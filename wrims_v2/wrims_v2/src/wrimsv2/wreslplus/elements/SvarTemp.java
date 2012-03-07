package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.evaluator.ValueEvaluatorTreeWalker;



public class SvarTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String fromWresl; // for test only
	public String id;
	public String kind;
	public String units;
	public String condition;
	//public String expression;
	public Set<String> dependants;
	
	//public Set<String> neededVarInCycleSet;
	//public boolean needVarFromEarlierCycle;

	
	public ArrayList<String> caseName;
	public ArrayList<String> caseCondition;
	public ArrayList<String> caseExpression;
		
	
	// default is 0
	public String timeArraySize;
	public String arraySize;	
	
	public SvarTemp(){
		

		kind=Param.undefined;
		units=Param.undefined;
		condition = Param.always;
		//expression=Param.undefined;
		dependants = new LinkedHashSet<String>();	
		
		timeArraySize="0";
		arraySize="0";
		
		caseName=new ArrayList<String>();
		caseCondition=new ArrayList<String>();
		caseExpression=new ArrayList<String>();
	}
	
}
	
