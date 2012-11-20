package wrimsv2.wreslplus.elements.procedures;

import java.util.ArrayList;
import java.util.Collections;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.evaluator.ValueEvaluatorLexer;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.wreslplus.elements.IfIncItemGroup;
import wrimsv2.wreslplus.elements.ModelTemp;
import wrimsv2.wreslplus.elements.StudyTemp;

public class ProcIfIncItemGroup {

	private ProcIfIncItemGroup() {
	}

	public static void process(StudyTemp st){
		
		for (String q: st.modelList){
			
			ModelTemp m =  st.modelMap.get(q);
			
			process(m);
			
		}
		
	}

	public static void process(ModelTemp m){
		
		for ( String k : m.ifIncItemGroupIDList){
			
			IfIncItemGroup gObj = m.ifIncItemGroupMap.get(k);
			
			
			// good for debug
			gObj.conditionValueList = evaluateConditions(gObj.conditionList);			
			
			// find index
			int indexOfFirstTrue = gObj.conditionValueList.indexOf(true);
			
			if (indexOfFirstTrue>-1) {
			
				//System.out.println("~~ This condition index is true: "+indexOfFirstTrue);
				
				int index_ItemList = m.itemList.indexOf(gObj.id);
			
				m.itemList.remove(index_ItemList);
				m.itemTypeList.remove(index_ItemList);

			
				m.itemList.addAll(index_ItemList, gObj.inc_files_list.get(indexOfFirstTrue));

				// TODO: improve this
				for (String dummy: gObj.inc_files_list.get(indexOfFirstTrue)) {
				
					m.itemTypeList.add(index_ItemList, Param.incFileType);

				}
				
				
				int index_IncFileIDList = m.incFileIDList.indexOf(gObj.id);
				
				m.incFileIDList.removeAll(Collections.singleton(gObj.id));
				m.incFileIDList.addAll(index_IncFileIDList, gObj.inc_files_list.get(indexOfFirstTrue));
				
				m.incFileMap.remove(gObj.id);
				m.incFileMap.putAll(gObj.inc_files_map_list.get(indexOfFirstTrue));


			}

		}
		
	}

	// TODO: return the index that contains the first "true" value
	public static ArrayList<Boolean> evaluateConditions(ArrayList<String> conditionList){
		
		ArrayList<Boolean> ret = new ArrayList<Boolean>();
		
		for (String conditionExpression : conditionList) {
		
			String evalString="c: "+conditionExpression;
			ANTLRStringStream stream = new ANTLRStringStream(evalString);
			ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);

			ValueEvaluatorParser vep = new ValueEvaluatorParser(tokenStream);
		
			try {
				
				vep.evaluator();
				ret.add(vep.evalCondition);
				
				//if (vep.evalCondition) return ret;
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(" Error in ProcIfIncFileGroup ...");
				return null;
			}
						
		}
		
		return ret;
		
	}	
	
}
