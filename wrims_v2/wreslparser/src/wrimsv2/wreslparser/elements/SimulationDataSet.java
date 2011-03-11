package wrimsv2.wreslparser.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	public Map<String, WeightTable> wtMap = new HashMap<String, WeightTable>();
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
}
