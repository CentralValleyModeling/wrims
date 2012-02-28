
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

public class TestWreslWalker_integer {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void std() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_integer_std";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 

		LogUtils.studySummary_details(sd);

		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");	
		
		String s;
		int n;
	
		s = "int_global,always,0,1,y,none,integer";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "int_local,always,0,1,y,none,integer";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).dvList_global.get(0),"int_global" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).dvList_local.get(0),"int_local" );

	}

	@Test(groups = { "WRESL_elements" })
	public void nonStd() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_integer_nonStd";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");	
		
		String s;
		int n;
	
		s = "int_global,always,-3,5,y,none,integer";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
		s = "int_local,always,0,5,y,none,integer";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "int_negative,always,-99,-20,y,none,integer";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).dvList_global.get(0),"int_global" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).dvList_local.get(0),"int_local" );
	
	}
}
