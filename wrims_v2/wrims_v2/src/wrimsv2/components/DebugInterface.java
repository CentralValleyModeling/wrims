package wrimsv2.components;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
	public boolean isRunning=true;
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
			controllerDebug.suspend();
			do {
				try{
					message=requestIn.readLine();
					handleRequest (message);
				}catch (Exception e){
					e.printStackTrace();
				}
			}while (isRunning);
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
		}else if (request.startsWith("time")){
			requestParts=request.split(":");
			String[] yearMonthDayCycle=requestParts[1].split("\\");
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
				dataString=dataString+":"+value+"#";
			}
			if (ControlData.currDvMap.containsKey(variable)){
				Number value=ControlData.currDvMap.get(variable).getData().getData();
				dataString=dataString+":"+value+"#";
			}
			if (ControlData.currAliasMap.containsKey(variable)){
				Number value=ControlData.currAliasMap.get(variable).getData().getData();
				dataString=dataString+":"+value+"#";
			}
		}
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-2);
		return dataString;
	}
	
	public static void main(int requestPort, int eventPort, String[] args){
		new DebugInterface(requestPort, eventPort, args);
	}
}
