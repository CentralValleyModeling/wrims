package wrims.schematic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.nwoods.jgo.*;

/**
 *
 * @author Clay Booher (adapted Tom Pruett's SchematicOverview
 *
 */
public class MapOverview extends JGoView implements JGoViewListener {	

	private Hashtable<String, String> _regionToNodenameMap = new Hashtable<String, String>();

	private final String[] regionNames = {"Redding", "Red Bluff", "Colusa", "Butte", "Feather", "Yuba", "American",
		"Cache", "NBA", "Delta", "Eastside", "San Joaquin", "Southern"};

	private final String[] centralNodeNames = {"SAC 281", "SAC 207", "CBD 031", "BTC 000", "WWC 014", "YUB 011", "RFS 26",
		"PTH 007", "PSC 023", "OMR 009", "MOK 048", "614", "855"};

	public final int ALPHA_VALUE = 175;  // out of maximum 255

	protected Point myDefaultLocation = new Point(10, 10);

	private Point myMouseUpDocPoint = new Point(0, 0);

	private Point copyPoint = new Point(0, 0); //CB added

	protected Schematic _app;

//	protected JFrame _frame;

	private MapOverview() {
		super();
	}

	private MapOverview(SchematicDocument doc) {
		super(doc);
		doc.setModifiable(false);
	}

//	public MapOverview(Schematic app, Image backgroundImage) {
//		super();
//		initialize(app, backgroundImage);
//	}

	public MapOverview(SchematicDocument doc, Schematic app, Image backgroundImage) {
		super(doc);
		initialize(app, backgroundImage);
		doc.setModifiable(false);
	}

	public void initialize(Schematic app, Image backgroundImage) {
		_app = app;
//		_frame = frame;
		addViewListener(this);
		setGridWidth(10);
		setGridHeight(10);

//		JToolBar toolBar = initToolbar();
//		add(toolBar);

		if (regionNames.length == centralNodeNames.length) {
			for (int i = 0; i < regionNames.length; ++i) {
//				System.out.print(regionNames[i]);
//				System.out.print(" : ");
//				System.out.println(centralNodeNames[i]);
				_regionToNodenameMap.put(regionNames[i], centralNodeNames[i]);
			}
		}

		JGoBasicNode redding = new JGoBasicNode();
		JGoPolygon polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(75, 0));
//		polygon.addPoint(new Point(75, 100));
//		polygon.addPoint(new Point(0, 100));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(190, 0));
		polygon.addPoint(new Point(190, 254));
		polygon.addPoint(new Point(0, 254));
		polygon.addPoint(new Point(0, 0));
		redding.setDrawable(polygon);
		redding.setBrush(JGoBrush.makeStockBrush(new Color(255, 0, 0, ALPHA_VALUE)));
		redding.setLabel(new JGoText("Redding"));
		conditionRegion(redding);
//		redding.setLocation(new Point(165, 170));
		redding.setLocation(new Point(424, 420));
		JGoLayer defaultLayer = getDocument().getDefaultLayer();
		defaultLayer.addObjectAtTail(redding);

		JGoBasicNode redBluff = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(93, 0));
//		polygon.addPoint(new Point(93, 31));
//		polygon.addPoint(new Point(80, 58));
//		polygon.addPoint(new Point(75, 58));
//		polygon.addPoint(new Point(63, 77));
//		polygon.addPoint(new Point(28, 77));
//		polygon.addPoint(new Point(28, 92));
//		polygon.addPoint(new Point(0, 92));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(244, 0));
		polygon.addPoint(new Point(244, 78));
		polygon.addPoint(new Point(203, 147));
		polygon.addPoint(new Point(190, 147));
		polygon.addPoint(new Point(160, 196));
		polygon.addPoint(new Point(71, 196));
		polygon.addPoint(new Point(71, 234));
		polygon.addPoint(new Point(0, 234));
		polygon.addPoint(new Point(0, 0));
		redBluff.setDrawable(polygon);
		redBluff.setBrush(JGoBrush.makeStockBrush(new Color(255, 255, 0, ALPHA_VALUE)));  //yellow
		redBluff.setLabel(new JGoText("Red Bluff"));
		conditionRegion(redBluff);
//		redBluff.setLocation(new Point(169, 266));
		redBluff.setLocation(new Point(438, 665));
		defaultLayer.addObjectAtTail(redBluff);

		JGoBasicNode colusa = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(-11, 0));
//		polygon.addPoint(new Point(-11, 25));
//		polygon.addPoint(new Point(30, 66));
//		polygon.addPoint(new Point(46, 66));
//		polygon.addPoint(new Point(30, 20));
//		polygon.addPoint(new Point(33, -15));
//		polygon.addPoint(new Point(6, -15));
//		polygon.addPoint(new Point(6, 0));
//		polygon.addPoint(new Point(-11, 0));
		polygon.addPoint(new Point(-28, 0));
		polygon.addPoint(new Point(-28, 63));
		polygon.addPoint(new Point(76, 168));
		polygon.addPoint(new Point(117, 168));
		polygon.addPoint(new Point(76, 51));
		polygon.addPoint(new Point(84, -38));
		polygon.addPoint(new Point(15, -38));
		polygon.addPoint(new Point(15, 0));
		polygon.addPoint(new Point(-28, 0));
		colusa.setDrawable(polygon);
		colusa.setBrush(JGoBrush.makeStockBrush(new Color(0, 0, 255, ALPHA_VALUE)));  //blue
		colusa.setLabel(new JGoText("Colusa"));
		conditionRegion(colusa);
		colusa.setLocation(new Point(417, 847));
		defaultLayer.addObjectAtTail(colusa);

		JGoBasicNode butteSutter = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(-3, 35));
//		polygon.addPoint(new Point(13, 81));
//		polygon.addPoint(new Point(16, 81));
//		polygon.addPoint(new Point(16, 10));
//		polygon.addPoint(new Point(50, -40));
//		polygon.addPoint(new Point(40, -47));
//		polygon.addPoint(new Point(26, -20));
//		polygon.addPoint(new Point(21, -20));
//		polygon.addPoint(new Point(10, 0));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(-8, 89));
		polygon.addPoint(new Point(33, 206));
		polygon.addPoint(new Point(41, 206));
		polygon.addPoint(new Point(41, 25));
		polygon.addPoint(new Point(127, -102));
		polygon.addPoint(new Point(102, -119));
		polygon.addPoint(new Point(62, -50)); //
		polygon.addPoint(new Point(49, -50)); //
		polygon.addPoint(new Point(19, 0));
		polygon.addPoint(new Point(0, 0));
		butteSutter.setDrawable(polygon);
		butteSutter.setBrush(JGoBrush.makeStockBrush(new Color(0, 175, 0, ALPHA_VALUE)));  //green
		butteSutter.setLabel(new JGoText("Butte"));  //"Butte-Sutter"?  CB - cannot move it in pixels so...
		//too far left		butteSutter.setLabelSpot(JGoBasicNode.Left);  //override conditionRegion's label spot
//		butteSutter.getLabel().setLocationOffset(0, 0, -50, -50);  //no effect! (tried other ways - none worked), so ...
		conditionRegion(butteSutter);
		//... hide the connected label:
		butteSutter.getLabel().setTextColor(new Color(0, 175, 0, 0));
		butteSutter.setLocation(new Point(517, 787));
		defaultLayer.addObjectAtTail(butteSutter);
		//... add label here
//		JGoTextNode tn = new JGoTextNode("Butte");
		TextNode tn = new TextNode("Butte");
		tn.setBrush(JGoBrush.makeStockBrush(new Color(0, 175, 0, 0)));
		tn.setPen(JGoPen.makeStockPen(new Color(0, 175, 0, 0)));
		tn.setSelectable(false);
		tn.setLocation(477, 787);
		defaultLayer.addObjectAtTail(tn);

		JGoBasicNode feather = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(-34, 50));
//		polygon.addPoint(new Point(-34, 90));
//		polygon.addPoint(new Point(40, 83));
//		polygon.addPoint(new Point(45, 0));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(-86, 127));
		polygon.addPoint(new Point(-86, 229));
		polygon.addPoint(new Point(102, 211));
		polygon.addPoint(new Point(114, 0));
		polygon.addPoint(new Point(0, 0));
		feather.setDrawable(polygon);
		feather.setBrush(JGoBrush.makeStockBrush(new Color(230, 150, 0, ALPHA_VALUE)));  //orange
		feather.setLabel(new JGoText("Feather"));
		conditionRegion(feather);
		feather.setLocation(new Point(599, 757));
		defaultLayer.addObjectAtTail(feather);

		JGoBasicNode yubaBear = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(74, -7));
//		polygon.addPoint(new Point(74, -7));
//		polygon.addPoint(new Point(53, 18));
//		polygon.addPoint(new Point(0, 31));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(188, -18));
		polygon.addPoint(new Point(135, 46));
		polygon.addPoint(new Point(0, 79));
		polygon.addPoint(new Point(0, 0));
		yubaBear.setDrawable(polygon);
		yubaBear.setBrush(JGoBrush.makeStockBrush(new Color(200, 0, 200, ALPHA_VALUE)));  //magenta
		yubaBear.setLabel(new JGoText("Yuba")); //Yuba-Bear??
		conditionRegion(yubaBear);
		yubaBear.setLocation(new Point(594, 901));
		defaultLayer.addObjectAtTail(yubaBear);

		JGoBasicNode american = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(5, -20));
//		polygon.addPoint(new Point(-16, 4));
//		polygon.addPoint(new Point(-68, 16));
//		polygon.addPoint(new Point(-68, 50));
//		polygon.addPoint(new Point(-3, 40));
//		polygon.addPoint(new Point(7, -20));
		polygon.addPoint(new Point(15, -54));
		polygon.addPoint(new Point(-41, 10));
		polygon.addPoint(new Point(-173, 41));
		polygon.addPoint(new Point(-173, 127));
		polygon.addPoint(new Point(-6, 102));
		polygon.addPoint(new Point(15, -54));
		american.setDrawable(polygon);
		american.setBrush(JGoBrush.makeStockBrush(new Color(255, 255, 0, ALPHA_VALUE)));  //yellow
		american.setLabel(new JGoText("American"));
		conditionRegion(american);
		american.setLocation(new Point(594, 945));
		defaultLayer.addObjectAtTail(american);

		JGoBasicNode cachePutah = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(46, 0));
//		polygon.addPoint(new Point(46, 25));
//		polygon.addPoint(new Point(87, 66));
//		polygon.addPoint(new Point(105, 66));
//		polygon.addPoint(new Point(105, 98));
//		polygon.addPoint(new Point(109, 120));
//		polygon.addPoint(new Point(58, 111));
//		polygon.addPoint(new Point(0, 35));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(117, 0));
		polygon.addPoint(new Point(117, 63));
		polygon.addPoint(new Point(219, 167));
		polygon.addPoint(new Point(272, 167));
		polygon.addPoint(new Point(272, 249));
		polygon.addPoint(new Point(282, 307));
		polygon.addPoint(new Point(147, 282));
		polygon.addPoint(new Point(0, 89));
		polygon.addPoint(new Point(0, 0));
		cachePutah.setDrawable(polygon);
		cachePutah.setBrush(JGoBrush.makeStockBrush(new Color(255, 0, 0, ALPHA_VALUE)));  //red
		cachePutah.setLabel(new JGoText("Cache")); //or "Cache-Putah"?
		conditionRegion(cachePutah);
		cachePutah.setLocation(new Point(369, 935));
		defaultLayer.addObjectAtTail(cachePutah);

		JGoBasicNode nba = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(2, 13));
//		polygon.addPoint(new Point(56, 25));
//		polygon.addPoint(new Point(54, 12));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(5, 33));
		polygon.addPoint(new Point(141, 59));
		polygon.addPoint(new Point(135, 26));
		polygon.addPoint(new Point(0, 0));
		nba.setDrawable(polygon);
		nba.setBrush(JGoBrush.makeStockBrush(new Color(255, 150, 0, ALPHA_VALUE)));  //orange
		nba.setLabel(new JGoText("NBA")); //or "North Bay Aqueduct"?
		conditionRegion(nba);
		nba.setLocation(new Point(445, 1093));
		defaultLayer.addObjectAtTail(nba);

		JGoBasicNode delta = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(8, 44));
//		polygon.addPoint(new Point(62, 54));
//		polygon.addPoint(new Point(54, 12));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(40, 114));
		polygon.addPoint(new Point(157, 135));
		polygon.addPoint(new Point(137, 26));
		polygon.addPoint(new Point(0, 0));
		delta.setDrawable(polygon);
		delta.setBrush(JGoBrush.makeStockBrush(new Color(0, 175, 0, ALPHA_VALUE)));  //green
		delta.setLabel(new JGoText("Delta")); //or "North Bay Aqueduct"?
		conditionRegion(delta);
//		delta.setLocation(new Point(176, 461));
		delta.setLocation(457, 1164);
		defaultLayer.addObjectAtTail(delta);

		JGoBasicNode eastside = new JGoBasicNode();
		polygon = new JGoPolygon();
		// changed to larger background image:
//		polygon.addPoint(new Point(0, 0));
//		polygon.addPoint(new Point(66, -10));
//		polygon.addPoint(new Point(76, 57));
//		polygon.addPoint(new Point(64, 72));
//		polygon.addPoint(new Point(14, 77));
//		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(167, -25));
		polygon.addPoint(new Point(193, 145));
		polygon.addPoint(new Point(162, 183));
		polygon.addPoint(new Point(36, 196));
		polygon.addPoint(new Point(0, 0));
		eastside.setDrawable(polygon);
		eastside.setBrush(JGoBrush.makeStockBrush(new Color(0, 0, 255, ALPHA_VALUE)));  //blue
		eastside.setLabel(new JGoText("Eastside"));
		conditionRegion(eastside);
//		eastside.setLocation(new Point(231, 445));
		eastside.setLocation(new Point(596, 1121));
		defaultLayer.addObjectAtTail(eastside);

		JGoBasicNode sanjoaquin = new JGoBasicNode();
		polygon = new JGoPolygon();
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(117, 21));
		polygon.addPoint(new Point(243, 8));
		polygon.addPoint(new Point(274, -30));
		polygon.addPoint(new Point(474, 285));
		polygon.addPoint(new Point(370, 345));
		polygon.addPoint(new Point(180, 345));
		polygon.addPoint(new Point(-60, 55));
		polygon.addPoint(new Point(0, 0));
		sanjoaquin.setDrawable(polygon);
		sanjoaquin.setBrush(JGoBrush.makeStockBrush(new Color(200, 0, 200, ALPHA_VALUE)));  //magenta
		sanjoaquin.setLabel(new JGoText("San Joaquin"));
		conditionRegion(sanjoaquin);
		sanjoaquin.setLocation(new Point(626, 1368));
		defaultLayer.addObjectAtTail(sanjoaquin);

		JGoBasicNode south = new JGoBasicNode();
		polygon = new JGoPolygon();
		polygon.addPoint(new Point(0, 0));
		polygon.addPoint(new Point(75, 0));
		polygon.addPoint(new Point(330, 425));
		polygon.addPoint(new Point(720, 720));
		polygon.addPoint(new Point(740, 860));
		polygon.addPoint(new Point(550, 860));
		polygon.addPoint(new Point(100, 340));
		polygon.addPoint(new Point(-45, 505));
		polygon.addPoint(new Point(-60, 300));
		polygon.addPoint(new Point(115, 210));
		polygon.addPoint(new Point(0, 0));
		south.setDrawable(polygon);
		south.setBrush(JGoBrush.makeStockBrush(new Color(255, 255, 0, ALPHA_VALUE)));  //yellow
		south.setLabel(new JGoText("Southern")); //CB - cannot move it in pixels so...
		//too far left		south.setLabelSpot(JGoBasicNode.Left);  //override conditionRegion's label spot
//		south.getLabel().setLocationOffset(0, 0, -50, -50);  //no effect! (tried other ways - none worked), so ...
		conditionRegion(south);
		//... hide the connected label:
		south.getLabel().setTextColor(new Color(255, 255, 0, 0));
		south.setLocation(new Point(950, 1986));
		defaultLayer.addObjectAtTail(south);
		//... add label here
//		JGoTextNode tn = new JGoTextNode("Southern");
		TextNode tn2 = new TextNode("Southern");
		tn2.setBrush(JGoBrush.makeStockBrush(new Color(255, 255, 0, 0))); //color does not matter when alpha = 0
		tn2.setPen(JGoPen.makeStockPen(new Color(255, 255, 0, 0))); //color does not matter when alpha = 0
		tn2.setSelectable(false);
		tn2.setLocation(900, 2000);
		defaultLayer.addObjectAtTail(tn2);

//CB no scrollbars on background!		setBackgroundImage(backgroundImage);
		// SO create a JGoImage
		JGoImage image = new JGoImage();
		image.setImage(backgroundImage);
		image.setBoundingRect(new Point(0, 0), new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));
//		getDocument().addLayerBefore(defaultLayer);  //only objects on layer are transparent, NOT layer itself!!!
//		JGoLayer imageLayer = getDocument().getFirstLayer();
//		imageLayer.addObjectAtTail(image);
		defaultLayer.addObjectAtHead(image);
//		defaultLayer.setTransparency(0.25f); //set layer translucency - NO - it sets it for the background image too!  Went to object color translucency
		zoomNormal();
	}

	private void conditionRegion(JGoBasicNode node) {
		node.setAutoResize(false);
		node.setDraggable(false);
		if (node.getLabel() != null) {
			node.getLabel().setFontSize(14);
			node.getLabel().setSelectable(false);
			node.getLabel().setWrapping(false);
			node.getLabel().setBold(true);
			node.getLabel().setBkColor(new Color(255, 255, 255, 0));   //transparent white
			node.setLabelSpot(JGoObject.Center);
		}
		node.setSelectable(true);
	}


/*	void initMenus() {
		// ==============================================================
		// Define all the command actions and setup the menus
		// ==============================================================
		JMenuItem item = null;

		viewmenu.setText("View");
		viewmenu.setMnemonic('V');

		item = viewmenu.add(ZoomNormalAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,
				Event.CTRL_MASK | Event.SHIFT_MASK));
		item.setMnemonic('N');

		item = viewmenu.add(ZoomInAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,
				Event.CTRL_MASK));
		item.setMnemonic('I');
		item.setIcon(null); // choose not to use icon in menu

		item = viewmenu.add(ZoomOutAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,
				Event.SHIFT_MASK));
		item.setMnemonic('O');
		item.setIcon(null); // choose not to use icon in menu

		item = viewmenu.add(ZoomToFitAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		item.setMnemonic('Z');

		viewmenu.addSeparator();

		viewmenu.add(OverviewAction).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK));

		mainMenuBar.add(viewmenu);

		// Help menu
		helpmenu.setText("Help");
		helpmenu.setMnemonic('H');
		// mainMenuBar.add(helpmenu);
		setJMenuBar(mainMenuBar);
	} */


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

	SchematicRelatedAction ZoomToFitAction = new SchematicRelatedAction("Zoom To Fit", this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomToFit();
		}
	};

	SchematicRelatedAction ZoomNormalAction = new SchematicRelatedAction("Normal Zoom", this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomNormal();
		}
	};

	SchematicRelatedAction ZoomInAction = new SchematicRelatedAction("Zoom In",
			Schematic.createIconImage("images/ZoomIn24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomIn();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getScale() < 8.0f);
		}
	};

	SchematicRelatedAction ZoomOutAction = new SchematicRelatedAction("Zoom Out",
			Schematic.createIconImage("images/ZoomOut24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomOut();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getScale() > 0.13f);   //CB TO DO:  decrase this number?
		}
	};

	// creating a SchematicView without specifying a document in the constructor
	// needs to create a SchematicDocument rather than a generic JGoDocument
/*CB not used	public JGoDocument createDefaultModel() {
		return new SchematicDocument();
	} */

	// convenience method--the return value is a SchematicDocument instead
	// of a JGoDocument
	SchematicDocument getDoc() {
		System.out.println(getDocument().getClass());
		return (SchematicDocument) getDocument();
	}

	Schematic getApp() {
		return _app;
	}

	// an example of how to implement popup menus
	public boolean doMouseDown(int modifiers, Point dc, Point vc) {
		return super.doMouseDown(modifiers, dc, vc);
	}

	/**
	 *
	 */
	public boolean doMouseUp(int modifiers, Point dc, Point vc) {
		myMouseUpDocPoint.x = dc.x;
		myMouseUpDocPoint.y = dc.y;
		JGoObject obj = pickDocObject(dc, true);
		if (getCurrentMouseEvent() != null) {
			if (obj != null) { //obj under mouse
				if (obj instanceof JGoBasicNode) {  //CB TODO need this check?
					String name = ((JGoBasicNode)obj).getText();
					if (_regionToNodenameMap.get(name.trim()) != null) {
						JGoBasicNode node = _app.getCurrentView().getDoc().retrieveNode(_regionToNodenameMap.get(name.trim()));
						if (node != null) {
							getSelection().clearSelection();
							getSelection().extendSelection(node);
							Point nodeLocation = node.getLocation();
							double extentWidth = _app.getCurrentView().getExtentSize().width;
							double extentHeight = _app.getCurrentView().getExtentSize().height;
							_app.getCurrentView().setViewPosition(new Point((int)(nodeLocation.x - extentWidth/2), (int)(nodeLocation.y - extentHeight/2)));
							return true;
						} else {
							JOptionPane.showMessageDialog(this, "Make sure .svg file is open",
									"Region Node Not Found", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
		// otherwise implement the default behavior
		return super.doMouseUp(modifiers, dc, vc);  //CB TODO or return false????????????????
	}

	SchematicRelatedAction insertPointAction = new SchematicRelatedAction("Insert Point", getApp()) {
		public void actionPerformed(ActionEvent e) {
			insertPointIntoLink();
		}

		public boolean canAct() {
			// return super.canAct() && getView().getDoc().isModifiable();
			if (getView() != null && getView().getDoc() != null)
				return super.canAct() && getView().getDoc().isModifiable();
			else
				return false;
		}
	};

	SchematicRelatedAction removeSegmentAction = new SchematicRelatedAction("Remove Segment", getApp()) {
		public void actionPerformed(ActionEvent e) {
			removeSegmentFromLink();
		}

		public boolean canAct() {
			// return super.canAct() && getView().getDoc().isModifiable();
			if (getView() != null && getView().getDoc() != null)
				return super.canAct() && getView().getDoc().isModifiable();
			else
				return false;
		}
	};

	// popup menu commands
	void insertPointIntoLink() {
		if (getSelection().getPrimarySelection() instanceof JGoLink) {
			JGoLink s = (JGoLink) getSelection().getPrimarySelection();
			int i = s.getSegmentNearPoint(myMouseUpDocPoint);
			if (s.getNumPoints() > 3) {
				if (i < 1)
					i = 1; // don't add to first segment
				else if (i >= s.getNumPoints() - 2)
					i = s.getNumPoints() - 3; // don't add to last segment
			}
			Point a = s.getPoint(i);
			Point b = s.getPoint(i + 1);
			Point closest = new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
			getDocument().startTransaction();
			s.insertPoint(i + 1, closest);
			if (s.isOrthogonal()) // when orthogonal, gotta insert two points
				s.insertPoint(i + 1, closest);
			getSelection().toggleSelection(s);
			selectObject(s);
			getDocument().endTransaction("inserted point into link stroke");
		}
	}

	void removeSegmentFromLink() {
		if (getSelection().getPrimarySelection() instanceof JGoLink) {
			JGoLink s = (JGoLink) getSelection().getPrimarySelection();
			int i = s.getSegmentNearPoint(myMouseUpDocPoint);
			getDocument().startTransaction();
			if (s.isOrthogonal()) { // will have at least 7 points
				// don't remove either first two or last two segments
				i = Math.max(i, 2);
				i = Math.min(i, s.getNumPoints() - 5);
				Point a = s.getPoint(i);
				Point b = s.getPoint(i + 1);
				s.removePoint(i);
				// to maintain orthogonality, gotta remove two points
				s.removePoint(i);
				// now fix up following point to maintain orthogonality
				// Point c = new Point(s.getPoint(i));
				Point c = new Point(s.getPoint(i).x, s.getPoint(i).y);
				if (a.x == b.x) {
					c.y = a.y;
				} else {
					c.x = a.x;
				}
				s.setPoint(i, c);
			} else { // will have at least 3 points
				i = Math.max(i, 1); // don't remove point 0
				i = Math.min(i, s.getNumPoints() - 2); // don't remove last
				// point
				s.removePoint(i);
			}
			getSelection().toggleSelection(s);
			selectObject(s);
			getDocument().endTransaction("removed segment from link stroke");
		}
	}

	// implement JGoViewListener
	// just need to keep the actions enabled appropriately
	// depending on the selection
	public void viewChanged(JGoViewEvent e) {
		// if the selection changed, maybe some commands need to
		// be disabled or re-enabled
//		System.out.println("event type = " + e.getHint());
		switch (e.getHint()) {
		case JGoViewEvent.UPDATE_ALL:
		case JGoViewEvent.SELECTION_GAINED:
		case JGoViewEvent.SELECTION_LOST:
		case JGoViewEvent.SCALE_CHANGED:
			SchematicRelatedAction.updateAllActions();
			break;
		case JGoViewEvent.CLIPBOARD_PASTED:  //CB added section to paste and in relation to the right-click location
//			System.out.println("copyPoint = (" + copyPoint.x + ", " + copyPoint.y + ")");
//			System.out.println("myMouseUpDocPoint = (" + myMouseUpDocPoint.x + ", " + myMouseUpDocPoint.y + ")");
			JGoListPosition nextPosition = getSelection().getFirstObjectPos();
			JGoObject nextObject;
			boolean containsVariable = false;  //CB added for triggering call to loadAllVariablesVector()
			JGoObject primary = getSelection().getPrimarySelection();
			if (primary == null) break;
			if (primary instanceof NetworkNode  //CB added for triggering call to loadAllVariablesVector()
					&& ((NetworkNode)primary).getType() == NetworkNode.VARIABLE)
				containsVariable = true;
			boolean containsValueNode = false;  //CB added for triggering call to loadNameToValueNodeHashtable()
			if (primary instanceof ValueNode)  //CB added for triggering call to loadNameToValueNodeHashtable()
				containsValueNode = true;
//			System.out.println("primarySelection Point = (" + primary.getLocation().x + ", " + primary.getLocation().y + ")");
			int diffX = myMouseUpDocPoint.x - primary.getLocation().x;
			int diffY = myMouseUpDocPoint.y - primary.getLocation().y;
			while (nextPosition != null) {
				nextObject = getSelection().getObjectAtPos(nextPosition);
				if (!containsVariable && nextObject instanceof NetworkNode  //CB added for triggering call to loadAllVariablesVector()
						&& ((NetworkNode)nextObject).getType() == NetworkNode.VARIABLE)
					containsVariable = true;
				if (!containsValueNode && nextObject instanceof ValueNode)  //CB added for triggering call to loadNameToValueNodeHashtable()
					containsValueNode = true;
				if (nextObject != null) {
						nextObject.setLocation(nextObject.getLocation().x + diffX, nextObject.getLocation().y + diffY);
				}
				nextPosition = getSelection().getNextObjectPos(nextPosition);
			}
			getSelection().clearSelection();
			if (containsVariable)
				getDoc().loadAllVariablesVector();
			if (containsValueNode)
				getDoc().loadNameToValueNodeHashtable();
			break;
		}
	}

	// the default place to put stuff if not dragged there
	public Point getDefaultLocation() {
		// to avoid constantly putting things in the same place,
		// keep shifting the default location
		if (myDefaultLocation != null) {
			myDefaultLocation.x += 10;
			myDefaultLocation.y += 10;
		}
		return myDefaultLocation;
	}

	public void setDefaultLocation(Point loc) {
		myDefaultLocation = loc;
	}

	void zoomIn() {
		double newscale = Math.rint(getScale() / 0.9f * 100f) / 100f;
		setScale(newscale);
	}

	void zoomOut() {
		double newscale = Math.rint(getScale() * 0.9f * 100f) / 100f;
		setScale(newscale);
	}

	void zoomNormal() {
		setScale(0.7d);
	}

	void zoomToFit() {
		double newscale = 1;
		if (!getDocument().isEmpty()) {
			double extentWidth = getExtentSize().width;
			double printWidth = getPrintDocumentSize().width;
			double extentHeight = getExtentSize().height;
			double printHeight = getPrintDocumentSize().height;
			newscale = Math.min((extentWidth / printWidth),
					(extentHeight / printHeight));
		}
		if (newscale > 2)
			newscale = 1;
		newscale *= getScale();
		setScale(newscale);
		setViewPosition(0, 0);
	}
}
