package wrimsv2.evaluator;

public class LoopIndex {
	private String name;
	private int value;
	
	public LoopIndex(String name, int value){
		this.name=name;
		this.value=value;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setValue(int value){
		this.value=value;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
}
