package wrimsv2.evaluator;

public class LoopIndex {
	private String name;
	private int value;
	private boolean indexStart;
	
	public LoopIndex(String name, int value, boolean indexStart){
		this.name=name;
		this.value=value;
		this.indexStart=indexStart;
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
	
	public boolean getIndexStart(){
		return indexStart;
	}
	
	public void setIndexStart(boolean indexStart){
		this.indexStart=indexStart;
	}
}
