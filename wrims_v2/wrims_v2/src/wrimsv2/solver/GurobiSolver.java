package wrimsv2.solver;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import com.sunsetsoft.xa.Optimizer;
import com.sunsetsoft.xa.XAException;

import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.commondata.solverdata.*;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.IntDouble;
import wrimsv2.components.Error;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import gurobi.*;

public class GurobiSolver {
	int modelStatus;
	GRBEnv    env   = new GRBEnv("model1.log");
	GRBModel  model = new GRBModel(env);
	Map<String, GRBVar> varMap = new HashMap <String, GRBVar> ();
	
	public GurobiSolver() throws GRBException{
		//ControlData.xasolver.loadNewModel();
		setConstraints();
		setDVars();
		//setWeights();

		try {
			model.optimize();
		} catch (GRBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ControlData.xasolver.solve();
		/*
		modelStatus=ControlData.xasolver.getModelStatus();
		System.out.println("Model status: "+modelStatus);
		if (modelStatus>2)	getSolverInformation();
		*/
	}
	/*
	public void getSolverInformation(){
		System.out.println("Solver status: "+ControlData.xasolver.getSolverStatus());
		System.out.println("Exception: "+ControlData.xasolver.getExceptionCode());
		System.out.println("Message: "+ControlData.xasolver.getMessage());
		System.out.println("Return code: "+ControlData.xasolver.getRc());
		switch (modelStatus){
			case 3: Error.addSolvingError("Unbounded solution."); break;
			case 4: Error.addSolvingError("Infeasible solution."); break;
			case 6: Error.addSolvingError("Intermediate infeasible solution."); break;
		}
	}*/
	
	public void setDVars() throws GRBException{
		Map<String, Dvar> DvarMap = SolverData.getDvarMap();
		Set DvarCollection = DvarMap.keySet();
		Iterator dvarIterator=DvarCollection.iterator();
		
		while(dvarIterator.hasNext()){                          
			String dvarName=(String)dvarIterator.next();
			Dvar dvar=DvarMap.get(dvarName);

			Map<String, WeightElement> weightMap = SolverData.getWeightMap();
			Set weightCollection = weightMap.keySet();
			Iterator weightIterator = weightCollection.iterator();
			String weightName=(String)weightIterator.next();
			
			double lb = dvar.lowerBoundValue.doubleValue();
			double ub = dvar.upperBoundValue.doubleValue();
			
			GRBVar VarName = model.addVar(lb, ub, weightMap.get(dvarName).getValue(), GRB.BINARY, dvarName);
			varMap.put(dvarName, VarName);
			model.update();
			/*
			if (dvar.integer.equals("y")){
				ControlData.xasolver.setColumnInteger(dvarName, lb, ub); }
			else {
				ControlData.xasolver.setColumnMinMax(dvarName, lb, ub);}*/
		}
	}
	/*
	public void setWeights(){
		Map<String, WeightElement> weightMap = SolverData.getWeightMap();
		Set weightCollection = weightMap.keySet();
		Iterator weightIterator = weightCollection.iterator();
		
		while(weightIterator.hasNext()){
			String weightName=(String)weightIterator.next();
			ControlData.xasolver.setColumnObjective(weightName, weightMap.get(weightName).getValue());
		}
	}
	*/
	private void setConstraints() throws GRBException {
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		Set constraintCollection = constraintMap.keySet();
		Iterator constraintIterator = constraintCollection.iterator();
		
		while(constraintIterator.hasNext()){                          
			String constraintName=(String)constraintIterator.next();
			EvalConstraint ec=constraintMap.get(constraintName);
			GRBLinExpr expr = new GRBLinExpr();
			if (ec.getSign().equals("=")) {
				//ControlData.xasolver.setRowFix(constraintName, -ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
				model.addConstr(expr, GRB.EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
			else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
				//ControlData.xasolver.setRowMax(constraintName, -ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
				model.addConstr(expr, GRB.LESS_EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
			else if (ec.getSign().equals(">")){
				//ControlData.xasolver.setRowMin(constraintName, -ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
				model.addConstr(expr, GRB.GREATER_EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
			
			HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
			Set multCollection = multMap.keySet();
			Iterator multIterator = multCollection.iterator();
			
			while(multIterator.hasNext()){
				String multName=(String)multIterator.next();
				//ControlData.xasolver.loadToCurrentRow(multName, multMap.get(multName).getData().doubleValue());
				expr.addTerm(multMap.get(multName).getData().doubleValue(), varMap.get(multName));
			}
		}
	}
}
