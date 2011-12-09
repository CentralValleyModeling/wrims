package wrimsv2_plugin.debugger.menuitem;

import java.util.Date;

import org.eclipse.jface.action.AbstractAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;

public class NextCycleMenu implements IWorkbenchWindowActionDelegate {
	public NextCycleMenu(){
		
	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		if (DebugCorePlugin.debugCycle<DebugCorePlugin.totalNoOfCycle){
			DebugCorePlugin.debugSet.getComboCycle().setText(String.valueOf(DebugCorePlugin.debugCycle+1));
		}else{
			Date endDate= new Date(DebugCorePlugin.endYear-1900, DebugCorePlugin.endMonth-1, DebugCorePlugin.endDay);
			Date debugDate = new Date (DebugCorePlugin.debugYear-1900, DebugCorePlugin.debugMonth-1, DebugCorePlugin.debugDay);
			if (endDate.after(debugDate)){
				DebugCorePlugin.debugSet.getComboCycle().setText("1");
				DebugCorePlugin.debugSet.nextTimeStep();
			}
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
}
