package wrimsv2.solver;

import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;

public class initialXALog {
	public initialXALog(){
		ControlData.xasolver.setCommand( "FileName  "+FilePaths.mainDirectory+"  Output "+FilePaths.mainDirectory+"\\xa.log set sortName YES MPSX Yes ToRcc Yes") ;
	}
}
