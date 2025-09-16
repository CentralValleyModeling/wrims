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
package wrimsv2_plugin.debugger.launcher;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

/**
 * Launches a WPP file
 */
public class WPPLaunchShortcut implements ILaunchShortcut {

    /* (non-Javadoc)
     * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.jface.viewers.ISelection, java.lang.String)
     */
    @Override
	public void launch(ISelection selection, String mode) {
        // Support both workspace IFile and raw String filesystem path in selection
        if (!(selection instanceof IStructuredSelection)) {
            return; // cannot handle
        }
        Object first = ((IStructuredSelection) selection).getFirstElement();
        if (first == null) {
            return;
        }

        String path;
        String name;
        if (first instanceof IFile) {
            IFile file = (IFile) first;
            path = file.getFullPath().toString();
            name = file.getName();
        } else if (first instanceof String) {
            path = (String) first;
            File f = new File(path);
            name = f.getName();
        } else {
            return; // unsupported selection type
        }

        // check for an existing launch config for the WPP file
        DebugPlugin debug = DebugPlugin.getDefault();
        if (debug == null) {
            // Likely running in headless test environment; skip actual launching
            return;
        }
        ILaunchManager launchManager = debug.getLaunchManager();
        ILaunchConfigurationType type = launchManager.getLaunchConfigurationType(DebugCorePlugin.ID_WPP_LAUNCH_CONFIGURATION_TYPE);
        try {
            ILaunchConfiguration[] configurations = launchManager.getLaunchConfigurations(type);
            for (int i = 0; i < configurations.length; i++) {
                ILaunchConfiguration configuration = configurations[i];
                String attribute = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM, (String) null);
                if (path.equals(attribute)) {
                    DebugUITools.launch(configuration, mode);
                    return;
                }
            }
        } catch (CoreException e) {
            return;
        }

        try {
            // create a new configuration for the WPP file
            ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, name);
            workingCopy.setAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM, path);
            ILaunchConfiguration configuration = workingCopy.doSave();
            DebugUITools.launch(configuration, mode);
        } catch (CoreException e1) {
            WPPException.handleException(e1);
        }
    }

    
    /* (non-Javadoc)
     * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.ui.IEditorPart, java.lang.String)
     */
    @Override
	public void launch(IEditorPart editor, String mode) {
    }

}
