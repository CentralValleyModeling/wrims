
package wrimsv2.tools.nonuniqueSolutionDetector;

import java.util.ArrayList;


public class DetectorParam {

	// constant
	public static final int altSolutionFound = 1;
	public static final int altSolutionNotFound = 0;	
	public static final int modelNotValid = -1;
	public static final int otherErrors = -2;

	/// user input
	// required
	public static final double nonunique_min_abs_diff = 0.6;     // minimum difference for reporting solution range
	public static final double vertax_tolerance = 0.001;  // tolerance for determining if a var is at vertex
	public static final double obj_constraint_relax_ratio = 0.00001; // relax constraint by this ratio to avoid solution infeasible 
	
	public static int searchLevel = 2;  
	// 1: max for vars at lowerbound. need to scan all vars in solution to get better result. 
	// 2: max and min for vars at bound. default.  
	// 3: max and min for vars at or not at bound. best result.   
	
	
	// optional
	public static ArrayList<String> searchVarList = null;
	public static ArrayList<String> excludeStrings = null;
	public static ArrayList<String> includeStrings = null;
	
	public static boolean lpsLogging = false;
	public static String lpsDir = "";
	public static String lpsFileNamePrepend = "";
	
	
}
