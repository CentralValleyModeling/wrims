package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime.RecognitionException;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class StudyParser{
	
  public static int total_errors = 0;
  public static int total_warnings = 0;
	
  public static StudyDataSet writeWreslData(StudyConfig sc, TempData td){
    StudyDataSet studyDataSet = new StudyDataSet();

    studyDataSet.setModelList(sc.modelList);
    studyDataSet.setModelConditionList(sc.modelConditionList);

    Map<String, ModelDataSet> modelDataSetMap = new HashMap<String, ModelDataSet>();
    Map<String, Timeseries> timeseriesMap = new HashMap<String, Timeseries>();

    for (String modelName : studyDataSet.getModelList())
    {
      SimulationDataSet ds = (SimulationDataSet)td.model_dataset_map.get(modelName);
      ModelDataSet thisModelDataSet = new ModelDataSet();

      thisModelDataSet.dvList = ds.dvList;
      thisModelDataSet.dvList_global = ds.dvList_global;
      thisModelDataSet.dvList_local = ds.dvList_local;
      thisModelDataSet.dvMap = ds.dvMap;

      thisModelDataSet.tsList = ds.tsList;
      thisModelDataSet.tsList_global = ds.tsList_global;
      thisModelDataSet.tsList_local = ds.tsList_local;
      thisModelDataSet.tsMap = ds.tsMap;

      thisModelDataSet.svSet_unknown = ds.svSet_unknown;
      thisModelDataSet.svList = ds.svList;
      thisModelDataSet.svList_global = ds.svList_global;
      thisModelDataSet.svList_local = ds.svList_local;
      thisModelDataSet.svMap = ds.svMap;

      thisModelDataSet.gList = ds.gList;
      thisModelDataSet.gList_global = ds.gList_global;
      thisModelDataSet.gList_local = ds.gList_local;
      thisModelDataSet.gMap = ds.gMap;

      thisModelDataSet.asSet_unknown = ds.asSet_unknown;
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

      thisModelDataSet.incFileList = ds.incFileList;
      thisModelDataSet.incFileList_global = ds.incFileList_global;
      thisModelDataSet.incFileList_local = ds.incFileList_local;

      modelDataSetMap.put(modelName, thisModelDataSet);
      timeseriesMap.putAll(ds.tsMap);
    }

    studyDataSet.setModelDataSetMap(modelDataSetMap);
    studyDataSet.setTimeseriesMap(timeseriesMap);

    return studyDataSet;
  }

  public static StudyConfig processMainFileIntoStudyConfig(String relativeMainFilePath) throws RecognitionException, IOException {
	    /// reset total errors
	    total_errors = 0;
    return processMainFileIntoStudyConfig(relativeMainFilePath, false);
  }

  public static StudyConfig processMainFileIntoStudyConfig(String relativeMainFilePath, boolean showTree) throws RecognitionException, IOException
  {
    File absMainFile = new File(relativeMainFilePath).getAbsoluteFile();
    String absMainFilePath = absMainFile.getCanonicalPath().toLowerCase();

    LogUtils.importantMsg("Parsing study main file: " + absMainFilePath);

    WreslTreeWalker walker = FileParser.parseFile(absMainFilePath, showTree);

    StudyConfig sc = new StudyConfig();

    sc.sequenceMap = walker.thisFileDataSet.seqMap;
    
	/// Sort sequence order
	
	for ( Integer i : sc.sequenceMap.keySet()){ sc.sequenceOrder.add(i); }
	Collections.sort(sc.sequenceOrder);

    for (Integer i : sc.sequenceOrder) {
      sc.sequenceList.add(((Sequence)sc.sequenceMap.get(i)).sequenceName);
      sc.modelList.add(((Sequence)sc.sequenceMap.get(i)).modelName);

      sc.modelConditionList.add(((Sequence)sc.sequenceMap.get(i)).condition);
    }

    sc.absMainFilePath = absMainFilePath;
    sc.modelDataMap = walker.modelDataMap;

    for (Integer i : sc.sequenceOrder) {
      LogUtils.importantMsg("Sequence: " + i + " : " + ((Sequence)sc.sequenceMap.get(i)).sequenceName + "   Model: " + ((Sequence)sc.sequenceMap.get(i)).modelName);
    }

    return sc;
  }

  public static Map<String, SimulationDataSet> parseModels(StudyConfig sc, TempData td) throws RecognitionException, IOException
  {
    return parseModels(sc, td, false);
  }

  public static Map<String, SimulationDataSet> parseModels(StudyConfig sc, TempData td, boolean rewrite_list_based_on_dependency) throws RecognitionException, IOException
  {
    Map<String, SimulationDataSet> model_dataset_map = new HashMap<String, SimulationDataSet>();

    for (Integer iSequence : sc.sequenceOrder)
    {
      String modelName = sc.sequenceMap.get(iSequence).modelName;

      LogUtils.importantMsg("Processing sequence: " + iSequence + ", model: " + modelName);

      SimulationDataSet adhoc = sc.modelDataMap.get(modelName);

      Map<String, SimulationDataSet> fileDataMap_new = getNewDataSet(adhoc.incFileSet, td.fileDataMap_wholeStudy.keySet());

      td.fileDataMap_wholeStudy.putAll(fileDataMap_new);

      td.t1Map_wholeStudy.putAll(Tools.getType1Map(fileDataMap_new));
      td.fileScopeMap_wholeStudy.putAll(Tools.getFileScopeMap(fileDataMap_new));

      Map<String, SimulationDataSet> fileDataMap_thisModel = copyDataSetToThisModel(adhoc.incFileSet, td.fileDataMap_wholeStudy);

      ArrayList<String> ordered_list_for_all_vars = getOrderedList(fileDataMap_thisModel, adhoc);
      

      Set<String> duplicates = Tools.removeDuplicates(ordered_list_for_all_vars);
      

      if (duplicates.size() > 0) {
        LogUtils.errMsg("Variables redefined in model " + modelName + ": " + duplicates);
      }

      
      SimulationDataSet model_dataset = correctScopeAndPrioritize(modelName, 
        adhoc, 
        sc.absMainFilePath, 
        fileDataMap_thisModel, 
        td.fileDataMap_wholeStudy, 
        td.t1Map_wholeStudy, 
        td.fileScopeMap_wholeStudy);

      model_dataset.svSet = Tools.restoreOrder(model_dataset.svList, ordered_list_for_all_vars, model_dataset.svSet);
      model_dataset.asSet = Tools.restoreOrder(model_dataset.asList, ordered_list_for_all_vars, model_dataset.asSet);

      td.t1Map_wholeStudy.put(sc.absMainFilePath, adhoc.incFileSet);
      Map<String, Set<String>> t1ReverseMap_wholeStudy = Tools.getReverseMap(td.t1Map_wholeStudy);

      
      ///////// add previous globals
      //LogUtils.importantMsg("Adding previous global vars into model: "+modelName);

      /// check for redefined weight // TODO: what to do?
      Set<String> redefined_globals_wt = new LinkedHashSet<String>(td.cumulative_global_complete.wtSet);
      redefined_globals_wt.retainAll(model_dataset.wtSet);
      if (redefined_globals_wt.size()>0) LogUtils.errMsg("Global weights redefined: "+ redefined_globals_wt); 
      
      /// check for redefined file
      Set<String> redefined_globals = new LinkedHashSet<String>(td.cumulative_global_complete.incFileSet);
      redefined_globals.retainAll(model_dataset.incFileSet_global);
      if (redefined_globals.size()>0) LogUtils.errMsg("Global include files redefined: "+ redefined_globals); 
      
      /// check for redefined globals        
      redefined_globals = new LinkedHashSet<String>(td.cumulative_global_complete.getAllVarsSet_except_file_and_weight());
      Set<String> redefined_globals_as_locals = new LinkedHashSet<String>(td.cumulative_global_complete.getAllVarsSet_except_file_and_weight());
      
      
      redefined_globals.retainAll(model_dataset.getAllGlobalVarsSet_except_file_and_weight());
      
      redefined_globals_as_locals.retainAll(model_dataset.getAllLocalVarsSet_except_file_and_weight());
      
      if (redefined_globals.size()>0) LogUtils.errMsg("Global variables redefined: "+ redefined_globals);
      if (redefined_globals_as_locals.size()>0) LogUtils.warningMsg("Global variables redefined as local: "+ redefined_globals_as_locals);
      
     
      
      /// add previous globals
      
      SimulationDataSet cumulative_global_remove_redefined = new SimulationDataSet(td.cumulative_global_complete);
      //cumulative_global_remove_redefined.overwrittenWith_set(td.cumulative_global_complete);
      cumulative_global_remove_redefined.remove_set(redefined_globals);
      cumulative_global_remove_redefined.remove_set(redefined_globals_as_locals);
      
      model_dataset.overwrite_set(cumulative_global_remove_redefined);

      //LogUtils.importantMsg("Finish adding previous global vars into model: "+modelName);
      /// finish adding globals
      
     
      lousyConvert(model_dataset);
      
      sortDependency(model_dataset, rewrite_list_based_on_dependency);  

      model_dataset_map.put(modelName, model_dataset);

      td.cumulative_global_adhocs.overwrittenWith_set(sc.modelDataMap.get(modelName).getGlobalVars_set());
      td.cumulative_global_complete.overwrittenWith_set(model_dataset.getGlobalVars_set());

      lousyConvert(td.cumulative_global_adhocs);
      lousyConvert(td.cumulative_global_complete);
    }


    return model_dataset_map;
    
  }

  public static Map<String, SimulationDataSet> getNewDataSet(Set<String> adhoc_incFileSet, Set<String> fileDataMap_wholeStudy_keySet) throws RecognitionException, IOException
  {
    Map<String, SimulationDataSet> fileDataMap_new = new HashMap<String, SimulationDataSet>();

    for (String f : adhoc_incFileSet)
    {
      if (fileDataMap_wholeStudy_keySet.contains(f))
      {
        continue;
      }

      Map<String, SimulationDataSet> each = FileParser.processNestedFileExceptFor(f, fileDataMap_wholeStudy_keySet);
      fileDataMap_new.putAll(each);
    }

    return fileDataMap_new;
  }

  public static Map<String, SimulationDataSet> copyDataSetToThisModel(Set<String> incFileSet, Map<String, SimulationDataSet> fileDataMap_wholeStudy)
  {
    Map<String, SimulationDataSet> fileDataMap_thisModel = new HashMap<String, SimulationDataSet>();

    for (String f : incFileSet)
    {
      fileDataMap_thisModel.putAll(Tools.putDataFileMapFromWholeStudy(f, fileDataMap_wholeStudy));
    }

    return fileDataMap_thisModel;
  }

  public static SimulationDataSet correctScopeAndPrioritize(String modelName, SimulationDataSet adhoc, String absMainFilePath, Map<String, SimulationDataSet> fileDataMap_thisModel, Map<String, SimulationDataSet> fileDataMap_wholeStudy, Map<String, Set<String>> t1Map_wholeStudy, Map<String, String> fileScopeMap_wholeStudy)
    throws RecognitionException, IOException
  {
    Map<String, String> fileScopeMap = new HashMap<String, String>(fileScopeMap_wholeStudy);
    fileScopeMap.putAll(Tools.getScopeMap(adhoc.incFileSet, adhoc.incFileSet_local));

    Map<String, Set<String>> t1Map = new HashMap<String, Set<String>>(t1Map_wholeStudy);
    t1Map.put(absMainFilePath, adhoc.incFileSet);
    Map<String, Set<String>> t1ReverseMap = Tools.getReverseMap(t1Map);

    Map<String, SimulationDataSet> fileDataMap_corrected = new HashMap<String, SimulationDataSet>(fileDataMap_thisModel);
    SimulationDataSet ds;
    for (String f : fileDataMap_thisModel.keySet())
    {
      ds = Tools.correctDataScope(f, (SimulationDataSet)fileDataMap_thisModel.get(f), fileScopeMap, t1ReverseMap);
      fileDataMap_corrected.put(f, ds);
    }

    SimulationDataSet model_dataset = new SimulationDataSet();

    for (String f : adhoc.incFileList)
    {
      SimulationDataSet temp = new SimulationDataSet();

      temp.addChildren(f, t1Map, fileDataMap_corrected);

      temp.overwrittenWith_set((SimulationDataSet)fileDataMap_corrected.get(f));

      model_dataset.overwrittenWith_set(temp);
    }

    model_dataset.overwrittenWith_set(adhoc);

    return model_dataset;
  }

  public static boolean sortDependency(SimulationDataSet model_dataset, boolean rewrite_list_based_on_dependency)
  {
    boolean OK = true;

    Sort sortSV = new Sort(model_dataset.svMap, model_dataset.tsSet);

    ArrayList<String> sortedSvList = new ArrayList<String>();

    Set<String> var_with_unknown = sortSV.sort(sortedSvList);
    if (var_with_unknown.size() > 0) OK = false;

    model_dataset.svSet_unknown = var_with_unknown;
    
    if (rewrite_list_based_on_dependency) {
      model_dataset.svList = sortedSvList;
      model_dataset.svList.addAll(model_dataset.svSet_unknown);
    }

    Sort sortAs = new Sort(model_dataset.asMap, model_dataset.svSet, model_dataset.dvSet, model_dataset.tsSet);

    ArrayList<String> sortedAsList = new ArrayList<String>();

    var_with_unknown = sortAs.sort(sortedAsList);
    if (var_with_unknown.size() > 0) OK = false;

    model_dataset.asSet_unknown = var_with_unknown;
    
    if (rewrite_list_based_on_dependency) {
      model_dataset.asList = sortedAsList;
      model_dataset.asList.addAll(model_dataset.asSet_unknown);
    }

    return OK;
  }

  public static void lousyConvert(SimulationDataSet q)
  {
    q.asList = new ArrayList<String>(q.asSet);
		q.asList_global = new ArrayList<String>(q.asSet_global);
		q.asList_local = new ArrayList<String>(q.asSet_local);

		q.wtList = new ArrayList<String>(q.wtSet);
		q.wtList_global = new ArrayList<String>(q.wtSet_global);
		q.wtList_local = new ArrayList<String>(q.wtSet_local);

		q.svList = new ArrayList<String>(q.svSet);
		q.svList_global = new ArrayList<String>(q.svSet_global);
		q.svList_local = new ArrayList<String>(q.svSet_local);

		q.dvList = new ArrayList<String>(q.dvSet);
		q.dvList_global = new ArrayList<String>(q.dvSet_global);
		q.dvList_local = new ArrayList<String>(q.dvSet_local);

		q.tsList = new ArrayList<String>(q.tsSet);
		q.tsList_global = new ArrayList<String>(q.tsSet_global);
		q.tsList_local = new ArrayList<String>(q.tsSet_local);

		q.exList = new ArrayList<String>(q.exSet);
		q.exList_global = new ArrayList<String>(q.exSet_global);
		q.exList_local = new ArrayList<String>(q.exSet_local);

		q.gList = new ArrayList<String>(q.gSet);
		q.gList_global = new ArrayList<String>(q.gSet_global);
		q.gList_local = new ArrayList<String>(q.gSet_local);
		
		q.incFileList = new ArrayList<String>(q.incFileSet);
		q.incFileList_global = new ArrayList<String>(q.incFileSet_global);
		q.incFileList_local = new ArrayList<String>(q.incFileSet_local);

    q.incFileList = new ArrayList<String>(q.incFileSet);
    q.incFileList_global = new ArrayList<String>(q.incFileSet_global);
    q.incFileList_local = new ArrayList<String>(q.incFileSet_local);
  }

  public static ArrayList<String> getOrderedList(Map<String, SimulationDataSet> fileDataMap_thisModel, SimulationDataSet adhoc)
  {
    Map<String, ArrayList<String>> orderListMap = new HashMap<String, ArrayList<String>>();

    ArrayList<String> complete_ordered_list = new ArrayList<String>();

    Sort sortFile = new Sort(fileDataMap_thisModel);

    ArrayList<String> sortedFileList = new ArrayList<String>();

    sortFile.sort(sortedFileList);

    //------------------------------------------------
    // initialize
    for (String f: sortedFileList){
    	ArrayList<String> toBeAdded = new ArrayList<String>(fileDataMap_thisModel.get(f).ordered_list_including_files);
    	orderListMap.put(f, toBeAdded);
    }
    
    // iterate

			for (String f : sortedFileList) {
				SimulationDataSet ds = fileDataMap_thisModel.get(f);

				ArrayList<String> new_ordered_list = new ArrayList<String>(ds.ordered_list_including_files);

				// System.out.println(" new ordered_list_include_files: " +
				// new_ordered_list);

				for (String inf : ds.incFileList) {
					ArrayList<String> toBeAdded = orderListMap.get(inf);

					// System.out.println(" new ordered_list before: " +
					// new_ordered_list);
					// System.out.println(" toBeAdded: " + toBeAdded);

					int pos = new_ordered_list.indexOf(inf);
					new_ordered_list.addAll(pos, toBeAdded);
					new_ordered_list.remove(inf);
				}
				orderListMap.put(f, new_ordered_list);
				//System.out.println(" order list Map: " + orderListMap);
			}



    //--------------------------------------------------

    complete_ordered_list = new ArrayList<String>(adhoc.ordered_list_including_files);

    for (String inf : adhoc.incFileList)
    {
      ArrayList<String> toBeAdded = orderListMap.get(inf);

      int pos = complete_ordered_list.indexOf(inf);
      complete_ordered_list.addAll(pos, toBeAdded);
      complete_ordered_list.remove(inf);
    }
    return complete_ordered_list;
  }
}