package wrimsv2_plugin.tools;

import java.util.ArrayList;

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
}
