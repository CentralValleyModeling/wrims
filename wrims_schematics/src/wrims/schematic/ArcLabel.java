package wrims.schematic;

import com.nwoods.jgo.*;
import java.awt.*;

/**
 *
 * @author Tom Pruett
 * @author Clay Booher (minor additions)
 *
 */
// Arcs have labels that are loosely "connected" to the link.
public class ArcLabel extends JGoLinkLabel {
  public ArcLabel() {
    setTextColor(new Color(0, 127, 0));
    setAlignment(JGoText.ALIGN_CENTER);
    setEditOnSingleClick(true);
	setEditable(true);
	setDraggable(true);
  }

  public JGoObject copyObject(JGoCopyEnvironment env) {
    ArcLabel l = (ArcLabel)super.copyObject(env);
    if (l != null) {
      l.myOffset.x = myOffset.x;
      l.myOffset.y = myOffset.y;
      l.mySegment = mySegment;
      l.mySegmentDistance = mySegmentDistance;
      l.myConnectorPen = myConnectorPen;
      l.myBoxPen = myBoxPen;
    }
    return l;
  }

  public Arc getLink() { return (Arc)getPartner(); }

  public Point getOffset() { return myOffset; }

  public void setOffset(Point p) { setOffset(p.x, p.y); }

  public void setOffset(int x, int y) {
    int oldx = myOffset.x;
    int oldy = myOffset.y;
    if (oldx != x || oldy != y) {
      myOffset.x = x;
      myOffset.y = y;
      update(ChangedOffset, 0, new Point(oldx, oldy));
      if (getLink() != null) {
        getLink().positionLabels();
      }
    }
  }

  public int getSegment() { return mySegment; }

  public void setSegment(int s) {
    int olds = mySegment;
    if (olds != s && s >= 0) {
      mySegment = s;
      update(ChangedSegment, olds, null);
      if (getLink() != null) {
        getLink().positionLabels();
      }
    }
  }

  public int getSegmentDistance() { return mySegmentDistance; }
  public void setSegmentDistance(int percent) {
    int olds = mySegmentDistance;
    if (olds != percent && percent >= 0 && percent <= 100) {
      mySegmentDistance = percent;
      update(ChangedSegmentDistance, olds, null);
      if (getLink() != null) {
        getLink().positionLabels();
      }
    }
  }

  public Point getMidLabelConnectionPoint(Point p) {
    Arc l = getLink();
    if (l != null) {
      int numpts = l.getNumPoints();
      if (numpts < 2) return p;  // assume at least two points, one segment
      if (p == null)
        p = new Point(0, 0);
      int s = getSegment();
      if (s < 1)
        s = 1;
      else if (s >= numpts-2)
        s = numpts-3;
      int ax = l.getPointX(s);
      int ay = l.getPointY(s);
      int bx = l.getPointX(s+1);
      int by = l.getPointY(s+1);
      int segdst = getSegmentDistance();
      p.x = ax + ((bx-ax)*segdst)/100;
      p.y = ay + ((by-ay)*segdst)/100;
    }
    return p;
  }

  public JGoPen getConnectorPen() { return myConnectorPen; }
  public void setConnectorPen(JGoPen pen)
  {
    JGoPen old = myConnectorPen;
    if (old != pen) {
      myConnectorPen = pen;
      update(ChangedConnectorPen, 0, old);
    }
  }

  public JGoPen getBoxPen() { return myBoxPen; }
  public void setBoxPen(JGoPen pen)
  {
    JGoPen old = myBoxPen;
    if (old != pen) {
      myBoxPen = pen;
      update(ChangedBoxPen, 0, old);
    }
  }

  public void paint(Graphics2D g, JGoView view) {
    Arc l = getLink();
    if (l != null) {
      if (getConnectorPen() != null) {
        Point cp = getMidLabelConnectionPoint(null);
        if (cp != null) {
          Rectangle r = getBoundingRect();
          JGoDrawable.drawLine(g, getConnectorPen(), r.x+r.width/2, r.y+r.height/2, cp.x, cp.y);
        }
      }
      if (getBoxPen() != null) {
        Rectangle r = getBoundingRect();
        JGoDrawable.drawRect(g, getBoxPen(), JGoBrush.white, r.x-4, r.y, r.width+6, r.height+1);
      }
    }

    super.paint(g, view);
  }

  public void expandRectByPenWidth(Rectangle rect) {
    super.expandRectByPenWidth(rect);
    Arc l = getLink();
    if (l != null && getConnectorPen() != null) {
      Point midpt = getMidLabelConnectionPoint(null);
      if (midpt != null) {
        rect.add(midpt);
      }
    }
  }

  public void copyNewValueForRedo(JGoDocumentChangedEdit e) {
    switch (e.getFlags()) {
      case ChangedOffset:
        e.setNewValue(getOffset());
        return;
      case ChangedSegment:
        e.setNewValueInt(getSegment());
        return;
      case ChangedSegmentDistance:
        e.setNewValueInt(getSegmentDistance());
        return;
      case ChangedConnectorPen:
        e.setNewValue(getConnectorPen());
        return;
      case ChangedBoxPen:
        e.setNewValue(getBoxPen());
        return;
      default:
        super.copyNewValueForRedo(e);
        return;
    }
  }

  public void changeValue(JGoDocumentChangedEdit e, boolean undo)
  {
    switch (e.getFlags()) {
      case ChangedOffset:
        setOffset((Point)e.getValue(undo));
        return;
      case ChangedSegment:
        setSegment(e.getValueInt(undo));
        return;
      case ChangedSegmentDistance:
        setSegmentDistance(e.getValueInt(undo));
        return;
      case ChangedConnectorPen:
        setConnectorPen((JGoPen)e.getValue(undo));
        return;
      case ChangedBoxPen:
        setBoxPen((JGoPen)e.getValue(undo));
        return;
      default:
        super.changeValue(e, undo);
        return;
    }
  }

  public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup)
  {
    if (svgDoc.JGoXMLOutputEnabled()) {
      DomElement flowLabel = svgDoc.createJGoClassElement(
          "ArcLabel",
          jGoElementGroup);

      //we need to store the offset otherwise the label is not
      //positioned correctly
      flowLabel.setAttribute("offsetx", Integer.toString( (int) getOffset().getX()));
      flowLabel.setAttribute("offsety", Integer.toString( (int) getOffset().getY()));
      flowLabel.setAttribute("segment", Integer.toString(getSegment()));
      flowLabel.setAttribute("segmentdistance",
                             Integer.toString(getSegmentDistance()));
      JGoPen boxPen = getBoxPen();
      if (boxPen != null) {
        if (!svgDoc.isRegisteredReference(getBoxPen())) {
          flowLabel.setAttribute("embeddedboxpen", "true");
          DomElement subGroup = svgDoc.createElement("g");
          flowLabel.appendChild(subGroup);
          getBoxPen().SVGWriteObject(svgDoc, subGroup);
        }
        svgDoc.registerReferencingNode(flowLabel, "boxpen", getBoxPen());
      }
    }

    // Have superclass add to the JGoObject group
    super.SVGWriteObject(svgDoc, jGoElementGroup);
  }

  public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc, DomElement
                               svgElement, DomElement jGoChildElement)
  {
    if (jGoChildElement != null) {
      // This is a <ArcLabel> element
      int x = Integer.parseInt(jGoChildElement.getAttribute("offsetX"));
      int y = Integer.parseInt(jGoChildElement.getAttribute("offsetY"));
      setOffset(x,y);
      setSegment(Integer.parseInt(jGoChildElement.getAttribute("segment")));
      setSegmentDistance(Integer.parseInt(jGoChildElement.getAttribute("segmentdistance")));

      if (jGoChildElement.getAttribute("embeddedboxpen").equals("true")) {
        svgDoc.SVGTraverseChildren(jGoDoc, jGoChildElement, null, false);
      }
      String pen = jGoChildElement.getAttribute("boxpen");
      svgDoc.registerReferencingObject(this, "boxpen", pen);
      super.SVGReadObject(svgDoc, jGoDoc, svgElement,
                          jGoChildElement.getNextSiblingJGoClassElement());
    }
    else {
      // This is some other SVG element implemented as ArcLabel
    }
    return svgElement.getNextSibling();
  }

  public static final int ChangedOffset = LastChangedHint+123;
  public static final int ChangedSegment = LastChangedHint+124;
  public static final int ChangedSegmentDistance = LastChangedHint+125;
  public static final int ChangedConnectorPen = LastChangedHint+126;
  public static final int ChangedBoxPen = LastChangedHint+127;

  private Point myOffset = new Point(0, 0);
  private int mySegment = 3;
  private int mySegmentDistance = 50;
  private JGoPen myConnectorPen = JGoPen.lightGray;
  private JGoPen myBoxPen = JGoPen.lightGray;
}
