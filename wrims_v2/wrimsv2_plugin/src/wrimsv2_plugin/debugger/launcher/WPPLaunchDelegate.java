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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;

import java.lang.Runtime;


public class WPPLaunchDelegate extends LaunchConfigurationDelegate {
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException{
		List commandList = new ArrayList();
			
		// if in debug mode, add debug arguments - i.e. '-debug requestPort eventPort'
		int requestPort = -1;
		int eventPort = -1;
		requestPort = findFreePort();
		eventPort = findFreePort();
		if (requestPort == -1 || eventPort == -1) {
			abort("Unable to find free port", null);
		}
			
		createDebugBatch(requestPort, eventPort);
		
		try {
			Process process = Runtime.getRuntime().exec("D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\WRIMSv2_Debugger.bat");
			IProcess p = DebugPlugin.newProcess(launch, process, "DebugWPP");
			IDebugTarget target = new WPPDebugTarget(launch, p, requestPort, eventPort);
			launch.addDebugTarget(target);
		} catch (IOException e) {
			WPPException.handleException(e);
		}
	}
	
	public void createDebugBatch(int requestPort, int eventPort){
		String debugFileFullPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\WRIMSv2_Debugger.bat";
		try {
			FileWriter debugFile = new FileWriter(debugFileFullPath);
			PrintWriter out = new PrintWriter(debugFile);
			out.println("@echo off");
			out.println();
			out.println("set Java_Bin=D:\\cvwrsm\\trunk\\3rd_party\\jrockit-jre1.6.0_26-R28.1.4\\bin\\");
			out.println("set path=D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\conv\\Run\\External;D:\\cvwrsm\\trunk\\3rd_party\\vista\\lib;D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\lib;%path%");
			out.println();
			out.println("D:\\cvwrsm\\trunk\\3rd_party\\jrockit-jre1.6.0_26-R28.1.4\\bin\\java -Xmx1600m -Xss1024K -Djava.library.path=\"D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\conv\\Run\\External;D:\\cvwrsm\\trunk\\3rd_party\\vista\\lib;D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\lib\" -cp \"D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\lib\\lpsolve55j.jar;D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\lib\\WRIMSv2.jar;D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\lib\\wrimsv2\\external\\*.class;D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\lib\\XAOptimizer.jar;D:\\cvwrsm\\trunk\\wrims_v2\\wrimsv2_plugin\\Engine\\lib\\gurobi.jar;D:\\cvwrsm\\trunk\\3rd_party\\vista\\lib\\*\" wrimsv2.components.DebugInterface "+requestPort+" "+eventPort+" D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\common\\CVGroundwater\\Data\\ D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\conv\\Run\\mainCONV_30.wresl D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\common\\DSS\\CalSim30_06_SV.dss D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\common\\DSS\\CalSim30_06Init.dss D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\conv\\DSS\\TestWRIMSV2DV.dss CalSim30_06 CalSim30_06 CALSIM 1MON 1921 10 31 1922 10 31 XA csv");
			out.close();
		}catch (IOException e) {
			WPPException.handleException(e);
		}
	}
		
	/**
	 * Throws an exception with a new status containing the given
	 * message and optional exception.
	 * 
	 * @param message error message
	 * @param e underlying exception
	 * @throws CoreException
	 */
	private void abort(String message, Throwable e) throws CoreException {
		throw new CoreException(new Status(IStatus.ERROR, DebugCorePlugin.getDefault().getDescriptor().getUniqueIdentifier(), 0, message, e));
	}
	
	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free port.
	 * 
	 * @return a free port number on localhost, or -1 if unable to find a free port
	 */
	public static int findFreePort() {
		ServerSocket socket= null;
		try {
			socket= new ServerSocket(0);
			return socket.getLocalPort();
		} catch (IOException e) { 
			WPPException.handleException(e);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					WPPException.handleException(e);
				}
			}
		}
		return -1;		
	}		
}
