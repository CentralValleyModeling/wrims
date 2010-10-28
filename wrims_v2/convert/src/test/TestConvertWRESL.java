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

import WRESL.ConvertWRESLLexer;
import WRESL.ConvertWRESLParser;

import org.testng.annotations.*;
import org.testng.Assert;


public class TestConvertWRESL {

	
	private static CharStream stream;
	
	@Test
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test sample: 1==1");
	}
	
	@Test
	public void svarConst() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_svarConst.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, String> svar_constant = parser.svar_expression;
		
		expected.put("minflow_C_Orovl3", ".29");
		expected.put("minflow_C_Orovl2", "45.29");
		expected.put("minflow_C_Orovl", "600");
		
		Assert.assertEquals(svar_constant, expected);
	}

	@Test
	public void svarExpression() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_svarExpression.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, String> svar_expression = parser.svar_expression;
		
		expected.put("coefev_Orovl", "(A_Orovl_forward - A_Orovl_back)/(100*max(0.01,S_Orovl(-1)))");
		expected.put("min_test", "min(max(a,b),2.5)");
		
		Assert.assertEquals(svar_expression, expected);
	}
	
	@Test
	public void dvarStd() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_dvarStd.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    //String[] array;
	    //ArrayList<String> list;
	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_std = parser.dvar_std;
		
		expected.put("C_Tracy", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS"})));
		expected.put("C_Banks", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "TAF"})));
		
		Assert.assertEquals(dvar_std, expected);
	}	

	@Test
	public void dvarNonStd() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_dvarNonStd.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0.", "6150*taf_cfs"})));
		
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test
	public void dvarNonStd2() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_dvarNonStd_2.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  dvar_nonstd = parser.dvar_nonstd;	

		expected.put("C_SLCVP", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "unbounded", "unbounded"})));
		expected.put("C_SacFea", new ArrayList<String>(Arrays.asList(new String[]{"FLOW-CHANNEL", "CFS", "0", "6150*taf_cfs"})));
		Assert.assertEquals(dvar_nonstd, expected);
	}		

	@Test
	public void svarDSS() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_svarDSS.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_dss = parser.svar_dss;	

		expected.put("evap_S_Orovl", new ArrayList<String>(Arrays.asList(new String[]{"EVAPORATION-RATE", "IN"})));
		
		Assert.assertEquals(svar_dss, expected);
	}		
	
	@Test
	public void svarTable() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_svarTable.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.svar_table;	

		expected.put("nov_trigger_cfs", new ArrayList<String>(Arrays.asList(new String[]{"target","feather_fish_203",null,null,"month = NOV"})));
		
		Assert.assertEquals(svar_table, expected);
	}	

	@Test
	public void svarTableFull() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_svarTableFull.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.svar_table;	

		expected.put("A_Orovl_last", new ArrayList<String>(Arrays.asList(new String[]{"area","res_info","storage=1000*S_Orovl(-1)","linear","res_num=6" })));
		
		Assert.assertEquals(svar_table, expected);
	}		

	@Test
	public void svarTableMultipleWhere() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_svarTableMultipleWhere.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>>  svar_table = parser.svar_table;	

		expected.put("A_Orovl_last", new ArrayList<String>(Arrays.asList(new String[]{"area","res_info","storage=1000*S_Orovl(-1)","linear","res_num=6" })));
		
		Assert.assertEquals(svar_table, expected);
	}		
	
	@Test
	public void goalSimple() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL_goalSimple.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, String>  goal_simple = parser.goal_simple;	

		expected.put("split_C5_WTS", "C5_WTS = C5_WTS_Stg1 + C5_WTS_Stg2");
		expected.put("C_SLCVP", "C5_WTS = C5_WTS_Stg1");
		
		Assert.assertEquals(goal_simple, expected);
	}			

}
