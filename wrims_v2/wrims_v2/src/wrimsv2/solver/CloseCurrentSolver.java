package wrimsv2.solver;

import wrimsv2.components.ControlData;
import wrimsv2.solver.Gurobi.GurobiSolver;
import wrimsv2.solver.ortools.OrToolsSolver;

public class CloseCurrentSolver {
	public CloseCurrentSolver(String currentSolver){
		if (currentSolver.equalsIgnoreCase("XA") || currentSolver.equalsIgnoreCase("XALOG")) {
			ControlData.xasolver.close();
		}else if (currentSolver.equalsIgnoreCase("Gurobi")){
			GurobiSolver.dispose();
		}else if (currentSolver.equalsIgnoreCase("Glpk")){
			OrToolsSolver.delete();
		}else if (currentSolver.equalsIgnoreCase("Cbc")){
			OrToolsSolver.delete();
		}
	}
}
