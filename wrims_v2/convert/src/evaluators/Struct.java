package evaluators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Struct {

	public String currentAbsolutePath;
	public String currentAbsoluteParent;

	// / models appear in this parsed file
	public ArrayList<String> model_list = new ArrayList<String>();
	public ArrayList<String> error_model_redefined = new ArrayList<String>();

	// / sequence
	public Map<Integer, String> sequence_map = new HashMap<Integer, String>();
	public ArrayList<Integer> error_model_order_redefined = new ArrayList<Integer>();

	public ArrayList<String> sequence_list = new ArrayList<String>();
	public ArrayList<String> error_sequence_redefined = new ArrayList<String>();

	// / includeFile data structure
	public IncludeFile incFile;
	public ArrayList<String> incFileList = new ArrayList<String>();
	public ArrayList<String> incFileList_global = new ArrayList<String>();
	public ArrayList<String> incFileList_local = new ArrayList<String>();
	public Map<String, IncludeFile> incFileMap = new HashMap<String, IncludeFile>();
	public ArrayList<String> error_includeFile_redefined = new ArrayList<String>();

	// / external function structure
	public External ex;
	public ArrayList<String> exList = new ArrayList<String>();
	public ArrayList<String> exList_global = new ArrayList<String>();
	public ArrayList<String> exList_local = new ArrayList<String>();
	public Map<String, External> exMap = new HashMap<String, External>();
	
	// / svar data structure
	public Svar sv;
	public ArrayList<String> svList = new ArrayList<String>();
	public ArrayList<String> svList_global = new ArrayList<String>();
	public ArrayList<String> svList_local = new ArrayList<String>();
	public Map<String, Svar> svMap = new HashMap<String, Svar>();

	// / dvar data structure
	public Dvar dv;
	public ArrayList<String> dvList = new ArrayList<String>();
	public ArrayList<String> dvList_global = new ArrayList<String>();
	public ArrayList<String> dvList_local = new ArrayList<String>();
	public Map<String, Dvar> dvMap = new HashMap<String, Dvar>();

	// / alias data structure
	public Alias as;
	public ArrayList<String> asList = new ArrayList<String>();
	public ArrayList<String> asList_global = new ArrayList<String>();
	public ArrayList<String> asList_local = new ArrayList<String>();
	public Map<String, Alias> asMap = new HashMap<String, Alias>();

	// / goal data structure
	public Goal gl;
	public ArrayList<String> gList = new ArrayList<String>();
	public ArrayList<String> gList_global = new ArrayList<String>();
	public ArrayList<String> gList_local = new ArrayList<String>();
	public Map<String, Goal> gMap = new HashMap<String, Goal>();

	// / errors
	public Map<String, String> error_var_redefined = new HashMap<String, String>();

	public Map<String, String> svar_expression = new HashMap<String, String>();

	public Map<String, ArrayList<String>> dvar_nonstd = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> dvar_std = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> dvar_alias = new HashMap<String, ArrayList<String>>();

	public Map<String, ArrayList<String>> svar_table_text = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_table = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_dss = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_sum = new HashMap<String, ArrayList<String>>();

	// / variable, scope, and type, units
	public Map<String, String> var_all = new HashMap<String, String>();
	public Map<String, String> svar_scope = new HashMap<String, String>();
	public Map<String, String> svar_type = new HashMap<String, String>();
	public Map<String, String> dvar_scope = new HashMap<String, String>();
	public Map<String, String> goal_scope = new HashMap<String, String>();
	public Map<String, String> include_file_scope = new HashMap<String, String>();

	public Map<String, ArrayList<String>> svar_type_units = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> dvar_type_units = new HashMap<String, ArrayList<String>>();

	// / models in a file

	// / svar_cases
	public Map<String, ArrayList<String>> svar_cases = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_conditions = new HashMap<String, ArrayList<String>>();
	public Map<String, Map<String, ArrayList<String>>> svar_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();

	// / goal
	public Map<String, String> goal_simple = new HashMap<String, String>();
	public Map<String, ArrayList<String>> goal_no_case = new HashMap<String, ArrayList<String>>();

	// / goal_cases
	public Map<String, String> goal_lhs = new HashMap<String, String>();
	public Map<String, ArrayList<String>> goal_cases = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> goal_conditions = new HashMap<String, ArrayList<String>>();
	public Map<String, Map<String, ArrayList<String>>> goal_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();

	private static String[] keys = { "define", "goal" };
	private static String[] mons = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
			"JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	public static List<String> r_keys = Arrays.asList(keys);
	public static List<String> r_mons = Arrays.asList(mons);

	// public static List<String> reserved_words = new ArrayList<String>() {{
	// addAll(r_keys); addAll(r_mons); }};

	// /dummy var
	private ArrayList<String> list;

	// public Struct(String currentFilePath){
	// this.currentFilePath = currentFilePath;
	// }

	public void modelList(String name) {
		if (model_list.contains(name)) {
			ErrMsg.print("Model redefined: "+name, currentAbsolutePath);
			error_model_redefined.add(name);
		} else {
			// file_include_file.get(name).add(filePath);
			model_list.add(name);
			var_all.put(name, "model");
		}
	}

	public void includeFile(String fileRelativePath, String scope)  {
		
		File absFile = new File(currentAbsoluteParent, fileRelativePath).getAbsoluteFile();
		String absFilePath = "Error with include file: "+fileRelativePath;
		try {
			absFilePath = absFile.getCanonicalPath().toLowerCase();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String absFilePath = absFile.getAbsolutePath().toLowerCase();
		
		//System.out.println("check: "+absFilePath);
		
		if (incFileList.contains(absFilePath)) {
			ErrMsg.print("Include file redefined: " + fileRelativePath, currentAbsolutePath);
			error_includeFile_redefined.add(absFilePath);

		} else {

			// /clearer data structure
			incFile = new IncludeFile();

			incFile.scope = scope;
			incFileList.add(absFilePath);
			
			incFileMap.put(absFilePath, incFile);
			
			if      (scope == "global"){incFileList_global.add(absFilePath);}
			else if (scope == "local") {incFileList_local.add(absFilePath);}
			else{ System.out.println("wrong scope!!");}
			

		}
	}

	public void goalSimple(String name, String scope, String content) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Goal redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "goal_simple");
		} else {
			goal_scope.put(name, scope);
			goal_simple.put(name, content);
			var_all.put(name, "goal_simple");

			// / clearer data structure
			gl = new Goal();
			gl.scope = scope;
			// gl.lhs="in expression";
			gl.caseCondition.add("always");
			gl.caseName.add("default");
			gl.caseExpression.add(content);
			gl.case_lhs_gt_rhs.add("constrain");
			gl.case_lhs_lt_rhs.add("constrain");
			gl.fromWresl = currentAbsolutePath;
			gMap.put(name, gl);
			gList.add(name);
			
			if      (scope == "global"){gList_global.add(name);}
			else if (scope == "local") {gList_local.add(name);}
			else{ System.out.println("wrong scope!!");}
		}
	}

	public void goalNoCase(String name, String scope, String lhs, String rhs,
			String lhs_gt_rhs, String lhs_lt_rhs) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Goal redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "goal_no_case");
		} else {
			// list.add(0,"lhs");list.add(1,lhs);
			// goal_scope.put(name, scope);
			// goal_no_case.put(name, list);
			var_all.put(name, "goal_no_case");

			// / clearer data structure
			gl = new Goal();
			gl.scope = scope;
			gl.lhs = lhs;
			gl.caseCondition.add("always");
			gl.caseName.add("default");
			gl.caseExpression.add(rhs);
			gl.case_lhs_gt_rhs.add(lhs_gt_rhs);
			gl.case_lhs_lt_rhs.add(lhs_lt_rhs);
			gl.fromWresl = currentAbsolutePath;
			gMap.put(name, gl);
			gList.add(name);
			
			if      (scope == "global"){gList_global.add(name);}
			else if (scope == "local") {gList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void goalCase(String name, String scope, String lhs, Goal gl) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Goal redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "goal_cases");
		} else {
			goal_scope.put(name, scope);
			var_all.put(name, "goal_cases");

			// / better data structure

			gl.scope = scope;
			gl.lhs = lhs;
			gl.fromWresl = currentAbsolutePath;
			gMap.put(name, gl);
			gList.add(name);
			
			if      (scope == "global"){gList_global.add(name);}
			else if (scope == "local") {gList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void svarCase(String svarName, String scope, Svar sv,
			ArrayList<String> caseName, ArrayList<String> condition,
			ArrayList<String> expression,
			Map<String, ArrayList<String>> caseContent) {

		if (var_all.containsKey(svarName)) {
			ErrMsg.print("Svar redefined: "+svarName, currentAbsolutePath);
			error_var_redefined.put(svarName, "svar_cases");
		} else {
			svar_scope.put(svarName, scope);
			svar_cases.put(svarName, caseName);
			svar_conditions.put(svarName, condition);
			svar_map_case_content.put(svarName, caseContent);
			var_all.put(svarName, "svar_cases");

			// ///////////////////
			sv.scope = scope;
			sv.fromWresl = currentAbsolutePath;
			svMap.put(svarName, sv);
			svList.add(svarName);
			
			if      (scope == "global"){svList_global.add(svarName);}
			else if (scope == "local") {svList_local.add(svarName);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void external(String name, String scope, String externalType) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Svar redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "external");
		} else {

			// / clearer data structure

			ex = new External();
			ex.type = externalType;
			ex.fromWresl = currentAbsolutePath;

			exMap.put(name, ex);
			exList.add(name);
			
			if      (scope == "global"){exList_global.add(name);}
			else if (scope == "local") {exList_local.add(name);}
			else{ System.out.println("wrong scope!!");}
		}

	}
	
	public void svarExpression(String svarName, String scope, String expression) {
		if (var_all.containsKey(svarName)) {
			ErrMsg.print("Svar redefined: "+svarName, currentAbsolutePath);
			error_var_redefined.put(svarName, "svar_expression");
		} else {
			svar_scope.put(svarName, scope);
			svar_expression.put(svarName, expression);
			var_all.put(svarName, "svar_expression");

			// / clearer data structure

			String caseName = "default";
			String condition = "always";

			sv = new Svar();
			sv.scope = scope;
			sv.caseName.add(caseName);
			sv.caseCondition.add(condition);
			sv.caseExpression.add(expression);
			sv.fromWresl = currentAbsolutePath;

			svMap.put(svarName, sv);
			svList.add(svarName);
			
			if      (scope == "global"){svList_global.add(svarName);}
			else if (scope == "local") {svList_local.add(svarName);}
			else{ System.out.println("wrong scope!!");}
		}

	}

	public void svarSum(String name, String scope, ArrayList<String> content,
			String sumStr) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Svar redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "svar_sum");
		} else {
			svar_scope.put(name, scope);
			svar_sum.put(name, content);
			var_all.put(name, "svar_sum");

			sv = new Svar();
			sv.scope = scope;
			sv.caseName.add("default");
			sv.caseCondition.add("always");
			sv.caseExpression.add(sumStr);
			sv.fromWresl = currentAbsolutePath;

			svMap.put(name, sv);
			svList.add(name);
			
			if      (scope == "global"){svList_global.add(name);}
			else if (scope == "local") {svList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void svarTable(String name, String scope, ArrayList<String> content,
			String sqlStr) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Svar redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "svar_table");
		} else {
			var_all.put(name, "svar_table");
			svar_scope.put(name, scope);

			list = new ArrayList<String>();
			// list.add(scope);
			list.addAll(content);
			svar_table.put(name, list);

			list = new ArrayList<String>();
			// list.add(scope);
			list.add(sqlStr);
			svar_table_text.put(name, list);

			// / clearer data structure
			sv = new Svar();
			sv.scope = scope;
			sv.format = "lookup_table";
			sv.caseCondition.add("always");
			sv.caseName.add("default");
			sv.caseExpression.add(sqlStr);
			sv.fromWresl = currentAbsolutePath;
			svMap.put(name, sv);
			svList.add(name);
			
			if      (scope == "global"){svList_global.add(name);}
			else if (scope == "local") {svList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void svarDSS(String name, String scope, String b_part, String kind, String units, String convertToUnits) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Svar redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "svar_dss");
		} else {
			svar_scope.put(name, scope);
			svar_type.put(name, "timeseries");
			list = new ArrayList<String>();
			list.add(kind);
			list.add(units);
			svar_dss.put(name, list);
			var_all.put(name, "svar_dss");

			// / clearer data structure
			Svar sv = new Svar();
			sv.scope = scope;
			if (b_part!=null) sv.dssBPart = b_part; 
			sv.kind = kind;
			sv.units = units;
			if (convertToUnits!=null) {sv.convertToUnits = convertToUnits;}
			sv.format = "timeseries";
			sv.caseCondition.add("always");
			sv.caseName.add("default");
			sv.caseExpression.add("timeseries");
			sv.fromWresl = currentAbsolutePath;
			svMap.put(name, sv);
			svList.add(name);
			
			if      (scope == "global"){svList_global.add(name);}
			else if (scope == "local") {svList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void dvarStd(String name, String scope, String integer, String kind, String units) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Dvar redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "dvar_std");
		} else {
			dvar_scope.put(name, scope);
			list = new ArrayList<String>();
			// list.add(scope);
			list.add(kind);
			list.add(units);
			list.add("0");
			list.add("unbounded");
			dvar_std.put(name, list);
			var_all.put(name, "dvar_std");

			// / better data structure
			dv = new Dvar();
			dv.scope = scope;
			if (integer != null) {dv.integer = "Y";}
			dv.kind = kind;
			dv.units = units;
			dv.lowerBound = Parameters.dv_lowerBound;
			dv.upperBound = Parameters.dv_upperBound;
			dv.fromWresl = currentAbsolutePath;
			dvMap.put(name, dv);
			dvList.add(name);
			
			if      (scope == "global"){dvList_global.add(name);}
			else if (scope == "local") {dvList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void alias(String name, String scope, String kind, String units,
			String alias) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Alias redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "dvar_alias");
		} else {
			dvar_scope.put(name, scope);
			list = new ArrayList<String>();
			list.add(kind);
			list.add(units);
			list.add(alias);
			dvar_alias.put(name, list);
			var_all.put(name, "dvar_alias");

			// / better data structure
			as = new Alias();
			as.scope = scope;
			if (kind != null)
				as.kind = kind;
			if (units != null)
				as.units = units;
			as.expression = alias;
			as.fromWresl = currentAbsolutePath;
			asMap.put(name, as);
			asList.add(name);
			
			if      (scope == "global"){asList_global.add(name);}
			else if (scope == "local") {asList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void dvarNonStd(String name, String scope, String kind,
			String units, ArrayList<String> content, String lowerBound,
			String upperBound) {
		if (var_all.containsKey(name)) {
			ErrMsg.print("Dvar redefined: "+name, currentAbsolutePath);
			error_var_redefined.put(name, "dvar_nonstd");
		} else {
			dvar_scope.put(name, scope);
			list = new ArrayList<String>();
			// list.add(scope);
			list.add(kind);
			list.add(units);
			list.addAll(content);
			dvar_nonstd.put(name, list);
			var_all.put(name, "dvar_nonstd");

			// / better data structure
			dv = new Dvar();
			dv.scope = scope;
			dv.kind = kind;
			dv.units = units;
			dv.lowerBound = lowerBound;
			dv.upperBound = upperBound;
			dv.fromWresl = currentAbsolutePath;
			dvMap.put(name, dv);
			dvList.add(name);
			
			if      (scope == "global"){dvList_global.add(name);}
			else if (scope == "local") {dvList_local.add(name);}
			else{ System.out.println("wrong scope!!");}

		}
	}

	public void sequenceOrder(String sequenceName, String order,
			String modelName) {

		Integer i = Integer.parseInt(order);

		if (sequence_list.contains(sequenceName)) {
			error_sequence_redefined.add(sequenceName);
		} else if (sequence_map.containsKey(i)) {
			error_model_order_redefined.add(i);
		} else {
			sequence_map.put(i, modelName);
			sequence_list.add(sequenceName);
		}

	}
}
