package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import Parser.ParseTableLexer;
import Parser.ParseTableParser;

import org.testng.annotations.*;
import org.testng.Assert;


public class TestParseTable {


	private static CharStream stream;

	@Test
	public void sample()
	{
		Assert.assertEquals(1,1);
        System.out.println("@Test sample: 1==1");
	}

	public void testNodeTable() throws RecognitionException, IOException {
   
		try {
			stream = new ANTLRFileStream("src//test//node.table", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
		
	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    Map<String, ArrayList<String>>  expected1 = new HashMap<String, ArrayList<String>>();
	    Map<String, String>  expected2 = new HashMap<String, String>();
	    
		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>> var_node = parser.node;
		Map<String, ArrayList<String>> var_dvar = parser.dvar;
		Map<String, String> var_weight = parser.weight;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;

		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("38.46");
		list.add("-256.34");
		list.add("normal");
		list.add("errpos_Alamo");
		list.add("errneg_Alamo");
		expected.put("Alamo", list);
		
		list = new ArrayList<String>();
		list.add("38.46");
		list.add("-256.34");
		list.add("reservoir");
		list.add("0");
		list.add("0");
		expected.put("S_Folsm", list);
		
		ArrayList<String> dvList = new ArrayList<String>();
        dvList.add("0");
        dvList.add("1.e38");
        dvList.add("n");
        dvList.add("cfs");
        dvList.add("error-term");
		expected1.put("errpos_Alamo", dvList);
		dvList = new ArrayList<String>();
        dvList.add("0");
        dvList.add("1.e38");
        dvList.add("n");
        dvList.add("cfs");
        dvList.add("error-term");
		expected1.put("errneg_Alamo", dvList);
		
		expected2.put("errpos_Alamo", "999999");
		expected2.put("errneg_Alamo", "999999");

		Assert.assertEquals(var_node, expected);
		Assert.assertEquals(var_dvar, expected1);
		//Assert.assertEquals(var_weight, expected2);
	}

	public void testSVarTable() throws RecognitionException, IOException {

        byte[] buffer = new byte[(int) new File("src//test//sv.csv").length()];
        BufferedInputStream f = null;
        try {
           f = new BufferedInputStream(new FileInputStream("src//test//sv.csv"));
           f.read(buffer);
           f.close();
        } catch (Exception e) { 
           e.printStackTrace();
        }
        
        String fileString=new String(buffer);
        fileString=fileString.toLowerCase();
        
        try {
           stream=new ANTLRStringStream(fileString);
        }
        catch(Exception e) {
           e.printStackTrace();
        }

	    Map<String, ArrayList<ArrayList<String>>>  expected = new HashMap<String, ArrayList<ArrayList<String>>>();

		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<ArrayList<String>>> var_svar = parser.svar;

		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;

		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		ArrayList<ArrayList<String>> svlist = new ArrayList<ArrayList<String>> ();
		ArrayList<String> list = new ArrayList<String>();
		list.add("forcast");
		list.add("cfs");
		list.add("month=Feb");
		list.add("TABLE");
		list.add("Feb");
		list.add("American_runoff_forcast");
		list.add("");
		list.add("");
		list.add("year=wateryear");
		svlist.add(list);
		list = new ArrayList<String>();
		list.add("forcast");
		list.add("cfs");
		list.add("always");
		list.add("EXPRESSION");
		list.add("-123.4");
		svlist.add(list);
		expected.put("Frcst_amrY", svlist);
		
		svlist = new ArrayList<ArrayList<String>> ();
		list = new ArrayList<String>();
		list.add("evap-cf");
		list.add("in");
		list.add("always");
		list.add("TIMESERIESWITHUNITS");
		list.add("evaporation-rate");
		list.add("in");
		svlist.add(list);
		expected.put("Evap_S_Shsta", svlist);		

		Assert.assertEquals(var_svar, expected);
	}
	
	public void testDvarTable() throws RecognitionException, IOException {

		try {
			stream = new ANTLRFileStream("src//test//dvar.table", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();

		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>> var_dvar = parser.dvar;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;

		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1.e38");
		list.add("n");
		list.add("cfs");
		list.add("channel-exc");
		expected.put("C_Kswck_Exc1", list);

		Assert.assertEquals(var_dvar, expected);
	}
	
	public void testArcTable() throws RecognitionException, IOException {

		try {
			stream = new ANTLRFileStream("src//test//arc.table", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    Map<String, ArrayList<ArrayList<String>>> expected1 = new HashMap<String, ArrayList<ArrayList<String>>>();
	    
		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>> var_dvar = parser.dvar;
		Map<String, ArrayList<ArrayList<String>>> var_svar = parser.svar;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;
		
		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("0");
		list.add("3160");
		list.add("n");
		list.add("cfs");
		list.add("delivery");
		expected.put("D_Banks", list);

		//Assert.assertEquals(var_dvar, expected);
		
		list = new ArrayList<String>();
		list.add("channel");
		list.add("cfs");
		list.add("always");
		list.add("EXPRESSION");
		list.add("45");
		ArrayList<ArrayList<String>> svlist = new ArrayList<ArrayList<String>>();
		svlist.add(list);
		expected1.put("C_Banks", svlist);
		Assert.assertEquals(var_svar, expected1);
	}
	
	public void testWeightTable() throws RecognitionException, IOException {

		try {
			stream = new ANTLRFileStream("src//test//weight.table", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		Map<String, String> var_weight = parser.weight;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;
		
		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		expected.put("c134", "-345");
		expected.put("ddd", "100*taf_cfs");
		expected.put("eee", "-120.0");
		expected.put("fff", "7.8");

		Assert.assertEquals(var_weight, expected);
	}
	
	public void testFileTable() throws RecognitionException, IOException {

		try {
			stream = new ANTLRFileStream("src//test//file.table", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    ArrayList<String>  expected = new ArrayList<String>();
	    
		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		ArrayList<String> var_file = parser.file;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;
		
		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		expected.add("..\\y\\focus-1\\");
		expected.add(".\\y\\focus-wel\\k.table");
		Assert.assertEquals(var_file, expected);
	}	
	
	public void testConstraintTable() throws RecognitionException, IOException {

		try {
			stream = new ANTLRFileStream("src//test//constraint.table", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<ArrayList<String>>>  expected = new HashMap<String, ArrayList<ArrayList<String>>>();
	    Map<String, ArrayList<ArrayList<String>>>  expected1 = new HashMap<String, ArrayList<ArrayList<String>>>();
	    Map<String, ArrayList<ArrayList<String>>>  expected2 = new HashMap<String, ArrayList<ArrayList<String>>>();

		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<ArrayList<String>>> var_constraint = parser.constraint;
		Map<String, ArrayList<ArrayList<String>>> var_lgr = parser.lgr;
		Map<String, ArrayList<ArrayList<String>>> var_rgl = parser.rgl;

		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;

		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>> ();
		ArrayList<String> list = new ArrayList<String>();
		list.add("Mon=Feb");
		list.add("D_sacFea_A=D_SacFea_B");
		constraintList.add(list);
		list = new ArrayList<String>();		
		list.add("always");
		list.add("D_sacFea_A>D_SacFea_B");
		constraintList.add(list);
		expected.put("ActfwflowY", constraintList);
		constraintList = new ArrayList<ArrayList<String>> ();
		list = new ArrayList<String>();
		list.add("a3+a4<5");
		list.add("f7<80.3+ghl");
		constraintList.add(list);
		list = new ArrayList<String>();
		list.add("a3+a4=5");
		list.add("f7>80.3+ghl");
		constraintList.add(list);
		list = new ArrayList<String>();
		list.add("always");
		list.add("0=0");
		constraintList.add(list);		
		expected.put("constraint1", constraintList);
		
		ArrayList<ArrayList<String>> lgrList = new ArrayList<ArrayList<String>> ();
		list = new ArrayList<String>();
		list.add("a3+a4<5");
		list.add("0");
		list.add("0");
		lgrList.add(list);
		list = new ArrayList<String>();
		list.add("a3+a4=5");
		list.add("f7-(80.3+ghl)");
		list.add("7.0");
		lgrList.add(list);
		list = new ArrayList<String>();
		list.add("always");
		list.add("d12-e14-(56*hn)");
		list.add("-8.0");
		lgrList.add(list);
		expected1.put("constraint1", lgrList);
		
		ArrayList<ArrayList<String>> rglList = new ArrayList<ArrayList<String>> ();
		list = new ArrayList<String>();
		list.add("a3+a4<5");
		list.add("80.3+ghl-(f7)");
		list.add("-6.0");
		rglList.add(list);
		list = new ArrayList<String>();
		list.add("a3+a4=5");
		list.add("0");
		list.add("0");
		rglList.add(list);
		list = new ArrayList<String>();
		list.add("always");
		list.add("56*hn-(d12-e14)");
		list.add("-6.0");
		rglList.add(list);
		expected2.put("constraint1", rglList);
		
		//Assert.assertEquals(var_constraint, expected);
		//Assert.assertEquals(var_lgr, expected1);
		Assert.assertEquals(var_rgl, expected2);
	}
	
	public void testReservoirTable() throws RecognitionException, IOException {

		try {
			stream = new ANTLRFileStream("src//test//reservoir.table", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    Map<String, ArrayList<ArrayList<String>>>  expected1 = new HashMap<String, ArrayList<ArrayList<String>>>();
	    Map<String, ArrayList<ArrayList<String>>>  expected2 = new HashMap<String, ArrayList<ArrayList<String>>>();
	    Map<String, String>  expected3 = new HashMap<String, String>();
	    
		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		Map<String, ArrayList<String>> var_dvar = parser.dvar;
		Map<String, ArrayList<ArrayList<String>>> var_svar=parser.svar;
		Map<String, ArrayList<ArrayList<String>>> var_constraint=parser.constraint;
		Map<String, String> var_weight = parser.weight;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;

		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1.e38");
		list.add("n");
		list.add("taf");
		list.add("storage");
		expected.put("S_Orovl", list);		
		list = new ArrayList<String>();
		list.add("0");
		list.add("1.e38");
		list.add("n");
		list.add("taf");
		list.add("storage-zone");
		expected.put("S_Orovl_1", list);
		list = new ArrayList<String>();
		list.add("0");
		list.add("1.e38");
		list.add("n");
		list.add("taf");
		list.add("storage-zone");
		expected.put("S_Orovl_2", list);
		list = new ArrayList<String>();
		list.add("0");
		list.add("1.e38");
		list.add("n");
		list.add("taf");
		list.add("storage-zone");
		expected.put("S_Orovl_3", list);
		
		ArrayList<ArrayList<String>> svList=new ArrayList<ArrayList<String>>();
		list = new ArrayList<String>();
		list.add("reservoir-level");
		list.add("taf");
		list.add("always");
		list.add("EXPRESSION");
		list.add("29.6");
		svList.add(list);
		expected1.put("S_Orovllevel1", svList);
		svList=new ArrayList<ArrayList<String>>();
		list = new ArrayList<String>();
		list.add("reservoir-level");
		list.add("taf");
		list.add("always");
		list.add("TIMESERIES");
		list.add("storage-level");
		svList.add(list);
		expected1.put("S_Orovllevel2", svList);
		svList=new ArrayList<ArrayList<String>>();
		list = new ArrayList<String>();
		list.add("reservoir-level");
		list.add("taf");
		list.add("always");
		list.add("EXPRESSION");
		list.add("min(2470.0, S_OrovlLevel2)");
		svList.add(list);
		expected1.put("S_Orovllevel3", svList);
		
		list = new ArrayList<String>();
		ArrayList<ArrayList<String>> constraintList=new ArrayList<ArrayList<String>>();
		list.add("always");
		list.add("S_Orovl=S_Orovl_1+S_Orovl_2+S_Orovl_3");
		constraintList.add(list);
		expected2.put("storage_S_Orovl", constraintList);
		list = new ArrayList<String>();
		constraintList=new ArrayList<ArrayList<String>>();
		list.add("always");
		list.add("S_Orovl_1<S_Orovllevel1");
		constraintList.add(list);
		expected2.put("S_Orovl_zone1", constraintList);
		list = new ArrayList<String>();
		constraintList=new ArrayList<ArrayList<String>>();
		list.add("always");
		list.add("S_Orovl_2<S_Orovllevel2-S_Orovllevel1");
		constraintList.add(list);
		expected2.put("S_Orovl_zone2", constraintList);
		list = new ArrayList<String>();
		constraintList=new ArrayList<ArrayList<String>>();
		list.add("always");
		list.add("S_Orovl_3<S_Orovllevel3-S_Orovllevel2");
		constraintList.add(list);
		expected2.put("S_Orovl_zone3", constraintList);
		
		expected3.put("S_Orovl_1", "100*taf_cfs");
		expected3.put("S_Orovl_3", "-100*taf_cfs");		
		//Assert.assertEquals(var_dvar, expected);
		//Assert.assertEquals(var_svar, expected1);	
		Assert.assertEquals(var_constraint, expected2);
		//Assert.assertEquals(var_weight, expected3);
	}

	public void testCycleTable() throws RecognitionException, IOException {

        byte[] buffer = new byte[(int) new File("src//test//cycle2.table").length()];
        BufferedInputStream f = null;
        try {
           f = new BufferedInputStream(new FileInputStream("src//test//cycle2.table"));
           f.read(buffer);
           f.close();
        } catch (Exception e) { 
           e.printStackTrace();
        }
        
        String fileString=new String(buffer);
        fileString=fileString.toLowerCase();
        
        try {
           stream=new ANTLRStringStream(fileString);
        }
        catch(Exception e) {
           e.printStackTrace();
        }
        
	    ArrayList<String>  expected = new ArrayList<String>();
	    Map<String, ArrayList<String>>  expected1 = new HashMap<String, ArrayList<String>>();
	    
		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		ArrayList<String> var_file = parser.file;
		Map<String, ArrayList<String>> var_node = parser.node;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;
		
		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		expected.add("src\\test\\node.table");
		expected.add("src\\test\\dvar.table");
		expected.add("src\\test\\arc.table");
		expected.add("src\\test\\svar.table");
		expected.add("src\\test\\reservoir.table");
		expected.add("src\\test\\constraint.table");
		expected.add("src\\test\\weights.table");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("38.46");
		list.add("-256.34");
		list.add("normal");
		list.add("errpos_alamo");
		list.add("errneg_alamo");
		expected1.put("alamo", list);
		
		list = new ArrayList<String>();
		list.add("38.46");
		list.add("-256.34");
		list.add("reservoir");
		list.add("0");
		list.add("0");
		expected1.put("s_folsm", list);
		
		list = new ArrayList<String>();
		list.add("38.46");
		list.add("-256.34");
		list.add("normal");
		list.add("errpos_sjr2");
		list.add("errneg_sjr2");
		list.add("-c_banks");
		list.add("+d_banks");
		expected1.put("sjr2", list);
		
		list = new ArrayList<String>();
		list.add("38.46");
		list.add("-256.34");
		list.add("normal");
		list.add("errpos_sbay");
		list.add("errneg_sbay");
		list.add("+c_banks");
		list.add("-d_banks");		
		expected1.put("sbay", list);
		
		//Assert.assertEquals(var_file, expected);
		Assert.assertEquals(var_node, expected1);
	}	
	
	@Test
	public void testMainTable() throws RecognitionException, IOException {

        byte[] buffer = new byte[(int) new File("src//test//main.wresl").length()];
        BufferedInputStream f = null;
        try {
           f = new BufferedInputStream(new FileInputStream("src//test//main.wresl"));
           f.read(buffer);
           f.close();
        } catch (Exception e) { 
           e.printStackTrace();
        }
        
        String fileString=new String(buffer);
        fileString=fileString.toLowerCase();
        
        try {
           stream=new ANTLRStringStream(fileString);
        }
        catch(Exception e) {
           e.printStackTrace();
        }
        
	    ArrayList<String>  expected = new ArrayList<String>();
	    Map<String, ArrayList<String>>  expected1 = new HashMap<String, ArrayList<String>>();
	    Map<String, ArrayList<ArrayList<String>>>  expected2 = new HashMap<String, ArrayList<ArrayList<String>>>();
	    
		ParseTableLexer lexer = new ParseTableLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ParseTableParser parser = new ParseTableParser(tokenStream);
		parser.evaluator();
		ArrayList<String> var_file = parser.file;
		Map<String, ArrayList<ArrayList<String>>> var_constraint = parser.constraint;
		Map<String, ArrayList<String>> var_alias=parser.alias;
		ArrayList<String> errorGrammer=parser.error_grammer;
		ArrayList<String> errorVarRedefine=parser.error_var_redefined;
		
		for (int i=0; i<errorGrammer.size(); i++){
			System.out.println(errorGrammer.get(i));
		}
		
		for (int i=0; i<errorVarRedefine.size(); i++){
			System.out.println(errorVarRedefine.get(i));
		}
		
		expected.add("src\\test\\dvar.wresl");
		expected.add("src\\test\\constraint.wresl");
			
		//Assert.assertEquals(var_file, expected);
		//Assert.assertEquals(var_constraint, expected1);
		Assert.assertEquals(var_alias, expected1);
	}	
}
