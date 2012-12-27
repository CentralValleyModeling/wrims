package wrimsv2_plugin.debugger.menuitem;

import java.util.Date;
import java.util.HashMap;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.AbstractAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.toolbaritem.HandlePauseResumeButton;

public class NextCycleMenu implements IWorkbenchWindowActionDelegate {
	public NextCycleMenu(){

	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		if (DebugCorePlugin.debugCycle<DebugCorePlugin.totalNoOfCycle){
			DebugCorePlugin.debugSet.getComboCycle().setText(String.valueOf(DebugCorePlugin.debugCycle+1));
			DebugCorePlugin.debugSet.updateDebugTimeSet();
		}else{
			Date endDate= new Date(DebugCorePlugin.endYear-1900, DebugCorePlugin.endMonth-1, DebugCorePlugin.endDay);
			Date debugDate = new Date (DebugCorePlugin.debugYear-1900, DebugCorePlugin.debugMonth-1, DebugCorePlugin.debugDay);
			if (endDate.after(debugDate)){
				DebugCorePlugin.debugSet.getComboCycle().setText("1");
				DebugCorePlugin.debugSet.nextTimeStep();
			}
		}
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

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		
	}
	
	public void enableRunMenuWithResume(){
		HashMap<String, Boolean> enableMap=new HashMap<String, Boolean>();
		enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(1);
	}
	
	public void enableRunMenuNoDebugging(){
		HashMap<String, Boolean> enableMap=new HashMap<String, Boolean>();
		enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, false);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(0);
	}
	
	public void enableRunMenuNoResume(){
		HashMap<String, Boolean> enableMap=new HashMap<String, Boolean>();
		enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(0);
	}
}
