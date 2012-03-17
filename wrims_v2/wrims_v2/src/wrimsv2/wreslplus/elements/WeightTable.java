package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.wresldata.Param;

public class WeightTable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String id;
	public String condition;
	public String fromWresl;
	public int line;
	public Set<String> dependants;
	public ArrayList<String> varList;
	public Map<String,String> varWeightMap;
	//public Map<String,LinkedHashSet<String>> varDependantMap;
	
	
	public WeightTable(){
		condition = Param.always;
		fromWresl = Param.undefined;
		dependants = new LinkedHashSet<String>();
		varList = new ArrayList<String>();
		varWeightMap = new LinkedHashMap<String, String>();
		//varDependantMap = new LinkedHashMap<String, LinkedHashSet<String>>();

	}
	
}
	
