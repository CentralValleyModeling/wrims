package wrimsv2.commondata.solverdata;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.commondata.wresldata.Dvar;

public class SolverData {
	private static Map<String, EvalConstraint> constraintDataMap=new HashMap<String, EvalConstraint>();
	private static Map<String, Dvar> dvarMap= new HashMap<String, Dvar>();
	private static ArrayList<EvalExpression> softConstraintExpression =new ArrayList<EvalExpression> ();
	private static ArrayList<Number> softConstraintWeight=new ArrayList<Number> ();

	public static Map<String, EvalConstraint> getConstraintDataMap(){
		return constraintDataMap;
	}

	public static Map<String, Dvar> getDvarMap(){
		return dvarMap;
	}

	public static void setDvarMap(Map<String, Dvar>dvMap){
		dvarMap=dvMap;
	}

	public static ArrayList<EvalExpression> getSoftConstraintExpression(){
		return softConstraintExpression;
	}

	public static ArrayList<Number> getSoftConstraintWeight(){
		return softConstraintWeight;
	}
}
