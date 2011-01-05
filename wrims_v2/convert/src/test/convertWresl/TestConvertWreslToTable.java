package test.convertWresl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.*;
import evaluators.Comparison;
import evaluators.Dataset;
import evaluators.StudyConfig;
import evaluators.StudyParser;
import evaluators.Tools;
import evaluators.WriteCSV;


public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;

	
	@Test(groups = { "WRESL_to_Table"  })
	public void globalLocalVars() throws RecognitionException, IOException {
		
		String f = "src\\test\\TestConvertWreslToTable_globalLocalVars.wresl";
		
		String outParent = "test-csv\\TestConvertWreslToTable_globalLocalVars\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_globalLocalVars\\";
		
		Tools.deleteDir(outParent);

		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(sc);
		
		Assert.assertEquals(modelDataMap.keySet().isEmpty(), false );
		
		WriteCSV.output(modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}		
	
	@Test(groups = { "WRESL_to_Table"  })
	public void localVars() throws RecognitionException, IOException {
		
		String f = "src\\test\\TestConvertWreslToTable_localVars.wresl";
		
		String outParent = "test-csv\\TestConvertWreslToTable_localVars\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_localVars\\";
		
		Tools.deleteDir(outParent);

		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(sc);
		
		Assert.assertEquals(modelDataMap.keySet().isEmpty(), false );
		
		WriteCSV.output(modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}	
	
	@Test(groups = { "WRESL_to_Table"  })
	public void globalVars() throws RecognitionException, IOException {
		
		String f = "src\\test\\TestConvertWreslToTable_globalVars.wresl";
		
		String outParent = "test-csv\\TestConvertWreslToTable_globalVars\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_globalVars\\";
		
		Tools.deleteDir(outParent);

		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(sc);
		
		Assert.assertEquals(modelDataMap.keySet().isEmpty(), false );
		
		WriteCSV.output(modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}
	
	@Test(groups = { "WRESL_to_Table"  })
	public void processModelNestedSimple() throws RecognitionException, IOException {
		
		String f = "src\\test\\TestConvertWreslToTable_processModelNestedSimple.wresl";
		
		String outParent = "test-csv\\TestConvertWreslToTable_processModelNestedSimple\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_processModelNestedSimple\\";
		
		Tools.deleteDir(outParent);

		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(sc);
		
		Assert.assertEquals(modelDataMap.keySet().isEmpty(), false );
		
		WriteCSV.output(modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}	

	@Test(groups = { "WRESL_to_Table"  })
	public void calsimTest() throws RecognitionException, IOException {

		//String f = "src\\test\\TestConvertWreslToTable_t1Map.wresl";
		String f = "D:\\CALSIM3.0_070110\\D1641\\Run\\maind1641.wresl";
		//String f = "D:\\CALSIM3_0_070110\\common\\test.wresl";
		//String f = "D:\\CalliteRun\\main.wresl";	
		
		String outParent = "test-csv\\TestConvertWreslToTable_t1Map\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_t1Map\\";
		
		Tools.deleteDir(outParent);

		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(sc);
		
		Assert.assertEquals(modelDataMap.keySet().isEmpty(), false );
		
		WriteCSV.study(sc, modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}	
	
}
