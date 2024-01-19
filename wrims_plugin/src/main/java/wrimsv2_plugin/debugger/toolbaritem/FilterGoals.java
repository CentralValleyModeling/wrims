package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import wrimsv2_plugin.debugger.dialog.WPPFilterGoalsDialog;

public class FilterGoals extends ActionDelegate implements IViewActionDelegate{

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		
	}

	public void run(IAction action) {
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				Shell shell=workbench.getActiveWorkbenchWindow().getShell();
				WPPFilterGoalsDialog dialog= new WPPFilterGoalsDialog(shell);
				dialog.openDialog();
			}
		});
	}
}
