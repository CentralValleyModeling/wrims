package wrims.schematic.jdiagram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D.Float;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

import com.mindfusion.diagramming.AutoResize;
import com.mindfusion.diagramming.Behavior;
import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramAdapter;
import com.mindfusion.diagramming.DiagramEvent;
import com.mindfusion.diagramming.DiagramItem;
import com.mindfusion.diagramming.DiagramLink;
import com.mindfusion.diagramming.DiagramLinkList;
import com.mindfusion.diagramming.DiagramNode;
import com.mindfusion.diagramming.DiagramNodeList;
import com.mindfusion.diagramming.DiagramView;
import com.mindfusion.diagramming.DummyNode;
import com.mindfusion.diagramming.GridStyle;
import com.mindfusion.diagramming.HandlesStyle;
import com.mindfusion.diagramming.LinkEvent;
import com.mindfusion.diagramming.NodeEvent;
import com.mindfusion.diagramming.Orientation;
import com.mindfusion.diagramming.PointList;
import com.mindfusion.diagramming.RerouteLinks;
import com.mindfusion.diagramming.RoutingOptions;
import com.mindfusion.diagramming.ShapeNode;
import com.mindfusion.diagramming.UndoManager;
import com.mindfusion.diagramming.XmlException;

/**
 * View schematic
 * 
 * @author psandhu
 * 
 */
public class SchematicEditor extends SchematicViewer {
	JPopupMenu popupMenu;
	JPopupMenu pastePopupMenu;
	JMenuItem deleteMenuItem;
	JMenuItem copyMenuItem;
	private JMenuItem pasteMenuItem;
	private AbstractAction undoAction;
	private AbstractAction redoAction;
	private AbstractAction copyAction;
	private AbstractAction pasteAction;
	private JMenuItem shortenPointsMenuItem;

	public SchematicEditor() {
		super();
		getDiagramView().setBehavior(Behavior.Modify);
		getDiagramView().setAllowInplaceEdit(true);

		Icon undoIcon = ImageUtil.createImageIcon("images/undo.png");
		Icon redoIcon = ImageUtil.createImageIcon("images/redo.png");
		Icon copyIcon = ImageUtil.createImageIcon("images/copy.png");
		Icon pasteIcon = ImageUtil.createImageIcon("images/paste.png");

		undoAction = new AbstractAction("Undo", undoIcon) {

			@Override
			public void actionPerformed(ActionEvent e) {
				getDiagram().getUndoManager().undo();
			}
		};

		redoAction = new AbstractAction("Redo", redoIcon) {

			@Override
			public void actionPerformed(ActionEvent e) {
				getDiagram().getUndoManager().redo();
			}
		};

		copyAction = new AbstractAction("Copy", copyIcon) {

			@Override
			public void actionPerformed(ActionEvent evt) {
				onCopy();
			}
		};
		// copyAction.putValue(Action.ACCELERATOR_KEY,
		// KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));

		pasteAction = new AbstractAction("Paste", pasteIcon) {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				onPaste();
			}
		};
		// pasteAction.putValue(Action.ACCELERATOR_KEY,
		// KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		getDiagramView().getInputMap().put(KeyStroke.getKeyStroke("Control C"),
				copyAction);
		getDiagramView().getInputMap().put(KeyStroke.getKeyStroke("Control V"),
				pasteAction);
		getDiagramView().getInputMap().put(KeyStroke.getKeyStroke("Control Z"),
				undoAction);

		deleteMenuItem = new JMenuItem();
		deleteMenuItem.setName("_menuItemDelete");
		deleteMenuItem.setText("Delete");
		deleteMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onDelete();
			}
		});

		copyMenuItem = new JMenuItem(copyAction);

		pasteMenuItem = new JMenuItem(pasteAction);

		shortenPointsMenuItem = new JMenuItem("Delete Intermediate Points");
		shortenPointsMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (clickedItem != null && clickedItem instanceof DiagramLink) {
					onShortenPoints((DiagramLink) clickedItem);
				}
			}

		});

		getDiagram().removeDiagramListener(listener);
		getDiagram().addDiagramListener(new DiagramAdapter() {
			public void nodeSelected(NodeEvent e) {
				// getDiagram().alignPointToGrid(point);
				e.getNode().setHandlesStyle(HandlesStyle.EasyMove);
			}

			public void linkSelected(LinkEvent e) {
				e.getLink().setSnapToNodeBorder(true);
			}

			public void nodeClicked(NodeEvent e) {
				if (e.getNode() instanceof ShapeNode) {
					boxClicked(e);
				}
			}

			public void linkClicked(LinkEvent e) {
				arrowClicked(e);
			}

			public void clicked(DiagramEvent e) {
				diagramClicked(e);
			}

		});

		pastePopupMenu = new JPopupMenu("Paste Popup");
		pastePopupMenu.setName("pastePopup");
		pastePopupMenu.add(pasteMenuItem);

		popupMenu = new JPopupMenu("Edit Popup");
		popupMenu.setName("editPopup");
		popupMenu.add(copyMenuItem);
		popupMenu.add(deleteMenuItem);
		popupMenu.add(shortenPointsMenuItem);

	}

	public void onShortenPoints(DiagramLink link) {
		try {
			PointList controlPoints = link.getControlPoints();
			controlPoints.removeRange(1, Math
					.max(1, link.getSegmentCount() - 1));
			// link.updateFromPoints(false, true);
			link.updateFromPoints();
			// link.route();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void alignSelectedLinks(int direction) {
		for (DiagramLink link : getDiagram().getSelection().getLinks()) {
			alignLinkPoints(link, direction);
		}
		getDiagram().repaint();
	}

	public void alignLinkPoints(DiagramLink link, int direction) {
		PointList controlPoints = link.getControlPoints();
		if (link.getOrigin() instanceof DummyNode
				|| link.getDestination() instanceof DummyNode) {
			System.out.println("Link: " + link
					+ " is missing origin or destination connections");
			return;
		}
		if (direction == Orientation.Vertical) {
			controlPoints.get(0).x = (float) link.getOrigin().getBounds()
					.getCenterX();
			controlPoints.get(controlPoints.size() - 1).x = (float) link
					.getDestination().getBounds().getCenterX();
		} else if (direction == Orientation.Horizontal) {
			controlPoints.get(0).y = (float) link.getOrigin().getBounds()
					.getCenterY();
			controlPoints.get(controlPoints.size() - 1).y = (float) link
					.getDestination().getBounds().getCenterY();
		}

		Point2D.Float alignPoint = controlPoints.get(0);
		Point2D.Float endAlignPoint = controlPoints
				.get(controlPoints.size() - 1);
		int size = controlPoints.size();
		float stepX = 1, stepY = 1;
		if (size > 1) {
			stepX = (endAlignPoint.x - alignPoint.x) / (size - 1);
			stepY = (endAlignPoint.y - alignPoint.y) / (size - 1);
		}
		int index = 0;
		for (Point2D.Float p : controlPoints) {
			if (index == size - 1)
				break; // don't do the end points
			if (direction == Orientation.Vertical) {
				p.x = alignPoint.x;
				p.y = alignPoint.y + index * stepY;
			} else if (direction == Orientation.Horizontal) {
				p.y = alignPoint.y;
				p.x = alignPoint.x + index * stepX;
			}
			index++;
		}

		try {
			link.updateFromPoints(false, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean spaceNodesEvenly = false;

	public void alignSelectedNodes(final int orientation) {
		Diagram diagram = getDiagram();
		DiagramNodeList nodes = diagram.getSelection().getNodes();
		ArrayList<DiagramNode> sortedNodes = new ArrayList<DiagramNode>();
		sortedNodes.addAll(nodes);
		Collections.sort(sortedNodes, new Comparator<DiagramNode>() {

			@Override
			public int compare(DiagramNode arg0, DiagramNode arg1) {
				if (orientation == Orientation.Horizontal) {
					return (int) Math.signum(arg0.getBounds().x - arg1.getBounds().x);
				} else if (orientation == Orientation.Vertical) {
					return (int) Math.signum(arg0.getBounds().y - arg1.getBounds().y);
				} else {
					return 0;
				}
			}

		});
		if (nodes.size() == 0) {
			return;
		}
		DiagramNode alignNode = sortedNodes.get(0);
		Float bounds0 = alignNode.getBounds();
		double centerX = bounds0.getCenterX();
		double centerY = bounds0.getCenterY();
		DiagramNode endAlignNode = sortedNodes.get(sortedNodes.size()-1);
		Float bounds1 = endAlignNode.getBounds();
		int size = nodes.size();
		float spaceX = 1, spaceY = 1;
		if (size > 1) {
			spaceX = (bounds1.x - bounds0.x) / (size - 1);
			spaceY = (bounds1.y - bounds0.y) / (size - 1);
		}
		int index = 0;
		for (DiagramNode n : sortedNodes) {
			Float bounds = n.getBounds();
			if (orientation == Orientation.Vertical) {
				double delX = bounds.getCenterX() - centerX;
				bounds.x = bounds.x - (float) delX;
				if (spaceNodesEvenly) {
					bounds.y = bounds0.y + index * spaceY;
				}
			} else if (orientation == Orientation.Horizontal) {
				double delY = bounds.getCenterY() - centerY;
				bounds.y = bounds.y - (float) delY;
				if (spaceNodesEvenly) {
					bounds.x = bounds0.x + index * spaceX;
				}
			}
			n.moveTo(Math.round(bounds.x/diagram.getGridSizeX())*diagram.getGridSizeX(), Math.round(bounds.y/diagram.getGridSizeY())*diagram.getGridSizeY());
			index++;
		}
		diagram.repaint();
	}

	private DiagramNode getRightBottomMostNode(DiagramNodeList nodes,
			int orientation) {
		DiagramNode alignNode = null;
		for (DiagramNode n : nodes) {
			if (alignNode == null) {
				alignNode = n;
				continue;
			}
			if (orientation == Orientation.Vertical) {
				if (n.getBounds().y > alignNode.getBounds().y) {
					alignNode = n;
				}
			} else if (orientation == Orientation.Horizontal) {
				if (n.getBounds().x > alignNode.getBounds().x) {
					alignNode = n;
				}
			}
		}
		return alignNode;
	}

	private DiagramNode getLeftUpperMostNode(DiagramNodeList nodes,
			int orientation) {
		DiagramNode alignNode = null;
		for (DiagramNode n : nodes) {
			if (alignNode == null) {
				alignNode = n;
				continue;
			}
			if (orientation == Orientation.Vertical) {
				if (n.getBounds().y < alignNode.getBounds().y) {
					alignNode = n;
				}
			} else if (orientation == Orientation.Horizontal) {
				if (n.getBounds().x < alignNode.getBounds().x) {
					alignNode = n;
				}
			}
		}
		return alignNode;
	}

	public JPanel createFindPanel() {
		final JTextField findTextField = new JTextField();
		findTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					SchematicEditor.this.findInView(findTextField.getText());

				}
			}
		});
		JButton findButton = new JButton("Find");
		findButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SchematicEditor.this.findInView(findTextField.getText());
			}
		});
		JPanel findPanel = new JPanel();
		findPanel.setLayout(new BorderLayout());
		findPanel.add(findButton, "East");
		findPanel.add(findTextField);
		return findPanel;
	}

	public Action getUndoAction() {
		return undoAction;
	}

	public Action getRedoAction() {
		return redoAction;
	}

	public void onDelete() {
		Diagram d = getDiagram();
		if (!(d.getSelection().getNodes().isEmpty())) {
			for (DiagramNode n : d.getSelection().getNodes()) {
				n.setLocked(false);
			}
			d.getNodes().removeAll(d.getSelection().getNodes());
		}
		if (!(d.getSelection().getLinks().isEmpty())) {
			for (DiagramLink l : d.getSelection().getLinks()) {
				l.setLocked(false);
			}
			d.getLinks().removeAll(d.getSelection().getLinks());
		}

	}

	private ArrayList<DiagramItem> copiedItems;
	private Point2D lastMouseClickedPosition;
	private DiagramItem clickedItem;

	public void onCopy() {
		Diagram d = getDiagram();
		copiedItems = new ArrayList<DiagramItem>();
		if (!(d.getSelection().getNodes().isEmpty())) {
			DiagramNodeList nodes = d.getSelection().getNodes();
			for (DiagramNode node : nodes) {
				if (node instanceof ShapeNode) {
					ShapeNode snode = (ShapeNode) node;
					copiedItems.add(snode);
				}
			}
		}
		if (!(d.getSelection().getLinks().isEmpty())) {
			DiagramLinkList links = d.getSelection().getLinks();
			for (DiagramLink link : links) {
				if (link instanceof DiagramLink) {
					copiedItems.add(link);
				}
			}
		}
	}

	public void onPaste() {
		if (lastMouseClickedPosition == null || copiedItems == null
				|| copiedItems.size() == 0) {
			return;
		}
		Diagram diagram = getDiagram();
		DiagramView diagramView = getDiagramView();
		DiagramItem diagramItem = copiedItems.get(0);
		Float bounds = diagramItem.getBounds();
		float delX = (float) lastMouseClickedPosition.getX() - bounds.x;
		float delY = (float) lastMouseClickedPosition.getY() - bounds.y;

		// first add all nodes
		HashMap<DiagramNode, DiagramNode> selectedToAddedMap = new HashMap<DiagramNode, DiagramNode>();
		for (DiagramItem itemOriginal : copiedItems) {
			if (itemOriginal == null) {
				continue;
			}
			if (!(itemOriginal instanceof DiagramNode)) {
				continue;
			}
			DiagramItem item = itemOriginal.clone(true);
			diagram.add(item);
			Float bounds2 = item.getBounds();
			bounds2.x = bounds2.x + delX;
			bounds2.y = bounds2.y + delY;
			((DiagramNode) item).setBounds(bounds2);
			selectedToAddedMap.put((DiagramNode) itemOriginal,
					(DiagramNode) item);

			// FIXME: alignTo grid
		}
		// then add links connecting them to nodes if selected and added
		for (DiagramItem itemOriginal : copiedItems) {
			if (itemOriginal == null) {
				continue;
			}
			if (!(itemOriginal instanceof DiagramLink)) {
				continue;
			}
			DiagramLink linkOriginal = (DiagramLink) itemOriginal;
			DiagramItem item = itemOriginal.clone(true);
			diagram.add(item);
			Float bounds2 = item.getBounds();
			bounds2.x = bounds2.x + delX;
			bounds2.y = bounds2.y + delY;
			DiagramLink link = (DiagramLink) item;
			for (Point2D.Float point : link.getControlPoints()) {
				point.x = point.x + delX;
				point.y = point.y + delY;
			}
			link.updateFromPoints();
			// connect it up if origin or destination nodes were selected and
			// copied over
			DiagramNode origin = linkOriginal.getOrigin();
			if (origin != null) {
				DiagramNode originCopy = selectedToAddedMap.get(origin);
				if (originCopy != null) {
					link.setOrigin(originCopy);
				}
			}
			DiagramNode dest = linkOriginal.getDestination();
			if (dest != null) {
				DiagramNode destCopy = selectedToAddedMap.get(dest);
				if (destCopy != null) {
					link.setDestination(destCopy);
				}
			}
			// FIXME: alignTo grid
		}

	}

	public void boxClicked(NodeEvent e) {
		if (e.getMouseButton() == MouseEvent.BUTTON1) {
		} else if (e.getMouseButton() == MouseEvent.BUTTON3) {
			int x;
			int y;

			Point2D event = e.getMousePosition();
			x = (int) event.getX();
			y = (int) event.getY();
			Point mousePos = getMousePosition();
			clickedItem = e.getNode();
			shortenPointsMenuItem.setEnabled(false);
			// display context menu at right mouse click
			popupMenu.show(this, mousePos.x, mousePos.y);
		}
	}

	public void arrowClicked(LinkEvent e) {
		if (e.getMouseButton() == MouseEvent.BUTTON1) {
		} else if (e.getMouseButton() == MouseEvent.BUTTON3) {
			int x;
			int y;

			Point2D event = e.getMousePosition();
			x = (int) event.getX();
			y = (int) event.getY();
			Point mousePos = getMousePosition();

			clickedItem = e.getLink();
			// display context menu at right mouse click
			shortenPointsMenuItem.setEnabled(true);
			popupMenu.show(this, mousePos.x, mousePos.y);
		}
	}

	public void diagramClicked(DiagramEvent e) {
		if (e.getMouseButton() == MouseEvent.BUTTON1) {
		} else if (e.getMouseButton() == MouseEvent.BUTTON3) {

			int x;
			int y;

			Point2D event = e.getMousePosition();
			x = (int) event.getX();
			y = (int) event.getY();
			Point mousePos = getMousePosition();

			// display context menu at right mouse click
			pastePopupMenu.show(this, mousePos.x, mousePos.y);
			lastMouseClickedPosition = event;
		}
	}

	@Override
	public void load(String filename) throws FileNotFoundException,
			IOException, XmlException {
		super.load(filename);
		getDiagram().setAutoResize(AutoResize.AllDirections);

		getDiagram().setAdjustmentHandlesSize(6);
		getDiagram().setAdjustmentHandlesSize(8);

		// getDiagram().setAllowUnanchoredLinks(true);
		// getDiagram().setAllowUnconnectedLinks(true);
		getDiagram().setDynamicLinks(true);
		getDiagram().setAlignToGrid(true);

		getDiagram().setGridColor(Color.blue);
		getDiagram().setGridSizeX(10);
		getDiagram().setGridSizeY(10);
		getDiagram().setGridStyle(GridStyle.Lines);

		RoutingOptions routingOptions = getDiagram().getRoutingOptions();
		routingOptions.setEndOrientation(Orientation.Auto);
		routingOptions.setStartOrientation(Orientation.Auto);
		routingOptions.setLengthCost((short) 100);
		routingOptions.setSmartPolylineEnds(true);
		routingOptions.setMinSegmentsMode();
		routingOptions.setTriggerRerouting(RerouteLinks.WhenIntersectNode);

		UndoManager undoManager = getDiagram().getUndoManager();
		undoManager.setUndoEnabled(true);

	}

	public Action getToggleAutoAlignAction() {
		return new AbstractAction("Auto Align", ImageUtil
				.createImageIcon("images/auto_align.png")) {

			@Override
			public void actionPerformed(ActionEvent evt) {
				Object source = evt.getSource();
				if (source instanceof JToggleButton) {
					JToggleButton toggleButton = (JToggleButton) source;
					if (toggleButton.isSelected()) {
						getDiagram().setAutoAlignDistance(10);
						getDiagram().setAutoAlignNodes(true);
					} else {
						getDiagram().setAutoAlignNodes(false);
					}
				}
			}
		};
	}

	public Action getToggleEvenlySpaceNodes() {
		return new AbstractAction("Evenly Space Nodes", ImageUtil
				.createImageIcon("images/evenly_space_nodes.png")) {

			@Override
			public void actionPerformed(ActionEvent evt) {
				Object source = evt.getSource();
				if (source instanceof AbstractButton) {
					AbstractButton toggleButton = (AbstractButton) source;
					spaceNodesEvenly = toggleButton.isSelected();
				}
			}
		};
	}

	public Action getToggleGridLinesAction() {
		return new AbstractAction("Show Grid", ImageUtil
				.createImageIcon("images/show_grid.png")) {

			@Override
			public void actionPerformed(ActionEvent evt) {
				Object source = evt.getSource();
				if (source instanceof JToggleButton) {
					JToggleButton toggleButton = (JToggleButton) source;
					getDiagram().setShowGrid(toggleButton.isSelected());
					getDiagram().repaint();
				}
			}
		};
	}

	public Action getHorizontalAlignAction() {
		return new AbstractAction("Align Horizontal", ImageUtil
				.createImageIcon("images/align_horizontal.png")) {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				alignSelectedNodes(Orientation.Horizontal);
				alignSelectedLinks(Orientation.Horizontal);
			}
		};
	}

	public Action getVerticalAlignAction() {
		return new AbstractAction("Align Vertical", ImageUtil
				.createImageIcon("images/align_vertical.png")) {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				alignSelectedNodes(Orientation.Vertical);
				alignSelectedLinks(Orientation.Vertical);
			}
		};
	}

}
