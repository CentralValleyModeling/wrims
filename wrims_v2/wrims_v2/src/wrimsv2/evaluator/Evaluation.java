package wrimsv2.evaluator;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.external.ExternalFunction;
import wrimsv2.external.ExternalFunctionTable;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Stack;

public class Evaluation {

	public static double convertStringToDouble(String text){
		return Double.valueOf(text);
	}
	
	public static double convertStringToInt(String text){
		return Integer.valueOf(text);
	}
	
	public static String convertDoubleToString(double value){
		return Double.toString(value);
	}
	
	public static String assignStatement(String ident, EvalExpression ee){
		if (!ee.isNumeric()){
			Error.addEvaluationError("Decision variable can't be used in table definition");
		}
		return ident+"="+ee.getValue().getData();
	}
	
	public static boolean relationStatement(EvalExpression ee1, EvalExpression ee2, String relation){
		if (!ee1.isNumeric() || !ee2.isNumeric()){
			Error.addEvaluationError("Decision variable can't be used in define condition");
		}
		
		double value1=ee1.getValue().getData().doubleValue();
		double value2=ee2.getValue().getData().doubleValue();
		
		if (relation.equals("==")) {
			if (value1==value2){
				return true;
			}else{
				return false;
			}
		}else if (relation.equals(">")){
			if (value1>value2){
				return true;
			}else{
				return false;
			}
		}else if (relation.equals("<")){
			if (value1<value2){
				return true;
			}else{
				return false;
			}
		}else if (relation.equals(">=")){
			if (value1>=value2){
				return true;
			}else{
				return false;
			}
		}else{
			if (value1<=value2){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static boolean range(String m1, String m2){
		int mon1=TimeOperation.findWaterMonth(m1);
		int mon2=TimeOperation.findWaterMonth(m2);
		
		if (mon1<=mon2){
			if (ControlData.currWaterMonth>=mon1 && ControlData.currWaterMonth<=mon2){
				return true;
			}else{
				return false;
			}
		}else{
			if (ControlData.currWaterMonth>=mon1 || ControlData.currWaterMonth<=mon2){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static boolean relationStatementSeries(boolean r1, boolean r2, String s){
		if (s.equals(".and.")) {
			return (r1 && r2);
		}else{
			return (r1 || r2);
		}
	}
	
	public static EvalConstraint constraintStatement (EvalExpression ee1, EvalExpression ee2, String s) {
		EvalExpression ee=substract(ee1, ee2);
		EvalConstraint ec=new EvalConstraint();
		ec.setEvalExpression(ee);
		ec.setSign(s);
		return ec;
	}
	
	public static EvalExpression term_knownTS(String result){
		EvalExpression ee=new EvalExpression();
		IntDouble intDouble= new IntDouble (convertStringToDouble(result), false);
		ee.setValue(intDouble);
		return ee;
	}
	
	public static EvalExpression term_IDENT (String ident){
		EvalExpression ee=new EvalExpression();
		IntDouble intDouble0 = new IntDouble (0, true);
		ee.setValue(intDouble0);
		HashMap<String, IntDouble> multiplier=ee.getMultiplier();
		IntDouble intDouble= new IntDouble(1,true); 
		multiplier.put(ident, intDouble);
		return ee;
	}
	
	public static EvalExpression term_SVAR (String ident){
		EvalExpression ee=new EvalExpression();
		//To Do: get data from Svar in the IlpData in the current cycle
		IntDouble intDouble = new IntDouble(99999999999.0, false);
		ee.setValue(intDouble);
		return ee;
	}
	
	public static EvalExpression term_INTEGER (String integer){
		EvalExpression ee=new EvalExpression();
		IntDouble intDouble = new IntDouble(convertStringToInt(integer), true);
		ee.setValue(intDouble);
		return ee;
	}
	
	public static EvalExpression term_FLOAT (String floatValue){
		EvalExpression ee=new EvalExpression();
		IntDouble intDouble = new IntDouble(convertStringToDouble(floatValue), false);
		ee.setValue(intDouble);
		return ee;
	}
	
	public static EvalExpression unary (String s, EvalExpression ee){
		if (s !=null){
			if (ee.getValue().isInt()){
				int value=-ee.getValue().getData().intValue();
				ee.getValue().setData(value);
			}else{
				double value=-ee.getValue().getData().doubleValue();
				ee.getValue().setData(value);
			}
			Map<String, IntDouble> multiplier=ee.getMultiplier();
			for (String dvar : multiplier.keySet()) {
				IntDouble intDouble=multiplier.get(dvar);
				if (intDouble.isInt()){
					intDouble.setData(-intDouble.getData().intValue());
				}else{
					intDouble.setData(-intDouble.getData().doubleValue());
				}
				multiplier.put(dvar, intDouble);				
			}
		}
		return ee;
	}
	
	public static EvalExpression mult(EvalExpression ee1, EvalExpression ee2){
		if (ee1.isNumeric()){
			IntDouble id1=ee1.getValue();
			IntDouble id2=ee2.getValue();
			ee2.setValue(multiplyOperation(id1,id2));
			Map<String, IntDouble> multiplier=ee2.getMultiplier();
			for (String dvar : multiplier.keySet()) {
				multiplier.put(dvar, multiplyOperation(id1,multiplier.get(dvar)));				
			}
			return ee2;
		}else{
			if (ee2.isNumeric()){
				IntDouble id2=ee2.getValue();
				IntDouble id1=ee1.getValue();
				ee1.setValue(multiplyOperation(id2,id1));
				Map<String, IntDouble> multiplier=ee1.getMultiplier();
				for (String dvar : multiplier.keySet()) {
					multiplier.put(dvar, multiplyOperation(id2,multiplier.get(dvar)));				
				}
				return ee1;
			}else{
				Error.addEvaluationError("Decision variable multiply decision variable appears. The problem is not linear.");
				return ee1;
			}
		}
	}
	
	public static IntDouble multiplyOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().intValue()*id2.getData().intValue(), true);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()*id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()*id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().doubleValue()*id2.getData().doubleValue(), false);
		}
		return id;
	}
	
	public static EvalExpression divide(EvalExpression ee1, EvalExpression ee2){
		if (ee2.isNumeric()){
			IntDouble id2=ee2.getValue();
			IntDouble id1=ee1.getValue();
			if (id2.getData().doubleValue() ==0.0){
				Error.addEvaluationError("0.0 appears in divisor");
				return ee1;
			}
			ee1.setValue(divideOperation(id1,id2));
			Map<String, IntDouble> multiplier=ee1.getMultiplier();
			for (String dvar : multiplier.keySet()) {
				multiplier.put(dvar, divideOperation(multiplier.get(dvar),id2));				
			}
			return ee1;
		}else{
			Error.addEvaluationError("Decision variable appears in divisor. The problem is not linear.");
			return ee1;
		}
	}
	
	public static IntDouble divideOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().intValue()/id2.getData().intValue(), true);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()/id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()/id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().doubleValue()/id2.getData().doubleValue(), false);
		}
		return id;		
	}
	
	public static EvalExpression mod(EvalExpression ee1, EvalExpression ee2){
		if (ee1.isNumeric() && ee2.isNumeric()){
			IntDouble id1=ee1.getValue();
			IntDouble id2=ee2.getValue();
			ee1.setValue(modOperation(id1,id2));			
			return ee1;
		}else{
			Error.addEvaluationError("Decision variable appears in MOD calcualtion. The problem is not linear.");
			return ee1;
		}
	}
	
	public static IntDouble modOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().intValue()%id2.getData().intValue(), true);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()%id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()%id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().doubleValue()%id2.getData().doubleValue(), false);
		}
		return id;		
	}
	
	public static EvalExpression add(EvalExpression ee1, EvalExpression ee2){
		IntDouble id1=ee1.getValue();
		IntDouble id2=ee2.getValue();
		ee1.setValue(addOperation(id1,id2));
		Map<String, IntDouble> multiplier1=ee1.getMultiplier();
		Map<String, IntDouble> multiplier2=ee2.getMultiplier();
		for (String dvar : multiplier2.keySet()) {
			if (multiplier1.containsKey(dvar)){
				multiplier1.put(dvar, addOperation(multiplier1.get(dvar),multiplier2.get(dvar)));
			}else{
				multiplier1.put(dvar, multiplier2.get(dvar));
			}
		}
		return ee1;
	}
	
	public static IntDouble addOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().intValue()+id2.getData().intValue(), true);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()+id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()+id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().doubleValue()+id2.getData().doubleValue(), false);
		}
		return id;		
	}
	
	public static EvalExpression substract(EvalExpression ee1, EvalExpression ee2){
		IntDouble id1=ee1.getValue();
		IntDouble id2=ee2.getValue();
		ee1.setValue(substractOperation(id1,id2));
		Map<String, IntDouble> multiplier1=ee1.getMultiplier();
		Map<String, IntDouble> multiplier2=ee2.getMultiplier();
		for (String dvar : multiplier2.keySet()) {
			if (multiplier1.containsKey(dvar)){
				multiplier1.put(dvar, substractOperation(multiplier1.get(dvar),multiplier2.get(dvar)));
			}else{
				IntDouble id0=new IntDouble(0,true);
				multiplier1.put(dvar, substractOperation(id0,multiplier2.get(dvar)));
			}
		}
		return ee1;
	}
	
	public static IntDouble substractOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().intValue()-id2.getData().intValue(), true);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()-id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()-id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().doubleValue()-id2.getData().doubleValue(), false);
		}
		return id;		
	}
	
	public static String noArgFunction(String ident){
		//To Do call no ArgFunction
		String result ="99999999999";
		return result;
	}
	
	public static String argFunction(String ident, ArrayList<EvalExpression> eeArray){
		if (eeArray.size()==1){
			//To Do: check if it is dvar or alias or function
		}
		
		if (ExternalFunctionTable.externalFunctionsHashtable ==null){
			Error.addEvaluationError("WRIMS V2 Engine error. Dlls have not been load.");
			return "0.0";
		}
		
		ExternalFunction ef=ExternalFunctionTable.externalFunctionsHashtable.get(ident);
		if (ef == null){
			Error.addEvaluationError("WRIMS V2 Engine error. Dlls have not been load.");
			return "0.0";
		}
		
		Stack stack = new Stack();
		for (int i=0; i<eeArray.size(); i++){
			EvalExpression ee=eeArray.get(i);
			if (!ee.isNumeric()){
				Error.addEvaluationError("argument in the function of "+ident+" contains decision variable.");
				return "0.0";
			}
			
			IntDouble id=ee.getValue();
			if (id.isInt()){
				int value=id.getData().intValue();
				stack.push(value);
			}else{
				double value=id.getData().doubleValue();
				stack.push(value);
			}      
		}
		
		ef.execute(stack);
		String result = ((Number)stack.pop()).toString();
		return result;
	}
	
	public static String pastCycleDV(String ident, String cycle){
		//To Do: add function for getting past cycle dv
		return "9999999";
	}
	
	public static EvalExpression max(EvalExpression ee1, EvalExpression ee2){
		if (!ee1.isNumeric() || !ee2.isNumeric()){
			Error.error_evaluation.add("variable inside max function should not contain decision variable.");
		}
		EvalExpression ee=new EvalExpression();
		ee.setValue(maxOperation(ee1.getValue(), ee2.getValue()));
		return ee;
	}
	
	public static IntDouble maxOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(Math.max(id1.getData().intValue(),id2.getData().intValue()), true);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(Math.max(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(Math.max(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}else{
			id=new IntDouble(Math.max(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static EvalExpression min(EvalExpression ee1, EvalExpression ee2){
		if (!ee1.isNumeric() || !ee2.isNumeric()){
			Error.error_evaluation.add("variable inside min function should not contain decision variable.");
		}
		EvalExpression ee=new EvalExpression();
		ee.setValue(minOperation(ee1.getValue(), ee2.getValue()));
		return ee;
	}
	
	public static IntDouble minOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(Math.min(id1.getData().intValue(),id2.getData().intValue()), true);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(Math.min(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(Math.min(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}else{
			id=new IntDouble(Math.min(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static EvalExpression intFunc(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.error_evaluation.add("variable inside int function should not contain decision variable.");
		}
		EvalExpression ee=new EvalExpression();
		ee.setValue(intOperation(ee1.getValue()));
		return ee;
	}
	
	public static IntDouble intOperation(IntDouble id1){
		IntDouble id;
		if (!id1.isInt()){
			id=new IntDouble(((int)id1.getData().doubleValue()), true);
			return id;
		}
		return id1;
	}
	
	public static EvalExpression abs(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.error_evaluation.add("variable inside abs function should not contain decision variable.");
		}
		EvalExpression ee=new EvalExpression();
		ee.setValue(absOperation(ee1.getValue()));
		return ee;
	}
	
	public static IntDouble absOperation(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.abs(id1.getData().intValue()), true);
		}else{
			id=new IntDouble(Math.abs(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static EvalExpression log(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.error_evaluation.add("variable inside log function should not contain decision variable.");
		}
		EvalExpression ee=new EvalExpression();
		ee.setValue(logOperation(ee1.getValue()));
		return ee;
	}
	
	public static IntDouble logOperation(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.log(id1.getData().intValue()), false);
		}else{
			id=new IntDouble(Math.log(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static EvalExpression log10(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.error_evaluation.add("variable inside log10 function should not contain decision variable.");
		}
		EvalExpression ee=new EvalExpression();
		ee.setValue(log10Operation(ee1.getValue()));
		return ee;
	}
	
	public static IntDouble log10Operation(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.log10(id1.getData().intValue()), false);
		}else{
			id=new IntDouble(Math.log10(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static EvalExpression pow(EvalExpression ee1, EvalExpression ee2){
		if (!ee1.isNumeric() || !ee2.isNumeric()){
			Error.error_evaluation.add("variable inside pow function should not contain decision variable.");
		}
		EvalExpression ee=new EvalExpression();
		ee.setValue(powOperation(ee1.getValue(), ee2.getValue()));
		return ee;
	}
	
	public static IntDouble powOperation(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id1.isInt() && id2.isInt()){
			id=new IntDouble(Math.pow(id1.getData().intValue(),id2.getData().intValue()), false);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(Math.pow(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(Math.pow(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}else{
			id=new IntDouble(Math.pow(id1.getData().doubleValue(),id2.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static EvalExpression daysIn(){
		int days=TimeOperation.numberOfDays(ControlData.currWaterMonth, ControlData.currWaterYear);
		IntDouble id=new IntDouble(days, true);
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		return ee;
	}
	
	public static EvalExpression tafcfs_term(String ident, EvalExpression ee){
		if (ee==null){
			ControlData.dataWaterMonth=ControlData.currWaterMonth;
			ControlData.dataWaterYear=ControlData.dataWaterYear;
		}else{
			if (!ee.isNumeric()){
				Error.error_evaluation.add("The index of "+ident+" should not contain decision variable.");
			}
			IntDouble id=ee.getValue();
			if (!id.isInt()){
				Error.error_evaluation.add("The index of "+ident+" should be integer.");
			}
			TimeOperation.findTime(id.getData().intValue());
		}
		double convert = tafcfs(ident);
		IntDouble id1=new IntDouble(convert, false);
		EvalExpression ee1=new EvalExpression();
		ee1.setValue(id1);
		return ee1;
	}
	
	public static double tafcfs(String ident){
		double convert;
		int days=TimeOperation.numberOfDays(ControlData.dataWaterMonth, ControlData.dataWaterYear);
		if (ident.equals("taf_cfs")){
			return 504.1666667 / days;
		}else if (ident.equals("cfs_taf")){
			return days / 504.1666667;
		}else if (ident.equals("af_cfs")){
			return 504.1666667 / days / 1000.;
		}else{
			return days / 504.1666667 * 1000.;
		}
	}
	
	public static IntDouble expressionInput(EvalExpression ee){
		if (!ee.isNumeric()){
			Error.addEvaluationError("the value is not numeric and contains decision variable");
		}
		return ee.getValue();
	}
}
