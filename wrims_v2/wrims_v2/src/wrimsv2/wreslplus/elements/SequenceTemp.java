package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SequenceTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String id;
	
	public String model;
	public String condition;
	public String order;	
	//public Map<String,SvarTemp> svMap;	
	
	
	public Map<String,SvarTemp> svMap;
	
	public SequenceTemp(){
		
		svMap = new HashMap<String, SvarTemp>();

	}
	
}
	
