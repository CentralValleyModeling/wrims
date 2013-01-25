
package wrimsv2.tools.nonuniqueSolutionDetector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.apache.commons.io.FilenameUtils;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.solver.mpmodel.MPModelUtils;
import wrimsv2.solver.mpmodel.MPModel;
import wrimsv2.solver.ortools.OrToolsSolver;
import wrimsv2.wreslplus.elements.Tools;


public class Detector2 {

	public static final double inf = Double.POSITIVE_INFINITY;
	public static final double nonunique_min_diff = 0.1;     // minimum difference for reporting solution range
	public static final double vertax_tolerance = 0.001;  // tolerance for determining if a var is at vertex
	public static final double obj_constraint_tolerance_ratio = 0.00001; // relax constraint by this ratio to avoid solution infeasible 
	public static ArrayList<String> excludeStrings = null;
	public static ArrayList<String> includeStrings = null;
	public static ArrayList<String> varList = null;
	
	public static void main(String[] args) throws Exception {
		
		OrToolsSolver.initialize();

		//detect("examples\\example8\\run\\=ILP=\\example8.config\\mpmodel\\1921_10_c01.mpm");
		
		excludeStrings = new ArrayList<String>();
		excludeStrings.add("slack__");
		excludeStrings.add("surplus__");
		
		//detect("examples\\CL_SharingFix_Shortage_121212\\Run\\=ILP=\\Existing_BO_121212_CBC.config\\mpmodel\\\\1921_10_c01.mpm");
		detect("examples\\simple1\\run\\=ILP=\\simple1_cbc.config\\mpmodel\\1921_10_c01.mpm");		
		
	}

	
	public static ArrayList<String> findLowerVertaxVars_number(MPModel in) {
		
		ArrayList<String> out = new ArrayList<String>();
		
		for (String key: in.varMap_number.keySet()){
			
			if (in.solution.get(key) < in.varMap_number.get(key)[0] + vertax_tolerance) {
			
				out.add(key);
				
			}
			
		}
		
		return out;
		
	}
	
	public static int detect(String mpmPath) {
		
		int returnCode = 0;
		OrToolsSolver aSolver = new OrToolsSolver("CBC_MIXED_INTEGER_PROGRAMMING");
		aSolver.setVerbose(1);

		
		MPModel originalModel = null;
		String mpmodelDir = null;
		String mpmodelFileName = "";

		
		try {
			originalModel = MPModelUtils.load(mpmPath);
			
			File f = new File(mpmPath);
			mpmodelFileName = FilenameUtils.removeExtension(f.getName());
			mpmodelDir = new File(f.getParent()).getAbsolutePath();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// log original model
		MPModelUtils.toLpSolve(originalModel, mpmodelDir, mpmodelFileName+"_original.lps");
		// solve original model		
		System.out.println("solve original model...");
		returnCode = aSolver.solve(originalModel);
		if (returnCode!=0) {
			aSolver.delete();
			return returnCode;
		} else {
			System.out.println("solving success for original model!");
		}
		
		originalModel.solution = aSolver.solution;
		originalModel.objValue = aSolver.solver.objectiveValue();
		//System.out.println("Original:   "+originalModel.solution);			
		
		
		// base model
		MPModel baseModel = new MPModel(originalModel, "base");
		baseModel.createConstraint("OBJ_CONSTRAINT", originalModel.objFunction, originalModel.objValue*(1.0-obj_constraint_tolerance_ratio), Param.inf);

		MPModelUtils.toLpSolve(baseModel, mpmodelDir, mpmodelFileName+"_base.lps");
		
		System.out.println("solve base model...");
		returnCode =  aSolver.solve(baseModel);
		if (aSolver.solve(baseModel)!=0) {
			aSolver.delete();
			return returnCode;
		} else {
			System.out.println("solving success for base model!");
		}
		
		baseModel.solution = aSolver.solution;
		baseModel.objValue = aSolver.solver.objectiveValue();	
		//System.out.println("SearchBase: "+baseModel.solution);
		
		
		aSolver.delete();
		

		// find vars that equals it's own bound
		VarsGroup varsGroup = new VarsGroup(baseModel, vertax_tolerance);
		varsGroup.setVarsPool();
		varsGroup.filterVarsPool(includeStrings, excludeStrings);
		
		varsGroup.findVarsAtVertex();
		
		// TODO: find vars that equals it's own upper bound
		// TODO: find vars not at either bound
		
		
		// initialize var range using original and base solutions		
		
		ArrayList<String> all_vars_to_report = varsGroup.varsPool;
		ArrayList<String> all_vars_to_search = varsGroup.varsPool_integer;
		
		
		LinkedHashMap<String, Double> reportBaseSolution = new LinkedHashMap<String, Double>(baseModel.solution);
		Tools.mapRetainAll(reportBaseSolution, all_vars_to_report);
		
		LinkedHashMap<String, Double> reportOriginalSolution = new LinkedHashMap<String, Double>(originalModel.solution);
		Tools.mapRetainAll(reportOriginalSolution, all_vars_to_report);
		
		ArrayList<LinkedHashMap<String, Double>> group0Solutions = new ArrayList<LinkedHashMap<String,Double>>();
		group0Solutions.add(reportBaseSolution);
		group0Solutions.add(reportOriginalSolution);	
		
		LinkedHashMap<String, double[]> varRange_group0 = findVarsRange(group0Solutions);		
		
		
		
		// start to search
		

		
		System.out.println("all_vars_to_search:"+all_vars_to_search);
		// group 1 search
		
		int begin_indx = 0;
		int end_indx = Math.min(10, all_vars_to_search.size());
		int max_n_trials = 30;
		int coef_obj_search = -1;
		
		ArrayList<String> g1searchVars = new ArrayList<String>(all_vars_to_search.subList(begin_indx, end_indx));		
		AltSolutionFinder altFinder = new AltSolutionFinder("group1", baseModel, g1searchVars, coef_obj_search, all_vars_to_report, max_n_trials);
		altFinder.setLpsLoggingPath(mpmodelDir, mpmodelFileName);
		ArrayList<LinkedHashMap<String, Double>> group1Solutions = altFinder.go();
		
		// find solution ranges
		if (group1Solutions.size()==0) {
			System.out.println(" no alt solution found");
			System.exit(0);
		}
			
		LinkedHashMap<String, double[]> varRange_group1 = findVarsRange(group1Solutions);		
		
		
		
		
		
		// update ranges
		LinkedHashMap<String, double[]> varRange_all =  updateVarsRange(varRange_group0, varRange_group1);
		
		
		// report only vars that have big difference
		LinkedHashMap<String, double[]> varRange_all_filtered =  filterVarsRange_or(varRange_all, 0.5);
		
		
		// write report
		writeReport(varRange_all_filtered, mpmodelDir, mpmodelFileName);



		return returnCode;
		
	}

	private static void writeReport(LinkedHashMap<String, double[]> varRange, String dir, String fileName) {
		
		try {
			PrintWriter reportFile = Tools.openFile(dir, fileName+"_nonunique.csv");
			
			for (String varName: varRange.keySet()){
				
				double[] range = varRange.get(varName);
				
				// for excel view
				reportFile.println(varName+","+(float)range[0] + ","+(float)range[1]);
				
				reportFile.flush();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	private static LinkedHashMap<String, double[]> filterVarsRange_or(LinkedHashMap<String, double[]> varsRange, double min_abs_diff) {
		
		LinkedHashMap<String, double[]> out = new LinkedHashMap<String, double[]>();
		
		
		for (String varName: varsRange.keySet()){
			
			double lower = varsRange.get(varName)[0];
			double upper = varsRange.get(varName)[1];
			
			if ( (upper-lower)> min_abs_diff ) out.put(varName, new double[]{lower, upper});
			//if ( (upper!=0) && ( (upper-lower)/upper > min_abs_diff ) ) out.put(varName, new double[]{lower, upper});
			
		}
		
		return out;		
		
	}

	private static LinkedHashMap<String, double[]> findVarsRange(ArrayList<LinkedHashMap<String, Double>> allSearchSolutions) {
		
		
		// initialize		
		LinkedHashMap<String, Double> varUpper = new LinkedHashMap<String, Double>(allSearchSolutions.get(0));
		LinkedHashMap<String, Double> varLower = new LinkedHashMap<String, Double>(allSearchSolutions.get(0));
		
		
		for (LinkedHashMap<String, Double> sol : allSearchSolutions){
			
			for (String varName: sol.keySet()){
				if (sol.get(varName) > varUpper.get(varName) ) varUpper.put(varName, sol.get(varName)); 
				if (sol.get(varName) < varLower.get(varName) ) varLower.put(varName, sol.get(varName)); 
			}
		}
		
		

		LinkedHashMap<String, double[]> varRange = new LinkedHashMap<String, double[]>();
		
		for (String varName: allSearchSolutions.get(0).keySet()){
			
			double upper = varUpper.get(varName);
			double lower = varLower.get(varName);
			
			varRange.put(varName, new double[]{lower, upper});
			
		}
		
		return varRange;		
		
	}
	
	private static LinkedHashMap<String, double[]> updateVarsRange(LinkedHashMap<String, double[]> varsRange1, LinkedHashMap<String, double[]> varsRange2) {
		
		LinkedHashMap<String, double[]> out = new LinkedHashMap<String, double[]>(varsRange1);
		
		
		for (String key: varsRange1.keySet()){
			
			double upper = varsRange1.get(key)[1];
			double lower = varsRange1.get(key)[0];
			
			System.out.println("$$:"+key+":"+varsRange2.get(key)[0]);
			if (varsRange2.get(key)[0] < lower) lower = varsRange2.get(key)[0];
			if (varsRange2.get(key)[1] > upper) upper = varsRange2.get(key)[1];
			
			out.put(key, new double[]{lower, upper});
				
		}
		
		return out;		
		
	}
}
