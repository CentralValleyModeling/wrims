package gov.ca.dwr.jdiagram.views;

import gov.ca.dwr.jdiagram.Activator;
import gov.ca.dwr.jdiagram.AttributeMapper;
import gov.ca.dwr.jdiagram.SchematicPluginCore;
import gov.ca.dwr.jdiagram.XmlUtilities;
import gov.ca.dwr.jdiagram.panel.EditSchematicElementPanel;
import gov.ca.dwr.jdiagram.toolbars.DateCombo;
import gov.ca.dwr.jdiagram.toolbars.SearchText;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.prefs.Preferences;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.w3c.dom.Document;

import wrimsv2_plugin.debugger.exception.WPPException;

import com.mindfusion.diagramming.Behavior;
import com.mindfusion.diagramming.CompositeCmd;
import com.mindfusion.diagramming.CustomDraw;
import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramAdapter;
import com.mindfusion.diagramming.DiagramEvent;
import com.mindfusion.diagramming.DiagramItem;
import com.mindfusion.diagramming.DiagramItemList;
import com.mindfusion.diagramming.DiagramLink;
import com.mindfusion.diagramming.DiagramLinkList;
import com.mindfusion.diagramming.DiagramNode;
import com.mindfusion.diagramming.DiagramNodeList;
import com.mindfusion.diagramming.DiagramView;
import com.mindfusion.diagramming.DrawNodeEvent;
import com.mindfusion.diagramming.DummyNode;
import com.mindfusion.diagramming.GridStyle;
import com.mindfusion.diagramming.HandlesStyle;
import com.mindfusion.diagramming.InplaceEditable;
import com.mindfusion.diagramming.LinkEvent;
import com.mindfusion.diagramming.NodeEvent;
import com.mindfusion.diagramming.Orientation;
import com.mindfusion.diagramming.RerouteLinks;
import com.mindfusion.diagramming.RoutingOptions;
import com.mindfusion.diagramming.Shape;
import com.mindfusion.diagramming.ShapeNode;
import com.mindfusion.diagramming.UndoEvent;
import com.mindfusion.diagramming.UndoManager;
import com.mindfusion.diagramming.XmlException;
import com.mindfusion.drawing.Brush;
import com.mindfusion.drawing.DashStyle;
import com.mindfusion.drawing.Pen;
import com.mindfusion.drawing.PointList;
import com.mindfusion.drawing.SolidBrush;
import com.mindfusion.graphs.Point;

public abstract class SchematicEditor extends SchematicBase {

	private final class CompartorOnNodeId implements Comparator<DiagramNode> {
		@Override
		public int compare(DiagramNode o1, DiagramNode o2) {
			if (o1==null){
				if (o2==null){
					return 0;
				}else {
					return -1;
				}
			}else{
				if (o2==null){
					return 1;
				} else {
					String id1 = getIdFor(o1);
					String id2 = getIdFor(o2);
					if (id1==null){
						if (id2==null){
							return 0;
						} else {
							return -1;
						}
					} else {
						if (id2==null){
							return 1;
						}else{
							return id1.compareTo(id2);
						}
					}
				}
			}
		}
	}

	JPopupMenu popupMenu;
	JPopupMenu pastePopupMenu;
	JMenuItem deleteMenuItem;
	JMenuItem copyMenuItem;
	private JMenuItem pasteMenuItem;
	private Action exportAction;
	private Action importAction;
	private Action undoAction;
	private Action redoAction;
	private Action copyAction;
	private Action pasteAction;
	private Action verticalAlignAction;
	private Action horizontalAlignAction;
	private JMenuItem shortenPointsMenuItem;
	private JMenuItem editShapeMenuItem;
	private JMenuItem shrinkToElementsMenuItem;
	private JMenuItem changePointsMenuItem;
	private static HashMap<String, String> attributeMap;
	
	public SchematicEditor(){
		super();
	}
	
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		getDiagramView().setBehavior(Behavior.Modify);
		getDiagramView().setAllowInplaceEdit(true);

		attributeMap = new HashMap<String, String>();

		makeEditorActions();
		contributeToEditorActionBars();
		
		// pasteAction.putValue(Action.ACCELERATOR_KEY,
		// KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		getDiagramView().getInputMap().put(
				KeyStroke.getKeyStroke("ctrl typed c"), copyAction);
		getDiagramView().getInputMap().put(
				KeyStroke.getKeyStroke("ctrl typed v"), pasteAction);
		getDiagramView().getInputMap().put(
				KeyStroke.getKeyStroke("ctrl typed z"), undoAction);

		deleteMenuItem = new JMenuItem();
		deleteMenuItem.setName("_menuItemDelete");
		deleteMenuItem.setText("Delete");
		deleteMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onDelete();
			}
		});

		copyMenuItem = new JMenuItem();
		copyMenuItem.setName("_menuItemCopy");
		copyMenuItem.setText("Copy");
		copyMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onCopy();
			}
		});

		pasteMenuItem = new JMenuItem();
		pasteMenuItem.setName("_menuItemPaste");
		pasteMenuItem.setText("Paste");
		pasteMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onPaste();
			}
		});

		shortenPointsMenuItem = new JMenuItem("Delete Intermediate Points");
		shortenPointsMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (clickedItem != null && clickedItem instanceof DiagramLink) {
					onShortenPoints((DiagramLink) clickedItem);
				}
			}

		});

		changePointsMenuItem = new JMenuItem(
				"Change Number of Intermediate Points");
		changePointsMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (clickedItem != null && clickedItem instanceof DiagramLink) {
					onChangePoints((DiagramLink) clickedItem);
				}
			}

		});

		editShapeMenuItem = new JMenuItem("Edit Shape");
		editShapeMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (clickedItem != null && clickedItem instanceof DiagramItem) {
					if (clickedItem instanceof DiagramLink) {
						Pen p = ((Pen) clickedItem.getPen().clone());
						clickedItem.setPen(p);
						clickedItem.getPen().setDashStyle(DashStyle.Dash);
						return;
					}

					// showShapeDialog();
					ShapeNode snode = (ShapeNode) clickedItem;
					snode.setCustomDraw(CustomDraw.Additional);
					/*
					 * Shape shape = snode.getShape(); ElementTemplate[] outline
					 * = shape.getOutline().clone(); int
					 * d1x=2,d2x=98,d1y=5,d2y=95; ElementTemplate[] decorations
					 * = new ElementTemplate[]{ new LineTemplate(d1x, d1y, d2x,
					 * d1y), new LineTemplate(d2x, d1y, d2x, d2y), new
					 * LineTemplate(d2x, d2y, d1x, d2y), new LineTemplate(d1x,
					 * d2y, d1x, d1y) }; for(int i=0; i< decorations.length;
					 * i++){ //decorations[i].setColor(Color.GRAY);
					 * decorations[i].setWidth(0.75f); } Shape newShape = new
					 * Shape(outline, decorations, shape.getTextArea(),
					 * GeneralPath.WIND_NON_ZERO,"DOUBLE BORDER");
					 * snode.setShape(newShape);
					 */
					// Pen p = ((Pen)clickedItem.getPen().clone());
					// clickedItem.setPen(p);
					// clickedItem.getPen().setDashStyle(DashStyle.Dash);
					try {
						addToShapeLibrary();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		shrinkToElementsMenuItem = new JMenuItem("Shrink Bounds to Elements");
		shrinkToElementsMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					shrinkDiagramToElements();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		getDiagram().removeDiagramListener(listener);
		getDiagram().addDiagramListener(new DiagramAdapter() {
			public void nodeSelected(NodeEvent e) {
				e.getNode().setHandlesStyle(HandlesStyle.EasyMove);
			}

			public void linkSelected(LinkEvent e) {
				e.getLink().setSelected(true);
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

			@Override
			/**
			 * Raised when a diagram node must be custom drawn.
			 */
			public void drawNode(DrawNodeEvent e) {
				Rectangle2D rect = e.getBounds();
				rect.setFrame(rect.getMinX() + 9, rect.getMinY() + 9, rect
						.getWidth() - 16, rect.getHeight() - 16);

				Graphics2D g = e.getGraphics();
				Pen pen = (Pen) e.getNode().getPen().clone();
				pen.setWidth(4);
				pen.applyTo(g);
				g.draw(rect);
			}

			// undo/redo events

			@Override
			public void actionRecorded(UndoEvent e) {
				undoAction.setEnabled(true);
				redoAction.setEnabled(false);
			}

			@Override
			public void actionRedone(UndoEvent e) {
				undoAction.setEnabled(true);
				if (getDiagram().getUndoManager().getHistory().getNextRedo() == null) {
					redoAction.setEnabled(false);
				}
			}

			@Override
			public void actionUndone(UndoEvent e) {
				redoAction.setEnabled(true);
				if (getDiagram().getUndoManager().getHistory().getNextUndo() == null) {
					undoAction.setEnabled(false);
				}
			}

			private java.awt.geom.Rectangle2D.Float previousBounds = null;

			@Override
			public void viewportChanged() {
				java.awt.geom.Rectangle2D.Float bounds = getDiagram().getBounds();
				if (previousBounds == null) {
					previousBounds = bounds;
				}
				if (badValue(bounds.x) || badValue(bounds.y)
						|| badValue(bounds.height) || badValue(bounds.width)) {
					getDiagram().setBounds(previousBounds);
				} else {
					previousBounds = bounds;
				}
				float zoomFactor = getDiagramView().getZoomFactor();
				getDiagram().setAdjustmentHandlesSize(
						Math.round(10 + 150 / zoomFactor));
			}

			private boolean badValue(float x) {
				return java.lang.Float.isNaN(x)
						|| java.lang.Float.isInfinite(x)
						|| x == java.lang.Float.MIN_VALUE
						|| x == java.lang.Float.MAX_VALUE
						|| ((int) x == Integer.MAX_VALUE)
						|| ((int) x == Integer.MIN_VALUE);
			}
		});

		pastePopupMenu = new JPopupMenu("Paste Popup");
		pastePopupMenu.setName("pastePopup");
		pastePopupMenu.add(pasteMenuItem);

		popupMenu = new JPopupMenu("Edit Popup");
		popupMenu.setName("editPopup");
		popupMenu.add(copyMenuItem);
		popupMenu.add(deleteMenuItem);
		popupMenu.add(changePointsMenuItem);
	}

	private void makeEditorActions() {
		
		exportAction = new Action("Export Attributes", Activator.getImageDescriptor("export_attr.png")) {

			public void run() {
				String fileToSave = chooseFileToExport();
				try {
					saveAttributesTo(fileToSave);
				} catch (Exception ex) {
					WPPException.handleException(ex);
				}
			};
			
		};

		importAction = new Action("Import Attributes", Activator.getImageDescriptor("import_attr.png")) {

			public void run() {
				String fileToImport = chooseFileToImport();
				try {
					loadAttributesFrom(fileToImport);
				} catch (Exception ex) {
					WPPException.handleException(ex);
				}
			}

		};

		undoAction = new Action("Undo", Activator.getImageDescriptor("undo.png")) {

			public void run() {
				getDiagram().getUndoManager().undo();
				if (this instanceof Action) {
					if (getDiagram().getUndoManager().getHistory()
							.getNextUndo() == null) {
						setEnabled(false);
					}
				}
			}
		};
		undoAction.setEnabled(false);

		redoAction = new Action("Redo", Activator.getImageDescriptor("redo.png")) {

			@Override
			public void run() {
				getDiagram().getUndoManager().redo();
				if (this instanceof Action) {
					if (getDiagram().getUndoManager().getHistory()
							.getNextRedo() == null) {
						setEnabled(false);
					}
				}
			}
		};
		redoAction.setEnabled(false);
		
		copyAction = new Action("Copy", Activator.getImageDescriptor("copy.png")) {

			public void run() {
				onCopy();
			}
		};

		pasteAction = new Action("Paste", Activator.getImageDescriptor("paste.png") ) {

			@Override
			public void run() {
				onPaste();
			}
		};
		
		verticalAlignAction = new Action("Align Vertical", 
				Activator.getImageDescriptor("align_vertical.png")) {

			@Override
			public void run() {
				alignSelectedNodes(Orientation.Vertical);
				alignSelectedLinks(Orientation.Vertical);
			}
		};
		
		horizontalAlignAction = new Action("Align Horizontal", 
				Activator.getImageDescriptor("align_horizontal.png")) {

			@Override
			public void run() {
				alignSelectedNodes(Orientation.Horizontal);
				alignSelectedLinks(Orientation.Horizontal);
			}
		};
	}
	
	private void contributeToEditorActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillEditorToolBar(bars.getToolBarManager());
	}
	
	private void fillEditorToolBar(IToolBarManager manager) {
		manager.add(importAction);
		manager.add(exportAction);
		manager.add(undoAction);
		manager.add(redoAction);
		manager.add(copyAction);
		manager.add(pasteAction);
		manager.add(verticalAlignAction);
		manager.add(horizontalAlignAction);
		if (dateCombo !=null) manager.remove(dateCombo);
	}
	
	public void onDelete() {
		Diagram d = getDiagram();
		CompositeCmd compositeCmd = d.getUndoManager().startComposite(
				"DeleteALot");
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
		compositeCmd.execute();
	}
	
	private Point2D lastMouseClickedPosition;
	private DiagramItem clickedItem;
	
	public void onCopy() {
		Diagram d = getDiagram();
		CompositeCmd compositeCmd = d.getUndoManager().startComposite(
				"CopyALot");
		onCopy(d);
		compositeCmd.execute();
		
		DiagramView diagramView=getDiagramView();
		try {
			diagramView.copyToClipboard(true);
		} catch (IOException e) {
			WPPException.handleException(e);
		} catch (XmlException e) {
			WPPException.handleException(e);
		}
		
		SchematicPluginCore.copyDiagram=d;
	}

	public void onCopy(Diagram d) {
		SchematicPluginCore.copiedItems = new ArrayList<DiagramItem>();
		HashMap<DiagramNode, DiagramNode> selectedToAddedMap = new HashMap<DiagramNode, DiagramNode>();
		if (!(d.getSelection().getNodes().isEmpty())) {
			DiagramNodeList nodes = d.getSelection().getNodes();
			for (DiagramNode node : nodes) {
				if (node instanceof ShapeNode) {
					ShapeNode snode = (ShapeNode) node;
					ShapeNode clone = (ShapeNode) snode.clone(true);
					SchematicPluginCore.copiedItems.add(clone);
					selectedToAddedMap.put(snode, clone);
				}
			}
		}
		if (!(d.getSelection().getLinks().isEmpty())) {
			DiagramLinkList links = d.getSelection().getLinks();
			for (DiagramLink link : links) {
				if (link instanceof DiagramLink) {
					DiagramLink linkClone = (DiagramLink) link.clone(true);
					SchematicPluginCore.copiedItems.add(linkClone);
					// connect it up if origin or destination nodes were
					// selected and
					// copied over
					DiagramNode origin = link.getOrigin();
					if (origin != null) {
						DiagramNode originCopy = selectedToAddedMap.get(origin);
						if (originCopy != null) {
							linkClone.setOrigin(originCopy);
						}
					}
					DiagramNode dest = link.getDestination();
					if (dest != null) {
						DiagramNode destCopy = selectedToAddedMap.get(dest);
						if (destCopy != null) {
							linkClone.setDestination(destCopy);
						}
					}
				}
			}
		}
	}

	public void onPaste() {
		if (lastMouseClickedPosition == null || SchematicPluginCore.copiedItems == null
				|| SchematicPluginCore.copiedItems.size() == 0) {
			return;
		}

		Diagram diagram = getDiagram();
		DiagramView diagramView = getDiagramView();

		CompositeCmd compositeCmd = diagram.getUndoManager().startComposite(
				"PasteALot");
		diagram.getLinkRouter().Suspend();

		DiagramItem diagramItem = SchematicPluginCore.copiedItems.get(0);
		java.awt.geom.Rectangle2D.Float bounds = diagramItem.getBounds();
		float delX = (float) lastMouseClickedPosition.getX() - bounds.x;
		float delY = (float) lastMouseClickedPosition.getY() - bounds.y;

		if (SchematicPluginCore.copyDiagram.equals(diagram)){
		//first add all nodes
		HashMap<DiagramNode, DiagramNode> selectedToAddedMap = new HashMap<DiagramNode, DiagramNode>();
		for (DiagramItem itemOriginal : SchematicPluginCore.copiedItems) {
			if (itemOriginal == null) {
				continue;
			}
			if (!(itemOriginal instanceof DiagramNode)) {
				continue;
			}
			DiagramItem item = itemOriginal.clone(true);
			diagram.add(item, true);
			java.awt.geom.Rectangle2D.Float bounds2 = item.getBounds();
			bounds2.x = bounds2.x + delX;
			bounds2.y = bounds2.y + delY;
			((DiagramNode) item).setBounds(bounds2);
			selectedToAddedMap.put((DiagramNode) itemOriginal,
					(DiagramNode) item);
			//FIXME: alignTo grid
		}
		//then add links connecting them to nodes if selected and added
		for (DiagramItem itemOriginal : SchematicPluginCore.copiedItems) {
			if (itemOriginal == null) {
				continue;
			}
			if (!(itemOriginal instanceof DiagramLink)) {
				continue;
			}
			DiagramLink linkOriginal = (DiagramLink) itemOriginal;
			DiagramItem item = itemOriginal.clone(true);
			diagram.add(item, true);
			java.awt.geom.Rectangle2D.Float bounds2 = item.getBounds();
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

		compositeCmd.execute();
		}else{
			try {
				diagramView.pasteFromClipboard(delX, delY, false);
			} catch (IOException e) {
				WPPException.handleException(e);
			} catch (XmlException e) {
				WPPException.handleException(e);
			}
		}
	}
	
	public void boxClicked(NodeEvent e) {
		if (e.getMouseButton() == MouseEvent.BUTTON1) {
		} else if (e.getMouseButton() == MouseEvent.BUTTON3) {
			e.getNode().setLocked(false);
			int x;
			int y;

			Point2D event = e.getPointerPosition();
			x = (int) event.getX();
			y = (int) event.getY();
			Component contentPane = getContentPane();
			java.awt.Point mousePos = contentPane.getMousePosition();
			clickedItem = e.getNode();
			// shortenPointsMenuItem.setEnabled(false);
			// display context menu at right mouse click
			popupMenu.show(contentPane, mousePos.x, mousePos.y);
		}
	}

	public void arrowClicked(LinkEvent e) {
		if (e.getMouseButton() == MouseEvent.BUTTON1) {
		} else if (e.getMouseButton() == MouseEvent.BUTTON3) {
			e.getLink().setLocked(false);
			int x;
			int y;

			Point2D event = e.getPointerPosition();
			x = (int) event.getX();
			y = (int) event.getY();
			Component contentPane = getContentPane();
			java.awt.Point mousePos = contentPane.getMousePosition();

			clickedItem = e.getLink();
			// display context menu at right mouse click
			// shortenPointsMenuItem.setEnabled(true);
			popupMenu.show(contentPane, mousePos.x, mousePos.y);
		}
	}

	public void diagramClicked(DiagramEvent e) {
		if (e.getMouseButton() == MouseEvent.BUTTON1) {
		} else if (e.getMouseButton() == MouseEvent.BUTTON3) {

			int x;
			int y;

			Point2D event = e.getPointerPosition();
			x = (int) event.getX();
			y = (int) event.getY();
			Component contentPane = getContentPane();
			java.awt.Point mousePos = contentPane.getMousePosition();

			// display context menu at right mouse click
			pastePopupMenu.show(contentPane, mousePos.x, mousePos.y);
			lastMouseClickedPosition = event;
		}
	}

	
	public void onShortenPoints(DiagramLink link) {
		try {
			PointList controlPoints = link.getControlPoints();
			for (int i=1; i<=Math
					.max(1, link.getSegmentCount() - 1); i++){
				controlPoints.remove(i);
			}
			// link.updateFromPoints(false, true);
			link.updateFromPoints();
			// link.route();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void onChangePoints(DiagramLink link) {//Corrected by Liheng Zhong, 05/23/2012 
		try {
			PointList controlPoints = link.getControlPoints();
			String result = JOptionPane.showInputDialog(
					"Set points in link to: ", controlPoints.size() - 2);
			if (result == null){
				return;
			}
			int npoints = Integer.parseInt(result);
			if (npoints < 0 || npoints == controlPoints.size() - 2)
				return;
			// link.setSegmentCount(npoints);
			if (npoints < controlPoints.size() - 2) {
				int n_point_delete = controlPoints.size() - 2 - npoints;
				for (int i = 1; i <= n_point_delete; i++){
					controlPoints.remove(1);
				}
			} else {
				java.awt.geom.Point2D.Float float0 = controlPoints.get(0);
				java.awt.geom.Point2D.Float float1 = controlPoints.get(1);
				int n_point_add = npoints - controlPoints.size() + 2;
				for (int i = 1; i <= n_point_add; i++) {
					java.awt.geom.Point2D.Float float2 = (java.awt.geom.Point2D.Float) float0.clone();
					float2.setLocation((float0.getX()+float1.getX())/2, (float0.getY()+float1.getY())/2);
					controlPoints.add(1,float2);
					float1 = float2;
				}
			}
			link.updateFromPoints(true);
			//link.updateFromPoints();
			// link.route();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void alignSelectedLinks(Orientation direction) {
		for (DiagramLink link : getDiagram().getSelection().getLinks()) {
			alignLinkPoints(link, direction);
		}
		getDiagram().repaint();
	}

	public void alignLinkPoints(DiagramLink link, Orientation direction) {
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
			// java.awt.geom.Point2D.Float pointOnGrid =
			// getDiagram().alignPointToGrid(p);
			// p.x=pointOnGrid.x;
			// p.y=pointOnGrid.y;
			index++;
		}

		try {
			link.updateFromPoints(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean spaceNodesEvenly = false;

	public void alignSelectedNodes(final Orientation orientation) {
		Diagram diagram = getDiagram();
		DiagramNodeList nodes = diagram.getSelection().getNodes();
		ArrayList<DiagramNode> sortedNodes = new ArrayList<DiagramNode>();
		sortedNodes.addAll(nodes);
		Collections.sort(sortedNodes, new Comparator<DiagramNode>() {

			@Override
			public int compare(DiagramNode arg0, DiagramNode arg1) {
				if (orientation == Orientation.Horizontal) {
					return (int) Math.signum(arg0.getBounds().x
							- arg1.getBounds().x);
				} else if (orientation == Orientation.Vertical) {
					return (int) Math.signum(arg0.getBounds().y
							- arg1.getBounds().y);
				} else {
					return 0;
				}
			}

		});
		if (nodes.size() == 0) {
			return;
		}
		DiagramNode alignNode = sortedNodes.get(0);
		java.awt.geom.Rectangle2D.Float bounds0 = alignNode.getBounds();
		double centerX = bounds0.getCenterX();
		double centerY = bounds0.getCenterY();
		DiagramNode endAlignNode = sortedNodes.get(sortedNodes.size() - 1);
		java.awt.geom.Rectangle2D.Float bounds1 = endAlignNode.getBounds();
		int size = nodes.size();
		float spaceX = 1, spaceY = 1;
		if (size > 1) {
			spaceX = (bounds1.x - bounds0.x) / (size - 1);
			spaceY = (bounds1.y - bounds0.y) / (size - 1);
		}
		int index = 0;
		for (DiagramNode n : sortedNodes) {
			java.awt.geom.Rectangle2D.Float bounds = n.getBounds();
			if (orientation == Orientation.Vertical) {
				double delX = bounds.getCenterX() - centerX;
				bounds.x = bounds.x - (float) delX;
				if (spaceNodesEvenly) {
					bounds.y = bounds0.y + index * spaceY - bounds.height / 2;
				}
			} else if (orientation == Orientation.Horizontal) {
				double delY = bounds.getCenterY() - centerY;
				bounds.y = bounds.y - (float) delY;
				if (spaceNodesEvenly) {
					bounds.x = bounds0.x + index * spaceX - bounds.width / 2;
				}
			}
			// java.awt.geom.Point2D.Float pointOnGrid =
			// diagram.alignPointToGrid(new Point2D.Float(bounds.x, bounds.y));
			// n.moveTo(pointOnGrid.x, pointOnGrid.y);
			n.moveTo(bounds.x, bounds.y);
			index++;
		}
		diagram.repaint();
	}
	
	public void showShapeDialog() {
		JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(getContentPane()),
				"Edit Shape", ModalityType.APPLICATION_MODAL);
		EditSchematicElementPanel editPanel = new EditSchematicElementPanel();
		dialog.getContentPane().add(editPanel);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		editPanel.setDiagramItem(clickedItem);
		dialog.pack();
		dialog.show();
		clickedItem.getPen().setColor(editPanel.getColor());
		if (clickedItem instanceof ShapeNode) {
			ShapeNode shapeNode = (ShapeNode) clickedItem;
			shapeNode.getShape().setId(editPanel.getShape());
			shapeNode.getPen().setColor(editPanel.getColor());
		}
		if (clickedItem instanceof DiagramLink) {
			DiagramLink link = (DiagramLink) clickedItem;
			link.getHeadPen().setColor(editPanel.getColor());
		}
	}

	public void shrinkDiagramToElements() throws Exception {
		DiagramItemList items = getDiagram().getItems();
		Rectangle2D.Float calculatedBounds = null;
		float minx = java.lang.Float.MAX_VALUE, miny = java.lang.Float.MAX_VALUE, maxx = java.lang.Float.MIN_VALUE, maxy = java.lang.Float.MIN_VALUE;
		for (DiagramItem item : items) {
			java.awt.geom.Rectangle2D.Float itemBounds = item.getBounds();
			if (calculatedBounds == null) {
				calculatedBounds = (Rectangle2D.Float) itemBounds.clone();
			} else {
				calculatedBounds.add(itemBounds);
			}
		}
		getDiagram().setBounds(calculatedBounds);
		getDiagram().repaint();
	}

	public void addToShapeLibrary() throws Exception {
		String filename = "d:/temp/shapes.xml";
		if (clickedItem instanceof ShapeNode) {
			ShapeNode snode = (ShapeNode) clickedItem;
			Shape s = snode.getShape();
			Document doc = XmlUtilities.newDocument();
			doc.appendChild(s.toDOM(doc));
			XmlUtilities.saveTo(doc, filename);
		}
	}
	
	protected void saveAttributesTo(String fileToSave) throws Exception {
		AttributeMapper mapper = new AttributeMapper();
		Diagram d = getDiagram();
		PrintWriter wr = new PrintWriter(fileToSave);
		ArrayList<DiagramNode> nodes = new ArrayList<DiagramNode>();
		for (DiagramNode n : d.items(DiagramNode.class)) {
			nodes.add(n);
		}
		
		Collections.sort(nodes, new CompartorOnNodeId());
		
		for (DiagramNode n : nodes) {
			if (n instanceof ShapeNode){
				ShapeNode s=(ShapeNode)n;
				Pen pen = s.getPen();
				Color fillColor = null;
				Brush brush = s.getBrush();
				Shape shape=s.getShape();
				CustomDraw customdraw=s.getCustomDraw();
				if (brush instanceof SolidBrush) {
					fillColor = ((SolidBrush) brush).getColor();
				} else {
					System.err.println("brush type is :" + brush.getClass()
							+ " for node: " + ((InplaceEditable)n).getTextToEdit());
				}
				String id = getIdFor(n);
				if (id.length() > 40){
					id=id.substring(0, 39);
				}
	
				String attributeName = mapper.getAttributeName(pen, brush, shape, customdraw);
				wr.println(String.format("%-45s|%s|%s|%3.1f|%s|%s|%s|%s", id, mapper
						.formatColor(pen.getColor()), mapper.formatStyle(pen
						.getDashStyle()), pen.getWidth(), mapper
						.formatColor(fillColor), mapper.formatShape(shape), mapper.formatCustomDraw(customdraw), attributeName));
			}
		}
		wr.close();
	}

	protected void loadAttributesFrom(String fileToImport) throws Exception {
		AttributeMapper mapper = new AttributeMapper();
		Diagram d = getDiagram();
		LineNumberReader reader = new LineNumberReader(new FileReader(
				fileToImport));
		String line = null;
		HashMap<String, AttributeMapper.Attribute> idToAttributeMap = new HashMap<String, AttributeMapper.Attribute>();
		while ((line = reader.readLine()) != null) {
			String[] fields = line.split("\\|");
			String id = fields[0].trim();
			AttributeMapper.Attribute attr = null;
			if (fields.length > 7) {
				String attributeName = fields[7];
				if (attributeName != null && !attributeName.equals("")) {
					attr = mapper.getAttribute(attributeName);
				}
			} 
			if (attr == null) {
				String line_attr=line.substring(line.indexOf("|")+1);
/*				Color outlineColor = mapper.parseColor(fields[1]);
				DashStyle style = mapper.parseStyle(fields[2]);
				float width = fields[3] != null && !fields[3].trim().equals("") ? java.lang.Float
						.parseFloat(fields[3])
						: 4;
				Color fillColor = mapper.parseColor(fields[4]);*/
				
				Pen pen = mapper.parsePen(line_attr);
				Brush brush = mapper.parseBrush(line_attr);
				Shape shape = mapper.parseShape(line_attr);
				CustomDraw customdraw = mapper.parseCustomDraw(line_attr);
				
				attr = new AttributeMapper.Attribute();
				attr.pen = pen;
				attr.brush = brush;
				attr.shape = shape;
				attr.customdraw = customdraw;
			}

			idToAttributeMap.put(id, attr);
		}
		reader.close();

		DiagramNodeList nodes = d.getNodes();
		getDiagramView().suspendRepaint();
		for (DiagramNode n : nodes) {
			String id = getIdFor(n);
			if (id.length() > 40){
				id=id.substring(0, 39);
			}
			AttributeMapper.Attribute attribute = idToAttributeMap.get(id);
			if (attribute == null) {
				continue;
			}
			if (n instanceof ShapeNode){
				ShapeNode s=(ShapeNode)n;
				s.setPen(attribute.pen);
				s.setBrush(attribute.brush);
				s.setShape(attribute.shape);
				s.setCustomDraw(attribute.customdraw);
			}
		}
		getDiagramView().resumeRepaint();
	}
	
	public String getIdFor(DiagramNode n){
		String text = ((InplaceEditable)n).getTextToEdit();
		//return text == null ? null : text.split("\n")[0].trim();
		return text == null ? null : text.trim().replace("\n", "*#*");
	}
	
	public String chooseFileToImport() {
		Preferences p = Preferences.userNodeForPackage(SchematicEditor.class);
		String currentDirectory = p.get("SCHEMATICS_DIRECTORY", System
				.getProperty("user.dir"));
		JFileChooser chooser = new JFileChooser(currentDirectory);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "text";
			}

			@Override
			public boolean accept(File f) {
				return f != null && f.isFile()
						&& (f.getName().toLowerCase().endsWith(".txt"))
						|| f.isDirectory();
			}
			
		});
		int rval = chooser.showOpenDialog(getContentPane());
		if (rval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File selectedFile = chooser.getSelectedFile();
		p.put("SCHEMATICS_DIRECTORY", selectedFile.getParent());
		return selectedFile.getAbsolutePath();
	}

	public String chooseFileToExport() {
		Preferences p = Preferences.userNodeForPackage(SchematicEditor.class);
		String currentDirectory = p.get("SCHEMATICS_DIRECTORY", System
				.getProperty("user.dir"));
		JFileChooser chooser = new JFileChooser(currentDirectory);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "text";
			}

			@Override
			public boolean accept(File f) {
				return f != null && f.isFile() || f.isDirectory();
			}
		});
		int rval = chooser.showSaveDialog(getContentPane());
		if (rval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File selectedFile = chooser.getSelectedFile();
		p.put("SCHEMATICS_DIRECTORY", selectedFile.getParent());
		return selectedFile.getAbsolutePath();
	}
	
	public void load() {
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
		routingOptions.setTriggerRerouting(EnumSet.noneOf(RerouteLinks.class));

		UndoManager undoManager = getDiagram().getUndoManager();
		undoManager.setUndoEnabled(true);
		redoAction.setEnabled(false);
		undoAction.setEnabled(false);
	}
}
