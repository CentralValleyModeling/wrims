package wrimsv2.evaluator;
import java.util.HashMap;

public class EvalExpression {
	private IntDouble intDouble;
	private HashMap<String, IntDouble> multiplier;
	
	public EvalExpression(){
		intDouble=new IntDouble(0, true);
		multiplier = new HashMap<String, IntDouble>();
	}
	
	public EvalExpression(IntDouble id){
		intDouble=id;
		multiplier = new HashMap<String, IntDouble>();
	}
	
	public IntDouble getValue(){
		return intDouble;
	}
	
	public void setValue(IntDouble intDouble){
		this.intDouble=intDouble;
	}
	
	public HashMap<String, IntDouble> getMultiplier(){
		return multiplier;
	}
	
	public void setMultiplier(HashMap<String, IntDouble> multiplier){
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
