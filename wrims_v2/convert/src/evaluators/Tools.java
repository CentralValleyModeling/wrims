package evaluators;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


public class Tools {
	  public static String strip(String s) {
		    return s.substring(1, s.length()-1);
		    }
	  
	  public static String readFileAsString(String filePath) throws IOException{
		    byte[] buffer = new byte[(int) new File(filePath).length()];
		    BufferedInputStream f = null;
		    try {
		        f = new BufferedInputStream(new FileInputStream(filePath));
		        f.read(buffer);
		    } finally {
		        if (f != null) try { f.close(); } catch (IOException ignored) { }
		    }
		    return new String(buffer);
		}
	  
	  public static String readFileLine(String filePath) throws IOException{
		
		  File input = new File(filePath);
		  BufferedReader in = new BufferedReader(new FileReader(input));		  
		  return in.readLine();
		  
		  
	  }
	  
}

