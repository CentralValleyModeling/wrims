package evaluators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SvarProps {
	
	public String scope;
	public String format;
	public String kind;
	public String units;
	public String expression;
	public String caseName;
	public String caseCondition;
	public String caseExpression;
	public Map<String,ArrayList<String>> caseContent = new HashMap<String,ArrayList<String>>();
	
	public SvarProps(){
		scope="";
		format="";
		kind="";
		units="";
		expression="";
	}
	
	public String equalEva(){
		
		String temp = "s:"+scope+format+kind+units+expression+caseName+caseCondition+caseExpression;
		return temp;
		
	}

	@Override
	public boolean equals(Object obj)
	{

	  if((obj == null) || (obj.getClass() != this.getClass()))
	  	{return false;}
	  
	  else if (this.equalEva() == ((SvarProps) obj).equalEva()){

	    return true;
	  }
	  
	  return false;
	}
}
	
