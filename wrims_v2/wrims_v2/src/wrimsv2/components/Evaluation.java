package wrimsv2.components;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;

import java.util.HashMap;
import java.util.Map;

public class Evaluation {

	public static double convertStringToDouble(String text){
		return Double.valueOf(text);
	}
	
	public static String convertDoubleToString(double value){
		return Double.toString(value);
	}
	
	public static String assignStatement(String ident, EvalExpression ee){
		if (!ee.isNumeric()){
			Error.addEvaluationError("Decision variable can't be used in table definition");
		}
		return ident+"="+ee.getValue();
	}
	
	public static boolean relationStatement(EvalExpression ee1, EvalExpression ee2, String relation){
		if (!ee1.isNumeric() || !ee2.isNumeric()){
			Error.addEvaluationError("Decision variable can't be used in define condition");
		}
		double value1=convertStringToDouble(ee1.getValue());
		double value2=convertStringToDouble(ee2.getValue());
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
		int mon1=ControlData.findWaterMonth(m1);
		int mon2=ControlData.findWaterMonth(m2);
		
		if (mon1<=mon2){
			if (ControlData.currMonth>=mon1 && ControlData.currMonth<=mon2){
				return true;
			}else{
				return false;
			}
		}else{
			if (ControlData.currMonth>=mon1 || ControlData.currMonth<=mon2){
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
		EvalExpression ee=minus(ee1, ee2);
		EvalConstraint ec=new EvalConstraint();
		ec.setEvalExpression(ee);
		ec.setSign(s);
		return ec;
	}
	
	public static EvalExpression term_IDENT (String ident){
		EvalExpression ee=new EvalExpression();
		HashMap<String, Double> multiplier=ee.getMultiplier();
		multiplier.put(ident, 1.0);
		return ee;
	}
	
	public static EvalExpression term_SVAR (String ident){
		EvalExpression ee=new EvalExpression();
		//To Do: get data from Svar in the IlpData in the current cycle
		ee.setValue("99999999999.0");
		return ee;
	}
	
	public static EvalExpression term_INTEGER (String integer){
		EvalExpression ee=new EvalExpression();
		ee.setValue(integer);
		return ee;
	}
	
	public static EvalExpression term_FLOAT (String floatValue){
		EvalExpression ee=new EvalExpression();
		ee.setValue(floatValue);
		return ee;
	}
	
	public static EvalExpression unary (String s, EvalExpression ee){
		if (s !=null){
			double value=-convertStringToDouble(ee.getValue());
			ee.setValue(convertDoubleToString(value));
			Map<String, Double> multiplier=ee.getMultiplier();
			for (String dvar : multiplier.keySet()) {
				multiplier.put(dvar, -multiplier.get(dvar));				
			}
		}
		return ee;
	}
	
	public static EvalExpression mult(EvalExpression ee1, EvalExpression ee2){
		if (ee1.isNumeric()){
			double value1=convertStringToDouble(ee1.getValue());
			double value2=convertStringToDouble(ee2.getValue());
			ee2.setValue(convertDoubleToString(value1*value2));
			Map<String, Double> multiplier=ee2.getMultiplier();
			for (String dvar : multiplier.keySet()) {
				multiplier.put(dvar, value1*multiplier.get(dvar));				
			}
			return ee2;
		}else{
			if (ee2.isNumeric()){
				double value2=convertStringToDouble(ee2.getValue());
				double value1=convertStringToDouble(ee1.getValue());
				ee1.setValue(convertDoubleToString(value2*value1));
				Map<String, Double> multiplier=ee1.getMultiplier();
				for (String dvar : multiplier.keySet()) {
					multiplier.put(dvar, value2*multiplier.get(dvar));				
				}
				return ee1;
			}else{
				Error.addEvaluationError("Decision variable multiply decision variable appears. The problem is not linear.");
				return ee1;
			}
		}
	}
	
	public static EvalExpression divide(EvalExpression ee1, EvalExpression ee2){
		if (ee2.isNumeric()){
			double value2=convertStringToDouble(ee2.getValue());
			double value1=convertStringToDouble(ee1.getValue());
			if (value2 ==0.0){
				Error.addEvaluationError("0 appears in divisor");
				return ee1;
			}
			ee1.setValue(convertDoubleToString(value1/value2));
			Map<String, Double> multiplier=ee1.getMultiplier();
			for (String dvar : multiplier.keySet()) {
				multiplier.put(dvar, multiplier.get(dvar)/value2);				
			}
			return ee1;
		}else{
			Error.addEvaluationError("Decision variable appears in divisor. The problem is not linear.");
			return ee1;
		}
	}
	
	public static EvalExpression mod(EvalExpression ee1, EvalExpression ee2){
		if (ee1.isNumeric() && ee2.isNumeric()){
			double value1=convertStringToDouble(ee1.getValue());
			double value2=convertStringToDouble(ee2.getValue());
			ee1.setValue(convertDoubleToString(value1%value2));			
			return ee1;
		}else{
			Error.addEvaluationError("Decision variable appears in MOD calcualtion. The problem is not linear.");
			return ee1;
		}
	}
	
	public static EvalExpression add(EvalExpression ee1, EvalExpression ee2){
		double value1=convertStringToDouble(ee1.getValue());
		double value2=convertStringToDouble(ee2.getValue());
		ee1.setValue(convertDoubleToString(value1+value2));
		Map<String, Double> multiplier1=ee1.getMultiplier();
		Map<String, Double> multiplier2=ee2.getMultiplier();
		for (String dvar : multiplier2.keySet()) {
			if (multiplier1.containsKey(dvar)){
				multiplier1.put(dvar, multiplier1.get(dvar)+multiplier2.get(dvar));
			}else{
				multiplier1.put(dvar, multiplier2.get(dvar));
			}
		}
		return ee1;
	}
	
	
	public static EvalExpression minus(EvalExpression ee1, EvalExpression ee2){
		double value1=convertStringToDouble(ee1.getValue());
		double value2=convertStringToDouble(ee2.getValue());
		ee1.setValue(convertDoubleToString(value1-value2));
		Map<String, Double> multiplier1=ee1.getMultiplier();
		Map<String, Double> multiplier2=ee2.getMultiplier();
		for (String dvar : multiplier2.keySet()) {
			if (multiplier1.containsKey(dvar)){
				multiplier1.put(dvar, multiplier1.get(dvar)-multiplier2.get(dvar));
			}else{
				multiplier1.put(dvar, -multiplier2.get(dvar));
			}
		}
		return ee1;
	}
}
