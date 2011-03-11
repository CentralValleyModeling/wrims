package wrimsv2.wreslparser.elements;

import java.util.HashMap;
import java.util.Map;

public class PairMap {
    public Map<String, Dataset> fileDataMap = new HashMap<String, Dataset>();
    public Map<String, Dataset> modelAdhocMap = new HashMap<String, Dataset>();

    public PairMap() {

    }
    
    public PairMap(Map<String, Dataset> fileMap, Map<String, Dataset> modelMap) {
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
