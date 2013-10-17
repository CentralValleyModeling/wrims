package wrimsv2_plugin.debugger.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.toolbaritem.EnableButtons;
import wrimsv2_plugin.debugger.toolbaritem.HandlePauseResumeButton;
import wrimsv2_plugin.debugger.view.UpdateView;
import wrimsv2_plugin.debugger.view.WPPWatchView;
import wrimsv2_plugin.tools.DataProcess;
import wrimsv2_plugin.tools.ProcWatchItem;
import wrimsv2_plugin.tools.ShowDuplicatedWatch;

public class DebuggerStartUp implements IStartup {

	@Override
	public void earlyStartup() {
		enableRunMenu();
		initialWatchViewer();
		initialStudyData();
		DataProcess.initialVariableValueAlt();
	}

	public void enableRunMenu(){
		HashMap<String, Boolean> enableMenuMap=new HashMap<String, Boolean>();
		enableMenuMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_CONDITIONALBREAKPOINT, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_CLEARCONDITIONALBREAKPOINT, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMenuMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(0);
		HashMap<String, Boolean> enableButtonMap=new HashMap<String, Boolean>();
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLEBUTTON, false);
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEPBUTTON, false);
		new EnableButtons(enableButtonMap);
	}
	
	public void initialWatchViewer(){
		ArrayList<String> watchItems= ProcWatchItem.getLastWatchItems();
		DebugCorePlugin.watchItems = watchItems;
		int size = watchItems.size();
		for (int i=0; i<size; i++){
			final String varGoalName=watchItems.get(i);
			final IWorkbench workbench=PlatformUI.getWorkbench();
			workbench.getDisplay().asyncExec(new Runnable(){
				public void run(){
					WPPWatchView watchView = (WPPWatchView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_WATCH_VIEW);
					watchView.addWatched(varGoalName);
				}
			});
		}
	}
	
	public void initialStudyData(){
		Map<String, String>[] studiesData = DebugCorePlugin.studiesData;
		for (int i=0; i<4; i++){
			studiesData[i]=new HashMap<String, String>();
		}
	}
}
