package wrimsv2.wreslplus.elements;

import java.io.File;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
//import org.antlr.runtime.tree.CommonTreeNodeStream;

import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslplus.grammar.WreslPlusLexer;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class ParserUtils {
	

	
	private ParserUtils(){}


	public static WreslPlusParser initParser(String inputFilePath) throws RecognitionException  {		

		CharStream stream;
		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         //e.printStackTrace();
	         LogUtils.errMsg("File not found: "+ inputFilePath);
	         LogUtils.closeLogFile();
	         return null;
	        }
		    
		WreslPlusLexer lexer = new WreslPlusLexer(stream);
		
		TokenStream tokenStream = new CommonTokenStream(lexer);		
		
		WreslPlusParser parser = new WreslPlusParser(tokenStream);
		
		parser.currentAbsolutePath = new File(inputFilePath).getAbsolutePath(); 
		parser.currentAbsoluteParent = new File(inputFilePath).getAbsoluteFile().getParent();
		parser.pathRelativeToRunDir = ResourceUtils.getRelativePath(parser.currentAbsolutePath, GlobalData.runDir, "\\");
		
		LogUtils.importantMsg("Parsing file: "+parser.currentAbsolutePath);
		
		return parser;
		
	}



}
	
