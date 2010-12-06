package test.convertWresl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import evaluators.SvarProps;
import evaluators.Tools;
import evaluators.WriteCSV;



//import evaluators.Demo;

public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;
	private static CharStream stream;	
	
	@Test(groups = { "WRESL_to_Table" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "WRESL_to_Table" }) sample: 1==1");
	}
		
	
	@Test(groups = { "WRESL_to_Table" })
	public void svar() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWreslToTable_svar.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		outputFilePath ="test-csv\\svar.csv";
		outFile = Tools.openFile(outputFilePath);
		outFile.print(WriteCSV.svar_header+"\n");
		
		WriteCSV.svar(parser.F.svar,inputFilePath,outFile);
	    outFile.close();
		
		String expected = Tools.readFileAsString("src\\test\\TestConvertWreslToTable_svar.expected");
	    String test = 	  Tools.readFileAsString(outputFilePath);	
		
		Assert.assertEquals(test, expected);
	}
	
	@Test(groups = { "WRESL_to_Table" })
	public void svarCase() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWreslToTable_svarCase.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		outputFilePath ="test-csv\\svar_case.csv";
		outFile = Tools.openFile(outputFilePath);
		outFile.print(WriteCSV.svar_header+"\n");
		
		WriteCSV.svar(parser.F.svar,inputFilePath,outFile);
	    outFile.close();
		
		String expected = Tools.readFileAsString("src\\test\\TestConvertWreslToTable_svarCase.expected");
	    String test = 	  Tools.readFileAsString(outputFilePath);	
		
		Assert.assertEquals(test, expected);
	}
	
	@Test(groups = { "WRESL_to_Table" })	
	public void dvar() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWreslToTable_dvar.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		outputFilePath = "test-csv\\dvar.csv"; 
		outFile = Tools.openFile(outputFilePath); 
		outFile.print(WriteCSV.dvar_header+"\n");

		
		Map<String, ArrayList<String>> mapAll = new HashMap<String, ArrayList<String>>();		
		mapAll.putAll(parser.F.dvar_std);
		mapAll.putAll(parser.F.dvar_nonstd);
		
		WriteCSV.dvar(mapAll, parser.F.dvar_scope,  inputFilePath, outFile);
		
		outFile.close();
		
		String expected = Tools.readFileAsString("src\\test\\TestConvertWreslToTable_dvar.expected");
	    String test = 	  Tools.readFileAsString(outputFilePath);	
		
		Assert.assertEquals(test, expected);
	}

	

	@Test(groups = { "WRESL_to_Table" })
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

	@Test(groups = { "WRESL_to_Table" })
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
	
	@Test(groups = { "WRESL_to_Table" })
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
	
	
}
