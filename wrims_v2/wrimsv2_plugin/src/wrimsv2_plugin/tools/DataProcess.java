package wrimsv2_plugin.tools;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.debug.core.model.IValue;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;
import wrimsv2_plugin.debugger.model.WPPValue;

public class DataProcess {
	public static ArrayList<String[]> generateVarDetailData(String data){
		ArrayList<String[]> varDetail = new ArrayList<String[]>();
		String[] dataStrings = data.split("#");
		for (int i=0; i<dataStrings.length; i++){
			String[] entry=dataStrings[i].split(":");
			varDetail.add(entry);
		}
		return varDetail;
	}
	
	public static IValue[] generateTree(String data){
		if (data.equals("")){
			return new WPPValue[0];
		}else{
			String[] dataStrings=data.split("#");
			int size=dataStrings.length;
		
			WPPValue[] values=new WPPValue[size];  
			for (int i=0; i<size; i++){
				String[] dataSubStrings=dataStrings[i].split(":",2);
				WPPValue value=new WPPValue(DebugCorePlugin.target,dataSubStrings[1], dataSubStrings[0]); 
				values[i]=value;
			}
			return values;
		}
	}
	
	public static ArrayList<String> generateArrayList(String data){
		if (data.equals("")) return new ArrayList<String>();
		String[] dataParts=data.split(":");
		return new ArrayList<String>(Arrays.asList(dataParts));  
	}
}
