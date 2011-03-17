package wrimsv2.evaluator;

import wrimsv2.components.ControlData;
import java.util.Date;

public class TimeOperation {
	public static int monthValue(String month){
		if (month == "jan"){
			return 1;
		}else if (month == "feb"){
			return 2;
		}else if (month == "mar"){
			return 3;
		}else if (month == "apr"){
			return 4;
		}else if (month == "may"){
			return 5;
		}else if (month == "jun"){
			return 6;
		}else if (month == "jul"){
			return 7;
		}else if (month == "aug"){
			return 8;
		}else if (month == "sep"){
			return 9;
		}else if (month == "oct"){
			return 10;
		}else if (month == "nov"){
			return 11;
		}else{
			return 12;
		}
	}
	
	public static boolean isLeapYear(int year){
		if (year % 4 == 0) {
		    if (year % 100 != 0) {
		    	return true;
		    }else if (year % 400 == 0) {
		    	return true;
		    }else {
		    	return false;
		    }
		}else{
			return false;
		}
	}
	
	public static void findTime(int value){
		if (ControlData.timeStep.equals("month")){
			int detYear=value/12;
			int detMonth=value%12;
			ControlData.dataMonth=ControlData.currMonth+detMonth;
			ControlData.dataYear=ControlData.currYear+detYear;
			if (ControlData.dataMonth<1){
				ControlData.dataMonth=ControlData.dataMonth+12;
				ControlData.dataYear=ControlData.dataYear-1;
			}else if (ControlData.dataMonth>12){
				ControlData.dataMonth=ControlData.dataMonth-12;
				ControlData.dataYear=ControlData.dataYear+1;
			}
			int days=numberOfDays(ControlData.dataMonth, ControlData.dataYear);
			if (ControlData.currDay<=days){
				ControlData.dataDay=ControlData.currDay;
			}else{
				ControlData.dataDay=days-numberOfDays(ControlData.currMonth, ControlData.currYear)+ControlData.currDay;
			}
		}else if(ControlData.timeStep.equals("day")){
			Date currDate = new Date (ControlData.currYear, ControlData.currMonth-1, ControlData.currDay);
			long dataTime=currDate.getTime()+value;
			Date dataDate = new Date (dataTime);
			ControlData.dataMonth=dataDate.getMonth()+1;
			ControlData.dataYear=dataDate.getYear();
		}
	}
	
	public static int numberOfDays(int month, int year){
		int days;
		if (month==1 || month==3 || month==5 || month==7 
				||month==8 || month==10 ||month==12){
			days=31;
		}else if (month==4|| month==6 || month==9 || month==11){ 
			days=30;
		}else {
			if (TimeOperation.isLeapYear(year)){
				days=29;
			}else{
				days=28;
			}
		}
		return days;
	}
	
}
