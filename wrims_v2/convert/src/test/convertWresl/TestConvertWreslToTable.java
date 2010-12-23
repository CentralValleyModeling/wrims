package test.convertWresl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wresl.ConvertWreslLexer;
import wresl.ConvertWreslParser;

import org.testng.annotations.*;
import org.testng.Assert;

import evaluators.Dataset;
import evaluators.FileParser;
import evaluators.PairMap;
import evaluators.Struct;
import evaluators.Svar;
import evaluators.Dvar;
import evaluators.Tools;
import evaluators.WriteCSV;



//import evaluators.Demo;

public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;


	
	@Test(groups = { "WRESL_to_Table"  })
	public void processModelOneLevel_case1() throws RecognitionException, IOException {
 
		PairMap pairMain;
		
		String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelOneLevel_case1.wresl";

		pairMain = FileParser.processFile(mainFilePath,"global"); 
		
		/// process included files in this main file
		pairMain.add(FileParser.processFileList(pairMain.fileDataMap.get(mainFilePath))); 
		

		/// this map will collect detailed info for models				
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		
		/// for each model collected from the main file and one-level includes
		for ( String model : pairMain.modelAdhocMap.keySet()){
			
			System.out.println( "processing this included model in main file: "+ model );
			
			/// put the initial adhoc data from main file into complete data container
			Dataset model_data_complete = new Dataset( pairMain.modelAdhocMap.get(model) );	
			
			
			/// process included files under this model
			pairMain.add(FileParser.processFileList(pairMain.modelAdhocMap.get(model)));
			
			/// copy global data from pair into the complete data container
			for (String includedFile : pairMain.modelAdhocMap.get(model).incFileList_global){
				model_data_complete.add(pairMain.fileDataMap.get(includedFile));	
			}

			/// copy local data from pair into the complete data container
			for (String includedFile : pairMain.modelAdhocMap.get(model).incFileList_local){
				Dataset localData = Tools.convertDatasetToLocal(pairMain.fileDataMap.get(includedFile));
				model_data_complete.add(localData);	
			}
			
			
			model_data_complete_map.put(model, model_data_complete);		
		}		
		

		
		System.out.println( "in complete map: "+ model_data_complete_map.keySet() );

		/// output csv files
		
		
		for (String model : model_data_complete_map.keySet()) {

			String outFolder = "test-csv\\TestConvertWreslToTable_processModelOneLevel_case1\\" + model;
			String expectedFolder = "src\\test\\expected\\TestConvertWreslToTable_processModelOneLevel_case1\\" + model;

			Tools.deleteDir(outFolder);

			WriteCSV.dataset(model_data_complete_map.get(model), "all", outFolder);

			Map<String, String> actual = Tools.readFilesFromDirAsMap(outFolder);

			Map<String, String> expected = Tools.readFilesFromDirAsMap(expectedFolder);

			Assert.assertEquals(actual, expected);
		}
	}	


	

	
	
	
}
