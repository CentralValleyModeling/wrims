package components_tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructTree {
	
	public SimulationDataSet S;



	// / models appear in this parsed file
	//public ArrayList<String> model_list = new ArrayList<String>();
	//public ArrayList<String> error_model_redefined = new ArrayList<String>();

	// / weight table   // <objName,  <itemName, value>>
	public WeightTable wt;
//	public ArrayList<String> wtList = new ArrayList<String>();
//	public ArrayList<String> wtList_global = new ArrayList<String>();
//	public ArrayList<String> wtList_local = new ArrayList<String>();
//	public Map<String, WeightTable> wtMap = new HashMap<String, WeightTable>();
//	public Map<String,String> error_weightVar_redefined = new HashMap<String, String>();
	
	// / sequence
	//public ArrayList<Integer> error_sequence_order_redefined = new ArrayList<Integer>();
	//public ArrayList<String> error_sequence_redefined = new ArrayList<String>();	
	
	public Sequence seq;
	//public Map<Integer, Sequence> seqMap = new HashMap<Integer, Sequence>();
	//public ArrayList<String> seqList = new ArrayList<String>();
	
	// / includeFile data structure
	public IncludeFile incFile;
//	public ArrayList<String> incFileList = new ArrayList<String>();
//	public ArrayList<String> incFileList_global = new ArrayList<String>();
//	public ArrayList<String> incFileList_local = new ArrayList<String>();
//	public Map<String, IncludeFile> incFileMap = new HashMap<String, IncludeFile>();
//	public ArrayList<String> error_includeFile_redefined = new ArrayList<String>();

	// / external function structure
	public External ex;
	//public ArrayList<String> exList = new ArrayList<String>();
	//public ArrayList<String> exList_global = new ArrayList<String>();
	//public ArrayList<String> exList_local = new ArrayList<String>();
	//public Map<String, External> exMap = new HashMap<String, External>();
	
	// / svar data structure
	public Svar sv;
//	public ArrayList<String> svList = new ArrayList<String>();
//	public ArrayList<String> svList_global = new ArrayList<String>();
//	public ArrayList<String> svList_local = new ArrayList<String>();
//	public Map<String, Svar> svMap = new HashMap<String, Svar>();

	// / dvar data structure
	public Dvar dv;
	//public ArrayList<String> dvList = new ArrayList<String>();
	//public ArrayList<String> dvList_global = new ArrayList<String>();
	//public ArrayList<String> dvList_local = new ArrayList<String>();
	//public Map<String, Dvar> dvMap = new HashMap<String, Dvar>();

	// / alias data structure
	public Alias as;
	//public ArrayList<String> asList = new ArrayList<String>();
	//public ArrayList<String> asList_global = new ArrayList<String>();
	//public ArrayList<String> asList_local = new ArrayList<String>();
	//public Map<String, Alias> asMap = new HashMap<String, Alias>();

	// / goal data structure
	public Goal gl;
	//public ArrayList<String> gList = new ArrayList<String>();
	//public ArrayList<String> gList_global = new ArrayList<String>();
	//public ArrayList<String> gList_local = new ArrayList<String>();
	//public Map<String, Goal> gMap = new HashMap<String, Goal>();
	//public Map<String, String> error_goal_redefined = new HashMap<String, String>();
	
	// / errors
	//public Map<String, String> error_var_redefined = new HashMap<String, String>();

	//public Map<String, String> svar_expression = new HashMap<String, String>();

//	public Map<String, ArrayList<String>> dvar_nonstd = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> dvar_std = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> dvar_alias = new HashMap<String, ArrayList<String>>();
//
//	public Map<String, ArrayList<String>> svar_table_text = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> svar_table = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> svar_dss = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> svar_sum = new HashMap<String, ArrayList<String>>();

	// / variable, scope, and type, units
	//public Map<String, String> var_all = new HashMap<String, String>();
	//public Map<String, String> svar_scope = new HashMap<String, String>();
//	public Map<String, String> svar_type = new HashMap<String, String>();
//	public Map<String, String> dvar_scope = new HashMap<String, String>();
//	public Map<String, String> goal_scope = new HashMap<String, String>();
//	public Map<String, String> include_file_scope = new HashMap<String, String>();

//	public Map<String, ArrayList<String>> svar_type_units = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> dvar_type_units = new HashMap<String, ArrayList<String>>();

	// / models in a file

	// / svar_cases
//	public Map<String, ArrayList<String>> svar_cases = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> svar_conditions = new HashMap<String, ArrayList<String>>();
//	public Map<String, Map<String, ArrayList<String>>> svar_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();

	// / goal
//	public Map<String, String> goal_simple = new HashMap<String, String>();
//	public Map<String, ArrayList<String>> goal_no_case = new HashMap<String, ArrayList<String>>();

	// / goal_cases
//	public Map<String, String> goal_lhs = new HashMap<String, String>();
//	public Map<String, ArrayList<String>> goal_cases = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> goal_conditions = new HashMap<String, ArrayList<String>>();
//	public Map<String, Map<String, ArrayList<String>>> goal_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();

	private static String[] keys = { "define", "goal" };
	private static String[] mons = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
			"JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	public static List<String> r_keys = Arrays.asList(keys);
	public static List<String> r_mons = Arrays.asList(mons);

	// public static List<String> reserved_words = new ArrayList<String>() {{
	// addAll(r_keys); addAll(r_mons); }};

	public void modelList(String name) {
		if (S.model_list.contains(name)) {
			LogUtils.errMsg("Model redefined: "+name, S.currentAbsolutePath);
			S.error_model_redefined.add(name);
		} else {
			// file_include_file.get(name).add(filePath);
			S.model_list.add(name);
			S.var_all.put(name, "model");
		}
	}

	public void mergeWeightTable(String name, String value, String scope) {
		if (S.wtList.contains(name)) {
			LogUtils.errMsg("Weight table variable redefined: "+name, S.currentAbsolutePath);
			S.error_weightVar_redefined.put(name, S.currentAbsolutePath);
		} 
		else {
					
			// / clearer data structure
			wt = new WeightTable();
			wt.weight = value;
			wt.fromWresl = S.currentAbsolutePath;
			S.wtMap.put(name, wt);

			S.wtList.add(name);
			
			if      (scope == Parameters.global){S.wtList_global.add(name);}
			else if (scope == Parameters.local) {S.wtList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void includeFile(String fileRelativePath, String scope)  {
		
		File absIncludeFile = new File(S.currentAbsoluteParent, fileRelativePath).getAbsoluteFile();
		String absIncludeFilePath = "Error with include file: "+fileRelativePath;
		try {
			absIncludeFilePath = absIncludeFile.getCanonicalPath().toLowerCase();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtils.errMsg("Include file IOException: " + fileRelativePath, S.currentAbsolutePath);
		}
		
		if (S.incFileList.contains(absIncludeFilePath)) {
			LogUtils.errMsg("Include file redefined: " + fileRelativePath, S.currentAbsolutePath);
			S.error_includeFile_redefined.add(absIncludeFilePath);

		} else {

			// /clearer data structure
			incFile = new IncludeFile();

			incFile.scope = scope;
			incFile.fromWresl = S.currentAbsolutePath;
			
			S.incFileList.add(absIncludeFilePath);
			
			S.incFileMap.put(absIncludeFilePath, incFile);
			
			if      (scope == Parameters.global){S.incFileList_global.add(absIncludeFilePath);}
			else if (scope == Parameters.local) {S.incFileList_local.add(absIncludeFilePath);}
			else{ LogUtils.errMsg("Include file scope undefined: "+fileRelativePath, S.currentAbsolutePath);}
			

		}
	}

	public void goalSimple(String name, String scope, String content) {
		if (S.gList.contains(name)) {
			LogUtils.errMsg("Goal redefined: "+name, S.currentAbsolutePath);
			S.error_goal_redefined.put(name, S.currentAbsolutePath);
		} else {
			//goal_scope.put(name, scope);
			//goal_simple.put(name, content);
			//S.var_all.put(name, "goal_simple");

			// / clearer data structure
			gl = new Goal();
			gl.scope = scope;
			// gl.lhs="in expression";
			gl.caseCondition.add(Parameters.always);
			gl.caseName.add(Parameters.defaultCaseName);
			gl.caseExpression.add(content);
			gl.case_lhs_gt_rhs.add(Parameters.skip);
			gl.case_lhs_lt_rhs.add(Parameters.skip);
			gl.fromWresl = S.currentAbsolutePath;
			S.gMap.put(name, gl);
			S.gList.add(name);
			
			if      (scope == Parameters.global){S.gList_global.add(name);}
			else if (scope == Parameters.local) {S.gList_local.add(name);}
			else{ System.out.println("wrong scope!!");}
		}
	}

	public void goalNoCase(String name, String scope, String lhs, String rhs,
			String lhs_gt_rhs, String lhs_lt_rhs) {
		if (S.gList.contains(name)) {
			LogUtils.errMsg("Goal redefined: "+name, S.currentAbsolutePath);
			S.error_goal_redefined.put(name, S.currentAbsolutePath);
		} else {
			// list.add(0,"lhs");list.add(1,lhs);
			// goal_scope.put(name, scope);
			// goal_no_case.put(name, list);
			S.var_all.put(name, "goal_no_case");

			// / clearer data structure
			gl = new Goal();
			gl.scope = scope;
			gl.lhs = lhs;
			gl.caseCondition.add("always");
			gl.caseName.add(Parameters.defaultCaseName);
			gl.caseExpression.add(lhs+" = "+rhs);
			gl.case_lhs_gt_rhs.add(lhs_gt_rhs);
			gl.case_lhs_lt_rhs.add(lhs_lt_rhs);
			gl.fromWresl = S.currentAbsolutePath;
			S.gMap.put(name, gl);
			S.gList.add(name);
			
			if      (scope == Parameters.global){S.gList_global.add(name);}
			else if (scope == Parameters.local) {S.gList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void goalCase(String name, String scope, String lhs, Goal gl) {
		if (S.gList.contains(name)) {
			LogUtils.errMsg("Goal redefined: "+name, S.currentAbsolutePath);
			S.error_goal_redefined.put(name, S.currentAbsolutePath);
		} else {
			//goal_scope.put(name, scope);
			S.var_all.put(name, "goal_cases");

			// / better data structure

			gl.scope = scope;
			gl.lhs = lhs;
			
			// combine lhs and rhs with " = "
	    	for (int i=0; i<gl.caseCondition.size(); i++){
	    		gl.caseExpression.set(i, lhs+" = "+gl.caseExpression.get(i)) ; //for EXPRESSION
	    	}
			
			gl.fromWresl = S.currentAbsolutePath;
			S.gMap.put(name, gl);
			S.gList.add(name);
			
			if      (scope == Parameters.global){S.gList_global.add(name);}
			else if (scope == Parameters.local) {S.gList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void svarCase(String svarName, String scope, Svar sv) {

		if (S.var_all.containsKey(svarName)) {
			LogUtils.errMsg("Svar redefined: "+svarName, S.currentAbsolutePath);
			S.error_var_redefined.put(svarName, "svar_cases");
		} else {
			S.var_all.put(svarName, "svar_cases");

			// ///////////////////
			sv.scope = scope;
			sv.fromWresl = S.currentAbsolutePath;
			S.svMap.put(svarName, sv);
			S.svList.add(svarName);
			
			if      (scope == Parameters.global){S.svList_global.add(svarName);}
			else if (scope == Parameters.local) {S.svList_local.add(svarName);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void external(String name, String scope, String externalType) {
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("External variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "external");
		} else {

			// / clearer data structure

			ex = new External();
			ex.type = externalType;
			ex.fromWresl = S.currentAbsolutePath;

			S.exMap.put(name, ex);
			S.exList.add(name);
			
			if      (scope == Parameters.global){S.exList_global.add(name);}
			else if (scope == Parameters.local) {S.exList_local.add(name);}
			else{ System.out.println("wrong scope!!");}
		}

	}
	
	public void svarExpression(String svarName, String scope, String expression) {
		if (S.var_all.containsKey(svarName)) {
			LogUtils.errMsg("State variable redefined: "+svarName, S.currentAbsolutePath);
			S.error_var_redefined.put(svarName, "svar_expression");
		} else {
			//svar_scope.put(svarName, scope);
			//svar_expression.put(svarName, expression);
			S.var_all.put(svarName, "svar_expression");

			// / clearer data structure

			String caseName = Parameters.defaultCaseName;
			String condition = Parameters.always;

			sv = new Svar();
			sv.scope = scope;
			sv.caseName.add(caseName);
			sv.caseCondition.add(condition);
			sv.caseExpression.add(expression);
			sv.fromWresl = S.currentAbsolutePath;

			S.svMap.put(svarName, sv);
			S.svList.add(svarName);
			
			if      (scope == Parameters.global){S.svList_global.add(svarName);}
			else if (scope == Parameters.local) {S.svList_local.add(svarName);}
			else{ System.out.println("wrong scope!!");}
		}

	}

	public void svarSum(String name, String scope, ArrayList<String> content,
			String sumStr) {
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("State variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_sum");
		} else {
			//svar_scope.put(name, scope);
			//svar_sum.put(name, content);
			S.var_all.put(name, "svar_sum");

			sv = new Svar();
			sv.scope = scope;
			sv.caseName.add(Parameters.defaultCaseName);
			sv.caseCondition.add("always");
			sv.caseExpression.add(sumStr);
			sv.fromWresl = S.currentAbsolutePath;

			S.svMap.put(name, sv);
			S.svList.add(name);
			
			if      (scope == Parameters.global){S.svList_global.add(name);}
			else if (scope == Parameters.local) {S.svList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void svarTable(String name, String scope, ArrayList<String> content,
			String sqlStr) {
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("State variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_table");
		} else {
			S.var_all.put(name, "svar_table");
			//svar_scope.put(name, scope);

			//list = new ArrayList<String>();
			// list.add(scope);
			//list.addAll(content);
			//svar_table.put(name, list);

			//list = new ArrayList<String>();
			// list.add(scope);
			//list.add(sqlStr);
			//svar_table_text.put(name, list);

			// / clearer data structure
			sv = new Svar();
			sv.scope = scope;
			sv.format = "lookup_table";
			sv.caseCondition.add("always");
			sv.caseName.add(Parameters.defaultCaseName);
			sv.caseExpression.add(sqlStr);
			sv.fromWresl = S.currentAbsolutePath;
			S.svMap.put(name, sv);
			S.svList.add(name);
			
			if      (scope == Parameters.global){S.svList_global.add(name);}
			else if (scope == Parameters.local) {S.svList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void svarDSS(String name, String scope, String b_part, String kind, String units, String convertToUnits) {
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("State variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_dss");
		} else {
			//svar_scope.put(name, scope);
			//svar_type.put(name, "timeseries");
			//list = new ArrayList<String>();
			//list.add(kind);
			//list.add(units);
			//svar_dss.put(name, list);
			S.var_all.put(name, "svar_dss");

			// / clearer data structure
			Svar sv = new Svar();
			sv.scope = scope;
			if (b_part!=null) sv.dssBPart = b_part; 
			sv.kind = kind;
			sv.units = units;
			if (convertToUnits!=null) {sv.convertToUnits = convertToUnits;}
			sv.format = "timeseries";
			sv.caseCondition.add("always");
			sv.caseName.add(Parameters.defaultCaseName);
			sv.caseExpression.add("timeseries");
			sv.fromWresl = S.currentAbsolutePath;
			S.svMap.put(name, sv);
			S.svList.add(name);
			
			if      (scope == Parameters.global){S.svList_global.add(name);}
			else if (scope == Parameters.local) {S.svList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void dvarStd(String name, String scope, String integer, String kind, String units) {
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("Dvar redefined: "+name, "\n"+S.currentAbsolutePath);
			S.error_var_redefined.put(name, "dvar_std");
		} else {

			S.var_all.put(name, "dvar_std");

			// / better data structure
			dv = new Dvar();
			dv.scope = scope;
			if (integer != null) {dv.integer = "Y";}
			dv.kind = kind;
			dv.units = units;
			dv.lowerBound = Parameters.dv_lowerBound;
			dv.upperBound = Parameters.dv_upperBound;
			dv.fromWresl = S.currentAbsolutePath;
			
			S.dvMap.put(name, dv);
			S.dvList.add(name);
			
			if      (scope == Parameters.global){S.dvList_global.add(name);}
			else if (scope == Parameters.local) {S.dvList_local.add(name);}
			else{ LogUtils.errMsg("Dvar scope undefined: "+name, S.currentAbsolutePath);}

		}
	}

	public void alias(String name, String scope, String kind, String units,
			String alias) {
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("Alias redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "dvar_alias");
		} else {
			//dvar_scope.put(name, scope);
			//list = new ArrayList<String>();
			//list.add(kind);
			//list.add(units);
			//list.add(alias);
			//dvar_alias.put(name, list);
			S.var_all.put(name, "dvar_alias");

			// / better data structure
			as = new Alias();
			as.scope = scope;
			if (kind != null)
				as.kind = kind;
			if (units != null)
				as.units = units;
			as.expression = alias;
			as.fromWresl = S.currentAbsolutePath;
			S.asMap.put(name, as);
			S.asList.add(name);
			
			if      (scope == Parameters.global){S.asList_global.add(name);}
			else if (scope == Parameters.local) {S.asList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void dvarNonStd(String name, String scope, String kind,
			String units,  String lowerBound,
			String upperBound) {
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("Dvar redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "dvar_nonstd");
		} else {
			//dvar_scope.put(name, scope);
			//list = new ArrayList<String>();
			// list.add(scope);
			//list.add(kind);
			//list.add(units);
			//list.addAll(content);
			//dvar_nonstd.put(name, list);
			S.var_all.put(name, "dvar_nonstd");

			// / better data structure
			dv = new Dvar();
			dv.scope = scope;
			dv.kind = kind;
			dv.units = units;
			dv.lowerBound = lowerBound;
			dv.upperBound = upperBound;
			dv.fromWresl = S.currentAbsolutePath;
			S.dvMap.put(name, dv);
			S.dvList.add(name);
			
			if      (scope == Parameters.global){S.dvList_global.add(name);}
			else if (scope == Parameters.local) {S.dvList_local.add(name);}
			else{ LogUtils.errMsg("Dvar scope undefined: "+name, S.currentAbsolutePath);}

		}
	}

	public void sequenceOrder(String sequenceName, String order,
			String modelName, String condition) {

		Integer i = Integer.parseInt(order);

		if (S.seqList.contains(sequenceName)) {
			S.error_sequence_redefined.add(sequenceName);
		} else if (S.seqMap.containsKey(i)) {
			S.error_sequence_order_redefined.add(i);
		} else {
			
			seq = new Sequence();
			seq.sequenceName = sequenceName;
			if (condition!=null) seq.condition = condition;
			seq.modelName = modelName;
			seq.fromWresl = S.currentAbsolutePath;
			S.seqMap.put(i, seq);
			S.seqList.add(sequenceName);

		}

	}
}
