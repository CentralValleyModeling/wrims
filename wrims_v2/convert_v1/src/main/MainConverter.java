package main;

import java.io.IOException;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import evaluators.Dataset;
import evaluators.StudyConfig;
import evaluators.StudyParser;
import evaluators.Tools;
import evaluators.WriteCSV;

public class MainConverter {
	
	
	public static void main(String[] args) throws RecognitionException, IOException {


		String f = args[0];
		//String f = "D:\\CALSIM3.0_070110\\D1641\\Run\\maind1641.wresl";

		
		String outParent = "test-csv\\TestConvertWreslToTable_main\\";
		
		Tools.deleteDir(outParent);

		
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		Map<String, Dataset> modelDataMap = StudyParser.parseSubFiles(sc);
		
		
		WriteCSV.study(sc, modelDataMap, outParent);
		

	}

}
