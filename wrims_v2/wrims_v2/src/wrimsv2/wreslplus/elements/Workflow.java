package wrimsv2.wreslplus.elements;

import org.antlr.runtime.RecognitionException;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class Workflow {
	
	
	private Workflow(){}


	public static StudyTemp checkWreslMain(String inputFilePath) throws RecognitionException  {
		
		StudyTemp st = parseWreslMain(inputFilePath);
		
		ErrorCheck.checkStudy(st);
		Procedures.processGoalHS(st);
		//Procedures.processSlackSurplus(st);
		//st= Procedures.replaceChar(st);
		
		return st;
		
	}	
	
	public static StudyTemp parseWreslMain(String inputFilePath) throws RecognitionException  {
		
		
		WreslPlusParser parser = ParserUtils.initParser(inputFilePath);
		
		parser.wreslMain();
		
		return parser.styObj;
		
	}
	
	



}
	
