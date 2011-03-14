package wrimsv2.wreslparser.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudyConfig {
    public String absMainFilePath;
	public Map<Integer, Sequence> sequenceMap = new HashMap<Integer, Sequence>();
	public ArrayList<Integer> sequenceOrder = new ArrayList<Integer>();
	public ArrayList<String> sequenceList = new ArrayList<String>();
    public Map<String, SimulationDataSet> modelDataMap = new HashMap<String, SimulationDataSet>();

    public StudyConfig() {

    } 
    
};
