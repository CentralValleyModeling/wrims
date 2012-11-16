package test.test_wreslplus;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.config.ConfigUtils;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.SequenceTemp;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.Workflow;
import wrimsv2.wreslplus.elements.procedures.ToWreslData;


public class TestWreslPlus_parameter {
	
	public String projectPath = TestParam.projectPath_wp;	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void parameter1() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_parameter1";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
		
	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void parameter2() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_parameter2";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);	
		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void parameter3() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_parameter3";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);	
		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void parameter4() throws RecognitionException, IOException {
		


		/// set control data		
		String[] controlDataString = {

				
	    "-config=\"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\parameter\\simple4_error.config\"" 
				
		};

	
		StudyParser.reset();
		Error.clear();
        
        ConfigUtils.loadArgs(controlDataString);
        StudyUtils.checkStudy(FilePaths.fullMainPath);
		
        Assert.assertEquals(Error.getTotalError(),1);
		Assert.assertEquals(StudyParser.total_errors, 1);	

		
	
	}
}
