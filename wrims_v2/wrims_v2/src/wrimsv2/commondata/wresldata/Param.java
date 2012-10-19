package wrimsv2.commondata.wresldata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// global parameters
public class Param {
	
	// solver selection
	  public static final Integer SOLVER_XA = 10;
	  public static final Integer SOLVER_LPSOLVE = 20;
	  public static final Integer SOLVER_CBC = 30;
	  public static final Integer SOLVER_GUROBI = 40;
	
	  public static boolean debug= false; 
	  public static final String dv_std_lowerBound= "0"; 
	  public static final String zero= "0"; 
	  public static final String dv_std_upperBound= "upper_unbounded"; 
	  public static final String lower_unbounded= "lower_unbounded"; 
	  public static final String upper_unbounded= "upper_unbounded"; 
	  public static final double lower_unbounded_double= -1e23; 
	  public static final double upper_unbounded_double= 1e23; 
	  public static final String dv_std_integer_lowerBound= "0"; 
	  public static final String dv_std_integer_upperBound= "1"; 
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
	  public static final String windows_pathseperator = "\\";
	  public static final String linux_pathseperator = "/";
	  public static final String wreslChekerName = "Wresl Checker ";
	  public static final String conditional = "conditional";
	  public static final String model_label = "__model__";
	  
	  public static final String legacywresl = "_legacywresl";
	  
	  public static final Integer incFileType = 1;
	  public static final Integer tsType = 2;
	  public static final Integer svType = 3;
	  public static final Integer dvType = 4;
	  public static final Integer asType = 5;
	  public static final Integer exType = 6;
	  public static final Integer gl1Type = 7;
	  public static final Integer gl2Type = 8;
	  public static final Integer incModelType = 9;

	  
	  public static int printLevel = 1;
	  
	  
	  public static final String global="global";
	  public static final String local="local";
	  
	  public static final double deviationSlackSurplusTolerance = 1E-5;
	  
	  public static Set<String> reservedSet = new HashSet<String>(Arrays.asList
				("month", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec",
				 "prevjan", "prevfeb", "prevmar", "prevapr", "prevmay", "prevjun", 
				 "prevjul", "prevaug", "prevsep", "prevoct", "prevnov", "prevdec",
				 "wateryear", "cfs_taf", "taf_cfs", "cfs_cfm", "af_cfs", "cfs_af", "daysin", "daysinmonth",
				 "i", "null", "pow", "exp", "log", "log10", "abs", "real","mod",
				 "day"
				 ));
	  
	  
}

