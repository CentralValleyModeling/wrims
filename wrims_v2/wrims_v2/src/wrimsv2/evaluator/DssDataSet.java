package wrimsv2.evaluator;

import java.util.ArrayList;
import java.util.Date;

public class DssDataSet {
	private ArrayList<Double> data;
	private String timeStep;
	private Date startTime;
	private boolean fromDssFile=false;
	
	public void setData(ArrayList<Double> data){
		this.data=data;
	}
	
	public ArrayList<Double> getData(){
		return data;
	}
	
	public void setTimeStep(String timeStep){
		this.timeStep=timeStep;
	}
	
	public void setStartTime(Date st){
		startTime=st;
	}
	
	public Date getStartTime(){
		return startTime;
	}
	
	public String getTimeStep(){
		return timeStep;
	}
	
	public boolean fromDssFile(){
		return fromDssFile;
	}
	
	public void setFromDssFile(boolean fromDssFile){
		this.fromDssFile=fromDssFile;
	}
}
