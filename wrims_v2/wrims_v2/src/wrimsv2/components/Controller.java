package wrimsv2.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.commondata.solverData.SolverData;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.TimeOperation;

public class Controller {
	public Controller(StudyDataSet sds){
		ControlData.currStudyDataSet=sds;
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		Date currTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
		Date endTime=new Date(ControlData.endYear-1900, ControlData.endMonth-1, ControlData.endDay);
		while (currTime.getTime()<=endTime.getTime()){
			for (int i=0; i<modelList.size(); i++){
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleIndex=i;
				processModel();
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
		processExternal();
		processSvar();
		//processDvar();	//To Do: allow process dvar
		//processGoal();	//To Do: allow process goal
	}
	
	public static void processExternal(){
		
	}
	
	public static void processSvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> svList = mds.svList;
		Map<String, Svar> svMap =mds.svMap;
		ControlData.currSvMap=svMap;
		ControlData.currEvalTypeIndex=0;
		for (String svName: svList){
			ControlData.currEvalName=svName;
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
					Error.error_evaluation.add("Case condition evaluation has error.");
					condition=false;
				}
			}
			if (condition){
				String evalString="v: "+svar.caseExpression.get(i);
				ANTLRStringStream stream = new ANTLRStringStream(evalString);
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try {
					evaluator.evaluator();
					svar.setValue(evaluator.evalValue.getData());
				} catch (RecognitionException e) {
					Error.error_evaluation.add("Case expression evaluation has error.");
					svar.setValue(0);
				}
			}else{
				Error.error_evaluation.add("None of the case conditions is satisfied.");
				svar.setValue(0);
			}
		}
	}
	
	public static void processDvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> dvList = mds.dvList;
		Map<String, Dvar> dvMap =mds.dvMap;
		ControlData.currDvMap=dvMap;
		ControlData.currEvalTypeIndex=1;
		for (String dvName: dvList){
			ControlData.currEvalName=dvName;
			Dvar dvar=dvMap.get(dvName);
			SolverData.getDvarMap().put(dvName, dvar);
			
			String evalString="v: "+dvar.lowerBound;
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			EvaluatorLexer lexer = new EvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				dvar.lowerBoundValue=evaluator.evalValue.getData();
			} catch (RecognitionException e) {
				Error.error_evaluation.add("Lowerbound evaluation has error.");
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
				Error.error_evaluation.add("Lowerbound evaluation has error.");
				dvar.lowerBoundValue=-901.0;
			}
		}
	}
	
	public static void processGoal(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> gList = mds.gList;
		Map<String, Goal> gMap =mds.gMap;
		ControlData.currGoalMap=gMap;
		ControlData.currEvalTypeIndex=3;
		for (String goalName: gList){
			ControlData.currEvalName=goalName;
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
					Error.error_evaluation.add("Case condition evaluation has error.");
					condition=false;
				}
			}
			if (condition){
				String evalString="g: "+goal.caseExpression.get(i);
				ANTLRStringStream stream = new ANTLRStringStream(evalString);
				EvaluatorLexer lexer = new EvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
				try {
					evaluator.evaluator();
					SolverData.getConstraintDataMap().put(goalName,evaluator.evalConstraint);
				} catch (RecognitionException e) {
					Error.error_evaluation.add("Case expression evaluation has error.");
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