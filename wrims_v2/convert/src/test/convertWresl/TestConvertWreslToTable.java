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

			ArrayList<String> fileList = adhoc.incFileList;			
			Map<String,Dataset> fileDataMap = new HashMap<String, Dataset>() ;
			
			for ( int i=0; i< fileList.size(); i++ ){
				String f = fileList.get(i);
				Map<String,Dataset> each = FileParser.processNestedFile(f);
				
				fileDataMap.putAll(each);
			}
			
			Map<String,String> fileScopeMap = Tools.getFileScopeMap(fileDataMap, adhoc);
			
			Map<String, Dataset> all = new HashMap<String, Dataset>();
			all.putAll(fileDataMap);
			all.put(mainFilePath,adhoc);
			Map<String,ArrayList<String>> t1Map = Tools.getType1Map(all);
			
			Map<String,ArrayList<String>> t1ReverseMap = Tools.getReverseMap(t1Map);
			Map<String,ArrayList<String>> t1MapScope = Tools.getType1MapScope(all);
			

			/// correct data scope
			Map<String,Dataset> fileDataMap_corrected = new HashMap<String, Dataset>();
			fileDataMap_corrected.putAll(fileDataMap);
			
			for (String f : fileDataMap_corrected.keySet()) {

				if (fileScopeMap.get(f) == "local") {

					Dataset d = fileDataMap_corrected.get(f);

					fileDataMap_corrected.put(f, d.convertToLocal());

				}
				else {

					for (String upperFile : t1ReverseMap.get(f)) {

						if (fileScopeMap.get(upperFile) == "local") {

							System.out.println("found it! " + upperFile);

							Dataset d = fileDataMap_corrected.get(f);

							fileDataMap_corrected.put(f, d.convertToLocal());

							break;
						}
					}
				}

			}

			
			System.out.println("file scope map: "+fileScopeMap);
			System.out.println("t1 map: "+t1Map);
			System.out.println("t1 map scope: "+t1MapScope);
			System.out.println("t1 reverse map: "+t1ReverseMap);
			
			System.out.println("keysets in fileDataMap"+fileDataMap.keySet());
			
			System.out.println(fileDataMap_corrected.get("D:\\cvwrsm\\wrims_v2\\convert\\src\\test\\TestConvertWresl_svarExpression.wresl").svList);			
			System.out.println(fileDataMap_corrected.get("D:\\cvwrsm\\wrims_v2\\convert\\src\\test\\TestConvertWresl_svarExpression.wresl").svList_global);
			System.out.println(fileDataMap_corrected.get("D:\\cvwrsm\\wrims_v2\\convert\\src\\test\\TestConvertWresl_svarExpression.wresl").svList_local);
			
			
			ArrayList<String> level_1_files = adhoc.incFileList;
			
			
			
			Dataset model_data_complete = new Dataset();

			for (String f : adhoc.incFileList) {

				for (String l2File : t1Map.get(f)) {
					for (String l3File : t1Map.get(l2File)) {

						// / check duplicate and promote later included file
						// data for higher priority
						model_data_complete.prioritize(fileDataMap_corrected.get(l3File), l3File);
					}

				}
			}
			
			for (String f : adhoc.incFileList) {

				for (String lowerFile : t1Map.get(f)) {

					// / check duplicate and promote later included file data
					// for higher priority
					model_data_complete.prioritize(fileDataMap_corrected.get(lowerFile), lowerFile);

				}
			}
			
			for (String f : adhoc.incFileList){
				
				/// check duplicate and promote later included file data for higher priority 		
				model_data_complete.prioritize(fileDataMap_corrected.get(f), f);

			}			
			/// check duplicate and promote adhoc data for higher priority 
			model_data_complete.prioritize(adhoc, mainFilePath);	
			
			/// assemble the final map
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
