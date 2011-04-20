package wrimsv2.evaluator;

import vista.db.dss.*;
import vista.time.Time;
import vista.time.TimeFactory;
import vista.time.TimeInterval;
import vista.time.TimeWindow;
import vista.set.*;

import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.SvarTimeseries;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;

import java.util.ArrayList;

public class DssOperation {
	public static boolean getSVTimeseries(String name, String file){
		SvarTimeseries svar=ControlData.currSvTsMap.get(name);
		String partC=svar.kind;
		DataSet ds=getDataFor(file,ControlData.partA,name,partC,"",ControlData.partE, ControlData.svDvPartF);
		
		if (ds==null){
			return false;
		}
		if (!ds.getAttributes().getYUnits().toUpperCase().equals(svar.units.toUpperCase())){
			return false;
		}	
		if (!(ds instanceof RegularTimeSeries)){
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
        dds.setFromDssFile(true);
        DataTimeSeries.svTS.put(name, dds);
		return true;
	}
	
	public static boolean getSVInitTimeseries(String name, String file){
		SvarTimeseries svar=ControlData.currSvTsMap.get(name);
		String partC=svar.kind;
		DataSet ds=getDataForInitial(file,ControlData.partA,name,partC,"",ControlData.partE, ControlData.initPartF);
		
		if (ds==null){
			return false;
		}
		if (!ds.getAttributes().getYUnits().toUpperCase().equals(svar.units.toUpperCase())){
			return false;
		}
		if (!(ds instanceof RegularTimeSeries)){
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
        DataTimeSeries.svInit.put(name, dds);
		return true;
	}
	
	public static boolean getDVAliasInitTimeseries(String name, String file){
		String units;
		String partC;
		if (ControlData.currDvMap.containsKey(name)){
			Dvar dvar=ControlData.currDvMap.get(name);
			partC=dvar.kind;
			units=dvar.units;
		}else{
			Alias alias=ControlData.currAliasMap.get(name);
			partC=alias.kind;
			units=alias.units;
		}
		
		DataSet ds=getDataForInitial(file,ControlData.partA,name,partC,"",ControlData.partE, ControlData.initPartF);
		if (ds==null){
			Error.error_evaluation.add("Intial data of "+name+" in dss file doesn't exist." );
			return false;
		}
		if (!units.toUpperCase().equals(ds.getAttributes().getYUnits().toUpperCase())){
			return false;
		}
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
        dpart = "01JAN1990";
        DataReference ref = DSSUtil.createDataReference("local",file,Pathname.createPathname(new String[]{apart, bpart, cpart, dpart, epart, fpart}));
        return ref.getData();
    }
    
    public static DataSet getDataForInitial(String file, String apart, String bpart, String cpart, String dpart, String epart, String fpart){
    	Group group = DSSUtil.createGroup("local", file);
    	DataReference[] refs = group.find(new String[]{apart, bpart, cpart, dpart, epart, fpart});
        if (refs.length==0){
              return null;
        } else {
              return refs[0].getData();
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
}
