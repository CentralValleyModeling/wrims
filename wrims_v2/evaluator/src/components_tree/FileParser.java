package components_tree;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;


import grammar.EvaluatorTreeLexer;
import grammar.EvaluatorTreeParser;
import grammar.EvaluatorTreeWalker;

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

	public static EvaluatorTreeWalker parseFile(String inputFilePath) throws RecognitionException, IOException {		

		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         //e.printStackTrace();
	         
	         LogUtils.errMsg("File not found: "+ inputFilePath);
	         
	        }
		    
		EvaluatorTreeLexer lexer = new EvaluatorTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);		

		EvaluatorTreeParser parser = new EvaluatorTreeParser(tokenStream);
		
		parser.currentAbsolutePath = new File(inputFilePath).getAbsolutePath(); 
		parser.currentAbsoluteParent = new File(inputFilePath).getAbsoluteFile().getParent();
		
		LogUtils.importantMsg("Parsing file: "+parser.currentAbsolutePath);
		
		EvaluatorTreeParser.evaluator_return parser_evaluator = parser.evaluator();
		
		// / for debug info
		parser.commonTree = (CommonTree) parser_evaluator.getTree();
		LogUtils.importantMsg("tree = " + parser.commonTree.toStringTree());
		
		// / feed walker with parser's tree output
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(parser_evaluator.getTree());
		EvaluatorTreeWalker walker = new EvaluatorTreeWalker(nodeStream);
		
		walker.commonTree = parser.commonTree;
		walker.currentAbsolutePath = parser.currentAbsolutePath; 
		walker.currentAbsoluteParent = parser.currentAbsoluteParent;

		LogUtils.importantMsg("Walking tree: "+parser.currentAbsolutePath);
		
		int result= walker.evaluator();
		
		walker.result = result;
		return walker;
		
	}


}
	
