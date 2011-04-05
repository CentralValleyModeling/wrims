package wrimsv2.evaluator;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTimeSeries {
	public static HashMap<String, DssDataSet> svTS = new HashMap<String, DssDataSet> ();
	public static HashMap<String, DssDataSet> dvAliasTS = new HashMap<String, DssDataSet> ();
	public static HashMap<String, DssDataSet> svInit = new HashMap<String, DssDataSet> ();
	public static HashMap<String, DssDataSet> dvAliasInit = new HashMap<String, DssDataSet> ();
	public static ArrayList<String> lookSvDss=new ArrayList<String>();
	public static ArrayList<String> lookInitDss=new ArrayList<String>();
}
