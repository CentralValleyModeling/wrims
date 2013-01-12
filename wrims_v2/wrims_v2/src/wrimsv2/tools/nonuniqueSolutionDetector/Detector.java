
package wrimsv2.tools.nonuniqueSolutionDetector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import wrimsv2.solver.ortools.OrToolsSolver;
import wrimsv2.solver.MPModel;


public class Detector {

	public static final double coef_searchObj = 1.0;
	public static final double inf = Double.POSITIVE_INFINITY;
	
	public static void main(String[] args) throws Exception {
		
		
		//simple();
		MPModel m = loadModel("examples\\nonuniqueSolutionDetector\\test_01\\test_01.mpm");
		detect(m);
		//trans();
		
		OrToolsSolver.delete();
	}

	public static void trans() {
		
		OrToolsSolver.initialize("CBC_MIXED_INTEGER_PROGRAMMING");
		OrToolsSolver.setVerbose(2);
		
		MPModel originalModel = createModel("testOriginalModel");	
		
		// solve original model
		OrToolsSolver.solve(originalModel);
//		
//		originalModel.solution = CbcSolver.solution;
//		originalModel.objValue = CbcSolver.solver.objectiveValue();
	
		
		MPModel tModel =  TransformModel.transform(originalModel);

		
		for (String k: originalModel.varMap_number.keySet()) {
			
			System.out.println(k+"="+originalModel.varMap_number.get(k)[0]+";"+originalModel.varMap_number.get(k)[1]);
		}
		
		System.out.println("================================");
		
		for (String k: tModel.varMap_number.keySet()) {
			
			System.out.println(k+"="+tModel.varMap_number.get(k)[0]+";"+tModel.varMap_number.get(k)[1]);
		}
		

		System.out.println(tModel.tvarEquationMap);
		System.out.println(tModel.tvarOffsetMap);

		OrToolsSolver.solve(tModel);
		tModel.solution = OrToolsSolver.solution;
		tModel.objValue = OrToolsSolver.solver.objectiveValue();
		
		System.out.println("================================");

		LinkedHashMap<String, Double> restored_solution = TransformModel.restoreSolution(tModel.solution, tModel.tvarOffsetMap, tModel.tvarEquationMap);

		double restored_obj_value = TransformModel.restoreObjValue(originalModel.objFunction, restored_solution);

		System.out.println("restored obj value = "+restored_obj_value);
		
		System.out.println("restored_solution");
		
		SortedSet<String> keys = new TreeSet<String>(restored_solution.keySet());
		for (String k: keys){
			System.out.println(k+"="+restored_solution.get(k));
		}
	}
	
	private static ArrayList<LinkedHashMap<String, Double>> searchAltSolutions_quick(MPModel inModel, LinkedHashSet<String> zeroSolutionVars) {
		
		ArrayList<LinkedHashMap<String, Double>> solutions = new ArrayList<LinkedHashMap<String,Double>>();
		
		boolean hasNewSolution = true;
		int maxTry = 5;
		int i = 0;
		
		OrToolsSolver.setModel(inModel);
		
		while (hasNewSolution && i<=maxTry && zeroSolutionVars.size()>0) {
			i++;
			System.out.println("# seach: "+i);
									
			LinkedHashMap<String, Double> objFunc1 = createSearchObjFunc(zeroSolutionVars);
			
			OrToolsSolver.refreshObjFunc(objFunc1);

			OrToolsSolver.solve();

			hasNewSolution = false;
			
			// TODO: tolerance to replace 0
			if (OrToolsSolver.solver.objectiveValue() > 0) {
				
				// post new solution
				solutions.add(OrToolsSolver.solution);
				
				// update zeroSolutionVars
				ArrayList<String> nonZeroVars = new ArrayList<String>();
				for (String key: zeroSolutionVars){
					
					// TODO: tolerance to replace 0
					if (OrToolsSolver.solution.get(key)>0) nonZeroVars.add(key);
					
				}
				zeroSolutionVars.removeAll(nonZeroVars);

				hasNewSolution = true;
				
			}
			
			//System.out.println("# hasNewSolution? "+hasNewSolution);	
		}
		
		return solutions;
		
	}


	
	public static LinkedHashSet<String> findZeroSolutionVars(Map<String, Double> solution) {
	
		LinkedHashSet<String> out = new LinkedHashSet<String>();
		
		for (String key: solution.keySet()){
			
			if (solution.get(key)==0) {
			
				out.add(key);
				
			}
			
		}
		
		return out;
		
	}

	public static MPModel createSearchModel(MPModel in) {
		
		MPModel base = new MPModel(in, "seachModel");

		System.out.println("# seach lp problem");
		
		base.createConstraint("OBJ_CONSTRAINT", in.objFunction, in.objValue, in.objValue);
		
		return base;
	}
	

	
	public static LinkedHashMap<String, Double> createSearchObjFunc(LinkedHashSet<String> vars){

		LinkedHashMap<String, Double> searchObj = new LinkedHashMap<String, Double>();
		
		for (String key: vars){
			
			searchObj.put(key, coef_searchObj);
			
		}
		
		
		return searchObj;		
	}

//	private static void createModel(StudyDataSet sd) {
//		
//		System.out.println("# original lp problem -- from StudyDataSet ");
//		
//		MPModel m = new MPModel("base");
//		double inf = m.inf;
//		
//		
//		
//		model = m;
//
//	}
	
	private static MPModel createModel(String modelName) {
		
		System.out.println("# original lp problem -- test");
		
		MPModel m = new MPModel(modelName);

		
		m.addStdVar("x0");
		//m.addGeneralVar("x0", -inf, 37);
		m.addStdVar("x1");
		m.addStdVar("x2");
		m.addGeneralVar("x3", -50.0, 60.0);
		
	
		// Maximize 2 * x0 + 2 * x1	
		LinkedHashMap<String, Double> objFunc = new LinkedHashMap<String, Double>();
		
		objFunc.put("x0", 3.);
		objFunc.put("x1", 3.);
		objFunc.put("x2", 3.);
		objFunc.put("x3", 3.);
		
		m.objFunction = objFunc;
		
		
		
		// x0 + x1 + x2 + x3 <= 100.
		
		double cRhs_lb = -inf;
		double cRhs_ub = 100;
		LinkedHashMap<String, Double> cLhs = new LinkedHashMap<String, Double>();
		
		cLhs.put("x0", 1.);
		cLhs.put("x1", 1.);
		cLhs.put("x2", 1.);
		cLhs.put("x3", 1.);
		
		m.createConstraint("c0", cLhs, cRhs_lb, cRhs_ub);
				
		
		return m;
	
	}

	public static void simple() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		OrToolsSolver.initialize("CBC_MIXED_INTEGER_PROGRAMMING");
		OrToolsSolver.setVerbose(2);
		
		MPModel originalModel = createSimpleModel("testOriginalModel");	
		
		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
//		        "java2sObject.dat"));
//		    oos.writeObject(new int[] { 2, 3, 5, 7, 11 });
//		    oos.close();
//		    
//		    
//		    //Read objects or arrays from binary file "o.dat":
//		    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
//		        "java2sObject.dat"));
//		    int[] ia = (int[]) (ois.readObject());
//		    System.out.println(ia[0] + "," + ia[1] + "," + ia[2] + "," + ia[3]
//		        + "," + ia[4]);
		    
		    
			ObjectOutputStream mos = new ObjectOutputStream(new FileOutputStream("mpmodel.dat"));
			    mos.writeObject(originalModel);
			    mos.close();
			    
			    
			    //Read objects or arrays from binary file "o.dat":
			    ObjectInputStream mis = new ObjectInputStream(new FileInputStream("from.mpm"));
			    MPModel ia = (MPModel) (mis.readObject());   
		
		// solve original model
		OrToolsSolver.solve(ia);
		
		ia.solution = OrToolsSolver.solution;
		ia.objValue = OrToolsSolver.solver.objectiveValue();
	
		
	
		// print all solutions
		
		System.out.println("Original:   "+ia.solution);
	
	}

	private static MPModel createSimpleModel(String modelName) {
		
		System.out.println("# Test simple lp problem");
		
		MPModel m = new MPModel(modelName);
	
		
		m.addStdVar("x0");
		m.addStdVar("x1");
		m.addStdVar("x2");
		m.addGeneralVar("x3", -50.0, 60.0);
		m.addGeneralVar("ggg1", 2.0, 9.0);
		m.addGeneralVar("ggg2", 2.0, 9.0);
		
	
		// Maximize 2 * x0 + 2 * x1	
		LinkedHashMap<String, Double> objFunc = new LinkedHashMap<String, Double>();
		
		objFunc.put("x0", 3.);
		objFunc.put("x1", 3.);
	    objFunc.put("x2", 3.);
		objFunc.put("x3", 3.);
		objFunc.put("ggg1", 3.);
		objFunc.put("ggg2", 3.);
		
		m.objFunction = objFunc;
		
		
		
		// x0 + x1 + x2 + x3 <= 100.
		
		double cRhs_lb = -inf;
		double cRhs_ub = 100;
		LinkedHashMap<String, Double> cLhs = new LinkedHashMap<String, Double>();
		
		cLhs.put("x0", 1.);
		cLhs.put("x1", 1.);
		cLhs.put("x2", 1.);
		cLhs.put("x3", 1.);
		cLhs.put("ggg1", 1.);
		cLhs.put("ggg2", 1.);
		
		m.createConstraint("c0", cLhs, cRhs_lb, cRhs_ub);
				
		
		return m;
	
	}

	public static void detect() {
		
		MPModel originalModel = createSimpleModel("testOriginalModel");	
		detect(originalModel);

	}

	public static void detect(MPModel originalModel) {
		
		OrToolsSolver.initialize("CBC_MIXED_INTEGER_PROGRAMMING");
		OrToolsSolver.setVerbose(2);

		

		
		// solve original model
		OrToolsSolver.solve(originalModel);
		
		originalModel.solution = OrToolsSolver.solution;
		originalModel.objValue = OrToolsSolver.solver.objectiveValue();
	
		MPModel tModel =  TransformModel.transform(originalModel);
		
		tModel.originalObjFunction = originalModel.objFunction;
		OrToolsSolver.solve(tModel);
		tModel.solution = OrToolsSolver.solution;
		tModel.objValue = OrToolsSolver.solver.objectiveValue();
		tModel.restoredSolution = TransformModel.restoreSolution(tModel.solution, tModel.tvarOffsetMap, tModel.tvarEquationMap);
		tModel.restoredObjValue = TransformModel.restoreObjValue(tModel.originalObjFunction, tModel.restoredSolution);
		
		
		
		
		MPModel baseModel =  createSearchModel(tModel);
		// solve search model
		OrToolsSolver.solve(baseModel);
		
		baseModel.solution = OrToolsSolver.solution;
		baseModel.objValue = OrToolsSolver.solver.objectiveValue();		
		baseModel.restoredSolution = TransformModel.restoreSolution(baseModel.solution, tModel.tvarOffsetMap, tModel.tvarEquationMap);
		
		LinkedHashSet<String> zeroSolutionVars = findZeroSolutionVars(baseModel.solution);
		
		
		ArrayList<LinkedHashMap<String, Double>> allSearchSolutions_raw = searchAltSolutions_quick(baseModel, zeroSolutionVars);
		allSearchSolutions_raw.add(baseModel.solution);

		
		ArrayList<LinkedHashMap<String, Double>> allSearchSolutions = TransformModel.restoreSolutions(allSearchSolutions_raw, tModel.tvarOffsetMap, tModel.tvarEquationMap);
		allSearchSolutions.add(originalModel.solution);		
	
		// print all solutions
		
		System.out.println("Original:   "+originalModel.solution);
		System.out.println("transform:  "+tModel.restoredSolution);		
		System.out.println("SearchBase: "+baseModel.restoredSolution);
		
//		writeReport();
		
		for (LinkedHashMap<String,Double> solution: allSearchSolutions_raw){
			
			System.out.println("Search raw:     "+solution);
			
		}		
		
		System.out.println("==== all solutions ====");
		for (LinkedHashMap<String,Double> solution: allSearchSolutions){
			
			System.out.println("solution:   "+solution);
			
		}
		
		// find solution ranges
		
		//findSolutionRanges(allSolutions);
		
		
		
		
	}

	public static MPModel loadModel(String MPModelPath) throws FileNotFoundException, IOException, ClassNotFoundException {
			
			    
			    
//				ObjectOutputStream mos = new ObjectOutputStream(new FileOutputStream("mpmodel.dat"));
//				    mos.writeObject(originalModel);
//				    mos.close();
				    
				    
				    //Read objects or arrays from binary file "o.dat":
				    ObjectInputStream mis = new ObjectInputStream(new FileInputStream(MPModelPath));
				    MPModel ia = (MPModel) (mis.readObject());
					
				    return ia;   
		
		}

}
