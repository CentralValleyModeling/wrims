package wrims.schematic;

import hec.heclib.dss.*;
import hec.heclib.util.*;
import hec.io.*;    // Has TimeSeriesContainer

import hec.gfx2d.*;  // Only need for plot software

import java.util.*;
import com.nwoods.jgo.*;

//  Complete exampe to create a new DSS file, write a data set to it,
//  then read it back in and plot the data.
class Plotter {

    public Plotter() { }

    public Plotter(JGoSelection s) {
        parseSelection(s);
    }

/*    public boolean isValidSelection(JGoSelection selection) {
        boolean isValid = false;
        JGoListPosition pos = selection.getFirstObjectPos();

        while (pos != null) {
          JGoObject obj = selection.getObjectAtPos(pos);
          if (obj instanceof Arc) {
             Arc a = (Arc)obj;
             if (a.isPlotable() == true) {
                isValid = true;
                break;
             }
          }
          if (obj instanceof NetworkNode) {
             NetworkNode n = (NetworkNode)obj;
             if (n.isPlotable() == true) {
                isValid = true;
                break;
             }
          }
          pos = selection.getNextObjectPos(pos);
        }
        //System.out.println( "isValid: "+isValid);
        return isValid;
    } */

    public void plot(JGoSelection selection) {
        Vector vars = parseSelection(selection);
        //System.out.println( "Plot variables: "+vars);
        plotVariables(vars);
    }

    private void plotVariables(Vector variables) {

        //  Read Data
        TimeSeriesContainer tsc = new TimeSeriesContainer();  //  Bare bones object to hold data
        HecTimeSeries rts = new HecTimeSeries();
        rts.setDSSFileName("D:/dss/1/2020D09EDV.DSS");
        /*
        rts.setDSSFileName("D:/dss/1/2020D09EDV.DSS");
        rts.setDSSFileName("D:/dss/2/2020D09E_SA_DV.DSS");
        rts.setDSSFileName("D:/dss/3/2020D09EDV.DSS");
        rts.setDSSFileName("D:/dss/4/2020D09E_SA_DV.DSS");
        */
        rts.setTimeWindow("31Oct1921 30Sep2003");      // Can either set a time window, or
        rts.setPathname("/CALSIM/S1/STORAGE/31OCT1921/1MON/2020D09E/");   // use a valid D part to read all data
        //rts.setRetrieveAllTimes(true);
        int status = rts.read(tsc, true);
        rts.done();
        rts.close();  //  Close the DSS file (usually at the end of the program)


        //  Plot Data
        if (status < -1) {
            System.out.println("No Data");
        }
        else {
            //  Plot the data
            Vector data = new Vector();
            data.add(tsc);  // Pass containers in vector so we can have several curves.
            G2dDialog plot = new G2dDialog(null, "My plot", true, data);
            plot.setVisible(true);
        }
    }

    public Vector<String> parseSelection(JGoSelection selection) {
        Vector<String> variables = new Vector<String>();
        JGoListPosition pos = selection.getFirstObjectPos();

        while (pos != null) {
          JGoObject obj = selection.getObjectAtPos(pos);
          //System.out.println( "object: "+obj);

          if (obj instanceof Arc) {
             Arc a = (Arc)obj;
             //System.out.println( "isPlottable: "+a.isPlotable());
             //System.out.println( "getArcType: "+a.getArcType());
             if (a.isPlotable() == true) {
                //System.out.println( "Arc Plottable: "+a.getVariable());
                variables.add(a.getVariable());
             }
          }

          if (obj instanceof NetworkNode) {
             NetworkNode n = (NetworkNode)obj;
             if (n.isPlotable() == true) {
                //System.out.println( "Node Plottable: "+n.getVariable());
//            	 System.out.println(n.getText() + " or " + n.getVariable());
//            	 System.out.println(n.getText() + " or " + n.getVariable());
                variables.add(n.getVariable());
             }
          }
          pos = selection.getNextObjectPos(pos);
        }
        return variables;
    }

    public static void main (String args[])  {

        //  Write Data
        HecTimeSeries ts = new HecTimeSeries();
        ts.setDSSFileName("C:/test.dss");      // Dss file.  Does not need to exist for writing.
        ts.setPathname("/BASIN/LOC/FLOW//1HOUR/OBS/");
        ts.setStartTime(new HecTime("04Sep1996", "1330"));  // start date & time of first value
        double[] values = {0,2,1,4,3,6,5,8,7,9};  //  Dummy up a data array
        ts.setData(values);
        ts.setUnits("CFS");
        ts.setType("INST-VAL");
        ts.write();
        ts.done();          //  Let software know that we are done with this object (ts)
                            //  (similar to a C++ destructor call)

        //  Read Data
        TimeSeriesContainer tsc = new TimeSeriesContainer();  //  Bare bones object to hold data
        HecTimeSeries rts = new HecTimeSeries();
        rts.setDSSFileName("C:/test.dss");
        //rts.setTimeWindow("04Sep1996 1330 04Sep1996 2330");      // Can either set a time window, or
        rts.setPathname("/BASIN/LOC/FLOW/01SEP1996/1HOUR/OBS/");   // use a valid D part to read all data
        int status = rts.read(tsc, true);
        rts.done();
        rts.close();  //  Close the DSS file (usually at the end of the program)


        //System.out.println( "tsc: "+tsc.values[0]+" "+tsc.values[1]);
        //  Plot Data
        if (status < -1) {
            System.out.println("No Data");
        }
        else {
            //  Plot the data
            Vector data = new Vector();
            data.add(tsc);  // Pass containers in vector so we can have several curves.
            G2dDialog plot = new G2dDialog(null, "My plot", true, data);
            plot.setVisible(true);
        }
    }
}

/*
HecTimeSeries timeSeries;
Vector pathnames = new Vector();
Int numberPaths = timeSeries.getPathnameList("B=my b part, C=my C part",
pathnames);
If (numberPaths < 0) error
For (int i=0; i<pathnames.size() i++) {
	System.out.println("Pathname = " +
pathnames.elementAt(i).toString());
}
*/



