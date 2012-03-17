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



public class AliasTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String fromWresl; // for test only
	public String id;
	public String kind;
	public String units;
	public String condition;
	public String expression;
	public Set<String> dependants;
	public boolean isMovedToDvar;
			
	
	public AliasTemp(){

		kind=Param.undefined;
		units=Param.undefined;
		condition = Param.always;
		expression=Param.undefined;
		dependants = new LinkedHashSet<String>();	
		isMovedToDvar = false;

	}
	
}
	
