package wrimsv2.gui;

import wrimsv2.commondata.wresldata.StudyDataSet;

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
