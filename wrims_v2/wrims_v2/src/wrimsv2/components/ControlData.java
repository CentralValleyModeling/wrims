package wrimsv2.components;

import vista.db.dss.DSSDataWriter;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.sunsetsoft.xa.Optimizer;

public class ControlData {
	public static int currTimeStep;
	public static StudyDataSet currStudyDataSet=new StudyDataSet();
	public static ModelDataSet currModelDataSet=new ModelDataSet();
	public static Map<String, Svar> currSvMap=new HashMap<String, Svar>() ;
	public static Map<String, Svar> currSvFutMap=new HashMap<String, Svar>() ;
	public static Map<String, Timeseries> currTsMap=new HashMap<String, Timeseries>();
	public static Map<String, Dvar> currDvMap=new HashMap<String, Dvar>();
	public static Map<String, Dvar> currDvSlackSurplusMap=new HashMap<String, Dvar>();
	public static Map<String, Alias> currAliasMap=new HashMap<String, Alias>();
	public static Map<String, Goal> currGoalMap=new HashMap<String, Goal>();
	public static Map<String, External> currExMap = new HashMap<String, External> ();
	public static Map<String, Timeseries> allTsMap=new HashMap<String, Timeseries>();
	public static Map<String, String> allExternalFunction = new HashMap<String, String> ();
	public static Map<String, ExternalFunction> allExternalFunctionMap = new HashMap<String, ExternalFunction>();  
	public static ArrayList<String> allDll= new ArrayList<String>() ;
	public static String currCycleName;
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
	public static int writeDssStartYear;
	public static int writeDssStartMonth;
	public static int writeDssStartDay;
	public static int endYear ;
	public static int endMonth;
	public static int endDay;
	public static int totalTimeStep;
	public static Date startTime;
	public static String simulationTimeFrame;
	public static String partA;
	public static String svDvPartF;
	public static String initPartF;
	public static Stack<LoopIndex> sumIndex= new Stack <LoopIndex>();
	public static int timeArrayIndex;
	public static Group groupInit;
	public static Group groupSvar;
	public static DSSDataWriter writer;
	public static String solverName;
	public static Optimizer xasolver;
	public static boolean isPostProcessing=false;
	public static boolean sendAliasToDvar=false;
	public static boolean outputWreslCSV=true;
	public static boolean showRunTimeMessage=false;
	public static boolean showWreslLog=true;



	
	public ControlData(){
	}
	
	public static String getPartE(){
		return timeStep;
	}
}
