package wrimsv2.commondata.wresldata;

import java.io.Serializable;
import wrimsv2.evaluator.ValueEvaluatorParser;


public class WeightElement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String weight;
	public String condition;
	public ValueEvaluatorParser weightParser;
	public ValueEvaluatorParser conditionParser;
	public String fromWresl;
	public int line=0;
	private double value;
	
	// default is zero
	public String timeArraySize;
	public ValueEvaluatorParser timeArraySizeParser;
	
	
	public WeightElement(){
		weight = Param.undefined;
		condition = Param.always;
		fromWresl = Param.undefined;
		
		timeArraySize = "0"; // default has no future time array
	}
	
	public void setValue(double value){
		this.value=value;		
	}

	public double getValue(){
		return value;		
	}
}
	
