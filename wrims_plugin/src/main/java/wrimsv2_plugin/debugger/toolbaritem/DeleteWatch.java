package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.view.WPPWatchView;

public class DeleteWatch extends ActionDelegate implements IViewActionDelegate{
	IViewPart view;
	
	@Override
	public void init(IViewPart view) {
		this.view=view;		
	}

	public void run(IAction action) {
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				WPPWatchView watchView = (WPPWatchView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_WATCH_VIEW);
				watchView.deleteWatched();
			}
		});
	}
}
