
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

public class TestWreslWalker_alias {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void alias_to_goal() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_alias_to_goal";
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
	
		//LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		s = "exportactual__alias##exportactual=d_jones+d_banks";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		
		// confirm that the item is removed from alias
		
		File as_file = new File(csvFolderPath + "\\first\\alias.csv");

		if (as_file.exists()) {
			csvText = Tools.readFileAsString(csvFolderPath + "\\first\\alias.csv");

			s = "exportactual";
			s = Tools.replace_regex(s);
			n = RegUtils.timesOfMatches(csvText, s);
			Assert.assertEquals(n, 0);

		}
		
		// check if dv has the item
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");
		
		s = "exportactual,##,always,lower_unbounded,upper_unbounded,n,cfs,export-prj";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);		
		
		// weight 
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\weight.csv");
		
		//s = "surplus_export_sjrir_comply_eisjr_udef,-999999";
		s = "surplus__export_sjrir_comply_1,##-999999";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		

		
	}

	@Test(groups = { "WRESL_elements" })
	public void alias_to_goal2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_alias_to_goal2";
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
	
		//LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 6);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\second\\constraint.csv");	
		
		String s;
		int n;
	
		s = "zz__alias##zz=x+y";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
		
		// confirm that the item is removed from alias list or set?
		
		File as_file = new File(csvFolderPath + "\\second\\alias.csv");
	
		if (as_file.exists()) {
			csvText = Tools.readFileAsString(csvFolderPath + "\\first\\alias.csv");
	
			s = "zz";
			s = Tools.replace_regex(s);
			n = RegUtils.timesOfMatches(csvText, s);
			Assert.assertEquals(n, 0);
	
		}
		
		// check if dv has the item
		csvText = Tools.readFileAsString(csvFolderPath+"\\second\\dvar.csv");
		
		s = "zz,##always,lower_unbounded,upper_unbounded,n,cfs,alias";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);		
		
		// weight 
		csvText = Tools.readFileAsString(csvFolderPath+"\\second\\weight.csv");
		
		//s = "surplus_goal_1_case1,-999999";
		s = "surplus__goal_1_1,##-999999";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
	
		
	}

	@Test(groups = { "WRESL_elements" })
	public void alias_to_goal3() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_alias_to_goal3";
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
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 6);	
				
	}

	@Test(groups = { "WRESL_elements" })
	public void alias_to_goal4() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_alias_to_goal4";
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
	
		//LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		

		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\constraint.csv");	
		
		String s;
		int n;
	
		s = "a1__alias##a1=dv";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		// confirm that the item is removed from alias list or set?
		
		File as_file = new File(csvFolderPath + "\\first\\alias.csv");
	
		if (as_file.exists()) {
			csvText = Tools.readFileAsString(csvFolderPath + "\\first\\alias.csv");
	
			s = "a1";
			s = Tools.replace_regex(s);
			n = RegUtils.timesOfMatches(csvText, s);
			Assert.assertEquals(n, 0);
	
		}
		
		// check if dv has the item
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");
		
		s = "a1,##always,lower_unbounded,upper_unbounded,n,cfs,net-dicu";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);			
	}

	@Test(groups = { "WRESL_elements" })
	public void alias_unknown() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_alias_unknown";
		csvFolderPath = "testResult\\"+testName;
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
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
		String csvText;
		String s;
		int n;

		
		// check if dependents has the item
		csvText = Tools.readFileAsString(csvFolderPath+"\\first\\svar.csv");
		
		s = "cfs_cfmp,##default,1,always,daysindv(-1)*86400.0+x,daysindv;x;";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);			
	}

	@Test(groups = { "WRESL_elements" })
	public void alias_to_goal5_typeRedefined() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_alias_to_goal5_typeRedefined";
		csvFolderPath = "testResult\\"+testName;
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
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 7);	
		
		int err = RegUtils.timesOfMatches(logText, "# Error: Variable is redefined as different type: zz");
		Assert.assertEquals(totalErrs, 7);	
				
	}

	@Test(groups = { "WRESL_elements" })
	public void alias_to_goal6() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_alias_to_goal6";
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
	
		//LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		
	}

	@Test(groups = { "WRESL_elements" })
	public void alias_to_goal7() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_alias_to_goal7";
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
	
		//LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		
	}

	@Test(groups = { "WRESL_elements" })
	public void alias() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_alias";
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
	
		//LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		
	}

	@Test(groups = { "WRESL_elements" })
	public void alias2() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_alias2";
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
	
		//LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		
	}
}
