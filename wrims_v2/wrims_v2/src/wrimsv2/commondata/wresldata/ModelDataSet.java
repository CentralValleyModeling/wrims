package wrimsv2.commondata.wresldata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class ModelDataSet {
	
	// / weight table   // <objName,  <itemName, value>>
	public ArrayList<String> wtList = new ArrayList<String>();	
	public Map<String, WeightElement> wtMap = new HashMap<String, WeightElement>();

	// / external function structure
	public ArrayList<String> exList = new ArrayList<String>();
	public Map<String, External> exMap = new HashMap<String, External>();
	
	// / svar timeseries data structure
	public ArrayList<String> svTsList = new ArrayList<String>();
	public Map<String, SvarTimeseries> svTsMap = new HashMap<String, SvarTimeseries>();
	
	// / svar data structure
	public ArrayList<String> svList = new ArrayList<String>();
	public Map<String, Svar> svMap = new HashMap<String, Svar>();

	// / dvar data structure
	public ArrayList<String> dvList = new ArrayList<String>();
	public Map<String, Dvar> dvMap = new HashMap<String, Dvar>();

	// / alias data structure
	public ArrayList<String> asList = new ArrayList<String>();
	public Map<String, Alias> asMap = new HashMap<String, Alias>();

	// / goal data structure
	public ArrayList<String> gList = new ArrayList<String>();
	public Map<String, Goal> gMap = new HashMap<String, Goal>();
	
	public ArrayList<String> incFileList=new ArrayList<String>();
 
}

