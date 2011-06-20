package wrims.schematic;

import javax.swing.*;
import com.nwoods.jgo.*;
import java.awt.*;

public class Arc extends JGoLabeledLink implements Describable {

	public static final int RIVER = 1;  //CB changed CHANNEL to RIVER

	// static final int RECHARGE = 2;
	public static final int INFLOW = 3;

	public static final int DIVERSION = 4;

	public static final int GWRECHARGE = 5;

	public static final int RETURN = 6;

	public static final int GWSW = 7;

	public static final int GWGW = 8;

	public static final int GWPUMPING = 9;

	public static final int SPILL = 10; //CB added?

	public static final int CHANNEL = 11; //CB added

	public static final int FUTURE = 12; //CB added

	public static final int OLD_TO_NEW = 13; //CB added

	public static final int BYPASS = 14; //CB added

	public static final int LCPSIM = 15; //CB added

	public static final int MODULE_BOUNDARY = 16;  //CB added

	public static final int LCPSIM_DASHED = 17;  //CB added

	private boolean split = false;

	int arcType = 0;

	private String _description = "";  //CB added

	public Arc() {
		super();
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}

	public Arc(JGoPort from, JGoPort to, boolean isLabelled) { //CB added boolean argument
		super(from, to);
		if (isLabelled) {
			JGoLinkLabel text = new JGoLinkLabel("");
			text.setAlignment(JGoText.ALIGN_CENTER);
			text.setSelectable(true);
			text.setEditable(true);
			text.setEditOnSingleClick(true);  //TODO: CB need to put in above if/else block??
			text.setTransparent(false);
			text.setBkColor(new Color(255, 255, 255, 200)); // translucent white
			setMidLabel(text);
		}
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}

	/**
	 * CB added to allow setting of type up front.
	 * @param from
	 * @param to
	 * @param isLabelled
	 * @param color
	 */
	public Arc(JGoPort from, JGoPort to, boolean isLabelled, int type) {
		this(from, to, isLabelled);
//		System.out.println("arc constructor type = " + type);
		setType(type);
	}

	/**
	 * CB added.
	 * @param from
	 * @param to
	 * @param isLabelled
	 * @param color
	 */
	public Arc(JGoPort from, JGoPort to, boolean isLabelled, Color color) {
		this(from, to, isLabelled);
		if (color.equals(Color.BLUE))
			setType(RIVER);
//		if () setType(RIVER);  //CB to do:  added DOTTED check here??  Add BYPASS and OLD_TO_NEW here??
//		else setType(FUTURE);
		else if (color.equals(Color.CYAN))
			setType(INFLOW);
		else if (color.equals(Color.RED))
			setType(DIVERSION);
		else if (color.equals(Schematic.ARC_GREEN))
			setType(RETURN);
		else if (color.equals(Schematic.YUCK))
			setType(DIVERSION);
		else if (color.equals(Color.CYAN))
			setType(INFLOW);
		else if (color.equals(Color.BLACK)) //CB added section?
			setType(SPILL);
		else if (color.equals(Color.GRAY)) //CB added section
			setType(CHANNEL);
		else if (color.equals(Color.MAGENTA)) //CB added section
			setType(GWGW);
		else if (color.equals(Schematic.VIOLET)) //CB added section
			setType(LCPSIM);
		else if (color.equals(Color.GREEN)) //CB added section
			setType(MODULE_BOUNDARY);
		else if (color.equals(Color.WHITE)) //CB added section
			setType(LCPSIM_DASHED);
		else
			JOptionPane.showMessageDialog(null, "Arc constructor color argument is not valid", "Bad Arc Color", JOptionPane.ERROR_MESSAGE);
//		System.out.println("color = " + color + " and arc constructor type = " + arcType);
	}

	public void initialize(String t, String desc) {
		// if (!desc.equals(""))
		// apparently no setToolTipText for JGoLink's
		// setToolTipText(desc);
		initialize(t);
	}

	public void initialize(String t) {
/*CB		if (t != null) //CB added if line to prevent text if not desired (TO DO: eliminate Link class and use Arc for CalSim III type instead of NetworkNode!)
			setText(t);
		setAvoidsNodes(true);
		setAdjustingStyle(JGoLink.AdjustingStyleStretch);
		setArrowHeads(false, true);
		setGrabChildSelection(false); // let the label be selectable */
		initialize(t, true); //CB added
	}

	/**
	 * CB added.
	 * @param t
	 * @param desc
	 * @param arrowAtEnd
	 */
	public void initialize(String t, String desc, boolean arrowAtEnd) {
		initialize(t, arrowAtEnd);
	}

	/**
	 * CB added.
	 * @param t  the label text
	 * @param arrowAtEnd
	 */
	public void initialize(String t, boolean arrowAtEnd) {
		initialize(t, arrowAtEnd, true);
	}

	/**
	 * CB added.
	 * @param t   the label text
	 * @param arrowAtEnd
	 * @param isOrthogonal
	 */
	public void initialize(String t, boolean arrowAtEnd, boolean isOrthogonal) {
		// CB moved bulk here from simpler initialize method
		//CB TO DO: eliminate Link class and use Arc for CalSim III type instead of NetworkNode!  IFF ARCS CAN HAVE MORE THAN TWO CONTROL POINTS (I.E., THEY CAN BEND!)
		if (t != null) { //CalSim II type
			setText(t);
			setArrowHeads(false, arrowAtEnd);
			setGrabChildSelection(true); // the label is selectable
		} else { // CalSim III type
			setAvoidsNodes(true);
			setJumpsOver(true);      //CB added
			set4ResizeHandles(true); //CB added
			setAdjustingStyle(JGoLink.AdjustingStyleStretch);
			setArrowHeads(false, arrowAtEnd);
			setOrthogonal(isOrthogonal); //CB added
			setRoundedCorners(true); //CB added
			setGrabChildSelection(false); // the label is NOT selectable
		}
//		System.out.println("is 4 resize handles = " + is4ResizeHandles()); //debugging
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

	public SchematicDocument getDoc() {
		return (SchematicDocument) getDocument();
	}

	public boolean isPlotable() {
		boolean plotable = true;

		switch (arcType) {
			case CHANNEL:
			case INFLOW:
			case DIVERSION:
			case GWPUMPING:
			case GWRECHARGE:
			case RETURN:
			case GWGW:
			case GWSW:
			case FUTURE: //CB added
			case OLD_TO_NEW: //CB added
			case BYPASS: //CB added
				break;
			default:
				plotable = false;
		}
		return plotable;
	}

	public NetworkNode getFromNode() {
		if (getFromPort() != null)
			if (getFromPort().getParent() instanceof NetworkNode) // CB added check to prevent ClassCastException
				return (NetworkNode) (getFromPort().getParent());
			else return null; //CB added line; maybe need to return the JGoBasicNode (an invisible node)
		return null;
	}

	public NetworkNode getToNode() {
		if (getToPort() != null) {
			if (getToPort().getParent() instanceof NetworkNode) // CB added check to prevent ClassCastException
				return (NetworkNode) (getToPort().getParent());
			else return null; //CB added line; maybe need to return the JGoBasicNode (an invisible node) for CalSim II?
		}
		return null;
	}

	// CB added here - probably needs work!
	public JPopupMenu getPopup() {
		JPopupMenu popup = null;
		// System.out.println("getPopup: "+ntype+" ");
		popup = new ChanPopup(this).getPopup();
		return popup;
	}

	// private JGoPen OutsidePen = JGoPen.make(JGoPen.SOLID, 3, Color.black);
	private JGoPen InsidePen = JGoPen.make(JGoPen.SOLID, 2, Color.white);   //CB changed width to 2

	// private JGoPen RegularPen = JGoPen.make(JGoPen.SOLID, 1, Color.black);
	private Color arccolor = null;

	private int arcstyle = 0;

	public void makeSplit() {
		setHighlight(JGoPen.make(arcstyle, 3, arccolor));
		setPen(InsidePen);

		// System.out.println( "L: "+getArrowLength());
		// System.out.println( "sL: "+getArrowShaftLength());
		// System.out.println( "W: "+getArrowWidth());

		setArrowLength(12.0);
		setArrowShaftLength(10.0);
		setArrowWidth(10.0);
	}

	public void makeUnSplit() {
		setPen(JGoPen.make(arcstyle, 2, arccolor));  //CB changed width to 2
		setHighlight(null);
		setArrowLength(10.0);
		setArrowShaftLength(8.0);
		setArrowWidth(8.0);
	}

	public boolean isSplit() {
		return split;
	}

	public void setSplit(boolean bFlag) {
		if (arccolor == null) {
			arccolor = getPen().getColor();
			arcstyle = getPen().getStyle();
		}

		if (bFlag && !split) {
			makeSplit();
		} else if (split) {
			makeUnSplit();
		}
		split = bFlag;
	}

	private void setLinkProperties(Color color, int style) {
//		System.out.println("setLinkProperties color = " + color);
		arccolor = color;
		arcstyle = style;
		setPen(JGoPen.make(style, 2, color));
		if (split) {
			makeSplit();
		} else
			makeUnSplit();

		setBrush(JGoBrush.make(JGoBrush.SOLID, color));
		JGoText obj = (JGoText) getMidLabel();
		if (obj != null) //CB added check
			obj.setTextColor(color);
	}

//CB	private void setLinkType() {
	private void setLinkProperties() { //CB renamed more appropriately
		Color color = null;
		int style = JGoPen.SOLID;

		switch (arcType) {
		case RIVER:
			color = Color.BLUE;
			break;
		case INFLOW:
			if (getMidLabel() != null) //CB added to make only CalSim II return types as Color.green
				color = Color.gray;
			else
				color = Color.CYAN;
			break;
		case DIVERSION:
			color = Color.red;
			if (getMidLabel() != null) { //CB added to make only CalSim II diversion types dashed
//				System.out.println(getMidLabel()); //CB debugging
//CB				style = JGoPen.DASHED;
			}
			break;
		case GWPUMPING:
			color = Color.red;
			style = JGoPen.DASHED;
			break;
		case GWRECHARGE:
			color = Color.gray;
			break;
		case RETURN:
			if (getMidLabel() != null) //CB added to make only CalSim II return types as Color.green  - CB NO LONGER
//				color = Color.green;
				color = Schematic.ARC_GREEN;
			else  //CB added to make CalSim III return types as a better green (more like the Excel version)
				color = Schematic.ARC_GREEN;
			break;
		case CHANNEL:
			color = Color.GRAY;
			break;
		case GWGW:
			color = Color.MAGENTA;
			break;
		case GWSW:
			color = Color.MAGENTA;
			style =JGoPen.DASHED;  //CB added this - temporary fix?
			break;
		case FUTURE:  //CB added section
			color = Color.BLACK;  //CB chaged from blue
			style = JGoPen.DASHED;
			break;
		case OLD_TO_NEW:  //CB added section
			color = Color.YELLOW;
			style = JGoPen.DASHED;
			break;
		case BYPASS:  //CB added section
//			color = Color.YELLOW;
//			color = Schematic.ALMOST_YELLOW;
			color = Schematic.MUSTARD;
			break;
		case LCPSIM:  //CB added section
			color = Schematic.VIOLET;
			break;
		case MODULE_BOUNDARY:  //CB added section
			color = Color.GREEN;
			break;
		case LCPSIM_DASHED:  //CB added section
			color = Schematic.VIOLET;
			style = JGoPen.DASHED;
			break;
		default:
			color = Color.black;
			style = JGoPen.SOLID;
		}
//		System.out.println("Arc setLinkType color = " + color);
		setLinkProperties(color, style);
	}

	public String getVariable() {
		if (getMidLabel() != null) //CB added check
			return ((JGoLinkLabel) getMidLabel()).getText();
		else return null;
	}

	public void setVariable(String text) {
		((JGoLinkLabel) getMidLabel()).setText(text);
	}

	public JMenu getVariableMenu() {
		return new ChanPopup(this).getVariableMenu(); //CB
	}

	public JMenu getDSSMenu() {
		return new ChanPopup(this).getDSSMenu(); //CB
	}

	// Events
	public void labelChanged() {
		// Only allow if not already defined
		if (arcType != 0)
			return;

		String s = getText();
		if (s.length() > 1 && s.substring(0, 1).equals("C")) {
			arcType = CHANNEL;
		} else if (s.length() > 1 && s.substring(0, 1).equals("R")) {
			arcType = RETURN;
		} else if (s.length() > 1 && s.substring(0, 1).equals("I")) {
			arcType = INFLOW;
		} else if (s.length() > 1 && s.substring(0, 1).equals("D")) {
			arcType = DIVERSION;
		} else if (s.length() > 1 && s.substring(0, 2).equals("GR")) {
			arcType = GWRECHARGE;
		} else if (s.length() > 1 && s.substring(0, 2).equals("GP")) {
			arcType = GWPUMPING;
		} else if (s.length() > 1 && s.substring(0, 2).equals("GW")) {
			arcType = GWGW;
		} else if (s.length() > 1 && s.substring(0, 2).equals("GS")) {
			arcType = GWSW;
		}
		//CB TO DO:???  add SPILL arc type and/or FUTURE arc type??
		setLinkProperties();

//		System.out.println("in labelChanged() of Arc.java");
	}

	public boolean doMouseDblClick(int modifiers, Point dc, Point vc,
			JGoView view) {
		SchematicView schematicView = (SchematicView) view;
		if (Schematic.IS_DEVELOPER)  //CB added
			schematicView.editArc(this);
		return true;
	}

	public void unlink() {
		// NetworkNode toNode = (NetworkNode)getToNode();
		super.unlink();
		// if (toNode != null)
		// toNode.updateDownstreamLinks();
	}

	// Properties
	public String getText() {
		JGoText obj = (JGoText) getMidLabel();
		if (obj != null)
			return obj.getText();
		else
			return "";
	}

	public void setText(String s) {
		// System.out.println( "setText: "+s);
		JGoText obj = (JGoText) getMidLabel();
		if (obj == null)
			return;
		obj.setText(s);

		labelChanged();
	}

	public void setType(int type) {
		arcType = type;
		setLinkProperties();
//		System.out.println("in setType(int type) of Arc.java; type = " + arcType);
	}

	public int getType() {
		return arcType;
	}

	public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup) {
		// Add Arc element
		DomElement jGoArc = svgDoc.createJGoClassElement("wrims.schematic.Arc",
				jGoElementGroup);
		jGoArc.setAttribute("split", Boolean.toString(split));
		jGoArc.setAttribute("arcType", Integer.toString(arcType));
		jGoArc.setAttribute("description", _description); //CB added
		// Have superclass add to the JGoObject group
		super.SVGWriteObject(svgDoc, jGoElementGroup);
	}

	public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc,
			DomElement svgElement, DomElement jGoChildElement) {
		if (jGoChildElement != null) {
			// This is an Arc element
			split = Boolean.parseBoolean(jGoChildElement.getAttribute("split"));
			arcType = Integer.parseInt(jGoChildElement.getAttribute("arcType"));
			_description = jGoChildElement.getAttribute("description"); //CB added
			DomNode node = super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());
			// updateFill();
		}
		return svgElement.getNextSibling();
	}

}
