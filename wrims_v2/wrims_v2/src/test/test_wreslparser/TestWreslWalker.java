
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.wreslparser.elements.FileParser;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class TestWreslWalker {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	

	@Test(groups = { "WRESL_elements" })
	public void mainFile() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_mainFile";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	
	}		

	@Test(groups = { "WRESL_elements" })
	public void dvarsAndIncludes() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_dvarsAndIncludes";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		
		LogUtils.fileSummary(walker.thisFileDataSet);
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 1);
		
		int incFiles = RegUtils.timesOfMatches(fileText, "Include total 2 files:");
		Assert.assertEquals(incFiles, 1);

		int globalFiles = RegUtils.timesOfMatches(fileText, "Include total 1 global files:");
		Assert.assertEquals(globalFiles, 1);

		int localFiles = RegUtils.timesOfMatches(fileText, "Include total 1 local files:");
		Assert.assertEquals(localFiles, 1);
		
		int dvars = RegUtils.timesOfMatches(fileText, "Include total 4 Dvars:"); // should be 3
		Assert.assertEquals(dvars, 1);

		int globalDvars = RegUtils.timesOfMatches(fileText, "Include total 3 global Dvars:"); //should be 2
		Assert.assertEquals(globalDvars, 1);
		
		int localDvars = RegUtils.timesOfMatches(fileText, "Include total 1 local Dvars:");
		Assert.assertEquals(localDvars, 1);		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void mainFile2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_mainFile2";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		//WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		LogUtils.mainFileSummary(sc);
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 2);	
		
		int undefinedModelErrs = RegUtils.timesOfMatches(fileText, "# Error: Sequence has undefined models:");
		Assert.assertEquals(undefinedModelErrs, 2);	
	}		

	@Test(groups = { "WRESL_elements" })
	public void parseSubFiles() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_parseSubFiles";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		LogUtils.mainFileSummary(sc);
		
		
		for (String key : walker.thisFileDataSet.model_list){
			
			for (String subFile : walker.modelDataMap.get(key).incFileList){
			
				WreslTreeWalker sw = FileParser.parseFile(subFile);
			
				LogUtils.fileSummary(sw.thisFileDataSet);
				
			}
		}
		
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 2);	

		int redefErrs1 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: c_banks");
		Assert.assertEquals(redefErrs1, 1);
		
		int redefErrs2 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: c_sacfea");
		Assert.assertEquals(redefErrs2, 1);	
	}		

	@Test(groups = { "WRESL_elements" })
	public void studyParser_subFiles() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_studyParser_subFiles";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile=null;
		String absFilePath=null;
		try {
			absFile = new File(inputFilePath).getAbsoluteFile();
			absFilePath = absFile.getCanonicalPath().toLowerCase();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LogUtils.setLogFile(logFilePath);

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		LogUtils.mainFileSummary(sc);
		
		TempData td = new TempData();

		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		LogUtils.studySummary(sc, td.model_dataset_map);

		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 3);	

		int err1 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: c_banks");
		Assert.assertEquals(err1, 1);
		
		int err2 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: c_sacfea");
		Assert.assertEquals(err2, 1);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void studyParser_sortSeq() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_studyParser_sortSeq";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile=null;
		String absFilePath=null;
		try {
			absFile = new File(inputFilePath).getAbsoluteFile();
			absFilePath = absFile.getCanonicalPath().toLowerCase();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LogUtils.setLogFile(logFilePath);
		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		LogUtils.mainFileSummary(sc);
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	

		int seq1 = RegUtils.timesOfMatches(fileText, "Sequence.+4.+cycle2.+empty");
		Assert.assertEquals(seq1, 1);
		
		int seq2 = RegUtils.timesOfMatches(fileText, "Sequence.+15.+cycle1.+first");
		Assert.assertEquals(seq2, 1);
	}	

	@Test(groups = { "WRESL_elements" })
	public void mainFile3() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_mainFile3";
		csvFolderPath = "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 1);	

		int orderErr = RegUtils.timesOfMatches(fileText, "# Error: line 17:0 missing EOF at \'SEQUENCE\'");
		Assert.assertEquals(orderErr, 1);	
		
	}	
		
}
