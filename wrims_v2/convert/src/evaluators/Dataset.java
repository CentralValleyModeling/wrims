package evaluators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dataset {

	// / models appear in this parsed file
	public ArrayList<String> model_list = new ArrayList<String>();
	public ArrayList<String> error_model_redefined = new ArrayList<String>();

	// / sequence
	// TODO: error is not added yet
	public ArrayList<String> error_sequence_redefined = new ArrayList<String>();
	public ArrayList<Integer> error_sequence_order_redefined = new ArrayList<Integer>();
	
	public Sequence seq;
	public Map<Integer, Sequence> seqMap = new HashMap<Integer, Sequence>();
	public ArrayList<String> seqList = new ArrayList<String>();

	
	
	
	
	// / includeFile data structure
	public ArrayList<String> incFileList = new ArrayList<String>();
	public ArrayList<String> incFileList_global = new ArrayList<String>();
	public ArrayList<String> incFileList_local = new ArrayList<String>();
	public Map<String, IncludeFile> incFileMap = new HashMap<String, IncludeFile>();
	public ArrayList<String> error_includeFile_redefined = new ArrayList<String>();

	// / svar, dvar, goal, alias
	public Map<String, String> var_all = new HashMap<String, String>();
	public Map<String, String> error_var_redefined = new HashMap<String, String>();

	// / external function structure
	public ArrayList<String> exList = new ArrayList<String>();
	public ArrayList<String> exList_global = new ArrayList<String>();
	public ArrayList<String> exList_local = new ArrayList<String>();
	public Map<String, External> exMap = new HashMap<String, External>();

	
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

		if(s==null) System.out.println("Fatal error!!! Dataset is null in file: "+filePath);

		for (String e : s.incFileList){ 
			if (this.incFileList.contains(e)) {
				System.out.println("Error!!! Include file redefined: "+e+" in file: "+filePath);
				b = true;
			}
		}
		
		for (String e : s.svList){ 
			if (this.svList.contains(e)) {
				System.out.println("Error!!! Svar redefined: "+e+" in file: "+filePath);
				ErrMsg.print("Svar redefined: "+e, filePath);
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
		
		for (String e : s.seqList){ 
			if (this.seqList.contains(e)) {
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

		if (!s.exList.isEmpty()) {
			this.exList.addAll(s.exList);
			this.exList_local.addAll(s.exList);
			this.exMap.putAll(s.exMap);
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


	
	public Dataset getGlobalVars() {
		
		Dataset out = new Dataset() ;

		if (!this.incFileList_global.isEmpty()) {
			out.incFileList.addAll(this.incFileList_global);
			out.incFileList_global.addAll(this.incFileList_global);

			for (String key : this.incFileList_global) {
				out.incFileMap.put(key, this.incFileMap.get(key));
			}
		}
		
		if (!this.exList_global.isEmpty()) {
			out.exList.addAll(this.exList_global);
			out.exList_global.addAll(this.exList_global);

			for (String key : this.exList_global) {
				out.exMap.put(key, this.exMap.get(key));
			}
		}
		
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

	
	public Dataset remove(Dataset s) {
		
		
		if (!s.incFileList.isEmpty()) {
			this.incFileList.removeAll(s.incFileList);
			this.incFileList_global.removeAll(s.incFileList);
			this.incFileList_local.removeAll(s.incFileList);
			this.incFileMap.remove(s.incFileList);
		}

		if (!s.exList.isEmpty()) {
			this.exList.removeAll(s.exList);
			if (!s.exList_global.isEmpty()) {this.exList_global.removeAll(s.exList);}
			if (!s.exList_local.isEmpty()) {this.exList_local.removeAll(s.exList);}
			this.exMap.remove(s.exList);
		}
		
		if (!s.svList.isEmpty()) {
			this.svList.removeAll(s.svList);
			if (!s.svList_global.isEmpty()) {this.svList_global.removeAll(s.svList);}
			if (!s.svList_local.isEmpty()) {this.svList_local.removeAll(s.svList);}
			this.svMap.remove(s.svList);
		}

		if (!s.dvList.isEmpty()) {
			this.dvList.removeAll(s.dvList);
			if (!s.dvList_global.isEmpty()) {this.dvList_global.removeAll(s.dvList);}
			if (!s.dvList_local.isEmpty()) {this.dvList_local.removeAll(s.dvList);}
			this.dvMap.remove(s.dvList);
		}
		if (!s.asList.isEmpty()) {
			this.asList.removeAll(s.gList);
			if (!s.asList_global.isEmpty()) {this.asList_global.removeAll(s.asList);}
			if (!s.asList_local.isEmpty()) {this.asList_local.removeAll(s.asList);}
			this.asMap.remove(s.gList);
		}

		if (!s.gList.isEmpty()) {
			this.gList.removeAll(s.gList);
			if (!s.gList_global.isEmpty()) {this.gList_global.removeAll(s.gList);}
			if (!s.gList_local.isEmpty()) {this.gList_local.removeAll(s.gList);}
			this.gMap.remove(s.gList);
		}

		if (!s.model_list.isEmpty()) {
			this.model_list.removeAll(s.model_list);
		}
		
		if (!s.seqList.isEmpty()) {
			this.seqList.removeAll(s.seqList);
			this.seqMap.remove(s.seqList);
		}

		return this;
	}	

	
	public Dataset add(Dataset s) {
		
		if (!s.incFileList.isEmpty()) {
			this.incFileList.addAll(s.incFileList);
			if (!s.incFileList_global.isEmpty()) {this.incFileList_global.addAll(s.incFileList_global);}
			if (!s.incFileList_local.isEmpty()) {this.incFileList_local.addAll(s.incFileList_local);}
			this.incFileMap.putAll(s.incFileMap);
		}

		if (!s.exList.isEmpty()) {
			this.exList.addAll(s.exList);
			if (!s.exList_global.isEmpty()) {this.exList_global.addAll(s.exList_global);}
			if (!s.exList_local.isEmpty()) {this.exList_local.addAll(s.exList_local);}
			this.exMap.putAll(s.exMap);
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
		
		if (!s.seqList.isEmpty()) {
			this.seqList.addAll(s.seqList);
			this.seqMap.putAll(s.seqMap);
		}

		return this;
	}
	
	
	
	public Dataset addNonDuplicate(Dataset s) {
		
		s.remove(this);		

		return this.add(s);
	}
	

	
	public Dataset prioritize(Dataset laterFileData, String filePath_forErrorMessage) {

		/// check duplicate and promote later included file data for higher priority 
		if(laterFileData==null) System.out.println("Fatal error!!! Dataset is null in file: "+filePath_forErrorMessage);
		
		if ( this.hasDuplicateIn(laterFileData, filePath_forErrorMessage)) {
			this.remove(laterFileData);
		}
		
		return this.add(laterFileData); // later data has higher priority
	}
	
	public Dataset prioritizeChildren(String nodeFile, Map<String,ArrayList<String>> t1Map, Map<String, Dataset> fileDataMap ) {

		
		for (String childFile : t1Map.get(nodeFile)) {
			
			//System.out.println(" child file is: "+ childFile +" from node: " + nodeFile);
						
			if (t1Map.get(childFile)!=null)  this.prioritizeChildren(childFile, t1Map, fileDataMap);
			
			System.out.println("========== Prioritize file: " + childFile);
			this.prioritize(fileDataMap.get(childFile), childFile);
		}
		
		return this;
	}

	
	

	
}
