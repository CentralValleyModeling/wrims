package evaluators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dataset {

	// / models appear in this parsed file
	public ArrayList<String> model_list = new ArrayList<String>();
	public ArrayList<String> error_model_redefined = new ArrayList<String>();

	// / sequence
	public Map<Integer, String> model_order_map = new HashMap<Integer, String>();
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
			this.model_order_map.putAll(s.model_order_map);
		}

		return this;
	}
	
	public Dataset addStruct(Object obj) {
		
		Struct s = (Struct)obj;

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
			this.model_order_map.putAll(s.model_order_map);
		}

		return this;
	}
	
	public Map<String, Dataset> addStructMap(Map<String, Struct> s){
		
		Map<String, Dataset> resultMap = new HashMap<String, Dataset>();
		Dataset dataset;
		
		if (!s.isEmpty()) {
			for (String key : s.keySet()){
				dataset = new Dataset();
				dataset.addStruct(s.get(key));
				resultMap.put(key, dataset);
			}
		}
		
		return resultMap;

	} 	
	
}
