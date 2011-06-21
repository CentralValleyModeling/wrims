package wrimsv2.solver;

import gurobi.*;

import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import gurobi.*;

public class GurobiSolver {
	
	int modelStatus;
	GRBEnv    env   = new GRBEnv("mip1.log");
	GRBModel  model = new GRBModel(env);
	
	Map<String, GRBVar> varMap = new HashMap <String, GRBVar> ();
	
	public GurobiSolver() throws GRBException{
		setConstraints();
		setDVars();
		model.optimize();		
		assignDvarTimeseries();

	}
	
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
			
			if (weightMap.containsKey(dvarName)) {
				GRBVar VarName = model.addVar(lb, ub, weightMap.get(dvarName).getValue(), GRB.BINARY, dvarName);
				varMap.put(dvarName, VarName);
			}else{
				GRBVar VarName = model.addVar(lb, ub, 0, GRB.BINARY, dvarName);
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
			GRBLinExpr expr = new GRBLinExpr();
			if (ec.getSign().equals("=")) {
				model.addConstr(expr, GRB.EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
			else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
				model.addConstr(expr, GRB.LESS_EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
			else if (ec.getSign().equals(">")){
				model.addConstr(expr, GRB.GREATER_EQUAL, -ec.getEvalExpression().getValue().getData().doubleValue(), constraintName); 
			}
			
			HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
			Set multCollection = multMap.keySet();
			Iterator multIterator = multCollection.iterator();
			
			while(multIterator.hasNext()){
				String multName=(String)multIterator.next();
				expr.addTerm(multMap.get(multName).getData().doubleValue(), varMap.get(multName));
			}
		}
	}
	
	public void assignDvarTimeseries() throws GRBException{
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		
		String outPath=FilePaths.mainDirectory+"step"+ControlData.currTimeStep+"_"+ControlData.currCycleIndex+".txt";
		FileWriter outstream;
		try {
			outstream = new FileWriter(outPath);
			BufferedWriter out = new BufferedWriter(outstream);
			
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			double value=varMap.get(dvName).get(GRB.DoubleAttr.X); 
			dvar.setData(new IntDouble(value,false));
			if (!DataTimeSeries.dvAliasTS.containsKey(dvName)){
				DssDataSetFixLength dds=new DssDataSetFixLength();
				double[] data=new double[ControlData.totalTimeStep];
				dds.setData(data);
				dds.setTimeStep(ControlData.partE);
				dds.setStartTime(ControlData.startTime);
				DataTimeSeries.dvAliasTS.put(dvName,dds);
			}
			double[] dataList=DataTimeSeries.dvAliasTS.get(dvName).getData();
			dataList[ControlData.currTimeStep]=value;
			
			out.write(dvName+":"+value+"\n");
		}
		
		out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
