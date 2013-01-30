
package wrimsv2.tools.nonuniqueSolutionDetector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.solver.mpmodel.MPModelUtils;
import wrimsv2.solver.mpmodel.MPModel;
import wrimsv2.solver.ortools.OrToolsSolver;
import wrimsv2.wreslplus.elements.Tools;


public class Detector {

	// constant
	public static final double inf = Double.POSITIVE_INFINITY;
	public static final int Detection_AltSolutionFound = 1;

	
	// required
	public static final double nonunique_min_abs_diff = 0.6;     // minimum difference for reporting solution range
	public static final double vertax_tolerance = 0.001;  // tolerance for determining if a var is at vertex
	public static final double obj_constraint_tolerance_ratio = 0.00001; // relax constraint by this ratio to avoid solution infeasible 
	public static int searchLevel = 2;  
	// 1: max for vars at lowerbound. need to scan all vars in solution to get better result. 
	// 2: max and min for vars at bound. default.  
	// 3: max and min for vars at or not at bound. best result.   

	// optional
	public static ArrayList<String> searchVarList = null;
	public static ArrayList<String> excludeStrings = null;
	public static ArrayList<String> includeStrings = null;
	public static boolean lpsLogging = true;
	
	public static void main(String[] args) throws Exception {
		
		OrToolsSolver.initialize();

		//detect("examples\\example8\\run\\=ILP=\\example8.config\\mpmodel\\1921_10_c01.mpm");
		
		
		
		
		excludeStrings = new ArrayList<String>();
		excludeStrings.add("slack__");
		excludeStrings.add("surplus__");
		
		String mpmPath = "examples\\CL_SharingFix_Shortage_121212\\Run\\=ILP=\\Existing_BO_121212_CBC.config\\mpmodel\\\\1921_10_c01.mpm";
		detect(mpmPath, searchVarList);
		
		//detect("examples\\simple1\\run\\=ILP=\\simple1_cbc.config\\mpmodel\\1921_10_c01.mpm");		

	}
	
	public static void detect(String mpmPath, ArrayList<String> searchVarList) {
		
		
		DetectorWorkflow dw = new DetectorWorkflow(mpmPath);
		
		boolean OK_original = dw.validateOriginalModel();
		boolean OK_base = dw.validateBaseModel();

		LinkedHashMap<String, double[]> varsRange = null;
		
		if (dw.findAltSolutions(searchVarList) == DetectorParam.altSolutionFound) {
			varsRange = dw.getVarsRange();
			String reportPath = FilenameUtils.removeExtension(mpmPath)+"_variable_range.csv";
			Misc.writeReport(varsRange, reportPath);
		}

		
	}

}
