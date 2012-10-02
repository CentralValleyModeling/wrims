package test.test_wreslplus;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.Workflow;
import wrimsv2.wreslplus.elements.procedures.ToWreslData;


public class TestWreslPlus_svar {
	
	public String projectPath = TestParam.projectPath;	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void svar_const() throws RecognitionException, IOException {
		

		testName = TestParam.testNamePrepend + "_svar_const";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
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
		Assert.assertEquals(totalErrs, 2);
		
		//StudyDataSet s = ToWreslData.convertStudy(s)
		
		

	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void svar_expression() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_svar_expression";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
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
		Assert.assertEquals(totalErrs, 2);	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void svar_sum() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_svar_sum";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
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
		Assert.assertEquals(totalErrs, 3);
		
	
		
		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void svar_case() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_svar_case";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
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
		Assert.assertEquals(totalErrs, 2);
		
	
		
		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void svar_table() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_svar_table";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
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
	public void svar_tableFull() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_svar_tableFull";
		csvFolderPath = "testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
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
