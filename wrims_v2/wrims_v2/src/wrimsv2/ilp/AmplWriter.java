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

public class AmplWriter {

	private static PrintWriter _amplFile;
	private static PrintWriter _svarFile;
	private static PrintWriter _dvarFile;
	private static File amplParentDir;

	private AmplWriter() {

	}

//	public static void setAmplFile(String dirPath) {
//
//		String amplFileName;
//		String svarFileName;
//		String dvarFileName;
//		String twoDigitMonth = String.format("%02d", ControlData.currMonth);
//		String twoDigitCycle = String.format("%02d", ControlData.currCycleIndex+1);
//
//		
//		if (dirPath.length() > 1) {
//			amplParentDir = new File(dirPath);
//		} else {
//			File ilpGrandParentDir = new File(FilePaths.mainDirectory, "=ILP=\\=AMPL=");  
//			amplParentDir = new File(ilpGrandParentDir.getAbsolutePath(), FilePaths.configFileName); 
//		}
//		
//		if (FilePaths.amplFile.length() > 4) {
//			amplFileName = FilePaths.amplFile;
//		} else {
//			amplFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".mod";
//		}
//		
//		svarFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".svar";
//		dvarFileName = ControlData.currYear + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".dvar";
//		// System.out.println("################# "+fileName);
//		// System.out.println("################# "+System.getProperty("user.dir")+"\\"+dirPath);
//		try {
//			//_ilpFile = Tools.openFile(System.getProperty("user.dir") + "\\" + dirPath, fileName);
//			
//			String amplDir = new File(amplParentDir, "ampl").getAbsolutePath();
//			String varDir = new File(amplParentDir, "var").getAbsolutePath();
//			//private static File ilpDir = new File(ilpParentDir, "ilp");
//			
//			_amplFile = Tools.openFile(amplDir, amplFileName);
//			_svarFile = Tools.openFile(varDir, svarFileName);
//			_dvarFile = Tools.openFile(varDir, dvarFileName);
//
//		}
//		catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//	}

	public static void closeAmplFile() {

		_amplFile.close();
		_svarFile.close();
		_dvarFile.close();
	}

	public static Set<String> output() {

		Set<String> usedDvar = new HashSet<String>();
		
		writeInfo();
		_amplFile.print("\n");

		String cs=writeConstraintToString(usedDvar);
		Set<String> usedDvarInWeight = new HashSet<String>();
		String objS = writeObjToString(usedDvarInWeight);
		usedDvar.addAll(usedDvarInWeight);
		writeDvar(usedDvar);
		_amplFile.print("\n");
		_amplFile.print(cs);
		_amplFile.print("\n");
		_amplFile.print(objS);
		_amplFile.flush();
		
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
		
		_amplFile.println("# /* Date: "+CurrDate+"    */");
		_amplFile.println("# /* Cycle: "+twoDigitCycle+"    */");
		_amplFile.println("# /* Solver: "+ControlData.solverName+"    */");
		_amplFile.flush();
		
	}
	
	public static void writeObjValue() {
		
		double objValue = ControlData.xasolver.getObjective();
		_amplFile.println("\n");
		_amplFile.println("\n");
		if (Error.getTotalError()==0) {
		_amplFile.println("# /* objective value:   "+objValue+"    */");
		} else {
		_amplFile.println("# /* objective value:   Error!   */");	
		}
		_amplFile.flush();
	}
	
	// return dvarInWeight
	private static String writeObjToString(Set<String> usedDvarInWeight) {
		
		String ObjString = "";
		
		ObjString = "# objective function \n";
		ObjString = ObjString + "maximize Obj:  \n";
		//_amplFile.println("# /* objective function */");
		//_amplFile.println("maximize Obj: ");

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

				toPrint = toPrint + "+ " + weight + " * " + dvar.toUpperCase() + " ";
				ObjString = ObjString + "+ " + weight + " * " + dvar.toUpperCase() + "\n";
				//_amplFile.println("+ " + weight + " * " + dvar.toUpperCase());

			}
			else {
				toPrint = toPrint + weight + " * " + dvar.toUpperCase() + " ";
				ObjString = ObjString + weight + " * " + dvar.toUpperCase() + "\n";
				//_amplFile.println(weight + " * " + dvar.toUpperCase());
			}

		}

		// _ilpFile.println(toPrint);
		ObjString = ObjString + ";";
		usedDvarInWeight.addAll(sortedTerm);
		
		return ObjString;

	}

	// output usedDvar Set
	private static String writeConstraintToString(Set<String> usedDvar) {

		String constraintString = "";
		
		//usedDvar = new HashSet<String>();
		//_amplFile.println("# /* constraint */");
		constraintString = "# /* constraint */" + "\n";
		
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
						term = " + " + var.toUpperCase();
					}
					else if (coefDouble == -1.0) {
						term = " - " + var.toUpperCase();
					}
					else if (coefDouble < 0) {
						term = " " + coefStr + " * " + var.toUpperCase();
					}
					else { // coefDouble >= 0
						term = " + " + coefStr + " * " + var.toUpperCase();
					}
					lhs = lhs + term;
				}

			}
			else {

				lhs = "0";
			}

			// TODO: improve this
			String sign = constraintMap.get(constraintName).getSign()+"=";
			sign= sign.replace("==", "=");
			double val = constraintMap.get(constraintName).getEvalExpression().getValue().getData().doubleValue();

			if (val == 0) {
				lhs = constraintName.toUpperCase() + ": " + lhs + " " + sign + " " + "0";
			}
			else {
				lhs = constraintName.toUpperCase() + ": " + lhs + " " + sign + " " + val * -1;
			}

			//_amplFile.println("subject to "+lhs + " ;");
			constraintString = constraintString + "subject to "+lhs + " ;\n";

		}
		return constraintString;
	}

	private static void writeDvar(Set<String> usedDvar) {

		_amplFile.println("# /* dvar */");

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



			if (lowerStr.equalsIgnoreCase(Param.lower_unbounded) && upperStr.equalsIgnoreCase(Param.upper_unbounded)) {
				freeList.add(key);
				continue;
			}
			else if (lowerStr.equalsIgnoreCase(Param.lower_unbounded)) {
				toPrint = key.toUpperCase() + " <= " + upper;
				_amplFile.print("var "+toPrint );
			}
			else if (upperStr.equalsIgnoreCase(Param.upper_unbounded)) {

				_amplFile.print("var "+key.toUpperCase() + " >= " + lower );

			}
			else {

				_amplFile.print("var "+key.toUpperCase() + " >= " + lower + " <= " + upper );

				//_amplFile.print("var "+key.toUpperCase() + " <= " + upper );
			}

			if (dvarMap.get(key).integer.equalsIgnoreCase(Param.yes)) {
				//intList.add(key);
				_amplFile.print(" integer ;\n");
			} else {
				_amplFile.print(" ;\n");
			}
			
		}

//		if (intList.size() > 0) {
//			_amplFile.print("int ");
//
//			for (int i = 0; i < intList.size(); i++) {
//				String term = intList.get(i);
//
//				if (i == 0) {
//					_amplFile.print(term);
//				}
//				else {
//					_amplFile.print(", " + term);
//				}
//			}
//
//			_amplFile.print(" ;\n");
//		}

		if (freeList.size() > 0) {

			for (int i = 0; i < freeList.size(); i++) {
				String term = freeList.get(i);

				_amplFile.print("var "+term.toUpperCase()+" ;\n");

			}

		}
	}

}
