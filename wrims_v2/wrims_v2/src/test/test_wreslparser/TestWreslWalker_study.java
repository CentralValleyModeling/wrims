
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class TestWreslWalker_study {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_elements" })
	public void svTsDv() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_study_svTsDv";
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
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList.get(0),"svar" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).dvList.get(0),"dvar" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).tsList.get(0),"ts" );

		
		Set<String> s;
		Set<String> e;
		
		s = new HashSet<String>();
		s.addAll(sd.getModelDataSetMap().get(modelName).svTsDvList);
		e = new HashSet<String>();
		e.add("svar"); e.add("dvar"); e.add("ts");
		
		Assert.assertEquals(s,e);

		
		s = new HashSet<String>();
		s.addAll(sd.getModelDataSetMap().get(modelName).svTsList);
		e = new HashSet<String>();
		e.add("svar"); e.add("ts");
		
		Assert.assertEquals(s,e);
		
	}

	@Test(groups = { "WRESL_elements" })
	public void timeseries() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_study_timeseries";
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
		
		/// write full study data to csv files
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
		
		Set<String> s;
		Set<String> e;
		
		s = new HashSet<String>();
		s.addAll(sd.getTimeseriesMap().keySet());
		e = new HashSet<String>();
		e.add("first_global"); e.add("first_local"); e.add("second_local");e.add("third_global");
		
		Assert.assertEquals(s,e);
	}

	@Test(groups = { "WRESL_elements" })
	public void order() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_study_order";
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
		
		ArrayList<String> s;
		ArrayList<String> e;
		

		s = sd.getModelDataSetMap().get(modelName).tsList;
		
		System.out.println("sssss "+s);

		e = new ArrayList<String>();
		e.add("zero"); 
		
		e.add("first1_include1"); 
		e.add("first2_include1"); 

		e.add("second1_include2"); 
		e.add("second2_include2_include"); 
		e.add("second3_include2_include");
		e.add("second4_include2");	
		
		e.add("third"); 
		
		Assert.assertEquals(s,e);
	
		

		
	}

	@Test(groups = { "WRESL_elements" })
	public void order_simple() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_study_order_simple";
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
		
		ArrayList<String> s;
		ArrayList<String> e;
		
	
		s = sd.getModelDataSetMap().get(modelName).tsList;
		
		System.out.println("sssss "+s);
	
		e = new ArrayList<String>();

		e.add("first1_include1"); 
		e.add("first2_include1"); 
		e.add("second1_include2"); 
		e.add("second2_include2_include"); 
		e.add("second3_include2_include");
		e.add("second4_include2");		
		Assert.assertEquals(s,e);
	
		
	
		
	}
}
