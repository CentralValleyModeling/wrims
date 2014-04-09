package wrimsv2_plugin.debugger.pa;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.TimeOperation;

public class PAProcRun {
	
	private int prePAStartYear=1921;
	private int prePAStartMonth=10;
	private int prePAStartDay=1;
	
	public PAProcRun(ILaunchConfiguration configuration){
		try {
			int startYear = Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_STARTYEAR, (String)null));
			int startMonth = TimeOperation.monthValue(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_STARTMONTH, (String)null));
			DebugCorePlugin.startYear=startYear;
			DebugCorePlugin.startMonth=startMonth;
		
			int endYear = Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_ENDYEAR, (String)null));
			int endMonth = TimeOperation.monthValue(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_ENDMONTH, (String)null));
			DebugCorePlugin.endYear=endYear;
			DebugCorePlugin.endMonth=endMonth;
		
			int startDay = Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_STARTDAY, (String)null));
			int endDay = Integer.parseInt(configuration.getAttribute(DebugCorePlugin.ATTR_WPP_ENDDAY, (String)null));
			DebugCorePlugin.startDay=startDay;
			DebugCorePlugin.endDay=endDay;
		} catch (NumberFormatException e) {
			WPPException.handleException(e);
		} catch (CoreException e) {
			WPPException.handleException(e);
		}
	}
	
	public boolean continueRun(){
		int diff=TimeOperation.diffInMin(DebugCorePlugin.paStartYear, DebugCorePlugin.paStartMonth, DebugCorePlugin.paStartDay, DebugCorePlugin.paEndYear, DebugCorePlugin.paEndMonth, DebugCorePlugin.paEndDay);
		if (diff<0){
			return false;
		}else{
			return true;
		}
	}
	
	public void initialPATime(){	
		DebugCorePlugin.paStartYear=DebugCorePlugin.startYear;
		DebugCorePlugin.paStartMonth=DebugCorePlugin.startMonth;
		DebugCorePlugin.paStartDay=DebugCorePlugin.startDay;
		prePAStartYear=DebugCorePlugin.paStartYear;
		prePAStartMonth=DebugCorePlugin.paStartMonth;
		prePAStartDay=DebugCorePlugin.paStartDay;
		getPAEndTime();
		
	}
	
	public void updatePATime(){
		getPAStartTime();
		getPAEndTime();
	}
	
	public void getPAEndTime(){
		int month=DebugCorePlugin.paStartMonth+DebugCorePlugin.paDuration;
		int year=(month-1)/12;
		DebugCorePlugin.paEndYear=DebugCorePlugin.paStartYear+year;
		DebugCorePlugin.paEndMonth=month-year*12;

		int daysIn=TimeOperation.numberOfDays(DebugCorePlugin.paEndMonth, DebugCorePlugin.paEndYear);
		DebugCorePlugin.paEndDay=DebugCorePlugin.paStartDay-1;	
		if (DebugCorePlugin.paEndDay<=0){
			DebugCorePlugin.paEndMonth=DebugCorePlugin.paEndMonth-1;
			if (DebugCorePlugin.paEndMonth<=0){
				DebugCorePlugin.paEndMonth=12;
				DebugCorePlugin.paEndYear=DebugCorePlugin.paEndYear-1;		
			}
			DebugCorePlugin.paEndDay=TimeOperation.numberOfDays(DebugCorePlugin.paEndMonth, DebugCorePlugin.paEndYear);			
		}else if (DebugCorePlugin.paEndDay>daysIn){
			DebugCorePlugin.paEndDay=daysIn;
		}
		
		int diff=TimeOperation.diffInMin(DebugCorePlugin.paEndYear, DebugCorePlugin.paEndMonth, DebugCorePlugin.paEndDay, DebugCorePlugin.endYear, DebugCorePlugin.endMonth, DebugCorePlugin.endDay);
		if (diff<0){
			DebugCorePlugin.paEndYear=DebugCorePlugin.endYear;
			DebugCorePlugin.paEndMonth=DebugCorePlugin.endMonth;
			DebugCorePlugin.paEndDay=DebugCorePlugin.endDay;
		}
	}
	
	public void getPAStartTime(){
		prePAStartYear=DebugCorePlugin.paStartYear;
		prePAStartMonth=DebugCorePlugin.paStartMonth;
		prePAStartDay=DebugCorePlugin.paStartDay;
		
		DebugCorePlugin.paStartYear=DebugCorePlugin.paEndYear;
		DebugCorePlugin.paStartMonth=DebugCorePlugin.paEndMonth;
		DebugCorePlugin.paStartDay=DebugCorePlugin.paEndDay+1;
		int daysIn=TimeOperation.numberOfDays(DebugCorePlugin.paStartMonth, DebugCorePlugin.paStartYear);
		if (DebugCorePlugin.paStartDay>daysIn){
			DebugCorePlugin.paStartDay=1;
			DebugCorePlugin.paStartMonth=DebugCorePlugin.paStartMonth+1;
			if (DebugCorePlugin.paStartMonth>12){
				DebugCorePlugin.paStartMonth=1;
				DebugCorePlugin.paStartYear=DebugCorePlugin.paStartYear+1;
			}
		}
	}

	public int getPrePAStartYear() {
		return prePAStartYear;
	}
	
	public int getPrePAStartMonth() {
		return prePAStartMonth;
	}
	
	public int getPrePAStartDay() {
		return prePAStartDay;
	}
}
