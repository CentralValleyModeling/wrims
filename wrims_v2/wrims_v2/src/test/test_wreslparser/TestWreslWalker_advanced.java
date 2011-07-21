
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.TempData;

public class TestWreslWalker_advanced {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;			

	@Test(groups = { "WRESL_elements" })
	public void studyParser1() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_advanced_studyParser1";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();

		StudyConfig sc = new StudyConfig();
		
		sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		LogUtils.mainFileSummary(sc);
		
		TempData td = new TempData();

		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		LogUtils.studySummary(sc, td.model_dataset_map);
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 3 Dvars:");
		Assert.assertEquals(str1, 1);

		int str2 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 2 global Dvars:");
		Assert.assertEquals(str2, 1);

	}		
	
	@Test(groups = { "WRESL_elements" })
	public void studyParser2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_advanced_studyParser2";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		LogUtils.mainFileSummary(sc);
		
		TempData td = new TempData();

		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		LogUtils.studySummary(sc, td.model_dataset_map);
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 5 Dvars:");
		Assert.assertEquals(str1, 1);

		int str2 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 2 global Dvars:");
		Assert.assertEquals(str2, 1);
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void studyParser3() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_advanced_studyParser3";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);

		LogUtils.studySummary(sc, td.model_dataset_map);

		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 5 Dvars:");
		Assert.assertEquals(str1, 1);

		int str2 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 4 global Dvars:");
		Assert.assertEquals(str2, 1);

	}	
}
