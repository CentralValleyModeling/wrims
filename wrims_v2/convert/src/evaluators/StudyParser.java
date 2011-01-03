package evaluators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;

public class StudyParser {
	
	public static Map<String, Dataset> parseMainFile(String relativeMainFilePath) throws RecognitionException, IOException {
 		
		PairMap pairMain;
		File absMainFile = new File(relativeMainFilePath).getAbsoluteFile();
		String absMainFilePath = absMainFile.getCanonicalPath();
		
		pairMain = FileParser.processFileIntoPair(absMainFilePath,"global"); 

		System.out.println("############################################");
		System.out.println("############################################");

		//System.out.println("sequence: "+ pairMain.fileDataMap.get(absMainFilePath).sequence_map);
		

		Map<Integer, String> sequence_map = pairMain.fileDataMap.get(absMainFilePath).sequence_map;

		ArrayList<Integer> sequenceList = new ArrayList<Integer>();
		
		for ( Integer i : sequence_map.keySet()){ sequenceList.add(i); }
		
		Collections.sort(sequenceList);
		
		for ( Integer i : sequenceList){	
			System.out.println("sequence: "+i+" Model: "+sequence_map.get(i));		
		}
		
		
		
		
		
//		/// process included files in this main file		
//		Map<String, PairMap> m = FileParser.processFileListIntoMapOfPair(pairMain.fileDataMap.get(mainFilePath));
//		for (String file : m.keySet()){ pairMain.add(m.get(file)); }
				
		
		Map<String,Dataset> fileDataMap_wholeStudy = new HashMap<String, Dataset>() ;
		Map<String,ArrayList<String>> t1Map_wholeStudy = new HashMap<String, ArrayList<String>>();	
		Map<String,String> fileScopeMap_wholeStudy = new HashMap<String, String>();	

		/// this map will collect detailed info for models			
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		/// cumulative global vars and include files
		Dataset adhoc_cumulative_globals = new Dataset();

		/// for each model collected from the main files
//###################################################################################################		
		for ( Integer iSequence : sequenceList){	

			String model = sequence_map.get(iSequence);
		
			
			System.out.println("############################################");
			System.out.println("####   Processing sequence: "+iSequence);
			System.out.println("####              model:    "+model);
			System.out.println("############################################");
			
			Dataset adhoc = pairMain.modelAdhocMap.get(model);

			
			Dataset adhoc_include_previous_globals = new Dataset();
			adhoc_include_previous_globals.add(adhoc);
			adhoc_include_previous_globals.add(adhoc_cumulative_globals);
			

			
//			Set<String> filesDataToCopy = new HashSet<String>();
//			filesDataToCopy.addAll(adhoc.incFileList);
//			filesDataToCopy.addAll(adhoc_cumulative_globals.incFileList);
			
			Set<String> existingSet = fileDataMap_wholeStudy.keySet();
			
			Map<String,Dataset> fileDataMap_newInModel = new HashMap<String, Dataset>() ;			
			/// get all file data map for this study
			Map<String,Dataset> fileDataMap_thisModel = new HashMap<String, Dataset>();
			
			
			

			/// process include files both appear in this model and previous globals
			for (String f: adhoc_include_previous_globals.incFileList) {
				
				if (existingSet.contains(f))  {
					/// skip processing
					//System.out.println("....Skip file: "+f);
					fileDataMap_thisModel.put(f, fileDataMap_wholeStudy.get(f));
					fileDataMap_thisModel.putAll(Tools.getAllOffSprings(f, t1Map_wholeStudy, fileDataMap_wholeStudy));
					/// TODO: need to put file f's children dataset					

				} 
				else { /// new file
					Map<String, Dataset> each = FileParser.processNestedFileExceptFor(f,existingSet);
					fileDataMap_newInModel.putAll(each);
					fileDataMap_wholeStudy.putAll(each);
				}				
			}
			
			
			/// copy to this model
			for (String f: adhoc_include_previous_globals.incFileList) {
			
				fileDataMap_thisModel.putAll(Tools.putDataFileMapFromWholeStudy(f,fileDataMap_wholeStudy));
			}

			
//			System.out.println("keysets in thisModel"+fileDataMap_thisModel.keySet());	
//			System.out.println("keysets in whole"+fileDataMap_wholeStudy.keySet());
			
			
			/// get fileScopeMap and ReverseMap
			/// TODO: avoid repeated processing
			
			////// update whole study t1Map
			t1Map_wholeStudy.putAll(Tools.getType1Map(fileDataMap_newInModel));
			fileScopeMap_wholeStudy.putAll(Tools.getFileScopeMap(fileDataMap_newInModel));
		    //////////////////////////////////////////////////////////////////////////////
			
			/// this model t1Map, fileScopeMap, and reverseMap
			Map<String,String> fileScopeMap = new HashMap<String, String>(fileScopeMap_wholeStudy);
			fileScopeMap.putAll(Tools.getScopeMap(adhoc_include_previous_globals.incFileList, adhoc_include_previous_globals.incFileList_local));
			
			Map<String,ArrayList<String>> t1Map = new HashMap<String, ArrayList<String>>(t1Map_wholeStudy);
			t1Map.put(absMainFilePath, adhoc_include_previous_globals.incFileList);
			
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

			
//			System.out.println("file scope map: "+fileScopeMap);
//			System.out.println("t1 map: "+t1Map);
//			System.out.println("t1 reverse map: "+t1ReverseMap);
//			
//			System.out.println("keysets in fileDataMap"+fileDataMap_corrected.keySet());
			
//			for (String f : fileDataMap_corrected.keySet()) {
//				System.out.println("========== fileDataMap_corrected =========== ");
//				System.out.println("all   : " + f + "::: " + fileDataMap_corrected.get(f).svList);
//				System.out.println("global: " + f + "::: " + fileDataMap_corrected.get(f).svList_global);
//				System.out.println("local : " + f + "::: " + fileDataMap_corrected.get(f).svList_local);
//			}
			
			
			/// prioritize data if redefined			
			Dataset model_data_complete = new Dataset();
			System.out.println("========== starting data prioritization =========== ");	
			
			/// previous globals have lowest priority
			model_data_complete.prioritize(adhoc_cumulative_globals, " cumulative adhoc globals");

			/// for kid
			for (String f : adhoc_include_previous_globals.incFileList) {
				
					model_data_complete.prioritizeChildren(f, t1Map, fileDataMap_corrected);
			}
			System.out.println("========== finish children prioritization =========== ");

			/// for include files in adhoc
			for (String f : adhoc_include_previous_globals.incFileList) {
				
				model_data_complete.prioritize(fileDataMap_corrected.get(f), f);
			}
			
			/// for vars in adhoc
			model_data_complete.prioritize(adhoc, absMainFilePath);
			
			/// update whole study
			adhoc_cumulative_globals.add(adhoc.getGlobalVars());
			
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
	
		
		
		System.out.println("All keyset: "+model_data_complete_map.keySet());
		
		
		
		return model_data_complete_map;
	}}
	
