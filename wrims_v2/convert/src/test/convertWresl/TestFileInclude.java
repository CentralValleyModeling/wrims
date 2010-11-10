package test.convertWresl;

import java.io.IOException;
import java.util.ArrayList;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wresl.FileIncludeLexer;
import wresl.FileIncludeParser;

import org.testng.annotations.*;
import org.testng.Assert;


public class TestFileInclude {

	
	private static CharStream stream;	
	
	@Test(groups = { "file_includes" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "WRESL_elements" }) sample: 1==1");
	}

	@Test(groups = { "file_includes" })
	public void Simple() throws RecognitionException, IOException {
		
		String filePath ="src\\test\\TestFileInclude_Simple.wresl";
		
		try {
			stream = new ANTLRFileStream(filePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    ArrayList<String>  expected = new ArrayList<String>();
	    
		FileIncludeLexer lexer = new FileIncludeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		FileIncludeParser parser = new FileIncludeParser(tokenStream);
		parser.currentFilePath = filePath;
		parser.evaluator();
		//Map<String, String> svar_constant = parser.F.svar_expression;
		
		expected.add("minflow_C_Orovl3");
		expected.add("minflow_C_Orovl3");
		expected.add("minflow_C_Orovl3");		
		

		Assert.assertEquals(parser.fileList, expected);
	}		

}
