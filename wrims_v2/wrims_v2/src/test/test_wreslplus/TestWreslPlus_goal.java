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
import wrimsv2.wreslplus.elements.Workflow;
import wrimsv2.wreslplus.elements.procedures.ToWreslData;


public class TestWreslPlus_goal {
	
	public String projectPath = TestParam.projectPath;	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void goal_simple() throws RecognitionException, IOException {
		

		testName = TestParam.testNamePrepend + "_goal_simple";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
		Assert.assertEquals(totalErrs, 6);
		
		//StudyDataSet s = ToWreslData.convertStudy(s)

	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void goal_noCase() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_noCase";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
		Assert.assertEquals(totalErrs, 10);
		
		//StudyDataSet s = ToWreslData.convertStudy(s)
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void goal_case() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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

		
		// to match the missing dependants in penalty term parsed by wreslparser
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		String csvText_modified = csvText.replaceAll(";pp", "");
		
		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
		csvFile.print(csvText_modified);
		csvFile.close();
		
		Assert.assertEquals(totalErrs, 2);		
		
		//StudyDataSet s = ToWreslData.convertStudy(s)
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void goal_case2() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case2";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
	
		
		// to match the missing dependants in penalty term parsed by wreslparser
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		String csvText_modified = csvText.replaceAll("a;b;", "");
		
		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
		csvFile.print(csvText_modified);
		csvFile.close();
		
		Assert.assertEquals(totalErrs, 3);		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void goal_case3() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case3";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
	public void goal_case4() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case4";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
	public void goal_case5() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case5";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
	public void goal_case6() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case6";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
	public void goal_case7() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case7";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
		
		Assert.assertEquals(totalErrs, 8);		
		
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void goal_case8() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case8";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
	public void goal_case9() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_goal_case9";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
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
