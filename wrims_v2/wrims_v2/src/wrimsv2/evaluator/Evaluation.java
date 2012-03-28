package wrimsv2.evaluator;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.components.IntDouble;
import wrimsv2.external.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Date;

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
		return new EvalExpression(result);
	}
	
	public static EvalExpression term_IDENT (String ident){
		if (ControlData.currSvMap.containsKey(ident)){
			EvalExpression ee=new EvalExpression();
			IntDouble id0 = ControlData.currSvMap.get(ident).getData();
			IntDouble id1 = new IntDouble(id0.getData(), id0.isInt());
			ee.setValue(id1);
			return ee;
		}else if (ControlData.currTsMap.containsKey(ident)){
			EvalExpression ee=new EvalExpression();
			IntDouble id0 = ControlData.currTsMap.get(ident).getData();
			IntDouble id1 = new IntDouble(id0.getData(), id0.isInt());
			ee.setValue(id1);
			return ee;
		}else if (ControlData.isPostProcessing && ControlData.currDvMap.containsKey(ident)){
			EvalExpression ee=new EvalExpression();
			IntDouble id0 = ControlData.currDvMap.get(ident).getData();
			IntDouble id1 = new IntDouble(id0.getData(), id0.isInt());
			ee.setValue(id1);
			return ee;
		}else if (ControlData.isPostProcessing && ControlData.currAliasMap.containsKey(ident)){
			EvalExpression ee=new EvalExpression();
			IntDouble id0 = ControlData.currAliasMap.get(ident).getData();
			IntDouble id1 = new IntDouble(id0.getData(), id0.isInt());
			ee.setValue(id1);
			return ee;
		}else if (!ControlData.isPostProcessing && ControlData.currAliasMap.containsKey(ident) && !ControlData.currDvMap.containsKey(ident)){
			EvalExpression ee=new EvalExpression();
			IntDouble id0=new IntDouble(1.0, false);
			ee.setValue(id0);
			Error.addEvaluationError("Alias "+ident+" should not appear in constraint. ");
			return ee;
		} else if (!ControlData.isPostProcessing && !ControlData.currAliasMap.containsKey(ident) && !ControlData.currDvMap.containsKey(ident) && !ControlData.currDvSlackSurplusMap.containsKey(ident)){
			EvalExpression ee=new EvalExpression();
			IntDouble id0=new IntDouble(1.0, false);
			ee.setValue(id0);
			Error.addEvaluationError(ident+" is not defined before used.");
			return ee;
		}
		
		EvalExpression ee=new EvalExpression();
		IntDouble id0 = new IntDouble (0, true);
		ee.setValue(id0);
		HashMap<String, IntDouble> multiplier=ee.getMultiplier();
		IntDouble id= new IntDouble(1,true); 
		multiplier.put(ident, id);
		return ee;
	}
	
	public static EvalExpression term_SVAR (String ident){
		IntDouble data;
		if (!ControlData.currSvMap.containsKey(ident)){
			if (!ControlData.currTsMap.containsKey(ident)){
				Error.addEvaluationError("State variable "+ident+" is not defined before used.");
				IntDouble id=new IntDouble(1.0, false);
				return new EvalExpression(id);
			}else{
				data=ControlData.currTsMap.get(ident).getData();
			}
		}else{
			data=ControlData.currSvMap.get(ident).getData();
		}
		
		if (data == null){
			Error.addEvaluationError("The value of state variable "+ident+" is not defined before used.");
			IntDouble id=new IntDouble(1.0, false);
			return new EvalExpression(id);
		}
		return new EvalExpression(new IntDouble(data.getData(), data.isInt()));
	}
	
	public static EvalExpression term_INTEGER (String integer){
		IntDouble id = new IntDouble(convertStringToInt(integer), true);
		return new EvalExpression(id);
	}
	
	public static EvalExpression term_FLOAT (String floatValue){
		IntDouble id = new IntDouble(convertStringToDouble(floatValue), false);
		return new EvalExpression(id);
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
				IntDouble id=multiplier.get(dvar);
				if (id.isInt()){
					id.setData(-id.getData().intValue());
				}else{
					id.setData(-id.getData().doubleValue());
				}
				multiplier.put(dvar, id);				
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
				IntDouble id3=multiplyOperation(id1,multiplier.get(dvar));
				if (id3.getData().doubleValue()==0.0){
					multiplier.remove(dvar);
				}else{
					multiplier.put(dvar, id3);
				}
			}
			return ee2;
		}else{
			if (ee2.isNumeric()){
				IntDouble id2=ee2.getValue();
				IntDouble id1=ee1.getValue();
				ee1.setValue(multiplyOperation(id2,id1));
				Map<String, IntDouble> multiplier=ee1.getMultiplier();
				for (String dvar : multiplier.keySet()) {
					IntDouble id3=multiplyOperation(id2,multiplier.get(dvar));
					if (id3.getData().doubleValue()==0.0){
						multiplier.remove(dvar);
					}else{
						multiplier.put(dvar, id3);
					}			
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
				if (id1.getData().doubleValue()==0.0 && ee1.isNumeric()){
					return ee1;
				}else{
					Error.addEvaluationError("0.0 appears in divisor");
				}
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
				IntDouble id3=addOperation(multiplier1.get(dvar),multiplier2.get(dvar));
				if (id3.getData().doubleValue()==0.0){
					multiplier1.remove(dvar);
				}else{
					multiplier1.put(dvar, id3);
				}
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
	
	public static EvalExpression noArgFunction(String ident){
		Class function;
		IntDouble result;
		try {
			function = Class.forName("wrimsv2.external.Function"+ident);
		
			Stack stack = new Stack();

			ExternalFunction ef;
			if (ControlData.allExternalFunctionMap.containsKey(ident)){
				ef=ControlData.allExternalFunctionMap.get(ident);
			}else{
				ef = (ExternalFunction)function.newInstance();
				ControlData.allExternalFunctionMap.put(ident, ef);
			}
			ef.execute(stack);
			String valueString=stack.pop().toString();
			
			if (valueString.contains(".")){       
				result = new IntDouble(Double.parseDouble(valueString), false);
				return new EvalExpression(result);
			}else{
				result = new IntDouble(Integer.parseInt(valueString), true);
				return new EvalExpression(result);
			}
			
		} catch (Exception e) {
			Error.addEvaluationError("The function " +ident+" is not defined in the WRIMS engine. Re-run preprocessor for dlls.");
			result=new IntDouble (1.0,false);
			return new EvalExpression(result);
		}
	}
	
	public static EvalExpression argFunction(String ident, ArrayList<EvalExpression> eeArray){
		IntDouble result;
		if (eeArray.size()==1){
			if (ControlData.currSvMap.containsKey(ident)||ControlData.currTsMap.containsKey(ident)||ControlData.currDvMap.containsKey(ident)||ControlData.currAliasMap.containsKey(ident)||ControlData.currDvSlackSurplusMap.containsKey(ident)) return getTimeSeries(ident, eeArray);
		}
			
		Class function;
		try {
			function = Class.forName("wrimsv2.external.Function"+ident);
		
			Stack stack = new Stack();
			for (int i=0; i<eeArray.size(); i++){
				EvalExpression ee=eeArray.get(i);
				if (!ee.isNumeric()){
					Error.addEvaluationError("The function " +ident+" is not defined in the WRIMS engine. Re-run preprocessor for dlls.");
					result=new IntDouble (0.0,false);
					return new EvalExpression(result);
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

			ExternalFunction ef;
			if (ControlData.allExternalFunctionMap.containsKey(ident)){
				ef=ControlData.allExternalFunctionMap.get(ident);
			}else{
				ef = (ExternalFunction)function.newInstance();
				ControlData.allExternalFunctionMap.put(ident, ef);
			}
			ef.execute(stack);
			String valueString=stack.pop().toString();
			
			if (valueString.contains(".")){       
				result=new IntDouble(Double.parseDouble(valueString), false);
				return new EvalExpression(result);
			}else{
				result=new IntDouble(Integer.parseInt(valueString), true);
				return new EvalExpression(result);
			}
			
		} catch (Exception e) {
			Error.addEvaluationError("The function " +ident+" is not defined in the WRIMS engine. Re-run preprocessor for dlls.");
			result=new IntDouble (1.0,false);
			return new EvalExpression(result);
		}
	}
	
	public static EvalExpression getTimeSeries(String ident, ArrayList<EvalExpression> eeArray){
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
					return new EvalExpression(result);
				}else{
					isSumIndex=true;
				}
			}else{
				Error.addEvaluationError("The index of "+ident+" contains decision variable.");
				result=new IntDouble (0.0,false);
				return new EvalExpression(result);
			}
		}
		
		IntDouble id=ee.getValue();
		if (!id.isInt()){
			Error.addEvaluationError("The index of "+ident+" should be integer.");
			result=new IntDouble (0.0,false);
			return new EvalExpression(result);
		}

		if (isSumIndex){
			if (isIndexStart){
				TimeOperation.findTime(indexValue);
			}else{
				result=new IntDouble (1.0,false);
				return new EvalExpression(result);
			}
		}else{
			TimeOperation.findTime(id.getData().intValue());
		}
		
		double value;
		int idValue=id.getData().intValue();
		if (ControlData.currDvMap.containsKey(ident)){
			if (idValue<0){
				value=dvarAliasTimeSeries(ident,idValue);
			}else if (idValue==0){
				HashMap<String, IntDouble> multiplier = new HashMap<String, IntDouble>();
				multiplier.put(ident, new IntDouble(1, true));
				EvalExpression eeResult=new EvalExpression();
				eeResult.setMultiplier(multiplier);
				return eeResult;
			}else{
				String futDvName=ident+"__fut__"+idValue;
				if (SolverData.getDvarMap().containsKey(futDvName)){
					HashMap<String, IntDouble> multiplier = new HashMap<String, IntDouble>();
					multiplier.put(futDvName, new IntDouble(1, true));
					EvalExpression eeResult=new EvalExpression();
					eeResult.setMultiplier(multiplier);
					return eeResult;
				}else{
					Error.addEvaluationError("Time Array Dvar "+futDvName+" is used without definition.");
					result=new IntDouble (1.0, false);
					return new EvalExpression(result);
				}
			}
		}else if (ControlData.currDvSlackSurplusMap.containsKey(ident)){
			if (idValue==0){
				HashMap<String, IntDouble> multiplier = new HashMap<String, IntDouble>();
				multiplier.put(ident, new IntDouble(1, true));
				EvalExpression eeResult=new EvalExpression();
				eeResult.setMultiplier(multiplier);
				return eeResult;
			}else if (idValue>0){
				String futDvSlackSurplusName=ident+"__fut__"+idValue;
				HashMap<String, IntDouble> multiplier = new HashMap<String, IntDouble>();
				multiplier.put(futDvSlackSurplusName, new IntDouble(1, true));
				EvalExpression eeResult=new EvalExpression();
				eeResult.setMultiplier(multiplier);
				return eeResult;
			}else{
				Error.addEvaluationError("Slack surplus index of "+ident+", "+idValue+"<0. THe index has to be larger than 0.");
				result=new IntDouble (1.0,false);
				return new EvalExpression(result);
			}
		}else if (ControlData.currAliasMap.containsKey(ident)){
			value=dvarAliasTimeSeries(ident,idValue);
		}else{
			if (ControlData.currSvMap.containsKey(ident)){ 
				if (idValue==0)	{
					result = ControlData.currSvMap.get(ident).getData();
					return new EvalExpression(result);
				}else if(idValue>0){
					String futSvName=ident+"__fut__"+idValue;
					if (ControlData.currSvFutMap.containsKey(futSvName)){
						result=ControlData.currSvFutMap.get(futSvName).getData();
						return new EvalExpression(result);
					}else{
						Error.addEvaluationError(futSvName+", the future value of "+ident+" is used before defined.");
						result=new IntDouble (1.0,false);
						return new EvalExpression(result);
					}
				}
			}
			value=svarTimeSeries(ident);
		}
		
		result=new IntDouble (value, false);
		return new EvalExpression(result);
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
					if (value != -901.0 && value != -902.0){
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
				if (value !=-901.0){
					return value;
				}
			}
		}else{
			DataTimeSeries.lookInitDss.add(ident);
			if (DssOperation.getSVInitTimeseries(ident)){
				DssDataSet dds=DataTimeSeries.svInit.get(ident);
				index =timeSeriesIndex(dds);
				ArrayList<Double> data=dds.getData();
				if (index>=0 && index<data.size()){
					double value=data.get(index);
					if (value !=-901.0){
						return value;
					}
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
			DssDataSetFixLength dds=DataTimeSeries.dvAliasTS.get(ident);
			index=timeSeriesIndex(dds);
			double[] data=dds.getData();
			return data[index];
		}
		
		if (!DataTimeSeries.dvAliasInit.containsKey(ident)){
			if (!DssOperation.getDVAliasInitTimeseries(ident)){
				Error.addEvaluationError("Initial file doesn't have data for decision vairiable/alias " +ident);
				return 1.0;
			}
		}
		
		DssDataSet dds=DataTimeSeries.dvAliasInit.get(ident);
		index=timeSeriesIndex(dds);
		ArrayList<Double> data=dds.getData();
		if (index>=0 && index<data.size()){
			double result=data.get(index);
			if (result==-901.0 || result==-902.0){
				Error.addEvaluationError("Initial file doesn't have data for decision vairiable/alias " +ident);
				return 1.0;
			}
			return result;
		}
		
		Error.addEvaluationError("The data requested for timeseries "+ident+" is outside of the time frame provided in dss file.");
		return 1.0;
	}
	
	public static double dvarAliasTimeSeries(String ident, int indexValue){
		if (indexValue>0){
			Error.addEvaluationError("Can't access decision variable after the current time step.");
		}
		
		int index=indexValue+ControlData.currTimeStep;
		if (index>=0){
			DssDataSetFixLength dds=DataTimeSeries.dvAliasTS.get(ident);
			double[] data=dds.getData();
			return data[index];
		}
		
		if (!DataTimeSeries.dvAliasInit.containsKey(ident)){
			if (!DssOperation.getDVAliasInitTimeseries(ident)){
				Error.addEvaluationError("Initial file doesn't have data for decision vairiable/alias " +ident);
				return 1.0;
			}
		}
		
		DssDataSet dds=DataTimeSeries.dvAliasInit.get(ident);
		index=timeSeriesIndex(dds);
		ArrayList<Double> data=dds.getData();
		if (index>=0 && index<data.size()){
			double result=data.get(index);
			if (result==-901.0 || result==-902.0){
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
			double indexValue=(dataTime-sTime)/(1000*60*60*24);
			index=(int)indexValue+2;
		}
		return index;
	}
	
	public static int timeSeriesIndex(DssDataSetFixLength dds){
		Date st=dds.getStartTime();
		long sTime=st.getTime();
		int sYear=st.getYear()+1900;
		int sMonth=st.getMonth(); //Originally it should be getMonth()-1. However, dss data store at 24:00 Jan31, 1921 is considered to store at 0:00 Feb 1, 1921 
		long dataTime=new Date(ControlData.dataYear-1900, ControlData.dataMonth-1, ControlData.dataDay).getTime();
		int index;
		if (dds.getTimeStep().equals("1MON")){
			index=ControlData.dataYear*12+ControlData.dataMonth-(sYear*12+sMonth);
		}else{
			double indexValue=(dataTime-sTime)/(1000*60*60*24);
			index=(int)indexValue+2;
		}
		return index;
	}
	
	public static EvalExpression timeseries(){
		String svName=ControlData.currEvalName;
		TimeOperation.findTime(0);
		double value=svarTimeSeries(svName);
		IntDouble id=new IntDouble(value,false);
		return new EvalExpression(id);
	}
	
	public static double timeseries(String tsName){
		TimeOperation.findTime(0);
		return svarTimeSeries(tsName);
	}
	
	public static IntDouble pastCycleDV(String ident, String cycle){
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		IntDouble data=new IntDouble(1.0,false);
		if (varCycleValueMap.containsKey(ident)){
			Map<String, IntDouble> var= varCycleValueMap.get(ident);
			if (var.containsKey(cycle)){
				data=var.get(cycle);
			}else{
				Error.addEvaluationError("The variable "+ident+" is not defined in the past cycle of "+cycle+".");
				return data;
			}
		}else{
			Error.addEvaluationError("The variable "+ident+" is not defined in the past cycle of "+cycle+".");
			return data;
		}
		return new IntDouble(data.getData(),data.isInt());
	}
	
	public static EvalExpression max(EvalExpression ee1, EvalExpression ee2){
		if (!ee1.isNumeric() || !ee2.isNumeric()){
			Error.addEvaluationError("variable inside max function should not contain decision variable.");
		}
		return new EvalExpression(maxOperation(ee1.getValue(), ee2.getValue()));
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
			Error.addEvaluationError("variable inside min function should not contain decision variable.");
		}
		return new EvalExpression((minOperation(ee1.getValue(), ee2.getValue())));
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
			Error.addEvaluationError("variable inside int function should not contain decision variable.");
		}
		return new EvalExpression(intOperation(ee1.getValue()));
	}
	
	public static IntDouble intOperation(IntDouble id1){
		IntDouble id;
		if (!id1.isInt()){
			id=new IntDouble(((int)id1.getData().doubleValue()), true);
			return id;
		}
		return id1;
	}
	
	public static EvalExpression realFunc(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.addEvaluationError("variable inside int function should not contain decision variable.");
		}
		return new EvalExpression(realOperation(ee1.getValue()));
	}
	
	public static IntDouble realOperation(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble((id1.getData().doubleValue()), false);
			return id;
		}
		return id1;
	}
	
	public static EvalExpression abs(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.addEvaluationError("variable inside abs function should not contain decision variable.");
		}
		return new EvalExpression(absOperation(ee1.getValue()));
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
	
	public static EvalExpression exp(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.addEvaluationError("variable inside log function should not contain decision variable.");
		}
		return new EvalExpression(expOperation(ee1.getValue()));
	}
	
	public static IntDouble expOperation(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.exp(id1.getData().intValue()), false);
		}else{
			id=new IntDouble(Math.exp(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static EvalExpression log(EvalExpression ee1){
		if (!ee1.isNumeric()){
			Error.addEvaluationError("variable inside log function should not contain decision variable.");
		}
		return new EvalExpression(logOperation(ee1.getValue()));
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
			Error.addEvaluationError("variable inside log10 function should not contain decision variable.");
		}
		return new EvalExpression(log10Operation(ee1.getValue()));
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
			Error.addEvaluationError("variable inside pow function should not contain decision variable.");
		}
		return new EvalExpression(powOperation(ee1.getValue(), ee2.getValue()));
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
		return new EvalExpression(id);
	}
	
	public static EvalExpression tafcfs_term(String ident, EvalExpression ee){
		if (ee==null){
			ControlData.dataMonth=ControlData.currMonth;
			ControlData.dataYear=ControlData.currYear;
		}else{
			IntDouble id=new IntDouble(0,true);
			if (!ee.isNumeric()){
				HashMap<String, IntDouble> multiplier=ee.getMultiplier();
				if (multiplier.size()==1){
					if (ControlData.sumIndex.size()>0){
						LoopIndex li=ControlData.sumIndex.pop();
						String indexName=li.getName();
						int indexValue=li.getValue();
						ControlData.sumIndex.push(li);
						id=new IntDouble(indexValue, true);
					}else{
						Error.addEvaluationError("The index of "+ident+" should not contain decision variable.");
					}
				}else{
					Error.addEvaluationError("The index of "+ident+" should not contain decision variable.");
				}
			}else{
				id=ee.getValue();
			}
			if (!id.isInt()){
				Error.addEvaluationError("The index of "+ident+" should be integer.");
			}
			TimeOperation.findTime(id.getData().intValue());
		}
		double convert = tafcfs(ident);
		IntDouble id1=new IntDouble(convert, false);
		return new EvalExpression(id1);
	}
	
	public static double tafcfs(String ident){
		double convert;
		int days=TimeOperation.numberOfDays(ControlData.dataMonth, ControlData.dataYear);
		if (ident.equals("taf_cfs")){
			if (ControlData.timeStep.equals("1MON")){
				return 504.1666667 / days;
			}else{
				return 504.1666667;
			}
		}else if (ident.equals("cfs_taf")){
			if (ControlData.timeStep.equals("1MON")){
				return days / 504.1666667;
			}else{
				return 1 / 504.1666667;
			}
		}else if (ident.equals("af_cfs")){
			if (ControlData.timeStep.equals("1MON")){
				return 504.1666667 / days / 1000.;
			}else{
				return 504.1666667 / 1000.;
			}
		}else{
			if (ControlData.timeStep.equals("1MON")){
				return days / 504.1666667 * 1000.;
			}else{
				return 1 / 504.1666667 * 1000.;
			}
		}
	}
	
	public static EvalExpression term_YEAR(){
		IntDouble id=new IntDouble(TimeOperation.waterYearValue(), true);
		return new EvalExpression(id);
	}
	
	public static EvalExpression term_MONTH(){
		IntDouble id=new IntDouble(TimeOperation.waterMonthValue(ControlData.currMonth), true);
		return new EvalExpression(id);
	}
	
	public static EvalExpression term_DAY(){
		IntDouble id=new IntDouble(ControlData.currDay, true);
		return new EvalExpression(id);
	}
	
	public static EvalExpression term_MONTH_CONST(String month){
		int monthValue=TimeOperation.monthValue(month);
		IntDouble id=new IntDouble(TimeOperation.waterMonthValue(monthValue), true);
		return new EvalExpression(id);
	}
	
	public static EvalExpression term_PASTMONTH(String pastMonth){
		pastMonth=pastMonth.substring(4);
		int pastMonthValue=TimeOperation.monthValue(pastMonth);
		int index=pastMonthValue-ControlData.currMonth;
		if (index>=0){
			index=index-12;
		}
		IntDouble id=new IntDouble(index,true);
		return new EvalExpression(id);
	}
	
	public static EvalExpression term_ARRAY_ITERATOR(){
		IntDouble id=new IntDouble(ControlData.timeArrayIndex, true);
		return new EvalExpression(id);
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
			IntDouble id=new IntDouble(1.0, false);
			return new EvalExpression(id);
		}
		if (!ee2.isNumeric()){
			Error.addEvaluationError("the ending index can't contains decision variable");
			IntDouble id=new IntDouble(1.0, false);
			return new EvalExpression(id);
		}
		IntDouble id1=ee1.getValue();
		IntDouble id2=ee2.getValue();
		if (!id1.isInt()){
			Error.addEvaluationError("the starting index should be integer");
			IntDouble id=new IntDouble(1.0, false);
			return new EvalExpression(id);
		}
		if (!id2.isInt()){
			Error.addEvaluationError("the ending index should be integer");
			IntDouble id=new IntDouble(1.0, false);
			return new EvalExpression(id);
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
		
		ControlData.sumIndex.pop();
		return new EvalExpression(id);
	}
	
	public static Number assignWhereStatement(EvalExpression ee){
		if (ee.isNumeric()){
			return ee.getValue().getData();
		}else{
			return 1.0;
		}
	}
	
	public static EvalExpression tableSQL(String table, String select, HashMap<String, Number> where, HashMap<String, Number> given, String use){
		IntDouble id;
		if (where==null){	
			id=TableOperation.findData(table, select, given, use);
		}else{
			id=TableOperation.findData(table, select, where, given, use);
		}
		return new EvalExpression(id);
	}
	
	public static IntDouble expressionInput(EvalExpression ee){
		if (!ee.isNumeric()){
			Error.addEvaluationError("the value is not numeric and contains decision variable");
		}
		return ee.getValue();
	}
}
