package wrimsv2.solver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.commondata.solverdata.*;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.wreslparser.elements.Tools;
import lpsolve.*;

public class LPSolveSolver {
	LpSolve Model =null;
	Map <String, Integer> VarMap = new HashMap <String, Integer>();
    double [] addConstraint;
    int [] constraintNum;
    private static PrintWriter _lpsolveFile;
    private static File lpsolveParentDir;

	public LPSolveSolver(String filePath){

		  try {
			  
			  LpSolve solver = LpSolve.readLp("test2.lps", LpSolve.IMPORTANT, "test_prob");
		      //solver.setVerbose(LpSolve.IMPORTANT);

		      int ret = solver.solve();
		      
		      if (ret != LpSolve.OPTIMAL){
		    	  
		    	  System.out.println(ret);
		    	  System.out.println(solver.getStatustext(ret));
		      }
		      
		      solver.printSolution(1);
		      
		      System.out.println("loops:"+solver.getPresolveloops());

		      int rn = solver.getNorigRows();
		      for (int i = 1; i < solver.getNcolumns()+1; i++) {
		          System.out.println(solver.getOrigcolName(i)+" : "+solver.getVarPrimalresult(i+rn));
		      }
		      // delete the problem and free memory
		      //solver.deleteLp(); // move to later
		      
		      ControlData.lpssolver = solver; // for other processes
		    }
		    catch (LpSolveException e) {
		       e.printStackTrace();
		    }
	}
	
	public LPSolveSolver() throws LpSolveException{
		
		Model = LpSolve.makeLp(SolverData.getConstraintDataMap().size(), SolverData.getDvarMap().size()+SolverData.getWeightSlackSurplusMap().size());

		
		lpsolveParentDir = new File(FilePaths.mainDirectory, "=LPSolve=");
		try {
			_lpsolveFile = Tools.openFile(lpsolveParentDir.getAbsolutePath(), "LPSolveOutputTest.txt");} 
		catch (IOException e) {
			e.printStackTrace();}
		setDVars();
		setObjective();
		setConstraints();
		Model.setMaxim();
		Model.solve();
		assignDvar();
		Output();
	}
		
	public void setDVars() throws LpSolveException{
		Map<String, Dvar> DvarMap = SolverData.getDvarMap();
		Set DvarCollection = DvarMap.keySet();
		Iterator dvarIterator=DvarCollection.iterator();
		int ColNum = 1;

		while(dvarIterator.hasNext()){                          
			String dvarName=(String)dvarIterator.next();
			Dvar dvar=DvarMap.get(dvarName);
			
			double lb = dvar.lowerBoundValue.doubleValue();
			double ub = dvar.upperBoundValue.doubleValue();
			
			Model.setBounds(ColNum, lb, ub);
			if (dvar.integer.equals("y")){
				Model.setInt(ColNum, true); 
			}

			VarMap.put(dvarName, ColNum);
			ColNum++;
		}
		

	}

	public void setObjective() throws LpSolveException{
		Map<String, WeightElement> weightMap = SolverData.getWeightMap();
		Set weightCollection = weightMap.keySet();
		Iterator weightIterator = weightCollection.iterator();
		double[] weightArray = new double[weightCollection.size()];
		int[] colArray = new int[weightCollection.size()];		
		
		Map<String, WeightElement> weightSlackSurplusMap = SolverData.getWeightSlackSurplusMap();
		Set weightSlackSurplusCollection = weightSlackSurplusMap.keySet();
		Iterator weightSlackSurplusIterator = weightSlackSurplusCollection.iterator();
		double[] weightSlackSurplusArray = new double[weightSlackSurplusCollection.size()];
		int[] colArray2 = new int[weightSlackSurplusCollection.size()];
		
		double[] weightArrayCombined = new double[weightCollection.size()+weightSlackSurplusCollection.size()];
		int[] colArrayCombined = new int[weightCollection.size()+weightSlackSurplusCollection.size()];
		
		int counter = 0;
		int counter2 = 0;
		
		while(weightIterator.hasNext()){
			String weightName=(String)weightIterator.next();
			weightArray[counter]=weightMap.get(weightName).getValue();
			colArray[counter]=VarMap.get(weightName);
			counter++;
		}
		while(weightSlackSurplusIterator.hasNext()){
			String weightSlackSurplusName=(String)weightSlackSurplusIterator.next();
			weightSlackSurplusArray[counter2]=weightSlackSurplusMap.get(weightSlackSurplusName).getValue();
			colArray2[counter2]=counter+1;
			VarMap.put(weightSlackSurplusName, counter+1);
			counter++;
			counter2++;
		}
		
		Model.setObjFnex(weightArrayCombined.length, weightArrayCombined, colArrayCombined);
	}
	
	private void setConstraints() throws LpSolveException {
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		Set constraintCollection = constraintMap.keySet();
		Iterator constraintIterator = constraintCollection.iterator();
		int [] constraintNum2;
		String outConstraint = null;
		while(constraintIterator.hasNext()){
			String constraintName=(String)constraintIterator.next();
			EvalConstraint ec=constraintMap.get(constraintName);
			HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
			Set multCollection = multMap.keySet();
			Iterator multIterator = multCollection.iterator();
			int colNum = 0;
		    addConstraint = new double[multCollection.size()];
		    int slackNum = 0;
		    constraintNum = new int[multCollection.size()];
		    outConstraint = (String) constraintIterator.next() + ": ";
		    	
			while(multIterator.hasNext()){
				String multName=(String)multIterator.next();
				double coef=multMap.get(multName).getData().doubleValue();
				addConstraint[colNum]= coef;
				if (VarMap.keySet().contains(multName)){
					constraintNum[colNum]=VarMap.get(multName);
					outConstraint = outConstraint + " ";
				}
				
				colNum++;
				
			}
			_lpsolveFile.println(outConstraint);
			
			Map<String, Dvar> DvarMap = SolverData.getDvarMap();
			Set DvarCollection = DvarMap.keySet();
			Iterator dvarIterator=DvarCollection.iterator();
			
			if (ec.getSign().equals("=")) {		
				Model.addConstraintex(addConstraint.length,addConstraint,constraintNum,Model.EQ,-ec.getEvalExpression().getValue().getData().doubleValue()); //LE(1); GE(2): EQ(3)
			}
			else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
				Model.addConstraintex(addConstraint.length,addConstraint,constraintNum,Model.LE,-ec.getEvalExpression().getValue().getData().doubleValue());
			}
			else if (ec.getSign().equals(">") || ec.getSign().equals(">=")){
				Model.addConstraintex(addConstraint.length,addConstraint,constraintNum,Model.GE,-ec.getEvalExpression().getValue().getData().doubleValue());
			}
		}
	}
	
	public void assignDvar() throws LpSolveException{
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Map<String, Map<String, IntDouble>> varTimeArrayCycleValueMap=ControlData.currStudyDataSet.getVarTimeArrayCycleValueMap();
		Set<String> dvarUsedByLaterCycle = ControlData.currModelDataSet.dvarUsedByLaterCycle;
		Set<String> dvarTimeArrayUsedByLaterCycle = ControlData.currModelDataSet.dvarTimeArrayUsedByLaterCycle;
		String model=ControlData.currCycleName;
			
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			double[] var = Model.getPtrVariables();
			double value=var[VarMap.get(dvName)-1]; 
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
			dataList[ControlData.currTimeStep]=value;
		}
		
		if (ControlData.showRunTimeMessage) System.out.println("Assign Dvar Done.");
	}
	
	private void Output() throws  LpSolveException{
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		
		Map<String, WeightElement> weightSlackSurplusMap = SolverData.getWeightSlackSurplusMap();
		Set weightSlackSurplusCollection = weightSlackSurplusMap.keySet();
		Iterator weightSlackSurplusIterator = weightSlackSurplusCollection.iterator();
		
		double[] var = Model.getPtrVariables();
				
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
		}

		while(weightSlackSurplusIterator.hasNext()){
			String weightSlackSurplusName=(String)weightSlackSurplusIterator.next();
			double value=var[VarMap.get(weightSlackSurplusName)]; 
			
			System.out.print("The Answer " + weightSlackSurplusName + ": " + VarMap.get(weightSlackSurplusName) + " " + value +"\n");
		}
	}
}
