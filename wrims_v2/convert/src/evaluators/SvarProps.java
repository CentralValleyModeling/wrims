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
	public ArrayList<String> caseName = new ArrayList<String>();
	public ArrayList<String> caseCondition = new ArrayList<String>();
	public Map<String,ArrayList<String>> caseContent = new HashMap<String,ArrayList<String>>();
	
	public SvarProps(){
		scope="";
		format="";
		kind="";
		units="";
		expression="";
	}
}
	
