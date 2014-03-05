package gov.ca.dwr.hecdssvue.menus;

import gov.ca.dwr.hecdssvue.PluginCore;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import hec.dataTable.HecDataTable;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;

public class InsertRows implements IWorkbenchWindowActionDelegate{

	@Override
	public void run(IAction action) {
		IWorkbench workbench=PlatformUI.getWorkbench();
		IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
		DSSTableView dssTableView=(DSSTableView) workBenchPage.findView(PluginCore.ID_DSSVue_DSSTableView);
		
		if (dssTableView !=null){
			final HecDataTable table = dssTableView.getTable();
			if (PluginCore.dssEditable){
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
			        public void run() {
						table.insertRow();
			        }
			    });
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
