package wrimsv2.wreslplus.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;



import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.wreslparser.elements.LogUtils;

public class ErrorCheck {
	
	
	private ErrorCheck(){}

	
	
	// TODO: this process alias only. need to expand to other types
	public static void checkVarUsedBeforeDefined(StudyTemp s) {
		
		for (String se : s.seqList){
			
			SequenceTemp seqObj = s.seqMap.get(se); 

			checkVarUsedBeforeDefined(seqObj);						
		}
	}
	
	public static void checkVarUsedBeforeDefined(SequenceTemp seqObj) {
		
		for (String key : seqObj.asMap.keySet()) {

			AliasTemp asObj = seqObj.asMap.get(key);
				
			if (asObj.dependants_unknown.size()>0){
				LogUtils.errMsg(asObj.fromWresl+
						"\n  Variable(s) unknown: "+asObj.dependants_unknown+" in Alias \""+asObj.id+"\"");
			}
	
		}	
		
		
		for (String key : seqObj.glMap.keySet()) {

			GoalTemp glObj = seqObj.glMap.get(key);
				
			if (glObj.dependants_unknown.size()>0){
				LogUtils.errMsg(glObj.fromWresl+
						"\n  Variable(s) unknown: "+glObj.dependants_unknown+" in Goal \""+glObj.id+"\"");
			}
	
		}
		
		for (String key : seqObj.svMap.keySet()) {

			SvarTemp svObj = seqObj.svMap.get(key);
				
			if (svObj.dependants_unknown.size()>0){
				LogUtils.errMsg(svObj.fromWresl+
						"\n  Variable(s) unknown: "+svObj.dependants_unknown+" in Svar \""+svObj.id+"\"");
			}
	
		}		

		
	}
	
	
	public static int checkVarRedefined (StudyTemp s){
		
		// check modelList itself
		
		for (String k: s.modelList){
			
			ModelTemp m = s.modelMap.get(k);
			
			checkVarRedefined(m);
			
		}
		
		return 0;

	}	

	public static int checkVarRedefined (ModelTemp m){
		
		// check dvar list duplicates
		ArrayList<String> dvDup = findDuplicates(m.dvList);
		
		if (dvDup.size()>0) {
			m.dvList = removeDuplicates(m.dvList);
		
			for (String s: dvDup){
				LogUtils.errMsg("Dvar redefined: "+s+" in file: "+m.dvMap.get(s).fromWresl);
			}
		}		
	
		// check svar list duplicates
		ArrayList<String> svDup = findDuplicates(m.svList);
		
		if (svDup.size()>0) {
			m.svList = removeDuplicates(m.svList);
		
			for (String s: svDup){
				LogUtils.errMsg("Svar redefined: "+s+" in file: unknown");
			}
		}
		
		// TODO: check incFile list duplicates

		
		// check wTable var duplicates
		ArrayList<String> wvDup = findDuplicates(m.wvList_defaultType);
		
		if (wvDup.size()>0) {
			m.wvList_defaultType = removeDuplicates(m.wvList_defaultType);
		
			for (String s: wvDup){
				LogUtils.errMsg("Weight redefined: "+s+" in file: unknown");
			}
		}	

		// check item list duplicates
		ArrayList<String> itemDup = findDuplicates(m.itemList);
		
		if (itemDup.size()>0) {
			m.itemList = removeDuplicates(m.itemList);
		
			for (String s: itemDup){
				LogUtils.errMsg("Item redefined: "+s+" in file: "+m.absPath);
			}
		}
		
		return 0;
	
	}

	
	public static ArrayList<String> findDuplicates(ArrayList<String> a){
		
		ArrayList<String> duplicates = new ArrayList<String>();
		
		if (a.size()<1) return duplicates;
		
		duplicates.addAll(a);
		Set<String> varSet = new LinkedHashSet<String>();
		
		varSet.addAll(a);
		
		for (String s: varSet) {
			duplicates.remove(s);
		}
		
		return duplicates;
	}
	
	public static ArrayList<String> removeDuplicates(ArrayList<String> a){

		Set<String> varSet = new LinkedHashSet<String>();
		
		varSet.addAll(a);
		
		return new ArrayList<String>(varSet);

	}

}
	
