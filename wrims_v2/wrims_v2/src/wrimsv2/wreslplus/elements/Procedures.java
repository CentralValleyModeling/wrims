package wrimsv2.wreslplus.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.javatuples.Triplet;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.components.ControlData;
import wrimsv2.components.IntDouble;
import wrimsv2.wreslparser.elements.LogUtils;

public class Procedures {

	private Procedures() {
	}

	public static void processDependants(StudyTemp s) {

		for (String m : s.modelList_effective) {

			ModelTemp mObj = s.modelMap.get(m);

			processDependants(mObj);

		}
		
		for (String m : s.incModelList_effective) {

			ModelTemp mObj = s.modelMap.get(m);

			processDependants(mObj);

		}

	}

	public static void processDependants(ModelTemp mObj) {

		for (String key : mObj.svMap.keySet()) {

			SvarTemp svObj = mObj.svMap.get(key);

			svObj.dependants.removeAll(Param.reservedSet);
		}

		for (String key : mObj.glMap.keySet()) {

			GoalTemp svObj = mObj.glMap.get(key);

			svObj.dependants.removeAll(Param.reservedSet);

		}

		for (String key : mObj.asMap.keySet()) {

			AliasTemp asObj = mObj.asMap.get(key);

			asObj.dependants.removeAll(Param.reservedSet);

		}

	}

	public static void copyModelVarMapToSequenceVarMap(StudyTemp st) {
		
		
		
		for (String seqName : st.seqList) {
			
			SequenceTemp seqObj = st.seqMap.get(seqName);
			ModelTemp seqModelObj = st.modelMap.get(seqObj.model);

			seqObj.svIncFileList_post = seqModelObj.svIncFileList_post;
			seqObj.asIncFileList_post = seqModelObj.asIncFileList_post;
			seqObj.exIncFileList_post = seqModelObj.exIncFileList_post;
			seqObj.incFileAbsPathList_post = seqModelObj.incFileAbsPathList_post;
			seqObj.incFileRelativePathList_post = seqModelObj.incFileRelativePathList_post;
			
			if (st.allOffspringMap_incModel.keySet().contains(seqObj.model)) {
				for (String f: st.allOffspringMap_incModel.get(seqObj.model)) {
				
					ModelTemp incModel = st.modelMap.get(f);
				

					copyModelVarMapToSequenceVarMap(incModel, seqObj);

					
				}
			}
			

			for (String f: seqModelObj.incFileRelativePathList_post){
				
				ModelTemp incModel = st.fileModelDataTable.get(f, st.fileModelNameMap.get(f).get(0));
				
				copyModelVarMapToSequenceVarMap(incModel, seqObj);
			
			}

			copyModelVarMapToSequenceVarMap(seqModelObj, seqObj);

		}
		
	}

	public static void copyModelVarMapToSequenceVarMap(ModelTemp mt, SequenceTemp seq) {
		
		for (String cycleName: mt.neededCycleVarMap.keySet()){
		
			if (seq.neededCycleVarMap.containsKey(cycleName)){
				
				seq.neededCycleVarMap.get(cycleName).addAll(mt.neededCycleVarMap.get(cycleName));
			}
			else {
				seq.neededCycleVarMap.put(cycleName, mt.neededCycleVarMap.get(cycleName));
			}
		}
		
		seq.wvList.addAll(mt.wvList_post);
		seq.wTableObjList.addAll(mt.wTableObjList);
		seq.exList.addAll(mt.exList);
		seq.dvList.addAll(mt.dvList);
		seq.dvList_deviationSlackSurplus.addAll(mt.dvList_deviationSlackSurplus);
		seq.deviationSlackSurplus_toleranceMap.putAll(mt.deviationSlackSurplus_toleranceMap);
		
		seq.asList.addAll(mt.asList); 
		seq.glList.addAll(mt.glList);
		seq.gl2List.addAll(mt.gl2List);
		seq.tsList.addAll(mt.tsList);
		
		seq.ssList_hasCase.addAll(mt.ssList_hasCase);
		seq.ssList_noCase.addAll(mt.ssList_noCase);
		
		
		seq.svMap.putAll(mt.svMap);
		seq.dvMap.putAll(mt.dvMap);
		seq.asMap.putAll(mt.asMap);
		seq.glMap.putAll(mt.glMap);
		seq.exMap.putAll(mt.exMap);
		seq.tsMap.putAll(mt.tsMap);
		
		
		seq.ssMap_hasCase.putAll(mt.ssMap_hasCase);
		seq.ssWeightMap_hasCase.putAll(mt.ssWeightMap_hasCase);
		seq.ssMap_noCase.putAll(mt.ssMap_noCase);
		seq.ssWeightMap_noCase.putAll(mt.ssWeightMap_noCase);	
		
		seq.groupWeightMap.putAll(mt.groupWeightMap);
		
	}
	
	public static void convertAliasToGoal(StudyTemp s) {

		
		for (String se : s.seqList){
			
			SequenceTemp seqObj = s.seqMap.get(se); 

			convertAliasToGoal(seqObj);				
			
		}

	}

	public static void convertAliasToGoal(SequenceTemp seqObj) {

		Set<String> allDepInGoals = new HashSet<String>();

		// add all dep from Goal
		for (String key : seqObj.glMap.keySet()) {

			GoalTemp g = seqObj.glMap.get(key);
			allDepInGoals.addAll(g.dependants);
			allDepInGoals.retainAll(seqObj.asList);
		}

		// TODO: slow algorithm. need to improve.

		boolean hasNewItem = true;
		HashSet<String> t;
		
		while (hasNewItem) {
			
			t = new HashSet<String>();
			
			for (String key : allDepInGoals) {

				AliasTemp a = seqObj.asMap.get(key);
			
				t.addAll(a.dependants);
			}
			
			t.removeAll(allDepInGoals);
			t.retainAll(seqObj.asList);
			allDepInGoals.addAll(t);
			
			hasNewItem = t.size()>0 ;
		}
		
		
//		// add all dep from Alias
//		for (String key : seqObj.asMap.keySet()) {
//
//			AliasTemp a = seqObj.asMap.get(key);
//			allDepInGoals.addAll(a.dependants);
//		}

		for (String aKey : seqObj.asMap.keySet()) {

			if (allDepInGoals.contains(aKey)) {

				AliasTemp a = seqObj.asMap.get(aKey);
				a.isMovedToDvar = true;

				// add to dvar
				DvarTemp d = new DvarTemp();
				d.id = a.id;
				d.upperBound = Param.upper_unbounded;
				d.lowerBound = Param.lower_unbounded;
				d.kind = a.kind;
				d.units = a.units;
				d.fromWresl = a.fromWresl;
				d.condition = a.condition;
				d.isFromAlias = true;

				seqObj.asList.remove(aKey);
				seqObj.asIncFileList_post.remove(aKey);
				seqObj.dvList_fromAlias.add(aKey);
				//seqObj.dvList.add(aKey);
				seqObj.dvMap.put(aKey, d);

				// add goal
				GoalTemp g = new GoalTemp();
				g.isFromAlias=true;
				g.fromWresl = a.fromWresl;
				g.id = a.id + "__alias";
				// String e = a.id.toLowerCase() + "=" + a.expression;
				g.caseExpression.add(a.id.toLowerCase() + "=" + a.expression);
				g.condition = a.condition;
				g.caseName.add(Param.defaultCaseName);
				g.caseCondition.add(Param.always);
				g.dependants = a.dependants;

				seqObj.glList_fromAlias.add(g.id.toLowerCase());
				//seqObj.glList.add(g.id.toLowerCase());
				seqObj.glMap.put(g.id.toLowerCase(), g);

			}

		}

	}	
	
	
	public static void postProcessIncFileList(StudyTemp st) {
		
		// use the fileGroupOrder
		for (HashSet<String> fgroup: st.fileGroupOrder){
			
			for ( String f : fgroup){
				
				if (!st.allOffspringMap.keySet().contains(f)) continue; // TODO: the whole first round can be skipped
				
						
				//Pair<String,String> p = new Pair<String, String>(f, st.fileModelNameMap.get(f).get(0));
				
				//ModelTemp m = st.fileModelDataMap.get(p);
				ModelTemp m = st.fileModelDataTable.get(f,st.fileModelNameMap.get(f).get(0));
				ArrayList<String> list_post1 = m.incFileAbsPathList_post;
				ArrayList<String> list_post2 = m.incFileRelativePathList_post;
				
				
				for( String includedFile: st.allOffspringMap.get(f)){
					int index =list_post1.indexOf(includedFile);
					
					
					//Pair<String,String> p2 = new Pair<String, String>(includedFile, st.fileModelNameMap.get(includedFile).get(0));
					
					//ModelTemp includedModel = st.fileModelDataMap.get(p2);
					
					ModelTemp includedModel = st.fileModelDataTable.get(includedFile, st.fileModelNameMap.get(includedFile).get(0));
					list_post1.addAll(index+1, includedModel.incFileAbsPathList_post); 
					list_post2.addAll(index+1, includedModel.incFileRelativePathList_post); 
					
				}
			}
		}
		
		// process the main file includes
		// TODO: replace effective list with seq. 
		for (String fi : st.modelList_effective){
			
			ModelTemp m = st.modelMap.get(fi);
			
			for (String includedFile: m.incFileRelativePathList ){
				
				int index = m.incFileRelativePathList.indexOf(includedFile);
	
				//Pair<String,String> p2 = new Pair<String, String>(includedFile, st.fileModelNameMap.get(includedFile).get(0));
				
				//ModelTemp includedModel = st.fileModelDataMap.get(p2);
				
				ModelTemp includedModel = st.fileModelDataTable.get(includedFile, st.fileModelNameMap.get(includedFile).get(0));
				
				m.incFileRelativePathList_post.addAll(index+1, includedModel.incFileRelativePathList_post);
				m.incFileAbsPathList_post.addAll(index+1, includedModel.incFileAbsPathList_post);
	
				
			}		
		}
	}

	public static void findKidMap(StudyTemp st) {
		
		for (String f: st.fileModelNameMap.keySet()){
			
			String modelName = st.fileModelNameMap.get(f).get(0);
			
			ArrayList<String> kids = st.fileModelDataTable.get(f,modelName).incFileRelativePathList;
			
			if (kids==null){
				st.noKid.add(f);			
			} else if (kids.isEmpty()){
				st.noKid.add(f);
			} else {
				//st.kidssMap.put(f, modelName, new HashSet<String>(kids));
				st.kidMap.put(f, new HashSet<String>(kids));
			}
			
		}
		
	}
	
	public static void findAllOffSpring(StudyTemp st) {


		for (String f: st.kidMap.keySet()) { 
				
			HashSet<String> a = Tools.findAllOffspring(f, st.kidMap);
			
			st.allOffspringMap.put(f, a);			
			
		}
		
	}

	public static void findFileGroupOrder(StudyTemp st) {
		
		Map<String,HashSet<String>> toBeSorted = new HashMap<String, HashSet<String>>(st.allOffspringMap);
		
		///// skip mainFile
		toBeSorted.remove(st.relativePath);
		
		//System.out.println("st.noKid"+st.noKid);
		st.fileGroupOrder.add(st.noKid);
		
		
		Tools.findFileHierarchy(st.fileGroupOrder, toBeSorted);
		
	}
	

	// replace file with vars
	public static void postProcessVarListinIncFile(StudyTemp st) {
		
		// use the fileGroupOrder
		for (HashSet<String> fgroup: st.fileGroupOrder){
			
			for ( String f : fgroup){
				
				if (!st.allOffspringMap.keySet().contains(f)) continue; // TODO: the whole first round can be skipped
				
				String modelName = st.fileModelNameMap.get(f).get(0);		
				
				ModelTemp m = st.fileModelDataTable.get(f,modelName);
				
				for( String includedFile: st.allOffspringMap.get(f)){
					
					int index =m.svIncFileList_post.indexOf(includedFile);
					
					if (index>-1) {
					m.svIncFileList_post.remove(index);
					
					//Pair<String,String> p2 = new Pair<String, String>(includedFile, st.fileModelNameMap.get(includedFile).get(0));
					
					ModelTemp includedModel = st.fileModelDataTable.get(includedFile,st.fileModelNameMap.get(includedFile).get(0));
					m.svIncFileList_post.addAll(index, includedModel.svIncFileList_post); 
					//m.dvList.addAll(includedModel.dvList);
					m.ssList_noCase.addAll(includedModel.ssList_noCase);
					m.ssList_hasCase.addAll(includedModel.ssList_hasCase);
					
					}
					
					// process alias
					index =m.asIncFileList_post.indexOf(includedFile);
					
					if (index > -1) {
						
						m.asIncFileList_post.remove(index);
						ModelTemp includedModel = st.fileModelDataTable.get(includedFile,
								st.fileModelNameMap.get(includedFile).get(0));
						m.asIncFileList_post.addAll(index, includedModel.asIncFileList_post);

					}
					
					// process external
					index =m.exIncFileList_post.indexOf(includedFile);
					
					if (index > -1) {
						
						m.exIncFileList_post.remove(index);
						ModelTemp includedModel = st.fileModelDataTable.get(includedFile,
								st.fileModelNameMap.get(includedFile).get(0));
						m.exIncFileList_post.addAll(index, includedModel.exIncFileList_post);

					}
	
				}
			}
		}
		
		// process the main file except the first model includes
		ArrayList<String> ttt = new ArrayList<String>(st.modelList_effective);
	
		for (String modelNameOfMain : ttt){
			
			ModelTemp m = st.modelMap.get(modelNameOfMain);
			
			
			for (String includedFile: m.incFileRelativePathList ){
				
				int index = m.svIncFileList_post.indexOf(includedFile);
				
				
				if (index>-1) {
				
				String modelName = st.fileModelNameMap.get(includedFile).get(0);
				
				//Pair<String,String> p = new Pair<String, String>(includedFile, modelName);
				
				ModelTemp includedModel = st.fileModelDataTable.get(includedFile,modelName);
	
				

				m.svIncFileList_post.remove(index);
				
				m.svIncFileList_post.addAll(index, includedModel.svIncFileList_post);
				//m.dvList.addAll(includedModel.dvList);
				m.ssList_noCase.addAll(includedModel.ssList_noCase);
				m.ssList_hasCase.addAll(includedModel.ssList_hasCase);
				}
				
				// process alias
				index = m.asIncFileList_post.indexOf(includedFile);
				
				if (index > -1) {

					String modelName = st.fileModelNameMap.get(includedFile).get(0);

					ModelTemp includedModel = st.fileModelDataTable.get(includedFile, modelName);
					m.asIncFileList_post.remove(index);
					m.asIncFileList_post.addAll(index, includedModel.asIncFileList_post);
				}
				
				// process external
				index = m.exIncFileList_post.indexOf(includedFile);
				
				if (index > -1) {

					String modelName = st.fileModelNameMap.get(includedFile).get(0);

					ModelTemp includedModel = st.fileModelDataTable.get(includedFile, modelName);
					m.exIncFileList_post.remove(index);
					m.exIncFileList_post.addAll(index, includedModel.exIncFileList_post);
				}
				
			}		
		}
	}

	// TODO: this process alias only. need to expand to other types
	public static void classifyDependants(StudyTemp s) {
		
		for (String se : s.seqList){
			
			SequenceTemp seqObj = s.seqMap.get(se); 

			//ModelTemp mObj = s.modelMap.get(m);

			classifyDependants(seqObj, s.parameterList);						
		}
	}
	public static void classifyDependants(SequenceTemp seqObj, ArrayList<String> parameterList) {
		
		for (String key : seqObj.asMap.keySet()) {

			AliasTemp asObj = seqObj.asMap.get(key);

			asObj.dependants_timeseries = new LinkedHashSet<String>(asObj.dependants);
			asObj.dependants_timeseries.retainAll(seqObj.tsList);

			asObj.dependants_dvar = new LinkedHashSet<String>(asObj.dependants);
			asObj.dependants_dvar.retainAll(seqObj.dvList);

			asObj.dependants_svar = new LinkedHashSet<String>(asObj.dependants);
			asObj.dependants_svar.retainAll(seqObj.svMap.keySet());

			asObj.dependants_alias = new LinkedHashSet<String>(asObj.dependants);
			asObj.dependants_alias.retainAll(seqObj.asMap.keySet());

			asObj.dependants_parameter = new LinkedHashSet<String>(asObj.dependants);
			asObj.dependants_parameter.retainAll(parameterList);
			
			asObj.dependants_unknown = new LinkedHashSet<String>(asObj.dependants);
			asObj.dependants_unknown.removeAll(asObj.dependants_timeseries);
			asObj.dependants_unknown.removeAll(asObj.dependants_dvar);
			asObj.dependants_unknown.removeAll(asObj.dependants_svar);
			asObj.dependants_unknown.removeAll(asObj.dependants_alias);
			asObj.dependants_unknown.removeAll(asObj.dependants_parameter);
			
			
			// TODO: this is to match legacy wresl parser
			asObj.dependants.removeAll(asObj.dependants_timeseries);
			asObj.dependants.removeAll(asObj.dependants_dvar);
		}	
		
		for (String key : seqObj.svMap.keySet()) {

			SvarTemp svObj = seqObj.svMap.get(key);
			
			svObj.dependants_timeseries = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_timeseries.retainAll(seqObj.tsList);

			svObj.dependants_alias = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_alias.retainAll(seqObj.asMap.keySet());
			
			svObj.dependants_dvar = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_dvar.retainAll(seqObj.dvList);
			
			svObj.dependants_svar = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_svar.retainAll(seqObj.svMap.keySet());
			
			svObj.dependants_external = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_external.retainAll(seqObj.exList);

			svObj.dependants_parameter = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_parameter.retainAll(parameterList);
			
			svObj.dependants_unknown = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_unknown.removeAll(svObj.dependants_timeseries);
			svObj.dependants_unknown.removeAll(svObj.dependants_alias);
			svObj.dependants_unknown.removeAll(svObj.dependants_dvar);
			svObj.dependants_unknown.removeAll(svObj.dependants_svar);
			svObj.dependants_unknown.removeAll(svObj.dependants_external);
			svObj.dependants_unknown.removeAll(svObj.dependants_parameter);

			// TODO: this is to match legacy wresl parser
			svObj.dependants.removeAll(svObj.dependants_timeseries);
			svObj.dependants.removeAll(seqObj.dvList);
		}	
		
		for (String key : seqObj.glMap.keySet()) {

			GoalTemp svObj = seqObj.glMap.get(key);

			//svObj.dependants.removeAll(seqObj.tsList);
			//svObj.dependants.removeAll(seqObj.dvList);
			
			svObj.dependants_timeseries = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_timeseries.retainAll(seqObj.tsList);

			svObj.dependants_svar = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_svar.retainAll(seqObj.svMap.keySet());
			
			svObj.dependants_dvar = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_dvar.retainAll(seqObj.dvList);

			svObj.dependants_alias = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_alias.retainAll(seqObj.asMap.keySet());

			svObj.dependants_external = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_external.retainAll(seqObj.exMap.keySet());

			svObj.dependants_parameter = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_parameter.retainAll(parameterList);
			
			svObj.dependants_unknown = new LinkedHashSet<String>(svObj.dependants);
			svObj.dependants_unknown.removeAll(svObj.dependants_timeseries);
			svObj.dependants_unknown.removeAll(svObj.dependants_svar);
			svObj.dependants_unknown.removeAll(svObj.dependants_dvar);
			svObj.dependants_unknown.removeAll(svObj.dependants_alias);
			svObj.dependants_unknown.removeAll(svObj.dependants_external);
			svObj.dependants_unknown.removeAll(svObj.dependants_parameter);
			
		}	
	}


	public static void analyzeVarNeededFromCycle(StudyTemp s){
		
		for (String se : s.seqList){
			
			SequenceTemp q = s.seqMap.get(se); 
			ArrayList<String> others = new ArrayList<String>(s.seqList);
			others.remove(se);
			
			for (String o : others){
				
				SequenceTemp otherSeq = s.seqMap.get(o);
				
				Set<String> varSet = otherSeq.neededCycleVarMap.get(q.model);
				
				if (varSet != null) {

					q.varUsedByLaterCycle.addAll(varSet);
					
					for (String e : varSet) {

						if (q.asIncFileList_post.contains(e)) {
							
							q.aliasUsedByLaterCycle.add(e);
						}
						else if (q.dvList.contains(e)) {
							
							q.dvarUsedByLaterCycle.add(e);
						}
						else if (q.dvList_fromAlias.contains(e)) {
							
							q.dvarUsedByLaterCycle.add(e);
						}
						else if (q.svIncFileList_post.contains(e)) {
							
							q.svarUsedByLaterCycle.add(e);
						}
						else {

							LogUtils.errMsg(" Unknown type of variable ["+ e +"] in ["+ se+": "+q.model +"] is used in ["+o+": "+otherSeq.model+"]");

						}
					}
				}
				
				
			}
						
		}
		
	}

	public static void createSpaceInVarCycleValueMap(StudyTemp s){
		
		Map<String, Map<String, IntDouble>> vcv = s.varCycleValueMap;
		
		for (String seqName : s.seqList){
			
			SequenceTemp q = s.seqMap.get(seqName); 
			
			String modelName = q.model;
						
			for (String e : q.varUsedByLaterCycle) {

				// / create space in varCycleValue map
				if (vcv.keySet().contains(e)) {
					vcv.get(e).put(modelName, null);
				} else {
					Map<String, IntDouble> t = new HashMap<String, IntDouble>();
					t.put(modelName, null);
					vcv.put(e, t);
				}
			}
				
				
			
		}
	}

	public static void collectTimeStep(StudyTemp st) {

		// TODO: need to create model time step list in sequence.
		// TODO: currently only allows monthly time step for testing in wreslplus
		// TODO: check with Hao



		for (String se : st.seqList){
			
			SequenceTemp q = st.seqMap.get(se);
			
			// TODO: warning!!! test only. need to parse time step from wreslplus
			st.seqTimeStepList.add("1MON");		
		}

		String definedTimeStep = "1MON";
		
		for (String se : st.seqList){
			
			SequenceTemp q = st.seqMap.get(se); 

			for (String timeseriesName : q.tsList) {

				if (st.timeseriesTimeStepMap.containsKey(timeseriesName)) {

					ArrayList<String> timeStepList = st.timeseriesTimeStepMap.get(timeseriesName);
					if (!timeStepList.contains(definedTimeStep)) {
						timeStepList.add(definedTimeStep);
					}
				}
				else {
					st.timeseriesTimeStepMap.put(timeseriesName, new ArrayList<String>(Arrays.asList(definedTimeStep)));
				}
			}

		}
		
		
//	      String timeStep=sc.modelTimeStepList.get(modelIndex);
//	      String definedTimeStep;
//	      if (timeStep.equals(Param.undefined)){
//	    	  definedTimeStep=ControlData.defaultTimeStep;
//	      }else{
//	    	  definedTimeStep=timeStep;
//	      }
//	      for (String timeseriesName:ds.tsMap.keySet()){
//	    	  if (timeseriesTimeStepMap.containsKey(timeseriesName)){
//	    		  ArrayList<String> timeStepList=timeseriesTimeStepMap.get(timeseriesName);
//	    		  if (!timeStepList.contains(definedTimeStep)){
//	    			  timeStepList.add(definedTimeStep);
//	    		  }
//	    	  }else{
//	    		  timeseriesTimeStepMap.put(timeseriesName, new ArrayList<String>(Arrays.asList(definedTimeStep)));
//	    	  }
//	      }
		
	}


	
}
