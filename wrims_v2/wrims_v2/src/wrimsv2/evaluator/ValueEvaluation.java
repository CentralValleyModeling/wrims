package wrimsv2.evaluator;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Svar;
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

public class ValueEvaluation {
	private static int start;
	private static int end;
	private static int step;
	
	public static double convertStringToDouble(String text){
		return Double.parseDouble(text);
	}
	
	public static int convertStringToInt(String text){
		return Integer.parseInt(text);
	}
	
	public static String convertDoubleToString(double value){
		return Double.toString(value);
	}
	
	public static String convertIntToString(int value){
		return Integer.toString(value);
	}
	
	public static boolean relationStatement(IntDouble id1, IntDouble id2, String relation){
		double value1=id1.getData().doubleValue();
		double value2=id2.getData().doubleValue();
		
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
	
	public static IntDouble term_knownTS(IntDouble result){
		return result;
	}
	
	public static IntDouble term_IDENT (String ident){
		if (ControlData.currSvMap.containsKey(ident)){
			IntDouble id0=ControlData.currSvMap.get(ident).getData();
			return new IntDouble(id0.getData(),id0.isInt());
		}else if (ControlData.currTsMap.containsKey(ident)){
			IntDouble id0=ControlData.currTsMap.get(ident).getData();
			return new IntDouble(id0.getData(),id0.isInt());
		}else if (ControlData.isPostProcessing && ControlData.currDvMap.containsKey(ident)){
			IntDouble id0=ControlData.currDvMap.get(ident).getData();
			return new IntDouble(id0.getData(),id0.isInt());
		}else if (ControlData.isPostProcessing && ControlData.currAliasMap.containsKey(ident)){
			IntDouble id0=ControlData.currAliasMap.get(ident).getData();
			return new IntDouble(id0.getData(),id0.isInt());
		}
		if (ControlData.sumIndex.size()>0){
			LoopIndex li=ControlData.sumIndex.pop();
			if (li.getName().equals(ident) && li.getIndexStart()){
				ControlData.sumIndex.push(li);
				return new IntDouble(li.getValue(),true);
			}
			ControlData.sumIndex.push(li);
		}
		Error.addEvaluationError(ident+" is not in svar, dvar, alias list.");
		return new IntDouble (1.0, false);
	}
	
	public static IntDouble term_SVAR (String ident){
		IntDouble data;
		if (!ControlData.currSvMap.containsKey(ident)){
			if (!ControlData.currTsMap.containsKey(ident)){
				Error.addEvaluationError("State variable "+ident+" is not defined before used.");
				return new IntDouble(1.0, false);
			}else{
				data=ControlData.currTsMap.get(ident).getData();
			}
		}else{
			data=ControlData.currSvMap.get(ident).getData();
		}
		
		if (data == null){
			Error.addEvaluationError("The value of state variable "+ident+" is not defined before used.");
			return new IntDouble(1.0, false);
		}
		return new IntDouble(data.getData(), data.isInt());
	}
	
	public static IntDouble term_INTEGER (String integer){
		return new IntDouble(convertStringToInt(integer), true);
	}
	
	public static IntDouble term_FLOAT (String floatValue){
		return new IntDouble(convertStringToDouble(floatValue), false);
	}
	
	public static IntDouble unary (String s, IntDouble id){
		if (s !=null){
			if (id.isInt()){
				int value=-id.getData().intValue();
				id.setData(value);
			}else{
				double value=-id.getData().doubleValue();
				id.setData(value);
			}
		}
		return id;
	}
		
	public static IntDouble mult(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (!id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()*id2.getData().doubleValue(), false);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()*id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()*id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().intValue()*id2.getData().intValue(), true);
		}
		return id;
	}
	
	public static IntDouble divide(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id2.getData().doubleValue()==0.0){
			Error.addEvaluationError("divided by 0.");
			return new IntDouble(1.0, false);
		}
		if (!id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()/id2.getData().doubleValue(), false);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()/id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()/id2.getData().intValue(), false);
		}else {
			id=new IntDouble(id1.getData().intValue()/id2.getData().intValue(), true);
		}
		return id;		
	}
		
	public static IntDouble mod(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (id2.getData().doubleValue()==0.0){
			Error.addEvaluationError("Mod function uses 0 as divider.");
			return new IntDouble(1.0, false);
		}
		if (!id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()%id2.getData().doubleValue(), false);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()%id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()%id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().intValue()%id2.getData().intValue(), true);
		}
		return id;		
	}
		
	public static IntDouble add(IntDouble id1, IntDouble id2){
		IntDouble id;
		if (!id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()+id2.getData().doubleValue(), false);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()+id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()+id2.getData().intValue(), false);
		}else {
			id=new IntDouble(id1.getData().intValue()+id2.getData().intValue(), true);
		}
		return id;		
	}
	
	public static IntDouble substract(IntDouble id1, IntDouble id2){
		IntDouble id;	
		if (!id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()-id2.getData().doubleValue(), false);
		}else if (id1.isInt() && !id2.isInt()){
			id=new IntDouble(id1.getData().intValue()-id2.getData().doubleValue(), false);
		}else if (!id1.isInt() && id2.isInt()){
			id=new IntDouble(id1.getData().doubleValue()-id2.getData().intValue(), false);
		}else{
			id=new IntDouble(id1.getData().intValue()-id2.getData().intValue(), true);
		}
		return id;		
	}
	
	public static IntDouble noArgFunction(String ident){
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
				return new IntDouble(Double.parseDouble(valueString), false);
			}else{
				return new IntDouble(Integer.parseInt(valueString), true);
			}
			
		} catch (Exception e) {
			Error.addEvaluationError("The function " +ident+" is not defined in the WRIMS engine. Re-run preprocessor for dlls.");
			result=new IntDouble (1.0,false);
			return result;
		}
	}
	
	public static IntDouble argFunction(String ident, ArrayList<IntDouble> idArray){
		IntDouble result;
		if (idArray.size()==1){
			if (ControlData.currSvMap.containsKey(ident)||ControlData.currTsMap.containsKey(ident)||ControlData.currDvMap.containsKey(ident)||ControlData.currAliasMap.containsKey(ident)) return getTimeSeries(ident, idArray);
		}
			
		Class function;
		try {
			Stack stack = new Stack();
			for (int i=0; i<idArray.size(); i++){
				IntDouble id=idArray.get(i);
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
				function = Class.forName("wrimsv2.external.Function"+ident);
				ef = (ExternalFunction)function.newInstance();
				ControlData.allExternalFunctionMap.put(ident, ef);
			}
			ef.execute(stack);
			String valueString=stack.pop().toString();
			
			if (valueString.contains(".")){       
				return new IntDouble(Double.parseDouble(valueString), false);
			}else{
				return new IntDouble(Integer.parseInt(valueString), true);
			}
			
		} catch (Exception e) {
			Error.addEvaluationError("The function " +ident+" is not defined in the WRIMS engine. Re-run preprocessor for dlls.");
			result=new IntDouble (1.0,false);
			return result;
		}
	}
	
	public static IntDouble getTimeSeries(String ident, ArrayList<IntDouble> idArray){		
		IntDouble result;
		boolean isSumIndex=false;
		int indexValue=0;
		boolean isIndexStart=true;
		
		IntDouble id=idArray.get(0);	
		
		if (!id.isInt()){
			Error.addEvaluationError("The index of "+ident+" should be integer.");
			result=new IntDouble (1.0,false);
			return result;
		}

		int idValue=id.getData().intValue();
		TimeOperation.findTime(idValue);
		
		double value;
		if (ControlData.currDvMap.containsKey(ident)||ControlData.currAliasMap.containsKey(ident)){
			value=dvarAliasTimeSeries(ident,id.getData().intValue());
		}else{
			if (ControlData.currSvMap.containsKey(ident)){ 
				if (idValue==0)	{
					return ControlData.currSvMap.get(ident).getData();
				}else if(idValue>0){
					String futSvName=ident+"__fut__"+idValue;
					if (ControlData.currSvFutMap.containsKey(futSvName)){
						return ControlData.currSvFutMap.get(futSvName).getData();
					}else{
						Error.addEvaluationError(futSvName+", the future value of "+ident+" is used before defined.");
						return new IntDouble (1.0,false);
					}
				}
			}
			value=svarTimeSeries(ident);
		}
		
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
		
		int index=indexValue+ControlData.currTimeStep.get(ControlData.currCycleIndex);
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
	
	public static IntDouble timeseries(){
		String svName=ControlData.currEvalName;
		TimeOperation.findTime(0);
		double value=svarTimeSeries(svName);
		return new IntDouble(value,false);
	}
	
	public static double timeseries(String tsName){
		TimeOperation.findTime(0);
		return svarTimeSeries(tsName);
	}
	
	public static IntDouble pastCycleNoTimeArray(String ident, String cycle){
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
	
	public static IntDouble pastCycleTimeArray(String ident, String cycle, IntDouble id){
		IntDouble data=new IntDouble(1.0,false);
		if (!id.isInt()){
			Error.addEvaluationError("Time array index of "+ident+" is not an integer.");
			return data;
		}
		int index=id.getData().intValue();
		if (index<0){
			ArrayList<IntDouble> idArray=new ArrayList<IntDouble>();
			idArray.add(id);
			return getTimeSeries(ident, idArray);
		}else if(index==0){
			return pastCycleNoTimeArray(ident, cycle);
		}
		Map<String, Map<String, IntDouble>> varTimeArrayCycleValueMap=ControlData.currStudyDataSet.getVarTimeArrayCycleValueMap();
	    String varTimeArrayName=ident+"__fut__"+index;
		if (varTimeArrayCycleValueMap.containsKey(varTimeArrayName)){
			Map<String, IntDouble> var= varTimeArrayCycleValueMap.get(varTimeArrayName);
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
	
	public static IntDouble max(IntDouble id1, IntDouble id2){
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
	
	public static IntDouble min(IntDouble id1, IntDouble id2){
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
	
	public static IntDouble intFunc(IntDouble id1){
		IntDouble id;
		if (!id1.isInt()){
			id=new IntDouble(((int)id1.getData().doubleValue()), true);
			return id;
		}
		return id1;
	}
	
	public static IntDouble realFunc(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble((id1.getData().doubleValue()), false);
			return id;
		}
		return id1;
	}
	
	public static IntDouble abs(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.abs(id1.getData().intValue()), true);
		}else{
			id=new IntDouble(Math.abs(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static IntDouble exp(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.exp(id1.getData().intValue()), false);
		}else{
			id=new IntDouble(Math.exp(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static IntDouble log(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.log(id1.getData().intValue()), false);
		}else{
			id=new IntDouble(Math.log(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static IntDouble log10(IntDouble id1){
		IntDouble id;
		if (id1.isInt()){
			id=new IntDouble(Math.log10(id1.getData().intValue()), false);
		}else{
			id=new IntDouble(Math.log10(id1.getData().doubleValue()), false);
		}
		return id;
	}
	
	public static IntDouble pow(IntDouble id1, IntDouble id2){
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
	
	public static IntDouble daysIn(){
		int days=TimeOperation.numberOfDays(ControlData.currMonth, ControlData.currYear);
		return new IntDouble(days, true);
	}
	
	public static IntDouble tafcfs_term(String ident, IntDouble id){
		if (id==null){
			ControlData.dataMonth=ControlData.currMonth;
			ControlData.dataYear=ControlData.currYear;
		}else{
			if (!id.isInt()){
				Error.addEvaluationError("The index of "+ident+" should be integer.");
			}
			TimeOperation.findTime(id.getData().intValue());
		}
		double convert = tafcfs(ident);
		return new IntDouble(convert, false);
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
	
	public static IntDouble term_YEAR(){
		return new IntDouble(TimeOperation.waterYearValue(), true);
	}
	
	public static IntDouble term_MONTH(){
		return new IntDouble(TimeOperation.waterMonthValue(ControlData.currMonth), true);
	}
	
	public static IntDouble term_DAY(){
		return new IntDouble(ControlData.currDay, true);
	}
	
	public static IntDouble  term_MONTH_CONST(String month){
		int monthValue=TimeOperation.monthValue(month);
		return new IntDouble(TimeOperation.waterMonthValue(monthValue), true);
	}
	
	public static IntDouble term_PASTMONTH(String pastMonth){
		pastMonth=pastMonth.substring(4);
		int pastMonthValue=TimeOperation.monthValue(pastMonth);
		int index=pastMonthValue-ControlData.currMonth;
		if (index>=0){
			index=index-12;
		}
		return new IntDouble(index,true);
	}
	
	public static IntDouble term_ARRAY_ITERATOR(){
		return new IntDouble(ControlData.timeArrayIndex, true);
	}
	
	public static void sumExpression_IDENT(String ident){
		//To Do: check if svar, dvar, alias contains ident
		LoopIndex li=new LoopIndex(ident, 0, false);
		ControlData.sumIndex.push(li);
	}
	
	public static void initSumExpression(IntDouble id1, IntDouble id2, String s){
		step=1;
		if (!s.equals("")){
			step=convertStringToInt(s);
		}
		if (!id1.isInt()){
			Error.addEvaluationError("the starting index should be integer");
		}
		if (!id2.isInt()){
			Error.addEvaluationError("the ending index should be integer");
		}
		start=id1.getData().intValue();
		end=id2.getData().intValue();
		LoopIndex li=ControlData.sumIndex.pop();
		li.setValue(start);
		li.setIndexStart(true);
		ControlData.sumIndex.push(li);
	}
	
	public static IntDouble sumExpression(IntDouble id, String expression){	
		if (step>=0){
			start=start+step;
			if (start>end) return id;
			for (int i=start; i<=end; i=i+step){
				LoopIndex li=ControlData.sumIndex.pop();
				li.setValue(i);
				li.setIndexStart(true);
				ControlData.sumIndex.push(li);
				ANTLRStringStream stream = new ANTLRStringStream("v: "+expression); 
				ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
				try{
					evaluator.evaluator();
				}catch (RecognitionException e){
					Error.addEvaluationError(e.toString());
				}
			
				IntDouble id0=evaluator.evalValue;
				id=add(id, id0);
			}
		}else{
			start=start+step;
			if (start<end) return id;
			for (int i=start; i>=end; i=i+step){
				LoopIndex li=ControlData.sumIndex.pop();
				li.setValue(i);
				li.setIndexStart(true);
				ControlData.sumIndex.push(li);
				ANTLRStringStream stream = new ANTLRStringStream("v: "+expression); 
				ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
				try{
					evaluator.evaluator();
				}catch (RecognitionException e){
					Error.addEvaluationError(e.toString());
				}
			
				IntDouble id0=evaluator.evalValue;
				id=add(id, id0);
			}
		}
		
		ControlData.sumIndex.pop();
		return id;
	}
	
	public static Number assignWhereStatement(IntDouble id){
		return id.getData();
	}
	
	public static IntDouble tableSQL(String table, String select, HashMap<String, Number> where, HashMap<String, Number> given, String use){
		IntDouble id;
		if (where==null){	
			return TableOperation.findData(table, select, given, use);
		}else{
			return TableOperation.findData(table, select, where, given, use);
		}
	}
	
	public static IntDouble expressionInput(IntDouble id){
		return id;
	}
}
