package components;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import components.Parameters;


public class LogUtils {

	public static PrintWriter _logFile;


	public static void setLogFile(){
		
		 setLogFile(Parameters.converterLogFileName);		
	}
	
	public static void setLogFile(String logFileName){
				
		try {
			_logFile = Tools.openFile(System.getProperty("user.dir"), logFileName);
			
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	

	public static void importantMsg(String msg){

		System.out.println(msg);
		_logFile.println(msg);
	}
	
	public static void normalMsg(String msg){
		
		if (Parameters.printLevel>1){

			System.out.println(msg);
			_logFile.println(msg);

		}
	}

	public static void errMsg(String msg){

		 System.out.println("# Error: "+msg);
		 _logFile.println("# Error: "+msg);
		
	}	
	
	public static void errMsg(String msg, String file){

		 System.out.println("# Error: "+msg+" @ "+file);
		 _logFile.println("# Error: "+msg+" @ "+file);
		
	}

	public static void errMsg(String msg, String file1, String file2, Map<String, Set<String>> reverseMap) {

		System.out.println("# Error: " + msg + " in files: ");
		_logFile.println("# Error: " + msg + " in files: ");

		String sp = "  ";
		System.out.println(sp + file1);
		_logFile.println(sp + file1);
		printTree(file1, reverseMap, sp);
		System.out.println(sp + file2);
		_logFile.println(sp + file2);
		printTree(file2, reverseMap, sp);

	}

	private static void printTree(String f, Map<String, Set<String>> reverseMap, String level) {

		// String arrow = ">";
		if (reverseMap.get(f) != null) {
			level = level + "--";
			Set<String> parents = reverseMap.get(f);
			for (String s : parents) {
				System.out.println(" "+level + "> "+ s);
				_logFile.println(" "+level + "> "+ s);

				printTree(s, reverseMap, level);

			}

		}	


	}	
}
	
