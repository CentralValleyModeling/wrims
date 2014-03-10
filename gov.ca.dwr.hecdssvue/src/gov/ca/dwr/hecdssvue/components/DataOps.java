package gov.ca.dwr.hecdssvue.components;

import hec.dataTable.HecDataTable;
import hec.heclib.util.HecTime;
import hec.hecmath.DSS;
import hec.hecmath.DSSFile;
import hec.hecmath.HecMathException;
import hec.io.DataContainer;
import hec.io.TimeSeriesContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import wrimsv2_plugin.debugger.exception.WPPException;

public class DataOps {

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

		return ntsc;

	}
}
