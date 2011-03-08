
package test.wresl_walker;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import components_tree.FileParser;
import components_tree.LogUtils;
import components_tree.RegUtils;
import components_tree.Tools;

import wresl.WreslTreeWalker;

public class TestWreslWalker {
	
	
	public String inputFilePath;
	public String logFilePath;

	@Test(groups = { "WRESL_elements" })
	public void test2() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestWreslWalker_test2.wresl";
		logFilePath = "TestWreslWalker_test2.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils._logFile.close();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	
	}		
	

	@Test(groups = { "WRESL_elements" })
	public void mainFile() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestWreslWalker_mainFile.wresl";
		logFilePath = "TestWreslWalker_mainFile.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils._logFile.close();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void mainFile2() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestWreslWalker_mainFile2.wresl";
		logFilePath = "TestWreslWalker_mainFile2.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.varsList(walker.F);
		
		
		LogUtils._logFile.close();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	
	}		

	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestWreslWalker_dvarNonStd.wresl";
		logFilePath = "TestWreslWalker_dvarNonStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils._logFile.close();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestWreslWalker_dvarStd.wresl";
		logFilePath = "TestWreslWalker_dvarStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils._logFile.close();
		
		
		String fileText = Tools.readFileAsString(logFilePath);
		int redefineErrs = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: C_Banks");
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(redefineErrs, 1);
		Assert.assertEquals(totalErrs, 1);		
	}	
		
}
