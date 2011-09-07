package wrimsv2.solver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
import lpsolve.*;

public class LPSolveSolver {
	LpSolve Model = LpSolve.makeLp(10000, 25000);
	Map <String, Integer> VarMap = new HashMap <String, Integer>();
    double [] addConstraint;
    int [] constraintNum;
    
	public LPSolveSolver() throws LpSolveException{
		//setDVars();
		setConstraints();
		setObjective();
		Model.solve();
		assignDvar();
		Output();
	}
		
	public void setDVars() throws LpSolveException{
		Map<String, Dvar> DvarMap = SolverData.getDvarMap();
		Set DvarCollection = DvarMap.keySet();
		Iterator dvarIterator=DvarCollection.iterator();
		int ColNum = 0;
		
		while(dvarIterator.hasNext()){                          
			String dvarName=(String)dvarIterator.next();
			Dvar dvar=DvarMap.get(dvarName);
			
			double lb = dvar.lowerBoundValue.doubleValue();
			double ub = dvar.upperBoundValue.doubleValue();
			
			if (dvar.integer.equals("y")){
				Model.setBounds(ColNum, lb, ub);
				VarMap.put(dvarName, ColNum);}
			else {
				Model.setBounds(ColNum, 0, 0);
				VarMap.put(dvarName, ColNum);}
		}
	}

	public void setObjective() throws LpSolveException{
		Map<String, WeightElement> weightMap = SolverData.getWeightMap();
		Set weightCollection = weightMap.keySet();
		Iterator weightIterator = weightCollection.iterator();
		double[] weightArray = new double[weightCollection.size()];
		
		while(weightIterator.hasNext()){
			String weightName=(String)weightIterator.next();
			weightArray[VarMap.get(weightName)]=weightMap.get(weightName).getValue();
		}
		Model.setObjFnex(VarMap.size(), weightArray, constraintNum);
	}
	
	private void setConstraints() throws LpSolveException {
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		Set constraintCollection = constraintMap.keySet();
		Iterator constraintIterator = constraintCollection.iterator();
		
		while(constraintIterator.hasNext()){                          
			String constraintName=(String)constraintIterator.next();
			EvalConstraint ec=constraintMap.get(constraintName);
			HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
			Set multCollection = multMap.keySet();
			Iterator multIterator = multCollection.iterator();
			int colNum = 1;
		    addConstraint = new double[multCollection.size()+1];
		    constraintNum = new int[multCollection.size()+1];
		    
			while(multIterator.hasNext()){
				String multName=(String)multIterator.next();
				double coef=multMap.get(multName).getData().doubleValue();
				
				addConstraint[colNum]= coef;
				constraintNum[colNum]=colNum;
				VarMap.put(multName, colNum);
				colNum++;
			}
			
			Map<String, Dvar> DvarMap = SolverData.getDvarMap();
			Set DvarCollection = DvarMap.keySet();
			Iterator dvarIterator=DvarCollection.iterator();
			
			while(dvarIterator.hasNext()){                          
				String dvarName=(String)dvarIterator.next();
				Dvar dvar=DvarMap.get(dvarName);
				
				double lb = dvar.lowerBoundValue.doubleValue();
				double ub = dvar.upperBoundValue.doubleValue();
				
				Model.setColName(VarMap.get(dvarName), dvarName);
				
				if (dvar.integer.equals("y")){
					Model.setBounds(VarMap.get(dvarName), lb, ub);}
				else {
					Model.setBounds(VarMap.get(dvarName), lb, ub);}
			}
			
			if (ec.getSign().equals("=")) {		
				Model.addConstraintex(addConstraint.length,addConstraint,constraintNum,3,ec.getEvalExpression().getValue().getData().doubleValue());} //LE(1); GE(2): EQ(3)
			else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
				Model.addConstraintex(addConstraint.length,addConstraint,constraintNum,1,ec.getEvalExpression().getValue().getData().doubleValue());
			}
			else if (ec.getSign().equals(">") || ec.getSign().equals(">=")){
				Model.addConstraintex(addConstraint.length,addConstraint,constraintNum,2,ec.getEvalExpression().getValue().getData().doubleValue());
			}
		}
	}
	
	public void assignDvar() throws LpSolveException{
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Set<String> dvarUsedByLaterCycle = ControlData.currModelDataSet.dvarUsedByLaterCycle;
		String model=ControlData.currCycleName;
		
		String outPath=FilePaths.mainDirectory+"step"+ControlData.currTimeStep+"_"+ControlData.currCycleIndex+".txt";
		FileWriter outstream;
		try {
			outstream = new FileWriter(outPath);
			BufferedWriter out = new BufferedWriter(outstream);
			
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			double[] var = Model.getPtrVariables();
			double value=var[VarMap.get(dvName)]; 
			IntDouble id=new IntDouble(value,false);
			dvar.setData(id);
			if (dvarUsedByLaterCycle.contains(dvName)){
				varCycleValueMap.get(dvName).put(model, id);
			}
			if (!DataTimeSeries.dvAliasTS.containsKey(dvName)){
				DssDataSetFixLength dds=new DssDataSetFixLength();
				double[] data=new double[ControlData.totalTimeStep];
				dds.setData(data);
				dds.setTimeStep(ControlData.partE);
				dds.setStartTime(ControlData.startTime);
				dds.setUnits(dvar.units);
				dds.setKind(dvar.kind);
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
	
	private void Output() throws  LpSolveException{
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			System.out.print(dvName + ": " + dvar.getData().getData() +"\n");
		}
		
		System.out.println("Obj: " + Model.getObjective());
	}
}
