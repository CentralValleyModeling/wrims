package wrimsv2.ilp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.solver.Gurobi.GurobiSolver;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.Tools;

// for LpSolve select 1.Rows 2.Cols 3.Elimeq2 in Presolve

public class ILP {

	private static String _lpSolveDir;
	private static String _cplexLpDir;
	private static String _amplDir;
	public static String lpSolveFilePath;
	public static String cplexLpFilePath;
	public static String amplFilePath;
	private static PrintWriter _lpSolveFile;
	private static PrintWriter _cplexLpFile;
	private static PrintWriter _amplFile;
	private static PrintWriter _svarFile;
	private static PrintWriter _dvarFile;
	private static PrintWriter _objValueFile;
	private static Set<String> dvar_effective;
	private static final String lpSolve_comment_Symbol = "//";
	private static final String ampl_comment_Symbol = "#";
	private static final String cplexLp_comment_Symbol = "\\";
	private static DecimalFormat df;
	public static int maximumFractionDigits = 8;
	public static boolean loggingVariableValue = false;
	public static boolean logging = false;
	public static boolean loggingAmpl = false;
	public static boolean loggingCplexLp = false; // special LP problem file format designed by Cplex
	public static boolean loggingLpSolve = false; // special LP problem file format designed by LpSolve
	
	private static File _ilpRootDir;  
	private static File _ilpDir; 
	private static File _svarDir;
	private static File _dvarDir;
	
	private ILP() {
		
	}

	public static void initializeIlp() {
		
		_ilpRootDir = new File(FilePaths.mainDirectory, "=ILP=");  
	    _ilpDir = new File(_ilpRootDir.getAbsolutePath(), StudyUtils.configFileName); 
	    
		if (ILP.loggingLpSolve)  _lpSolveDir = new File(_ilpDir, "lpsolve").getAbsolutePath();
		if (ILP.loggingCplexLp)  _cplexLpDir = new File(_ilpDir, "cplexlp").getAbsolutePath();
		if (ILP.loggingAmpl)     _amplDir = new File(_ilpDir, "ampl").getAbsolutePath();
		// TODO: write ampl command file "option presolve_eps 1e-13;"

		if (ILP.loggingVariableValue) setVarDir();
		setMaximumFractionDigits();
		
	    try {
			_objValueFile = Tools.openFile(_ilpDir.getAbsolutePath(), "ObjValues.log");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setMaximumFractionDigits() {
		
		df = new DecimalFormat();
		//df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(maximumFractionDigits);
	}
	
	public static void setIlpFile() {
		
		if (ILP.loggingLpSolve) setLpSolveFile();
		if (ILP.loggingCplexLp) setCplexLpFile();		
		if (ILP.loggingAmpl)    setAmplFile();		
	}

	public static void writeIlp() {
		
		if (ILP.loggingLpSolve) writeLpSolveFile();
		if (ILP.loggingCplexLp) writeCplexLpFile();
		if (ILP.loggingAmpl)    writeAmplFile();
		
	}

	public static void writeObjValue_XA() {
		
		double objValue = ControlData.xasolver.getObjective();
		String objValueStr = Double.toString(objValue);
		
		if (ILP.loggingLpSolve) writeObjValue(objValueStr, _lpSolveFile, lpSolve_comment_Symbol);
		if (ILP.loggingCplexLp) writeObjValue(objValueStr, _cplexLpFile, cplexLp_comment_Symbol);
		if (ILP.loggingAmpl)    writeObjValue(objValueStr, _amplFile, ampl_comment_Symbol);
	    
		writeObjValueLog(getYearMonthCycle(), objValueStr, _objValueFile);
		
	}
	
	public static void writeObjValue_LPSOLVE() {

		double objValue = ControlData.lpsolve_objective;
		String objValueStr = Double.toString(objValue);

		writeObjValue(objValueStr, _lpSolveFile, lpSolve_comment_Symbol);
		if (ILP.loggingCplexLp) writeObjValue(objValueStr, _cplexLpFile, cplexLp_comment_Symbol);
		if (ILP.loggingAmpl) writeObjValue(objValueStr, _amplFile, ampl_comment_Symbol);
		
		writeObjValueLog(getYearMonthCycle(), objValueStr, _objValueFile);

	}

	public static void writeObjValue_Gurobi() {

		double objValue = ControlData.gurobi_objective;
		String objValueStr = Double.toString(objValue);
		
		writeObjValue(objValueStr, _cplexLpFile, cplexLp_comment_Symbol);
		if (ILP.loggingLpSolve) writeObjValue(objValueStr, _lpSolveFile, lpSolve_comment_Symbol);
		if (ILP.loggingAmpl)    writeObjValue(objValueStr, _amplFile, ampl_comment_Symbol);

		writeObjValueLog(getYearMonthCycle(), objValueStr, _objValueFile);

	}
	
	private static void writeLpSolveFile() {
		
		_lpSolveFile.print(findHeaderStr(lpSolve_comment_Symbol));
		
		Map<String, WeightElement> activeWeightMap = findActiveWeightMap();
		
		LpSolveWriter.writeObj(_lpSolveFile, activeWeightMap);
		LpSolveWriter.writeConstraint(_lpSolveFile);
		
		Set<String> dvar_inConstraint = findDvarInConstraint();
		Set<String> dvar_weighted = findWeightedDvar();
		//Set<String> dvar_unWeighted = findUnWeightedDvarInConstraint(dvar_inConstraint, dvar_weighted);
		
		dvar_effective = new HashSet<String>();
		dvar_effective.addAll(dvar_weighted);
		dvar_effective.addAll(dvar_inConstraint);
		
		//LpSolveWriter.writeDvar(_lpSolveFile, dvar_weighted, dvar_unWeighted);
		LpSolveWriter.writeDvar(_lpSolveFile, dvar_effective);	
		_lpSolveFile.flush();
	}
	private static void writeCplexLpFile() {
		
		_cplexLpFile.print(findHeaderStr(cplexLp_comment_Symbol));
		
		Map<String, WeightElement> activeWeightMap = findActiveWeightMap();
		
		CplexLpWriter.writeObj(_cplexLpFile, activeWeightMap);
		CplexLpWriter.writeConstraint(_cplexLpFile);
		
		Set<String> dvar_inConstraint = findDvarInConstraint();
		Set<String> dvar_weighted = findWeightedDvar();
		//Set<String> dvar_unWeighted = findUnWeightedDvarInConstraint(dvar_inConstraint, dvar_weighted);
		
		dvar_effective = new HashSet<String>();
		dvar_effective.addAll(dvar_weighted);
		dvar_effective.addAll(dvar_inConstraint);
		
		CplexLpWriter.writeDvar(_cplexLpFile, dvar_effective);	
		_cplexLpFile.println("\nEnd");
		_cplexLpFile.flush();
		
	}
	private static void writeAmplFile() {
		
		_amplFile.print(findHeaderStr(ampl_comment_Symbol));
		
		Map<String, WeightElement> activeWeightMap = findActiveWeightMap();
		
		Set<String> dvar_inConstraint = findDvarInConstraint();
		Set<String> dvar_weighted = findWeightedDvar();
		//Set<String> dvar_unWeighted = findUnWeightedDvarInConstraint(dvar_inConstraint, dvar_weighted);
		
		dvar_effective = new HashSet<String>();
		dvar_effective.addAll(dvar_weighted);
		dvar_effective.addAll(dvar_inConstraint);
		
		AmplWriter.writeDvar(_amplFile, dvar_effective);	
		AmplWriter.writeConstraint(_amplFile);
		AmplWriter.writeObj(_amplFile, activeWeightMap);
		_amplFile.flush();
	}
	
	public static void writeDvarValue_XA() {
		
		writeDvarValue_XA(_dvarFile, dvar_effective);
		_dvarFile.flush();
		
	}
	public static void writeDvarValue_LPSOLVE() {
		
		writeDvarValue_LPSOLVE(_dvarFile, dvar_effective);
		_dvarFile.flush();
		
	}
	public static void writeDvarValue_Gurobi() {
		
		writeDvarValue_Gurobi(_dvarFile, dvar_effective);
		_dvarFile.flush();
		
	}
	public static void writeSvarValue() {
		
		writeSvarValue(_svarFile);
		_svarFile.flush();
	}
	
	public static void closeIlpFile() {
	
		try {
			if (ILP.loggingLpSolve) _lpSolveFile.close();
			if (ILP.loggingCplexLp) _cplexLpFile.close();
			if (ILP.loggingAmpl)    _amplFile.close();
			if (ILP.loggingVariableValue) {
				_svarFile.close();
				_dvarFile.close();
			}
		} catch (Exception e) {

			// ignore
		}
	}

	private static void setLpSolveFile() {
	
		String lpSolveFileName;
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);
		
		lpSolveFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".lps";		

		try {
			
			_lpSolveFile = Tools.openFile(_lpSolveDir, lpSolveFileName);
			lpSolveFilePath = new File(_lpSolveDir, lpSolveFileName).getAbsolutePath(); // for public access
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	public static void setVarDir(){
				
		_svarDir = new File(_ilpDir, "svar");
		_dvarDir = new File(_ilpDir, "dvar");
		
	}
	
	public static String getYearMonthCycle(){
		
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);
		String ret = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle;
		
		return ret;
		
	}
	
	public static void setObjValueFile(){
				
		
		try {
			
			_objValueFile = Tools.openFile(_ilpDir.getAbsolutePath(), "objectiveValues.log");

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void setVarFile(){
		
		String svarFileName = getYearMonthCycle()+ ".svar";
		String dvarFileName = getYearMonthCycle()+ ".dvar";
		
		
		try {
			
			_svarFile = Tools.openFile(_svarDir.getAbsolutePath(), svarFileName);
			_dvarFile = Tools.openFile(_dvarDir.getAbsolutePath(), dvarFileName);
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private static void setCplexLpFile() {
		
		String cplexLpFileName = getYearMonthCycle()+".lp";		

		try {

			
			_cplexLpFile = Tools.openFile(_cplexLpDir, cplexLpFileName);
			cplexLpFilePath = new File(_cplexLpDir, cplexLpFileName).getAbsolutePath(); // for public access

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	private static void setAmplFile() {
		
		String amplFileName = getYearMonthCycle()+ ".mod";				

		try {
		
			_amplFile = Tools.openFile(_amplDir, amplFileName);	
			amplFilePath = new File(_amplDir, amplFileName).getAbsolutePath(); // for public access
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}


	private static String findHeaderStr(String commentSymbol) {
		
		String headerStr = "";
		
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);
		
		String CurrDate = Integer.toString(ControlData.currYear)+"."
		                 + twoDigitMonth;
		
		headerStr = headerStr + commentSymbol + " Date: "+CurrDate + "\n";
		headerStr = headerStr + commentSymbol + " Cycle: "+twoDigitCycle + "\n";;
		headerStr = headerStr + commentSymbol + " Solver: "+ControlData.solverName + "\n\n";
		
		return headerStr;
	}
	
	private static Set<String> findWeightedDvar() {
		
		Set<String> dvar_weighted = new HashSet<String>();
		
		dvar_weighted.addAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		dvar_weighted.addAll(SolverData.getWeightMap().keySet());
	
		return dvar_weighted;		
	}
	
	private static Set<String> findDvarInConstraint() {
	
		Set<String> dvar_inConstraint = new HashSet<String>();

		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();
	
		for (String constraintName : constraintMap.keySet()) {	
	
			if (!constraintMap.get(constraintName).getEvalExpression().isNumeric()) {
	
				dvar_inConstraint.addAll(constraintMap.get(constraintName).getEvalExpression().getMultiplier().keySet());
			}	
		}
		return dvar_inConstraint;
	}

	private static Set<String> findUnWeightedDvarInConstraint( Set<String> dvar_inConstraint, Set<String> dvar_weighted ) {
		
		Set<String> dvar_unWeighted = new HashSet<String>();
		
		dvar_unWeighted.addAll(dvar_inConstraint);

		dvar_unWeighted.removeAll(dvar_weighted);
	
		return dvar_unWeighted;		
	}

	private static Map<String, WeightElement> findActiveWeightMap() {
	
		Map<String, WeightElement> activeWeightMap = new HashMap<String, WeightElement>();
		
		for (String usedSlackSurplus: ControlData.currModelDataSet.usedWtSlackSurplusList){
		
			activeWeightMap.put(usedSlackSurplus, SolverData.getWeightSlackSurplusMap().get(usedSlackSurplus));	
			
		}
		
		activeWeightMap.putAll(SolverData.getWeightMap());
	
		return activeWeightMap;
	}

	private static String findSvarValueStr() {
		
		String svarValueStr = "";
		
		Map<String, Svar> svMap = ControlData.currSvMap;
		
		ArrayList<String> sortedTerm = new ArrayList<String>(svMap.keySet());
		Collections.sort(sortedTerm);
		
		for (String s : sortedTerm){
			String svName = String.format("%-35s", s);
			svarValueStr = svarValueStr + ( svName + ":  " + svMap.get(s).getData().getData() +"\n"  );
		}
		
		return svarValueStr;
	}

	private static String findDvarValueStr_XA(Set<String> dvar) {
		
		ArrayList<String> dvar_sorted = new ArrayList<String>(dvar);
		
		Collections.sort(dvar_sorted);		
		
		String dvarValueStr = "";
		
		for (String s : dvar_sorted){
			String dvName = String.format("%-35s", s);
			dvarValueStr = dvarValueStr + (dvName + ":  " + ControlData.xasolver.getColumnActivity(s) +"\n"  );
		}
		
		return dvarValueStr;
	}

	public static void writeObjValueLog(String msg, String objValueStr, PrintWriter outFile) {		
			
		if (Error.getTotalError()==0) {
			outFile.println(msg+": "+objValueStr);
		} else {
			outFile.println(msg+": "+"Error! ");	
		}
		outFile.flush();
	}
	
	private static void writeObjValue(String objValueStr, PrintWriter outFile, String commentSym) {		

		//double objValue = ControlData.xasolver.getObjective();
		
		outFile.print("\n\n\n\n");		
		if (Error.getTotalError()==0) {
			outFile.println(commentSym+" objective value:   "+objValueStr);
		} else {
			outFile.println(commentSym+" objective value:   Error! ");	
		}
		outFile.flush();
	}

	// returns <dvar_weighted, dvar_unweighted>
	private static ArrayList<ArrayList<String>> prepareDvarToWrite(Set<String> dvar_effective){
		
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, WeightElement> wtMap = SolverData.getWeightMap();
		//Map<String, WeightElement> wtSlackSurplusMap = SolverData.getWeightSlackSurplusMap();
		
		ArrayList<String> dvar_weighted = new ArrayList<String>(wtMap.keySet());
		dvar_weighted.addAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		
		//TODO: remove weight of 0 from dvar_weighted.
		
		
		ArrayList<String> dvar_unweighted = new ArrayList<String>(dvMap.keySet());
		//dvar_unweighted.removeAll(wtMap.keySet());
		//dvar_unweighted.removeAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		dvar_unweighted.removeAll(dvar_weighted);
		
		dvar_unweighted.retainAll(dvar_effective);
		Collections.sort(dvar_weighted);
		Collections.sort(dvar_unweighted);
		
		ret.add(dvar_weighted);
		ret.add(dvar_unweighted);
		
		return ret;
		
	}
	private static void writeDvarValue_XA(PrintWriter dvarFile, Set<String> dvar_effective) {
		
		ArrayList<ArrayList<String>> sortedDvar = prepareDvarToWrite(dvar_effective);
		ArrayList<String> dvar_weighted = sortedDvar.get(0);
		ArrayList<String> dvar_unweighted = sortedDvar.get(1);
		
		dvarFile.println("/* Weighted Dvar    */");
		for (String s : dvar_weighted){
			String dvName = String.format("%-35s", s);
			try{
				dvarFile.print(dvName + ":  " + df.format(ControlData.xasolver.getColumnActivity(s)) +"\n"  );
			} catch (Exception e) {
				dvarFile.print(dvName + ":  " + ControlData.xasolver.getColumnActivity(s) +"\n"  );
			}
		}
		dvarFile.println();
		dvarFile.println("/* Unweighted Dvar    */");	
		for (String s : dvar_unweighted){
			String dvName = String.format("%-35s", s);
			try{
				dvarFile.print(dvName + ":  " + df.format(ControlData.xasolver.getColumnActivity(s)) +"\n"  );
			} catch (Exception e) {
				dvarFile.print(dvName + ":  " + ControlData.xasolver.getColumnActivity(s) +"\n"  );
			}
		}
	}

	private static void writeDvarValue_LPSOLVE(PrintWriter dvarFile, Set<String> dvar_effective) {		
		
		ArrayList<ArrayList<String>> sortedDvar = prepareDvarToWrite(dvar_effective);	
		ArrayList<String> dvar_weighted = sortedDvar.get(0);
		ArrayList<String> dvar_unweighted = sortedDvar.get(1);
		
		dvarFile.println("/* Weighted Dvar    */");
		for (String s : dvar_weighted){
			String dvName = String.format("%-35s", s);
			//dvarFile.print(dvName + ":  " + ControlData.xasolver.getColumnActivity(s) +"\n"  );
			try{
				double v = LPSolveSolver.varDoubleMap.get(s);
				// TODO: improve speed
				if (!df.format(v).equals("-0")) {
					dvarFile.print(dvName + ":  " + df.format(v) +"\n"  );					
				} else {
					dvarFile.print(dvName + ":  0" +"\n"  );				
				}

			} catch (Exception e) {
				dvarFile.print(dvName + ":  " + LPSolveSolver.varDoubleMap.get(s) +"\n"  );
			}
		}
		dvarFile.println();
		dvarFile.println("/* Unweighted Dvar    */");	
		for (String s : dvar_unweighted){
			String dvName = String.format("%-35s", s);
			try{
				double v = LPSolveSolver.varDoubleMap.get(s);
				// TODO: improve speed
				if (!df.format(v).equals("-0")) {
					dvarFile.print(dvName + ":  " + df.format(v) +"\n"  );					
				} else {
					dvarFile.print(dvName + ":  0" +"\n"  );				
				}
				
			} catch (Exception e) {
				dvarFile.print(dvName + ":  " + LPSolveSolver.varDoubleMap.get(s) +"\n"  );
			}
		}
	}

	private static void writeDvarValue_Gurobi(PrintWriter dvarFile, Set<String> dvar_effective) {

		
		ArrayList<ArrayList<String>> sortedDvar = prepareDvarToWrite(dvar_effective);		
		ArrayList<String> dvar_weighted = sortedDvar.get(0);
		ArrayList<String> dvar_unweighted = sortedDvar.get(1);
		
		dvarFile.println("/* Weighted Dvar    */");
		for (String s : dvar_weighted){
			String dvName = String.format("%-35s", s);
			//dvarFile.print(dvName + ":  " + ControlData.xasolver.getColumnActivity(s) +"\n"  );
			try{
				double v = GurobiSolver.varDoubleMap.get(s);
				// TODO: improve speed
				if (!df.format(v).equals("-0")) {
					dvarFile.print(dvName + ":  " + df.format(v) +"\n"  );					
				} else {
					dvarFile.print(dvName + ":  0" +"\n"  );				
				}
	
			} catch (Exception e) {
				dvarFile.print(dvName + ":  " + GurobiSolver.varDoubleMap.get(s) +"\n"  );
			}
		}
		dvarFile.println();
		dvarFile.println("/* Unweighted Dvar    */");	
		for (String s : dvar_unweighted){
			String dvName = String.format("%-35s", s);
			try{
				double v = GurobiSolver.varDoubleMap.get(s);
				// TODO: improve speed
				if (!df.format(v).equals("-0")) {
					dvarFile.print(dvName + ":  " + df.format(v) +"\n"  );					
				} else {
					dvarFile.print(dvName + ":  0" +"\n"  );				
				}
				
			} catch (Exception e) {
				dvarFile.print(dvName + ":  " + GurobiSolver.varDoubleMap.get(s) +"\n"  );
			}
		}
	}

	private static void writeSvarValue(PrintWriter svarFile) {
		
		Map<String, Svar> svMap = ControlData.currSvMap;
		
		ArrayList<String> sortedTerm = new ArrayList<String>(svMap.keySet());
		Collections.sort(sortedTerm);
		


		
		for (String s : sortedTerm){
			String svName = String.format("%-35s", s);
			// TODO: improve speed
			if (!df.format(svMap.get(s).getData().getData()).equals("-0")) {
				svarFile.print(svName + ":  " + df.format(svMap.get(s).getData().getData()) +"\n"  );
			} else {
				svarFile.print(svName + ":   0" +"\n"  );
			}
			
			
//			svarFile.print(svName + ":  ");
//			svarFile.print(df.format(svMap.get(s).getData().getData()));
//			svarFile.print("\n"  );
			
		}

	}
}
