package wrimsv2.wreslplus.elements.procedures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.components.ControlData;
import wrimsv2.components.IntDouble;
import wrimsv2.components.Error;
import wrimsv2.evaluator.ValueEvaluatorLexer;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.wreslplus.elements.ParamTemp;
import wrimsv2.wreslplus.elements.StudyTemp;

public class ProcParameter {

	private ProcParameter() {
	}

	public static void process(StudyTemp st){
		
		ControlData.parameterMap = convertParamMapToSvarMap(st.parameterMap);
		callEvaluator(st.parameterList, ControlData.parameterMap);	
		
	}
	


	
	private static void callEvaluator(ArrayList<String> keyList, Map<String, Svar> map) {
		
		for (String key: keyList) {
			
			Svar svar = map.get(key);
			
			// no condition allowed for parameters at testing stage
			// the condition is always TRUE
			String evalString="c: "+svar.caseCondition.get(0);
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
			svar.caseConditionParsers.add(evaluator);
			
			
			evalString="v: "+svar.caseExpression.get(0);
			stream = new ANTLRStringStream(evalString);
			lexer = new ValueEvaluatorLexer(stream);
			tokenStream = new CommonTokenStream(lexer);
			evaluator = new ValueEvaluatorParser(tokenStream);
			svar.caseExpressionParsers.add(evaluator);
			
			
			try {
				evaluator.evaluator();
				IntDouble evalValue=evaluator.evalValue.copyOf();
				svar.setData(evalValue);
			} catch (RecognitionException e) {
				Error.addEvaluationError("Parameter evaluation has error.");

			}			
			
			
						
		}
		

	}
	
	
	private static Map<String, Svar> convertParamMapToSvarMap(
			Map<String, ParamTemp> simpleMap) {
		
		Map<String, Svar> pm = new HashMap<String, Svar>();
		
		for (String key: simpleMap.keySet()){
			
			Svar svObj = new Svar();
			
			svObj.caseName.add(Param.defaultCaseName);
			svObj.caseCondition.add(Param.always);
			svObj.caseExpression.add(simpleMap.get(key).expression);
		    
			pm.put(key, svObj);
			
		}
		
		return pm;
	}
}
