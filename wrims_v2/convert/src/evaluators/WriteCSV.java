package evaluators;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

public class WriteCSV {
	  
	  //static Map<String, List<String>> mapStringList = new HashMap<String, List<String>>();
	  //private static PrintWriter out;
	 
	  public static String svar_dss_header ="NAME,KIND,UNIT";	  
	  public static String svar_header ="NAME,TYPE,UNITS,OUTPUT,CASE,ORDER,CONDITION,EXPRESSION,FROM_WRESL_FILE";
	  public static String dvar_header ="NAME,TYPE,UNITS,LOWER_BOUND,UPPER_BOUND,FROM_WRESL_FILE";	  
	  public static String alias_header ="NAME,TYPE,UNITS,OUTPUT,EXPRESSION,FROM_WRESL_FILE";

	  public static void svar(Map<String,Svar> sMap, String filePath, PrintWriter out) {
		    
			List<String> keys = new ArrayList<String> (sMap.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    //List<SvarProps> svarPropsList;
			
		    for (String k: keys ){
		    	
		    	//out.print(k);
		    	Svar s = sMap.get(k);
		    	
		    	for (int i=0; i<s.caseCondition.size(); i++)

		    	//	SvarProps p =sMap.get(k);
		    	{
			    	int caseOrder = i+1;
			    out.print(k); // for SVAR NAME
		    	//out.print(","+p.scope);  // for SCOPE
		    	//out.print(",Y"); //for INCLUDE
		    	//out.print(","+p.format); //for FORMAT
		    	out.print(","+s.kind); //for KIND		    	
		    	out.print(","+s.units); //for UNITS
		    	out.print(",Y"); //for OUTPUT
		    	out.print(","+s.caseName.get(i)); //for CASE 
		    	out.print(","+caseOrder); //for CASE 
		    	out.print(","+s.caseCondition.get(i)); //for CONDITION
		    	out.print(","+s.caseExpression.get(i)); //for EXPRESSION
		    	

				out.print(","+filePath);
				out.print("\n");	
		    	}
			}
	  };	  

	public static void dvar(Map<String,Dvar> dMap, String filePath, PrintWriter out) {
		    
			List<String> keys = new ArrayList<String> (dMap.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
			
		    for (String k: keys ){
		    	
		    	Dvar d = dMap.get(k);		    	

			    out.print(k); // for DVAR NAME

		    	out.print(","+d.kind); //for KIND		    	
		    	out.print(","+d.units); //for UNITS
		    	out.print(","+d.lowerBound); //for UNITS
		    	out.print(","+d.upperBound); //for UNITS

				out.print(","+filePath);
				out.print("\n");	
		    	}
	  };

	public static void alias(Map<String,Alias> asMap, String filePath, PrintWriter out) {
		    
			List<String> keys = new ArrayList<String> (asMap.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
			
		    for (String k: keys ){
		    	
		    	Alias a = asMap.get(k);		    	

			    out.print(k); // for DVAR NAME

		    	out.print(","+a.kind); //for KIND		    	
		    	out.print(","+a.units); //for UNITS
		    	out.print(",Y"); //for OUTPUT
		    	out.print(","+a.expression); //for expression

				out.print(","+filePath);
				out.print("\n");	
		    	}
	  };		  
	  
	public static void obsolete(Object obj, Map<String,String> scope, String filePath, PrintWriter out) {
			
		    @SuppressWarnings("unchecked")
		    Map<String, List<String>> mapStringList = (Map<String, List<String>>) obj;
		    
			List<String> keys = new ArrayList<String> (mapStringList.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    
		    for (String k: keys ){
		    	out.print(k);
		    	out.print(","+scope.get(k));  // for SCOPE
		    	out.print(",Y"); //for INCLUDE
		    	out.print(", "); //for TYPE
		    	out.print(", "); //for UNITS
		    	out.print(", "); //for CASE
		    	out.print(", "); //for CONDITION
		    	
				for(String i : mapStringList.get(k)){
					out.print(","+i);
					}
				out.print(","+filePath);
				out.print("\n");	
			}
	  };
	  
  
	  
		public static void mapStringListMerged(Object obj, PrintWriter out) {
			
		    @SuppressWarnings("unchecked")
		    List<Map<String, List<String>>> listMapStringList = (List<Map<String, List<String>>>) obj;
		    Map<String, List<String>> mapAll = new HashMap<String, List<String>>();		    
		    
			ArrayList<String> keys = new ArrayList<String>(); 
			
			for (Map<String, List<String>> m : listMapStringList){
				
				mapAll.putAll(m);
			}

			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    
		    for (String k: keys ){
		    	out.print(k);		
			
				for(String i : mapAll.get(k)){
					out.print(","+i);}
				out.print("\n");	
			}
	  };	  
	  

}
