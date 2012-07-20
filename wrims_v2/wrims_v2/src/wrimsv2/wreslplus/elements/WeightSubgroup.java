package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;

import wrimsv2.commondata.wresldata.Param;

public class WeightSubgroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String id;
	public ArrayList<String> varList;
	public String commonPenalty;
	public ArrayList<WeightSubgroup> subgroup;
	
	public WeightSubgroup(){
		varList = new ArrayList<String>();
		commonPenalty = Param.zero; // default is zero
		subgroup = new ArrayList<WeightSubgroup>();

	}
	
}
	
