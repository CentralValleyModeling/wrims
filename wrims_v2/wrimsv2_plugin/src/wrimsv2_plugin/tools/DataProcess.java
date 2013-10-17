package wrimsv2_plugin.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.model.IValue;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
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
	
	public static Map<String, VariableProperty> generateVariableProperty(String data){
		Map<String, VariableProperty> vp=new HashMap<String, VariableProperty>();
		if (!data.equals("")){
			String[] dataStrings = data.split("#");
			for (int i=0; i<dataStrings.length; i++){
				String[] dataParts = dataStrings[i].split(":");
				VariableProperty property = new VariableProperty(dataParts[1], dataParts[2]);
				vp.put(dataParts[0], property);
			}
		}
		return vp;
	}
	
	public static void generateAltStudyData(){
		Map<String, String>[] studiesData = DebugCorePlugin.studiesData;
		int suspendedYear=DebugCorePlugin.suspendedYear;
		int suspendedMonth=DebugCorePlugin.suspendedMonth;
		int suspendedDay=DebugCorePlugin.suspendedDay;
		int suspendedCycle=DebugCorePlugin.suspendedCycle;
		String sm, sd, sc;
		if (suspendedMonth<10){
			sm="0"+suspendedMonth;
		}else{
			sm=""+suspendedMonth;
		}
		if (suspendedDay<10){
			sd="0"+suspendedDay;
		}else{
			sd=""+suspendedDay;
		}
		if (suspendedCycle<10){
			sc="0"+suspendedCycle;
		}else{
			sc=""+suspendedCycle;
		}
		String line="";
		for (int i=4; i<8; i++){
			int j=i-4;
			studiesData[j]=new HashMap<String, String>();
			if (DebugCorePlugin.selectedStudies[i]){
				String dvFileName=DebugCorePlugin.studyFolderNames[j]+"\\dvar\\"+suspendedYear+"_"+sm+"_"+"c"+sc+".dvar";
				File dvFile=new File(dvFileName);
				if (dvFile.exists()){
					try {
						FileReader fr = new FileReader(dvFile);
						BufferedReader br = new BufferedReader(fr);
						while ((line = br.readLine()) != null) {
							if (line.equals("/* Weighted Dvar    */") || line.equals("/* Unweighted Dvar    */") || line.equals("")){
							}else{
								String[] part=line.split(":");
								studiesData[j].put(part[0].trim(), part[1]);
							}
						}
					} catch (Exception e) {
						WPPException.handleException(e);
					}
				}
				String svFileName=DebugCorePlugin.studyFolderNames[j]+"\\svar\\"+suspendedYear+"_"+sm+"_"+"c"+sc+".svar";
				File svFile=new File(svFileName);
				if (svFile.exists()){
					try {
						FileReader fr = new FileReader(svFile);
						BufferedReader br = new BufferedReader(fr);
						while ((line = br.readLine()) != null) {
							String[] part=line.split(":");
							studiesData[j].put(part[0].trim(), part[1]);
						}
					} catch (Exception e) {
						WPPException.handleException(e);
					}
				}
			}
		}
	}
	
	public static void initialVariableValueAlt(){
		Map<String, String>[] variableValueAlt = DebugCorePlugin.variableAltValue;
		for (int i=0; i<8; i++){
			variableValueAlt[i]=new HashMap<String, String>();
		}
	}
}
