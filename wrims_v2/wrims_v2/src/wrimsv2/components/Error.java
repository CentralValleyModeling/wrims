package wrimsv2.components;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Error {
	public static ArrayList<String>   error_grammer = new ArrayList<String> ();
	public static ArrayList<String>   error_evaluation= new ArrayList<String> ();
	
	public static void writeGrammerErrorFile(String fileName){
		
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
	
	public static void writeEvaluationErrorFile(String fileName){
		
		String errorFileFullPath=MainFile.mainDirectory+fileName;
		try{
			FileWriter errorFile = new FileWriter(errorFileFullPath);
			PrintWriter out = new PrintWriter(errorFile);

			for (int i=0; i<error_evaluation.size(); i++){
				out.println(error_evaluation.get(i));
			}
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void addEvaluationError(String error){
		if (ControlData.currFileTypeIndex == 0){
			error_evaluation.add(ControlData.currEvalName+" in svar definition of Cycle "+ControlData.currCycleIndex+": "+error);
		}else if (ControlData.currFileTypeIndex == 1){
			error_evaluation.add(ControlData.currEvalName+" in dvar definition of Cycle "+ControlData.currCycleIndex+": "+error);
		}else if (ControlData.currFileTypeIndex == 2){
			error_evaluation.add(ControlData.currEvalName+" in constraint definition of Cycle "+ControlData.currCycleIndex+": "+error);
		}else if (ControlData.currFileTypeIndex == 3){
			error_evaluation.add(ControlData.currEvalName+" in alias definition of Cycle "+ControlData.currCycleIndex+": "+error);
		}
			
	}
}

