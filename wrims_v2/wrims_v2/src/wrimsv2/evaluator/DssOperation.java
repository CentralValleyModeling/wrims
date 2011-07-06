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
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class DssOperation {
	public static boolean getSVTimeseries(String name, String file){
		Timeseries ts=ControlData.allTsMap.get(name);
		String partC=ts.kind;
		DataSet ds=getDataForSvar(ControlData.partA,name,partC,"",ControlData.partE, ControlData.svDvPartF);
		
		if (ds==null){
			return false;
		}
		if (!ds.getAttributes().getYUnits().toUpperCase().equals(ts.units.toUpperCase())){
			return false;
		}	
		if (!(ds instanceof RegularTimeSeries)){
			return false;
		}
		RegularTimeSeries rts=(RegularTimeSeries)ds;
		DssDataSet dds= new DssDataSet();
		ArrayList<Double> dataArray= new ArrayList<Double>();
		Date startDate=rts.getStartTime().getDate();
		if (ts.convertToUnits.equals("cfs")){
			ControlData.dataYear=startDate.getYear()+1900;
			ControlData.dataMonth=startDate.getMonth();
			ControlData.dataDay=startDate.getDate();
			int i=0;
			for (double dataEntry :  rts.getYArray()){
				TimeOperation.findTime(i);
				dataArray.add(dataEntry*Evaluation.tafcfs("taf_cfs"));
				i=i+1;
			}
		}else{
			for (double dataEntry :  rts.getYArray()){
				dataArray.add(dataEntry);
			}
		}
        dds.setData(dataArray);
        dds.setTimeStep(rts.getTimeInterval().toString());
        dds.setStartTime(startDate);
        dds.setFromDssFile(true);
        DataTimeSeries.svTS.put(name, dds);
		return true;
	}
	
	public static boolean getSVInitTimeseries(String name){
		Timeseries ts=ControlData.currTsMap.get(name);
		String partC=ts.kind;
		DataSet ds=getDataForInitial(ControlData.partA,name,partC,"",ControlData.partE, ControlData.initPartF);
		
		if (ds==null){
			return false;
		}
		if (!ds.getAttributes().getYUnits().toUpperCase().equals(ts.units.toUpperCase())){
			return false;
		}
		if (!(ds instanceof RegularTimeSeries)){
			return false;
		}
		RegularTimeSeries rts=(RegularTimeSeries)ds;
		DssDataSet dds= new DssDataSet();
		ArrayList<Double> dataArray= new ArrayList<Double>();
		Date startDate=rts.getStartTime().getDate();
		if (ts.convertToUnits.equals("cfs")){
			ControlData.dataYear=startDate.getYear()+1900;
			ControlData.dataMonth=startDate.getMonth()+1;
			ControlData.dataDay=startDate.getDate();
			int i=0;
			for (double dataEntry :  rts.getYArray()){
				TimeOperation.findTime(i);
				dataArray.add(dataEntry*Evaluation.tafcfs("taf_cfs"));
				i=i+1;
			}
		}else{
			for (double dataEntry :  rts.getYArray()){
				dataArray.add(dataEntry);
			}
		}
        dds.setData(dataArray);
        dds.setTimeStep(rts.getTimeInterval().toString());
        dds.setStartTime(startDate);
        DataTimeSeries.svInit.put(name, dds);
		return true;
	}
	
	public static boolean getDVAliasInitTimeseries(String name){
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
		
		DataSet ds=getDataForInitial(ControlData.partA,name,partC,"",ControlData.partE, ControlData.initPartF);
		if (ds==null){
			Error.addEvaluationError("Intial data of "+name+" in dss file doesn't exist." );
			return false;
		}
		if (!units.toUpperCase().equals(ds.getAttributes().getYUnits().toUpperCase())){
			return false;
		}
		if (!(ds instanceof RegularTimeSeries)){
			Error.addEvaluationError("Intial data of "+name+" in dss file is not a regular timeseries." );
			return false;
		}
		RegularTimeSeries rts=(RegularTimeSeries)ds;
		DssDataSet dds= new DssDataSet();
		ArrayList<Double> dataArray= new ArrayList<Double>();
		for (double dataEntry :  rts.getYArray()){
			dataArray.add(dataEntry);
		}
        dds.setData(dataArray);
        dds.setUnits(units);
        dds.setKind(partC);
        dds.setTimeStep(rts.getTimeInterval().toString());
        dds.setStartTime(rts.getStartTime().getDate());
        DataTimeSeries.dvAliasInit.put(name, dds);
		return true;
	}
	
    public static DataSet getDataFor(String file, String apart, String bpart, String cpart, String dpart, String epart, String fpart){
        dpart = "01JAN1920"; //To Do: this method may be removed
        DataReference ref = DSSUtil.createDataReference("local",file,Pathname.createPathname(new String[]{apart, bpart, cpart, dpart, epart, fpart}));
        return ref.getData();
    }
    
    public static DataSet getDataForSvar(String apart, String bpart, String cpart, String dpart, String epart, String fpart){
    	DataReference[] refs = ControlData.groupSvar.find(new String[]{apart, bpart, cpart, dpart, epart, fpart});
        if (refs.length==0){
              return null;
        } else {
              return refs[0].getData();
        }
    }
    
    public static DataSet getDataForInitial(String apart, String bpart, String cpart, String dpart, String epart, String fpart){
    	DataReference[] refs = ControlData.groupInit.find(new String[]{apart, bpart, cpart, dpart, epart, fpart});
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
                dds.setUnits(data._yUnits);
                dds.setTimeStep(timeStep);
                dds.setStartTime(tw.getStartTime().getDate());
                DataTimeSeries.dvAliasInit.put(rName, dds);
			}
		}
	}
	
	public static void writeInitDvarAliasToDSS() {				
		Set initSet=DataTimeSeries.dvAliasInit.keySet();
		Iterator iterator = initSet.iterator();
		while(iterator.hasNext()){
			String initName=(String)iterator.next();
			DssDataSet dds=DataTimeSeries.dvAliasInit.get(initName);
			ArrayList<Double> data=dds.getData();
			int size=data.size();
			double[] values=new double[size];
			for (int i=0; i<size; i++){
				values[i]=data.get(i);
			}
			DSSData ds = new DSSData();
			ds._dataType=DSSUtil.REGULAR_TIME_SERIES;
			ds._yType="PER-AVER";
			ds._numberRead=values.length;
			ds._yUnits=dds.getUnits().toUpperCase();
			ds._yValues = values;
			Date startDate=dds.getStartTime();
			long startJulmin = TimeFactory.getInstance().createTime(startDate).getTimeInMinutes();
			boolean storeFlags = false;
			String pathName="/"+ControlData.partA+"/"+initName+"/"+dds.getKind()+"//"+ControlData.partE+"/"+ControlData.svDvPartF+"/";
			ControlData.writer.storeTimeSeriesData(pathName, startJulmin, ds,
				storeFlags);
		}
	}
	
	public static void writeDVAliasToDSS() {
		String startDateStr=TimeOperation.dssTimeEndDay(ControlData.writeDssStartYear, ControlData.writeDssStartMonth, ControlData.writeDssStartDay);
		long startJulmin = TimeFactory.getInstance().createTime(startDateStr).getTimeInMinutes();
		Set dvAliasSet=DataTimeSeries.dvAliasTS.keySet();
		Iterator iterator = dvAliasSet.iterator();
		while(iterator.hasNext()){
			String dvAliasName=(String)iterator.next();
			DssDataSetFixLength ddsfl=DataTimeSeries.dvAliasTS.get(dvAliasName);
			double[] values=ddsfl.getData();
			DSSData dd = new DSSData();
			dd._dataType=DSSUtil.REGULAR_TIME_SERIES;
			dd._yType="PER-AVER";
			dd._numberRead=values.length;
			dd._yUnits=ddsfl.getUnits().toUpperCase();
			dd._yValues = values;
			boolean storeFlags = false;
			String pathName="/"+ControlData.partA+"/"+dvAliasName+"/"+ddsfl.getKind()+"//"+ControlData.partE+"/"+ControlData.svDvPartF+"/";
			ControlData.writer.storeTimeSeriesData(pathName, startJulmin, dd,
						storeFlags);
		}
	}
}
