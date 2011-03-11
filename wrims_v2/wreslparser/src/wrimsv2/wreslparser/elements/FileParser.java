package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;


import wrimsv2.wreslparser.grammar.WreslTreeLexer;
import wrimsv2.wreslparser.grammar.WreslTreeParser;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

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
		
		// / check if sequence contains models not defined
		ArrayList<String> undefined_models = parser.model_in_sequence;
		parser.model_in_sequence.removeAll(parser.model_list);
		if (undefined_models.size()>0 ){
			LogUtils.errMsg("Sequence has undefined models: ", undefined_models);
		}
		
		// / for debug info
		parser.commonTree = (CommonTree) parser_evaluator.getTree();
		LogUtils.importantMsg("tree = " + parser.commonTree.toStringTree());
		
		// / feed walker with parser's tree output
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(parser_evaluator.getTree());
		nodeStream.setTokenStream(tokenStream); // important trick to avoid null exception in tree walker
		WreslTreeWalker walker = new WreslTreeWalker(nodeStream);
		
		walker.commonTree = parser.commonTree;
		walker.currentAbsolutePath = parser.currentAbsolutePath; 
		walker.currentAbsoluteParent = parser.currentAbsoluteParent;

		LogUtils.importantMsg("Walking tree: "+parser.currentAbsolutePath);
		
		walker.evaluator();
		
		return walker;
		
	}


}
	
