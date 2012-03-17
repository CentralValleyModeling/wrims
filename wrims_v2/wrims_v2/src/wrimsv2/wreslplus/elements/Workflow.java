package wrimsv2.wreslplus.elements;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class Workflow {
	
	
	private Workflow(){}


	public static StudyTemp checkWreslMain(String mainFilePath) throws RecognitionException  {
		
		
		String canonicalMainFilePath = checkPath(mainFilePath);
		
		GlobalData.runDir = new File(canonicalMainFilePath).getParent(); 
		
		StudyTemp st = parseWreslMain(canonicalMainFilePath);

		
		ErrorCheck.checkStudy(st);		

		ToLowerCase.convertStudy(st);		
		
		Procedures.processIncFilePath(st);
		
		ModelTemp fm = st.modelMap.get(st.modelList.get(0));
		System.out.println(fm.incFileIDList);
		for (String s:fm.incFileIDList ) System.out.println(fm.incFileMap.get(s).rawPath);
		for (String s:fm.incFileIDList ) System.out.println(fm.incFileMap.get(s).absPath);
		for (String s:fm.incFileIDList ) System.out.println(fm.incFileMap.get(s).pathRelativeToRunDir);
		
		Procedures.processGoalHS(st);		
		
		Procedures.collectWeightVar(st);
		
		Procedures.processDependants(st);
		
		Procedures.convertAliasToGoal(st);
		
		return st;
		
	}	
	
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


	public static StudyTemp parseWreslMain(String inputFilePath) throws RecognitionException  {
		
		
		WreslPlusParser parser = ParserUtils.initParser(inputFilePath);
		
		//parser.runDir = parser.currentAbsolutePath;
		parser.wreslMain();
		
		return parser.styObj;
		
	}
	
	



}
	
