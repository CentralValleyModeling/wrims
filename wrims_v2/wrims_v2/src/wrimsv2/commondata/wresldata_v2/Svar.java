package wrimsv2.commondata.wresldata_v2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.evaluator.ValueEvaluatorTreeWalker;


public class Svar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String scope;
	public String dssBPart;
	public String format;
	public String kind;
	public String units;
	public String convertToUnits;
	public ArrayList<String> caseName;
	public ArrayList<String> caseCondition;
	public ArrayList<ValueEvaluatorParser> caseConditionParsers;
	public ArrayList<ValueEvaluatorTreeWalker> caseConditionWalkers;
	public ArrayList<String> caseExpression;
	public ArrayList<ValueEvaluatorParser> caseExpressionParsers;
	public ArrayList<ValueEvaluatorTreeWalker> caseExpressionWalkers;
	public String fromWresl;
	private IntDouble data;
	public Set<String> dependants;
	public Set<String> neededVarInCycleSet;
	public boolean needVarFromEarlierCycle;
	
	public Svar(){
		scope=Param.undefined;
		dssBPart=Param.undefined;
		format=Param.undefined;
		kind=Param.undefined;
		units=Param.undefined;
		convertToUnits =Param.undefined;
		caseName       = new ArrayList<String>();
		caseCondition  = new ArrayList<String>();
		caseConditionParsers = new ArrayList<ValueEvaluatorParser>();
		caseConditionWalkers = new ArrayList<ValueEvaluatorTreeWalker>();
		caseExpression = new ArrayList<String>();
		caseExpressionParsers = new ArrayList<ValueEvaluatorParser>();
		caseExpressionWalkers = new ArrayList<ValueEvaluatorTreeWalker>();
		fromWresl = Param.undefined;
		dependants = new HashSet<String>();
		data = null;
		neededVarInCycleSet = new HashSet<String>();
		needVarFromEarlierCycle = false;
	}

	public Svar(Svar s){
		scope=s.scope;
		dssBPart=s.dssBPart;
		format=s.format;
		kind=s.kind;
		units=s.units;
		convertToUnits =s.convertToUnits;
		caseName       = new ArrayList<String>(s.caseName);
		caseCondition  = new ArrayList<String>(s.caseCondition);
		caseExpression = new ArrayList<String>(s.caseExpression);
		fromWresl = s.fromWresl;
		dependants = new HashSet<String>(s.dependants);
		neededVarInCycleSet = new HashSet<String>(s.neededVarInCycleSet);
		needVarFromEarlierCycle = s.needVarFromEarlierCycle;
		// TODO: check if cause error
		//data = new IntDouble(s.data.getData(),s.data.isInt()); 
	}	
	
	public void setData(IntDouble data){
		this.data=data;
	}
	
	public IntDouble getData(){
		return data;
	}
}
	
