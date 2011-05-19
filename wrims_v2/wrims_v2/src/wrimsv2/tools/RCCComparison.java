package wrimsv2.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.EvalConstraint;

public class RCCComparison {
	private String cycleName="02";
	private BufferedWriter out; 
	private String gName;
	private ArrayList<Object> gNameArrayList=new ArrayList<Object> ();
	
	public RCCComparison() {
		Map<String, EvalConstraint> constraintMap=SolverData.getConstraintDataMap();
		Object[] gNameArray=constraintMap.keySet().toArray();
		Collections.addAll(gNameArrayList, gNameArray); 
		
		try{
			String outPath=FilePaths.mainDirectory+"comparercc.txt";
			FileWriter outstream = new FileWriter(outPath);
			out = new BufferedWriter(outstream);

			String filePath=FilePaths.mainDirectory+"rcc_reformatted.txt";
		
			FileInputStream fstream = new FileInputStream(filePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			    
			String strLine;
			boolean isEnd=false;
			int line=0;
			while (!isEnd){
			 	strLine=br.readLine();
			 	if (strLine==null || strLine.equals("")) {
			 		isEnd=true;
			 	}else{
			 		if (!isEnd && (strLine.startsWith("00") && !strLine.startsWith("00"+"Objective")) || (strLine.startsWith(cycleName) && !strLine.startsWith(cycleName+"Objective"))){
			 			compare(strLine);
			 		}
			 	}
			}
			
			for (int i=0; i<gNameArrayList.size(); i++){
				out.write(gNameArrayList.get(i)+" is not in WRIMS1.\n");
			}
			out.close();
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(gName);
		}
	}
	
	public void compare(String strLine) throws IOException{
		strLine=strLine.substring(2, strLine.length()).toLowerCase();
		String[] subStrs=strLine.split(":");
		gName=subStrs[0].substring(0, subStrs[0].lastIndexOf("/"));
		Map<String, EvalConstraint> constraintMap=SolverData.getConstraintDataMap();
		if (constraintMap.containsKey(gName)){
			EvalConstraint ec=constraintMap.get(gName);
			gNameArrayList.remove(gName);
			Map<String, IntDouble> multiplier=ec.getEvalExpression().getMultiplier();
			String outLine=gName+":";
			String[] coefVariable=subStrs[1].replaceAll(" ","").split(";");
			boolean isDifferent=false;
			for (int i=0; i<coefVariable.length-1; i++){
				String[] multiStrs=coefVariable[i].split("\\|");
				if (multiplier.containsKey(multiStrs[0])){
					double coef=multiplier.get(multiStrs[0]).getData().doubleValue();
					if (Math.abs(coef-Double.parseDouble(multiStrs[1]))>0.1){
						isDifferent=true;
						outLine=outLine+"("+multiStrs[1]+"|"+coef+")*"+multiStrs[0]+";";
					}
				}
			}
			String[] signValue=subStrs[subStrs.length-1].split(";");
			if (!signValue[0].replaceAll(" ", "").equals(ec.getSign())){
				isDifferent=true;
				outLine=outLine+"("+signValue[0]+"|"+ec.getSign()+")";
			}
			double value=-ec.getEvalExpression().getValue().getData().doubleValue();
			if (Math.abs(Double.parseDouble(signValue[1]))-value >0.1){
				isDifferent=true;
				outLine=outLine+"("+signValue[1]+"|"+value+")";
			}
			if (isDifferent) out.write(outLine+"\n");
		}else{
			out.write(gName+" is not in WRIMS v2.\n");
		}
	}
}
