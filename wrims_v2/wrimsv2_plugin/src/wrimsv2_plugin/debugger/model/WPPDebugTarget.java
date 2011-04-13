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
import java.util.Vector;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;

/**
 * WPP Debug Target
 */
public class WPPDebugTarget extends WPPDebugElement implements IDebugTarget, IWPPEventListener {
	
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
		// initialize error hanlding to suspend on 'unimplemented instructions'
		// and 'no such label' errors
		sendRequest("to:4456");
		String data=null;
		try {
			while (data==null){
				data=fRequestReader.readLine();
			}
			System.out.println(data);
		} catch (IOException e) {
			requestFailed("Request failed: " + "to:4456", e);
		}
		sendRequest("step: ");
		try {
			data=fRequestReader.readLine();
			System.out.println(data);
		} catch (IOException e) {
			requestFailed("Request failed: " + "to:4456", e);
		}
		sendRequest("to:10001");
	}

    /* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
	 */
	public IProcess getProcess() {
		return fProcess;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getThreads()
	 */
	public IThread[] getThreads() throws DebugException {
		return fThreads;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	public boolean hasThreads() throws DebugException {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getName()
	 */
	public String getName() throws DebugException {
		return "WPP";
	}
	public IDebugTarget getDebugTarget() {
		return this;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return fLaunch;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return getProcess().canTerminate();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return fTerminated || getProcess().isTerminated();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		getThread().terminate();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return !isTerminated() && getThread().isSuspended();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		getThread().resume();
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		getThread().suspend();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	public boolean canDisconnect() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	public void disconnect() throws DebugException {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	public boolean isDisconnected() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	public boolean supportsStorageRetrieval() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
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
		fireTerminateEvent();
		removeEventListener(this);
	}
	
	/**
	 * Returns the values on the data stack (top down)
	 * 
	 * @return the values on the data stack (top down)
	 */
	public IValue[] getDataStack() throws DebugException {
		String dataStack = sendRequest("data");
		if (dataStack != null && dataStack.length() > 0) {
			String[] values = dataStack.split("\\|");
			IValue[] theValues = new IValue[values.length];
			for (int i = 0; i < values.length; i++) {
				String value = values[values.length - i - 1];
				theValues[i] = new WPPStackValue(this, value, i);
			}
			return theValues;
		}
		return new IValue[0];		
	}
	
	/* (non-Javadoc)
	 * @see example.debug.core.model.WPPDebugElement#sendRequest(java.lang.String)
	 */
	public String sendRequest(String request) throws DebugException {
		synchronized (fRequestSocket) {
			fRequestWriter.println(request);
			fRequestWriter.flush();
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
	public void handleEvent(String event) {
		System.out.print(event);
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

	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub
		return false;
	}
}
