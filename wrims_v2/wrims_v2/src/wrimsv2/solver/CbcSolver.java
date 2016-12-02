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
import wrimsv2.wreslplus.elements.Tools;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;



public class CbcSolver {
	
	public static Map <String, Double> varDoubleMap;
	
	private static SWIGTYPE_p_OsiClpSolverInterface solver; // = jCbc.new_jOsiClpSolverInterface(); //this is our LP solver!
	private static SWIGTYPE_p_CbcModel model; // = jCbc.new_jCbcModel();// This defines a new empty CbcModel
	private static SWIGTYPE_p_CoinModel modelObject; 

	private static Map<String, String> iisPossibleConstraintMap;
	private static Set<String> iisConfirmConstraint;
	//private static LinkedHashSet<String> iisReport;
	private static LinkedHashMap<Integer, String> iisSlackMap;
	private static LinkedHashMap<String, String> iisConstraintSignMap;
	private static LinkedHashMap<String, Double> iisConstraintRHSMap;
	private static LinkedHashMap<String, int[]> iisConstraintIndexMap;
	private static LinkedHashMap<String, double[]> iisConstraintElementMap;
	private static ArrayList<String> iisSlacks;
	//private static ArrayList<String> iisDvarList;
	private static final double iisWeight = 3000;
	
	private static  Map<String, Dvar> dvarMap;
	private static BiMap<Integer, String> dvBiMap;
	private static BiMap<String, Integer> dvBiMapInverse;
	
	private static  double maxValue = Double.MAX_VALUE;
	//public static final double zeroTolerence =  1e-10;
	public static double solve_2_primalT =  1e-8;
	public static final double solve_2_primalT_relax =  1e-6;
	public static final double solve_2_primalT_relax_most =  1e-4;
	public static final double solve_3_primalT =  1e-9;
	//public static final double solve_3_primalT_relax =  1e-7;
	public static double solve_whs_primalT =  1e-9;
	public static final Integer cutoff_n =  12;
	public static double integerT =  1e-9;
	public static String cbcLibName = "jCbc";
	
	private static String modelName;
	
	private static Map<String, WeightElement> wm2; 
	
	private static boolean useLpFile=false;
	
	private static int index[];
	private static double elements[];
	
	private static boolean saveWarm=false;
	private static boolean useWarm=false;
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
	
	public static void init(boolean useLpFile){
		//useLpFile=false;
		CbcSolver.useLpFile = useLpFile;
		System.loadLibrary(cbcLibName);
		ILP.getIlpDir();
		ILP.createNoteFile();
		
		if (ControlData.useCbcWarmStart || ControlData.cbc_debug_routeCbc || ControlData.cbc_debug_routeXA){
			dvIntMap = new LinkedHashMap<String, Integer>();
			for (String d: ControlData.allIntDv){
				dvIntMap.put(d, 0);
			}
		}
		
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

			setDVars();
			setConstraints();

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
			collectDvar(); 
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

	private static void reloadProblem() {


		// restore original state
		SolverData.getDvarMap().keySet().retainAll(originalDvarKeys);
		int sizeA = ControlData.currModelDataSet.dvList.size();
		int sizeB = ControlData.currModelDataSet.dvTimeArrayList.size();
		dvBiMap.clear();
		for (int i=0; i<sizeA; i++){
			dvBiMap.put(i,ControlData.currModelDataSet.dvList.get(i));				
		}
		for (int i=sizeA; i<sizeA+sizeB; i++){
			dvBiMap.put(i,ControlData.currModelDataSet.dvTimeArrayList.get(i));				
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

		setDVars();
		setConstraints();
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
		for (int i=sizeA; i<sizeA+sizeB; i++){
			dvBiMap.put(i,ControlData.currModelDataSet.dvTimeArrayList.get(i));				
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

		setDVars();
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
		for (int i=sizeA; i<sizeA+sizeB; i++){
			dvBiMap.put(i,ControlData.currModelDataSet.dvTimeArrayList.get(i));				
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
	
	private static void setConstraints() {
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
						
						addConditionalSlackSurplusToDvarMap(dvarMap, multName);
					
					}					
					
					index[j]=dvBiMapInverse.get(multName);
					double temp = multMap.get(multName).getData().doubleValue();
					if(Math.abs(temp)<ControlData.zeroTolerance) {temp=0;} 
					elements[j]=temp;
					
					j++;
				}

				jCbc.addRow(modelObject,multMap.keySet().size(), index, elements, GT, LT, constraintName);
				rowCounter++; 
				
			}
		}
		
		 jCbc.addRows(solver,modelObject);
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
						
						addConditionalSlackSurplusToDvarMap(dvarMap, multName);
					
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
				
				index = new int[multMap.keySet().size()+2];	
				elements = new double[multMap.keySet().size()+2];	
				
				int j=0;
				while(multIterator.hasNext()){
					String multName=(String)multIterator.next();
										
					if (!dvarMap.containsKey(multName)){ 
						int sizeDv = dvBiMap.size();
						dvBiMap.put(sizeDv, multName);
						dvBiMapInverse.put(multName, sizeDv);
						
						addConditionalSlackSurplusToDvarMap(dvarMap, multName);
					
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
				
				if (enforceThisConstraint.contains(constraintName)){ coef = 0; }
				
				int z = dvBiMap.size();
				
				dvBiMap.put(z, iisNameP);
				dvBiMapInverse.put(iisNameP, z);
				index[j] = dvBiMapInverse.get(iisNameP);
				elements[j] = coef;
				j++;				
				iisSlackMap.put(z, constraintName);
				//iisC
				jCbc.addCol(modelObject, 0, maxValue, iisWeight, iisNameP, false); 
				
				dvBiMap.put(z+1, iisNameN);
				dvBiMapInverse.put(iisNameN, z+1);
				index[j] = dvBiMapInverse.get(iisNameN);
				elements[j] = -coef;
				j++;				
				iisSlackMap.put(z+1, constraintName);
				jCbc.addCol(modelObject, 0, maxValue, iisWeight, iisNameN, false); 
				
				
				jCbc.addRow(modelObject,multMap.keySet().size()+2, index, elements, GT, LT, constraintName);
				
			}
		}
		
		 jCbc.addRows(solver,modelObject);
	}
    
	private static void setDVars() {
				
		Map<String, WeightElement> wm1  = SolverData.getWeightMap();
		
		for (int i=0; i<dvBiMap.size(); i++){
			String dvName = dvBiMap.get(i);
			Dvar dvObj = dvarMap.get(dvName);
			
			double w = 0;
			if (wm1.keySet().contains(dvName)){
				w = -wm1.get(dvName).getValue();
			
			}
			//System.out.println("weight of: "+dvName+"="+w);
		    jCbc.addCol(modelObject , dvObj.lowerBoundValue.doubleValue(), dvObj.upperBoundValue.doubleValue(), w, dvName, dvObj.integer==Param.yes ); 
			
		}
		
	}
	
	private static void setDVarsIIS() {
		
		for (int i=0; i<dvBiMap.size(); i++){
			String dvName = dvBiMap.get(i);
			Dvar dvObj = dvarMap.get(dvName);
			
		    jCbc.addCol(modelObject , dvObj.lowerBoundValue.doubleValue(), dvObj.upperBoundValue.doubleValue(), 0, dvName, dvObj.integer==Param.yes ); 
			
		}
		
	}
	
	public static int[] solve(){
		
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

				intSolSize = ControlData.cycIntDvMap.get(ControlData.currCycleIndex).size();
				names = jCbc.new_jarray_string(intSolSize);
				values = jCbc.new_jarray_int(intSolSize);
				warmArrayExist = true;
				int k = 0;
				for (String dvN : ControlData.cycIntDvMap.get(ControlData.currCycleIndex)) {
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
			
		if (useWarm || saveWarm) {
			int ii = ControlData.currCycleIndex+1;
			//System.out.println(ii+": use warm");
			
			if (warmArrayExist) {

				jCbc.delete_jarray_int(values);
				jCbc.delete_jarray_string(names);
				intSolSize = 0;
				values = null;
				names = null;
				warmArrayExist = false;
			}			
			
			intSolSize = ControlData.cycIntDvMap.get(ControlData.currCycleIndex).size();
			names = jCbc.new_jarray_string(intSolSize);
			values = jCbc.new_jarray_int(intSolSize);
			warmArrayExist = true;
			int k=0;
			for (String dvN: ControlData.cycIntDvMap.get(ControlData.currCycleIndex)){
				jCbc.jarray_string_setitem(names,k,dvN);
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
				reloadProblem();	
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
			//note_msg(jCbc.getModelName(solver), " Solve_"+solveName+" infeasible. Use solve_2 with primalT="+solve_2_primalT_relax);
			reloadProblem();
			solve_2(solve_2_primalT_relax);	
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);
		}	

		if (status != 0 || status2 != 0) {
			//note_msg(jCbc.getModelName(solver), " Solve_"+solveName+" infeasible. Use solve_2 with primalT="+solve_2_primalT_relax_most);
			reloadProblem();
			solve_2(solve_2_primalT_relax);	
			status = jCbc.status(model);
			status2 = jCbc.secondaryStatus(model);
		}	
		
		if (status != 0 || status2 != 0) {
			//note_msg(jCbc.getModelName(solver), " Solve_"+solveName+" infeasible. Use callCbc.");
			reloadProblem();
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
			reloadAndWriteLp("_infeasible", true);
			getSolverInformation(status, status2);
			iis();
		}

		return new int[]{status, status2};
	    	
	}
	
	
	private static void iis() {
		iisConstraintIndexMap = new LinkedHashMap<String, int[]>();
		iisConstraintElementMap = new LinkedHashMap<String, double[]>();
		iisConstraintSignMap = new LinkedHashMap<String, String>();
		iisConstraintRHSMap = new LinkedHashMap<String, Double>();
		iisSlacks = new ArrayList<String>();
		iisPossibleConstraintMap = new LinkedHashMap<String, String>();
		iisConfirmConstraint = new LinkedHashSet<String>();

		boolean success = iisSolve(true, new HashSet());

		if (!success) {
			return;
		} else {
			System.out.print("Finding constraints that cause infeasibility");
		}
		
		Set<String> aa = new HashSet<String>();
		Set<String> bb = new HashSet<String>(); 
		Set<String> ss = new HashSet<String>();

		while (aa.size()<iisPossibleConstraintMap.size()){
			System.out.print(".");
			bb = new HashSet<String>(iisPossibleConstraintMap.keySet());
			bb.removeAll(aa);
		    aa = new HashSet<String>(iisPossibleConstraintMap.keySet());   
		    
			for (String s : bb) {
				ss = new HashSet<String>();
				ss.add(s);
				success = iisSolve(false, ss);
			}
			
		}
		
		while (success){
			System.out.print(".");
			success = iisSolve(false, iisPossibleConstraintMap.keySet());
		}
		
		for (String c : iisPossibleConstraintMap.keySet()){
			if(iisSolveConfirm(c)){
				System.out.print(".");
				iisConfirmConstraint.add(c);
			}
		}
		System.out.println("");
		
		Set<String> iisReport;
		
		if (iisConfirmConstraint.size()>0) {
			iisReport = iisConfirmConstraint;
		} else {
			iisReport = iisPossibleConstraintMap.keySet();
		}
		
		String errString = "One or more of the following constraints might cause infeasibility:\r\n";

		for (String c : iisReport){
				errString += iisPossibleConstraintMap.get(c) + "\r\n";
		}
		Error.addSolvingError(errString);
		for (String c : iisReport){
			Error.addInfeasibleHint(c, iisPossibleConstraintMap.get(c));
		}
		System.out.println("Check \"Error.log\" under the folder \"=ILP=\" for more information.");
		System.out.println();

	}

	private static boolean iisSolveConfirm(String skipThisConstraint) {
		boolean success = false;

		reloadProblemConfirm(skipThisConstraint);
		//jCbc.writeLp1(model, "confirm", 1e-14, 14);
		solve_3();
		//jCbc.callCbc("-log 0 -preprocess off -presolve off -cutsOnOff off -integerT 1e-9 -solve", model);
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
		//iisTriedConstraintSet.add(enforceThisConstraint);
		//jCbc.writeLp1(model, "iis", 1e-14, 14);
		solve_2();
		int s = jCbc.status(model);
		int s2 = jCbc.secondaryStatus(model);
//		System.out.println("s: " + s);
//		System.out.println("s2: " + s2);
		// System.out.println(iisDvarMap);
		// scan iis dvar solution

		// for (int j = 0; j < jCbc.getNumCols(model); j++){
		// System.out.println(jCbc.getColName(model,j)+"::"+jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j));
		//
		// }

		if (s == 0 && s2 == 0) {
//			System.out.println("A set the following constraints might cause infeasibility:");
//			System.out.println("============================================================");
			for (int j : iisSlackMap.keySet()) {
				String name = iisSlackMap.get(j);
				String name2 = jCbc.getColName(model, j);
				// System.out.println(name);
				// System.out.println(jCbc.getColName(model,j));
				// check if name matches
				if (!name2.substring(0, name2.length() - 2).equalsIgnoreCase(name)) {
					System.out.println("@@ " + jCbc.getColName(model, j));
					System.out.println("@@ " + name);
				} else {
					// check if solution not zero
					if (jCbc.jarray_double_getitem(jCbc.getColSolution(solver), j) > 0) {
						//iisFinalConstraintSet.add(name);
						//iisToTryConstraintSet.add(name);
						//System.out.println(jCbc.getColName(model, j) + ":" + jCbc.jarray_double_getitem(jCbc.getColSolution(solver), j));
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
						//System.out.println(show);
						

					}
				}

			}
			//System.out.println("============================================================");

			success = true;
		} else {
			success = false;
		}

		return success;
	}

	private static void collectDvar() {

		int ColumnSize = jCbc.getNumCols(model);
		varDoubleMap = new HashMap<String, Double>();
				
		if (saveWarm||useWarm) {
			int ii = ControlData.currCycleIndex + 1;
			//System.out.println(ii + ": save warm");


			int k = 0;
			for (int j = 0; j < ColumnSize; j++){
				 varDoubleMap.put(jCbc.getColName(model,j), jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j));
				 if (jCbc.isInteger(solver,j)==1) {
					dvIntMap.put(jCbc.getColName(solver,j), (int)Math.round(jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j)));
				 	k++; 
				 }
			}
		} else {

			for (int j = 0; j < ColumnSize; j++){
				varDoubleMap.put(jCbc.getColName(model,j), jCbc.jarray_double_getitem(jCbc.getColSolution(solver),j));
	
			}
		}

	}
	
	private static void assignDvar() {
		
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
	
	public static void addConditionalSlackSurplusToDvarMap(Map<String, Dvar> dvarMap, String dvName){
		
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

	}
	
	public static void reloadAndWriteLp(String nameAppend, boolean logMps) {
		
		String label = modelName + "_" + solveName + "_" + nameAppend;
		String oPath = new File(ILP.getIlpDir().getAbsoluteFile(), label).getAbsolutePath();
		reloadProblem();
		jCbc.writeLp1(model, oPath, 1e-14, 14);
		//jCbc.writeMps(model, oPath);
		if(logMps){jCbc.writeMps1(model, oPath+".mps", 1, 2);}
		
		logIntVars(label);

	}
	
	public static void writeCbcLp(String nameAppend, boolean logMps) {
		
		String label = modelName + "_" + solveName + "_" + nameAppend;
		String oPath = new File(ILP.getIlpDir().getAbsoluteFile(), label).getAbsolutePath();
		//reloadProblem();
		jCbc.writeLp1(model, oPath, 1e-14, 14);
		//jCbc.writeMps(model, oPath);
		if(logMps){jCbc.writeMps1(model, oPath+".mps", 1, 2);}
		
		logIntVars(label);

	}
	
	private static void logIntVars(String label){
		
		if (ControlData.cycIntDvMap != null) {
			if (ControlData.cycIntDvMap.get(ControlData.currCycleIndex).size() > 0) {

				String c = "";
				for (String dvN : ControlData.cycIntDvMap.get(ControlData.currCycleIndex)) {
					c = c + dvN + "," + dvIntMap.get(dvN) + "\n";
				}
				Tools.quickLog(label + "_intVars", c);
			}
		}	
	}
	
	public static void main(String argv[]) {

		System.loadLibrary("jCbc"); 

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
	
	private static void note_msg(String modelName2, String msg) {
		ILP.writeNoteLn(jCbc.getModelName(solver), msg);
		System.out.println(jCbc.getModelName(solver)+ msg);
	}
	
	private static void solve_2() {
		solve_2(solve_2_primalT);
	}
	
	private static void solve_2(double priT) {
		solveName="2__";
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
		solveName="cal";
		jCbc.setIntegerTolerance(model, integerT);
		jCbc.callCbc("-log 0 -preprocess off -presolve off -cutsOnOff off -primalT 1e-4 -integerT 1e-7 -solve", model);
	}

}
