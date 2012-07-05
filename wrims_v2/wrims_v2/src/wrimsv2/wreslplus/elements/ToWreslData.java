package wrimsv2.wreslplus.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;

public class ToWreslData {
	
	
	private ToWreslData(){}

	
	//TODO: model must be in sequence obj, also condition not linked yet
	//TODO: remember to lowercase all evaluation strings and var names
	public static StudyDataSet convertStudy (StudyTemp s){
		
		StudyDataSet o = new StudyDataSet();
		o.setModelList(s.modelList_effective);
		
		o.setVarCycleValueMap(s.varCycleValueMap);
		o.setTimeseriesTimeStepMap(s.timeseriesTimeStepMap);
		o.setModelTimeStepList(s.seqTimeStepList);		
		
		Map<String, ModelDataSet> modelDataSetMap = new HashMap<String, ModelDataSet>();
		ArrayList<String> modelConditionList   = new ArrayList<String>();
		Map<String, Timeseries> allTimeseriesMap = new LinkedHashMap<String, Timeseries>();
		
		//for (String k: s.modelList_effective){
		for (String se : s.seqList){
			
			SequenceTemp seqObj = s.seqMap.get(se); 
			String modelName = seqObj.model;

			ModelTemp mt = s.modelMap.get(modelName);	
			
			modelConditionList.add("always"); //TODO: need condition
			ModelDataSet md = convertModel(mt, seqObj);
			modelDataSetMap.put(modelName, md);
		
			// add ts into all ts map. TODO: check name duplications
			allTimeseriesMap.putAll(md.tsMap);
		}
		
		o.setModelDataSetMap(modelDataSetMap);
		o.setModelConditionList(modelConditionList);
		o.setTimeseriesMap(allTimeseriesMap);

		return o;

	}	
	
	public static ModelDataSet convertModel (ModelTemp m, SequenceTemp seq){
		
		ModelDataSet o = new ModelDataSet();
		
		o.varUsedByLaterCycle = seq.varUsedByLaterCycle;
		o.dvarUsedByLaterCycle = seq.dvarUsedByLaterCycle;
		o.svarUsedByLaterCycle = seq.svarUsedByLaterCycle;
		o.aliasUsedByLaterCycle = seq.aliasUsedByLaterCycle;
		
		// TODO: give pre-sorted var list

		o.dvSlackSurplusList = new ArrayList<String>(seq.ssList_hasCase);
		Collections.sort(o.dvSlackSurplusList,String.CASE_INSENSITIVE_ORDER);

		o.wtSlackSurplusList = new ArrayList<String>(seq.ssList_hasCase);
		Collections.sort(o.wtSlackSurplusList,String.CASE_INSENSITIVE_ORDER);
	
		o.dvList = new ArrayList<String>(seq.dvList);
		o.dvList.addAll(seq.dvList_fromAlias);
		//o.dvList.addAll(seq.ssList_noCase);
		Collections.sort(o.dvList,String.CASE_INSENSITIVE_ORDER);
		
		o.tsList = new ArrayList<String>(seq.tsList);
		Collections.sort(o.tsList,String.CASE_INSENSITIVE_ORDER);
		
		// don't sort svList. order matters in evaluator
		o.svList = new ArrayList<String>(m.svIncFileList_post);
		//System.out.println("ToWreslData => m.svIncFileList_post"+m.svIncFileList_post);
		//System.out.println("ToWreslData => m.svList"+m.svList);
		//o.svList = new ArrayList<String>(m.svList);

		o.gList = new ArrayList<String>(seq.glList);
		o.gList.addAll(seq.glList_fromAlias);
		Collections.sort(o.gList,String.CASE_INSENSITIVE_ORDER);
		

		
		o.exList = new ArrayList<String>(seq.exList);
		Collections.sort(o.exList,String.CASE_INSENSITIVE_ORDER);
		
		o.asList = new ArrayList<String>(seq.asList);
		Collections.sort(o.asList,String.CASE_INSENSITIVE_ORDER);

		o.wtList = new ArrayList<String>(seq.wvList_defaultType);
		o.wtList.addAll(seq.ssList_noCase);
		Collections.sort(o.wtList,String.CASE_INSENSITIVE_ORDER);
		
		o.incFileList = new ArrayList<String>(m.incFileAbsPathList_post);
	
		
//		for (String k: m.incFileMap.keySet()){			
//			o.incFileList.add(m.incFileMap.get(k).absPath);
//		}
		
		
		for (String k: o.dvSlackSurplusList){			
			o.dvSlackSurplusMap.put(k, convertDvar(seq.ssMap_hasCase.get(k)));
		}
		for (String k: o.wtSlackSurplusList){			
			o.wtSlackSurplusMap.put(k, convertWeight(seq.ssWeightMap_hasCase.get(k)));
		}
		
		
		for (String k: seq.tsMap.keySet()){			
			o.tsMap.put(k, convertTimeseries(seq.tsMap.get(k)));
		}		

		for (String k: seq.glMap.keySet()){			
			o.gMap.put(k, convertGoal(seq.glMap.get(k)));
		}
		for (String k: o.exList){			
			o.exMap.put(k, convertExternal(seq.exMap.get(k)));
		}
		
		
		
		// special case. don't copy and paste
		for (String k: o.svList){		
//			System.out.println("svarName: "+k );
//			System.out.println("modelName: "+m.id );
//			System.out.println("this file: "+m.absPath );
//			System.out.println("incFileList_post: ");
//			System.out.println(m.incFileRelativePathList_post );
//			System.out.println("svincFileList_post: ");
//			System.out.println(m.svIncFileList_post);

			o.svMap.put(k, convertSvar(seq.svMap.get(k)));
		}
		
		//dv
		
		//System.out.println("0503 dvList: "+o.dvList);
		
		
		for (String k: o.dvList){			
			o.dvMap.put(k, convertDvar(seq.dvMap.get(k)));
		}
		for (String k: seq.ssList_noCase){			
			o.dvMap.put(k, convertDvar(seq.ssMap_noCase.get(k)));
		}
		o.dvList.addAll(seq.ssList_noCase);
		
		
		for (String k: o.asList){			
			o.asMap.put(k, convertAlias(seq.asMap.get(k)));
		}
		for (WeightTable w : seq.wTableObjList_defaultType){	
			
			//System.out.println("before: "+w.varWeightMap.keySet());
			//if (w.id.equalsIgnoreCase("obj")) o.wtMap.putAll(convertWeightTable(w));
			//Map<String,WeightElement> wem = convertWeightTable(w);
			o.wtMap.putAll(convertWeightTable(w));
			//System.out.println("after: "+wem.keySet());
		}
		for (String k: seq.ssList_noCase){				
			o.wtMap.put(k, convertWeight(seq.ssWeightMap_noCase.get(k)));
		}		
		
		
		return o;
		
	}

	public static Svar convertSvar (SvarTemp s){
		
		Svar o = new Svar();
		try {
			o.fromWresl = s.fromWresl;
		} catch (Exception e) {
			System.out.println("#### error");
			System.out.println("svarName: "+s.id);
		}
		o.kind = s.kind;
		o.units = s.units;
		o.caseName = s.caseName;
		o.dependants = s.dependants;
		o.neededVarInCycleSet = s.neededVarInCycleSet;
		o.needVarFromEarlierCycle = s.needVarFromEarlierCycle;
		//o.dependants.removeAll(Param.reservedSet);
		//System.out.println(s.dependants);
		
		o.caseCondition = s.caseCondition;
		//o.caseCondition = Tools.replace_with_space(o.caseCondition);
		o.caseCondition = Tools.replace_seperator(o.caseCondition);
		//o.caseCondition = Tools.add_space_between_logical(o.caseCondition);
		
		o.caseExpression = s.caseExpression;
		//o.caseExpression = Tools.replace_with_space(o.caseExpression);
		o.caseExpression = Tools.replace_seperator(o.caseExpression);
		//o.caseExpression = Tools.add_space_between_logical(o.caseExpression);
		
		//System.out.println(o.caseExpression);
		return o;
		
	}	
	
	public static Timeseries convertTimeseries (TimeseriesTemp t){
		
		Timeseries o = new Timeseries();
		
		o.fromWresl = t.fromWresl;
		o.dssBPart = t.dssBPart;
		o.convertToUnits = t.convertToUnits;
		o.kind = t.kind;
		o.units = t.units;
		
		return o;
		
	}
	
	public static Dvar convertDvar (DvarTemp d){
		
		Dvar o = new Dvar();
		
		o.fromWresl = d.fromWresl;
		o.lowerBound = d.lowerBound;
		o.upperBound = d.upperBound;
		o.kind = d.kind;
		o.units = d.units;
		o.condition = d.condition;
		if (d.isInteger) o.integer=Param.yes;
		
		return o;
		
	}


	public static WeightElement convertWeight (WeightTemp w){
		
		WeightElement o = new WeightElement();
		
		o.fromWresl = w.fromWresl;
		o.condition = w.condition;
		o.weight = w.weight;

		o.weight = Tools.replace_with_space(o.weight);
		o.weight = Tools.replace_seperator(o.weight);
		
		return o;
		
	}


	public static Map<String,WeightElement> convertWeightTable (WeightTable w){
		
		Map<String,WeightElement> om = new LinkedHashMap<String, WeightElement>();
		
		for (String s : w.varList) {
		
			WeightElement o = new WeightElement();
		
			o.fromWresl = w.fromWresl;
			o.condition = w.condition;
			o.weight = w.varWeightMap.get(s);
			
			om.put(s,o);
		}

		
		return om;
		
	}


	public static External convertExternal (ExternalTemp e){
		
		External o = new External();
		
		o.fromWresl = e.fromWresl;
		o.type = e.fileName;
		
		return o;
		
	}


	public static Goal convertGoal (GoalTemp g){
		
		Goal o = new Goal();
		
		o.fromWresl = g.fromWresl;
		o.caseName = g.caseName;
		o.expressionDependants = g.dependants;
		o.neededVarInCycleSet = g.neededVarInCycleSet;
		o.needVarFromEarlierCycle = g.needVarFromEarlierCycle;
		o.expressionDependants.removeAll(Param.reservedSet);
		//System.out.println(s.dependants);
		
		o.caseCondition = g.caseCondition;
		//o.caseCondition = Tools.replace_with_space(o.caseCondition);
		o.caseCondition = Tools.replace_seperator(o.caseCondition);
		//o.caseCondition = Tools.add_space_between_logical(o.caseCondition);
		
		o.caseExpression = g.caseExpression;
		//o.caseExpression = Tools.replace_with_space(o.caseExpression);
		o.caseExpression = Tools.replace_seperator(o.caseExpression);
		//o.caseExpression = Tools.add_space_between_logical(o.caseExpression);
		
		//System.out.println(o.caseExpression);
		return o;
		
	}


	public static Alias convertAlias (AliasTemp d){
		
		Alias o = new Alias();
		
		o.fromWresl = d.fromWresl;
		o.expression = Tools.replace_seperator(d.expression);
		o.kind = d.kind;
		o.units = d.units;
		o.condition = d.condition;
		o.dependants = d.dependants;
		o.neededVarInCycleSet = d.neededVarInCycleSet;
		o.needVarFromEarlierCycle = d.needVarFromEarlierCycle;

		return o;
		
	}

}
	
