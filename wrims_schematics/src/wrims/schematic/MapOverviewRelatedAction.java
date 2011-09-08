package wrims.schematic;

import java.awt.Container;
import javax.swing.Icon;

//
// depending on the current context.
/**
 * Define an Action that knows about views and supports enabling/disabling depending on the
 * current context.
 * @author Clay Booher
 */
public abstract class MapOverviewRelatedAction extends ContainerRelatedAction {

	public MapOverview getView() {
		if (getApp() != null && getApp() instanceof MapOverviewPanel) {
			return ((MapOverviewPanel)getApp()).getView();
		} else return null;
	}

	public Plotter getPlotter() {
		if (getApp() != null && getApp() instanceof MainFrame) {
			return ((MainFrame)getApp()).getPlotter();
		} else return null;
	}

	public MapOverviewRelatedAction(String name, Container app) {
		super(name, app);
	}

	public MapOverviewRelatedAction(String name, Icon icon, Container app) {
		super(name, icon, app);
	}

	public boolean canAct() {
		return (getView() != null);
	}
}
