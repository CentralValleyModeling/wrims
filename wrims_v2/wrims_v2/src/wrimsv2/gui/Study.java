package wrimsv2.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;

public class Study {
	public StudyDataSet currStudyDataSet=new StudyDataSet();
	public static int currDay=1;
	public static int currMonth;
	public static int currYear;
	public static String timeStep ="1MON"; //TO DO: allow input;
	public static String partE="1MON";
	public static int startYear;       //TO DO: allow input
	public static int startMonth;
	public static int startDay;
	public static int endYear ;
	public static int endMonth;
	public static int endDay;
	public static String partA;
	public static String svDvPartF;
	public static String initPartF;
}
