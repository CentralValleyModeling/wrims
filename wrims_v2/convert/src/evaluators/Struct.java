package evaluators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Struct {

	public Map<String, ArrayList<String>> model_var_adhoc = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> model_include_files = new HashMap<String, ArrayList<String>>();
	
	public Map<String, String> sequence_orders = new HashMap<String, String>();
	public Map<String, String> error_sequence_order_redefined = new HashMap<String, String>();
	public Map<String, String> error_var_redefined = new HashMap<String, String>();
	public Map<String, String> var_all = new HashMap<String, String>();
	public Map<String, String> svar_expression = new HashMap<String, String>();
	public Map<String, String> goal_simple = new HashMap<String, String>();

	public Map<String, ArrayList<String>> dvar_nonstd = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> dvar_std = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> dvar_alias = new HashMap<String, ArrayList<String>>();

	public Map<String, ArrayList<String>> svar_table = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_dss = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_sum = new HashMap<String, ArrayList<String>>();

	/// svar_cases
	public Map<String, ArrayList<String>> svar_cases = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_conditions = new HashMap<String, ArrayList<String>>();
	public Map<String, Map<String, ArrayList<String>>> svar_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();

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

	public void goalSimple(String name, String content) {
		if (var_all.containsKey(name)) {
			// System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "goal_simple");
		} else {
			goal_simple.put(name, content);
			var_all.put(name, "goal_simple");
		}
	}
	
	
	public void svarExpression(String name, String content) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_expression");
			}
			else {
			svar_expression.put(name, content);
			var_all.put(name, "svar_expression");
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
