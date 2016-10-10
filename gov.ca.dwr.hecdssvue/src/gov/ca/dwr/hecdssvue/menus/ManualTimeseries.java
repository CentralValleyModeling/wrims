package gov.ca.dwr.hecdssvue.menus;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gov.ca.dwr.hecdssvue.DssPluginCore;
import gov.ca.dwr.hecdssvue.components.CatalogListSelection;
import gov.ca.dwr.hecdssvue.components.DssMathFrame;
import gov.ca.dwr.hecdssvue.views.DSSCatalogView;
import gov.ca.dwr.hecdssvue.views.DSSPlotView;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import hec.dataTable.HecDataTable;
import hec.dssgui.CombinedDataManager;
import hec.dssgui.ListSelection;
import hec.dssgui.MathFrame2;
import hec.dssgui.NewPartsDialog;
import hec.dssgui.TimeSeriesDataEntry;
import hec.heclib.dss.HecDss;
import hec.io.DataContainer;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;

public class ManualTimeseries implements IWorkbenchWindowActionDelegate{

	private Vector<String> oldPathnameVector=new Vector<String>();
	private Vector<String> newPathnameVector=new Vector<String>();		
	
	@Override
	public void run(IAction action) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CatalogListSelection ls = new CatalogListSelection();
				for (int i=0; i<3; i++){
					if (DebugCorePlugin.selectedStudies[i]){
						CombinedDataManager dm = new CombinedDataManager(false);
						HecDss svFile = DebugCorePlugin.svDss[i];
						if (svFile !=null){
							dm = svFile.getDataManager();
						}else {
							HecDss dvFile = DebugCorePlugin.dvDss[i];
							if (dvFile != null ){
								dm = dvFile.getDataManager();
							}
						}
						TimeSeriesDataEntry dataEntry = new TimeSeriesDataEntry(ls, dm);
						dataEntry.addWindowListener(new WindowAdapter() {            

							@Override
					        public void windowClosed(WindowEvent e) {
								/*
					        	final IWorkbench workbench=PlatformUI.getWorkbench();
					    		workbench.getDisplay().asyncExec(new Runnable(){
					    			public void run(){
					    				IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
										DSSCatalogView dssCatalogView=(DSSCatalogView) workBenchPage.findView(PluginCore.ID_DSSVue_DSSCatalogView);
										TableViewer viewer = dssCatalogView.getViewer();
										viewer.setInput(viewer.getInput()); 
					    			}
					    		});
					    		*/
					    		
					        }
							
							@Override
					        public void windowClosing(WindowEvent e) {
								
					        	final IWorkbench workbench=PlatformUI.getWorkbench();
					    		workbench.getDisplay().syncExec(new Runnable(){
					    			public void run(){
					    				IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
										DSSCatalogView dssCatalogView=(DSSCatalogView) workBenchPage.findView(DssPluginCore.ID_DSSVue_DSSCatalogView);
										TableViewer viewer = dssCatalogView.getViewer();
										viewer.setInput(viewer.getInput()); 
					    			}
					    		});
					    		
					        }
					    }); 
				
						dataEntry.show();
						
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
