package wrimsv2.components;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Error {
	public static ArrayList<String>   error_grammer = new ArrayList<String> ();
	
	public static void writeErrorFile(String fileName){
		
		String errorFileFullPath=MainFile.mainDirectory+fileName;
		try{
			FileWriter errorFile = new FileWriter(errorFileFullPath);
			PrintWriter out = new PrintWriter(errorFile);

			for (int i=0; i<error_grammer.size(); i++){
				out.println(error_grammer.get(i));
			}
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

