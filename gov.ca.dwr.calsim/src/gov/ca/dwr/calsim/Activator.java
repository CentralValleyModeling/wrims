package gov.ca.dwr.calsim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.swixml.SwingEngine;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "gov.ca.dwr.calsim"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		CalSimPluginCore.swix = new SwingEngine(this);
		CalSimPluginCore.swix.getTaglib().registerTag("numtextfield", NumericTextField.class);
		CalSimPluginCore.swix.render(new File(DebugCorePlugin.dataDir, "GUI.xml"));
		CalSimPluginCore.CalLiteLookups=readInLookups("GUI_Links3_CalLite.table");
		CalSimPluginCore.CalSim2Lookups=readInLookups("GUI_Links3_CalSim2.table");
		CalSimPluginCore.CalSim3Lookups=readInLookups("GUI_Links3_CalSim3.table");
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	
	private String[][] readInLookups(String fn) {

		// Open input file
		String lookups[][]=new String[0][0];
		
		Scanner input;
		try {
			input = new Scanner(new FileReader(DebugCorePlugin.dataDir+"\\"+fn));
		} catch (FileNotFoundException e) {
			WPPException.handleException(e);
			return lookups;
		}

		Vector<String> allLookups = new Vector<String>();

		int lineCount = 0;
		input.nextLine(); // Skip header line
		while (input.hasNextLine()) {
			String line = input.nextLine();
			allLookups.add(line);
			lineCount++;
		}
		input.close();
		lookups = new String[lineCount][6];
		for (int i = 0; i < lineCount; i++) {
			String[] parts = allLookups.get(i).split("[\t]+");
			for (int j = 0; j < 6; j++) {
				if (parts[j].equals("null"))
					parts[j] = "";
				lookups[i][j] = parts[j];
			}
		}

		return lookups;
	}

}
