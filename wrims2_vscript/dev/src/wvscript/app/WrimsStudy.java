package wvscript.app;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WrimsStudy {

	public File studyRunDir;
	public String configFile;
	//public String studyName;
	public Map<String,String> configMap;
	
	public WrimsStudy() {

		this.studyRunDir = null;
		this.configFile = null;
		//this.studyName = "";
		configMap = new HashMap<String,String>();
		
	}

}
