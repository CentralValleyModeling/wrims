
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
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void svar_const() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_svar_const";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error: State variable redefined");
		Assert.assertEquals(totalErrs, 1);	
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\"+modelName+"\\svar.csv");	
	
		int r1 = RegUtils.timesOfMatches(csvText, "minflow_c_orovl.+\\.29");
		Assert.assertEquals(r1, 1);	
	}

	@Test(groups = { "WRESL_elements" })
	public void svar_expression() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_svar_expression";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);	
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");	
	
		String s;
		int n;
		
		s = "division_test##(a_orovl_forward-a_orovl_back)/(100*max(0.01;s_orovl(-1)))";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s);
		Assert.assertEquals(n, 1);
	
		s = "min_test##min(max(a;b);2.5)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s);
		Assert.assertEquals(n, 1);		
	}

	@Test(groups = { "WRESL_elements" })
	public void svar_case() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_svar_case";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");	
		
		String s;
		int n;
	
		s ="svar_global,##,case1,1,month>=jan .and. month<=feb .and. sri_ytp==5 .and. c_nimbus_fmp_mif(-1)<800.,select feb from sacramento_runoff where wateryear=wateryear";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "svar_global,##,case2,2,always,300.0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "svar_local,##,mar_sep,1,month>=mar .and. month<=sep,sum(i=-(month-may);sep-month) i_folsm(i)*cfs_taf(i)+i300(i)*cfs_taf(i)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "svar_local,##,other,2,always,min(max(i_folsm(i);200);i300(i))";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_global.get(0),"svar_global" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_local.get(0),"svar_local" );
	}

	@Test(groups = { "WRESL_elements" })
	public void svar_sum() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_svar_sum";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 4);	
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\"+modelName+"\\svar.csv");	
	
		String s;
		int n;
		
		s = "s1,##,default,1,always,sum(i=0;sep-month;1) max(i_orovl(i);dummy)*cfs_taf(i),dummy;i_orovl;";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s);
		Assert.assertEquals(n, 1);
	
		s = "s2,##,default,1,always,sum(i=int(-daysinprevmo);-1;1) i1(i)*cfs_taf,daysinprevmo;i1;,";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s);
		Assert.assertEquals(n, 1);		
	}

	@Test(groups = { "WRESL_elements" })
	public void svar_table() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_svar_table";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath, true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);	
		
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");	
		
		String s;
		int n;
	
		s = "multi_where##select target from res_level where res_num=1;level=4;month=month";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
		s = "simple##select target from feather_fish_203 where month=nov";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}

	@Test(groups = { "WRESL_elements" })
	public void svar_tableFull() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_svar_tableFull";
		csvFolderPath = "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
	
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");	
		
		String s;
		int n;
	
		s = "full_table##select area from res_info given storage=1000*s_orovl_extern(-1) use linear where res_num=6;somevalue=7";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}
}
