package wrimsv2.commondata.wresldata;

import java.io.Serializable;
import java.util.ArrayList;

import wrimsv2.evaluator.ValueEvaluatorParser;


public class WeightElement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String weight;
	public ValueEvaluatorParser weightParser;
	public String fromWresl;
	private double value;
	
	public WeightElement(){
		weight = Param.undefined;
		fromWresl = Param.undefined;

	}
	
	public void setValue(double value){
		this.value=value;		
	}

	public double getValue(){
		return value;		
	}
}
	
