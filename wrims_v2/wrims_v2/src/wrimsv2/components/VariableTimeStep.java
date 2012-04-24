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
	
	public static void setCycleTargetDate(StudyDataSet sds){
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
			addOneMonthToTargetDate();
		}else if (priority==1.0){
			addOneDayToTargetDate();
		}
	}
	
	private static void addOneMonthToTargetDate(){
		ControlData.cycleTargetMonth=ControlData.currMonth+1;
		ControlData.cycleTargetYear=ControlData.currYear;
		if (ControlData.cycleTargetMonth>12){
			ControlData.cycleTargetMonth=ControlData.cycleTargetMonth-12;
			ControlData.cycleTargetYear=ControlData.cycleTargetYear+1;
		}
		ControlData.cycleTargetDay=TimeOperation.numberOfDays(ControlData.cycleTargetMonth, ControlData.cycleTargetYear);
	}
	
	private static void addOneDayToTargetDate(){
		Date currDate = new Date (ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay);
		long cycleTargetTime=currDate.getTime()+1 * 24 * 60 * 60 * 1000l;
		Date cycleTargetDate = new Date (cycleTargetTime);
		ControlData.cycleTargetMonth=cycleTargetDate.getMonth()+1;
		ControlData.cycleTargetYear=cycleTargetDate.getYear()+1900;
		ControlData.cycleTargetDay=cycleTargetDate.getDate();
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
}
