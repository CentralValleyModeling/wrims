package wrimsv2.evaluator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;

public class WeightEval {
	private static double minw=1.0;
	private static String minwv="N/A";
	private static double maxw=1.0;
	private static String maxwv="N/A";
	private static String minP="N/A";
	private static String maxP="N/A";
	private static int minC=-1;
	private static int maxC=-1;
	private static String fstr = "WeightTable.csv";
	
	private static ArrayList<String> wList=new ArrayList<String>();
	private static HashMap<String, LinkedHashMap<Integer, ArrayList<String>>> wMap= new HashMap<String, LinkedHashMap<Integer, ArrayList<String>>>();
	private static ArrayList<String> variedwList=new ArrayList<String>();
	
	public static void procWt(StudyDataSet sds){
		ArrayList<String> modelList = sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap = sds.getModelDataSetMap();
		for (int i=0; i<modelList.size(); i++){  
			String model=modelList.get(i);
			ModelDataSet mds=modelDataSetMap.get(model);
			collectWt(mds, i+1);
			collectWtSlackSurplus(mds, i+1);
		}
		outputWtTable();
		outputExtreme();
	}
	
	public static void collectWt(ModelDataSet mds, int ci){
		ArrayList<String> wtList = mds.wtList;
		Map<String, WeightElement> wtMap =mds.wtMap;
		ControlData.currEvalTypeIndex=7;
		for (String wtName: wtList){
			ControlData.currEvalName=wtName;
			WeightElement wt=wtMap.get(wtName);
			if (!wList.contains(wtName)){
				wList.add(wtName);
			}
			if (wMap.containsKey(wtName)){
				LinkedHashMap<Integer, ArrayList<String>> cw = wMap.get(wtName);
				if (cw.containsKey(ci)){
					ArrayList<String> wlc = cw.get(ci);
					wlc.add(wt.weight);
				}else{
					ArrayList<String> wlc = new ArrayList<String> ();
					wlc.add(wt.weight);
					cw.put(ci, wlc);
				}
			}else{
				LinkedHashMap<Integer, ArrayList<String>> cw = new LinkedHashMap<Integer, ArrayList<String>>();
				ArrayList<String> wlc = new ArrayList<String> ();
				wlc.add(wt.weight);
				cw.put(ci, wlc);
				wMap.put(wtName, cw);
			}
			try{
				double wtv = Double.parseDouble(wt.weight);
				if (wtv !=0.0){
					double awtv = Math.abs(wtv);
					if (awtv<=minw){
						minw=awtv;
						minwv=wtName;
						minP="("+wt.fromWresl+":"+wt.line+")";
						minC=ci;
					}else if (awtv>=maxw){
						maxw=awtv;
						maxwv=wtName;
						maxP="("+wt.fromWresl+":"+wt.line+")";
						maxC=ci;
					}
				}
			}catch (Exception e){
				variedwList.add(wtName);
			}		
		}
	}
	
	public static void collectWtSlackSurplus(ModelDataSet mds, int ci){
		ArrayList<String> wtssList = mds.wtSlackSurplusList;
		Map<String, WeightElement> wtssMap =mds.wtSlackSurplusMap;
		ControlData.currEvalTypeIndex=7;
		for (String wtssName: wtssList){
			ControlData.currEvalName=wtssName;
			WeightElement wt=wtssMap.get(wtssName);
			if (!wList.contains(wtssName)){
				wList.add(wtssName);
			}
			if (wMap.containsKey(wtssName)){
				LinkedHashMap<Integer, ArrayList<String>> cw = wMap.get(wtssName);
				if (cw.containsKey(ci)){
					ArrayList<String> wlc = cw.get(ci);
					wlc.add(wt.weight);
				}else{
					ArrayList<String> wlc = new ArrayList<String> ();
					wlc.add(wt.weight);
					cw.put(ci, wlc);
				}
			}else{
				LinkedHashMap<Integer, ArrayList<String>> cw = new LinkedHashMap<Integer, ArrayList<String>>();
				ArrayList<String> wlc = new ArrayList<String> ();
				wlc.add(wt.weight);
				cw.put(ci, wlc);
				wMap.put(wtssName, cw);
			}
			try{
				double wtv = Double.parseDouble(wt.weight);
				if (wtv !=0.0){
					double awtv = Math.abs(wtv);
					if (awtv<=minw){
						minw=awtv;
						minwv=wtssName;
						minP="("+wt.fromWresl+":"+wt.line+")";
						minC=ci;
					}else if (awtv>=maxw){
						maxw=awtv;
						maxwv=wtssName;
						maxP="("+wt.fromWresl+":"+wt.line+")";
						maxC=ci;
					}
				}
			}catch (Exception e){
				variedwList.add(wtssName);
			}
		}
	}
	
	public static void outputWtTable(){
		try {
			File file = new File(FilePaths.mainDirectory, fstr);
			if (!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			PrintWriter out = new PrintWriter(fw);
		
			Collections.sort(wList);
		
			out.println("Name"+","+"Cycle"+","+"Weight");
			for (int i=0; i<wList.size(); i++){
				String wtName = wList.get(i);
				LinkedHashMap<Integer, ArrayList<String>> cwMap = wMap.get(wtName);
				Set<Integer> ks = cwMap.keySet();
				Iterator<Integer> it = ks.iterator();
				while (it.hasNext()){
					int ci=it.next();
					ArrayList<String> wtList = cwMap.get(ci);
					for (int j=0; j<wtList.size(); j++){
						out.println(wtName+","+ci+","+wtList.get(j));
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void outputExtreme(){
		Collections.sort(variedwList);
		int size = variedwList.size();
		for (int i=0; i<size-1; i++){
			System.out.print(variedwList.get(i)+", ");
		}
		System.out.print(variedwList.get(size-1)+" ");
		System.out.println("have variable(s) in the weight and were excluded from the evaluation of the maximum and minimum weights.");
		System.out.println("The maximum weight is "+maxwv+" with a value of "+maxw+" and appear in Cycle "+maxC+".");
		System.out.println("The maximum weight source code location is at "+maxP+" .");
		System.out.println("The minimum weight is "+minwv+" with a value of "+minw+" and appear in Cycle "+minC+".");
		System.out.println("The minimum weight source code location is at "+minP+" .");
	}
}
