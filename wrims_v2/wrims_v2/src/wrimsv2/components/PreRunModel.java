package wrimsv2.components;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import vista.db.dss.DSSDataWriter;
import vista.db.dss.DSSUtil;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.external.LoadAllDll;
import wrimsv2.hdf5.HDF5Reader;
import wrimsv2.hdf5.HDF5Writer;

public class PreRunModel {
	public PreRunModel(StudyDataSet sds){
		ControlData.currStudyDataSet=sds;
		VariableTimeStep.procCycleTimeStep(sds);
		ControlData.totalTimeStep=VariableTimeStep.getTotalTimeStep(sds);
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();
		ControlData.monthlyStartTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, TimeOperation.numberOfDays(ControlData.startMonth, ControlData.startYear));
		ControlData.dailyStartTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);

		//if (ControlData.outputType!=1){
			ControlData.writer = new DSSDataWriter(FilePaths.fullDvarDssPath);
			try {
				ControlData.writer.openDSSFile();
			} catch (Exception e) {
				ControlData.writer.closeDSSFile();
				Error.addEngineError("Could not open dv file. "+e);
				return;
			}
		//}
		
		if (!(new File(FilePaths.fullInitFilePath)).exists()){
			System.out.println("Error: Initial file "+ FilePaths.fullInitFilePath+" doesn't exist.");
			System.out.println("=======Run Complete Unsuccessfully=======");
			System.exit(1);
		}
		if (!(new File(FilePaths.fullSvarFilePath)).exists()){
			System.out.println("Error: Svar file "+ FilePaths.fullSvarFilePath+" doesn't exist.");
			System.out.println("=======Run Complete Unsuccessfully=======");
			System.exit(1);
		}
		ControlData.allTsMap=sds.getTimeseriesMap();

		if (FilePaths.svarFile.toLowerCase().endsWith(".h5")){
			HDF5Reader.readTimeseries();
		}else{
			DSSUtil.generateCatalog(FilePaths.fullSvarFilePath);
			ControlData.groupSvar= DSSUtil.createGroup("local", FilePaths.fullSvarFilePath);
			if (!FilePaths.fullSvarFile2Path.equals("")){
				ControlData.groupSvar2= DSSUtil.createGroup("local", FilePaths.fullSvarFile2Path);
			}
			readTimeseries();
		}

		if (FilePaths.initFile.toLowerCase().endsWith(".h5")){
			ControlData.initHDF5=true;
			HDF5Reader.readInitialData();
		}else{
			ControlData.initHDF5=false;
			DSSUtil.generateCatalog(FilePaths.fullInitFilePath);
			ControlData.groupInit= DSSUtil.createGroup("local", FilePaths.fullInitFilePath);
		}
		initialDvarAliasTS();

		for (int i=0; i<modelList.size(); i++){
			String model=modelList.get(i);
			ModelDataSet mds=modelDataSetMap.get(model);
			ControlData.currModelDataSet=mds;
			ControlData.currCycleIndex=i;
			processExternal();
		}

		if (ControlData.outputType==1){
			System.out.println("Create HDF5 output data structure.");
			HDF5Writer.createDataStructure();
			HDF5Writer.listCycleStaticVariables(sds);
			System.out.println("HDF5 output data structure is created.");
		}
		
		setSelectedOutputCycles();
	}

	public void readTimeseries(){
		Map<String, Timeseries> tsMap=ControlData.currStudyDataSet.getTimeseriesMap();
		Map<String, ArrayList<String>> tsTimeStepMap=ControlData.currStudyDataSet.getTimeseriesTimeStepMap();
		ControlData.currEvalTypeIndex=6;
		Set tsKeySet=tsMap.keySet();
		Iterator iterator=tsKeySet.iterator();
		while(iterator.hasNext()){
			String tsName=(String)iterator.next();
			//System.out.println("Reading svar timeseries "+tsName);
			//To Do: in the svar class, add flag to see if svTS has been loaded
			if (!DataTimeSeries.lookSvDss.contains(tsName)){
				ArrayList<String> timeStepList=tsTimeStepMap.get(tsName);
				for (String timeStep:timeStepList){
					DssOperation.getSVTimeseries(tsName, FilePaths.fullSvarFilePath, timeStep, 1);
					if (!FilePaths.fullSvarFile2Path.equals("")){
						DssOperation.getSVTimeseries(tsName, FilePaths.fullSvarFile2Path, timeStep, 2);
					}
					String entryNameTS=DssOperation.entryNameTS(tsName, timeStep);
					DataTimeSeries.lookSvDss.add(entryNameTS);
				}
			}
		}
		System.out.println("Timeseries Reading Done.");
	}

	public void	initialDvarAliasTS(){
		DataTimeSeries.dvAliasTS=new HashMap<String, DssDataSetFixLength>();
		//if (ControlData.outputCycleToDss) {
		ControlData.cycleDataStartYear=ControlData.startYear;
		ControlData.cycleDataStartMonth=ControlData.startMonth;
		ControlData.cycleDataStartDay=ControlData.startDay;
		int totalCycleNumber=ControlData.currStudyDataSet.getModelList().size();
		DataTimeSeries.dvAliasTSCycles=new ArrayList<HashMap<String, DssDataSetFixLength>>(totalCycleNumber);
		for (int i=0; i<totalCycleNumber; i++){
			HashMap<String, DssDataSetFixLength> dvAliasTSCycle = new HashMap<String, DssDataSetFixLength>();
			DataTimeSeries.dvAliasTSCycles.add(dvAliasTSCycle);
		}
		//}
	}

	public void processExternal(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> exList = mds.exList;
		Map<String, External> exMap =mds.exMap;
		ControlData.currExMap=exMap;
		ControlData.currEvalTypeIndex=4;
		for (String exName: exList){
			if (!ControlData.allExternalFunction.containsKey(exName)){
				ControlData.currEvalName=exName;
				External external=exMap.get(exName);
				ControlData.allExternalFunction.put(exName, external.type);
				if (!external.type.equals("f90") && !ControlData.allDll.contains(exName)){
					ControlData.allDll.add(external.type);
				}
			}
		}
		new LoadAllDll(ControlData.allDll);
		System.out.println("Load dlls for Cycle "+(ControlData.currCycleIndex+1)+" done");
	}
	
	public void setSelectedOutputCycles(){
		String strSelectedCycleOutput = ControlData.selectedCycleOutput.replace("\'", "");
		ControlData.selectedCycles = strSelectedCycleOutput.split(",");
	}
}
