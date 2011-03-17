package wrimsv2.evaluator;

import wrimsv2.components.ControlData;

public class TimeOperation {
	public static int findWaterMonth(String month){
		if (month == "jan"){
			return 4;
		}else if (month == "feb"){
			return 5;
		}else if (month == "mar"){
			return 6;
		}else if (month == "apr"){
			return 7;
		}else if (month == "may"){
			return 8;
		}else if (month == "jun"){
			return 9;
		}else if (month == "jul"){
			return 10;
		}else if (month == "aug"){
			return 11;
		}else if (month == "sep"){
			return 12;
		}else if (month == "oct"){
			return 1;
		}else if (month == "nov"){
			return 2;
		}else{
			return 3;
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
		if (ControlData.timeStep=="month"){
			int detYear=value/12;
			int detMonth=value%12;
			ControlData.dataWaterMonth=ControlData.currWaterMonth+detMonth;
			ControlData.dataWaterYear=ControlData.currWaterYear+detYear;
			if (ControlData.dataWaterMonth<1){
				ControlData.dataWaterMonth=ControlData.dataWaterMonth+12;
				ControlData.dataWaterYear=ControlData.dataWaterYear-1;
			}else if (ControlData.dataWaterMonth>12){
				ControlData.dataWaterMonth=ControlData.dataWaterMonth-12;
				ControlData.dataWaterYear=ControlData.dataWaterYear+1;
			}
			
		}
	}
	
	public static int numberOfDays(int waterMonth, int waterYear){
		int days;
		if (waterMonth==1 || waterMonth==3 || waterMonth==4 || waterMonth==6 
				||waterMonth==8 || waterMonth==10 ||waterMonth==11){
			days=31;
		}else if (waterMonth==2|| waterMonth==7 || waterMonth==9 || waterMonth==12){ 
			days=30;
		}else {
			if (TimeOperation.isLeapYear(waterYear)){
				days=29;
			}else{
				days=28;
			}
		}
		return days;
	}
	
}
