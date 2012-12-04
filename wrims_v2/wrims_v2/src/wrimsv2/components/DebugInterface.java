package wrimsv2.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;

import com.google.common.primitives.Doubles;
import com.sun.java.util.collections.Arrays;

import vista.db.dss.DSSData;
import vista.db.dss.DSSDataWriter;
import vista.db.dss.DSSUtil;
import vista.time.TimeFactory;
import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.debug.ChangeSolver;
import wrimsv2.debug.ReLoadSVDss;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSet;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.evaluator.LookUpTable;
import wrimsv2.evaluator.PreEvaluator;
import wrimsv2.evaluator.TableSeries;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.evaluator.ValueEvaluation;
import wrimsv2.ilp.ILP;
import wrimsv2.solver.CloseCurrentSolver;
import wrimsv2.solver.InitialXASolver;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.solver.SetXALog;
import wrimsv2.wreslparser.elements.FileParser;
import wrimsv2.wreslparser.elements.SimulationDataSet;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;
import wrimsv2.wreslplus.elements.GoalTemp;
import wrimsv2.wreslplus.elements.ModelTemp;
import wrimsv2.wreslplus.elements.ParserUtils;
import wrimsv2.wreslplus.elements.StudyTemp;

public class DebugInterface {
	private ServerSocket requestSocket;
	private Socket requestConnection;
	private ServerSocket eventSocket;
	private Socket eventConnection;
	private PrintWriter requestOut;
	private BufferedReader requestIn;
	private PrintWriter eventOut;
	private BufferedReader eventIn;
	public ArrayList<String> breakIndex=new ArrayList<String>();
	public ArrayList<String> breakFile=new ArrayList<String>();
	public boolean isDebugging=true;
	private ControllerDebug controllerDebug;
	private FileWriter statusFile;
	public PrintWriter fileOut;
	private boolean isStart=false;
	private String[] debugSvar;
	private String[] debugDvar;
	private String[] debugAlias;
	private String[] allDebugVariables;
	public DecimalFormat df = new DecimalFormat("#.####");
	public static String[] monitorVarNames=new String[0];
	public static String monitorVarTimeStep="";
	public boolean resimDate=false;
	public int resimYear;
	public int resimMonth;
	public int resimDay;
	
	public DebugInterface(int requestPort, int eventPort, String args[]){
		try{	
			statusFile = new FileWriter("DebugStatus.txt");
		}catch (IOException e){
			e.printStackTrace();
		}
		fileOut = new PrintWriter(statusFile);
		try {
			requestSocket = new ServerSocket(requestPort);
			eventSocket = new ServerSocket(eventPort);
			requestConnection=requestSocket.accept();
			eventConnection=eventSocket.accept();
			requestOut=new PrintWriter(requestConnection.getOutputStream());
			requestOut.flush();
			requestIn=new BufferedReader(new InputStreamReader(requestConnection.getInputStream()));
			eventOut=new PrintWriter(eventConnection.getOutputStream());
			eventOut.flush();
			eventIn=new BufferedReader(new InputStreamReader(eventConnection.getInputStream()));
			String message="";
			controllerDebug=new ControllerDebug(args, this);
			do {
				try{
					message=requestIn.readLine();
					handleRequest (message);
				}catch (Exception e){
					e.printStackTrace();
				}
			}while (isDebugging);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}		
		
		finally{
			try{
				fileOut.close();
				requestIn.close();
				requestOut.close();
				requestSocket.close();
				eventSocket.close();
				System.exit(0);
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}

	}
		
	public void handleRequest(String request) {
		String dataString="";
		String goalString="";
		if (request.equals("start")) {
			controllerDebug.start();
			isStart=true;
			try {
				sendRequest("started");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (request.equals("resume")) {
			controllerDebug.resume();
			try {
				sendRequest("resumed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.equals("data")){
			try {
				dataString=getDataString();
				sendRequest(dataString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("data:")){
			int index=request.indexOf(":");
			try {
				if (request.equals("data:")){
					sendRequest("");
				}else{
					String fileName=request.substring(index+1);
					if (StudyUtils.useWreslPlus){
						dataString=getVariableInOneFileWP(fileName);
					}else{
						dataString=getVariableInOneFile(fileName);
					}
					sendRequest(dataString);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("tsdetail:")){
			int index=request.indexOf(":");
			try {
				if (request.equals("tsdetail:")){
					sendRequest("");
				}else{
					String variableNames=request.substring(index+1);
					dataString=getTimeseriesDetail(variableNames);
					sendRequest(dataString);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("futdetail:")){
			int index=request.indexOf(":");
			try {
				if (request.equals("futdetail:")){
					sendRequest("");
				}else{
					String variableName=request.substring(index+1);
					dataString=getFutureValueDetail(variableName);
					sendRequest(dataString);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("cycledetail:")){
			int index=request.indexOf(":");
			try {
				if (request.equals("cycledetail:")){
					sendRequest("");
				}else{
					String variableName=request.substring(index+1);
					dataString=getCycleValueDetail(variableName);
					sendRequest(dataString);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("watch:")){
			int index=request.indexOf(":");
			try{
				if (request.equals("watch:")){
					sendRequest("");
				}else{
					String vGNameString=request.substring(index+1);
					dataString=getWatch(vGNameString);
					sendRequest(dataString);
				}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.equals("alldata")){
			try{
				dataString=getAllVariableString();
				sendRequest(dataString);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("goal:")){
			int index=request.indexOf(":");
			try {
				if (request.equals("goal:")){
					sendRequest("");
				}else{
					String fileName=request.substring(index+1);
					if (StudyUtils.useWreslPlus){
						goalString=getGoalInOneFileWP(fileName);
					}else{
						goalString=getGoalInOneFile(fileName);
					}
					sendRequest(goalString);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.equals("allgoals")){
			try{
				goalString=getAllGoalString();
				sendRequest(goalString);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.equals("allcontrolgoals")){
			try{
				String goalName=getAllControlGoalName();
				sendRequest(goalName);
			}catch (IOException e){
				e.printStackTrace();
			}
			
		}else if (request.startsWith("time")){
			String [] requestParts=request.split(":");
			String[] yearMonthDayCycle=requestParts[1].split("/");
			controllerDebug.debugYear=Integer.parseInt(yearMonthDayCycle[0]);
			controllerDebug.debugMonth=Integer.parseInt(yearMonthDayCycle[1]);
			controllerDebug.debugDay=Integer.parseInt(yearMonthDayCycle[2]);
			controllerDebug.debugCycle=Integer.parseInt(yearMonthDayCycle[3]);
			try {
				sendRequest("time defined");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("variables:")){
			String [] requestParts=request.split(":");
			allDebugVariables=requestParts[1].split("#");
			try {
				sendRequest("variables defined");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.equals("terminate")) {
			controllerDebug.stop();
			if (ControlData.solverName.equalsIgnoreCase("XA") || ControlData.solverName.equalsIgnoreCase("XALOG")) {
				ControlData.xasolver.close();
			}
			DssOperation.writeInitDvarAliasToDSS();
			DssOperation.writeDVAliasToDSS();
			ControlData.writer.closeDSSFile();
			System.out.println("terminated");
			try {
				sendRequest("terminated");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isDebugging=false;
		}else if (request.equals("suspend")) {
			controllerDebug.suspend();
			System.out.println("suspended");
			try {
				sendRequest("suspended");
				sendEvent("suspended");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.equals("pause")) {
			controllerDebug.debugYear=ControlData.currYear;
			controllerDebug.debugMonth=ControlData.currMonth;
			controllerDebug.debugDay=ControlData.currDay;
			controllerDebug.debugCycle=ControlData.currCycleIndex+1;
			try {
				sendRequest("paused");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("modify_timeseries:")){
			String[] requestParts=request.split(":");
			boolean isModified=modifyTimeSeries(requestParts);
			try {
				if (isModified){
					sendRequest("modified");
				}else{
					sendRequest("not_modified");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("modify_cycle:")){
			String[] requestParts=request.split(":");
			boolean isModified=modifyCycle(requestParts);
			try {
				if (isModified){
					sendRequest("modified");
				}else{
					sendRequest("not_modified");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("resim_cycle:")){
			String[] requestParts=request.split(":");
			Error.clear();
			if (requestParts[1].equals("loadsv")){
				new ReLoadSVDss(ControlData.currStudyDataSet);
			}
			if (requestParts[3].equals("loadtable")){
				TableSeries.tableSeries=new HashMap<String, LookUpTable> ();
			}
			controllerDebug.modelIndex=Integer.parseInt(requestParts[2])-2;
			controllerDebug.resume();
			try {
				sendRequest("resumed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("resim_date:")){
			String[] requestParts=request.split(":");
			Error.clear();
			resimDate=true;
			if (requestParts[1].equals("recompile")){
				StudyDataSet sds;
				try {
					sds = controllerDebug.parse();
					ControlData.currStudyDataSet=sds;
					sendEvent("totalcycle#"+sds.getModelList().size());
					if (StudyParser.total_errors==0){
						new PreEvaluator(sds);
					}
				} catch (RecognitionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (requestParts[2].equals("loadsv")){
				new ReLoadSVDss(ControlData.currStudyDataSet);
			}
			if (requestParts[6].equals("loadtable")){
				TableSeries.tableSeries=new HashMap<String, LookUpTable> ();
			}
			controllerDebug.modelIndex=ControlData.currStudyDataSet.getModelList().size()-1;
			resimYear=Integer.parseInt(requestParts[3]);
			resimMonth=Integer.parseInt(requestParts[4]);
			resimDay=Integer.parseInt(requestParts[5]);
			ControlData.currYear=ControlData.cycleEndYear;
			ControlData.currMonth=ControlData.cycleEndMonth;
			ControlData.currDay=ControlData.cycleEndDay;
			controllerDebug.resume();
			try {
				sendRequest("resumed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("solveroption:")){
			String[] requestParts=request.split(":");
			setSolverOptions(requestParts);
			try {
				sendRequest("solveroptionset");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("savesvdss:")){
			int index=request.indexOf(":");
			String fileName=request.substring(index+1);
			boolean saveSucceed=saveSvDss(fileName);
			try {
				if (saveSucceed) {
					sendRequest("svardsssaved");
				}else{
					sendRequest("dsssavefailed");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.startsWith("savedvdss:")){
			int index=request.indexOf(":");
			String fileName=request.substring(index+1);
			boolean saveSucceed=saveDvDss(fileName);
			try {
				if (saveSucceed) {
					sendRequest("dvardsssaved");
				}else{
					sendRequest("dsssavefailed");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendRequest(String request) throws IOException {
		synchronized (requestConnection){
			try{
				requestOut.println(request);
				requestOut.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}	
	
	public void sendEvent(String event) throws IOException {
		synchronized (eventConnection){
			try{
				eventOut.println(event);
				eventOut.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public String getVariableInOneFile(String fileFullPath){
		String dataString="";
		String modelName=ControlData.currStudyDataSet.getModelList().get(ControlData.currCycleIndex);
		ModelDataSet mds=ControlData.currStudyDataSet.getModelDataSetMap().get(modelName);
		Map<String, Timeseries> tsMap = mds.tsMap;
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, Svar> svMap = mds.svMap;
		Map<String, Svar> svFutMap = mds.svFutMap;
		Map<String, Alias> asMap = mds.asMap;
		Map<String, String> partsMap=new HashMap<String, String>(); 
		try {
			WreslTreeWalker walker = FileParser.parseOneFileForDebug(fileFullPath);
			if (walker==null) return dataString;
			SimulationDataSet fileDataSet = walker.thisFileDataSet;
			ArrayList<String> dvList = fileDataSet.dvList;
			ArrayList<String> svList = fileDataSet.svList;
			ArrayList<String> asList = fileDataSet.asList;
			ArrayList<String> tsList = fileDataSet.tsList;
			ArrayList<String> sortedList=fileDataSet.asList;
			asList.removeAll(dvList);
			sortedList.addAll(dvList);
			sortedList.addAll(svList);
			sortedList.addAll(tsList);
			
			ArrayList<String> gList = fileDataSet.gList;
			for (String gName:gList){
				Set<String> dependants = fileDataSet.gMap.get(gName).expressionDependants;
				Iterator<String> iterator = dependants.iterator();
				while (iterator.hasNext()){
					String varName=iterator.next();
					if (!sortedList.contains(varName)){
						sortedList.add(varName);
					}
				}
			}
			
			IntDouble intDouble;
			Collections.sort(sortedList);
			for (String variable: sortedList){
				if (svMap.containsKey(variable)){
					Svar sv = svMap.get(variable);
					intDouble=sv.getData();
					if (intDouble != null) {
						dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
						partsMap.put(variable, sv.kind+":"+ControlData.timeStep);
					}
				}else if (dvMap.containsKey(variable)){
					Dvar dv = dvMap.get(variable);
					intDouble=dv.getData();
					if (intDouble != null) {
						dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
						partsMap.put(variable, dv.kind+":"+ControlData.timeStep);
					}
				}else if (tsMap.containsKey(variable)){
					Timeseries ts = tsMap.get(variable);
					intDouble=ts.getData();
					if (intDouble != null) {
						dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
						partsMap.put(variable, ts.kind+":"+ControlData.timeStep);
					}
				}else if (asMap.containsKey(variable)){
					Alias as = asMap.get(variable);
					intDouble=as.getData();
					if (intDouble != null) {
						dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
						partsMap.put(variable, as.kind+":"+ControlData.timeStep);
					}
				}
			}
			if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
			dataString=dataString+"!";
			for (String variable: partsMap.keySet()){
				dataString=dataString+variable+":"+partsMap.get(variable)+"#";
			}
			if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataString;
	}
	
	public String getVariableInOneFileWP(String fileFullPath){
		String dataString="";
		StudyDataSet sds = ControlData.currStudyDataSet;
		String modelName=sds.getModelList().get(ControlData.currCycleIndex);
		ModelDataSet mds=sds.getModelDataSetMap().get(modelName);
		Map<String, Svar> parameterMap = sds.getParameterMap();
		Map<String, Timeseries> tsMap = mds.tsMap;
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, Svar> svMap = mds.svMap;
		Map<String, Svar> svFutMap = mds.svFutMap;
		Map<String, Alias> asMap = mds.asMap;
		Map<String, String> partsMap=new HashMap<String, String>();
		ArrayList<String> parameterList = new ArrayList<String>();
		if (fileFullPath.equalsIgnoreCase(FilePaths.fullMainPath)){
			StudyTemp studyTemp = ParserUtils.parseWreslMain(fileFullPath);
			if (studyTemp==null) return dataString;
			parameterList = studyTemp.parameterList;
		}
		ModelTemp modelTemp = ParserUtils.parseWreslFile(fileFullPath);
		if (modelTemp==null) return dataString;
		ArrayList<String> dvList = modelTemp.dvList;
		ArrayList<String> svList = modelTemp.svList;
		ArrayList<String> asList = modelTemp.asList;
		ArrayList<String> tsList = modelTemp.tsList;
		ArrayList<String> gList = modelTemp.glList;
		Map<String, GoalTemp> glMap = modelTemp.glMap;
		ArrayList<String> sortedList = modelTemp.asList;
		
		asList.removeAll(dvList);
		sortedList.addAll(dvList);
		sortedList.addAll(parameterList);
		sortedList.addAll(svList);
		sortedList.addAll(tsList);

		for (String gName:gList){
			Set<String> dependants = glMap.get(gName).dependants;
			Iterator<String> iterator = dependants.iterator();
			while (iterator.hasNext()){
				String varName=iterator.next();
				if (!sortedList.contains(varName)){
					sortedList.add(varName);
				}
			}
		}
		IntDouble intDouble;
		Collections.sort(sortedList);
		for (String variable: sortedList){
			if (svMap.containsKey(variable)){
				Svar sv = svMap.get(variable);
				intDouble=sv.getData();
				if (intDouble != null) {
					dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
					partsMap.put(variable, sv.kind+":"+ControlData.timeStep);
				}
			}else if (dvMap.containsKey(variable)){
				Dvar dv = dvMap.get(variable);
				intDouble=dv.getData();
				if (intDouble != null) {
					dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
					partsMap.put(variable, dv.kind+":"+ControlData.timeStep);
				}
			}else if (tsMap.containsKey(variable)){
				Timeseries ts = tsMap.get(variable);
				intDouble=ts.getData();
				if (intDouble != null) {
					dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
					partsMap.put(variable, ts.kind+":"+ControlData.timeStep);
				}
			}else if (asMap.containsKey(variable)){
				Alias as = asMap.get(variable);
				intDouble=as.getData();
				if (intDouble != null) {
					dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
					partsMap.put(variable, as.kind+":"+ControlData.timeStep);
				}
			}else if (parameterMap.containsKey(variable)){
				Svar sv = parameterMap.get(variable);
				intDouble=sv.getData();
				if (intDouble != null){
					dataString=dataString+variable+":"+df.format(intDouble.getData())+"#";
					//partsMap.put(variable, sv.kind+":"+ControlData.timeStep);
				}
			}
		}
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		dataString=dataString+"!";
		for (String variable: partsMap.keySet()){
			dataString=dataString+variable+":"+partsMap.get(variable)+"#";
		}
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		
		return dataString;
	}
	
	public String getGoalInOneFile(String fileFullPath){
		String goalString="";
		Map<String, EvalConstraint> gMap = SolverData.getConstraintDataMap();
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		ArrayList<String> controlGoals=new ArrayList<String>();
		
		try {
			WreslTreeWalker walker = FileParser.parseOneFileForDebug(fileFullPath);
			if (walker==null) return goalString;
			SimulationDataSet fileDataSet = walker.thisFileDataSet;	
			ArrayList<String> sortedGoalList = fileDataSet.gList;
			
			Collections.sort(sortedGoalList);
			for (int i=0; i<sortedGoalList.size(); i++){
				double lhs=0;
				String goalName=sortedGoalList.get(i);
				if (gMap.containsKey(goalName)){
					goalString=goalString+goalName+":";
					EvalConstraint ec=gMap.get(goalName);
					if (ec!=null){
						EvalExpression ee=ec.getEvalExpression();
						Map<String, IntDouble> multiplier = ee.getMultiplier();
						Set<String> mKeySet = multiplier.keySet();
						Iterator<String> mi = mKeySet.iterator();
						boolean hasData = true;
						while (mi.hasNext()){
							String variable=mi.next();
							Number value=multiplier.get(variable).getData();
							double value1=value.doubleValue();
							if (goalString.endsWith(":")){
								if (value1==1.0){
									goalString=goalString+variable;
								}else if (value1==-1.0){
									goalString=goalString+"-"+variable;
								}else{
									goalString=goalString+df.format(value)+variable;
								}
							}else{
								if (value1==1.0){
									goalString=goalString+"+"+variable;
								}else if (value1 == -1.0){
									goalString=goalString+"-"+variable;
								}else if(value1>=0){
									goalString=goalString+"+"+df.format(value)+variable;
								}else{
									goalString=goalString+df.format(value)+variable;
								}
							}
							if (!(variable.startsWith("surplus__") || variable.startsWith("slack__"))){
								IntDouble id = dvMap.get(variable).getData();
								if (id==null){
									hasData=false;
								}else{
									double variableValue=id.getData().doubleValue();
									lhs=lhs+value1*variableValue;
								}
							}
						}
						Number value=ee.getValue().getData();
						double value1=value.doubleValue();
						if (value1>0){
							goalString=goalString+"+"+df.format(value)+ec.getSign()+"0#";
						}else if(value1<0){
							goalString=goalString+df.format(value)+ec.getSign()+"0#";
						}else{
							goalString=goalString+ec.getSign()+"0#";
						}
						lhs=lhs+value1;
						if (Math.abs(lhs)<=0.00001 && hasData){
							controlGoals.add(goalName);
						}
					}
				}
			}
			if (goalString.endsWith("#")) goalString=goalString.substring(0, goalString.length()-1);
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goalString=goalString+"!";
		for (String controlGoal:controlGoals){
			goalString=goalString+controlGoal+":";
		}
		if (goalString.endsWith(":")) goalString=goalString.substring(0, goalString.length()-1);
		return goalString;
	}
	
	public String getGoalInOneFileWP(String fileFullPath){
		String goalString="";
		Map<String, EvalConstraint> gMap = SolverData.getConstraintDataMap();
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		ArrayList<String> controlGoals=new ArrayList<String>();
		
		ModelTemp modelTemp = ParserUtils.parseWreslFile(fileFullPath);
		if (modelTemp==null) return goalString;	
		ArrayList<String> sortedGoalList = modelTemp.glList;
		
		Collections.sort(sortedGoalList);
		for (int i=0; i<sortedGoalList.size(); i++){
			double lhs=0;
			String goalName=sortedGoalList.get(i);
			if (gMap.containsKey(goalName)){
				goalString=goalString+goalName+":";
				EvalConstraint ec=gMap.get(goalName);
				if (ec!=null){
					EvalExpression ee=ec.getEvalExpression();
					Map<String, IntDouble> multiplier = ee.getMultiplier();
					Set<String> mKeySet = multiplier.keySet();
					Iterator<String> mi = mKeySet.iterator();
					boolean hasData = true;
					while (mi.hasNext()){
						String variable=mi.next();
						Number value=multiplier.get(variable).getData();
						double value1=value.doubleValue();
						if (goalString.endsWith(":")){
							if (value1==1.0){
								goalString=goalString+variable;
							}else if (value1==-1.0){
								goalString=goalString+"-"+variable;
							}else{
								goalString=goalString+df.format(value)+variable;
							}
						}else{
							if (value1==1.0){
								goalString=goalString+"+"+variable;
							}else if (value1 == -1.0){
								goalString=goalString+"-"+variable;
							}else if(value1>=0){
								goalString=goalString+"+"+df.format(value)+variable;
							}else{
								goalString=goalString+df.format(value)+variable;
							}
						}
						if (!(variable.startsWith("surplus__") || variable.startsWith("slack__"))){
							IntDouble id = dvMap.get(variable).getData();
							if (id==null){
								hasData=false;
							}else{
								double variableValue=id.getData().doubleValue();
								lhs=lhs+value1*variableValue;
							}
						}
					}
					Number value=ee.getValue().getData();
					double value1=value.doubleValue();
					if (value1>0){
						goalString=goalString+"+"+df.format(value)+ec.getSign()+"0#";
					}else if(value1<0){
						goalString=goalString+df.format(value)+ec.getSign()+"0#";
					}else{
						goalString=goalString+ec.getSign()+"0#";
					}
					lhs=lhs+value1;
					if (Math.abs(lhs)<=0.00001 && hasData){
						controlGoals.add(goalName);
					}
				}
			}
		}
		if (goalString.endsWith("#")) goalString=goalString.substring(0, goalString.length()-1);
		goalString=goalString+"!";
		for (String controlGoal:controlGoals){
			goalString=goalString+controlGoal+":";
		}
		if (goalString.endsWith(":")) goalString=goalString.substring(0, goalString.length()-1);
		return goalString;
	}
	
	public String getAllVariableString(){
		String dataString="";
		ArrayList<String> allDataNames=new ArrayList<String>();
		ArrayList<String> allTsNames=new ArrayList<String>();
		ArrayList<String> allDvNames=new ArrayList<String>();
		ArrayList<String> allSvNames=new ArrayList<String>();
		ArrayList<String> allAsNames=new ArrayList<String>();
		Map<String, Number> allData=new HashMap<String, Number>();
		String modelName=ControlData.currStudyDataSet.getModelList().get(ControlData.currCycleIndex);
		ModelDataSet mds=ControlData.currStudyDataSet.getModelDataSetMap().get(modelName);
		Map<String, Timeseries> tsMap = mds.tsMap;
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, Svar> svMap = mds.svMap;
		Map<String, Svar> svFutMap = mds.svFutMap;
		Map<String, Alias> asMap = mds.asMap;

		IntDouble intDouble;
		
		Set<String> tsKeySet = tsMap.keySet();
		Iterator<String> tsIterator = tsKeySet.iterator();
		while (tsIterator.hasNext()){
			String tsName=tsIterator.next();
			if (!allDataNames.contains(tsName)){
				intDouble=tsMap.get(tsName).getData();
				if (intDouble != null){
					allDataNames.add(tsName);
					allTsNames.add(tsName);
					allData.put(tsName, intDouble.getData());
				}
			}
		}
		
		Set<String> dvKeySet = dvMap.keySet();
		Iterator<String> dvIterator = dvKeySet.iterator();
		while (dvIterator.hasNext()){
			String dvName=dvIterator.next();
			if (!allDataNames.contains(dvName)){
				intDouble=dvMap.get(dvName).getData();
				if (intDouble !=null){
					allDataNames.add(dvName);
					allDvNames.add(dvName);
					allData.put(dvName, intDouble.getData());
				}
			}
		}
		
		Set<String> svKeySet = svMap.keySet();
		Iterator<String> svIterator = svKeySet.iterator();
		while (svIterator.hasNext()){
			String svName=svIterator.next();
			if (!allDataNames.contains(svName)){
				intDouble=svMap.get(svName).getData();
				if (intDouble!=null){
					allDataNames.add(svName);
					allSvNames.add(svName);
					allData.put(svName, intDouble.getData());
				}
			}
		}
		
		Set<String> svFutKeySet = svFutMap.keySet();
		Iterator<String> svFutIterator = svFutKeySet.iterator();
		while (svFutIterator.hasNext()){
			String svFutName=svFutIterator.next();
			if (!allDataNames.contains(svFutName)){
				intDouble=svFutMap.get(svFutName).getData();
				if (intDouble!=null){
					allDataNames.add(svFutName);
					allSvNames.add(svFutName);
					allData.put(svFutName, intDouble.getData());
				}
			}
		}
		
		Set<String> asKeySet = asMap.keySet();
		Iterator<String> asIterator = asKeySet.iterator();
		while (asIterator.hasNext()){
			String asName=asIterator.next();
			if (!allDataNames.contains(asName)){
				intDouble=asMap.get(asName).getData();
				if (intDouble!=null){
					allDataNames.add(asName);
					allData.put(asName, intDouble.getData());
				}
			}
			if (!allAsNames.contains(asName)){
				allAsNames.add(asName);
			}
		}
		
		Collections.sort(allDataNames);
		for (String variable: allDataNames){
			dataString=dataString+variable+":"+df.format(allData.get(variable))+"#";
		}
		
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		return dataString;
	}
	
	public String getAllGoalString(){
		String goalString="";
		Map<String, EvalConstraint> gMap = SolverData.getConstraintDataMap();
		Set<String> goalKeySet=gMap.keySet();
		ArrayList<String> gKeyArrayList=new ArrayList<String>();
		Iterator ki=goalKeySet.iterator();
		while (ki.hasNext()){
			gKeyArrayList.add((String) ki.next());
		}
		Collections.sort(gKeyArrayList);
		for (int i=0; i<gKeyArrayList.size(); i++){
			String goalName=gKeyArrayList.get(i);
			goalString=goalString+goalName+":";
			EvalConstraint ec=gMap.get(goalName);
			if (ec!=null){
				EvalExpression ee=ec.getEvalExpression();
				Map<String, IntDouble> multiplier = ee.getMultiplier();
				Set<String> mKeySet = multiplier.keySet();
				Iterator<String> mi = mKeySet.iterator();
				while (mi.hasNext()){
					String variable=mi.next();
					Number value=multiplier.get(variable).getData();
					double value1=value.doubleValue();
					if (goalString.endsWith(":")){
						if (value1==1.0){
							goalString=goalString+variable;
						}else if (value1==-1.0){
							goalString=goalString+"-"+variable;
						}else{
							goalString=goalString+df.format(value)+variable;
						}
					}else{
						if (value1==1.0){
							goalString=goalString+"+"+variable;
						}else if (value1 == -1.0){
							goalString=goalString+"-"+variable;
						}else if(value1>=0){
							goalString=goalString+"+"+df.format(value)+variable;
						}else{
							goalString=goalString+df.format(value)+variable;
						}
					}
				}
				Number value=ee.getValue().getData();
				double value1=value.doubleValue();
				if (value1>0){
					goalString=goalString+"+"+df.format(value)+ec.getSign()+"0#";
				}else if(value1<0){
					goalString=goalString+df.format(value)+ec.getSign()+"0#";
				}else{
					goalString=goalString+ec.getSign()+"0#";
				}
			}
		}
		if (goalString.endsWith("#")) goalString=goalString.substring(0, goalString.length()-1);
		return goalString;
	}
	
	public String getWatch(String vGNameString){
		String dataString="";
		String modelName=ControlData.currStudyDataSet.getModelList().get(ControlData.currCycleIndex);
		ModelDataSet mds=ControlData.currStudyDataSet.getModelDataSetMap().get(modelName);
		Map<String, Timeseries> tsMap = mds.tsMap;
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Map<String, Svar> svMap = mds.svMap;
		Map<String, Svar> svFutMap = mds.svFutMap;
		Map<String, Alias> asMap = mds.asMap;
		Map<String, EvalConstraint> gMap = SolverData.getConstraintDataMap();
		Map<String, String> partsMap=new HashMap<String, String>();
		
		String[] vGNames;
		if (vGNameString.contains("#")){
			vGNames=vGNameString.split("#");
		}else{
			vGNames=new String[1];
			vGNames[0]=vGNameString;
		}
		ArrayList<String> controlGoals=new ArrayList<String>();
		IntDouble intDouble;
		for (int i=0; i<vGNames.length; i++){
			String vGName=vGNames[i];
			if (svMap.containsKey(vGName)){
				Svar sv = svMap.get(vGName);
				intDouble=sv.getData();
				if (intDouble != null) {
					dataString=dataString+vGName+":"+df.format(intDouble.getData())+"#";
					partsMap.put(vGName, sv.kind+":"+ControlData.timeStep);
				}
			}else if (dvMap.containsKey(vGName)){
				Dvar dv = dvMap.get(vGName);
				intDouble=dv.getData();
				if (intDouble != null) {
					dataString=dataString+vGName+":"+df.format(intDouble.getData())+"#";
					partsMap.put(vGName, dv.kind+":"+ControlData.timeStep);
				}
			}else if (tsMap.containsKey(vGName)){
				Timeseries ts = tsMap.get(vGName);
				intDouble=ts.getData();
				if (intDouble != null) {
					dataString=dataString+vGName+":"+df.format(intDouble.getData())+"#";
					partsMap.put(vGName, ts.kind+":"+ControlData.timeStep);
				}
			}else if (asMap.containsKey(vGName)){
				Alias as = asMap.get(vGName);
				intDouble=as.getData();
				if (intDouble != null) {
					dataString=dataString+vGName+":"+df.format(intDouble.getData())+"#";
					partsMap.put(vGName, as.kind+":"+ControlData.timeStep);
				}
			}else if (gMap.containsKey(vGName)){
				double lhs=0;
				dataString=dataString+vGName+":";
				EvalConstraint ec=gMap.get(vGName);
				if (ec!=null){
					EvalExpression ee=ec.getEvalExpression();
					Map<String, IntDouble> multiplier = ee.getMultiplier();
					Set<String> mKeySet = multiplier.keySet();
					Iterator<String> mi = mKeySet.iterator();
					boolean hasData = true;
					while (mi.hasNext()){
						String variable=mi.next();
						Number value=multiplier.get(variable).getData();
						double value1=value.doubleValue();
						if (dataString.endsWith(":")){
							if (value1==1.0){
								dataString=dataString+variable;
							}else if (value1==-1.0){
								dataString=dataString+"-"+variable;
							}else{
								dataString=dataString+df.format(value)+variable;
							}
						}else{
							if (value1==1.0){
								dataString=dataString+"+"+variable;
							}else if (value1 == -1.0){
								dataString=dataString+"-"+variable;
							}else if(value1>=0){
								dataString=dataString+"+"+df.format(value)+variable;
							}else{
								dataString=dataString+df.format(value)+variable;
							}
						}
						if (!(variable.startsWith("surplus__") || variable.startsWith("slack__"))){
							IntDouble id = dvMap.get(variable).getData();
							if (id==null){
								hasData=false;
							}else{
								double variableValue=id.getData().doubleValue();
								lhs=lhs+value1*variableValue;
							}
						}
					}
					Number value=ee.getValue().getData();
					double value1=value.doubleValue();
					if (value1>0){
						dataString=dataString+"+"+df.format(value)+ec.getSign()+"0#";
					}else if(value1<0){
						dataString=dataString+df.format(value)+ec.getSign()+"0#";
					}else{
						dataString=dataString+ec.getSign()+"0#";
					}
					lhs=lhs+value1;
					if (Math.abs(lhs)<=0.00001 && hasData){
						controlGoals.add(vGName);
					}
				}
			}else{
				dataString=dataString+vGName+":"+"N/A#";
			}
		}
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		
		dataString=dataString+"!";
		for (String controlGoal:controlGoals){
			dataString=dataString+controlGoal+":";
		}
		if (dataString.endsWith(":")) dataString=dataString.substring(0, dataString.length()-1);
		
		dataString=dataString+"&";
		for (String variable: partsMap.keySet()){
			dataString=dataString+variable+":"+partsMap.get(variable)+"#";
		}
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		
		return dataString;
	}
	
	public String getAllControlGoalName(){
		String goalNames="";
		Map<String, EvalConstraint> gMap = SolverData.getConstraintDataMap();
		Map<String, Dvar> dvMap = SolverData.getDvarMap();
		Set<String> goalKeySet=gMap.keySet();
		Iterator ki=goalKeySet.iterator();
		while (ki.hasNext()){
			double lhs=0.0;
			String goalName=(String)ki.next();
			EvalConstraint ec=gMap.get(goalName);
			if (ec!=null){
				EvalExpression ee=ec.getEvalExpression();
				Map<String, IntDouble> multiplier = ee.getMultiplier();
				Set<String> mKeySet = multiplier.keySet();
				Iterator<String> mi = mKeySet.iterator();
				boolean hasData = true;
				while (mi.hasNext()){
					String variable=mi.next();
					double value1=multiplier.get(variable).getData().doubleValue();
					if (!(variable.startsWith("surplus__") || variable.startsWith("slack__"))){
						IntDouble id = dvMap.get(variable).getData();
						if (id ==null){
							hasData=false;
						}else{
							double variableValue=id.getData().doubleValue();
							lhs=lhs+variableValue*value1;
						}
					}
				}
				double value1=ee.getValue().getData().doubleValue();
				lhs=lhs+value1;
				if (Math.abs(lhs)<=0.00001 && hasData) goalNames=goalNames+goalName+":";
			}
		}
		if (goalNames.endsWith(":")) goalNames=goalNames.substring(0, goalNames.length()-1);
		return goalNames;
	}
	
	public String getTimeseriesDetail(String variableNames){
		monitorVarNames=variableNames.split("#");
		monitorVarTimeStep=ControlData.timeStep;
		controllerDebug.updateVarMonitor();
		
		String dataString="";
		String variableName=monitorVarNames[0];
		String entryName=DssOperation.entryNameTS(variableName, ControlData.timeStep);
		HashMap<String, DssDataSetFixLength> dvAliasTSMap = DataTimeSeries.dvAliasTS;

		if (dvAliasTSMap.containsKey(entryName)){
			DssDataSetFixLength ddsf = dvAliasTSMap.get(entryName);
			double[] dataArray = ddsf.getData();
			TimeOperation.findTime(0);
			int currIndex=ValueEvaluation.timeSeriesIndex(ddsf)-1;
			for (int i=0; i<=currIndex; i++){
				double value=dataArray[i];
				if (!(value==-901.0 || value==-902.0)){
					int timestepListed=i-currIndex;
					TimeOperation.findTime(timestepListed);
					dataString=dataString+timestepListed+":"+ControlData.dataMonth+"-"+ControlData.dataDay+"-"+ControlData.dataYear+":"+df.format(value)+"#";
				}
			}
		}else{
			HashMap<String, DssDataSet> svTSMap = DataTimeSeries.svTS;
			if (svTSMap.containsKey(entryName)){
				DssDataSet dds = svTSMap.get(entryName);
				ArrayList<Double> dataArrayList = dds.getData();
				TimeOperation.findTime(0);
				int currIndex=ValueEvaluation.timeSeriesIndex(dds);
				for (int i=0; i<dataArrayList.size(); i++){
					double value=dataArrayList.get(i);
					if (!(value==-901.0 || value==-902.0)){
						int timestepListed=i-currIndex;
						TimeOperation.findTime(timestepListed);
						dataString=dataString+timestepListed+":"+ControlData.dataMonth+"-"+ControlData.dataDay+"-"+ControlData.dataYear+":"+df.format(value)+"#";
					}
				}
			}
		}
		
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		return dataString;
	}
	
	public String getFutureValueDetail(String variableName){
		String dataString="";
		StudyDataSet sds = ControlData.currStudyDataSet;
		String cycleName = sds.getModelList().get(ControlData.currCycleIndex);
		ModelDataSet mds = sds.getModelDataSetMap().get(cycleName);
		ArrayList<Integer> indexList=new ArrayList<Integer>();
		Map<Integer, Number> futureArray= new HashMap<Integer, Number>();
		if (mds.svList.contains(variableName)){
			Map<String, Svar> svFutMap = mds.svFutMap;
			Set<String> keySet=svFutMap.keySet();
			for (String key:keySet){
				if (key.startsWith(variableName+"__fut__")){
					String[] splittedKey=key.split("__fut__");
					if (splittedKey.length>1){
						int index = Integer.parseInt(splittedKey[1]);
						IntDouble intDouble=svFutMap.get(key).getData();
						if (intDouble != null) {
							indexList.add(index);
							futureArray.put(index, intDouble.getData());
						}
					}
				}
			}
		}else if (mds.dvList.contains(variableName)){
			Map<String, Dvar> dvMap = SolverData.getDvarMap();
			Set<String> keySet=dvMap.keySet();
			for (String key:keySet){
				if (key.startsWith(variableName+"__fut__")){
					String[] splittedKey=key.split("__fut__");
					if (splittedKey.length>1){
						int index = Integer.parseInt(splittedKey[1]);
						IntDouble intDouble=dvMap.get(key).getData();
						if (intDouble != null){
							indexList.add(index);
							futureArray.put(index, intDouble.getData());
						}
					}
				}
			}
		}
		Collections.sort(indexList);
		for (int i=0; i<indexList.size(); i++){
			Integer index=indexList.get(i);
			TimeOperation.findTime(i);
			dataString=dataString+index+":"+ControlData.dataMonth+"-"+ControlData.dataDay+"-"+ControlData.dataYear+":"+df.format(futureArray.get(index))+"#";
		}
		
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		return dataString;
	}
	
	public String getCycleValueDetail(String variableName){
		String dataString="";
		StudyDataSet sds = ControlData.currStudyDataSet;
		ArrayList<String> ml = sds.getModelList();
		Map<String, Map<String, IntDouble>> varCycleValue = sds.getVarCycleValueMap();
		if (varCycleValue.containsKey(variableName)){
			Map<String, IntDouble> cycleValue = varCycleValue.get(variableName);
			int cycleIndex=1;
			for (String cycle: ml){
				if (cycleValue.containsKey(cycle) && cycleIndex<ControlData.currCycleIndex+1){
					IntDouble id=cycleValue.get(cycle);
					if (id!=null) dataString=dataString+cycleIndex+":"+cycle+":"+df.format(id.getData())+"#";
				}
				cycleIndex=cycleIndex+1;
			}
		}else{
			Map<String, Map<String, IntDouble>> varTimeArrayCycleValue = sds.getVarTimeArrayCycleValueMap();
			if (varTimeArrayCycleValue.containsKey(variableName)){
				Map<String, IntDouble> cycleValue = varTimeArrayCycleValue.get(variableName);
				int cycleIndex=1;
				for (String cycle: ml){
					if (cycleValue.containsKey(cycle) && cycleIndex<ControlData.currCycleIndex+1){
						IntDouble id=cycleValue.get(cycle);
						if (id!=null) dataString=dataString+cycleIndex+":"+cycle+":"+df.format(id.getData())+"#";
					}
					cycleIndex=cycleIndex+1;
				}
			}
		}
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		return dataString;
	}
	
	public boolean modifyTimeSeries(String[] requestParts){
		boolean isModified=false;
		String[] varStrings=requestParts[1].split("#");
		String varName=varStrings[0];
		int index=Integer.parseInt(varStrings[1]);
		double value=Double.parseDouble(varStrings[2]);
		String entryName=DssOperation.entryNameTS(varName, monitorVarTimeStep);
		HashMap<String, DssDataSetFixLength> dvAliasTSMap = DataTimeSeries.dvAliasTS;
		if (dvAliasTSMap.containsKey(entryName)){
			DssDataSetFixLength ddsf = dvAliasTSMap.get(entryName);
			double[] dataArray = ddsf.getData();
			TimeOperation.findTime(index);
			int tsIndex=ValueEvaluation.timeSeriesIndex(ddsf)-1;
			dataArray[tsIndex]=value;
			isModified=true;
		}else{
			HashMap<String, DssDataSet> svTSMap = DataTimeSeries.svTS;
			if (svTSMap.containsKey(entryName)){
				DssDataSet dds = svTSMap.get(entryName);
				ArrayList<Double> dataArrayList = dds.getData();
				TimeOperation.findTime(index);
				int tsIndex=ValueEvaluation.timeSeriesIndex(dds);
				dataArrayList.set(tsIndex, value);
				isModified=true;
			}
		}
		return isModified;
	}
	
	public boolean modifyCycle(String[] requestParts){
		boolean isModified=false;
		String[] varStrings=requestParts[1].split("#");
		String varName=varStrings[0];
		String cycle=varStrings[1];
		double value=Double.parseDouble(varStrings[2]);
		StudyDataSet sds = ControlData.currStudyDataSet;
		Map<String, Map<String, IntDouble>> varCycleValue = sds.getVarCycleValueMap();
		if (varCycleValue.containsKey(varName)){
			Map<String, IntDouble> cycleValue = varCycleValue.get(varName);
			if (cycleValue.containsKey(cycle)){
				cycleValue.put(cycle, new IntDouble(value, false));
				isModified=true;
			}
		}else{
			Map<String, Map<String, IntDouble>> varTimeArrayCycleValue = sds.getVarTimeArrayCycleValueMap();
			if (varTimeArrayCycleValue.containsKey(varName)){
				Map<String, IntDouble> cycleValue = varTimeArrayCycleValue.get(varName);
				cycleValue.put(cycle, new IntDouble(value, false));
				isModified=true;
			}
		}
		return isModified;
	}
	
	public String getDataString(){
		String dataString="";
		for (int i=0; i<allDebugVariables.length; i++){
			String variable=allDebugVariables[i];
			if (ControlData.currSvMap.containsKey(variable)){
				Number value=ControlData.currSvMap.get(variable).getData().getData();
				dataString=dataString+variable+":"+value+"#";
			}
			if (ControlData.currDvMap.containsKey(variable)){
				Number value=ControlData.currDvMap.get(variable).getData().getData();
				dataString=dataString+variable+":"+value+"#";
			}
			if (ControlData.currAliasMap.containsKey(variable)){
				Number value=ControlData.currAliasMap.get(variable).getData().getData();
				dataString=dataString+variable+":"+value+"#";
			}
		}
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		return dataString;
	}
	
	public void setSolverOptions(String[] requestParts){
		String solverName=requestParts[1];
		String log=requestParts[2];
		new CloseCurrentSolver(ControlData.solverName);
		System.out.println("Change solver to "+solverName);
		if (solverName.equals("XA")){
			new InitialXASolver();
			if (log.equals("None")){
				SetXALog.disableXALog();
				ILP.logging=false;
				ILP.loggingLpSolve=false;
				ILP.loggingCplexLp=false;
				ILP.loggingVariableValue=false;
				ControlData.solverName="XA";
				System.out.println("Log file turn off");
			}else if (log.equals("Log")){
				SetXALog.enableXALog();
				ILP.logging=true;
				ILP.loggingLpSolve=false;
				ILP.loggingCplexLp=true;
				ILP.loggingVariableValue=true;
				ControlData.solverName="XALOG";
				ILP.initializeIlp();
				System.out.println("Log file turn on");
			}
		}else if(solverName.equals("LPSolve")){
			ControlData.solverName="LPSolve";
			ILP.loggingLpSolve=true;
			ILP.loggingCplexLp=false;
			if (log.equals("None")){
				ILP.logging=false;
				ILP.loggingVariableValue=false;
				System.out.println("Log file turn off");
			}else if (log.equals("Log")){
				ILP.logging=true;
				ILP.loggingVariableValue=true;
				System.out.println("Log file turn on");
			}
			ILP.initializeIlp();
			ChangeSolver.loadLPSolveConfigFile();
		}else if(solverName.equals("Gurobi")){
			ControlData.solverName="Gurobi";
			ILP.loggingCplexLp=true;
			ILP.loggingLpSolve=false;
			if (log.equals("None")){
				ILP.logging=false;
				ILP.loggingVariableValue=false;
				System.out.println("Log file turn off");
			}else if (log.equals("Log")){
				ILP.logging=true;
				ILP.loggingVariableValue=true;
				System.out.println("Log file turn on");
			}
			ILP.initializeIlp();
		}
	}
	
	public boolean saveSvDss(String fileName){
		DSSDataWriter writer = new DSSDataWriter(fileName);
		try {
			writer.openDSSFile();
			DssOperation.saveSvarTSData(writer, fileName);
			writer.closeDSSFile();
			return true;
		} catch (Exception e) {
			writer.closeDSSFile();
			return false;
		}
	}
		
	public boolean saveDvDss(String fileName){
		if (fileName.equalsIgnoreCase(FilePaths.fullDvarDssPath)){
			DssOperation.writeInitDvarAliasToDSS();
			DssOperation.writeDVAliasToDSS();
			return true;
		}else{
			DSSDataWriter writer = new DSSDataWriter(fileName);
			try {
				writer.openDSSFile();
			} catch (Exception e) {
				writer.closeDSSFile();
				return false;
			}
			DssOperation.saveInitialData(writer, fileName);
			DssOperation.saveDvarData(writer, fileName);
			writer.closeDSSFile();
			return true;
		}
	}
	
	public static void main(String[] args){
		int argsSize=args.length;
		String[] modArgs=new String[argsSize-2];
		for (int i=0; i<=argsSize-3; i++){
			modArgs[i]=args[i+2];
		}
		int requestPort=Integer.parseInt(args[0]);
		int eventPort=Integer.parseInt(args[1]);
		new DebugInterface(requestPort, eventPort, modArgs);
	}
}
