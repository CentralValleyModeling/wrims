package wrimsv2.hdf5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ncsa.hdf.hdf5lib.H5;
import ncsa.hdf.hdf5lib.HDF5Constants;
import ncsa.hdf.hdf5lib.exceptions.HDF5LibraryException;

import org.antlr.runtime.RecognitionException;

import vista.db.dss.DSSUtil;
import vista.set.DataReference;
import vista.set.DataSet;
import vista.set.RegularTimeSeries;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.components.PreRunModel;
import wrimsv2.config.ConfigUtils;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSet;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.Evaluation;
import wrimsv2.evaluator.PreEvaluator;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.wreslparser.elements.StudyUtils;

public class DSSHDF5Converter {

	private static ArrayList<String> svLookupNames = new ArrayList<String>();
	private static ArrayList<String> svLookupKinds = new ArrayList<String>();
	private static ArrayList<String> svLookupUnits = new ArrayList<String>();
	private static ArrayList<String> svLookupTimestep = new ArrayList<String>();
	private static ArrayList<Integer> svLookupIndex = new ArrayList<Integer>();
	private static int svIndex=0;
	private static ArrayList<String> svMonthlyNames = new ArrayList<String>();
	private static Map<String, double[]> svMonthlyData = new HashMap<String, double[]>();
	private static ArrayList<String> svDailyNames = new ArrayList<String>();
	private static Map<String, double[]> svDailyData = new HashMap<String, double[]>();
	
	private static String svH5FileName="";
	private static int svFid=-1;
	private static int svGidPartA=-1;
	private static int svGidPartF=-1;
	private static int svGidIOData=-1;
	private static String gIOData="IO Data";
	private static String gInfo="Info";
	private static int svGidInfo=-1;
	private static String gData="Data";
	private static int svGidData=-1;
	private static String gMonthly="Monthly";
	private static int svGidMonthly=-1;
	private static String gDaily="Daily";
	private static int svGidDaily=-1;
	
	public DSSHDF5Converter(String[] args) {
		processArgs(args);
		convertSVFile();
		convertInitFile();
	}
	
	public void convertSVFile(){
		if (FilePaths.svarDssFile.toLowerCase().endsWith(".dss")){
			convertSVFileDssToHDF5();
		}else if (FilePaths.svarDssFile.toLowerCase().endsWith(".h5")){
			convertSVFileHDF5ToDss();
		}
	}
	
	public void convertSVFileDssToHDF5(){
		
		svLookupNames = new ArrayList<String>();
		svLookupKinds = new ArrayList<String>();
		svLookupUnits = new ArrayList<String>();
		svLookupTimestep = new ArrayList<String>();
		svLookupIndex = new ArrayList<Integer>();
		svIndex=0;
		
		readMonthlySVDssFile();
		readDailySVDssFile();
		createSVHDF5DataStructure();
		createSVLookup();
		listMonthlySVHDF5File();
		writeMonthlySVHDF5File();
		listDailySVHDF5File();
		writeDailySVHDF5File();
		closeSVHDF5DataStructure();
	}
	
	public static void listMonthlySVHDF5File(){
		int size=svMonthlyNames.size();
		long[] dims = {size};
		try {
			int tidName = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidName, 256);
				
			int sidList = H5.H5Screate_simple(1, dims, null);
			if (svGidInfo >= 0 && sidList >= 0 && size>0){
				int didList=-1;
				try{
					didList = H5.H5Dopen(svGidMonthly, "Timestep List");
				}catch(Exception e){
					didList = H5.H5Dcreate(svGidMonthly,
							"Timestep List", tidName,
							sidList, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				}
				
				if (didList >= 0){
					HDF5Util.writeStringData(didList, tidName, svMonthlyNames.toArray(new String[size]), 256);
				}
				
	            H5.H5Sclose(sidList);
	            H5.H5Tclose(tidName);
	            H5.H5Dclose(didList);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listDailySVHDF5File(){
		int size=svDailyNames.size();
		long[] dims = {size};
		try {
			int tidName = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidName, 256);
				
			int sidList = H5.H5Screate_simple(1, dims, null);
			if (svGidInfo >= 0 && sidList >= 0 && size>0){
				int didList=-1;
				try{
					didList = H5.H5Dopen(svGidDaily, "Timestep List");
				}catch(Exception e){
					didList = H5.H5Dcreate(svGidDaily,
							"Timestep List", tidName,
							sidList, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				}
				
				if (didList >= 0){
					HDF5Util.writeStringData(didList, tidName, svDailyNames.toArray(new String[size]), 256);
				}
				
	            H5.H5Sclose(sidList);
	            H5.H5Tclose(tidName);
	            H5.H5Dclose(didList);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createSVLookup(){
		int size=svLookupNames.size();
		
		long[] dims = {size};
		try {
			int tidStringName = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidStringName, 256);
			
			int tidStringKind = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidStringKind, 80);
			
			int tidStringUnit = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidStringUnit, 20);
			
			int tidStringTimestep = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidStringTimestep, 4);
			
			int tidCompound = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, (256+80+20+4+4));
			int offset=0;
			int tidName = H5.H5Tinsert(tidCompound, "Name", offset, tidStringName);
			offset=offset+256;
			int tidKind = H5.H5Tinsert(tidCompound, "Kind", offset, tidStringKind);
			offset=offset+80;
			int tidUnit = H5.H5Tinsert(tidCompound, "Unit", offset, tidStringUnit);
			offset=offset+20;
			int tidTimestep = H5.H5Tinsert(tidCompound, "Timestep", offset, tidStringTimestep);
			offset=offset+4;
			int tidIndex = H5.H5Tinsert(tidCompound, "Index", offset, HDF5Constants.H5T_NATIVE_INT32);
			
			int sidLookup = H5.H5Screate_simple(1, dims, null);
			if (svGidInfo >= 0 && sidLookup >= 0){
				int didLookup=-1;
				try{
					didLookup = H5.H5Dopen(svGidInfo, "IO Variable Lookup");
				}catch(Exception e){
					didLookup = H5.H5Dcreate(svGidInfo,
							"IO Variable Lookup", tidCompound,
							sidLookup, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				}
				
				if (didLookup >= 0){
					offset=0;
					
					int tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 256);
					H5.H5Tinsert(tidCompoundTmp, "Name", offset, tidStringName);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, svLookupNames.toArray(new String[size]), 256);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 80);
					H5.H5Tinsert(tidCompoundTmp, "Kind", offset, tidStringKind);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, svLookupKinds.toArray(new String[size]), 80);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 20);
					H5.H5Tinsert(tidCompoundTmp, "Unit", offset, tidStringUnit);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, svLookupUnits.toArray(new String[size]), 20);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 4);
					H5.H5Tinsert(tidCompoundTmp, "Timestep", offset, tidStringTimestep);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, svLookupTimestep.toArray(new String[size]), 4);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 4);
					H5.H5Tinsert(tidCompoundTmp, "Index", offset, HDF5Constants.H5T_NATIVE_INT32);
					H5.H5Dwrite(didLookup, tidCompoundTmp,
							HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL, HDF5Constants.H5P_DEFAULT, 
			        		svLookupIndex.toArray(new Integer[size]));
					
					H5.H5Tclose(tidCompoundTmp);
				}
				
	            H5.H5Sclose(sidLookup);
	            H5.H5Tclose(tidStringName);
	            H5.H5Tclose(tidStringKind);
	            H5.H5Tclose(tidStringUnit);
	            H5.H5Tclose(tidStringTimestep);
	            H5.H5Tclose(tidCompound);
	            H5.H5Dclose(didLookup);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeSVHDF5DataStructure(){
		try {
			if (svGidDaily>=0)
				H5.H5Gclose(svGidDaily);
			if (svGidMonthly>=0) 
				H5.H5Gclose(svGidMonthly);
			if (svGidData>=0) 
				H5.H5Gclose(svGidData);
			if (svGidInfo>=0) 
				H5.H5Gclose(svGidInfo);
			if (svGidIOData>=0) 
				H5.H5Gclose(svGidIOData);
			if (svGidPartF>=0) 
				H5.H5Gclose(svGidPartF);
			if (svGidPartA>=0) 
				H5.H5Gclose(svGidPartA);
			if (svFid>=0)
				H5.H5Fclose(svFid);
		} catch (HDF5LibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	public static void createSVHDF5DataStructure(){
		
		String[] monthlyDateStr={TimeOperation.dssTimeEndDay(ControlData.startYear, ControlData.startMonth, TimeOperation.numberOfDays(ControlData.startMonth, ControlData.startYear))};	
		
		String[] dailyDateStr={TimeOperation.dssTimeEndDay(ControlData.startYear, ControlData.startMonth, ControlData.startDay)};										
		
		svH5FileName=FilePaths.fullSvarDssPath;
		int index=svH5FileName.lastIndexOf(".");
		svH5FileName=svH5FileName.substring(0, index+1)+"h5";
		
		svFid=HDF5Util.locateFile(svH5FileName);
		
		if (svFid<0){
			System.out.println("Failed to generate HDF5 file.");
		}else{
			try {
				svGidPartA=HDF5Util.locateGroup(svFid, ControlData.partA);
				if (svGidPartA>=0){
					svGidPartF = HDF5Util.locateGroup(svGidPartA, ControlData.svDvPartF);
					if (svGidPartF>=0){	
						
						svGidIOData = HDF5Util.locateGroup(svGidPartF, gIOData);
						if (svGidIOData>=0){
							svGidInfo = HDF5Util.locateGroup(svGidIOData, gInfo);							
							svGidData = HDF5Util.locateGroup(svGidIOData, gData);
							if(svGidData>=0){
								int tidAttr = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
								long[] dims= {1};
								int sidAttr = H5.H5Screate_simple(1, dims, null);
								H5.H5Tset_size(tidAttr, 30);
								
								svGidMonthly = HDF5Util.locateGroup(svGidData, gMonthly);
								if (svGidMonthly>=0 && tidAttr>=0 && sidAttr>=0){
									int aidMonthly=-1;
									try{
										H5.H5Aopen(svGidMonthly, "Starting Time", HDF5Constants.H5P_DEFAULT);
									}catch (Exception e){
										aidMonthly=H5.H5Acreate(svGidMonthly, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
									}
									if (aidMonthly>=0){
																			
										HDF5Util.writeStringAttr(aidMonthly, tidAttr, monthlyDateStr, 30);
										H5.H5Aclose(aidMonthly);
									}
								}
								
								svGidDaily = HDF5Util.locateGroup(svGidData, gDaily);
								if (svGidDaily>=0 && tidAttr>=0 && sidAttr>=0){
									int aidDaily=-1;
									try{
										H5.H5Aopen(svGidDaily, "Starting Time", HDF5Constants.H5P_DEFAULT);
									}catch (Exception e){
										aidDaily=H5.H5Acreate(svGidDaily, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
									}
									if (aidDaily>=0){
										
										HDF5Util.writeStringAttr(aidDaily, tidAttr, dailyDateStr, 30);
										H5.H5Aclose(aidDaily);
									}
								}
								
								H5.H5Tclose(tidAttr);
								H5.H5Sclose(sidAttr);
							}
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void readMonthlySVDssFile(){
		
		svMonthlyNames = new ArrayList<String>();
		svMonthlyData = new HashMap<String, double[]>();
		
		int dim = getTotalTimeStep("1MON");
		
		DSSUtil.generateCatalog(FilePaths.fullSvarDssPath);
		ControlData.groupSvar= DSSUtil.createGroup("local", FilePaths.fullSvarDssPath);
		String[] parts=new String[6];
		parts[0]=regularExp(ControlData.partA);
		parts[1]="";
		parts[2]="";
		parts[3]="";
		parts[4]=regularExp("1MON");
		parts[5]=regularExp(ControlData.svDvPartF);
		DataReference[] refs = ControlData.groupSvar.find(parts);
		int size = refs.length;
		for (int i=0; i<size; i++){
			DataSet ds = refs[i].getData();
			if (ds!=null && ds instanceof RegularTimeSeries){
				RegularTimeSeries rts=(RegularTimeSeries)ds;
				Date startDate=rts.getStartTime().getDate();
				int year=startDate.getYear()+1900;
				int month=startDate.getMonth();;
				int day = startDate.getDate();
				
				double[] rtsData = rts.getYArray();
				int rtsDim=rtsData.length;
				
				double[] data=new double[dim];
				
				int det_timestep=(ControlData.startYear-year)*12+(ControlData.startMonth-month);
				
				for (int j=0; j<dim; j++){
					int index=det_timestep+j;
					if (index<0 || index>=rtsDim){
						data[j]=-901.0;
					}else{
						data[j]=rtsData[index];
					}
				}
				String name=rts.getAttributes().getLocationName();
				svMonthlyNames.add(name);
				svMonthlyData.put(name, data);
				svLookupNames.add(name);
				svLookupUnits.add(ds.getAttributes().getYUnits());
				svLookupKinds.add(ds.getAttributes().getTypeName());
		        svLookupTimestep.add("1MON");
		        svLookupIndex.add(svIndex);
		        svIndex++;
			}
		}
	}
	
	public void writeMonthlySVHDF5File(){
		long[] dims={0,0};
		int size=svMonthlyNames.size();
		
		if (svGidMonthly>=0 && size>0){
			try {		
				String name=svMonthlyNames.get(0);
				int dim = svMonthlyData.get(name).length;
				
				dims[0]=dim;
				dims[1]=size;
				double[][] write_data=new double[dim][size];
				
				String dName="Timestep Table";
					
				int sidTDA = H5.H5Screate_simple(2, dims, null);
				if (sidTDA >= 0){
					int didTDA=-1;
					try{
						didTDA = H5.H5Dopen(svGidMonthly, dName);
					}catch (Exception e){
						didTDA = H5.H5Dcreate(svGidMonthly, dName, HDF5Constants.H5T_NATIVE_DOUBLE, sidTDA, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
					}
				
					if (didTDA >= 0){
						for (int i=0; i<size; i++){
								name=svMonthlyNames.get(i);
											
								double[] data = svMonthlyData.get(name);
								
								for (int j=0; j<dim; j++){
									write_data[j][i]=data[j];
								}
								
							}
						}
				
						H5.H5Dwrite(didTDA, HDF5Constants.H5T_NATIVE_DOUBLE, 
						HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL, HDF5Constants.H5P_DEFAULT, write_data);
					
						H5.H5Dclose(didTDA);
					}	
					H5.H5Sclose(sidTDA);

			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void readDailySVDssFile(){
		svDailyNames = new ArrayList<String>();
		svDailyData = new HashMap<String, double[]>();
		
		int dim = getTotalTimeStep("1DAY");
		
		DSSUtil.generateCatalog(FilePaths.fullSvarDssPath);
		ControlData.groupSvar= DSSUtil.createGroup("local", FilePaths.fullSvarDssPath);
		String[] parts=new String[6];
		parts[0]=regularExp(ControlData.partA);
		parts[1]="";
		parts[2]="";
		parts[3]="";
		parts[4]=regularExp("1DAY");
		parts[5]=regularExp(ControlData.svDvPartF);
		DataReference[] refs = ControlData.groupSvar.find(parts);
		int size = refs.length;
		for (int i=0; i<size; i++){
			DataSet ds = refs[i].getData();
			if (ds!=null && ds instanceof RegularTimeSeries){
				RegularTimeSeries rts=(RegularTimeSeries)ds;
				Date rtsStartDate=rts.getStartTime().getDate();
				long rtsStartTime=rtsStartDate.getTime();
				
				double[] rtsData = rts.getYArray();
				int rtsDim=rtsData.length;
				
				double[] data=new double[dim];
				
				Date startDate = new Date (ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
				long startTime=startDate.getTime();
				double det_timestep=(rtsStartTime-startTime)/(24*60*60*1000l);
				
				for (int j=0; j<dim; j++){
					int index=(int)det_timestep+j;
					if (index<0 || index>=rtsDim){
						data[j]=-901.0;
					}else{
						data[j]=rtsData[index];
					}
				}
				String name=rts.getAttributes().getLocationName();
				svDailyNames.add(name);
				svDailyData.put(name, data);
				svLookupNames.add(name);
				svLookupUnits.add(ds.getAttributes().getYUnits());
				svLookupKinds.add(ds.getAttributes().getTypeName());
		        svLookupTimestep.add("1DAY");
		        svLookupIndex.add(svIndex);
		        svIndex++;
			}
		}
	}
	
	public void writeDailySVHDF5File(){
		long[] dims={0,0};
		int size=svDailyNames.size();
		
		if (svGidDaily>=0 && size>0){
			try {		
				String name=svDailyNames.get(0);
				int dim = svDailyData.get(name).length;
				
				dims[0]=dim;
				dims[1]=size;
				double[][] write_data=new double[dim][size];
				
				String dName="Timestep Table";
					
				int sidTDA = H5.H5Screate_simple(2, dims, null);
				if (sidTDA >= 0){
					int didTDA = -1;
					try{
						didTDA = H5.H5Dopen(svGidDaily, dName);
					}catch (Exception e){
						didTDA = H5.H5Dcreate(svGidDaily, dName, HDF5Constants.H5T_NATIVE_DOUBLE, sidTDA, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
					}
				
					if (didTDA >= 0){
						for (int i=0; i<size; i++){
								name=svDailyNames.get(i);
											
								double[] data = svDailyData.get(name);
								
								for (int j=0; j<dim; j++){
									write_data[j][i]=data[j];
								}
								
							}
						}
				
						H5.H5Dwrite(didTDA, HDF5Constants.H5T_NATIVE_DOUBLE, 
						HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL, HDF5Constants.H5P_DEFAULT, write_data);
					
						H5.H5Dclose(didTDA);
					}	
					H5.H5Sclose(sidTDA);

			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void convertSVFileHDF5ToDss(){
		
	}
	
	public void convertInitFile(){
		if (FilePaths.initDssFile.endsWith(".dss")){
			convertInitFileDssToHDF5();
		}else if (FilePaths.initDssFile.endsWith(".h5")){
			convertInitFileHDF5ToDss();
		}
	}
	
	public void convertInitFileDssToHDF5(){
		readMonthlyInitDssFile();
		readDailyInitDssFile();
		writeMonthlyInitHDF5File();
		writeDailyInitHDF5File();
	}
	
	public void readMonthlyInitDssFile(){
		DSSUtil.generateCatalog(FilePaths.fullInitDssPath);
		ControlData.groupInit= DSSUtil.createGroup("local", FilePaths.fullInitDssPath);
	}
	
	public void writeMonthlyInitHDF5File(){
		
	}
	
	public void readDailyInitDssFile(){
		DSSUtil.generateCatalog(FilePaths.fullInitDssPath);
		ControlData.groupInit= DSSUtil.createGroup("local", FilePaths.fullInitDssPath);
	}
	
	public void writeDailyInitHDF5File(){
		
	}
	
	public void convertInitFileHDF5ToDss(){
		
	}
	
	public void processArgs(String[] args){
		
		if(args[0].startsWith("-")) {
			ConfigUtils.loadArgs(args);
		} else {		
			setControlData(args);
		}		
	}
	
	public void setControlData(String[] args){
		FilePaths.groundwaterDir=args[0];
        FilePaths.setMainFilePaths(args[1]);
        FilePaths.setSvarDssPaths(args[2]);
        FilePaths.setInitDssPaths(args[3]);
        FilePaths.setDvarDssPaths(args[4]);
		ControlData.svDvPartF=args[5];
		ControlData.initPartF=args[6];
		ControlData.partA = args[7];
		ControlData.defaultTimeStep = args[8];
		ControlData.startYear=Integer.parseInt(args[9]);
		ControlData.startMonth=Integer.parseInt(args[10]);
		ControlData.startDay=Integer.parseInt(args[11]);
		ControlData.endYear=Integer.parseInt(args[12]);
		ControlData.endMonth=Integer.parseInt(args[13]);
		ControlData.endDay=Integer.parseInt(args[14]);
		ControlData.solverName=args[15];
		FilePaths.csvFolderName = args[16];
		ControlData.currYear=ControlData.startYear;
		ControlData.currMonth=ControlData.startMonth;
		ControlData.currDay=ControlData.startDay;
	}
	
	public static void main(String[] args){
		new DSSHDF5Converter(args);
	}
	
	public static String regularExp(String part){
		return "^"+part+"$";
	}
	
	public int getTotalTimeStep(String timestepStr){
		if (timestepStr.equals("1MON")){
			int timestep=(ControlData.endYear-ControlData.startYear)*12+(ControlData.endMonth-ControlData.startMonth)+1;
			return timestep;
		}else if (timestepStr.equals("1DAY")){
			Date startDate = new Date (ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
			Date endDate=new Date (ControlData.endYear-1900, ControlData.endMonth-1, ControlData.endDay);
			long startTime=startDate.getTime();
			long endTime=endDate.getTime();
			double timestep=(endTime-startTime)/(24*60*60*1000l)+1;
			return (int)timestep;
		}
		return 0;
	}
		
}
