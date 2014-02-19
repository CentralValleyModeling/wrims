package gov.ca.dwr.hecdssvue.components;

import hec.dataTable.HecDataTable;
import hec.heclib.util.HecTime;
import hec.hecmath.DSS;
import hec.hecmath.DSSFile;
import hec.hecmath.HecMathException;
import hec.io.DataContainer;

import java.util.Vector;

import wrimsv2_plugin.debugger.exception.WPPException;

public class TableOps {

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
	
}
