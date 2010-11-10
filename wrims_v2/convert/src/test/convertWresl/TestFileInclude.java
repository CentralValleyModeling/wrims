package test.convertWresl;

import java.io.IOException;
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


public class TestIncludeFile {

	
	private static CharStream stream;	
	
	@Test(groups = { "file_includes" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "WRESL_elements" }) sample: 1==1");
	}

	@Test(groups = { "file_includes" })
	public void errorSimple() throws RecognitionException, IOException {
		
		String filePath ="src\\test\\TestErrorMessage_errorSimple.wresl";
		
		try {
			stream = new ANTLRFileStream(filePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = filePath;
		parser.evaluator();
		Map<String, String> svar_constant = parser.F.svar_expression;
		
		expected.put("minflow_C_Orovl3", ".29");
		expected.put("minflow_C_Orovl2", "45.29");
		expected.put("minflow_C_Orovl", "600");
		
		Assert.assertEquals(svar_constant, expected);
	}		

}
