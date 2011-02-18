package evaluators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import wresl.ConvertWreslParser;

import evaluators.LogUtils;

public class StudyParser {
	
	
	public static StudyConfig processMainFileIntoStudyConfig(String relativeMainFilePath) throws RecognitionException, IOException {
		
		File absMainFile = new File(relativeMainFilePath).getAbsoluteFile();
		String absMainFilePath = absMainFile.getCanonicalPath().toLowerCase();
		
		LogUtils.importantMsg("Parsing study main file: " + absMainFilePath);
		
		ConvertWreslParser parser = FileParser.parseFile(absMainFilePath);
		

		Map<String, Dataset> modelAdhocMap = new HashMap<String, Dataset>();
		StudyConfig sc = new StudyConfig();

		Dataset dataset = Tools.convertStructToDataset(parser.F);
		sc.sequenceMap = dataset.seqMap;
		
		ArrayList<Integer> sequenceOrder = new ArrayList<Integer>();		
		for ( Integer i : sc.sequenceMap.keySet()){ sequenceOrder.add(i); }
		Collections.sort(sequenceOrder);
		sc.sequenceOrder = sequenceOrder;

		for (Integer i : sequenceOrder){
			String modelName = sc.sequenceMap.get(i).modelName;

			if (!parser.F.model_list.contains(modelName)){
				LogUtils.errMsg(" This model doesn't exist: "+ modelName, absMainFilePath);
				
			}
		}
		
		if ( ! parser.F.model_list.isEmpty()){
			
			modelAdhocMap.putAll( Tools.convertStructMapToDatasetMap(parser.modelMap) );
		}
		else { LogUtils.errMsg(" No models found ", absMainFilePath); }

		sc.absMainFilePath = absMainFilePath;
		sc.modelAdhocMap = modelAdhocMap;

		sc.sequenceMap = dataset.seqMap;
				
		for ( Integer i : sc.sequenceOrder){	
			LogUtils.importantMsg("sequence: "+i+" : "+sc.sequenceMap.get(i).modelName);		
		}	
		
		return sc;
	}


	
	public static Map<String, Dataset> parseSubFiles(StudyConfig sc) throws RecognitionException, IOException {
 		
		String absMainFilePath = sc.absMainFilePath;

		Map<Integer, Sequence> seqMap = sc.sequenceMap;
		
	
						
		
		Map<String,Dataset> fileDataMap_wholeStudy = new HashMap<String, Dataset>() ;
		Map<String,ArrayList<String>> t1Map_wholeStudy = new HashMap<String, ArrayList<String>>();	
		Map<String,String> fileScopeMap_wholeStudy = new HashMap<String, String>();	

		/// this map will collect detailed info for models			
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		/// cumulative global vars and include files
		Dataset adhoc_cumulative_globals = new Dataset();

		/// for each model collected from the main files
//###################################################################################################		
		for ( Integer iSequence : sc.sequenceOrder){	

			String model = seqMap.get(iSequence).modelName;
		
			LogUtils.importantMsg("Processing sequence: "+iSequence+", model: "+model);

			
			Dataset adhoc = sc.modelAdhocMap.get(model);

			
			Dataset adhoc_include_previous_globals = new Dataset(adhoc);
			adhoc_include_previous_globals.addNonDuplicate(adhoc_cumulative_globals);
			

			
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
					LogUtils.normalMsg("....Skip file: "+f);
					fileDataMap_thisModel.put(f, fileDataMap_wholeStudy.get(f));
					fileDataMap_thisModel.putAll(Tools.getAllOffSprings(f, t1Map_wholeStudy, fileDataMap_wholeStudy));
					
					//System.out.println("....got data from previous models." );
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
			LogUtils.normalMsg(".....Finished fileScopeMap & ReverseMap.");
			
			
			Map<String,Dataset> fileDataMap_corrected = new HashMap<String, Dataset>();
			fileDataMap_corrected.putAll(fileDataMap_thisModel);
			
			//System.out.println("keysets in corrected"+fileDataMap_corrected.keySet());
			
			for (String f : fileDataMap_thisModel.keySet()) {

				Dataset ds = Tools.correctDataScope(f, fileDataMap_thisModel.get(f), fileScopeMap, t1ReverseMap);
				
				fileDataMap_corrected.put(f, ds);
				
			}

			
			
			/// prioritize data if redefined			
			Dataset model_data_complete = new Dataset();
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
	}}
	
