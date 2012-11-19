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

public class PreRunModel {
	public PreRunModel(StudyDataSet sds){
		ControlData.currStudyDataSet=sds;
		VariableTimeStep.procCycleTimeStep(sds);
		ControlData.totalTimeStep=VariableTimeStep.getTotalTimeStep(sds);
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		ControlData.monthlyStartTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, TimeOperation.numberOfDays(ControlData.startMonth, ControlData.startYear));
		ControlData.dailyStartTime=new Date(ControlData.startYear-1900, ControlData.startMonth-1, ControlData.startDay);
				
		ControlData.writer = new DSSDataWriter(FilePaths.fullDvarDssPath);
		try {
			ControlData.writer.openDSSFile();
		} catch (Exception e) {
			ControlData.writer.closeDSSFile();
			Error.addEngineError("Could not open dv file. "+e);
			return;
		}
		
		if (!(new File(FilePaths.fullInitDssPath)).exists()){ 
			System.out.println("Error: Initial file "+ FilePaths.fullInitDssPath+" doesn't exist.");
			System.out.println("=======Run Complete Unsuccessfully=======");
			System.exit(0);
		}
		if (!(new File(FilePaths.fullSvarDssPath)).exists()){ 
			System.out.println("Error: Svar file "+ FilePaths.fullSvarDssPath+" doesn't exist.");
			System.out.println("=======Run Complete Unsuccessfully=======");
			System.exit(0);
		}
		ControlData.groupInit= DSSUtil.createGroup("local", FilePaths.fullInitDssPath);
		ControlData.groupSvar= DSSUtil.createGroup("local", FilePaths.fullSvarDssPath);
		ControlData.allTsMap=sds.getTimeseriesMap();
		
		readTimeseries();
		initialDvarAliasTS();
		for (int i=0; i<modelList.size(); i++){
			String model=modelList.get(i);
			ModelDataSet mds=modelDataSetMap.get(model);
			ControlData.currModelDataSet=mds;
			ControlData.currCycleIndex=i;
			processExternal();
		}
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
					DssOperation.getSVTimeseries(tsName, FilePaths.fullSvarDssPath, timeStep);
					String entryNameTS=DssOperation.entryNameTS(tsName, timeStep);
					DataTimeSeries.lookSvDss.add(entryNameTS);
				}
			}
		}
		System.out.println("Timeseries Reading Done.");
	}
	
	public void	initialDvarAliasTS(){
		DataTimeSeries.dvAliasTS=new HashMap<String, DssDataSetFixLength>();
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
}
