package wrimsv2.components;

import java.util.ArrayList;
import java.util.Date;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.evaluator.TimeOperation;

public class VariableTimeStep {
	
	static public void setCycleTimeStep(StudyDataSet sds){
		String timeStep=sds.getModelTimeStepList().get(ControlData.currCycleIndex);
		if (timeStep.equals(Param.undefined)){
			ControlData.timeStep=ControlData.defaultTimeStep;
			ControlData.partE=ControlData.defaultTimeStep;
		}else{
			ControlData.timeStep=timeStep;
			ControlData.partE=timeStep;
		}
	}
	
	static public void setCycleTargetDate(StudyDataSet sds){
		ArrayList<String> timeStepList=sds.getModelTimeStepList();
		String definedTimeStep;
		double priority=0.0;
		for (String timeStep: timeStepList){
			if (timeStep.equals(Param.undefined)){
				definedTimeStep=ControlData.defaultTimeStep;
			}else{
				definedTimeStep=timeStep;
			}
			if (definedTimeStep.equals("1MON") && priority<2.0){
				priority=2.0;
			}else if (definedTimeStep.equals("1Day") && priority<1.0){
				priority=1.0;
			}
		}
		if (priority==2.0){
			addOneMonthToTargetDate();
		}else if (priority==1.0){
			addOneDayToTargetDate();
		}
	}
	
	static private void addOneMonthToTargetDate(){
		ControlData.cycleTargetMonth=ControlData.currMonth+1;
		ControlData.cycleTargetYear=ControlData.currYear;
		if (ControlData.cycleTargetMonth>12){
			ControlData.cycleTargetMonth=ControlData.cycleTargetMonth-12;
			ControlData.cycleTargetYear=ControlData.cycleTargetYear+1;
		}
		ControlData.cycleTargetDay=TimeOperation.numberOfDays(ControlData.cycleTargetMonth, ControlData.cycleTargetYear);
	}
	
	static private void addOneDayToTargetDate(){
		Date currDate = new Date (ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay);
		long cycleTargetTime=currDate.getTime()+1 * 24 * 60 * 60 * 1000l;
		Date cycleTargetDate = new Date (cycleTargetTime);
		ControlData.cycleTargetMonth=cycleTargetDate.getMonth()+1;
		ControlData.cycleTargetYear=cycleTargetDate.getYear()+1900;
		ControlData.cycleTargetDay=cycleTargetDate.getDate();
	}
}
