package evaluators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Map;


public class WriteCSV {
	  
	  //static Map<String, List<String>> mapStringList = new HashMap<String, List<String>>();
	  private static PrintWriter out;
	 
	  public static String svar_dss_header ="NAME,KIND,UNIT";	  
	  public static String svar_table_header ="NAME,SELECT,FROM,GIVEN,USE,WHERE,WHERE,WHERE";
	  public static String dvar_header ="NAME";
	  
	private static void openFile(String filePath) throws IOException{
		File f = new File(filePath);
		File dir = new File(f.getParent());
		dir.mkdirs();
		f.createNewFile();
		
	    out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
	}
	  
	public static void mapStringList(Object obj, String header, String filePath) throws IOException{
		  
			openFile(filePath);
			
		    @SuppressWarnings("unchecked")
		    Map<String, List<String>> mapStringList = (Map<String, List<String>>) obj;
		    
			List<String> keys = new ArrayList<String> (mapStringList.keySet());
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    
			out.print(header+"\n");
		    for (String k: keys ){
		    	out.print(k);		
			
				for(String i : mapStringList.get(k)){
					out.print(","+i);}
				out.print("\n");	
			}
				
			out.close();
	  };
	  

}
