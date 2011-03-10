package components;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ReadSerialObj {
	  
	  //static Map<String, List<String>> mapStringList = new HashMap<String, List<String>>();
	  //private static PrintWriter out;


	public static SimulationData readObj(String filePath){
		
		FileInputStream f_in = null;
		SimulationData obj_in = null;
	
		
		try {
			f_in = new FileInputStream(filePath);
			obj_in = (SimulationData)(new ObjectInputStream (f_in).readObject());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return obj_in;
	
	} 
	  

}
