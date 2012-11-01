package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class IfIncFileGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String id;	

	public ArrayList<ArrayList<String>> inc_files_list;
	public ArrayList<HashMap<String, IncFileTemp>> inc_files_map_list;
	public ArrayList<String> conditionList;
	
	public IfIncFileGroup(){

		inc_files_list = new ArrayList<ArrayList<String>>();
		inc_files_map_list = new ArrayList<HashMap<String,IncFileTemp>>();
		conditionList = new ArrayList<String>();

	}
	
}
	
