package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SequenceTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String id;
	
	public String model;
	public String condition;
	public String order;	

	
	public Map<String,SvarTemp> svMap;
	public Map<String,DvarTemp> dvMap;
	
	public Map<String,DvarTemp> ssMap_hasCase;   // processed
	public Map<String,WeightTemp> ssWeightMap_hasCase;  // processed

	public Map<String,DvarTemp> ssMap_noCase;           // processed
	public Map<String,WeightTemp> ssWeightMap_noCase;   // processed
	
	public ArrayList<String> wvList_defaultType;
	public ArrayList<WeightTable> wTableObjList_defaultType; 
	
	public SequenceTemp(){
		
		svMap = new HashMap<String, SvarTemp>();
		dvMap = new HashMap<String, DvarTemp>();
		
		ssMap_hasCase = new HashMap<String, DvarTemp>();
		ssWeightMap_hasCase = new HashMap<String, WeightTemp>();

		ssMap_noCase = new HashMap<String, DvarTemp>();
		ssWeightMap_noCase = new HashMap<String, WeightTemp>();
		
		wvList_defaultType = new ArrayList<String>();
		wTableObjList_defaultType = new ArrayList<WeightTable>();
		
	}
	
}
	
