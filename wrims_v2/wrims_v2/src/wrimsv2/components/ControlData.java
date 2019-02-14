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
import wrimsv2.solver.ortools.OrToolsSolver;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Stack;

import lpsolve.LpSolve;

import com.sunsetsoft.xa.Optimizer;

public class ControlData {
	public static ArrayList<Integer> currTimeStep;
	public static StudyDataSet currStudyDataSet=new StudyDataSet();
	public static ModelDataSet currModelDataSet=new ModelDataSet();
	public static Map<String, Svar> parameterMap=new HashMap<String, Svar>();
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
	public static int currEvalTypeIndex; //0=sv; 1=dv; 2=alias; 3=goal; 4=external; 5=timeseries define; 6=timeseries reading; 7=weight; 8=initial_vars; 9=conditional_include
	public static String currEvalName;
	public static int currDay=1;
	public static int currMonth;
	public static int currYear;
	public static int dataDay;
	public static int dataMonth;
	public static int dataYear;
	public static String defaultTimeStep="1MON";
	public static String timeStep ="1MON"; 
	public static String partE="1MON";
	public static int startYear;       
	public static int startMonth;
	public static int startDay;
	public static int endYear ;
	public static int endMonth;
	public static int endDay;
	public static int cycleStartDay;
	public static int cycleStartMonth;
	public static int cycleStartYear;
	public static int cycleEndDay;
	public static int cycleEndMonth;
	public static int cycleEndYear;
	public static double cycleTimeStepPriority=0;
	public static ArrayList<Integer> totalTimeStep;
	public static Date monthlyStartTime;
	public static Date dailyStartTime;
	public static String simulationTimeFrame;
	public static String partA;
	public static String svDvPartF;
	public static String initPartF;
	public static Stack<LoopIndex> sumIndex= new Stack <LoopIndex>();
	public static int timeArrayIndex;
	public static Group groupInit;
	public static Group groupSvar;
	public static DSSDataWriter writer;
	public static String solverName="Cbc'";
	public static Optimizer xasolver;
	public static OrToolsSolver otsolver;
	//public static int cbcSolverOptions = 2;
	public static Double clp_cbc_objective;
	public static String clp_cbc_note="";
	public static double lpsolve_objective;
	public static double gurobi_objective;
	public static boolean isPostProcessing=false;
	public static boolean sendAliasToDvar=false;
	public static boolean outputWreslCSV=false;
	public static boolean showRunTimeMessage=false;
	public static boolean showWreslLog=true;
	public static boolean writeInitToDVOutput=true;
	public static int solverType;
	public static boolean isParseStudy=true;
	public static boolean ignoreError=false;
	public static boolean allowSvTsInit=false;
	public static int outputType=0;
	public static boolean outputCycleToDss=false;
	public static boolean initHDF5=false;
	public static double solverTime_xa=0;
	public static double solverTime_xa_this=0;
	public static double solverTime_cbc=0;
	public static double solverTime_cbc_this=0;
	public static double solverCreationTime_cbc=0;
	public static double solverCreationTime_xa=0;
	public static double lpFileWritingTime=0;
	public static double cdTime=0;	
	public static double adTime=0;	
	public static boolean useCplexLpString=false;
	public static boolean saveCplexLpStringToFile=false;
	public static boolean useCbcWarmStart=true;
	public static boolean writeCbcSolvingTime=false;
	//public static Map<Integer,LinkedHashSet<String>> cycIntDvMap;
	//public static LinkedHashSet<String> allIntDv;
	public static ArrayList<Integer> cycWarmStart;
	public static ArrayList<Integer> cycWarmStop;
	public static ArrayList<Integer> cycWarmUse;
	public static boolean cbc_debug_routeXA=false; //use xa solution	
	public static boolean cbc_debug_routeCbc=false;	// use cbc solution
	public static String[] watchList;
	public static double watchList_tolerance = 1e99;
	public static double zeroTolerance =  1e-11;
	public static Double xaIntegerT =  null;
	public static String xaSort = null;
	public static boolean resimDate=false;
	public static boolean resimGroundwater=false;
	public static int resimYear;
	public static int resimMonth;
	public static int resimDay;
	    
	public static String USER;       
	public static String PASS;  
	public static String databaseURL;
	public static String sqlGroup="calsim";
	public static int ovOption=0;
	public static String ovFile="";
	public static boolean isSimOutput = true;
	
	public static boolean enableProgressLog = false;
	
	public ControlData(){
	}
	
	public static String getPartE(){
		return timeStep;
	}
}
