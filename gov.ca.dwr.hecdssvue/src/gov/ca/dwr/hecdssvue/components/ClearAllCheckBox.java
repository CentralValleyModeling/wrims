package gov.ca.dwr.hecdssvue.components;

import gov.ca.dwr.hecdssvue.views.DeliveryShortagesView;
import gov.ca.dwr.hecdssvue.views.SanJoaquinRiverView;
import gov.ca.dwr.hecdssvue.views.StorageFlowsView;
import gov.ca.dwr.hecdssvue.views.WaterManagementActionsView;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.exception.WPPException;

public class ClearAllCheckBox {

	public ClearAllCheckBox(){
		try {
			final IWorkbench workbench=PlatformUI.getWorkbench();
			workbench.getDisplay().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
					StorageFlowsView storageFlowsView = (StorageFlowsView) workBenchPage.findView(StorageFlowsView.ID);
					storageFlowsView.clearAll();
					SanJoaquinRiverView sanJoaquinRiverView = (SanJoaquinRiverView)workBenchPage.findView(SanJoaquinRiverView.ID);
					sanJoaquinRiverView.clearAll();
					WaterManagementActionsView waterManagementActionsView = (WaterManagementActionsView)workBenchPage.findView(WaterManagementActionsView.ID);
					waterManagementActionsView.clearAll();
					DeliveryShortagesView deliveryShortagesView = (DeliveryShortagesView)workBenchPage.findView(DeliveryShortagesView.ID);
					deliveryShortagesView.clearAll();
				}
			});
		} catch (Exception e) {
			WPPException.handleException(e);
		}
	}
}
