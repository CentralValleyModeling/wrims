package wrimsv2.commondata.wresldata;

import java.util.ArrayList;


public class Svar {
	
	public String scope;
	public String dssBPart;
	public String format;
	public String kind;
	public String units;
	public String convertToUnits;
	public ArrayList<String> caseName;
	public ArrayList<String> caseCondition;
	public ArrayList<String> caseExpression;
	public String fromWresl;
	private Number value; 
	
	public Svar(){
		scope=Parameters.undefined;
		dssBPart=Parameters.undefined;
		format=Parameters.undefined;
		kind=Parameters.undefined;
		units=Parameters.undefined;
		convertToUnits =Parameters.undefined;
		caseName       = new ArrayList<String>();
		caseCondition  = new ArrayList<String>();
		caseExpression = new ArrayList<String>();
		fromWresl = Parameters.undefined;
	}
	
	public String equalEva(){
		
		String s = "|";
		String caseNameStr="";
		String caseConditionStr="";
		String caseExpressionStr="";
		
		for (String i: caseName){caseNameStr = caseNameStr + s + i;}
		for (String i: caseCondition){caseConditionStr = caseConditionStr + s + i;}
		for (String i: caseExpression){caseExpressionStr = caseExpressionStr + s + i;}
		
		
		String temp = scope+s+dssBPart+format+s+kind+s+units+s+convertToUnits+s+
		              caseNameStr+caseConditionStr+s+caseExpressionStr;
		
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
	
	public void setValue(Number value){
		this.value=value;
	}
	
	public Number getValue(){
		return value;
	}
}
	
