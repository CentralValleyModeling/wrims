package wrimsv2.evaluator;

import java.util.ArrayList;
import java.util.Date;

import wrimsv2.components.ControlData;

public class DssDataSet {
	private ArrayList<Double> data;
	private String timeStep;
	private String units;
	private String convertToUnits="";
	private String kind;
	private Date startTime;
	private boolean fromDssFile=false;
	private int studyStartIndex=-1;
	
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
	
	public void setUnits(String units){
		this.units=units;
	}
	
	public String getConvertToUnits(){
		return convertToUnits;
	}
	
	public void setConvertToUnits(String convertToUnits){
		this.convertToUnits=convertToUnits;
	}
	
	public String getUnits(){
		return units;
	}
	
	public void setKind(String kind){
		this.kind=kind;
	}
	
	public String getKind(){
		return kind;
	}
	
	public void generateStudyStartIndex(){
		Date st=getStartTime();
		long sTime=st.getTime();
		int sYear=st.getYear()+1900;
		int sMonth=st.getMonth(); //Originally it should be getMonth()-1. However, dss data store at 24:00 Jan31, 1921 is considered to store at 0:00 Feb 1, 1921 
		long studyStartTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay).getTime();
		if (getTimeStep().equals("1MON")){
			studyStartIndex=ControlData.startYear*12+ControlData.startMonth-(sYear*12+sMonth);
		}else{
			double indexValue=(studyStartTime-sTime)/(1000*60*60*24);
			studyStartIndex=(int)indexValue+2;
		}
	}
	
	public int getStudyStartIndex(){
		return studyStartIndex;
	}
}
