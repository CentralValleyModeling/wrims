package wrimsv2.ilp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.components.ControlData;
import wrimsv2.wreslparser.elements.Tools;

public class IntermediateLP {
	
	private static PrintWriter _ilpFile;
	
	public IntermediateLP(){

	}
	
	public static void setIlpFile(String dirPath, int timeStep){
		
		String fileName = "test_"+Integer.toString(timeStep)+".ilp";
		
		try {
			_ilpFile = Tools.openFile(System.getProperty("user.dir")+"//"+dirPath, fileName);
			
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	public static void closeIlpFile(){
		
		_ilpFile.close();		
	}
	
	public static void output(){
		
		writeDvar();
		
		
	}
	
	private static void writeDvar(){
		
		_ilpFile.println("dvar test");
		
		Map<String, Dvar> dvarMap = SolverData.getDvarMap();
		ArrayList<String> sortedDvar = new ArrayList<String>(dvarMap.keySet());
		Collections.sort(sortedDvar);
		
		for (String key : sortedDvar){
			
			_ilpFile.println(key);
	
		}
	}
	

}
