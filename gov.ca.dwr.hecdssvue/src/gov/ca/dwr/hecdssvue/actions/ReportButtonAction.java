package gov.ca.dwr.hecdssvue.actions;

import gov.ca.dwr.hecdssvue.PluginCore;
import gov.ca.dwr.hecdssvue.views.DSSMonthlyView;
import gov.ca.dwr.hecdssvue.views.DSSPlotView;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import gov.ca.dwr.hecdssvue.views.DeliveryShortagesView;
import gov.ca.dwr.hecdssvue.views.SanJoaquinRiverView;
import gov.ca.dwr.hecdssvue.views.StorageFlowsView;
import gov.ca.dwr.hecdssvue.views.WaterManagementActionsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.exception.WPPException;



public class ReportButtonAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		String bn=b.getName();
		
		if (bn.equalsIgnoreCase("btnpClear") || bn.equalsIgnoreCase("btnpClear_SJR") || bn.equalsIgnoreCase("btnpClear_shortage")){
			PluginCore.selectedCheckBox=new ArrayList<String>();
			clearAllCheckBox();
		}
	}

	private void clearAllCheckBox(){
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
