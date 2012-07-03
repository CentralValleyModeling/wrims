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
import wrimsv2.ilp.ILP;
import wrimsv2.solver.GurobiSolver;
import wrimsv2.solver.XASolver;
import wrimsv2.solver.initialXALog;
import wrimsv2.solver.initialXASolver;
import wrimsv2.tools.RCCComparison;
import wrimsv2.wreslparser.elements.StudyUtils;

public class ControllerSG {
	
	public ControllerSG() {
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
	
	public ControllerSG(String[] args) {
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
		System.exit(0);
	}
	
	public void setControlData(){
		FilePaths.groundwaterDir="D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\common\\CVGroundwater\\Data\\";
		FilePaths.setMainFilePaths("D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\CONV\\Run\\mainCONV_30.wresl");
		FilePaths.setSvarDssPaths("D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\common\\DSS\\CalSim30_06_SV.dss");
        FilePaths.setInitDssPaths("D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\common\\DSS\\CalSim30_06Init.dss");   
        FilePaths.setDvarDssPaths("D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\CONV\\DSS\\TestWRIMSV2DV.dss");
		ControlData cd=new ControlData();
		cd.svDvPartF="CALSIM30_06";
		cd.initPartF="CALSIM30_06";
		cd.partA = "CALSIM";
		cd.defaultTimeStep="1MON";
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
		cd.defaultTimeStep = args[8];
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

	}
	
	public void generateStudyFile(){
		String outPath="study.sty";
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
			out.write(ControlData.defaultTimeStep+"\n");
			out.write(VariableTimeStep.getTotalTimeStep(ControlData.defaultTimeStep)+"\n");
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
		return StudyUtils.checkStudy(FilePaths.fullMainPath);
	}
	
	public void runModel(StudyDataSet sds){
		System.out.println("=============Prepare Run Study===========");
		new PreRunModel(sds);
		System.out.println("==============Run Study Start============");
		if (ControlData.solverName.equalsIgnoreCase("XA") || ControlData.solverName.equalsIgnoreCase("XALOG") ){
			runModelXA(sds);
		}else if (ControlData.solverName.equalsIgnoreCase("Gurobi")){
			runModelGurobi(sds);
		}else if (ControlData.solverName.toLowerCase().contains("ilp")){
			runModelILP(sds);
		}
		System.out.println("=================Run ends!================");
	}
	
	public void runModelXA(StudyDataSet sds){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		new initialXASolver();
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			if (ControlData.solverName.equalsIgnoreCase("XALOG")) new initialXALog();
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			int i=0;
			while (i<modelList.size()  && noError){  
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);

				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
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
				
					if (condition){
						ClearValue.clearCycleLoopValue(modelList, modelDataSetMap);
						ControlData.currSvMap=mds.svMap;
						ControlData.currSvFutMap=mds.svFutMap;
						ControlData.currDvMap=mds.dvMap;
						ControlData.currDvSlackSurplusMap=mds.dvSlackSurplusMap;
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
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("solving_error.txt");
							noError=false;
						}
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
						if (Error.error_evaluation.size()>=1) noError=false;
						//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==2) new RCCComparison();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						new AssignPastCycleVariable();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}	
				}
				i=i+1;
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
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
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			int i=0;
			while (i<modelList.size()  && noError){   
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);

				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
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
				
					if (condition){
						ClearValue.clearCycleLoopValue(modelList, modelDataSetMap);
						ControlData.currSvMap=mds.svMap;
						ControlData.currSvFutMap=mds.svFutMap;
						ControlData.currDvMap=mds.dvMap;
						ControlData.currDvSlackSurplusMap=mds.dvSlackSurplusMap;
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
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("solving_error.txt");
							noError=false;
						}
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
						if (Error.error_evaluation.size()>=1) noError=false;
						//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==1) new RCCComparison();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						new AssignPastCycleVariable();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}
				}
				i=i+1;
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
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
	
	public static void main(String[] args){
		new ControllerSG(args);
	}

	public void runModelILP(StudyDataSet sds){
		
		ILP.initializeIlp();
		
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		new initialXASolver();
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			if (ControlData.solverName.toLowerCase().contains("xalog")) new initialXALog();
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			int i=0;
			while (i<modelList.size()  && noError){  
			
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);

				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
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
				
					if (condition){
						ClearValue.clearCycleLoopValue(modelList, modelDataSetMap);
						ControlData.currSvMap=mds.svMap;
						ControlData.currSvFutMap=mds.svFutMap;
						ControlData.currDvMap=mds.dvMap;
						ControlData.currDvSlackSurplusMap=mds.dvSlackSurplusMap;
						ControlData.currAliasMap=mds.asMap;
						ControlData.currGoalMap=mds.gMap;
						ControlData.currTsMap=mds.tsMap;
						ControlData.isPostProcessing=false;
						mds.processModel();
					
						ILP.setIlpFile();
						ILP.writeIlp();
						ILP.writeSvarValue();
					
						if (Error.error_evaluation.size()>=1){
							Error.writeEvaluationErrorFile("evaluation_error.txt");
							noError=false;
						}
						new XASolver();

						ILP.writeObjValue_XA();
						ILP.writeDvarValue_XA();
						ILP.closeIlpFile();

						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("solving_error.txt");
							noError=false;
						}
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
						if (Error.error_evaluation.size()>=1) noError=false;
						//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==2) new RCCComparison();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						new AssignPastCycleVariable();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}
				}
				i=i+1;
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
		}
		ControlData.xasolver.close();
		if (ControlData.writeInitToDVOutput){
		DssOperation.writeInitDvarAliasToDSS();
		}
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
}