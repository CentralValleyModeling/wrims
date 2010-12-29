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

	  public static String external_header ="NAME,TYPE,FROM_WRESL_FILE";
	  public static String svar_header ="NAME,TYPE,UNITS,CONVERT_TO,OUTPUT,CASE,ORDER,CONDITION,EXPRESSION,FROM_WRESL_FILE";
	  public static String dvar_header ="NAME,TYPE,UNITS,LOWER_BOUND,UPPER_BOUND,FROM_WRESL_FILE";	  
	  public static String alias_header ="NAME,TYPE,UNITS,OUTPUT,EXPRESSION,FROM_WRESL_FILE";
	  public static String goal_header = "NAME,LHS,CASE,ORDER,CONDITION,EXPRESSION/RHS,LHS>RHS,LHS<RHS,FROM_WRESL_FILE";
	  
	  public static void dataset(Dataset ds, String scope, String outFolder) throws IOException {
		  PrintWriter out_ex = Tools.openFile(outFolder,"external.csv");
		  PrintWriter out_sv = Tools.openFile(outFolder,"svar.csv");
		  PrintWriter out_dv = Tools.openFile(outFolder,"dvar.csv");
		  PrintWriter out_goal = Tools.openFile(outFolder,"constraint.csv");
		  PrintWriter out_alias = Tools.openFile(outFolder,"alias.csv");
			
		  out_ex.print(WriteCSV.external_header+"\n");
		  out_sv.print(WriteCSV.svar_header+"\n");
		  out_dv.print(WriteCSV.dvar_header+"\n");
		  out_goal.print(WriteCSV.goal_header+"\n");
		  out_alias.print(WriteCSV.alias_header+"\n");
		  
		  if (scope == "all") {
		  external(ds.exMap, ds.exList, out_ex );
		  svar(ds.svMap, ds.svList, out_sv );
		  dvar(ds.dvMap, ds.dvList, out_dv );
		  goal(ds.gMap,  ds.gList, out_goal );
		  alias(ds.asMap, ds.asList, out_alias );
		  } else if (scope == "global") {
			  external(ds.exMap, ds.exList_global, out_ex );
			  svar(ds.svMap, ds.svList_global, out_sv );
			  dvar(ds.dvMap, ds.dvList_global, out_dv );
			  goal(ds.gMap,  ds.gList_global, out_goal );
			  alias(ds.asMap, ds.asList_global, out_alias );
		  } else if (scope == "local") {
			  external(ds.exMap, ds.exList_local, out_ex );
			  svar(ds.svMap, ds.svList_local, out_sv );
			  dvar(ds.dvMap, ds.dvList_local, out_dv );
			  goal(ds.gMap,  ds.gList_local, out_goal );
			  alias(ds.asMap, ds.asList_local, out_alias );
		  } else { System.out.println("WriteCSV scope error!!!" ); }
		  
		  out_ex.close();
		  out_sv.close();
		  out_dv.close();
		  out_goal.close();
		  out_alias.close();
	  };

	  public static void external(Map<String,External> eMap, ArrayList<String> list ,PrintWriter out) {
		    
			List<String> keys = list;
			Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		    //List<SvarProps> svarPropsList;
			
		    for (String k: keys ){
		    	
		    	//out.print(k);
		    	External s = eMap.get(k);
		    	

			    out.print(k); // 
		    	out.print(","+s.type); //for KIND		    	

				out.print(","+s.fromWresl);
				out.print("\n");	
		    	
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
			    out.print(","+g.lhs); // for LHS
		    	//out.print(","+p.scope);  // for SCOPE
		    	//out.print(",Y"); //for INCLUDE
		    	//out.print(","+p.format); //for FORMAT
		    	//out.print(","+s.kind); //for KIND		    	
		    	//out.print(","+s.units); //for UNITS
		    	//out.print(",Y"); //for OUTPUT
		    	out.print(","+g.caseName.get(i)); //for CASE 
		    	out.print(","+caseOrder); //for ORDER 
		    	out.print(","+g.caseCondition.get(i)); //for CONDITION
		    	out.print(","+g.caseExpression.get(i)); //for EXPRESSION
		    	out.print(","+g.case_lhs_gt_rhs.get(i)); //for EXPRESSION
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
