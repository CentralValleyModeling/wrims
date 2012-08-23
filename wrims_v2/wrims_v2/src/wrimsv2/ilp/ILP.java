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

import lpsolve.LpSolveException;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.Tools;

// for LpSolve select 1.Rows 2.Cols 3.Elimeq2 in Presolve

public class ILP {

	private static File _lpSolveParentDir;
	private static File _cplexLpParentDir;
	private static File _amplParentDir;
	private static String _lpSolveDir;
	private static String _cplexLpDir;
	public static String lpSolveFilePath;
	public static String cplexLpFilePath;
	private static PrintWriter _lpSolveFile;
	private static PrintWriter _cplexLpFile;
	private static PrintWriter _amplFile;
	private static PrintWriter _svarFile;
	private static PrintWriter _dvarFile;
	private static Set<String> dvar_effective;
	private static final String lpSolve_comment_Symbol = "//";
	private static final String ampl_comment_Symbol = "#";
	private static final String cplexLp_comment_Symbol = "\\";
	private static DecimalFormat df;
	public static int maximumFractionDigits = 8;
	public static boolean loggingVariableValue = false;
	public static boolean logging = false;
	public static boolean loggingAmpl = false;
	public static boolean loggingCplexLp = false;
	
	private ILP() {
		
	}

	public static void initializeIlp() {
		
		setLpSolveParentDir();
		if(ILP.loggingCplexLp) setCplexLpParentDir();
		if(ILP.loggingAmpl) setAmplParentDir();
		// TODO: write ampl command file "option presolve_eps 1e-13;"
		
		
		//TODO: move to somewhere else
		df = new DecimalFormat();
		//df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(maximumFractionDigits);
	}
	
	public static void setIlpFile() {
		
		setLpSolveFile();
		if (ILP.loggingCplexLp) setCplexLpFile();		
		if (ILP.loggingAmpl) setAmplFile();		
	}

	public static void writeIlp() {
		
		writeLpSolveFile();
		if (ILP.loggingCplexLp) writeCplexLpFile();
		if (ILP.loggingAmpl) writeAmplFile();
		
		_lpSolveFile.flush();
		if (ILP.loggingCplexLp) _cplexLpFile.flush();
		if (ILP.loggingAmpl) _amplFile.flush();
	}

	public static void writeObjValue_XA() {
		
		double objValue = ControlData.xasolver.getObjective();
		writeObjValue(Double.toString(objValue), _lpSolveFile, lpSolve_comment_Symbol);
		if (ILP.loggingCplexLp) writeObjValue(Double.toString(objValue), _cplexLpFile, cplexLp_comment_Symbol);
		if (ILP.loggingAmpl) writeObjValue(Double.toString(objValue), _amplFile, ampl_comment_Symbol);
	
	}
	
	public static void writeObjValue_LPSOLVE() {
		
		double objValue;
		//try {
			objValue = ControlData.lpsolve_objective;
			writeObjValue(Double.toString(objValue), _lpSolveFile, lpSolve_comment_Symbol);
			if (ILP.loggingCplexLp) writeObjValue(Double.toString(objValue), _cplexLpFile, cplexLp_comment_Symbol);
			if (ILP.loggingAmpl) writeObjValue(Double.toString(objValue), _amplFile, ampl_comment_Symbol);
		//}
//		catch (LpSolveException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			writeObjValue(" LpSolveException Error! ", _lpSolveFile, lpSolve_comment_Symbol);
//			writeObjValue(" LpSolveException Error! ", _amplFile, ampl_comment_Symbol);
//		}

	
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
	
	public static void writeDvarValue_XA() {
		
		writeDvarValue_XA(_dvarFile, dvar_effective);
		_dvarFile.flush();
		
	}
	public static void writeDvarValue_LPSOLVE() {
		
		writeDvarValue_LPSOLVE(_dvarFile, dvar_effective);
		_dvarFile.flush();
		
	}
	public static void writeSvarValue() {
		
		writeSvarValue(_svarFile);
		_svarFile.flush();
	}
	
	public static void closeIlpFile() {
	
		try {
			_lpSolveFile.close();
			if (ILP.loggingCplexLp) _cplexLpFile.close();
			if (ILP.loggingAmpl) _amplFile.close();
			_svarFile.close();
			_dvarFile.close();
		} catch (Exception e) {

			// ignore
		}
	}
	private static void setLpSolveParentDir() {
	
		File lpSolveGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=LpSolve=");  
		_lpSolveParentDir = new File(lpSolveGrandParentDir.getAbsolutePath(), StudyUtils.configFileName); 
		_lpSolveDir = new File(_lpSolveParentDir, "lpsolve").getAbsolutePath();
	
	}
	private static void setCplexLpParentDir() {
		
		File cplexLpGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=CplexLp=");  
		_cplexLpParentDir = new File(cplexLpGrandParentDir.getAbsolutePath(), StudyUtils.configFileName); 
		_cplexLpDir = new File(_cplexLpParentDir, "cplexlp").getAbsolutePath();
	
	}
	private static void setAmplParentDir() {
		
		
		File amplGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=AMPL=");  
		_amplParentDir = new File(amplGrandParentDir.getAbsolutePath(), StudyUtils.configFileName); 		
		//_amplDir = new File(_amplParentDir, "ampl").getAbsolutePath();
		
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
			//lpSolveDir = new File(_lpSolveParentDir, "lpsolve").getAbsolutePath();
			String varDir = new File(_lpSolveParentDir, "var").getAbsolutePath();
			
			_lpSolveFile = Tools.openFile(_lpSolveDir, lpSolveFileName);
			lpSolveFilePath = new File(_lpSolveDir, lpSolveFileName).getAbsolutePath(); // for public access
			if (ILP.loggingVariableValue) _svarFile = Tools.openFile(varDir, svarFileName);
			if (ILP.loggingVariableValue) _dvarFile = Tools.openFile(varDir, dvarFileName);
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	private static void setCplexLpFile() {
		
		String cplexLpFileName;
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1); 
		
		cplexLpFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".lp";		

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

	private static void writeDvarValue_XA(PrintWriter dvarFile, Set<String> dvar_effective) {
		
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, WeightElement> wtMap = SolverData.getWeightMap();
		//Map<String, WeightElement> wtSlackSurplusMap = SolverData.getWeightSlackSurplusMap();
		
		ArrayList<String> dvar_weighted = new ArrayList<String>(wtMap.keySet());
		dvar_weighted.addAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		
		ArrayList<String> dvar_unweighted = new ArrayList<String>(dvMap.keySet());
		dvar_unweighted.removeAll(wtMap.keySet());
		dvar_unweighted.removeAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		
		dvar_unweighted.retainAll(dvar_effective);
		Collections.sort(dvar_weighted);
		Collections.sort(dvar_unweighted);
		
		
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
		
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, WeightElement> wtMap = SolverData.getWeightMap();
		//Map<String, WeightElement> wtSlackSurplusMap = SolverData.getWeightSlackSurplusMap();
		
		ArrayList<String> dvar_weighted = new ArrayList<String>(wtMap.keySet());
		dvar_weighted.addAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		
		ArrayList<String> dvar_unweighted = new ArrayList<String>(dvMap.keySet());
		dvar_unweighted.removeAll(wtMap.keySet());
		dvar_unweighted.removeAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		
		dvar_unweighted.retainAll(dvar_effective);
		Collections.sort(dvar_weighted);
		Collections.sort(dvar_unweighted);
		
		
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
