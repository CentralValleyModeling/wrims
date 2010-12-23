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
		//pairMain.add(FileParser.processFileList(pairMain.fileDataMap.get(mainFilePath))); 
		

		/// this map will collect detailed info for models				
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		
		/// for each model collected from the main file
		for ( String model : pairMain.modelAdhocMap.keySet()){
			
			System.out.println( "processing this included model in main file: "+ model );
			
			/// put the initial adhoc data from main file into complete data container
			Dataset model_data_adhoc = pairMain.modelAdhocMap.get(model);	
			Dataset model_data_complete = new Dataset(model_data_adhoc);
			
			/// process included files under this model
			Map<String, PairMap> pm = new HashMap<String, PairMap>();
			pm = FileParser.processFileListIntoMap(pairMain.modelAdhocMap.get(model));
			
			for (String file : pm.keySet()){
				pairMain.add(pm.get(file));
			}
			

			
			List<String> allList = pairMain.modelAdhocMap.get(model).incFileList;
			List<String> localList = pairMain.modelAdhocMap.get(model).incFileList_local;
			
			// / copy data from pair into the complete data container
			for (String includedFile : allList) {

				Dataset ds = pairMain.fileDataMap.get(includedFile);

				if (!model_data_complete.hasRedefinedIn(ds)) {
					
					/// local
					if (localList.contains(includedFile)) {

						model_data_complete.addToLocal(ds);
					}
					/// global
					else {
						model_data_complete.add(ds);
					}
				}
			}
			

			
			
			model_data_complete_map.put(model, model_data_complete);		
		}		
		

		/// output csv files		
		
		String outFolder = "test-csv\\TestConvertWreslToTable_processModelOneLevel_case1\\";
		String expectedFolder = "src\\test\\expected\\TestConvertWreslToTable_processModelOneLevel_case1\\";
		Tools.deleteDir(outFolder);
		
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
