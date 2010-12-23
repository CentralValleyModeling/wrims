package evaluators;

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
        this.fileDataMap.putAll(inPair.fileDataMap);
        this.modelAdhocMap.putAll(inPair.modelAdhocMap);
		return this;
    }    
    
};
