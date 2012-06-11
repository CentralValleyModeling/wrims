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


public class TestWreslPlus_alias {
	
	public String projectPath = TestParam.projectPath;	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void alias_to_goal() throws RecognitionException, IOException {
		

		testName = TestParam.testNamePrepend + "_alias_to_goal";
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
		
		// to match the missing dependants in wreslparser
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		String csvText_modified = csvText.replaceAll("d_banks;d_jones;", "");
		
		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
		csvFile.print(csvText_modified);
		csvFile.close();
		
		Assert.assertEquals(totalErrs, 0);		

	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void alias_to_goal2() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_alias_to_goal2";
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

	@Test(groups = { "WRESLPLUS_elements" })
	public void alias_to_goal3() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_alias_to_goal3";
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

	@Test(groups = { "WRESLPLUS_elements" })
	public void alias_to_goal4() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_alias_to_goal4";
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
		
		// to match the missing dependants in wreslparser
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		String csvText_modified = csvText.replaceAll("dv;", "");
		
		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
		csvFile.print(csvText_modified);
		csvFile.close();
		
		Assert.assertEquals(totalErrs, 0);		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void alias_to_goal6() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_alias_to_goal6";
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
		
//		// to match the missing dependants in wreslparser
//		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
//		String csvText_modified = csvText.replaceAll("dv;", "");
//		
//		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
//		csvFile.print(csvText_modified);
//		csvFile.close();
		
		Assert.assertEquals(totalErrs, 0);		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void alias_to_goal7() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_alias_to_goal7";
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
		
//		// to match the missing dependants in wreslparser
//		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
//		String csvText_modified = csvText.replaceAll("dv;", "");
//		
//		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
//		csvFile.print(csvText_modified);
//		csvFile.close();
		
		Assert.assertEquals(totalErrs, 0);		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
		public void alias() throws RecognitionException, IOException {
			
		
			testName = TestParam.testNamePrepend + "_alias";
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
			
	//		// to match the missing dependants in wreslparser
	//		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
	//		String csvText_modified = csvText.replaceAll("dv;", "");
	//		
	//		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
	//		csvFile.print(csvText_modified);
	//		csvFile.close();
			
			Assert.assertEquals(totalErrs, 0);		
		
		}

	@Test(groups = { "WRESLPLUS_elements" })
		public void alias2() throws RecognitionException, IOException {
			
		
			testName = TestParam.testNamePrepend + "_alias2";
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
			
	//		// to match the missing dependants in wreslparser
	//		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
	//		String csvText_modified = csvText.replaceAll("dv;", "");
	//		
	//		PrintWriter csvFile = Tools.openFile(System.getProperty("user.dir"), csvFolderPath+"\\first\\constraint.csv");
	//		csvFile.print(csvText_modified);
	//		csvFile.close();
			
			Assert.assertEquals(totalErrs, 0);		
		
		}
}
