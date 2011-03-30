package wrimsv2.commondata.wresldata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StudyDataSet {
	
	public String absMainFilePath;
	
	public ArrayList<String> sequence_of_models;
	
	/// this map will collect detailed info for models			
	public Map<String, ModelDataSet> model_dataset_map;
	
	
	public StudyDataSet(){
		
		sequence_of_models = new ArrayList<String>();	
		
		/// <modelName, ModelDataSet>		
		model_dataset_map = new HashMap<String, ModelDataSet>();			
		
	}
	

}
