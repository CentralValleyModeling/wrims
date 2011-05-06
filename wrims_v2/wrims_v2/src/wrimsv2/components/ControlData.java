package wrimsv2.components;

import vista.db.dss.DSSUtil;
import vista.set.Group;
import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.evaluator.LoopIndex;
import wrimsv2.external.ExternalFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.sunsetsoft.xa.Optimizer;

public class ControlData {
	public static StudyDataSet currStudyDataSet=new StudyDataSet();
	public static ModelDataSet currModelDataSet=new ModelDataSet();
	public static Map<String, Svar> currSvMap=new HashMap<String, Svar>() ;
	public static Map<String, Timeseries> currTsMap=new HashMap<String, Timeseries>();
	public static Map<String, Dvar> currDvMap=new HashMap<String, Dvar>();
	public static Map<String, Alias> currAliasMap=new HashMap<String, Alias>();
	public static Map<String, Goal> currGoalMap=new HashMap<String, Goal>();
	public static Map<String, External> currExMap = new HashMap<String, External> ();
	public static Map<String, Timeseries> allTsMap=new HashMap<String, Timeseries>();
	public static Map<String, String> allExternalFunction = new HashMap<String, String> ();
	public static Map<String, ExternalFunction> allExternalFunctionMap = new HashMap<String, ExternalFunction>();  
	public static ArrayList<String> allDll= new ArrayList<String>() ;
	public static int currCycleIndex;
	public static int currEvalTypeIndex; //0=sv; 1=dv; 2=alias; 3=goal; 4=external; 5=timeseries define; 6=timeseries reading; 7=weight
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
	public static Group groupInit;
	public static Group groupSvar;
	public static Optimizer solver=new Optimizer(25000);
	
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
