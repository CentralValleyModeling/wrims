package wrimsv2.wreslplus.elements;

import java.io.Serializable;

import wrimsv2.commondata.wresldata.Param;

public class IncFileTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String id;
	public String rawPath;
	public String pathRelativeToRunDir;
	public String absPath;

	
	public IncFileTemp(){
		

	}
	
}
	
