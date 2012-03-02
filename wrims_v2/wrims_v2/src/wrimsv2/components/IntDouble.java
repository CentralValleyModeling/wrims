package wrimsv2.components;

public class IntDouble {
	private Number data;
	private boolean isInteger;
	
	public IntDouble(Number value, boolean isInt) {
		data=value;
		isInteger=isInt;
	}
	
	public Number getData(){
		return data;
	}
	
	public void setData (Number value){
		data=value;
	}
	
	public boolean isInt(){
		return isInteger;
	}
	
	public void setInt(boolean isInt){
		isInteger=isInt;
	}
	
	public IntDouble copyOf(){
		IntDouble newIntDouble;
		if (isInteger){
			newIntDouble= new IntDouble(data.intValue(), isInteger);
		}else{
			newIntDouble= new IntDouble(data.doubleValue(), isInteger);
		}
		return newIntDouble;
	}
}
