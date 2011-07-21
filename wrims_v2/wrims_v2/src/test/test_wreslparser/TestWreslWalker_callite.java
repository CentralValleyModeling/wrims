
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_callite {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_Callite" })
	public void callite_hao() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_callite_hao";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = "D:\\Haos_CalLite\\Run\\main.wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
				
		/// write full study data to csv files
		WriteCSV.study(sd, csvFolderPath ) ;
	
		Assert.assertEquals(1, 0);	
		
	}

	@Test(groups = { "WRESL_Callite" })
	public void callite_beta_debug() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_callite_beta_debug";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = "D:\\CalLite_Beta_042611_WRIMSv2_corroboration_debug\\Run\\main_BO.wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
				
		/// write full study data to csv files
		WriteCSV.study(sd, csvFolderPath ) ;
	
		Assert.assertEquals(1, 0);	
		
	}

	@Test(groups = { "WRESL_Callite" })
	public void callite_beta_042611() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_callite_beta_042611";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CalLite_Beta_042611\\Run\\main_BO.wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
				
		/// write full study data to csv files
		WriteCSV.study(sd, csvFolderPath ) ;
	
		Assert.assertEquals(1, 0);	
		
	}	
}
