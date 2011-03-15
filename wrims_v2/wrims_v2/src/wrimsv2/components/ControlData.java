package wrimsv2.components;

public class ControlData {
	public static int currCycleIndex;
	public static int currFileTypeIndex; //0=sv; 1=dv; 2=constraint; 3=alias
	public static String currEvalName;
	public static int currMonth;
	public static int currWateryear;
	
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
}
