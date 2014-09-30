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
import java.util.Map;
import java.util.Set;

import com.google.common.primitives.Doubles;

public class DssOperation {
	public static boolean getSVTimeseries(String name, String file, String timeStep){
		ControlData.timeStep=timeStep;
		ControlData.partE=timeStep;
		Timeseries ts=ControlData.allTsMap.get(name);
		String partC=ts.kind;
		DataSet ds=getDataForSvar(regularExp(ControlData.partA),regularExp(ts.dssBPart),regularExp(partC),"",regularExp(timeStep), regularExp(ControlData.svDvPartF));
		
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
		int year=startDate.getYear()+1900;
		int month=startDate.getMonth();;
		int day = startDate.getDate();
		if (ts.units.equals("taf") && ts.convertToUnits.equals("cfs")){
			int i=0;
			for (double dataEntry :  rts.getYArray()){
				if (dataEntry==-901.0){
					dataArray.add(-901.0);
				}else if (dataEntry==-902.0){
					dataArray.add(-902.0);
				}else{
					TimeOperation.findTime(i, year, month, day);
					double dataEntryValue=dataEntry*Evaluation.tafcfs("taf_cfs");
					dataArray.add(dataEntryValue);
				}
				i=i+1;
			}
		}else if (ts.units.equals("cfs") && ts.convertToUnits.equals("taf")){
			int i=0;
			for (double dataEntry :  rts.getYArray()){
				if (dataEntry==-901.0){
					dataArray.add(-901.0);
				}else if (dataEntry==-902.0){
					dataArray.add(-902.0);
				}else{
					TimeOperation.findTime(i, year, month, day);
					double dataEntryValue=dataEntry*Evaluation.tafcfs("cfs_taf");
					dataArray.add(dataEntryValue);
				}
				i=i+1;
			}
		}else{
			for (double dataEntry :  rts.getYArray()){
				dataArray.add(dataEntry);
			}
		}
		dds.setUnits(ts.units);
		dds.setKind(partC);
        dds.setData(dataArray);
        dds.setTimeStep(rts.getTimeInterval().toString());
        dds.setStartTime(startDate);
        dds.setFromDssFile(true);
        dds.generateStudyStartIndex();
        String entryNameTS=DssOperation.entryNameTS(name, timeStep);
        DataTimeSeries.svTS.put(entryNameTS, dds);
		return true;
	}
	
	public static boolean getSVInitTimeseries(String name){
		Timeseries ts=ControlData.currTsMap.get(name);
		String partC=ts.kind;
		DataSet ds=getDataForInitial(regularExp(ControlData.partA),regularExp(ts.dssBPart),regularExp(partC),"",regularExp(ControlData.partE), regularExp(ControlData.initPartF));
		
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
		if (ts.units.equals("taf") && ts.convertToUnits.equals("cfs")){
			ControlData.dataYear=startDate.getYear()+1900;
			ControlData.dataMonth=startDate.getMonth()+1;
			ControlData.dataDay=startDate.getDate();
			int i=0;
			for (double dataEntry :  rts.getYArray()){
				if (dataEntry==-901.0){
					dataArray.add(-901.0);
				}else if (dataEntry==-902.0){
					dataArray.add(-902.0);
				}else{
					TimeOperation.findTime(i);
					dataArray.add(dataEntry*Evaluation.tafcfs("taf_cfs"));
				}
				i=i+1;
			}
		}else if (ts.units.equals("cfs") && ts.convertToUnits.equals("taf")){
			ControlData.dataYear=startDate.getYear()+1900;
			ControlData.dataMonth=startDate.getMonth()+1;
			ControlData.dataDay=startDate.getDate();
			int i=0;
			for (double dataEntry :  rts.getYArray()){
				if (dataEntry==-901.0){
					dataArray.add(-901.0);
				}else if (dataEntry==-902.0){
					dataArray.add(-902.0);
				}else{
					TimeOperation.findTime(i);
					dataArray.add(dataEntry*Evaluation.tafcfs("cfs_taf"));
				}
				i=i+1;
			}
		}else{
			for (double dataEntry :  rts.getYArray()){
				dataArray.add(dataEntry);
			}
		}
		dds.setUnits(ts.units);
		dds.setKind(ts.kind);
        dds.setData(dataArray);
        dds.setTimeStep(rts.getTimeInterval().toString());
        dds.setStartTime(startDate);
        String entryNameTS=DssOperation.entryNameTS(name, ControlData.timeStep);
        DataTimeSeries.svInit.put(entryNameTS, dds);
		return true;
	}
	
	public static String regularExp(String part){
		return "^"+part+"$";
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
        String timeStep=rts.getTimeInterval().toString();
        dds.setTimeStep(timeStep);
        dds.setStartTime(rts.getStartTime().getDate());
        String entryNameTS=DssOperation.entryNameTS(name, timeStep);
        DataTimeSeries.dvAliasInit.put(entryNameTS, dds);
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
	
	public static void writeInitDvarAliasToDSS() {	
		System.out.println("write initial data for dvar and alias to dv dss");
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
			String timeStep=dds.getTimeStep();
			DSSData ds = new DSSData();
			Date startDate=dds.getStartTime();
			long startJulmin = TimeFactory.getInstance().createTime(startDate).getTimeInMinutes();
			Date modelStartDate=new Date(ControlData.startYear-1900, ControlData.startMonth, ControlData.startDay);
			ds._dataType=DSSUtil.REGULAR_TIME_SERIES;
			ds._yType="PER-AVER";
			ds._numberRead=TimeOperation.getNumberOfTimestep(startDate, modelStartDate, timeStep);
			ds._yUnits=dds.getUnits().toUpperCase();
			ds._yValues = values;
			boolean storeFlags = false;
			String pathName="/"+ControlData.partA+"/"+DssOperation.getTSName(initName)+"/"+dds.getKind()+"//"+timeStep+"/"+ControlData.svDvPartF+"/";
			ControlData.writer.storeTimeSeriesData(pathName, startJulmin, ds,
				storeFlags);
		}
	}
	
	public static void writeDVAliasToDSS() {
		System.out.println("write dvar and alias to dv dss");
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
			String pathName="/"+ControlData.partA+"/"+DssOperation.getTSName(dvAliasName)+"/"+ddsfl.getKind()+"//"+ddsfl.getTimeStep()+"/"+ControlData.svDvPartF+"/";
			Date startDate=ddsfl.getStartTime();
			String startDateStr=TimeOperation.dssTimeEndDay(startDate.getYear()+1900, startDate.getMonth()+1, startDate.getDate());
			long startJulmin = TimeFactory.getInstance().createTime(startDateStr).getTimeInMinutes();
			ControlData.writer.storeTimeSeriesData(pathName, startJulmin, dd,
						storeFlags);
		}
	}
	
	public static String entryNameTS(String name, String timeStep){
		return name+"@"+timeStep;
	}
	
	public static String getTSName(String entryNameTS){
		String[] entry=entryNameTS.split("@");
		return entry[0];
	}
	
	public static void saveInitialData(DSSDataWriter writer, String fileName){
		System.out.println("write initial data for dvar and alias to "+fileName);
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
			String timeStep=dds.getTimeStep();
			DSSData ds = new DSSData();
			Date startDate=dds.getStartTime();
			long startJulmin = TimeFactory.getInstance().createTime(startDate).getTimeInMinutes();
			Date modelStartDate=new Date(ControlData.startYear-1900, ControlData.startMonth, ControlData.startDay);
			ds._dataType=DSSUtil.REGULAR_TIME_SERIES;
			ds._yType="PER-AVER";
			ds._numberRead=TimeOperation.getNumberOfTimestep(startDate, modelStartDate, timeStep);;
			ds._yUnits=dds.getUnits().toUpperCase();
			ds._yValues = values;
			boolean storeFlags = false;
			String pathName="/"+ControlData.partA+"/"+DssOperation.getTSName(initName)+"/"+dds.getKind()+"//"+timeStep+"/"+ControlData.svDvPartF+"/";
			writer.storeTimeSeriesData(pathName, startJulmin, ds,
				storeFlags);
		}
	}
	
	public static void saveDVInitialData(DSSDataWriter writer, String fileName){
		System.out.println("write initial data for dvar and alias to "+fileName);
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
			String timeStep=dds.getTimeStep();
			DSSData ds = new DSSData();
			Date startDate=dds.getStartTime();
			long startJulmin = TimeFactory.getInstance().createTime(startDate).getTimeInMinutes();
			Date modelStartDate=new Date(ControlData.startYear-1900, ControlData.startMonth, ControlData.startDay);
			ds._dataType=DSSUtil.REGULAR_TIME_SERIES;
			ds._yType="PER-AVER";
			ds._numberRead=TimeOperation.getNumberOfTimestep(startDate, modelStartDate, timeStep);;
			ds._yUnits=dds.getUnits().toUpperCase();
			ds._yValues = values;
			boolean storeFlags = false;
			String pathName="/"+ControlData.partA+"/"+DssOperation.getTSName(initName)+"/"+dds.getKind()+"//"+timeStep+"/"+ControlData.initPartF+"/";
			writer.storeTimeSeriesData(pathName, startJulmin, ds,
				storeFlags);
		}
		System.out.println("Initial file saved.");
	}
	
	public static void saveSVInitialData(DSSDataWriter writer, String fileName){
		System.out.println("write initial data for svar to "+fileName);
		Set initSet=DataTimeSeries.svInit.keySet();
		Iterator iterator = initSet.iterator();
		Map<String, Timeseries> allTsMap = ControlData.allTsMap;
		while(iterator.hasNext()){
			String initName=(String)iterator.next();
			DssDataSet dds=DataTimeSeries.svInit.get(initName);
			ArrayList<Double> data=dds.getData();
			String ctu = "none";
			String units="none";
			if (allTsMap.containsKey(initName)){
				Timeseries ts=allTsMap.get(initName);
				units = ts.units;
				ctu=ts.convertToUnits;
			}
			ArrayList<Double> values=dds.getData();
			DSSData dd = new DSSData();
			dd._dataType=DSSUtil.REGULAR_TIME_SERIES;
			dd._yType="PER-AVER";
			int size=values.size();
			dd._numberRead=size;
			dd._yUnits=dds.getUnits().toUpperCase();
			dd._yValues=new double[size];
			Date startDate=dds.getStartTime();
			startDate.setTime(startDate.getTime()-1*24*60*60);
			int year=startDate.getYear()+1900;
			int month=startDate.getMonth()+1;
			int day=startDate.getDate();
			String startDateStr=TimeOperation.dssTimeEndDay(year, month, day);
			long startJulmin = TimeFactory.getInstance().createTime(startDateStr).getTimeInMinutes();
			if (units.equals("taf") && ctu.equals("cfs")){			
				for (int i=0; i<size; i++){
					Double value=values.get(i);
					if (value == null){
						dd._yValues[i]=-901.0;
					}else{
						if (value == -901.0 || value == -902.0){
							dd._yValues[i]=value;
						}else{
							TimeOperation.findTime(i, year, month, day);
							dd._yValues[i]=value/Evaluation.tafcfs("taf_cfs");;
						}
					}
				}
			}else if (units.equals("cfs") && ctu.equals("taf")){			
				for (int i=0; i<size; i++){
					Double value=values.get(i);
					if (value == null){
						dd._yValues[i]=-901.0;
					}else{
						if (value == -901.0 || value == -902.0){
							dd._yValues[i]=value;
						}else{
							TimeOperation.findTime(i, year, month, day);
							dd._yValues[i]=value/Evaluation.tafcfs("cfs_taf");;
						}
					}
				}
			}else{
				for (int i=0; i<size; i++){
					Double value=values.get(i);
					dd._yValues[i]=value;
				}
			}
			boolean storeFlags = false;
			String pathName="/"+ControlData.partA+"/"+initName+"/"+dds.getKind()+"//"+dds.getTimeStep()+"/"+ControlData.initPartF+"/";
			writer.storeTimeSeriesData(pathName, startJulmin, dd, storeFlags);
		}
		System.out.println("Initial file saved.");
	}
	
	public static void saveDvarData(DSSDataWriter writer, String fileName){
		System.out.println("write dvar and alias to "+fileName);
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
			String pathName="/"+ControlData.partA+"/"+DssOperation.getTSName(dvAliasName)+"/"+ddsfl.getKind()+"//"+ddsfl.getTimeStep()+"/"+ControlData.svDvPartF+"/";
			Date startDate=ddsfl.getStartTime();
			String startDateStr=TimeOperation.dssTimeEndDay(startDate.getYear()+1900, startDate.getMonth()+1, startDate.getDate());
			long startJulmin = TimeFactory.getInstance().createTime(startDateStr).getTimeInMinutes();
			writer.storeTimeSeriesData(pathName, startJulmin, dd,
						storeFlags);
		}
		System.out.println("Dvar file saved.");
	}
	
	public static void saveSvarTSData(DSSDataWriter writer, String fileName){
		System.out.println("write svar timeseries to "+fileName);
		Set svTsSet=DataTimeSeries.svTS.keySet();
		Iterator iterator = svTsSet.iterator();
		Map<String, Timeseries> allTsMap = ControlData.allTsMap;
		while(iterator.hasNext()){
			String svTsName=(String)iterator.next();
			String svName=getTSName(svTsName);
			String ctu = "none";
			String units="none";
			if (allTsMap.containsKey(svName)){
				Timeseries ts=allTsMap.get(svName);
				units = ts.units;
				ctu=ts.convertToUnits;
			}
			DssDataSet dds=DataTimeSeries.svTS.get(svTsName);
			ArrayList<Double> values=dds.getData();
			DSSData dd = new DSSData();
			dd._dataType=DSSUtil.REGULAR_TIME_SERIES;
			dd._yType="PER-AVER";
			int size=values.size();
			dd._numberRead=size;
			dd._yUnits=dds.getUnits().toUpperCase();
			dd._yValues=new double[size];
			Date startDate=dds.getStartTime();
			startDate.setTime(startDate.getTime()-1*24*60*60);
			int year=startDate.getYear()+1900;
			int month=startDate.getMonth()+1;
			int day=startDate.getDate();
			String startDateStr=TimeOperation.dssTimeEndDay(year, month, day);
			long startJulmin = TimeFactory.getInstance().createTime(startDateStr).getTimeInMinutes();
			if (units.equals("taf") && ctu.equals("cfs")){			
				for (int i=0; i<size; i++){
					Double value=values.get(i);
					if (value == null){
						dd._yValues[i]=-901.0;
					}else{
						if (value == -901.0 || value == -902.0){
							dd._yValues[i]=value;
						}else{
							TimeOperation.findTime(i, year, month, day);
							dd._yValues[i]=value/Evaluation.tafcfs("taf_cfs");;
						}
					}
				}
			}else if (units.equals("cfs") && ctu.equals("taf")){			
				for (int i=0; i<size; i++){
					Double value=values.get(i);
					if (value == null){
						dd._yValues[i]=-901.0;
					}else{
						if (value == -901.0 || value == -902.0){
							dd._yValues[i]=value;
						}else{
							TimeOperation.findTime(i, year, month, day);
							dd._yValues[i]=value/Evaluation.tafcfs("cfs_taf");;
						}
					}
				}
			}else{
				for (int i=0; i<size; i++){
					Double value=values.get(i);
					dd._yValues[i]=value;
				}
			}
			boolean storeFlags = false;
			String pathName="/"+ControlData.partA+"/"+svName+"/"+dds.getKind()+"//"+dds.getTimeStep()+"/"+ControlData.svDvPartF+"/";
			writer.storeTimeSeriesData(pathName, startJulmin, dd, storeFlags);
		}
		System.out.println("Svar file saved.");
	}
}
