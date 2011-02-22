package components;

import java.util.ArrayList;

public class Goal {
	
	public String scope;
	//public String format;
	//public String kind;
	//public String units;
	public String lhs;
	public ArrayList<String> caseName;
	public ArrayList<String> caseCondition;
	public ArrayList<String> caseExpression;
	public ArrayList<String> case_lhs_gt_rhs;
	public ArrayList<String> case_lhs_lt_rhs;
	public String fromWresl;
	
	public Goal(){
		scope=Parameters.undefined;
		lhs=Parameters.undefined;
		caseName       = new ArrayList<String>();
		caseCondition  = new ArrayList<String>();
		caseExpression = new ArrayList<String>();
		case_lhs_gt_rhs = new ArrayList<String>();
		case_lhs_lt_rhs = new ArrayList<String>();
		fromWresl = Parameters.undefined;
	}
	
	public String equalEva(){
		
		String s = "|";
		String caseNameStr="";
		String caseConditionStr="";
		String caseExpressionStr="";
		String case_lhs_gt_rhs_str="";
		String case_lhs_lt_rhs_str="";
		
		for (String i: caseName){caseNameStr = caseNameStr + s + i;}
		for (String i: caseCondition){caseConditionStr = caseConditionStr + s + i;}
		for (String i: caseExpression){caseExpressionStr = caseExpressionStr + s + i;}	
		for (String i: case_lhs_gt_rhs){case_lhs_gt_rhs_str = case_lhs_gt_rhs_str + s + i;}	
		for (String i: case_lhs_lt_rhs){case_lhs_lt_rhs_str = case_lhs_lt_rhs_str + s + i;}	
		
		String temp = scope+s+lhs+s+caseNameStr+caseConditionStr+s+caseExpressionStr+s+case_lhs_gt_rhs_str+s+case_lhs_lt_rhs_str;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((Goal) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((Goal) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
}
	
