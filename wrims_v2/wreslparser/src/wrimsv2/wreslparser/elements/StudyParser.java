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

//	public static Map<String,SimulationDataSet> fileDataMap_wholeStudy = new HashMap<String, SimulationDataSet>() ;	
//	public static Map<String,ArrayList<String>> t1Map_wholeStudy = new HashMap<String, ArrayList<String>>();	
//	public static Map<String,String> fileScopeMap_wholeStudy = new HashMap<String, String>();	
//	
//	/// this map will collect detailed info for models			
//	//public static Map<String, SimulationDataSet> model_dataset_map =  new HashMap<String, SimulationDataSet>();
//
//	/// map of model's global adhocs
//	public static Map<String, SimulationDataSet> model_global_adhoc_map = new HashMap<String, SimulationDataSet>();
//	
//	/// cumulative global vars and include files
//	public static SimulationDataSet cumulative_global_adhocs = new SimulationDataSet();

	
		
	public static StudyConfig processMainFileIntoStudyConfig(String relativeMainFilePath) throws RecognitionException, IOException {
		
		File absMainFile = new File(relativeMainFilePath).getAbsoluteFile();
		String absMainFilePath = absMainFile.getCanonicalPath().toLowerCase();
		
		LogUtils.importantMsg("Parsing study main file: " + absMainFilePath);
		
		WreslTreeWalker walker = FileParser.parseFile(absMainFilePath);
		
		StudyConfig sc = new StudyConfig();

		sc.sequenceMap = walker.thisFileDataSet.seqMap;
		
		/// Sort sequence order
		
		for ( Integer i : sc.sequenceMap.keySet()){ sc.sequenceOrder.add(i); }
		Collections.sort(sc.sequenceOrder);

		for ( Integer i : sc.sequenceOrder){ 
			sc.sequenceList.add(sc.sequenceMap.get(i).sequenceName);
			sc.modelList.add(sc.sequenceMap.get(i).modelName);
		}		

		sc.absMainFilePath = absMainFilePath;
		sc.modelDataMap = walker.modelDataMap;
				
		for ( Integer i : sc.sequenceOrder){	
			LogUtils.importantMsg("Sequence: "+i+" : "+sc.sequenceMap.get(i).sequenceName +"   Model: "+sc.sequenceMap.get(i).modelName);		
		}	
		
		return sc;
	}
	
	public static Map<String, SimulationDataSet> parseModels(StudyConfig sc, TempData td) throws RecognitionException, IOException {

		Map<String, SimulationDataSet> model_dataset_map = new HashMap<String, SimulationDataSet>();
		
		for ( Integer iSequence : sc.sequenceOrder){	

			String modelName = sc.sequenceMap.get(iSequence).modelName;
		
			LogUtils.importantMsg("Processing sequence: "+iSequence+", model: "+modelName);
			
			SimulationDataSet model_dataset = parseModel(modelName, sc, 
														td.fileDataMap_wholeStudy, td.t1Map_wholeStudy,
														td.fileScopeMap_wholeStudy, td.cumulative_global_adhocs );
		
		    model_dataset_map.put(modelName, model_dataset);
		}
		return model_dataset_map;		
	}

	
	public static SimulationDataSet parseModel( String modelName, StudyConfig studyConfig, 
												Map<String, SimulationDataSet> fileDataMap_wholeStudy,
												Map<String,ArrayList<String>> t1Map_wholeStudy,
												Map<String,String> fileScopeMap_wholeStudy,
												SimulationDataSet cumulative_global_adhocs
												)
	
	throws RecognitionException, IOException {

		SimulationDataSet adhoc = studyConfig.modelDataMap.get(modelName);
		
		Map<String,SimulationDataSet> fileDataMap_new = new HashMap<String, SimulationDataSet>() ;			
		/// get all file data map for this study
		Map<String,SimulationDataSet> fileDataMap_thisModel = new HashMap<String, SimulationDataSet>();
			
			/// process include files in this model and those in previous globals
			for (String f: adhoc.incFileList) {
				
				if (fileDataMap_wholeStudy.keySet().contains(f))  {
					/// skip processing and get data from fileDataMap_wholeStudy
					LogUtils.importantMsg("....Skip file: "+f);
					fileDataMap_thisModel.put(f, fileDataMap_wholeStudy.get(f));
					fileDataMap_thisModel.putAll(Tools.getAllOffSprings(f, t1Map_wholeStudy, fileDataMap_wholeStudy));
					/// TODO: need to put file f's children dataset					
				} 
				else { /// new file
					Map<String, SimulationDataSet> each = FileParser.processNestedFileExceptFor(f,fileDataMap_wholeStudy.keySet());
					fileDataMap_new.putAll(each);
					fileDataMap_wholeStudy.putAll(each);
				}				
			}		
			
			/// copy to this model
			for (String f: adhoc.incFileList) {
			
				fileDataMap_thisModel.putAll(Tools.putDataFileMapFromWholeStudy(f,fileDataMap_wholeStudy));
			}
				
			/// get fileScopeMap and ReverseMap
			/// TODO: avoid repeated processing
			
			////// update whole study t1Map
			t1Map_wholeStudy.putAll(Tools.getType1Map(fileDataMap_new));
			fileScopeMap_wholeStudy.putAll(Tools.getFileScopeMap(fileDataMap_new));
		    //////////////////////////////////////////////////////////////////////////////
			
			/// this model t1Map, fileScopeMap, and reverseMap
			Map<String,String> fileScopeMap = new HashMap<String, String>(fileScopeMap_wholeStudy);
			fileScopeMap.putAll(Tools.getScopeMap(adhoc.incFileList, adhoc.incFileList_local));
			
			Map<String,ArrayList<String>> t1Map = new HashMap<String, ArrayList<String>>(t1Map_wholeStudy);
			t1Map.put(studyConfig.absMainFilePath, adhoc.incFileList);
			
			//Map<String,ArrayList<String>> t1ReverseMap = Tools.getReverseMap(t1Map);
			Map<String,Set<String>> t1ReverseMap = Tools.getReverseMap(t1Map);

			//////////////////////////////////////////////////////////////////////////////////////
			LogUtils.normalMsg(".....Finished fileScopeMap & ReverseMap.");
			
			
			Map<String,SimulationDataSet> fileDataMap_corrected = new HashMap<String, SimulationDataSet>();
			fileDataMap_corrected.putAll(fileDataMap_thisModel);
			
			
			for (String f : fileDataMap_thisModel.keySet()) {

				SimulationDataSet ds = Tools.correctDataScope(f, fileDataMap_thisModel.get(f), fileScopeMap, t1ReverseMap);
				
				fileDataMap_corrected.put(f, ds);
				
			}
		
			
			/// prioritize data if redefined			
			SimulationDataSet model_dataset = new SimulationDataSet();
			LogUtils.normalMsg("========== Start data prioritization =========== ");	
			
			/// previous globals have lowest priority
			model_dataset.prioritize(cumulative_global_adhocs, " cumulative adhoc globals", t1ReverseMap);	
			LogUtils.normalMsg("========== Finish initial prioritization =========== ");
			
			/// for kid
			for (String f : adhoc.incFileList) {
					
				LogUtils.normalMsg("========== Prioritize offsprings in file: "+f);
					model_dataset.prioritizeChildren(f, t1Map, fileDataMap_corrected, t1ReverseMap);
					
			}
			LogUtils.normalMsg("========== Finish children prioritization =========== ");
			
			/// for include files in adhoc
			for (String f : adhoc.incFileList) {
				
                LogUtils.normalMsg("========== Prioritize adhoc include file: "+f);
				model_dataset.prioritize(fileDataMap_corrected.get(f), f, t1ReverseMap);

			}
			
			/// for vars in adhoc
			LogUtils.normalMsg("========== Prioritize adhoc =========== ");
			model_dataset.prioritize(adhoc, studyConfig.absMainFilePath, t1ReverseMap);
			LogUtils.normalMsg("========== Finish adhoc prioritization =========== ");
			LogUtils.normalMsg("========== Finish all prioritization =========== ");
			
			/// update whole study
			cumulative_global_adhocs.add(adhoc.getGlobalVars());
		
		return model_dataset;
	}
	
	
	public static Map<String, SimulationDataSet> parseSubFiles(StudyConfig sc) throws RecognitionException, IOException {
 
		Map<String,SimulationDataSet> fileDataMap_wholeStudy = new HashMap<String, SimulationDataSet>() ;	
		Map<String,ArrayList<String>> t1Map_wholeStudy = new HashMap<String, ArrayList<String>>();	
		Map<String,String> fileScopeMap_wholeStudy = new HashMap<String, String>();	
		
		/// this map will collect detailed info for models			
		//public static Map<String, SimulationDataSet> model_dataset_map =  new HashMap<String, SimulationDataSet>();

		new HashMap<String, SimulationDataSet>();
		
		/// cumulative global vars and include files
		SimulationDataSet cumulative_global_adhocs = new SimulationDataSet();

		
		Map<String, SimulationDataSet> model_dataset_map =  new HashMap<String, SimulationDataSet>();


		/// for each model collected from the main files
//###################################################################################################		
		for ( Integer iSequence : sc.sequenceOrder){	

			String model = sc.sequenceMap.get(iSequence).modelName;
		
			LogUtils.importantMsg("Processing sequence: "+iSequence+", model: "+model);

			
			SimulationDataSet adhoc = sc.modelDataMap.get(model);

			
			SimulationDataSet adhoc_include_previous_globals = new SimulationDataSet(adhoc);
			adhoc_include_previous_globals.addNonDuplicate(cumulative_global_adhocs);
			


			
			Map<String,SimulationDataSet> fileDataMap_newInModel = new HashMap<String, SimulationDataSet>() ;			
			/// get all file data map for this study
			Map<String,SimulationDataSet> fileDataMap_thisModel = new HashMap<String, SimulationDataSet>();
			
			
			

			/// process include files in this model and those in previous globals
			for (String f: adhoc_include_previous_globals.incFileList) {
				
				if (fileDataMap_wholeStudy.keySet().contains(f))  {
					/// skip processing
					LogUtils.importantMsg("....Skip file: "+f);
					fileDataMap_thisModel.put(f, fileDataMap_wholeStudy.get(f));
					fileDataMap_thisModel.putAll(Tools.getAllOffSprings(f, t1Map_wholeStudy, fileDataMap_wholeStudy));
					
					//System.out.println("....got data from previous models." );
					/// TODO: need to put file f's children dataset					

				} 
				else { /// new file
					Map<String, SimulationDataSet> each = FileParser.processNestedFileExceptFor(f,fileDataMap_wholeStudy.keySet());
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
			t1Map.put(sc.absMainFilePath, adhoc_include_previous_globals.incFileList);
			
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
			model_data_complete.prioritize(cumulative_global_adhocs, " cumulative adhoc globals", t1ReverseMap);	
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
			model_data_complete.prioritize(adhoc, sc.absMainFilePath, t1ReverseMap);
			LogUtils.normalMsg("========== Finish adhoc prioritization =========== ");
			LogUtils.normalMsg("========== Finish all prioritization =========== ");
			
			/// update whole study
			cumulative_global_adhocs.add(adhoc.getGlobalVars());
			



//				System.out.println("all   : " + model_data_complete.svList);
//				System.out.println("global: " + model_data_complete.svList_global);
//				System.out.println("local : " + model_data_complete.svList_local);
			
			
			//////////////////////////////////////////
			
			model_dataset_map.put(model, model_data_complete);
			
			//System.out.println(" weight table keys: "+ model_data_complete.wtMap.keySet());
			
			LogUtils.importantMsg("Finished processing sequence: "+iSequence+", model: "+model);

		}

		LogUtils.importantMsg("Finished all data processing");


		
		//LogUtils.importantMsg("All keyset: "+model_data_complete_map.keySet());
		
		
		
		return model_dataset_map;
	}
	
	
}
