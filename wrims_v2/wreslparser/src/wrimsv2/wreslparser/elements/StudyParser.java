package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;


public class StudyParser {
	
	public static StudyDataSet writeWreslData(StudyConfig sc, TempData td){
		
		StudyDataSet studyDataSet = new StudyDataSet();
		
		studyDataSet.setModelList(sc.modelList);
		studyDataSet.setModelConditionList(sc.modelConditionList);
		
		Map<String, ModelDataSet> modelDataSetMap = new HashMap<String, ModelDataSet>();
		
		for (String modelName: studyDataSet.getModelList()){
			
			SimulationDataSet ds = td.model_dataset_map.get(modelName);
			ModelDataSet thisModelDataSet = new ModelDataSet();

			thisModelDataSet.svDvList = ds.svDvList; 
			
			thisModelDataSet.dvList = ds.dvList; 
			thisModelDataSet.dvList_global = ds.dvList_global; 
			thisModelDataSet.dvList_local = ds.dvList_local; 
			thisModelDataSet.dvMap = ds.dvMap; 

			thisModelDataSet.svTsList = ds.svTsList; 
			thisModelDataSet.svTsList_global = ds.svTsList_global; 
			thisModelDataSet.svTsList_local = ds.svTsList_local; 
			thisModelDataSet.svTsMap = ds.svTsMap;
			
			thisModelDataSet.svList = ds.svList; 
			thisModelDataSet.svList_global = ds.svList_global; 
			thisModelDataSet.svList_local = ds.svList_local; 
			thisModelDataSet.svMap = ds.svMap;
			
			thisModelDataSet.gList = ds.gList; 
			thisModelDataSet.gList_global = ds.gList_global; 
			thisModelDataSet.gList_local = ds.gList_local; 
			thisModelDataSet.gMap = ds.gMap;

			thisModelDataSet.asList = ds.asList; 
			thisModelDataSet.asList_global = ds.asList_global; 
			thisModelDataSet.asList_local = ds.asList_local; 
			thisModelDataSet.asMap = ds.asMap;

			thisModelDataSet.exList = ds.exList; 
			thisModelDataSet.exList_global = ds.exList_global; 
			thisModelDataSet.exList_local = ds.exList_local; 
			thisModelDataSet.exMap = ds.exMap;
			
			thisModelDataSet.wtList = ds.wtList; 
			thisModelDataSet.wtMap = ds.wtMap;	
			
			thisModelDataSet.incFileList=ds.incFileList;
			thisModelDataSet.incFileList_global=ds.incFileList_global;
			thisModelDataSet.incFileList_local=ds.incFileList_local;
			
			modelDataSetMap.put(modelName, thisModelDataSet);
		}
		
		studyDataSet.setModelDataSetMap(modelDataSetMap);
		
		return studyDataSet;
	}
	
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
			
			sc.modelConditionList.add(sc.sequenceMap.get(i).condition);
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
			
			SimulationDataSet adhoc = sc.modelDataMap.get(modelName);
			
			/// get new dataset in this model
			Map<String,SimulationDataSet> fileDataMap_new = getNewDataSet(adhoc.incFileList, td.fileDataMap_wholeStudy.keySet());
			
			/// update whole study
			td.fileDataMap_wholeStudy.putAll(fileDataMap_new);
			/// update whole study t1Map
			td.t1Map_wholeStudy.putAll(Tools.getType1Map(fileDataMap_new));
			td.fileScopeMap_wholeStudy.putAll(Tools.getFileScopeMap(fileDataMap_new));
			
			
			/// copy file data map from updated whole study to this model
			Map<String,SimulationDataSet> fileDataMap_thisModel = copyDataSetToThisModel(adhoc.incFileList, td.fileDataMap_wholeStudy);
			
			
			/// correct scope and prioritize
			SimulationDataSet model_dataset = correctScopeAndPrioritize(modelName,
														adhoc,
														sc.absMainFilePath,
														fileDataMap_thisModel,
														td.fileDataMap_wholeStudy,  
														td.t1Map_wholeStudy,        
														td.fileScopeMap_wholeStudy
														);
			
			/// get whole study reverse map / TODO: not needed for global because source file is the same
			td.t1Map_wholeStudy.put(sc.absMainFilePath, adhoc.incFileList);
			Map<String,Set<String>> t1ReverseMap_wholeStudy = Tools.getReverseMap(td.t1Map_wholeStudy);
			
//			String ttt="";
//			Map<String,Set<String>> qwe = t1ReverseMap_wholeStudy;
//			for (String s : qwe.keySet()){
//				ttt = ttt + "{"+s+"}"+"::"+qwe.get(s);
//			}
//			LogUtils.errMsg(ttt);
			
			/// include global data
			/// previous globals have lowest priority /TODO: remove reverse map
			model_dataset.dePrioritize(td.cumulative_global_complete, "", t1ReverseMap_wholeStudy);	
			LogUtils.normalMsg("========== Finish cumulative globals prioritization =========== ");

			
		    model_dataset_map.put(modelName, model_dataset);
		    
			/// update/overwrite cumulative globals
			td.cumulative_global_adhocs.overwrittenWith(sc.modelDataMap.get(modelName).getGlobalVars());
			td.cumulative_global_complete.overwrittenWith(model_dataset.getGlobalVars());		    

		}
		return model_dataset_map;		
	}
	
	public static Map<String,SimulationDataSet> getNewDataSet(ArrayList<String> adhoc_incFileList, Set<String> fileDataMap_wholeStudy_keySet ) throws RecognitionException, IOException{
		
		Map<String,SimulationDataSet> fileDataMap_new = new HashMap<String, SimulationDataSet>();
		
		/// process include files in this model and those in previous globals
		for (String f: adhoc_incFileList) {
			
			if (fileDataMap_wholeStudy_keySet.contains(f))  {
				
				LogUtils.importantMsg("....Skip file: "+f);				
			} 
			else { /// new file
				Map<String, SimulationDataSet> each = FileParser.processNestedFileExceptFor(f,fileDataMap_wholeStudy_keySet);
				fileDataMap_new.putAll(each);

			}				
		}			
		return fileDataMap_new;
	}

	public static Map<String,SimulationDataSet> copyDataSetToThisModel(ArrayList<String> incFileList, 
																	   Map<String,SimulationDataSet> fileDataMap_wholeStudy ){
		
		/// get all file data map for this study
		Map<String,SimulationDataSet> fileDataMap_thisModel = new HashMap<String, SimulationDataSet>();		
						
			/// copy to this model
			for (String f: incFileList) {
			
				fileDataMap_thisModel.putAll(Tools.putDataFileMapFromWholeStudy(f,fileDataMap_wholeStudy));
			}
		
		return fileDataMap_thisModel;
		
	}
	
	public static SimulationDataSet correctScopeAndPrioritize( String modelName,
												SimulationDataSet adhoc,
												String absMainFilePath,
												Map<String,SimulationDataSet> fileDataMap_thisModel,
												Map<String, SimulationDataSet> fileDataMap_wholeStudy,
												Map<String,ArrayList<String>> t1Map_wholeStudy,
												Map<String,String> fileScopeMap_wholeStudy
												)
	
	throws RecognitionException, IOException {
			
			
			/// this model t1Map, fileScopeMap, and reverseMap /TODO: avoid repeated processing
			Map<String,String> fileScopeMap = new HashMap<String, String>(fileScopeMap_wholeStudy);
			fileScopeMap.putAll(Tools.getScopeMap(adhoc.incFileList, adhoc.incFileList_local));
			
			Map<String,ArrayList<String>> t1Map = new HashMap<String, ArrayList<String>>(t1Map_wholeStudy);
			t1Map.put(absMainFilePath, adhoc.incFileList);
			Map<String,Set<String>> t1ReverseMap = Tools.getReverseMap(t1Map);

			//////////////////////////////////////////////////////////////////////////////////////
			LogUtils.normalMsg(".....Finished fileScopeMap & ReverseMap.");
			
			Map<String,SimulationDataSet> fileDataMap_corrected = new HashMap<String, SimulationDataSet>();
			fileDataMap_corrected.putAll(fileDataMap_thisModel);			
			
			for (String f : fileDataMap_thisModel.keySet()) {

				SimulationDataSet ds = Tools.correctDataScope(f, fileDataMap_thisModel.get(f), fileScopeMap, t1ReverseMap);				
				fileDataMap_corrected.put(f, ds);
			}
			
//----------------------------------------------------------------------------------		
			/// prioritize data if redefined			
			SimulationDataSet model_dataset = new SimulationDataSet();
			LogUtils.normalMsg("========== Start data prioritization =========== ");	
			
			/// for kids
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
			model_dataset.prioritize(adhoc, absMainFilePath, t1ReverseMap);
			LogUtils.normalMsg("========== Finish adhoc prioritization =========== ");
//---------------------------------------------------------------------------------------			

		return model_dataset;
	}
	
	
	
}
