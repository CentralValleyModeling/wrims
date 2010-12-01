package evaluators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import java.util.Map;




public class Wresl2Writers {
	  
	  //static Map<String, List<String>> mapStringList = new HashMap<String, List<String>>();
	  static PrintWriter out;
	  
	  
	
	public static void mapStringList(Object obj, String dir, String fileName) throws IOException{
		  
		    File d = new File(dir);
		    boolean success = d.mkdir();
		    File f = new File(dir, fileName);		    
		    success = f.createNewFile( );
		    
		    out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			
		    @SuppressWarnings("unchecked")
		    Map<String, List<String>> mapStringList = (Map<String, List<String>>) obj;	
		    
		    for (String k: mapStringList.keySet() ){
		    	out.print(k);		
			
				for(String i : mapStringList.get(k)){
					out.print(","+i);}
				out.print("\n");	
			}
				
			out.close();
	  };
	  

}
