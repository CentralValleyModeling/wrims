package wrimsv2.components;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;

public class Evaluation {
	public static boolean isDouble(String text){
		try {
            Double.parseDouble(text);
            return true;
          }catch (NumberFormatException nfe5) {
            return false;
          }
	}
	
	public static double convertStringToDouble(String text){
		return Double.parseDouble(text);
	}
	
	public static String assignStatement(String i, String e){
		return i+"="+e;
	}
	
	public static String constraintStatement (String e1, String s, String e2) throws RecognitionException{
		if (isDouble(e2)) {
			if (convertStringToDouble(e2)==0.0){
				return e1+s+"0";
			}
		}
		ANTLRStringStream stream = new ANTLRStringStream("c:"+e1+"-("+e2+")"+s+"0");
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		return evaluator.evaluator();		
	}
}
