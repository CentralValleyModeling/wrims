
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

public class TestWreslWalker_dependantInCycles {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void svarExpr() throws RecognitionException, IOException {
	// deep embedding of alias
		
		testName = "TestWreslWalker_dependentInCycles_svarExpr";
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
		StudyParser.analyzeVarNeededFromCycles(sc, sd);
	
		LogUtils.closeLogFile();
		
		
		WriteCSV.study(sd, csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
		String csvText;
		String s;
		int n;
	
		csvText = Tools.readFileAsString(csvFolderPath+"\\second\\svar.csv");
		
		s = "sv_expr1##x[first];";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);			

		s = "sv_expr2##x[first];";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	
		
		s = "sv_expr3##x[first];";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);	

	}
}
