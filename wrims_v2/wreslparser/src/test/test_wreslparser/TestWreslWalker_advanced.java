
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


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
		Assert.assertEquals(totalErrs, 2);	

		int err1 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: C_Banks");
		Assert.assertEquals(err1, 1);
		
		int err2 = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: C_SacFea");
		Assert.assertEquals(err2, 1);
	}		
	
}
