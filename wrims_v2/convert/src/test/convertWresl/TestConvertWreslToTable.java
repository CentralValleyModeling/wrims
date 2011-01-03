package test.convertWresl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.testng.annotations.*;
import evaluators.Comparison;
import evaluators.Dataset;
import evaluators.StudyParser;
import evaluators.Tools;
import evaluators.WriteCSV;


public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;


	
	@Test(groups = { "WRESL_to_Table"  })
	public void processModelNestedSimple() throws RecognitionException, IOException {
		
		String f = "src\\test\\TestConvertWreslToTable_processModelNestedSimple.wresl";
		
		String outParent = "test-csv\\TestConvertWreslToTable_processModelNestedSimple\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_processModelNestedSimple\\";
		
		Tools.deleteDir(outParent);

		
		Map<String, Dataset> modelDataMap = StudyParser.parseMainFile(f);
		WriteCSV.output(modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}	

	@Test(groups = { "WRESL_to_Table"  })
	public void t1Map() throws RecognitionException, IOException {

		//String f = "src\\test\\TestConvertWreslToTable_t1Map.wresl";
		String f = "D:\\CALSIM3.0_070110\\D1641\\Run\\maind1641.wresl";
		//String f = "D:\\CALSIM3_0_070110\\common\\test.wresl";
		//String f = "D:\\CalliteRun\\main.wresl";	
		
		String outParent = "test-csv\\TestConvertWreslToTable_t1Map\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_t1Map\\";
		
		Tools.deleteDir(outParent);

		
		Map<String, Dataset> modelDataMap = StudyParser.parseMainFile(f);
		WriteCSV.output(modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}	
	
}
