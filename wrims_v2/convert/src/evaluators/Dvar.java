package evaluators;

public class Dvar {
	
	public String scope;
	public String integer;
	public String format;
	public String kind;
	public String units;
	public String lowerBound;
	public String upperBound;
	public String fromWresl;
//	public ArrayList<String> caseName;
//	public ArrayList<String> caseCondition;
//	public ArrayList<String> caseExpression;
	
	public Dvar(){
		scope=Parameters.undefined;
		integer="N";
		format=Parameters.undefined;
		kind=Parameters.undefined;
		units=Parameters.undefined;
		lowerBound=Parameters.undefined;
		upperBound=Parameters.undefined;
		fromWresl=Parameters.undefined;
//		caseName       = new ArrayList<String>();
//		caseCondition  = new ArrayList<String>();
//		caseExpression = new ArrayList<String>();
	}
	
	public String equalEva(){
		
		String s = "|";
		String temp = scope+s+integer+s+format+s+kind+s+units+lowerBound+upperBound;
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
	
