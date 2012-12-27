package wrimsv2_plugin.debugger.menuitem;

import java.util.HashMap;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.toolbaritem.HandlePauseResumeButton;

public class SuspendMenu implements IWorkbenchWindowActionDelegate {
	public SuspendMenu(){

	}

	@Override
	public void run(IAction action) {
		try {
			if (DebugCorePlugin.isDebugging){
				DebugCorePlugin.target.suspend();
				enableRunMenu();
			}
		} catch (DebugException e) {
			WPPException.handleException(e);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		
	}
	
	public void enableRunMenu(){
		HashMap<String, Boolean> enableMap=new HashMap<String, Boolean>();
		enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(3);
	}
}
