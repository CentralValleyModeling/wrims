package wrimsv2_plugin.debugger;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import wrimsv2_plugin.debugger.model.IWPPEventListener;

public class ContactDebugger implements IWPPEventListener{
	private ServerSocket requestSocket;
	private Socket requestConnection;
	private ServerSocket eventSocket;
	private Socket eventConnection;
	private PrintWriter out;
	private BufferedReader in;
	public int pauseIndex=-1;
	public int i=-1;
	private Runner runner;
	private FileWriter statusFile;
	public PrintWriter fileOut;
	private boolean isStart=false;
	
	public ContactDebugger(int requestPort, int eventPort){
		try{	
			statusFile = new FileWriter("SocketTest.txt");
		}catch (IOException e){
			e.printStackTrace();
		}
		fileOut = new PrintWriter(statusFile);
		fileOut.println("good!");
		try {
			requestSocket = new ServerSocket(requestPort);
			eventSocket = new ServerSocket(eventPort);
			requestConnection=requestSocket.accept();
			eventConnection=eventSocket.accept();
			out=new PrintWriter(requestConnection.getOutputStream());
			out.flush();
			in=new BufferedReader(new InputStreamReader(requestConnection.getInputStream()));
			String message="";
			runner=new Runner(this);
			do {
				try{
					message=in.readLine();
					handleEvent (message);
				}catch (Exception e){
					e.printStackTrace();
				}
			}while (i<=10000);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}		
		
		finally{
			try{
				fileOut.close();
				in.close();
				out.close();
				requestSocket.close();
				eventSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}

	}
		
	@Override
	public void handleEvent(String request) {
		String[] requestParts=request.split(":");
		if (requestParts[0].equals("to")) {
			pauseIndex=Integer.parseInt(requestParts[1]);
			if (isStart){
				runner.resume();
			}else{
				isStart=true;
				runner.start();
			}
		} else if (request.equals("step: ")) {
			pauseIndex=pauseIndex+1;
			if (isStart){
				runner.resume();
			}else{
				isStart=true;
				runner.start();
			}
		}else if (request.equals("end: ")){
			pauseIndex=10001;
			if (isStart){
				runner.resume();
			}else{
				isStart=true;
				runner.start();
			}
			try {
				sendRequest("end");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendRequest(String request) throws IOException {
		synchronized (requestConnection){
			try{
				out.println(request);
				out.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}  
	
}
