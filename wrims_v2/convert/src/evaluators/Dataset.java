package evaluators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dataset {

	// / models appear in this parsed file
	public ArrayList<String> model_list = new ArrayList<String>();
	public ArrayList<String> error_model_redefined = new ArrayList<String>();

	// / sequence
	public Map<Integer, String> sequence_map = new HashMap<Integer, String>();
	public ArrayList<String> sequence_list = new ArrayList<String>();
	public ArrayList<String> error_sequence_redefined = new ArrayList<String>();
	
	// / includeFile data structure
	public ArrayList<String> incFileList = new ArrayList<String>();
	public ArrayList<String> incFileList_global = new ArrayList<String>();
	public ArrayList<String> incFileList_local = new ArrayList<String>();
	public Map<String, IncludeFile> incFileMap = new HashMap<String, IncludeFile>();
	public ArrayList<String> error_includeFile_redefined = new ArrayList<String>();

	// / svar, dvar, goal, alias
	public Map<String, String> var_all = new HashMap<String, String>();
	public Map<String, String> error_var_redefined = new HashMap<String, String>();
	
	// / svar data structure
	public ArrayList<String> svList = new ArrayList<String>();
	public ArrayList<String> svList_global = new ArrayList<String>();
	public ArrayList<String> svList_local = new ArrayList<String>();
	public Map<String, Svar> svMap = new HashMap<String, Svar>();

	// / dvar data structure
	public ArrayList<String> dvList = new ArrayList<String>();
	public ArrayList<String> dvList_global = new ArrayList<String>();
	public ArrayList<String> dvList_local = new ArrayList<String>();
	public Map<String, Dvar> dvMap = new HashMap<String, Dvar>();

	// / alias data structure
	public ArrayList<String> asList = new ArrayList<String>();
	public ArrayList<String> asList_global = new ArrayList<String>();
	public ArrayList<String> asList_local = new ArrayList<String>();
	public Map<String, Alias> asMap = new HashMap<String, Alias>();

	// / goal data structure
	public ArrayList<String> gList = new ArrayList<String>();
	public ArrayList<String> gList_global = new ArrayList<String>();
	public ArrayList<String> gList_local = new ArrayList<String>();
	public Map<String, Goal> gMap = new HashMap<String, Goal>();

	public Dataset() {
	}

	public Dataset(Dataset s) {
		
		this.add(s);
	}	


	public boolean hasDuplicateIn(Dataset s, String filePath){
		
		boolean b = false;
		
		for (String e : s.incFileList){ 
			if (this.incFileList.contains(e)) {
				System.out.println("Error!!! Include file redefined: "+e+" in file: "+filePath);
				b = true;
			}
		}
		
		for (String e : s.svList){ 
			if (this.svList.contains(e)) {
				System.out.println("Error!!! Svar redefined: "+e+" in file: "+filePath);
				b = true;
			}
		}		

		for (String e : s.dvList){ 
			if (this.dvList.contains(e)) {
				System.out.println("Error!!! Dvar redefined: "+e+" in file: "+filePath);	
				b = true;
			}
		}	

		for (String e : s.gList){ 
			if (this.gList.contains(e)) {
				System.out.println("Error!!! Goal redefined: "+e+" in file: "+filePath);	
				b = true;
			}
		}
		
		for (String e : s.asList){ 
			if (this.asList.contains(e)) {
				System.out.println("Error!!! Alias redefined: "+e+" in file: "+filePath);	
				b = true;
			}
		}

		for (String e : s.model_list){ 
			if (this.model_list.contains(e)) {
				System.out.println("Error!!! Model redefined: "+e+" in file: "+filePath);	
				b = true;
			}
		}
		
		for (String e : s.sequence_list){ 
			if (this.sequence_list.contains(e)) {
				System.out.println("Error!!! Sequence redefined: "+e+" in file: "+filePath);	
				b = true;
			}
		}
		return b;
		
	}
	
	public Dataset addToLocal(Object obj) {
		
		Dataset s = (Dataset)obj;
		

		if (!s.incFileList.isEmpty()) {
			this.incFileList.addAll(s.incFileList);
			this.incFileList_local.addAll(s.incFileList);
			this.incFileMap.putAll(s.incFileMap);
		}

		if (!s.svList.isEmpty()) {
			this.svList.addAll(s.svList);
			this.svList_local.addAll(s.svList);
			this.svMap.putAll(s.svMap);
		}

		if (!s.dvList.isEmpty()) {
			this.dvList.addAll(s.dvList);
			this.dvList_local.addAll(s.dvList);
			this.dvMap.putAll(s.dvMap);
		}
		if (!s.asList.isEmpty()) {
			this.asList.addAll(s.asList);
			this.asList_local.addAll(s.asList);
			this.asMap.putAll(s.asMap);
		}

		if (!s.gList.isEmpty()) {
			this.gList.addAll(s.gList);
			this.gList_local.addAll(s.gList);
			this.gMap.putAll(s.gMap);
		}

		if (!s.model_list.isEmpty()) {
			this.model_list.addAll(s.model_list);
		}

		return this;
	}	

	public Dataset convertToLocal() {		

		if (!this.incFileList.isEmpty()) {
			this.incFileList_local = new ArrayList<String>();
			this.incFileList_local.addAll(this.incFileList);
			this.incFileList_global = new ArrayList<String>();
		}

		if (!this.svList.isEmpty()) {
			this.svList_local = new ArrayList<String>();
			this.svList_local.addAll(this.svList);
			this.svList_global = new ArrayList<String>();
		}

		if (!this.dvList.isEmpty()) {
			this.dvList_local = new ArrayList<String>();
			this.dvList_local.addAll(this.dvList);
			this.dvList_global = new ArrayList<String>();
		}
		if (!this.asList.isEmpty()) {
			this.asList_local = new ArrayList<String>();
			this.asList_local.addAll(this.asList);
			this.asList_global = new ArrayList<String>();
		}

		if (!this.gList.isEmpty()) {
			this.gList_local = new ArrayList<String>();
			this.gList_local.addAll(this.gList);
			this.gList_global = new ArrayList<String>();
		}

		return this;
	}	


	
	public Dataset getGlobalVar() {
		
		Dataset out = new Dataset() ;

		if (!this.svList_global.isEmpty()) {
			out.svList.addAll(this.svList_global);
			out.svList_global.addAll(this.svList_global);

			for (String key : this.svList_global) {
				out.svMap.put(key, this.svMap.get(key));
			}
		}

		if (!this.dvList_global.isEmpty()) {
			out.dvList.addAll(this.dvList_global);
			out.dvList_global.addAll(this.dvList_global);

			for (String key : this.dvList_global) {
				out.dvMap.put(key, this.dvMap.get(key));
			}
		}

		if (!this.gList_global.isEmpty()) {
			out.gList.addAll(this.gList_global);
			out.gList_global.addAll(this.gList_global);

			for (String key : this.gList_global) {
				out.gMap.put(key, this.gMap.get(key));
			}
		}
		

		return out;
	}

	
	public Dataset remove(Object obj) {
		
		Dataset s = (Dataset)obj;

		
		if (!s.incFileList.isEmpty()) {
			this.incFileList.removeAll(s.incFileList);
			if (!s.incFileList_global.isEmpty()) {this.incFileList_global.removeAll(s.incFileList_global);}
			if (!s.incFileList_local.isEmpty()) {this.incFileList_local.removeAll(s.incFileList_local);}
			this.incFileMap.remove(s.incFileList);
		}

		if (!s.svList.isEmpty()) {
			this.svList.removeAll(s.svList);
			if (!s.svList_global.isEmpty()) {this.svList_global.removeAll(s.svList_global);}
			if (!s.svList_local.isEmpty()) {this.svList_local.removeAll(s.svList_local);}
			this.svMap.remove(s.svList);
		}

		if (!s.dvList.isEmpty()) {
			this.dvList.removeAll(s.dvList);
			if (!s.dvList_global.isEmpty()) {this.dvList_global.removeAll(s.dvList_global);}
			if (!s.dvList_local.isEmpty()) {this.dvList_local.removeAll(s.dvList_local);}
			this.dvMap.remove(s.dvList);
		}
		if (!s.asList.isEmpty()) {
			this.asList.removeAll(s.gList);
			if (!s.asList_global.isEmpty()) {this.asList_global.removeAll(s.asList_global);}
			if (!s.asList_local.isEmpty()) {this.asList_local.removeAll(s.asList_local);}
			this.asMap.remove(s.gList);
		}

		if (!s.gList.isEmpty()) {
			this.gList.removeAll(s.gList);
			if (!s.gList_global.isEmpty()) {this.gList_global.removeAll(s.gList_global);}
			if (!s.gList_local.isEmpty()) {this.gList_local.removeAll(s.gList_local);}
			this.gMap.remove(s.gList);
		}

		if (!s.model_list.isEmpty()) {
			this.model_list.removeAll(s.model_list);
		}
		
		if (!s.sequence_list.isEmpty()) {
			this.sequence_list.removeAll(s.sequence_list);
			this.sequence_map.remove(s.sequence_list);
		}

		return this;
	}	
	
	public Dataset add(Object obj) {
		
		Dataset s = (Dataset)obj;

		
		if (!s.incFileList.isEmpty()) {
			this.incFileList.addAll(s.incFileList);
			if (!s.incFileList_global.isEmpty()) {this.incFileList_global.addAll(s.incFileList_global);}
			if (!s.incFileList_local.isEmpty()) {this.incFileList_local.addAll(s.incFileList_local);}
			this.incFileMap.putAll(s.incFileMap);
		}

		if (!s.svList.isEmpty()) {
			this.svList.addAll(s.svList);
			if (!s.svList_global.isEmpty()) {this.svList_global.addAll(s.svList_global);}
			if (!s.svList_local.isEmpty()) {this.svList_local.addAll(s.svList_local);}
			this.svMap.putAll(s.svMap);
		}

		if (!s.dvList.isEmpty()) {
			this.dvList.addAll(s.dvList);
			if (!s.dvList_global.isEmpty()) {this.dvList_global.addAll(s.dvList_global);}
			if (!s.dvList_local.isEmpty()) {this.dvList_local.addAll(s.dvList_local);}
			this.dvMap.putAll(s.dvMap);
		}
		if (!s.asList.isEmpty()) {
			this.asList.addAll(s.asList);
			if (!s.asList_global.isEmpty()) {this.asList_global.addAll(s.asList_global);}
			if (!s.asList_local.isEmpty()) {this.asList_local.addAll(s.asList_local);}
			this.asMap.putAll(s.asMap);
		}

		if (!s.gList.isEmpty()) {
			this.gList.addAll(s.gList);
			if (!s.gList_global.isEmpty()) {this.gList_global.addAll(s.gList_global);}
			if (!s.gList_local.isEmpty()) {this.gList_local.addAll(s.gList_local);}
			this.gMap.putAll(s.gMap);
		}

		if (!s.model_list.isEmpty()) {
			this.model_list.addAll(s.model_list);
		}
		
		if (!s.sequence_list.isEmpty()) {
			this.sequence_list.addAll(s.sequence_list);
			this.sequence_map.putAll(s.sequence_map);
		}

		return this;
	}
	
	public Dataset prioritize(Dataset laterFileData, String filePath) {

		/// check duplicate and promote later included file data for higher priority 
		if ( this.hasDuplicateIn(laterFileData, filePath)) {
			this.remove(laterFileData);
		}
		
		return this.add(laterFileData); // later data has higher priority
	}
	
	
//	public Dataset addStruct(Object obj) {
//		
//		Struct s = (Struct)obj;
//
//		if (!s.incFileList.isEmpty()) {
//			this.incFileList.addAll(s.incFileList);
//			if (!s.incFileList_global.isEmpty()) {this.incFileList_global.addAll(s.incFileList_global);}
//			if (!s.incFileList_local.isEmpty()) {this.incFileList_local.addAll(s.incFileList_local);}
//			this.incFileMap.putAll(s.incFileMap);
//		}
//
//		if (!s.svList.isEmpty()) {
//			this.svList.addAll(s.svList);
//			if (!s.svList_global.isEmpty()) {this.svList_global.addAll(s.svList_global);}
//			if (!s.svList_local.isEmpty()) {this.svList_local.addAll(s.svList_local);}
//			this.svMap.putAll(s.svMap);
//		}
//
//		if (!s.dvList.isEmpty()) {
//			this.dvList.addAll(s.dvList);
//			if (!s.dvList_global.isEmpty()) {this.dvList_global.addAll(s.dvList_global);}
//			if (!s.dvList_local.isEmpty()) {this.dvList_local.addAll(s.dvList_local);}
//			this.dvMap.putAll(s.dvMap);
//		}
//		if (!s.asList.isEmpty()) {
//			this.asList.addAll(s.asList);
//			if (!s.asList_global.isEmpty()) {this.asList_global.addAll(s.asList_global);}
//			if (!s.asList_local.isEmpty()) {this.asList_local.addAll(s.asList_local);}
//			this.asMap.putAll(s.asMap);
//		}
//
//		if (!s.gList.isEmpty()) {
//			this.gList.addAll(s.gList);
//			if (!s.gList_global.isEmpty()) {this.gList_global.addAll(s.gList_global);}
//			if (!s.gList_local.isEmpty()) {this.gList_local.addAll(s.gList_local);}
//			this.gMap.putAll(s.gMap);
//		}
//
//		if (!s.model_list.isEmpty()) {
//			this.model_list.addAll(s.model_list);
//			this.model_order_map.putAll(s.model_order_map);
//		}
//
//		return this;
//	}
	
//	public Map<String, Dataset> addStructMap(Map<String, Struct> s){
//		
//		Map<String, Dataset> resultMap = new HashMap<String, Dataset>();
//		Dataset dataset;
//		
//		if (!s.isEmpty()) {
//			for (String key : s.keySet()){
//				dataset = new Dataset();
//				dataset.addStruct(s.get(key));
//				resultMap.put(key, dataset);
//			}
//		}
//		
//		return resultMap;
//
//	} 	
	
}
