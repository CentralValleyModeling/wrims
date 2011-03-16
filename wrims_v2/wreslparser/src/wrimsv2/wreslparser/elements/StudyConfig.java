package wrimsv2.wreslparser.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudyConfig {
    public String absMainFilePath;
	public Map<Integer, Sequence> sequenceMap;
	public ArrayList<Integer> sequenceOrder;
	public ArrayList<String> sequenceList;
	public ArrayList<String> model_list;
	public Map<String, SimulationDataSet> modelDataMap;

    public StudyConfig() {
    	
    	
        absMainFilePath=null;
    	sequenceMap = new HashMap<Integer, Sequence>();
    	sequenceOrder = new ArrayList<Integer>();
    	sequenceList = new ArrayList<String>();
    	model_list = new ArrayList<String>();
    	modelDataMap = new HashMap<String, SimulationDataSet>();


    } 
    
};
