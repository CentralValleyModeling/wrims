package wrimsv2.tools.nonuniqueSolutionDetector;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import wrimsv2.solver.mpmodel.MPModel;
import wrimsv2.solver.mpmodel.MPModelUtils;
import wrimsv2.solver.ortools.OrToolsSolver;

public class AltSolutionFinder {

	
	// required
	private String id;
	private MPModel asfModel = null;
	private ArrayList<String> searchVars;
	private boolean isMaximize = true;
	private int maxIteration = 0; // max number of finds
	
	
	// optional
	private boolean lpsLogging = false;
	private String lpsDir = "";
	private String lpsFileNamePrepend = "";
	
	
	public AltSolutionFinder(String id, MPModel inModel, ArrayList<String> searchVars, boolean isMaximize, int maxIteration) {
		
		this.asfModel = inModel;
		this.id = id;
		this.searchVars = searchVars;
		this.isMaximize = isMaximize;
		this.maxIteration = maxIteration;		
	}


	// optional. This is for lps file logging. if not set then no logging.
	public void setLpsLoggingPath(String dirName, String lpsFileNamePrepend){
		
		this.lpsLogging = true;
		this.lpsDir = dirName;
		this.lpsFileNamePrepend = lpsFileNamePrepend+"_"+id;
		
	}

	public ArrayList<LinkedHashMap<String, Double>> go() {
		
		ArrayList<LinkedHashMap<String, Double>> altSolutions = new ArrayList<LinkedHashMap<String, Double>>();
		
		boolean hasNewSolution = true;

		int i = 0;
		
		OrToolsSolver sSolver = new OrToolsSolver("CBC_MIXED_INTEGER_PROGRAMMING");
		sSolver.setModel(asfModel);
		
		while (hasNewSolution && i<=maxIteration && searchVars.size()>0) {
			i++;
			System.out.println("# seach: "+i);
									
			LinkedHashMap<String, Double> searchObjFunc = new LinkedHashMap<String, Double>();
	
			System.out.println("Vars to search:  "+searchVars);
			//System.out.println("lowerVertaxVars_integer: "+lowerVertaxVars_integer);
			
			double searchObjOffset = createSearchObjFunc(searchObjFunc, searchVars, asfModel.solution);
			
	
			System.out.println("searchObjFunc: "+searchObjFunc);
			System.out.println("searchObjOffset: "+searchObjOffset);
			
			sSolver.refreshObjFunc(searchObjFunc);
			
			// log search model
			
			MPModelUtils.toLpSolve(sSolver.model, lpsDir, lpsFileNamePrepend+"_search_"+i+".lps");
	
			// TODO: if solve fail then need to skip current obj function and continue to next search
			if (sSolver.solve()!=0) {
				System.out.println("# Error ... problem in alt solution search ...");
				//continue;
			}
	
	
			hasNewSolution = false;
			
			// TODO: tolerance to replace 0
			if (sSolver.solver.objectiveValue() > searchObjOffset) {
				
				// post new solution
				altSolutions.add(sSolver.solution);
				
				// update zeroSolutionVars
				ArrayList<String> varsHaveNewSolution = new ArrayList<String>();
				for (String key: searchVars){
					
					// TODO: tolerance to replace lower bound
					if (sSolver.solution.get(key) > asfModel.varMap_number.get(key)[0]) varsHaveNewSolution.add(key);
					
				}
	
				searchVars.removeAll(varsHaveNewSolution);
	
				
				hasNewSolution = true;
				
				System.out.println("New solution found? "+hasNewSolution);	
				System.out.println("vars have new solution: "+varsHaveNewSolution);
				
			} else {
				
				System.out.println("New solution found? "+hasNewSolution);	
			}
			
			
		}
		
		sSolver.delete();
		return altSolutions;
		
	}


	public static double createSearchObjFunc(LinkedHashMap<String, Double> out_searchObjFunc, ArrayList<String> vars, LinkedHashMap<String, Double> baseSolution){
	
	
		double out_searchObjOffset = 0;
		
		for (String key: vars){
			
			out_searchObjFunc.put(key, Detector2.coef_searchObj);
			out_searchObjOffset = out_searchObjOffset + baseSolution.get(key)*Detector2.coef_searchObj;
			
		}
		
		return out_searchObjOffset;
			
	}	
	
}
