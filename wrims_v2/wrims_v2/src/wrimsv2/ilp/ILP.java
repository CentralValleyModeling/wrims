package wrimsv2.ilp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.wreslparser.elements.Tools;

// for LpSolve select 1.Rows 2.Cols 3.Elimeq2 in Presolve

public class ILP {

	private static File _lpSolveParentDir;
	private static File _amplParentDir;
	private static PrintWriter _lpSolveFile;
	private static PrintWriter _amplFile;
	private static PrintWriter _svarFile;
	private static PrintWriter _dvarFile;
	private static Set<String> dvar_effective;
	private static final String lpSolve_comment_Symbol = "//";
	private static final String ampl_comment_Symbol = "#";

	private ILP() {

	}

	public static void initializeIlp() {
		
		setLpSolveParentDir();
		setAmplParentDir();
		// TODO: write ampl command file "option presolve_eps 1e-13;"
	}
	
	public static void setIlpFile() {
		
		setLpSolveFile();
		setAmplFile();		
	}

	public static void writeIlp() {
		
		writeLpSolveFile();
		writeAmplFile();
		
		_lpSolveFile.flush();
		_amplFile.flush();
	}

	public static void writeObjValue_XA() {
		

		writeObjValue_XA(_lpSolveFile, lpSolve_comment_Symbol);
		writeObjValue_XA(_amplFile, ampl_comment_Symbol);
	
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

	}
	
	public static void writeDvarValue() {
		
		LpSolveWriter.writeDvarValue(_dvarFile, dvar_effective);
		
	}

	public static void writeSvarValue() {
		
		LpSolveWriter.writeSvarValue(_svarFile);
		
	}
	
	public static void closeIlpFile() {
	
		_lpSolveFile.close();
	    _amplFile.close();
		_svarFile.close();
		_dvarFile.close();
	}
	private static void setLpSolveParentDir() {
	
		File lpSolveGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=LpSolve=");  
		_lpSolveParentDir = new File(lpSolveGrandParentDir.getAbsolutePath(), FilePaths.configFileName); 		
	
	}
	private static void setLpSolveFile() {
	
		String lpSolveFileName;
		String svarFileName;
		String dvarFileName;
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);
	
		//File lpSolveGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=LpSolve=");  
		//File lpSolveParentDir = new File(lpSolveGrandParentDir.getAbsolutePath(), FilePaths.configFileName); 
		
		lpSolveFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".lps";		
		
		svarFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".svar";
		dvarFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".dvar";

		try {
			String ilpDir = new File(_lpSolveParentDir, "lpsolve").getAbsolutePath();
			String varDir = new File(_lpSolveParentDir, "var").getAbsolutePath();
			
			_lpSolveFile = Tools.openFile(ilpDir, lpSolveFileName);
			_svarFile = Tools.openFile(varDir, svarFileName);
			_dvarFile = Tools.openFile(varDir, dvarFileName);
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	private static void setAmplParentDir() {
		
		File amplGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=AMPL=");  
		_amplParentDir = new File(amplGrandParentDir.getAbsolutePath(), FilePaths.configFileName); 		
	
	}
	private static void setAmplFile() {
		
		String amplFileName;
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);
	
		//File ilpGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=AMPL=");  
		//File lpSolveParentDir = new File(ilpGrandParentDir.getAbsolutePath(), FilePaths.configFileName); 
		
		amplFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".mod";				

		try {
			String ilpDir = new File(_amplParentDir, "ampl").getAbsolutePath();
			
			_amplFile = Tools.openFile(ilpDir, amplFileName);	
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


	
	private static void writeObjValue_XA(PrintWriter outFile, String commentSym) {		

		double objValue = ControlData.xasolver.getObjective();
		
		outFile.print("\n\n\n\n");		
		if (Error.getTotalError()==0) {
			outFile.println(commentSym+" objective value:   "+objValue);
		} else {
			outFile.println(commentSym+" objective value:   Error! ");	
		}
		outFile.flush();
	}
}
