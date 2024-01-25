package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.view.WPPWatchView;

public class DeleteAllWatch extends ActionDelegate implements IViewActionDelegate{
	IViewPart view;
	
	@Override
	public void init(IViewPart view) {
		this.view=view;		
	}

	public void run(IAction action) {
		
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				Shell shell=workbench.getActiveWorkbenchWindow().getShell();
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION|SWT.OK|SWT.CANCEL);
				messageBox.setText("Delete All Watched");
				messageBox.setMessage("Are you sure to delete all watched items?");
				int val=messageBox.open();
				switch (val){
					case SWT.OK:
						WPPWatchView watchView = (WPPWatchView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_WATCH_VIEW);
						watchView.deleteAllWatched();
						break;
					case SWT.CANCEL:
						break;
				}
			}
		});
		
		
	}
}
