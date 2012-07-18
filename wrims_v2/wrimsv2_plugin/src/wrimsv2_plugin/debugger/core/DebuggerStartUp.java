package wrimsv2_plugin.debugger.core;

import java.util.HashMap;

import org.eclipse.ui.IStartup;

import wrimsv2_plugin.debugger.menuitem.EnableRunMenu;

public class DebuggerStartUp implements IStartup {

	@Override
	public void earlyStartup() {
		enableRunMenu();
	}

	public void enableRunMenu(){
		HashMap<String, Boolean> enableMap=new HashMap<String, Boolean>();
		enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, false);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, false);
		new EnableRunMenu(enableMap);
	}
}
