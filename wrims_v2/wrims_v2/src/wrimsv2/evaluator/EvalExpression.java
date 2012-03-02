package wrimsv2.evaluator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import wrimsv2.components.ControlData;
import wrimsv2.components.IntDouble;

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
	
	public EvalExpression copyOf(){
		EvalExpression evalExpression = new EvalExpression();
		evalExpression.setMultiplier(copyOfMultiplier());
		evalExpression.setValue(intDouble.copyOf());
		return evalExpression;
	}
	
	public HashMap<String, IntDouble> copyOfMultiplier(){
		HashMap<String, IntDouble> newMultiplier=new HashMap<String, IntDouble>();
		Set multCollection = multiplier.keySet();
		Iterator multIterator = multCollection.iterator();
		
		while(multIterator.hasNext()){
			String multName=(String)multIterator.next();
			newMultiplier.put(multName, multiplier.get(multName));
		}
		return newMultiplier;
	}
}
