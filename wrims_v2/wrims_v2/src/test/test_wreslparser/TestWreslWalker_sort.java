
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

public class TestWreslWalker_sort {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_elements" })
	public void simple() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_sort_simple";
		inputFilePath = projectPath+csvFolderPath+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
		
		Set<String> s;
		
		s = sd.getModelDataSetMap().get(modelName).svMap.get("value_1").dependants;		
		Assert.assertEquals(s.size(),1);

		s = sd.getModelDataSetMap().get(modelName).svMap.get("value_2").dependants;		
		Assert.assertEquals(s.size(),2);

		s = sd.getModelDataSetMap().get(modelName).svMap.get("table_2").dependants;		
		Assert.assertEquals(s.size(),2);
		
		s = sd.getModelDataSetMap().get(modelName).svMap.get("case_2").dependants;		
		Assert.assertEquals(s.size(),2);
		
		s = sd.getModelDataSetMap().get(modelName).svMap.get("case_3").dependants;		
		Assert.assertEquals(s.size(),3);
		
		s = sd.getModelDataSetMap().get(modelName).svMap.get("sum_1").dependants;		
		Assert.assertEquals(s.size(),1);
	
	
	}

	@Test(groups = { "WRESL_elements" })
	public void case2() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_sort_case2";
		inputFilePath = projectPath+csvFolderPath+".wresl";
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
		
		String modelName = sd.getModelList().get(1);
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
		
		System.out.println("#### orderList: "+sd.getModelDataSetMap().get(modelName).svList);
		
		ArrayList<String> e = new ArrayList<String>();
		e.add("z_1"); e.add("b_2"); e.add("a_3");e.add("b_3");e.add("c_3");e.add("sum_3"); e.add("a_4"); e.add("error_1"); e.add("error_2");
		
		System.out.println(sd.getModelDataSetMap().get(modelName).svList);
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList, e);
		
		Set<String> es = new HashSet<String>();
		es.add("error_1");es.add("error_2");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svSet_unknown, es);		
		
	
	}

	@Test(groups = { "WRESL_elements" })
	public void case1() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_sort_case1";
		inputFilePath = projectPath+csvFolderPath+".wresl";
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
		Assert.assertEquals(totalErrs, 1);		
		
		System.out.println("#### orderList: "+sd.getModelDataSetMap().get(modelName).svList);
		
		ArrayList<String> e = new ArrayList<String>();
		e.add("z_1"); e.add("b_2"); e.add("sum_3"); e.add("a_4"); e.add("error_1");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList, e);
		
		Set<String> es = new HashSet<String>();
		es.add("error_1");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svSet_unknown, es);		
		
	
	}

	@Test(groups = { "WRESL_elements" })
	public void global_redefine() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_sort_global_redefine";
		inputFilePath = projectPath+csvFolderPath+".wresl";
		logFilePath = csvFolderPath+".log";
	
		Param.debug = true;
		
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath,true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,true,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 4);		

		int n = RegUtils.timesOfMatches(logText, "Warning: Variables type of sv: Svar");
		Assert.assertEquals(n, 2);	
		
		n = RegUtils.timesOfMatches(logText, "Warning: Variables type of sv: Alias");
		Assert.assertEquals(n, 1);	
		
	
		
	
	}

	@Test(groups = { "WRESL_elements" })
	public void alias() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_sort_alias";
		inputFilePath = projectPath+csvFolderPath+".wresl";
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
		
		String modelName = sd.getModelList().get(1);
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 4);		
		
		System.out.println("#### orderList: "+sd.getModelDataSetMap().get(modelName).asList);
		
		ArrayList<String> e = new ArrayList<String>();
		e.add("b_alias_1"); e.add("a_alias_2"); e.add("error_1");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asList, e);
		
		Set<String> es = new HashSet<String>();
		es.add("error_1");
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asSet_unknown, es);		
		
	
	}
}
