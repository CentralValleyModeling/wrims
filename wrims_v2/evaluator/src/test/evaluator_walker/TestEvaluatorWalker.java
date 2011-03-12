
package test.evaluator_walker;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;


import elements.LogUtils;
import elements.ParserTools;
import elements.Tools;
import grammar.EvaluatorTreeWalker;

public class TestEvaluatorWalker {
	
	
	public String inputFilePath;
	public String logFilePath;

	@Test(groups = { "example" })
	public void example() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\example.wresl";
		logFilePath = "TestEvaluatorWalker_example.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();

		LogUtils.setLogFile(logFilePath);
		
		EvaluatorTreeWalker walker = ParserTools.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.importantMsg("result = " + walker.result);
		LogUtils._logFile.close();
		
	}
	
	@Test(groups = { "example" })
	public void parseString() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\parseObj.wresl";
		logFilePath = "TestEvaluatorWalker_parseString.log";
		


		LogUtils.setLogFile(logFilePath);
		
		EvaluatorTreeWalker walker = ParserTools.parseString("3+5");
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.importantMsg("result = " + walker.result);
		LogUtils._logFile.close();
		
	}

	@Test(groups = { "example" })
	public void parseObj() throws RecognitionException, IOException {
		

		

		logFilePath = "TestEvaluatorWalker_parseObj.log";
		
		LogUtils.setLogFile(logFilePath);
		
		EvaluatorTreeWalker walker = ParserTools.parseString("3+5");
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.importantMsg("result = " + walker.result);
		LogUtils._logFile.close();
		
	}	
	
}
