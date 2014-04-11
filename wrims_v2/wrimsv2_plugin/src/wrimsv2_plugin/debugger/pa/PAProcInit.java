package wrimsv2_plugin.debugger.pa;

import hec.heclib.dss.HecDSSDataAttributes;
import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;
import hec.hecmath.TimeSeriesMath;
import hec.io.DataContainer;
import hec.io.TimeSeriesContainer;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.FileProcess;
import wrimsv2_plugin.tools.TimeOperation;

public class PAProcInit {
	
	private String initFile="";
	
	public PAProcInit(ILaunchConfiguration configuration){
		try {
			initFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_INITFILE, (String)null);
		} catch (CoreException e) {
			WPPException.handleException(e);
		}
	}
	
	public void createPAInit(ILaunchConfiguration configuration){
		File initDSSFile=new File(initFile);
		if (initFile !=null){
			if (!initDSSFile.isAbsolute()){
				initFile=FileProcess.procRelativePath(initFile, configuration);
				initDSSFile=new File(initFile);
			}
			DebugCorePlugin.paInitFile=createPAInitFileName(initFile);
			if (initDSSFile !=null){
				File newInitDSSFile = new File(DebugCorePlugin.paInitFile);
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
	
	public void deletePAInit(){
		if (DebugCorePlugin.deletePAInit){
			final File paInit=new File(DebugCorePlugin.paInitFile);
			paInit.delete();
		}
	}
	
	public void createInitData(PAProcRun procRun){
		HecDss paInitDss;
		try {
			paInitDss=HecDss.open(DebugCorePlugin.paInitFile);
		} catch (Exception e) {
			WPPException.handleException(e);
			return;
		}
		Vector<String> paPathList = paInitDss.getPathnameList();
		for (int i=0; i<paPathList.size(); i++){
			String path = paPathList.get(i);
			try {
				TimeSeriesContainer dc = (TimeSeriesContainer)paInitDss.get(path);
				TimeSeriesMath tm = new TimeSeriesMath(dc);
				HecMath newTm = tm.shiftInTime(DebugCorePlugin.paStartInterval+"MON");
				paInitDss.write(newTm);
			} catch (Exception e) {
				WPPException.handleException(e);
			}
		}
		paInitDss.close();
	}

}
