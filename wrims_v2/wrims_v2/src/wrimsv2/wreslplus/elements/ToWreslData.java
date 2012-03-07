package wrimsv2.wreslplus.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;

public class ToWreslData {
	
	
	private ToWreslData(){}

	
	//TODO: model must be in sequence obj, also condition not linked yet
	//TODO: remember to lowercase all evaluation strings and var names
	public static StudyDataSet convertStudy (StudyTemp s){
		
		StudyDataSet o = new StudyDataSet();
		o.setModelList(Tools.allToLowerCase(s.modelList));
				
		Map<String, ModelDataSet> modelDataSetMap = new HashMap<String, ModelDataSet>();
		ArrayList<String> modelConditionList   = new ArrayList<String>();
		Map<String, Timeseries> allTimeseriesMap = new LinkedHashMap<String, Timeseries>();
		
		for (String k: s.modelList){
			
			modelConditionList.add("always");
			ModelDataSet m = convertModel(s.modelMap.get(k));
			modelDataSetMap.put(k.toLowerCase(), m );
		
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
		
		o.dvList = Tools.allToLowerCase(m.dvList);
		Collections.sort(o.dvList,String.CASE_INSENSITIVE_ORDER);
		
		o.tsList = Tools.allToLowerCase(m.tsList);
		Collections.sort(o.tsList,String.CASE_INSENSITIVE_ORDER);
		
		o.svList = Tools.allToLowerCase(m.svList);
		Collections.sort(o.svList,String.CASE_INSENSITIVE_ORDER);

		o.exList = Tools.allToLowerCase(m.exList);
		Collections.sort(o.exList,String.CASE_INSENSITIVE_ORDER);
		
		for (String k: m.dvMap.keySet()){			
			o.dvMap.put(k.toLowerCase(), convertDvar(m.dvMap.get(k)));
		}
		for (String k: m.tsMap.keySet()){			
			o.tsMap.put(k.toLowerCase(), convertTimeseries(m.tsMap.get(k)));
		}		
		for (String k: m.svMap.keySet()){			
			o.svMap.put(k.toLowerCase(), convertSvar(m.svMap.get(k)));
		}
		for (String k: m.exMap.keySet()){			
			o.exMap.put(k.toLowerCase(), convertExternal(m.exMap.get(k)));
		}
		return o;
		
	}

	public static Svar convertSvar (SvarTemp s){
		
		Svar o = new Svar();
		
		o.fromWresl = s.fromWresl.toLowerCase();
		o.kind = s.kind.toLowerCase();
		o.units = s.units.toLowerCase();
		o.caseName = Tools.allToLowerCase(s.caseName);
		o.dependants = Tools.allToLowerCase(s.dependants);
		o.dependants.removeAll(Param.reservedSet);
		//System.out.println(s.dependants);
		
		o.caseCondition = Tools.allToLowerCase(s.caseCondition);
		o.caseCondition = Tools.replace_with_space(o.caseCondition);
		o.caseCondition = Tools.replace_seperator(o.caseCondition);
		o.caseCondition = Tools.add_space_between_logical(o.caseCondition);
		
		o.caseExpression = Tools.allToLowerCase(s.caseExpression);
		o.caseExpression = Tools.replace_with_space(o.caseExpression);
		o.caseExpression = Tools.replace_seperator(o.caseExpression);
		o.caseExpression = Tools.add_space_between_logical(o.caseExpression);
		
		System.out.println(o.caseExpression);
		return o;
		
	}	
	
	public static Timeseries convertTimeseries (TimeseriesTemp t){
		
		Timeseries o = new Timeseries();
		
		o.fromWresl = t.fromWresl.toLowerCase();
		o.dssBPart = t.dssBPart.toLowerCase();
		o.convertToUnits = t.convertToUnits.toLowerCase();
		o.kind = t.kind.toLowerCase();
		o.units = t.units.toLowerCase();
		
		return o;
		
	}
	
	public static Dvar convertDvar (DvarTemp d){
		
		Dvar o = new Dvar();
		
		o.fromWresl = d.fromWresl.toLowerCase();
		o.lowerBound = d.lowerBound.toLowerCase();
		o.upperBound = d.upperBound.toLowerCase();
		o.kind = Tools.strip(d.kind.toLowerCase());
		o.units = Tools.strip(d.units.toLowerCase());
		if (d.isInteger) o.integer=Param.yes;
		
		return o;
		
	}


	public static External convertExternal (ExternalTemp e){
		
		External o = new External();
		
		o.fromWresl = e.fromWresl.toLowerCase();
		o.type = e.fileName.toLowerCase();
		
		return o;
		
	}

}
	
