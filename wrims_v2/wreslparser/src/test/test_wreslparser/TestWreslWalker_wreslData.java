
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
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.TempData;

public class TestWreslWalker_wreslData {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;		

	@Test(groups = { "WRESL_elements" })
	public void dvar1() throws RecognitionException, IOException {
		
		inputFilePath =projectPath+"TestWreslWalker_wreslData_dvar1.wresl";
		logFilePath = "TestWreslWalker_wreslData_dvar1.log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 

		LogUtils.studySummary_details(sd);

		LogUtils.closeLogFile();
			
		String fileText = Tools.readFileAsString(logFilePath);	

		int correct = RegUtils.timesOfMatches(fileText, "Model second watch_this .+this-is-correct");
		Assert.assertEquals(correct, 1);

		int wrong = RegUtils.timesOfMatches(fileText, "Model second watch_this .+this-should-not-exist-in-model-second");
		Assert.assertEquals(wrong, 0);
		
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(totalErrs, 1);	
		
		int Errs = RegUtils.timesOfMatches(fileText, "# Error: Decision varriable redefined: watch_this in files: ");
		Assert.assertEquals(Errs, 1);			

		int str1 = RegUtils.timesOfMatches(fileText, 
				"Model second Include total 5 Dvars:");
		Assert.assertEquals(str1, 1);
	}	
}
