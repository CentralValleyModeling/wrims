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
import wrimsv2.solver.CbcSolver;

public class SettingPref {
	private static String settingPrefFile="setting.prf";
	private static String cbcSettingPrefFile="CBCSetting.prf";
	
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
	
	public static void loadCBCSetting(String dataDir){
		try {
			File file = new File(dataDir, cbcSettingPrefFile);
			if (file.exists()){
				FileInputStream fs = new FileInputStream(file.getAbsolutePath());
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			    String line = br.readLine();
			    while (line !=null){
			    	line.replace(" ", "");
			    	String[] parts = line.split(":");
			    	if (parts.length>=2){
			    		String pn=parts[0].trim();
			    		String pv=parts[1].trim();
			    		if (pn.equalsIgnoreCase("cbcTolerancePrimal")){
			    			CbcSolver.solve_2_primalT       = Double.parseDouble(pv);
			    		}else if (pn.equalsIgnoreCase("cbcTolerancePrimalRelax")){			
			    			CbcSolver.solve_2_primalT_relax = Double.parseDouble(pv);
			    		}else if (pn.equalsIgnoreCase("cbcToleranceWarmPrimal")){
			    			CbcSolver.solve_whs_primalT     = Double.parseDouble(pv);
			    		}else if (pn.equalsIgnoreCase("cbcToleranceInteger")){	
			    			CbcSolver.integerT              = Double.parseDouble(pv);
			    		}else if (pn.equalsIgnoreCase("cbcToleranceIntegerCheck")){
			    			CbcSolver.integerT_check        = Double.parseDouble(pv);
			    		}else if (pn.equalsIgnoreCase("cbcToleranceZero")){
			    			ControlData.zeroTolerance        = Double.parseDouble(pv);
			    		}
			    	}
			    	line=br.readLine();
			    }
				br.close();
			}
		}catch(Exception e){		
		}
	}
}
