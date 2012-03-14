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
		o.setModelList(s.modelList);
				
		Map<String, ModelDataSet> modelDataSetMap = new HashMap<String, ModelDataSet>();
		ArrayList<String> modelConditionList   = new ArrayList<String>();
		Map<String, Timeseries> allTimeseriesMap = new LinkedHashMap<String, Timeseries>();
		
		for (String k: s.modelList){
			
			modelConditionList.add("always");
			ModelDataSet m = convertModel(s.modelMap.get(k));
			modelDataSetMap.put(k, m );
		
			// add ts into all ts map. TODO: check name duplications
			allTimeseriesMap.putAll(m.tsMap);
		}
		
		o.setModelDataSetMap(modelDataSetMap);
		o.setModelConditionList(modelConditionList);
		o.setTimeseriesMap(allTimeseriesMap);
		
		return o;

	}	
	
	public static ModelDataSet convertModel (ModelTemp m){
		
		ModelDataSet o = new ModelDataSet();
		
		// TODO: give pre-sorted var list

		o.dvSlackSurplusList = new ArrayList<String>(m.ssList);
		Collections.sort(o.dvSlackSurplusList,String.CASE_INSENSITIVE_ORDER);

		o.wtSlackSurplusList = new ArrayList<String>(m.ssList);
		Collections.sort(o.wtSlackSurplusList,String.CASE_INSENSITIVE_ORDER);
		
		o.dvList = new ArrayList<String>(m.dvList);
		Collections.sort(o.dvList,String.CASE_INSENSITIVE_ORDER);
		
		o.tsList = new ArrayList<String>(m.tsList);
		Collections.sort(o.tsList,String.CASE_INSENSITIVE_ORDER);
		
		// don't sort svList. order matters in evaluator
		o.svList = new ArrayList<String>(m.svList);

		o.gList = new ArrayList<String>(m.glList);
		Collections.sort(o.exList,String.CASE_INSENSITIVE_ORDER);
		
		o.exList = new ArrayList<String>(m.exList);
		Collections.sort(o.exList,String.CASE_INSENSITIVE_ORDER);
		
		o.asList = new ArrayList<String>(m.asList_reduced);
		Collections.sort(o.asList,String.CASE_INSENSITIVE_ORDER);
		
		for (String k: m.ssMap.keySet()){			
			o.dvSlackSurplusMap.put(k, convertDvar(m.ssMap.get(k)));
		}
		for (String k: m.ssWeightMap.keySet()){			
			o.wtSlackSurplusMap.put(k, convertWeight(m.ssWeightMap.get(k)));
		}
		for (String k: m.dvMap.keySet()){			
			o.dvMap.put(k, convertDvar(m.dvMap.get(k)));
		}
		for (String k: m.tsMap.keySet()){			
			o.tsMap.put(k, convertTimeseries(m.tsMap.get(k)));
		}		
		for (String k: m.svMap.keySet()){			
			o.svMap.put(k, convertSvar(m.svMap.get(k)));
		}
		for (String k: m.glMap.keySet()){			
			o.gMap.put(k, convertGoal(m.glMap.get(k)));
		}
		for (String k: m.exMap.keySet()){			
			o.exMap.put(k, convertExternal(m.exMap.get(k)));
		}
		// this one is special. don't use copy and paste
		for (String k: o.asList){			
			o.asMap.put(k, convertAlias(m.asMap.get(k)));
		}
		return o;
		
	}

	public static Svar convertSvar (SvarTemp s){
		
		Svar o = new Svar();
		
		o.fromWresl = s.fromWresl;
		o.kind = s.kind;
		o.units = s.units;
		o.caseName = s.caseName;
		o.dependants = s.dependants;
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

		return o;
		
	}

}
	
