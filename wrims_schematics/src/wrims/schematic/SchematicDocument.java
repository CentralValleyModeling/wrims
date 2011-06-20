package wrims.schematic;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.nwoods.jgo.DomDoc;
import com.nwoods.jgo.DomElement;
import com.nwoods.jgo.DomNode;
import com.nwoods.jgo.JGoBasicNode;
import com.nwoods.jgo.JGoDocument;
import com.nwoods.jgo.JGoDocumentChangedEdit;
import com.nwoods.jgo.JGoDocumentEvent;
import com.nwoods.jgo.JGoLink;
import com.nwoods.jgo.JGoLinkLabel;
import com.nwoods.jgo.JGoListPosition;
import com.nwoods.jgo.JGoObject;
import com.nwoods.jgo.JGoPen;
import com.nwoods.jgo.JGoText;
import com.nwoods.jgo.JGoUndoManager;
import com.nwoods.jgo.svg.DefaultDocument;

public class SchematicDocument extends JGoDocument {
	// private Vector<String> _allVariables = new Vector<String>(); //CB added
	// for speed as it may be needed many times in a short period
	private Hashtable<String, Object> _allVariables = new Hashtable<String, Object>(); // CB
	// added
	// for
	// speed
	// as
	// it
	// may
	// be
	// needed
	// many
	// times
	// in
	// a
	// short
	// period

	/*
	 * Hashtable of variable names/value node pairs for fast updating of value
	 * nodes with data
	 */
	private Hashtable<String, ValueNode>[] _nameToValueNodeHashtable = new Hashtable[2]; // CB
	// added.

	private Object dummy = new Object();

	public SchematicDocument() { // CB tried to make private but SVGReadDoc
		// method wants no arg constructor (it uses
		// reflection)
		setUndoManager(new JGoUndoManager());
		if (Schematic.IS_DEVELOPER) {
			setModifiable(true);
		} else {
			setModifiable(false);
		}
	}

	/**
	 * CB added.
	 * 
	 * @param name
	 */
	public SchematicDocument(String name) {
		this();
		setName(name);
	}

	/**
	 * Loads a vector with all VARIABLE type NetworkNodes. As an aside, if the
	 * user is not a developer, it makes Arcs, Links, ValueNodes not selectable.
	 * Yes, it is not good programming practice, but is more time efficient. CB
	 * added.
	 * 
	 * @return
	 */
	synchronized void loadAllVariablesVector() {
		JGoListPosition position = getFirstObjectPos();
		while (position != null) {
			if ((getObjectAtPos(position) instanceof NetworkNode)
					&& (((NetworkNode) getObjectAtPos(position)).getType() == NetworkNode.VARIABLE)) {
				// _allVariables.add(((NetworkNode)getObjectAtPos(position)).getText());
				_allVariables.put(((NetworkNode) getObjectAtPos(position))
						.getText(), dummy);
			} else if (!Schematic.IS_DEVELOPER) {
				if (getObjectAtPos(position) instanceof Arc) {
					((Arc) getObjectAtPos(position)).setSelectable(false);
				} else if (getObjectAtPos(position) instanceof Link) {
					((Link) getObjectAtPos(position)).setSelectable(false);
				} else if (getObjectAtPos(position) instanceof ValueNode) {
					((ValueNode) getObjectAtPos(position)).setSelectable(false);
				} else if (getObjectAtPos(position) instanceof TextNode) {
					((TextNode) getObjectAtPos(position)).setSelectable(false);
				}
			}
			position = getNextObjectPos(position);

			// CB debugging black octagon at about 0,0!!!! (CB - found out it
			// was a corrupted file due to a constructor calling super("")
			// instead of super())!
			// if (getObjectAtPos(position) instanceof JGoBasicNode)
			// if (getObjectAtPos(position).getLocation().x < 50 &&
			// getObjectAtPos(position).getLocation().y < 50) {
			// System.out.println(getObjectAtPos(position).getClass() +
			// " object at " + getObjectAtPos(position).getLocation());
			// }
			// CB to find a node far, far away from other objects (greatly
			// increases doc size and slows it way down)
			// if (getObjectAtPos(position) instanceof JGoBasicNode &&
			// getObjectAtPos(position).getLocation().y > 100000) {
			// System.out.println(((JGoBasicNode)getObjectAtPos(position)).getLabel().getText()
			// + " location: "
			// + getObjectAtPos(position).getLocation());
			// }
		}
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	// synchronized Vector<String> getAllVariables() {
	synchronized Hashtable<String, Object> getAllVariables() {
		return _allVariables;
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	synchronized void loadNameToValueNodeHashtable() {
		for (int i = 0; i < _nameToValueNodeHashtable.length; ++i) {
			if (_nameToValueNodeHashtable[i] == null) {
				if (i == 0) {
					resetValueNodeNames();
				}
				_nameToValueNodeHashtable[i] = new Hashtable<String, ValueNode>();
			}
		}
		JGoListPosition position = getFirstObjectPos();
		while (position != null) {
			if (getObjectAtPos(position) instanceof ValueNode) {
				for (int i = 0; i < _nameToValueNodeHashtable.length; ++i) {
					if ((((ValueNode) getObjectAtPos(position)).getLinkName() != null)
							&& ((ValueNode) getObjectAtPos(position)).getText()
									.startsWith(Schematic.ALT_STRINGS[i])) {
						_nameToValueNodeHashtable[i].put(
								((ValueNode) getObjectAtPos(position))
										.getLinkName(),
								(ValueNode) getObjectAtPos(position));
						break;
					}
				}
			}

			if (getObjectAtPos(position) != null) {
				// if
				// (((JGoBasicNode)getObjectAtPos(position)).getBrush().getColor()
				// == Color.BLACK
				// ||
				// ((JGoBasicNode)getObjectAtPos(position)).getBrush().getColor()
				// == Color.black)
				// System.out.println();
				if ((getObjectAtPos(position) instanceof JGoBasicNode)
						&& !(getObjectAtPos(position) instanceof NetworkNode)
						&& !(getObjectAtPos(position) instanceof TextNode)
						&& !(getObjectAtPos(position) instanceof GageNode)
						&& !(getObjectAtPos(position) instanceof ValueNode)) {
					// System.out.println(getObjectAtPos(position).getClass());
					// System.out.println(((JGoBasicNode)getObjectAtPos(position)).getLocation().x);
					// System.out.println(((JGoBasicNode)getObjectAtPos(position)).getLocation().y);
					// System.out.println(((JGoBasicNode)getObjectAtPos(position)).getLabel().getText());
				}
			}

			position = getNextObjectPos(position);
		}
	}

	/**
	 * Resets ValueNode labels to their original label. This must be called
	 * before saving.
	 */
	void resetValueNodeNames() { // CB added
		JGoObject object = null;
		JGoListPosition position = getFirstObjectPos();
		while (position != null) {
			object = getObjectAtPos(position);
			if (object instanceof ValueNode) {
				((ValueNode) object).resetLabel();
			}
			position = getNextObjectPos(position);
		}
	}

	// CB TODO consider making alt 2 boxes visibility separate from alt 1 boxes.
	/**
	 * CB added. They are all visible or all invisible.
	 * 
	 * @param isVisible
	 */
	void setValueNodeVisibility(boolean isVisible) {
		JGoListPosition position = getFirstObjectPos();
		JGoObject object = getObjectAtPos(position);
		while (position != null) {
			object = getObjectAtPos(position);
			if (object instanceof ValueNode) {
				// they are all visible or all invisible so if first is
				// <code>isVisible</code>, return
				if (object.isVisible() == isVisible) {
					return;
				}
				((ValueNode) object).setVisible(isVisible);
			}
			position = getNextObjectPos(position);
		}
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	synchronized Hashtable<String, ValueNode>[] getNameToValueNodeHashtables() {
		return _nameToValueNodeHashtable;
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	synchronized Hashtable<String, ValueNode> getAlt1NameToValueNodeHashtable() {
		return _nameToValueNodeHashtable[0];
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	synchronized Hashtable<String, ValueNode> getAlt2NameToValueNodeHashtable() {
		return _nameToValueNodeHashtable[1];
	}

	/**
	 *
	 */
	public JGoListPosition addObjectAtTail(JGoObject obj) {
		return super.addObjectAtTail(obj);
	}

	JGoBasicNode retrieveNode(String name) {
		JGoListPosition position = getFirstObjectPos();
		JGoObject object = getObjectAtPos(position);
		while (position != null) {
			object = getObjectAtPos(position);
			if (object instanceof JGoBasicNode) {
				// System.out.println(((JGoBasicNode)object).getText());
				if (((JGoBasicNode) object).getText().trim().equalsIgnoreCase(
						name)) {
					return (JGoBasicNode) object;
				}
			}
			position = getNextObjectPos(position);
		}
		return null;
	}

	// Basic properties: name and location (pathname)

	public String getName() {
		return myName;
	}

	public void setName(String newname) {
		String oldName = myName;
		if (!oldName.equals(newname)) {
			myName = newname;
			fireUpdate(NAME_CHANGED, 0, null, 0, oldName);
		}
	}

	public String getLocation() {
		return myLocation;
	}

	public void setLocation(String newloc) {
		String oldLocation = myLocation;
		if (!oldLocation.equals(newloc)) {
			myLocation = newloc;
			fireUpdate(LOCATION_CHANGED, 0, null, 0, oldLocation);

			updateLocationModifiable();
		}
	}

	// read-only property--can the file be written?
	public boolean isLocationModifiable() {
		return myIsLocationModifiable; // just return cached value
	}

	// There's no setLocationModifiable, because that's controlled externally
	// in the file system. But because we're caching the writableness,
	// we need a method to update the cache.

	public void updateLocationModifiable() {
		boolean canwrite = true;
		if (!getLocation().equals("")) {
			File file = new File(getLocation());
			if (file.exists() && !file.canWrite()) {
				canwrite = false;
			}
		}
		if (isLocationModifiable() != canwrite) {
			boolean oldIsModifiable = isModifiable();
			myIsLocationModifiable = canwrite;
			if (oldIsModifiable != isModifiable()) {
				fireUpdate(JGoDocumentEvent.MODIFIABLE_CHANGED, 0, null,
						(oldIsModifiable ? 1 : 0), null);
			}
		}
	}

	// override to include whether the file can be written
	public boolean isModifiable() {
		return super.isModifiable() && isLocationModifiable();
	}

	public void updatePaperColor() {
		if (isModifiable()) {
			setPaperColor(Color.white);
		} else {
			setPaperColor(new Color(0xDD, 0xDD, 0xDD));
		}
	}

	// new property--has the document been changed?
	public boolean isModified() {
		return myIsModified;
	}

	public void setModified(boolean b) {
		if (myIsModified != b) {
			myIsModified = b;
			// don't need to notify document listeners
		}
	}

	// Some, but not all, changes to the document should make it "modified"
	public void fireUpdate(int hint, int flags, Object object, int prevInt,
			Object prevVal) {
		// changing the read-only-ness isn't considered modifying the document
		if (hint == JGoDocumentEvent.MODIFIABLE_CHANGED) {
			updatePaperColor();
		} else if (hint != JGoDocumentEvent.PAPER_COLOR_CHANGED) {
			// don't consider the paper color as part of the document, either
			setModified(true);
		}
		if (hint == JGoDocumentEvent.CHANGED) {
			if ((flags == JGoText.ChangedText)
					&& (object instanceof JGoLinkLabel)) {
				// System.out.println( "Hint: "+JGoDocumentEvent.CHANGED+"
				// "+hint);
				// System.out.println( "flags: "+JGoText.ChangedText+" "+flags+"
				// "+object);
				JGoLinkLabel lab = (JGoLinkLabel) object;
				// System.out.println( "Link: "+lab.getLabeledLink());
				if ((lab.getLabeledLink() != null)
						&& (lab.getLabeledLink() instanceof Arc)) {
					Arc a = (Arc) lab.getLabeledLink();
					a.labelChanged();
				}
			}
		}

		super.fireUpdate(hint, flags, object, prevInt, prevVal);
	}

	public int getNextNodeID() {
		return ++myLastNodeID;
	}

	public JGoPen getLinkPen() {
		return myPen;
	}

	public void setLinkPen(JGoPen p) {
		if (!myPen.equals(p)) {
			myPen = p;
			// now update all links
			JGoListPosition pos = getFirstObjectPos();
			while (pos != null) {
				JGoObject obj = getObjectAtPos(pos);
				// only consider top-level objects
				pos = getNextObjectPosAtTop(pos);
				if (obj instanceof JGoLink) {
					JGoLink link = (JGoLink) obj;
					link.setPen(p);
				}
			}
		}
	}

	// CB private static String _lastSVGLocation = null;
	// CB public String getLastLocation() {
	// CB return _lastSVGLocation;
	// CB }

	/**
	 * Read and write schematic documents as files using the default
	 * serialization or as a simple XML document.
	 * 
	 * @param parent
	 * @param defaultLocation
	 */
	public static SchematicDocument open(Component parent, String location) {
		_parent = parent;
		// defaultLocation = "svg/";
		// CB - only need if file at defaultLocation is directory OR does not
		// exist
		JFileChooser chooser = null; // = new JFileChooser();
		if ((location != null) && (!location.equals(""))) {
			File currentFile = new File(location);
			// CB added block to handle file which is NOT a directory
			System.out.println("currentFile: " + currentFile);
			if (currentFile.exists()) {
				if (currentFile.isAbsolute() && !currentFile.isDirectory()) {
					if ((parent instanceof Schematic)
							&& !((Schematic) parent)
									.isSchematicFileOpen(location)) {
						// String loc = defaultLocation.substring(0,
						// defaultLocation.lastIndexOf("\\"));//CB added - but
						// openDoc expects full path. Why is name provided too?
						String name = location.substring(location
								.lastIndexOf("\\") + 1);
						// openDoc(parent, loc, name); //CB added - but openDoc
						// expects full path. Why is name provided too?
						return openDoc(parent, location, name);
					}
				}
			}
			chooser = new JFileChooser();
			chooser.setCurrentDirectory(currentFile);
		} else {
			chooser = new JFileChooser();
			chooser.setCurrentDirectory(null);
		}
		chooser.setAcceptAllFileFilterUsed(false);
		Filter svgInputFilter = new Filter(".svg",
				"JGo SVG with XML extensions (*.svg)");
		chooser.addChoosableFileFilter(svgInputFilter);
		chooser.setFileFilter(svgInputFilter);
		int returnVal = chooser.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String name = chooser.getSelectedFile().getName();
			String loc = chooser.getSelectedFile().getAbsolutePath();
			if ((parent instanceof Schematic)
					&& !((Schematic) parent).isSchematicFileOpen(loc)) {
				return openDoc(parent, loc, name); // CB added to eliminate
				// duplicate code below
				/*
				 * CB loc.toLowerCase(); FileInputStream fstream = null; try {
				 * fstream = new FileInputStream(loc); SchematicDocument doc =
				 * null; if (loc.endsWith(".svg")) doc = loadSVG1(fstream); if
				 * (doc == null) return null; doc.setName(name);
				 * doc.updateLocationModifiable(); doc.updatePaperColor();
				 * doc.setModified(false); // the UndoManager is transient and
				 * must be setup again when created from // serialization, but
				 * we also need to ignore all changes up to now anyway, // so
				 * we'll just throw away the old manager and create a new one
				 * doc.setUndoManager(new JGoUndoManager()); //CB
				 * _lastSVGLocation = loc; doc.setLocation(loc); return doc; }
				 * catch (IOException x) { JOptionPane.showMessageDialog(null,
				 * x, "Open Document Error",
				 * javax.swing.JOptionPane.ERROR_MESSAGE); return null; } catch
				 * (Exception x) { JOptionPane.showMessageDialog(null, x,
				 * "Loading Document Exception",
				 * javax.swing.JOptionPane.ERROR_MESSAGE); return null; }
				 * finally { try { if (fstream != null) fstream.close(); } catch
				 * (Exception x) {} }
				 */
			} else {
				return null;
			}
		} else {
			// return ((Schematic)_parent).newSchematic();
			return null;
		}
	}

	/**
	 * 
	 * @param parent
	 *            CB not used here (yet?)
	 * @param loc
	 *            the absolute path
	 * @param filename
	 * @return
	 */
	static SchematicDocument openDoc(Component parent, String loc,
			String filename) {
		_parent = parent; // CB need here?
		loc.toLowerCase(); // CB huh?
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(loc);
			SchematicDocument doc = null;
			if (loc.endsWith(".svg")) {
				doc = loadSVG1(fstream); // 1.89 GB to 1.89 GB the second time
			}
			// or NOT MUCH MEMORY USED BY doc
			if (doc == null) {
				return null;
			}
			doc.setName(filename);
			doc.updateLocationModifiable();
			doc.updatePaperColor();
			// CB doc.setModified(false); //CB moved down after setLocation(loc)
			// which resets modified to true

			// the UndoManager is transient and must be setup again when
			// created from serialization
			// but we also need to ignore all changes up to now anyway,
			// so we'll just throw away the old manager and create a new one
			doc.setUndoManager(new JGoUndoManager());
			doc.setLocation(loc); // CB added, but may be redundant
			doc.setModified(false); // CB moved to here from above
			return doc;
		} catch (IOException x) {
			JOptionPane.showMessageDialog(null, x, "Open Document Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		} catch (Exception x) {
			JOptionPane.showMessageDialog(null, x,
					"Loading Document Exception", JOptionPane.ERROR_MESSAGE);
			return null;
		} finally {
			try {
				if (fstream != null) {
					fstream.close();
				}
				fstream = null;
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}

	public void save() {
		if (getLocation().equals("")) {
			saveAs(".svg");
		} else {
			// CB added the lines before store() to prevents an open .svg file
			// from being corrupted
			Filter svgInputFilter = new Filter(".svg", sJGoSVGXML);
			if (svgInputFilter.accept(new File(getLocation()))) {
				myDescription = sJGoSVGXML;
			}
			store();
		}
	}

	public void store() {
		if (!getLocation().equals("")) {
			FileOutputStream fstream = null;
			try {
				fstream = new FileOutputStream(getLocation());
				resetValueNodeNames();
				if (myDescription.equals(sJGoSVGXML)) {
					storeSVG1(fstream, true, true);
				} else {
					storeObjects(fstream);
				}
			} catch (Exception x) {
				JOptionPane.showMessageDialog(null, x, "Save Document Error",
						javax.swing.JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (fstream != null) {
						fstream.close();
					}
				} catch (Exception x) {
				}
				setModified(false);
			}
		}
	}

	public void saveAs(String fileType) {
		resetValueNodeNames();
		JFileChooser chooser = new JFileChooser();
		String loc = getLocation();
		// System.out.println( "saveAs: "+loc);
		File currentFile = new File(loc);
		chooser.setCurrentDirectory(currentFile);
		chooser.setAcceptAllFileFilterUsed(false);
		Filter svgFilter1 = new Filter(".svg", sJGoSVGXML);
		chooser.addChoosableFileFilter(svgFilter1);
		if (fileType.equalsIgnoreCase(".svg")) {
			chooser.setFileFilter(svgFilter1);
		}
		int returnVal = chooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String ext = ".svg";
			Filter FileFilter = (Filter) (chooser.getFileFilter());
			myDescription = FileFilter.getDescription();
			ext = FileFilter.getExtension();
			String name = chooser.getSelectedFile().getName();
			setName(name);
			loc = chooser.getSelectedFile().getAbsolutePath();
			String loc2 = loc.toLowerCase();
			if (loc2.indexOf(".") == -1) {
				loc += ext;
			}

			setLocation(loc);
			store();
		}
	}

	public static SchematicDocument importXY(Component parent,
			String defaultLocation) {
		// defaultLocation = "d:/workspace/hecdss/wrims/Schematic/xy/";
		defaultLocation = "c:/ztp/schematic_dss/xy/";
		JFileChooser chooser = new JFileChooser(defaultLocation);
		if ((defaultLocation != null) && (!defaultLocation.equals(""))) {
			File currentFile = new File(defaultLocation);
			chooser.setCurrentDirectory(currentFile);
		} else {
			chooser.setCurrentDirectory(null);
		}
		chooser.setAcceptAllFileFilterUsed(false);
		// Filter svgInputFilter = new Filter(".xy", "Excel converted with
		// html2xy.py filter (*.xy)");
		// chooser.addChoosableFileFilter(svgInputFilter);
		Filter svgInputFilter = new Filter("obj.xy",
				"AutoCAD converted to text import file (*.obj.xy)");
		chooser.addChoosableFileFilter(svgInputFilter);
		chooser.setFileFilter(svgInputFilter);
		int returnVal = chooser.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String name = chooser.getSelectedFile().getName();
			String loc = chooser.getSelectedFile().getAbsolutePath();
			loc.toLowerCase();

			FileInputStream fstream = null;
			try {

				fstream = new FileInputStream(loc);
				SchematicDocument doc = null;
				// if (loc.endsWith(".xy")) {
				// doc = new SchematicDocument();
				// Importer importer = new Importer(doc, loc);
				// //doc.setSuspendUpdates(true);
				// }
				if (loc.endsWith("obj.xy")) {
					doc = new SchematicDocument();
					// ImporterCAD importer = new ImporterCAD(doc, loc, name);
					// doc.setSuspendUpdates(true);
				}

				if (doc == null) {
					return null;
				}
				doc.setName(name);
				doc.updateLocationModifiable();
				doc.updatePaperColor();
				doc.setModified(false);

				// the UndoManager is transient and must be setup again when
				// created from serialization
				// but we also need to ignore all changes up to now anyway,
				// so we'll just throw away the old manager and create a new one
				doc.setUndoManager(new JGoUndoManager());
				return doc;
			} catch (IOException x) {
				JOptionPane.showMessageDialog(null, x, "Open Document Error",
						javax.swing.JOptionPane.ERROR_MESSAGE);
				return null;
			} catch (Exception x) {
				JOptionPane.showMessageDialog(null, x,
						"Loading Document Exception",
						javax.swing.JOptionPane.ERROR_MESSAGE);
				return null;
			} finally {
				try {
					if (fstream != null) {
						fstream.close();
					}
				} catch (Exception x) {
				}
			}
		} else {
			return null;
		}
	}

	static public SchematicDocument loadObjects(InputStream ins)
			throws IOException, ClassNotFoundException {
		ObjectInputStream istream = new ObjectInputStream(ins);
		Object newObj = istream.readObject();
		if (newObj instanceof SchematicDocument) {
			SchematicDocument doc = (SchematicDocument) newObj;
			return doc;
		} else {
			return null;
		}
	}

	public void storeObjects(OutputStream outs) throws IOException {
		ObjectOutputStream ostream = new ObjectOutputStream(outs);
		ostream.writeObject(this);
		ostream.flush();
	}

	static public SchematicDocument loadSVG1(InputStream ins) {
		SchematicDocument doc = new SchematicDocument();
		try {
			DefaultDocument svgDomDoc = new DefaultDocument();
			svgDomDoc.SVGReadDoc(ins, doc);
			doc.loadAllVariablesVector(); // CB added this. Too bad it cannot be
			// loaded in the constructor, but
			// the svg file is not read in yet
			// there.
			doc.loadNameToValueNodeHashtable(); // CB added this. Too bad it
			// cannot be loaded in the
			// constructor, but the svg file
			// is not read in yet there.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public void storeSVG1(OutputStream outs, boolean genXMLExtensions,
			boolean genSVG) {
		DefaultDocument svgDomDoc = new DefaultDocument();
		svgDomDoc.setGenerateJGoXML(genXMLExtensions);
		svgDomDoc.setGenerateSVG(genSVG);
		svgDomDoc.SVGWriteDoc(outs, this);
	}

	public void copyNewValueForRedo(JGoDocumentChangedEdit e) {
		switch (e.getHint()) {
		case NAME_CHANGED:
			e.setNewValue(getName());
			return;
		case LOCATION_CHANGED:
			e.setNewValue(getLocation());
			return;
		default:
			super.copyNewValueForRedo(e);
			return;
		}
	}

	public void changeValue(JGoDocumentChangedEdit e, boolean undo) {
		switch (e.getHint()) {
		case NAME_CHANGED:
			setName((String) e.getValue(undo));
			return;
		case LOCATION_CHANGED:
			setLocation((String) e.getValue(undo));
			return;
		default:
			super.changeValue(e, undo);
			return;
		}
	}

	public void endTransaction(String pname) {
		super.endTransaction(pname);
		SchematicRelatedAction.updateAllActions();
	}

	public void SVGWriteObject(DomDoc svgDoc, DomElement jGoElementGroup) {
		// Add <SchematicDocument> element
		if (svgDoc.JGoXMLOutputEnabled()) {
			DomElement schematicDocElement = svgDoc.createJGoClassElement(
					"wrims.schematic.SchematicDocument", jGoElementGroup);
			schematicDocElement.setAttribute("name", myName);
			schematicDocElement.setAttribute("location", myLocation);
			schematicDocElement.setAttribute("lastid", Integer
					.toString(myLastNodeID));
			if (!svgDoc.isRegisteredReference(myPen)) {
				schematicDocElement.setAttribute("embeddedlinkpen", "true");
				DomElement subGroup = svgDoc.createElement("g");
				schematicDocElement.appendChild(subGroup);
				myPen.SVGWriteObject(svgDoc, subGroup);
				svgDoc.registerReferencingNode(schematicDocElement, "linkpen",
						myPen);
			}
		}
		// Have superclass add to the JGoObject group
		super.SVGWriteObject(svgDoc, jGoElementGroup);
	}

	public DomNode SVGReadObject(DomDoc svgDoc, JGoDocument jGoDoc,
			DomElement svgElement, DomElement jGoChildElement) {
		if (jGoChildElement != null) {
			// This is a <SchematicDocument> element
			myName = jGoChildElement.getAttribute("name");
			myLocation = jGoChildElement.getAttribute("location");
			myLastNodeID = Integer.parseInt(jGoChildElement
					.getAttribute("lastid"));
			if (jGoChildElement.getAttribute("embeddedlinkpen").equals("true")) {
				svgDoc
						.SVGTraverseChildren(jGoDoc, jGoChildElement, null,
								false);
			}
			String pen = jGoChildElement.getAttribute("linkpen");
			svgDoc.registerReferencingObject(this, "linkpen", pen);
			super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());

			super.SVGReadObject(svgDoc, jGoDoc, svgElement, jGoChildElement
					.getNextSiblingJGoClassElement());
		}
		return svgElement.getNextSibling();
	}

	// Constants
	// private static final String schematicTag = "Process";
	// private static final String activityTag = "Activity";
	// private static final String flowTag = "Flow";

	// Event hints
	public static final int NAME_CHANGED = JGoDocumentEvent.LAST + 1;

	public static final int LOCATION_CHANGED = JGoDocumentEvent.LAST + 2;

	// State
	private JGoPen myPen = JGoPen.make(JGoPen.SOLID, 2, Color.black);

	private String myName = "";

	private String myLocation = "";

	private String myDescription = "";

	private int myLastNodeID = -1;

	private transient boolean myIsLocationModifiable = true;

	private transient boolean myIsModified = false;

	private static Component _parent; // CB added

	static final String sJGoSVGXML = "JGo SVG with XML extensions, read/write (*.svg)";
}
