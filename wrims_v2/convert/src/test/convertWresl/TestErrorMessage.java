package test.convertWresl;

import java.io.IOException;
import java.util.ArrayList;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wresl.ConvertWreslLexer;
import wresl.ConvertWreslParser;

import org.testng.annotations.*;
import org.testng.Assert;


public class TestErrorMessage {

	public String path; 
	private static CharStream stream;	
	
	@Test(groups = { "error_messages" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "error_message" }) sample: 1==1");
	}
	
	@Test(groups = { "error_messages" })
	public void errorSimple() throws RecognitionException, IOException {

		path ="src\\test\\TestErrorMessage_errorSimple.wresl";
		
		try {
			stream = new ANTLRFileStream(path, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    ArrayList<String>  expected = new ArrayList<String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = path;
		parser.evaluator(path);
				
		expected.add("missing EOF at 'defin' in file \"src\\test\\TestErrorMessage_errorSimple.wresl\"");
		
		Assert.assertEquals(parser.outputErrorMessage, expected);
	}			

}
