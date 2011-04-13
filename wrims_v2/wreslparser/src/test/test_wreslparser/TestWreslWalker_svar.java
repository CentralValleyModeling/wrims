
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
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_svar {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_elements" })
	public void svar_case() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_svar_case";
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
		Assert.assertEquals(totalErrs, 0);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\svar.csv");	
		
		String s;
		int n;
	
		s = "global_goal,ActionOn,1,int(B2On)==1,C3_M>minflow_C | minflow_C-(C3_M):-700.";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "global_goal,ActionOff,2,int(B2On)==0,C3_M>clear_min | clear_min-(C3_M):-0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_global.get(0),"svar_global" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_local.get(0),"svar_local" );
	}
	@Test(groups = { "WRESL_elements" })
	public void goal_case2() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_goal_case2";
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
		Assert.assertEquals(totalErrs, 0);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\constraint.csv");	
		
		String s;
		int n;
	

		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_global.get(0),"global_goal" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"local_goal" );
	}
	@Test(groups = { "WRESL_elements" })
	public void goal_case3() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_goal_case3";
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
		Assert.assertEquals(totalErrs, 0);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\constraint.csv");	
		
		String s;
		int n;
	

		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_global.get(0),"global_goal" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"local_goal" );
	}
}
