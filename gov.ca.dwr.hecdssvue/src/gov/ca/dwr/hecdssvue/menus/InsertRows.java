package gov.ca.dwr.hecdssvue.menus;

import javax.swing.SwingWorker;

import gov.ca.dwr.hecdssvue.DssPluginCore;
import gov.ca.dwr.hecdssvue.components.Focus;
import gov.ca.dwr.hecdssvue.views.DSSCatalogView;
import gov.ca.dwr.hecdssvue.views.DSSMonthlyView;
import gov.ca.dwr.hecdssvue.views.DSSPlotView;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import hec.dataTable.HecDataTable;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;

public class InsertRows implements IWorkbenchWindowActionDelegate{

	@Override
	public void run(IAction action) {
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
				DSSTableView dssTableView=(DSSTableView) workBenchPage.findView(DssPluginCore.ID_DSSVue_DSSTableView);
				DSSCatalogView catalogView=(DSSCatalogView)workBenchPage.findView(DssPluginCore.ID_DSSVue_DSSCatalogView);
				Focus.setFocus(catalogView, workBenchPage);
												
				if (dssTableView !=null){
					final HecDataTable table = dssTableView.getTable();
					if (DssPluginCore.dssEditable){
				
						javax.swing.SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								table.insertRow();
							}
						});
			    			
					}
				}
			}
		});
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
