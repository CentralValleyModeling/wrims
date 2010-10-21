package test;

import java.io.IOException;
import java.util.ArrayList;
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

//import java.io.File;

public class TestConvertWRESL {

	
	private static CharStream stream;
	
	@Test
	public void isEmpty()
	{
		Assert.assertEquals(1,1);
        System.out.println("@Test - 1==1");


	}
	@Test
	public void mm() throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream("src//test//TestConvertWRESL3.wresl", "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

		ConvertWRESLLexer lexer = new ConvertWRESLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWRESLParser parser = new ConvertWRESLParser(tokenStream);
		parser.evaluator();
		Map<String, String> var_const = parser.var_constants;
		Map<String, ArrayList<String>>  dvar_std = parser.dvar_std;
		Map<String, ArrayList<String>>  dvar_nonstd = parser.dvar_nonstd;
		System.out.println("ok - var_constants: " + var_const );
		System.out.println("ok - dvar_std: " + dvar_std );
		System.out.println("ok - dvar_nonstd: " + dvar_nonstd );
	}

	

}
