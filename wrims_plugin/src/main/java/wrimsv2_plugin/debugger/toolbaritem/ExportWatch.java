package wrimsv2_plugin.debugger.toolbaritem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.eclipse.jface.action.IAction;
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

public class ExportWatch extends ActionDelegate implements IViewActionDelegate{
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
				FileDialog dlg =new FileDialog(shell,SWT.SAVE);
				String fn=dlg.open();
				if (fn !=null){
					Path from = (new File(DebugCorePlugin.dataDir, DebugCorePlugin.watchFile)).toPath();
					File toFile = new File(fn);
					Path to = toFile.toPath(); 
					try {
						Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						WPPException.handleException(e);
					}
				}
			}
		});
	}
}
