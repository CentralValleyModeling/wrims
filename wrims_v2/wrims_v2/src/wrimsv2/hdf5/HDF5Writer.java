package wrimsv2.hdf5;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ncsa.hdf.hdf5lib.H5;
import ncsa.hdf.hdf5lib.HDF5Constants;
import ncsa.hdf.hdf5lib.exceptions.HDF5LibraryException;
import ncsa.hdf.object.h5.H5File;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.TimeOperation;

public class HDF5Writer {
	
	private static boolean hasDvarAliasLookup=false;
	private static String[] dvAsLookupNames;
	private static String[] dvAsLookupKinds;
	private static String[] dvAsLookupUnits;
	private static String[] dvAsLookupTimestep;
	private static int[] dvAsLookupIndex;
	private static ArrayList<String> monthlyDvarAliasList = new ArrayList<String>();
	private static ArrayList<String> dailyDvarAliasList =  new ArrayList<String>();
	private static Map<String, String> monthlyDvarAliasMap = new HashMap<String, String>();
	private static Map<String, String> dailyDvarAliasMap =  new HashMap<String, String>();
	private static String h5FileName="";
	private static int fid=-1;
	private static String gPartA=ControlData.partA;
	private static int gidPartA=-1;
	private static String gPartF=ControlData.svDvPartF;
	private static int gidPartF=-1;
	private static String gIOData="IO Data";
	private static int gidIOData=-1;
	private static String gInfo="Info";
	private static int gidInfo=-1;
	private static String gData="Data";
	private static int gidData=-1;
	private static String gMonthly="Monthly";
	private static int gidMonthly=-1;
	private static String gDaily="Daily";
	private static int gidDaily=-1;
	private static String gSC="Static Cycle";
	private static int gidSC=-1;
	private static String gDC="Dynamic Cycle";
	private static int gidDC=-1;
	private static String gSCMonthly="Monthly";
	private static int gidSCMonthly=-1;
	private static String gSCDaily="Daily";
	private static int gidSCDaily=-1;
	private static String gDCMonthly="Monthly";
	private static int gidDCMonthly=-1;
	private static String gDCDaily="Daily";
	private static int gidDCDaily=-1;
	
	public static void createDataStructure(){
		h5FileName=FilePaths.fullDvarDssPath;
		if (h5FileName.toLowerCase().endsWith(".dss")){
			int index=h5FileName.lastIndexOf(".");
			h5FileName=h5FileName.substring(0, index+1)+"h5";
		}
		fid=HDF5Util.locateFile(h5FileName);
		
		Date date = ControlData.monthlyStartTime;
		String[] monthlyDateStr={TimeOperation.dssTimeEndDay(date.getYear()+1900, date.getMonth()+1, date.getDate())};	
		
		date = ControlData.dailyStartTime;
		String[] dailyDateStr={TimeOperation.dssTimeEndDay(date.getYear()+1900, date.getMonth()+1, date.getDate())};										
		
		if (fid<0){
			System.out.println("Failed to generate HDF5 file.");
		}else{
			try {
				gidPartA=HDF5Util.locateGroup(fid, gPartA);
				if (gidPartA>=0){
					gidPartF = HDF5Util.locateGroup(gidPartA, gPartF);
					if (gidPartF>=0){	
						gidSC=HDF5Util.locateGroup(gidPartF, gSC);
						if (gidSC>=0){	
							int tidAttr = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
							long[] dims= {1};
							int sidAttr = H5.H5Screate_simple(1, dims, null);
							H5.H5Tset_size(tidAttr, 30);
							
							gidSCMonthly=HDF5Util.locateGroup(gidSC, gSCMonthly);
							if (gidSCMonthly>=0 && tidAttr>=0 && sidAttr>=0){
								int aidMonthly=-1;
								try{
									H5.H5Aopen(gidSCMonthly, "Starting Time", HDF5Constants.H5P_DEFAULT);
								}catch (Exception e){
									aidMonthly=H5.H5Acreate(gidSCMonthly, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
								}
								if (aidMonthly>=0){
																		
									HDF5Util.writeStringAttr(aidMonthly, tidAttr, monthlyDateStr, 30);
									H5.H5Aclose(aidMonthly);
								}
							}
							
							gidSCDaily=HDF5Util.locateGroup(gidSC, gSCDaily);
							if (gidSCDaily>=0 && tidAttr>=0 && sidAttr>=0){
								int aidDaily=-1;
								try{
									H5.H5Aopen(gidSCDaily, "Starting Time", HDF5Constants.H5P_DEFAULT);
								}catch (Exception e){
									aidDaily=H5.H5Acreate(gidSCDaily, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
								}
								if (aidDaily>=0){
									
									HDF5Util.writeStringAttr(aidDaily, tidAttr, dailyDateStr, 30);
									H5.H5Aclose(aidDaily);
								}
							}
							
							H5.H5Tclose(tidAttr);
							H5.H5Sclose(sidAttr);
						}
						
						gidDC=HDF5Util.locateGroup(gidPartF, gDC);
						if (gidDC>=0){			
							int tidAttr = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
							long[] dims= {1};
							int sidAttr = H5.H5Screate_simple(1, dims, null);
							H5.H5Tset_size(tidAttr, 30);
							
							gidDCMonthly=HDF5Util.locateGroup(gidDC, gDCMonthly);
							if (gidDCMonthly>=0 && tidAttr>=0 && sidAttr>=0){
								int aidMonthly=-1;
								try{
									H5.H5Aopen(gidDCMonthly, "Starting Time", HDF5Constants.H5P_DEFAULT);
								}catch (Exception e){
									aidMonthly=H5.H5Acreate(gidDCMonthly, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
								}
								if (aidMonthly>=0){
																		
									HDF5Util.writeStringAttr(aidMonthly, tidAttr, monthlyDateStr, 30);
									H5.H5Aclose(aidMonthly);
								}
							}
							
							gidDCDaily=HDF5Util.locateGroup(gidDC, gDCDaily);
							if (gidDCDaily>=0 && tidAttr>=0 && sidAttr>=0){
								int aidDaily=-1;
								try{
									H5.H5Aopen(gidDCDaily, "Starting Time", HDF5Constants.H5P_DEFAULT);
								}catch (Exception e){
									aidDaily=H5.H5Acreate(gidDCDaily, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
								}
								if (aidDaily>=0){
									
									HDF5Util.writeStringAttr(aidDaily, tidAttr, dailyDateStr, 30);
									H5.H5Aclose(aidDaily);
								}
							}
							
							H5.H5Tclose(tidAttr);
							H5.H5Sclose(sidAttr);
						}
						
						gidIOData = HDF5Util.locateGroup(gidPartF, gIOData);
						if (gidIOData>=0){
							gidInfo = HDF5Util.locateGroup(gidIOData, gInfo);							
							gidData = HDF5Util.locateGroup(gidIOData, gData);
							if(gidData>=0){
								int tidAttr = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
								long[] dims= {1};
								int sidAttr = H5.H5Screate_simple(1, dims, null);
								H5.H5Tset_size(tidAttr, 30);
								
								gidMonthly = HDF5Util.locateGroup(gidData, gMonthly);
								if (gidMonthly>=0 && tidAttr>=0 && sidAttr>=0){
									int aidMonthly=-1;
									try{
										H5.H5Aopen(gidMonthly, "Starting Time", HDF5Constants.H5P_DEFAULT);
									}catch (Exception e){
										aidMonthly=H5.H5Acreate(gidMonthly, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
									}
									if (aidMonthly>=0){
																			
										HDF5Util.writeStringAttr(aidMonthly, tidAttr, monthlyDateStr, 30);
										H5.H5Aclose(aidMonthly);
									}
								}
								
								gidDaily = HDF5Util.locateGroup(gidData, gDaily);
								if (gidDaily>=0 && tidAttr>=0 && sidAttr>=0){
									int aidDaily=-1;
									try{
										H5.H5Aopen(gidDaily, "Starting Time", HDF5Constants.H5P_DEFAULT);
									}catch (Exception e){
										aidDaily=H5.H5Acreate(gidDaily, "Starting Time", tidAttr, sidAttr, HDF5Constants.H5P_DEFAULT);
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
	
	public static void createDvarAliasLookup(){
		HashMap<String, DssDataSetFixLength> dvAliasTs = DataTimeSeries.dvAliasTS;
		int size=dvAliasTs.size();
		dvAsLookupNames=new String[size];
		dvAsLookupKinds=new String[size];
		dvAsLookupUnits=new String[size];
		dvAsLookupTimestep=new String[size];
		dvAsLookupIndex=new int[size];
		Set dvAliasCollection = dvAliasTs.keySet();
		Iterator dvarIterator = dvAliasCollection.iterator();
		int i=0;
		while(dvarIterator.hasNext()){ 
			String dvAliasName=(String)dvarIterator.next();
			DssDataSetFixLength dds = dvAliasTs.get(dvAliasName);
			String dvAliasNameMod=dvAliasName.substring(0, dvAliasName.length()-5);
			dvAsLookupNames[i]=dvAliasNameMod;
			dvAsLookupKinds[i]=dds.getKind();
			dvAsLookupUnits[i]=dds.getUnits();
			String timestep=dds.getTimeStep();
			dvAsLookupTimestep[i]=timestep;
			int j=i+1;
			dvAsLookupIndex[i]=j;
			if (timestep.equals("1MON")){
				monthlyDvarAliasMap.put(dvAliasName, dvAliasNameMod);
				monthlyDvarAliasList.add(dvAliasName);
			}else if (timestep.equals("1DAY")){
				dailyDvarAliasMap.put(dvAliasName, dvAliasNameMod);
				dailyDvarAliasList.add(dvAliasName);
			}
			i=i+1;
		}
		
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
			if (gidInfo >= 0 && sidLookup >= 0){
				int didLookup=-1;
				try{
					didLookup = H5.H5Dopen(gidInfo, "IO Variable Lookup");
				}catch(Exception e){
					didLookup = H5.H5Dcreate(gidInfo,
							"IO Variable Lookup", tidCompound,
							sidLookup, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				}
				
				if (didLookup >= 0){
					offset=0;
					
					int tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 256);
					H5.H5Tinsert(tidCompoundTmp, "Name", offset, tidStringName);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, dvAsLookupNames, 256);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 80);
					H5.H5Tinsert(tidCompoundTmp, "Kind", offset, tidStringKind);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, dvAsLookupKinds, 80);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 20);
					H5.H5Tinsert(tidCompoundTmp, "Unit", offset, tidStringUnit);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, dvAsLookupUnits, 20);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 4);
					H5.H5Tinsert(tidCompoundTmp, "Timestep", offset, tidStringTimestep);
					HDF5Util.writeStringData(didLookup, tidCompoundTmp, dvAsLookupTimestep, 4);
					
					tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 4);
					H5.H5Tinsert(tidCompoundTmp, "Index", offset, HDF5Constants.H5T_NATIVE_INT32);
					H5.H5Dwrite(didLookup, tidCompoundTmp,
							HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL, HDF5Constants.H5P_DEFAULT, 
			        		dvAsLookupIndex);
					
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
	
	public static void writeTimestepData(){
		if (fid>0){
			writeTimestepDvarAlias();
		}
	}
	
	public static void writeTimestepDvarAlias(){
		System.out.println("write dvar and alias to HDF5 file");
		listMonthlyTimestepDvarAlias();
		writeMonthlyTimestepDvarAlias();
		listDailyTimestepDvarAlias();
		writeDailyTimestepDvarAlias();
	}

	public static void writeMonthlyTimestepDvarAlias_deprecated(){
		
		long[] dims={0};
		
		if (gidMonthly>=0){
			try {
				String name=monthlyDvarAliasList.get(0);
				int dim = DataTimeSeries.dvAliasTS.get(name).getData().length;
				dims[0]=dim;
				
				int size=monthlyDvarAliasList.size();
				int tableCount=(size-1)/1000+1;
				int lastTableColCount=size%1000;
				if (lastTableColCount==0) lastTableColCount=1000;
	
				for (int k=0; k<tableCount; k++){
					int offset=0;
					int endi, colCount;
					
					int kk=k+1;
					if (kk<tableCount){
						endi=1000*kk;
						colCount=1000;
					}else{
						endi=size;
						colCount=lastTableColCount;
					}
					String dName="Timestep Table "+kk;
					
					int tidCompound = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 8*colCount);
					for (int i=k*1000; i<endi; i++){
						name=monthlyDvarAliasList.get(i);
						int j=i-k*1000;
					
						int tidValue = H5.H5Tinsert(tidCompound, String.valueOf(j), offset, HDF5Constants.H5T_NATIVE_DOUBLE);
						offset=offset+8;
					}
					H5.H5Tclose(tidCompound);
					
					int sidTDA = H5.H5Screate_simple(1, dims, null);
					if (sidTDA >= 0){
						int didTDA = H5.H5Dcreate(gidMonthly, dName, tidCompound, sidTDA, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				
						if (didTDA >= 0){
							offset=0;
							for (int i=k*1000; i<endi; i++){
								name=monthlyDvarAliasList.get(i);
								int j=i=k*1000;
								
								int tidCompoundTmp = H5.H5Tcreate(HDF5Constants.H5T_COMPOUND, 8);						
								H5.H5Tinsert(tidCompoundTmp, String.valueOf(j), offset, HDF5Constants.H5T_NATIVE_DOUBLE);
						
								double[] data = DataTimeSeries.dvAliasTS.get(name).getData();
								
								H5.H5Dwrite(didTDA, tidCompoundTmp, 
							        HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL, HDF5Constants.H5P_DEFAULT, data);
							
								H5.H5Tclose(tidCompoundTmp);
							}
						}
						H5.H5Dclose(didTDA);
					}	
					H5.H5Sclose(sidTDA);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
public static void writeMonthlyTimestepDvarAlias(){
		
		long[] dims={0,0};
		
		if (gidMonthly>=0 && monthlyDvarAliasList.size()>0){
			try {		
				String name=monthlyDvarAliasList.get(0);
				int dim = DataTimeSeries.dvAliasTS.get(name).getData().length;
				
				int size=monthlyDvarAliasList.size();
				
				dims[0]=dim;
				dims[1]=size;
				double[][] write_data=new double[dim][size];
				
				String dName="Timestep Table";
					
				int sidTDA = H5.H5Screate_simple(2, dims, null);
				if (sidTDA >= 0){
					int didTDA=-1;
					try{
						didTDA = H5.H5Dopen(gidMonthly, dName);
					}catch (Exception e){
						didTDA = H5.H5Dcreate(gidMonthly, dName, HDF5Constants.H5T_NATIVE_DOUBLE, sidTDA, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
					}
					
					//int didTDA = H5.H5Dcreate(gidMonthly, dName, HDF5Constants.H5T_NATIVE_DOUBLE, sidTDA, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				
					if (didTDA >= 0){
						for (int i=0; i<size; i++){
								name=monthlyDvarAliasList.get(i);
											
								double[] data = DataTimeSeries.dvAliasTS.get(name).getData();
								
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
	
	public static void writeDailyTimestepDvarAlias(){
		
		long[] dims={0,0};
		
		if (gidDaily>=0 && dailyDvarAliasList.size()>0){
			try {		
				String name=dailyDvarAliasList.get(0);
				int dim = DataTimeSeries.dvAliasTS.get(name).getData().length;
				
				int size=dailyDvarAliasList.size();
				
				dims[0]=dim;
				dims[1]=size;
				double[][] write_data=new double[dim][size];
				
				String dName="Timestep Table";
					
				int sidTDA = H5.H5Screate_simple(2, dims, null);
				if (sidTDA >= 0){
					int didTDA = -1;
					try{
						didTDA = H5.H5Dopen(gidDaily, dName);
					}catch (Exception e){
						didTDA = H5.H5Dcreate(gidDaily, dName, HDF5Constants.H5T_NATIVE_DOUBLE, sidTDA, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
					}
				
					if (didTDA >= 0){
						for (int i=0; i<size; i++){
								name=dailyDvarAliasList.get(i);
											
								double[] data = DataTimeSeries.dvAliasTS.get(name).getData();
								
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
	
	public static void listMonthlyTimestepDvarAlias(){
		int size=monthlyDvarAliasList.size();
		long[] dims = {size};
		try {
			int tidName = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidName, 256);
				
			int sidList = H5.H5Screate_simple(1, dims, null);
			if (gidInfo >= 0 && sidList >= 0 && size>0){
				int didList=-1;
				try{
					didList = H5.H5Dopen(gidMonthly, "Timestep List");
				}catch(Exception e){
					didList = H5.H5Dcreate(gidMonthly,
							"Timestep List", tidName,
							sidList, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				}
				
				if (didList >= 0){
					String[] nameList=new String[size];
					for (int i=0; i<size; i++){
						nameList[i]=monthlyDvarAliasMap.get(monthlyDvarAliasList.get(i));
					}
					HDF5Util.writeStringData(didList, tidName, nameList, 256);
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
	
	public static void listDailyTimestepDvarAlias(){
		int size=dailyDvarAliasList.size();
		long[] dims = {size};
		try {
			int tidName = H5.H5Tcopy(HDF5Constants.H5T_C_S1);
			H5.H5Tset_size(tidName, 256);
				
			int sidList = H5.H5Screate_simple(1, dims, null);
			if (gidInfo >= 0 && sidList >= 0 && size>0){
				int didList=-1;
				try{
					didList = H5.H5Dopen(gidDaily, "Timestep List");
				}catch(Exception e){
					didList = H5.H5Dcreate(gidDaily,
							"Timestep List", tidName,
							sidList, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				}
				
				if (didList >= 0){
					String[] nameList=new String[size];
					for (int i=0; i<size; i++){
						nameList[i]=dailyDvarAliasMap.get(dailyDvarAliasList.get(i));
					}
					HDF5Util.writeStringData(didList, tidName, nameList, 256);
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
	
	public static void writeOneCycle(ModelDataSet mds, int index){
		if (fid>0){
			if (ControlData.timeStep.equals("1MON")) {
				writeMonthlyCycle(mds, index);
			}else if (ControlData.timeStep.equals("1DAY")){
				writeDailyCycle(mds, index);
			}
		}
	}
	
	public static void writeMonthlyCycle(ModelDataSet mds, int index){
		
			//writeMonthlyCycleStaticVariables(mds, index);
			//writeMonthlyCycleDynamicVariables(mds, index);
		
	}
	
	public static void writeDailyCycle(ModelDataSet mds, int index){
		
		
	}
	
	public static void listCycleStaticVariables(){
	
	}
	
	public static void skipOneCycle(ModelDataSet mds, int index){
		if (fid>0){
			if (ControlData.timeStep.equals("1MON")) {
				
			}else if (ControlData.timeStep.equals("1DAY")){
				
			}
		}
	}
	
	public static void closeDataStructure(){
			try {
				if (gidSCDaily>=0)
					H5.H5Gclose(gidSCDaily);
				if (gidSCMonthly>=0) 
					H5.H5Gclose(gidSCMonthly);
				if (gidSC>=0)
					H5.H5Gclose(gidSC);
				if (gidDCDaily>=0)
					H5.H5Gclose(gidDCDaily);
				if (gidDCMonthly>=0) 
					H5.H5Gclose(gidDCMonthly);
				if (gidDC>=0)
					H5.H5Gclose(gidDC);
				if (gidDaily>=0)
					H5.H5Gclose(gidDaily);
				if (gidMonthly>=0) 
					H5.H5Gclose(gidMonthly);
				if (gidData>=0) 
					H5.H5Gclose(gidData);
				if (gidInfo>=0) 
					H5.H5Gclose(gidInfo);
				if (gidIOData>=0) 
					H5.H5Gclose(gidIOData);
				if (gidPartF>=0) 
					H5.H5Gclose(gidPartF);
				if (gidPartA>=0) 
					H5.H5Gclose(gidPartA);
				if (fid>=0)
					H5.H5Fclose(fid);
			} catch (HDF5LibraryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
