package components;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class WriteSerialObj {
	  
	  //static Map<String, List<String>> mapStringList = new HashMap<String, List<String>>();
	  //private static PrintWriter out;


		public static void writeObj(SimulationDataSet data, String filePath){		
			
			FileOutputStream f_out = null;
			ObjectOutputStream obj_out = null;
			
			try {
				f_out = new FileOutputStream(filePath);
				obj_out = new ObjectOutputStream (f_out);
				obj_out.writeObject (data);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
	  

}
