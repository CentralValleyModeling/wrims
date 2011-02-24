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
		    
		CommonTree commonTree;
		WreslTreeLexer lexer = new WreslTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);		

		WreslTreeParser parser = new WreslTreeParser(tokenStream);
		WreslTreeParser.evaluator_return evaluator = parser.evaluator();
		
		commonTree = (CommonTree) evaluator.getTree();
		
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(evaluator.getTree());
		WreslTreeWalker walker = new WreslTreeWalker(nodeStream);
		
		walker.commonTree = commonTree;
		walker.result = walker.evaluator();

		
		walker.currentAbsolutePath = new File(inputFilePath).getAbsolutePath(); 
		walker.currentAbsoluteParent = new File(inputFilePath).getAbsoluteFile().getParent();
		
		LogUtils.consoleMsgOnly("...Parsing file: "+walker.currentAbsolutePath);
		

		
		return walker;
		
	}


}
	
