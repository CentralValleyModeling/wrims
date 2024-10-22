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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;

/**
 * A run to line breakpoint.
 */
public class WPPRunToLineBreakpoint extends WPPLineBreakpoint {
	
	private IFile fSourceFile;
	
	/**
	 * Constructs a run-to-line breakpoint in the given WPP program.
	 * 
	 * @param resource WPP source file
	 * @param lineNumber line to run to
	 * @exception DebugException if unable to create the breakpoint
	 */
	public WPPRunToLineBreakpoint(final IFile resource, final int lineNumber) throws DebugException {
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				// associate with workspace root to avoid drawing in editor ruler
				IMarker marker = ResourcesPlugin.getWorkspace().getRoot().createMarker("wrimsv2_plugin.debugger.core.wpp.markerType.lineBreakpoint");
				setMarker(marker);
				marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
				setRegistered(false);
				fSourceFile = resource;
			}
		};
		run(getMarkerRule(resource), runnable);		
	}
	
	/**
	 * Returns whether this breakpoint is a run-to-line breakpoint
	 * 
	 * @return whether this breakpoint is a run-to-line breakpoint
	 */
	public boolean isRunToLineBreakpoint() {
		return true;
	}
	
	/**
	 * Returns the source file this breakpoint is contained in.
	 * 
	 * @return the source file this breakpoint is contained in
	 */
	public IFile getSourceFile() {
		return fSourceFile;
	}
}
