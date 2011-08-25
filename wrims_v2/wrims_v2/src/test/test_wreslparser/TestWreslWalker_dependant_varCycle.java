
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_dependant_varCycle {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void missingCycle() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependant_varCycle_missingCycle";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyParser.reset();
		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath, true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,false,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td);
		
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		LogUtils.closeLogFile();
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
		Assert.assertEquals(StudyParser.total_errors, 0);

		int totalWarnings = RegUtils.timesOfMatches(logText, "Warning:");
		Assert.assertEquals(totalWarnings, 1);		
	
	}

	@Test(groups = { "WRESL_elements" })
	public void usePrevCycle() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependant_varCycle_usePrevCycle";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyParser.reset();
		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath, true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,false,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td);
		
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		LogUtils.closeLogFile();
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
		Assert.assertEquals(StudyParser.total_errors, 0);
	
		int totalWarnings = RegUtils.timesOfMatches(logText, "Warning:");
		Assert.assertEquals(totalWarnings, 1);		
	
		String csvText;
		String s;
		String cycleName;
		int n;

		cycleName = "first";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");

		s = "dv##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv").keySet().contains(cycleName));

		
		
		cycleName = "second";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");

		s = "dv##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv").keySet().contains(cycleName));

		cycleName = "third";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");

		s = "dv##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv").keySet().contains(cycleName));
		
		cycleName = "fourth";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");

		s = "dv##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 0);
		Assert.assertFalse(sd.getVarCycleValueMap().get("dv").keySet().contains(cycleName));
		
	}
}
