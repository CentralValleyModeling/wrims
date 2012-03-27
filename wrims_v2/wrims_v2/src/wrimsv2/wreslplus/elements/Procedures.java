package wrimsv2.wreslplus.elements;

import java.io.File;
import java.io.IOException;
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
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.wreslparser.elements.LogUtils;

public class Procedures {

	private Procedures() {
	}

	public static void processGoalHS(StudyTemp s) {

		for (String m : s.modelList) {

			ModelTemp mObj = s.modelMap.get(m);

			processGoalHS(mObj);
		}
	}

	public static void processGoalHS(ModelTemp mObj) {

		for (String gKey : mObj.gl2List) {

			GoalTemp g2 = mObj.glMap.get(gKey);

			for (int i = 0; i < g2.caseName.size(); i++) {

				String cn = g2.caseName.get(i);
				GoalCase gc = g2.caseMap.get(cn);
				g2.caseCondition.add(gc.condition);

				// convert penalty into caseExpression
				Map<String, String> o = convertPenalty(g2.id.toLowerCase(), i, g2.lhs, gc);

				String slackName = o.get("slackName");
				String surplusName = o.get("surplusName");
				// System.out.println(slackName);
				// System.out.println(surplusName);

				g2.slackList.add(slackName);
				g2.surplusList.add(surplusName);
				g2.caseExpression.add(o.get("caseExpression"));

				if (slackName != null) {
					WeightTemp w = new WeightTemp();
					w.weight = o.get("slackWeight");

					DvarTemp d = new DvarTemp();
					d.fromWresl = g2.fromWresl;
					d.kind = "slack";

					if (g2.hasCase) {
						d.condition = Param.conditional;
						w.condition = Param.conditional;
						
						mObj.ssList_hasCase.add(slackName);
						mObj.ssMap_hasCase.put(slackName, d);
						mObj.ssWeightMap_hasCase.put(slackName, w);
						
					} else {

						mObj.ssList_noCase.add(slackName);
						mObj.ssMap_noCase.put(slackName, d);
						mObj.ssWeightMap_noCase.put(slackName, w);
					
					}
					// System.out.println(slackName+":"+g2.ruleType+":"+d.condition);
				}
				if (surplusName != null) {
					WeightTemp w = new WeightTemp();
					w.weight = o.get("surplusWeight");

					DvarTemp d = new DvarTemp();
					d.fromWresl = g2.fromWresl;
					d.kind = "surplus";

					if (g2.hasCase) {
						d.condition = Param.conditional;
						w.condition = Param.conditional;
						mObj.ssList_hasCase.add(surplusName);
						mObj.ssMap_hasCase.put(surplusName, d);
						mObj.ssWeightMap_hasCase.put(surplusName, w);
					} else {
					
						mObj.ssList_noCase.add(surplusName);
						mObj.ssMap_noCase.put(surplusName, d);
						mObj.ssWeightMap_noCase.put(surplusName, w);
						
					}
					
					// System.out.println(surplusName+":"+g2.ruleType+":"+d.condition);
				}

			}

			mObj.glMap.put(gKey, g2);

		}

	}

	private static Map<String, String> convertPenalty(String goalName, int caseIndex, String lhs, GoalCase cm) {

		String caseNumber = Integer.toString(caseIndex + 1);
		String caseExpression = null;
		String lhs_m = null;
		// String rhs_m=null;
		String relation = null;

		String lt = cm.lhs_lt_rhs;
		String gt = cm.lhs_gt_rhs;

		String slackName = null;
		String surplusName = null;
		String slackWeight = null;
		String surplusWeight = null;

		Map<String, String> expression_slack_surplus = new HashMap<String, String>();

		if (isConstrain(gt) && isConstrain(lt)) {

			lhs_m = lhs;
			relation = "=";
			caseExpression = lhs_m + relation + cm.rhs;

		}
		else if (isConstrain(gt)) {

			if (isFree(lt)) {

				lhs_m = lhs;
				relation = "<";
				caseExpression = lhs_m + relation + cm.rhs;

			}
			else {

				slackName = "slack__" + goalName + "_" + caseNumber;
				slackWeight = lt;
				lhs_m = lhs + "+" + slackName;
				relation = "=";
				caseExpression = lhs_m + relation + cm.rhs;
			}

		}
		else if (isConstrain(lt)) {

			if (isFree(gt)) {

				lhs_m = lhs;
				relation = ">";
				caseExpression = lhs_m + relation + cm.rhs;

			}
			else {

				surplusName = "surplus__" + goalName + "_" + caseNumber;
				surplusWeight = gt;
				lhs_m = lhs + "-" + surplusName;
				relation = "=";
				caseExpression = lhs_m + relation + cm.rhs;
			}

		}
		else if (isFree(gt) && isFree(lt)) {

			caseExpression = " 1 > 0 ";

		}
		else if (isFree(lt)) {

			surplusName = "surplus__" + goalName + "_" + caseNumber;
			surplusWeight = gt;
			lhs_m = lhs + "-" + surplusName;
			relation = "<";
			caseExpression = lhs_m + relation + cm.rhs;

		}
		else if (isFree(gt)) {

			slackName = "slack__" + goalName + "_" + caseNumber;
			slackWeight = lt;
			lhs_m = lhs + "+" + slackName;
			relation = ">";
			caseExpression = lhs_m + relation + cm.rhs;

		}
		else {

			surplusName = "surplus__" + goalName + "_" + caseNumber;
			surplusWeight = gt;
			lhs_m = lhs + "-" + surplusName;
			slackName = "slack__" + goalName + "_" + caseNumber;
			slackWeight = lt;
			lhs_m = lhs_m + "+" + slackName;
			relation = "=";
			caseExpression = lhs_m + relation + cm.rhs;
		}

		if (isNumber(slackWeight)) {
			slackWeight = "-" + slackWeight;
		}
		else {
			slackWeight = "-(" + slackWeight + ")";
		}

		if (isNumber(surplusWeight)) {
			surplusWeight = "-" + surplusWeight;
		}
		else {
			surplusWeight = "-(" + surplusWeight + ")";
		}

		expression_slack_surplus.put("caseExpression", caseExpression);
		expression_slack_surplus.put("slackName", slackName);
		expression_slack_surplus.put("surplusName", surplusName);
		expression_slack_surplus.put("slackWeight", slackWeight);
		expression_slack_surplus.put("surplusWeight", surplusWeight);
		return expression_slack_surplus;
	}

	private static boolean isConstrain(String v) {

		return v.equals(Param.constrain);

	}

	private static boolean isFree(String v) {

		try {

			int p = Integer.parseInt(v);
			if (p == 0) return true;

		}
		catch (Exception e) {
		}

		return false;

	}

	private static boolean isNumber(String v) {

		try {

			Float p = Float.parseFloat(v);
			return true;

		}
		catch (Exception e) {
		}

		return false;

	}

	public static void processDependants(StudyTemp s) {

		for (String m : s.modelList) {

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

			GoalTemp glObj = mObj.glMap.get(key);

			glObj.dependants.removeAll(Param.reservedSet);

		}

		for (String key : mObj.asMap.keySet()) {

			AliasTemp asObj = mObj.asMap.get(key);

			asObj.dependants.removeAll(Param.reservedSet);

		}

	}

	public static void copyModelSvMapToSequenceSvMap(StudyTemp st) {
		
		for (String seqName : st.seqList) {

			SequenceTemp seqObj = st.seqMap.get(seqName);
			ModelTemp seqModelObj = st.modelMap.get(seqObj.model);

			for (String f: seqModelObj.incFileRelativePathList_post){
			
				ModelTemp incModel = st.fileModelMap.get(f);
				copyModelSvMapToSequenceSvMap(incModel, seqObj);
			
			}
			
			copyModelSvMapToSequenceSvMap(seqModelObj, seqObj);
		}
		
	}

	public static void copyModelSvMapToSequenceSvMap(ModelTemp mt, SequenceTemp seq) {
		
		seq.svMap.putAll(mt.svMap);
		
	}
	
	public static void convertAliasToGoal(StudyTemp s) {

		for (String m : s.modelList) {

			ModelTemp mObj = s.modelMap.get(m);

			convertAliasToGoal(mObj);
			

		}

	}

	public static void convertAliasToGoal(ModelTemp mObj) {

		mObj.asList_reduced = new ArrayList<String>(mObj.asList);

		Set<String> allDepInGoals = new HashSet<String>();

		// add all dep from Goal
		for (String key : mObj.glMap.keySet()) {

			GoalTemp g = mObj.glMap.get(key);
			allDepInGoals.addAll(g.dependants);
		}
		// add all dep from Alias
		for (String key : mObj.asMap.keySet()) {

			AliasTemp a = mObj.asMap.get(key);
			allDepInGoals.addAll(a.dependants);
		}

		for (String aKey : mObj.asMap.keySet()) {

			if (allDepInGoals.contains(aKey)) {

				AliasTemp a = mObj.asMap.get(aKey);
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

				mObj.asList_reduced.remove(aKey);
				mObj.dvList_fromAlias.add(aKey);
				mObj.dvList.add(aKey);
				mObj.dvMap.put(aKey, d);

				// add goal
				GoalTemp g = new GoalTemp();
				g.fromWresl = a.fromWresl;
				g.id = a.id + "__alias";
				// String e = a.id.toLowerCase() + "=" + a.expression;
				g.caseExpression.add(a.id.toLowerCase() + "=" + a.expression);
				g.condition = a.condition;
				g.caseName.add(Param.defaultCaseName);
				g.caseCondition.add(Param.always);
				g.dependants = a.dependants;

				mObj.glList_fromAlias.add(g.id.toLowerCase());
				mObj.glList.add(g.id.toLowerCase());
				mObj.glMap.put(g.id.toLowerCase(), g);

			}

		}

	}

	// processed after lowercase conversion
	public static void collectWeightVar(StudyTemp s) {

		for (String m : s.modelList) {

			ModelTemp mObj = s.modelMap.get(m);

			collectWeightVar(mObj);

		}

	}

	// processed after lowercase conversion
	public static void collectWeightVar(ModelTemp mObj) {

		for (WeightTable wt : mObj.wTableObjList) {

			// TODO: can collect different objective type
			// if (wt.id.equalsIgnoreCase(s.objectiveType)){
			mObj.wvList_defaultType.addAll(wt.varList);
			mObj.wTableObjList_defaultType.add(wt);
			// }

		}

	}

	// processed after lowercase conversion
	public static void processIncFilePath(StudyTemp s) {

		for (String m : s.modelList_effective) {

			ModelTemp mObj = s.modelMap.get(m);

			processIncFilePath(mObj);

		}

	}

	// processed after lowercase conversion
	public static void processIncFilePath(ModelTemp m) {

		m.pathRelativeToRunDir = ResourceUtils.getRelativePath(m.absPath, GlobalData.runDir, "\\");

		for (String key : m.incFileMap.keySet()) {

			IncFileTemp f = m.incFileMap.get(key);

			try {
				f.absPath = new File(m.parentAbsPath, f.rawPath).getCanonicalPath().toLowerCase();
				m.incFileAbsPathList.add(f.absPath);
			}
			catch (IOException e) {
				e.printStackTrace();
				LogUtils.errMsg("Include file IOException: " + f.rawPath, m.absPath);
			}

			f.pathRelativeToRunDir = ResourceUtils.getRelativePath(f.absPath, GlobalData.runDir, "\\");
			m.incFileRelativePathList.add(f.pathRelativeToRunDir);

		}
		
		m.incFileAbsPathList_post = new ArrayList<String>(m.incFileAbsPathList);
		m.incFileRelativePathList_post = new ArrayList<String>(m.incFileRelativePathList);

	}

	public static void findEffectiveModelinMain(StudyTemp st) {
		
		for (String s: st.seqList){
			String modelName = st.seqMap.get(s).model;
			
			if (!st.modelList.contains(modelName)){
				LogUtils.errMsg("model name not found in sequence: " + modelName);
			}
			
			st.modelList_effective.add(modelName);
		}
	}


	public static void findKidMap(StudyTemp st) {
		
		for (String m: st.fileModelMap.keySet()){
			
			ArrayList<String> kids = st.fileModelMap.get(m).incFileRelativePathList;
			
			System.out.println("file:"+m);
			System.out.println("kids:"+kids);
			
			if (kids==null){
				st.noKid.add(m);			
			} else if (kids.isEmpty()){
				st.noKid.add(m);
			} else {
				st.kidMap.put(m, new HashSet<String>(kids));
			}
			
		}
		
		System.out.println("st.kidMap"+st.kidMap);
		
	}
	
	public static void findAOM(StudyTemp st) {

		for (String s: st.kidMap.keySet()) { 
			HashSet<String> a = Tools.findAllOffspring(s, st.kidMap);
			st.AOMap.put(s, a);
		}
		
	}

	public static void findFileGroupOrder(StudyTemp st) {
		
		Map<String,HashSet<String>> toBeSorted = new HashMap<String, HashSet<String>>(st.AOMap);
		
		System.out.println(st.AOMap);
		
		System.out.println("st.noKid"+st.noKid);
		st.fileGroupOrder.add(st.noKid);
		Tools.findFileHierarchy(st.fileGroupOrder, toBeSorted);
		
	}
	

	public static void processSvIncFileList( StudyTemp st) {
		
		
		for (String m : st.modelList_effective){

			processSvIncFileList(st.modelMap.get(m));
		
		}		
	}

	public static void processSvIncFileList( ModelTemp mt) {
		
		mt.svIncFileList = new ArrayList<String>(mt.itemList);
		mt.svIncFileList.removeAll(mt.tsList);
		mt.svIncFileList.removeAll(mt.asList);
		mt.svIncFileList.removeAll(mt.dvList);
		mt.svIncFileList.removeAll(mt.glList);
		mt.svIncFileList.removeAll(mt.gl2List);
		mt.svIncFileList.removeAll(mt.exList);
		
		for (String f : mt.incFileMap.keySet()){
			
			int index = mt.svIncFileList.indexOf(f);
			mt.svIncFileList.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
			
		}
		
		mt.svIncFileList_post = new ArrayList<String>(mt.svIncFileList);
//		
//		// TODO: check
//		mt.incFileAbsPathList_post = new ArrayList<String>(mt.incFileAbsPathList);
//		mt.incFileRelativePathList_post = new ArrayList<String>(mt.incFileRelativePathList);
		
	}
	

	public static void postProcessSvIncFileList(StudyTemp st) {
		
		// use the fileGroupOrder
		for (HashSet<String> fgroup: st.fileGroupOrder){
			
			for ( String f : fgroup){
				
				if (!st.AOMap.keySet().contains(f)) continue; // TODO: the whole first round can be skipped
				
						
				ModelTemp m = st.fileModelMap.get(f);
				ArrayList<String> list = m.svIncFileList;
				ArrayList<String> list_post = m.svIncFileList_post;
				
				
				for( String includedFile: st.AOMap.get(f)){
					int index =list_post.indexOf(includedFile);
					
					//if (index>-1){
					list_post.remove(index);
					
					ModelTemp includedModel = st.fileModelMap.get(includedFile);
					list_post.addAll(index, includedModel.svIncFileList_post); 
					
					// TODO: move to later process
					m.svMap.putAll(includedModel.svMap);

				}
			}
		}
		
		// process the main file includes
		for (String fi : st.modelList_effective){
			
			ModelTemp m = st.modelMap.get(fi);
			
			
			for (String includedFile: m.incFileRelativePathList ){
				int index = m.svIncFileList_post.indexOf(includedFile);
				ModelTemp includedModel = st.fileModelMap.get(includedFile);

				m.svIncFileList_post.remove(index);
				
				m.svIncFileList_post.addAll(index, includedModel.svIncFileList_post);
				// TODO: move to later process
				m.svMap.putAll(includedModel.svMap);


				
			}		
		}
	}

	public static void postProcessIncFileList(StudyTemp st) {
			
			// use the fileGroupOrder
			for (HashSet<String> fgroup: st.fileGroupOrder){
				
				for ( String f : fgroup){
					
					if (!st.AOMap.keySet().contains(f)) continue; // TODO: the whole first round can be skipped
					
							
					ModelTemp m = st.fileModelMap.get(f);

					ArrayList<String> list_post1 = m.incFileAbsPathList_post;
					ArrayList<String> list_post2 = m.incFileRelativePathList_post;
					
					
					for( String includedFile: st.AOMap.get(f)){
						int index =list_post1.indexOf(includedFile);
						
						
						ModelTemp includedModel = st.fileModelMap.get(includedFile);
						list_post1.addAll(index+1, includedModel.incFileAbsPathList_post); 
						list_post2.addAll(index+1, includedModel.incFileRelativePathList_post); 
						
					}
				}
			}
			
			// process the main file includes
			for (String fi : st.modelList_effective){
				
				ModelTemp m = st.modelMap.get(fi);
				
				for (String includedFile: m.incFileRelativePathList ){
					
					int index = m.incFileRelativePathList.indexOf(includedFile);
	
					ModelTemp includedModel = st.fileModelMap.get(includedFile);
					
					m.incFileRelativePathList_post.addAll(index+1, includedModel.incFileRelativePathList_post);
					m.incFileAbsPathList_post.addAll(index+1, includedModel.incFileAbsPathList_post);

					
				}		
			}
		}



	
}
