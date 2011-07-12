package wrimsv2.commondata.wresldata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// global parameters
public class Param {
	  public static boolean debug= false; 
	  public static final String dv_std_lowerBound= "0"; 
	  public static final String dv_std_upperBound= "upper_unbounded"; 
	  public static final String lower_unbounded= "lower_unbounded"; 
	  public static final String upper_unbounded= "upper_unbounded"; 
	  public static final String integer_lowerBound= "0"; 
	  public static final String integer_upperBound= "upper_unbounded"; 
	  public static final String undefined= "undefined"; 
	  public static final String defaultCaseName = "default";
	  public static final String always = "always";
	  public static final String constrain = "constrain";
	  public static final String skip = "#";
	  public static final String no =  "n";
	  public static final String yes = "y";	  
	  public static final String arg_seperator = ",";
	  public static final String new_seperator = ";";
	  public static final String csv_seperator = ",";


	  public static int printLevel = 1;
	  
	  
	  public static final String global="global";
	  public static final String local="local";
	  
	  public static Set<String> reservedSet = new HashSet<String>(Arrays.asList
				("month", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec",
				 "prevjan", "prevfeb", "prevmar", "prevapr", "prevmay", "prevjun", 
				 "prevjul", "prevaug", "prevsep", "prevoct", "prevnov", "prevdec",
				 "wateryear", "cfs_taf", "taf_cfs", "cfs_cfm", "af_cfs", "daysin", "daysinmonth",
				 "i", "null", "pow", "log10", "abs"   ));
	  
	  
}

