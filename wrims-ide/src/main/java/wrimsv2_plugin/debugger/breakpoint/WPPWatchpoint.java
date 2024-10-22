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
package wrimsv2_plugin.debugger.breakpoint;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IWatchpoint;

import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;

/**
 * A watchpoint.
 */
public class WPPWatchpoint extends WPPLineBreakpoint implements IWatchpoint {
    
    // 'read' or 'write' depending on what caused the last suspend for this watchpoint
    private String fLastSuspendType;
    
    // marker attributes
    public static final String ACCESS = "ACCESS";
    public static final String MODIFICATION = "MODIFICATION";
    public static final String FUNCTION_NAME = "FUNCTION_NAME";
    public static final String VAR_NAME = "VAR_NAME";

	/**
	 * Default constructor is required for the breakpoint manager
	 * to re-create persisted breakpoints. After instantiating a breakpoint,
	 * the <code>setMarker(...)</code> method is called to restore
	 * this breakpoint's attributes.
	 */
    public WPPWatchpoint() {
	}
	/**
	 * Constructs a line breakpoint on the given resource at the given
	 * line number. The line number is 1-based (i.e. the first line of a
	 * file is line number 1). The WPP VM uses 0-based line numbers,
	 * so this line number translation is done at breakpoint install time.
	 * 
	 * @param resource file on which to set the breakpoint
	 * @param lineNumber 1-based line number of the breakpoint
	 * @param functionName function name the variable is defined in
	 * @param varName variable name that watchpoint is set on
	 * @param access whether this is an access watchpoint
	 * @param modification whether this in a modification watchpoint
	 * @throws CoreException if unable to create the watchpoint
	 */
	public WPPWatchpoint(final IResource resource, final int lineNumber, final String functionName, final String varName, final boolean access, final boolean modification) throws CoreException {
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				IMarker marker = resource.createMarker("wpp.markerType.watchpoint");
				setMarker(marker);
				setEnabled(true);
				ensureMarker().setAttribute(IMarker.LINE_NUMBER, lineNumber);
				ensureMarker().setAttribute(IBreakpoint.ID, getModelIdentifier());
				setAccess(access);
				setModification(modification);
				setVariable(functionName, varName);
				marker.setAttribute(IMarker.MESSAGE, "Watchpoint: " + resource.getName() + " [line: " + lineNumber + "]");
			}
		};
		run(getMarkerRule(resource), runnable);
	}    

    /* (non-Javadoc)
     * @see org.eclipse.debug.core.model.IWatchpoint#isAccess()
     */
    public boolean isAccess() throws CoreException {
        return getMarker().getAttribute(ACCESS, true);
    }

    /* (non-Javadoc)
     * @see org.eclipse.debug.core.model.IWatchpoint#setAccess(boolean)
     */
    public void setAccess(boolean access) throws CoreException {
        setAttribute(ACCESS, access);
    }

    /* (non-Javadoc)
     * @see org.eclipse.debug.core.model.IWatchpoint#isModification()
     */
    public boolean isModification() throws CoreException {
        return getMarker().getAttribute(MODIFICATION, true);
    }

    /* (non-Javadoc)
     * @see org.eclipse.debug.core.model.IWatchpoint#setModification(boolean)
     */
    public void setModification(boolean modification) throws CoreException {
        setAttribute(MODIFICATION, modification); 
    }

    /* (non-Javadoc)
     * @see org.eclipse.debug.core.model.IWatchpoint#supportsAccess()
     */
    public boolean supportsAccess() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.eclipse.debug.core.model.IWatchpoint#supportsModification()
     */
    public boolean supportsModification() {
        return true;
    }
    
    /**
     * Sets the variable and function names the watchpoint is set on.
     * 
     * @param functionName function name
     * @param variableName variable name
     * @throws CoreException if an exception occurrs setting marker attribtues
     */
    protected void setVariable(String functionName, String variableName) throws CoreException {
        setAttribute(VAR_NAME, variableName);
        setAttribute(FUNCTION_NAME, functionName);
    }
    
    /**
     * Returns the name of the variable this watchpoint is set on.
     * 
     * @return the name of the variable this watchpoint is set on
     * @throws CoreException if unable to access the attribute
     */
    public String getVariableName() throws CoreException {
        return getMarker().getAttribute(VAR_NAME, (String)null);
    }

    /**
     * Returns the name of the function the variable associted with this watchpoint is defined in.
     * 
     * @return the name of the function the variable associted with this watchpoint is defined in
     * @throws CoreException if unable to access the attribute
     */
    public String getFunctionName() throws CoreException {
        return getMarker().getAttribute(FUNCTION_NAME, (String)null);
    }    
    
    /**
     * Sets the type of event that causes the last suspend event.
     * 
     * @param description one of 'read' or 'write'
     */
    public void setSuspendType(String description) {
        fLastSuspendType = description;
    }
    
    /**
     * Returns the type of event that caused the last suspend.
     * 
     * @return 'read', 'write', or <code>null</code> if undefined
     */
    public String getSuspendType() {
        return fLastSuspendType;
    }
	
	/* (non-Javadoc)
	 * @see example.debug.core.breakpoints.WPPLineBreakpoint#createRequest(example.debug.core.model.WPPDebugTarget)
	 */
	protected void createRequest(WPPDebugTarget target) throws CoreException {
        int flag = 0;
        if (isAccess()) {
            flag = flag | 1;
        }
        if (isModification()) {
            flag = flag | 2;
        }		
		target.sendRequest("watch " + getFunctionName() + "::" + getVariableName() + " " + flag);
	}
	
	/* (non-Javadoc)
	 * @see example.debug.core.breakpoints.WPPLineBreakpoint#clearRequest(example.debug.core.model.WPPDebugTarget)
	 */
	protected void clearRequest(WPPDebugTarget target) throws CoreException {
		 target.sendRequest("watch " + getFunctionName() + "::" + getVariableName() + " " + 0);
	}
    
	/* (non-Javadoc)
	 * @see example.debug.core.model.IWPPEventListener#handleEvent(java.lang.String)
	 */
	public void handleEvent(String event) {
		if (event.startsWith("suspended watch")) {
			handleHit(event);
		}
	}
    
	/**
     * Determines if this breakpoint was hit and notifies the thread.
     * 
     * @param event breakpoint event
     */
    private void handleHit(String event) {
        String[] strings = event.split(" ");
        if (strings.length == 4) {
            String fv = strings[3];
            int j = fv.indexOf("::");
            if (j > 0) {
                String fcn = fv.substring(0, j);
                String var = fv.substring(j + 2);
				try {
					if (getVariableName().equals(var) && getFunctionName().equals(fcn)) {
						setSuspendType(strings[2]);
					    notifyThread();
					}
				} catch (CoreException e) {
					WPPException.handleException(e);
				}
            }
    	}
    }    
}
