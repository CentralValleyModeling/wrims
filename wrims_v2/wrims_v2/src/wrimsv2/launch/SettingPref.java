package wrimsv2.launch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import wrimsv2.components.ControlData;

public class SettingPref {
	private static String settingPrefFile="setting.prf";
	
	public static void load(String dataDir){
		try {
			File file = new File(dataDir, settingPrefFile);
			if (!file.exists()){
				ControlData.solverName="cbc";
				ControlData.isOutputCycle=false;
				ControlData.outputAllCycles=true;
				ControlData.selectedCycleOutput="\'\'";
				return;
			}
			FileInputStream fs = new FileInputStream(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		    LineNumberReader reader = new LineNumberReader(br);
		    ControlData.solverName=br.readLine().toLowerCase();
		    String xmx=br.readLine();
		    String strOutputCycleToDss = br.readLine();
		    if (strOutputCycleToDss.toLowerCase().equals("true")){
		    	ControlData.isOutputCycle=true;
		    }else{
		    	ControlData.isOutputCycle=false;
		    }
		    String strOutputAllCycles = br.readLine();
		    if (strOutputAllCycles.toLowerCase().equals("true")){
		    	ControlData.outputAllCycles=true;
		    }else{
		    	ControlData.outputAllCycles=false;
		    }
		    ControlData.selectedCycleOutput=br.readLine().replace(" ", "");
		} catch (Exception e) {
			e.printStackTrace();
			ControlData.solverName="cbc";
			ControlData.isOutputCycle=false;
			ControlData.outputAllCycles=true;
			ControlData.selectedCycleOutput="\'\'";
			e.printStackTrace();
		}
		return;
	}
}
