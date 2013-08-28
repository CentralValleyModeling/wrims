package wvscript.app;

import java.util.HashMap;
import java.util.Map;

public class WrimsStudy {

	public String studyRunDir;
	public String studyName;
	public Map<String,String> configMap;
	
	public WrimsStudy() {

		this.studyRunDir = "";
		this.studyName = "";
		configMap = new HashMap<String,String>();
		
	}

}
