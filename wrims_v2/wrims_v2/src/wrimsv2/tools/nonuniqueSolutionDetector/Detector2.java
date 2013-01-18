
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
	public static final double delta = 0.001;
	public static final double vertax_tolerance = 0.001;
	public static final double obj_constraint_lower_bound_tolerance_ratio = 0.00001;
	
	public static void main(String[] args) throws Exception {
		
		OrToolsSolver.initialize();
		//detect("examples\\simple1\\run\\=ILP=\\simple1_cbc.config\\mpmodel\\1921_10_c01.mpm");
		//detect("examples\\example8\\run\\=ILP=\\example8.config\\mpmodel\\1921_10_c01.mpm");
		detect("examples\\CL_SharingFix_Shortage_121212\\Run\\=ILP=\\Existing_BO_121212_CBC.config\\mpmodel\\\\1921_10_c01.mpm");
		
		
	}

	
	private static ArrayList<LinkedHashMap<String, Double>> searchAltSolutions(MPModel inModel, ArrayList<String> lowerVertaxVars_number, ArrayList<String> lowerVertaxVars_integer, String mpmodelDir, String mpmodelFileName) {
		
		ArrayList<LinkedHashMap<String, Double>> solutions = new ArrayList<LinkedHashMap<String,Double>>();
		
		boolean hasNewSolution = true;
		int maxTry = 5;
		int i = 0;
		
		OrToolsSolver sSolver = new OrToolsSolver("CBC_MIXED_INTEGER_PROGRAMMING");
		sSolver.setModel(inModel);
		
		while (hasNewSolution && i<=maxTry && lowerVertaxVars_number.size()>0) {
			i++;
			System.out.println("# seach: "+i);
									
			LinkedHashMap<String, Double> searchObjFunc = new LinkedHashMap<String, Double>();

			System.out.println("lowerVertaxVars_number:  "+lowerVertaxVars_number);
			System.out.println("lowerVertaxVars_integer: "+lowerVertaxVars_integer);
			
			double searchObjOffset = createSearchObjFunc(searchObjFunc, lowerVertaxVars_number, lowerVertaxVars_integer, inModel);
			

			System.out.println("searchObjFunc: "+searchObjFunc);
			System.out.println("searchObjOffset: "+searchObjOffset);
			
			sSolver.refreshObjFunc(searchObjFunc);
			
			// log search model
			MPModelUtils.toLpSolve(sSolver.model, mpmodelDir, mpmodelFileName+"_search_"+i+".lps");

			// TODO: if solve fail then need to skip current obj function and continue to next search
			if (sSolver.solve()!=0) {
				System.out.println("# Error ... problem in alt solution search ...");
				//continue;
			}


			hasNewSolution = false;
			
			// TODO: tolerance to replace 0
			if (sSolver.solver.objectiveValue() > searchObjOffset) {
				
				// post new solution
				solutions.add(sSolver.solution);
				
				// update zeroSolutionVars
				ArrayList<String> varsHaveNewSolution = new ArrayList<String>();
				for (String key: lowerVertaxVars_number){
					
					// TODO: tolerance to replace lower bound
					if (sSolver.solution.get(key) > inModel.varMap_number.get(key)[0]) varsHaveNewSolution.add(key);
					
				}
				for (String key: lowerVertaxVars_integer){
					
					// TODO: tolerance to replace lower bound
					if (sSolver.solution.get(key) > inModel.varMap_integer.get(key)[0]) varsHaveNewSolution.add(key);
					
				}
				lowerVertaxVars_number.removeAll(varsHaveNewSolution);
				lowerVertaxVars_integer.removeAll(varsHaveNewSolution);
				
				hasNewSolution = true;
				
				System.out.println("New solution found? "+hasNewSolution);	
				System.out.println("vars have new solution: "+varsHaveNewSolution);
				
			} else {
				
				System.out.println("New solution found? "+hasNewSolution);	
			}
			
			
		}
		
		sSolver.delete();
		return solutions;
		
	}

	public static ArrayList<String> findLowerVertaxVars_integer(MPModel in) {
		
		ArrayList<String> out = new ArrayList<String>();
		
		for (String key: in.varMap_integer.keySet()){
			
			if (in.solution.get(key) < in.varMap_integer.get(key)[0] + vertax_tolerance) {
			
				out.add(key);
				
			}
			
		}
		
		return out;
		
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
	
	public static double createSearchObjFunc(LinkedHashMap<String, Double> out_searchObjFunc, ArrayList<String> vars1, ArrayList<String> vars2, MPModel in){


		double out_searchObjOffset = 0;
		
		for (String key: vars1){
			
			out_searchObjFunc.put(key, coef_searchObj);
			out_searchObjOffset = out_searchObjOffset + in.solution.get(key)*coef_searchObj;
			
		}
		for (String key: vars2){
			
			out_searchObjFunc.put(key, coef_searchObj);
			out_searchObjOffset = out_searchObjOffset + in.solution.get(key)*coef_searchObj;
			
		}		
		return out_searchObjOffset;
			
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
			System.out.println("solving success!");
		}
		
		originalModel.solution = aSolver.solution;
		originalModel.objValue = aSolver.solver.objectiveValue();
		
		
		
		// search base model
		MPModel baseModel = new MPModel(originalModel, "searchBase");
		baseModel.createConstraint("OBJ_CONSTRAINT", originalModel.objFunction, originalModel.objValue*(1.0-obj_constraint_lower_bound_tolerance_ratio), Param.inf);

		MPModelUtils.toLpSolve(baseModel, mpmodelDir, mpmodelFileName+"_searchBase.lps");
		
		System.out.println("solve base model...");
		returnCode =  aSolver.solve(baseModel);
		if (aSolver.solve(baseModel)!=0) {
			aSolver.delete();
			return returnCode;
		} else {
			System.out.println("solving success!");
		}
		
		baseModel.solution = aSolver.solution;
		baseModel.objValue = aSolver.solver.objectiveValue();	
		
		aSolver.delete();
		
		
		
		
		
		// find vars that equals it's own lower bound
		ArrayList<String> lowerVertaxVars_number_all = findLowerVertaxVars_number(baseModel);
		ArrayList<String> lowerVertaxVars_integer = findLowerVertaxVars_integer(baseModel);
		
		// TODO: find vars that equals it's own upper bound
		
		// TODO: find vars not at either bound
		
		ArrayList<String> lowerVertaxVars_number = new ArrayList<String>(lowerVertaxVars_number_all.subList(10, 50));
		
		
		ArrayList<LinkedHashMap<String, Double>> allSearchSolutions = searchAltSolutions(baseModel, lowerVertaxVars_number, lowerVertaxVars_integer, mpmodelDir, mpmodelFileName);
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
				
				reportFile.println(varName+" : {"+(float)range[0] + ", "+(float)range[1]+"}");
				
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
			
			if ( (upper-lower)> delta) varRange.put(varName, new double[]{lower, upper});
			
		}
		
		return varRange;		
		
	}

}
