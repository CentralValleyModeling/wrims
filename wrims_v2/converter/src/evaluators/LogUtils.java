package evaluators;

import java.util.Map;
import java.util.Set;
import evaluators.Parameters;

public class LogUtils {
	

	public static void importantMsg(String msg){

		System.out.println(msg);
		
		System.out.flush();
	}
	
	public static void normalMsg(String msg){
		
		if (Parameters.printLevel>1){

			System.out.println(msg);
			
			System.out.flush();
		}
	}

	public static void errMsg(String msg){

		System.err.println("# Error: "+msg);

	}	
	
	public static void errMsg(String msg, String file){

		System.err.println("# Error: "+msg+" @ "+file);

	}

	public static void errMsg(String msg, String file1, String file2,  Map<String,Set<String>> reverseMap){

		System.out.flush();
		
		System.err.println("# Error: "+msg+" in files: ");
		String sp = "  ";
		System.err.println(sp+file1);
		printTree(file1,reverseMap, sp);		
		System.err.println(sp+file2);
		printTree(file2,reverseMap, sp);
		
		System.err.flush();


	}	

	private static void printTree(String f, Map<String,Set<String>> reverseMap, String level){

		//String arrow = ">";
		if(reverseMap.get(f)!=null){
			level = level + "--";
			Set<String> parents = reverseMap.get(f);
			for (String s : parents){
				System.err.println(level+s);
				printTree(s, reverseMap, level);
				
				
			}
			
		}
		

		


	}	
}
	
