package components_tree;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import components_tree.Parameters;


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
	

	
	public static void varsList(ArrayList<String> list_all, ArrayList<String> list_g, ArrayList<String> list_l, String description){
		
		LogUtils.importantMsg("------------------------------");
		LogUtils.importantMsg("Include total "+list_all.size()+" "+description+":");
		LogUtils.importantMsg(list_all);
		LogUtils.importantMsg("------------------------------");
		LogUtils.importantMsg("Include total "+list_g.size()+" global "+description+":");
		LogUtils.importantMsg(list_g);
		LogUtils.importantMsg("------------------------------");
		LogUtils.importantMsg("Include total "+list_l.size()+" local "+description+":");
		LogUtils.importantMsg(list_l);
		LogUtils.importantMsg("------------------------------");
		
	}
	public static void varsList(ArrayList<String> list_all, String description){
		
		LogUtils.importantMsg("------------------------------");
		LogUtils.importantMsg("Include total "+list_all.size()+" "+description+":");
		LogUtils.importantMsg(list_all);
		LogUtils.importantMsg("------------------------------");
	
	}

	public static void seqList(ArrayList<String> list,  Map<Integer, Sequence> seqMap){
		
		LogUtils.importantMsg("------------------------------");
		LogUtils.importantMsg("Include total "+list.size()+" sequences:");
		for (int i: seqMap.keySet()){
			LogUtils.importantMsg("Order: "+i+"  Sequence: "+seqMap.get(i).sequenceName+"  Model: "+seqMap.get(i).modelName);
		}
		LogUtils.importantMsg("------------------------------");
	
	}	
	
	public static void fileSummary(StructTree F){

		seqList(F.seqList, F.seqMap);
		varsList(F.model_list, "models");
		varsList(F.incFileList, F.incFileList_global, F.incFileList_local, "files");
		varsList(F.dvList, F.dvList_global, F.dvList_local, "Dvars");
		varsList(F.svList, F.svList_global, F.svList_local, "Svars");
		
	}	

	public static void mainFileSummary(StructTree F, Map<String, StructTree> modelMap){

		seqList(F.seqList, F.seqMap);
		varsList(F.model_list, "models");
		
		for (String key: F.model_list){
			StructTree M = modelMap.get(key);
			LogUtils.importantMsg("#####  Model: "+ key);
			varsList(M.incFileList, M.incFileList_global, M.incFileList_local, "files");
			varsList(M.dvList, M.dvList_global, M.dvList_local, "Dvars");
			varsList(M.svList, M.svList_global, M.svList_local, "Svars");
		}
	}	
	
	public static void importantMsg(String msg){

		System.out.println(msg);
		_logFile.println(msg);
	}
	
	public static void importantMsg(ArrayList<String> msg){
		
		for(String e: msg){
			importantMsg(e+"\n");
		}
	}
	
	public static void normalMsg(String msg){
		
		if (Parameters.printLevel>1){

			System.out.println(msg);
			_logFile.println(msg);

		}
	}

	public static void consoleMsgOnly(String msg){

		 System.out.println(msg);
		
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
	
