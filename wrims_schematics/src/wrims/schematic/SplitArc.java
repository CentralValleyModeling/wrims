package wrims.schematic;

import com.nwoods.jgo.*;
import java.awt.*;


public class SplitArc extends JGoLabeledLink {
  public SplitArc() { init(); }
  public SplitArc(JGoPort a, JGoPort b) { super(a, b); init(); }

  private void init() {
    setPen(JGoPen.make(JGoPen.SOLID, 6, Color.yellow));
    setHighlight(JGoPen.make(JGoPen.SOLID, 8, Color.blue));
    setBrush(JGoBrush.make(JGoBrush.SOLID, Color.blue));
    setArrowShaftLength(10);
    setArrowHeads(false, true);
  }

  public void calculateStroke() {
    super.calculateStroke();
    // assume no arrow at start
    if (hasArrowAtEnd()) {
      Point start = getArrowToAnchorPoint();
      Point end = getArrowToEndPoint();
      if (start == null || end == null) return;
      int[] headx = new int[4];
      int[] heady = new int[4];
      calculateFilledArrowhead(start.x, start.y, end.x, end.y, 1, headx, heady);
      myEndPointX = end.x;
      myEndPointY = end.y;
      setPoint(getNumPoints()-1, headx[0], heady[0]);
    }
  }

  protected void drawArrowHeads(Graphics2D g) {
    // assume no arrow at start
    if (hasArrowAtEnd()) {
      Point start = getArrowToAnchorPoint();
      if (start == null) return;
      int[] headx = new int[4];
      int[] heady = new int[4];
      calculateFilledArrowhead(start.x, start.y, myEndPointX, myEndPointY, 1, headx, heady);
      JGoStroke.drawPolygon(g, null, getBrush(), headx, heady, 4);
    }
  }

  private int myEndPointX;
  private int myEndPointY;
}

