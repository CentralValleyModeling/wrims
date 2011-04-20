
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.FileParser;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class TestWreslWalker_element {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_dvarNonStd.wresl";
		logFilePath = "TestWreslWalker_element_dvarNonStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		//LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		LogUtils.fileSummary(walker.thisFileDataSet);
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_dvarStd.wresl";
		logFilePath = "TestWreslWalker_element_dvarStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.closeLogFile();
		
		
		String fileText = Tools.readFileAsString(logFilePath);
		int redefineErrs = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: c_banks");
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(redefineErrs, 1);
		Assert.assertEquals(totalErrs, 1);		
	}
	
	@Test(groups = { "WRESL_elements" })
	public void svarDSS() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_svarDSS.wresl";
		logFilePath = "TestWreslWalker_element_svarDSS.log";
		csvFolderPath = "TestWreslWalker_element_svarDSS";

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
//		Map<String, Svar> svMap = sd.getModelDataSetMap().get(modelName).svMap;
//		ArrayList<String> svList = sd.getModelDataSetMap().get(modelName).svList;
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\timeseries.csv");	

		int r1 = RegUtils.timesOfMatches(csvText, "complex.+ud_ccwd.+demand-cvp.+taf.+cfs");
		Assert.assertEquals(r1, 1);	
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).tsList_global.get(0),"simple" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).tsList_local.get(0),"complex" );
	}
	
	@Test(groups = { "WRESL_elements" })
	public void svarConst() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_svarConst.wresl";
		logFilePath = "TestWreslWalker_element_svarConst.log";
		csvFolderPath = "TestWreslWalker_element_svarConst";

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

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error: State variable redefined");
		Assert.assertEquals(totalErrs, 1);	
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\svar.csv");	

		int r1 = RegUtils.timesOfMatches(csvText, "minflow_c_orovl.+\\.29");
		Assert.assertEquals(r1, 1);	
	}
	@Test(groups = { "WRESL_elements" })
	public void svarExpression1() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_svarExpression1.wresl";
		logFilePath = "TestWreslWalker_element_svarExpression1.log";
		csvFolderPath = "TestWreslWalker_element_svarExpression1";

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
		
		s = "division_test#(a_orovl_forward-a_orovl_back)/(100*max(0.01;s_orovl(-1)))";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s);
		Assert.assertEquals(n, 1);

		s = "min_test#min(max(a;b);2.5)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s);
		Assert.assertEquals(n, 1);		
	}
	@Test(groups = { "WRESL_elements" })
	public void svarSum() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_element_svarSum.wresl";
		logFilePath = "TestWreslWalker_element_svarSum.log";
		csvFolderPath = "TestWreslWalker_element_svarSum";

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
		
		s = "oroinfest#(i=0;sep-month;1) max(i_orovl(i);dummy)*cfs_taf(i)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}
	@Test(groups = { "WRESL_elements" })
	public void svarTable() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_element_svarTable";
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
	
		s = "multi_where#select target from res_level where res_num=1;level=4;month=month";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "simple#select target from feather_fish_203 where month=nov";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_global.get(0),"simple" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_local.get(0),"multi_where" );
	}
	
	@Test(groups = { "WRESL_elements" })
	public void svarTableFull() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_element_svarTableFull";
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
	
		s = "full_table#select area from res_info given storage=1000*s_orovl(-1) use linear where res_num=6;somevalue=7";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}
	@Test(groups = { "WRESL_elements" })
	public void alias() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_element_alias";
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
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\alias.csv");	
		
		String s;
		int n;
	
		s = "alias_global,flow-channel,cfs,c_sacfea+d_sacfea";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "alias_local,..,cfs,d419_swp[monthlyweighted5]";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asList_global.get(0),"alias_global" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asList_local.get(0),"alias_local" );
	}
	@Test(groups = { "WRESL_elements" })
	public void weightTable() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_element_weightTable";
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
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\weight.csv");	
		
		String s;
		int n;
	
		s = "alias_global,flow-channel,cfs,C_SacFea+D_SacFea";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		

		
		//Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asList_global.get(0),"alias_global" );
		//Assert.assertEquals(sd.getModelDataSetMap().get(modelName).asList_local.get(0),"alias_local" );
	}
}
