package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;

import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;



public class StudyParser {

	
	
	
	public static StudyConfig processMainFileIntoStudyConfig(String relativeMainFilePath) throws RecognitionException, IOException {
		
		File absMainFile = new File(relativeMainFilePath).getAbsoluteFile();
		String absMainFilePath = absMainFile.getCanonicalPath().toLowerCase();
		
		LogUtils.importantMsg("Parsing study main file: " + absMainFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absMainFilePath);
		
		StudyConfig sc = new StudyConfig();

		sc.sequenceMap = walker.mainDataSet.seqMap;
		
		/// Sort sequence order
		ArrayList<Integer> sequenceOrder = new ArrayList<Integer>();		
		for ( Integer i : sc.sequenceMap.keySet()){ sequenceOrder.add(i); }
		Collections.sort(sequenceOrder);

		
		ArrayList<String> sequenceList = new ArrayList<String>();
		for ( Integer i : sequenceOrder){ 
			sequenceList.add(sc.sequenceMap.get(i).sequenceName);
		}
		
		sc.sequenceList = sequenceList;
		sc.sequenceOrder = sequenceOrder;

		sc.absMainFilePath = absMainFilePath;
		sc.modelDataMap = walker.modelDataMap;

				
		for ( Integer i : sc.sequenceOrder){	
			LogUtils.importantMsg("Sequence: "+i+" : "+sc.sequenceMap.get(i).sequenceName +"   Model: "+sc.sequenceMap.get(i).modelName);		
		}	
		
		return sc;
	}


	
	public static Map<String, SimulationDataSet> parseSubFiles(StudyConfig sc) throws RecognitionException, IOException {
 		
		String absMainFilePath = sc.absMainFilePath;

		Map<Integer, Sequence> seqMap = sc.sequenceMap;
		
	
						
		
		Map<String,SimulationDataSet> fileDataMap_wholeStudy = new HashMap<String, SimulationDataSet>() ;
		Map<String,ArrayList<String>> t1Map_wholeStudy = new HashMap<String, ArrayList<String>>();	
		Map<String,String> fileScopeMap_wholeStudy = new HashMap<String, String>();	

		/// this map will collect detailed info for models			
		Map<String, SimulationDataSet> model_data_complete_map =  new HashMap<String, SimulationDataSet>();
		
		/// cumulative global vars and include files
		SimulationDataSet adhoc_cumulative_globals = new SimulationDataSet();

		/// for each model collected from the main files
//###################################################################################################		
		for ( Integer iSequence : sc.sequenceOrder){	

			String model = seqMap.get(iSequence).modelName;
		
			LogUtils.importantMsg("Processing sequence: "+iSequence+", model: "+model);

			
			SimulationDataSet adhoc = sc.modelDataMap.get(model);

			
			SimulationDataSet adhoc_include_previous_globals = new SimulationDataSet(adhoc);
			adhoc_include_previous_globals.addNonDuplicate(adhoc_cumulative_globals);
			

			
//			Set<String> filesDataToCopy = new HashSet<String>();
//			filesDataToCopy.addAll(adhoc.incFileList);
//			filesDataToCopy.addAll(adhoc_cumulative_globals.incFileList);
			
			Set<String> existingSet = fileDataMap_wholeStudy.keySet();
			
			Map<String,SimulationDataSet> fileDataMap_newInModel = new HashMap<String, SimulationDataSet>() ;			
			/// get all file data map for this study
			Map<String,SimulationDataSet> fileDataMap_thisModel = new HashMap<String, SimulationDataSet>();
			
			
			

			/// process include files in this model and those in previous globals
			for (String f: adhoc_include_previous_globals.incFileList) {
				
				if (existingSet.contains(f))  {
					/// skip processing
					LogUtils.normalMsg("....Skip file: "+f);
					fileDataMap_thisModel.put(f, fileDataMap_wholeStudy.get(f));
					fileDataMap_thisModel.putAll(Tools.getAllOffSprings(f, t1Map_wholeStudy, fileDataMap_wholeStudy));
					
					//System.out.println("....got data from previous models." );
					/// TODO: need to put file f's children dataset					

				} 
				else { /// new file
					//Map<String, SimulationDataSet> each = FileParser.processNestedFileExceptFor(f,existingSet);
					//fileDataMap_newInModel.putAll(each);
					//fileDataMap_wholeStudy.putAll(each);
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
			LogUtils.normalMsg(".....Finished fileScopeMap & ReverseMap.");
			
			
			Map<String,SimulationDataSet> fileDataMap_corrected = new HashMap<String, SimulationDataSet>();
			fileDataMap_corrected.putAll(fileDataMap_thisModel);
			
			//System.out.println("keysets in corrected"+fileDataMap_corrected.keySet());
			
			for (String f : fileDataMap_thisModel.keySet()) {

				SimulationDataSet ds = Tools.correctDataScope(f, fileDataMap_thisModel.get(f), fileScopeMap, t1ReverseMap);
				
				fileDataMap_corrected.put(f, ds);
				
			}

			
			
			/// prioritize data if redefined			
			SimulationDataSet model_data_complete = new SimulationDataSet();
			LogUtils.normalMsg("========== Start data prioritization =========== ");	
			
			/// previous globals have lowest priority
			model_data_complete.prioritize(adhoc_cumulative_globals, " cumulative adhoc globals", t1ReverseMap);	
			LogUtils.normalMsg("========== Finish initial prioritization =========== ");
			
			/// for kid
			for (String f : adhoc_include_previous_globals.incFileList) {
					
				LogUtils.normalMsg("========== Prioritize offsprings in file: "+f);
					model_data_complete.prioritizeChildren(f, t1Map, fileDataMap_corrected, t1ReverseMap);
					
			}
			LogUtils.normalMsg("========== Finish children prioritization =========== ");
			
			/// for include files in adhoc
			for (String f : adhoc_include_previous_globals.incFileList) {
				

                LogUtils.normalMsg("========== Prioritize adhoc include file: "+f);
				model_data_complete.prioritize(fileDataMap_corrected.get(f), f, t1ReverseMap);

			}
			
			/// for vars in adhoc
			LogUtils.normalMsg("========== Prioritize adhoc =========== ");
			model_data_complete.prioritize(adhoc, absMainFilePath, t1ReverseMap);
			LogUtils.normalMsg("========== Finish adhoc prioritization =========== ");
			LogUtils.normalMsg("========== Finish all prioritization =========== ");
			
			/// update whole study
			adhoc_cumulative_globals.add(adhoc.getGlobalVars());
			



//				System.out.println("all   : " + model_data_complete.svList);
//				System.out.println("global: " + model_data_complete.svList_global);
//				System.out.println("local : " + model_data_complete.svList_local);
			
			
			//////////////////////////////////////////
			
			model_data_complete_map.put(model, model_data_complete);
			
			//System.out.println(" weight table keys: "+ model_data_complete.wtMap.keySet());
			
			LogUtils.importantMsg("Finished processing sequence: "+iSequence+", model: "+model);

		}

		LogUtils.importantMsg("Finished all data processing");


		
		//LogUtils.importantMsg("All keyset: "+model_data_complete_map.keySet());
		
		
		
		return model_data_complete_map;
	}
	
	
}
