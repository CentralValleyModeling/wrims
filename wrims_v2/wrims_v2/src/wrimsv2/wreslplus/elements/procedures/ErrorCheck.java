package wrimsv2.wreslplus.elements.procedures;

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
import wrimsv2.wreslplus.elements.AliasTemp;
import wrimsv2.wreslplus.elements.DvarTemp;
import wrimsv2.wreslplus.elements.GoalTemp;
import wrimsv2.wreslplus.elements.ModelTemp;
import wrimsv2.wreslplus.elements.SequenceTemp;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.SvarTemp;
import wrimsv2.wreslplus.elements.Tools;

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
						"\n  Variable(s) unknown "+asObj.dependants_unknown+" in Alias ["+asObj.id+"]");
			}
	
		}	
		
		
		for (String key : seqObj.glMap.keySet()) {

			GoalTemp glObj = seqObj.glMap.get(key);
				
			if (glObj.dependants_unknown.size()>0){
				LogUtils.errMsg(glObj.fromWresl+
						"\n  Variable(s) unknown "+glObj.dependants_unknown+" in Goal ["+glObj.id+"]");
			}
	
		}
		
		for (String key : seqObj.svMap.keySet()) {

			SvarTemp svObj = seqObj.svMap.get(key);
				
			if (svObj.dependants_unknown.size()>0){
				LogUtils.errMsg(svObj.fromWresl+
						"\n  Variable(s) unknown "+svObj.dependants_unknown+" in Svar ["+svObj.id+"]");
			}
	
		}		

		
	}

	public static boolean checkIncModelNotExistIgnoreCase (StudyTemp s){
		
		ArrayList<String> modelList_lowercase = new ArrayList<String>();
		
		modelList_lowercase.addAll(Tools.allToLowerCase(s.modelList));
		
		//System.out.println("modelList_lowercase:"+modelList_lowercase);
		
		for (ModelTemp mt: s.modelMap.values()){
			
			for ( String incM: mt.incModelList) {
				
				if ( !modelList_lowercase.contains(incM.toLowerCase())) {
					
					LogUtils.errMsg("Include model ["+ incM +"] not exist in model ["+mt.id+"].");
					
					return true;
				}
						
			}
			
		}
		
		return false;
		
	}
	
	public static int checkModelRedefinedIgnoreCase (StudyTemp s){
		
		ArrayList<String> modelDup = findDuplicatesIgnoreCase(s.modelList);
		
		//System.out.println("modelDup:"+modelDup);
		
		for (String m:modelDup){
			LogUtils.errMsg("Model ["+ m +"] redefined in main file.");
		}
		return modelDup.size();
		
	}
	
	public static int checkModelRedefined (StudyTemp s){
		
		ArrayList<String> modelDup = findDuplicates(s.modelList);
		
		//System.out.println("modelDup:"+modelDup);
		
		for (String m:modelDup){
			LogUtils.errMsg("Model ["+ s.modelMap.get(m).id +"] redefined in main file.");
		}
		return modelDup.size();
		
	}
	
	public static int checkVarRedefined (StudyTemp s){
		
		// check modelList itself
		// check item duplicates with model names
		
		
		// 
		int totalDup=0;
		for (String k: s.modelList){
			
			ModelTemp m = s.modelMap.get(k);
			
			totalDup += checkVarRedefined(m);
			
		}
		
		return totalDup;

	}	

	public static int checkVarRedefined (ModelTemp m){
				
		
		// check dvar list duplicates
		ArrayList<String> dvDup = findDuplicates(m.dvList);
		
		if (dvDup.size()>0) {
			m.dvList = removeDuplicates(m.dvList);
		
			for (String s: dvDup){
				DvarTemp dvO = m.dvMap.get(s);
				LogUtils.errMsg("Dvar ["+dvO.id+"] redefined in file ["+ dvO.fromWresl +"].");
			}
		}		
	
		// check svar list duplicates
		ArrayList<String> svDup = findDuplicates(m.svList);
		
		if (svDup.size()>0) {
			m.svList = removeDuplicates(m.svList);
		
			for (String s: svDup){
				SvarTemp svO = m.svMap.get(s);
				LogUtils.errMsg("Svar ["+svO.id+"] redefined in file ["+ svO.fromWresl +"].");
			}
		}
		
		// TODO: check incFile list duplicates

		
		// check wTable var duplicates
		ArrayList<String> wvDup = findDuplicates(m.wvList);
		
		if (wvDup.size()>0) {
			m.wvList = removeDuplicates(m.wvList);
		
			for (String s: wvDup){
				LogUtils.errMsg("Weight redefined: "+s+" in file: unknown.");
			}
		}	

		// check item list duplicates
		ArrayList<String> itemDup = findDuplicates(m.itemList);
		
		if (itemDup.size()>0) {
			m.itemList = removeDuplicates(m.itemList);
		
			for (String s: itemDup){
				LogUtils.errMsg("Item ["+s+"] redefined in file ["+ m.absPath +"].");
			}
		}
		
		return dvDup.size()+svDup.size()+wvDup.size()+itemDup.size();
	
	}

	public static ArrayList<String> findDuplicatesIgnoreCase(ArrayList<String> a){
		
		ArrayList<String> duplicates = new ArrayList<String>();
		
		if (a.size()<1) return duplicates;
		
		ArrayList<String> a_lowercase = Tools.allToLowerCase(a);
		
		duplicates.addAll(a_lowercase);
		Set<String> varSet = new LinkedHashSet<String>();
		
		varSet.addAll(a_lowercase);
		
		for (String s: varSet) {
			duplicates.remove(s);
		}
		
		return duplicates;
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
	
