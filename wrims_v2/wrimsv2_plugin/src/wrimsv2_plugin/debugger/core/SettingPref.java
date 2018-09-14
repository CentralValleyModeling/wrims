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
				save();
				return;
			}
			FileInputStream fs = new FileInputStream(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		    LineNumberReader reader = new LineNumberReader(br);
		    DebugCorePlugin.solver=br.readLine();
		    DebugCorePlugin.xmx=br.readLine();
		} catch (Exception e) {
			DebugCorePlugin.solver="CBC";
			DebugCorePlugin.xmx="4096";
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
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
