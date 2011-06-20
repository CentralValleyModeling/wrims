package wrims.schematic;

import com.nwoods.jgo.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import wrims.dss.DssFrame;

public class ImporterCAD {

//CB    SchematicDocument doc;
    String fileName;
    String path;
//CB tried    DSSFrame _frame;
//    Schematic _schematic;
    protected HashMap id2node = new HashMap();

    String objfn = null;
    String confn = null;

//CB    public ImporterCAD(SchematicDocument d) {
//CB tried    public ImporterCAD(SchematicDocument d, DSSFrame frame) {
    public ImporterCAD() {
//CB        doc = d;
//Cb tried        _frame = frame;
//    	_schematic = schem;
    }

//CB    public ImporterCAD(SchematicDocument d, String loc, String name) {
//CB tried    public ImporterCAD(SchematicDocument d, String loc, String name, DSSFrame frame) {
    public ImporterCAD(String loc, String name) {
//        doc = d;
//    	_schematic = schem;
        fileName = name;
        path = loc;
//CB        _frame = frame;
        setFileNames();
        addCADObjectsFromFile();
        addCADArcsFromFile();
    }

    public void setFileNames() {

        //System.out.println( "file: "+fileName);
        if (fileName.contains("obj")) {
            //System.out.println( "file contains 'obj': "+fileName);
            objfn = path;
            confn = path.replace("obj","arc");
        }
        else if (fileName.contains("con")) {
            //System.out.println( "file contains 'con': "+fileName);
            confn = path;
            objfn = path.replace("arc","arc");
        }
    }


    public void addCADObjectsFromFile() {
    	String newline = System.getProperty("line.separator");

        String fn = objfn;
        String [] temp = null;

        BufferedReader input = null;
        try {
          File file = new File(fn);
          //System.out.println( "file: "+file);
          input = new BufferedReader( new FileReader(file));

          String line = null;
          String what = null;
          String id = null;
          String desc = null;
          float x;
          float y;
          String xs = null;
          String ys = null;

          NetworkNode n;

          while (( line = input.readLine()) != null) {
              //System.out.println( "line: "+line.split("<>"));
              temp = line.split("<>");

              //System.out.println( "length: "+ temp.length);

              // NODES
              what = temp[0].trim();
              id = temp[1].trim();
              desc = temp[2].trim();
              xs = temp[3].trim();
              ys = temp[4].trim();

              x = Float.valueOf(xs.trim()).floatValue();
              y = Float.valueOf(ys.trim()).floatValue();

              if (what.equals("CP")) {
                 //System.out.println( "CP: "+ line.toString());
                 //System.out.println( "x,y: "+ x + " "+y);
//CB tried                 n = new NetworkNode(id, NetworkNode.Network, true, _frame);
                 n = new NetworkNode(id, NetworkNode.NETWORK, true);
              } else if (what.equals("RESV")) {
                 n = new NetworkNode(id, NetworkNode.RESERVOIR, true);
              } else if (what.equals("DEMAND"))
                 n = new NetworkNode(id, NetworkNode.DEMAND, true);
              else if (what.equals("PP")) {
                 n = new NetworkNode();
                 n.init(NetworkNode.PUMPING);
              } else if (what.equals("PWRP")) {
                 n = new NetworkNode();
                 n.init(NetworkNode.POWER);
              } else if (what.equals("TNODE")) {
                 n = new NetworkNode(id, NetworkNode.TNODE, true);
              } else if (what.equals("ANNO")) {
                 id = desc.replace("\\n",newline);
                 addAnnoNode(id, x, y);
                 continue;
              } else
                 continue;

              if (!desc.equals("") && !what.equals("TNODE"))
                n.setToolTipText(desc);
              n.setLocation((int)(10+x*90), (int)(10+y*90));
              //System.out.println( "node: "+n);
              //System.out.println( "location: "+n.getLocation());
//CB              doc.addObjectAtTail(n);
              SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(n); //CB

              id2node.put(id, n);

          }
        } catch (FileNotFoundException ex) {
          ex.printStackTrace();
        } catch (IOException ex) {
          ex.printStackTrace();
        } finally {
            try {input.close();}
            catch (Exception x) {}
        }
    }

    public void addCADArcsFromFile() {
//    	String newline = System.getProperty("line.separator");

        String fn = confn;
        String [] temp = null;
        BufferedReader input = null;

        try {
          File file = new File(fn);
//          System.out.println("file: "+file);
          input = new BufferedReader( new FileReader(file));

          String line = null;
//          String what = null;
          String id = null;
          String from_id = null;
          String to_id = null;
//          String desc = null;

          Arc arc;
          JGoPort from;
          JGoPort to;

          while (( line = input.readLine()) != null) {
              if (line.startsWith("#"))
                  continue;

              temp = line.split("<>");
//              what = temp[1].trim();
              id = temp[0].trim();
              from_id = temp[2].trim();
              to_id = temp[3].trim();

              //System.out.println( "from_id: "+from_id+"  to_id:"+to_id);
              //System.out.println( "id: "+id+"  what:"+what);

              if (to_id.equals("none"))
                continue;
              if (from_id.equals("none"))
                continue;

              //System.out.println( "from_id: "+from_id+"  to_id:"+to_id);

              if (!id2node.containsKey(from_id) || !id2node.containsKey(to_id))
                    continue;

              from = ((NetworkNode)id2node.get(from_id)).getPort();
              to = ((NetworkNode)id2node.get(to_id)).getPort();
              arc = new Arc(from, to, true); //CB added boolean argument - CalSim II (CAD) type arcs have labels by default
              //arc.initialize(id, desc);
              arc.initialize(id);


              //System.out.println( "node: "+n);
              //System.out.println( "location: "+n.getLocation());
              //view.getDoc().addObjectAtTail(link);
//CB              doc.addObjectAtTail(arc);
              SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(arc); //CB

          }
        } catch (FileNotFoundException ex) {
            //System.out.println( "FileNotFoundException" );
            //return;
            //ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {input.close();}
            catch (Exception x) {}
        }

    }

    private void addAnnoNode(String id, float x, float y) {
        JGoTextNode tn = new JGoTextNode(id);
        tn.setTopPort(null);
        tn.setBottomPort(null);
        tn.setLeftPort(null);
        tn.setRightPort(null);
        //tn.setBrush(JGoBrush.makeStockBrush(Color.lightGray));
        //tn.setBrush(JGoBrush.makeStockBrush(new Color(230, 230, 250)));
        tn.setBrush(JGoBrush.makeStockBrush(new Color(240, 240, 255)));
        JGoText text = tn.getLabel();
        text.setEditable(true);
        text.setAlignment(JGoText.ALIGN_CENTER);
        //text.setAlignment(JGoText.ALIGN_LEFT);
        text.setWrapping(true);
        //text.setWrappingWidth(60);
        text.setMultiline(true);
        text.setFontSize(10);
        text.setAutoResize(true);
        tn.setLocation((int)(10+x*90), (int)(10+y*90));
//CB        doc.addObjectAtTail(tn);
        SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(tn); //CB
    }
}
