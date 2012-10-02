
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import test.test_wreslplus.TestParam;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_order {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void gobalVars() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_order_globalVars";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath,true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		String modelName1 = sd.getModelList().get(0);
		String modelName2 = sd.getModelList().get(1);
		String modelName3 = sd.getModelList().get(2);
		
		WriteCSV.study(sd,csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
		
		//System.out.println("#### orderList: "+sd.getModelDataSetMap().get(modelName).asList);
		
		ArrayList<String> e = new ArrayList<String>();
		e.add("sv3"); e.add("sv1"); e.add("sv2"); e.add("sv4"); e.add("global");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName1).svList_global, e);
		
		e = new ArrayList<String>();
		e.add("sv3"); e.add("sv1"); e.add("sv2"); e.add("sv4"); e.add("global"); e.add("sv5"); e.add("sv6");
		System.out.println(sd.getModelDataSetMap().get(modelName2).svList);
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName2).svList, e);		
		
		e = new ArrayList<String>();
		e.add("sv3"); e.add("sv1"); e.add("sv2"); e.add("sv4"); e.add("global"); e.add("sv5"); e.add("sv6"); e.add("sv7"); e.add("sv8");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName3).svList, e);		
	}

	@Test(groups = { "WRESL_elements" })
	public void alias() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_order_alias";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath,true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,true,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
		
		//System.out.println("#### orderList: "+sd.getModelDataSetMap().get(modelName).asList);
		
		ArrayList<String> e = new ArrayList<String>();
		e.add("here"); //e.add("a_alias_2"); e.add("error_1");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asList, e);
		
		Set<String> es = new HashSet<String>();
		es.add("here");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asSet_unknown, es);		
		
	
	}
}
