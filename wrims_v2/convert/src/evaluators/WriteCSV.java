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
	  public static String svar_header ="NAME,SCOPE,INCLUDE,FORMAT,KIND,UNITS,CASE,CONDITION,EXPRESSION,FROM_WRESL_FILE,COMMENT,";
	  public static String dvar_header ="NAME,SCOPE,INCLUDE,KIND,UNITS,LOWER_BOUND,UPPER_BOUND,FROM_WRESL_FILE,COMMENT,";
	  
	public static void svar(Map<String,SvarProps> sMap, String filePath, PrintWriter out) {
		    
			List<String> keys = new ArrayList<String> (sMap.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    
		    for (String k: keys ){
		    	out.print(k);
		    	
		    	SvarProps p = sMap.get(k);
		    	
		    	out.print(","+p.scope);  // for SCOPE
		    	out.print(",Y"); //for INCLUDE
		    	out.print(","+p.format); //for TYPE
		    	out.print(","+p.kind); //for KIND		    	
		    	out.print(","+p.units); //for UNITS
		    	out.print(", "); //for CASE
		    	out.print(", "); //for CONDITION
		    	out.print(","+p.expression); //for EXPRESSION
		    	

				out.print(","+filePath);
				out.print("\n");	
			}
	  };

//	public static void svarCase(Map<String,SvarProps> sMap, String filePath, PrintWriter out) {
//		    
//			List<String> keys = new ArrayList<String> (sMap.keySet());
//			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
//		    
//		    for (String k: keys ){
//		    	out.print(k);
//		    	
//		    	SvarProps p = sMap.get(k);
//		    	
//		    	for (int i = ){
//		
//		    	
//		    	out.print(","+p.scope);  // for SCOPE
//		    	out.print(",Y"); //for INCLUDE
//		    	out.print(","+p.format); //for TYPE
//		    	out.print(","+p.kind); //for KIND		    	
//		    	out.print(","+p.units); //for UNITS
//		    	out.print(","+c); //for CASE
//		    	out.print(","+); //for CONDITION
//		    	out.print(","+p.expression); //for EXPRESSION
//		    	
//
//				out.print(","+filePath);
//				out.print("\n");
//		    	}
//			}
//	  };	  
	  
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
	  
	  public static void dvar(Object obj, Map<String,String> scope, String filePath, PrintWriter out) {
			
		    @SuppressWarnings("unchecked")
		    Map<String, List<String>> mapStringList = (Map<String, List<String>>) obj;
		    
			List<String> keys = new ArrayList<String> (mapStringList.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    
		    for (String k: keys ){
		    	out.print(k);
		    	out.print(","+scope.get(k)); //SCOPE
		    	out.print(",Y"); //for INCLUDE flag	
			
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
