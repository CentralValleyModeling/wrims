package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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


public class TestConvertWresl {

	
	private static CharStream stream;	
	
	@Test(groups = { "WRESL_elements" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "WRESL_elements" }) sample: 1==1");
	}
	
	@Test(groups = { "WRESL_elements" })
	public void svarConst() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_svarConst.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, String> svar_constant = parser.svar_expression;
		
		expected.put("minflow_C_Orovl3", ".29");
		expected.put("minflow_C_Orovl2", "45.29");
		expected.put("minflow_C_Orovl", "600");
		
		Assert.assertEquals(svar_constant, expected);
	}

	@Test(groups = { "WRESL_elements" })
	public void svarExpression() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_svarExpression.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, String> svar_expression = parser.svar_expression;
		
		expected.put("coefev_Orovl", "(A_Orovl_forward - A_Orovl_back)/(100*max(0.01,S_Orovl(-1)))");
		expected.put("min_test", "min(max(a,b),2.5)");
		
		Assert.assertEquals(svar_expression, expected);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_dvarStd.wresl", "UTF8");
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
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_std = parser.dvar_std;
		
		expected.put("C_Tracy", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS"})));
		expected.put("C_Banks", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "TAF"})));
		
		Assert.assertEquals(dvar_std, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_dvarNonStd.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0.", "6150*taf_cfs"})));
		
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd2() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_dvarNonStd_2.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0", "6150*taf_cfs"})));
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarDSS() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_svarDSS.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_dss = parser.svar_dss;	

		expected.put("evap_S_Orovl", new ArrayList<String>(Arrays.asList(new String[]{"EVAPORATION-RATE", "IN"})));
		
		Assert.assertEquals(svar_dss, expected);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void svarTable() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_svarTable.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.svar_table;	

		expected.put("nov_trigger_cfs", new ArrayList<String>(Arrays.asList(new String[]{"target","feather_fish_203",null,null,"month = NOV"})));
		
		Assert.assertEquals(svar_table, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void svarTableFull() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_svarTableFull.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.svar_table;	

		expected.put("A_Orovl_last", new ArrayList<String>(Arrays.asList(new String[]{"area","res_info","storage=1000*S_Orovl(-1)","linear","res_num=6" })));
		
		Assert.assertEquals(svar_table, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarTableMultipleWhere() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_svarTableMultipleWhere.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.svar_table;	

		expected.put("S_TrntyLevel4", new ArrayList<String>(Arrays.asList(new String[]{"target","res_level",null,null,"res_num=1","level=4","month=month" })));
		
		Assert.assertEquals(svar_table, expected);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void svarCase() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_svarCase.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    //Map<String, Map<String, ArrayList<String>>>  expected  = new HashMap<String, Map<String, ArrayList<String>>>(); 
	    

	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
	    Map<String, Map<String, ArrayList<ArrayList<String>>>> svar_case_sql = parser.svar_case_sql; 
	    Map<String, ArrayList<String>>   svar_case_sql_list  = parser.svar_case_sql_list; 
	    
	    Map<String,Map<String,ArrayList<ArrayList<String>>>>expected = new HashMap<String,Map<String,ArrayList<ArrayList<String>>>>();				
	    Map<String, ArrayList<String>>   expected_case_list  = new HashMap<String,ArrayList<String>> (); 
	    
	    Map<String, ArrayList<ArrayList<String>>> map_cases; 
	    ArrayList<String> list_case_names;
	    ArrayList<ArrayList<String>> list_case_2d;

		// new svar
	    map_cases  = new HashMap<String,ArrayList<ArrayList<String>>>(); 
	    list_case_names = new ArrayList<String>();
	    
	    // new case
	    list_case_2d = new ArrayList<ArrayList<String>>();
		list_case_2d.add(new ArrayList<String>());list_case_2d.add(new ArrayList<String>());

		list_case_2d.get(0).add("sql");
		list_case_2d.get(1).addAll(Arrays.asList(new String[]{"month == FEB","FEB","sacramento_runoff_forecast",null,null,"wateryear=wateryear",null,null}));
		list_case_names.add("Febfore"); // this is needed to ensure the order of the cases, which is lost in map
		map_cases.put("Febfore", list_case_2d);
		
		// new case
	    list_case_2d = new ArrayList<ArrayList<String>>();
		list_case_2d.add(new ArrayList<String>());list_case_2d.add(new ArrayList<String>());

		list_case_2d.get(0).add("value");
		list_case_2d.get(1).addAll(Arrays.asList(new String[]{"always","0"}));
		list_case_names.add("JuntoJan");
		map_cases.put("JuntoJan", list_case_2d);

		// conclude 1st svar
		expected_case_list.put("frcst_sac", list_case_names);
		expected.put("frcst_sac", map_cases);
				
		Assert.assertEquals(svar_case_sql, expected);
		//Assert.assertEquals(svar_case_sql_list, expected_case_list);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void goalSimple() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWresl_goalSimple.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, String>  goal_simple = parser.goal_simple;	

		expected.put("split_C5_WTS", "C5_WTS = C5_WTS_Stg1 + C5_WTS_Stg2");
		expected.put("C_SLCVP", "C5_WTS = C5_WTS_Stg1");
		
		Assert.assertEquals(goal_simple, expected);
	}			

}
