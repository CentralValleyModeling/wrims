package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;

public class WeightGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ArrayList<String> varList;
	public String commonWeight;
	public String commonPenalty;

	
	
	public WeightGroup(){

		varList = new ArrayList<String>();

	}
	
}
	
