
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
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_priority {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	


	@Test(groups = { "WRESL_elements" })
	public void global1() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_priority_global1.wresl";
		logFilePath = "TestWreslWalker_priority_global1.log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);

		LogUtils.studySummary_details(sc, td.model_dataset_map);

		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	

		int correct = RegUtils.timesOfMatches(fileText, "Model second watch_this .+this-is-correct");
		Assert.assertEquals(correct, 2);

		int wrong = RegUtils.timesOfMatches(fileText, "Model second watch_this .+this-should-not-exist-in-model-second");
		Assert.assertEquals(wrong, 0);
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 1);	
		
		int Errs = RegUtils.timesOfMatches(fileText, "# Error: Decision varriable redefined: watch_this in files: ");
		Assert.assertEquals(Errs, 0);	
		

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 5 Dvars:");
		Assert.assertEquals(str1, 1);

		int str2 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 4 global Dvars:");
		Assert.assertEquals(str2, 1);

	}	
	@Test(groups = { "WRESL_elements" })
	public void case2() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_priority_case2";
		inputFilePath = projectPath+csvFolderPath+".wresl";
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
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\dvar.csv");	
		
		String s;
		int n;
	
		s ="watch_this#this-is-correct";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "another#this-is-correct";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}
	@Test(groups = { "WRESL_elements" })
	public void case3() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_priority_case3";
		inputFilePath = projectPath+csvFolderPath+".wresl";
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
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\dvar.csv");	
		
		String s;
		int n;
	
		s ="include1#this-is-correct";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "include2#this-is-correct";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "main#this-is-correct";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}

}
