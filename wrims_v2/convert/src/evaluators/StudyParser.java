package evaluators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;

public class StudyParser {
	
	public static Map<String, Dataset> parseMainFile(String mainFilePath) throws RecognitionException, IOException {
 		
		PairMap pairMain;
		
		
		pairMain = FileParser.processFileIntoPair(mainFilePath,"global"); 

		
		/// process included files in this main file		
		Map<String, PairMap> m = FileParser.processFileListIntoMapOfPair(pairMain.fileDataMap.get(mainFilePath));
		for (String file : m.keySet()){ pairMain.add(m.get(file)); }
				
		
		Map<String,Dataset> fileDataMap_wholeStudy = new HashMap<String, Dataset>() ;
		Map<String,ArrayList<String>> t1Map_wholeStudy = new HashMap<String, ArrayList<String>>();	
		Map<String,String> fileScopeMap_wholeStudy = new HashMap<String, String>();	

		/// this map will collect detailed info for models			
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		/// for each model collected from the main files
		for ( String model : pairMain.modelAdhocMap.keySet()){
			System.out.println("############################################");
			System.out.println("####   Processing model: "+model);
			System.out.println("############################################");
			
			Dataset adhoc = pairMain.modelAdhocMap.get(model);
	
			Set<String> existingSet = fileDataMap_wholeStudy.keySet();
			
			Map<String,Dataset> fileDataMap_newInModel = new HashMap<String, Dataset>() ;			
			/// get all file data map for this study
			Map<String,Dataset> fileDataMap_thisModel = new HashMap<String, Dataset>();
			
			for (String f: adhoc.incFileList) {
				if (existingSet.contains(f))  {
					/// skip processing
					//System.out.println("....Skip file: "+f);
					fileDataMap_thisModel.put(f, fileDataMap_wholeStudy.get(f));
					fileDataMap_thisModel.putAll(Tools.getAllSprings(f, t1Map_wholeStudy, fileDataMap_wholeStudy));
					/// TODO: need to put file f's children dataset					

				} 
				else { /// new file
					Map<String, Dataset> each = FileParser.processNestedFileExceptFor(f,existingSet);
					fileDataMap_newInModel.putAll(each);
					fileDataMap_wholeStudy.putAll(each);
				}				
			}
			
			
			/// copy to this model
			for (String f: adhoc.incFileList) {
			
				fileDataMap_thisModel.putAll(Tools.putDataFileMapFromWholeStudy(f,fileDataMap_wholeStudy));
			}

			
			System.out.println("keysets in thisModel"+fileDataMap_thisModel.keySet());	
			System.out.println("keysets in whole"+fileDataMap_wholeStudy.keySet());
			
			
			/// get fileScopeMap and ReverseMap
			/// TODO: avoid repeated processing
			
			////// update whole study t1Map
			t1Map_wholeStudy.putAll(Tools.getType1Map(fileDataMap_newInModel));
			fileScopeMap_wholeStudy.putAll(Tools.getFileScopeMap(fileDataMap_newInModel));
		    //////////////////////////////////////////////////////////////////////////////
			
			/// this model t1Map, fileScopeMap, and reverseMap
			Map<String,String> fileScopeMap = new HashMap<String, String>(fileScopeMap_wholeStudy);
			fileScopeMap.putAll(Tools.getScopeMap(adhoc.incFileList, adhoc.incFileList_local));
			
			Map<String,ArrayList<String>> t1Map = new HashMap<String, ArrayList<String>>(t1Map_wholeStudy);
			t1Map.put(mainFilePath, adhoc.incFileList);
			
			//Map<String,ArrayList<String>> t1ReverseMap = Tools.getReverseMap(t1Map);
			Map<String,Set<String>> t1ReverseMap = Tools.getReverseMap(t1Map);



			//////////////////////////////////////////////////////////////////////////////////////
			System.out.println(".....Finished fileScopeMap & ReverseMap.");
			
			
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
			
//			for (String f : fileDataMap_corrected.keySet()) {
//				System.out.println("========== fileDataMap_corrected =========== ");
//				System.out.println("all   : " + f + "::: " + fileDataMap_corrected.get(f).svList);
//				System.out.println("global: " + f + "::: " + fileDataMap_corrected.get(f).svList_global);
//				System.out.println("local : " + f + "::: " + fileDataMap_corrected.get(f).svList_local);
//			}
			
			
			/// prioritize data if redefined			
			Dataset model_data_complete = new Dataset();
			System.out.println("========== starting data prioritization =========== ");	

			/// for kid
			for (String f : adhoc.incFileList) {
				
					model_data_complete.prioritizeChildren(f, t1Map, fileDataMap_corrected);
			}
			System.out.println("========== finish children prioritization =========== ");

			/// for member in adhoc
			for (String f : adhoc.incFileList) {
				
				model_data_complete.prioritize(fileDataMap_corrected.get(f), f);
			}
			
			model_data_complete.prioritize(adhoc, mainFilePath);
			
			System.out.println("========== finish prioritization =========== ");


//				System.out.println("all   : " + model_data_complete.svList);
//				System.out.println("global: " + model_data_complete.svList_global);
//				System.out.println("local : " + model_data_complete.svList_local);
			
			
			//////////////////////////////////////////
			
			model_data_complete_map.put(model, model_data_complete);
			System.out.println("######################################################");
			System.out.println("####   Finished Processing model: "+model);
			System.out.println("######################################################");
		}
		System.out.println("**********************************************************");
		System.out.println("***********+----------------------------------+***********");
		System.out.println("***********|   Finished all data processing   |***********");
		System.out.println("***********+----------------------------------+***********");
		System.out.println("**********************************************************");

		/// output csv files		
		
		
		System.out.println("All keyset: "+model_data_complete_map.keySet());
		Assert.assertEquals(model_data_complete_map.keySet().isEmpty(), false );
		
		
		return model_data_complete_map;
	}}
	
