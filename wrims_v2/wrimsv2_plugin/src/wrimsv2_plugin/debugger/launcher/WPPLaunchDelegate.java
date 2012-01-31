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
import wrimsv2_plugin.tools.TimeOperation;

import java.lang.Runtime;

import javax.jws.WebParam.Mode;


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
			
		createBatch(configuration, requestPort, eventPort, mode);
		
		try {
			if (mode.equals("debug")){
				DebugCorePlugin.debugSet.reset();
				Process process = Runtime.getRuntime().exec("WRIMSv2_Engine.bat");
				IProcess p = DebugPlugin.newProcess(launch, process, "DebugWPP");
				IDebugTarget target = new WPPDebugTarget(launch, p, requestPort, eventPort);
				launch.addDebugTarget(target);
			}else{
				Process process = Runtime.getRuntime().exec("WRIMSv2_Engine.bat");
				IProcess p = DebugPlugin.newProcess(launch, process, "RunWPP");
			}
		} catch (IOException e) {
			WPPException.handleException(e);
		}
	}
	
	public void createBatch(ILaunchConfiguration configuration, int requestPort, int eventPort, String mode){
		try {
			String studyName=null;
			studyName = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_STUDY, (String)null);
					
			String author=null;
			author = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_AUTHOR, (String)null);
				
			String date=null;
			date = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_DATE, (String)null);
			
			String description=null;
			description = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_DESCRIPTION, (String)null);
				
			String mainFile = null;
			mainFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM, (String)null);
			
			String dvarFile = null;
			dvarFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_DVARFILE, (String)null);
			
			String svarFile = null;
			svarFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_SVARFILE, (String)null);
			
			String initFile = null;
			initFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_INITFILE, (String)null);
			
			String gwDataFolder = null;
			gwDataFolder = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_GWDATAFOLDER, (String)null)+"\\";
			
			String aPart = null;
			aPart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_APART, (String)null);
			
			String svFPart = null;
			svFPart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_SVFPART, (String)null);
			
			String initFPart = null;
			initFPart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_INITFPART, (String)null);
			
			String timeStep = null;
			timeStep = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_TIMESTEP, (String)null);
			DebugCorePlugin.timeStep=timeStep;
			
			int startYear = Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_STARTYEAR, (String)null));
			int startMonth = TimeOperation.monthValue(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_STARTMONTH, (String)null));
			DebugCorePlugin.startYear=startYear;
			DebugCorePlugin.startMonth=startMonth;
			
			int endYear = Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_ENDYEAR, (String)null));
			int endMonth = TimeOperation.monthValue(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_ENDMONTH, (String)null));
			DebugCorePlugin.endYear=endYear;
			DebugCorePlugin.endMonth=endMonth;
			
			int startDay;
			int endDay;
			if (timeStep.equals("1MON")){
				startDay=TimeOperation.numberOfDays(startMonth, startYear);
				endDay=TimeOperation.numberOfDays(endMonth, endYear);
			}else{
				startDay= Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_STARTDAY, (String)null));
				endDay=Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_ENDDAY, (String)null));
			}
			DebugCorePlugin.startDay=startDay;
			DebugCorePlugin.endDay=endDay;
					
			int index = mainFile.lastIndexOf("\\");
			String mainDirectory = mainFile.substring(0, index + 1);
			String externalPath = mainDirectory + "External";
			
			String engineFileFullPath = "WRIMSv2_Engine.bat";
			try {
				FileWriter debugFile = new FileWriter(engineFileFullPath);
				PrintWriter out = new PrintWriter(debugFile);
				out.println("@echo off");
				out.println();
				//out.println("set Java_Bin=D:\\cvwrsm\\trunk\\3rd_party\\jrockit-jre1.6.0_26-R28.1.4\\bin\\");
				out.println("set path=" + externalPath + ";"+"lib;%path%");
				out.println();
				if (mode.equals("debug")){
					out.println("jre6\\bin\\java -Xmx1600m -Xss1024K -Djava.library.path=\"" + externalPath + ";lib\" -cp \""+externalPath+";"+"lib\\external"+";lib\\WRIMSv2.jar;lib\\XAOptimizer.jar;lib\\lpsolve55j.jar;lib\\gurobi.jar;lib\\heclib.jar;lib\\jnios.jar;lib\\jpy.jar;lib\\misc.jar;lib\\pd.jar;lib\\vista.jar;\" wrimsv2.components.DebugInterface "+requestPort+" "+eventPort+" "
						+ gwDataFolder+" "
						+ mainFile + " "
						+ svarFile + " "
						+ initFile + " " 
						+ dvarFile + " " 
						+ svFPart + " "
						+ initFPart + " "
						+ aPart + " "
						+ timeStep + " " 
						+ startYear + " " 
						+ startMonth + " "
						+ startDay + " " 
						+ endYear + " "
						+ endMonth + " " 
						+ endDay + " "
						+ "XALOG csv");
				}else{
					out.println("jre6\\bin\\java -Xmx1600m -Xss1024K -Djava.library.path=\"" + externalPath + ";lib\" -cp \""+externalPath+";"+"lib\\external;lib\\WRIMSv2.jar;lib\\XAOptimizer.jar;lib\\lpsolve55j.jar;lib\\gurobi.jar;lib\\heclib.jar;lib\\jnios.jar;lib\\jpy.jar;lib\\misc.jar;lib\\pd.jar;lib\\vista.jar;\" wrimsv2.components.ControllerSG "
							+ gwDataFolder+" "
							+ mainFile + " "
							+ svarFile + " "
							+ initFile + " " 
							+ dvarFile + " " 
							+ svFPart + " "
							+ initFPart + " "
							+ aPart + " "
							+ timeStep + " " 
							+ startYear + " " 
							+ startMonth + " "
							+ startDay + " " 
							+ endYear + " "
							+ endMonth + " " 
							+ endDay + " "
							+ "XALOG csv");
				}
				out.close();
			}catch (IOException e) {
				WPPException.handleException(e);
			}
		} catch (CoreException e) {
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
