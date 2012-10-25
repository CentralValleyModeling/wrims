package wrimsv2.wreslplus.elements.procedures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


import wrimsv2.components.Error;
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
import wrimsv2.wreslplus.elements.WeightSubgroup;
import wrimsv2.wreslplus.elements.WeightTable;

public class ErrorCheck {
	
	
	private ErrorCheck(){}

//	// these dvars are from slack and surplus of weight group deviation penalty
//	public static boolean checkDeviationSlackSurplus(ArrayList<String> dvList_monitored, Map<String, Dvar> dvMap) {
//		
//		ArrayList<String> errorList = new ArrayList<String>();
//		
//		for (String x : dvList_monitored){
//			
//			double v = (Double) dvMap.get(x).getData().getData();
//			
//			if (v > Param.deviationSlackSurplusTolerance) {
//				
//				errorList.add(x);
//				
//			}			
//			
//		}
//		
//		if (errorList.size()>0) {
//			
//			Error.addDeviationError( " Deviation slack and surplus are not zero: "+errorList); 
//			Error.writeDeviationErrorFile("Error_deviation.txt");
//			return true;
//			
//		}
//		
//		return false;
//			
//	}	

	// these dvars are from slack and surplus of weight group deviation penalty
	public static boolean checkDeviationSlackSurplus(Map<String,Double> deviationSS_toleranceMap, Map<String, Dvar> dvMap) {
		
		ArrayList<String> errorList = new ArrayList<String>();
		
		for (String x : deviationSS_toleranceMap.keySet()){
			
			double v = (Double) dvMap.get(x).getData().getData();
			
			if (v > deviationSS_toleranceMap.get(x)) {
				
				errorList.add(x);
				Error.addDeviationError( "Tolerance of ["+ deviationSS_toleranceMap.get(x) +"] exceeded by deviation slack and surplus: ["+x+"]"); 
				
			}			
			
		}
		
		if (errorList.size()>0) {
			
			Error.writeDeviationErrorFile("Error_deviation.txt");
			Error.writeErrorLog();
			return true;
			
		}
		
		return false;
			
	}
	
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

	public static int checkSequenceHasUniqueModel (StudyTemp s){
		
		ArrayList<String> modelList = new ArrayList<String>();
		
		//modelList_lowercase.addAll(Tools.allToLowerCase(s.modelList));
		
		
		for (SequenceTemp seq: s.seqMap.values()){
			
			modelList.add(seq.model.toLowerCase());
			
		}
		
		ArrayList<String> modelDup = findDuplicatesIgnoreCase(modelList);
		
		for (String m:modelDup){
			LogUtils.errMsg("Each sequence must define unique model. ["+ m +"] is used in multiple sequences.");
		}
		return modelDup.size();
		

		
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
		ArrayList<String> wvDup = findDuplicates(m.wvList_post);
		
		if (wvDup.size()>0) {
			m.wvList_post = removeDuplicates(m.wvList_post);
		
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



	public static boolean checkWeightObjList(StudyTemp st) {

		boolean ret = false;
		
		for (String seqName : st.seqList) {
			
			SequenceTemp seqObj = st.seqMap.get(seqName);

			
		//// check duplicate weight group (objective) names
			ArrayList<String> WeightObjIdList = new ArrayList<String>();
			
			for (WeightTable wt: seqObj.wTableObjList){
				
				WeightObjIdList.add(wt.id_lowcase);
				
			}
			if (findDuplicates(WeightObjIdList).size()>0) {
				
				for (String id : findDuplicates(WeightObjIdList)) {
					LogUtils.errMsg(" Objective ["+id+"] is redefined in Sequence ["+ seqName +"]");
				
				}
				
				return true;
				
			}
			
		//// check deviation penalty and tolerance "Not a number" in weight group	

			for (WeightTable wt: seqObj.wTableObjList){
				
				if (wt.isWeightGroup) {
					
					try {
						
						double p = Double.parseDouble(wt.deviationPenalty);
						
						if (p<0) {
							LogUtils.errMsg(" Deviation Penalty ["+ wt.deviationPenalty +"] in Objective ["+ wt.id_raw +"] must be a nonnegative number." );	
							ret = true;
						}
						
					} catch (Exception e) {
						
						LogUtils.errMsg(" Deviation Penalty ["+ wt.deviationPenalty +"] in Objective ["+ wt.id_raw +"] must be a pure number." );	
						
						ret = true;
					}

					try {
						
						double p = Double.parseDouble(wt.deviationTolerance);
						
						if (p<0) {
							LogUtils.errMsg(" Deviation Tolerance ["+ wt.deviationTolerance +"] in Objective ["+ wt.id_raw +"] must be a nonnegative number." );	
							ret = true;
						}
						
					} catch (Exception e) {
						
						LogUtils.errMsg(" Deviation Tolerance ["+ wt.deviationTolerance +"] in Objective ["+ wt.id_raw +"] must be a pure number." );	
						
						ret = true;
					}
					
					for (WeightSubgroup ws: wt.subgroupMap.values()){
						
						
						try {
							
							double p = Double.parseDouble(ws.deviationPenalty);
							
							if (p<0) {
								LogUtils.errMsg(" Deviation Penalty ["+ ws.deviationPenalty +"] in Objective ["+ wt.id_raw +"] must be a nonnegative number." );	
								ret = true;
							}
							
						} catch (Exception e) {
							
							LogUtils.errMsg(" Deviation Penalty ["+ ws.deviationPenalty +"] in Objective ["+ wt.id_raw +"] must be a pure number." );	
							
							ret = true;
						}
						
						try {
							
							double p = Double.parseDouble(ws.deviationTolerance);
							
							if (p<0) {
								LogUtils.errMsg(" Deviation Tolerance ["+ ws.deviationTolerance +"] in Objective ["+ wt.id_raw +"] must be a nonnegative number." );	
								ret = true;
							}
							
						} catch (Exception e) {
							
							LogUtils.errMsg(" Deviation Tolerance ["+ ws.deviationTolerance +"] in Objective ["+ wt.id_raw +"] must be a pure number." );	
							
							ret = true;
						}
						
					}

				}				

			}
			
			if (ret) return true;
			
			
		//// check duplicate variables inside the same weight group (objective)
			
			for (WeightTable wt: seqObj.wTableObjList){
				
				ArrayList<String> varList = new ArrayList<String>();
				
				if (wt.isWeightGroup) {
					varList.addAll(wt.varList);
					varList.addAll(wt.subgroupMap.keySet());
					
					for (WeightSubgroup ws: wt.subgroupMap.values()){
						
						varList.addAll(ws.varList);
					
					}
					
				}
				else {
					varList.addAll(wt.varList);

				}
				
				if (findDuplicates(varList).size()>0) {
					
					for (String var : findDuplicates(varList)) {
						LogUtils.errMsg(" Weight variable ["+var+"] in Objective ["+ wt.id_raw +"] is redefined in Sequence ["+ seqName +"]");	
					}
										
					ret = true;
				}
			}
			
			if (ret) return true;
			
	//// check duplicates variables inside the sequence
		
			ArrayList<String> varList = new ArrayList<String>();
			
			for (WeightTable wt: seqObj.wTableObjList){
				
				if (wt.isWeightGroup) {
					varList.addAll(wt.varList);
					varList.addAll(wt.subgroupMap.keySet());
					
					for (WeightSubgroup ws: wt.subgroupMap.values()){
						
						varList.addAll(ws.varList);
					
					}
					
				}
				else {
					varList.addAll(wt.varList);

				}
				
			}
			
			if (findDuplicates(varList).size()>0) {
				
				for (String var : findDuplicates(varList)) {
					LogUtils.errMsg(" Weight variable ["+var+"] is redefined in Sequence ["+ seqName +"]");	
				}
									
				ret = true;
			}
			
			if (ret) return true;
			
			
		}
		
		return false;
		
	}




}
	
