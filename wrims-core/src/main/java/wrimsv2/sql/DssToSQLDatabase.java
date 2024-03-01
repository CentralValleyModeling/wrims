package wrimsv2.sql;

import hec.heclib.dss.DSSPathname;
import hec.heclib.dss.HecDssCatalog;
import hec.heclib.dss.HecTimeSeries;
import hec.heclib.util.HecTime;
import hec.heclib.util.doubleArrayContainer;
import hec.io.TimeSeriesContainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.evaluator.CondensedReferenceCacheAndRead;
import wrimsv2.evaluator.CsvOperation;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSet;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.CondensedReferenceCacheAndRead.CondensedReferenceCache;
import wrimsv2.hdf5.DSSHDF5Converter;

public class DssToSQLDatabase {

	public static String dssInfoFilePath="";
	private ArrayList<String[]> dssFilePathArr=new ArrayList<String[]> ();
	
	public DssToSQLDatabase(String[] args) {
		new DataBaseProfile(args);
		if (getDssFilePaths()){
			for (int i=0; i<dssFilePathArr.size(); i++){
				String[] dssFilePaths = dssFilePathArr.get(i);
				setSQLAttr(dssFilePaths[0]);
				dssReader(dssFilePaths);
				convertData();
			}
		}
		System.exit(0);
	}
	
	public static void main(String[] args){
		new DssToSQLDatabase(args);
	}
	
	public void setSQLAttr(String dvFilePath){
		FilePaths.fullDvarDssPath=dvFilePath;
		int index1=dvFilePath.lastIndexOf(File.separator);
		int index2=dvFilePath.lastIndexOf(".");
		FilePaths.dvarDssDirectory=dvFilePath.substring(0,index1+1);
		FilePaths.sqlScenarioName=dvFilePath.substring(index1+1,index2);
	}
	
	public void convertData(){
		ControlData.isSimOutput=false;
		if (ControlData.databaseURL.startsWith("jdbc:sqlserver")){
			SQLServerRWriter sqlServerRWriter = new SQLServerRWriter();
			sqlServerRWriter.process();
		}else if (ControlData.databaseURL.startsWith("jdbc:mysql")){
			MySQLRWriter mySqlRWriter = new MySQLRWriter();
			mySqlRWriter.process();
		}else{
			CsvOperation co = new CsvOperation();
			int index = FilePaths.fullDvarDssPath.lastIndexOf(".");
			String csvPath = FilePaths.fullDvarDssPath.substring(0, index)+".csv";
			co.ouputCSV(csvPath, 0);
		}
	}
	
	public boolean getDssFilePaths(){
		dssFilePathArr=new ArrayList<String[]> ();
		File dssInfoFile = new File (dssInfoFilePath);
		try {
			FileInputStream fs = new FileInputStream(dssInfoFile.getAbsolutePath());
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		    String line=br.readLine();
		    if (br == null) return false;
			while((line=br.readLine()) !=null){
		    	line=line.trim();
		    	if (line.equals("")) return true;
		    	String[] dssFilePaths = new String[3];
		    	String[] parts = line.split(",");
		    	if (parts.length>=5){
		    		dssFilePaths[0]=parts[0];
		    		dssFilePaths[1]=parts[1];
		    		dssFilePaths[2]=parts[2];
		    		ControlData.partA=parts[3];
		    		ControlData.svDvPartF=parts[4];
		    		dssFilePathArr.add(dssFilePaths);
		    	}	
		    }
		    br.close();
		    fs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	public void dssReader(String[] dssFilePaths){
		System.out.println("Reading DV, SV, and Init Dss Files...");
		DataTimeSeries.dvAliasTS = readDssDataFixLength(dssFilePaths[0]);
		System.out.println("Reading DV Dss File Done");
		DataTimeSeries.svTS = readDssData(dssFilePaths[1]);
		System.out.println("Reading SV Dss File Done");
		DataTimeSeries.dvAliasInit = readDssData(dssFilePaths[2]);
		System.out.println("Reading Init Dss File Done");
	}
	
	public HashMap<String, DssDataSet>  readDssData(String dssPath){
		HashMap<String, DssDataSet> ddsMap=new HashMap<String, DssDataSet>();
		File dssFile=new File (dssPath);
		if (!dssFile.exists()) return ddsMap;
        CondensedReferenceCache cache = CondensedReferenceCacheAndRead.createCondensedCache(dssPath);
		for(String dp : cache.getAllPaths()){
			TimeSeriesContainer tsc = cache.readFullRecord(dp);
			DssDataSet dds= new DssDataSet();
			ArrayList<Double> dataArray= new ArrayList<>();
			HecTime startTime=tsc.getStartTime();
			int year=startTime.year();
			int month=startTime.month();
			int day = startTime.day();
			Date startDate=new Date(year-1900, month-1, day);
			for (double dataEntry :  tsc.getValues()){
				dataArray.add(dataEntry);
			}
			dds.setUnits(tsc.getUnits());
			DSSPathname hts = new DSSPathname(dp);
			dds.setKind(hts.cPart().toLowerCase());
	        dds.setData(dataArray);
	        String timeStep=hts.ePart().toUpperCase();
	        dds.setTimeStep(timeStep);
	        dds.setStartTime(startDate);
	        dds.setFromDssFile(true);
	        dds.generateStudyStartIndex();
	        String name=hts.bPart().toLowerCase();
	        String entryNameTS=DssOperation.entryNameTS(name, timeStep);
	        ddsMap.put(entryNameTS, dds);
		}
		return ddsMap;
	}
	
	public HashMap<String, DssDataSetFixLength> readDssDataFixLength(String dssPath){
		HashMap<String, DssDataSetFixLength> ddsMap=new HashMap<String, DssDataSetFixLength>();
		File dssFile=new File (dssPath);
		if (!dssFile.exists()) return ddsMap;

        CondensedReferenceCache cache = CondensedReferenceCacheAndRead.createCondensedCache(dssPath);
        Set<String> dps = cache.getAllPaths();
		for(String dp : dps) {
			TimeSeriesContainer tsc = cache.readFullRecord(dp);
			DssDataSetFixLength dds= new DssDataSetFixLength();
			HecTime startTime=tsc.getStartTime();
			int year=startTime.year();
			int month=startTime.month();
			int day = startTime.day();
			Date startDate=new Date(year-1900, month-1, day);
			DSSPathname hts = new DSSPathname(tsc.getFullName());
			double[] data = tsc.getValues();
			dds.setUnits(tsc.getUnits());
			dds.setKind(hts.cPart().toLowerCase());
	        dds.setData(data);
	        String timeStep=hts.ePart().toUpperCase();
	        dds.setTimeStep(timeStep);
	        dds.setStartTime(startDate);
	        dds.setFromDssFile(true);
	        String name=hts.bPart().toLowerCase();
	        String entryNameTS=DssOperation.entryNameTS(name, timeStep);
	        ddsMap.put(entryNameTS, dds);
		}
		return ddsMap;
	}
}
