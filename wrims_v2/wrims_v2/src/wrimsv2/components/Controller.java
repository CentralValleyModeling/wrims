package wrimsv2.components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.evaluator.Evaluation;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.PreEvaluator;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.evaluator.ValueEvaluatorLexer;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.external.LoadAllDll;
import wrimsv2.solver.Solver;
import wrimsv2.tools.RCCComparison;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;

public class Controller {
	
	private int totalTimeStep;
	private Date startTime;
	
	public Controller() {
		setControlData();
		try {
			StudyDataSet sds = parse();
			new PreEvaluator(sds);
			runModel(sds);
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Controller(String[] args) {
		setControlData(args);
		try {
			StudyDataSet sds = parse();
			new PreEvaluator(sds);
			runModel(sds);
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setControlData(){
        FilePaths.setSvarDssPaths("D:\\CalLite_Beta_042611\\DSS\\CL_FUTURE_WHL042611_SV.dss");
        FilePaths.setInitDssPaths("D:\\CalLite_Beta_042611\\DSS\\CalLite2020D09EINIT.dss");
        FilePaths.setMainFilePaths("D:\\CalLite_Beta_042611\\Run\\main_BO.wresl");
		ControlData cd=new ControlData();
        cd.svDvPartF="2020D09E";
        cd.initPartF="2020D09E";
		cd.partA = "CALSIM";
		cd.partE = "1MON";
		cd.timeStep="1MON";
        cd.startYear=1921;
        cd.startMonth=10;
        cd.startDay=31;
        cd.endYear=1921;
        cd.endMonth=10;
        cd.endDay=31;
        cd.simulationTimeFrame=TimeOperation.dssTimeFrame(cd.startYear, cd.startMonth, cd.startDay, cd.endYear, cd.endMonth, cd.endDay);
        cd.currYear=ControlData.startYear;
        cd.currMonth=ControlData.startMonth;
        cd.currDay=ControlData.startDay;
	}
	
	public void setControlData(String[] args){
        FilePaths.setMainFilePaths(args[0]);
        FilePaths.setSvarDssPaths(args[1]);
        FilePaths.setInitDssPaths(args[2]);
        FilePaths.setDvarDssPaths(args[3]);
		ControlData cd=new ControlData();
		cd.svDvPartF=args[4];
		cd.initPartF=args[5];
		cd.partA = args[6];
		cd.partE = args[7];
		cd.timeStep = args[7];
		cd.startYear=Integer.parseInt(args[8]);
		cd.startMonth=Integer.parseInt(args[9]);
		cd.startDay=Integer.parseInt(args[10]);
		cd.endYear=Integer.parseInt(args[11]);
		cd.endMonth=Integer.parseInt(args[12]);
		cd.endDay=Integer.parseInt(args[13]);
		cd.simulationTimeFrame=TimeOperation.dssTimeFrame(cd.startYear, cd.startMonth, cd.startDay, cd.endYear, cd.endMonth, cd.endDay);
		cd.currYear=cd.startYear;
		cd.currMonth=cd.startMonth;
		cd.currDay=cd.startDay;
	}
	
	public StudyDataSet parse()throws RecognitionException, IOException{
		Calendar cal = Calendar.getInstance();
		System.out.println("Before Parsser: "+cal.getTimeInMillis());
		
		String csvFolderPath = "TestWreslWalker";
		String inputFilePath = FilePaths.fullMainPath;
		String logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
				
		WriteCSV.study(sd, csvFolderPath ) ;
	
		return sd;	
	}
	
	public void runModel(StudyDataSet sds){
		ControlData.currStudyDataSet=sds;
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		startTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
				
		ControlData.groupInit= DSSUtil.createGroup("local", FilePaths.fullInitDssPath);
		ControlData.groupSvar= DSSUtil.createGroup("local", FilePaths.fullSvarDssPath);
		ControlData.allTsMap=sds.getTimeseriesMap();
		
		totalTimeStep=getTotalTimeStep();
		Calendar cal = Calendar.getInstance();
		System.out.println("After Parsser: "+cal.getTimeInMillis());
		readTimeseries();
		initialDvarAliasTS(totalTimeStep);
		for (int i=0; i<modelList.size(); i++){
			String model=modelList.get(i);
			ModelDataSet mds=modelDataSetMap.get(model);
			ControlData.currModelDataSet=mds;
			ControlData.currCycleIndex=i;
			processExternal();
		}
		
		prepareSolver();
		boolean noError=true;
		ControlData.currTimeStep=0;
		while (ControlData.currTimeStep<totalTimeStep && noError){
			int i=0;
			while (i<modelList.size() && noError){
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currSvMap=mds.svMap;
				ControlData.currDvMap=mds.dvMap;
				ControlData.currAliasMap=mds.asMap;
				ControlData.currGoalMap=mds.gMap;
				ControlData.currTsMap=mds.tsMap;
				ControlData.currCycleIndex=i;
				ControlData.isPostProcessing=false;
				cal = Calendar.getInstance();
				System.out.println("Before Evaluation: "+cal.getTimeInMillis());
				processModel();
				if (Error.error_evaluation.size()>=1){
					Error.writeEvaluationErrorFile("evaluation_error.txt");
					noError=false;
				}
				cal = Calendar.getInstance();
				System.out.println(" After Evaluation: "+cal.getTimeInMillis());
				new Solver();
				cal = Calendar.getInstance();
				System.out.println("    After solving: "+cal.getTimeInMillis());
				if (Error.error_solving.size()<1){
					assignDvar();
					cal = Calendar.getInstance();
					System.out.println("After assign dvar: "+cal.getTimeInMillis());
					ControlData.isPostProcessing=true;
					processAlias();
				}else{
					Error.writeSolvingErrorFile("solving_error.txt");
					noError=false;
				}
				cal = Calendar.getInstance();
				System.out.println("      After alias: "+cal.getTimeInMillis());
				new RCCComparison();
				i=i+1;
			}
			if (ControlData.timeStep.equals("1MON")){
				currTimeAddOneMonth();
			}else{
				currTimeAddOneDay();
			}
			System.out.println(ControlData.currYear+"/"+ControlData.currMonth);
			ControlData.currTimeStep=ControlData.currTimeStep+1;
		}
		ControlData.solver.close();
	}
	
	public void prepareSolver(){
		ControlData.solver.openConnection();
		ControlData.solver.setModelSize(32, 32);
		ControlData.solver.setCommand("MAXIMIZE Yes MUTE NO FORCE No MATLIST BOTH");
		//ControlData.solver.setCommand("MPSX YES");
		ControlData.solver.setCommand( "FileName  "+FilePaths.mainDirectory+"  Output "+FilePaths.mainDirectory+"\\xa.log matlist v ToRcc Yes wait no" ) ;
	}
	
	public void processModel(){
		processTimeseries();
		Calendar cal = Calendar.getInstance();
		System.out.println(" After Timeseries: "+cal.getTimeInMillis());
		processSvar();
		cal = Calendar.getInstance();
		System.out.println("       After svar: "+cal.getTimeInMillis());
		processDvar();	
		cal = Calendar.getInstance();
		System.out.println("       After dvar: "+cal.getTimeInMillis());
		processGoal();	
		cal = Calendar.getInstance();
		System.out.println("       After goal: "+cal.getTimeInMillis());
		processWeight();
		cal = Calendar.getInstance();
		System.out.println("     After weight: "+cal.getTimeInMillis());
	}

	public void readTimeseries(){
		Map<String, Timeseries> tsMap=ControlData.currStudyDataSet.getTimeseriesMap();
		ControlData.currEvalTypeIndex=6;
		Set tsKeySet=tsMap.keySet();
		Iterator iterator=tsKeySet.iterator();
		while(iterator.hasNext()){
			String tsName=(String)iterator.next();
			//System.out.println("Reading svar timeseries "+tsName);
			//To Do: in the svar class, add flag to see if svTS has been loaded
			if (!DataTimeSeries.lookSvDss.contains(tsName)){ 
				DssOperation.getSVTimeseries(tsName, FilePaths.fullSvarDssPath);
				DataTimeSeries.lookSvDss.add(tsName);
			}
		}
	}
	
	public void	initialDvarAliasTS(long totalTimeStep){
		
	}
	
	public void processExternal(){
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
	
	public void processWeight(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> wtList = mds.wtList;
		Map<String, WeightElement> wtMap =mds.wtMap;
		SolverData.setWeightMap(wtMap);
		ControlData.currEvalTypeIndex=5;
		for (String wtName: wtList){
			ControlData.currEvalName=wtName;
			//System.out.println("Process weight "+wtName);
			WeightElement wt=wtMap.get(wtName);
			String wtString=wt.weight;
			String evalString="v: "+wtString;
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				wt.setValue(evaluator.evalValue.getData().doubleValue());
			} catch (RecognitionException e) {
				Error.addEvaluationError("weight definition has error");
				wt.setValue(0.0);
			}
		}
	}
	
	public void processSvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> svList = mds.svList;
		Map<String, Svar> svMap =mds.svMap;
		ControlData.currEvalTypeIndex=0;
		for (String svName: svList){
			ControlData.currEvalName=svName;
			//System.out.println("Process svar "+svName);
			Svar svar=svMap.get(svName);
			ArrayList<ValueEvaluatorParser> caseConditions=svar.caseConditionParsers;
			boolean condition=false;
			int i=-1;
			while(!condition && i<=caseConditions.size()-2){
				i=i+1;
				ValueEvaluatorParser caseCondition=caseConditions.get(i);
				try{
					caseCondition.evaluator();
					condition=caseCondition.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Case condition evaluation has error.");
					condition=false;
				}
				caseCondition.reset();
			}
			if (condition){
				if (svName.equals("trinity_import1")){
					int x=0;
				}
				ArrayList<ValueEvaluatorParser> caseExpressions=svar.caseExpressionParsers;
				ValueEvaluatorParser caseExpression=caseExpressions.get(i);
				if (svName.equals("lod_future")){
					int x=0;
				}
				try {
					caseExpression.evaluator();
					svar.setData(caseExpression.evalValue);
				} catch (RecognitionException e) {
					Error.addEvaluationError("Case expression evaluation has error.");
					svar.setData(new IntDouble(1.0, false));
				}
				caseExpression.reset();
			}else{
				Error.addEvaluationError("None of the case conditions is satisfied.");
				svar.setData(new IntDouble(1.0, false));
			}
		}
	}
	
	public void processTimeseries(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> tsList = mds.tsList;
		Map<String, Timeseries> tsMap =mds.tsMap;
		ControlData.currEvalTypeIndex=5;
		for (String tsName:tsList){
			ControlData.currEvalName=tsName;
			//System.out.println("process timeseries "+tsName);
			Timeseries ts=tsMap.get(tsName);
			ts.setData(new IntDouble(Evaluation.timeseries(tsName),false));
		}
	}
	
	public void processDvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> dvList = mds.dvList;
		Map<String, Dvar> dvMap =mds.dvMap;
		SolverData.setDvarMap(dvMap);
		ControlData.currDvMap=dvMap;
		ControlData.currEvalTypeIndex=1;
		for (String dvName: dvList){
			ControlData.currEvalName=dvName;
			//System.out.println("Process dvar "+dvName);
			Dvar dvar=dvMap.get(dvName);
			
			String evalString="v: "+dvar.lowerBound;
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				dvar.lowerBoundValue=evaluator.evalValue.getData();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Lowerbound evaluation has error.");
				dvar.lowerBoundValue=-901.0;
			}
			
			evalString="v: "+dvar.upperBound;
			stream = new ANTLRStringStream(evalString);
			lexer = new ValueEvaluatorLexer(stream);
			tokenStream = new CommonTokenStream(lexer);
			evaluator = new ValueEvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				dvar.upperBoundValue=evaluator.evalValue.getData();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Lowerbound evaluation has error.");
				dvar.lowerBoundValue=-901.0;
			}
		}
	}
	
	public void processGoal(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> gList = mds.gList;
		Map<String, Goal> gMap =mds.gMap;
		ControlData.currEvalTypeIndex=3;
		SolverData.clearConstraintDataMap();
		for (String goalName: gList){
			ControlData.currEvalName=goalName;
			//System.out.println("Process constraint "+goalName);
			Goal goal=gMap.get(goalName);
			ArrayList<String> caseCondition=goal.caseCondition;
			boolean condition=false;
			int i=-1;
			while(!condition && i<=caseCondition.size()-2){
				i=i+1;
				String evalString="c: "+caseCondition.get(i);
				ANTLRStringStream stream = new ANTLRStringStream(evalString);
				ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
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
	
	public void assignDvar(){
		Map<String, Dvar> dvarMap = ControlData.currDvMap;
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
		
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			double value=ControlData.solver.getColumnActivity(dvName);
			dvar.setData(new IntDouble(value,false));
			if (!DataTimeSeries.dvAliasTS.containsKey(dvName)){
				DssDataSetFixLength dds=new DssDataSetFixLength();
				double[] data=new double[totalTimeStep];
				dds.setData(data);
				dds.setTimeStep(ControlData.partE);
				dds.setStartTime(startTime);
				DataTimeSeries.dvAliasTS.put(dvName,dds);
			}
			double[] dataList=DataTimeSeries.dvAliasTS.get(dvName).getData();
			dataList[ControlData.currTimeStep]=value;
		}
	}
	
	public void processAlias(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> asList = mds.asList;
		Map<String, Alias> asMap =mds.asMap;
		ControlData.currEvalTypeIndex=2;
		for (String asName: asList){
			ControlData.currEvalName=asName;
			//System.out.println("Process alias "+asName);
			Alias alias=asMap.get(asName);
			
			String evalString="v: "+alias.expression;
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
			try {
				evaluator.evaluator();
				IntDouble id=evaluator.evalValue;
				alias.data=id;
				if (!DataTimeSeries.dvAliasTS.containsKey(asName)){
					DssDataSetFixLength dds=new DssDataSetFixLength();
					double[] data=new double[totalTimeStep];
					dds.setData(data);
					dds.setTimeStep(ControlData.partE);
					dds.setStartTime(startTime);
					DataTimeSeries.dvAliasTS.put(asName,dds);
				}
				double[] dataList=DataTimeSeries.dvAliasTS.get(asName).getData();
				dataList[ControlData.currTimeStep]=id.getData().doubleValue();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Alias evaluation has error.");
				alias.data=new IntDouble(-901.0,false);
				double[] dataList=DataTimeSeries.dvAliasTS.get(asName).getData();
				dataList[ControlData.currTimeStep]=-901.0;
			}
		}
	}
	
	public int getTotalTimeStep(){
		if (ControlData.timeStep.equals("1MON")){
			return (ControlData.endYear-ControlData.startYear)*12+(ControlData.endMonth-ControlData.startMonth)+1;
		}else{
			Date startDate = new Date (ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
			Date endDate=new Date (ControlData.endYear-1900, ControlData.endMonth-1, ControlData.endDay);
			long startTime=startDate.getTime();
			long endTime=endDate.getTime();
			return (int)(endTime-startTime)/(24*60*60*1000)+1;
		}
	}
	
	public void currTimeAddOneMonth(){
		ControlData.currMonth=ControlData.currMonth+1;
		ControlData.currYear=ControlData.currYear;
		if (ControlData.currMonth>12){
			ControlData.currMonth=ControlData.currMonth-12;
			ControlData.currYear=ControlData.currYear+1;
		}
	}

	public void currTimeAddOneDay(){
		Date currDate = new Date (ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay);
		long currTime=currDate.getTime()+1 * 24 * 60 * 60 * 1000;
		currDate = new Date (currTime);
		ControlData.currMonth=currDate.getMonth()+1;
		ControlData.currYear=currDate.getYear()+1900;
	}
	
	public static void main(String[] args){
		new Controller(args);
	}
}