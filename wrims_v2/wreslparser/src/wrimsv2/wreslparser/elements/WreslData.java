package wrimsv2.wreslparser.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class WreslData {
	
	public String absMainFilePath;
	
	public ArrayList<String> sequence_of_models;
	
	/// this map will collect detailed info for models			
	public Map<String, SimulationDataSet> model_dataset_map;
	
	/// global variables in first cycle
	public SimulationDataSet global_vars;
	
	
	public WreslData(){
		
		sequence_of_models = new ArrayList<String>();	
		
		/// this map will collect detailed info for models			
		model_dataset_map = new HashMap<String, SimulationDataSet>();
			
		/// cumulative global vars and include files
		global_vars = new SimulationDataSet();
		
	}

	  
}

