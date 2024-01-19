package wrimsv2_plugin.debugger.toolbaritem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPWatchView;

public class ImportWatch extends ActionDelegate implements IViewActionDelegate{
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
				FileDialog dlg =new FileDialog(shell,SWT.OPEN);
				String fn=dlg.open();
				if (fn !=null){
					File fromFile = new File(fn);
					if (fromFile.exists()){
						Path from = fromFile.toPath(); 
						Path to = (new File(DebugCorePlugin.dataDir, DebugCorePlugin.watchFile)).toPath(); 
						try {
							Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
							WPPWatchView watchView = (WPPWatchView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_WATCH_VIEW);
							watchView.setInitialWatchVariables(((TableViewer)watchView.getViewer()).getTable());
						} catch (IOException e) {
							WPPException.handleException(e);
						}
					}
				}
			}
		});
	}
}
