package wrimsv2.wreslparser.elements;

import java.util.HashMap;
import java.util.Map;

public class PairMap {
    public Map<String, SimulationDataSet> fileDataMap = new HashMap<String, SimulationDataSet>();
    public Map<String, SimulationDataSet> modelAdhocMap = new HashMap<String, SimulationDataSet>();

    public PairMap() {

    }
    
    public PairMap(Map<String, SimulationDataSet> fileMap, Map<String, SimulationDataSet> modelMap) {
        this.fileDataMap = fileMap;
        this.modelAdhocMap = modelMap;
    }
    
    public PairMap add(PairMap inPair) {
    	
    	for (String fileKey: inPair.fileDataMap.keySet()){

        	if (this.fileDataMap.containsKey(fileKey)){ System.out.println("Error!! include file redefined: "+fileKey);}
        	else{ this.fileDataMap.putAll(inPair.fileDataMap);}
    	}
    	
    	for (String modelKey: inPair.modelAdhocMap.keySet()){

        	if (this.modelAdhocMap.containsKey(modelKey)){ System.out.println("Error!! model redefined: "+modelKey);}
        	else{ this.modelAdhocMap.putAll(inPair.modelAdhocMap);}
    	}

		return this;
    }    
    
};
