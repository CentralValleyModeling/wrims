package main;

import java.io.IOException;
import java.util.Map;

import org.antlr.runtime.RecognitionException;

import components.Dataset;
import components.LogUtils;
import components.ReadSerialObj;
import components.SimulationData;
import components.StudyConfig;
import components.StudyParser;
import components.Tools;
import components.WriteCSV;
import components.WriteSerialObj;

public class MainConverter {
	
	
	public static void main(String[] args) throws RecognitionException, IOException {

		String f;
		String outParent;
		
		
		if (args.length > 0 ){
			f = args[0];
		} else {
			f = "D:\\CALSIM3.0_070110\\D1641\\Run\\maind1641.wresl";
		}
		
		//System.out.println("main file: "+f);

		if (args.length > 1 ){
			outParent = args[1];
		} else {
			outParent = "..\\test-csv\\calsim3\\";
		}
		
		//System.out.println("output folder: "+outParent);
		
		Tools.deleteDir(outParent);

		LogUtils.setLogFile();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(sc);
		
		
		WriteCSV.study(sc, modelDataMap, outParent);
		
		LogUtils._logFile.close();
		
		
		SimulationData obj = new SimulationData();
		obj.svMap = modelDataMap.get("SJRBASE").svMap;
		obj.svList = modelDataMap.get("SJRBASE").svList;
		WriteSerialObj.writeObj(obj, "test.ilp");
		
		System.out.println("=== finished writing object ===");
		
		SimulationData obj_in = ReadSerialObj.readObj("test.ilp");;
		
		System.out.println("=== reading object ===");
		String sv1 = obj_in.svList.get(0);
		System.out.println("Svar: " + sv1 + "   Expression: " + obj_in.svMap.get(sv1).caseExpression.get(0));
		
		
		
		
		
		
		

	}

}
