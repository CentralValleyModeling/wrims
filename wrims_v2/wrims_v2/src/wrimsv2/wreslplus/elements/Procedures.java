package wrimsv2.wreslplus.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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

	public static void processGoalHS(StudyTemp s) {
		
		//TODO: use seq list
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

	public static void processGoalHS2(StudyTemp s) {

		for (String seqName : s.seqList) {

			SequenceTemp seqObj = s.seqMap.get(seqName);

			processGoalHS2(seqObj);
		}
		
	}

	public static void processGoalHS2(SequenceTemp seqObj) {
	
		for (String gKey : seqObj.gl2List) {
	
			GoalTemp g2 = seqObj.glMap.get(gKey);
	
			// added to prevent re-assignment in the later sequence 
			// if this goal obj is copied to different seqObj from the same included file.
			// This approach is to reduce data size by not using different goal obj.
			g2.caseCondition = new ArrayList<String>();
			
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
						
						seqObj.ssList_hasCase.add(slackName);
						seqObj.ssMap_hasCase.put(slackName, d);
						seqObj.ssWeightMap_hasCase.put(slackName, w);
						
					} else {
	
						seqObj.ssList_noCase.add(slackName);
						seqObj.ssMap_noCase.put(slackName, d);
						seqObj.ssWeightMap_noCase.put(slackName, w);
					
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
						seqObj.ssList_hasCase.add(surplusName);
						seqObj.ssMap_hasCase.put(surplusName, d);
						seqObj.ssWeightMap_hasCase.put(surplusName, w);
					} else {
					
						seqObj.ssList_noCase.add(surplusName);
						seqObj.ssMap_noCase.put(surplusName, d);
						seqObj.ssWeightMap_noCase.put(surplusName, w);
						
					}
					
					// System.out.println(surplusName+":"+g2.ruleType+":"+d.condition);
				}
	
			}
	
			seqObj.glMap.put(gKey, g2);
	
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

			float p = Float.parseFloat(v);
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

	public static void copyModelVarMapToSequenceVarMap(StudyTemp st) {
		
		for (String seqName : st.seqList) {
			
			SequenceTemp seqObj = st.seqMap.get(seqName);
			ModelTemp seqModelObj = st.modelMap.get(seqObj.model);

			seqObj.svIncFileList_post = seqModelObj.svIncFileList_post;
			seqObj.asIncFileList_post = seqModelObj.asIncFileList_post;
			seqObj.exIncFileList_post = seqModelObj.exIncFileList_post;
			
			for (String f: seqModelObj.incFileRelativePathList_post){
			
				// TODO: allow multiple models in a file
				//Pair<String,String> p = new Pair<String, String>(f, st.fileModelNameMap.get(f).get(0));
				//ModelTemp incModel = st.fileModelDataMap.get(p);
				ModelTemp incModel = st.fileModelDataTable.get(f, st.fileModelNameMap.get(f).get(0));
				
				copyModelVarMapToSequenceVarMap(incModel, seqObj);
			
			}
			
			copyModelVarMapToSequenceVarMap(seqModelObj, seqObj);
		}
		
	}

	public static void copyModelVarMapToSequenceVarMap(ModelTemp mt, SequenceTemp seq) {
		
		//System.out.println("0427: "+mt.pathRelativeToRunDir+" : "+mt.dvList);
		
		for (String cycleName: mt.neededCycleVarMap.keySet()){
		
			if (seq.neededCycleVarMap.containsKey(cycleName)){
				
				seq.neededCycleVarMap.get(cycleName).addAll(mt.neededCycleVarMap.get(cycleName));
			}
			else {
				seq.neededCycleVarMap.put(cycleName, mt.neededCycleVarMap.get(cycleName));
			}
		}
		
		seq.exList.addAll(mt.exList);
		seq.dvList.addAll(mt.dvList);
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
		
	}
	
	public static void convertAliasToGoal(StudyTemp s) {

//		for (String m : s.modelList) {
//
//			ModelTemp mObj = s.modelMap.get(m);
//
//			convertAliasToGoal(mObj);
//			
//		}
		
		for (String se : s.seqList){
			
			SequenceTemp seqObj = s.seqMap.get(se); 
			String m = seqObj.model;

			//ModelTemp mObj = s.modelMap.get(m);

			convertAliasToGoal(seqObj);				
			
		}

	}

	public static void convertAliasToGoal(SequenceTemp seqObj) {

		//mObj.asList_reduced = new ArrayList<String>(mObj.asList);

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

	// processed after lowercase conversion
	public static void collectWeightVar(StudyTemp s) {

		for (String seq : s.seqList) {
			
			SequenceTemp seqObj = s.seqMap.get(seq);
			
			String m = seqObj.model;

			ModelTemp mObj = s.modelMap.get(m);

			collectWeightVar(mObj, seqObj, s);

		}

	}

	// processed after lowercase conversion
	public static void collectWeightVar(ModelTemp mObj, SequenceTemp seqObj, StudyTemp st) {

		
		for (String f: mObj.incFileRelativePathList_post){
		
			// TODO: enable for multiple model per file
			String mn = st.fileModelNameMap.get(f).get(0);
			ArrayList<WeightTable> wl = st.fileModelDataTable.get(f, mn).wTableObjList;
			
			for (WeightTable wt : wl) {

				// TODO: can collect different objective type
				// if (wt.id.equalsIgnoreCase(s.objectiveType)){
				seqObj.wvList_defaultType.addAll(wt.varList);
				seqObj.wTableObjList_defaultType.add(wt);
				// }
			}			
		}
			
		for (WeightTable wt : mObj.wTableObjList) {

			// TODO: can collect different objective type
			// if (wt.id.equalsIgnoreCase(s.objectiveType)){
			seqObj.wvList_defaultType.addAll(wt.varList);
			seqObj.wTableObjList_defaultType.add(wt);
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

	public static void postProcessIncFileList(StudyTemp st) {
		
		// use the fileGroupOrder
		for (HashSet<String> fgroup: st.fileGroupOrder){
			
			for ( String f : fgroup){
				
				if (!st.AOMap.keySet().contains(f)) continue; // TODO: the whole first round can be skipped
				
						
				//Pair<String,String> p = new Pair<String, String>(f, st.fileModelNameMap.get(f).get(0));
				
				//ModelTemp m = st.fileModelDataMap.get(p);
				ModelTemp m = st.fileModelDataTable.get(f,st.fileModelNameMap.get(f).get(0));
				ArrayList<String> list_post1 = m.incFileAbsPathList_post;
				ArrayList<String> list_post2 = m.incFileRelativePathList_post;
				
				
				for( String includedFile: st.AOMap.get(f)){
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

	// TODO: delete this. this has errors
	public static void postProcessVarListinIncFile_step1(StudyTemp st) {
		
		// use the fileGroupOrder
		for (HashSet<String> fgroup: st.fileGroupOrder){
			
			for ( String f : fgroup){
				
				if (!st.AOMap.keySet().contains(f)) continue; // TODO: the whole first round can be skipped
				
				String modelName = st.fileModelNameMap.get(f).get(0);		
				
				ModelTemp m = st.fileModelDataTable.get(f,modelName);
				
				for( String includedFile: st.AOMap.get(f)){
					
					int index =m.svIncFileList_post.indexOf(includedFile);
					
					System.out.println("f: "+f);
					System.out.println("includedFile: "+includedFile);
					
					if (index<0) {
						System.out.println("## problem::");
						System.out.println("model: "+modelName);
						System.out.println("this file1: "+m.absPath);
						System.out.println("this file2: "+f);
						System.out.println("includedFile: "+includedFile);
						System.out.println("m.svIncFileList_post: ");
						System.out.println(m.svIncFileList_post);
					}
					
					//m.svIncFileList_post.remove(index);
					
					//Pair<String,String> p2 = new Pair<String, String>(includedFile, st.fileModelNameMap.get(includedFile).get(0));
					
					ModelTemp includedModel = st.fileModelDataTable.get(includedFile,st.fileModelNameMap.get(includedFile).get(0));
					m.svIncFileList_post.addAll(index+1, includedModel.incFileRelativePathList_post); 
					

	
				}
			}
		}
		
		// process the main file except the first model includes
		ArrayList<String> ttt = new ArrayList<String>(st.modelList_effective);
	
		for (String modelNameOfMain : ttt){
			
			ModelTemp m = st.modelMap.get(modelNameOfMain);
			
			
			for (String includedFile: m.incFileRelativePathList ){
				
				int index = m.svIncFileList_post.indexOf(includedFile);
				
				String modelName = st.fileModelNameMap.get(includedFile).get(0);
				
				//Pair<String,String> p = new Pair<String, String>(includedFile, modelName);
				
				ModelTemp includedModel = st.fileModelDataTable.get(includedFile,modelName);
	
				
//				System.out.println("err: this model:   "+modelNameOfMain);
//				System.out.println("err: m.svIncFileList_post: "+m.svIncFileList_post);
//				System.out.println("err: includedFile: "+includedFile);
//				System.out.println("err: index:        "+index);
				//m.svIncFileList_post.remove(index);
				
				m.svIncFileList_post.addAll(index+1, includedModel.incFileRelativePathList_post);
				
			}		
		}
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
		
		for (String f: st.fileModelNameMap.keySet()){
			
			String modelName = st.fileModelNameMap.get(f).get(0);
			
			ArrayList<String> kids = st.fileModelDataTable.get(f,modelName).incFileRelativePathList;
			
			//System.out.println("file:"+f);
			//System.out.println("kids:"+kids);
			
			if (kids==null){
				st.noKid.add(f);			
			} else if (kids.isEmpty()){
				st.noKid.add(f);
			} else {
				//st.kidssMap.put(f, modelName, new HashSet<String>(kids));
				st.kidMap.put(f, new HashSet<String>(kids));
			}
			
		}
		
		//System.out.println("st.kidsMap"+st.kidsMap);
		
	}
	
	public static void findAOM(StudyTemp st) {

//		for (String f: st.kidsMap.rowKeySet()) { 
//			
//			for (String m : st.kidsMap.row(f).keySet()){
//				
//				HashSet<String> a = Tools.findAllOffspring(f, m, st.kidsMap);
//				if (!st.AOMap.keySet().contains(f)) {
//					st.AOMap.put(f, a);
//				} else {
//					st.AOMap.get(f).addAll(a);
//				}
//			
//			}
//		}

		for (String f: st.kidMap.keySet()) { 
				
			HashSet<String> a = Tools.findAllOffspring(f, st.kidMap);
			
			st.AOMap.put(f, a);			
			
		}
		
	}

	public static void findFileGroupOrder(StudyTemp st) {
		
		Map<String,HashSet<String>> toBeSorted = new HashMap<String, HashSet<String>>(st.AOMap);
		
		///// skip mainFile
		toBeSorted.remove(st.relativePath);
		
		//System.out.println("st.noKid"+st.noKid);
		st.fileGroupOrder.add(st.noKid);
		
		
		Tools.findFileHierarchy(st.fileGroupOrder, toBeSorted);
		
	}
	

	public static void processVarIncFileList( StudyTemp st) {
		
		// TODO: use sequence instead of effective list
		for (String m : st.modelList_effective){

			processVarIncFileList(st.modelMap.get(m));
		
		}		
	}

	public static void processT_svList( StudyTemp st) {
		
		// TODO: use sequence instead of effective list
		for (String m : st.modelList_effective){

			processT_svList(st.modelMap.get(m));
		
		}		
	}
	
	public static void processVarIncFileList( ModelTemp mt) {
		
		// TODO: use retain Set to simplify codes
		mt.svIncFileList = new ArrayList<String>(mt.itemList);
		mt.svIncFileList.removeAll(mt.tsList);
		mt.svIncFileList.removeAll(mt.asList);
		mt.svIncFileList.removeAll(mt.dvList);
		mt.svIncFileList.removeAll(mt.glList);
		mt.svIncFileList.removeAll(mt.exList);

		mt.asIncFileList = new ArrayList<String>(mt.itemList);
		mt.asIncFileList.removeAll(mt.tsList);
		mt.asIncFileList.removeAll(mt.svList);
		mt.asIncFileList.removeAll(mt.dvList);
		mt.asIncFileList.removeAll(mt.glList);
		mt.asIncFileList.removeAll(mt.exList);
		
		mt.exIncFileList = new ArrayList<String>(mt.itemList);
		mt.exIncFileList.removeAll(mt.tsList);
		mt.exIncFileList.removeAll(mt.svList);
		mt.exIncFileList.removeAll(mt.dvList);
		mt.exIncFileList.removeAll(mt.glList);
		mt.exIncFileList.removeAll(mt.asList);
		
		for (String f : mt.incFileMap.keySet()){
			
			int index = mt.svIncFileList.indexOf(f);
			mt.svIncFileList.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
			
			index = mt.asIncFileList.indexOf(f);
			mt.asIncFileList.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
			
			index = mt.exIncFileList.indexOf(f);
			mt.exIncFileList.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
		}
		
		mt.svIncFileList_post = new ArrayList<String>(mt.svIncFileList);
		
		mt.asIncFileList_post = new ArrayList<String>(mt.asIncFileList);
		
		mt.exIncFileList_post = new ArrayList<String>(mt.exIncFileList);
//		
//		// TODO: check
//		mt.incFileAbsPathList_post = new ArrayList<String>(mt.incFileAbsPathList);
//		mt.incFileRelativePathList_post = new ArrayList<String>(mt.incFileRelativePathList);
		
	}

	public static void processT_svList( ModelTemp mt) {
		
		// don't use svIncFileList because this is supposed to replace that
		
		ArrayList<Triplet<String, String, String>> t =  new ArrayList<Triplet<String,String,String>>();
	

		
		
		for (int i=0;i<mt.itemList.size();i++){
			
			if (mt.itemTypeList.get(i)==Param.svType) {
				
				String svName = mt.itemList.get(i);
				
				//TODO: might need to fill in operation name
				mt.t_svList.add(new Triplet<String, String, String>(mt.pathRelativeToRunDir, "", svName));
				
			} else if (mt.itemTypeList.get(i)==Param.incFileType) {
				
				String incFileID = mt.itemList.get(i);
				String incFileRelativePath = mt.incFileMap.get(incFileID).pathRelativeToRunDir;
				
				// null means processed later
				mt.t_svList.add(new Triplet<String, String, String>(incFileRelativePath, "", null));
				
			}	
			
		}
		
		mt.t_svList_post = new ArrayList<Triplet<String,String,String>>(mt.t_svList);

		//System.out.println("t_svList: "+mt.t_svList);
	}

	// replace file with vars
	public static void postProcessVarListinIncFile(StudyTemp st) {
		
		// use the fileGroupOrder
		for (HashSet<String> fgroup: st.fileGroupOrder){
			
			for ( String f : fgroup){
				
				if (!st.AOMap.keySet().contains(f)) continue; // TODO: the whole first round can be skipped
				
				String modelName = st.fileModelNameMap.get(f).get(0);		
				
				ModelTemp m = st.fileModelDataTable.get(f,modelName);
				
				for( String includedFile: st.AOMap.get(f)){
					
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

			classifyDependants(seqObj);						
		}
	}
	public static void classifyDependants(SequenceTemp seqObj) {
		
		for (String key : seqObj.asMap.keySet()) {

			AliasTemp asObj = seqObj.asMap.get(key);

			asObj.dependants.removeAll(seqObj.tsList);
			asObj.dependants.removeAll(seqObj.dvList);
		}	
		
		for (String key : seqObj.svMap.keySet()) {

			SvarTemp svObj = seqObj.svMap.get(key);

			svObj.dependants.removeAll(seqObj.tsList);
			svObj.dependants.removeAll(seqObj.dvList);
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

						if (q.asList.contains(e)) {
							q.aliasUsedByLaterCycle.add(e);
						}
						else if (q.dvList.contains(e)) {
							q.dvarUsedByLaterCycle.add(e);
						}
						else if (q.svIncFileList_post.contains(e)) {
							q.svarUsedByLaterCycle.add(e);
						}
						else {
							System.out.println("Error in analyzeVarNeededFromCycles");
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
