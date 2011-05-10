package wrimsv2.evaluator;

import java.util.ArrayList;
import java.util.Date;

public class DssDataSetFixLength {
	private double[] data;
	private String timeStep;
	private Date startTime;
	private boolean fromDssFile=false;
	
	public void setData(double[] data){
		this.data=data;
	}
	
	public double[] getData(){
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
