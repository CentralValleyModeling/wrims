
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
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class TestWreslWalker {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;

	@Test(groups = { "WRESL_elements" })
	public void test2() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_test2.wresl";
		logFilePath = "TestWreslWalker_test2.log";
		
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
	public void mainFile() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_mainFile.wresl";
		logFilePath = "TestWreslWalker_mainFile.log";
		
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
		
		inputFilePath =projectPath+"TestWreslWalker_dvarsAndIncludes.wresl";
		logFilePath = "TestWreslWalker_dvarsAndIncludes.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		
		LogUtils.fileSummary(walker.mainDataSet);
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);
		
		int incFiles = RegUtils.timesOfMatches(fileText, "Include total 2 files:");
		Assert.assertEquals(incFiles, 1);

		int globalFiles = RegUtils.timesOfMatches(fileText, "Include total 1 global files:");
		Assert.assertEquals(globalFiles, 1);

		int localFiles = RegUtils.timesOfMatches(fileText, "Include total 1 local files:");
		Assert.assertEquals(localFiles, 1);
		
		int dvars = RegUtils.timesOfMatches(fileText, "Include total 3 Dvars:");
		Assert.assertEquals(dvars, 1);

		int globalDvars = RegUtils.timesOfMatches(fileText, "Include total 2 global Dvars:");
		Assert.assertEquals(globalDvars, 1);
		
		int localDvars = RegUtils.timesOfMatches(fileText, "Include total 1 local Dvars:");
		Assert.assertEquals(localDvars, 1);		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void mainFile2() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_mainFile2.wresl";
		logFilePath = "TestWreslWalker_mainFile2.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.mainFileSummary(walker.mainDataSet, walker.modelDataMap);
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 2);	
		
		int undefinedModelErrs = RegUtils.timesOfMatches(fileText, "# Error: Sequence has undefined models:");
		Assert.assertEquals(undefinedModelErrs, 2);	
	}		

	@Test(groups = { "WRESL_elements" })
	public void parseSubFiles() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_parseSubFiles.wresl";
		logFilePath = "TestWreslWalker_parseSubFiles.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		LogUtils.mainFileSummary(walker.mainDataSet, walker.modelDataMap);
		
		
		for (String key : walker.mainDataSet.model_list){
			
			for (String subFile : walker.modelDataMap.get(key).incFileList){
			
				WreslTreeWalker sw = FileParser.parseFile(subFile);
			
				LogUtils.fileSummary(sw.mainDataSet);
				
			}
		}
		
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 2);	

		int redefErrs1 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: C_Banks");
		Assert.assertEquals(redefErrs1, 1);
		
		int redefErrs2 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: C_SacFea");
		Assert.assertEquals(redefErrs2, 1);	
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void studyParser_sortSeq() throws RecognitionException {
		
		inputFilePath =projectPath+"TestWreslWalker_studyParser_sortSeq.wresl";
		logFilePath = "TestWreslWalker_studyParser_sortSeq.log";
		
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
		
		StudyConfig sc=null;
		
		try {
			sc=StudyParser.processMainFileIntoStudyConfig(absFilePath);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		LogUtils.mainFileSummary(sc);
		
		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	

		int seq1 = RegUtils.timesOfMatches(fileText, "Sequence: 4 : CYCLE2   Model: empty");
		Assert.assertEquals(seq1, 1);
		
		int seq2 = RegUtils.timesOfMatches(fileText, "Sequence: 15 : CYCLE1   Model: first");
		Assert.assertEquals(seq2, 1);
	}	

	@Test(groups = { "WRESL_elements" })
	public void mainFile3() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_mainFile3.wresl";
		logFilePath = "TestWreslWalker_mainFile3.log";
		
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
	
	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_dvarNonStd.wresl";
		logFilePath = "TestWreslWalker_dvarNonStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		//LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		LogUtils.fileSummary(walker.mainDataSet);
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_dvarStd.wresl";
		logFilePath = "TestWreslWalker_dvarStd.log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		LogUtils.importantMsg("tree = " + walker.commonTree.toStringTree());
		
		LogUtils.closeLogFile();
		
		
		String fileText = Tools.readFileAsString(logFilePath);
		int redefineErrs = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: C_Banks");
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(redefineErrs, 1);
		Assert.assertEquals(totalErrs, 1);		
	}	
		
}
