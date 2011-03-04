
package test.evaluator_walker;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;

import components_tree.FileParser;
import components_tree.LogUtils;
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
		
		EvaluatorTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.importantMsg("result = " + walker.result);
		LogUtils._logFile.close();
		
	}
		
}
