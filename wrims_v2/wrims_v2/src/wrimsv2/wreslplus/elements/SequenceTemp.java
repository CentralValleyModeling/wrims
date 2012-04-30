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

	// does not reflect user's input order
	public ArrayList<String> exList; 
	public ArrayList<String> dvList;
	public ArrayList<String> ssList_hasCase;
	public ArrayList<String> ssList_noCase;
	
	public ArrayList<String>  tsList;
	public Map<String,TimeseriesTemp> tsMap;
	
	public Map<String,SvarTemp> svMap;
	public Map<String,DvarTemp> dvMap;
	public Map<String,ExternalTemp> exMap;	
	
	public Map<String,DvarTemp> ssMap_hasCase;   // processed
	public Map<String,WeightTemp> ssWeightMap_hasCase;  // processed

	public Map<String,DvarTemp> ssMap_noCase;           // processed
	public Map<String,WeightTemp> ssWeightMap_noCase;   // processed
	
	public ArrayList<String> wvList_defaultType;
	public ArrayList<WeightTable> wTableObjList_defaultType; 
	
	public SequenceTemp(){
		
		exList = new ArrayList<String>();
		dvList = new ArrayList<String>();
		tsList = new ArrayList<String>();
		ssList_hasCase = new ArrayList<String>();
		ssList_noCase = new ArrayList<String>();
		
		tsMap = new HashMap<String, TimeseriesTemp>();
		svMap = new HashMap<String, SvarTemp>();
		dvMap = new HashMap<String, DvarTemp>();
		exMap = new HashMap<String, ExternalTemp>();
		
		ssMap_hasCase = new HashMap<String, DvarTemp>();
		ssWeightMap_hasCase = new HashMap<String, WeightTemp>();

		ssMap_noCase = new HashMap<String, DvarTemp>();
		ssWeightMap_noCase = new HashMap<String, WeightTemp>();
		
		wvList_defaultType = new ArrayList<String>();
		wTableObjList_defaultType = new ArrayList<WeightTable>();
		
	}
	
}
	
