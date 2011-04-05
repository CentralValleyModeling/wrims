package wrimsv2.components;

import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.evaluator.LoopIndex;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class ControlData {
	public static StudyDataSet currStudyDataSet=null;
	public static ModelDataSet currModelDataSet=null;
	public static Map<String, Svar> currSvMap=null;
	public static Map<String, Dvar> currDvMap=null;
	public static Map<String, Alias> currAliasMap=null;
	public static int currCycleIndex;
	public static int currEvalTypeIndex; //0=sv; 1=dv; 2=constraint; 3=alias
	public static String currEvalName;
	public static int currDay=1;
	public static int currMonth;
	public static int currYear;
	public static int dataDay;
	public static int dataMonth;
	public static int dataYear;
	public static String timeStep ="1MON"; //TO DO: allow input;
	public static String partE="1MON";
	public static int startYear;       //TO DO: allow input
	public static int startMonth;
	public static int startDay;
	public static int endYear ;
	public static int endMonth;
	public static int endDay;
	public static String simulationTimeFrame;
	public static String partA;
	public static String svDvPartF;
	public static String initPartF;
	public static Stack<LoopIndex> sumIndex= new Stack <LoopIndex>();
	
	public ControlData(){
		timeStep ="1MON"; //TO DO: allow input;
		startYear=1921;       //TO DO: allow input
		startMonth=10;
		startDay=1;
		endYear =2003;
		endMonth=9;
		endDay=30;
		simulationTimeFrame=TimeOperation.dssTimeFrame(startYear, startMonth, startDay, endYear, endMonth, endDay);
		partA = "CALSIM";
		partE = getPartE();
		svDvPartF = "2020D09E";
		initPartF = "2020D09E";
		currYear=startYear;
		currMonth=startMonth;
		currDay=startDay;
	}
	
	public static String getPartE(){
		return timeStep;
	}
}
