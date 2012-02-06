
package test.test_wreslparser_v2;

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
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslParser_timeArraySvar {
	
	public String projectPath = "src\\test\\test_wreslparser_v2\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void simple_value() throws RecognitionException, IOException {
		
		testName = "TestWreslParser_timeArraySvar_simple_value";
		csvFolderPath = "testResult_v2\\"+testName;
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
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);

		String errS=null;
		int errN = 0;
		
		errS ="variable names used before definition: [somesvar] in Svar named [i2]";
		errS = Tools.replace_regex(errS);
		errN = RegUtils.timesOfMatches(logText, errS );
		Assert.assertEquals(errN, 1);
		
		errS ="variable names used before definition: [sometimefunc] in Svar named [i3]";
		errS = Tools.replace_regex(errS);
		errN = RegUtils.timesOfMatches(logText, errS );
		Assert.assertEquals(errN, 1);
		
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");	
		
		String s;
		int n;
	
		s =",to(oct)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s ="i4,default,1,always,abc(\\$m-month)";
		s = Tools.replace_regex(s);
		System.out.println(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

	}

	@Test(groups = { "WRESL_elements" })
	public void simple_case_value() throws RecognitionException, IOException {
		
		testName = "TestWreslParser_timeArraySvar_simple_case_value";
		csvFolderPath = "testResult_v2\\"+testName;
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
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);

		String errS=null;
		int errN = 0;
		
		errS ="variable names used before definition: [somesvar] in Svar named [i4]";
		errS = Tools.replace_regex(errS);
		errN = RegUtils.timesOfMatches(logText, errS );
		Assert.assertEquals(errN, 1);
	
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");	
		
		String s;
		int n;
	
		s =",to(sep)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 6);
	
		s ="i3,e,5,month==may,i3may50(\\$m-month)";
		s = Tools.replace_regex(s);
		System.out.println(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
	}
}
