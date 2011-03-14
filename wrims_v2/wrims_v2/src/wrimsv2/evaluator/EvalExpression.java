package wrimsv2.evaluator;
import java.util.HashMap;

public class EvalExpression {
	private double doubleValue=0.0;
	private HashMap<String, Double> multiplier = new HashMap<String, Double>();
	
	public double getDoubleValue(){
		return doubleValue;
	}
	
	public void setDoubleValue(double value){
		this.doubleValue =value; 
	}
	
	public HashMap<String, Double> getMultiplier(){
		return multiplier;
	}
	
	public void setMultiplier(HashMap<String, Double> multiplier){
		this.multiplier=multiplier;
	}
	
	public boolean isNumeric(){
		if (multiplier.size()==0){
			return true;
		}else{
			return false;
		}
	}
}
