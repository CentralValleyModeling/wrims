package wrimsv2.components;

import gurobi.GRBException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import com.sunsetsoft.xa.Optimizer;

import vista.db.dss.DSSDataWriter;
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
import wrimsv2.evaluator.AssignPastCycleVariable;
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
import wrimsv2.ilp.IntermediateLP;
import wrimsv2.solver.GurobiSolver;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.solver.XASolver;
import wrimsv2.solver.initialXALog;
import wrimsv2.solver.initialXASolver;
import wrimsv2.tools.RCCComparison;
import wrimsv2.wreslparser.elements.StudyUtils;

import lpsolve.*;

public class Controller {
	
	public Controller() {
		long startTimeInMillis = Calendar.getInstance().getTimeInMillis();
		setControlData();
		generateStudyFile();
		try {
			StudyDataSet sds = parse();
			if (StudyUtils.total_errors==0){
				new PreEvaluator(sds);
				runModel(sds);
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTimeInMillis = Calendar.getInstance().getTimeInMillis();
		int runPeriod=(int) (endTimeInMillis-startTimeInMillis);
		System.out.println("=================Run Time is "+runPeriod/60000+"min"+Math.round((runPeriod/60000.0-runPeriod/60000)*60)+"sec====");
	}
	
	public Controller(String[] args) {
		long startTimeInMillis = Calendar.getInstance().getTimeInMillis();
		setControlData(args);
		generateStudyFile();
		try {
			StudyDataSet sds = parse();
			if (StudyUtils.total_errors==0){
				new PreEvaluator(sds);
				runModel(sds);
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTimeInMillis = Calendar.getInstance().getTimeInMillis();
		int runPeriod=(int) (endTimeInMillis-startTimeInMillis);
		System.out.println("=================Run Time is "+runPeriod/60000+"min"+Math.round((runPeriod/60000.0-runPeriod/60000)*60)+"sec====");
	}
	
	public void setControlData(){
		FilePaths.groundwaterDir="D:\\BDCP_MODEL\\calsim30_alt1_elt_roa25_slr15_cc5_101111_w2\\calsim30_bo\\common\\CVGroundwater\\Data\\";
		FilePaths.setMainFilePaths("D:\\BDCP_MODEL\\calsim30_alt1_elt_roa25_slr15_cc5_101111_w2\\calsim30_bo\\conv\\Run\\mainCONV_30.wresl");
		FilePaths.setSvarDssPaths("D:\\BDCP_MODEL\\calsim30_alt1_elt_roa25_slr15_cc5_101111_w2\\calsim30_bo\\common\\DSS\\CalSim30_2020_SV.dss");
        FilePaths.setInitDssPaths("D:\\BDCP_MODEL\\calsim30_alt1_elt_roa25_slr15_cc5_101111_w2\\calsim30_bo\\conv\\DSS\\ALT1_ELT_102011_DV.dss");   
        FilePaths.setDvarDssPaths("D:\\BDCP_MODEL\\calsim30_alt1_elt_roa25_slr15_cc5_101111_w2\\calsim30_bo\\conv\\DSS\\ALT1_ELT_102011_DV.dss");
		ControlData cd=new ControlData();
		cd.svDvPartF="CALSIM30_2020";
		cd.initPartF="CALSIM30_2020";
		cd.partA = "CALSIM";
		cd.partE = "1MON";
		cd.timeStep="1MON";
		cd.startYear=1921;
		cd.startMonth=10;
		cd.startDay=31;
		cd.endYear=2003;
		cd.endMonth=9;
		cd.endDay=30;
        cd.solverName="XA";
        FilePaths.csvFolderName="csv";
        
		cd.currYear=cd.startYear;
		cd.currMonth=cd.startMonth;
		cd.currDay=cd.startDay;
        cd.writeDssStartYear=ControlData.startYear;
        cd.writeDssStartMonth=ControlData.startMonth;
        cd.writeDssStartDay=ControlData.startDay;
        cd.writeDssStartYear=ControlData.startYear;
        cd.writeDssStartMonth=ControlData.startMonth;
        cd.writeDssStartDay=ControlData.startDay;
        
		cd.totalTimeStep=getTotalTimeStep();
	}
	
	public void setControlData(String[] args){
		FilePaths.groundwaterDir=args[0];
        FilePaths.setMainFilePaths(args[1]);
        FilePaths.setSvarDssPaths(args[2]);
        FilePaths.setInitDssPaths(args[3]);
        FilePaths.setDvarDssPaths(args[4]);
		ControlData cd=new ControlData();
		cd.svDvPartF=args[5];
		cd.initPartF=args[6];
		cd.partA = args[7];
		cd.partE = args[8];
		cd.timeStep = args[8];
		cd.startYear=Integer.parseInt(args[9]);
		cd.startMonth=Integer.parseInt(args[10]);
		cd.startDay=Integer.parseInt(args[11]);
		cd.endYear=Integer.parseInt(args[12]);
		cd.endMonth=Integer.parseInt(args[13]);
		cd.endDay=Integer.parseInt(args[14]);
		cd.solverName=args[15];
		FilePaths.csvFolderName = args[16];
		cd.currYear=cd.startYear;
		cd.currMonth=cd.startMonth;
		cd.currDay=cd.startDay;
        cd.writeDssStartYear=cd.startYear;
        cd.writeDssStartMonth=cd.startMonth;
        cd.writeDssStartDay=cd.startDay;
        
		cd.totalTimeStep=getTotalTimeStep();
	}
	
	public void generateStudyFile(){
		String outPath=System.getenv("Java_Bin")+"study.sty";
		FileWriter outstream;
		try {
			outstream = new FileWriter(outPath);
			BufferedWriter out = new BufferedWriter(outstream);
			out.write("Study File: Generated by WRIMS. Do Not Edit!\n");
			out.write("Study Name\n");
			out.write("Author\n");
			out.write("Time\n");
			out.write("Note\n");
			out.write("Version\n");
			out.write(FilePaths.groundwaterDir+"\n");
			out.write("StudyFileFullPath\n");
			out.write(FilePaths.fullMainPath+"\n");
			out.write(FilePaths.fullSvarDssPath+"\n");
			out.write(FilePaths.fullDvarDssPath+"\n");
			out.write(FilePaths.fullInitDssPath+"\n");
			out.write(ControlData.timeStep+"\n");
			out.write(ControlData.totalTimeStep+"\n");
			out.write(ControlData.startDay+"\n");
			out.write(ControlData.startMonth+"\n");
			out.write(ControlData.startYear+"\n");
			out.write("SLP\n");
			out.write("CycleNumber\n");
			out.write("FALSE\n");
			out.write("NONE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("CALSIM\n");
			out.write(ControlData.initPartF+"\n");
			out.write(ControlData.svDvPartF+"\n");
			out.write("FALSE\n");
			out.write("TRUE\n");
			out.write("FALSE\n");
			out.write("SINGLE\n");
			out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StudyDataSet parse()throws RecognitionException, IOException{		
		return StudyUtils.checkStudy(FilePaths.fullMainPath, ControlData.sendAliasToDvar);
	}
	
	public void runModel(StudyDataSet sds){
		System.out.println("=============Prepare Run Study===========");
		new PreRunModel(sds);
		System.out.println("==============Run Study Start============");
		if (ControlData.solverName.equalsIgnoreCase("XA") || ControlData.solverName.equalsIgnoreCase("XALOG") ){
			runModelXA(sds);
		}else if (ControlData.solverName.equalsIgnoreCase("Gurobi")){
			runModelGurobi(sds);
		}else if (ControlData.solverName.equalsIgnoreCase("ILP")){
			runModelILP(sds);
		}else if (ControlData.solverName.equalsIgnoreCase("LPSolve")){
			try {
				runModeLPSolve(sds);
			} catch (LpSolveException e) {
				e.printStackTrace();
			}
		}
		System.out.println("=================Run ends!================");
	}
	
	public void runModeLPSolve(StudyDataSet sds) throws LpSolveException{
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		ControlData.currTimeStep=0;
		while (ControlData.currTimeStep<ControlData.totalTimeStep && noError){
			clearValues(modelList, modelDataSetMap);
			int i=0;
			while (i<modelList.size()  && noError){   
				ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
				boolean condition=false;
				try{
					modelCondition.evaluator();
					condition=modelCondition.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Model condition evaluation has error.");
					condition=false;
				}
				modelCondition.reset();
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				
				if (condition){
					ControlData.currSvMap=mds.svMap;
					ControlData.currDvMap=mds.dvMap;
					ControlData.currAliasMap=mds.asMap;
					ControlData.currGoalMap=mds.gMap;
					ControlData.currTsMap=mds.tsMap;
					ControlData.isPostProcessing=false;
					mds.processModel();
					if (Error.error_evaluation.size()>=1){
						Error.writeEvaluationErrorFile("evaluation_error.txt");
						noError=false;
					}
				
					new LPSolveSolver();

					System.out.println("Solving Done.");
					if (Error.error_solving.size()<1){
						System.out.println("Assign Dvar Done.");
						ControlData.isPostProcessing=true;
						mds.processAlias();
						System.out.println("Assign Alias Done.");
					}else{
						Error.writeSolvingErrorFile("solving_error.txt");
						noError=false;
					}
					System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
					//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==1) new RCCComparison();
				}else{
					new AssignPastCycleVariable();
				}
				i=i+1;
			}
			if (ControlData.timeStep.equals("1MON")){
				currTimeAddOneMonth();
			}else{
				currTimeAddOneDay();
			}
			ControlData.currTimeStep=ControlData.currTimeStep+1;
		}
		DssOperation.writeInitDvarAliasToDSS();
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
	
	public void runModelXA(StudyDataSet sds){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		new initialXASolver();
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		ControlData.currTimeStep=0;
		while (ControlData.currTimeStep<ControlData.totalTimeStep && noError){
			if (ControlData.solverName.equalsIgnoreCase("XALOG")) new initialXALog();
			clearValues(modelList, modelDataSetMap);
			int i=0;
			while (i<modelList.size()  && noError){  
				ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
				boolean condition=false;
				try{
					modelCondition.evaluator();
					condition=modelCondition.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Model condition evaluation has error.");
					condition=false;
				}
				modelCondition.reset();
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				
				if (condition){
					ControlData.currSvMap=mds.svMap;
					ControlData.currDvMap=mds.dvMap;
					ControlData.currAliasMap=mds.asMap;
					ControlData.currGoalMap=mds.gMap;
					ControlData.currTsMap=mds.tsMap;
					ControlData.isPostProcessing=false;
					mds.processModel();
					if (Error.error_evaluation.size()>=1){
						Error.writeEvaluationErrorFile("evaluation_error.txt");
						noError=false;
					}
					new XASolver();
					System.out.println("Solving Done.");
					if (Error.error_solving.size()<1){
						ControlData.isPostProcessing=true;
						mds.processAlias();
						System.out.println("Assign Alias Done.");
					}else{
						Error.writeSolvingErrorFile("solving_error.txt");
						noError=false;
					}
					System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
					//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==2) new RCCComparison();
				}else{
					new AssignPastCycleVariable();
				}
				i=i+1;
			}
			if (ControlData.timeStep.equals("1MON")){
				currTimeAddOneMonth();
			}else{
				currTimeAddOneDay();
			}
			ControlData.currTimeStep=ControlData.currTimeStep+1;
		}
		ControlData.xasolver.close();
		DssOperation.writeInitDvarAliasToDSS();
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
	
	public void runModelGurobi(StudyDataSet sds){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		ControlData.currTimeStep=0;
		while (ControlData.currTimeStep<ControlData.totalTimeStep && noError){
			clearValues(modelList, modelDataSetMap);
			int i=0;
			while (i<modelList.size()  && noError){   
				ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
				boolean condition=false;
				try{
					modelCondition.evaluator();
					condition=modelCondition.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Model condition evaluation has error.");
					condition=false;
				}
				modelCondition.reset();
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				
				if (condition){
					ControlData.currSvMap=mds.svMap;
					ControlData.currDvMap=mds.dvMap;
					ControlData.currAliasMap=mds.asMap;
					ControlData.currGoalMap=mds.gMap;
					ControlData.currTsMap=mds.tsMap;
					ControlData.isPostProcessing=false;
					mds.processModel();
					if (Error.error_evaluation.size()>=1){
						Error.writeEvaluationErrorFile("evaluation_error.txt");
						noError=false;
					}
					try{
						new GurobiSolver();
					}catch (GRBException e){
						Error.addSolvingError("Gurobi solving error: "+e.getMessage());
					}
					System.out.println("Solving Done.");
					if (Error.error_solving.size()<1){
						System.out.println("Assign Dvar Done.");
						ControlData.isPostProcessing=true;
						mds.processAlias();
						System.out.println("Assign Alias Done.");
					}else{
						Error.writeSolvingErrorFile("solving_error.txt");
						noError=false;
					}
					System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
					//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==1) new RCCComparison();
				}else{
					new AssignPastCycleVariable();
				}
				i=i+1;
			}
			if (ControlData.timeStep.equals("1MON")){
				currTimeAddOneMonth();
			}else{
				currTimeAddOneDay();
			}
			ControlData.currTimeStep=ControlData.currTimeStep+1;
		}
		DssOperation.writeInitDvarAliasToDSS();
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
	
	public void writeOutputDssEveryTenYears(){
		if (ControlData.currMonth==12 && ControlData.currYear%10==0){
			if (ControlData.timeStep.equals("1MON")){
				DssOperation.writeDVAliasToDSS();
			}else if(ControlData.timeStep.equals("1DAY") && ControlData.currDay==31){
				DssOperation.writeDVAliasToDSS();
			}
		}
	}
	
	public void clearValues(ArrayList<String> modelList, Map<String, ModelDataSet> modelDataSetMap){
		for (int i=0; i<modelList.size(); i++){   
			String model=modelList.get(i);
			ModelDataSet mds=modelDataSetMap.get(model);
			ArrayList<String> dvList = mds.dvList;
			Map<String, Dvar> dvMap =mds.dvMap;
			for (String dvName: dvList){
				Dvar dvar=dvMap.get(dvName);
				dvar.setData(null);
			}
			ArrayList<String> svList = mds.svList;
			Map<String, Svar> svMap =mds.svMap;
			for (String svName: svList){
				Svar svar=svMap.get(svName);
				svar.setData(null);
			}
			ArrayList<String> asList = mds.asList;
			Map<String, Alias> asMap =mds.asMap;
			for (String asName: asList){
				Alias alias=asMap.get(asName);
				alias.setData(null);
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
		ControlData.currDay=TimeOperation.numberOfDays(ControlData.currMonth, ControlData.currYear);
	}

	public void currTimeAddOneDay(){
		Date currDate = new Date (ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay);
		long currTime=currDate.getTime()+1 * 24 * 60 * 60 * 1000;
		currDate = new Date (currTime);
		ControlData.currMonth=currDate.getMonth()+1;
		ControlData.currYear=currDate.getYear()+1900;
		ControlData.currDay=currDate.getDate();
	}
	
	public static void main(String[] args){
		new Controller(args);
	}

	public void runModelILP(StudyDataSet sds){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		new initialXASolver();
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		ControlData.currTimeStep=0;
		while (ControlData.currTimeStep<ControlData.totalTimeStep && noError){
			if (ControlData.solverName.equalsIgnoreCase("XALOG")) new initialXALog();
			clearValues(modelList, modelDataSetMap);
			int i=0;
			while (i<modelList.size()  && noError){  
				ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
				boolean condition=false;
				try{
					modelCondition.evaluator();
					condition=modelCondition.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Model condition evaluation has error.");
					condition=false;
				}
				modelCondition.reset();
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				
				if (condition){
					ControlData.currSvMap=mds.svMap;
					ControlData.currDvMap=mds.dvMap;
					ControlData.currAliasMap=mds.asMap;
					ControlData.currGoalMap=mds.gMap;
					ControlData.currTsMap=mds.tsMap;
					ControlData.isPostProcessing=false;
					mds.processModel();
					IntermediateLP.setIlpFile(FilePaths.ilpFileDirectory);
					Set<String> usedDvar=IntermediateLP.output();
				
					if (Error.error_evaluation.size()>=1){
						Error.writeEvaluationErrorFile("evaluation_error.txt");
						noError=false;
					}
					new XASolver();
					IntermediateLP.writeObjValue();
					IntermediateLP.writeDvarValue(usedDvar);
					IntermediateLP.closeIlpFile();
					System.out.println("Solving Done.");
					if (Error.error_solving.size()<1){
						ControlData.isPostProcessing=true;
						mds.processAlias();
						System.out.println("Assign Alias Done.");
					}else{
						Error.writeSolvingErrorFile("solving_error.txt");
						noError=false;
					}
					System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
					//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==2) new RCCComparison();
				}else{
					new AssignPastCycleVariable();
				}
				i=i+1;
			}
			if (ControlData.timeStep.equals("1MON")){
				currTimeAddOneMonth();
			}else{
				currTimeAddOneDay();
			}
			ControlData.currTimeStep=ControlData.currTimeStep+1;
		}
		ControlData.xasolver.close();
		DssOperation.writeInitDvarAliasToDSS();
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
}