package gov.ca.gwr.wrims.geoschematic;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.locationtech.udig.catalog.internal.ui.CatalogView;
import org.locationtech.udig.project.ui.internal.LayersView;
import org.locationtech.udig.tool.info.internal.InfoView2;

@SuppressWarnings("restriction")
public class GeoschematicPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);

        layout.addView(MapView.ID, IPageLayout.LEFT, 0.8f, IPageLayout.ID_EDITOR_AREA);

        IFolderLayout leftFolder = layout.createFolder("gov.ca.gwr.wrims.geoschematic.GeoschematicPerspective.leftFolder", IPageLayout.LEFT, 0.2f, MapView.ID); //$NON-NLS-1$
        leftFolder.addView(LayersView.ID); 

        IFolderLayout bottomFolder = layout.createFolder("gov.ca.gwr.wrims.geoschematic.GeoschematicPerspective.bottomFolder", IPageLayout.BOTTOM, 0.7f, MapView.ID); //$NON-NLS-1$
        bottomFolder.addView(InfoView2.VIEW_ID);
        bottomFolder.addPlaceholder(CatalogView.VIEW_ID);

        layout.getViewLayout(MapView.ID).setCloseable(false);	
	}
	
}
