package wrimsv2_plugin.debugger.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class SettingPref {
	private static String settingPrefFile="setting.prf";
	
	public static void load(){
		try {
			File file = new File(DebugCorePlugin.dataDir, settingPrefFile);
			if (!file.exists()){
				file.createNewFile();
				DebugCorePlugin.solver="CBC";
				DebugCorePlugin.xmx="4096";
				DebugCorePlugin.outputCycleToDss=false;
				DebugCorePlugin.outputAllCycles=true;
				DebugCorePlugin.outputCycles="\'\'";
				save();
				return;
			}
			FileInputStream fs = new FileInputStream(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		    LineNumberReader reader = new LineNumberReader(br);
		    DebugCorePlugin.solver=br.readLine();
		    DebugCorePlugin.xmx=br.readLine();
		    String strOutputCycleToDss = br.readLine();
		    if (strOutputCycleToDss.toLowerCase().equals("true")){
		    	DebugCorePlugin.outputCycleToDss=true;
		    }else{
		    	DebugCorePlugin.outputCycleToDss=false;
		    }
		    String strOutputAllCycles = br.readLine();
		    if (strOutputAllCycles.toLowerCase().equals("true")){
		    	DebugCorePlugin.outputAllCycles=true;
		    }else{
		    	DebugCorePlugin.outputAllCycles=false;
		    }
		    DebugCorePlugin.outputCycles=br.readLine();
		} catch (Exception e) {
			DebugCorePlugin.solver="CBC";
			DebugCorePlugin.xmx="4096";
			DebugCorePlugin.outputCycleToDss=false;
			DebugCorePlugin.outputAllCycles=true;
			DebugCorePlugin.outputCycles="\'\'";
			e.printStackTrace();
		}
		return;
	}
	
	public static void save(){
		try {
			File file = new File(DebugCorePlugin.dataDir, settingPrefFile);
			if (!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			PrintWriter out = new PrintWriter(fw);
			out.println(DebugCorePlugin.solver);
			out.println(DebugCorePlugin.xmx);
			out.println(DebugCorePlugin.outputCycleToDss);
			out.println(DebugCorePlugin.outputAllCycles);
			out.println(DebugCorePlugin.outputCycles);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
