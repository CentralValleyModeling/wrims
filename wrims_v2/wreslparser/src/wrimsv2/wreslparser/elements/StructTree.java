package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;

public class StructTree {
	
	public SimulationDataSet S;



	// / models appear in this parsed file
	//public ArrayList<String> model_list = new ArrayList<String>();
	//public ArrayList<String> error_model_redefined = new ArrayList<String>();

	// / weight table   // <objName,  <itemName, value>>
	public WeightElement wt;

	public Sequence seq;

	public IncludeFile incFile;

	// / external function structure
	public External ex;

	public Timeseries svTs;
	
	public Svar sv;

	public Dvar dv;

	public Alias as;

	public Goal gl;


	private static String[] keys = { "define", "goal" };
	private static String[] mons = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
			"JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	public static List<String> r_keys = Arrays.asList(keys);
	public static List<String> r_mons = Arrays.asList(mons);

	// public static List<String> reserved_words = new ArrayList<String>() {{
	// addAll(r_keys); addAll(r_mons); }};

	public void modelList(String name) {
		
		name = name.toLowerCase();
		
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
		
		name = name.toLowerCase();
		value = value.toLowerCase();
		
		if (S.wtList.contains(name)) {
			LogUtils.errMsg("Weight table variable redefined: "+name, S.currentAbsolutePath);
			S.error_weightVar_redefined.put(name, S.currentAbsolutePath);
		} 
		else {
					
			// / clearer data structure
			wt = new WeightElement();
			wt.weight = value;
			wt.fromWresl = S.currentAbsolutePath;
			S.wtMap.put(name, wt);

			S.wtList.add(name);
			S.wtSet.add(name);
			
			if      (scope == null)
					{S.wtList_global.add(name);S.wtSet_global.add(name);}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.wtList_local.add(name);S.wtSet_local.add(name);}
			else{ LogUtils.errMsg("Weight table scope undefined: "+name, S.currentAbsolutePath);}

		}
	}

	public void includeFile(String fileRelativePath, String scope)  {
		
		fileRelativePath = fileRelativePath.toLowerCase();
		
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

			//incFile.scope = scope;
			incFile.fromWresl = S.currentAbsolutePath;
						
			S.incFileMap.put(absIncludeFilePath, incFile);
			S.incFileList.add(absIncludeFilePath);
			S.svTsDvFileList.add(absIncludeFilePath);
			S.incFileSet.add(absIncludeFilePath);
			
			if      (scope==null)
					{ S.incFileList_global.add(absIncludeFilePath);
					  S.incFileSet_global.add(absIncludeFilePath);
					  incFile.scope = Param.global; }
			else if (scope.equalsIgnoreCase(Param.local))
					{ S.incFileList_local.add(absIncludeFilePath); 
					  S.incFileSet_local.add(absIncludeFilePath);
					  incFile.scope = Param.local; }
			else{ LogUtils.errMsg("Include file scope undefined: "+fileRelativePath, S.currentAbsolutePath);}
			

		}
	}

	public void goalSimple(String name, String scope, String expression) {
		
		name = name.toLowerCase();
		expression = expression.toLowerCase();
		
		if (S.gList.contains(name)) {
			LogUtils.errMsg("Goal redefined: "+name, S.currentAbsolutePath);
			S.error_goal_redefined.put(name, S.currentAbsolutePath);
		} else {

			S.var_all.put(name, "goal_simple");
			// / clearer data structure
			gl = new Goal();
			gl.caseCondition.add(Param.always);
			gl.caseName.add(Param.defaultCaseName);
			gl.caseExpression.add(expression);
			gl.fromWresl = S.currentAbsolutePath;
			S.gMap.put(name, gl);
			S.gList.add(name);
			S.gSet.add(name);
			
			if      ( scope == null )
					{S.gList_global.add(name);S.gSet_global.add(name); gl.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.gList_local.add(name);S.gSet_local.add(name); gl.scope = Param.local;}
			else{ LogUtils.errMsg("Goal scope undefined: "+name, S.currentAbsolutePath);}
		}
	}

	public void goalCase(String name, String scope, Goal gl) {
		
		name = name.toLowerCase();
		
		if (S.gList.contains(name)) {
			LogUtils.errMsg("Goal redefined: "+name, S.currentAbsolutePath);
			S.error_goal_redefined.put(name, S.currentAbsolutePath);
		} else {
			//goal_scope.put(name, scope);
			S.var_all.put(name, "goal_cases");

			// / better data structure
			
			gl.fromWresl = S.currentAbsolutePath;
			S.gMap.put(name, gl);
			S.gList.add(name);
			S.gSet.add(name);
			
			if      ( scope == null )
					{S.gList_global.add(name);S.gSet_global.add(name); gl.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.gList_local.add(name);S.gSet_local.add(name); gl.scope = Param.local;}
			else{ LogUtils.errMsg("Goal scope undefined: "+name, S.currentAbsolutePath);}
		}
	}

	public void svarCase(String name, String scope, Svar sv, String dependants) {

		name = name.toLowerCase();
		if (dependants!=null) dependants = dependants.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("Svar redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_cases");
		} else {
			S.var_all.put(name, "svar_cases");
			S.svTsDvList.add(name);
			S.svTsDvFileList.add(name);
			S.svTsList.add(name);
			
			// ///////////////////
			//sv.scope = scope;
			sv.fromWresl = S.currentAbsolutePath;
			
			if (dependants!=null) sv.dependants = Tools.convertStrToSet(dependants);	
			
			S.svMap.put(name, sv);
			S.svList.add(name);
			S.svSet.add(name);
	
			if      ( scope == null )
					{S.svList_global.add(name);S.svSet_global.add(name); sv.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.svList_local.add(name);S.svSet_local.add(name); sv.scope = Param.local;}
			else{ LogUtils.errMsg("Svar scope undefined: "+name, S.currentAbsolutePath);}
		}
	}

	public void external(String name, String scope, String externalType) {
		
		name = name.toLowerCase();
		externalType = externalType.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("External variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "external");
		} else {
			
			S.var_all.put(name, "external");
			// / clearer data structure

			ex = new External();
			ex.type = externalType;
			ex.fromWresl = S.currentAbsolutePath;

			S.exMap.put(name, ex);
			S.exList.add(name);
			S.exSet.add(name);
			
			if      (scope == null)
					{S.exList_global.add(name);S.exSet_global.add(name); ex.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.exList_local.add(name);S.exSet_local.add(name); ex.scope = Param.local;}
			else{ LogUtils.errMsg("External scope undefined: "+name, S.currentAbsolutePath);}
		}
	}
	
	public void svarExpression(String name, String scope, String expression, String dependants) {
		
		name = name.toLowerCase();
		expression = expression.toLowerCase();
		if (dependants!=null) dependants = dependants.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("State variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_expression");
		} else {

			S.var_all.put(name, "svar_expression");
			S.svTsDvList.add(name);
			S.svTsDvFileList.add(name);
			S.svTsList.add(name);
			
			// / clearer data structure
			String caseName = Param.defaultCaseName;
			String condition = Param.always;

			sv = new Svar();
			//sv.scope = scope;
			sv.caseName.add(caseName);
			sv.caseCondition.add(condition);
			sv.caseExpression.add(expression);
			sv.fromWresl = S.currentAbsolutePath;
			
			if (dependants!=null) sv.dependants = Tools.convertStrToSet(dependants);				

			S.svMap.put(name, sv);
			S.svList.add(name);
			S.svSet.add(name);
			
			if      ( scope == null )
					{S.svList_global.add(name);S.svSet_global.add(name); sv.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.svList_local.add(name);S.svSet_local.add(name); sv.scope = Param.local;}
			else{ LogUtils.errMsg("Svar scope undefined: "+name, S.currentAbsolutePath);}
		}

	}

	public void svarSum(String name, String scope, String hdr, String expression, String dependants) {
		
		name = name.toLowerCase();
		hdr = hdr.toLowerCase();
		expression = expression.toLowerCase();
		if (dependants!=null) dependants = dependants.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("State variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_sum");
		} else {

			S.var_all.put(name, "svar_sum");
			S.svTsDvList.add(name);
			S.svTsDvFileList.add(name);
			S.svTsList.add(name);
			
			sv = new Svar();
			//sv.scope = scope;
			sv.caseName.add(Param.defaultCaseName);
			sv.caseCondition.add("always");
			sv.caseExpression.add(hdr + " " +expression);
			sv.fromWresl = S.currentAbsolutePath;
			if (dependants!=null) sv.dependants = Tools.convertStrToSet(dependants);	

			S.svMap.put(name, sv);
			S.svList.add(name);
			S.svSet.add(name);
			
			if      ( scope == null )
					{S.svList_global.add(name);S.svSet_global.add(name); sv.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.svList_local.add(name);S.svSet_local.add(name); sv.scope = Param.local;}
			else{ LogUtils.errMsg("Svar scope undefined: "+name, S.currentAbsolutePath);}


		}
	}

	public void svarTable(String name, String scope, String sqlStr, String dependants) {
		
		name = name.toLowerCase();
		sqlStr = sqlStr.toLowerCase();
		if (dependants!=null) dependants = dependants.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("State variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_table");
		} else {
			S.var_all.put(name, "svar_table");
			S.svTsDvList.add(name);
			S.svTsDvFileList.add(name);
			S.svTsList.add(name);

			// / clearer data structure
			sv = new Svar();
			//sv.scope = scope;
			sv.format = "lookup_table";
			sv.caseCondition.add("always");
			sv.caseName.add(Param.defaultCaseName);
			sv.caseExpression.add(sqlStr);
			sv.fromWresl = S.currentAbsolutePath;
			if (dependants!=null) sv.dependants = Tools.convertStrToSet(dependants);	
			
			S.svMap.put(name, sv);
			S.svList.add(name);
			S.svSet.add(name);
			
			if      ( scope == null )
					{S.svList_global.add(name);S.svSet_global.add(name); sv.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local)) 
					{S.svList_local.add(name);S.svSet_local.add(name); sv.scope = Param.local;}
			else{ LogUtils.errMsg("Svar scope undefined: "+name, S.currentAbsolutePath);}
		}
	}

	public void timeseriesDss(String name, String scope, String b_part, String kind, String units, String convertToUnits) {
		
		name = name.toLowerCase();
		if (b_part != null) b_part = b_part.toLowerCase();
		kind = kind.toLowerCase();
		units = units.toLowerCase();
		if ( convertToUnits!=null) convertToUnits = convertToUnits.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("State variable redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "svar_dss");
		} else {

			S.var_all.put(name, "timeseries");
			S.svTsDvList.add(name);
			S.svTsDvFileList.add(name);
			S.svTsList.add(name);

			// / clearer data structure
			Timeseries ts = new Timeseries();
			//svTs.scope = scope;
			if (b_part!=null) ts.dssBPart = b_part; 
			ts.kind = kind;
			ts.units = units;
			if (convertToUnits!=null) {ts.convertToUnits = convertToUnits;}
			ts.format = "dss";
			ts.fromWresl = S.currentAbsolutePath;
			S.tsMap.put(name, ts);
			S.tsList.add(name);
			S.tsSet.add(name);
			
			if      (scope == null)
					{S.tsList_global.add(name);S.tsSet_global.add(name); ts.scope = Param.global;}
			else if (scope.equalsIgnoreCase(Param.local))
					{S.tsList_local.add(name);S.tsSet_local.add(name); ts.scope = Param.local;}
			else{ LogUtils.errMsg("Timeseries scope undefined: "+name, S.currentAbsolutePath);}

		}
	}

	public void dvarStd(String name, String scope, String integer, String kind, String units) {
		
		name = name.toLowerCase();
		kind = kind.toLowerCase();
		units = units.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("Dvar redefined: "+name, "\n"+S.currentAbsolutePath);
			S.error_var_redefined.put(name, "dvar_std");
		} else {

			S.var_all.put(name, "dvar_std");
			S.svTsDvList.add(name);
			S.svTsDvFileList.add(name);
			S.dvSet.add(name);

			// / better data structure
			dv = new Dvar();

			dv.kind = kind;
			dv.units = units;
			dv.lowerBound = Param.dv_lowerBound;
			dv.upperBound = Param.dv_upperBound;
			dv.fromWresl = S.currentAbsolutePath;

			if (integer != null) {
				
				dv.integer = Param.yes;
				dv.lowerBound = Param.integer_lowerBound;
				dv.upperBound = Param.integer_upperBound;
				
			}
			
			S.dvMap.put(name, dv);
			S.dvList.add(name);
			S.dvSet.add(name);
			
			if      ( scope == null )
					{S.dvList_global.add(name);S.dvSet_global.add(name); dv.scope = Param.global;}
			else if ( scope.equalsIgnoreCase(Param.local) ) 
					{S.dvList_local.add(name);S.dvSet_local.add(name); dv.scope = Param.local;}
			else{ LogUtils.errMsg("Dvar scope undefined: "+name, S.currentAbsolutePath);}

		}
	}

	public void alias(String name, String scope, String kind, String units,
			String expression) {
		
		name = name.toLowerCase();
		if (kind!=null) kind = kind.toLowerCase();
		if (units!=null) units = units.toLowerCase();
		expression = expression.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("Alias redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "dvar_alias");
		} else {

			S.var_all.put(name, "dvar_alias");

			// / better data structure
			as = new Alias();
			// as.scope = scope;
			if (kind != null)
				as.kind = kind;
			if (units != null)
				as.units = units;
			as.expression = expression;
			as.fromWresl = S.currentAbsolutePath;
			S.asMap.put(name, as);
			S.asList.add(name);
			S.asSet.add(name);
			
			if      (scope == null)
					{S.asList_global.add(name);S.asSet_global.add(name); as.scope = Param.global;}
			else if (scope.toLowerCase().equals(Param.local)) 
					{S.asList_local.add(name);S.asSet_local.add(name); as.scope = Param.local;}
			else{ LogUtils.errMsg("Alias scope undefined: "+name, S.currentAbsolutePath);}

		}
	}

	public void dvarNonStd(String name, String scope, String kind,
			String units,  String lowerBound,
			String upperBound) {
		
		name = name.toLowerCase();
		kind = kind.toLowerCase();
		units = units.toLowerCase();
		lowerBound = lowerBound.toLowerCase();
		upperBound = upperBound.toLowerCase();
		
		if (S.var_all.containsKey(name)) {
			LogUtils.errMsg("Dvar redefined: "+name, S.currentAbsolutePath);
			S.error_var_redefined.put(name, "dvar_nonstd");
		} else {

			S.var_all.put(name, "dvar_nonstd");
			S.svTsDvList.add(name);
			S.svTsDvFileList.add(name);

			// / better data structure
			dv = new Dvar();
			//dv.scope = scope;
			dv.kind = kind;
			dv.units = units;
			dv.lowerBound = lowerBound;
			dv.upperBound = upperBound;
			dv.fromWresl = S.currentAbsolutePath;
			S.dvMap.put(name, dv);
			S.dvList.add(name);
			S.dvSet.add(name);
			
			if      ( scope == null )
					{S.dvList_global.add(name);S.dvSet_global.add(name); dv.scope = Param.global;}
			else if ( scope.equalsIgnoreCase(Param.local) ) 
					{S.dvList_local.add(name);S.dvSet_local.add(name); dv.scope = Param.local;}
			else{ LogUtils.errMsg("Dvar scope undefined: "+name, S.currentAbsolutePath);}

		}
	}

	public void sequenceOrder(String sequenceName, String order,
			String modelName, String condition) {

		sequenceName = sequenceName.toLowerCase();
		order = order.toLowerCase();
		modelName = modelName.toLowerCase();
		if (condition!=null) condition = condition.toLowerCase();
		
		
		Integer i = Integer.parseInt(order);

		if (S.seqList.contains(sequenceName)) {
			S.error_sequence_redefined.add(sequenceName);
		} else if (S.seqMap.containsKey(i)) {
			S.error_sequence_order_redefined.add(i);
		} else {
			
			seq = new Sequence();
			seq.sequenceName = sequenceName;
			seq.condition = Param.always;
			if (condition!=null) seq.condition = condition;
			seq.modelName = modelName;
			seq.fromWresl = S.currentAbsolutePath;
			S.seqMap.put(i, seq);
			S.seqList.add(sequenceName);

		}

	}
}
