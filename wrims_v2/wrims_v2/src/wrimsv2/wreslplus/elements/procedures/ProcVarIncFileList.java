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
		
		for (String m : st.modelList_effective){
	
			replaceIncFile(st.modelMap.get(m));
		
		}
		
		for (String m : st.incModelList_effective){
	
			replaceIncFile(st.modelMap.get(m));
		
		}
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


//	public static void replaceIncModel( ModelTemp mt) {
//		
//		
//		for (String f : mt.inc){
//			
//			int index = mt.svIncFileList_post.indexOf(f);
//			mt.svIncFileList_post.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
//			
//			index = mt.asIncFileList_post.indexOf(f);
//			mt.asIncFileList_post.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
//			
//			index = mt.exIncFileList_post.indexOf(f);
//			mt.exIncFileList_post.set(index, mt.incFileMap.get(f).pathRelativeToRunDir);
//		}
//		
//		
//	}
	
	
}
