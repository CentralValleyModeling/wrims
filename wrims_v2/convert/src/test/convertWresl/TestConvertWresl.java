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


//import evaluators.Demo;

public class TestConvertWresl {

	
	private static CharStream stream;	
	
	@Test(groups = { "WRESL_elements" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "WRESL_elements" }) sample: 1==1");
	}

	@Test(groups = { "WRESL_elements" })
	public void sequence() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_sequence.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		
		expected.put("1", "SJRBASE");
		expected.put("2", "SJR_WQ1");
		
		Assert.assertEquals(parser.F.sequence, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void model() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_model.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, String> svar_constant = parser.F.svar_expression;
		
		expected.put("minflow_C_Orovl3", ".29");
		expected.put("minflow_C_Orovl2", "45.29");
		expected.put("minflow_C_Orovl", "600");
		
		Assert.assertEquals(svar_constant, expected);
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void svarConst() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarConst.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, String> svar_constant = parser.F.svar_expression;
		//Map<String, String> svar_constant2 = 
		
		expected.put("minflow_C_Orovl3", ".29");
		expected.put("minflow_C_Orovl2", "45.29");
		expected.put("minflow_C_Orovl", "600");
		
		Assert.assertEquals(svar_constant, expected);
	}

	@Test(groups = { "WRESL_elements" })
	public void svarSum() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		
		expected.put("OroInfEst", new ArrayList<String>(Arrays.asList(new String[]{"sum(i=0,SEP-month,1)","(I_Orovl(i))*cfs_taf(i)"})));
		
		
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
		parser.evaluator();
		Map<String, String> svar_expression = parser.F.svar_expression;
		
		expected.put("coefev_Orovl", "(A_Orovl_forward - A_Orovl_back)/(100*max(0.01,S_Orovl(-1)))");
		expected.put("min_test", "min(max(a,b),2.5)");
		
		Assert.assertEquals(svar_expression, expected);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_std = parser.F.dvar_std;
		
		expected.put("C_Tracy", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS"})));
		expected.put("C_Banks", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "TAF"})));
		
		Assert.assertEquals(dvar_std, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void dvarAlias() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		
		expected.put("QsacFth", new ArrayList<String>(Arrays.asList(new String[]{"flow-channel","CFS","C_SacFea+D_SacFea"})));
		
		Assert.assertEquals(parser.F.dvar_alias, expected);
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.F.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0.", "6150*taf_cfs"})));
		
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd2() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_dvarNonStd_2.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.F.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0", "6150*taf_cfs"})));
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarDSS() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_dss = parser.F.svar_dss;	

		expected.put("evap_S_Orovl", new ArrayList<String>(Arrays.asList(new String[]{"EVAPORATION-RATE", "IN"})));
		
		Assert.assertEquals(svar_dss, expected);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void svarTable() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.F.svar_table;	

		expected.put("nov_trigger_cfs", new ArrayList<String>(Arrays.asList(new String[]{"target","feather_fish_203",null,null,"month = NOV"})));
		
		Assert.assertEquals(svar_table, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void svarTableFull() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.F.svar_table;	

		expected.put("A_Orovl_last", new ArrayList<String>(Arrays.asList(new String[]{"area","res_info","storage=1000*S_Orovl(-1)","linear","res_num=6" })));
		
		Assert.assertEquals(svar_table, expected);
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarTableMultipleWhere() throws RecognitionException, IOException {
		
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
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.F.svar_table;	

		expected.put("S_TrntyLevel4", new ArrayList<String>(Arrays.asList(new String[]{"target","res_level",null,null,"res_num=1","level=4","month=month" })));
		
		Assert.assertEquals(svar_table, expected);
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void svarCase() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarCase.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();		
	    
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
		map_case_content.put("Febfore", Arrays.asList(new String[]{"sql","FEB","sacramento_runoff_forecast",null,null,"wateryear=wateryear"}));
		
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
	public void svarCase2() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarCase2.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();		
	    
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
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"sql","di","wsi_di_cvp_s","wsi=wsi_cvp_s","linear"}));
		
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
	public void svarCaseSum() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src\\test\\TestConvertWresl_svarCaseSum.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();		
	    
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
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"sum","sum(i=-(month-MAY),SEP-month)","I_Folsm(i)*cfs_taf(i) + I300(i)*cfs_taf(i)"}));
		
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
		parser.evaluator();		
	    
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
		map_case_content.put(list_case_names.get(list_case_names.size()-1), Arrays.asList(new String[]{"value","max(250., min(1750., (0.85 * C_Nimbus_fmp_mif(-1))))"}));
		
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
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.evaluator();

		expected.put("split_C5_WTS", "C5_WTS = C5_WTS_Stg1 + C5_WTS_Stg2");
		expected.put("C_SLCVP", "C5_WTS = C5_WTS_Stg1");
		expected.put("a1", "b = c");
		expected.put("a2", "b >  c");
		expected.put("a3", "b < c");
		
		
		List<String> goal_simple_keys = new ArrayList<String> (parser.F.goal_simple.keySet());
		List<String> expected_keys = new ArrayList<String> (expected.keySet());
		Collections.sort(goal_simple_keys);
		Collections.sort(expected_keys);
		
		Assert.assertEquals(goal_simple_keys, expected_keys);
		
		for (String i : expected_keys) {
			Assert.assertEquals(parser.F.goal_simple.get(i), expected.get(i));
		}
		
		Assert.assertEquals(parser.F.goal_simple, expected);		
	}			

	
	@Test(groups = { "WRESL_elements" })
	public void minMaxInlines() throws RecognitionException, IOException {
		
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
		parser.evaluator();

		expected.put("a", "min(1000. + 0.5*max(S_Orovl(prevSep) - 1000. ,0.), S_OrovlLevel5)");
		
		Assert.assertEquals(parser.F.svar_expression, expected);	
	}	
}
