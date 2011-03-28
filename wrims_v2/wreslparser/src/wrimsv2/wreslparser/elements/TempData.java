package wrimsv2.wreslparser.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TempData {

	//public StudyConfig studyConfig;	
	
	public Map<String,SimulationDataSet> fileDataMap_wholeStudy ;	
	public Map<String,ArrayList<String>> t1Map_wholeStudy;	
	public Map<String,String> fileScopeMap_wholeStudy;	
	
	/// this map will collect detailed info for models			
	public Map<String, SimulationDataSet> model_dataset_map;

	/// map of model's global adhocs
	public Map<String, SimulationDataSet> model_global_adhoc_map;
	
	/// cumulative global vars and include files
	public SimulationDataSet cumulative_global_adhocs;
	
	public TempData(){
		
		//studyConfig = new StudyConfig();
		
		fileDataMap_wholeStudy  = new HashMap<String, SimulationDataSet>();	
		t1Map_wholeStudy = new HashMap<String, ArrayList<String>>();	
		fileScopeMap_wholeStudy = new HashMap<String, String>();	
		
		/// this map will collect detailed info for models			
		model_dataset_map = new HashMap<String, SimulationDataSet>();

		/// map of model's global adhocs
		model_global_adhoc_map = new HashMap<String, SimulationDataSet>();
			
		/// cumulative global vars and include files
		cumulative_global_adhocs = new SimulationDataSet();
		
	}

	  
}

