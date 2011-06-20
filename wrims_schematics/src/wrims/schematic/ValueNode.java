package wrims.schematic;

import com.nwoods.jgo.*;

import java.awt.*;
//import java.awt.event.*;
import java.util.Hashtable;
import javax.swing.JPopupMenu;
//import wrims.dss.DssFrame;

/**
 *
 * @author Clay Booher
 *
 */
public class ValueNode extends JGoBasicNode implements Describable {
	public final int ALT_1 = 1;
	public final int ALT_2 = 2;
	public final Hashtable<Integer, Color> _altColorHashtable = new Hashtable<Integer, Color>();
	private String _name = "";  //label will be temporarily overwritten with data so need permanence
	private int _altNumber = 0;
	private String _linkedVariableName;
	private String _description = "";

	public ValueNode() { //CB must have this (no arg constructor) for copyObject method to work!
//NO!		super("");   //CB This constructor screws up ALL new and existing ValueNodes!!!!!!!!!!!!!!!!
		super();
		loadHashtable();
	}

	public ValueNode(int altNumber) {
		this();
		if (_altColorHashtable.get(altNumber) == null) return;
		init(altNumber);
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}

	public ValueNode(int altNumber, String label) {
		super(label);
		loadHashtable();
		if (_altColorHashtable.get(altNumber) == null) return;
		init(altNumber, label);
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}

	public ValueNode(int altNumber, String label, boolean isitCAD) {
		this(altNumber, label);
//		isCAD = isitCAD;
	}

	private void loadHashtable() {
		_altColorHashtable.put(ALT_1, Color.YELLOW);
//		_altColorHashtable.put(ALT_2, Color.ORANGE); // not distinguishable enough from Color.YELLOW
		_altColorHashtable.put(ALT_2, Schematic.BURNT_ORANGE);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getDescription() {
		return _description;
	}

	void setLabel(String newLable) {
		getLabel().setText(newLable);
	}

	/**
	 * Resets the label to the original text name, replacing the number value lable if present.
	 */
	void resetLabel() {
		getLabel().setText(_name);
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
	 * @return fill (inside) color
	 */
	public Color getFillColor() {
		if (getBrush() == null) return null;
		else return getBrush().getColor();
	}

	/**
	 * @param nodetype
	 */
	void init(int altNumber) {
		if (_altColorHashtable.get(altNumber) == null) return;
		init(altNumber, "", Color.LIGHT_GRAY, Color.YELLOW, Color.BLACK);
	}

	/**
	 * @param
	 */
	void init(int altNumber, String name) {
		if (_altColorHashtable.get(altNumber) == null) return;
		init(altNumber, name, Color.LIGHT_GRAY, _altColorHashtable.get(altNumber), Color.BLACK);
	}

	void init(int altNumber, String name, Color strokeColor, Color fillColor, Color textColor ) {
		if (_altColorHashtable.get(altNumber) == null) return;
		_name = name;
		_altNumber = altNumber;
		JGoText label = getLabel();
		if (label != null) {
			label.setEditable(false);
			label.setMultiline(false);
			label.setFontSize(label.getFontSize());
			label.setBold(true);
			label.setTextColor(textColor);
			label.setFontSize(10);
		}
		setDrawable(new JGoRectangle(new Rectangle(30, 30)));
		setPen(JGoPen.make(JGoPen.NONE, 2, strokeColor));
		setBrush(JGoBrush.makeStockBrush(fillColor));
		setLabelSpot(JGoObject.Center);
		setToolTipText("Alternative " + altNumber + " timeseries value");
		setResizable(false);
		setAutoResize(false);
	}

	public JPopupMenu getPopup() {
		JPopupMenu popup = new JPopupMenu();
		return popup;
	}

	public boolean doMouseDblClick(int modifiers, Point dc, Point vc,
			JGoView view) {
		if (view instanceof SchematicView)
			((SchematicView) view).editValueNode(this);
		return true;
	}

	public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup) {
		setLabel(_name); //CB test to see if the labels are changed before writing
		DomElement jGoValueNode = svgDoc.createJGoClassElement(
				"wrims.schematic.ValueNode", jGoElementGroup);
		jGoValueNode.setAttribute("altNumber", Integer.toString(_altNumber));
		jGoValueNode.setAttribute("name", _name);
		jGoValueNode.setAttribute("linkedVariableName", _linkedVariableName);  //CB added on 11/24/2008 - TODO: need???
		jGoValueNode.setAttribute("description", _description);  //CB added on 11/24/2008 - TODO: need???
		// Have superclass add to the JGoObject group
		super.SVGWriteObject(svgDoc, jGoElementGroup);
	}

	public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc,
			DomElement svgElement, DomElement jGoChildElement) {
		if (jGoChildElement != null) {
			_altNumber = Integer.parseInt(jGoChildElement.getAttribute("altNumber"));
			_name = jGoChildElement.getAttribute("name");
			_linkedVariableName = jGoChildElement.getAttribute("linkedVariableName"); //CB already here on 11/24/2008
			_description = jGoChildElement.getAttribute("description");  //CB TODO: need?  //CB added on 11/24/2008
			super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());
//			System.out.print("");  //debugging
		}
		return svgElement.getNextSibling();
	}

	// copy
	public JGoObject copyObject(JGoCopyEnvironment env) {
		ValueNode newobj = (ValueNode) super.copyObject(env);
		if (newobj != null) {
			// the ID should *not* be copied blindly--leave as -1 so
			// that we can fix it up later in ownerChange
			// the JGoObjects that are part of this area are copied
			// separately by copyChildren()
			// no other fields to copy--the Text is actually on a sub-object
			newobj._altNumber = _altNumber;
			newobj._name = _name;
			newobj._linkedVariableName = _linkedVariableName;
			newobj._description = _description;  // TO DO: need description?????  //CB added on 11/24/2008
		}
		return newobj;
	}

	public String getName() {
		return _name;
	}

	public int getAltNumber() {
		return _altNumber;
	}

	public String getLinkName() {
		return _linkedVariableName;
	}

	void setLinkName(String variableName) {
		_linkedVariableName = variableName;
	}

}
