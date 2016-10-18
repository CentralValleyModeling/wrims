package gov.ca.dwr.hecdssvue.components;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import gov.ca.dwr.hecdssvue.views.DSSCatalogView;

public class Focus {

	public static void setFocus(DSSCatalogView catalogView, IWorkbenchPage workBenchPage){
		if (workBenchPage.isPartVisible(catalogView)){
			catalogView.setFocus();
		}else{
			IWorkbenchPart part = workBenchPage.getActivePart();
			workBenchPage.activate(catalogView);
			catalogView.setFocus();
			workBenchPage.activate(part);
		}
	}
	
}
