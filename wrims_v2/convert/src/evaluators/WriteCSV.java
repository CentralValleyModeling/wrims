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
	  public static String svar_table_header ="NAME,SELECT,FROM,GIVEN,USE,WHERE,WHERE,WHERE";
	  public static String dvar_header ="INCLUDE,NAME,LAYER,TYPE,UNITS,LOWER_BOUND,UPPER_BOUND,FILTER";
	  
	public static void mapStringList(Object obj, String filters, PrintWriter out) {
			
		    @SuppressWarnings("unchecked")
		    Map<String, List<String>> mapStringList = (Map<String, List<String>>) obj;
		    
			List<String> keys = new ArrayList<String> (mapStringList.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    
		    for (String k: keys ){
		    	out.print("Y,"); //for INCLUDE flag	
		    	out.print(k);		
			
				for(String i : mapStringList.get(k)){
					out.print(","+i);
					}
				out.print(","+filters);
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
