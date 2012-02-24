package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import wrimsv2.commondata.wresldata.Param;



public class DvarTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public boolean isInteger;
	public String format;
	public String kind;
	public String units;
	public String lowerBound;
	public String upperBound;
	public String condition;
	public String expression;
	public Set<String> dependants;
	
	// default is null
	public String timeArraySize;
	public String arraySize;	
	
	public DvarTemp(){
		isInteger=false;
		format=Param.undefined;
		kind=Param.undefined;
		units=Param.undefined;
		lowerBound=Param.undefined;
		upperBound=Param.undefined;
		condition = Param.always;
		expression=Param.undefined;
		dependants = new HashSet<String>();	
		
		timeArraySize=null;
		arraySize=null;
	}
	
}
	
