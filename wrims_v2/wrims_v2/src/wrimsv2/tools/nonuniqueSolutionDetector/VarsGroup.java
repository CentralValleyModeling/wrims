package wrimsv2.tools.nonuniqueSolutionDetector;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import wrimsv2.solver.mpmodel.MPModel;
import wrimsv2.wreslplus.elements.Tools;

public class VarsGroup {

	public ArrayList<String> lowerVertexVars_number;
	public ArrayList<String> lowerVertexVars_integer;
	public ArrayList<String> upperVertexVars_number;
	public ArrayList<String> upperVertexVars_integer;

	// required
	private final double vertax_tolerance;  // tolerance for determining if a var is at vertex
	private MPModel baseModel;	
	
	// optional 
	private ArrayList<String> excludeStrings; // if not set then exclude none
	private ArrayList<String> includeStrings; // if not set then include all
	private ArrayList<String> varsPool;	// default is base solution
	
	// processed
	private ArrayList<String> varsPool_number;	// subset of varsPool
	private ArrayList<String> varsPool_integer;	// subset of varsPool
	
	public VarsGroup(MPModel in, double vertax_tolerance) {

		lowerVertexVars_number = new ArrayList<String>();
		lowerVertexVars_integer = new ArrayList<String>();
		upperVertexVars_number = new ArrayList<String>();
		upperVertexVars_integer = new ArrayList<String>();
		
		excludeStrings = null;
		includeStrings = null;
		
		baseModel = in;
		this.vertax_tolerance = vertax_tolerance;
		this.varsPool = new ArrayList<String>(baseModel.solution.keySet());
	}

	public void setIncludeStrings(ArrayList<String> in){
		
		includeStrings = in;
		
	}
	
	public void setExcludeStrings(ArrayList<String> in){
		
		excludeStrings = in;
		
	}	
	
	
	public void setVarsPool(){
		
		setVarsPool(new ArrayList<String>(baseModel.solution.keySet()));
		
	}
	public void setVarsPool(ArrayList<String> varsToSearch_in){
		
		ArrayList<String> p = new ArrayList<String>(Tools.allToLowerCase(varsToSearch_in));

		if (p.retainAll(baseModel.solution.keySet())){
			// unknown vars...
			ArrayList<String> unknownVars = new ArrayList<String>(Tools.allToLowerCase(varsToSearch_in));
			unknownVars.removeAll(p);
			System.err.println("# Error: unknown vars in varsPool:"+ unknownVars);
		
		} else {
			
			varsPool = p;
			
			varsPool_integer = new ArrayList<String>(p);
			varsPool_integer.retainAll(baseModel.varMap_integer.keySet());

			varsPool_number = new ArrayList<String>(p);
			varsPool_number.retainAll(baseModel.varMap_number.keySet());
			
		}
	
		
	}
	

	public void findVarsAtVertex(){
		
		//lowerVertexVars_number = findLowerVertaxVars_number();
		lowerVertexVars_number = findLowerVertaxVars(varsPool_number, baseModel.solution, baseModel.varMap_number);
		upperVertexVars_number = findUpperVertaxVars(varsPool_number, baseModel.solution, baseModel.varMap_number);
		lowerVertexVars_integer = findLowerVertaxVars(varsPool_integer, baseModel.solution, baseModel.varMap_integer);
		upperVertexVars_integer = findUpperVertaxVars(varsPool_integer, baseModel.solution, baseModel.varMap_integer);
		
	}
	
	private ArrayList<String> findLowerVertaxVars(ArrayList<String> vars, LinkedHashMap<String, Double> solutionMap, LinkedHashMap<String, double[]> varBounds) {

		ArrayList<String> out = new ArrayList<String>();

		for (String key : vars) {

			if (solutionMap.get(key) < varBounds.get(key)[0] + vertax_tolerance) {

				out.add(key);

			}
		}

		return out;
	}
	
	private ArrayList<String> findUpperVertaxVars(ArrayList<String> vars, LinkedHashMap<String, Double> solutionMap, LinkedHashMap<String, double[]> varBounds) {

		ArrayList<String> out = new ArrayList<String>();

		for (String key : vars) {

			if (solutionMap.get(key) > varBounds.get(key)[1] - vertax_tolerance) {

				out.add(key);

			}
		}

		return out;
	}
	
	private ArrayList<String> findLowerVertaxVars_number() {

		ArrayList<String> out = new ArrayList<String>();

		for (String key : varsPool_number) {

			if (baseModel.solution.get(key) < baseModel.varMap_number.get(key)[0] + vertax_tolerance) {

				out.add(key);

			}
		}

		return out;
	}

}
