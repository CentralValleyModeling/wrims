package wrimsv2.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import vista.db.dss.DSSUtil;
import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.evaluator.Evaluation;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.IntDouble;
import wrimsv2.external.LoadAllDll;

public class Controller {
	public Controller(StudyDataSet sds){
		ControlData.currStudyDataSet=sds;
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		Date currTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
		Date endTime=new Date(ControlData.endYear-1900, ControlData.endMonth-1, ControlData.endDay);
		
		ControlData.groupInit= DSSUtil.createGroup("local", FilePaths.fullInitDssPath);
		ControlData.groupSvar= DSSUtil.createGroup("local", FilePaths.fullSvarDssPath);
		ControlData.allTsMap=sds.getTimeseriesMap();
		readTimeseries();
		for (int i=0; i<modelList.size(); i++){  
			String model=modelList.get(i);
			ModelDataSet mds=modelDataSetMap.get(model);
			ControlData.currModelDataSet=mds;
			ControlData.currCycleIndex=i;
			processExternal();
		}
		
		while (currTime.getTime()<=endTime.getTime()){
			for (int i=0; i<modelList.size(); i++){
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currSvMap=mds.svMap;
				ControlData.currDvMap=mds.dvMap;
				ControlData.currAliasMap=mds.asMap;
				ControlData.currGoalMap=mds.gMap;
				ControlData.currTsMap=mds.tsMap;
				ControlData.currCycleIndex=i;
				processModel();
				Error.writeEvaluationErrorFile("evaluation_error.txt"); 
			}
			if (ControlData.timeStep.equals("1MON")){
				currTimeAddOneMonth();
			}else{
				currTimeAddOneDay();
			}
			currTime=new Date(ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay); 
		}
	}
	
	public static void processModel(){
		processTimeseries();
		processSvar();
		processDvar();	
		processGoal();	
		processWeight();
	}

	public static void readTimeseries(){
		Map<String, Timeseries> tsMap=ControlData.currStudyDataSet.getTimeseriesMap();
		ControlData.currEvalTypeIndex=6;
		Set tsKeySet=tsMap.keySet();
		Iterator iterator=tsKeySet.iterator();
		while(iterator.hasNext()){
			String tsName=(String)iterator.next();
			System.out.println("Reading svar timeseries "+tsName);
			//To Do: in the svar class, add flag to see if svTS has been loaded
			if (!DataTimeSeries.lookSvDss.contains(tsName)){ 
				DssOperation.getSVTimeseries(tsName, FilePaths.fullSvarDssPath);
				DataTimeSeries.lookSvDss.add(tsName);
			}
		}
	}
	
	public static void processExternal(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> exList = mds.exList;
		Map<String, External> exMap =mds.exMap;
		ControlData.currExMap=exMap;
		ControlData.currEvalTypeIndex=4;
		for (String exName: exList){
			if (!ControlData.allExternalFunction.containsKey(exName)){
				ControlData.currEvalName=exName;
				External external=exMap.get(exName);
				ControlData.allExternalFunction.put(exName, external.type);
				if (!external.type.equals("f90") && !ControlData.allDll.contains(exName)){
					ControlData.allDll.add(external.type);
				}
			}
		}
		new LoadAllDll(ControlData.allDll);
	}
	
	public static void processWeight(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> wtList = mds.wtList;
		Map<String, WeightElement> wtMap =mds.wtMap;
		SolverData.setWeightMap(wtMap);
		ControlData.currEvalTypeIndex=5;
		for (String wtName: wtList){
			ControlData.currEvalName=wtName;
			System.out.println("Process weight "+wtName);
			WeightElement wt=wtMap.get(wtName);
			String wtString=wt.weight;
			try{
				wt.setValue(Double.parseDouble(wtString));
			} catch (NumberFormatException e1){
				try{
					Integer wtValue=Integer.parseInt(wtString);
					wt.setValue(wtValue.doubleValue());
				}catch (NumberFormatException e2){
					String evalString="v: "+wtString;
					ANTLRStringStream stream = new ANTLRStringStream(evalString);
					EvaluatorLexer lexer = new EvaluatorLexer(stream);
					TokenStream tokenStream = new CommonTokenStream(lexer);
					EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
					try {
						evaluator.evaluator();
						wt.setValue(evaluator.evalValue.getData().doubleValue());
					} catch (RecognitionException e) {
						Error.addEvaluationError("weight definition has error");
						wt.setValue(0.0);
					}
				}
			}
		}
	}
	
	public static void processSvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> svList = mds.svList;
		Map<String, Svar> svMap =mds.svMap;
		ControlData.currEvalTypeIndex=0;
		for (String svName: svList){
			ControlData.currEvalName=svName;
			System.out.println("Process svar "+svName);
			Svar svar=svMap.get(svName);
			ArrayList<String> caseCondition=svar.caseCondition;
			boolean condition=false;
			int i=-1;
			while(!condition && i<=caseCondition.size()-2){
				i=i+1;
				String evalString="c: "+caseCondition.get(i);
				ANTLRStringStream stream = new ANTLRStringStream(evalString);
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try{
					evaluator.evaluator();
					condition=evaluator.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Case condition evaluation has error.");
					condition=false;
				}
			}
			if (condition){
				if (svName.equals("x2_last")){
					int x=0;
				}
				String evalString="v: "+svar.caseExpression.get(i);
				ANTLRStringStream stream = new ANTLRStringStream(evalString);
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try {
					evaluator.evaluator();
					svar.setData(evaluator.evalValue);
				} catch (RecognitionException e) {
					Error.addEvaluationError("Case expression evaluation has error.");
					svar.setData(new IntDouble(1.0, false));
				}
			}else{
				Error.addEvaluationError("None of the case conditions is satisfied.");
				svar.setData(new IntDouble(1.0, false));
			}
		}
	}
	
	public static void processTimeseries(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> tsList = mds.tsList;
		Map<String, Timeseries> tsMap =mds.tsMap;
		ControlData.currEvalTypeIndex=5;
		for (String tsName:tsList){
			ControlData.currEvalName=tsName;
			System.out.println("process timeseries "+tsName);
			Timeseries ts=tsMap.get(tsName);
			ts.setData(new IntDouble(Evaluation.timeseries(tsName),false));
		}
	}
	
	public static void processDvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> dvList = mds.dvList;
		Map<String, Dvar> dvMap =mds.dvMap;
		SolverData.setDvarMap(dvMap);
		ControlData.currDvMap=dvMap;
		ControlData.currEvalTypeIndex=1;
		for (String dvName: dvList){
			ControlData.currEvalName=dvName;
			System.out.println("Process dvar "+dvName);
			Dvar dvar=dvMap.get(dvName);
			
			String evalString="v: "+dvar.lowerBound;
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			EvaluatorLexer lexer = new EvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				dvar.lowerBoundValue=evaluator.evalValue.getData();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Lowerbound evaluation has error.");
				dvar.lowerBoundValue=-901.0;
			}
			
			evalString="v: "+dvar.upperBound;
			stream = new ANTLRStringStream(evalString);
			lexer = new EvaluatorLexer(stream);
			tokenStream = new CommonTokenStream(lexer);
			evaluator = new EvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				dvar.upperBoundValue=evaluator.evalValue.getData();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Lowerbound evaluation has error.");
				dvar.lowerBoundValue=-901.0;
			}
		}
	}
	
	public static void processAlias(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> asList = mds.asList;
		Map<String, Alias> asMap =mds.asMap;
		ControlData.currEvalTypeIndex=2;
		for (String asName: asList){
			ControlData.currEvalName=asName;
			System.out.println("Process alias "+asName);
			Alias alias=asMap.get(asName);
			
			String evalString="v: "+alias.expression;
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			EvaluatorLexer lexer = new EvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				alias.data=evaluator.evalValue;
			} catch (RecognitionException e) {
				Error.addEvaluationError("Alias evaluation has error.");
				alias.data=new IntDouble(-901.0,false);
			}
		}
	}
	
	public static void processGoal(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> gList = mds.gList;
		Map<String, Goal> gMap =mds.gMap;
		ControlData.currEvalTypeIndex=3;
		for (String goalName: gList){
			ControlData.currEvalName=goalName;
			System.out.println("Process constraint "+goalName);
			Goal goal=gMap.get(goalName);
			ArrayList<String> caseCondition=goal.caseCondition;
			boolean condition=false;
			int i=-1;
			while(!condition && i<=caseCondition.size()-2){
				i=i+1;
				String evalString="c: "+caseCondition.get(i);
				ANTLRStringStream stream = new ANTLRStringStream(evalString);
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try{
					evaluator.evaluator();
					condition=evaluator.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Case condition evaluation has error.");
					condition=false;
				}
			}
			if (condition){
				ANTLRStringStream stream = new ANTLRStringStream("g:"+goal.caseExpression.get(i));
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try {
					evaluator.evaluator();
					SolverData.getConstraintDataMap().put(goalName,EvaluatorParser.evalConstraint);
				} catch (RecognitionException e) {
					Error.addEvaluationError("Case expression evaluation has error.");
				}	
			}
		}
	}
		
	public static void currTimeAddOneMonth(){
		ControlData.currMonth=ControlData.currMonth+1;
		ControlData.currYear=ControlData.currYear;
		if (ControlData.currMonth>12){
			ControlData.currMonth=ControlData.currMonth-12;
			ControlData.currYear=ControlData.currYear+1;
		}
	}

	public static void currTimeAddOneDay(){
		Date currDate = new Date (ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay);
		long currTime=currDate.getTime()+1 * 24 * 60 * 60 * 1000;
		currDate = new Date (currTime);
		ControlData.currMonth=currDate.getMonth()+1;
		ControlData.currYear=currDate.getYear()+1900;
	}
}