package test.convertWresl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		
		//String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelNestedSimple.wresl";	
		//String mainFilePath = "D:\\CalliteRun\\main.wresl";	
		String mainFilePath = "D:\\CALSIM3.0_070110\\D1641\\Run\\maind1641.wresl";
		
		pairMain = FileParser.processFileIntoPair(mainFilePath,"global"); 

		
		/// process included files in this main file		
		Map<String, PairMap> m = FileParser.processFileListIntoMapOfPair(pairMain.fileDataMap.get(mainFilePath));
		for (String file : m.keySet()){ pairMain.add(m.get(file)); }
				

		
		
		/// this map will collect detailed info for models				
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		Map<String,Dataset> fileDataMap_wholeStudy = new HashMap<String, Dataset>() ;
		
		/// for each model collected from the main files
		for ( String model : pairMain.modelAdhocMap.keySet()){
			
			Dataset adhoc = pairMain.modelAdhocMap.get(model);
	
			Set<String> existingSet = fileDataMap_wholeStudy.keySet();

			
			Map<String,Dataset> fileDataMap_newInModel = new HashMap<String, Dataset>() ;			
			/// get all file data map for this study
			Map<String,Dataset> fileDataMap_thisModel = new HashMap<String, Dataset>();
			
			for (String f: adhoc.incFileList) {
				if (existingSet.contains(f))  {
					/// skip processing
					fileDataMap_thisModel.put(f, fileDataMap_wholeStudy.get(f));	
				} 
				else { /// new file
					Map<String, Dataset> each = FileParser.processNestedFileExceptFor(f,existingSet);
					fileDataMap_newInModel.putAll(each);
					fileDataMap_thisModel.putAll(each);
					fileDataMap_wholeStudy.putAll(each);
				}				
			}
			
			/// update data map for the whole study
			//fileDataMap_wholeStudy.putAll(fileDataMap_newInModel);
			
			System.out.println("keysets in thisModel"+fileDataMap_thisModel.keySet());	
			System.out.println("keysets in whole"+fileDataMap_wholeStudy.keySet());
			
			
			/// get fileScopeMap and ReverseMap
			/// TODO: avoid repeated processing
			Map<String, Dataset> all = new HashMap<String, Dataset>();
			all.putAll(fileDataMap_thisModel);
			all.put(mainFilePath,adhoc);
			Map<String,ArrayList<String>> t1Map = Tools.getType1Map(all);			
			
			Map<String,ArrayList<String>> t1ReverseMap = Tools.getReverseMap(t1Map);
			Map<String,String> fileScopeMap = Tools.getFileScopeMap(fileDataMap_thisModel, adhoc);
			//////////////////////////////////////////////////////////////////////////////////////

			Map<String,Dataset> fileDataMap_corrected = new HashMap<String, Dataset>();
			fileDataMap_corrected.putAll(fileDataMap_thisModel);
			
			System.out.println("keysets in corrected"+fileDataMap_corrected.keySet());
			
			for (String f : fileDataMap_thisModel.keySet()) {

				Dataset ds = Tools.correctDataScope(f, fileDataMap_thisModel.get(f), fileScopeMap, t1ReverseMap);
				
				fileDataMap_corrected.put(f, ds);
				
			}

			
			System.out.println("file scope map: "+fileScopeMap);
			System.out.println("t1 map: "+t1Map);
			System.out.println("t1 reverse map: "+t1ReverseMap);
			
			System.out.println("keysets in fileDataMap"+fileDataMap_corrected.keySet());
			
			for (String f : fileDataMap_newInModel.keySet()) {

				System.out.println("key: " + f + "::: " + fileDataMap_corrected.get(f).svList);
				System.out.println("key: " + f + "::: " + fileDataMap_corrected.get(f).svList_global);
				System.out.println("key: " + f + "::: " + fileDataMap_corrected.get(f).svList_local);
			}
			
			
			/// prioritize data if redefined			
			Dataset model_data_complete = new Dataset();

			for (String f : adhoc.incFileList) {
				
					model_data_complete.prioritizeList(f, t1Map, fileDataMap_corrected);
			}
			
			model_data_complete_map.put(model, model_data_complete);		
		}		
		

		/// output csv files		
		
		String outParent = "test-csv\\TestConvertWreslToTable_processModelNestedSimple\\";
		String expectedParent = "src\\test\\expected\\TestConvertWreslToTable_processModelNestedSimple\\";
		Tools.deleteDir(outParent);
		
		Assert.assertEquals(model_data_complete_map.keySet().isEmpty(), false );
		
		for (String model : model_data_complete_map.keySet()) {
			
			String outFolder = outParent + model;
			//String expectedFolder = expectedParent + model;

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


	
	
}
