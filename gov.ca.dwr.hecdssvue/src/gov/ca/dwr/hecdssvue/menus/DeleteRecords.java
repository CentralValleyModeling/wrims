package gov.ca.dwr.hecdssvue.menus;

import java.util.Vector;

import gov.ca.dwr.hecdssvue.PluginCore;
import gov.ca.dwr.hecdssvue.views.DSSCatalogView;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import hec.dataTable.HecDataTable;
import hec.dssgui.DataReferenceSet;
import hec.heclib.dss.HecDss;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;

public class DeleteRecords implements IWorkbenchWindowActionDelegate{

	@Override
	public void run(IAction action) {
		IWorkbench workbench=PlatformUI.getWorkbench();
		IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
		DSSCatalogView dssCatalogView=(DSSCatalogView) workBenchPage.findView(PluginCore.ID_DSSVue_DSSCatalogView);
		boolean[] foundInDv={false, false, false, false};
		
		if (dssCatalogView !=null){
			Vector<String[]> selectedParts=dssCatalogView.getSelectedParts();
			for (int i=0; i<3; i++){
				if (DebugCorePlugin.selectedStudies[i]){
					HecDss dvFile = DebugCorePlugin.dvDss[i];
					if (dvFile !=null){
						Vector dvPathNameList = dvFile.getPathnameList();
						for (int j=0; j<selectedParts.size(); j++){
							Vector<String> selectedPathname = new Vector<String>();
							String[] parts=selectedParts.get(j);
							for (int k=0; k<dvPathNameList.size(); k++){
								String pathname=(String)dvPathNameList.get(k);
								if (containParts(pathname, parts)){
									selectedPathname.add(pathname);
									foundInDv[i]=true;
								}
							}
							dvFile.delete(selectedPathname);
						}
					}
					HecDss svFile = DebugCorePlugin.svDss[i];
					if (!foundInDv[i] && svFile !=null){
						Vector svPathNameList = svFile.getPathnameList();
						for (int j=0; j<selectedParts.size(); j++){	
							Vector<String> selectedPathname = new Vector<String>();
							String[] parts=selectedParts.get(j);
							for (int k=0; k<svPathNameList.size(); k++){
								String pathname=(String)svPathNameList.get(k);
								if (containParts(pathname, parts)){
									selectedPathname.add(pathname);
								}
							}
							svFile.delete(selectedPathname);
						}
					}
				}
			}
		}
		TableViewer viewer = dssCatalogView.getViewer();
		viewer.setInput(viewer.getInput());
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
	
	public boolean containParts(String pathName, String[] parts){
		String start="/";
		String end="/";
		for (int i=1; i<4; i++){
			start=start+parts[i]+"/";
		}
		for (int i=5; i<7; i++){
			end=end+parts[i]+"/";
		}
		if (pathName.startsWith(start) && pathName.endsWith(end)){
			return true;
		}else{
			return false;
		}
	}
}
