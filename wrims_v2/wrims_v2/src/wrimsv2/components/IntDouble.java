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
}
