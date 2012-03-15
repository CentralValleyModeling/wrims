package wrimsv2.wreslplus.elements;

import java.io.File;

import org.antlr.runtime.RecognitionException;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class Workflow {
	
	
	private Workflow(){}


	public static StudyTemp checkWreslMain(String inputFilePath) throws RecognitionException  {
		
		StudyTemp st = parseWreslMain(inputFilePath);
		
		System.out.println(st.modelMap.get(st.modelList.get(0)).incFileIDList);
		System.out.println(st.modelMap.get(st.modelList.get(0)).incFileMap);
		
		ErrorCheck.checkStudy(st);
		
		Procedures.processGoalHS(st);
		
		ToLowerCase.convertStudy(st);		

		Procedures.collectWeightVar(st);
		
		Procedures.processDependants(st);
		
		Procedures.convertAliasToGoal(st);
		
//		String t=ResourceUtils.getRelativePath("c:\\test\\what\\is\\this\\m.htm", "c:\\test\\what\\diff\\", "\\");
//		
//		System.out.println(t);
		
		return st;
		
	}	
	
	public static StudyTemp parseWreslMain(String inputFilePath) throws RecognitionException  {
		
		
		WreslPlusParser parser = ParserUtils.initParser(inputFilePath);
		
		//parser.runDir = parser.currentAbsolutePath;
		parser.wreslMain();
		
		return parser.styObj;
		
	}
	
	



}
	
