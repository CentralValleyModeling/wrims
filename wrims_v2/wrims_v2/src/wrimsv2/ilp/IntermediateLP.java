package wrimsv2.ilp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.evaluator.EvalConstraint;

// for LpSolve select 1.Rows 2.Cols 3.Elimeq2 in Presolve

public class IntermediateLP {

	private static PrintWriter _ilpFile;

	public IntermediateLP() {

	}

	public static void setIlpFile(String dirPath) {

		String fileName;

		if (FilePaths.ilpFile.length() > 3) {
			fileName = FilePaths.ilpFile;
		}
		else {
			fileName = ControlData.currTimeStep + "_" + ControlData.currCycleIndex + ".ilp";
		}
		// System.out.println("################# "+fileName);
		// System.out.println("################# "+System.getProperty("user.dir")+"\\"+dirPath);
		try {
			_ilpFile = Tools.openFile(System.getProperty("user.dir") + "\\" + dirPath, fileName);

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void closeIlpFile() {

		_ilpFile.close();
	}

	public static void output() {

		writeObj();
		_ilpFile.print("\n");
		writeConstraint();
		_ilpFile.print("\n");
		writeDvar();
		_ilpFile.flush();
	}

	public static void writeObjValue() {
		
		double objValue = ControlData.xasolver.getObjective();
		_ilpFile.println("\n");
		_ilpFile.println("\n");
		_ilpFile.println("/* objective value: "+objValue+"    */");
		_ilpFile.flush();
	}
	
	private static void writeObj() {

		_ilpFile.println("/* objective function */");
		_ilpFile.println("max: ");

		Map<String, WeightElement> weightMap = SolverData.getWeightMap();

		String toPrint = "";

		ArrayList<String> sortedTerm = new ArrayList<String>(weightMap.keySet());
		Collections.sort(sortedTerm);

		for (String dvar : sortedTerm) {

			double weight = weightMap.get(dvar).getValue();

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

	private static void writeConstraint() {

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
	}

	private static void writeDvar() {

		_ilpFile.println("/* dvar */");

		Map<String, Dvar> dvarMap = SolverData.getDvarMap();
		ArrayList<String> sortedDvar = new ArrayList<String>(dvarMap.keySet());
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
