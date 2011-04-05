
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.wreslparser.elements.FileParser;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.SimulationDataSet;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class TestWreslWalker_calsim3 {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	

	
	@Test(groups = { "WRESL_Calsim3" })
	public void firstCycle() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_calsim3_firstCycle";
		inputFilePath = "D:\\CALSIM3.0_070110\\D1641\\Run\\maind1641.wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
		
		/// get the model name of the first cycle
		String modelName = sd.getModelList().get(0);
		
		/// write model data to csv files
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
	
		Assert.assertEquals(1, 0);	
		
	}
}
