package evaluators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Struct {


	  public Map<String, String>   model               = new HashMap<String, String>();
	  public Map<String, String>   sequence            = new HashMap<String, String>();  
	  public Map<String, String>   error_var_redefined = new HashMap<String, String> ();
	  public Map<String, String>   var_all             = new HashMap<String, String> ();
	  public Map<String, String>   svar_expression     = new HashMap<String, String>();
	  public Map<String, String>   goal_simple         = new HashMap<String, String>();
	      
	  public Map<String, ArrayList<String>>  dvar_nonstd = new HashMap<String, ArrayList<String>>();  
	  public Map<String, ArrayList<String>>  dvar_std    = new HashMap<String, ArrayList<String>>(); 
	  public Map<String, ArrayList<String>>  dvar_alias  = new HashMap<String, ArrayList<String>>();   

	  public Map<String, ArrayList<String>>  svar_table  = new HashMap<String, ArrayList<String>>(); 
	  public Map<String, ArrayList<String>>  svar_dss    = new HashMap<String, ArrayList<String>>(); 
	  public Map<String, ArrayList<String>>  svar_sum    = new HashMap<String, ArrayList<String>>(); 
	    
		/// svar_cases
		public    Map<String, ArrayList<String>>   svar_cases  = new HashMap<String,ArrayList<String>> (); 
		public    Map<String, ArrayList<String>>   svar_conditions  = new HashMap<String,ArrayList<String>> (); 
		public    Map<String, Map<String, ArrayList<String>>> svar_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();


		  private static String[] keys = {"define","goal"};
		  private static String[] mons = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		  public static List<String> r_keys = Arrays.asList(keys); 
		  public static List<String> r_mons = Arrays.asList(mons); 
		  public static List<String> reserved_words = new ArrayList<String>() {{ addAll(r_keys); addAll(r_mons); }}; 

}
