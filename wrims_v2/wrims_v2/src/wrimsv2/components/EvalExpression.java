package wrimsv2.components;
import java.util.HashMap;

public class EvalExpression {
	private String value="0.0";
	private HashMap<String, Double> multiplier = new HashMap<String, Double>();
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value =value; 
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
