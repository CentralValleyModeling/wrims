package wrimsv2.evaluator;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.external.ExternalFunction;
import wrimsv2.external.ExternalFunctionTable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Date;

import vista.db.dss.DSSUtil;
import vista.set.*;

public class Evaluation {

	public static double convertStringToDouble(String text){
		return Double.valueOf(text);
	}
	
	public static int convertStringToInt(String text){
		return Integer.valueOf(text);
	}
	
	public static String convertDoubleToString(double value){
		return Double.toString(value);
	}
	
	public static String convertIntToString(int value){
		return Integer.toString(value);
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
		int mon1=TimeOperation.monthValue(m1);
		int mon2=TimeOperation.monthValue(m2);
		
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
		EvalExpression ee=substract(ee1, ee2);
		EvalConstraint ec=new EvalConstraint();
		ec.setEvalExpression(ee);
		ec.setSign(s);
		return ec;
	}
	
	public static EvalExpression term_knownTS(IntDouble result){
		EvalExpression ee=new EvalExpression();
		ee.setValue(result);
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
				IntDouble id3=substractOperation(multiplier1.get(dvar),multiplier2.get(dvar));
				if (id3.getData().doubleValue()==0.0){
					multiplier1.remove(dvar);
				}else{
					multiplier1.put(dvar, id3);
				}
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
	
	public static IntDouble noArgFunction(String ident){
		//To Do call no ArgFunction
		IntDouble result=new IntDouble(9999999999.9,false);
		return result;
	}
	
	public static IntDouble argFunction(String ident, ArrayList<EvalExpression> eeArray){
		IntDouble result;
		if (eeArray.size()==1){
			//To Do: check if it is dvar or alias or svar or function
			
			return getTimeSeries(ident, eeArray);
		}
		
		if (ExternalFunctionTable.externalFunctionsHashtable ==null){
			Error.addEvaluationError("WRIMS V2 Engine error. Dlls have not been load.");
			result=new IntDouble (0.0,false);
			return result;
		}
		
		ExternalFunction ef=ExternalFunctionTable.externalFunctionsHashtable.get(ident);
		if (ef == null){
			Error.addEvaluationError("WRIMS V2 Engine error. Dlls have not been load.");
			result=new IntDouble (0.0,false);
			return result;
		}
		
		Stack stack = new Stack();
		for (int i=0; i<eeArray.size(); i++){
			EvalExpression ee=eeArray.get(i);
			if (!ee.isNumeric()){
				Error.addEvaluationError("argument in the function of "+ident+" contains decision variable.");
				result=new IntDouble (0.0,false);
				return result;
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
		if (ExternalFunctionTable.externalFunctionReturnType.get(ident).equals("double")){
			result=new IntDouble((Number)stack.pop(), false);
		}else{
			result=new IntDouble((Number)stack.pop(), true);
		}
		return result;
	}
	
	public static IntDouble getTimeSeries(String ident, ArrayList<EvalExpression> eeArray){
		IntDouble result;
		boolean isSumIndex=false;
		int indexValue=0;
		boolean isIndexStart=true;
		
		EvalExpression ee=eeArray.get(0);	
		
		if (!ee.isNumeric()){
			HashMap<String, IntDouble> multiplier=ee.getMultiplier();
			if (multiplier.size()==1){
				LoopIndex li=ControlData.sumIndex.pop();
				String indexName=li.getName();
				indexValue=li.getValue();
				isIndexStart=li.getIndexStart();
				ControlData.sumIndex.push(li);
				if (!(multiplier.containsKey(indexName) && multiplier.get(indexName).getData().doubleValue()==1.0 && ee.getValue().getData().doubleValue()==0.0)){
					Error.addEvaluationError("The index of "+ident+" contains decision variable.");
					result=new IntDouble (0.0,false);
					return result;
				}else{
					isSumIndex=true;
				}
			}else{
				Error.addEvaluationError("The index of "+ident+" contains decision variable.");
				result=new IntDouble (0.0,false);
				return result;
			}
		}
		
		IntDouble id=ee.getValue();
		if (!id.isInt()){
			Error.addEvaluationError("The index of "+ident+" should be integer.");
			result=new IntDouble (0.0,false);
			return result;
		}

		if (isSumIndex){
			if (isIndexStart){
				TimeOperation.findTime(indexValue);
			}else{
				result=new IntDouble (0.0,false);
				return result;
			}
		}else{
			TimeOperation.findTime(id.getData().intValue());
		}
		
		//To Do: check if ident is svar, dvar, or alias, and treat separately
		
		double value;
		value=dvarAliasTimeSeries(ident);
		value=svarTimeSeries(ident);
		
		return new IntDouble (value, false);
	}
	
	public static double svarTimeSeries(String ident){
		int index;
		if (DataTimeSeries.svTS.containsKey(ident)){
			DssDataSet dds=DataTimeSeries.svTS.get(ident);
			index =timeSeriesIndex(dds);
			ArrayList<Double> data=dds.getData();
			if (index>=0 && index<data.size()){
				double value=data.get(index);
				if (dds.fromDssFile()){
					if (value != 901.0){
						return value;
					}
				}else{
					return value;
				}
			}
		}
		if (DataTimeSeries.svInit.containsKey(ident)){
			DssDataSet dds=DataTimeSeries.svInit.get(ident);
			index =timeSeriesIndex(dds);
			ArrayList<Double> data=dds.getData();
			if (index>=0 && index<data.size()){
				double value=data.get(index);
				if (value !=901.0){
					return value;
				}
			}
		}
		Error.addEvaluationError("The data requested for timeseries "+ident+" is outside of the time frame provided in dss file.");
		return 1.0;
	}
	
	public static double dvarAliasTimeSeries(String ident){
		int index;
		long dataTime;
		long startTime;
		long currTime;
		if (ControlData.timeStep.equals("1MON")){
			dataTime=new Date(ControlData.dataYear-1900, ControlData.dataMonth-1, 1).getTime();
			startTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, 1).getTime();
			currTime=new Date(ControlData.currYear-1900, ControlData.currMonth-1, 1).getTime();
		}else{
			dataTime=new Date(ControlData.dataYear-1900, ControlData.dataMonth-1, ControlData.dataDay).getTime();
			startTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay).getTime();
			currTime=new Date(ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay).getTime();
		}
		
		if (dataTime>=currTime){
			Error.addEvaluationError("The timeseries data for decision variable/alias "+ident+" is not available at or after current simulation period.");
			return 1.0;
		}else if(dataTime>=startTime && dataTime<currTime){
			DssDataSet dds=DataTimeSeries.dvAliasTS.get(ident);
			index=timeSeriesIndex(dds);
			return dds.getData().get(index);
		}
		
		if (!DataTimeSeries.dvAliasInit.containsKey(ident)){
			if (!DssOperation.getDVAliasInitTimeseries(ident, FilePaths.fullInitDssPath)){
				Error.addEvaluationError("Initial file doesn't have data for decision vairiable/alias " +ident);
				return 1.0;
			}
		}
		
		DssDataSet dds=DataTimeSeries.dvAliasInit.get(ident);
		index=timeSeriesIndex(dds);
		ArrayList<Double> data=dds.getData();
		if (index>=0 && index<data.size()){
			double result=data.get(index);
			if (result==-901.0){
				Error.addEvaluationError("Initial file doesn't have data for decision vairiable/alias " +ident);
				return 1.0;
			}
			return result;
		}
		
		Error.addEvaluationError("The data requested for timeseries "+ident+" is outside of the time frame provided in dss file.");
		return 1.0;
	}
	
	public static int timeSeriesIndex(DssDataSet dds){
		Date st=dds.getStartTime();
		long sTime=st.getTime();
		int sYear=st.getYear()+1900;
		int sMonth=st.getMonth(); //Originally it should be getMonth()-1. However, dss data store at 24:00 Jan31, 1921 is considered to store at 0:00 Feb 1, 1921 
		long dataTime=new Date(ControlData.dataYear-1900, ControlData.dataMonth-1, ControlData.dataDay).getTime();
		int index;
		if (dds.getTimeStep().equals("1MON")){
			index=ControlData.dataYear*12+ControlData.dataMonth-(sYear*12+sMonth);
		}else{
			index=(int)((sTime-dataTime)/(1000*60*60*24));
		}
		return index;
	}
	
	public static EvalExpression timeseries(){
		String svName=ControlData.currEvalName;
		//To Do: in the svar class, add flag to see if svTS has been loaded
		if (!DataTimeSeries.svTS.containsKey(svName)){ //To Do check if svTS has been loaded. If no, load.
			DssOperation.getSVTimeseries(svName, FilePaths.fullSvarDssPath);
		}
		//To Do: in the svar class, add flag to see if svInit has been loaded
		if (!DataTimeSeries.svInit.containsKey(svName)){ //To Do check if svInit has been loaded. If no, load. 
			DssOperation.getSVInitTimeseries(svName, FilePaths.fullInitDssPath);
		}
		TimeOperation.findTime(0);
		double value=svarTimeSeries(svName);
		IntDouble id=new IntDouble(value,false);
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		return ee;
	}
	
	public static IntDouble pastCycleDV(String ident, String cycle){
		//To Do: add function for getting past cycle dv
		IntDouble result=new IntDouble(9999999999.9,false);
		return result;
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
		int days=TimeOperation.numberOfDays(ControlData.currMonth, ControlData.currYear);
		IntDouble id=new IntDouble(days, true);
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		return ee;
	}
	
	public static EvalExpression tafcfs_term(String ident, EvalExpression ee){
		if (ee==null){
			ControlData.dataMonth=ControlData.currMonth;
			ControlData.dataYear=ControlData.dataYear;
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
		int days=TimeOperation.numberOfDays(ControlData.dataMonth, ControlData.dataYear);
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
	
	public static EvalExpression term_YEAR(){
		IntDouble id=new IntDouble(TimeOperation.waterYearValue(), true);
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		return ee;
	}
	
	public static EvalExpression term_MONTH(){
		IntDouble id=new IntDouble(TimeOperation.waterMonthValue(ControlData.currMonth), true);
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		return ee;
	}
	
	public static EvalExpression term_MONTH_CONST(String month){
		int monthValue=TimeOperation.monthValue(month);
		IntDouble id=new IntDouble(TimeOperation.waterMonthValue(monthValue), true);
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		return ee;
	}
	
	public static EvalExpression term_PASTMONTH(String pastMonth){
		pastMonth=pastMonth.substring(4);
		int pastMonthValue=TimeOperation.monthValue(pastMonth);
		int index=pastMonthValue-ControlData.currMonth;
		if (index>=0){
			index=index-12;
		}
		IntDouble id=new IntDouble(index,true);
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		return ee;
	}
	
	public static void sumExpression_IDENT(String ident){
		//To Do: check if svar, dvar, alias contains ident
		LoopIndex li=new LoopIndex(ident, 0, false);
		ControlData.sumIndex.push(li);
	}
	
	public static EvalExpression sumExpression(EvalExpression ee1, EvalExpression ee2, String s, String expression){
		int step=1;
		if (!s.equals("")){
			step=convertStringToInt(s);
		}
		if (!ee1.isNumeric()){
			Error.addEvaluationError("the starting index can't contains decision variable");
			EvalExpression ee=new EvalExpression();
			IntDouble id=new IntDouble(1.0, false);
			ee.setValue(id);
			return ee;
		}
		if (!ee2.isNumeric()){
			Error.addEvaluationError("the ending index can't contains decision variable");
			EvalExpression ee=new EvalExpression();
			IntDouble id=new IntDouble(1.0, false);
			ee.setValue(id);
			return ee;
		}
		IntDouble id1=ee1.getValue();
		IntDouble id2=ee2.getValue();
		if (!id1.isInt()){
			Error.addEvaluationError("the starting index should be integer");
			EvalExpression ee=new EvalExpression();
			IntDouble id=new IntDouble(1.0, false);
			ee.setValue(id);
			return ee;
		}
		if (!id2.isInt()){
			Error.addEvaluationError("the ending index should be integer");
			EvalExpression ee=new EvalExpression();
			IntDouble id=new IntDouble(1.0, false);
			ee.setValue(id);
			return ee;
		}
		int start=id1.getData().intValue();
		int end=id2.getData().intValue();
		IntDouble id=new IntDouble(0, true);
		
		if (step>=0){
			for (int i=start; i<=end; i=i+step){
				LoopIndex li=ControlData.sumIndex.pop();
				li.setValue(i);
				li.setIndexStart(true);
				ControlData.sumIndex.push(li);
				ANTLRStringStream stream = new ANTLRStringStream("v: "+expression); 
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try{
					evaluator.evaluator();
				}catch (RecognitionException e){
					Error.addEvaluationError(e.toString());
				}
			
				IntDouble id0=evaluator.evalValue;
				id=addOperation(id, id0);
			}
		}else{
			for (int i=start; i>=end; i=i+step){
				LoopIndex li=ControlData.sumIndex.pop();
				li.setValue(i);
				li.setIndexStart(true);
				ControlData.sumIndex.push(li);
				ANTLRStringStream stream = new ANTLRStringStream("v: "+expression); 
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try{
					evaluator.evaluator();
				}catch (RecognitionException e){
					Error.addEvaluationError(e.toString());
				}
			
				IntDouble id0=evaluator.evalValue;
				id=addOperation(id, id0);
			}
		}
		
		EvalExpression ee=new EvalExpression();
		ee.setValue(id);
		ControlData.sumIndex.pop();
		return ee;
	}
	
	public static IntDouble expressionInput(EvalExpression ee){
		if (!ee.isNumeric()){
			Error.addEvaluationError("the value is not numeric and contains decision variable");
		}
		return ee.getValue();
	}
}
