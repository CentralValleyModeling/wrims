package wrimsv2_plugin.calsimhydro;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

import wrimsv2_plugin.debugger.exception.WPPException;

public class DefaultCalSimHydro {

	public void load(){
		loadStudy();
	}
	
	public void loadStudy(){
		File f = new File("CalSimHydroDefault\\.project");
		IProjectDescription description;
		try {
			description = ResourcesPlugin
					   .getWorkspace().loadProjectDescription(new Path(f.getAbsolutePath()));
			IProject project = ResourcesPlugin.getWorkspace()
		 			   .getRoot().getProject(description.getName());
			if (!project.isOpen()){
				project.create(description, null);
				project.open(null);
			}
		} catch (CoreException e) {
			WPPException.handleException(e);
		}
		
	}
	
}
