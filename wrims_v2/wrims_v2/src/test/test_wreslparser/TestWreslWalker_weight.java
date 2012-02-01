
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.FileParser;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class TestWreslWalker_weight {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void weightTable1() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_weightTable1";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
		//LogUtils.studySummary_details(sd);
		LogUtils.closeLogFile();
		
		WriteCSV.study(sd,csvFolderPath ) ;
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);	
	
		int Errs;
		String s;
		
		s = "# Error: Weight var not found in dvar: [x]";
		s = Tools.replace_regex(s);
		Errs = RegUtils.timesOfMatches(logText, s);
		Assert.assertEquals(Errs, 1);	 
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\second\\weight.csv");	
		
		int n;
	
		s = "y,always,100";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "z,always,100";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\third\\weight.csv");	
	
		s = "errpos_shsta,always,-99999";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		
	}

	@Test(groups = { "WRESL_elements" })
	public void weightTable2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_weightTable2";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
		//LogUtils.studySummary_details(sd);
		LogUtils.closeLogFile();
			
		WriteCSV.study(sd,csvFolderPath ) ;
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);	
		
		int Errs;
		String s;
		
		s = "# Error: Weight var not found in dvar: [s_trnty_2, errpos_shsta, s_trnty_1, errneg_wkytn, y, x]";
		s = Tools.replace_regex(s);
		Errs = RegUtils.timesOfMatches(logText, s);
		Assert.assertEquals(Errs, 1);	

		s = "# Error: Weight var not found in dvar: [y]";
		s = Tools.replace_regex(s);
		Errs = RegUtils.timesOfMatches(logText, s);
		Assert.assertEquals(Errs, 1);
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\second\\weight.csv");	
		
		int n;
	
		s = "errpos_shsta,-99999";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 0);

		s = "x,always,20000";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
	}

	@Test(groups = { "WRESL_elements" })
	public void weightTable3() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_weightTable3";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
		//LogUtils.studySummary_details(sd);
		
		WreslTreeWalker walker = FileParser.parseMainFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		LogUtils.closeLogFile();
			
		WriteCSV.study(sd,csvFolderPath ) ;
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);	
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");	
		
		String s;
		int n;
	
		s = "surplus__g_pp_1";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\second\\dvar.csv");	
	
		s = "surplus__g_pp_1";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 0);

	
	}
}
