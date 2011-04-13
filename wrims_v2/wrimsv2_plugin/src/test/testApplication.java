package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class testApplication {
	
	public static void main(String arg[]) throws IOException{
		int requestPort=Integer.parseInt(arg[0]);
		int eventPort=Integer.parseInt(arg[1]);
		ContactDebugger run=new ContactDebugger(requestPort, eventPort);
	}
}
