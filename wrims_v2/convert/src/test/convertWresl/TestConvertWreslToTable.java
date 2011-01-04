package test.convertWresl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.*;
import evaluators.Comparison;
import evaluators.Dataset;
import evaluators.PairMap;
import evaluators.StudyParser;
import evaluators.Tools;
import evaluators.WriteCSV;


public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;

	@Test(groups = { "WRESL_to_Table"  })
	public void globalVars() throws RecognitionException, IOException {
		
		String f = "src\\test\\TestConvertWreslToTable_globalVars.wresl";
		
		String outParent = "test-csv\\TestConvertWreslToTable_globalVars\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_globalVars\\";
		
		Tools.deleteDir(outParent);

		
		PairMap pair = StudyParser.parseMainFile(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(pair);
		
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

		
		PairMap pair = StudyParser.parseMainFile(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(pair);
		
		Assert.assertEquals(modelDataMap.keySet().isEmpty(), false );
		
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

		
		PairMap pair = StudyParser.parseMainFile(f);
		
		File absMainFile = new File(f).getAbsoluteFile();
		String absMainFilePath = absMainFile.getCanonicalPath();		
		Map<Integer, String> sequence_map = pair.fileDataMap.get(absMainFilePath).sequence_map;
		ArrayList<Integer> sequenceList = new ArrayList<Integer>();
		for ( Integer i : sequence_map.keySet()){ sequenceList.add(i); }
		Collections.sort(sequenceList);

		PrintWriter out_sequence = Tools.openFile(outParent, "SEQUENCE.csv");
		out_sequence.print(WriteCSV.sequence_header + "\n");
		WriteCSV.sequence(sequence_map, sequenceList, out_sequence);
		
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(pair);
		
		Assert.assertEquals(modelDataMap.keySet().isEmpty(), false );
		
		WriteCSV.output(modelDataMap, outParent);
		
		Comparison.compareFolder(modelDataMap.keySet(), outParent, expectedParent);
	}	
	
}
