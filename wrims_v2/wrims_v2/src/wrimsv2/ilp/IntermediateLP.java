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
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.Error;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.evaluator.EvalConstraint;

// for LpSolve select 1.Rows 2.Cols 3.Elimeq2 in Presolve

public class IntermediateLP {

	private static PrintWriter _ilpFile;
	private static PrintWriter _svarFile;
	private static PrintWriter _dvarFile;
	private static File ilpParentDir;

	public IntermediateLP() {

	}

	public static void setIlpFile(String dirPath) {

		String ilpFileName;
		String svarFileName;
		String dvarFileName;
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);

		
		if (dirPath.length() > 1) {
			ilpParentDir = new File(dirPath);
		} else {
			File ilpGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=");  
			ilpParentDir = new File(ilpGrandParentDir.getAbsolutePath(), FilePaths.ilpFileDirectory_append); 
		}
		
		if (FilePaths.ilpFile.length() > 4) {
			ilpFileName = FilePaths.ilpFile;
		} else {
			ilpFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".ilp";
		}
		
		svarFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".svar";
		dvarFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".dvar";
		// System.out.println("################# "+fileName);
		// System.out.println("################# "+System.getProperty("user.dir")+"\\"+dirPath);
		try {
			//_ilpFile = Tools.openFile(System.getProperty("user.dir") + "\\" + dirPath, fileName);
			
			String ilpDir = new File(ilpParentDir, "ilp").getAbsolutePath();
			String varDir = new File(ilpParentDir, "var").getAbsolutePath();
			//private static File ilpDir = new File(ilpParentDir, "ilp");
			
			_ilpFile = Tools.openFile(ilpDir, ilpFileName);
			_svarFile = Tools.openFile(varDir, svarFileName);
			_dvarFile = Tools.openFile(varDir, dvarFileName);

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void closeIlpFile() {

		_ilpFile.close();
		_svarFile.close();
		_dvarFile.close();
	}

	public static Set<String> output() {
		
		writeInfo();
		writeObj();
		_ilpFile.print("\n");
		Set<String> usedDvar=writeConstraint();
		_ilpFile.print("\n");
		writeDvar(usedDvar);
		_ilpFile.flush();
		
		// write to _svarFile
		writeSvarValue();
		return usedDvar;
	}

	public static void writeDvarValue(Set<String> usedDvar) {
		
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, WeightElement> wtMap = SolverData.getWeightMap();
		//Map<String, WeightElement> wtSlackSurplusMap = SolverData.getWeightSlackSurplusMap();
		
		ArrayList<String> dvar_weighted = new ArrayList<String>(wtMap.keySet());
		dvar_weighted.addAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		
		ArrayList<String> dvar_unweighted = new ArrayList<String>(dvMap.keySet());
		dvar_unweighted.removeAll(wtMap.keySet());
		dvar_unweighted.removeAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		
		dvar_unweighted.retainAll(usedDvar);
		Collections.sort(dvar_weighted);
		Collections.sort(dvar_unweighted);
		
		
		_dvarFile.println("/* Weighted Dvar    */");
		for (String s : dvar_weighted){
			String dvName = String.format("%-35s", s);
			_dvarFile.print(dvName + ":  " + ControlData.xasolver.getColumnActivity(s) +"\n"  );
		}
		_dvarFile.println();
		_dvarFile.println("/* Unweighted Dvar    */");	
		for (String s : dvar_unweighted){
			String dvName = String.format("%-35s", s);
			_dvarFile.print(dvName + ":  " + ControlData.xasolver.getColumnActivity(s) +"\n"  );
		}
	}	
	
	private static void writeSvarValue() {
		
		Map<String, Svar> svMap = ControlData.currSvMap;
		
		ArrayList<String> sortedTerm = new ArrayList<String>(svMap.keySet());
		Collections.sort(sortedTerm);
		
		for (String s : sortedTerm){
			String svName = String.format("%-35s", s);
			_svarFile.print(svName + ":  " + svMap.get(s).getData().getData() +"\n"  );
			
		}
	}
	
	private static void writeInfo() {
		
		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);
		
		String CurrDate = Integer.toString(ControlData.currYear)+"."
		                 + twoDigitMonth;
		
		_ilpFile.println("/* Date: "+CurrDate+"    */");
		_ilpFile.println("/* Cycle: "+twoDigitCycle+"    */");
		_ilpFile.println("/* Solver: "+ControlData.solverName+"    */");
		_ilpFile.flush();
		
	}
	
	public static void writeObjValue() {
		
		double objValue = ControlData.xasolver.getObjective();
		_ilpFile.println("\n");
		_ilpFile.println("\n");
		if (Error.getTotalError()==0) {
		_ilpFile.println("/* objective value:   "+objValue+"    */");
		} else {
		_ilpFile.println("/* objective value:   Error!   */");	
		}
		_ilpFile.flush();
	}
	
	private static void writeObj() {

		_ilpFile.println("/* objective function */");
		_ilpFile.println("max: ");

		//Map<String, WeightElement> weightMap = SolverData.getWeightMap();
		Map<String, WeightElement> allWeightMap = new HashMap<String, WeightElement>();
		allWeightMap.putAll(SolverData.getWeightMap());
		allWeightMap.putAll(SolverData.getWeightSlackSurplusMap());
		String toPrint = "";

		ArrayList<String> sortedTerm = new ArrayList<String>(SolverData.getWeightMap().keySet());
		sortedTerm.addAll(ControlData.currModelDataSet.usedWtSlackSurplusList);
		Collections.sort(sortedTerm);

		for (String dvar : sortedTerm) {

			double weight = allWeightMap.get(dvar).getValue();

			if (weight > 0) {

				toPrint = toPrint + "+ " + weight + " " + dvar + " ";
				_ilpFile.println("+ " + weight + " " + dvar);

			}
			else {
				toPrint = toPrint + weight + " " + dvar + " ";
				_ilpFile.println(weight + " " + dvar);
			}

		}

		// _ilpFile.println(toPrint);
		_ilpFile.println(";");

	}

	private static Set<String> writeConstraint() {

		Set<String> usedDvar = new HashSet<String>();
		_ilpFile.println("/* constraint */");

		Map<String, EvalConstraint> constraintMap = SolverData.getConstraintDataMap();

		ArrayList<String> sortedConstraint = new ArrayList<String>(constraintMap.keySet());
		Collections.sort(sortedConstraint);

		for (String constraintName : sortedConstraint) {

			String lhs = "";

			if (!constraintMap.get(constraintName).getEvalExpression().isNumeric()) {

				ArrayList<String> sortedTerm = new ArrayList<String>(constraintMap.get(constraintName)
						.getEvalExpression().getMultiplier().keySet());
				Collections.sort(sortedTerm);
				usedDvar.addAll(sortedTerm);
				for (String var : sortedTerm) {

					Number coef = constraintMap.get(constraintName).getEvalExpression().getMultiplier().get(var)
							.getData();
					double coefDouble = coef.doubleValue();
					String coefStr = coef.toString();
					String term;

					if (coefDouble == 1.0) {
						term = " + " + var;
					}
					else if (coefDouble == -1.0) {
						term = " - " + var;
					}
					else if (coefDouble < 0) {
						term = " " + coefStr + " " + var;
					}
					else { // coefDouble >= 0
						term = " + " + coefStr + " " + var;
					}
					lhs = lhs + term;
				}

			}
			else {

				lhs = "0";
			}

			String sign = constraintMap.get(constraintName).getSign();
			double val = constraintMap.get(constraintName).getEvalExpression().getValue().getData().doubleValue();

			if (val == 0) {
				lhs = constraintName + ": " + lhs + " " + sign + " " + "0";
			}
			else {
				lhs = constraintName + ": " + lhs + " " + sign + " " + val * -1;
			}

			_ilpFile.println(lhs + " ;");

		}
		return usedDvar;
	}

	private static void writeDvar(Set<String> usedDvar) {

		_ilpFile.println("/* dvar */");

		Map<String, Dvar> dvarMap = SolverData.getDvarMap();
		ArrayList<String> sortedDvar = new ArrayList<String>(dvarMap.keySet());
		sortedDvar.retainAll(usedDvar);
		Collections.sort(sortedDvar);

		ArrayList<String> intList = new ArrayList<String>();
		ArrayList<String> freeList = new ArrayList<String>();

		for (String key : sortedDvar) {

			double lower = dvarMap.get(key).lowerBoundValue.doubleValue();
			double upper = dvarMap.get(key).upperBoundValue.doubleValue();
			String lowerStr = dvarMap.get(key).lowerBound;
			String upperStr = dvarMap.get(key).upperBound;
			String toPrint = null;

			if (dvarMap.get(key).integer.equalsIgnoreCase(Param.yes)) {
				intList.add(key);
			}

			if (lowerStr.equalsIgnoreCase(Param.lower_unbounded) && upperStr.equalsIgnoreCase(Param.upper_unbounded)) {
				freeList.add(key);
				continue;
			}
			else if (lowerStr.equalsIgnoreCase(Param.lower_unbounded)) {
				toPrint = key + " < " + upper;
				_ilpFile.print(toPrint + " ;\n");
			}
			else if (upperStr.equalsIgnoreCase(Param.upper_unbounded)) {

				if (lower != 0) _ilpFile.print(key + " > " + lower + " ;\n");

			}
			else {

				if (lower != 0) _ilpFile.print(key + " > " + lower + " ;\n");

				_ilpFile.print(key + " < " + upper + " ;\n");
			}

		}

		if (intList.size() > 0) {
			_ilpFile.print("int ");

			for (int i = 0; i < intList.size(); i++) {
				String term = intList.get(i);

				if (i == 0) {
					_ilpFile.print(term);
				}
				else {
					_ilpFile.print(", " + term);
				}
			}

			_ilpFile.print(" ;\n");
		}

		if (freeList.size() > 0) {
			_ilpFile.print("free ");

			for (int i = 0; i < freeList.size(); i++) {
				String term = freeList.get(i);

				if (i == 0) {
					_ilpFile.print(term);
				}
				else {
					_ilpFile.print(", " + term);
				}
			}

			_ilpFile.print(" ;\n");
		}
	}

}
