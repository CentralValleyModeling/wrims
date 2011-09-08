package wrims.schematic;

import com.nwoods.jgo.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JPopupMenu;
//import wrims.dss.DssFrame;

public class NetworkNode extends JGoBasicNode implements ActionListener, Serializable, Describable {
	//CB TO DO: NetworkNode class should be extended, instead of all the types of NetworkNode, but I
	//    did not write this, nor will I be allowed the time to do that overhaul any time soon, as usual.
	public static final int NETWORK = 1;

	public static final int DEMAND = 2;

	public static final int RESERVOIR = 3;

	public static final int RRESERVOIR = 4; //CB changed VRESERVOIR to RRESERVOIR

	public static final int URESERVOIR = 5; //CB added

	public static final int LRESERVOIR = 6; //CB added

	// These may just be areas instead with no real attributes
	public static final int POWER = 7;

	public static final int PUMPING = 8;

	public static final int DSA = 9;

	public static final int VARIABLE = 10;

	public static final int BOUNDARY = 11;

	public static final int PLANT = 12;  // Water treatment plant

	public static final int DWR = 13;

	public static final int TNODE = 14;

	public static final int VPOWER = 15;

	public static final int VPUMPING = 16;

	public static final int WASTE_PLANT = 17;  //CB added Wastewater treatment plant

	public static final int CLOSURE = 18; //CB added closure term symbol

	public static final int RESERVOIR_NOTUSED = 19; //CB added

	public static final int RRESERVOIR_NOTUSED = 20; //CB added

	public static final int URESERVOIR_NOTUSED = 21; //CB added

	public static final int LRESERVOIR_NOTUSED = 22; //CB added

	public static final int DEMAND_ALT = 23;  //CB added - I think to have i dark green?

	public static final int GWSTORAGE = 24;

	public static final int LCPSIMSTORAGE = 25;

	private int _ntype = 0;

	private boolean _isCAD = false;

//CB	private Color strokeColor = null; //CB This was previously not used much

//CB	private Color fillColor = null;   //CB This was previously not used much

//	private JGoPen pen = null;  //CB added, then commented out

//	private String _name = null;

	private String _description = "";  //CB TODO: need?????

	// CB tried private DSSFrame _frame; // CB added
//	private Schematic _schematic; // CB added
	// CB private AppAction _PlotAction = null;

	public NetworkNode() {
		super();
		// CB _frame = frame; // CB added
	}

	/**
	 * CB added
	 * @param label
	 */
	public NetworkNode(String label) {
		super(label);
	}

	// CB public NetworkNode(String label, int nodetype) {
	// CB tried public NetworkNode(String label, int nodetype, DSSFrame frame) {
	public NetworkNode(String label, int nodetype) {
//CB		super(label);
		this(label);  //CB changed
//		_name = label;
//		strokeColor = getColor("");
//		fillColor = getColor("");
		init(nodetype);
	}

	public NetworkNode(String label, int nodetype, boolean isitCAD) {
//CB		super(label);
		this(label);  //CB changed
//		_name = label;
		_isCAD = isitCAD;
//		strokeColor = getColor("");
//		fillColor = getColor("");
		init(nodetype);
		// CB _PlotAction = PlotAction;
	}

	/*
	 * CB public NetworkNode(String label, int nodetype, boolean isitCAD) {
	 * super(label); name = label; isCAD = isitCAD; strokeColor = getColor("");
	 * fillColor = getColor(""); init(nodetype); }
	 */

	public NetworkNode(String label, int nodetype, String sColor,
			String fColor) {
		super(label);
//		_name = label;
//		setPen(JGoPen.make(JGoPen.SOLID, 1, getColor(sColor))); //CB
//		setBrush(JGoBrush.make(JGoBrush.SOLID, getColor(fColor))); //CB
		init(nodetype, getColor(sColor), getColor(fColor)); //CB added colors
	}
	/**
	 * CB added
	 * @param label
	 * @param nodetype
	 * @param sColor
	 * @param fColor
	 */
	public NetworkNode(String label, int nodetype, Color sColor, Color fColor) {
		super(label);
//		_name = label;
//		setPen(JGoPen.make(JGoPen.SOLID, 1, sColor)); //CB
//		setBrush(JGoBrush.make(JGoBrush.SOLID, fColor)); //CB
		init(nodetype, sColor, fColor); //CB added colors
	}
	/**
	 * CB added.
	 * @param label
	 * @param nodetype
	 * @param sColor
	 * @param fColor
	 * @param penStyle
	 */
	public NetworkNode(String label, int nodetype, String sColor, String fColor, int penStyle) {
		this(label, nodetype, sColor, fColor);
		setPen(JGoPen.make(penStyle, 1, getStrokeColor()));
	}
	/**
	 * CB added
	 * @param label
	 * @param nodetype
	 * @param sColor
	 * @param fColor
	 * @param penStyle
	 */
	public NetworkNode(String label, int nodetype, Color sColor, Color fColor, int penStyle) {
		this(label, nodetype, sColor, fColor);
		setPen(JGoPen.make(penStyle, 1, getStrokeColor()));
	}
	/**
	 * CB added.
	 * @param label
	 * @param nodetype
	 * @param sColor
	 * @param fColor
	 * @param penStyle
	 * @param penSize
	 */
	public NetworkNode(String label, int nodetype, String sColor, String fColor, int penStyle, int penSize) {
		this(label, nodetype, sColor, fColor);
		setPen(JGoPen.make(penStyle, penSize, getStrokeColor()));
	}
	/**
	 * CB added.
	 * @param label
	 * @param nodetype
	 * @param sColor
	 * @param fColor
	 * @param penStyle
	 * @param penSize
	 */
	public NetworkNode(String label, int nodetype, Color sColor, Color fColor, int penStyle, int penSize) {
		this(label, nodetype, sColor, fColor);
		setPen(JGoPen.make(penStyle, penSize, getStrokeColor()));
	}

	// CB public AppAction getPlotAction() {
	// return _PlotAction;
	// }

	/**
	 * CB added because I had to due to adding a non-primative instance varaible.
	 */
	public void writeObject(ObjectOutputStream stream) {
		try {
			stream.defaultWriteObject();
//			stream.writeObject(_description);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * CB added because I had to due to adding a non-primitive instance variable.
	 */
	public void readObject(ObjectInputStream stream) {
		try {
			stream.defaultReadObject();
//			_description = (String)stream.readObject();
//			System.out.println(_description);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	/**
	 * CB added.
	 */
	public void setDescription(String description) {
		_description = description;
	}

	/**
	 * CB added.
	 */
	public String getDescription() {
		return _description;
	}

	public Color getColor(String scolor) {
		Color clr = null;
		if (scolor.equals("red"))
			clr = Color.red;
		else if (scolor.equals("blue"))
			clr = Color.blue;
		else if (scolor.equals("cyan"))
			clr = Color.cyan;
		else if (scolor.equals("gold"))
			clr = Color.yellow;
		else if (scolor.equals("green"))
			clr = Color.green;
		else if (scolor.equals(MainFrame.NODE_GREEN)) //CB replaced Color.GREEN
			clr = Color.green;
		else if (scolor.equals("maroon"))
			clr = Color.magenta;
		else if (scolor.equals("silver"))
			clr = Color.gray;
		else if (scolor.equals("#0cf"))
			clr = Color.cyan;
	    else if (scolor.equals("yellow"))  //CB added.  need????????  need the method??????
	    	clr = Color.yellow;
	    //CB need block for Schematic.VIOLET?
		else
			clr = Color.black;
		return clr;
	}
	/**
	 * CB added.
	 * @param color the brush or stroke or border color
	 */
	void setStrokeColor(Color color) {
		setPen(JGoPen.make(getPen().getStyle(),getPen().getWidth(), color));
	}

	/**
	 * CB added.
	 * @return the brush or stroke or border color
	 */
	public Color getStrokeColor() {
		return getPen().getColor();
	}

	/**
	 * CB added.
	 * @param style the integer style.
	 */
	void setStrokeStyle(int style) {
		setPen(JGoPen.make(style,getPen().getWidth(),getPen().getColor()));
	}

	/**
	 * CB added.
	 * @return the style value.
	 */
	public int getStrokeStyle() {
		return getPen().getStyle();
	}

	/**
	 * CB added.
	 * @param color the fill (inside) color
	 */
	void setFillColor(Color color) {
		setBrush(JGoBrush.makeStockBrush(color));
	}

	/**
	 * CB added.
	 * @return fill (inside) color
	 */
	public Color getFillColor() {
		if (getBrush() == null) return null;
		else return getBrush().getColor();
	}

	public void init(int nodetype, boolean isitCAD) {
		_isCAD = isitCAD;
		init(nodetype);
	}

	/**
	 * CB added.
	 * @param nodetype
	 */
	public void init(int nodetype) {
		init(nodetype, Color.black, Color.black);
	}

//CB	public void init(int nodetype) {
	public void init(int nodetype, Color strokeColor, Color fillColor) { //CB
		_ntype = nodetype;

		JGoObject shape = null;
		JGoPen pen = JGoPen.make(JGoPen.SOLID, 2, Color.black);

		JGoText text = getLabel();
//		text.setBold(true);  // causes NullPointerException

		if (nodetype == NETWORK) {
			shape = new JGoEllipse();
//			shape = new JGoRoundRect(); //CB trying for circle
//			shape.setSize(new Dimension(40,40));  //CB does nothing to ellipse TRYING TO MAKE IT A CIRCLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//			((JGoRoundRect)shape).setArcDimension(new Dimension(30,30));  //CB does nothing to JGoRoundRect TRYING TO MAKE IT A CIRCLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//			shape = new JGoEllipse(new Point(0,0), new Dimension(400,400));  //CB does nothing to JGoRoundRect TRYING TO MAKE IT A CIRCLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			setDrawable((JGoDrawable) shape);
//			int width = shape.getWidth();
//			int height = shape.getHeight();
//			((JGoEllipse)shape).setBoundingRect(0, 0, 40, 40);  //CB does nothing to ellipse TRYING TO MAKE IT A CIRCLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//			width = shape.getWidth();
//			height = shape.getHeight();
//			shape.setSize(40,40);  //CB does nothing to ellipse TRYING TO MAKE IT A CIRCLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// setAutoResize(false);
			// setResizable(false);
			if (text != null) {
				text.setWrapping(true);
				text.setWrappingWidth(30);
				text.setFontSize(10);
				text.setBold(true);
			}
//			width = shape.getWidth();
//			height = shape.getHeight();
//CB			if (strokeColor != null)
//CB				pen = JGoPen.make(JGoPen.SOLID, 1, strokeColor);
			setToolTipText("River/Channel Node");
			setPen(pen);
		} else if (nodetype == VARIABLE) { //CB added "else" to speed it up   //CB TODO: should be more aspects for colors, etc. or more node type instead of defining in Schematic class!
			shape = new JGoRectangle(new Rectangle(30, 30));
			setDrawable((JGoDrawable) shape);
//CB			pen = JGoPen.make(JGoPen.SOLID, 1, Color.blue);
//CB			if (strokeColor != null)
//CB				pen = JGoPen.make(JGoPen.SOLID, 1, strokeColor);
			if (text != null) {
				// text.setTextColor(Color.blue);
//CB				text.setTextColor(strokeColor);
				text.setFontSize(10);
				text.setBold(true);
			}
			setPen(pen);
		} else if (nodetype == RESERVOIR || nodetype == RESERVOIR_NOTUSED) { //CB added "else" to speed it up and || for unimplemented reservoirs
			JGoPolygon pg = new JGoPolygon();
			if (_isCAD) {
				pg.addPoint(new Point(0, 30));
				pg.addPoint(new Point(40, 30));
				pg.addPoint(new Point(20, 0));
				pg.addPoint(new Point(0, 30));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == RESERVOIR) {
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLUE));
					setBrush(JGoBrush.makeStockBrush(Color.WHITE));
					text.setTextColor(Color.BLUE);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			} else {
				pg.addPoint(new Point(0, 60));
				pg.addPoint(new Point(120, 60));
				pg.addPoint(new Point(60, 0));
				pg.addPoint(new Point(0, 60));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == RESERVOIR) { //CB added NOTUSED code
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.CYAN)); //CB changed from BLUE
					setBrush(JGoBrush.makeStockBrush(Color.CYAN));
					text.setTextColor(Color.BLACK);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			}
			setAutoResize(false);
			// setResizable(false);
			text.setWrapping(true);
			text.setWrappingWidth(20);
			text.setBold(true);
//			setLabelSpot(JGoObject.BottomCenter);  // no visible effect
// 			setLabelSpot(JGoObject.Bottom);  // no visible effect
		} else if (nodetype == RRESERVOIR || nodetype == RRESERVOIR_NOTUSED) { //CB added "else" to speed it up and || for unimplemented reservoirs; changed VRESERVOIR to RRESERVOIR
			JGoPolygon pg = new JGoPolygon();
			if (_isCAD) { //CB added if
				pg.addPoint(new Point(0, 0));
				pg.addPoint(new Point(0, 40));
				pg.addPoint(new Point(30, 20));
				pg.addPoint(new Point(0, 0));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == RRESERVOIR) {
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLUE)); //CB changed from BLUE
					setBrush(JGoBrush.makeStockBrush(Color.WHITE));
					text.setTextColor(Color.BLUE);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			} else { //CB added CalSim III type section
				pg.addPoint(new Point(0, 0));
				pg.addPoint(new Point(0, 120));
				pg.addPoint(new Point(60, 60));
				pg.addPoint(new Point(0, 0));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == RRESERVOIR) { //CB added NOTUSED code
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.CYAN)); //CB changed from BLUE
					setBrush(JGoBrush.makeStockBrush(Color.CYAN));
					text.setTextColor(Color.BLACK);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			}
			setAutoResize(false);
			text.setWrapping(true);
			text.setWrappingWidth(20);
		} else if (nodetype == URESERVOIR || nodetype == URESERVOIR_NOTUSED) {//CB added "else" to speed it up and || for unimplemented reservoirs; added section for "upside-down" reservoir
			JGoPolygon pg = new JGoPolygon();
			if (_isCAD) { //CB added if
				pg.addPoint(new Point(0, 0));
				pg.addPoint(new Point(40, 0));
				pg.addPoint(new Point(20, 30));
				pg.addPoint(new Point(0, 0));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == URESERVOIR) {
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLUE)); //CB changed from BLUE
					setBrush(JGoBrush.makeStockBrush(Color.WHITE));
					text.setTextColor(Color.BLUE);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			} else { //CB added CalSim III type section
				pg.addPoint(new Point(0, 0));
				pg.addPoint(new Point(60, 60));
				pg.addPoint(new Point(120, 0));
				pg.addPoint(new Point(0, 0));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == URESERVOIR) { //CB added NOTUSED code
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.CYAN)); //CB changed from BLUE
					setBrush(JGoBrush.makeStockBrush(Color.CYAN));
					text.setTextColor(Color.BLACK);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			}
			setAutoResize(false);
			text.setWrapping(true);
			text.setWrappingWidth(20);
			// setLabelSpot(JGoObject.Left);
		} else if (nodetype == LRESERVOIR || nodetype == LRESERVOIR_NOTUSED) {//CB added "else" to speed it up and || for unimplemented reservoirs; added LRESERVOIR section for  left-pointing reservoir
			JGoPolygon pg = new JGoPolygon();
			if (_isCAD) { //CB added if
				pg.addPoint(new Point(0, 20));
				pg.addPoint(new Point(30, 0));
				pg.addPoint(new Point(30, 40));
				pg.addPoint(new Point(0, 20));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == LRESERVOIR) {
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLUE)); //CB changed from BLUE
					setBrush(JGoBrush.makeStockBrush(Color.WHITE));
					text.setTextColor(Color.BLUE);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			} else { //CB added CalSim III type section
				pg.addPoint(new Point(0, 60));
				pg.addPoint(new Point(60, 0));
				pg.addPoint(new Point(60, 120));
				pg.addPoint(new Point(0, 60));
				shape = (JGoObject) pg;
				setDrawable((JGoDrawable) shape);
				if (nodetype == LRESERVOIR) { //CB added NOTUSED code
					setToolTipText("Reservoir");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.CYAN)); //CB changed from BLUE
					setBrush(JGoBrush.makeStockBrush(Color.CYAN));
					text.setTextColor(Color.BLACK);
				} else {
					setToolTipText("Reservoir (not implemented)");
					setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
					setBrush(JGoBrush.makeStockBrush(Color.BLACK));
					text.setTextColor(Color.WHITE);
				}
			}
			setAutoResize(false);
			text.setWrapping(true);
			text.setWrappingWidth(20);
			// setLabelSpot(JGoObject.Left);
		} else if (nodetype == GWSTORAGE) { //CB added section
			JGoPolygon pg = new JGoPolygon();
			pg.addPoint(new Point(0, 30));
			pg.addPoint(new Point(40, 30));
			pg.addPoint(new Point(20, 0));
			pg.addPoint(new Point(0, 30));
			shape = (JGoObject) pg;
			setDrawable((JGoDrawable) shape);
			setToolTipText("Groundwater Storage");
			setPen(JGoPen.make(JGoPen.SOLID, 2, Color.MAGENTA));
			setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			text.setTextColor(Color.MAGENTA);
			setAutoResize(false);
			// setResizable(false);
			text.setWrapping(true);
			text.setWrappingWidth(20);
			text.setBold(true);
//			setLabelSpot(JGoObject.BottomCenter);  // no visible effect
// 			setLabelSpot(JGoObject.Bottom);  // no visible effect
		} else if (nodetype == LCPSIMSTORAGE) { //CB added section
			JGoPolygon pg = new JGoPolygon();
			pg.addPoint(new Point(0, 30));
			pg.addPoint(new Point(40, 30));
			pg.addPoint(new Point(20, 0));
			pg.addPoint(new Point(0, 30));
			shape = (JGoObject) pg;
			setDrawable((JGoDrawable) shape);
			setToolTipText("LCPSIM Storage");
			setPen(JGoPen.make(JGoPen.SOLID, 2, MainFrame.VIOLET));
			setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			text.setTextColor(MainFrame.VIOLET);
			setAutoResize(false);
			// setResizable(false);
			text.setWrapping(true);
			text.setWrappingWidth(20);
			text.setBold(true);
//			setLabelSpot(JGoObject.BottomCenter);  // no visible effect
// 			setLabelSpot(JGoObject.Bottom);  // no visible effect
		} else if (nodetype == PLANT) { //CB added "else" to speed it up
			text.setWrapping(true);
			if (_isCAD) { //CB added if
//CB				if (name.startsWith("WTP")) {
					shape = new JGoRectangle(new Rectangle(30, 10));
					setDrawable((JGoDrawable) shape);
					text.setWrappingWidth(30);
					setToolTipText("WTP");
					setPen(pen);
/*CB				} else {
					JGoRoundRect rr = new JGoRoundRect();
					rr.setBrush(JGoBrush.makeStockBrush(Color.magenta));
					rr.setPen(JGoPen.make(JGoPen.SOLID, 1, Color.magenta));
					setDrawable((JGoDrawable) rr);
					// text.setWrappingWidth(40);
					setToolTipText("Waste Treatment Plant");
					setPen(pen);
				}*/
			} else { //CB added section
//CB				if (name.startsWith("WTP")) {
					shape = new JGoRectangle(new Rectangle(30, 10));
					setDrawable((JGoDrawable) shape);
					text.setWrappingWidth(30);
					setToolTipText("WTP");
					setPen(pen);
/*CB				} else {
					JGoRectangle rr = new JGoRectangle(); //CB
					rr.setBrush(JGoBrush.makeStockBrush(Color.decode("#888800"))); //CB
					rr.setPen(JGoPen.make(JGoPen.SOLID, 1, Color.BLACK));
					setDrawable((JGoDrawable) rr);
					// text.setWrappingWidth(40);
					setToolTipText("Waste Treatment Plant");
					setPen(pen);
				} */
			}
		} else if (nodetype == WASTE_PLANT) { //CB added section
			text.setWrapping(false);
			if (_isCAD) { //CB added if
				JGoRoundRect rr = new JGoRoundRect();
				rr.setBrush(JGoBrush.makeStockBrush(Color.magenta));
				rr.setPen(JGoPen.make(JGoPen.SOLID, 1, Color.magenta));
				setDrawable((JGoDrawable)rr);
				setToolTipText("Waste Treatment Plant");
				setPen(pen);
			} else { //CB added section
				JGoRectangle rr = new JGoRectangle(); //CB
				rr.setBrush(JGoBrush.makeStockBrush(Color.decode("#CCCC99"))); //CB
				rr.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
				setDrawable((JGoDrawable)rr);
				setToolTipText("Waste Treatment Plant");
				setPen(pen);
			}
		} else if (nodetype == CLOSURE) { //CB added section
			text.setWrapping(false);
			//CB added section
			JGoRectangle rr = new JGoRectangle(); //CB
			text.setTextColor(Color.WHITE);
			rr.setBrush(JGoBrush.makeStockBrush(Color.GRAY)); //CB
			rr.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
			setDrawable((JGoDrawable)rr);
			setToolTipText("Closure Term");
			setPen(pen);
		} else if (nodetype == DEMAND) { //CB added "else" to speed it up
			if (_isCAD) { //CB added if check
				JGoRectangle rect = new JGoRectangle(new Rectangle(40, 28));
				// if (fillColor != null)
				// rect.setBrush(JGoBrush.makeStockBrush(fillColor));
				setDrawable((JGoDrawable) rect);
				// setAutoResize(false);
//CB				pen = JGoPen.make(JGoPen.SOLID, 1, Color.green);
				pen = JGoPen.make(JGoPen.SOLID, 2, Color.GREEN);  //CB
//CB?				pen = JGoPen.make(JGoPen.SOLID, 2, strokeColor);  //CB
				text.setWrapping(true);
				text.setWrappingWidth(270);
			} else {
				JGoRectangle rect = new JGoRectangle(new Rectangle(0, 50));
				// if (fillColor != null)
				// rect.setBrush(JGoBrush.makeStockBrush(fillColor));
				shape = rect; //CB added
//CB				setDrawable((JGoDrawable) rect);
				setDrawable((JGoDrawable) shape);
				// setAutoResize(false);
//CB				pen = JGoPen.make(JGoPen.SOLID, 2, Color.green);
				pen = JGoPen.make(JGoPen.SOLID, 2, strokeColor);
				setBrush(JGoBrush.makeStockBrush(fillColor)); //CB added
				text.setWrapping(true);
				text.setWrappingWidth(80);
				text.setResizable(true); //CB trying for allowing resizing - maybe cannot when text wrapping is used
				text.setBold(true);
			}
			setPen(pen);
			setToolTipText("Demand Node");
		} else if (nodetype == DEMAND_ALT) { //CB added section
			if (_isCAD) { //CB added if check
				JGoRectangle rect = new JGoRectangle(new Rectangle(40, 28));
				// if (fillColor != null)
				// rect.setBrush(JGoBrush.makeStockBrush(fillColor));
				setDrawable((JGoDrawable) rect);
				// setAutoResize(false);
//CB				pen = JGoPen.make(JGoPen.SOLID, 1, Color.green);
				pen = JGoPen.make(JGoPen.SOLID, 2, MainFrame.ARC_GREEN);  //CB
//CB?				pen = JGoPen.make(JGoPen.SOLID, 2, strokeColor);  //CB
				text.setWrapping(true);
				text.setWrappingWidth(120);
			}
			setPen(pen);
			setToolTipText("Demand Node");
		} else if (nodetype == BOUNDARY) { //CB added "else" to speed it up
//			shape = new JGoRectangle(new Rectangle(30, 30)); works, butt...
//			setDrawable((JGoDrawable) shape);    works, but...
			setDrawable(new JGoRectangle(new Rectangle(30, 30))); //CB more brief
			// pen = JGoPen.make(JGoPen.SOLID, 1, Color.cyan);
			setPen(pen);
//CB			if (fillColor != null)
//CB				setBrush(JGoBrush.makeStockBrush(fillColor));
			text.setWrapping(true);
			text.setWrappingWidth(100);
			setToolTipText("Boundary");
		} else if (nodetype == POWER) { //CB added "else" to speed it up
			shape = new JGoRectangle(new Rectangle(40, 10));
			setDrawable((JGoDrawable) shape);
			setPen(pen);
			setBrush(JGoBrush.makeStockBrush(Color.black));
			setToolTipText("Power Plant");
		} else if (nodetype == VPOWER) { //CB added "else" to speed it up
			shape = new JGoRectangle(new Rectangle(10, 40));
			setDrawable((JGoDrawable) shape);
			setPen(pen);
			setBrush(JGoBrush.makeStockBrush(Color.black));
			setToolTipText("Power Plant");
		} else if (nodetype == PUMPING) { //CB added "else" to speed it up
			shape = new JGoRectangle(new Rectangle(40, 10));
			setDrawable((JGoDrawable) shape);
			setPen(pen);
			setToolTipText("Pumping Plant");
		} else if (nodetype == VPUMPING) { //CB added "else" to speed it up
			shape = new JGoRectangle(new Rectangle(10, 40));
			setDrawable((JGoDrawable) shape);
			setPen(pen);
			setToolTipText("Pumping Plant");
		} else if (nodetype == DWR) { //CB added "else" to speed it up
			JGoPolygon pg = new JGoPolygon();
/*CB			pg.setBrush(JGoBrush.makeStockBrush(Color.white));
			pg.addPoint(new Point(0, 25));
			pg.addPoint(new Point(5, 50));
			pg.addPoint(new Point(45, 40));
			pg.addPoint(new Point(45, 10));
			pg.addPoint(new Point(5, 0));
			pg.addPoint(new Point(0, 25)); */
			//CB made it a regular pentagon with bottom side horizontal
			pg.setBrush(JGoBrush.makeStockBrush(Color.white));
			pg.addPoint(new Point(0, 18));
			pg.addPoint(new Point(25, 0));
			pg.addPoint(new Point(50, 18));
			pg.addPoint(new Point(41, 48));
			pg.addPoint(new Point(10, 48));
			pg.addPoint(new Point(0, 18));
			shape = (JGoDrawable) pg;
			setDrawable((JGoDrawable) shape);
			setPen(pen);
			setAutoResize(false);
			text.setWrapping(true);
			text.setWrappingWidth(40);
			text.setFontSize(10);
			setToolTipText("DWR PS");
			shape = (JGoDrawable) pg;
			setDrawable((JGoDrawable) shape);
			setPen(pen);
			setAutoResize(false);
			text.setWrapping(true);
			text.setWrappingWidth(40);
			text.setFontSize(10);
			setToolTipText("DWR PS");
		} else if (nodetype == DSA) { //CB added "else" to speed it up
			JGoPolygon pg = new JGoPolygon();
			pg.setBrush(JGoBrush.makeStockBrush(Color.black));
			pg.addPoint(new Point(0, 15));
			pg.addPoint(new Point(15, 30));
			pg.addPoint(new Point(30, 15));
			pg.addPoint(new Point(15, 0));
			pg.addPoint(new Point(0, 15));
			shape = (JGoDrawable) pg;
			setDrawable((JGoDrawable) shape);
			setPen(pen);
			setBrush(JGoBrush.makeStockBrush(Color.black));
			setToolTipText("DSA Outflow Point");
		} else if (nodetype == TNODE) { //CB added "else" to speed it up
			text.setEditable(true);
			text.setMultiline(true);
			text.setFontSize(12);
			text.setAlignment(JGoText.ALIGN_LEFT);
			// text.setWrappingWidth(60);
			text.setMultiline(true);
			setLabelSpot(JGoObject.Center);
			pen = JGoPen.make(JGoPen.SOLID, 1, Color.white);
			setPen(pen);
			setDrawable(new JGoRectangle());
		}
		// JGoText text = getLabel();
		if (text != null) {
			// text.setEditable(true);
			text.setMultiline(true);
			text.setBold(true);
		}
//CB moved to specific sections		setPen(pen);
		setLabelSpot(JGoObject.Center);

//		JGoPen pencheck = getPen();

		System.out.print("");  //debugging
	}

	public int getType() {
		return _ntype;
	}

	// Only variables in DSS are Reservoirs "S"  //CB No. Tom made CalSim III arc names as NetworkNode type, so if type == VARIABLE, also in dss
	public String getVariable() {
		if (_ntype == VARIABLE) //CB added if/else structure and if block
			return getText();
		else
//CB			return ("S" + ((JGoText) getLabel()).getText());
			return "S_" + getText().toUpperCase();  //CB simpler and need uppercase (currently)
	}

	public boolean isPlotable() {
		boolean plotable = false;

		switch (_ntype) {
		case RESERVOIR:
		case RRESERVOIR:  //CB changed VRESERVOIR to RRESERVOIR
		case LRESERVOIR:  //CB added LRESERVOIR
		case URESERVOIR:  //CB added URESERVOIR
//		case RESERVOIR_NOTUSED:   //CB added
//		case RRESERVOIR_NOTUSED:  //CB added
//		case LRESERVOIR_NOTUSED:  //CB added
//		case URESERVOIR_NOTUSED:  //CB added
		case VARIABLE:    //CB added VARIABLE here
			plotable = true;
			break;
		default:
			plotable = false;
			break;
		}
		if (plotable)
			if (getVariable().equals("S0")) //CB huh!????
				plotable = false;

		return plotable;
	}

	public JPopupMenu getPopup() {
		JPopupMenu popup = null;
		// System.out.println("getPopup: "+ntype+" ");
		if (_ntype == RESERVOIR || _ntype == RRESERVOIR || _ntype == LRESERVOIR
				|| _ntype == URESERVOIR || _ntype == RESERVOIR_NOTUSED
				|| _ntype == RRESERVOIR_NOTUSED || _ntype == LRESERVOIR_NOTUSED
				|| _ntype == URESERVOIR_NOTUSED) //CB
			popup = new ResPopup(this).getPopup();
//		else if (ntype == RRESERVOIR)  //CB
//			popup = new ResPopup(this).getPopup();
		else if (_ntype == DEMAND)
			popup = new DemPopup(this).getPopup();
		else if (_ntype == VARIABLE)
			popup = new ChanPopup(this).getPopup();
		else
			popup = new NodePopup(this).getPopup();
		return popup;
	}

	// Events
	public void actionPerformed(ActionEvent e) {
		// JMenuItem source = (JMenuItem)(e.getSource());
		// String s = " Event source: " + source.getText();
		// System.out.println(s + "\n");
	}

	public boolean doMouseDblClick(int modifiers, Point dc, Point vc,
			JGoView view) {
		if (view instanceof SchematicView)
			((SchematicView) view).editNetworkNode(this);
		return true;
	}

	// file
	public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup) {
		// Add Arc element
		DomElement jGoNetworkNode = svgDoc.createJGoClassElement(
				"wrims.schematic.NetworkNode", jGoElementGroup);
		jGoNetworkNode.setAttribute("ntype", Integer.toString(_ntype));
		jGoNetworkNode.setAttribute("description", _description); //CB added on 11/24/2008
		// Have superclass add to the JGoObject group
		super.SVGWriteObject(svgDoc, jGoElementGroup);
	}

	public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc,
			DomElement svgElement, DomElement jGoChildElement) {
		if (jGoChildElement != null) {
			_ntype = Integer.parseInt(jGoChildElement.getAttribute("ntype"));
			_description = jGoChildElement.getAttribute("description"); //CB added on 11/24/2008
			super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());
		}
		return svgElement.getNextSibling();
	}

	// copy
	public JGoObject copyObject(JGoCopyEnvironment env) {
		if (!MainFrame.IS_DEVELOPER) return null;  //CB added
		NetworkNode newobj = (NetworkNode) super.copyObject(env);
		if (newobj != null) {
			// the ID should *not* be copied blindly--leave as -1 so
			// that we can fix it up later in ownerChange
			// the JGoObjects that are part of this area are copied
			// separately by copyChildren()
			newobj._ntype = _ntype;
//			newobj._isCAD = _isCAD;
//			newobj._name = _name;
			newobj._description = _description;  //CB uncommented on 11/24/2008
			// no other fields to copy--the Text is actually on a sub-object  (EVEN THE DESCRIPTION????)
		}
		return newobj;
	}

}
