package gov.ca.dwr.hecdssvue.components;

import gov.ca.dwr.hecdssvue.PluginCore;
import hec.dataTable.HecDataTable;
import hec.heclib.dss.HecDss;
import hec.heclib.util.HecTime;
import hec.hecmath.DSS;
import hec.hecmath.DSSFile;
import hec.hecmath.HecMath;
import hec.hecmath.HecMathException;
import hec.io.DataContainer;
import hec.io.TimeSeriesContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

public class DataOps {

	private static double FACTOR = 1000. * 43560 / (24 * 60 * 60);
	
	public static void saveData(HecDataTable table) {
		if (table.hasDataChanged()){
			int firstError[] = new int[3];
			int numberErrors = table.updateContainers(firstError);
			if (numberErrors > 0) {
				String message = "";
				if (numberErrors > 1) {
					message=message+numberErrors + " errors found.  First Error:\n";
				}
				if (firstError[2] == 0) {
					message=message+"Invalid date / time at ordinate " + (firstError[0] + 1);
				}else {
					message=message+"Dates / times are not ascending";
					HecTime time = new HecTime();
					time.set(firstError[1]);
					message=message+"\n    Date / time at ordinate " + firstError[0] + " is " + time;
					time.set(firstError[2]);
					message=message+"\n    Date / time at ordinate " + (firstError[0] + 1) + " is " + time;
				}
				WPPException.handleException(new Exception(message));
				return;
			}
			Vector<DataContainer> dataVector = table.getDataContainers();
			int size = dataVector.size();
			for (int i=0; i<size; i++){
				DataContainer dc=dataVector.get(i);
				String fileName=dc.fileName;
				DSSFile dssFile = DSS.open(fileName);
				try {
					dssFile.write(dc);
					dssFile.close();
				} catch (HecMathException e) {
					WPPException.handleException(e);
				}
			}
		}
	}

	public static TimeSeriesContainer getMonthlyData(TimeSeriesContainer tsc, ArrayList months) {
		TimeSeriesContainer ntsc = null;

		try {
			List<Double> lvalues = new ArrayList<Double>();
			List<Integer> ltimes = new ArrayList<Integer>();

			double[] values = tsc.values;
			int[] times = tsc.times;

			HecTime ht = new HecTime();
			// ht.set(tsc.startTime);

			for (int i = 0; i < values.length; i++) {
				// System.out.println(times[i]+" "+ht.month()+" "+months[1]+" "+values[i]);

				ht.set(times[i]);
				// WRONG MONTH FIX: subtract 1 min
				ht.add(-1);

				if (months.contains(ht.month())) {
					ltimes.add(times[i]);
					lvalues.add(values[i]);
					// values[i] = Constants.UNDEFINED;
				}
			}

			double[] nvalues = new double[lvalues.size()];
			int[] ntimes = new int[ltimes.size()];

			for (int i = 0; i < lvalues.size(); i++) {
				ntimes[i] = ltimes.get(i).intValue();
				nvalues[i] = lvalues.get(i).doubleValue();
				// System.out.println(ntimes[i]+" "+nvalues[i]);
			}

			ntsc = (TimeSeriesContainer) tsc.clone();
			ntsc.values = nvalues;
			ntsc.numberValues = nvalues.length;
			ntsc.times = ntimes;
			ntsc.startTime = ntimes[0];
			ntsc.endTime = ntimes[ntimes.length - 1];
			ntsc.interval = -1; // irregular time-series

		} catch (Exception e) {
		}

		ntsc=unitsConversion(ntsc);
		
		return ntsc;

	}
	
	public static TimeSeriesContainer unitsConversion(TimeSeriesContainer tsc) {
		String units=tsc.units;
		
		String fullName = tsc.fullName;
		String[] parts = fullName.split("/");
		boolean isStorage = parts[3].trim().toLowerCase().startsWith("storage");
		
		if (!PluginCore.units.equals(units)) {
			if (PluginCore.units.equals(PluginCore.taf) && units.equals(PluginCore.cfs)){
				tsc = adjustMonthlyData(tsc, true); 
				tsc.units=PluginCore.taf;
			} else if (PluginCore.units.equals(PluginCore.cfs) && units.equals(PluginCore.taf) && !isStorage){
				tsc = adjustMonthlyData(tsc, false); 
				tsc.units=PluginCore.cfs;
			}
		}
		return tsc;
	}

	public static TimeSeriesContainer adjustMonthlyData(TimeSeriesContainer tsc, boolean isCFStoTAF) { 

		HecTime ht = null;
		try {
			// double[] values = tsc.values;
			double[] nvalues = new double[tsc.values.length];
			int[] times = tsc.times;
			int ndays = 0;
			ht = new HecTime();
			for (int i = 0; i < times.length; i++) {
				ht.set(times[i]);
				// FIX: subtract 1 min
				ht.add(-1);
				ndays = ht.day();
				/*
				 * HecTime BUG: sometimes ht.day() returns a day later than *
				 * should???? I wasted a lot of time on this!!
				 * 
				 * returns ht.day() == 1, ht.hour() == 0 AS OPPOSED TO ht.day()
				 * == 28,30,31 (depending on month), ht.hour() == 24
				 */

				// if (DEBUG) System.out.println(ht.year()+" "+ht.month()+
				// " "+ht.day()+ht.hour()+" "+ht.minute()+" "+ht.second()+" "+times[i]+"
				// "+values[i]);
				// CB nvalues[i] = tsc.values[i] * ndays * factor;
				if (isCFStoTAF) {
					nvalues[i] = tsc.values[i] * ndays / FACTOR;
				} else {
					nvalues[i] = tsc.values[i] / ndays * FACTOR;
				}
			}
			tsc.values = nvalues;

		} catch (Exception e) {
			WPPException.handleException(e);
		}
		return tsc;
	}

	public static TimeSeriesContainer diff(TimeSeriesContainer tsc1, TimeSeriesContainer tsc0){
		try {
			HecMath hm0=HecMath.createInstance(tsc0);
			HecMath hm1=HecMath.createInstance(tsc1);
			hm1=hm1.subtract(hm0);
			return (TimeSeriesContainer)hm1.getData();
		} catch (HecMathException e) {
			WPPException.handleException(e);
			return tsc1;
		}
		
	}
	
	public static void loadAllSchematicVariableData(){
		PluginCore.allSchematicVariableUnitsCFS=new HashMap[3];
		PluginCore.allSchematicVariableUnitsTAF=new HashMap[3];
		PluginCore.longTermAverageDataCFS=new ArrayList[8];
		PluginCore.longTermAverageDataTAF=new ArrayList[8];
		PluginCore.allSchematicVariableData = new HashMap[3];
		for (int kk=0; kk<3; kk++){
			HashMap<String, HecMath> data= new HashMap<String, HecMath>();
			PluginCore.allSchematicVariableData[kk]=data;
			HashMap<String, String> cfsUnitsMap = new HashMap<String, String>();
			PluginCore.allSchematicVariableUnitsCFS[kk]=cfsUnitsMap;
			HashMap<String, String> tafUnitsMap = new HashMap<String, String>();
			PluginCore.allSchematicVariableUnitsTAF[kk]=tafUnitsMap;
			
			if (DebugCorePlugin.selectedStudies[kk]){
				if (DebugCorePlugin.dvDss[kk] !=null){
					DebugCorePlugin.dvDss[kk].setTimeWindow(DebugCorePlugin.timeWindow);
				}
				if (DebugCorePlugin.svDss[kk] !=null){
					DebugCorePlugin.svDss[kk].setTimeWindow(DebugCorePlugin.timeWindow);
				}
			}	
		}
		
		
		int size = PluginCore.allSchematicVariableNames.size();
		for (int j=0; j<size; j++) {
			String name = PluginCore.allSchematicVariableNames.get(j);
			if (PluginCore.allPathName.containsKey(name)){
				String pathName = PluginCore.allPathName.get(name);
				for (int i=0; i<3; i++){
					if (DebugCorePlugin.selectedStudies[i]){
						HecMath dataSet=null;
						HecDss dvFile = DebugCorePlugin.dvDss[i];
						HecDss svFile = DebugCorePlugin.svDss[i];
						if (dvFile != null){
							try {
								dataSet= dvFile.read(pathName);
								if (dataSet ==null){
									readFromSV(svFile, pathName, name, i);
									continue;
								}else{
									PluginCore.allSchematicVariableData[i].put(name, dataSet);
									PluginCore.allSchematicVariableUnitsCFS[i].put(name, dataSet.getUnits());
									PluginCore.allSchematicVariableUnitsTAF[i].put(name, dataSet.getUnits());
									continue;
								}
							} catch (Exception e) {
								readFromSV(svFile, pathName, name, i);
							}
						}else{
							readFromSV(svFile, pathName, name, i);
						}
					}
				}
			}
		}
	}
	
	public static void readFromSV(HecDss svFile, String pathName, String name, int i){
		try {
			HecMath dataSet = svFile.read(pathName);
			if (dataSet !=null){
				PluginCore.allSchematicVariableData[i].put(name, dataSet);
				PluginCore.allSchematicVariableUnitsCFS[i].put(name, dataSet.getUnits());
				PluginCore.allSchematicVariableUnitsTAF[i].put(name, dataSet.getUnits());
			}
		} catch (Exception e) {
		}
	}
}
