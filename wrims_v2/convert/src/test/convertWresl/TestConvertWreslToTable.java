package test.convertWresl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.testng.annotations.*;
import org.testng.Assert;

import evaluators.Dataset;
import evaluators.FileParser;
import evaluators.PairMap;
import evaluators.Tools;
import evaluators.WriteCSV;


public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;


	
	@Test(groups = { "WRESL_to_Table"  })
	public void processModelOneLevel_case1() throws RecognitionException, IOException {
 
		PairMap pairMain;
		
		String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelOneLevel_case2.wresl";

		pairMain = FileParser.processFile(mainFilePath,"global"); 

		
		/// process included files in this main file		
		Map<String, PairMap> m = FileParser.processFileListIntoMap(pairMain.fileDataMap.get(mainFilePath));
		for (String file : m.keySet()){ pairMain.add(m.get(file)); }
				

		/// this map will collect detailed info for models				
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		

		
		/// for each model collected from the main files
		for ( String model : pairMain.modelAdhocMap.keySet()){
			
			Dataset adhoc = pairMain.modelAdhocMap.get(model);
			
			/// get pairs from model adhoc (this is the major file parsing)
			/// TODO: reduce redundant parsing, e.g., same include files in different models
			Map<String,Dataset> fileDataMap = Tools.getModelPairFromAdhoc(adhoc).fileDataMap;
			
			/// copy to complete data
			Dataset model_data_complete = Tools.copyModelCompleteDataFromFileDataMap(
									fileDataMap, adhoc.incFileList, adhoc.incFileList_local);
			
			/// check duplicate and keep priority for adhoc data
			if ( model_data_complete.hasRedefinedIn(adhoc, mainFilePath)) {
				model_data_complete.remove(adhoc);
			}
			
			/// put the initial adhoc data into complete data container
			 model_data_complete.add(adhoc);
			

						
			model_data_complete_map.put(model, model_data_complete);		
		}		
		

		/// output csv files		
		
		String outFolder = "test-csv\\TestConvertWreslToTable_processModelOneLevel_case1\\";
		String expectedFolder = "src\\test\\expected\\TestConvertWreslToTable_processModelOneLevel_case1\\";
		Tools.deleteDir(outFolder);
		
		Assert.assertEquals(model_data_complete_map.keySet().isEmpty(), false );
		
		for (String model : model_data_complete_map.keySet()) {

			outFolder = outFolder + model;
			expectedFolder = expectedFolder + model;


			WriteCSV.dataset(model_data_complete_map.get(model), "all", outFolder);

			Map<String, String> actual = Tools.readFilesFromDirAsMap(outFolder);

			Map<String, String> expected = Tools.readFilesFromDirAsMap(expectedFolder);

			Assert.assertEquals(actual, expected);
		}
	}	


	

	
	
	
}
