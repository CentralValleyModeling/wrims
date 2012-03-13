package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModelTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String id;
	
	public ArrayList<String>  itemList;
	public ArrayList<String>  svList;
	public Map<String,SvarTemp> svMap;	
	public ArrayList<String>  dvList;
	public Map<String,DvarTemp> dvMap;	
	public ArrayList<String>  tsList;
	public Map<String,TimeseriesTemp> tsMap;
	public ArrayList<String>  exList;
	public Map<String,ExternalTemp> exMap;	
	public ArrayList<String>  glList;
	public ArrayList<String>  gl2List;
	public Map<String,GoalTemp> glMap;
	public Map<String,GoalTemp> gl2Map;
	public ArrayList<String>  ssList;
	public Map<String,DvarTemp> ssMap;
	public Map<String,WeightTemp> ssWeightMap;	

	
	public ModelTemp(){
		
		itemList = new ArrayList<String>();
		svList = new ArrayList<String>();
		svMap = new LinkedHashMap<String, SvarTemp>();	
		dvList = new ArrayList<String>();
		dvMap = new LinkedHashMap<String, DvarTemp>();	
		tsList = new ArrayList<String>();
		tsMap = new LinkedHashMap<String, TimeseriesTemp>();	
		exList = new ArrayList<String>();
		exMap = new LinkedHashMap<String, ExternalTemp>();		
		glList = new ArrayList<String>();
		glMap = new LinkedHashMap<String, GoalTemp>();	
		gl2List = new ArrayList<String>();
		gl2Map = new LinkedHashMap<String, GoalTemp>();	
		ssList = new ArrayList<String>();
		ssMap = new LinkedHashMap<String, DvarTemp>();	
		ssWeightMap = new LinkedHashMap<String, WeightTemp>();	
	}
	
}
	
