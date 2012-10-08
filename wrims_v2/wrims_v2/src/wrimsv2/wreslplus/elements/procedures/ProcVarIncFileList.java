package wrimsv2.wreslplus.elements.procedures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslplus.elements.ModelTemp;
import wrimsv2.wreslplus.elements.SequenceTemp;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.Tools;
import wrimsv2.wreslplus.elements.WeightSubgroup;
import wrimsv2.wreslplus.elements.WeightTable;

public class ProcVarIncFileList {

	private ProcVarIncFileList() {
	}

	public static void replaceIncFile( StudyTemp st) {
		
		
		for (HashSet<String> modSet : st.fileGroupOrder_incModel ){
			
			for (String modName: modSet ){
				
				ModelTemp mObj = st.modelMap.get(modName);
				
				replaceIncFile(mObj, st);
				
			}
			
		}	
	}

	// for main file only
	public static void replaceIncFile( ModelTemp mt, StudyTemp st) {
		
		// TODO: use retain Set to simplify codes
		mt.svIncFileList = new ArrayList<String>(mt.itemList);
		mt.svIncFileList.removeAll(mt.tsList);
		mt.svIncFileList.removeAll(mt.asList);
		mt.svIncFileList.removeAll(mt.dvList);
		mt.svIncFileList.removeAll(mt.glList);
		mt.svIncFileList.removeAll(mt.exList);
	
		mt.asIncFileList = new ArrayList<String>(mt.itemList);
		mt.asIncFileList.removeAll(mt.tsList);
		mt.asIncFileList.removeAll(mt.svList);
		mt.asIncFileList.removeAll(mt.dvList);
		mt.asIncFileList.removeAll(mt.glList);
		mt.asIncFileList.removeAll(mt.exList);
		
		mt.exIncFileList = new ArrayList<String>(mt.itemList);
		mt.exIncFileList.removeAll(mt.tsList);
		mt.exIncFileList.removeAll(mt.svList);
		mt.exIncFileList.removeAll(mt.dvList);
		mt.exIncFileList.removeAll(mt.glList);
		mt.exIncFileList.removeAll(mt.asList);
		
		for (String f : mt.incFileMap.keySet()){
			
			int index_1 = mt.svIncFileList.indexOf(f);
			int index_2 = mt.asIncFileList.indexOf(f);
			int index_3 = mt.exIncFileList.indexOf(f);
			
			// f might be a model
			
			if (st.incModelList_effective.contains(f)) {
				
				
				mt.svIncFileList.remove(index_1);	
				mt.svIncFileList.addAll(index_1, st.modelMap.get(f).svIncFileList_post);	

				mt.asIncFileList.remove(index_2);
				mt.asIncFileList.addAll(index_2, st.modelMap.get(f).asIncFileList_post);

				mt.exIncFileList.remove(index_3);
				mt.exIncFileList.addAll(index_3, st.modelMap.get(f).exIncFileList_post);
				
				
			} else {						

				mt.svIncFileList.set(index_1, mt.incFileMap.get(f).pathRelativeToRunDir);			
				mt.asIncFileList.set(index_2, mt.incFileMap.get(f).pathRelativeToRunDir);
				mt.exIncFileList.set(index_3, mt.incFileMap.get(f).pathRelativeToRunDir);
			
			}
		}
		
		mt.svIncFileList_post = new ArrayList<String>(mt.svIncFileList);	
		mt.asIncFileList_post = new ArrayList<String>(mt.asIncFileList);
		mt.exIncFileList_post = new ArrayList<String>(mt.exIncFileList);
		
	}
	
	public static void replaceIncFile( ModelTemp mt) {
		
		// TODO: use retain Set to simplify codes
		mt.svIncFileList = new ArrayList<String>(mt.itemList);
		mt.svIncFileList.removeAll(mt.tsList);
		mt.svIncFileList.removeAll(mt.asList);
		mt.svIncFileList.removeAll(mt.dvList);
		mt.svIncFileList.removeAll(mt.glList);
		mt.svIncFileList.removeAll(mt.exList);
	
		mt.asIncFileList = new ArrayList<String>(mt.itemList);
		mt.asIncFileList.removeAll(mt.tsList);
		mt.asIncFileList.removeAll(mt.svList);
		mt.asIncFileList.removeAll(mt.dvList);
		mt.asIncFileList.removeAll(mt.glList);
		mt.asIncFileList.removeAll(mt.exList);
		
		mt.exIncFileList = new ArrayList<String>(mt.itemList);
		mt.exIncFileList.removeAll(mt.tsList);
		mt.exIncFileList.removeAll(mt.svList);
		mt.exIncFileList.removeAll(mt.dvList);
		mt.exIncFileList.removeAll(mt.glList);
		mt.exIncFileList.removeAll(mt.asList);
		
		for (String f : mt.incFileMap.keySet()){
			
			int index = mt.svIncFileList.indexOf(f);
			mt.svIncFileList.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
			
			index = mt.asIncFileList.indexOf(f);
			mt.asIncFileList.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
			
			index = mt.exIncFileList.indexOf(f);
			mt.exIncFileList.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
		}
		
		mt.svIncFileList_post = new ArrayList<String>(mt.svIncFileList);	
		mt.asIncFileList_post = new ArrayList<String>(mt.asIncFileList);
		mt.exIncFileList_post = new ArrayList<String>(mt.exIncFileList);
		
	}

	public static void replaceIncModel( StudyTemp st) {
		
		
		for (HashSet<String> modSet : st.fileGroupOrder_incModel ){
			
			for (String modName: modSet ){
				
				ModelTemp mObj = st.modelMap.get(modName);
				
				replaceIncModel(mObj, st);
				
			}
			
		}	
		
	}
	
	public static void replaceIncModel( ModelTemp mt, StudyTemp st) {

		
		for (String incM : mt.incModelList){
			
			int index = -1;
			
			ModelTemp incMObj = st.modelMap.get(incM);
						
			
			
			index = mt.svIncFileList_post.indexOf(incM);
			mt.svIncFileList_post.remove(index);
			mt.svIncFileList_post.addAll(index, incMObj.svIncFileList_post);
			
			index = mt.asIncFileList_post.indexOf(incM);
			mt.asIncFileList_post.remove(index);
			mt.asIncFileList_post.addAll(index, incMObj.asIncFileList_post);
			
			index = mt.exIncFileList_post.indexOf(incM);
			mt.exIncFileList_post.remove(index);
			mt.exIncFileList_post.addAll(index, incMObj.exIncFileList_post);
		}
				
		
	}
	
	
}
