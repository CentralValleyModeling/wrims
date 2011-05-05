package wrimsv2.solver;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import com.sunsetsoft.xa.Optimizer;
import com.sunsetsoft.xa.XAException;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.commondata.solverdata.*;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.EvalConstraint;

public class Solver {
	private Optimizer solver=new Optimizer(25000);

	public Solver(){
		PrepareConstraintCoefficients();
		PrepareWeights();
		PrepareDVar();
		
		solver.solve();

	}
	
	public void PrepareDVar(){
		Map<String, Dvar> DvarMap = SolverData.getDvarMap();
		Set DvarCollection = DvarMap.keySet();
		Iterator dvarIterator=DvarCollection.iterator();
		
		while(dvarIterator.hasNext()){                          
			String dvarName=(String)dvarIterator.next();
			Dvar dvar=DvarMap.get(dvarName);

			double lb = dvar.lowerBoundValue.doubleValue();
			double ub = dvar.upperBoundValue.doubleValue();
			
			if (dvar.integer.equals("y")){
				solver.setColumnInteger(dvarName, lb, ub); }
			else {
				solver.setColumnMinMax(dvarName, lb, ub);}
		}
	}

	public void PrepareWeights(){
		Map<String, WeightElement> weightMap = SolverData.getWeightMap();
		Set weightCollection = weightMap.keySet();
		Iterator weightIterator = weightCollection.iterator();
		
		while(weightIterator.hasNext()){
			String weightName=(String)weightIterator.next();
			solver.setColumnObjective(weightName, weightMap.get(weightName).getValue());
		}
	}
	
	private void PrepareConstraintCoefficients() {
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		Set constraintCollection = constraintMap.keySet();
		Iterator constraintIterator = constraintCollection.iterator();
		
		while(constraintIterator.hasNext()){                          
			String constraintName=(String)constraintIterator.next();
			EvalConstraint ec=constraintMap.get(constraintName);
		
			if (ec.getSign().equals("=")) {
				solver.setRowFix(constraintName, ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
			}
			else if (ec.getSign().equals("<")){
				solver.setRowMax(constraintName, ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
			}
			else if (ec.getSign().equals(">")){
				solver.setRowMin(constraintName, ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
			}
			
			HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
			Set multCollection = multMap.keySet();
			Iterator multIterator = multCollection.iterator();
			
			while(multIterator.hasNext()){
				String multName=(String)multIterator.next();
				solver.loadToCurrentRow(multName, multMap.get(multName).getData().doubleValue());
			}
		}
	}
}
