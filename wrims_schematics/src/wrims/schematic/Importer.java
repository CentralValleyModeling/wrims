package wrims.schematic;

import com.nwoods.jgo.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

//import wrims.dss.DSSFrame;

public class Importer {

	// CB SchematicDocument doc;
	String fileName;

//CB tried	DSSFrame _frame; // CB added
//	Schematic _schematic; // CB added

	protected HashMap id2node = new HashMap();

	String objfn = "d:/workspace/wgod/wrims/Schematic/xy/csIIIobj.10.xy";

	String confn = "d:/workspace/wgod/wrims/Schematic/xy/csIIIcon.10.xy";

	// CB public Importer(SchematicDocument d) {
	Importer() { //CB
		// CB doc = d;
		//CB tried _frame = frame;
	}

	// CB public Importer(SchematicDocument d, String fn) {
	public Importer(MainFrame schem, String fn) { // CB
		boolean excelType = false;
		// CB doc = d;
		fileName = fn;
		// CB tried _frame = frame;
		excelType = setFileNames();
		if (excelType) {
			addObjectsFromFile();
			addConnectorsFromFile();
		} else {
			addCADObjectsFromFile();
			addCADArcsFromFile();
		}
	}

	public boolean setFileNames() {
		boolean excelType = false;

		// System.out.println( "file: "+fileName);

		if (fileName.contains("obj")) {
			// System.out.println( "file contains 'obj': "+fileName);
			objfn = fileName;
			confn = fileName.replace("obj", "con");
			excelType = true;
		} else if (fileName.contains("con")) {
			// System.out.println( "file contains 'con': "+fileName);
			confn = fileName;
			objfn = fileName.replace("con", "obj");
			excelType = true;
		}
		if (fileName.contains("cad"))
			return false;
		return excelType;
	}

	public void addObjectsFromFile() {

		String fn = objfn;
		String[] temp = null;

		try {
			File file = new File(fn);
			// System.out.println( "file: "+file);
			BufferedReader input = new BufferedReader(new FileReader(file));

			String line = null;
			String what = null;
			String id = null;
			String name = null;
			String sc = null;
			String fc = null;
			float x;
			float y;

			NetworkNode n;

			while ((line = input.readLine()) != null) {
				temp = line.split("<>");
				what = temp[0].trim();
				id = temp[1].trim();
				name = temp[2].trim();
				x = Float.valueOf(temp[3].trim()).floatValue();
				y = Float.valueOf(temp[4].trim()).floatValue();
				sc = temp[5].trim();
				fc = temp[6].trim();
				// y = (float)145. - Float.valueOf(temp[3].trim()).floatValue();

				if (what.equals("CP"))
					n = new NetworkNode(name, NetworkNode.NETWORK);
				else if (what.equals("RESV"))
					n = new NetworkNode(name, NetworkNode.RESERVOIR);
				else if (what.equals("DEM"))
					n = new NetworkNode(name, NetworkNode.DEMAND);
				else if (what.equals("PP")) {
					n = new NetworkNode(name, NetworkNode.PUMPING);
				} else if (what.equals("PWRP")) {
					n = new NetworkNode(name, NetworkNode.POWER);
				} else if (what.equals("RESERVOIR")) {
					// name = "xxxxx "+name;
					n = new NetworkNode(name, NetworkNode.RESERVOIR);
				} else if (what.equals("NODE")) {
					n = new NetworkNode(name, NetworkNode.NETWORK, sc, fc);
				} else if (what.equals("VARIABLE")) {
					n = new NetworkNode(name, NetworkNode.VARIABLE, sc, fc);
				} else if (what.equals("RECTANGLE")) {
					n = new NetworkNode(name, NetworkNode.DEMAND);
				} else if (what.equals("BOUNDARY")) {
					n = new NetworkNode(name, NetworkNode.BOUNDARY, sc, fc);
				} else if (what.equals("DEMAND_UNIT")) {
					n = new NetworkNode(name, NetworkNode.DEMAND, sc, fc);
				} else if (what.equals("PLANT")) {
					n = new NetworkNode(name, NetworkNode.PLANT);
				} else if (what.equals("DWRTHINGY")) {
					n = new NetworkNode(name, NetworkNode.DWR);
				} else
					continue;

				// n.setLocation(Point((int)(10+x*60), (int)(10+y*60)));
				// n.setLocation((int)(10+x*120), (int)(10+y*120));
				n.setLocation((int) (x * 1.4), (int) (y * 1.4));

				// System.out.println( "node: "+n);
				// System.out.println( "location: "+n.getLocation());
				// getCurrentView().getDoc().addObjectAtTail(n);
				// view.getDoc().addObjectAtTail(n);
//CB				doc.addObjectAtTail(n);
				SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(n); //CB

				id2node.put(id, n);

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} // finally {
		// input.close();
		// }
	}

	public void addConnectorsFromFile() {

		String fn = confn;
		String[] temp = null;

		try {
			File file = new File(fn);
			// System.out.println( "file: "+file);
			BufferedReader input = new BufferedReader(new FileReader(file));

			String line = null;
			String what = null;
			// String id = null;
			String from_id = null;
			String to_id = null;
			String arrow = null;
			String color = null;
			String style = null;

			Link link;
			JGoPort from;
			JGoPort to;

			while ((line = input.readLine()) != null) {
				temp = line.split(" ");
				what = temp[0].trim();
				// id = temp[1].trim();
				from_id = temp[2].trim();
				to_id = temp[3].trim();
				color = temp[4].trim();
				arrow = temp[5].trim();
				style = temp[6].trim();

				if (to_id.equals("__"))
					continue;
				// if (from_id.equals("_x0000_s3439"))
				// continue;

				// System.out.println( "from_id: "+from_id+" to_id:"+to_id);

				from = ((NetworkNode) id2node.get(from_id)).getPort();
				to = ((NetworkNode) id2node.get(to_id)).getPort();

				if (what.equals("CONNECTOR"))
					link = new Link(from, to);
				else
					continue;

				setLinkProperties(link, color, arrow, style);

				// System.out.println( "node: "+n);
				// System.out.println( "location: "+n.getLocation());
				// view.getDoc().addObjectAtTail(link);
//CB				doc.addObjectAtTail(link);
				SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(link); //CB

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void setLinkProperties(Link link, String scolor, String arrow,
			String sstyle) {

		link.setOrthogonal(true);
		// link.setAvoidsNodes(true);
		link.setJumpsOver(true);
		link.setRoundedCorners(true);
		// link.setAdjustingStyle(JGoLink.AdjustingStyleCalculate);
		// link.setAdjustingStyle(JGoLink.AdjustingStyleScale);
		// link.setAdjustingStyle(JGoLink.AdjustingStyleStretch);
		// link.setAdjustingStyle(JGoLink.AdjustingStyleEnd);

		if (arrow.equals("endarrow"))
			link.setArrowHeads(false, true);

		/*
		 * Color
		 */
		Color color = null;

		if (scolor.equals("red"))
			color = Color.red;
		else if (scolor.equals("blue"))
			color = Color.blue;
		else if (scolor.equals("green"))
			color = Color.green;
		else if (scolor.equals("maroon"))
			color = Color.magenta;
		else if (scolor.equals("gold"))
			color = Color.yellow;
		else if (scolor.equals("#0cf"))
			color = Color.cyan;
		else
			color = Color.black;

		/*
		 * Style
		 */
		int style = 0;
		if (sstyle.equals("solid"))
			style = JGoPen.SOLID;
		else if (sstyle.equals("dotted"))
			style = JGoPen.DOTTED;
		else
			style = JGoPen.SOLID;

		link.setPen(JGoPen.make(style, 1, color));
		link.setBrush(JGoBrush.make(style, color));

	}

	public void addCADObjectsFromFile() {
		String newline = System.getProperty("line.separator");

		String fn = objfn;
		String[] temp = null;

		try {
			File file = new File(fn);
			// System.out.println( "file: "+file);
			BufferedReader input = new BufferedReader(new FileReader(file));

			String line = null;
			String what = null;
			String id = null;
			String desc = null;
			// String id2 = null;
			float x;
			float y;
			String xs = null;
			String ys = null;
			String color = null;

			NetworkNode n;

			while ((line = input.readLine()) != null) {
//				System.out.println("line: " + line.split("<>"));
				temp = line.split("<>");

//				System.out.println("length: " + temp.length);

				// NODES
				if (temp.length == 5) {
					what = temp[0].trim();
					id = temp[1].trim();
					desc = temp[2].trim();
					xs = temp[3].trim();
					ys = temp[4].trim();
				}

				// ANNOTATION
				if (temp.length == 7) {
					if (temp[0].trim().equals("TNODE"))
						what = "TNODE";
					else
						what = "ANNO";
					id = temp[1].trim();
					id = id.replace("\\n", newline);
					// System.out.println( "id: "+ id);
					xs = temp[4].trim();
					ys = temp[5].trim();
					color = temp[6].trim();
				}

				// x = Float.valueOf(xs.trim()).floatValue() - (float)100.;
				// y = (float)70. - Float.valueOf(ys.trim()).floatValue();

				x = Float.valueOf(xs.trim()).floatValue();
				y = Float.valueOf(ys.trim()).floatValue();

				if (what.equals("CP")) {
//					System.out.println("CP: " + line.toString());
//					System.out.println("x,y: " + x + " " + y);
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
					addAnnoNode(id, x, y, color);
					continue;
				} else
					continue;

				if (!desc.equals("") && !what.equals("TNODE"))
					n.setToolTipText(desc);
				n.setLocation((int) (10 + x * 90), (int) (10 + y * 90));
				// System.out.println( "node: "+n);
				// System.out.println( "location: "+n.getLocation());
//CB				doc.addObjectAtTail(n);
				SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(n);  //CB

				id2node.put(id, n);

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} // finally {
		// input.close();
		// }
	}

	public void addCADArcsFromFile() {
		// String newline = System.getProperty("line.separator");

		String fn = confn;
		String[] temp = null;

		try {
			File file = new File(fn);
//			System.out.println("file: " + file);
			BufferedReader input = new BufferedReader(new FileReader(file));

			String line = null;
			String what = null;
			String id = null;
			String from_id = null;
			String to_id = null;
			// String desc = null;

			Arc arc;
			JGoPort from;
			JGoPort to;

			while ((line = input.readLine()) != null) {
				if (line.startsWith("#"))
					continue;

				temp = line.split("<>");
				what = temp[1].trim();
				id = temp[0].trim();
				from_id = temp[2].trim();
				to_id = temp[3].trim();
				// desc = temp[4].trim();

//				System.out.println("from_id: " + from_id + "  to_id:" + to_id);
//				System.out.println("id: " + id + "  what:" + what);

				if (to_id.equals("none"))
					continue;
				if (from_id.equals("none"))
					continue;

//				System.out.println("from_id: " + from_id + "  to_id:" + to_id);

				if (!id2node.containsKey(from_id)
						|| !id2node.containsKey(to_id))
					continue;

				from = ((NetworkNode) id2node.get(from_id)).getPort();
				to = ((NetworkNode) id2node.get(to_id)).getPort();
				arc = new Arc(from, to, false); //CB added boolean argument - CalSim III (non-CAD) type arcs have no labels by default
				// arc.initialize(id, desc);
				arc.initialize(id);

				// setLinkProperties(link, color, arrow, style);

				// System.out.println( "node: "+n);
				// System.out.println( "location: "+n.getLocation());
				// view.getDoc().addObjectAtTail(link);
//CB				doc.addObjectAtTail(arc);
				SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(arc); //CB

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	private void addAnnoNode(String id, float x, float y, String color) {
		JGoTextNode tn = new JGoTextNode(id);
		tn.setTopPort(null);
		tn.setBottomPort(null);
		tn.setLeftPort(null);
		tn.setRightPort(null);
		// tn.setBrush(JGoBrush.makeStockBrush(Color.lightGray));
		// tn.setBrush(JGoBrush.makeStockBrush(new Color(230, 230, 250)));
		tn.setBrush(JGoBrush.makeStockBrush(new Color(240, 240, 255)));
		JGoText text = tn.getLabel();
		text.setEditable(true);
		text.setAlignment(JGoText.ALIGN_CENTER);
		// text.setAlignment(JGoText.ALIGN_LEFT);
		text.setWrapping(true);
		// text.setWrappingWidth(60);
		text.setMultiline(true);
		text.setFontSize(10);
		text.setTextColor(getColor(color));
		text.setAutoResize(true);
		tn.setLocation((int) (10 + x * 90), (int) (10 + y * 90));
//CB		doc.addObjectAtTail(tn);
		SchematicUtils.schematic.getCurrentView().getDoc().addObjectAtTail(tn); //CB
	}

// CB I hate this type of method with a String match for colors!
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
//CB			clr = Color.green;
			clr = MainFrame.ARC_GREEN; //CB replaced with darker green
		else if (scolor.equals("maroon"))
			clr = Color.magenta;
		else if (scolor.equals("silver"))
			clr = Color.gray;
		else if (scolor.equals("#0cf"))
			clr = Color.cyan;
		else if (scolor.equals("#0cf"))
			clr = Color.cyan;
		else									//CB TODO: need to add violet, schematic arc_green, node_green and mustard?????????????????????????
			clr = Color.black;
		return clr;
	}

}
