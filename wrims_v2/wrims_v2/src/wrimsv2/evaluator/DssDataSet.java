package wrimsv2.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.IntDouble;

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
	
	public ArrayList<Double> getTimeseriesDataWithOptions(String selMon, Date selSd, Date selEd){
		ArrayList<Double> selData=new ArrayList<Double>();
		int selMonVal=TimeOperation.monthValue(selMon);
		if (selMonVal==12 && !selMon.equalsIgnoreCase("all") && !selMon.equalsIgnoreCase("dec")){
			Error.addEvaluationError("Selected month in the exceedence function should be Jan,..., Dec or All");
			return selData;
		}
		Date dataDate = startTime;
		if (timeStep.equals("1MON")){
			dataDate=TimeOperation.backOneMonth(dataDate);
		}else{
			dataDate=TimeOperation.backOneDay(dataDate);
		}
		for (int i=0; i<data.size(); i++){
			if (dataDate.after(selEd)){
				return selData;
			}else if (dataDate.before(selSd)){
				if (timeStep.equals("1MON")){
					dataDate=TimeOperation.addOneMonth(dataDate);
				}else{
					dataDate=TimeOperation.addOneDay(dataDate);
				}
			}else{
				if (selMon.equalsIgnoreCase("all")){
					selData.add(data.get(i));
				}else if (dataDate.getMonth()+1==selMonVal){
					selData.add(data.get(i));
				}
				if (timeStep.equals("1MON")){
					dataDate=TimeOperation.addOneMonth(dataDate);
				}else{
					dataDate=TimeOperation.addOneDay(dataDate);
				}
			}
		}
		return selData;	
	}
	
	public static double getExceedence(ArrayList<Double> optedData, double exc) {
		int size = optedData.size();
		if (size==0){
			Error.addEvaluationError("The data in the specified time period and selected month(s) from the timeseries doesn't exist in the Exceedence function.");
			return 1.0;
		}
		Double[] values =optedData.toArray(new Double[size]);
		Arrays.sort(values);
		if (exc==1){
			return values[0];
		}
		double excIndex = (1.0-exc)*size;
		if (excIndex>=1.0){
			int index = (int) Math.floor(excIndex);
			double fract = excIndex-index;
			double value = values[index-1]+fract*(values[index]-values[index-1]);
			return value;
		}else{
			double value=values[0]-(1.0-excIndex)*(values[1]-values[0]);
			return value;
		}
	}
}
