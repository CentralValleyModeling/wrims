/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Bjorn Freeman-Benson - initial API and implementation
 *******************************************************************************/
package wrimsv2_plugin.debugger.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.IBreakpointManagerListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.sourcelookup.ISourceLookupResult;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

import wrimsv2_plugin.debugger.breakpoint.WPPLineBreakpoint;
import wrimsv2_plugin.debugger.breakpoint.WPPRunToLineBreakpoint;
import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPExceptionView;
import wrimsv2_plugin.debugger.view.WPPVariableView;

/**
 * WPP Debug Target
 */
public class WPPDebugTarget extends WPPDebugElement implements IDebugTarget, IBreakpointManagerListener, IWPPEventListener {
	
	// associated system process (VM)
	private IProcess fProcess;
	
	// containing launch object
	private ILaunch fLaunch;
	
	// sockets to communicate with VM
	private Socket fRequestSocket;
	private PrintWriter fRequestWriter;
	private BufferedReader fRequestReader;
	private Socket fEventSocket;
	private BufferedReader fEventReader;
	
	// terminated state
	private boolean fTerminated = false;
	
	// threads
	private IThread[] fThreads;
	private WPPThread fThread;
	
	private IValue[] fDataStack=new IValue[0];
	private String fCurrFileName;
	private ISourceLookupResult result;
	private int currLine;
	private IEditorPart fTextEditor;
	private IWorkbenchPart fPart;
	private IPartListener fPartListener;
	
	// event dispatch job
	private EventDispatchJob fEventDispatch;
	// event listeners
	private Vector fEventListeners = new Vector();
	
	/**
	 * Listens to events from the WPP VM and fires corresponding 
	 * debug events.
	 */
	class EventDispatchJob extends Job {
		
		public EventDispatchJob() {
			super("WPP Event Dispatch");
			setSystem(true);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		@Override
		protected IStatus run(IProgressMonitor monitor) {
			String event = "";
			while (!isTerminated() && event != null) {
				try {
					event = fEventReader.readLine();
					if (event != null) {
						Object[] listeners = fEventListeners.toArray();
						for (int i = 0; i < listeners.length; i++) {
							((IWPPEventListener)listeners[i]).handleEvent(event);	
						}
					}
				} catch (IOException e) {
					terminated();
				}
			}
			return Status.OK_STATUS;
		}
		
	}
	
	/**
	 * Registers the given event listener. The listener will be notified of
	 * events in the program being interpretted. Has no effect if the listener
	 * is already registered.
	 *  
	 * @param listener event listener
	 */
	public void addEventListener(IWPPEventListener listener) {
		if (!fEventListeners.contains(listener)) {
			fEventListeners.add(listener);
		}
	}
	
	/**
	 * Deregisters the given event listener. Has no effect if the listener is
	 * not currently registered.
	 *  
	 * @param listener event listener
	 */
	public void removeEventListener(IWPPEventListener listener) {
		fEventListeners.remove(listener);
	}
	
	/**
	 * Constructs a new debug target in the given launch for the 
	 * associated WPP VM process.
	 * 
	 * @param launch containing launch
	 * @param process WPP VM
	 * @param requestPort port to send requests to the VM
	 * @param eventPort port to read events from
	 * @exception CoreException if unable to connect to host
	 */
	public WPPDebugTarget(ILaunch launch, IProcess process, int requestPort, int eventPort) throws CoreException {
		super(null);
		DebugCorePlugin.target=this;
		fLaunch = launch;
		fProcess = process;
		addEventListener(this);
		try {
			// give interpreter a chance to start
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			fRequestSocket = new Socket("localhost", requestPort);
			fEventSocket = new Socket("localhost", eventPort);
			fRequestWriter = new PrintWriter(fRequestSocket.getOutputStream());
			fRequestReader = new BufferedReader(new InputStreamReader(fRequestSocket.getInputStream()));
			fEventReader = new BufferedReader(new InputStreamReader(fEventSocket.getInputStream()));
		} catch (UnknownHostException e) {
			requestFailed("Unable to connect to WPP VM", e);
		} catch (IOException e) {
			requestFailed("Unable to connect to WPP VM", e);
		}
		fThread = new WPPThread(this);
		fThreads = new IThread[] {fThread};
		fEventDispatch = new EventDispatchJob();
		fEventDispatch.schedule();
		
		IBreakpointManager breakpointManager = getBreakpointManager();
        breakpointManager.addBreakpointListener(this);
		breakpointManager.addBreakpointManagerListener(this);
		
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				IWorkbenchWindow window=workbench.getActiveWorkbenchWindow();
				if (window !=null){
					fPartListener=new IPartListener(){
						@Override
						public void partActivated(IWorkbenchPart part) {
							if ((part instanceof ITextEditor) && (!part.equals(fPart))){
								fPart=part;
								System.out.println("changes");
								//To Do: parse file, send request, regenerate dataStack (viewer show automatically)
							}
						}

						@Override
						public void partBroughtToTop(IWorkbenchPart part) {
						}

						@Override
						public void partClosed(IWorkbenchPart part) {	
						}

						@Override
						public void partDeactivated(IWorkbenchPart part) {	
						}

						@Override
						public void partOpened(IWorkbenchPart part) {	
						}                                                                                                                                                                               
					};
					window.getActivePage().addPartListener(fPartListener);
				}
			}
		});
		
		//To Do: add real debug code
		//installDeferredBreakpoints();
		
		String data;
		
		data=sendRequest("start");
		System.out.println(data);
		
		data=sendRequest("time:1922/1/31/10");
		System.out.println(data);
		
		data=sendRequest("variables:s_shsta#s_folsm");
		System.out.println(data);
		
		
		/*
		if (fTextEditor!=null) ((ITextEditor)fTextEditor).resetHighlightRange();
		data=sendRequest("resume");
		System.out.println(data);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			WPPException.handleException(e);
		}
		
		data=sendRequest("step");
		System.out.println(data);
		
		if (fTextEditor!=null) ((ITextEditor)fTextEditor).resetHighlightRange();
		data=sendRequest("resume");
		System.out.println(data);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			WPPException.handleException(e);
		}
		
		data=sendRequest("year:10001");
		System.out.println(data);
		
		if (fTextEditor!=null) ((ITextEditor)fTextEditor).resetHighlightRange();
		data=sendRequest("resume");
		System.out.println(data);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			WPPException.handleException(e);
		}
		
		
		fProcess.terminate();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				IWorkbenchWindow window=workbench.getActiveWorkbenchWindow();
				if (window !=null){
					window.getActivePage().removePartListener(fPartListener);
				}
			}
		});
		*/
	}
	
	public void setSourceName(String fileName){
		fCurrFileName=fileName;
	}
	
	public void setCurrLine(int line){
		currLine=line;
	}
	
	public String getSourceName(){
		return fCurrFileName;
	}
	
	public IValue[] generateTree(String data){
		String[] dataStrings=data.split("#");
		int size=dataStrings.length;
		WPPValue[] values=new WPPValue[size];  
		for (int i=0; i<size; i++){
			String[] dataSubStrings=dataStrings[i].split(":",2);
			WPPValue value=new WPPValue(this,dataSubStrings[1], dataSubStrings[0]); 
			values[i]=value;
		}
		return values;
	}

    /* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
	 */
	@Override
	public IProcess getProcess() {
		return fProcess;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getThreads()
	 */
	@Override
	public IThread[] getThreads() throws DebugException {
		return fThreads;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	@Override
	public boolean hasThreads() throws DebugException {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getName()
	 */
	@Override
	public String getName() throws DebugException {
		return "WPP";
	}
	
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		if (!isTerminated() && breakpoint.getModelIdentifier().equals(getModelIdentifier())) {
			try {
				String program = getLaunch().getLaunchConfiguration().getAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM, (String)null);
				if (program.toLowerCase().endsWith(".wresl") || program.toLowerCase().endsWith(".wpp")) {
					return true;
				}
			} catch (CoreException e) {
				WPPException.handleException(e);
			}			
		}
		return false;
	}
	
	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	@Override
	public ILaunch getLaunch() {
		return fLaunch;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	@Override
	public boolean canTerminate() {
		return getProcess().canTerminate();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return fTerminated || getProcess().isTerminated();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	@Override
	public void terminate() throws DebugException {
		getThread().terminate();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	@Override
	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	@Override
	public boolean isSuspended() {
		return !isTerminated() && getThread().isSuspended();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	@Override
	public void resume() throws DebugException {
		getThread().resume();
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	@Override
	public void suspend() throws DebugException {
		getThread().suspend();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public void breakpointAdded(IBreakpoint breakpoint) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if ((breakpoint.isEnabled() && getBreakpointManager().isEnabled()) || !breakpoint.isRegistered()) {
					WPPLineBreakpoint wppBreakpoint = (WPPLineBreakpoint)breakpoint;
				    wppBreakpoint.install(this);
				}
			} catch (CoreException e) {
				WPPException.handleException(e);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
			    WPPLineBreakpoint wppBreakpoint = (WPPLineBreakpoint)breakpoint;
				wppBreakpoint.remove(this);
			} catch (CoreException e) {
				WPPException.handleException(e);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled() && getBreakpointManager().isEnabled()) {
					breakpointAdded(breakpoint);
				} else {
					breakpointRemoved(breakpoint, null);
				}
			} catch (CoreException e) {
				WPPException.handleException(e);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	@Override
	public boolean canDisconnect() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	@Override
	public void disconnect() throws DebugException {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	@Override
	public boolean isDisconnected() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	/**
	 * Notification we have connected to the VM and it has started.
	 * Resume the VM.
	 */
	private void started() {
		fireCreationEvent();
		installDeferredBreakpoints();
		try {
			resume();
		} catch (DebugException e) {
			WPPException.handleException(e);
		}
	}
	
	/**
	 * Install breakpoints that are already registered with the breakpoint
	 * manager.
	 */
	private void installDeferredBreakpoints() {
		IBreakpoint[] breakpoints = getBreakpointManager().getBreakpoints(getModelIdentifier());
		for (int i = 0; i < breakpoints.length; i++) {
			breakpointAdded(breakpoints[i]);
		}
	}
	
	/**
	 * Called when this debug target terminates.
	 */
	private synchronized void terminated() {
		fTerminated = true;
		fThread = null;
		fThreads = new IThread[0];
		IBreakpointManager breakpointManager = getBreakpointManager();
        breakpointManager.removeBreakpointListener(this);
		breakpointManager.removeBreakpointManagerListener(this);
		fireTerminateEvent();
		removeEventListener(this);
	}
	
	/**
	 * Returns the values on the data stack (top down)
	 * 
	 * @return the values on the data stack (top down)
	 */
	public IValue[] getDataStack() throws DebugException {
		return fDataStack;
	}
	
	/* (non-Javadoc)
	 * @see example.debug.core.model.WPPDebugElement#sendRequest(java.lang.String)
	 */
	@Override
	public String sendRequest(String request) throws DebugException {
		synchronized (fRequestSocket) {
			fRequestWriter.println(request);
			fRequestWriter.flush();
			try {
				// wait for reply
				return fRequestReader.readLine();
			} catch (IOException e) {
				requestFailed("Request failed: " + request, e);
			}
		}
		return null;
	}  
	
	/**
	 * When the breakpoint manager disables, remove all registered breakpoints
	 * requests from the VM. When it enables, reinstall them.
	 */
	public void breakpointManagerEnablementChanged(boolean enabled) {
		IBreakpoint[] breakpoints = getBreakpointManager().getBreakpoints(getModelIdentifier());
		for (int i = 0; i < breakpoints.length; i++) {
			if (enabled) {
				breakpointAdded(breakpoints[i]);
			} else {
				breakpointRemoved(breakpoints[i], null);
			}
        }
	}	
	
	/**
	 * Returns whether popping the data stack is currently permitted
	 *  
	 * @return whether popping the data stack is currently permitted
	 */
	public boolean canPop() {
	    try {
            return !isTerminated() && isSuspended() && getDataStack().length > 0;
        } catch (DebugException e) {
        	WPPException.handleException(e);
        }
        return false;
	}
	
	/**
	 * Pops and returns the top of the data stack
	 * 
	 * @return the top value on the stack 
	 * @throws DebugException if the stack is empty or the request fails
	 */
	public IValue pop() throws DebugException {
	    IValue[] dataStack = getDataStack();
	    if (dataStack.length > 0) {
	        sendRequest("popdata");
	        return dataStack[0];
	    }
	    requestFailed("Empty stack", null);
	    return null;
	}
	
	/**
	 * Returns whether pushing a value is currently supported.
	 * 
	 * @return whether pushing a value is currently supported
	 */
	public boolean canPush() {
	    return !isTerminated() && isSuspended();
	}
	
	/**
	 * Pushes a value onto the stack.
	 * 
	 * @param value value to push
	 * @throws DebugException on failure
	 */
	public void push(String value) throws DebugException {
	    sendRequest("pushdata " + value);
	}

	/* (non-Javadoc)
	 * @see example.debug.core.model.IWPPEventListener#handleEvent(java.lang.String)
	 */
	@Override
	public void handleEvent(String event) {
		String data="";
		if (event.startsWith("suspended")) {
			try {
				data=sendRequest("data");
				System.out.println(data);
			} catch (DebugException e) {
				WPPException.handleException(e);
			}
			//data="i:4456#a(-1):123.0#reservoir:reservorlevel1%56:reservorlevel2%1234";
			fDataStack=generateTree(data);
			DebugCorePlugin.dataStack=fDataStack;
			updateDataView();
			if (event.contains(":")) {
				String[] eventPart=event.split(":");
				setCurrLine(Integer.parseInt(eventPart[1]));
				setSourceName(eventPart[2]);
				openSourceHighlight();
			}
		}
	}
	
	public void updateDataView(){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				try {
					WPPVariableView variableView = (WPPVariableView) workbench.getActiveWorkbenchWindow().getActivePage().showView(DebugCorePlugin.ID_WPP_VARIABLE_VIEW);
					variableView.updateView();
				} catch (PartInitException e) {
					WPPException.handleException(e);
				}
			}
		});
	}
	
	public void openSourceHighlight(){
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() { 
			public void run() { 
				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IPath path = new Path(getSourceName());
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
					FileEditorInput fileEditorInput=new FileEditorInput(file);
					fTextEditor=page.openEditor(fileEditorInput, DebugCorePlugin.ID_WPP_EDITOR);
					IDocument document = ((ITextEditor)fTextEditor).getDocumentProvider().getDocument(fTextEditor.getEditorInput());
					IRegion lineInfo;
					lineInfo = document.getLineInformation(currLine);
					((ITextEditor)fTextEditor).setHighlightRange(lineInfo.getOffset(), lineInfo.getLength(), true);
				} catch (Exception e) {
					WPPException.handleException(e);
				}
			} 
		}); 
	}
	
	/**
	 * Returns this debug target's single thread, or <code>null</code>
	 * if terminated.
	 * 
	 * @return this debug target's single thread, or <code>null</code>
	 * if terminated
	 */
	protected synchronized WPPThread getThread() {
		return fThread;
	}
}
