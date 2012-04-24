package wrimsv2.solver;

import gurobi.*;

import gurobi.GRB;
import gurobi.GRBConstr;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import gurobi.*;

public class GurobiSolver {
	
	int modelStatus;
	GRBEnv    env   = new GRBEnv("TestGurobi.log");
	GRBModel  model = new GRBModel(env);
	
	Map<String, GRBVar> varMap = new HashMap <String, GRBVar> ();
	
	public GurobiSolver() throws GRBException{	
		
		setDVars();
		setConstraints();
		model.optimize();	
		assignDvar();
		Output();
	
	}
	
	public void setDVars() throws GRBException{
		Map<String, Dvar> DvarMap = SolverData.getDvarMap();
		Set DvarCollection = DvarMap.keySet();
		Iterator dvarIterator=DvarCollection.iterator();
		
		while(dvarIterator.hasNext()){                          
			String dvarName=(String)dvarIterator.next();
			Dvar dvar=DvarMap.get(dvarName);
			double testWeight=0;
			
			Map<String, WeightElement> weightMap = SolverData.getWeightMap();
			Set weightCollection = weightMap.keySet();
			Iterator weightIterator = weightCollection.iterator();
			String weightName=(String)weightIterator.next();
			
			double lb = dvar.lowerBoundValue.doubleValue();
			double ub = dvar.upperBoundValue.doubleValue();
			
			if (weightMap.containsKey(dvarName)) {
				double weight=-weightMap.get(dvarName).getValue();
				GRBVar VarName = model.addVar(lb, ub, weight, GRB.CONTINUOUS, dvarName);
				varMap.put(dvarName, VarName);
				
				testWeight = weight;
			}else{
				GRBVar VarName = model.addVar(lb, ub, 0, GRB.CONTINUOUS, dvarName);
				varMap.put(dvarName, VarName);
			}
			model.update();
		}
	}

	private void setConstraints() throws GRBException {
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		Set constraintCollection = constraintMap.keySet();
		Iterator constraintIterator = constraintCollection.iterator();
		
		while(constraintIterator.hasNext()){                          
			String constraintName=(String)constraintIterator.next();
			EvalConstraint ec=constraintMap.get(constraintName);
			HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
			Set multCollection = multMap.keySet();
			Iterator multIterator = multCollection.iterator();
			GRBLinExpr expr = new GRBLinExpr();
			double [] jack = new double[multCollection.size()+1];
			int counter = 1;
			
			while(multIterator.hasNext()){
				String multName=(String)multIterator.next();
				double coef=multMap.get(multName).getData().doubleValue();
				GRBVar var=varMap.get(multName);
				expr.addTerm(coef, var);
				jack[counter] = coef;
				counter++;
			}
			if (ec.getSign().equals("=")) {
				model.addConstr(expr, GRB.EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 			}
			else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
				model.addConstr(expr, GRB.LESS_EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
			else if (ec.getSign().equals(">") || ec.getSign().equals(">=")){
				model.addConstr(expr, GRB.GREATER_EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
		}
	}
	
	public void assignDvar() throws GRBException{
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Map<String, Map<String, IntDouble>> varTimeArrayCycleValueMap=ControlData.currStudyDataSet.getVarTimeArrayCycleValueMap();
		Set<String> dvarUsedByLaterCycle = ControlData.currModelDataSet.dvarUsedByLaterCycle;
		Set<String> dvarTimeArrayUsedByLaterCycle = ControlData.currModelDataSet.dvarTimeArrayUsedByLaterCycle;
		String model=ControlData.currCycleName;
		
		String outPath=FilePaths.mainDirectory+"step"+ControlData.currTimeStep+"_"+ControlData.currCycleIndex+".txt";
		FileWriter outstream;
		try {
			outstream = new FileWriter(outPath);
			BufferedWriter out = new BufferedWriter(outstream);
			
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			double value=varMap.get(dvName).get(GRB.DoubleAttr.X); 
			IntDouble id=new IntDouble(value,false);
			dvar.setData(id);
			if(dvarUsedByLaterCycle.contains(dvName)){
				varCycleValueMap.get(dvName).put(model, id);
			}else if (dvarTimeArrayUsedByLaterCycle.contains(dvName)){
				if (varTimeArrayCycleValueMap.containsKey(dvName)){
					varTimeArrayCycleValueMap.get(dvName).put(model, dvar.data);
				}else{
					Map<String, IntDouble> cycleValue = new HashMap<String, IntDouble>();
					cycleValue.put(model, dvar.data);
					varTimeArrayCycleValueMap.put(dvName, cycleValue);
				}
			}
			if (!DataTimeSeries.dvAliasTS.containsKey(dvName)){
				DssDataSetFixLength dds=new DssDataSetFixLength();
				double[] data=new double[ControlData.totalTimeStep.get(ControlData.currCycleIndex)];
				dds.setData(data);
				dds.setTimeStep(ControlData.partE);
				dds.setStartTime(ControlData.startTime);
				dds.setUnits(dvar.units);
				dds.setKind(dvar.kind);
				DataTimeSeries.dvAliasTS.put(dvName,dds);
			}
			double[] dataList=DataTimeSeries.dvAliasTS.get(dvName).getData();
			dataList[ControlData.currTimeStep.get(ControlData.currCycleIndex)]=value;
			
			out.write(dvName+":"+value+"\n");
		}
		
		out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ControlData.showRunTimeMessage) System.out.println("Assign Dvar Done.");
	}

	private void checkStatus() throws GRBException {
	      int status = model.get(GRB.IntAttr.Status);
	      if (status == GRB.Status.UNBOUNDED) {
	        System.out.println("The model cannot be solved "
	            + "because it is unbounded");
	        return;
	      }
	      if (status == GRB.Status.OPTIMAL) {
	        System.out.println("The optimal objective is " +
	            model.get(GRB.DoubleAttr.ObjVal));
	        return;
	      }
	      if (status != GRB.Status.INF_OR_UNBD && 
	          status != GRB.Status.INFEASIBLE    ) {
	        System.out.println("Optimization was stopped with status " + status);
	        return;
	      }

	      // do IIS
	      System.out.println("The model is infeasible; computing IIS");
	      LinkedList<String> removed = new LinkedList<String>();

	      // Loop until we reduce to a model that can be solved
	      while (true) {
	        model.computeIIS();
	        System.out.println("\nThe following constraint cannot be satisfied:");
	        for (GRBConstr c : model.getConstrs()) {
	          if (c.get(GRB.IntAttr.IISConstr) == 1) {
	            System.out.println(c.get(GRB.StringAttr.ConstrName));
	            // Remove a single constraint from the model
	            removed.add(c.get(GRB.StringAttr.ConstrName));
	            model.remove(c);
	            break;
	          }
	        }

	        System.out.println();
	        model.optimize();
	        status = model.get(GRB.IntAttr.Status);

	        if (status == GRB.Status.UNBOUNDED) {
	          System.out.println("The model cannot be solved "
	              + "because it is unbounded");
	          return;
	        }
	        if (status == GRB.Status.OPTIMAL) {
	          break;
	        }
	        if (status != GRB.Status.INF_OR_UNBD &&
	            status != GRB.Status.INFEASIBLE    ) {
	          System.out.println("Optimization was stopped with status " +
	              status);
	          return;
	        }
	      }

	      System.out.println("\nThe following constraints were removed "
	          + "to get a feasible LP:");
	      for (String s : removed) {
	        System.out.print(s + " ");
	      }
	      System.out.println();
		}
	
	private void Output() throws GRBException {
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			System.out.print(dvName + ": " + dvar.getData().getData() +"\n");
		}
		
		System.out.println("Obj: " + model.get(GRB.DoubleAttr.ObjVal));
	}
}
