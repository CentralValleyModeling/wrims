package wrimsv2.components;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;

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
	private String dataString;
	private String[] debugSvar;
	private String[] debugDvar;
	private String[] debugAlias;
	private String[] allDebugVariables;
	
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
		String [] requestParts;
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
		}else if (request.equals("alldata")){
			try{
				dataString=getAllDataString();
				sendRequest(dataString);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (request.startsWith("time")){
			requestParts=request.split(":");
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
			requestParts=request.split(":");
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
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-2);
		return dataString;
	}
	
	public String getAllDataString(){
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

		Set<String> tsKeySet = tsMap.keySet();
		Iterator<String> tsIterator = tsKeySet.iterator();
		while (tsIterator.hasNext()){
			String tsName=tsIterator.next();
			if (!allDataNames.contains(tsName)){
				allDataNames.add(tsName);
				allTsNames.add(tsName);
				allData.put(tsName, tsMap.get(tsName).getData().getData());
			}
		}
		
		Set<String> dvKeySet = dvMap.keySet();
		Iterator<String> dvIterator = dvKeySet.iterator();
		while (dvIterator.hasNext()){
			String dvName=dvIterator.next();
			if (!allDataNames.contains(dvName)){
				allDataNames.add(dvName);
				allDvNames.add(dvName);
				allData.put(dvName, dvMap.get(dvName).getData().getData());
			}
		}
		
		Set<String> svKeySet = svMap.keySet();
		Iterator<String> svIterator = svKeySet.iterator();
		while (svIterator.hasNext()){
			String svName=svIterator.next();
			if (!allDataNames.contains(svName)){
				allDataNames.add(svName);
				allSvNames.add(svName);
				allData.put(svName, svMap.get(svName).getData().getData());
			}
		}
		
		Set<String> svFutKeySet = svFutMap.keySet();
		Iterator<String> svFutIterator = svFutKeySet.iterator();
		while (svFutIterator.hasNext()){
			String svFutName=svFutIterator.next();
			if (!allDataNames.contains(svFutName)){
				allDataNames.add(svFutName);
				allSvNames.add(svFutName);
				allData.put(svFutName, svMap.get(svFutName).getData().getData());
			}
		}
		
		Set<String> asKeySet = asMap.keySet();
		Iterator<String> asIterator = asKeySet.iterator();
		while (asIterator.hasNext()){
			String asName=asIterator.next();
			if (!allDataNames.contains(asName)){
				allDataNames.add(asName);
				allData.put(asName, asMap.get(asName).getData().getData());
			}
			if (!allAsNames.contains(asName)){
				allAsNames.add(asName);
			}
		}
		
		Collections.sort(allDataNames);
		for (String variable: allDataNames){
			dataString=dataString+variable+":"+allData.get(variable)+"#";
		}
		
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-2);
		return dataString;
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
