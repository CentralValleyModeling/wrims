package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.evaluator.ValueEvaluatorTreeWalker;


public class GoalTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String fromWresl; // for test only
	public String id;
	public String condition;
	public String lhs;
	
	public Set<String> dependants;

	public boolean hasCase;
	public boolean hasLhs;
	public ArrayList<String> caseName;
	public Map<String, GoalCase> caseMap;
	public ArrayList<String> caseCondition;
	public ArrayList<String> caseExpression;
	public ArrayList<String> slackList;
	public ArrayList<String> surplusList;
	
	public GoalTemp(){
		
		lhs=null;
		condition = Param.always;
		dependants = new LinkedHashSet<String>();
		caseName=new ArrayList<String>();
		caseMap=new LinkedHashMap<String, GoalCase>();
		caseCondition=new ArrayList<String>();
		caseExpression=new ArrayList<String>();
		slackList=new ArrayList<String>();
		surplusList=new ArrayList<String>();
	}
	
}
	
