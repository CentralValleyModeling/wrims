package wrimsv2_plugin.debugger.pa;

import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;
import hec.hecmath.TimeSeriesMath;
import hec.io.TimeSeriesContainer;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import org.apache.commons.io.FileUtils;

import wrimsv2_plugin.batchrun.BatchRunProcess;
import wrimsv2_plugin.batchrun.LaunchConfigInfo;
import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.DssOperations;
import wrimsv2_plugin.tools.FileProcess;

public class PAProcInitBR {
	
	private String initFile="";
	
	public PAProcInitBR(LaunchConfigInfo configuration, int sid){
		String suffix="";
		if (sid>1) suffix="_MS"+sid;
		initFile = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_INITFILE+suffix, (String)null);
	}
	
	public void createPAInit(String launchFilePath, BatchRunProcess brp){
		File initDSSFile=new File(initFile);
		if (initFile !=null){
			if (!initDSSFile.isAbsolute()){
				initFile=FileProcess.procRelativePath(initFile, launchFilePath);
				initDSSFile=new File(initFile);
			}
			brp.paInitFile=createPAInitFileName(initFile);
			if (initDSSFile !=null){
				File newInitDSSFile = new File(brp.paInitFile);
				try {
					FileUtils.copyFile(initDSSFile, newInitDSSFile);
				} catch (IOException e) {
					WPPException.handleException(e);
				}
			}
		}
	}
	
	public String createPAInitFileName(String initFile){
		File file = new File(initFile);
		String fn = file.getName();
		String fp = file.getParent();
		String prefix="\\pa_";
		File newFile=new File(fp+prefix+fn);
		while (newFile.exists()){
			prefix=prefix+"_";
			newFile=new File(fp+prefix+fn);
		}
		return fp+prefix+fn;
	}
	
	public void deletePAInit(BatchRunProcess brp){
		if (brp.deletePAInit){
			final File paInit=new File(brp.paInitFile);
			paInit.delete();
		}
	}
	
	public void createInitData(PAProcRunBR procRun, BatchRunProcess brp){
		DssOperations.waitForDSSOp();
		HecDss paInitDss;
		try {
			paInitDss=HecDss.open(brp.paInitFile);
		} catch (Exception e) {
			WPPException.handleException(e);
			DssOperations.setIsDssInOp(false);
			return;
		}
		Vector<String> paPathList = paInitDss.getPathnameList();
		Collections.sort(paPathList, Collections.reverseOrder());
		for (int i=0; i<paPathList.size(); i++){
			String path = paPathList.get(i);
			try {
				TimeSeriesContainer dc = (TimeSeriesContainer)paInitDss.get(path);
				TimeSeriesMath tm = new TimeSeriesMath(dc);
				HecMath newTm = tm.shiftInTime(brp.paStartInterval+"MON");
				paInitDss.write(newTm);
			} catch (Exception e) {
				WPPException.handleException(e);
			}
		}
		paInitDss.close();
		DssOperations.setIsDssInOp(false);
	}

}
