package wrimsv2.components;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;

public class VariableTimeStep {
	static void setCycleTimeStep(StudyDataSet sds){
		String timeStep=sds.getModelTimeStepList().get(ControlData.currCycleIndex);
		if (timeStep.equals(Param.undefined)){
			ControlData.timeStep=ControlData.defaultTimeStep;
			ControlData.partE=ControlData.defaultTimeStep;
		}else{
			ControlData.timeStep=timeStep;
			ControlData.partE=timeStep;
		}
	}
}
