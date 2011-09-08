package wrims.schematic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Clay Booher (adapted Tom Pruett's SchematicOverview
 *
 */
public class MapOverviewPanel extends JPanel {

	private MapOverview _overview;

/*	public MapOverviewPanel() {
		super();
		_overview = new MapOverview();
	} */

/*	public MapOverviewPanel(SchematicDocument doc) {
		super();
		_overview = new MapOverview(doc);
	} */

	public MapOverviewPanel(SchematicDocument doc, MainFrame app, Image backgroundImage) {
		super();
		_overview = new MapOverview(doc, app, backgroundImage);
		initialize();
	}

	public void initialize() {
		JToolBar toolBar = initToolbar();
		JPanel barPanel = new JPanel();
		//CB			barPanel.setLayout(new BorderLayout());
		//CB			barPanel.add(toolBar, "West");
		barPanel.setLayout(new BoxLayout(barPanel, BoxLayout.Y_AXIS)); //CB
		barPanel.add(toolBar);

		setLayout(new BorderLayout());
		add(barPanel, BorderLayout.NORTH);
		add(_overview, BorderLayout.CENTER);
	}

	JToolBar initToolbar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(0);
		JButton button = null;
		button = toolBar.add(ZoomToFitAction);
		button.setToolTipText("Zoom To Fit");
		button = toolBar.add(ZoomNormalAction);
		button.setToolTipText("Zoom Normal");
		button = toolBar.add(ZoomInAction);
		button.setToolTipText("Zoom In");
		button = toolBar.add(ZoomOutAction);
		button.setToolTipText("Zoom Out");
		toolBar.addSeparator();
		return toolBar;
	}

	public MapOverview getView() {
		return _overview;
	}

	MapOverviewRelatedAction ZoomToFitAction = new MapOverviewRelatedAction("Zoom To Fit",
			MainFrame.createIconImage("images/ZoomToFit24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomToFit();
		}
	};

	MapOverviewRelatedAction ZoomNormalAction = new MapOverviewRelatedAction("Normal Zoom",
			MainFrame.createIconImage("images/ZoomNormal24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomNormal();
		}
	};

	MapOverviewRelatedAction ZoomInAction = new MapOverviewRelatedAction("Zoom In",
			MainFrame.createIconImage("images/ZoomIn24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomIn();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getScale() < 8.0f);
		}
	};

	MapOverviewRelatedAction ZoomOutAction = new MapOverviewRelatedAction("Zoom Out",
			MainFrame.createIconImage("images/ZoomOut24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			this.getView().zoomOut();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getScale() > 0.13f);   //CB TO DO:  decrease this number?
		}
	};
}
