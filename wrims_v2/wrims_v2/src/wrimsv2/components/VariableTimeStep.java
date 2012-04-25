package wrimsv2.components;

import java.util.ArrayList;
import java.util.Date;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.evaluator.TimeOperation;

public class VariableTimeStep {
	
	public static void setCycleTimeStep(StudyDataSet sds){
		String timeStep=sds.getModelTimeStepList().get(ControlData.currCycleIndex);
		if (timeStep.equals(Param.undefined)){
			ControlData.timeStep=ControlData.defaultTimeStep;
			ControlData.partE=ControlData.defaultTimeStep;
		}else{
			ControlData.timeStep=timeStep;
			ControlData.partE=timeStep;
		}
	}
	
	public static void setCycleEndDate(StudyDataSet sds){
		ArrayList<String> timeStepList=sds.getModelTimeStepList();
		String definedTimeStep;
		double priority=0.0;
		for (String timeStep: timeStepList){
			if (timeStep.equals("1MON") && priority<2.0){
				priority=2.0;
			}else if (timeStep.equals("1DAY") && priority<1.0){
				priority=1.0;
			}
		}
		if (priority==2.0){
			addOneMonthToCycleEndDate();
		}else if (priority==1.0){
			addOneDayToCycleEndDate();
		}
	}
	
	public static void setCycleStartDate(int day, int month, int year){
		ControlData.cycleStartDay=day;
		ControlData.cycleStartMonth=month;
		ControlData.cycleStartYear=year;
	}
	
	private static void addOneMonthToCycleEndDate(){
		ControlData.cycleEndMonth=ControlData.cycleStartMonth+1;
		ControlData.cycleEndYear=ControlData.cycleStartYear;
		if (ControlData.cycleEndMonth>12){
			ControlData.cycleEndMonth=ControlData.cycleEndMonth-12;
			ControlData.cycleEndYear=ControlData.cycleEndYear+1;
		}
		ControlData.cycleEndDay=1;
	}
	
	private static void addOneDayToCycleEndDate(){
		Date startDate = new Date (ControlData.cycleStartYear-1900, ControlData.cycleStartMonth-1, ControlData.cycleStartDay);
		long cycleEndTime=startDate.getTime()+1 * 24 * 60 * 60 * 1000l;
		Date cycleEndDate = new Date (cycleEndTime);
		ControlData.cycleEndMonth=cycleEndDate.getMonth()+1;
		ControlData.cycleEndYear=cycleEndDate.getYear()+1900;
		ControlData.cycleEndDay=cycleEndDate.getDate();
	}
	
	public static ArrayList<Integer> getTotalTimeStep(StudyDataSet sds){
		ArrayList<String> timeStepList=sds.getModelTimeStepList();
		ControlData.totalTimeStep=new ArrayList<Integer>();
		for (String timeStep: timeStepList){
			if (timeStep.equals("1MON")){
				ControlData.totalTimeStep.add((ControlData.endYear-ControlData.startYear)*12+(ControlData.endMonth-ControlData.startMonth)+1);
			}else{
				Date startDate = new Date (ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
				Date endDate=new Date (ControlData.endYear-1900, ControlData.endMonth-1, ControlData.endDay);
				long startTime=startDate.getTime();
				long endTime=endDate.getTime();
				double timestep=(endTime-startTime)/(24*60*60*1000l)+1;
				ControlData.totalTimeStep.add((int)timestep);
			}
		}
		return ControlData.totalTimeStep;
	}
	
	public static int getTotalTimeStep(String timeStep){
		if (timeStep.equals("1MON")){
			return (ControlData.endYear-ControlData.startYear)*12+(ControlData.endMonth-ControlData.startMonth)+1;
		}else{
			Date startDate = new Date (ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
			Date endDate=new Date (ControlData.endYear-1900, ControlData.endMonth-1, ControlData.endDay);
			long startTime=startDate.getTime();
			long endTime=endDate.getTime();
			double timestep=(endTime-startTime)/(24*60*60*1000l)+1;
			return (int)timestep;
		}
	}
	
	public static void procUndefinedTimeStep(StudyDataSet sds){
		ArrayList<String> timeStepList=sds.getModelTimeStepList();
		for (int i=0; i<timeStepList.size(); i++){
			if (timeStepList.get(i).equals("undefined")){
				timeStepList.set(i, ControlData.defaultTimeStep);
			}
		}
	}
	
	public static void initialCurrTimeStep(ArrayList<String> modelList){
		ControlData.currTimeStep=new ArrayList<Integer>();
		for (int i=0; i<modelList.size(); i++){
			ControlData.currTimeStep.add(0);
		}
	}
	
	public static void initialCycleStartDate(){
		ControlData.cycleStartDay=ControlData.startDay;
		ControlData.cycleStartMonth=ControlData.startMonth;
		ControlData.cycleStartYear=ControlData.startYear;
	}
	
	public static int checkEndDate(int day1, int month1, int year1, int day2, int month2, int year2){
		Date date1=new Date(year1-1900, month1-1, day1);
		Date date2=new Date(year2-1900, month2-1, day2);
		long time1=date1.getTime();
		long time2=date2.getTime();
		if (time1<time2){
			return -1;
		}else if (time1==time2){
			return 0;
		}else{
			return 1;
		}
	}
	
	public static void setCurrentDate(StudyDataSet sds, int day, int month, int year){
		String timeStep=sds.getModelTimeStepList().get(ControlData.currCycleIndex);
		if (timeStep.equals("1MON")){
			ControlData.currDay=TimeOperation.numberOfDays(month, year);
			ControlData.currMonth=month;
			ControlData.currYear=year;
		}else{
			ControlData.currDay=day;
			ControlData.currMonth=month;
			ControlData.currYear=year;	
		}
	}
}
