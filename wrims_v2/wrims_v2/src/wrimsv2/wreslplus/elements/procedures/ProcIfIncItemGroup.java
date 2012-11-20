package wrimsv2.wreslplus.elements.procedures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.evaluator.ValueEvaluatorLexer;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.wreslplus.elements.AliasTemp;
import wrimsv2.wreslplus.elements.DvarTemp;
import wrimsv2.wreslplus.elements.IfIncItemGroup;
import wrimsv2.wreslplus.elements.IncFileTemp;
import wrimsv2.wreslplus.elements.ModelTemp;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.SvarTemp;

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
			int index_ItemList = m.itemList.indexOf(gObj.id);
			int index_IncFileIDList = m.incFileIDList.indexOf(gObj.id);
			int index_svList = m.svList.indexOf(gObj.id);
			int index_dvList = m.dvList.indexOf(gObj.id);
			int index_asList = m.asList.indexOf(gObj.id);
			
			// when at least one condition is true
			if (indexOfFirstTrue>-1) {
			
				ArrayList<String> inc_item_list  = gObj.inc_item_list.get(indexOfFirstTrue);
				HashMap<String, IncFileTemp> incFMap = gObj.inc_files_map_list.get(indexOfFirstTrue);
				HashMap<String, SvarTemp> svarMap = gObj.inc_svar_map_list.get(indexOfFirstTrue);
				HashMap<String, DvarTemp> dvarMap = gObj.inc_dvar_map_list.get(indexOfFirstTrue);
				HashMap<String, AliasTemp> aliasMap = gObj.inc_alias_map_list.get(indexOfFirstTrue);				
				
				// svar replace 
				m.svList.remove(index_svList);
				m.svMap.remove(gObj.id);				
				ArrayList<String> svList = new ArrayList<String>(inc_item_list);
				svList.retainAll(svarMap.keySet());
				if (svList.size()>0){
					m.svList.addAll(index_svList,svList);
					m.svMap.putAll(svarMap);
				}

				// dvar replace 
				m.dvList.remove(index_dvList);
				m.dvMap.remove(gObj.id);
				ArrayList<String> dvList = new ArrayList<String>(inc_item_list);
				dvList.retainAll(dvarMap.keySet());
				if (dvList.size()>0){
					m.dvList.addAll(index_dvList,dvList);
					m.dvMap.putAll(dvarMap);
				}				

				// alias replace 
				m.asList.remove(index_asList);
				m.asMap.remove(gObj.id);
				ArrayList<String> asList = new ArrayList<String>(inc_item_list);
				asList.retainAll(aliasMap.keySet());
				if (asList.size()>0){
					m.asList.addAll(index_asList,asList);
					m.asMap.putAll(aliasMap);
				}				

			
				m.itemList.remove(index_ItemList);
				m.itemTypeList.remove(index_ItemList);

			
				m.itemList.addAll(index_ItemList, inc_item_list);

				// TODO: improve this by prepare itemTypeList before here
				for (String dummy: gObj.inc_item_list.get(indexOfFirstTrue)) {
				
					if (incFMap.keySet().contains(dummy)){
						m.itemTypeList.add(index_ItemList, Param.incFileType);
					} 
					else if (svarMap.keySet().contains(dummy)){
						m.itemTypeList.add(index_ItemList, Param.svType);
					} 

				}
				
				
				m.incFileIDList.removeAll(Collections.singleton(gObj.id));
				
				ArrayList<String> fileIdList = new ArrayList<String>(inc_item_list);
				
				fileIdList.retainAll(incFMap.keySet());
				
				m.incFileIDList.addAll(index_IncFileIDList, fileIdList);
				
				m.incFileMap.remove(gObj.id);
				m.incFileMap.putAll(incFMap);


			}
			// no condition is true
			else { 

				// svar
				m.svList.remove(gObj.id);
				m.svMap.remove(gObj.id);

				// dvar
				m.dvList.remove(gObj.id);
				m.dvMap.remove(gObj.id);

				// alias
				m.asList.remove(gObj.id);
				m.asMap.remove(gObj.id);
				
				m.itemList.remove(index_ItemList);
				m.itemTypeList.remove(index_ItemList);
				
				// inc file
				m.incFileIDList.removeAll(Collections.singleton(gObj.id));
				m.incFileMap.remove(gObj.id);

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
