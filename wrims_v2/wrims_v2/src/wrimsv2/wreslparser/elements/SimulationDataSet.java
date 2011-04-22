package wrimsv2.wreslparser.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;

public class SimulationDataSet {
	

	public String currentAbsolutePath;
	public String currentAbsoluteParent;


	// / models appear in this parsed file
	public ArrayList<String> model_list = new ArrayList<String>();
	public ArrayList<String> error_model_redefined = new ArrayList<String>();

	// / sequence
	// TODO: error is not added yet
	public ArrayList<String> error_sequence_redefined = new ArrayList<String>();
	public ArrayList<Integer> error_sequence_order_redefined = new ArrayList<Integer>();
	
	public Map<Integer, Sequence> seqMap = new HashMap<Integer, Sequence>();
	public ArrayList<String> seqList = new ArrayList<String>();

	
	// / weight table   // <objName,  <itemName, value>>


	public ArrayList<String> wtList = new ArrayList<String>();	
	public ArrayList<String> wtList_global = new ArrayList<String>();
	public ArrayList<String> wtList_local = new ArrayList<String>();
	public Map<String, WeightElement> wtMap = new HashMap<String, WeightElement>();
	public Map<String,String> error_weightVar_redefined = new HashMap<String, String>();
	

	
	// / includeFile data structure
	public ArrayList<String> incFileList = new ArrayList<String>();
	public ArrayList<String> incFileList_global = new ArrayList<String>();
	public ArrayList<String> incFileList_local = new ArrayList<String>();
	public Map<String, IncludeFile> incFileMap = new HashMap<String, IncludeFile>();
	public ArrayList<String> error_includeFile_redefined = new ArrayList<String>();

	// / svar, dvar, alias, !!! Not including goal
	public Map<String, String> var_all = new HashMap<String, String>();
	public Map<String, String> error_var_redefined = new HashMap<String, String>();

	// / external function structure
	public ArrayList<String> exList = new ArrayList<String>();
	public ArrayList<String> exList_global = new ArrayList<String>();
	public ArrayList<String> exList_local = new ArrayList<String>();
	public Map<String, External> exMap = new HashMap<String, External>();

    //  / sv, ts, and dv list
	public ArrayList<String> svTsDvList = new ArrayList<String>();	
    
	//  / sv and ts list
	public ArrayList<String> svTsList = new ArrayList<String>();	
	
	
	// / svar timeseries data structure
	public ArrayList<String> tsList = new ArrayList<String>();
	public ArrayList<String> tsList_global = new ArrayList<String>();
	public ArrayList<String> tsList_local = new ArrayList<String>();
	public Map<String, Timeseries> tsMap = new HashMap<String, Timeseries>();
	
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
	public Map<String, String> error_goal_redefined = new HashMap<String, String>();
	
	public SimulationDataSet() {
	}

	public SimulationDataSet(SimulationDataSet s) {
		
		this.add(s);
	}	

	public SimulationDataSet overwrittenWith(SimulationDataSet s) {
		
		this.remove(s);
		this.add(s);
		return this;	
	}
	
	public SimulationDataSet overwrite(SimulationDataSet s) {
		
		SimulationDataSet p = new SimulationDataSet(s);
		p.remove(this);
		this.add(p);
		return this;
	}
	

	public boolean hasDuplicateIn(SimulationDataSet s, String filePath, Map<String,Set<String>> reverseMap){
		
		boolean b = false;

		if(s==null) System.out.println("Fatal error!!! SimulationDataSet is null in file: "+filePath);

		for (String e : s.wtList){ 
			if (this.wtList.contains(e)) {
				String f1 = s.wtMap.get(e).fromWresl; //String f1 = filePath;
				String f2 = this.wtMap.get(e).fromWresl;
				LogUtils.errMsg("Weight table variable redefined: "+e, f1, f2, reverseMap);
				b = true;
			}
		}
		
		for (String e : s.incFileList){ 
			if (this.incFileList.contains(e)) {

				// TODO: does this work???
				String f1 = s.incFileMap.get(e).fromWresl; //String f1 = filePath;
				String f2 = this.incFileMap.get(e).fromWresl;
				LogUtils.errMsg("Include file redefined: "+e, f1, f2, reverseMap);
				b = true;			
			}
		}

		for (String e : s.tsList){ 
			if (this.tsList.contains(e)) {
				String f1 = s.tsMap.get(e).fromWresl; //String f1 = filePath;
				String f2 = this.tsMap.get(e).fromWresl;
				LogUtils.errMsg("State variable redefined: "+e, f1, f2, reverseMap);
				b = true;
			}
		}
		
		for (String e : s.svList){ 
			if (this.svList.contains(e)) {
				String f1 = s.svMap.get(e).fromWresl; //String f1 = filePath;
				String f2 = this.svMap.get(e).fromWresl;
				LogUtils.errMsg("State variable redefined: "+e, f1, f2, reverseMap);
				b = true;
			}
		}		

		for (String e : s.dvList){ 
			if (this.dvList.contains(e)) {	
				String f1 = s.dvMap.get(e).fromWresl;  //String f1 = filePath;
				String f2 = this.dvMap.get(e).fromWresl;
				LogUtils.errMsg("Decision varriable redefined: "+e, f1, f2, reverseMap);
				b = true;
			}
		}	

		for (String e : s.gList){ 
			if (this.gList.contains(e)) {				
				String f1 = s.gMap.get(e).fromWresl; //String f1 = filePath;
				String f2 = this.gMap.get(e).fromWresl;
				LogUtils.errMsg("Goal redefined: "+e, f1, f2, reverseMap);
				b = true;				
			}
		}
		
		for (String e : s.asList){ 
			if (this.asList.contains(e)) {
				String f1 = s.asMap.get(e).fromWresl; //String f1 = filePath;
				String f2 = this.asMap.get(e).fromWresl;
				LogUtils.errMsg("Alias redefined: "+e, f1, f2, reverseMap);
				b = true;	
			}
		}

		for (String e : s.model_list){ 
			if (this.model_list.contains(e)) {				
				// TODO: check 
				LogUtils.errMsg("Error!!! Model redefined: "+e+" in file: "+filePath);	
				b = true;
			}
		}
		
		for (String e : s.seqList){ 
			if (this.seqList.contains(e)) {
				// TODO: check 
				LogUtils.errMsg("Error!!! Sequence redefined: "+e+" in file: "+filePath);	
				b = true;
			}
		}
		return b;
		
	}
	
	public SimulationDataSet convertToLocal() {		

		if (!this.wtList.isEmpty()) {
			this.wtList_local = new ArrayList<String>();
			this.wtList_local.addAll(this.wtList);
			this.wtList_global = new ArrayList<String>();
		}
		
		if (!this.incFileList.isEmpty()) {
			this.incFileList_local = new ArrayList<String>();
			this.incFileList_local.addAll(this.incFileList);
			this.incFileList_global = new ArrayList<String>();
		}

		if (!this.tsList.isEmpty()) {
			this.tsList_local = new ArrayList<String>();
			this.tsList_local.addAll(this.tsList);
			this.tsList_global = new ArrayList<String>();
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


	
	public SimulationDataSet getGlobalVars() {
		
		SimulationDataSet out = new SimulationDataSet() ;

		if (!this.wtList_global.isEmpty()) {
			out.wtList.addAll(this.wtList_global);
			out.wtList_global.addAll(this.wtList_global);

			for (String key : this.wtList_global) {
				out.wtMap.put(key, this.wtMap.get(key));
			}
		}
		
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

		if (!this.tsList_global.isEmpty()) {
			out.tsList.addAll(this.tsList_global);
			out.tsList_global.addAll(this.tsList_global);

			for (String key : this.tsList_global) {
				out.tsMap.put(key, this.tsMap.get(key));
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

	
	public SimulationDataSet remove(SimulationDataSet s) {
		
		if (!s.svTsDvList.isEmpty()) this.svTsDvList.removeAll(s.svTsDvList);
		if (!s.svTsList.isEmpty()) this.svTsList.removeAll(s.svTsList);
		
		if (!s.wtList.isEmpty()) {
			this.wtList.removeAll(s.wtList);
			this.wtList_global.removeAll(s.wtList);
			this.wtList_local.removeAll(s.wtList);
			//this.wtMap.remove(s.wtList);
			Tools.mapRemoveAll(this.wtMap, s.wtList);
		}
		
		if (!s.incFileList.isEmpty()) {
			this.incFileList.removeAll(s.incFileList);
			this.incFileList_global.removeAll(s.incFileList);
			this.incFileList_local.removeAll(s.incFileList);
			//this.incFileMap.remove(s.incFileList);
			Tools.mapRemoveAll(this.incFileMap, s.incFileList);
		}

		if (!s.exList.isEmpty()) {
			this.exList.removeAll(s.exList);
			if (!s.exList_global.isEmpty()) {this.exList_global.removeAll(s.exList);}
			if (!s.exList_local.isEmpty()) {this.exList_local.removeAll(s.exList);}
			//this.exMap.remove(s.exList);
			Tools.mapRemoveAll(this.exMap, s.exList);
		}

		if (!s.tsList.isEmpty()) {
			this.tsList.removeAll(s.tsList);
			if (!s.tsList_global.isEmpty()) {this.tsList_global.removeAll(s.tsList);}
			if (!s.tsList_local.isEmpty()) {this.tsList_local.removeAll(s.tsList);}
			//this.svTsMap.remove(s.svTsList);
			Tools.mapRemoveAll(this.tsMap, s.tsList);
		}
		
		if (!s.svList.isEmpty()) {
			this.svList.removeAll(s.svList);
			if (!s.svList_global.isEmpty()) {this.svList_global.removeAll(s.svList);}
			if (!s.svList_local.isEmpty()) {this.svList_local.removeAll(s.svList);}
			//this.svMap.remove(s.svList);
			Tools.mapRemoveAll(this.svMap, s.svList);
		}

		if (!s.dvList.isEmpty()) {
			this.dvList.removeAll(s.dvList);
			if (!s.dvList_global.isEmpty()) {this.dvList_global.removeAll(s.dvList);}
			if (!s.dvList_local.isEmpty()) {this.dvList_local.removeAll(s.dvList);}
			//this.dvMap.remove(s.dvList);
			Tools.mapRemoveAll(this.dvMap, s.dvList);
		}
		if (!s.asList.isEmpty()) {
			this.asList.removeAll(s.gList);
			if (!s.asList_global.isEmpty()) {this.asList_global.removeAll(s.asList);}
			if (!s.asList_local.isEmpty()) {this.asList_local.removeAll(s.asList);}
			//this.asMap.remove(s.gList);
			Tools.mapRemoveAll(this.asMap, s.asList);
		}

		if (!s.gList.isEmpty()) {
			this.gList.removeAll(s.gList);
			if (!s.gList_global.isEmpty()) {this.gList_global.removeAll(s.gList);}
			if (!s.gList_local.isEmpty()) {this.gList_local.removeAll(s.gList);}
			//this.gMap.remove(s.gList);
			Tools.mapRemoveAll(this.gMap, s.gList);
		}

		if (!s.model_list.isEmpty()) {
			this.model_list.removeAll(s.model_list);
		}
		
		/// neglect sequence and seqMap

		return this;
	}	

	
	public SimulationDataSet add(SimulationDataSet s) {

		if (!s.svTsDvList.isEmpty()) this.svTsDvList.addAll(s.svTsDvList);
		if (!s.svTsList.isEmpty()) this.svTsList.addAll(s.svTsList);
		
		if (!s.wtList.isEmpty()) {
			this.wtList.addAll(s.wtList);
			if (!s.wtList_global.isEmpty()) {this.wtList_global.addAll(s.wtList_global);}
			if (!s.wtList_local.isEmpty()) {this.wtList_local.addAll(s.wtList_local);}
			this.wtMap.putAll(s.wtMap);
		}
		
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

		if (!s.tsList.isEmpty()) {
			this.tsList.addAll(0,s.tsList);
			if (!s.tsList_global.isEmpty()) {this.tsList_global.addAll(s.tsList_global);}
			if (!s.tsList_local.isEmpty()) {this.tsList_local.addAll(s.tsList_local);}
			this.tsMap.putAll(s.tsMap);
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
	
	
	
	public SimulationDataSet addNonDuplicate(SimulationDataSet s) {
		
		s.remove(this);		

		return this.add(s);
	}

	public SimulationDataSet dePrioritize(SimulationDataSet laterFileData, String filePath_forErrorMessage, Map<String,Set<String>> reverseMap) {

		/// check duplicate and demote later included file data to lower priority 
		if(laterFileData==null) System.out.println("Fatal error!!! SimulationDataSet is null in file: "+filePath_forErrorMessage);
		
		if ( this.hasDuplicateIn(laterFileData, filePath_forErrorMessage, reverseMap)) {
			this.overwrite(laterFileData);
		} else {
			this.add(laterFileData);
		}
		
		return this; // later data has lower priority
	}
	
	public SimulationDataSet prioritize_append(SimulationDataSet laterFileData, String filePath_forErrorMessage, Map<String,Set<String>> reverseMap) {

		/// check duplicate and promote later included file data to higher priority 
		if(laterFileData==null) System.out.println("Fatal error!!! SimulationDataSet is null in file: "+filePath_forErrorMessage);
		
		if ( this.hasDuplicateIn(laterFileData, filePath_forErrorMessage, reverseMap)) {
			this.remove(laterFileData);
		}
		
		return this.add(laterFileData); // later data has higher priority
	}

	public SimulationDataSet prioritize_prepend(SimulationDataSet laterFileData, String filePath_forErrorMessage, Map<String,Set<String>> reverseMap) {

		/// check duplicate and promote later included file data to higher priority 
		if(laterFileData==null) System.out.println("Fatal error!!! SimulationDataSet is null in file: "+filePath_forErrorMessage);
		
		if ( this.hasDuplicateIn(laterFileData, filePath_forErrorMessage, reverseMap)) {
			this.remove(laterFileData);
		}
		
		return this.insert(laterFileData); // later data has higher priority
	}	
	
	public SimulationDataSet prioritizeChildren(String nodeFile, Map<String,ArrayList<String>> t1Map, Map<String, SimulationDataSet> fileDataMap, Map<String,Set<String>> reverseMap ) {

		
		for (String childFile : t1Map.get(nodeFile)) {
			
			//System.out.println(" child file is: "+ childFile +" from node: " + nodeFile);
						
			if (t1Map.get(childFile)!=null)  this.prioritizeChildren(childFile, t1Map, fileDataMap, reverseMap);
			
			LogUtils.normalMsg("========== Prioritize file: " + childFile);
			this.prioritize_prepend(fileDataMap.get(childFile), childFile, reverseMap);
		}
		
		return this;
	}
	
	public ArrayList<String> getSortedList(Set<String> s) {
		return null;	
		
	}

	public SimulationDataSet insert(SimulationDataSet s) {
	
		if (!s.svTsDvList.isEmpty()) this.svTsDvList.addAll(0,s.svTsDvList);
		if (!s.svTsList.isEmpty()) this.svTsList.addAll(0,s.svTsList);
		
		if (!s.wtList.isEmpty()) {
			this.wtList.addAll(0,s.wtList);
			if (!s.wtList_global.isEmpty()) {this.wtList_global.addAll(0,s.wtList_global);}
			if (!s.wtList_local.isEmpty()) {this.wtList_local.addAll(0,s.wtList_local);}
			this.wtMap.putAll(s.wtMap);
		}
		
		if (!s.incFileList.isEmpty()) {
			this.incFileList.addAll(0,s.incFileList);
			if (!s.incFileList_global.isEmpty()) {this.incFileList_global.addAll(0,s.incFileList_global);}
			if (!s.incFileList_local.isEmpty()) {this.incFileList_local.addAll(0,s.incFileList_local);}
			this.incFileMap.putAll(s.incFileMap);
		}
	
		if (!s.exList.isEmpty()) {
			this.exList.addAll(0,s.exList);
			if (!s.exList_global.isEmpty()) {this.exList_global.addAll(0,s.exList_global);}
			if (!s.exList_local.isEmpty()) {this.exList_local.addAll(0,s.exList_local);}
			this.exMap.putAll(s.exMap);
		}
	
		if (!s.tsList.isEmpty()) {
			this.tsList.addAll(0,s.tsList);
			if (!s.tsList_global.isEmpty()) {this.tsList_global.addAll(0,s.tsList_global);}
			if (!s.tsList_local.isEmpty()) {this.tsList_local.addAll(0,s.tsList_local);}
			this.tsMap.putAll(s.tsMap);
		}
		
		if (!s.svList.isEmpty()) {
			this.svList.addAll(0,s.svList);
			if (!s.svList_global.isEmpty()) {this.svList_global.addAll(0,s.svList_global);}
			if (!s.svList_local.isEmpty()) {this.svList_local.addAll(0,s.svList_local);}
			this.svMap.putAll(s.svMap);
		}
	
		if (!s.dvList.isEmpty()) {
			this.dvList.addAll(0,s.dvList);
			if (!s.dvList_global.isEmpty()) {this.dvList_global.addAll(0,s.dvList_global);}
			if (!s.dvList_local.isEmpty()) {this.dvList_local.addAll(0,s.dvList_local);}
			this.dvMap.putAll(s.dvMap);
		}
		if (!s.asList.isEmpty()) {
			this.asList.addAll(0,s.asList);
			if (!s.asList_global.isEmpty()) {this.asList_global.addAll(0,s.asList_global);}
			if (!s.asList_local.isEmpty()) {this.asList_local.addAll(0,s.asList_local);}
			this.asMap.putAll(s.asMap);
		}
	
		if (!s.gList.isEmpty()) {
			this.gList.addAll(0,s.gList);
			if (!s.gList_global.isEmpty()) {this.gList_global.addAll(0,s.gList_global);}
			if (!s.gList_local.isEmpty()) {this.gList_local.addAll(0,s.gList_local);}
			this.gMap.putAll(s.gMap);
		}
	
		if (!s.model_list.isEmpty()) {
			this.model_list.addAll(0,s.model_list);
		}
		
		if (!s.seqList.isEmpty()) {
			this.seqList.addAll(0,s.seqList);
			this.seqMap.putAll(s.seqMap);
		}
	
		return this;
	}
}
