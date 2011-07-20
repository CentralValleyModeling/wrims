
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

public class TestWreslWalker_error {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_elements" })
	public void redefine2() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_error_redefine2";
		inputFilePath = projectPath+csvFolderPath+".wresl";
		logFilePath = csvFolderPath+".log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,false,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 

		LogUtils.studySummary_details(sd);

		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 14);	
		
		Assert.assertEquals(StudyParser.total_errors, 14);	
		
		Assert.assertEquals(sd.getModelDataSetMap().get("second").tsMap.get("ts").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv").caseExpression.get(0),"second_model_only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv2").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv2").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").asMap.get("as").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").gMap.get("gl").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("tab").dependants.toString(),"[second_model_only]" );
		//		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"a2" );

	}

	@Test(groups = { "WRESL_elements" })
	public void redefine_global() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_error_redefine_global";
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
		
		//String modelName = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 13);	
		Assert.assertEquals(StudyParser.total_errors, 13);


	
	}

	@Test(groups = { "WRESL_elements" })
	public void redefine() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_error_redefine";
		inputFilePath = projectPath+csvFolderPath+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,false,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 22);	
		
		Assert.assertEquals(StudyParser.total_errors, 22);
		
		Assert.assertEquals(sd.getModelDataSetMap().get("second").tsMap.get("ts").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv").caseExpression.get(0),"second_model_only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv2").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv2").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").asMap.get("as").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").gMap.get("gl").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("tab").dependants.toString(),"[second_model_only]" );
		//		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"a2" );
	
	}	
}
