package wrims.schematic;

//import java.awt.*;
import com.nwoods.jgo.*;

public class SchemGraph extends JGoSubGraph {
  public SchemGraph() { super(); }  // default constructor, just for copying

  public SchemGraph(String s) { super(s); }

  private boolean IsExpanded = true;

  public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup)
  {
    // expand before saving, else won't be saved properly
    IsExpanded = isExpanded();
    if (!IsExpanded)
        expand();

    DomElement jGoSchemGraph = svgDoc.createJGoClassElement("wrims.schematic.SchemGraph", jGoElementGroup);

    // save the state so can be restored when read
    jGoSchemGraph.setAttribute("IsExpanded", Boolean.toString(IsExpanded));

    // Have superclass add to the JGoObject group
    super.SVGWriteObject(svgDoc, jGoElementGroup);

    if (!IsExpanded)
        collapse();

  }

  public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc, DomElement svgElement, DomElement jGoChildElement)
  {
    if (jGoChildElement != null) {
      IsExpanded = Boolean.parseBoolean(jGoChildElement.getAttribute("IsExpanded"));
      super.SVGReadObject(svgDoc, jGoDoc, svgElement,
                          jGoChildElement.getNextSiblingJGoClassElement());

      // Maybe need to do the collapse() after entire graph is rendered????
      // Doesn't work at all here....
      //System.out.println( "READ: IsExpanded: "+IsExpanded);
      //if (!IsExpanded)
      //    collapse();

    }
    return svgElement.getNextSibling();
  }

}
