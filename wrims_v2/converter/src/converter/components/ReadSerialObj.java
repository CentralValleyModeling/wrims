package converter.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ReadSerialObj {
	  
	  //static Map<String, List<String>> mapStringList = new HashMap<String, List<String>>();
	  //private static PrintWriter out;


	public static SimulationDataSet readObj(String filePath){
		
		FileInputStream f_in = null;
		SimulationDataSet obj_in = null;
	
		
		try {
			f_in = new FileInputStream(filePath);
			obj_in = (SimulationDataSet)(new ObjectInputStream (f_in).readObject());
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
