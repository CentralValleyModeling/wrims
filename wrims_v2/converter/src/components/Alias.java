package components;

public class Alias {
	
	public String scope;
//	public String format;
	public String kind;
	public String units;
	public String expression;
	public String fromWresl;

//	public ArrayList<String> caseName;
//	public ArrayList<String> caseCondition;
//	public ArrayList<String> caseExpression;
	
	public Alias(){
		scope=Parameters.undefined;
//		format=Parameters.undefined;
		kind=Parameters.undefined;
		units=Parameters.undefined;
		expression=Parameters.undefined;
		fromWresl=Parameters.undefined;

//		caseName       = new ArrayList<String>();
//		caseCondition  = new ArrayList<String>();
//		caseExpression = new ArrayList<String>();
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
}
	
