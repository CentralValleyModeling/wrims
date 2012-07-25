package wrimsv2.debug;

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
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.external.LoadAllDll;

public class ReLoadSVDss {
	public ReLoadSVDss(StudyDataSet sds){
		ControlData.currStudyDataSet=sds;
				
		if (!(new File(FilePaths.fullSvarDssPath)).exists()){ 
			System.out.println("Error: Svar file "+ FilePaths.fullSvarDssPath+" doesn't exist.");
			System.out.println("=======Run Complete Unsuccessfully=======");
			System.exit(0);
		}
		ControlData.groupSvar= DSSUtil.createGroup("local", FilePaths.fullSvarDssPath);
		ControlData.allTsMap=sds.getTimeseriesMap();
		
		readTimeseries();
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
}
