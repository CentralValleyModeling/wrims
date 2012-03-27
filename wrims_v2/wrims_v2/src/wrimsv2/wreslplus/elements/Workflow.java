package wrimsv2.wreslplus.elements;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class Workflow {
	
	
	private Workflow(){}


	public static StudyTemp checkStudy(String mainFilePath) {
		
		
		String canonicalMainFilePath = Tools.checkPath(mainFilePath);
		
		setRunDir(new File(canonicalMainFilePath).getParent()); 
		
		StudyTemp st = parseWreslMain(canonicalMainFilePath);
		// TODO: need to check sequence error here
		// check study
		ErrorCheck.checkVarRedefined(st);		
		ToLowerCase.convert(st);	
		Procedures.findEffectiveModelinMain(st); // main file only

		Procedures.processIncFilePath(st);
		Procedures.processSvIncFileList(st);
		Procedures.processDependants(st);

		
		
		// parse all included files		
		// store results to a map using relativePath as key
		for (String m: st.modelList_effective){

			System.out.println("[M]"+m);

			ModelTemp mt = st.modelMap.get(m);

			parseAllIncFile(mt.incFileRelativePathList, st);					
			
		}
	
		
		
		// find all offspring
		// store results to kidMap and AOMap, fileGroupOrder
		Procedures.findKidMap(st);
		Procedures.findAOM(st);
		Procedures.findFileGroupOrder(st);
		
		System.out.println("hierarchy"+st.fileGroupOrder);
		
		//TODO: here
		Procedures.postProcessSvIncFileList(st);
		Procedures.postProcessIncFileList(st);
		
		System.out.println("fileDataMap_keyset: "+st.fileModelMap.keySet());
		
		for (String k: st.fileModelMap.keySet()){
			
			System.out.println("file: "+k);
			System.out.println("svIncFileList_post: "+st.fileModelMap.get(k).svIncFileList_post);
		}
		
		
		
		// append data to the main model as defined in sequence.
		//TODO: check svar orders. need to be done from bottom up
		for (String modelName: st.modelList_effective){

			ModelTemp mo = st.modelMap.get(modelName);
			
			//======================================
			for (String f: mo.incFileRelativePathList){				
				
				ModelTemp incm =  st.fileModelMap.get(f);
				
				//mo.svList.addAll(incm.svList);
				mo.svMap.putAll(incm.svMap);
				
				mo.dvList.addAll(incm.dvList);
				mo.dvMap.putAll(incm.dvMap);
				
			}
			//======================================
			
		}	
		
		
		// can be processed after error check 
		Procedures.processGoalHS(st);
		Procedures.convertAliasToGoal(st);
		
		
		Procedures.collectWeightVar(st);
		
		return st;
		
	}	
	
	public static void setRunDir(String runDir){
		
		GlobalData.runDir = Tools.checkPath(runDir);;
	}

	public static StudyTemp parseWreslMain(String inputFilePath) {
		
		
		WreslPlusParser parser = null;
		
		try {
			parser = ParserUtils.initParser(inputFilePath);
			parser.wreslMain();
		}
		catch (RecognitionException e) {

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

			e.printStackTrace();
		}
		
		return parser.mObj;
		
	}


	public static void parseAllIncFile(ArrayList<String> relativePathList , StudyTemp st) {

		for (String relativePath: relativePathList){
			
			if (!st.fileModelMap.keySet().contains(relativePath)){

				String absPath = Tools.checkPath(new File(st.runDir, relativePath).getAbsolutePath());
				ModelTemp fm = parseWreslFile(absPath);
				
				ErrorCheck.checkVarRedefined(fm);	

				ToLowerCase.convert(fm);		
				Procedures.processIncFilePath(fm);
				Procedures.processSvIncFileList(fm);
				Procedures.processDependants(fm);
				
				st.fileModelMap.put(relativePath, fm);
				
				// parse all included files within files
				parseAllIncFile(fm.incFileRelativePathList, st);
				
			}
		}
		
	}		
	
	public static void parseAllIncFile(Map<String,IncFileTemp> incfmap , StudyTemp st) {

		for (String f: incfmap.keySet()){
			
			String relativePath = incfmap.get(f).pathRelativeToRunDir;
			
			if (!st.fileModelMap.keySet().contains(relativePath)){

				ModelTemp fm = parseWreslFile(incfmap.get(f).absPath);
				
				ErrorCheck.checkVarRedefined(fm);	
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
	
