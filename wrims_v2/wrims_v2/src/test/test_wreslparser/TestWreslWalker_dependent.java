
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_dependent {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_elements" })
	public void ignore_dvar() throws RecognitionException, IOException {
	// deep embedding of alias
		
		csvFolderPath = "TestWreslWalker_dependent_ignoreDvar";
		inputFilePath = projectPath+csvFolderPath+".wresl";
		logFilePath = csvFolderPath+".log";
		
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath, true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		String csvText;
		String s;
		int n;

		
		// check if dependents has the item
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");
		
		s = "sv,default,1,always,dvar1(-2),,";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);			
	}

	@Test(groups = { "WRESL_elements" })
	public void ignore_external() throws RecognitionException, IOException {
	// deep embedding of alias
		
		csvFolderPath = "TestWreslWalker_dependent_ignoreExternal";
		inputFilePath = projectPath+csvFolderPath+".wresl";
		logFilePath = csvFolderPath+".log";
		
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath, true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		String csvText;
		String s;
		int n;
	
		
		// check if dependents has the item
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");
		
		s = "sv,default,1,always,external_var(-1),,";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);			
	}

	@Test(groups = { "WRESL_elements" })
	public void ignore_alias() throws RecognitionException, IOException {
	// deep embedding of alias
		
		csvFolderPath = "TestWreslWalker_dependent_ignoreAlias";
		inputFilePath = projectPath+csvFolderPath+".wresl";
		logFilePath = csvFolderPath+".log";
		
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath, true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		String csvText;
		String s;
		int n;
	
		
		// check if dependents has the item
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");
		
		s = "sv,default,1,always,alias1(-2),,";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);			
	}
}
