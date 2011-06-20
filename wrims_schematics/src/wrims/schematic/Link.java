package wrims.schematic;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import com.nwoods.jgo.*;

import java.awt.*;

public class Link extends JGoLink implements Describable {

	static final int RIVER = 1;  //CB changed CHANNEL to RIVER

	// static final int RECHARGE = 2;
	static final int INFLOW = 3;

	static final int DIVERSION = 4;

	static final int GWRECHARGE = 5;

	static final int RETURN = 6;

	static final int GWSW = 7;

	static final int GWGW = 8;

	static final int GWPUMPING = 9;

	public static final int SPILL = 10; //CB added, but may not need

	public static final int CHANNEL = 11; //CB added

	public static final int FUTURE = 12; //CB added

	public static final int LCPSIM = 13;  //CB added

	public static final int MODULE_BOUNDARY = 14;  //CB added

	public static final int LCPSIM_DASHED = 15;  //CB added

	int linkType = 0;

	private String _description = "";  //CB added

	public Link() {
		super();
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}

	public Link(JGoPort from, JGoPort to) {
		super(from, to);
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}
	/**
	 * CB added.
	 * @param from
	 * @param to
	 */
	public Link(JGoPort from, JGoPort to, int type) {
		this(from, to);
		setType(type);
	}
	/**
	 * CB added.
	 * @param from
	 * @param to
	 * @param color
	 */
	public Link(JGoPort from, JGoPort to, Color color) {
		this(from, to);
		if (color.equals(Color.BLUE)) //CB added section
			 setType(RIVER);
//			if () setType(RIVER);  //CB to do:  added DOTTED check here??
//			else setType(FUTURE);
		else if (color.equals(Color.CYAN))
			setType(INFLOW);
		else if (color.equals(Color.RED))
			setType(DIVERSION);
		else if (color.equals(Schematic.ARC_GREEN)) //CB replaced Color.GREEN
			setType(RETURN);
		else if (color.equals(Schematic.YUCK))
			setType(DIVERSION);
		else if (color.equals(Color.CYAN))
			setType(INFLOW);
		else if (color.equals(Color.BLACK))
			setType(SPILL);
		if (color.equals(Color.GRAY)) //CB changed from blue to gray
			setType(CHANNEL);
		else
			JOptionPane.showMessageDialog(null, "Link constructor color argument is not valid", "Bad Arc Color", JOptionPane.ERROR_MESSAGE);
//		System.out.print("Red = " + Color.RED);
//		System.out.println("color = " + color + " and link constructor type = " + linkType);
	}
	/**
	 * CB removed text parameter because Link does not have a label.
	 */
	public void initialize() {
		initialize(false);
	}

	/**
	 * CB added.
	 * @param t
	 * @param arrowAtEnd
	 */
	public void initialize(boolean arrowAtEnd) {
		setAvoidsNodes(true);
		setAdjustingStyle(JGoLink.AdjustingStyleStretch);
		setArrowHeads(false, arrowAtEnd);
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

	public int getLinkType() {
		return linkType;
	}

	public NetworkNode getFromNode() {
		if (getFromPort() != null)
			return (NetworkNode) (getFromPort().getParent());
		return null;
	}

	public NetworkNode getToNode() {
		if (getToPort() != null)
			return (NetworkNode) (getToPort().getParent());
		return null;
	}

    // CB added here - probably needs work!
    public JPopupMenu getPopup() {
        JPopupMenu popup = null;
        //System.out.println("getPopup: "+ntype+" ");
            popup = new ChanPopup(this).getPopup();
        return popup;
    }

//CB	private Color arccolor = null;   //CB its instance variable equivalent is not used

//CB	private int arcstyle = 0;   //CB its instance variable equivalent is not used

	private void setLinkProperties(Color color, int style) {
//CB		arccolor = color;
//CB		arcstyle = style;
		setPen(JGoPen.make(style, 2, color));  //CB changed width to 2
		setBrush(JGoBrush.make(JGoBrush.SOLID, color));
	}

	private void setLinkType() {
		Color color = null;
		int style = JGoPen.SOLID;

		switch (linkType) {
		case RIVER: //CB added RIVER section
			color = Color.blue;
			break;
		case INFLOW:
			color = Color.cyan;
			break;
		case DIVERSION:
			color = Color.red;
			// style = JGoPen.DASHED;
			break;
		case GWPUMPING:
			color = Color.red;
			style = JGoPen.DASHED;
			break;
		case GWRECHARGE:
			color = Color.gray;
			break;
		case RETURN:
//CB			color = Color.green;
			color = Schematic.ARC_GREEN; //CB
			break;
		case GWGW:
			color = Color.magenta;
			break;
		case GWSW:
			color = Color.magenta;
			break;
		case CHANNEL:
			color = Color.GRAY; //CB changed to gray from blue
			break;
		case FUTURE:
			color = Color.BLACK; //CB added section; later changed from BLUE
			style = JGoPen.DASHED;
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
//		System.out.println("Link type = " + linkType);
//		System.out.println("setLinkType color = " + color);
		setLinkProperties(color, style);
	}

	// Events
	/*
	 * public void labelChanged() { // Only allow if not already defined if
	 * (linkType != 0) return;
	 *
	 * String s = getText(); if (s.length() > 1 && s.substring(0,
	 * 1).equals("C")) { linkType = CHANNEL; } else if (s.length() > 1 &&
	 * s.substring(0, 1).equals("R")) { linkType = RETURN; } else if (s.length() >
	 * 1 && s.substring(0, 1).equals("I")) { linkType = INFLOW; } else if
	 * (s.length() > 1 && s.substring(0, 1).equals("D")) { linkType = DIVERSION; }
	 * else if (s.length() > 1 && s.substring(0, 2).equals("GR")) { linkType =
	 * GWRECHARGE; } else if (s.length() > 1 && s.substring(0, 2).equals("GP")) {
	 * linkType = GWPUMPING; } else if (s.length() > 1 && s.substring(0,
	 * 2).equals("GW")) { linkType = GWGW; } else if (s.length() > 1 &&
	 * s.substring(0, 2).equals("GS")) { linkType = GWSW; } setLinkType(); }
	 */

	public boolean doMouseDblClick(int modifiers, Point dc, Point vc,
			JGoView view) {
		SchematicView sview = (SchematicView) view;
		if (Schematic.IS_DEVELOPER)  //CB added
			sview.editLink(this);
		return true;
	}

	public void unlink() {
		// NetworkNode toNode = (NetworkNode)getToNode();
		super.unlink();
		// if (toNode != null)
		// toNode.updateDownstreamLinks();
	}

	// Properties
	public void setType(int type) {
		linkType = type;
		setLinkType();
	}

	public int getType() {
		return linkType;
	}

	public JMenu getVariableMenu() {
		return new ChanPopup(this).getVariableMenu();
	}

	public JMenu getDSSMenu() {
		return new ChanPopup(this).getDSSMenu();
	}

	public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup) {
		// Add Link element
		DomElement jGoArc = svgDoc.createJGoClassElement(
				"wrims.schematic.Link", jGoElementGroup);
		jGoArc.setAttribute("linkType", Integer.toString(linkType));
		jGoArc.setAttribute("description", _description); //CB added
		// Have superclass add to the JGoObject group
		super.SVGWriteObject(svgDoc, jGoElementGroup);
	}

	public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc,
			DomElement svgElement, DomElement jGoChildElement) {
		if (jGoChildElement != null) {
			// This is an Link element
			linkType = Integer.parseInt(jGoChildElement.getAttribute("linkType"));
			_description = jGoChildElement.getAttribute("description"); //CB added
			super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());
			// updateFill();
		}
		return svgElement.getNextSibling();
	}

}
