package evaluators;

public class Dvar {
	
	public String scope;
	public String format;
	public String kind;
	public String units;
	public String lowerBound;
	public String upperBound;
//	public ArrayList<String> caseName;
//	public ArrayList<String> caseCondition;
//	public ArrayList<String> caseExpression;
	
	public Dvar(){
		scope="undefined";
		format="undefined";
		kind="undefined";
		units="undefined";
		lowerBound="undefined";
		upperBound="undefined";
//		caseName       = new ArrayList<String>();
//		caseCondition  = new ArrayList<String>();
//		caseExpression = new ArrayList<String>();
	}
	
	public String equalEva(){
		
		String s = "|";
		String caseNameStr="";
		String caseConditionStr="";
		String caseExpressionStr="";
		
//		for (String i: caseName){caseNameStr = caseNameStr + s + i;}
//		for (String i: caseCondition){caseConditionStr = caseConditionStr + s + i;}
//		for (String i: caseExpression){caseExpressionStr = caseExpressionStr + s + i;}
		
		
		String temp = scope+s+format+s+kind+s+units+lowerBound+upperBound;
		              //+caseNameStr+caseConditionStr+s+caseExpressionStr;
		
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
}
	
