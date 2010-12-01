package evaluators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Struct {

	//public String inFile_or_inModel;
	
	public Map<String, String> sequence_orders = new HashMap<String, String>();

	/// errors
	public Map<String, String> error_sequence_order_redefined = new HashMap<String, String>();
	public Map<String, String> error_var_redefined = new HashMap<String, String>();
	public ArrayList<String> error_model_redefined = new ArrayList<String>();
	
	
	//public Map<String, String> error_file_contains_redefined = new HashMap<String, String>();
	
	public Map<String, String> svar_expression = new HashMap<String, String>();


	public Map<String, ArrayList<String>> dvar_nonstd = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> dvar_std = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> dvar_alias = new HashMap<String, ArrayList<String>>();

	public Map<String, ArrayList<String>> svar_table = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_dss = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_sum = new HashMap<String, ArrayList<String>>();

	/// variable and scope
	public Map<String, String> var_all = new HashMap<String, String>();
	public Map<String, String> var_scope = new HashMap<String, String>();
	public Map<String, String> include_file_scope = new HashMap<String, String>();
	
	/// models in a file
	public ArrayList<String> model_list = new ArrayList<String>();	
	
	/// svar_cases
	public Map<String, ArrayList<String>> svar_cases = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_conditions = new HashMap<String, ArrayList<String>>();
	public Map<String, Map<String, ArrayList<String>>> svar_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();

	/// goal
	public Map<String, String> goal_simple = new HashMap<String, String>();
	public Map<String, ArrayList<String>> goal_no_case = new HashMap<String, ArrayList<String>>();
	
	/// goal_cases
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
	
	///dummy var
	private ArrayList<String> list;

	public void modelList(String name ) {
		if (model_list.contains(name)) {
			error_model_redefined.add(name);
		} else {				
				//file_include_file.get(name).add(filePath);
				model_list.add(name);
				var_all.put(name, "model");
		}
	}		
	
	public void includeFile(String filePath, String scope ) {
		if (var_all.containsKey(filePath)) {
			error_var_redefined.put(filePath, "include");
		} else {				
				//file_include_file.get(name).add(filePath);
				include_file_scope.put(filePath, scope);
				var_all.put(filePath, "include");
		}
	}	
	
	public void goalSimple( String name, String scope, String content) {
		if (var_all.containsKey(name)) {
			// System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "goal_simple");
		} else {
			var_scope.put(name, scope);
			goal_simple.put(name, content);
			var_all.put(name, "goal_simple");

		}
	}
	
	public void goalNoCase(String name, String scope, String lhs, ArrayList<String> list) {
		if (var_all.containsKey(name)) {
			// System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "goal_no_case");
		} else {
			list.add(0,"lhs");list.add(1,lhs);
			var_scope.put(name, scope);
			goal_no_case.put(name, list);
			var_all.put(name, "goal_no_case");
		}
	}

	public void goalCase(String goalName, String scope, String lhs, ArrayList<String> caseName, ArrayList<String> condition, Map<String, ArrayList<String>> caseContent) {
		if (var_all.containsKey(goalName)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(goalName, "goal_cases");
			}
			else {
			var_scope.put(goalName, scope);
			goal_cases.put(goalName, caseName);
			goal_lhs.put(goalName, lhs);
			goal_conditions.put(goalName, condition);
			goal_map_case_content.put(goalName, caseContent);
			var_all.put(goalName, "goal_cases");
			}
	}	

	public void svarCase(String svarName, String scope, ArrayList<String> caseName, ArrayList<String> condition, Map<String, ArrayList<String>> caseContent) {
		if (var_all.containsKey(svarName)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(svarName, "svar_cases");
			}
			else {
		    var_scope.put(svarName, scope);
			svar_cases.put(svarName, caseName);
			svar_conditions.put(svarName, condition);
			svar_map_case_content.put(svarName, caseContent);
			var_all.put(svarName, "svar_cases");
			}
	}		
	
	public void svarExpression(String name, String scope, String content) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_expression");
			}
			else {
			var_scope.put(name, scope);	
			svar_expression.put(name, content);
			var_all.put(name, "svar_expression");
			}
	}	
	
	public void svarSum(String name, String scope, ArrayList<String> content) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_sum");
			}
			else {
			var_scope.put(name, scope);
			svar_sum.put(name, content);
			var_all.put(name, "svar_sum");
			}
	}	

	public void svarTable(String name, String scope, ArrayList<String> content) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_table");
			}
			else {
			var_scope.put(name, scope);	
			svar_table.put(name, content);
			var_all.put(name, "svar_table");
			}
	}		

	public void svarDSS(String name, String scope, String kind, String units) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_dss");
			}
			else {
			var_scope.put(name, scope);		
				list = new ArrayList<String>();
				list.add(kind);
				list.add(units);	
			svar_dss.put(name, list);
			var_all.put(name, "svar_dss");
			}
	}		

	public void dvarStd(String name, String scope, String kind, String units) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "dvar_std");
			}
			else {
			var_scope.put(name, scope);		
				list = new ArrayList<String>();
				list.add(kind);
				list.add(units);	
			dvar_std.put(name, list);
			var_all.put(name, "dvar_std");
			}
	}		

	public void dvarAlias(String name, String scope, String kind, String units, String alias) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "dvar_alias");
			}
			else {
				var_scope.put(name, scope);	
				list = new ArrayList<String>();
				list.add(kind);
				list.add(units);
				list.add(alias);
			dvar_alias.put(name, list);
			var_all.put(name, "dvar_alias");
			}
	}	

	public void dvarNonStd(String name, String scope, String kind, String units, ArrayList<String> content) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "dvar_nonstd");
			}
			else {
				var_scope.put(name, scope);	
				list = new ArrayList<String>();
				list.add(kind);
				list.add(units);
				list.addAll(content);
			dvar_nonstd.put(name, list);
			var_all.put(name, "dvar_nonstd");
			}
	}		
	
	public void sequenceOrder(String order, String modelName) {	
	if (sequence_orders.containsKey(order)){
		//System.out.println("error... variable redefined: " + $i.text);
		error_sequence_order_redefined.put(order, modelName);
		}
		else {
		sequence_orders.put(order, modelName);
		}
	}
	
}
