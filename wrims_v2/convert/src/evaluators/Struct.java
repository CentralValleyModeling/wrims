package evaluators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xml.internal.security.utils.Constants;

public class Struct {

	
	/// svar data structure
	public Svar sv; 
	public ArrayList<String> svList = new ArrayList<String>(); 
	public Map<String,Svar> svMap = new HashMap<String,Svar>(); 

	/// dvar data structure
	public Dvar dv; 
	public ArrayList<String> dvList = new ArrayList<String>(); 
	public Map<String,Dvar> dvMap = new HashMap<String,Dvar>(); 
	
	/// alias data structure
	public Alias as; 
	public ArrayList<String> asList = new ArrayList<String>(); 
	public Map<String,Alias> asMap = new HashMap<String,Alias>(); 
	

//	/// svar data structure
//	public SvarProps svarProps ; 
//	public ArrayList<SvarProps> svarPropsList ; 
//	public Map<String,SvarProps> svarMapSimple = new HashMap<String,SvarProps>(); 
//	public Map<String,ArrayList<SvarProps>> svarMap = new HashMap<String,ArrayList<SvarProps>>(); 
	
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

	public Map<String, ArrayList<String>> svar_table_text = new HashMap<String, ArrayList<String>>(); 
	public Map<String, ArrayList<String>> svar_table = new HashMap<String, ArrayList<String>>();	
	public Map<String, ArrayList<String>> svar_dss = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> svar_sum = new HashMap<String, ArrayList<String>>();

	/// variable, scope, and type, units
	public Map<String, String> var_all = new HashMap<String, String>();
	public Map<String, String> svar_scope = new HashMap<String, String>();
	public Map<String, String> svar_type = new HashMap<String, String>();
	public Map<String, String> dvar_scope = new HashMap<String, String>();
	public Map<String, String> goal_scope = new HashMap<String, String>();
	public Map<String, String> include_file_scope = new HashMap<String, String>();

	public Map<String, ArrayList<String>> svar_type_units = new HashMap<String, ArrayList<String>>(); 
	public Map<String, ArrayList<String>> dvar_type_units = new HashMap<String, ArrayList<String>>(); 

	
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
			goal_scope.put(name, scope);
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
			goal_scope.put(name, scope);
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
			goal_scope.put(goalName, scope);
			goal_cases.put(goalName, caseName);
			goal_lhs.put(goalName, lhs);
			goal_conditions.put(goalName, condition);
			goal_map_case_content.put(goalName, caseContent);
			var_all.put(goalName, "goal_cases");
			}
	}	

	public void svarCase(String svarName, String scope, Svar sv, ArrayList<String> caseName, ArrayList<String> condition, ArrayList<String> expression, Map<String, ArrayList<String>> caseContent) {

		if (var_all.containsKey(svarName)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(svarName, "svar_cases");
			}
			else {
		    svar_scope.put(svarName, scope);
			svar_cases.put(svarName, caseName);
			svar_conditions.put(svarName, condition);
			svar_map_case_content.put(svarName, caseContent);
			var_all.put(svarName, "svar_cases");
			

			
            /////////////////////
			sv.scope = scope;
			svMap.put(svarName, sv);
			svList.add(svarName);
			
//			svarProps = new SvarProps();
//			
//			for ( int i = 0; i< caseName.size();i++) {
//			
//			svarProps.caseName=caseName.get(i);
//			svarProps.caseCondition=condition.get(i);
//			svarProps.caseExpression=expression.get(i);
//
//			}
//			svarPropsList = new ArrayList<SvarProps>();
//			svarPropsList.add(svarProps);
//			svarMap.put(svarName, svarPropsList);
//			
			}
	}		
	
	public void svarExpression(String svarName, String scope, String expression) {
		if (var_all.containsKey(svarName)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(svarName, "svar_expression");
			}
			else {
			svar_scope.put(svarName, scope);	
			svar_expression.put(svarName, expression);
			var_all.put(svarName, "svar_expression");
			
			
			String caseName = "default";
			String condition = "always";
			
			
			
			sv = new Svar();
			sv.caseName.add(caseName);
			sv.caseCondition.add(condition);
			sv.caseExpression.add(expression);
			
			svMap.put(svarName, sv);
			svList.add(svarName);
			}
			
	}	
	
	public void svarSum(String name, String scope, ArrayList<String> content, String sumStr) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_sum");
			}
			else {
			svar_scope.put(name, scope);
			svar_sum.put(name, content);
			var_all.put(name, "svar_sum");
			
			sv = new Svar();
			sv.caseName.add("default");
			sv.caseCondition.add("always");
			sv.caseExpression.add(sumStr);
			
			svMap.put(name, sv);
			svList.add(name);
			
			
			}
	}	

	public void svarTable(String name, String scope, ArrayList<String> content, String sqlStr) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_table");
			}
			else {
				var_all.put(name, "svar_table");
				svar_scope.put(name, scope);	
			
			list = new ArrayList<String>();
			//list.add(scope);
			list.addAll(content);
			svar_table.put(name, list);

			list = new ArrayList<String>();
			//list.add(scope);
			list.add(sqlStr);
			svar_table_text.put(name, list);
			
			/// clearer data structure
			sv = new Svar();
			sv.scope=scope;
			sv.format="lookup_table";
			sv.caseCondition.add("always");
			sv.caseName.add("default");
			sv.caseExpression.add(sqlStr);
			svMap.put(name, sv);
			svList.add(name);
			

			}
	}		

	public void svarDSS(String name, String scope, String kind, String units) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "svar_dss");
			}
			else {
			svar_scope.put(name, scope);
			svar_type.put(name, "timeseries");
				list = new ArrayList<String>();
				list.add(kind);
				list.add(units);	
			svar_dss.put(name, list);
			var_all.put(name, "svar_dss");

			/// clearer data structure
			Svar sv = new Svar();
			sv.scope=scope;
			sv.kind=kind;
			sv.units=units;
			sv.format="timeseries";
			sv.caseCondition.add("always");
			sv.caseName.add("default");
			sv.caseExpression.add("timeseries");
			svMap.put(name, sv);
			svList.add(name);
			
			}
	}		

	public void dvarStd(String name, String scope, String kind, String units) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "dvar_std");
			}
			else {
			dvar_scope.put(name, scope);		
				list = new ArrayList<String>();
				//list.add(scope);
				list.add(kind);
				list.add(units);
				list.add("0");
				list.add("unbounded");
			dvar_std.put(name, list);
			var_all.put(name, "dvar_std");
			
			
			/// better data structure
			dv = new Dvar();
			dv.scope=scope;
			dv.kind=kind;
			dv.units=units;
			dv.lowerBound=Parameters.dv_lowerBound;
			dv.upperBound=Parameters.dv_upperBound;			
			dvMap.put(name, dv);
			dvList.add(name);
			
			}
	}		

	public void dvarAlias(String name, String scope, String kind, String units, String alias) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "dvar_alias");
			}
			else {
				dvar_scope.put(name, scope);	
				list = new ArrayList<String>();
				list.add(kind);
				list.add(units);
				list.add(alias);
			dvar_alias.put(name, list);
			var_all.put(name, "dvar_alias");
			
			/// better data structure
			as = new Alias();
			as.scope=scope;
			as.kind=kind;
			as.units=units;
			as.expression=alias;		
			asMap.put(name, as);
			asList.add(name);			
			
			
			}
	}	

	public void dvarNonStd(String name, String scope, String kind, String units, ArrayList<String> content,
			               String lowerBound, String upperBound) {
		if (var_all.containsKey(name)){
			//System.out.println("error... variable redefined: " + $i.text);
			error_var_redefined.put(name, "dvar_nonstd");
			}
			else {
				dvar_scope.put(name, scope);	
				list = new ArrayList<String>();
				//list.add(scope);
				list.add(kind);
				list.add(units);
				list.addAll(content);
			dvar_nonstd.put(name, list);
			var_all.put(name, "dvar_nonstd");
			
			/// better data structure
			dv = new Dvar();
			dv.scope=scope;
			dv.kind=kind;
			dv.units=units;
			dv.lowerBound=lowerBound;
			dv.upperBound=upperBound;			
			dvMap.put(name, dv);
			dvList.add(name);
			
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
