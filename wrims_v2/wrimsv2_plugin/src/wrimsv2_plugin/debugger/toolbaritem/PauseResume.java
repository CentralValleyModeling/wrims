package wrimsv2_plugin.debugger.toolbaritem;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.dialog.WPPAddWatchDialog;
import wrimsv2_plugin.debugger.dialog.WPPReSimDialog;
import wrimsv2_plugin.debugger.dialog.WPPVarGoalSearchDialog;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.view.WPPAllGoalView;
import wrimsv2_plugin.debugger.view.WPPAllVariableView;
import wrimsv2_plugin.debugger.view.WPPVariableView;
import wrimsv2_plugin.tools.DataProcess;

public class PauseResume extends ActionDelegate implements IViewActionDelegate{
	IViewPart view;
	
	@Override
	public void init(IViewPart view) {
		this.view=view;		
	}

	public void run(IAction action) {
		try {
			if (DebugCorePlugin.isDebugging){
				if (DebugCorePlugin.target.isSuspended()){
					DebugCorePlugin.debugSet.updateDebugTimeSet();
					DebugCorePlugin.target.resume();
					enableRunMenu(1);
				}else{
					DebugCorePlugin.target.pause();
					enableRunMenu(3);
				}
			}
		} catch (DebugException e) {
			WPPException.handleException(e);
		}
	}
	
	public void enableRunMenu(int flag){
		HandlePauseResumeButton.procPauseResumeToolbarItem(flag);
		HashMap<String, Boolean> enableMap=new HashMap<String, Boolean>();
		if (flag==3){
			enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, true);
			enableMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
			enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
			enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, true);
			enableMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, true);
			enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
			enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
			enableMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, true);
			enableMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, true);	
		}else{
			enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, true);
			enableMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, true);
			enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, true);
			enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
			enableMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
			enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
			enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
			enableMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
			enableMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		}
		new EnableMenus(enableMap);
	}
}
