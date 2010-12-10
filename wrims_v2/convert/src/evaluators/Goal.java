package evaluators;

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
	
	public Goal(){
		scope="undefined";
		lhs="undefined";
		caseName       = new ArrayList<String>();
		caseCondition  = new ArrayList<String>();
		caseExpression = new ArrayList<String>();
	}
	
	public String equalEva(){
		
		String s = "|";
		String caseNameStr="";
		String caseConditionStr="";
		String caseExpressionStr="";
		
		for (String i: caseName){caseNameStr = caseNameStr + s + i;}
		for (String i: caseCondition){caseConditionStr = caseConditionStr + s + i;}
		for (String i: caseExpression){caseExpressionStr = caseExpressionStr + s + i;}		
		
		String temp = scope+s+lhs+s+caseNameStr+caseConditionStr+s+caseExpressionStr;
		
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
	
