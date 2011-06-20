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
public class TextNode extends JGoBasicNode implements Describable {

	private String _description = "";  //CB added

	public TextNode() {
		super();
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}

	public TextNode(String label) {
		super(label);
		init();
		if (Schematic.IS_DEVELOPER) //CB added block
			setSelectable(true);
		else
			setSelectable(false);
	}

	public TextNode(String label, boolean isitCAD) {
		this(label);
//		isCAD = isitCAD;
		init();
	}

	/**
	 *
	 */
	public void setDescription(String description) {
		_description = description;
	}

	/**
	 *
	 */
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
		init(Color.WHITE, Color.WHITE, Color.BLACK);
	}

	public void init(Color strokeColor, Color fillColor, Color textColor) { //CB
		JGoText label = getLabel();
		if (label != null) {
			label.setEditable(true);
			label.setMultiline(true);
			label.setFontSize(label.getFontSize() + 2);
			label.setBold(true);
			label.setTextColor(textColor);
		}
		setDrawable(new JGoRectangle());
		setPen(JGoPen.make(JGoPen.SOLID, 2, strokeColor));
		setBrush(JGoBrush.makeStockBrush(fillColor));
		setLabelSpot(JGoObject.Center);
		setToolTipText("Annotation");
	}

	public JPopupMenu getPopup() {
		JPopupMenu popup = new JPopupMenu();
//		popup = new TextPopup(this).getPopup();
		return popup;
	}

	public boolean doMouseDblClick(int modifiers, Point dc, Point vc,
			JGoView view) {
		if (view instanceof SchematicView)
			((SchematicView) view).editTextNode(this);
		return true;
	}

	// file
	public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup) {
		// Add Arc element
		DomElement jGoTextNode = svgDoc.createJGoClassElement(
				"wrims.schematic.TextNode", jGoElementGroup);
		jGoTextNode.setAttribute("description", _description);  //CB added
		// Have superclass add to the JGoObject group
		super.SVGWriteObject(svgDoc, jGoElementGroup);
	}

	public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc,
			DomElement svgElement, DomElement jGoChildElement) {
		if (jGoChildElement != null) {
			_description = jGoChildElement.getAttribute("description");  //CB added
			super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());
		}
		return svgElement.getNextSibling();
	}

	// copy
	public JGoObject copyObject(JGoCopyEnvironment env) {
		TextNode newobj = (TextNode) super.copyObject(env);
		if (newobj != null) {
			// the ID should *not* be copied blindly--leave as -1 so
			// that we can fix it up later in ownerChange
			// the JGoObjects that are part of this area are copied
			// separately by copyChildren()
//			newobj.ntype = ntype;
			// no other fields to copy--the Text is actually on a sub-object
		}
		return newobj;
	}

}
