package wrimsv2.solver;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import org.coinor.cbc.SWIGTYPE_p_std__string;
import org.coinor.cbc.SWIGTYPE_p_CbcModel;
import org.coinor.cbc.SWIGTYPE_p_CoinModel;
import org.coinor.cbc.SWIGTYPE_p_OsiClpSolverInterface;
import org.coinor.cbc.jCbc;
import org.coinor.cbc.SWIGTYPE_p_double;
import org.coinor.cbc.SWIGTYPE_p_int;
import org.coinor.clp.jClp;

import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.commondata.solverdata.*;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.ilp.ILP;
import wrimsv2.tools.InfeasibilityAnalysis;
import wrimsv2.wreslplus.elements.Tools;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;



public class CbcSolver {
	
	public static LinkedHashMap <String, Double> varDoubleMap;
	
	private static SWIGTYPE_p_OsiClpSolverInterface solver; // = jCbc.new_jOsiClpSolverInterface(); //this is our LP solver!
	private static SWIGTYPE_p_CbcModel model; // = jCbc.new_jCbcModel();// This defines a new empty CbcModel
	private static SWIGTYPE_p_CoinModel modelObject; 

	private static Map<String, String> iisPossibleConstraintMap;
	private static Map<String, String> iisPossibleConstraintMap_cumulative;
	private static Set<String> iisConfirmConstraint;
	public static Set<String> prioritizeSearchTheseConstraints;
	private static boolean hasPriorityConstraints = false; // will be assigned to true if above set is not empty.
	private static Set<String> _pstc;
	private static int total_relaxed_constraints = 0;
	
	//private static LinkedHashSet<String> iisReport;
	private static LinkedHashMap<Integer, String> iisSlackMap;
	private static LinkedHashMap<String, String> iisConstraintSignMap;
	private static LinkedHashMap<String, Double> iisConstraintRHSMap;
	private static LinkedHashMap<String, int[]> iisConstraintIndexMap;
	private static LinkedHashMap<String, double[]> iisConstraintElementMap;
	private static ArrayList<String> iisSlacks;
	//private static ArrayList<String> iisDvarList;
	public static double cbcHintRelaxPenalty = 9000;
	
	private static  Map<String, Dvar> dvarMap;
	private static BiMap<Integer, String> dvBiMap;
	private static BiMap<String, Integer> dvBiMapInverse;
	
	private static  double maxValue = 1e28; //Double.POSITIVE_INFINITY;
	//public static final double zeroTolerence =  1e-10;
	public static double solve_2_primalT =  1e-9;        // can read from config cbcTolerancePrimal
	public static double solve_2_primalT_relax =  1e-7;  // can read from config cbcTolerancePrimalRelax
	//public static final double solve_2_primalT_relax_most =  1e-4;
	private static final double solve_3_primalT =  1e-9;
	//public static final double solve_3_primalT_relax =  1e-7;
	public static double solve_whs_primalT =  1e-9;      // can read from config cbcToleranceWarmPrimal
	//public static final Integer cutoff_n =  12;
	public static double integerT =  1e-9;               // can read from config cbcToleranceInteger
	public static double integerT_check = 1e-8;          // can read from config cbcToleranceIntegerCheck
	public static final double cbcWriteLpEpsilon = 1e-15; 	
	public static String cbcLibName = "jCbc_v2.9.8.1";
	public static int cbcHintTimeMax = 100; // can read from config CbcHintTimeMax
	private static String modelName;
	
	private static Map<String, WeightElement> wm2; 
	
	private static boolean useLpFile=false;
	
	private static int index[];
	private static double elements[];
	
	private static boolean saveWarm=false;
	private static boolean useWarm=false;
	private static final boolean saveIntVars=true;
	//private static boolean delWarm=false;

	private static LinkedHashMap<String, Integer> dvIntMap;
	
	private static SWIGTYPE_p_std__string names;
	private static SWIGTYPE_p_int values;
	private static int intSolSize=0;
	private static boolean warmArrayExist = false;
	
	private static SWIGTYPE_p_std__string names_eachTS;
	private static SWIGTYPE_p_int values_eachTS;
	private static int intSolSize_eachTS=0;
	private static boolean warmArrayExist_eachTS = false;
	
	private static SWIGTYPE_p_std__string names_dummy;
	private static SWIGTYPE_p_int values_dummy;

	// record max(cbc_obj - xa_obj) &  max(xa_obj - cbc_obj)
	public static double maxObjDiff=0;
	public static String maxObjDiff_id="";
	public static double maxObjDiff_minus=0;
	public static String maxObjDiff_minus_id="";
	private static HashSet originalDvarKeys=null;
	
	public static String solveName="";
	public static boolean logObj=false;
	public static boolean intLog=true;
	public static boolean intViolation=false;
	
	public static int solvFunc = 90; // default 
	public static int warm_2nd_solvFunc = 20; // default 
	
	//public static final int solv0 =  0;
	public static final int solv2 = 20;
	public static final int solv3 = 30;
	public static final int solvCallCbc = 50;
	public static final int solvFull = 90;
	public static final int solvU = 100;
	private static boolean next_possible_stuck=false;
	
	// record lp
	public static double record_if_obj_diff = 10000.0;
	public static double log_if_obj_diff = 500.0;
	
	public static final HashMap<Integer, String> solve_u_ret = new HashMap<Integer, String>() {{
	    put(6,"whs");put(5,"2__");put(4,"2_r");put(1,"inf");
	}};
	
	
	private CbcSolver(){}
	
	public static void init(boolean useLpFile, StudyDataSet sds){
		//useLpFile=false;
		CbcSolver.useLpFile = useLpFile;
		System.loadLibrary(cbcLibName);
		ILP.getIlpDir();
		ILP.createNoteFile();
		
		//if (ControlData.useCbcWarmStart || ControlData.cbc_debug_routeCbc || ControlData.cbc_debug_routeXA){
			dvIntMap = new LinkedHashMap<String, Integer>();
			for (String d: sds.allIntDv){
				dvIntMap.put(d, 0);
			}
		//}
		
		names_dummy = jCbc.new_jarray_string(0); 
		values_dummy = jCbc.new_jarray_int(0); 
		
		if (!useLpFile) dvBiMap = HashBiMap.create();
		
		//solver = jCbc.new_jOsiClpSolverInterface(); //this is our LP solver!
	
	}

	public static void close(){

	}
	
	public static void newProblem(){
		//System.out.println(" current cycle: "+ControlData.currCycleIndex);
		if (ControlData.useCbcWarmStart) {
			if (ControlData.cycWarmStart!=null){
				if (ControlData.cycWarmStart.contains(ControlData.currCycleIndex)) {
					saveWarm = true;
				} else {
					saveWarm = false;
				}
				if (ControlData.cycWarmUse.contains(ControlData.currCycleIndex)) {
					useWarm = true;
				} else {
					useWarm = false;
				}
			}
		}
		
		
		modelName = ILP.getYearMonthCycle();
		
		ControlData.clp_cbc_objective = null;
		
		long beginT_creation = System.currentTimeMillis();	
		
		model = jCbc.new_jCbcModel();
		solver = jCbc.new_jOsiClpSolverInterface(); //this is our LP solver!
		jCbc.assignSolver(model,solver); // Assign the solver to CbcModel
		
		if (useLpFile) {
					
			jCbc.readLp(solver, ILP.cplexLpFilePath);
			
		} else {
			
			int sizeA = ControlData.currModelDataSet.dvList.size();
			int sizeB = ControlData.currModelDataSet.dvTimeArrayList.size();

			for (int i=0; i<sizeA; i++){
				dvBiMap.put(i,ControlData.currModelDataSet.dvList.get(i));				
			}
			for (int i=0; i<sizeB; i++){
				dvBiMap.put(i+sizeA,ControlData.currModelDataSet.dvTimeArrayList.get(i));				
			}
			dvBiMapInverse = dvBiMap.inverse();
			
			originalDvarKeys = new HashSet<String>(SolverData.getDvarMap().keySet());
			
			dvarMap = SolverData.getDvarMap();
			wm2 = SolverData.getWeightSlackSurplusMap();

			modelObject = jCbc.new_jCoinModel();

			setDVars(ControlData.cbcLogNativeLp);
			setConstraints(ControlData.cbcLogNativeLp);
			if (ControlData.cbcLogNativeLp) {writeCbcLp("native", false);}

		}
		long endT_creation = System.currentTimeMillis();	
		double time_second_creation = (endT_creation-beginT_creation)/1000.;
		ControlData.solverCreationTime_cbc += time_second_creation; 
		
		jCbc.setModelName(solver, modelName);
		
//		if (next_possible_stuck) {
//
//			reloadAndWriteLp("stuck_possible",true);
//			
//		} 
		//jCbc.writeLp1(model, "test", 1e-14, 14);
		long beginT = System.currentTimeMillis();
		int[] modelStatus = solve();
		long endT = System.currentTimeMillis();
		
		double time_second = (endT-beginT)/1000.;
		
		if (Error.error_solving.size()<1) {
						
			ControlData.clp_cbc_objective = getObjValue();
			
			if (CbcSolver.logObj){
				ILP.writeNoteLn(ILP.getYearMonthCycle(), ""+ControlData.clp_cbc_objective, ILP._noteFile_cbc_obj);
			}
			long beginT_cd = System.currentTimeMillis();
			varDoubleMap = new LinkedHashMap<String, Double>();
			dvIntMap = new LinkedHashMap<String, Integer>();
			collectDvar(); 
			boolean intErr = false;
			// check integer violation
			for (String k:dvIntMap.keySet()){
				//System.out.println(k);
				if (varDoubleMap.containsKey(k)){
					double v = varDoubleMap.get(k);
					if (Math.abs(v-Math.round(v))>integerT_check){
						intErr = true;
						Error.addSolvingError("int violation:::"+k+":"+v);
					} 
				}
			}
			if (intErr){reloadAndWriteLp("_intViolation", true, true);
			Error.addSolvingError("Integer Violation! Please contact developers for this issue.");}
			
			boolean lowerboundErr = false;			
			// check dv lowerbound violation (only for lowerbound =0)
			double t = solve_2_primalT_relax*10; //solve_2_primalT;
//			if (Objects.equals(solveName,"whs"))      { t = solve_whs_primalT; }
//			else if (Objects.equals(solveName,"2R_")) { t = solve_2_primalT_relax; } 
			
			Map<String, Dvar> dMap = SolverData.getDvarMap();
			for (String k:dMap.keySet()){
				if (varDoubleMap.containsKey(k)){
					Dvar d = dMap.get(k);
					double v = varDoubleMap.get(k);
				
					if (d.lowerBoundValue.doubleValue() == 0 &&  v<-t){
						lowerboundErr = true;
						Error.addSolvingError("lowerbound violation:::"+k+":"+v);
					} 
				}
			}
			if (lowerboundErr){reloadAndWriteLp("_lbViolation", true, true);
			Error.addSolvingError("Lowerbound Violation! Please contact developers for this issue.");}

			
			long beginT_ad = System.currentTimeMillis();	
			if (!ControlData.cbc_debug_routeXA) assignDvar();
			long endT_ad = System.currentTimeMillis();	
			ControlData.cdTime += (beginT_ad-beginT_cd)/1000.;
			ControlData.adTime += (endT_ad-beginT_ad)/1000.;
		}
		
//		if (time_second > 4.0) {
//
//			reloadAndWriteLp("stuck_"+Math.round(time_second),true);
//			
//			ILP.writeNoteLn(modelName, " time(sec): "+time_second);
//			System.out.println(modelName+": "+time_second);
//			next_possible_stuck=true;
//			
//		} else {
//			
//			next_possible_stuck=false;
//		}
		
	}
	
	public static double getObjValue(){
		return jCbc.getObjValue(model)*-1;
	}

	private static void reloadProblem(boolean isNoteCbc) {


		// restore original state
		SolverData.getDvarMap().keySet().retainAll(originalDvarKeys);
		int sizeA = ControlData.currModelDataSet.dvList.size();
		int sizeB = ControlData.currModelDataSet.dvTimeArrayList.size();
		dvBiMap.clear();
		for (int i=0; i<sizeA; i++){
			dvBiMap.put(i,ControlData.currModelDataSet.dvList.get(i));				
		}
		for (int i=0; i<sizeB; i++){
			dvBiMap.put(i+sizeA,ControlData.currModelDataSet.dvTimeArrayList.get(i));				
		}
		dvBiMapInverse = dvBiMap.inverse();
		
		
		
		// clean up
		jCbc.delete_jCbcModel(model);
		model = null;
		jCbc.delete_jCoinModel(modelObject);
		//ControlData.clp_cbc_objective=null;
		
		
		// new model
		model = jCbc.new_jCbcModel();
		solver = jCbc.new_jOsiClpSolverInterface(); 
		jCbc.assignSolver(model,solver); 
		modelObject = jCbc.new_jCoinModel();

		setDVars(isNoteCbc);
		setConstraints(isNoteCbc);
		jCbc.setModelName(solver, modelName);
		
	}
	
	private static void reloadProblemConfirm(String skipThisConstraint) {

		// restore original state
		SolverData.getDvarMap().keySet().retainAll(originalDvarKeys);
		int sizeA = ControlData.currModelDataSet.dvList.size();
		int sizeB = ControlData.currModelDataSet.dvTimeArrayList.size();
		dvBiMap.clear();
		for (int i=0; i<sizeA; i++){
			dvBiMap.put(i,ControlData.currModelDataSet.dvList.get(i));				
		}
		for (int i=0; i<sizeB; i++){
			dvBiMap.put(i+sizeA,ControlData.currModelDataSet.dvTimeArrayList.get(i));				
		}
		dvBiMapInverse = dvBiMap.inverse();
		
		// clean up
		jCbc.delete_jCbcModel(model);
		model = null;
		jCbc.delete_jCoinModel(modelObject);
		
		// new model
		model = jCbc.new_jCbcModel();
		solver = jCbc.new_jOsiClpSolverInterface(); 
		jCbc.assignSolver(model,solver); 
		modelObject = jCbc.new_jCoinModel();

		setDVarsIIS();
		setConstraintsSkip(skipThisConstraint);
		jCbc.setModelName(solver, modelName);
		
	}
	
	private static void loadProblemIIS(boolean isFirstTimeRun, Set<String> enforceThisConstraint) {
		
		iisSlackMap = new LinkedHashMap<Integer, String>();
		// restore original state
		SolverData.getDvarMap().keySet().retainAll(originalDvarKeys);
		int sizeA = ControlData.currModelDataSet.dvList.size();
		int sizeB = ControlData.currModelDataSet.dvTimeArrayList.size();
		dvBiMap.clear();
		for (int i=0; i<sizeA; i++){
			dvBiMap.put(i,ControlData.currModelDataSet.dvList.get(i));				
		}
		for (int i=0; i<sizeB; i++){
			dvBiMap.put(i+sizeA,ControlData.currModelDataSet.dvTimeArrayList.get(i));				
		}
		dvBiMapInverse = dvBiMap.inverse();
		
		
		
		// clean up
		jCbc.delete_jCbcModel(model);
		model = null;
		jCbc.delete_jCoinModel(modelObject);
		//ControlData.clp_cbc_objective=null;
		
		
		// new model
		model = jCbc.new_jCbcModel();
		solver = jCbc.new_jOsiClpSolverInterface(); 
		jCbc.assignSolver(model,solver); 
		modelObject = jCbc.new_jCoinModel();

		setDVarsIIS();
		setConstraintsIIS(isFirstTimeRun, enforceThisConstraint);
		jCbc.setModelName(solver, modelName+"_iis");
		
	}
	
	public static void resetModel() {

		jCbc.delete_jCbcModel(model);
		model = null;
				
		if (!useLpFile) {
			jCbc.delete_jCoinModel(modelObject);
			dvBiMap.clear();
			dvBiMapInverse.clear();
		}

	}

	private static void getSolverInformation(int status, int status2){
		
		// status
//		 0 if finished (which includes the case when the algorithm is finished because it has been proved infeasible), 
//		 1 if stopped by user, and 
//		 2 if difficulties arose.	
		
		switch (status){
			case 0: Error.addSolvingError("Infeasible.");break; 
			case 1: Error.addSolvingError("Stopped by user.");break; 
			case 2: Error.addSolvingError("Other errors."); break;
			default: Error.addSolvingError("Status:"+status); break;
		}
		
		// secondaryStatus	 
//		0 search completed with solution
//		1 linear relaxation not feasible
//		2 stopped on gap
//		3 stopped on nodes
//		4 stopped on time
//		5 stopped on user event
//		6 stopped on solutions
//		7 linear relaxation unbounded
		
		switch (status2){
			case 1: Error.addSolvingError("Linear relaxation not feasible.");break; 
			case 2: Error.addSolvingError("Stopped on gap.");break; 
			case 3: Error.addSolvingError("Stopped on nodes."); break;
			case 4: Error.addSolvingError("Stopped on time."); break;
			case 5: Error.addSolvingError("Stopped on user event."); break;
			case 6: Error.addSolvingError("Stopped on solutions."); break;
			case 7: Error.addSolvingError("Linear relaxation unbounded."); break;
			default: Error.addSolvingError("Status2:"+status2); break;
		}
	}
	
	private static void setConstraints(boolean isNoteCbc) {
		if (ControlData.showRunTimeMessage) System.out.println("CBC Solver: Setting constraints");
		
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		String c="quicklog version 1.0\n";
		int rowCounter=0; // row index
		for (int i=0; i<=1; i++){
			ArrayList<String> constraintCollection;
			if (i==0){
				constraintCollection = new ArrayList<String>(ControlData.currModelDataSet.gList);
				constraintCollection.retainAll(constraintMap.keySet());
			}else{
				constraintCollection = new ArrayList<String>(ControlData.currModelDataSet.gTimeArrayList);
			}
			Iterator<String> constraintIterator = constraintCollection.iterator();
		
			
			while(constraintIterator.hasNext()){        
				
				double GT=-999;
				double LT= 999;
				
				
				String constraintName=(String)constraintIterator.next();
				EvalConstraint ec=constraintMap.get(constraintName);
			
				if (ec.getSign().equals("=")) {
					GT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(GT)<ControlData.zeroTolerance) {GT=0;} 
					else if (Math.abs(GT)>maxValue) {GT=maxValue*Math.signum(GT);}
					LT = GT;
				}
				else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
					GT = -maxValue;
					LT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(LT)<ControlData.zeroTolerance) {LT=0;} 
					else if (Math.abs(LT)>maxValue) {LT=maxValue*Math.signum(LT);}
				}
				else if (ec.getSign().equals(">")){
					GT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(GT)<ControlData.zeroTolerance) {GT=0;} 
					else if (Math.abs(GT)>maxValue) {GT=maxValue*Math.signum(GT);}
					LT = maxValue;
				}
				else {
					// error!!
					System.out.println("error in CbcSolver!");
				}
			
				HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
				Set multCollection = multMap.keySet();
				Iterator multIterator = multCollection.iterator();				
				
				index = new int[multMap.keySet().size()];	
				elements = new double[multMap.keySet().size()];	
				
				int j=0;
				while(multIterator.hasNext()){
					String multName=(String)multIterator.next();
										
					if (!dvarMap.containsKey(multName)){ 
						int sizeDv = dvBiMap.size();
						dvBiMap.put(sizeDv, multName);
						dvBiMapInverse.put(multName, sizeDv);
						
						addConditionalSlackSurplusToDvarMap(dvarMap, multName, isNoteCbc);
					
					}					
					
					index[j]=dvBiMapInverse.get(multName);
					double temp = multMap.get(multName).getData().doubleValue();
					if(Math.abs(temp)<ControlData.zeroTolerance) {temp=0;} 
					elements[j]=temp;
					
					j++;
				}

				jCbc.addRow(modelObject,multMap.keySet().size(), index, elements, GT, LT, constraintName);
				
				
			    if (isNoteCbc) {
			    			
					    	c = c + constraintName +","+GT+","+LT+","+multMap.keySet().size()+","+Arrays.toString(index)+","+Arrays.toString(elements)+"\n"; 					 
			    }
				rowCounter++; 
				
			}
		}
		
		 jCbc.addRows(solver,modelObject);
		 if (isNoteCbc) Tools.quickLog(modelName+"_"+solveName+".rows", c);
	}
	
	private static void setConstraintsSkip(String skipThisConstraint) {
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		
		int rowCounter=0; // row index
		for (int i=0; i<=1; i++){
			ArrayList<String> constraintCollection;
			if (i==0){
				constraintCollection = new ArrayList<String>(ControlData.currModelDataSet.gList);
				constraintCollection.retainAll(constraintMap.keySet());
			}else{
				constraintCollection = new ArrayList<String>(ControlData.currModelDataSet.gTimeArrayList);
			}
			Iterator<String> constraintIterator = constraintCollection.iterator();
		
			
			while(constraintIterator.hasNext()){        
				
				double GT=-999;
				double LT= 999;
				
				
				String constraintName=(String)constraintIterator.next();
				EvalConstraint ec=constraintMap.get(constraintName);
			
				if (ec.getSign().equals("=")) {
					GT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(GT)<ControlData.zeroTolerance) {GT=0;} 
					LT = GT;
				}
				else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
					GT = -maxValue;
					LT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(LT)<ControlData.zeroTolerance) {LT=0;} 
				}
				else if (ec.getSign().equals(">")){
					GT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(GT)<ControlData.zeroTolerance) {GT=0;} 
					LT = maxValue;
				}
				else {
					// error!!
					System.out.println("error in CbcSolver!");
				}
			
				HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
				Set multCollection = multMap.keySet();
				Iterator multIterator = multCollection.iterator();				
				
				index = new int[multMap.keySet().size()];	
				elements = new double[multMap.keySet().size()];	
				
				int j=0;
				while(multIterator.hasNext()){
					String multName=(String)multIterator.next();
										
					if (!dvarMap.containsKey(multName)){ 
						int sizeDv = dvBiMap.size();
						dvBiMap.put(sizeDv, multName);
						dvBiMapInverse.put(multName, sizeDv);
						
						addConditionalSlackSurplusToDvarMap(dvarMap, multName, false);
					
					}					
					
					index[j]=dvBiMapInverse.get(multName);
					double temp = multMap.get(multName).getData().doubleValue();
					if(Math.abs(temp)<ControlData.zeroTolerance) {temp=0;} 
					elements[j]=temp;
					
					j++;
				}
				if(!skipThisConstraint.equalsIgnoreCase(constraintName)){
					jCbc.addRow(modelObject,multMap.keySet().size(), index, elements, GT, LT, constraintName);
				}
				rowCounter++; 
				
			}
		}
		
		 jCbc.addRows(solver,modelObject);
	}
	
	private static void setConstraintsIIS(boolean firstTimeRun, Set<String> enforceThisConstraint) {
		
		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
		int total=0;
		for (int i=0; i<=1; i++){
			ArrayList<String> constraintCollection;
			if (i==0){
				constraintCollection = new ArrayList<String>(ControlData.currModelDataSet.gList);
				constraintCollection.retainAll(constraintMap.keySet());
			}else{
				constraintCollection = new ArrayList<String>(ControlData.currModelDataSet.gTimeArrayList);
			}
			Iterator<String> constraintIterator = constraintCollection.iterator();
		
			
			while(constraintIterator.hasNext()){        total++;
				
				double GT=-999;
				double LT= 999;
				
				String constraintName=(String)constraintIterator.next();
				EvalConstraint ec=constraintMap.get(constraintName);
			
				if (ec.getSign().equals("=")) {
					GT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(GT)<ControlData.zeroTolerance) {GT=0;} 
					LT = GT;
				}
				else if (ec.getSign().equals("<") || ec.getSign().equals("<=")){
					GT = -maxValue;
					LT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(LT)<ControlData.zeroTolerance) {LT=0;} 
				}
				else if (ec.getSign().equals(">")){
					GT = -ec.getEvalExpression().getValue().getData().doubleValue();
					if(Math.abs(GT)<ControlData.zeroTolerance) {GT=0;} 
					LT = maxValue; 
				}
				else {
					// error!!
					ILP.writeNoteLn("Error in CbcSolver constraint processing!",true,true);
				}
			
				HashMap<String, IntDouble> multMap = ec.getEvalExpression().getMultiplier();
				Set multCollection = multMap.keySet();
				Iterator multIterator = multCollection.iterator();				
				
				index = new int[multMap.keySet().size()+2];	
				elements = new double[multMap.keySet().size()+2];	
				
				int j=0;
				while(multIterator.hasNext()){
					String multName=(String)multIterator.next();
										
					if (!dvarMap.containsKey(multName)){ 
						int sizeDv = dvBiMap.size();
						dvBiMap.put(sizeDv, multName);
						dvBiMapInverse.put(multName, sizeDv);
						
						addConditionalSlackSurplusToDvarMap(dvarMap, multName, false);
					
					}					
					
					index[j]=dvBiMapInverse.get(multName);
					double temp = multMap.get(multName).getData().doubleValue();
					if(Math.abs(temp)<ControlData.zeroTolerance) {temp=0;} 
					elements[j]=temp;
					
					j++;
				}

				if (firstTimeRun) {
					int[] newIndex = Arrays.copyOfRange(index, 0, index.length - 2);
					double[] newElements = Arrays.copyOfRange(elements, 0, elements.length - 2);
					iisConstraintIndexMap.put(constraintName, newIndex);
					iisConstraintElementMap.put(constraintName, newElements);
					iisConstraintSignMap.put(constraintName, ec.getSign());
					iisConstraintRHSMap.put(constraintName, -ec.getEvalExpression().getValue().getData().doubleValue());
				}
				// TODO: add index and elements here for IIS
				String iisNameP = constraintName + "_p";
				String iisNameN = constraintName + "_n";
				
				double coef = 1;

				if (hasPriorityConstraints && _pstc.size()>0) {
					coef = 0;
					if (_pstc.contains(constraintName)){ coef = 1; }
				}
				
				if (enforceThisConstraint.contains(constraintName)){ coef = 0; }	
					
				int z = dvBiMap.size();
				
				dvBiMap.put(z, iisNameP);
				dvBiMapInverse.put(iisNameP, z);
				index[j] = dvBiMapInverse.get(iisNameP);
				elements[j] = coef;
				j++;				
				iisSlackMap.put(z, constraintName);
				//iisC
				jCbc.addCol(modelObject, 0, maxValue, cbcHintRelaxPenalty, iisNameP, false); 
				
				dvBiMap.put(z+1, iisNameN);
				dvBiMapInverse.put(iisNameN, z+1);
				index[j] = dvBiMapInverse.get(iisNameN);
				elements[j] = -coef;
				j++;				
				iisSlackMap.put(z+1, constraintName);
				jCbc.addCol(modelObject, 0, maxValue, cbcHintRelaxPenalty, iisNameN, false); 
				
				
				jCbc.addRow(modelObject,multMap.keySet().size()+2, index, elements, GT, LT, constraintName);
				
			}
		}
		
		 jCbc.addRows(solver,modelObject); total_relaxed_constraints = total;
	}
    
	private static void setDVars(boolean isNoteCbc) {
		if (ControlData.showRunTimeMessage) System.out.println("CBC Solver: Setting dvars");
		
		Map<String, WeightElement> wm1  = SolverData.getWeightMap();
		String c="quicklog version 1.0\n";
		for (int i=0; i<dvBiMap.size(); i++){
			String dvName = dvBiMap.get(i);
			Dvar dvObj = dvarMap.get(dvName);
			
			double w = 0;
			if (wm1.keySet().contains(dvName)){
				w = -wm1.get(dvName).getValue();
			
			}
			//System.out.println("weight of: "+dvName+"="+w);
		    jCbc.addCol(modelObject , dvObj.lowerBoundValue.doubleValue(), dvObj.upperBoundValue.doubleValue(), w, dvName, dvObj.integer==Param.yes ); 
		    if (isNoteCbc) {

		    	int isInt=0;
		    	if (dvObj.integer==Param.yes) isInt=1;
		    	c = c + isInt+","+dvName+","+w+","+dvObj.lowerBoundValue.doubleValue()+","+dvObj.upperBoundValue.doubleValue()+"\n"; 
		    
		    }
		}
		if (isNoteCbc) Tools.quickLog(modelName+"_"+solveName+".cols", c);
		
	}
	
	private static void setDVarsIIS() {
		
		for (int i=0; i<dvBiMap.size(); i++){
			String dvName = dvBiMap.get(i);
			Dvar dvObj = dvarMap.get(dvName);
			
		    jCbc.addCol(modelObject , dvObj.lowerBoundValue.doubleValue(), dvObj.upperBoundValue.doubleValue(), 0, dvName, dvObj.integer==Param.yes ); 
			
		}
		
	}
	
	public static int[] solve(){
		int ci=ControlData.currCycleIndex+1;
		if (ControlData.showRunTimeMessage) System.out.println("CBC Solver: Solving "+ControlData.currMonth+"/"+ControlData.currDay+"/"+ControlData.currYear+" Cycle "+ci+" ["+ControlData.currCycleName+"]");
		
		int status=-99;
		int status2=-99;
		
		long beginT = System.currentTimeMillis();
	    	
		if (solvFunc == solvU){
			//solveName="U__";
			int ret = 0;
			if (useWarm || saveWarm) {
				int ii = ControlData.currCycleIndex + 1;
				//System.out.println(ii + ": use warm");

				if (warmArrayExist) {

					jCbc.delete_jarray_int(values);
					jCbc.delete_jarray_string(names);
					intSolSize = 0;
					values = null;
					names = null;
					warmArrayExist = false;
				}

				intSolSize = ControlData.currStudyDataSet.cycIntDvMap.get(ControlData.currCycleIndex).size();
				names = jCbc.new_jarray_string(intSolSize);
				values = jCbc.new_jarray_int(intSolSize);
				warmArrayExist = true;
				int k = 0;
				for (String dvN : ControlData.currStudyDataSet.cycIntDvMap.get(ControlData.currCycleIndex)) {
					jCbc.jarray_string_setitem(names, k, dvN);
					jCbc.jarray_int_setitem(values, k, dvIntMap.get(dvN));
					k++;
				}

				ret = jCbc.solve_unified(model, solver, names, values, intSolSize, 0);
				
			} else {
				//intSolSize = 0;
				ret = jCbc.solve_unified(model, solver, null, null, 0, 0);
			}

			//jCbc.setIntegerTolerance(model, integerT);
			//writeCbcLp("", true);
			//int ret = jCbc.solve_unified(model, solver, names, values, intSolSize, 0);
			solveName=solve_u_ret.get(ret);
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);
		
		} else if (solvFunc == solv2){
			solveName="2__";
			jCbc.setPrimalTolerance(model, solve_2_primalT);
			jCbc.setIntegerTolerance(model, integerT);
			jCbc.solve_2(model, solver, 0);	
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);
			
		} else if (solvFunc == solv3){
			solveName="3__";
			jCbc.setPrimalTolerance(model, solve_3_primalT);
			jCbc.setIntegerTolerance(model, integerT);
			jCbc.solve_3(model, solver, 0);		
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);
			
		} else if (solvFunc == solvCallCbc){
			solveName="cal";
			jCbc.setIntegerTolerance(model, integerT);
			jCbc.callCbc("-log 0 -solve", model);
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);
			
		} else if (solvFunc == solvFull){
			
		Set<String> a=ControlData.currStudyDataSet.cycIntDvMap.get(ControlData.currCycleIndex);
		a.retainAll(dvIntMap.keySet());
		if ((useWarm || saveWarm) && a.size()>2) {
//			int ii = ControlData.currCycleIndex+1;
//			System.out.println(ii+": useWarm:"+useWarm);
//			System.out.println(ii+": saveWarm:"+saveWarm);		
//			System.out.println(ii+":dvIntMap size: "+dvIntMap.size());
			if (warmArrayExist) {

				jCbc.delete_jarray_int(values);
				jCbc.delete_jarray_string(names);
				intSolSize = 0;
				values = null;
				names = null;
				warmArrayExist = false;
			}			
			
			intSolSize = ControlData.currStudyDataSet.cycIntDvMap.get(ControlData.currCycleIndex).size();
			names = jCbc.new_jarray_string(intSolSize);
			values = jCbc.new_jarray_int(intSolSize);
			warmArrayExist = true;
			int k=0;
			for (String dvN: ControlData.currStudyDataSet.cycIntDvMap.get(ControlData.currCycleIndex)){
				jCbc.jarray_string_setitem(names,k,dvN);
//				System.out.println("values:"+values);
//				System.out.println("k:"+k);
//				System.out.println("dvN:"+dvN);
//				System.out.println("dvIntMap.keySet():"+dvIntMap.keySet());
//				for (String x:dvIntMap.keySet()) {
//					System.out.println(x+":"+dvIntMap.get(x));
//				}
				jCbc.jarray_int_setitem(values,k,dvIntMap.get(dvN));
				k++;
			}
			
			solveName="whs";
			jCbc.setPrimalTolerance(model, solve_whs_primalT);
			jCbc.setIntegerTolerance(model, integerT);
			jCbc.solve_whs(model,solver,names,values,intSolSize,0);
						
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);		
			
			if (status != 0 || status2 != 0) {
				
				//note_msg(jCbc.getModelName(solver), " Warmstart infeasible");
				reloadProblem(true);	
				if (warm_2nd_solvFunc == solv2){
					//note_msg(jCbc.getModelName(solver), " Use solve_2");
					solve_2();
				} else if (warm_2nd_solvFunc == solv3){
					//note_msg(jCbc.getModelName(solver), " Use solve_3");
					solve_3();
				} else {
					System.out.println("Error in warm 2nd solve function.");
				}	
			}	
			
		} else {
			
			if (warm_2nd_solvFunc == solv2){
				solve_2();
			} else if (warm_2nd_solvFunc == solv3){
				solve_3();
			} else {
				System.out.println("Error in warm 2nd solve function.");
			}
		}

		status = jCbc.status(model);
		status2 = jCbc.secondaryStatus(model);

		if (status != 0 || status2 != 0) {
			note_msg(" Solve_"+solveName+" infeasible. Use solve_2 with primalT="+solve_2_primalT_relax);
			reloadProblem(false);
			solve_2(solve_2_primalT_relax, "2R_");	
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);
		}	

//		if (status != 0 || status2 != 0) {
//			//note_msg(jCbc.getModelName(solver), " Solve_"+solveName+" infeasible. Use solve_2 with primalT="+solve_2_primalT_relax_most);
//			reloadProblem();
//			solve_2(solve_2_primalT_relax);	
//			status = jCbc.status(model);
//			status2 = jCbc.secondaryStatus(model);
//		}	
		
//		if (status != 0 || status2 != 0) {
//			note_msg(jCbc.getModelName(solver), " Solve_"+solveName+" infeasible. Use callCbc -primalT 1e-9 -integerT 1e-9 ");
//			reloadProblem(false);
//			callCbc();	
//			status = jCbc.status(model);
//			status2 = jCbc.secondaryStatus(model);
//		}	
		
//		if (status != 0 || status2 != 0) {
//			note_msg(jCbc.getModelName(solver), " Solve_"+solveName+" infeasible. Use callCbc -primalT 1e-7 -integerT 1e-9 ");
//			reloadProblem(false);
//			callCbc_R();	
//			status = jCbc.status(model);
//			status2 = jCbc.secondaryStatus(model);
//		}	
		
		
		////// check for violation and re-solve with v2.10a
		int Err_int = 0; int Err_lb = 0;		
			if (status == 0 && status2 == 0) {

				int ColumnSize = jCbc.getNumCols(model);
				SWIGTYPE_p_double v_ary = jCbc.getColSolution(solver);
				Map<String, Dvar> dMap = SolverData.getDvarMap();
				double t = solve_2_primalT_relax *10; //solve_2_primalT;
				//if (Objects.equals(solveName,"whs"))      { t = solve_whs_primalT; }
				//else if (Objects.equals(solveName,"2R_")) { t = solve_2_primalT_relax; } 
				
				for (int j = 0; j < ColumnSize; j++){
					 //varDoubleMap.put(jCbc.getColName(model,j), jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j));
					double v = jCbc.jarray_double_getitem(v_ary,j);
					String k = jCbc.getColName(model,j);
					
					if (jCbc.isInteger(solver,j)==1) {	 	
						if (Math.abs(v-Math.round(v))>integerT_check){	
							Err_int = 1; 
							ILP.writeNoteLn(modelName+":"+" Solve_"+solveName+":intViolation:::"+k+":"+v, true, false);
							//reloadAndWriteLp("_intViolation", true); 
							//break;
						} 
					} 
					else {
		
						Dvar d = dMap.get(k);												
						if (d.lowerBoundValue.doubleValue() == 0 &&  v<-t){
							Err_lb = 1;
							ILP.writeNoteLn(modelName+":"+" Solve_"+solveName+":lbViolation:::"+k+":"+v, true, false);
							//reloadAndWriteLp("_lbViolation", true); 
							//break;
						} 						
						
					}					 
						 
				}					
				
			}
			
			if (Err_int>0 || Err_lb>0){
				
				
				reloadAndWriteLp("_lbViolation", true); 
				
			
				// TODO: make sure callCbc version the last number >= 1 otherwise there are violations!!!!!
				boolean isDllReload = false;
				note_msg(" Solve_"+solveName+" has violations. Use callCbc");

				reloadProblem(false);
				callCbc();	
				status = jCbc.status(model);
				status2 = jCbc.secondaryStatus(model);

			}	
		
		}
	  
		
		long endT = System.currentTimeMillis();

		double time_second = (endT - beginT) / 1000.;
		ControlData.solverTime_cbc += time_second;
		ControlData.solverTime_cbc_this = time_second;
		if (ControlData.writeCbcSolvingTime) ILP.writeNoteLn(jCbc.getModelName(solver), " "+ time_second);
		
		if (status != 0 || status2 != 0) {
			//System.out.println("hello");
			reloadAndWriteLp("_infeasible", true, true);
			getSolverInformation(status, status2);
			iis();
		}

		return new int[]{status, status2};
	    	
	}
	
	
	private static void iis() {
		// test
		// final String[] SET_VALUES = new String[]{ "from_omr_np", "compare_omr_p"  };
		// prioritizeSearchTheseConstraints = new LinkedHashSet<String>(Arrays.asList(SET_VALUES));
		// end test
int pp=0;
		iisConstraintIndexMap = new LinkedHashMap<String, int[]>();
		iisConstraintElementMap = new LinkedHashMap<String, double[]>();
		iisConstraintSignMap = new LinkedHashMap<String, String>();
		iisConstraintRHSMap = new LinkedHashMap<String, Double>();
		iisSlacks = new ArrayList<String>();
		iisPossibleConstraintMap = new LinkedHashMap<String, String>();
		iisPossibleConstraintMap_cumulative = new LinkedHashMap<String, String>();
		iisConfirmConstraint = new LinkedHashSet<String>();
		
		InfeasibilityAnalysis.procIfsFile();
		prioritizeSearchTheseConstraints=InfeasibilityAnalysis.constraintSet;
		if (prioritizeSearchTheseConstraints!=null && prioritizeSearchTheseConstraints.size()>0) {
			hasPriorityConstraints = true;
			_pstc = new LinkedHashSet<String>(prioritizeSearchTheseConstraints);
		}
	

		boolean isFirstTimeRun = true;
		boolean success = true;
		long ts = Calendar.getInstance().getTimeInMillis();
		int tr=0;
		boolean isConflictFound = false;
		
		while (success) {
			
			tr =(int) (Calendar.getInstance().getTimeInMillis()-ts)/1000;
			if (tr>CbcSolver.cbcHintTimeMax) {
				ILP.writeNoteLn("\r\nInfeasibility analysis stopped due to time limit exceeded.", true, true);
				break;}
			
			iisPossibleConstraintMap_cumulative.putAll(iisPossibleConstraintMap);

			if (hasPriorityConstraints) {				
				_pstc.removeAll(iisConfirmConstraint);
				if (_pstc.size()<1) {hasPriorityConstraints = false;}
				}
			iisPossibleConstraintMap.clear();
			iisConfirmConstraint.clear();
//					System.out.println(hasPriorityConstraints);
//					System.out.println(_pstc);					
			success = iisSolve(isFirstTimeRun, iisPossibleConstraintMap_cumulative.keySet());
			//isFirstTimeRun=false;
			
			if (hasPriorityConstraints) {
				if (!success || iisPossibleConstraintMap.size()<1){
					ILP.writeNoteLn("End priority search.",true,false);
					hasPriorityConstraints = false;
					_pstc = null;
					success = true;
					continue;
				}
			}
				
			if (!success || iisPossibleConstraintMap.size()<1) {
				ILP.writeNoteLn("Infeasibility analysis ended.", true, false);
				if (iisPossibleConstraintMap_cumulative.size()>0) {
					//if (true) {
					if (!isConflictFound) {
						// output unconfirmed hints
						ILP.writeNoteLn("The following constraints might cause infeasibility.", true, false);
						for (String c: iisPossibleConstraintMap_cumulative.keySet()){
							ILP.writeNoteLn(Tools.findGoalLocation(c)+" "+iisPossibleConstraintMap_cumulative.get(c),true,true);
						}
					}	
				}
				return;
			} else {
				ILP.writeNoteLn("Finding constraints that cause infeasibility...", true, false);
//				System.out.println("iisPossibleConstraintMap_cumulative.size():"+iisPossibleConstraintMap_cumulative.size());
//				System.out.println("iisPossibleConstraintMap.size():"+iisPossibleConstraintMap.size());
//				System.out.println("total_relaxed:"+total_relaxed_constraints);
			}
			
	
			for (String c : iisPossibleConstraintMap.keySet()){
				if(iisSolveConfirm(c)){
					isConflictFound = true;
					iisConfirmConstraint.add(c); //pp++; ILP.writeNoteLn("found:"+pp,true,true);
				}
			}
			
			if (iisConfirmConstraint.size()>0) {
				for (String c : iisConfirmConstraint){
						ILP.writeNoteLn(Tools.findGoalLocation(c)+" "+iisPossibleConstraintMap.get(c),true,true);
				}
			}
//			// test
//			if (iisPossibleConstraintMap.keySet().size()>0) {
//				ILP.writeNoteLn("\n@@all_relaxed_contraints:\n");
//				for (String c :  iisPossibleConstraintMap.keySet()){
//					ILP.writeNoteLn(iisPossibleConstraintMap.get(c),true,true);
//				}
//				ILP.writeNoteLn("",false,false);
//				for (String c :  iisPossibleConstraintMap.keySet()){
//					ILP.writeNoteLn(Tools.findGoalLocation(c)+" "+iisPossibleConstraintMap.get(c),true,true);
//				}	
//				ILP.writeNoteLn("",false,false);
//			}
//			// end test
			
		}
	}

	private static boolean iisSolveConfirm(String skipThisConstraint) {
		boolean success = false;

		reloadProblemConfirm(skipThisConstraint);
		//writeCbcLp("iisSolveConfirm", false);
		solve_3();
		int s = jCbc.status(model);
		int s2 = jCbc.secondaryStatus(model);

		if (s == 0 && s2 == 0) {
			success = true;
		} else {
			success = false;
		}

		return success;
	}
	
	private static boolean iisSolve(boolean isFirstTimeRun, Set<String> enforceThisConstraint) {
		boolean success = false;

		loadProblemIIS(isFirstTimeRun, enforceThisConstraint);
		//writeCbcLp("iisSolve", false);
		
		solve_2();
		int s = jCbc.status(model);
		int s2 = jCbc.secondaryStatus(model);

		if (s == 0 && s2 == 0) {
			for (int j : iisSlackMap.keySet()) {
				String name = iisSlackMap.get(j);
				String name2 = jCbc.getColName(model, j);
				// check if name matches
				if (!name2.substring(0, name2.length() - 2).equalsIgnoreCase(name)) {
					System.out.println("@@ " + jCbc.getColName(model, j));
					System.out.println("@@ " + name);
				} else {
					// check if solution not zero
					if (jCbc.jarray_double_getitem(jCbc.getColSolution(solver), j) > 0) {
						// print this constraint
						int[] index = iisConstraintIndexMap.get(name);
						double[] coeff = iisConstraintElementMap.get(name);
						String show = name + ": ";
						// for (int r=index.length-1;r>-1;r--){
						for (int r = 0; r < index.length; r++) {
							int k = index[r];
							String var = dvBiMap.get(k);
							double coef = coeff[r];
							if (r != 0) {
								if (coef >= 0) {
									show = show + " +";
								} else {
									show = show + " ";
								}
							}
							
							String coefPrint = "";

							if(coef==-1){
								coefPrint = "-";
							} else if(coef==1){
								coefPrint = "";
							} else {
								coefPrint = Tools.noZerofmt(coef);
							}
							show = show + coefPrint + " " + var;
						}
						show += " " + iisConstraintSignMap.get(name);
						show += " " + Tools.noZerofmt(iisConstraintRHSMap.get(name));
						iisPossibleConstraintMap.put(name, show);
					}
				}

			}
			success = true;
		} else {
			success = false;
		}

		return success;
	}

	private static void collectDvar() {
		if (ControlData.showRunTimeMessage) System.out.println("CBC Solver: Collecting dvars");
		
		int ColumnSize = jCbc.getNumCols(model);
		varDoubleMap = new LinkedHashMap<String, Double>();
		dvIntMap = new LinkedHashMap<String, Integer>();
				
		if (saveWarm||useWarm||saveIntVars) {
			//int ii = ControlData.currCycleIndex + 1;
			//System.out.println(ii + ": save warm");


			//int k = 0;
			for (int j = 0; j < ColumnSize; j++){
				 varDoubleMap.put(jCbc.getColName(model,j), jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j));
				 if (jCbc.isInteger(solver,j)==1) {
					dvIntMap.put(jCbc.getColName(model,j), (int)Math.round(jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j)));
					// System.out.println(jCbc.getColName(model,j)+":"+jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j));				 	//k++; 
				 }
			}
		} else {

			for (int j = 0; j < ColumnSize; j++){
				varDoubleMap.put(jCbc.getColName(model,j), jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j));
	
			}
		}

	}
	
	private static void assignDvar() {
		if (ControlData.showRunTimeMessage) System.out.println("CBC Solver: Assigning dvars\' values");
		
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Map<String, Map<String, IntDouble>> varTimeArrayCycleValueMap=ControlData.currStudyDataSet.getVarTimeArrayCycleValueMap();
		Set<String> dvarUsedByLaterCycle = ControlData.currModelDataSet.dvarUsedByLaterCycle;
		Set<String> dvarTimeArrayUsedByLaterCycle = ControlData.currModelDataSet.dvarTimeArrayUsedByLaterCycle;
		ArrayList<String> timeArrayDvList = ControlData.currModelDataSet.timeArrayDvList;
		String modelName=ControlData.currCycleName;
		
		StudyDataSet sds = ControlData.currStudyDataSet;
		ArrayList<String> varCycleIndexList = sds.getVarCycleIndexList();
		ArrayList<String> dvarTimeArrayCycleIndexList = sds.getDvarTimeArrayCycleIndexList();
		Map<String, Map<String, IntDouble>> varCycleIndexValueMap = sds.getVarCycleIndexValueMap();
		
		Map<String, Dvar> dvarMap = SolverData.getDvarMap();
			
		HashSet<String> extraDv = new HashSet<String>(dvarMap.keySet());
		extraDv.removeAll(varDoubleMap.keySet());

		for (String dvName: extraDv) {
			Dvar dvar = dvarMap.get(dvName);
			double value=0;
			if (dvar.lowerBoundValue.doubleValue()>0) { value = dvar.lowerBoundValue.doubleValue();}
			varDoubleMap.put(dvName, value);
			IntDouble id = new IntDouble(value, false);
			dvar.setData(id);
			if(dvarUsedByLaterCycle.contains(dvName)){
				varCycleValueMap.get(dvName).put(modelName, id);
			}else if (dvarTimeArrayUsedByLaterCycle.contains(dvName)){
				if (varTimeArrayCycleValueMap.containsKey(dvName)){
					varTimeArrayCycleValueMap.get(dvName).put(modelName, dvar.data);
				}else{
					Map<String, IntDouble> cycleValue = new HashMap<String, IntDouble>();
					cycleValue.put(modelName, dvar.data);
					varTimeArrayCycleValueMap.put(dvName, cycleValue);
				}
			}
			if (varCycleIndexList.contains(dvName) || dvarTimeArrayCycleIndexList.contains(dvName)){
				if (varCycleIndexValueMap.containsKey(dvName)){
					varCycleIndexValueMap.get(dvName).put(modelName, dvar.data);
				}else{
					Map<String, IntDouble> cycleValue = new HashMap<String, IntDouble>();
					cycleValue.put(modelName, dvar.data);
					varCycleIndexValueMap.put(dvName, cycleValue);
				}
			}
			String entryNameTS=DssOperation.entryNameTS(dvName, ControlData.timeStep);
			DataTimeSeries.saveDataToTimeSeries(dvName, entryNameTS, value, dvar);
			if (timeArrayDvList.contains(dvName)){
				entryNameTS=DssOperation.entryNameTS(dvName+"__fut__0", ControlData.timeStep);
				DataTimeSeries.saveDataToTimeSeries(entryNameTS, value, dvar, 0);
			}
		}
		
		//TODO: weird bug. need to fix		
		for (String dvName: varDoubleMap.keySet()) {
			Dvar dvar=dvarMap.get(dvName);		
			double value=varDoubleMap.get(dvName);
			IntDouble id=new IntDouble(value,false);

			//TODO: weird bug. need to fix
			try {
				dvar.setData(id);
			} catch (Exception e) {
				//System.out.println("dvName: "+dvName);
				dvar=new Dvar();
				dvar.upperBoundValue = maxValue;
				dvar.lowerBoundValue = 0.0;
				dvar.setData(id);
				dvarMap.put(dvName, dvar);
			}

			if(dvarUsedByLaterCycle.contains(dvName)){
				varCycleValueMap.get(dvName).put(modelName, id);
			}else if (dvarTimeArrayUsedByLaterCycle.contains(dvName)){
				if (varTimeArrayCycleValueMap.containsKey(dvName)){
					varTimeArrayCycleValueMap.get(dvName).put(modelName, dvar.data);
				}else{
					Map<String, IntDouble> cycleValue = new HashMap<String, IntDouble>();
					cycleValue.put(modelName, dvar.data);
					varTimeArrayCycleValueMap.put(dvName, cycleValue);
				}
			}
			if (varCycleIndexList.contains(dvName) || dvarTimeArrayCycleIndexList.contains(dvName)){
				if (varCycleIndexValueMap.containsKey(dvName)){
					varCycleIndexValueMap.get(dvName).put(modelName, dvar.data);
				}else{
					Map<String, IntDouble> cycleValue = new HashMap<String, IntDouble>();
					cycleValue.put(modelName, dvar.data);
					varCycleIndexValueMap.put(dvName, cycleValue);
				}
			}
			String entryNameTS=DssOperation.entryNameTS(dvName, ControlData.timeStep);
			DataTimeSeries.saveDataToTimeSeries(dvName, entryNameTS, value, dvar);
			if (timeArrayDvList.contains(dvName)){
				entryNameTS=DssOperation.entryNameTS(dvName+"__fut__0", ControlData.timeStep);
				DataTimeSeries.saveDataToTimeSeries(entryNameTS, value, dvar, 0);
			}
		}
		
		if (ControlData.showRunTimeMessage) {
			System.out.println("Objective Value: "+ControlData.clp_cbc_objective);
			System.out.println("Assign Dvar Done.");
		}
	}
	
	public static void addConditionalSlackSurplusToDvarMap(Map<String, Dvar> dvarMap, String dvName, boolean isNoteCbc){
		String c="";
		Dvar dvar=new Dvar();
		dvar.upperBoundValue = maxValue;
		dvar.lowerBoundValue = 0.0;
		dvarMap.put(dvName, dvar);
		
		double w = 0;
		if (wm2.keySet().contains(dvName)){
			w = -wm2.get(dvName).getValue();
		}
		//System.out.println(dvName+":"+w);
		jCbc.addCol(modelObject , 0, maxValue, w, dvName, dvar.integer==Param.yes ); 
	    if (isNoteCbc) {

	    	int isInt=0;
	    	if (dvar.integer==Param.yes) isInt=1;
	    	c = isInt+","+dvName+","+w+",0,"+maxValue; 
	    	Tools.quickLog(modelName+"_"+solveName+".cols", c, true);
	    }
	

	}
	
	public static void reloadAndWriteLp(String nameAppend, boolean logMps, boolean logCbc) {
		
		String label = modelName + "_" + solveName + "_" + nameAppend;
		String oPath = new File(ILP.getIlpDir().getAbsoluteFile(), label).getAbsolutePath();
		reloadProblem(logCbc);
		jCbc.writeLp1(model, oPath, cbcWriteLpEpsilon, 14);
		//jCbc.writeMps(model, oPath);
		if(logMps){jCbc.writeMps1(model, oPath+".mps", 1, 2);}
		
		logIntVars(label);
		
		ILP.writeNoteLn("CbcTolerancePrimal: "+CbcSolver.solve_2_primalT);
		ILP.writeNoteLn("CbcTolerancePrimalRelax: "+CbcSolver.solve_2_primalT_relax);
		ILP.writeNoteLn("CbcToleranceInteger: "+CbcSolver.integerT);
		ILP.writeNoteLn("CbcToleranceIntegercheck: "+CbcSolver.integerT_check);	
		ILP.writeNoteLn("CbcToleranceWarmPrimal: "+CbcSolver.solve_whs_primalT);
		ILP.writeNoteLn("CbcToleranceZero: "+ControlData.zeroTolerance);
		ILP.writeNoteLn("CbcHintTimeMax: "+CbcSolver.cbcHintTimeMax);
		ILP.writeNoteLn("CbcHintRelaxPenalty: "+CbcSolver.cbcHintRelaxPenalty);

	}
	
	public static void reloadAndWriteLp(String nameAppend, boolean logCbc) {
		
		String label = modelName + "_" + solveName + "_" + nameAppend;
		String oPath = new File(ILP.getIlpDir().getAbsoluteFile(), label).getAbsolutePath();
		reloadProblem(logCbc);
		jCbc.writeLp1(model, oPath, cbcWriteLpEpsilon, 14);
		
		logIntVars(label);

	}
	
	public static void writeCbcLp(String nameAppend, boolean logMps) {
		
		String label = modelName + "_" + solveName + "_" + nameAppend;
		String oPath = new File(ILP.getIlpDir().getAbsoluteFile(), label).getAbsolutePath();
		//reloadProblem();
		jCbc.writeLp1(model, oPath, cbcWriteLpEpsilon, 14);
		//jCbc.writeMps(model, oPath);
		if(logMps){jCbc.writeMps1(model, oPath+".mps", 1, 2);}
		
		logIntVars(label);

	}
	
	private static void logIntVars(String label){
		
		if (ControlData.currStudyDataSet.cycIntDvMap != null) {
			if (ControlData.currStudyDataSet.cycIntDvMap.get(ControlData.currCycleIndex).size() > 0) {

				String c = "";
				for (String dvN : ControlData.currStudyDataSet.cycIntDvMap.get(ControlData.currCycleIndex)) {
					c = c + dvN + "," + dvIntMap.get(dvN) + "\n";
				}
				Tools.quickLog(label + "_intVars", c);
			}
		}	
	}
	
	public static void logCbcDebug(StudyDataSet sds){
			
//		ILP.getIlpDir();
//		ILP.setVarDir();
		//ILP.setSvarFile();
//		ILP.setMaximumFractionDigits();
		// write svar
		//ILP.writeSvarValue();
		// write dvar
		ILP.findDvarEffective();
		//System.out.println("write cbc dvar");
		ILP.setDvarFile("cbc");
		ILP.writeDvarValue_Clp0_Cbc0(CbcSolver.varDoubleMap);
		//System.out.println("write xa dvar");
		ILP.setDvarFile("xa");
		ILP.writeDvarValue_XA();
		
		
		// write watch var values
		boolean recordLP = false;
		boolean recordVar = false;
		double wa_cbc = 0;
		double wa_xa  = 0;
		if (ControlData.watchList != null) {
			String wa_cbc_str = "";
			String wa_xa_str = "";
			for (String s : ControlData.watchList) {
				if (ControlData.currModelDataSet.dvList.contains(s)){
				
					//System.out.println(s);
					wa_cbc = CbcSolver.varDoubleMap.get(s);
					wa_xa  = ControlData.xasolver.getColumnActivity(s);
					wa_cbc_str += String.format("%14.3f", wa_cbc) + "  ";
					wa_xa_str += String.format("%14.3f",  wa_xa) + "  ";
					
					if (Math.abs(wa_xa-wa_cbc)>ControlData.watchList_tolerance) recordLP=true; 
				}
			}
			ILP.writeNoteLn(ILP.getYearMonthCycle(), wa_cbc_str, ILP._watchFile_cbc);
			ILP.writeNoteLn(ILP.getYearMonthCycle(), wa_xa_str, ILP._watchFile_xa);
			
		}
		
		// write int value, time, and obj diff
		ILP.writeNoteLn(ILP.getYearMonthCycle(), ""+ControlData.xasolver.getObjective(), ILP._noteFile_xa_obj);
		ILP.writeNoteLn(ILP.getYearMonthCycle(), ""+ControlData.clp_cbc_objective, ILP._noteFile_cbc_obj);
		
		String xa_int = "";
		String cbc_int = "";
		if (sds.cycIntDvMap != null) {
			ArrayList<String> intDVs = new ArrayList<String>(sds.cycIntDvMap.get(ControlData.currCycleIndex));
			for (String v :sds.allIntDv) {
				if (intDVs.contains(v)){
					xa_int  += " "+ Math.round(ControlData.xasolver.getColumnActivity(v));
					if (Error.getTotalError()==0) {
						cbc_int += " "+ Math.round(CbcSolver.varDoubleMap.get(v));
					} else {
						cbc_int += " ?";
					}
				} else {
					xa_int  += "  ";
					cbc_int += "  ";
				}
			}
		}
		
		// write solve name
		cbc_int +=  "  "+CbcSolver.solveName;
		xa_int  +=  "  "+CbcSolver.solveName;
		
		if (Error.getTotalError() == 0) {
			if (recordLP) {
				CbcSolver.reloadAndWriteLp("_watch_diff", true, true);
			}
			
			double diff = ControlData.clp_cbc_objective - ControlData.xasolver.getObjective();
			if (Math.abs(diff) > CbcSolver.record_if_obj_diff) {
				CbcSolver.reloadAndWriteLp("_obj"+Math.round(diff), true, true);
			}
			if (Math.abs(diff) > CbcSolver.log_if_obj_diff) {
				xa_int += "  obj: " + String.format("%16.3f", diff);
				cbc_int += "  obj: " + String.format("%16.3f", diff);
				if (diff>CbcSolver.maxObjDiff){
					CbcSolver.maxObjDiff = diff;
					CbcSolver.maxObjDiff_id = ILP.getYearMonthCycle();
				} else if(diff<CbcSolver.maxObjDiff_minus){
					CbcSolver.maxObjDiff_minus = diff;
					CbcSolver.maxObjDiff_minus_id = ILP.getYearMonthCycle();										
				}
			}
		}
		ILP.writeNoteLn(ILP.getYearMonthCycle(), ""+ xa_int, ILP._noteFile_xa_int);
		ILP.writeNoteLn(ILP.getYearMonthCycle(), ""+ cbc_int, ILP._noteFile_cbc_int);		
	}
	
	public static void main(String argv[]) {

		System.loadLibrary(cbcLibName); 

		SWIGTYPE_p_OsiClpSolverInterface solver = jCbc.new_jOsiClpSolverInterface(); 
		SWIGTYPE_p_CbcModel model = jCbc.new_jCbcModel();
		jCbc.assignSolver(model, solver); 

		

		//jCbc.readLp(solver, "1961_01_c01.lp");
		jCbc.readLp(solver, "1961_01_c06.lp");
		jCbc.setModelName(solver, "TestName");

		
		long beginT = System.currentTimeMillis();
		
		jCbc.setPrimalTolerance(model, 1e-06);
		jCbc.solve_2(model, solver, 3);
		System.out.println("model name: "+jCbc.getModelName(solver));
		System.out.println("status: "+jCbc.status(model)+" "+jCbc.secondaryStatus(model));
		
		long endT = System.currentTimeMillis();
		
		double time_second = (endT-beginT)/1000.;

		System.out.println("time(sec): "+time_second);

		if (jCbc.status(model) == 0 && jCbc.secondaryStatus(model) == 0) {

			int nCols = jCbc.getNumCols(model);

			SWIGTYPE_p_double sol = jCbc.new_jarray_double(nCols);
			sol = jCbc.getColSolution(solver);

			System.out.println("Solution:\n");
			System.out.println("Objective Value = " + jCbc.getObjValue(model)
					+ "\n");

			for (int j = 0; j < nCols; j++) {
				if (jCbc.isInteger(solver, j) == 1)
					System.out.println(jCbc.getColName(model, j) + " = "
							+ jCbc.jarray_double_getitem(sol, j));
			}
		} else if (jCbc.secondaryStatus(model) == 1) {
			System.out.println("Model Infeasible.");

		} else {
			System.out.println("Errors!! "+jCbc.status(model)+" "+jCbc.secondaryStatus(model));
		}
		jCbc.delete_jCbcModel(model);

	}
	
	private static void note_msg(String msg) {
		ILP.writeNoteLn(jCbc.getModelName(solver), msg);
		System.out.println(jCbc.getModelName(solver)+ msg);
	}
	
	private static void solve_2() {
		solve_2(solve_2_primalT, "2__");
	}
	
	private static void solve_2(double priT, String solvName) {
		solveName=solvName;
		jCbc.setPrimalTolerance(model, priT);
		jCbc.setIntegerTolerance(model, integerT);
		jCbc.solve_2(model, solver, 0);
	}
	
	private static void solve_3() {
		solveName="3__";
		jCbc.setPrimalTolerance(model, solve_3_primalT);
		jCbc.setIntegerTolerance(model, integerT);
		jCbc.solve_3(model, solver, 0);
	}
	
	private static void callCbc() {
		solveName="c__";
		//jCbc.setIntegerTolerance(model, integerT);
		//jCbc.callCbc("-log 0 -preprocess off -presolve off -cutsOnOff off -primalT 1e-4 -integerT 1e-7 -solve", model);
		//jCbc.callCbc("-log 0 -preprocess off -presolve on -cutsOnOff on -primalT 1e-5 -integerT 1e-8 -solve", model);
		//jCbc.callCbc("-log 0 -preprocess off -presolve on -cutsOnOff on -primalT "+solve_2_primalT_relax+" -integerT "+integerT+" -solve", model);
		jCbc.callCbc("-log 0 -primalT 1e-9 -integerT 1e-9 -solve", model);
	}

	private static void callCbc_R() {
		solveName="cR_";
		jCbc.callCbc("-log 0 -primalT 1e-7 -integerT 1e-9 -solve", model);
	}
	
	public static void logIntCheck(StudyDataSet sds){
			
			String cbc_int = "";
			
			// write solve name
			cbc_int +=  ","+CbcSolver.solveName;
			
			// write solve time
			cbc_int +=  ","+String.format("%8.2f",ControlData.solverTime_cbc_this);
			
			if (sds.cycIntDvMap != null && sds.cycIntDvMap.containsKey(ControlData.currCycleIndex)) {
				ArrayList<String> intDVs = new ArrayList<String>(sds.cycIntDvMap.get(ControlData.currCycleIndex));
				Boolean int_violation = false;
				for (String v : sds.allIntDv) {
					if (intDVs.contains(v)){
						//xa_int  += " "+ Math.round(ControlData.xasolver.getColumnActivity(v));
						if (Error.getTotalError()==0) {
							//cbc_int += " "+ Math.round(CbcSolver.varDoubleMap.get(v));
							double x = CbcSolver.varDoubleMap.get(v);
							cbc_int += ","+ x;
							if   (Math.abs( Math.round(x)-x)>1E-7) {int_violation=true;}
							
						} else {
							cbc_int += ",?";
							int_violation=null;
						}
					} else {
						//xa_int  += "  ";
						cbc_int += ",";
					}
				}
				cbc_int = "," + int_violation + cbc_int;
			}
	
			ILP.writeNoteLn(ILP.getYearMonthCycle(), ""+ cbc_int, ILP._noteFile_cbc_int_log);					
		
	}

}
