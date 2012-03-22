package wrimsv2.wreslplus.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class Workflow {
	
	
	private Workflow(){}


	public static void setRunDir(String runDir){
		
		GlobalData.runDir = checkPath(runDir);;
	}



	public static StudyTemp checkStudy(String mainFilePath) {
		
		
		String canonicalMainFilePath = checkPath(mainFilePath);
		
		setRunDir(new File(canonicalMainFilePath).getParent()); 
		
		StudyTemp st = parseWreslMain(canonicalMainFilePath);
		// TODO: need to check sequence error here
		// check study
		ErrorCheck.checkVarRedefined(st);		
		ToLowerCase.convert(st);	
		Procedures.findEffectiveModelinMain(st); // main file only
		Procedures.processSvIncFileList(st);
		
		
		
		Procedures.processIncFilePath(st);
		Procedures.processDependants(st);

		
		
		
		// parse included files		
		// store results to a map using relativePath as key
		
		for (String modelName: st.modelList_effective){

			System.out.println("[M]"+modelName);

			//ModelTemp mo = st.modelMap.get(m);
			Map<String,IncFileTemp> incfmap = st.modelMap.get(modelName).incFileMap;
			
			
			parseAllIncFile(incfmap, st);					
			
		}
		
	    
		// TODO: need to check parsed wresl file
		
		System.out.println("fileModelMap: ");
		System.out.println(st.fileModelMap);
		
		// append data to the main model as defined in sequence
		//TODO: check svar orders. need to be done from bottom up
		for (String s: st.seqList){
			String modelName = st.seqMap.get(s).model;

			ModelTemp mo = st.modelMap.get(modelName);
			
			//======================================
			for (String f: mo.incFileRelativePathList){
				
				
				ModelTemp incm =  st.fileModelMap.get(f);
				
				
				mo.svList.addAll(incm.svList);
				mo.svMap.putAll(incm.svMap);
				
				mo.dvList.addAll(incm.dvList);
				mo.dvMap.putAll(incm.dvMap);
				
			}
			//======================================
			
		}	
	
		
		
//		// check full study
//		ErrorCheck.checkVarRedefined(st);		
//		ToLowerCase.convert(st);		
//		Procedures.processIncFilePath(st);		
//		Procedures.processDependants(st);
		
		
		// can be processed after error check 
		Procedures.processGoalHS(st);
		Procedures.convertAliasToGoal(st);
		Procedures.collectWeightVar(st);
		
		return st;
		
	}	
	
//	public static ModelTemp checkWreslFile(String wreslFilePath) throws RecognitionException  {
//			
//			
//			String canonicalWreslFilePath = checkPath(wreslFilePath);
//			
//			
//			
//			ModelTemp m = parseWreslFile(canonicalWreslFilePath);
//	
//			
//			ErrorCheck.checkVarRedefined(m);		
//	
//			ToLowerCase.convert(m);		
//			
//			Procedures.processIncFilePath(m);
//					
//			Procedures.processGoalHS(m);		
//			
//			Procedures.collectWeightVar(m);
//			
//			Procedures.processDependants(m);
//			
//
//			
//			return m;
//			
//		}


	private static String checkPath(String filePath) {
		
		String canonicalPath=null;
		
		try {
			
			canonicalPath = new File(filePath).getCanonicalPath().toLowerCase(); 
		
		} catch (IOException e) {
			
	        e.printStackTrace();
	        LogUtils.errMsg("IOException: " + filePath);
	    }
		
		return canonicalPath;
		
	}


	public static StudyTemp parseWreslMain(String inputFilePath) {
		
		
		WreslPlusParser parser = null;
		
		try {
			parser = ParserUtils.initParser(inputFilePath);
			parser.wreslMain();
		}
		catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		parser.styObj.absPath = parser.currentAbsolutePath;
		parser.styObj.relativePath = parser.pathRelativeToRunDir;
		parser.styObj.runDir = parser.currentAbsoluteParent;
		
		return parser.styObj;
		
	}


	public static ModelTemp parseWreslFile(String inputFilePath) {
		
		
		WreslPlusParser parser = null;
		
		try {
			parser = ParserUtils.initParser(inputFilePath);
			parser.wreslFile();
		}
		catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parser.mObj;
		
	}


	public static void parseAllIncFile(ArrayList<String> relativePathList , StudyTemp st) {

		for (String relativePath: relativePathList){
			
			
			if (!st.fileModelMap.keySet().contains(relativePath)){

				String absPath = checkPath(new File(st.runDir, relativePath).getAbsolutePath());
				ModelTemp fm = parseWreslFile(absPath);
				
				ErrorCheck.checkVarRedefined(fm);	
				Procedures.processSvIncFileList(st);
				ToLowerCase.convert(fm);		
				Procedures.processIncFilePath(fm);	
				Procedures.processDependants(fm);
				
				st.fileModelMap.put(relativePath, fm);
				
				// parse all included files within files
				parseAllIncFile(fm.incFileMap, st);
				
			}
		}
		
	}		
	
	public static void parseAllIncFile(Map<String,IncFileTemp> incfmap , StudyTemp st) {

		for (String f: incfmap.keySet()){
			
			String relativePath = incfmap.get(f).pathRelativeToRunDir;
			
			if (!st.fileModelMap.keySet().contains(relativePath)){

				ModelTemp fm = parseWreslFile(incfmap.get(f).absPath);
				
				ErrorCheck.checkVarRedefined(fm);	
				Procedures.processSvIncFileList(st);
				ToLowerCase.convert(fm);		
				Procedures.processIncFilePath(fm);	
				Procedures.processDependants(fm);
				
				st.fileModelMap.put(relativePath, fm);
				
				// parse all included files within files
				parseAllIncFile(fm.incFileMap, st);
				
			}
		}
		
	}	



}
	
