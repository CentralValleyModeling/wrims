
package test.test_evaluator;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.testng.annotations.Test;

import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.components.Error;
import wrimsv2.components.MainFile;

public class TestEvaluator {
	
	
	public String inputFilePath;
	public String logFilePath;
	
	public void testRelationStatement() throws RecognitionException, IOException {
		ANTLRStringStream stream = new ANTLRStringStream("g: (2+a)*3.4-(5+6*7.0)*b<(2+b)*6");
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		EvalConstraint ec=evaluator.evalConstraint;
		EvalExpression ee=ec.getEvalExpression();
		System.out.println(ec.getSign());
		System.out.println(ee.getValue());
		System.out.println(ee.getMultiplier());
	}
	
	@Test	
	public void testConditionStatement() throws RecognitionException, IOException {
        String mainFile="z:\\temp\\test";
        new MainFile(mainFile);
		
		ANTLRStringStream stream = new ANTLRStringStream("c: (6+8)*4>(3-2) .or. 100-4<3");
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		boolean eCondition=evaluator.evalCondition;
		if (eCondition){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
		Error.writeEvaluationErrorFile("log.txt");
	}
		
}
