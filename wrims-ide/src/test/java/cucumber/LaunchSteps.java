package cucumber;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import wrimsv2_plugin.debugger.launcher.WPPLaunchShortcut;
import io.cucumber.java.en.Then;

public class LaunchSteps {
	
	public String filePath="";
	public String mode="";
	
	/*
	@When("the user is on the IDE perspective")
	public void userIsONIDEPerspective() {
		
	}
	*/
	
	@Given("Select launch file {string} and mode {string}")
	public void selectLaunchFile(String filePath, String mode) {
		this.filePath=filePath;
		this.mode=mode;
	}

	@When("Run the launch shortcut")
	public void runLaunchShortcut() {
		ISelection selection = new StructuredSelection(filePath);
		WPPLaunchShortcut ls=new WPPLaunchShortcut();
		ls.launch(selection, mode); 
	}
}
