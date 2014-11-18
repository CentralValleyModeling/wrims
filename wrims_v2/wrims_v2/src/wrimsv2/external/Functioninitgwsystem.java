package wrimsv2.external;

import java.io.File;
import java.util.*;

import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.VariableTimeStep;
import wrimsv2.ilp.ILP;

public class Functioninitgwsystem extends ExternalFunction{
	private final boolean DEBUG = false;


	public Functioninitgwsystem(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param1 = stack.pop();

		String cGWPath = FilePaths.groundwaterDir;
		int iLenGWPath = cGWPath.length();
		String cOutPath = FilePaths.dvarDssDirectory;
		int iLenOutPath = cOutPath.length();
		String cTimeStep = ControlData.defaultTimeStep;
		int iNTimeSteps = VariableTimeStep.getTotalTimeStep(ControlData.defaultTimeStep);
		int iSimBeginMonth = ControlData.startMonth;
		int iSimBeginYear = ControlData.startYear;
		int iSimMode=0;
		
		if (ILP.logging){
			iSimMode = 1;
		}

		float result = initgwsystem(cGWPath,iLenGWPath,cOutPath,iLenOutPath,cTimeStep,iNTimeSteps,iSimBeginMonth,iSimBeginYear,iSimMode);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float initgwsystem(String cGWPath, int iLenGWPath,String cOutPath, int iLenOutPath, String cTimeStep, int iNTimeSteps, int iSimBeginMonth, int iSimBeginYear, int iSimMode);
}
