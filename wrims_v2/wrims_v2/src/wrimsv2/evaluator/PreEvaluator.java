package wrimsv2.evaluator;

import java.util.ArrayList;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.IntDouble;

public class PreEvaluator {
	private ArrayList<String> svList;
	private Map<String, Svar> svMap;

	public PreEvaluator(StudyDataSet sds ){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();
		for (int i=0; i<modelList.size(); i++){
			String model=modelList.get(i);
			ModelDataSet mds=modelDataSetMap.get(model);
			svList=mds.svList;
			svMap=mds.svMap;
			preEvaluateSvar();
		}
	}

	public void preEvaluateSvar(){
		for (String svName: svList){
			System.out.println("PreEvaluate svar "+svName);
			Svar svar=svMap.get(svName);
			ArrayList<String> caseCondition=svar.caseCondition;
			int i=-1;
			svar.caseConditionParsers=new ArrayList<ValueEvaluatorParser>();
			svar.caseExpressionParsers=new ArrayList<ValueEvaluatorParser>();
			while(i<=caseCondition.size()-2){
				i=i+1;
				String evalString="c: "+caseCondition.get(i);
				ANTLRStringStream stream = new ANTLRStringStream(evalString);
				ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				ValueEvaluatorParser evaluator = new ValueEvaluatorParser(tokenStream);
				svar.caseConditionParsers.add(evaluator);

				String evalString1="v: "+svar.caseExpression.get(i);
				ANTLRStringStream stream1 = new ANTLRStringStream(evalString1);
				ValueEvaluatorLexer lexer1 = new ValueEvaluatorLexer(stream1);
				TokenStream tokenStream1 = new CommonTokenStream(lexer1);
				ValueEvaluatorParser evaluator1 = new ValueEvaluatorParser(tokenStream1);
				svar.caseExpressionParsers.add(evaluator1);
			}
		}
	}
}
