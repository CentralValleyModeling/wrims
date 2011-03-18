
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.wreslparser.elements.GlobalData;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.SimulationDataSet;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.Tools;

public class TestWreslWalker_advanced {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;		

	@Test(groups = { "WRESL_elements" })
	public void studyParser1() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_advanced_studyParser1.wresl";
		logFilePath = "TestWreslWalker_advanced_studyParser1.log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyConfig sc=null;	

		sc=StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		LogUtils.mainFileSummary(sc);
		
		Map<String, SimulationDataSet> model_data_complete_map = new HashMap<String, SimulationDataSet>();
		
		model_data_complete_map =	StudyParser.parseSubFiles(sc);
		

		LogUtils.mainFileSummary(sc, model_data_complete_map);

		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 3 Dvars:");
		Assert.assertEquals(str1, 1);

		int str2 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 2 global Dvars:");
		Assert.assertEquals(str2, 1);

	}		
	
	@Test(groups = { "WRESL_elements" })
	public void studyParser2() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_advanced_studyParser2.wresl";
		logFilePath = "TestWreslWalker_advanced_studyParser2.log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		//StudyConfig sc=null;	

		GlobalData.studyConfig=StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		LogUtils.mainFileSummary(GlobalData.studyConfig);
		
		Map<String, SimulationDataSet> model_data_complete_map = new HashMap<String, SimulationDataSet>();
		
		model_data_complete_map =	StudyParser.parseSubFiles(GlobalData.studyConfig);
		

		LogUtils.mainFileSummary(GlobalData.studyConfig, model_data_complete_map);

		
		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 5 Dvars:");
		Assert.assertEquals(str1, 1);

		int str2 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 2 global Dvars:");
		Assert.assertEquals(str2, 1);

	}	
	
}
