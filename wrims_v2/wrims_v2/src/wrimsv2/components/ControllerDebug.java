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
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.debug.ReProcessExternal;
import wrimsv2.evaluator.AssignPastCycleVariable;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSet;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.evaluator.Evaluation;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.PreEvaluator;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.evaluator.ValueEvaluation;
import wrimsv2.evaluator.ValueEvaluatorLexer;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.external.LoadAllDll;
import wrimsv2.ilp.ILP;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.solver.XASolver;
import wrimsv2.solver.SetXALog;
import wrimsv2.solver.InitialXASolver;
import wrimsv2.solver.Gurobi.GurobiSolver;
import wrimsv2.tools.RCCComparison;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.procedures.ErrorCheck;
import lpsolve.*;

public class ControllerDebug extends Thread {
	private DebugInterface di;
	public int debugYear;
	public int debugMonth;
	public int debugDay;
	public int debugCycle;
	public String[] args;
	public int modelIndex;
	public static ArrayList<Integer> initialTimeStep;
		
	public ControllerDebug(String[] args, DebugInterface di) {
		this.di=di;
		this.args=args;
	}
	
	@Override
	public void run() {
		setControlData(args);
		generateStudyFile();
		try {
			StudyDataSet sds = parse();
			di.sendEvent("totalcycle#"+sds.getModelList().size());
			if (StudyParser.total_errors==0){
				new PreEvaluator(sds);
				runModel(sds);
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		di.isDebugging=false;
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
	}
	
	public void generateStudyFile(){
		String outPath=new File(".").getAbsolutePath()+"\\jre6\\bin\\study.sty";
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
		
		new InitialXASolver();
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			if (ControlData.solverName.equalsIgnoreCase("XALOG")) SetXALog.enableXALog();
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			modelIndex=0;
			prepareInitialTimeStep();
			while (modelIndex<modelList.size()  && noError){  
				
				String model=modelList.get(modelIndex);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=modelIndex;
				ControlData.currTimeStep.set(modelIndex, initialTimeStep.get(modelIndex));
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(modelIndex);
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
							Error.writeEvaluationErrorFile("Error_evaluation.txt");
							noError=false;
						}
						new XASolver();
						
						// check monitored dvar list. they are slack and surplus generated automatically 
						// from the weight group deviation penalty
						// give error if they are not zero or greater than a small tolerance.
						noError = !ErrorCheck.checkDeviationSlackSurplus(mds.deviationSlackSurplus_toleranceMap, mds.dvMap);
						
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("Error_solving.txt");
							Error.writeErrorLog();
							noError=false;
						}
						System.out.println("Cycle "+(modelIndex+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
						pauseForDebug(modelIndex);
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
				modelIndex=modelIndex+1;
			}
			updateVarMonitor();
			if (di.resimDate){
				di.resimDate=false;
				noError=true;
				sds=ControlData.currStudyDataSet;
				modelList=sds.getModelList();
				modelDataSetMap=sds.getModelDataSetMap();		
				modelConditionParsers=sds.getModelConditionParsers();
				new ReProcessExternal(sds);
				resetStartDate(sds);
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
	
	public void runModelGurobi(StudyDataSet sds){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		
		ILP.initializeIlp();
		GurobiSolver.initialize();
		
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			modelIndex=0;
			prepareInitialTimeStep();
			while (modelIndex<modelList.size()  && noError){   
				
				String model=modelList.get(modelIndex);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=modelIndex;
				ControlData.currTimeStep.set(modelIndex, initialTimeStep.get(modelIndex));
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(modelIndex);
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
							Error.writeEvaluationErrorFile("Error_evaluation.txt");
							Error.addSolvingError("evaluation error(s)");
							Error.writeErrorLog();
							noError=false;
						} else {	
							ILP.setIlpFile();
							ILP.writeIlp();
							if (ILP.loggingVariableValue) {
								ILP.setVarFile();
								ILP.writeSvarValue();
							}
							GurobiSolver.setLp(ILP.cplexLpFilePath);
							GurobiSolver.solve();
						}

						// check monitored dvar list. they are slack and surplus generated automatically 
						// from the weight group deviation penalty
						// give error if they are not zero or greater than a small tolerance.
						noError = !ErrorCheck.checkDeviationSlackSurplus(mds.deviationSlackSurplus_toleranceMap, mds.dvMap);
						
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							
		            		ILP.writeObjValue_Gurobi();
		            		if (ILP.loggingVariableValue) ILP.writeDvarValue_Gurobi();
		            		
		            		ILP.closeIlpFile();
		            		
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("Error_solving.txt");
							Error.writeErrorLog();
							noError=false;
						}
						System.out.println("Cycle "+(modelIndex+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
						pauseForDebug(modelIndex);
						if (Error.error_evaluation.size()>=1) noError=false;

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
				modelIndex=modelIndex+1;
			}
			updateVarMonitor();
			if (di.resimDate){
				di.resimDate=false;
				noError=true;
				sds=ControlData.currStudyDataSet;
				modelList=sds.getModelList();
				modelDataSetMap=sds.getModelDataSetMap();		
				modelConditionParsers=sds.getModelConditionParsers();
				new ReProcessExternal(sds);
				resetStartDate(sds);
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
		}
		GurobiSolver.dispose();
		if (ControlData.writeInitToDVOutput){
			DssOperation.writeInitDvarAliasToDSS();
		}
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
	
	public void prepareInitialTimeStep(){
		initialTimeStep=new ArrayList<Integer>();
		for (Integer timeStep: ControlData.currTimeStep){
			initialTimeStep.add(timeStep.intValue());
		}
	}
	
	public void resetStartDate(StudyDataSet sds){
		int diffTimeStep;
		VariableTimeStep.procCycleTimeStep(sds);
		for(int i=0; i<initialTimeStep.size(); i++){
			String timeStep=sds.getModelTimeStepList().get(i);
			if (timeStep.equals("1MON")){
				diffTimeStep=(ControlData.cycleStartYear-di.resimYear)*12+(ControlData.cycleStartMonth-di.resimMonth);
			}else{
				Date startDate = new Date (di.resimYear-1900, di.resimMonth-1, di.resimDay);
				Date endDate=new Date (ControlData.cycleStartYear-1900, ControlData.cycleStartMonth-1, ControlData.cycleStartDay);
				long startTime=startDate.getTime();
				long endTime=endDate.getTime();
				diffTimeStep=(int)((endTime-startTime)/(24*60*60*1000l));
			}
			ControlData.currTimeStep.set(i, initialTimeStep.get(i)-diffTimeStep);
		}
		ControlData.cycleEndYear=di.resimYear;
		ControlData.cycleEndMonth=di.resimMonth;
		ControlData.cycleEndDay=di.resimDay;
	}
	
	public void pauseForDebug(int i){
		if (ControlData.timeStep.equals("1MON")){
			if (ControlData.currYear==debugYear && ControlData.currMonth==debugMonth && i==debugCycle-1){
				try {
					di.sendEvent("suspended!"+debugYear+"#"+debugMonth+"#"+debugDay+"#"+debugCycle);
					System.out.println("paused");
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.suspend();
			}
		}else{
			if (ControlData.currYear==debugYear && ControlData.currMonth==debugMonth && ControlData.currDay==debugDay && i==debugCycle-1){
				try {
					di.sendEvent("suspended!"+debugYear+"#"+debugMonth+"#"+debugDay+"#"+debugCycle);
					System.out.println("paused");
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.suspend();
			}
		}
		if (Error.getTotalError()>0){
			try {
				di.sendEvent("suspended!"+ControlData.currYear+"#"+ControlData.currMonth+"#"+ControlData.currDay+"#"+ControlData.currCycleIndex+1);
				System.out.println("error! paused");
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.suspend();
		}
	}
	
	public void updateVarMonitor(){
		String dataString="updateVarMonitor!";
		for (int k=0; k<di.monitorVarNames.length; k++){
			String monitorVarName=di.monitorVarNames[k];
			dataString=dataString+monitorVarName+"$";
			String monitorVarTimeStep=di.monitorVarTimeStep;
			String entryName=DssOperation.entryNameTS(monitorVarName, monitorVarTimeStep);
			HashMap<String, DssDataSetFixLength> dvAliasTSMap = DataTimeSeries.dvAliasTS;
		
			if (dvAliasTSMap.containsKey(entryName)){
				DssDataSetFixLength ddsf = dvAliasTSMap.get(entryName);
				double[] dataArray = ddsf.getData();
				TimeOperation.findTime(-1);
				int currIndex=ValueEvaluation.timeSeriesIndex(ddsf)-1;
				for (int i=0; i<=currIndex; i++){
					double value=dataArray[i];
					if (!(value==-901.0 || value==-902.0)){
						int timestepListed=i-currIndex;
						TimeOperation.findTime(timestepListed);
						dataString=dataString+timestepListed+":"+ControlData.dataMonth+"-"+ControlData.dataDay+"-"+ControlData.dataYear+":"+di.df.format(value)+"#";
					}
				}
			}else{
				HashMap<String, DssDataSet> svTSMap = DataTimeSeries.svTS;
				if (svTSMap.containsKey(entryName)){
					DssDataSet dds = svTSMap.get(entryName);
					ArrayList<Double> dataArrayList = dds.getData();
					TimeOperation.findTime(-1);
					int currIndex=ValueEvaluation.timeSeriesIndex(dds);
					for (int i=0; i<=currIndex; i++){
						double value=dataArrayList.get(i);
						if (!(value==-901.0 || value==-902.0)){
							int timestepListed=i-currIndex;
							TimeOperation.findTime(timestepListed);
							dataString=dataString+timestepListed+":"+ControlData.dataMonth+"-"+ControlData.dataDay+"-"+ControlData.dataYear+":"+di.df.format(value)+"#";
						}
					}
				}
			}
			dataString=dataString+"!";
		}
		if (dataString.endsWith("!")) dataString=dataString.substring(0, dataString.length()-1);
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		try {
			di.sendEvent(dataString);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void runModelILP(StudyDataSet sds){
		
		ILP.initializeIlp();
		
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		if (ControlData.solverName.equalsIgnoreCase("lpsolve")) {
			ControlData.solverType = Param.SOLVER_LPSOLVE;
			// initiate lpsolve
		} else if (ControlData.solverName.toLowerCase().contains("xa")) {
			ControlData.solverType = Param.SOLVER_XA; //default
			new InitialXASolver();
		} else {
			Error.addConfigError("Solver name not recognized: "+ControlData.solverName);
			Error.writeErrorLog();
		}
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			if (ControlData.solverType == Param.SOLVER_XA && ControlData.solverName.toLowerCase().contains("xalog")) SetXALog.enableXALog();
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			modelIndex=0;
			prepareInitialTimeStep();
			while (modelIndex<modelList.size()  && noError){  
				
				String model=modelList.get(modelIndex);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=modelIndex;
				ControlData.currTimeStep.set(modelIndex, initialTimeStep.get(modelIndex));
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(modelIndex);
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
					
						if (ILP.logging) {
							ILP.setIlpFile();
							ILP.writeIlp();
							if (ILP.loggingVariableValue) {
								ILP.setVarFile();
								ILP.writeSvarValue();
							}
						}
					
						if (Error.error_evaluation.size()>=1){
							Error.writeEvaluationErrorFile("Error_evaluation.txt");
							Error.writeErrorLog();
							noError=false;
						}
					
						// choose solver to solve. TODO: this is not efficient. need to be done outside ILP
				        if (ControlData.solverType == Param.SOLVER_LPSOLVE.intValue()) {
				            LPSolveSolver.setLP(ILP.lpSolveFilePath);
				            LPSolveSolver.solve();
				            if (Error.error_solving.size()<1) {
				            	if (ILP.logging) {
				            		ILP.writeObjValue_LPSOLVE();
				            		if (ILP.loggingVariableValue) ILP.writeDvarValue_LPSOLVE();
				            	}
				            }
				        } else {

							new XASolver(); 						

							if (ILP.logging) {
								ILP.writeObjValue_XA();
								if (ILP.loggingVariableValue) ILP.writeDvarValue_XA();
							}
				        }



						ILP.closeIlpFile();

						// check monitored dvar list. they are slack and surplus generated automatically 
						// from the weight group deviation penalty
						// give error if they are not zero or greater than a small tolerance.
						noError = !ErrorCheck.checkDeviationSlackSurplus(mds.deviationSlackSurplus_toleranceMap, mds.dvMap);
						
						
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("Error_solving.txt");
							Error.writeErrorLog();
							noError=false;
						}
						System.out.println("Cycle "+(modelIndex+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done.");
						pauseForDebug(modelIndex);
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
				modelIndex=modelIndex+1;
			}
			updateVarMonitor();
			if (di.resimDate){
				di.resimDate=false;
				noError=true;
				sds=ControlData.currStudyDataSet;
				modelList=sds.getModelList();
				modelDataSetMap=sds.getModelDataSetMap();		
				modelConditionParsers=sds.getModelConditionParsers();
				new ReProcessExternal(sds);
				resetStartDate(sds);
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
		}
		if (ControlData.solverType == Param.SOLVER_LPSOLVE) {
			//ControlData.lpssolver.deleteLp();
		} else {
			ControlData.xasolver.close();
		}
		if (ControlData.writeInitToDVOutput){
		DssOperation.writeInitDvarAliasToDSS();
		}
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
}