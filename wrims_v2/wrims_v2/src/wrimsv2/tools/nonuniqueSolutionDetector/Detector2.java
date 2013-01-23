
package wrimsv2.tools.nonuniqueSolutionDetector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.apache.commons.io.FilenameUtils;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.solver.mpmodel.MPModelUtils;
import wrimsv2.solver.mpmodel.MPModel;
import wrimsv2.solver.ortools.OrToolsSolver;
import wrimsv2.wreslparser.elements.Tools;


public class Detector2 {

	public static final double coef_searchObj = 1.0;
	public static final double inf = Double.POSITIVE_INFINITY;
	public static final double nonunique_min_diff = 0.1;     // minimum difference for reporting solution range
	public static final double vertax_tolerance = 0.001;  // tolerance for determining if a var is at vertex
	public static final double obj_constraint_tolerance_ratio = 0.00001; // relax constraint by this ratio to avoid solution infeasible 
	public static ArrayList<String> notContainingString = null;
	public static ArrayList<String> onlyContainingString = null;
	public static ArrayList<String> varList = null;
	
	public static void main(String[] args) throws Exception {
		
		OrToolsSolver.initialize();
		//detect("examples\\simple1\\run\\=ILP=\\simple1_cbc.config\\mpmodel\\1921_10_c01.mpm");
		//detect("examples\\example8\\run\\=ILP=\\example8.config\\mpmodel\\1921_10_c01.mpm");
		
		notContainingString = new ArrayList<String>();
		notContainingString.add("slack__");
		notContainingString.add("surplus__");
		
		detect("examples\\CL_SharingFix_Shortage_121212\\Run\\=ILP=\\Existing_BO_121212_CBC.config\\mpmodel\\\\1921_10_c01.mpm");
		
		
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

//	public static double createSearchObjFunc(LinkedHashMap<String, Double> out_searchObjFunc, ArrayList<String> vars1, ArrayList<String> vars2, MPModel in){
//
//
//		double out_searchObjOffset = 0;
//		
//		for (String key: vars1){
//			
//			out_searchObjFunc.put(key, coef_searchObj);
//			out_searchObjOffset = out_searchObjOffset + in.solution.get(key)*coef_searchObj;
//			
//		}
//		for (String key: vars2){
//			
//			out_searchObjFunc.put(key, coef_searchObj);
//			out_searchObjOffset = out_searchObjOffset + in.solution.get(key)*coef_searchObj;
//			
//		}		
//		return out_searchObjOffset;
//			
//	}
	
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
		
		aSolver.delete();

		// find vars that equals it's own bound
		VarsGroup varsGroup = new VarsGroup(baseModel, vertax_tolerance);
		varsGroup.setVarsPool();
		varsGroup.findVarsAtVertex();
		
		// find vars that equals it's own lower bound
		//ArrayList<String> lowerVertaxVars_number_all = findLowerVertaxVars_number(baseModel);
		//ArrayList<String> lowerVertaxVars_integer = findLowerVertaxVars_integer(baseModel);
		
		// TODO: find vars that equals it's own upper bound
		
		// TODO: find vars not at either bound
		
		ArrayList<String> lowerVertaxVars_number = new ArrayList<String>(varsGroup.lowerVertexVars_number.subList(10, 50));
		
		
		AltSolutionFinder altFinder = new AltSolutionFinder("group1", baseModel, lowerVertaxVars_number, true, 30);
		altFinder.setLpsLoggingPath(mpmodelDir, mpmodelFileName);
		ArrayList<LinkedHashMap<String, Double>> allSearchSolutions = altFinder.go();
		
		
		allSearchSolutions.add(baseModel.solution);
		allSearchSolutions.add(originalModel.solution);
			
	
		// print all solutions
		
		System.out.println("Original:   "+originalModel.solution);	
		System.out.println("SearchBase: "+baseModel.solution);
		

		
		System.out.println("==== all solutions ====");
		for (LinkedHashMap<String,Double> solution: allSearchSolutions){
			
			System.out.println("solution:   "+solution);
			
		}
		
		// find solution ranges
		LinkedHashMap<String, double[]> varRange = findNonUniqueVars(allSearchSolutions);
		
		writeReport(varRange, mpmodelDir, mpmodelFileName);

		aSolver.delete();

		return returnCode;
		
	}

	private static void writeReport(LinkedHashMap<String, double[]> varRange, String dir, String fileName) {
		
		try {
			PrintWriter reportFile = Tools.openFile(dir, fileName+"_nonunique.txt");
			
			for (String varName: varRange.keySet()){
				
				double[] range = varRange.get(varName);
				
				// for excel view
				reportFile.println(varName+"\t"+(float)range[0] + "\t"+(float)range[1]);
				
				reportFile.flush();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	private static LinkedHashMap<String, double[]> findNonUniqueVars(ArrayList<LinkedHashMap<String, Double>> allSearchSolutions) {
		
		
		// initialize		
		LinkedHashMap<String, Double> varUpper = new LinkedHashMap<String, Double>(allSearchSolutions.get(0));
		LinkedHashMap<String, Double> varLower = new LinkedHashMap<String, Double>(allSearchSolutions.get(0));
		
		
		for (LinkedHashMap<String, Double> sol : allSearchSolutions){
			
			for (String varName: sol.keySet()){
				if (sol.get(varName) > varUpper.get(varName) ) varUpper.put(varName, sol.get(varName)); 
				if (sol.get(varName) < varLower.get(varName) ) varLower.put(varName, sol.get(varName)); 
			}
		}
		
		
		// return vars that has range greater than a specified delta
		LinkedHashMap<String, double[]> varRange = new LinkedHashMap<String, double[]>();
		
		for (String varName: allSearchSolutions.get(0).keySet()){
			
			double upper = varUpper.get(varName);
			double lower = varLower.get(varName);
			
			if ( (upper-lower)> nonunique_min_diff) varRange.put(varName, new double[]{lower, upper});
			
		}
		
		return varRange;		
		
	}

}
