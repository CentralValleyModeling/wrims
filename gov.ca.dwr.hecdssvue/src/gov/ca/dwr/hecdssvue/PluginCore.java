package gov.ca.dwr.hecdssvue;

import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;
import hec.io.DataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class PluginCore {
	public static String ID_DSSVue_DSSTableView="gov.ca.dwr.hecdssvue.views.DSSTableView";
	public static String ID_DSSVue_DSSCatalogView="gov.ca.dwr.hecdssvue.views.DSSCatalogView";
	
	public static boolean dssEditable=false;
	
	public static final String comp="comp";
	public static final String diff="diff";
	public static String mode=comp;
	
	public final static String taf="TAF";
	public final static String cfs="CFS";
	public static String units=cfs;
	
	public static int chartType=0;
	
	public static final int WATERYEAR = 0; 
	public static final int CALENDAR_YEAR = 1; 
	public static final int FEDERAL_CONTRACT_YEAR = 2;
	public static int annualType=WATERYEAR;

	public final static String DEFAULT_TIME_WINDOW = "All"; 
	public static String tw=DEFAULT_TIME_WINDOW;

	public static ArrayList<Integer> months= new ArrayList<Integer>(){{
	    add(10);
	    add(11);
	    add(12);
	    add(1);
	    add(2);
	    add(3);
	    add(4);
	    add(5);
	    add(6);
	    add(7);
	    add(8);
	    add(9);
	}};
	
	public static String filter="/*/*/*/*/*/*/";
	
	public static ArrayList<HecDss> dssArray = new ArrayList<HecDss> ();// for multiple dss readin
	public static Vector<CondensedReference> condensedCatalog;
	
	public static ArrayList<String> allStorageNames = new ArrayList<String>();
	public static HashMap<String, String> allPathName=new HashMap<String, String>();
	public static ArrayList<String> allSchematicVariableNames = new ArrayList<String>();
	public static HashMap<String, HecMath>[] allSchematicVariableData=new HashMap[3];
}
