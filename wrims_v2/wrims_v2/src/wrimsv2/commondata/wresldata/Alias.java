package wrimsv2.commondata.wresldata;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.ValueEvaluatorParser;


public class Alias extends Var implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String scope;
	public String kind;
	public String units;
	public String expression;
	public ValueEvaluatorParser expressionParser;
	public String fromWresl;
	public IntDouble data;
	public Set<String> dependants;
	public Set<String> neededVarInCycleSet;
	public boolean needVarFromEarlierCycle;

	public Alias(){
		scope=Param.undefined;
		kind=Param.undefined;
		units=Param.undefined;
		expression=Param.undefined;
		fromWresl=Param.undefined;
		dependants = new HashSet<String>();
		expressionParser = null;
		data = null;
		neededVarInCycleSet = new HashSet<String>();
		needVarFromEarlierCycle = false;
	}
	
	public String equalEva(){
		
		String s = "|";		
		String temp = scope+s+kind+s+units+s+expression;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((Alias) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((Alias) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
	
	public void setData(IntDouble data){
		this.data=data;
	}
	
	public IntDouble getData(){
		return data;
	}
}
	
