package wrimsv2.wreslplus.elements.procedures;

import java.util.ArrayList;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.wreslplus.elements.ModelTemp;
import wrimsv2.wreslplus.elements.SequenceTemp;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.WeightSubgroup;
import wrimsv2.wreslplus.elements.WeightTable;

public class ProcWeight {

	private ProcWeight() {
	}

	// processed after collecting weights
	public static void processWeightGroup(StudyTemp s) {

		for (String seq : s.seqList) {

			SequenceTemp seqObj = s.seqMap.get(seq);

			// TODO: process weight group in seqObj's wt list
			for (WeightTable wt : seqObj.wTableObjList_defaultType) {

				if (wt.isWeightGroup) {

					// TODO: process subgroup here
					//processSubgroup(wt);
					
					boolean mainCommonPenaltyIsZero = false;
					try { mainCommonPenaltyIsZero = Float.parseFloat(wt.commonPenalty)==0;} catch (Exception e) {}
										
					
					for (WeightSubgroup wsg : wt.subgroupMap.values()){

						boolean subCommonPenaltyIsZero = false;
						try { subCommonPenaltyIsZero = Float.parseFloat(wsg.commonPenalty)==0;} catch (Exception e) {}
/// process subgroup
						if (!mainCommonPenaltyIsZero || !subCommonPenaltyIsZero) {
							/// process subgroup
							// create new dvar for subgroup id. this is the
							// average for the subgroup
							Misc.createDvarInSeqObj(wsg.id, Param.upper_unbounded, Param.lower_unbounded,
									"weightgroup_mean", "na", wt.fromWresl, wt.condition, seqObj);

							// create new goal for subgroup average
							String goal_id = "wg__" + wt.id + "__" + wsg.id + "__mean";
							String lhs = wsg.varList.size() + "*" + wsg.id.toLowerCase();
							String rhs = "";
							for (String v : wsg.varList) {
								rhs = rhs + v + "+";
							}
							rhs = rhs.substring(0, rhs.length() - 1);
							// TODO: dependants check
							Misc.createGoalInSeqObj(goal_id, lhs, "=", rhs, wt.dependants, wt.fromWresl, wt.condition,
									seqObj);
						}
						
						if (!subCommonPenaltyIsZero) {
							
							
							// create slack and surplus for var in varList
							String weight = "-(" + wsg.commonPenalty + ")";
							
							for (String var : wsg.varList) {

								String slack_id =   "wg__" + wt.id.toLowerCase() + "__" + wsg.id.toLowerCase() + "__" + var + "__slack";
								String surplus_id = "wg__" + wt.id.toLowerCase() + "__" + wsg.id.toLowerCase() + "__" + var + "__surplus";

								// add slack						
								Misc.createDvarInSeqObj(slack_id, Param.upper_unbounded, Param.zero, "weightgroup_slack", "na", wt.fromWresl, wt.condition, seqObj);
								
								Misc.addWeightInGroupWeightMap(slack_id, wt.fromWresl, weight, seqObj);

								// add surplus
								Misc.createDvarInSeqObj(surplus_id, Param.upper_unbounded, Param.zero, "weightgroup_surplus", "na", wt.fromWresl, wt.condition, seqObj);

								Misc.addWeightInGroupWeightMap(surplus_id, wt.fromWresl, weight, seqObj);

								// add goal for slack surplus
								String goal_ss_id = "wg__" + wt.id + "__" + wsg.id + "__" + var + "__ss";
								String lhs_ss = var + "+" + slack_id + "-" + surplus_id;
								String rhs_ss = wsg.id.toLowerCase();

								Misc.createGoalInSeqObj(goal_ss_id, lhs_ss, "=", rhs_ss, wt.dependants, wt.fromWresl, wt.condition, seqObj);

							}
							
							
						}
					} // end for loop subgroup
					
					
/// process main group					
					if (!mainCommonPenaltyIsZero) {
						
						/// process main group
						// create new dvar for average
						String average_id = "mean__" + wt.id;
						String kind = "weightgroup_mean";
						String units = "na";

						Misc.createDvarInSeqObj(average_id, Param.upper_unbounded, Param.lower_unbounded, kind, units, wt.fromWresl, wt.condition, seqObj);
						
						// create new goal for group average						
						ArrayList<String> varList_and_subGroupId = new ArrayList<String>();
						varList_and_subGroupId.addAll(wt.varList);
						varList_and_subGroupId.addAll(wt.subgroupMap.keySet());
						String goal_id = "wg__" + wt.id + "__mean";
						int mult =wt.varList.size()+wt.subgroupMap.keySet().size();
						String lhs = mult + "*" + average_id.toLowerCase();
						String rhs = "";
						for (String v : varList_and_subGroupId) {
							rhs = rhs + v + "+";
						}
						rhs = rhs.substring(0, rhs.length() - 1);
						Misc.createGoalInSeqObj(goal_id, lhs, "=", rhs, wt.dependants, wt.fromWresl, wt.condition, seqObj);
						

						// create slack and surplus for var in varList
						String weight = "-(" + wt.commonPenalty + ")";
						
						for (String var : varList_and_subGroupId) {

							String slack_id = "wg__" + wt.id.toLowerCase() + "__" + var + "__slack";
							String surplus_id = "wg__" + wt.id.toLowerCase() + "__" + var + "__surplus";

							// add slack						
							Misc.createDvarInSeqObj(slack_id, Param.upper_unbounded, Param.zero, "weightgroup_slack", "na", wt.fromWresl, wt.condition, seqObj);
							
							Misc.addWeightInGroupWeightMap(slack_id, wt.fromWresl, weight, seqObj);

							// add surplus
							Misc.createDvarInSeqObj(surplus_id, Param.upper_unbounded, Param.zero, "weightgroup_surplus", "na", wt.fromWresl, wt.condition, seqObj);

							Misc.addWeightInGroupWeightMap(surplus_id, wt.fromWresl, weight, seqObj);

							// add goal for slack surplus
							String goal_ss_id = "wg__" + wt.id + "__" + var + "__ss";
							String lhs_ss = var + "+" + slack_id + "-" + surplus_id;
							String rhs_ss = average_id.toLowerCase();

							Misc.createGoalInSeqObj(goal_ss_id, lhs_ss, "=", rhs_ss, wt.dependants, wt.fromWresl, wt.condition, seqObj);

						}

					}

				}

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
				for (WeightSubgroup wsg: wt.subgroupMap.values() ){
					seqObj.wvList_defaultType.addAll(wsg.varList);
				}
				//seqObj.wvList_defaultType.addAll(wt.subgroupMap.keySet());
				seqObj.wTableObjList_defaultType.add(wt);
				// }
			}			
		}
	
		for (WeightTable wt : mObj.wTableObjList) {
	
			// TODO: can collect different objective type
			// if (wt.id.equalsIgnoreCase(s.objectiveType)){
			seqObj.wvList_defaultType.addAll(wt.varList);
			for (WeightSubgroup wsg: wt.subgroupMap.values() ){
				seqObj.wvList_defaultType.addAll(wsg.varList);
			}
			//seqObj.wvList_defaultType.addAll(wt.subgroupMap.keySet());
			seqObj.wTableObjList_defaultType.add(wt);
			// }
	
		}
	
	}





	
}
