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

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.swt.widgets.Combo;
import org.osgi.framework.BundleContext;

import wrimsv2_plugin.debugger.menuitem.NextTimeStepMenu;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;
import wrimsv2_plugin.debugger.toolbaritem.DebugSet;
import wrimsv2_plugin.debugger.view.WPPVariableView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * The main plugin class to be used in the desktop.
 */
public class DebugCorePlugin extends Plugin {
	//The shared instance.
	private static DebugCorePlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	/**
	 * Unique identifier for the WPP debug model (value 
	 * <code>wpp.debugModel</code>).
	 */
	public static WPPDebugTarget target;
	
	public static IValue[] dataStack;
	
	public static int totalNoOfCycle=1;
	
	public static String timeStep="1DAY";
	
	public static int startYear=1921;
	
	public static int startMonth=10;
	
	public static int startDay=31;
	
	public static int endYear=2003;
	
	public static int endMonth=9;
	
	public static int endDay=30;
	
	public static int debugYear=2003;
	
	public static int debugMonth=9;
	
	public static int debugDay=30;
	
	public static int debugCycle=1;
	
	public static DebugSet debugSet;
	
	public static boolean isDebugging=false;
	
	public static final String ID_WPP_DEBUG_MODEL = "wpp.debugModel";
	
	public static final String ID_WPP_VARIABLE_VIEW="wpp.variableview";
	
	public static final String ID_WPP_EDITOR="wpp.editor";
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
	
	
	
	/**
	 * Identifier for the WPP launch configuration type
	 * (value <code>wpp.launchType</code>)
	 */
	public static final String ID_WPP_LAUNCH_CONFIGURATION_TYPE = "wpp.launchType";	
	
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
}
