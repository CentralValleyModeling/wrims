package test.convertWresl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wresl.ConvertWreslLexer;
import wresl.ConvertWreslParser;

import org.testng.annotations.*;
import org.testng.Assert;

import evaluators.Struct;


//import evaluators.Demo;

public class TestConvertWresl {

	public String inputFilePath;
	private static CharStream stream;	
	
	@Test(groups = { "WRESL_elements" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "WRESL_elements" }) sample: 1==1");
	}

	@Test(groups = { "WRESL_elements" })
	public void sequence() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestConvertWresl_sequence.wresl";
		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected.put("1", "SJRBASE");
		expected.put("2", "SJR_WQ1");
		
		Assert.assertEquals(parser.F.sequence_orders, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void includeFile() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_includeFile.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    

	    //ArrayList<String> list;
	    //Map<String, ArrayList<String>>  expected_file_include_file  = new HashMap<String, ArrayList<String>>();
	    Map<String, String>  expected_include_file_scope = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		

		expected_include_file_scope.put("..\\..\\common\\System\\System_Sac.wresl", "local");
		expected_include_file_scope.put("..\\..\\common\\System\\SystemTables_Sac\\constraints-seepage_cycle7.wresl", "global");
		

		Assert.assertEquals(parser.F.include_file_scope, expected_include_file_scope);
		//Assert.assertEquals(parser.F.file_include_file, expected_file_include_file);
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void modelList() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelList.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    ArrayList<String>  expected_model_list = new ArrayList<String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		

		expected_model_list.add("one");
		expected_model_list.add("TWO");
		expected_model_list.add("Three");		
		

		Assert.assertEquals(parser.F.model_list, expected_model_list);
		//Assert.assertEquals(parser.F.file_include_file, expected_file_include_file);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void modelIncludeFile() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelIncludeFile.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct = new Struct();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected_struct.include_file_scope.put("..\\..\\common\\System\\System_Sac.wresl","local");
		expected_struct.include_file_scope.put("..\\..\\common\\System\\SystemTables_Sac\\constraints-seepage_cycle7.wresl","global");
		
//	    String[] array={null,"local","global"};
//	    list=new ArrayList<String>();list.addAll(Arrays.asList(array));
//		expected_model_scope_list.put("CVCWHEELING", list);
		
		expected_modelMap.put("CVCWHEELING",expected_struct);
				
		//System.out.println("#############################: " + parser.modelMap.get("CVCWHEELING").include_file_scope);
		//System.out.println("#############################: " + expected_modelMap.get("CVCWHEELING").include_file_scope);
		Assert.assertEquals(parser.modelMap.get("CVCWHEELING").include_file_scope, expected_modelMap.get("CVCWHEELING").include_file_scope);

	}	
	
	@Test(groups = { "WRESL_elements" })
	public void modelVarAdhoc() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelVarAdhoc.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct = new Struct();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected_struct.var_scope.put("force_c607","local");
		expected_struct.goal_simple.put("force_c607","C607 > 500");
		
//	    String[] array={null,"local","global"};
//	    list=new ArrayList<String>();list.addAll(Arrays.asList(array));
//		expected_model_scope_list.put("CVCWHEELING", list);
		
		expected_modelMap.put("CVCWHEELING",expected_struct);
				
		//System.out.println("#############################: " + parser.modelMap.get("CVCWHEELING").goal_simple);
		//System.out.println("#############################: " + expected_modelMap.get("CVCWHEELING").goal_simple);
		Assert.assertEquals(parser.modelMap.get("CVCWHEELING").goal_simple, expected_modelMap.get("CVCWHEELING").goal_simple);
		Assert.assertEquals(parser.modelMap.get("CVCWHEELING").var_scope, expected_modelMap.get("CVCWHEELING").var_scope);
		
	}	

	@Test(groups = { "WRESL_elements" })
	public void modelBasic() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelBasic.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct = new Struct();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();

		expected_struct.include_file_scope.put("..\\..\\common\\System\\System_Sac.wresl","local");
		expected_struct.include_file_scope.put("..\\..\\common\\System\\SystemTables_Sac\\constraints-seepage_cycle7.wresl","global");
				
		expected_struct.var_scope.put("force_c607","local");
		expected_struct.goal_simple.put("force_c607","C607 > 500");
		
//	    String[] array={null,"local","global"};
//	    list=new ArrayList<String>();list.addAll(Arrays.asList(array));
//		expected_model_scope_list.put("CVCWHEELING", list);
		
		expected_modelMap.put("CVCWHEELING",expected_struct);
				
		//System.out.println("#############################: " + parser.modelMap.get("CVCWHEELING").goal_simple);
		//System.out.println("#############################: " + expected_modelMap.get("CVCWHEELING").goal_simple);
		Assert.assertEquals(parser.modelMap.get("CVCWHEELING").goal_simple, expected_modelMap.get("CVCWHEELING").goal_simple);
		Assert.assertEquals(parser.modelMap.get("CVCWHEELING").var_scope, expected_modelMap.get("CVCWHEELING").var_scope);
		Assert.assertEquals(parser.modelMap.get("CVCWHEELING").include_file_scope, expected_modelMap.get("CVCWHEELING").include_file_scope);
		
	}			
	
	@Test(groups = { "WRESL_elements" })
	public void svarConst() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestConvertWresl_svarConst.wresl";
		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, String> svar_constant = parser.F.svar_expression;
		
		expected.put("minflow_C_Orovl3", ".29");
		expected.put("minflow_C_Orovl2", "45.29");
		expected.put("minflow_C_Orovl", "600");
		
		Assert.assertEquals(svar_constant, expected);
	}

	@Test(groups = { "WRESL_elements" })
	public void svarSum() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_svarSum.wresl";
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarSum.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, ArrayList<String>>   expected = new HashMap<String, ArrayList<String>> ();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected.put("OroInfEst", new ArrayList<String>(Arrays.asList(new String[]{"sum(i=0;SEP-month;1)","max(I_Orovl(i);dummy)*cfs_taf(i)"})));
		
		
		List<String> svar_sum_keys = new ArrayList<String> (parser.F.svar_sum.keySet());
		List<String> expected_keys = new ArrayList<String> (expected.keySet());
		Collections.sort(svar_sum_keys);
		Collections.sort(expected_keys);
		
		Assert.assertEquals(svar_sum_keys, expected_keys);
		for (String i : svar_sum_keys) {
			Assert.assertEquals(parser.F.svar_sum.get(i), expected.get(i));
		}
		Assert.assertEquals(parser.F.svar_sum, expected);
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void svarExpression() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_svarExpression.wresl";
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarExpression.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, String> svar_expression = parser.F.svar_expression;
		
		expected.put("coefev_Orovl", "(A_Orovl_forward - A_Orovl_back)/(100*max(0.01;S_Orovl(-1)))");
		expected.put("min_test", "min(max(a;b);2.5)");
		
		Assert.assertEquals(svar_expression, expected);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_dvarStd.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_dvarStd.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    //String[] array;
	    //ArrayList<String> list;
	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, ArrayList<String>>  dvar_std = parser.F.dvar_std;
		
		expected.put("C_Tracy", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS"})));
		expected.put("C_Banks", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "TAF"})));
		
		Assert.assertEquals(dvar_std, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void dvarAlias() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_dvarAlias.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_dvarAlias.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    //String[] array;
	    //ArrayList<String> list;
	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected.put("QsacFth", new ArrayList<String>(Arrays.asList(new String[]{"flow-channel","CFS","C_SacFea+D_SacFea"})));
		
		Assert.assertEquals(parser.F.dvar_alias, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void dvarAlias2() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_dvarAlias2.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_dvarAlias2.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    //String[] array;
	    //ArrayList<String> list;
	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected.put("D419_swpC6", new ArrayList<String>(Arrays.asList(new String[]{null,"CFS","D419_swp[monthlyweighted5]"})));
		
		Assert.assertEquals(parser.F.dvar_alias, expected);
	}

	@Test(groups = { "WRESL_elements" })
	public void defineLocal() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_defineLocal.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    //String[] array;
	    //ArrayList<String> list;
	    Map<String, ArrayList<String>>  expected_dvar_alias = new HashMap<String, ArrayList<String>>();
	    Map<String, String>  expected_svar_expression = new HashMap<String, String> ();
	    Map<String, String> expected_var_scope = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected_dvar_alias.put("D419_swpC6", new ArrayList<String>(Arrays.asList(new String[]{null,"CFS","D419_swp[monthlyweighted5]"})));
		expected_svar_expression.put("minflow_C", "60");
		
		expected_var_scope.put("D419_swpC6", "global");
		expected_var_scope.put("minflow_C", "local");
		
		//Assert.assertEquals(1, 2);
		Assert.assertEquals(parser.F.var_scope, expected_var_scope);
		
		Assert.assertEquals(parser.F.dvar_alias, expected_dvar_alias);
		Assert.assertEquals(parser.F.svar_expression, expected_svar_expression);
		
		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_dvarNonStd.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_dvarNonStd.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.F.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0.", "6150*taf_cfs"})));
		
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd2() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_dvarNonStd_2.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_dvarNonStd2.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    Map<String, String>  expected_var_scope = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.F.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0", "6150*taf_cfs"})));
		expected_var_scope.put("C_SLCVP", "global");
		expected_var_scope.put("C_SacFea", "local");
		
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarDSS() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_svarDSS.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarDSS.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, ArrayList<String>>  svar_dss = parser.F.svar_dss;	

		expected.put("evap_S_Orovl", new ArrayList<String>(Arrays.asList(new String[]{"EVAPORATION-RATE", "IN"})));
		
		Assert.assertEquals(svar_dss, expected);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void svarTable() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarTable.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarTable.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.F.svar_table;	

		expected.put("nov_trigger_cfs", new ArrayList<String>(Arrays.asList(new String[]{
			"target","feather_fish_203",null,null,"month = NOV"
			})));
		
		Assert.assertEquals(svar_table, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void svarTableFull() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarTableFull.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarTableFull.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.F.svar_table;	

		expected.put("A_Orovl_last", new ArrayList<String>(Arrays.asList(new String[]{
			"area","res_info","storage=1000*S_Orovl(-1)","linear","res_num=6" 
			})));
		
		Assert.assertEquals(svar_table, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarTableMultipleWhere() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarTableMultipleWhere.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarTableMultipleWhere.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.F.svar_table;	

		expected.put("S_TrntyLevel4", new ArrayList<String>(Arrays.asList(new String[]{
		//	"select","target","from","res_level","given",null,"use",null,"where","res_num=1","level=4","month=month" 
		             "target"       ,"res_level"        ,null      ,null        ,"res_num=1","level=4","month=month" })));
		
		Assert.assertEquals(svar_table, expected);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void svarCase() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarCase.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarCase.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();		
	    
	    Map<String, ArrayList<String>>   expected_svar_cases  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, ArrayList<String>>   expected_svar_conditions  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, Map<String, List<String>>> expected_svar_map_case_content = new HashMap<String, Map<String, List<String>>>();
	    
	    /// for each case of svar
	    Map<String, List<String>> map_case_content; 
	    ArrayList<String> list_case_names;
	    ArrayList<String> list_conditions;


		/// new svar
	    list_case_names = new ArrayList<String>();
	    list_conditions = new ArrayList<String>();
	    map_case_content = new HashMap<String, List<String>>();	
	    
	    /// new case
		list_case_names.add("Febfore"); // this is needed to ensure the order of the cases, which is lost in map
		list_conditions.add("month == FEB");
		map_case_content.put("Febfore", Arrays.asList(new String[]{
			//"sql","select","FEB","from","sacramento_runoff_forecast","given",null,"use",null,"where","wateryear=wateryear"
			"sql"         ,"FEB"       ,"sacramento_runoff_forecast"        ,null,      null,        "wateryear=wateryear"
		}));
		
		/// new case
		list_case_names.add("JuntoJan");
		list_conditions.add("always");
		map_case_content.put("JuntoJan", Arrays.asList(new String[]{"value","0"}));

		// conclude 1st svar
		expected_svar_cases.put("frcst_sac", list_case_names);
		expected_svar_conditions.put("frcst_sac", list_conditions);
		expected_svar_map_case_content.put("frcst_sac", map_case_content);

				
		List<String> svar_cases_keys = new ArrayList<String> (parser.F.svar_cases.keySet());
		List<String> expected_svar_cases_keys = new ArrayList<String> (expected_svar_cases.keySet());
		Collections.sort(svar_cases_keys);
		Collections.sort(expected_svar_cases_keys);
		
		Assert.assertEquals(svar_cases_keys, expected_svar_cases_keys);
		
//		for (String i : svar_cases_keys) {
//			Assert.assertEquals(parser.F.svar_cases.get(i), expected_svar_cases.get(i));
//		}
//		
//		for (String i : svar_cases_keys) {
//			Assert.assertEquals(parser.F.svar_conditions.get(i), expected_svar_conditions.get(i));
//		}
//
//		for (String i : svar_cases_keys) {
//			for (String j : expected_svar_map_case_content.get(i).keySet()) {
//				//System.out.println(i+":"+j);
//				Assert.assertEquals(parser.F.svar_map_case_content.get(i).get(j), expected_svar_map_case_content.get(i).get(j));
//			}
//		}
		
		Assert.assertEquals(parser.F.svar_cases, expected_svar_cases);
		Assert.assertEquals(parser.F.svar_conditions, expected_svar_conditions);
		Assert.assertEquals(parser.F.svar_map_case_content, expected_svar_map_case_content);
	}

	@Test(groups = { "WRESL_elements" })
	public void svarCase2() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarCase2.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarCase2.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();		
	    
	    Map<String, ArrayList<String>>   expected_svar_cases  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, ArrayList<String>>   expected_svar_conditions  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, Map<String, List<String>>> expected_svar_map_case_content = new HashMap<String, Map<String, List<String>>>();
	    
	    /// for each case of svar
	    Map<String, List<String>> map_case_content; 
	    ArrayList<String> list_case_names;
	    ArrayList<String> list_conditions;


		/// new svar
	    list_case_names = new ArrayList<String>();
	    list_conditions = new ArrayList<String>();
	    map_case_content = new HashMap<String, List<String>>();	
	    String svar_name = "DI_CVP_s";
	    
	    /// new case
		list_case_names.add("MartoMay"); // this is needed to ensure the order of the cases, which is lost in map
		list_conditions.add("month >= MAR .and. month <= MAY");
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{
				"sql","di","wsi_di_cvp_s","wsi=wsi_cvp_s","linear"
				}));
		
		/// new case
		list_case_names.add("JuntoFeb");
		list_conditions.add("always");
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"value","99.06"}));

		// conclude 1st svar
		expected_svar_cases.put(svar_name, list_case_names);
		expected_svar_conditions.put(svar_name, list_conditions);
		expected_svar_map_case_content.put(svar_name, map_case_content);

				
		List<String> svar_cases_keys = new ArrayList<String> (parser.F.svar_cases.keySet());
		List<String> expected_svar_cases_keys = new ArrayList<String> (expected_svar_cases.keySet());
		Collections.sort(svar_cases_keys);
		Collections.sort(expected_svar_cases_keys);
		
		Assert.assertEquals(svar_cases_keys, expected_svar_cases_keys);
		
//		for (String i : svar_cases_keys) {
//			Assert.assertEquals(parser.F.svar_cases.get(i), expected_svar_cases.get(i));
//		}
//		
//		for (String i : svar_cases_keys) {
//			Assert.assertEquals(parser.F.svar_conditions.get(i), expected_svar_conditions.get(i));
//		}
//
//		for (String i : svar_cases_keys) {
//			for (String j : expected_svar_map_case_content.get(i).keySet()) {
//				//System.out.println(i+":"+j);
//				Assert.assertEquals(parser.F.svar_map_case_content.get(i).get(j), expected_svar_map_case_content.get(i).get(j));
//			}
//		}
		
		Assert.assertEquals(parser.F.svar_cases, expected_svar_cases);
		Assert.assertEquals(parser.F.svar_conditions, expected_svar_conditions);
		Assert.assertEquals(parser.F.svar_map_case_content, expected_svar_map_case_content);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void svarCaseSum() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_svarCaseSum.wresl";
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarCaseSum.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();		
	    
	    Map<String, ArrayList<String>>   expected_svar_cases  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, ArrayList<String>>   expected_svar_conditions  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, Map<String, List<String>>> expected_svar_map_case_content = new HashMap<String, Map<String, List<String>>>();
	    
	    /// for each case of svar
	    Map<String, List<String>> map_case_content; 
	    ArrayList<String> list_case_names;
	    ArrayList<String> list_conditions;


		/// new svar
	    list_case_names = new ArrayList<String>();
	    list_conditions = new ArrayList<String>();
	    map_case_content = new HashMap<String, List<String>>();	
	    String svar_name = "AmerFrcstInflow";
	    
	    /// new case
		list_case_names.add("MAR_SEP"); // this is needed to ensure the order of the cases, which is lost in map
		list_conditions.add("month >= MAR .and. month <= SEP");
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"sum","sum(i=-(month-MAY);SEP-month)","I_Folsm(i)*cfs_taf(i) + I300(i)*cfs_taf(i)"}));
		
		/// new case
		list_case_names.add("other");
		list_conditions.add("always");
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"value","0.0"}));

		// conclude 1st svar
		expected_svar_cases.put(svar_name, list_case_names);
		expected_svar_conditions.put(svar_name, list_conditions);
		expected_svar_map_case_content.put(svar_name, map_case_content);

				
		List<String> svar_cases_keys = new ArrayList<String> (parser.F.svar_cases.keySet());
		List<String> expected_svar_cases_keys = new ArrayList<String> (expected_svar_cases.keySet());
		Collections.sort(svar_cases_keys);
		Collections.sort(expected_svar_cases_keys);
		
		Assert.assertEquals(svar_cases_keys, expected_svar_cases_keys);
		
		for (String i : svar_cases_keys) {
			Assert.assertEquals(parser.F.svar_cases.get(i), expected_svar_cases.get(i));
		}
		
		for (String i : svar_cases_keys) {
			Assert.assertEquals(parser.F.svar_conditions.get(i), expected_svar_conditions.get(i));
		}

		for (String i : svar_cases_keys) {
			for (String j : expected_svar_map_case_content.get(i).keySet()) {
				//System.out.println(i+":"+j);
				Assert.assertEquals(parser.F.svar_map_case_content.get(i).get(j), expected_svar_map_case_content.get(i).get(j));
			}
		}
		
		Assert.assertEquals(parser.F.svar_cases, expected_svar_cases);
		Assert.assertEquals(parser.F.svar_conditions, expected_svar_conditions);
		Assert.assertEquals(parser.F.svar_map_case_content, expected_svar_map_case_content);
	}

	@Test(groups = { "WRESL_elements" })
	public void svarCaseMultipleAnds() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarCaseMultipleAnds.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();		
	    
	    Map<String, ArrayList<String>>   expected_svar_cases  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, ArrayList<String>>   expected_svar_conditions  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, Map<String, List<String>>> expected_svar_map_case_content = new HashMap<String, Map<String, List<String>>>();
	    
	    /// for each case of svar
	    Map<String, List<String>> map_case_content; 
	    ArrayList<String> list_case_names;
	    ArrayList<String> list_conditions;


		/// new svar
	    list_case_names = new ArrayList<String>();
	    list_conditions = new ArrayList<String>();
	    map_case_content = new HashMap<String, List<String>>();	
	    String svar_name = "minflowFMPAmer";
	    
	    /// new case
		list_case_names.add("JanFebCMin"); // this is needed to ensure the order of the cases, which is lost in map
		list_conditions.add("month>=JAN .and. month<=FEB .and. sri_ytp == 5 .and. C_Nimbus_fmp_mif(-1) < 800.");
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"value","max(250.; min(1750.; (0.85 * C_Nimbus_fmp_mif(-1))))"}));
		
		/// new case
		//list_case_names.add("JuntoFeb");
		//list_conditions.add("always");
		//map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"value","99.06"}));

		// conclude 1st svar
		expected_svar_cases.put(svar_name, list_case_names);
		expected_svar_conditions.put(svar_name, list_conditions);
		expected_svar_map_case_content.put(svar_name, map_case_content);

				
		List<String> svar_cases_keys = new ArrayList<String> (parser.F.svar_cases.keySet());
		List<String> expected_svar_cases_keys = new ArrayList<String> (expected_svar_cases.keySet());
		Collections.sort(svar_cases_keys);
		Collections.sort(expected_svar_cases_keys);
		
		Assert.assertEquals(svar_cases_keys, expected_svar_cases_keys);
		
		for (String i : svar_cases_keys) {
			Assert.assertEquals(parser.F.svar_cases.get(i), expected_svar_cases.get(i));
		}
		
		for (String i : svar_cases_keys) {
			Assert.assertEquals(parser.F.svar_conditions.get(i), expected_svar_conditions.get(i));
		}

		for (String i : svar_cases_keys) {
			for (String j : expected_svar_map_case_content.get(i).keySet()) {
				//System.out.println(i+":"+j);
				Assert.assertEquals(parser.F.svar_map_case_content.get(i).get(j), expected_svar_map_case_content.get(i).get(j));
			}
		}
		
		Assert.assertEquals(parser.F.svar_cases, expected_svar_cases);
		Assert.assertEquals(parser.F.svar_conditions, expected_svar_conditions);
		Assert.assertEquals(parser.F.svar_map_case_content, expected_svar_map_case_content);
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void goalSimple() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_goalSimple.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, String>  expected = new HashMap<String, String>();
	    Map<String, String>  expected_scope = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();

		expected.put("split_C5_WTS", "C5_WTS = C5_WTS_Stg1 + C5_WTS_Stg2");
		expected.put("C_SLCVP", "C5_WTS = C5_WTS_Stg1");
		expected.put("a1", "b = c");
		expected.put("a2", "b >  c");
		expected.put("a3", "b < c");
		

		expected_scope.put("split_C5_WTS", "global");
		expected_scope.put("C_SLCVP", "global");
		expected_scope.put("a1", "global");
		expected_scope.put("a2", "local");
		expected_scope.put("a3", "global");
		
		List<String> goal_simple_keys = new ArrayList<String> (parser.F.goal_simple.keySet());
		List<String> expected_keys = new ArrayList<String> (expected.keySet());
		Collections.sort(goal_simple_keys);
		Collections.sort(expected_keys);
		
		Assert.assertEquals(goal_simple_keys, expected_keys);
		
//		for (String i : expected_keys) {
//			Assert.assertEquals(parser.F.goal_simple.get(i), expected.get(i));
//		}
		
		Assert.assertEquals(parser.F.goal_simple, expected);	
		Assert.assertEquals(parser.F.var_scope, expected_scope);	
	}			

	@Test(groups = { "WRESL_elements" })
	public void goalNoCase() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_goalNoCase.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, List<String>>  expected = new HashMap<String, List<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();

		expected.put("b2action1Whi_1", Arrays.asList(new String[]{
				"lhs","C3_MIF","rhs","minflow_C3b2","l>r","constrain",null,"l<r","penalty","700.0"
		}));
		
		Assert.assertEquals(parser.F.goal_no_case, expected);		
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void goalCase() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_goalCase.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();		

		Map<String, String> expected_goal_lhs = new HashMap<String, String>();
	    Map<String, ArrayList<String>>   expected_goal_cases  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, ArrayList<String>>   expected_goal_conditions  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, Map<String, List<String>>> expected_goal_map_case_content = new HashMap<String, Map<String, List<String>>>();
	    
	    /// for each case of svar
	    Map<String, List<String>> map_case_content; 
	    ArrayList<String> list_case_names;
	    ArrayList<String> list_conditions;


		/// new svar
	    list_case_names = new ArrayList<String>();
	    list_conditions = new ArrayList<String>();
	    map_case_content = new HashMap<String, List<String>>();	
	    String goal_name = "b2action1Whi_1";
	    String lhs = "C3_MIF";
	    
	    /// new case
		list_case_names.add("Action1WhiOn"); // this is needed to ensure the order of the cases, which is lost in map
		list_conditions.add("int(B2Action1WhiOn)==1");
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{
				"goal","rhs","minflow_C3b2","l>r","constrain",null,"l<r","penalty","700."
				}));
		
		/// new case
		list_case_names.add("Action1WhiOff");
		list_conditions.add("int(B2Action1WhiOn)==0");
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{
				"goal","rhs","clear_min","l>r","constrain",null,"l<r","penalty","0"
				}));

		// conclude 1st svar
		expected_goal_lhs.put(goal_name, lhs);
		expected_goal_cases.put(goal_name, list_case_names);
		expected_goal_conditions.put(goal_name, list_conditions);
		expected_goal_map_case_content.put(goal_name, map_case_content);

				
		List<String> goal_cases_keys = new ArrayList<String> (parser.F.goal_cases.keySet());
		List<String> expected_goal_cases_keys = new ArrayList<String> (expected_goal_cases.keySet());
		Collections.sort(goal_cases_keys);
		Collections.sort(expected_goal_cases_keys);
		
//		Assert.assertEquals(goal_cases_keys, expected_goal_cases_keys);
//		
//		for (String i : goal_cases_keys) {
//			Assert.assertEquals(parser.F.goal_cases.get(i), expected_goal_cases.get(i));
//		}
//		
//		for (String i : goal_cases_keys) {
//			Assert.assertEquals(parser.F.goal_conditions.get(i), expected_goal_conditions.get(i));
//		}
//
//		for (String i : goal_cases_keys) {
//			for (String j : expected_goal_map_case_content.get(i).keySet()) {
//				//System.out.println(i+":"+j);
//				Assert.assertEquals(parser.F.goal_map_case_content.get(i).get(j), expected_goal_map_case_content.get(i).get(j));
//			}
//		}
		
		Assert.assertEquals(parser.F.goal_lhs, expected_goal_lhs);
		Assert.assertEquals(parser.F.goal_cases, expected_goal_cases);
		Assert.assertEquals(parser.F.goal_conditions, expected_goal_conditions);
		Assert.assertEquals(parser.F.goal_map_case_content, expected_goal_map_case_content);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void minMaxInlines() throws RecognitionException, IOException {
		
		inputFilePath =  "src\\test\\TestConvertWresl_minMaxInlines.wresl";
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_minMaxInlines.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		
		parser.currentFilePath = inputFilePath; parser.evaluator();

		expected.put("a", "min(1000. + 0.5*max(S_Orovl(prevSep) - 1000. ;0.); S_OrovlLevel5)");
		
		Assert.assertEquals(parser.F.svar_expression, expected);	
	}	
}
