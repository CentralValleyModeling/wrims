package wrimsv2.commondata.solverdata;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.WeightElement;

public class SolverData {
	private static Map<String, EvalConstraint> constraintDataMap=new HashMap<String, EvalConstraint>();
	private static Map<String, Dvar> dvarMap= new HashMap<String, Dvar>();
	private static Map<String, WeightElement> weightMap = new HashMap<String, WeightElement>();
	private static Map<String, WeightElement> weightSlackSurplusMap = new HashMap<String, WeightElement>();

	public static Map<String, WeightElement> getWeightMap(){
		return weightMap;
	}
	
	public static void setWeightMap(Map<String, WeightElement> wtMap){
		weightMap=wtMap;
	}
	
	public static Map<String, WeightElement> getWeightSlackSurplusMap(){
		return weightSlackSurplusMap;
	}
	
	public static void setWeightSlackSurplusMap(Map<String, WeightElement> wtSlackSurplusMap){
		weightSlackSurplusMap=wtSlackSurplusMap;
	}
	
	public static Map<String, EvalConstraint> getConstraintDataMap(){
		return constraintDataMap;
	}
	
	public static void clearConstraintDataMap(){
		constraintDataMap=new HashMap<String, EvalConstraint>();
	}

	public static Map<String, Dvar> getDvarMap(){
		return dvarMap;
	}

	public static void setDvarMap(Map<String, Dvar>dvMap){
		dvarMap=dvMap;
	}
}
