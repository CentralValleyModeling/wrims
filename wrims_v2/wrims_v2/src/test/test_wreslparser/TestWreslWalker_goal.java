
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
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

public class TestWreslWalker_goal {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void simple() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_simple";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
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
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 6);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		s = "c_slcvp##c5_wts=c5_wts_stg1";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "semicolon,##default,1,always,b<max(a;c)+min(d;e)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

	}	
	
	@Test(groups = { "WRESL_elements" })
	public void noCase() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_noCase";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
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
		Assert.assertEquals(totalErrs, 10);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;

		s = "goal_3,##default,1,always,x-surplus__goal_3_1+slack__goal_3_1=y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "goal_4,default,1,always,x-surplus_goal_4_default<y+z";
		s = "goal_4,##default,1,always,x-surplus__goal_4_1<y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "goal_2,default,1,always,x+slack_goal_2_default=y+z";
		s = "goal_2,##default,1,always,x+slack__goal_2_1=y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "goal_1,default,1,always,x+slack_goal_1_default=y+z";
		s = "goal_1,##default,1,always,x+slack__goal_1_1=y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "goal_5,##default,1,always,x>y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "goal_6,default,1,always,x-surplus_goal_6_default=y+z";
		s = "goal_6,##default,1,always,x-surplus__goal_6_1=y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "goal_7,##default,1,always,x<y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "goal_8,##default,1,always,x=y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "goal_9,##default,1,always,x=y+z";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);		
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\weight.csv");	
	
		//s = "slack_goal_1_default,-500.0";
		s = "slack__goal_1_1,##always,-500.0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "slack_goal_2_default,-600.0";
		s = "slack__goal_2_1,##always,-600.0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "surplus_goal_4_default,-99";
		s = "surplus__goal_4_1,##always,-99";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "slack_goal_4_default,-0";
		s = "slack__goal_4_1,##always,-0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 0);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void goal_case() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
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
		Assert.assertEquals(totalErrs, 2);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		//s = "global_goal,actionon,1,int(b2on)==1,c3_m+slack_global_goal_actionon=minflow_c";
		s = "global_goal,##actionon,1,int(b2on)==1,c3_m+slack__global_goal_1=minflow_c";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "global_goal,##actionoff,2,int(b2on)==0,c3_m<clear_min";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\weight.csv");	
	
		//s = "slack_global_goal_actionon,-700.";
		s = "slack__global_goal_1,##-700.";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "slack_global_goal_actionoff,-0";
		s = "slack__global_goal_2,##-0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 0);

		//s = "slack_local_goal_case1,-700.";
		s = "slack__local_goal_1,##-(pp)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "surplus_local_goal_case2,-10";
		s = "surplus__local_goal_2,##-10";		
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_global.get(0),"global_goal" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"local_goal" );
	}
	@Test(groups = { "WRESL_elements" })
	public void goal_case2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case2";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
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
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		//s = "global_goal,actionon,1,.not.(range(month;oct;dec) .and. month>=may),c3_m+slack_global_goal_actionon=minflow_c";
		s = "global_goal,##actionon,1,.not.(range(month;oct;dec) .and. month>=may),c3_m+slack__global_goal_1=minflow_c";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "local_goal,case1,1,min(200.;qwe_r)>max(x3;y4),x+slack_local_goal_case1=y";
		s = "local_goal,##case1,1,min(200.;qwe_r)>max(x3;y4),x+slack__local_goal_1=y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\weight.csv");	

		//s = "slack_global_goal_actionon,-700.";
		s = "slack__global_goal_1,##-700.";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "slack_local_goal_case1,-max(a;b)";
		s = "slack__local_goal_1,##-(max(a;b))";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "slack_local_goal_case1,-max(a;b)";
		s = "slack__double_negation_1,##-(-max(a;b)+1)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");	

		//s = "slack_global_goal_actionoff,0,upper_unbounded,n,undefined,slack";
		s = "slack__global_goal_2,##0,upper_unbounded,n,undefined,slack";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 0);

		//s = "slack_local_goal_case2,0,upper_unbounded,n,undefined,slack";
		s = "slack__local_goal_2,##0,upper_unbounded,n,undefined,slack";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 0);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_global.get(0),"global_goal" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"local_goal" );
	}
	@Test(groups = { "WRESL_elements" })
	public void goal_case3() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case3";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);	
		

		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_global.get(0),"global_goal" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"local_goal" );
	}
	@Test(groups = { "WRESL_elements" })
	public void goal_case4() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case4";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
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
		Assert.assertEquals(totalErrs, 1);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		s = "compute_rain_rel,##initialize,1,month==sep .and. wateryear==1921,fr_rain_rel=0.0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

	}

	@Test(groups = { "WRESL_elements" })
	public void goal_case5() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case5";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		s = "withcase,##actionon,1,int(b2action2on)==1,x=y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "nocase,##default,1,always,x=y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}

	@Test(groups = { "WRESL_elements" })
	public void goal_case6() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case6";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		s = "withcase,##actionon,1,v==1,x<y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
		s = "nocase,##default,1,always,x>y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}

	@Test(groups = { "WRESL_elements" })
	public void goal_case7() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case7";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 8);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		//s = "g_pp##x-surplus_g_pp_default+slack_g_pp_default=y";
		s = "g_pp##x-surplus__g_pp_1+slack__g_pp_1=y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
		//s = "g_pc##x-surplus_g_pc_default=y";
		s = "g_pc##x-surplus__g_pc_1=y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "g_cp##x+slack_g_cp_default=y";
		s = "g_cp##x+slack__g_cp_1=y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "g_fp##x+slack_g_fp_default>y";
		s = "g_fp##x+slack__g_fp_1>y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "g_pf##x-surplus_g_pf_default<y";
		s = "g_pf##x-surplus__g_pf_1<y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "g_fc##x>y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "g_cf##x<y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "g_cc##x=y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		
		// weight 
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\weight.csv");
		
		//s = "surplus_g_pp_default,-99";
		s = "surplus__g_pp_1,##-99";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "slack_g_pp_default,-11";
		s = "slack__g_pp_1,##-11";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		//s = "surplus_g_pc_default,-99";
		s = "surplus__g_pc_1,##-99";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "slack_g_cp_default,-11";
		s = "slack__g_cp_1,##always,-11";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "slack_g_fp_default,-11";
		s = "slack__g_fp_1,##always,-11";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		//s = "surplus_g_pf_default,-99";
		s = "surplus__g_pf_1,##always,-99";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
	}

	@Test(groups = { "WRESL_elements" })
	public void goal_var_unknown() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_var_unknown";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);	
				
		String s;
		int n;
	
		s = "# Error: ##variable names used before definition: [x] in Goal named [g_pp]";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(logText, s );
		Assert.assertEquals(n, 1);

		s = "# Error: ##variable names used before definition: [y, x] in Goal named [g_pp]";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(logText, s );
		Assert.assertEquals(n, 1);
		
	}

	@Test(groups = { "WRESL_elements" })
	public void goal_case8() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case8";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);	

		
	}

	@Test(groups = { "WRESL_elements" })
	public void goal_case9() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_goal_case9";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
	
		
	}
}
