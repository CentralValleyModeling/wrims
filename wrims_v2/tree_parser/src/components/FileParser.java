package components;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;


import wresl.WreslTreeLexer;
import wresl.WreslTreeParser;
import wresl.WreslTreeWalker;

public class FileParser {
	
	private static CharStream stream;	
	public String scope;
	public String kind;
	public String units;
	public String expression;

	
	public FileParser(){
		scope=Parameters.undefined;
		kind=Parameters.undefined;
		units=Parameters.undefined;
		expression=Parameters.undefined;


	}

	public static WreslTreeWalker parseFile(String inputFilePath) throws RecognitionException, IOException {		

		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         //e.printStackTrace();
	         
	         LogUtils.errMsg("File not found: "+ inputFilePath);
	         
	        }
		    
		WreslTreeLexer lexer = new WreslTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);		

		WreslTreeParser parser = new WreslTreeParser(tokenStream);
		
		parser.currentAbsolutePath = new File(inputFilePath).getAbsolutePath(); 
		parser.currentAbsoluteParent = new File(inputFilePath).getAbsoluteFile().getParent();
		
		LogUtils.importantMsg("Parsing file: "+parser.currentAbsolutePath);
		
		WreslTreeParser.evaluator_return parser_evaluator = parser.evaluator();
		
		// / for debug info
		parser.commonTree = (CommonTree) parser_evaluator.getTree();
				
		// / feed walker with parser's tree output
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(parser_evaluator.getTree());
		WreslTreeWalker walker = new WreslTreeWalker(nodeStream);
		
		walker.commonTree = parser.commonTree;
		walker.currentAbsolutePath = parser.currentAbsolutePath; 
		walker.currentAbsoluteParent = parser.currentAbsoluteParent;

		LogUtils.importantMsg("Walking tree: "+parser.currentAbsolutePath);
		
		walker.evaluator();
		
		return walker;
		
	}


}
	
