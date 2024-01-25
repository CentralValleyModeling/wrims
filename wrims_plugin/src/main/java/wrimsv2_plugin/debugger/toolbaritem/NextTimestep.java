package wrimsv2_plugin.debugger.toolbaritem;

import java.util.HashMap;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.actions.ActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;

public class NextTimestep extends ActionDelegate implements IViewActionDelegate{
	IViewPart view;
	
	@Override
	public void init(IViewPart view) {
		this.view=view;		
	}

	public void run(IAction action) {
		DebugCorePlugin.debugSet.nextTimeStep();
		try {
			if (DebugCorePlugin.isDebugging && DebugCorePlugin.target.isSuspended()) {
				DebugCorePlugin.target.resume();
				enableRunMenuWithResume();
			}else if (!DebugCorePlugin.isDebugging) {
				enableRunMenuNoDebugging();
			}else{
				enableRunMenuNoResume();
			}
		} catch (DebugException e) {
			WPPException.handleException(e);
		}
	}
	
	public void enableRunMenuWithResume(){
		HashMap<String, Boolean> enableMenuMap=new HashMap<String, Boolean>();
		enableMenuMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMenuMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(1);
		HashMap<String, Boolean> enableButtonMap=new HashMap<String, Boolean>();
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLEBUTTON, true);
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEPBUTTON, true);
		new EnableButtons(enableButtonMap);
	}
	
	public void enableRunMenuNoDebugging(){
		HashMap<String, Boolean> enableMenuMap=new HashMap<String, Boolean>();
		enableMenuMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMenuMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(0);
		HashMap<String, Boolean> enableButtonMap=new HashMap<String, Boolean>();
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLEBUTTON, false);
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEPBUTTON, false);
		new EnableButtons(enableButtonMap);
	}
	
	public void enableRunMenuNoResume(){
		HashMap<String, Boolean> enableMenuMap=new HashMap<String, Boolean>();
		enableMenuMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMenuMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(1);
		HashMap<String, Boolean> enableButtonMap=new HashMap<String, Boolean>();
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLEBUTTON, true);
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEPBUTTON, true);
		new EnableButtons(enableButtonMap);
	}
}
