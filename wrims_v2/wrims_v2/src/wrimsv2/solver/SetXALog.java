package wrimsv2.solver;

import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;

public class SetXALog {
	public static void enableXALog(){
		ControlData.xasolver.setCommand( "set debug no ToRcc Yes FileName  "+FilePaths.mainDirectory+"  Output "+FilePaths.mainDirectory+"\\xa.log set sortName YES MPSX Yes Set FreqLog :01") ;
		//ControlData.xasolver.setCommand("When +10920 FileName d:\\xatemp\\xa%d ToRcc Yes Output xa%d set sortName YES MPSX Yes");
	}
	
	public static void disableXALog(){
		ControlData.xasolver.setCommand("set debug no");
	}
}
