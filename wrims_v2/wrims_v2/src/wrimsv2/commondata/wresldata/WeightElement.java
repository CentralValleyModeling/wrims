package wrimsv2.commondata.wresldata;

import java.util.ArrayList;

import wrimsv2.evaluator.ValueEvaluatorParser;


public class WeightElement {
	


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
	
