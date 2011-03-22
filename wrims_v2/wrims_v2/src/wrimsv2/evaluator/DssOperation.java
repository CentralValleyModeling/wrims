package wrimsv2.evaluator;

import vista.db.dss.*;
import vista.time.Time;
import vista.time.TimeFactory;
import vista.time.TimeInterval;
import vista.time.TimeWindow;
import vista.set.*;

import wrimsv2.components.ControlData;
import wrimsv2.components.Error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class DssOperation {
	public static DataSet getSVTimeseries(String name, String file){
		//To Do: find part C 
		String path="/"+ControlData.partA+"/"+name+"/"+".*"+"/"+ControlData.simulationTimeFrame+"/"+ControlData.partE+"/"+ControlData.svDvPartF+"/";
		try {
			DataSet ds=DSSUtil.readData(file, path, true);
			return ds;
		}catch (IllegalArgumentException e){
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
	}
	
	public static void getAllInitTimeseries(String file){

		DSSDataReader reader = new DSSDataReader();
		Group group = DSSUtil.createGroup("local", file);
		DataReference[] refs = group.getAllDataReferences();
		String endTimeStr;
		ArrayList<DataReference> newList = new ArrayList<DataReference>();
		for(DataReference r: refs){
			TimeWindow tw = r.getTimeWindow();
			TimeInterval interval= r.getTimeInterval();
			String timeStep;
			if (interval.getIntervalAsString().equals("1MON")){
				timeStep="1MON";
				endTimeStr=TimeOperation.dssTime(ControlData.startYear, ControlData.startMonth-1, ControlData.startDay);
			}else{
				timeStep="1DAY";
				endTimeStr=TimeOperation.dssTime(ControlData.startYear, ControlData.startMonth, ControlData.startDay-1);
			}
			Time endTime = TimeFactory.getInstance().createTime(endTimeStr);
			Time ceiling = endTime.ceiling(interval);
			if (tw.contains(ceiling)){
				//To Do: see if r.name is in svar or dvar or alias map
				//
				String rName=r.getPathname().getPart(1);
				//To Do: find partC
				String path=ControlData.partA+"/"+rName+"/"+".*"+"/.*/"+ControlData.partE+"/"+ControlData.svDvPartF;
				long st=(int) tw.getStartTime().getTimeInMinutes();
				long et=endTime.getTimeInMinutes();
                DSSData data = reader.getData(file, path, st, et,
                        true);
                DssDataSet dds= new DssDataSet();
        		ArrayList<Double> dataArray= new ArrayList<Double>();
        		for (double dataEntry :  data._yValues){
        			dataArray.add(dataEntry);
        		}
                dds.setData(dataArray);
                dds.setTimeStep(timeStep);
                dds.setStartTime(tw.getStartTime().getDate());
                DataTimeSeries.dvAliasInit.put(rName, dds);
			}
		}
	}
	
	public static boolean getInitTimeseries(String name, String file){
		//To Do: find dv or alias part C		
		
		DataSet ds=getDataFor(file,ControlData.partA,name,"","",ControlData.partE, ControlData.svDvPartF);
		if (ds==null){
			Error.error_evaluation.add("Intial data of "+name+" in dss file doesn't exist." );
			return false;
		}
		ds.getAttributes().getYUnits();
		//To Do: test if units are right
		if (!(ds instanceof RegularTimeSeries)){
			Error.error_evaluation.add("Intial data of "+name+" in dss file is not a regular timeseries." );
			return false;
		}
		RegularTimeSeries rts=(RegularTimeSeries)ds;
		DssDataSet dds= new DssDataSet();
		ArrayList<Double> dataArray= new ArrayList<Double>();
		for (double dataEntry :  rts.getYArray()){
			dataArray.add(dataEntry);
		}
        dds.setData(dataArray);
        dds.setTimeStep(rts.getTimeInterval().toString());
        dds.setStartTime(rts.getStartTime().getDate());
        DataTimeSeries.dvAliasInit.put(name, dds);
		return true;
	}
	
    public static DataSet getDataFor(String file, String apart, String bpart, String cpart, String dpart, String epart, String fpart){
        Group group = DSSUtil.createGroup("local", file);
        DataReference[] refs = group.find(new String[]{apart, bpart, cpart, dpart, epart, fpart});
        if (refs.length==0){
              return null;
        } else {
              return refs[0].getData();
        }
  }

}
