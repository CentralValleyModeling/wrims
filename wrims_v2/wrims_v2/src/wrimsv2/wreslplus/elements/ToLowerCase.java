package wrimsv2.wreslplus.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;

public class ToLowerCase {
	
	
	private ToLowerCase(){}

	
	//TODO: model must be in sequence obj, also condition not linked yet
	//TODO: remember to lowercase all evaluation strings and var names
	public static void convertStudy (StudyTemp s){		

		for (String key : s.modelList) {
			ModelTemp n = s.modelMap.get(key);
			s.modelMap.remove( key);
			convertModel(n);
			s.modelMap.put( key.toLowerCase(), n);
		}
		s.modelList = Tools.allToLowerCase(s.modelList);
	}	
	
	public static void convertModel (ModelTemp j){
		
		for (String key : j.svList) {
			SvarTemp o = convertSvar(j.svMap.get(key));
			j.svMap.remove(key);
			j.svMap.put( key.toLowerCase(), o);
		}
		for (String key : j.dvList) {
			DvarTemp o = convertDvar(j.dvMap.get(key));
			j.dvMap.remove(key);
			j.dvMap.put( key.toLowerCase(), o);
		}
		for (String key : j.tsList) {
			TimeseriesTemp o = convertTimeseries(j.tsMap.get(key));
			j.tsMap.remove(key);
			j.tsMap.put( key.toLowerCase(), o);
		}
		for (String key : j.exList) {
			ExternalTemp o = convertExternal(j.exMap.get(key));
			j.exMap.remove(key);
			j.exMap.put( key.toLowerCase(), o);
		}
		for (String key : j.glList) {
			GoalTemp o = convertGoal(j.glMap.get(key));
			j.glMap.remove(key);
			j.glMap.put( key.toLowerCase(), o);
		}
		for (String key : j.gl2List) {
			GoalTemp o = convertGoal(j.gl2Map.get(key));
			j.gl2Map.remove(key);
			j.gl2Map.put( key.toLowerCase(), o);
		}
		for (String key : j.ssList) {
			DvarTemp o = convertDvar(j.ssMap.get(key));
			j.ssMap.remove(key);
			j.ssMap.put( key.toLowerCase(), o);
		}
		for (String key : j.ssList) {
			WeightTemp o = convertWeight(j.ssWeightMap.get(key));
			j.ssWeightMap.remove(key);
			j.ssWeightMap.put( key.toLowerCase(), o);
		}
		for (String key : j.asList) {
			AliasTemp o = convertAlias(j.asMap.get(key));
			j.asMap.remove(key);
			j.asMap.put( key.toLowerCase(), o);
		}		
		j.itemList = Tools.allToLowerCase(j.itemList);
		j.svList = Tools.allToLowerCase(j.svList);
		j.dvList = Tools.allToLowerCase(j.dvList);
		j.glList = Tools.allToLowerCase(j.glList);
		j.gl2List = Tools.allToLowerCase(j.gl2List);
		j.tsList = Tools.allToLowerCase(j.tsList);
		j.ssList = Tools.allToLowerCase(j.ssList);
		j.exList = Tools.allToLowerCase(j.exList);
		j.asList = Tools.allToLowerCase(j.asList);
		
	}

	public static SvarTemp convertSvar (SvarTemp s){
		
		SvarTemp o = new SvarTemp();
		
		o.id = s.id;
		o.fromWresl = s.fromWresl.toLowerCase();
		o.kind = s.kind.toLowerCase();
		o.units = s.units.toLowerCase();
		o.caseName = Tools.allToLowerCase(s.caseName);
		o.dependants = Tools.allToLowerCase(s.dependants);
		
		o.caseCondition = Tools.allToLowerCase(s.caseCondition);
		o.caseCondition = Tools.replace_with_space(o.caseCondition);
		//o.caseCondition = Tools.replace_seperator(o.caseCondition);
		o.caseCondition = Tools.add_space_between_logical(o.caseCondition);
		
		o.caseExpression = Tools.allToLowerCase(s.caseExpression);
		o.caseExpression = Tools.replace_with_space(o.caseExpression);
		//o.caseExpression = Tools.replace_seperator(o.caseExpression);
		o.caseExpression = Tools.add_space_between_logical(o.caseExpression);
		
		return o;
		
	}	
	
	public static TimeseriesTemp convertTimeseries (TimeseriesTemp t){
		
		TimeseriesTemp o = new TimeseriesTemp();
		
		o.id = t.id;
		o.fromWresl = t.fromWresl.toLowerCase();
		o.dssBPart = t.dssBPart.toLowerCase();
		o.convertToUnits = t.convertToUnits.toLowerCase();
		o.kind = t.kind.toLowerCase();
		o.units = t.units.toLowerCase();
		
		return o;
		
	}
	
	public static DvarTemp convertDvar (DvarTemp d){
		
		DvarTemp o = new DvarTemp();
		
		o.id = d.id;
		o.fromWresl = d.fromWresl.toLowerCase();
		o.lowerBound = d.lowerBound.toLowerCase();
		o.upperBound = d.upperBound.toLowerCase();
		o.kind = d.kind.toLowerCase();
		o.units = d.units.toLowerCase();
		o.condition = d.condition;
		o.isInteger = d.isInteger;
		
		return o;
	}


	public static WeightTemp convertWeight (WeightTemp w){
		
		WeightTemp o = new WeightTemp();
		
		o.id = w.id;
		o.fromWresl = w.fromWresl.toLowerCase();
		o.condition = w.condition.toLowerCase();
		o.weight = w.weight.toLowerCase();
		
		return o;

	}


	public static ExternalTemp convertExternal (ExternalTemp e){
		
		ExternalTemp o = new ExternalTemp();
		
		o.id = e.id;
		o.fromWresl = e.fromWresl.toLowerCase();
		o.fileName = e.fileName.toLowerCase();
		
		return o;
		
	}


	public static GoalTemp convertGoal (GoalTemp g){

		GoalTemp o = new GoalTemp();
		
		o.id = g.id;
		o.fromWresl = g.fromWresl.toLowerCase();
		o.caseName = Tools.allToLowerCase(g.caseName);
		o.dependants = Tools.allToLowerCase(g.dependants);
		o.dependants.removeAll(Param.reservedSet);
		//System.out.println(s.dependants);
		
		o.caseCondition = Tools.allToLowerCase(g.caseCondition);
		o.caseCondition = Tools.replace_with_space(o.caseCondition);
		//o.caseCondition = Tools.replace_seperator(o.caseCondition);
		o.caseCondition = Tools.add_space_between_logical(o.caseCondition);
		
		o.caseExpression = Tools.allToLowerCase(g.caseExpression);
		o.caseExpression = Tools.replace_with_space(o.caseExpression);
		//o.caseExpression = Tools.replace_seperator(o.caseExpression);
		o.caseExpression = Tools.add_space_between_logical(o.caseExpression);
		
		return o;
				
	}


	public static AliasTemp convertAlias (AliasTemp d){
		
		AliasTemp o = new AliasTemp();
		
		o.id = d.id;
		o.fromWresl = d.fromWresl.toLowerCase();
		o.expression = d.expression.toLowerCase();
		o.kind = d.kind.toLowerCase();
		o.units = d.units.toLowerCase();
		o.condition = d.condition;

		
		return o;
	}

}
	
