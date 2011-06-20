package wrims.schematic;

import com.nwoods.jgo.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPopupMenu;
import wrims.dss.DssFrame;

/**
 *
 * @author Clay Booher
 *
 */
public class GageNode extends JGoBasicNode implements Describable {

	private String _description = "";

	public GageNode() {
		super();
		JGoDrawable drawable = getDrawable();
		System.out.print("");
	}

	public GageNode(String label) {
		super(label);
		init();
	}

	public GageNode(String label, boolean isitCAD) {
		super(label);
//		isCAD = isitCAD;
		init();
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getDescription() {
		return _description;
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
	public void init() {
		init(Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.BLACK);
	}

	public void init(Color strokeColor, Color fillColor, Color textColor ) {
		JGoText label = getLabel();
		if (label != null) {
			label.setEditable(true);
			label.setMultiline(true);
			label.setFontSize(label.getFontSize());
			label.setBold(true);
			label.setTextColor(textColor);
		}
		setDrawable(new JGoRectangle());
		setPen(JGoPen.make(JGoPen.NONE, 2, strokeColor));
		setBrush(JGoBrush.makeStockBrush(fillColor));
		setLabelSpot(JGoObject.Center);
		setToolTipText("Annotation");
	}

	public JPopupMenu getPopup() {
		JPopupMenu popup = new JPopupMenu();
		return popup;
	}

	public boolean doMouseDblClick(int modifiers, Point dc, Point vc,
			JGoView view) {
		if (view instanceof SchematicView)
			((SchematicView) view).editGageNode(this);
		return true;
	}

	public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup) {
		// Add Arc element
		DomElement jGoGageNode = svgDoc.createJGoClassElement(
				"wrims.schematic.GageNode", jGoElementGroup);
		jGoGageNode.setAttribute("description", _description);
		// Have superclass add to the JGoObject group
		super.SVGWriteObject(svgDoc, jGoElementGroup);
	}

	public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc,
			DomElement svgElement, DomElement jGoChildElement) {
		if (jGoChildElement != null) {
			_description = jGoChildElement.getAttribute("description");
			super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());
		}
		return svgElement.getNextSibling();
	}

	// copy
	public JGoObject copyObject(JGoCopyEnvironment env) {
		GageNode newobj = (GageNode) super.copyObject(env);
		if (newobj != null) {
			// the ID should *not* be copied blindly--leave as -1 so
			// that we can fix it up later in ownerChange
			// the JGoObjects that are part of this area are copied
			// separately by copyChildren()
			// no other fields to copy--the Text is actually on a sub-object
		}
		return newobj;
	}
}
