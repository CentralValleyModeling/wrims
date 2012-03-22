package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModelTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String id;
	public String absPath;
	public String parentAbsPath;
	public String pathRelativeToRunDir; //processed
	
	public ArrayList<String>  itemList;
	public ArrayList<String>  svIncFileList;   // processed twice
	public ArrayList<String> incFileIDList;
	public ArrayList<String> incFileRelativePathList; // processed
	public ArrayList<String> incFileAbsPathList;      // processed 
	public Map<String,IncFileTemp> incFileMap;
	
	public ArrayList<String>  wvList_defaultType; // added after processed
	public ArrayList<WeightTable> wTableObjList_defaultType; // added after processed
	public ArrayList<WeightTable> wTableObjList;  // raw data
	public ArrayList<String>  asList;
	public ArrayList<String>  asList_reduced; // added after processed
	public Map<String,AliasTemp> asMap;		
	public ArrayList<String>  svList;
	public Map<String,SvarTemp> svMap;	
	public ArrayList<String>  dvList;
	public Map<String,DvarTemp> dvMap;	
	public ArrayList<String>  dvList_fromAlias;  // processed
	public ArrayList<String>  tsList;
	public Map<String,TimeseriesTemp> tsMap;
	public ArrayList<String>  exList;
	public Map<String,ExternalTemp> exMap;	
	public ArrayList<String>  glList;
	public Map<String,GoalTemp> glMap;
	public ArrayList<String>  gl2List;
	public ArrayList<String>  glList_fromAlias;  // processed
 	public ArrayList<String>  ssList;
	public Map<String,DvarTemp> ssMap;
	public Map<String,WeightTemp> ssWeightMap;

	
	public ModelTemp(){
		
		itemList = new ArrayList<String>();
		svIncFileList = new ArrayList<String>();
		incFileIDList = new ArrayList<String>();
		incFileRelativePathList = new ArrayList<String>();
		incFileAbsPathList = new ArrayList<String>();
		incFileMap= new LinkedHashMap<String, IncFileTemp>();
		wvList_defaultType = new ArrayList<String>();
		wTableObjList_defaultType = new ArrayList<WeightTable>();
		wTableObjList = new ArrayList<WeightTable>();
		svList = new ArrayList<String>();  //raw data
		svMap = new HashMap<String, SvarTemp>();  // includes processed data	
		asList = new ArrayList<String>();
		asList_reduced = new ArrayList<String>();
		asMap = new LinkedHashMap<String, AliasTemp>();
		dvList = new ArrayList<String>();
		dvMap = new HashMap<String, DvarTemp>();
		dvList_fromAlias = new ArrayList<String>();
		tsList = new ArrayList<String>();
		tsMap = new HashMap<String, TimeseriesTemp>();	
		exList = new ArrayList<String>();
		exMap = new HashMap<String, ExternalTemp>();		
		glList = new ArrayList<String>();
		glMap = new HashMap<String, GoalTemp>();	
		gl2List = new ArrayList<String>();
		glList_fromAlias = new ArrayList<String>();
		ssList = new ArrayList<String>();
		ssMap = new LinkedHashMap<String, DvarTemp>();	
		ssWeightMap = new LinkedHashMap<String, WeightTemp>();	
	}
	
}
	
