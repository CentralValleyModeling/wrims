package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudyTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<String> seqList;
	public Map<String, SequenceTemp> seqMap;
	public ArrayList<String> modelList;		
	public Map<String, ModelTemp> modelMap;
	
	public StudyTemp(){
		
		modelList = new ArrayList<String>();
		modelMap = new LinkedHashMap<String, ModelTemp>();	
		seqList = new ArrayList<String>();
		seqMap = new LinkedHashMap<String, SequenceTemp>();	
		
	}
	
}
