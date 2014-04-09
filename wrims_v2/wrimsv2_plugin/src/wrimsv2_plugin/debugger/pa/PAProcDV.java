package wrimsv2_plugin.debugger.pa;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.FileProcess;

public class PAProcDV {

	private String dvFile="";
	
	public PAProcDV(ILaunchConfiguration configuration){
		try {
			dvFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_DVARFILE, (String)null);
		} catch (CoreException e) {
			WPPException.handleException(e);
		}
	}
	
	public void deleteDVFile(ILaunchConfiguration configuration){
		try {
			File dvDSSFile=new File(dvFile);
			if (dvFile !=null){
				if (!dvDSSFile.isAbsolute()){
					dvFile=FileProcess.procRelativePath(dvFile, configuration);
					dvDSSFile=new File(dvFile);
				}
				if (dvDSSFile.exists() && dvDSSFile !=null){
					dvDSSFile.delete();
				}
			}
		} catch (Exception e) {
			WPPException.handleException(e);
		}
	}
	
}
