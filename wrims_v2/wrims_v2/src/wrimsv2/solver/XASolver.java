package wrimsv2.solver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;

public class XASolver {
	int modelStatus;
	
	public XASolver(){
		ControlData.xasolver.loadNewModel();
		setConstraints();
		setDVars();
		setWeights();
		
		ControlData.xasolver.solve();
		
		modelStatus=ControlData.xasolver.getModelStatus();
		System.out.println("Model status: "+modelStatus);
		if (modelStatus>2)	getSolverInformation();
		if (Error.error_solving.size()<1) assignDvar(); 
	}
	
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
	}
	
	public void setDVars(){
		Map<String, Dvar> DvarMap = SolverData.getDvarMap();
		//Set DvarCollection = DvarMap.keySet();
		ArrayList<String> DvarCollection = ControlData.currModelDataSet.dvList;
		Iterator<String> dvarIterator=DvarCollection.iterator();
		
		while(dvarIterator.hasNext()){                          
			String dvarName=(String)dvarIterator.next();
			Dvar dvar=DvarMap.get(dvarName);

			double lb = dvar.lowerBoundValue.doubleValue();
			double ub = dvar.upperBoundValue.doubleValue();
			
			if (dvar.integer.equals("y")){
				ControlData.xasolver.setColumnInteger(dvarName, lb, ub); }
			else {
				ControlData.xasolver.setColumnMinMax(dvarName, lb, ub);}
		}
	}

	public void setWeights(){
		Map<String, WeightElement> weightMap = SolverData.getWeightMap();
		ArrayList<String> weightCollection = ControlData.currModelDataSet.wtList;
		Iterator<String> weightIterator = weightCollection.iterator();
		
		while(weightIterator.hasNext()){
			String weightName=(String)weightIterator.next();
			ControlData.xasolver.setColumnObjective(weightName, weightMap.get(weightName).getValue());
		}
		
		Map<String, WeightElement> weightSlackSurplusMap = SolverData.getWeightSlackSurplusMap();
		ArrayList<String> usedWeightSlackSurplusCollection = ControlData.currModelDataSet.usedWtSlackSurplusList;
		Iterator<String> weightSlackSurplusIterator = usedWeightSlackSurplusCollection.iterator();
		
		while(weightSlackSurplusIterator.hasNext()){
			String weightSlackSurplusName=(String)weightSlackSurplusIterator.next();
			ControlData.xasolver.setColumnObjective(weightSlackSurplusName, weightSlackSurplusMap.get(weightSlackSurplusName).getValue());
		}
	}
	
	private void setConstraints() {
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		//Set constraintCollection = constraintMap.keySet();
		ArrayList<String> constraintCollection = new ArrayList<String>(ControlData.currModelDataSet.gList);
		constraintCollection.retainAll(constraintMap.keySet());
		Iterator<String> constraintIterator = constraintCollection.iterator();
		
		while(constraintIterator.hasNext()){                          
			String constraintName=(String)constraintIterator.next();
			EvalConstraint ec=constraintMap.get(constraintName);
			
			if (ec.getSign().equals("=")) {
				ControlData.xasolver.setRowFix(constraintName, -ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
			}
			else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
				ControlData.xasolver.setRowMax(constraintName, -ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
			}
			else if (ec.getSign().equals(">")){
				ControlData.xasolver.setRowMin(constraintName, -ec.getEvalExpression().getValue().getData().doubleValue()); //string constraint name
			}
			
			HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
			Set multCollection = multMap.keySet();
			Iterator multIterator = multCollection.iterator();
			
			while(multIterator.hasNext()){
				String multName=(String)multIterator.next();
				ControlData.xasolver.loadToCurrentRow(multName, multMap.get(multName).getData().doubleValue());
			}
		}
	}
	
	public void assignDvar(){
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator<String> dvarIterator = dvarCollection.iterator();
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Set<String> dvarUsedByLaterCycle = ControlData.currModelDataSet.dvarUsedByLaterCycle;
		String model=ControlData.currCycleName;
		
		String outPath=FilePaths.mainDirectory+"step"+ControlData.currTimeStep+"_"+ControlData.currCycleIndex+".txt";
		FileWriter outstream;
		//try {
			//outstream = new FileWriter(outPath);
			//BufferedWriter out = new BufferedWriter(outstream);
			
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			double value=ControlData.xasolver.getColumnActivity(dvName);
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
			
			//out.write(dvName+":"+value+"\n");
		}
		
		//out.close();
		
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		System.out.println("Objective Value: "+ControlData.xasolver.getObjective());
	}
}
