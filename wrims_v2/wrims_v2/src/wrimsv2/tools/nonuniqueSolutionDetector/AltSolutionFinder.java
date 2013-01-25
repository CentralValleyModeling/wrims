package wrimsv2.tools.nonuniqueSolutionDetector;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import wrimsv2.solver.mpmodel.MPModel;
import wrimsv2.solver.mpmodel.MPModelUtils;
import wrimsv2.solver.ortools.OrToolsSolver;
import wrimsv2.wreslplus.elements.Tools;

public class AltSolutionFinder {

	
	// required
	private String id;
	private MPModel asfModel = null;
	private ArrayList<String> searchVars; // will be modified (reduced) in the searching process ..
	private int searchObjSign; // 1 for + and -1 for -
	private ArrayList<String> reportVars; // only report these vars 
	private int maxIteration = 0; // max number of finds
	
	
	
	// optional
	private boolean lpsLogging = false;
	private String lpsDir = "";
	private String lpsFileNamePrepend = "";
	
	
	public AltSolutionFinder(String id, MPModel inModel, ArrayList<String> searchVars, int searchObjSign, ArrayList<String> reportVars, int maxIteration) {
		
		this.asfModel = inModel;
		this.id = id;
		this.searchVars = searchVars;
		this.searchObjSign = searchObjSign;
		this.reportVars = reportVars;
		this.maxIteration = maxIteration;

	}


	// optional. This is for lps file logging. if not set then no logging.
	public void setLpsLoggingPath(String dirName, String lpsFileNamePrepend){
		
		this.lpsLogging = true;
		this.lpsDir = dirName;
		this.lpsFileNamePrepend = lpsFileNamePrepend+"_"+id;
		
	}

	public ArrayList<LinkedHashMap<String, Double>> go() {

		OrToolsSolver sSolver = new OrToolsSolver("CBC_MIXED_INTEGER_PROGRAMMING");
		sSolver.setModel(asfModel);
		
		ArrayList<LinkedHashMap<String, Double>> altSolutions = new ArrayList<LinkedHashMap<String, Double>>();
		
		boolean hasNewObjValue = true;

		int i = 0;
		
		while (hasNewObjValue && i<=maxIteration && searchVars.size()>0) {
			i++;
			System.out.println(id+" seach: "+i);
									
			LinkedHashMap<String, Double> searchObjFunc = new LinkedHashMap<String, Double>();
			double searchObjOffset = createObjFunc(searchObjFunc, searchVars, searchObjSign, asfModel.solution);				
			
			System.out.println("Vars to search:  "+searchVars);

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

			System.out.println("obj value: "+sSolver.solver.objectiveValue());
			System.out.println("solution: "+sSolver.solution);
			
			hasNewObjValue = false;
			
			// TODO: something wrong here!
			
			if (searchObjSign>0) {
				hasNewObjValue = sSolver.solver.objectiveValue() > searchObjOffset;
			} else if (searchObjSign<0) {
				hasNewObjValue = sSolver.solver.objectiveValue() * searchObjSign < searchObjOffset * searchObjSign;
			}
			
			System.out.println("New solution found? "+hasNewObjValue);	
			
			if (hasNewObjValue) {
				
				// post new solution
				
				LinkedHashMap<String, Double> report_solution = new LinkedHashMap<String, Double>(sSolver.solution);
				Tools.mapRetainAll(report_solution, reportVars);
				altSolutions.add(report_solution);

				
				
				// update searchVars
				ArrayList<String> varsHaveNewSolution = new ArrayList<String>();
				for (String key: searchVars){
					
					// TODO: something wrong here...
					
					boolean hasNewVarSolution = false;
					
					if (searchObjSign>0) {
						hasNewVarSolution = sSolver.solution.get(key) > asfModel.solution.get(key);
					} else if (searchObjSign<0) {
						hasNewVarSolution = sSolver.solution.get(key) < asfModel.solution.get(key);
					}					
					
					if (hasNewVarSolution) varsHaveNewSolution.add(key);
					
				}
	
				searchVars.removeAll(varsHaveNewSolution);
	
				System.out.println("vars have new solution: "+varsHaveNewSolution);
				
			} 	
			
		}
		
		sSolver.delete();
		return altSolutions;
		
	}


	public static double createObjFunc(LinkedHashMap<String, Double> out_searchObjFunc, ArrayList<String> vars, int searchObjSign, LinkedHashMap<String, Double> baseSolution){
	
	
		double out_searchObjOffset = 0;
		
		for (String key: vars){
			
			out_searchObjFunc.put(key, (double)searchObjSign);
			out_searchObjOffset = out_searchObjOffset + baseSolution.get(key)*searchObjSign;
			
		}
		
		return out_searchObjOffset;
			
	}	
	
}
