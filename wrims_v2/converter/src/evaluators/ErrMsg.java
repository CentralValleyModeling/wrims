package evaluators;

import java.util.Map;
import java.util.Set;

public class ErrMsg {
	
	
	public static void print(String msg, String file){

		
		//System.out.println("Error!!! "+msg+" in file: "+file);
		System.err.println("Error! "+msg+" in file: "+file);

	}

	public static void printParents(String msg, String file1, String file2,  Map<String,Set<String>> reverseMap){

		
		//System.out.println("Error!!! "+msg+" in file: "+file);
		System.err.println("Error! "+msg+" in files: ");
		System.err.println(file1);
		
		for (String s : reverseMap.get(file1)){
			System.err.println("-->"+s);
			
		}
		
		
		System.err.println(file2);
		printTree(file2,reverseMap, "");

	}	

	private static void printTree(String f, Map<String,Set<String>> reverseMap, String level){

		String arrow = ">";
		if(reverseMap.get(f)!=null){
			level = "-" + level;
			Set<String> parents = reverseMap.get(f);
			for (String s : parents){
				System.err.println(level+arrow+s);
				printTree(s, reverseMap, level);
				
				
			}
			
		}
		

		


	}	
}
	
