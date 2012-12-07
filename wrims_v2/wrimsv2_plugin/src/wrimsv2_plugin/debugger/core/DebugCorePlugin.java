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
package wrimsv2_plugin.debugger.core;

import org.eclipse.core.internal.resources.PreferenceInitializer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.menuitem.NextTimeStepMenu;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;
import wrimsv2_plugin.debugger.toolbaritem.DebugSet;
import wrimsv2_plugin.debugger.view.WPPVariableView;
import wrimsv2_plugin.tools.VariableProperty;

import hec.heclib.dss.HecDss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

/**
 * The main plugin class to be used in the desktop.
 */
public class DebugCorePlugin extends AbstractUIPlugin {
	//The shared instance.
	private static DebugCorePlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	/**
	 * Unique identifier for the WPP debug model (value 
	 * <code>wpp.debugModel</code>).
	 */
	public static String preferenceFile = "WRIMS2_IDEGUI.epf";
	
	public static WPPDebugTarget target;
	
	public static IValue[] variableStack;	
	public static IValue[] goalStack;
	public static IValue[] allVariableStack;
	public static IValue[] allGoalStack;
	public static IValue[] watchStack;
	public static ArrayList<String> fileControlGoals;
	public static ArrayList<String> allControlGoals;
	public static ArrayList<String> watchControlGoals;
	public static ArrayList<String> watchItems=new ArrayList<String>();
	public static Map<String, VariableProperty> variableProperty=new HashMap<String, VariableProperty>();
	public static Map<String, VariableProperty> watchProperty=new HashMap<String, VariableProperty>();
	public static Map<Integer, Integer> variableAltColIndex=new HashMap<Integer, Integer>();;
	public static Map<Integer, Integer> watchAltColIndex=new HashMap<Integer, Integer>();;
	
	public static ArrayList<String[]> varDetailTimeseries= new ArrayList<String[]>();
	public static ArrayList<String[]> varDetailFuture= new ArrayList<String[]>();
	public static ArrayList<String[]> varDetailCycle= new ArrayList<String[]>();
	public static int varDetailChoice=0;
	public static ArrayList<String> selectedVariableNames=new ArrayList<String>();
		
	public static int totalNoOfCycle=1;
	public static String timeStep="1DAY";
	public static int startYear=1921;
	public static int startMonth=10;
	public static int startDay=31;
	public static int endYear=2009;
	public static int endMonth=9;
	public static int endDay=30;
	public static int debugYear=2009;
	public static int debugMonth=9;
	public static int debugDay=30;
	public static int debugCycle=1;
	public static int suspendedYear=2009;
	public static int suspendedMonth=9;
	public static int suspendedDay=30;
	public static int suspendedCycle=99;
	
	public static DebugSet debugSet;
	
	public static boolean isDebugging=false;
	public static boolean updateSelectedVariable=true;
	
	public static String solver="XA";
	public static String log="None";
	
	public static String savedSvFileName="";
	public static String savedDvFileName="";
	
	public static String[] studyDvFileNames={"","","",""};
	public static String[] studySvFileNames={"","","",""};
	public static boolean[] selectedStudies={false, false, false, false};
	public static HecDss[] dvDss=new HecDss[4];
	public static HecDss[] svDss=new HecDss[4];
	public static Vector[] dvVector=new Vector[4]; 
	public static Vector[] svVector=new Vector[4]; 
	
	public static String aPart="";
	public static String initFPart="";
	public static String svFPart="";
	
	public static DecimalFormat df = new DecimalFormat("#.####");
	
	public static final String ID_WPP_PLUGIN="wrimsv2_plugin";
	public static final String ID_WPP_DEBUG_MODEL = "wpp.debugModel";
	public static final String ID_WPP_VARIABLE_VIEW="wpp.variableview";
	public static final String ID_WPP_ALLVARIABLE_VIEW="wpp.allvariableview";
	public static final String ID_WPP_WATCH_VIEW="wpp.watchview";
	public static final String ID_WPP_VARIABLEDETAIL_VIEW="wpp.vardetailview";
	public static final String ID_WPP_VARIABLEMONITOR_VIEW="wpp.varmonitorview";
	public static final String ID_WPP_GOAL_VIEW="wpp.goalview";
	public static final String ID_WPP_ALLGOAL_VIEW="wpp.allgoalview";
	public static final String ID_WPP_EDITOR="wpp.editor";
	public static final String ID_WPP_RESUMEMENU="wpp.resume";
	public static final String ID_WPP_TERMINATEMENU="wpp.terminate";
	public static final String ID_WPP_PAUSEMENU="wpp.pause";
	public static final String ID_WPP_SUSPENDMENU="wpp.suspend";
	public static final String ID_WPP_NEXTTIMESTEP="wpp.nexttimestep";
	public static final String ID_WPP_NEXTCYCLE="wpp.nextcycle";
	public static final String ID_WPP_RESIMMENU="wpp.resim";
	public static final String ID_WPP_SAVETODVFILE="wpp.savedvfile";
	public static final String ID_WPP_SAVETOSVFILE="wpp.savesvfile";
	public static final String ID_WPP_SOLVEROPTIONMENU="wpp.solveroption";
	/**
	 * Identifier for the WPP launch configuration type
	 * (value <code>wpp.launchType</code>)
	 */
	public static final String ID_WPP_LAUNCH_CONFIGURATION_TYPE = "wpp.launchType";	
	
	
	public static final String TITLE_ALLVARIABLES_VIEW="All Variables";
	public static final String TITLE_VARIABLES_VIEW="Variables";
	public static final String TITLE_ALLGOALS_VIEW="All Goals";
	public static final String TITLE_GOALS_VIEW="Goals";
	public static final String TITLE_WATCH_VIEW="Watch";
	
	/**
	 * Launch configuration attribute key. Value is a path to a perl
	 * program. The path is a string representing a full path
	 * to a perl program in the workspace. 
	 */
	public static final String ATTR_WPP_STUDY=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_STUDY";
	public static final String ATTR_WPP_AUTHOR=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_AUTHOR";
	public static final String ATTR_WPP_DATE=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_DATE";
	public static final String ATTR_WPP_DESCRIPTION=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_DESCRIPTION";
	public static final String ATTR_WPP_PROGRAM = ID_WPP_DEBUG_MODEL + ".ATTR_WPP_PROGRAM";
	public static final String ATTR_WPP_DVARFILE = ID_WPP_DEBUG_MODEL + ".ATTR_WPP_DVAR";
	public static final String ATTR_WPP_SVARFILE = ID_WPP_DEBUG_MODEL + ".ATTR_WPP_SVAR";
	public static final String ATTR_WPP_INITFILE = ID_WPP_DEBUG_MODEL + ".ATTR_WPP_INIT";
	public static final String ATTR_WPP_GWDATAFOLDER=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_GWDATA";
	public static final String ATTR_WPP_APART=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_APART";
	public static final String ATTR_WPP_SVFPART=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_SVFPART";
	public static final String ATTR_WPP_INITFPART=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_INITFPART";
	public static final String ATTR_WPP_TIMESTEP=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_TIMESTEP";
	public static final String ATTR_WPP_STARTYEAR=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_STARTYEAR";
	public static final String ATTR_WPP_STARTMONTH=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_STARTMONTH";
	public static final String ATTR_WPP_STARTDAY=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_STARTDAY";
	public static final String ATTR_WPP_ENDYEAR=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_ENDYEAR";
	public static final String ATTR_WPP_ENDMONTH=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_ENDMONTH";
	public static final String ATTR_WPP_ENDDAY=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_ENDDAY";
	public static final String ATTR_WPP_WRESLPLUS=ID_WPP_DEBUG_MODEL + ".ATTR_WPP_WRESLPLUS";
	
	public static String textVarGoalSearch="";
	
	public static String hoverText="";
	
	/**
	 * The constructor.
	 */
	public DebugCorePlugin() {
		super();
		plugin = this; 
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		//new DebuggerPreferenceInitializer().initializeDefaultPreferences();
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
		resourceBundle = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static DebugCorePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = DebugCorePlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		try {
			if (resourceBundle == null)
				resourceBundle = ResourceBundle.getBundle("example.debug.core.DebugCorePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
		return resourceBundle;
	}
	
	/**
	 * Return a <code>java.io.File</code> object that corresponds to the specified
	 * <code>IPath</code> in the plugin directory, or <code>null</code> if none.
	 */
	public static File getFileInPlugin(IPath path) {
		try {
			URL installURL =
				new URL(getDefault().getDescriptor().getInstallURL(), path.toString());
			URL localURL = Platform.asLocalURL(installURL);
			return new File(localURL.getFile());
		} catch (IOException ioe) {
			return null;
		}
	}	
	
	public static ImageDescriptor getImageDescriptor(String name) {
		/*
		String iconPath = "icons/";
		try {
		   URL installURL = getDefault().getDescriptor().getInstallURL();
		   URL url = new URL(installURL, iconPath + name);
		   return ImageDescriptor.createFromURL(url);
		} catch (MalformedURLException e) {
		   WPPException.handleException(e);
		   return ImageDescriptor.getMissingImageDescriptor();
		}
		*/
		return imageDescriptorFromPlugin(ID_WPP_PLUGIN, "icons\\"+name);
	}
}
