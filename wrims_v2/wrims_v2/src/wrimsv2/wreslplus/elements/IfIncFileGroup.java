package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import wrimsv2.commondata.wresldata.Param;

public class IfIncFileGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String id;
	
	public ArrayList<String> if_list;
	public ArrayList<ArrayList<String>> elseif_list_list;
	public ArrayList<String> else_list;
	
	public Map<String, IncFileTemp> if_map;
	public ArrayList<HashMap<String, IncFileTemp>> elseif_map_list;
	public Map<String, IncFileTemp> else_map;
	
	public String if_condition;
	public String elseif_condition;
	public String else_condition;
	
	public IfIncFileGroup(){
		
		if_list = new ArrayList<String>();
		elseif_list_list = new ArrayList<ArrayList<String>>();
		else_list = new ArrayList<String>();
		
		if_map = new HashMap<String, IncFileTemp>();
		elseif_map_list = new ArrayList<HashMap<String,IncFileTemp>>();
		else_map = new HashMap<String, IncFileTemp>();
		
		if_condition = "";
		elseif_condition = "";
		else_condition = "";

	}
	
}
	
