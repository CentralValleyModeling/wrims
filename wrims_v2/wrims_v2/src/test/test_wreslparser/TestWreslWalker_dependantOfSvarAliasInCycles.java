
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

public class TestWreslWalker_dependantOfSvarAliasInCycles {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void svarExpr() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependantOfSvarAliasInCycles_svarExpr";
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
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
	
		LogUtils.closeLogFile();
		
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
		String csvText;
		String s;
		String cycleName;
		int n;

		cycleName = "first";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));

		s = "c##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("c").keySet().contains(cycleName));
		} catch (Exception e){}
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_1").keySet().contains(cycleName));
		
		cycleName = "second";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));
		} catch (Exception e){}		

		s = "sv_2##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_2").keySet().contains(cycleName));
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_2_global##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));

		cycleName = "third";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "int_3##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("int_3").keySet().contains(cycleName));
		
		s = "dv_2_global##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));
		} catch (Exception e){}	

	}

	@Test(groups = { "WRESL_elements" })
	public void svarSum() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependantOfSvarAliasInCycles_svarSum";
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
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
	
		LogUtils.closeLogFile();
		
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
		String csvText;
		String s;
		String cycleName;
		int n;

		cycleName = "first";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));

		s = "c##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("c").keySet().contains(cycleName));
		} catch (Exception e){}
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_1").keySet().contains(cycleName));
		
		cycleName = "second";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));
		} catch (Exception e){}		

		s = "sv_2##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_2").keySet().contains(cycleName));
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_2_global##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));

		cycleName = "third";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "int_3##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("int_3").keySet().contains(cycleName));
		
		s = "dv_2_global##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));
		} catch (Exception e){}	
	
	}

	@Test(groups = { "WRESL_elements" })
	public void svarTable() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependantOfSvarAliasInCycles_svarTable";
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
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
	
		LogUtils.closeLogFile();
		
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
		String csvText;
		String s;
		String cycleName;
		int n;

		cycleName = "first";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));

		s = "c##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("c").keySet().contains(cycleName));
		} catch (Exception e){}
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_1").keySet().contains(cycleName));
		
		cycleName = "second";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));
		} catch (Exception e){}		

		s = "sv_2##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_2").keySet().contains(cycleName));
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_2_global##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));

		cycleName = "third";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "int_3##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("int_3").keySet().contains(cycleName));
		
		s = "dv_2_global##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));
		} catch (Exception e){}	
	
	}

	@Test(groups = { "WRESL_elements" })
	public void svarCase() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependantOfSvarAliasInCycles_svarCase";
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
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
	
		LogUtils.closeLogFile();
		
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
		String csvText;
		String s;
		String cycleName;
		int n;

		cycleName = "first";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));

		s = "c##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("c").keySet().contains(cycleName));
		} catch (Exception e){}
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_1").keySet().contains(cycleName));
		
		cycleName = "second";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));
		} catch (Exception e){}		

		s = "sv_2##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_2").keySet().contains(cycleName));
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_2_global##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));

		cycleName = "third";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "int_3##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("int_3").keySet().contains(cycleName));
		
		s = "dv_2_global##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));
		} catch (Exception e){}	
	
	}

	@Test(groups = { "WRESL_elements" })
	public void svarCase_conditions() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependantOfSvarAliasInCycles_svarCase_conditions";
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
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
	
		LogUtils.closeLogFile();
		
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
		String csvText;
		String s;
		String cycleName;
		int n;
	
		cycleName = "first";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));
	
		s = "c##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("c").keySet().contains(cycleName));
		} catch (Exception e){}
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_1").keySet().contains(cycleName));
		
		cycleName = "second";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));
		} catch (Exception e){}		
	
		s = "sv_2##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_2").keySet().contains(cycleName));
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_2_global##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));
	
		cycleName = "third";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "int_3##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("int_3").keySet().contains(cycleName));
		
		s = "dv_2_global##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));
		} catch (Exception e){}	
	
	}

	@Test(groups = { "WRESL_elements" })
	public void alias() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependantOfSvarAliasInCycles_alias";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath, true);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,false,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td);
		
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
	
		LogUtils.closeLogFile();
		
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
		String csvText;
		String s;
		String cycleName;
		int n;

		cycleName = "first";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));

		s = "c##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("c").keySet().contains(cycleName));
		} catch (Exception e){}
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_1##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_1").keySet().contains(cycleName));
		
		cycleName = "second";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\svar.csv");
		
		s = "sv_1##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("sv_1").keySet().contains(cycleName));
		} catch (Exception e){}		

		s = "sv_2##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	
		Assert.assertTrue(sd.getVarCycleValueMap().get("sv_2").keySet().contains(cycleName));
		
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "dv_2_global##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));

		cycleName = "third";
		csvText = Tools.readFileAsString(csvFolderPath+"\\"+cycleName+"\\dvar.csv");
		
		s = "int_3##true";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		Assert.assertTrue(sd.getVarCycleValueMap().get("int_3").keySet().contains(cycleName));
		
		s = "dv_2_global##false";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		try{
			Assert.assertTrue(!sd.getVarCycleValueMap().get("dv_2_global").keySet().contains(cycleName));
		} catch (Exception e){}	
	
	}
}
