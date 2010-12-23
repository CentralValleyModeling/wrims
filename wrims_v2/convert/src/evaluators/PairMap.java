package evaluators;

import java.util.Map;

public class PairMap {
    public Map<String, Dataset> fileDataMap;
    public Map<String, Dataset> modelAdhocMap;

    public PairMap(Map<String, Dataset> fileMap, Map<String, Dataset> modelMap) {
        this.fileDataMap = fileMap;
        this.modelAdhocMap = modelMap;
    }
    
    public PairMap add(PairMap inPair) {
        this.fileDataMap.putAll(inPair.fileDataMap);
        this.modelAdhocMap.putAll(inPair.modelAdhocMap);
		return this;
    }    
    
};
