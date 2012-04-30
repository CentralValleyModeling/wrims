package test.test_wreslplus;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.ToWreslData;
import wrimsv2.wreslplus.elements.Workflow;


public class TestWreslPlus_include {
	
	public String projectPath = TestParam.projectPath;	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void include() throws RecognitionException, IOException {
		

		testName = TestParam.testNamePrepend + "_include";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + "\\moreWreslFiles\\" + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();

		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		
		Assert.assertEquals(totalErrs, 0);		

	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void include2() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_include2";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + "\\moreWreslFiles\\" + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		
		Assert.assertEquals(totalErrs, 1);		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void include_ex() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_include_ex";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + "\\moreWreslFiles\\" + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		
		Assert.assertEquals(totalErrs, 0);		
	
	}
}
