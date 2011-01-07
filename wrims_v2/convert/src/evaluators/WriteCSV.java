package evaluators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

public class WriteCSV {
	  
	  //static Map<String, List<String>> mapStringList = new HashMap<String, List<String>>();
	  //private static PrintWriter out;

	  public static String sequence_header ="RUN_ORDER,MODEL,CONDITION";
	  public static String weight_header ="DVAR,WEIGHT";
	  public static String external_header ="NAME,TYPE,FROM_WRESL_FILE";
	  public static String svar_header ="NAME,DSS_B_PART,TYPE,UNITS,CONVERT_TO,OUTPUT,CASE,ORDER,CONDITION,EXPRESSION,FROM_WRESL_FILE";
	  public static String dvar_header ="NAME,TYPE,UNITS,LOWER_BOUND,UPPER_BOUND,FROM_WRESL_FILE";	  
	  public static String alias_header ="NAME,TYPE,UNITS,OUTPUT,EXPRESSION,FROM_WRESL_FILE";
	  public static String goal_header = "NAME,CASE,ORDER,CONDITION,EXPRESSION,LHS>RHS,LHS<RHS,FROM_WRESL_FILE";

	public static void study(StudyConfig sc, Map<String, Dataset> modelDataMap, String outParent) {
			
		
		
			output(modelDataMap,outParent);
			
			
			try {
				PrintWriter out_seq = Tools.openFile(outParent, "SEQUENCE.csv");
				out_seq.print(WriteCSV.sequence_header + "\n");			
				sequence(sc.sequenceMap, sc.sequenceOrder, out_seq);
				out_seq.close();
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}	  
	  
	public static void output(Map<String, Dataset> modelDataMap, String outParent) {

		for (String model : modelDataMap.keySet()) {

			String outFolder = outParent + model;

			try {
				dataset(modelDataMap.get(model), outFolder);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void dataset(Dataset ds, String outFolder) throws IOException {

		PrintWriter out_ex;
		PrintWriter out_sv;
		PrintWriter out_dv;
		PrintWriter out_goal;
		PrintWriter out_alias;
		PrintWriter out_wt;
		
		if(ds.exList.size()>0){
			out_ex = Tools.openFile(outFolder, "external.csv");		
			out_ex.print(WriteCSV.external_header + "\n");
			external(ds.exMap, ds.exList, out_ex);	
			out_ex.close();
		}

		if(ds.svList.size()>0){
			out_sv = Tools.openFile(outFolder, "svar.csv");	
			out_sv.print(WriteCSV.svar_header + "\n");
			svar(ds.svMap, ds.svList, out_sv);
			out_sv.close();
		}
		if(ds.dvList.size()>0){
			out_dv = Tools.openFile(outFolder, "dvar.csv");	
			out_dv.print(WriteCSV.dvar_header + "\n");
			dvar(ds.dvMap, ds.dvList, out_dv);
			out_dv.close();
		}
		if(ds.gList.size()>0){
			out_goal = Tools.openFile(outFolder, "constraint.csv");		
			out_goal.print(WriteCSV.goal_header + "\n");
			goal(ds.gMap, ds.gList, out_goal);	
			out_goal.close();
		}
		if(ds.exList.size()>0){
			out_alias = Tools.openFile(outFolder, "alias.csv");		
			out_alias.print(WriteCSV.alias_header + "\n");
			alias(ds.asMap, ds.asList, out_alias);
			out_alias.close();
		}
		if(ds.wtList.size()>0){
			out_wt = Tools.openFile(outFolder, "weight.csv");		
			out_wt.print(WriteCSV.weight_header + "\n");
			weight(ds.wtMap, ds.wtList, out_wt);	
			out_wt.close();
		}



	};	

	  
	  public static void svar(Map<String,Svar> sMap, ArrayList<String> list ,PrintWriter out) {
		    
			List<String> keys = list;
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    //List<SvarProps> svarPropsList;
			
		    for (String k: keys ){
		    	
		    	//out.print(k);
		    	Svar s = sMap.get(k);
		    	
		    	for (int i=0; i<s.caseCondition.size(); i++)

		    	//	SvarProps p =sMap.get(k);
		    	{
			    	int caseOrder = i+1;
			    out.print(k); // for SVAR NAME
		    	//out.print(","+p.scope);  // for SCOPE
		    	//out.print(",Y"); //for INCLUDE
		    	//out.print(","+p.format); //for FORMAT
			    out.print(","+s.dssBPart); //for DSS B Part	
			    out.print(","+s.kind); //for KIND		    	
		    	out.print(","+s.units); //for UNITS
		    	out.print(","+s.convertToUnits); //for CONVERT
		    	out.print(",Y"); //for OUTPUT
		    	out.print(","+s.caseName.get(i)); //for CASE 
		    	out.print(","+caseOrder); //for CASE 
		    	out.print(","+s.caseCondition.get(i)); //for CONDITION
		    	out.print(","+s.caseExpression.get(i)); //for EXPRESSION
		    	

				out.print(","+s.fromWresl);
				out.print("\n");	
		    	}
			}
	  };	  

	
	  public static void sequence(Map<Integer,Sequence> seqMap, ArrayList<Integer> list ,PrintWriter out) {
		    
			List<Integer> keys = list;
			Collections.sort(keys);

			
		    for (Integer k: keys ){
		    	
		    	//out.print(k);
		    	//Sequence s = seqMap.get(k);
		    	

			    out.print(k); // 
		    	out.print(","+seqMap.get(k).modelName);
		    	out.print(","+seqMap.get(k).condition);
				out.print("\n");	
		    	
			}
	  };	
	
	  public static void external(Map<String,External> eMap, ArrayList<String> list ,PrintWriter out) {
		    
			List<String> keys = list;
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);

			
		    for (String k: keys ){
		    	
		    	//out.print(k);
		    	External s = eMap.get(k);
		    	

			    out.print(k); // 
		    	out.print(","+s.type); //for KIND		    	

				out.print(","+s.fromWresl);
				out.print("\n");	
		    	
			}
	  };	  

	  
	  public static void weight(Map<String,WeightTable> wtMap, ArrayList<String> list ,PrintWriter out) {
		    
			List<String> keys = list;
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    //List<SvarProps> svarPropsList;
			
		    for (String k: keys ){
		    	
		    	//out.print(k);
		    	WeightTable s = wtMap.get(k);
		    	

			    out.print(k); // for DVAR NAME

			    out.print(","+s.weight); //for DSS B Part	

				out.print("\n");	

			}
	  };	  

	public static void dvar(Map<String,Dvar> dMap, ArrayList<String> list ,PrintWriter out) {
		    
			List<String> keys = list;
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
			
		    for (String k: keys ){
		    	
		    	Dvar d = dMap.get(k);		    	

			    out.print(k); // for DVAR NAME

		    	out.print(","+d.kind); //for KIND		    	
		    	out.print(","+d.units); //for UNITS
		    	out.print(","+d.lowerBound); //for UNITS
		    	out.print(","+d.upperBound); //for UNITS

				out.print(","+d.fromWresl);
				out.print("\n");	
		    	}
	  };

	public static void alias(Map<String,Alias> asMap, ArrayList<String> list ,PrintWriter out) {
		    
			List<String> keys = list;
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
			
		    for (String k: keys ){
		    	
		    	Alias a = asMap.get(k);		    	

			    out.print(k); // for DVAR NAME

		    	out.print(","+a.kind); //for KIND		    	
		    	out.print(","+a.units); //for UNITS
		    	out.print(",Y"); //for OUTPUT
		    	out.print(","+a.expression); //for expression

				out.print(","+a.fromWresl);
				out.print("\n");	
		    	}
	  };		  
	  
	  public static void goal(Map<String,Goal> gMap, ArrayList<String> list ,PrintWriter out) {
		    
			List<String> keys = list;
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    //List<SvarProps> svarPropsList;
			
		    for (String k: keys ){
		    	
		    	//out.print(k);
		    	Goal g = gMap.get(k);
		    	
		    	for (int i=0; i<g.caseCondition.size(); i++)

		    	//	SvarProps p =sMap.get(k);
		    	{
			    	int caseOrder = i+1;
			    out.print(k); // for GOAL NAME
			    //out.print(","+g.lhs); // for LHS
		    	//out.print(","+p.scope);  // for SCOPE
		    	//out.print(",Y"); //for INCLUDE
		    	//out.print(","+p.format); //for FORMAT
		    	//out.print(","+s.kind); //for KIND		    	
		    	//out.print(","+s.units); //for UNITS
		    	//out.print(",Y"); //for OUTPUT
		    	out.print(","+g.caseName.get(i)); //for CASE 
		    	out.print(","+caseOrder); //for ORDER 
		    	out.print(","+g.caseCondition.get(i)); //for CONDITION
		    	
		    	if (g.lhs != Parameters.undefined ) {
		    		out.print("," + g.lhs + " = " + g.caseExpression.get(i) ); //for EXPRESSION
		    	}
		    	
		    	else {
		    		out.print("," + g.caseExpression.get(i) ); //for EXPRESSION
		    	}
		    	
		    	out.print(","+g.case_lhs_gt_rhs.get(i)); //
		    	out.print(","+g.case_lhs_lt_rhs.get(i)); //for EXPRESSION
		    	

				out.print(","+g.fromWresl);
				out.print("\n");	
		    	}
			}
	  };	  
	  
		public static void mapStringListMerged(Object obj, PrintWriter out) {
			
		    @SuppressWarnings("unchecked")
		    List<Map<String, List<String>>> listMapStringList = (List<Map<String, List<String>>>) obj;
		    Map<String, List<String>> mapAll = new HashMap<String, List<String>>();		    
		    
			ArrayList<String> keys = new ArrayList<String>(); 
			
			for (Map<String, List<String>> m : listMapStringList){
				
				mapAll.putAll(m);
			}

			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    
		    for (String k: keys ){
		    	out.print(k);		
			
				for(String i : mapAll.get(k)){
					out.print(","+i);}
				out.print("\n");	
			}
	  };	  
	  

}
