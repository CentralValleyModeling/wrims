package wrimsv2.commondata.wresldata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.ValueEvaluatorParser;


public class Dvar {
	
	public String scope;
	public String integer;
	public String format;
	public String kind;
	public String units;
	public String lowerBound;
	public ValueEvaluatorParser lowerBoundParser;
	public String upperBound;
	public ValueEvaluatorParser upperBoundParser;
	public String fromWresl;
	public IntDouble data;
	public Number upperBoundValue;
	public Number lowerBoundValue;
	public String expression;
	public Set<String> dependants;
	
	public Dvar(){
		scope=Param.undefined;
		integer=Param.no;
		format=Param.undefined;
		kind=Param.undefined;
		units=Param.undefined;
		lowerBound=Param.undefined;
		upperBound=Param.undefined;
		fromWresl=Param.undefined;
		expression=Param.undefined;
		dependants = new HashSet<String>();

		lowerBoundParser = null;
		upperBoundParser = null;
		data = new IntDouble();
		upperBoundValue = null;
		lowerBoundValue = null;
	}
	
	public String equalEva(){
		
		String s = "|";
		String temp = scope+s+integer+s+format+s+kind+s+units+lowerBound+upperBound;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((Dvar) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((Dvar) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
	
	public void setData(IntDouble data){
		this.data= new IntDouble(data);
	}
	
	public IntDouble getData(){
		return data;
	}
}
	
