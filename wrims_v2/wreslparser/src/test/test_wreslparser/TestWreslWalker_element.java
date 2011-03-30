
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.FileParser;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.SimulationDataSet;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class TestWreslWalker_element {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_dvarNonStd.wresl";
		logFilePath = "TestWreslWalker_element_dvarNonStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		//LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		LogUtils.fileSummary(walker.thisFileDataSet);
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_dvarStd.wresl";
		logFilePath = "TestWreslWalker_element_dvarStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.closeLogFile();
		
		
		String fileText = Tools.readFileAsString(logFilePath);
		int redefineErrs = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: C_Banks");
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(redefineErrs, 1);
		Assert.assertEquals(totalErrs, 1);		
	}
	
	@Test(groups = { "WRESL_elements" })
	public void svarDSS() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_svarDSS.wresl";
		logFilePath = "TestWreslWalker_element_svarDSS.log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 

		LogUtils.studySummary_details(sd);

		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	

		int correct = RegUtils.timesOfMatches(fileText, "Model second watch_this .+This-is-correct");
		Assert.assertEquals(correct, 1);

		int wrong = RegUtils.timesOfMatches(fileText, "Model second watch_this .+This-should-not-exist-in-model-second");
		Assert.assertEquals(wrong, 0);
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 1);	
		
		int Errs = RegUtils.timesOfMatches(fileText, "# Error: Decision varriable redefined: watch_this in files: ");
		Assert.assertEquals(Errs, 1);			

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 5 Dvars:");
		Assert.assertEquals(str1, 1);
	}
		
}
