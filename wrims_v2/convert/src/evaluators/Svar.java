package evaluators;

import java.util.ArrayList;

public class Svar {
	
	public String scope;
	public String format;
	public String kind;
	public String units;
	public ArrayList<String> caseName;
	public ArrayList<String> caseCondition;
	public ArrayList<String> caseExpression;
	
	public Svar(){
		scope="undefined";
		format="undefined";
		kind="undefined";
		units="undefined";
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
		
		
		String temp = scope+s+format+s+kind+s+units
		              +caseNameStr+caseConditionStr+s+caseExpressionStr;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((Svar) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((Svar) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
}
	
