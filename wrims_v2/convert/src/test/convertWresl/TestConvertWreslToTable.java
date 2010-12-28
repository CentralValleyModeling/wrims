package test.convertWresl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.testng.annotations.*;
import org.testng.Assert;

import evaluators.Dataset;
import evaluators.FileParser;
import evaluators.IncludeFile;
import evaluators.PairMap;
import evaluators.Tools;
import evaluators.WriteCSV;


public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;


	
	@Test(groups = { "WRESL_to_Table"  })
	public void processModelNestedSimple() throws RecognitionException, IOException {
 		
		PairMap pairMain;
		
		String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelNestedSimple.wresl";	
		
		pairMain = FileParser.processFileIntoPair(mainFilePath,"global"); 

		
		/// process included files in this main file		
		Map<String, PairMap> m = FileParser.processFileListIntoMapOfPair(pairMain.fileDataMap.get(mainFilePath));
		for (String file : m.keySet()){ pairMain.add(m.get(file)); }
				

		/// this map will collect detailed info for models				
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		

		
		/// for each model collected from the main files
		for ( String model : pairMain.modelAdhocMap.keySet()){
			
			Dataset adhoc = pairMain.modelAdhocMap.get(model);
			
			/// get dataset map from model adhoc (this is the major file parsing effort)
			/// TODO: reduce redundant parsing, e.g., same include files in different models

			ArrayList<String> firstLevel = new ArrayList<String>();
			ArrayList<String> secondLevel = new ArrayList<String>();
			
			/// get scope list
			ArrayList<String> scopeList = new ArrayList<String>();
			for (String f : adhoc.incFileList){ scopeList.add(adhoc.incFileMap.get(f).scope); }
			

			Map<String,Dataset> fileDataMap = FileParser.processFileListIntoDatasetMap(adhoc.incFileList,scopeList);
			
			System.out.println("keysets in fileDataMap"+fileDataMap.keySet());
			
			System.out.println(fileDataMap.get("D:\\cvwrsm\\wrims_v2\\convert\\src\\test\\TestConvertWresl_svarExpression.wresl").svList);			
			System.out.println(fileDataMap.get("D:\\cvwrsm\\wrims_v2\\convert\\src\\test\\TestConvertWresl_svarExpression.wresl").svList_global);
			System.out.println(fileDataMap.get("D:\\cvwrsm\\wrims_v2\\convert\\src\\test\\TestConvertWresl_svarExpression.wresl").svList_local);
			
			
			
			Dataset model_data_complete = new Dataset();
			
			for (String f : adhoc.incFileList){
				
				/// check duplicate and promote later included file data for higher priority 		
				model_data_complete.prioritize(fileDataMap.get(f), f);			
			
			
			
			}
			/// check duplicate and promote adhoc data for higher priority 
			model_data_complete.prioritize(adhoc, mainFilePath);	
			
			
			
			
			
			model_data_complete_map.put(model, model_data_complete);		
		}		
		

		/// output csv files		
		
		String outParent = "test-csv\\TestConvertWreslToTable_processModelNestedSimple\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_processModelNestedSimple\\";
		Tools.deleteDir(outParent);
		
		Assert.assertEquals(model_data_complete_map.keySet().isEmpty(), false );
		
		for (String model : model_data_complete_map.keySet()) {
			
			String outFolder = outParent + model;
			String expectedFolder = expectedParent + model;

			WriteCSV.dataset(model_data_complete_map.get(model), "all", outFolder);
		}
		
		for (String model : model_data_complete_map.keySet()) {
			
			String outFolder = outParent + model;
			String expectedFolder = expectedParent + model;
			
			Map<String, String> actual = Tools.readFilesFromDirAsMap(outFolder);
			Map<String, String> expected = Tools.readFilesFromDirAsMap(expectedFolder);

			Assert.assertEquals(actual, expected);
		}
	}	


//	@Test(groups = { "WRESL_to_Table"  })
//	public void processModelNestedTwoLevel() throws RecognitionException, IOException {
// 
//		PairMap pairMain;
//		
//		String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelNestedTwoLevel.wresl";	
//		
//		pairMain = FileParser.processFileIntoPair(mainFilePath,"global"); 
//
//		
//		/// process included files in this main file		
//		Map<String, PairMap> m = FileParser.processFileListIntoMapOfPair(pairMain.fileDataMap.get(mainFilePath));
//		for (String file : m.keySet()){ pairMain.add(m.get(file)); }
//				
//
//		/// this map will collect detailed info for models				
//		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
//		
//
//		
//		/// for each model collected from the main files
//		for ( String model : pairMain.modelAdhocMap.keySet()){
//			
//			Dataset adhoc = pairMain.modelAdhocMap.get(model);
//			
//			/// get dataset map from model adhoc (this is the major file parsing effort)
//			/// TODO: reduce redundant parsing, e.g., same include files in different models
//			Map<String,Dataset> fileDataMap = FileParser.processFileListIntoDatasetMap(adhoc);
//			                                  
//			
//			/// correct data scope
//			Dataset model_data_complete = Tools.overrideScope(
//									fileDataMap, adhoc.incFileList, adhoc.incFileList_local);
//			
//			/// check duplicate and promote adhoc data for higher priority 
//			if ( model_data_complete.hasDuplicateIn(adhoc, mainFilePath)) {
//				model_data_complete.remove(adhoc);
//			}
//			
//			/// put the initial adhoc data into complete data container to override
//			 model_data_complete.add(adhoc);
//						
//			 model_data_complete_map.put(model, model_data_complete);		
//		}		
//		
//
//		/// output csv files		
//		
//		String outFolder = "test-csv\\TestConvertWreslToTable_processModelNestedTwoLevel\\";
//		String expectedFolder = "src\\test\\expected\\TestConvertWreslToTable_processModelNestedTwoLevel\\";
//		Tools.deleteDir(outFolder);
//		
//		Assert.assertEquals(model_data_complete_map.keySet().isEmpty(), false );
//		
//		for (String model : model_data_complete_map.keySet()) {
//
//			outFolder = outFolder + model;
//			expectedFolder = expectedFolder + model;
//
//
//			WriteCSV.dataset(model_data_complete_map.get(model), "all", outFolder);
//
//			Map<String, String> actual = Tools.readFilesFromDirAsMap(outFolder);
//
//			Map<String, String> expected = Tools.readFilesFromDirAsMap(expectedFolder);
//
//			Assert.assertEquals(actual, expected);
//		}
//	}		
	
	
}
