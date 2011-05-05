package wrimsv2.commondata.wresldata;


public class WeightElement {
	


	public String weight;
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
	
