package gov.ca.dwr.wrims.geoschematic;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.locationtech.udig.catalog.internal.ui.CatalogView;
import org.locationtech.udig.project.IMap;
import org.locationtech.udig.project.ui.ApplicationGIS;
import org.locationtech.udig.project.ui.internal.LayersView;
import org.locationtech.udig.project.ui.internal.MapEditor;
import org.locationtech.udig.tool.info.internal.InfoView2;

@SuppressWarnings("restriction")
public class GeoschematicPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
        layout.setEditorAreaVisible(true);
		String editorArea = layout.getEditorArea();
		layout.addView(MapView.ID, IPageLayout.RIGHT, 0.8f, IPageLayout.ID_EDITOR_AREA);
		try {
			IMap map = ApplicationGIS.getActiveMap();
			IEditorInput editorInput = ApplicationGIS.getInput(map);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, MapEditor.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		} 
		
        IFolderLayout leftFolder = layout.createFolder("gov.ca.dwr.wrims.geoschematic.GeoschematicPerspective.leftFolder", IPageLayout.LEFT, 0.25f, editorArea); //$NON-NLS-1$
        leftFolder.addView(LayersView.ID); 
        leftFolder.addView(IPageLayout.ID_PROJECT_EXPLORER); 

        IFolderLayout bottomFolder = layout.createFolder("gov.ca.dwr.wrims.geoschematic.GeoschematicPerspective.bottomFolder", IPageLayout.BOTTOM, 0.7f, editorArea); //$NON-NLS-1$
        bottomFolder.addView(InfoView2.VIEW_ID);
        bottomFolder.addPlaceholder(CatalogView.VIEW_ID);

        //layout.getViewLayout(MapView.ID).setCloseable(false);
        
	}
	
}
