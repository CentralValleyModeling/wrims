
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class TestWreslWalker_scope {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void simple() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_scope_simple";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath,true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		WriteCSV.study(sd,csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
		
		int n;
		String s;
		s ="# Error: Global include files redefined##scope.wresl";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(logText, s );
		Assert.assertEquals(n, 1);	
		
		s ="# Error: Global variables redefined##sv1##sv2";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(logText, s );
		Assert.assertEquals(n, 1);	
	}

	@Test(groups = { "WRESL_elements" })
	public void case2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_scope_case2";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath,true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		String modelName2 = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
		
		int n;
		String s;
		s ="# Error: Global variables redefined: [sv1]";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(logText, s );
		Assert.assertEquals(n, 1);	
		
		ArrayList<String> e = new ArrayList<String>();
		e.add("sv1"); e.add("sv2");
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName2).svList, e);	
	
	}

	@Test(groups = { "WRESL_elements" })
	public void case1() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_scope_case1";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath,true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		WriteCSV.study(sd,csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
		
		int n;
		String s;
		s ="Warning: Global variables redefined as local##sv1##sv2]";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(logText, s );
		Assert.assertEquals(n, 1);	
		
	
	}

	@Test(groups = { "WRESL_elements" })
	public void case3() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_scope_case3";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath,true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName2 = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);		
		
		int n;
		String s;
		s ="Variables with unknown dependants: [sv2]";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(logText, s );
		Assert.assertEquals(n, 1);	
	
	}

}
