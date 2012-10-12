package wrimsv2.wreslplus.elements.procedures;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.javatuples.Triplet;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.components.ControlData;
import wrimsv2.components.IntDouble;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslplus.elements.DvarTemp;
import wrimsv2.wreslplus.elements.GoalTemp;
import wrimsv2.wreslplus.elements.SequenceTemp;
import wrimsv2.wreslplus.elements.WeightTemp;

public class Misc {

	private Misc() {
	}

	public static void addWeightInGroupWeightMap(String id, String fromWresl, String weight, SequenceTemp seqObj) {
		
		WeightTemp w1 = new WeightTemp();
		w1.id = id;
		w1.fromWresl = fromWresl;
		w1.weight = weight;

		seqObj.groupWeightMap.put(id.toLowerCase(), w1);
		seqObj.wvList.add(id.toLowerCase());
		
	}	
	
	public static void createDvarInSeqObj(String id, String ub, String lb, String kind, String units, 
			String fromWresl, String condition, SequenceTemp seqObj) {
		
		DvarTemp d = new DvarTemp();
		d.id = id;
		d.upperBound = ub;
		d.lowerBound = lb;
		d.kind = kind;
		d.units = units;
		d.fromWresl = fromWresl;
		d.condition = condition;

		seqObj.dvList.add(d.id.toLowerCase());
		seqObj.dvMap.put(d.id.toLowerCase(), d);
		
	}

	public static void createGoalInSeqObj(String id, String lhs, String relation, String rhs,  
			Set<String> dependants, String fromWresl, String condition, SequenceTemp seqObj) {
		
		GoalTemp g = new GoalTemp();
		g.fromWresl = fromWresl;
		g.id = id;

		g.caseExpression.add(lhs + relation + rhs);
		g.condition = condition;
		g.caseName.add(Param.defaultCaseName);
		g.caseCondition.add(Param.always);
		g.dependants = dependants;

		seqObj.glList.add(g.id.toLowerCase());
		seqObj.glMap.put(g.id.toLowerCase(), g);
		
	}
	
}
