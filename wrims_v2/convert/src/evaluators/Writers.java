package evaluators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class Writers {
	  
	  static Map<String, ArrayList<String>> mapStringArray;
	
	  public static void outputWresl2(Object obj, String dir, String fileName) throws IOException{
		  
		    File d = new File(dir);
		    boolean success = d.mkdir();
		    File f2 = new File(dir, fileName);		    
		    success = f2.createNewFile( );
		    
		    BufferedWriter outputFile = new BufferedWriter(new FileWriter(f2));
			
		    mapStringArray = (Map<String, ArrayList<String>>) obj;
		    
		    for (String k: mapStringArray.keySet() ){
				outputFile.write(k);
			
				for(String i : mapStringArray.get(k)){
					outputFile.write(",");outputFile.write(i);}
				outputFile.newLine();	
			}
				
			outputFile.close();
	  };
	  

}
