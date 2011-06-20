package wrims.schematic;

import com.nwoods.jgo.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.print.*;
import java.awt.dnd.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.*;

/**
 *
 * @author Tom Pruett for the bulk of it
 * @author Clay Booher
 *
 */
public class SchematicView extends JGoView implements JGoViewListener {
	public SchematicView() {
		super();
	}

	public SchematicView(SchematicDocument doc) {
		super(doc);
		//CB added if/else
		if (doc.getName().toLowerCase().indexOf(".svg") > -1)
			setName(doc.getName().substring(0, doc.getName().toLowerCase().indexOf(".svg")));
		else
			setName(doc.getName());
	}

	public void initialize(Schematic app, JInternalFrame frame) {
		myApp = app;
		myInternalFrame = frame;
		addViewListener(this);
		setGridWidth(10);
		setGridHeight(10);
		updateTitle();
//CB no effect!!		setBackground(Color.WHITE);  //CB tried because was off-white for non-modifiable document

//		if (getDoc() != null) {
//			System.out.println("getDoc() width = " + getDoc().getDocumentSize().width);
//			System.out.println("getDoc() width = " + getDoc().getDocumentSize().height);
//		}
		// cb added background image
		if (!Schematic.IS_DEVELOPER) { //because was coming up off-white!!!!!!!!!!!  Slows it way down even if done right.  If window resized - slow!!!!!!!!!
//		if (false) { //background image is too slow to use for large document
//			InputStream is = getClass().getResourceAsStream("images/white_background_small.jpg"); //too much cpu time to convert!!!
			InputStream is = getClass().getResourceAsStream("images/white_background.jpg"); //too much RAM????  50 GB as of
			if (is != null) {
				BufferedImage backgroundImage = null;
				try {
					backgroundImage = ImageIO.read(is);
//					cleanImage(image);
					//create a JGoImage
					if (backgroundImage != null) {
						JGoImage image = new JGoImage();
						image.setImage(backgroundImage);
						 //image size needs to be same size as the document size!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
						image.setBoundingRect(new Point(0, 0), new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));  //
//						image.setBoundingRect(new Point(0, 0), new Dimension(getDoc().getDocumentSize()));  //TOO MUCH CPU TIME IF DIFF SIZE FROM IMAGE!!!
						JGoLayer defaultLayer = getDoc().getDefaultLayer();
//						JGoObject first = defaultLayer.getObjectAtPos(defaultLayer.getFirstObjectPos()); // a JGoImage!!!!!!!
						if (defaultLayer.getObjectAtPos((defaultLayer.getFirstObjectPos())) instanceof JGoImage)
							defaultLayer.removeObjectAtPos(defaultLayer.getFirstObjectPos()); //remove JGoImage - does not remove off-white background
						image.setSelectable(false);
//temp						defaultLayer.addObjectAtHead(image); //add my background image
						System.out.print("");  //debugging
					}
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}  finally {
					try {
						if (is != null)
							is.close();  // This does not free up the RAM issue above; neither does closing the internal frame!
						is = null;
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
			}
		}

//		System.out.println(getBackground());

		//CB block due to change
//		copy(); //CB added to clear out the copied objects, if any, from the last time the program ran (there have been some seen)
		//CB Now copy() throws some weird NotSerializableException and I was not able to fix it in 5 hours or so
				// copySelection works fine with the same objects, so it appears it is a JGo bug
/*trying		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    Transferable transferable = clipboard.getContents(this);
	    if (transferable instanceof sun.awt.datatransfer.ClipboardTransferable) {
	    	DataFlavor[] flavors = ((sun.awt.datatransfer.ClipboardTransferable)transferable).getTransferDataFlavors();
	    	for (int i = 0; i < flavors.length; ++i) {
	    		System.out.println(flavors[i].getClass());
	    	}
//	    	clipboard.
	    } */


	    changeBackgroundOfWhiteBackgroundToTransparent();  //CB added - only need at most once between schematic alterations

	}

	// creating a SchematicView without specifying a document in the constructor
	// needs to create a SchematicDocument rather than a generic JGoDocument
/*CB not used	public JGoDocument createDefaultModel() {
		return new SchematicDocument();
	} */

	// convenience method--the return value is a SchematicDocument instead
	// of a JGoDocument
	SchematicDocument getDoc() {
		return (SchematicDocument) getDocument();
	}

	Schematic getApp() {
		return myApp;
	}

//CB	JInternalFrame getInternalFrame() { //CB changed frame has a view, from view has a frame logic.
//CB		return myInternalFrame;
//CB	}

	/**
	 * CB added
	 *
	 *
	 */
	public Vector<JGoObject> createSelectionVector(JGoSelection selection) {
		Vector<JGoObject> objects = new Vector<JGoObject>();
		JGoListPosition pos = selection.getFirstObjectPos();

		while (pos != null) {
			objects.add(selection.getObjectAtPos(pos));
			pos = selection.getNextObjectPos(pos);
		}
		return objects;
    }

	// handle DELETE, HOME, and arrow keys as well as the page up/down keys
	public void onKeyEvent(KeyEvent evt) {
		int t = evt.getKeyCode();
		if (t == KeyEvent.VK_DELETE) {
			if (getDoc().isModifiable()) {
				deleteSelection();
			}
		} else if (t == KeyEvent.VK_HOME) {
			setViewPosition(0, 0);
		} else if (t == KeyEvent.VK_RIGHT) {  		     //CB added nudge moves using alt button
			if (getDoc().isModifiable()) {
				if ((evt.getModifiers() & KeyEvent.ALT_MASK) != 0)
					doMoveSelection(0, 1, 0, EventMouseUp);
				else
					doMoveSelection(0, getGridWidth(), 0, EventMouseUp);
			}
		} else if (t == KeyEvent.VK_LEFT) {
			if (getDoc().isModifiable()) {
				if ((evt.getModifiers() & KeyEvent.ALT_MASK) != 0)
					doMoveSelection(0, -1, 0, EventMouseUp);
				else
					doMoveSelection(0, -getGridWidth(), 0, EventMouseUp);
			}
		} else if (t == KeyEvent.VK_DOWN) {
			if (getDoc().isModifiable()) {
				if ((evt.getModifiers() & KeyEvent.ALT_MASK) != 0)
					doMoveSelection(0, 0, 1, EventMouseUp);
				else
					doMoveSelection(0, 0, getGridHeight(), EventMouseUp);
			}
		} else if (t == KeyEvent.VK_UP) {
			if (getDoc().isModifiable()) {
				if ((evt.getModifiers() & KeyEvent.ALT_MASK) != 0)
					doMoveSelection(0, 0, -1, EventMouseUp);
				else
					doMoveSelection(0, 0, -getGridHeight(), EventMouseUp);
			}
		} else if (t == KeyEvent.VK_ESCAPE) {
			getSelection().clearSelection();
		} else {
			super.onKeyEvent(evt);
		}
	}

	// an example of how to implement popup menus
	public boolean doMouseDown(int modifiers, Point dc, Point vc) {
//CB		myMouseUpDocPoint.x = dc.x;
//CB		myMouseUpDocPoint.y = dc.y;
//CB		JGoObject obj = pickDocObject(dc, true);
//CB		if (obj != null && getCurrentMouseEvent() != null
//CB				&& getCurrentMouseEvent().isPopupTrigger()) {
//CB			selectObject(obj);
//CB			return doPopupMenu(modifiers, dc, vc, obj);
//CB		}
		//CB added if block to prevent frustrating auto-selection of nodes without a popup menu during right-click
//CB		if ((modifiers & InputEvent.BUTTON3_MASK) != 0 && obj instanceof NetworkNode && ((NetworkNode)obj).getType() == 1)
//CB			return false;
		// otherwise implement the default behavior
		return super.doMouseDown(modifiers, dc, vc);
//		return true;
	}
	/**
	 * Replaced by <code>doMouseUpint modifiers, Point dc, Point vc)</code>.
	 * @param modifiers
	 * @param dc
	 * @param vc
	 * @return
	 */
	public boolean doMouseUpOld(int modifiers, Point dc, Point vc) {
		myMouseUpDocPoint.x = dc.x;
		myMouseUpDocPoint.y = dc.y;
		JGoObject obj = pickDocObject(dc, true);
		if (obj != null && getCurrentMouseEvent() != null
				&& getCurrentMouseEvent().isPopupTrigger()) {
			deSelectUnlikeObjects((JGoBasicNode)obj); // CB
			getSelection().extendSelection(obj); //CB
//CB		selectObject(obj);
//CB			return doPopupMenu(modifiers, dc, vc, obj);
			return doPopupMenu(modifiers, dc, vc, obj);
		} else { //CB added else block to paste at particular location if not right-clicked on a JGoObject; otherwise ...
			if (obj != null && getCurrentMouseEvent() != null) {
				if (!getCurrentMouseEvent().isPopupTrigger())
					getSelection().clearSelection();
				else
					return doPopupMenu(modifiers, dc, vc, null);
			} else {
				deSelectUnlikeObjects((JGoBasicNode)obj); // CB
				getSelection().extendSelection(obj); //CB
			}
		}
		// otherwise implement the default behavior
		return super.doMouseUp(modifiers, dc, vc);
	}

	/**
	 * CB rewrote entire method to do it a little differently and additional functions.
	 */
	public boolean doMouseUp(int modifiers, Point dc, Point vc) {
		myMouseUpDocPoint.x = dc.x;
		myMouseUpDocPoint.y = dc.y;
//		System.out.println("(" + dc.x + ", " + dc.y + ")");
		JGoObject obj = pickDocObject(dc, true);
		if (getCurrentMouseEvent() != null) {
			if (obj != null) {
				if (getCurrentMouseEvent().isPopupTrigger() && obj instanceof JGoBasicNode) {
					if (!(obj instanceof ValueNode)) {
						deSelectUnlikeObjects((JGoBasicNode)obj); // CB
						getSelection().extendSelection(obj); //CB
						return doPopupMenu(modifiers, dc, vc, obj);
					} else {
						return false;
					}
				} else if (!(obj instanceof JGoImage)) {
					if (getCurrentMouseEvent().isControlDown())
						getSelection().toggleSelection(obj); //CB
					else if (getCurrentMouseEvent().isShiftDown())
						getSelection().extendSelection(obj); //CB
					else {
						getSelection().clearSelection();
						getSelection().extendSelection(obj); //CB
					}
//					System.out.println("number of selected objects = " + getSelection().getNumObjects());
					return true;
				}
			} else { //No object under mouse click - deselect selected objects OR show paste popup menu if it is desired
				if (!getCurrentMouseEvent().isPopupTrigger()) {
					getSelection().clearSelection();
//					return true;  //CB testing
				} else //for pasting copied objects at particular location in the view
					return doPopupMenu(modifiers, dc, vc, null);
			}
		}
		// otherwise implement the default behavior
		return super.doMouseUp(modifiers, dc, vc);
	}

	public boolean doMouseDblClick(int modifiers, Point dc, Point vc) {
		JGoObject obj = pickDocObject(dc, false);
		if (obj == null) {
			JOptionPane.showInternalMessageDialog(this,
					"The diagram background has no editable properties",
					"information", JOptionPane.INFORMATION_MESSAGE);
		}
		return super.doMouseDblClick(modifiers, dc, vc);
	}

	/**
	 * CB added.
	 * @param obj
	 */
	private void deSelectUnlikeObjects(JGoBasicNode obj) {  //CB TODO:  Abstract Reservoir class with multiple subclasses for various reservoir types!
		Vector<JGoBasicNode> likeObjects = new Vector<JGoBasicNode>(); //CB TODO:  Abstract NetworkNode class with multiple subclasses for various node types!
		JGoBasicNode object = null;
		JGoListPosition position = getSelection().getFirstObjectPos();

		while (position != null
				&& getSelection().getObjectAtPos(position) instanceof JGoBasicNode) {
			object = (JGoBasicNode)getSelection().getObjectAtPos(position);
//			System.out.println("obj class = " + obj.getClass());
			if (obj instanceof NetworkNode) {
//				System.out.println("obj type = " + ((NetworkNode)obj).getType());
				if ((((NetworkNode)obj).getType() == NetworkNode.LRESERVOIR
						|| ((NetworkNode)obj).getType() == NetworkNode.RRESERVOIR
						|| ((NetworkNode)obj).getType() == NetworkNode.RESERVOIR
						|| ((NetworkNode)obj).getType() == NetworkNode.URESERVOIR
						|| ((NetworkNode)obj).getType() == NetworkNode.LRESERVOIR_NOTUSED
						|| ((NetworkNode)obj).getType() == NetworkNode.RRESERVOIR_NOTUSED
						|| ((NetworkNode)obj).getType() == NetworkNode.RESERVOIR_NOTUSED
						|| ((NetworkNode)obj).getType() == NetworkNode.URESERVOIR_NOTUSED)) {
					if (object instanceof NetworkNode
							&& (((NetworkNode)object).getType() == NetworkNode.LRESERVOIR
							|| ((NetworkNode)object).getType() == NetworkNode.RRESERVOIR
							|| ((NetworkNode)object).getType() == NetworkNode.RESERVOIR
							|| ((NetworkNode)object).getType() == NetworkNode.URESERVOIR
							|| ((NetworkNode)object).getType() == NetworkNode.LRESERVOIR_NOTUSED
							|| ((NetworkNode)object).getType() == NetworkNode.RRESERVOIR_NOTUSED
							|| ((NetworkNode)object).getType() == NetworkNode.RESERVOIR_NOTUSED
							|| ((NetworkNode)object).getType() == NetworkNode.URESERVOIR_NOTUSED)) {
						likeObjects.add(object);
					}
				} else if (((NetworkNode)obj).getType() == NetworkNode.VARIABLE) {
					if ((object instanceof NetworkNode
							&& ((NetworkNode)object).getType() == NetworkNode.VARIABLE
							|| ((NetworkNode)obj).getType() == NetworkNode.LRESERVOIR
							|| ((NetworkNode)obj).getType() == NetworkNode.RRESERVOIR
							|| ((NetworkNode)obj).getType() == NetworkNode.RESERVOIR
							|| ((NetworkNode)obj).getType() == NetworkNode.URESERVOIR
							|| ((NetworkNode)obj).getType() == NetworkNode.LRESERVOIR_NOTUSED
							|| ((NetworkNode)obj).getType() == NetworkNode.RRESERVOIR_NOTUSED
							|| ((NetworkNode)obj).getType() == NetworkNode.RESERVOIR_NOTUSED
							|| ((NetworkNode)obj).getType() == NetworkNode.URESERVOIR_NOTUSED)
							|| object instanceof ValueNode) {
						likeObjects.add(object);
					}
				}
			} else if (obj.getClass() == ValueNode.class) {
				if (object.getClass() == ValueNode.class || (object.getClass() == NetworkNode.class
						&& ((NetworkNode)object).getType() == NetworkNode.VARIABLE))
					likeObjects.add(object);
			}
			position = getSelection().getNextObjectPos(position);
		}
		getSelection().clearSelection();
		Enumeration<JGoBasicNode> likeObjectEnum = likeObjects.elements();
		while (likeObjectEnum.hasMoreElements()) {
			getSelection().extendSelection((JGoBasicNode)likeObjectEnum.nextElement());
		}
	}

	/**
	 * Resets ValueNode labels to their original label.  This must be called before saving.
	 */
	void resetValueNodeNames() { //CB added
		getDoc().resetValueNodeNames();
/*		JGoBasicNode object = null;
		JGoListPosition position = getSelection().getFirstObjectPos();
		while (position != null) {
			object = (JGoBasicNode)getSelection().getObjectAtPos(position);
			if (object instanceof ValueNode)
				((ValueNode)object).resetLabel();
			position = getSelection().getNextObjectPos(position);
		} */
	}

	// CB changed this to have consistent implementation between nodes and arcs
	public boolean doPopupMenu(int modifiers, Point dc, Point vc, JGoObject obj) {
		JPopupMenu popup = null;
		if (obj != null) {
			if (obj instanceof JGoLinkLabel) {
				obj = ((JGoLinkLabel) obj).getPartner(); // CB
			}
			if (obj instanceof NetworkNode) {
				popup = ((NetworkNode) obj).getPopup(); // CB
			} else if (obj instanceof JGoLink) {
				if (obj instanceof Arc)
					popup = ((Arc) obj).getPopup(); // CB
				else if (obj instanceof Link)
					popup = ((Link) obj).getPopup(); // CB
				if (popup == null)
					return false;
				popup.addSeparator();
				if (Schematic.IS_DEVELOPER)  //CB added
					popup.add(insertPointAction);
				if (Schematic.IS_DEVELOPER) { //CB added check
					if (((JGoLink) obj).getNumPoints() > (((JGoLink) obj)
							.isOrthogonal() ? 6 : 2))
						popup.add(removeSegmentAction);
				}
//				popup.addSeparator();
			} else {
				popup = new JPopupMenu();  //CB trying to popup on JBasicNode because left click no longer allows text editing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
			if (popup != null) {
				if (Schematic.IS_DEVELOPER) {  //CB added
					popup.addSeparator();
					popup.add(getApp().CopyAction);
					popup.add(getApp().CutAction);
				}
				copyPoint = new Point(vc.x, vc.y);
				popup.insert(getApp().ObjectPropertiesAction, 0);
				if (popup.getComponentCount() > 1)
					popup.insert(new JPopupMenu.Separator(), 1);
				if (Schematic.IS_DEVELOPER) {
					popup.insert(new JPopupMenu.Separator(), 1);
					popup.insert(getApp().LinkObjectsForDSSAction, 1);  //CB added
				}
				popup.show(this, vc.x, vc.y);
				return true;
			}
		} else {
			if (Schematic.IS_DEVELOPER && canPaste()) {
				popup = new JPopupMenu();
				popup.add(getApp().PasteAction);
				popup.show(this, vc.x, vc.y);
				return true;
			}
		}
		return false;
	}

	SchematicRelatedAction insertPointAction = new SchematicRelatedAction("Insert Point", getApp()) {
		public void actionPerformed(ActionEvent e) {
			insertPointIntoLink();
		}

		public boolean canAct() {
			// return super.canAct() && getView().getDoc().isModifiable();
			if (getView() != null && getView().getDoc() != null)
				return super.canAct() && getView().getDoc().isModifiable();
			else
				return false;
		}
	};

	SchematicRelatedAction removeSegmentAction = new SchematicRelatedAction("Remove Segment", getApp()) {
		public void actionPerformed(ActionEvent e) {
			removeSegmentFromLink();
		}

		public boolean canAct() {
			// return super.canAct() && getView().getDoc().isModifiable();
			if (getView() != null && getView().getDoc() != null)
				return super.canAct() && getView().getDoc().isModifiable();
			else
				return false;
		}
	};

	// popup menu commands
	void insertPointIntoLink() {
		if (getSelection().getPrimarySelection() instanceof JGoLink) {
			JGoLink s = (JGoLink) getSelection().getPrimarySelection();
			int i = s.getSegmentNearPoint(myMouseUpDocPoint);
			if (s.getNumPoints() > 3) {
				if (i < 1)
					i = 1; // don't add to first segment
				else if (i >= s.getNumPoints() - 2)
					i = s.getNumPoints() - 3; // don't add to last segment
			}
			Point a = s.getPoint(i);
			Point b = s.getPoint(i + 1);
			Point closest = new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
			getDocument().startTransaction();
			s.insertPoint(i + 1, closest);
			if (s.isOrthogonal()) // when orthogonal, gotta insert two points
				s.insertPoint(i + 1, closest);
			getSelection().toggleSelection(s);
			selectObject(s);
			getDocument().endTransaction("inserted point into link stroke");
		}
	}

	void removeSegmentFromLink() {
		if (getSelection().getPrimarySelection() instanceof JGoLink) {
			JGoLink s = (JGoLink) getSelection().getPrimarySelection();
			int i = s.getSegmentNearPoint(myMouseUpDocPoint);
			getDocument().startTransaction();
			if (s.isOrthogonal()) { // will have at least 7 points
				// don't remove either first two or last two segments
				i = Math.max(i, 2);
				i = Math.min(i, s.getNumPoints() - 5);
				Point a = s.getPoint(i);
				Point b = s.getPoint(i + 1);
				s.removePoint(i);
				// to maintain orthogonality, gotta remove two points
				s.removePoint(i);
				// now fix up following point to maintain orthogonality
				// Point c = new Point(s.getPoint(i));
				Point c = new Point(s.getPoint(i).x, s.getPoint(i).y);
				if (a.x == b.x) {
					c.y = a.y;
				} else {
					c.x = a.x;
				}
				s.setPoint(i, c);
			} else { // will have at least 3 points
				i = Math.max(i, 1); // don't remove point 0
				i = Math.min(i, s.getNumPoints() - 2); // don't remove last
				// point
				s.removePoint(i);
			}
			getSelection().toggleSelection(s);
			selectObject(s);
			getDocument().endTransaction("removed segment from link stroke");
		}
	}

	// implement JGoViewListener
	// just need to keep the actions enabled appropriately
	// depending on the selection
	public void viewChanged(JGoViewEvent e) {
		// if the selection changed, maybe some commands need to
		// be disabled or re-enabled
//		System.out.println("event type = " + e.getHint());
		switch (e.getHint()) {
		case JGoViewEvent.UPDATE_ALL:
		case JGoViewEvent.SELECTION_GAINED:
		case JGoViewEvent.SELECTION_LOST:
		case JGoViewEvent.SCALE_CHANGED:
			SchematicRelatedAction.updateAllActions();
			break;
		case JGoViewEvent.CLIPBOARD_PASTED:  //CB added section to paste and in relation to the right-click location
//			System.out.println("copyPoint = (" + copyPoint.x + ", " + copyPoint.y + ")");
//			System.out.println("myMouseUpDocPoint = (" + myMouseUpDocPoint.x + ", " + myMouseUpDocPoint.y + ")");
			JGoListPosition nextPosition = getSelection().getFirstObjectPos();
			JGoObject nextObject;
			boolean containsVariable = false;  //CB added for triggering call to loadAllVariablesVector()
			JGoObject primary = getSelection().getPrimarySelection();
			if (primary == null) break;
			if (primary instanceof NetworkNode  //CB added for triggering call to loadAllVariablesVector()
					&& ((NetworkNode)primary).getType() == NetworkNode.VARIABLE)
				containsVariable = true;
			boolean containsValueNode = false;  //CB added for triggering call to loadNameToValueNodeHashtable()
			if (primary instanceof ValueNode)  //CB added for triggering call to loadNameToValueNodeHashtable()
				containsValueNode = true;
//			System.out.println("primarySelection Point = (" + primary.getLocation().x + ", " + primary.getLocation().y + ")");
			int diffX = myMouseUpDocPoint.x - primary.getLocation().x;
			int diffY = myMouseUpDocPoint.y - primary.getLocation().y;
			while (nextPosition != null) {
				nextObject = getSelection().getObjectAtPos(nextPosition);
				if (!containsVariable && nextObject instanceof NetworkNode  //CB added for triggering call to loadAllVariablesVector()
						&& ((NetworkNode)nextObject).getType() == NetworkNode.VARIABLE)
					containsVariable = true;
				if (!containsValueNode && nextObject instanceof ValueNode)  //CB added for triggering call to loadNameToValueNodeHashtable()
					containsValueNode = true;
				if (nextObject != null) {
						nextObject.setLocation(nextObject.getLocation().x + diffX, nextObject.getLocation().y + diffY);
				}
				nextPosition = getSelection().getNextObjectPos(nextPosition);
			}
			getSelection().clearSelection();
			if (containsVariable)
				getDoc().loadAllVariablesVector();
			if (containsValueNode)
				getDoc().loadNameToValueNodeHashtable();
			break;
		}
	}

	// implement JGoDocumentListener
	// here we just need to keep the title bar up-to-date
	public void documentChanged(JGoDocumentEvent evt) {
		if ((evt.getHint() == SchematicDocument.NAME_CHANGED)
				|| (evt.getHint() == JGoDocumentEvent.MODIFIABLE_CHANGED)) {
			updateTitle();
		} else if (evt.getHint() == JGoDocumentEvent.INSERTED
				|| evt.getHint() == JGoDocumentEvent.REMOVED) {
			if (evt.getObject() instanceof NetworkNode    //CB added to reload variables vector upon variable number change
					&& ((NetworkNode)evt.getObject()).getType() == NetworkNode.VARIABLE)
				getDoc().loadAllVariablesVector();
			else if (evt.getObject() instanceof ValueNode)  //CB added to reload valuenode Hashtable upon value node number change
				getDoc().loadNameToValueNodeHashtable();
		}
		super.documentChanged(evt);
	}

	// have the title bar for the internal frame include the name
	// of the document and whether it's read-only
	public void updateTitle() {
/*CB		if (getInternalFrame() != null) {
			String title = getDoc().getName();
			if (!getDocument().isModifiable())
				title += " (read-only)";
			getInternalFrame().setTitle(title);
			getInternalFrame().repaint();
		} */
//		CB replacement block cause I changed frame to have a view from view having a frame
		JInternalFrame[] frames = myApp.getDesktop().getAllFrames();
		for (int i = 0; i < frames.length; ++i) {
			if (frames[i] instanceof WrimsSchematicInternalFrame) {
				if (((WrimsSchematicInternalFrame)frames[i]).getView() == this) {
					String title = getDoc().getName();
					if (!getDocument().isModifiable())
						title += " (read-only)";
					frames[i].setTitle(title);
					frames[i].repaint();
				}
			}
		}
	}

	public void newLink(JGoPort from, JGoPort to) {
//		System.out.println("From: " + from.getParent());
//		System.out.println("To: " + to.getParent());
		Object fobj = from.getParent();
		Object tobj = to.getParent();

		String s = "";
//		System.out.println("entering newLink of SchematicView"); //CB debugging
		if (fobj instanceof NetworkNode || tobj instanceof NetworkNode) {
			if (myApp.getPalette() == myApp.getPalette(0)) { //CB added if/else for CAD vs. non-CAD type document
				Arc a = null;
				a = new Arc(from, to, true);
//CB temp?				a.initialize("label");
				a.initialize("");
				getDoc().addObjectAtTail(a);
				fireUpdate(JGoViewEvent.LINK_CREATED, 0, a);
			} else {  //CB added block
				Arc arc = null; //CB temporary for debugging
//				Link link = null;  //CB Link add to tail below FAILS!
				if (!(fobj instanceof NetworkNode) || !(tobj instanceof NetworkNode)) {
					arc = new Arc(from, to, false, Arc.SPILL);
					arc.initialize(null, false, false);
//					System.out.println("arc between USGS type and network node");
				} else {
//					System.out.println("from NetworkNode type = " + ((NetworkNode)fobj).getType());
//					System.out.println("to NetworkNode type = " + ((NetworkNode)tobj).getType());
					boolean isFromNodeVariableType = (((NetworkNode)fobj).getType() == NetworkNode.VARIABLE);
					boolean isToNodeVariableType = (((NetworkNode)tobj).getType() == NetworkNode.VARIABLE);
					if (((NetworkNode)fobj).getType() == NetworkNode.NETWORK
							&& ((NetworkNode)tobj).getType() == NetworkNode.NETWORK) {
//						if (((NetworkNode)fobj).getPen().getStyle() == JGoPen.DOTTED
//								|| ((NetworkNode)tobj).getPen().getStyle() == JGoPen.DOTTED) {
						if (((NetworkNode)fobj).getStrokeColor().equals(Color.WHITE)
								|| ((NetworkNode)tobj).getStrokeColor().equals(Color.WHITE)) {
							arc = new Arc(from, to, false, Arc.FUTURE);
//							if (((NetworkNode)tobj).getType() == NetworkNode.VARIABLE)
								arc.initialize(null, false);
//							else
//								arc.initialize(null, true);
						} else if (((NetworkNode)tobj).getStrokeColor().equals(((NetworkNode)fobj).getStrokeColor())) {
							//CB added section for module boundaries and LCPSIM nodes
							int type = 0;
							if (((NetworkNode)tobj).getStrokeColor().equals(Color.GREEN))
								type = Arc.MODULE_BOUNDARY;
							else if (((NetworkNode)tobj).getStrokeColor().equals(Schematic.VIOLET))
								type = Arc.LCPSIM;
							else if (((NetworkNode)tobj).getStrokeColor().equals(Color.WHITE))
								type = Arc.LCPSIM_DASHED;
							arc = new Arc(from, to, false, type);
							arc.initialize(null, false);
						}
					} else if (isToNodeVariableType && isFromNodeVariableType) { // CB added only for old name type nodes liked to new name type
						if (((NetworkNode)tobj).getFillColor() != null && ((NetworkNode)tobj).getFillColor().equals(Color.YELLOW)
								|| (((NetworkNode)fobj).getFillColor() != null && ((NetworkNode)fobj).getFillColor().equals(Color.YELLOW))) {
							int type = type = Arc.OLD_TO_NEW;
							arc = new Arc(from, to, false, type);
							arc.initialize(null, false, false);
						}
					} else if (isToNodeVariableType) {
						int type = 0;
						if (((NetworkNode)tobj).getStrokeColor().equals(Color.CYAN)) type = Arc.INFLOW;
						else if (((NetworkNode)tobj).getStrokeColor().equals(Color.BLUE))
							if (((NetworkNode)tobj).getStrokeStyle() == JGoPen.DOTTED)
								type = Arc.FUTURE;
							else
								type = Arc.RIVER;
						else if (((NetworkNode)tobj).getStrokeColor().equals(Schematic.ARC_GREEN)) type = Arc.RETURN;
						else if (((NetworkNode)tobj).getStrokeColor().equals(Color.RED)) type = Arc.DIVERSION;
						else if (((NetworkNode)tobj).getStrokeColor().equals(Color.BLACK)) type = Arc.SPILL;
						else if (((NetworkNode)tobj).getStrokeColor().equals(Color.GRAY)) type = Arc.CHANNEL;
//						else if (((NetworkNode)tobj).getStrokeColor().equals(Schematic.ALMOST_YELLOW)) type = Arc.BYPASS;   //CB added
						else if (((NetworkNode)tobj).getStrokeColor().equals(Schematic.MUSTARD)) type = Arc.BYPASS;  //CB added
						else if (((NetworkNode)tobj).getStrokeColor().equals(Color.MAGENTA)) type = Arc.GWGW;  //CB added
						else if (((NetworkNode)tobj).getStrokeColor().equals(Schematic.VIOLET)) type = Arc.LCPSIM;  //CB added
						else if (((NetworkNode)tobj).getStrokeColor().equals(Color.GREEN)) type = Arc.MODULE_BOUNDARY;  //CB added
						else if (((NetworkNode)tobj).getStrokeColor().equals(Color.WHITE)) type = Arc.LCPSIM_DASHED;  //CB added
						arc = new Arc(from, to, false, type);
	//					link = new Link(from, to, type);  //CB addObjectAtTail(link) below FAILS!
//						System.out.println("tobj is VARIABLE type; arc type is " + type);
						arc.initialize(null, false);
	//					link.initialize(false);  //CB Link add to tail below FAILS!
					} else if (isFromNodeVariableType) {
						int type = 0;
						if (((NetworkNode)fobj).getStrokeColor().equals(Color.CYAN)) type = Arc.INFLOW;
						else if (((NetworkNode)fobj).getStrokeColor().equals(Color.BLUE))
							if (((NetworkNode)tobj).getStrokeStyle() == JGoPen.DOTTED)
								type = Arc.FUTURE;
							else
								type = Arc.RIVER;
						else if (((NetworkNode)fobj).getStrokeColor().equals(Schematic.ARC_GREEN)) type = Arc.RETURN;
						else if (((NetworkNode)fobj).getStrokeColor().equals(Color.RED)) type = Arc.DIVERSION;
						else if (((NetworkNode)fobj).getStrokeColor().equals(Color.BLACK)) type = Arc.SPILL;
						else if (((NetworkNode)fobj).getStrokeColor().equals(Color.GRAY)) type = Arc.CHANNEL;
//						else if (((NetworkNode)fobj).getStrokeColor().equals(Schematic.ALMOST_YELLOW)) type = Arc.BYPASS;   //CB added
						else if (((NetworkNode)fobj).getStrokeColor().equals(Schematic.MUSTARD)) type = Arc.BYPASS;   //CB added
						else if (((NetworkNode)fobj).getStrokeColor().equals(Color.MAGENTA)) type = Arc.GWGW;  //CB added
						else if (((NetworkNode)fobj).getStrokeColor().equals(Schematic.VIOLET)) type = Arc.LCPSIM;  //CB added
						else if (((NetworkNode)fobj).getStrokeColor().equals(Color.GREEN)) type = Arc.MODULE_BOUNDARY;  //CB added
						else if (((NetworkNode)fobj).getStrokeColor().equals(Color.WHITE)) type = Arc.LCPSIM_DASHED;  //CB added
						arc = new Arc(from, to, false, type);
	//					link = new Link(from, to, type);  //CB Link add to tail below FAILS!
//						System.out.println("fobj is VARIABLE type; arc type is " + type);
	//					link.initialize();   //CB Link add to tail below FAILS!
						if (tobj instanceof NetworkNode && ((NetworkNode)tobj).getType() == NetworkNode.VARIABLE) {
							arc.initialize(null, false);
						} else
							arc.initialize(null, true);
					} else if (((NetworkNode)tobj).getType() == NetworkNode.GWSTORAGE) {
						if (((NetworkNode)fobj).getType() == NetworkNode.NETWORK
								|| ((NetworkNode)fobj).getType() == NetworkNode.DEMAND
								|| ((NetworkNode)fobj).getType() == NetworkNode.DEMAND_ALT) {
							//CB added section - temp fix?
							int type = Arc.GWSW;
							arc = new Arc(from, to, false, type);
							arc.initialize(null, true);
						}
					} else { //CB added section
	//					link = new Link(from, to, Link.SPILL);  //CB Link add to tail below FAILS!
	//					link.initialize(false);  //CB Link add to tail below FAILS!
						arc = new Arc(from, to, false, Arc.SPILL);
						arc.initialize(null, false);
//						System.out.println("arc type is " + Arc.SPILL);
					}
				}
//				getDoc().addObjectAtTail(link);  //CB Link add FAILS!
				getDoc().addObjectAtTail(arc);
//				fireUpdate(JGoViewEvent.LINK_CREATED, 0, link);  //CB Link add FAILS!
				fireUpdate(JGoViewEvent.LINK_CREATED, 0, arc);
			}
//CB			s = "new Link";
			s = "new Arc";  //CB
			/*
			 * Link a = new Link(from, to); a.initialize("label");
			 * getDoc().addObjectAtTail(a); s = "new Link";
			 * fireUpdate(JGoViewEvent.LINK_CREATED, 0, a);
			 *
			 * JGoLink link = new JGoLink(from, to); //link.initialize("label");
			 * getDoc().addObjectAtTail(link); s = "new Link";
			 * fireUpdate(JGoViewEvent.LINK_CREATED, 0, link);
			 */
		}
		getDoc().endTransaction(s);
	}

	// the default place to put stuff if not dragged there
	public Point getDefaultLocation() {
		// to avoid constantly putting things in the same place,
		// keep shifting the default location
		if (myDefaultLocation != null) {
			myDefaultLocation.x += 10;
			myDefaultLocation.y += 10;
		}
		return myDefaultLocation;
	}

	public void setDefaultLocation(Point loc) {
		myDefaultLocation = loc;
	}

	// although we use the standard drag-and-drop behavior, we do
	// want to modify the objects that are dropped
	public void drop(DropTargetDropEvent e) {
		// try standard drop action
		JGoCopyEnvironment map = getDocument().createDefaultCopyEnvironment();
		getDocument().startTransaction();
		if (getDocument().isModifiable() && doDrop(e, map)) {
			// for this demo application, we need to modify the copied objects
			// to make them a standard size and draggable
			Iterator i = map.values().iterator();
			while (i.hasNext()) {
				Object o = i.next();
				// CB - changed ActivityNode class to JGoObject class in the following block
				if (o instanceof JGoObject) {
					JGoObject jgoObject = (JGoObject) o;
//CB					jgoObject.setSize(JGoObject.getStdSize());//getStdSize() does not exist for JGoObject
//CB					jgoObject.resetEditability();  //resetEditability() does not exist for JGoObject
					snapObject(jgoObject);
				}
			}
			fireUpdate(JGoViewEvent.EXTERNAL_OBJECTS_DROPPED, 0, null);
			getDocument().endTransaction("Drop");
		} else {
			e.rejectDrop();
			getDocument().endTransaction(false);
		}
	}

	// bring up the appropriate dialog, based on the current selection
	void editObjectProperties() {
		JGoSelection sel = getSelection();
		if (sel.isEmpty()) {
			getApp().editSchematicProperties();
			return;
		}

		getDocument().startTransaction();

		JGoListPosition pos = sel.getFirstObjectPos();
		while (pos != null) {
			JGoObject obj = sel.getObjectAtPos(pos);
			pos = sel.getNextObjectPos(pos);

			// System.out.println( "editObjectProperties: "+obj);

			if (!obj.isTopLevel())
				continue;
			if (Schematic.IS_DEVELOPER && obj instanceof Link)
				editLink((Link) obj);
			else if (Schematic.IS_DEVELOPER && obj instanceof Arc)
				editArc((Arc) obj);
			else if (obj instanceof NetworkNode)
				editNetworkNode((NetworkNode) obj);
			//CB TODO: extend JGoBasicNode and use it for all below XXXX[X]Node classes' superclass OR add an interface and implement???
			else if (Schematic.IS_DEVELOPER && obj instanceof TextNode)
				editTextNode((TextNode) obj);
			else if (obj instanceof GageNode)
				editGageNode((GageNode) obj);
			else if (Schematic.IS_DEVELOPER && obj instanceof ValueNode)
				editValueNode((ValueNode) obj);
		}

		getDocument().endTransaction("Object Properties");
	}

	/**
	 * CB added
	 * Allows the linking or connecting of a variable with two alternative output objects for
	 * viewing DSS data for a single period at a time.
	 */
	void linkObjectsForDSS() {
		JGoSelection sel = getSelection();
		if (sel.isEmpty()) {
			getApp().editSchematicProperties();
			return;
		}
		getDocument().startTransaction();

		JGoListPosition pos = sel.getFirstObjectPos();
		int selectedNetworkNodeObjectCount = 0;
		int selectedValueNodeObjectCount = 0;
		String variableName = null;
		ValueNode[] valueNodes = new ValueNode[2];
		while (pos != null) {
			JGoObject obj = sel.getObjectAtPos(pos);
			pos = sel.getNextObjectPos(pos);

			if (!obj.isTopLevel())
				continue;
			if (obj instanceof NetworkNode && ((NetworkNode)obj).getType()
					== NetworkNode.VARIABLE) {
				++selectedNetworkNodeObjectCount;
				if (selectedNetworkNodeObjectCount > 1) {
					JOptionPane.showMessageDialog(null,
						"Three justaposed boxes, two of them value boxes, are required",
						"Too Many Variable Selected!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				variableName = ((NetworkNode)obj).getText();
			} else if (obj instanceof ValueNode) {
				if (((ValueNode)obj).getName().toLowerCase().indexOf("alt.") > -1) {
					++selectedValueNodeObjectCount;
					if (selectedValueNodeObjectCount > 2) {
						JOptionPane.showMessageDialog(null,
							"Three justaposed boxes, two of them value boxes, are required",
							"Too Many Alternative Value Boxes Selected!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					valueNodes[selectedValueNodeObjectCount - 1] = (ValueNode)obj;
				}
			}

		}
		if (selectedValueNodeObjectCount != 2) {
			if (selectedValueNodeObjectCount > 2) {
				JOptionPane.showMessageDialog(null,
					"Three justaposed boxes, two of them alternatives, are required",
					"Too Many Alternative Value Boxes Selected!", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		for (int i = 0; i < valueNodes.length; ++i) {
			if (valueNodes[i] != null) {
				valueNodes[i].setLinkName(variableName);
				if (i == valueNodes.length - 1)
					JOptionPane.showMessageDialog(null,
							"Linking successful",
							"Linking successful!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"Linking unsuccessful - only " + i + " value box is selected",
						"Linking Not Successful", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		getDocument().endTransaction("Link Objects");
	}

	/**
	 * CB added because the superclass' selectAll() method does not fully work -
	 * probably due to Arcs with null labels.  Anyway, it would select everything
	 * (including children) which is not necessary for moving everything.
	 * This allows a user to select all normally selectable objects for moving all at once.
	 */
	public void selectAll() {
		getSelection().clearSelection();
		JGoListPosition position = getDocument().getFirstObjectPos();
		if (position == null) return;
		JGoObject object = null;
		do {
			object = getDocument().getObjectAtPos(position);
			if (object == null) return;
			if (object instanceof JGoBasicNode) {
				getSelection().extendSelection(object);
			}
			position = getDocument().getNextObjectPos(position);
		} while (position != null);
	}

	/**
	 *
	 */
	public void changeBackgroundOfWhiteBackgroundToTransparent() {
		getSelection().clearSelection();
		JGoListPosition position = getDocument().getFirstObjectPos();
		if (position == null) return;
		JGoObject object = null;
		do {
			object = getDocument().getObjectAtPos(position);
			if (object == null) return;
//			System.out.println(((JGoBasicNode)object).getBrush());
//			System.out.println(((JGoBasicNode)object).getBrush().getColor());
			try {
				if (object instanceof JGoBasicNode) {
//					if (object == null)
//						System.out.println("null object");
					if (((JGoBasicNode)object).getDrawable() == null) { // a bad object (found one in whole doc once)
//						System.out.println("null drawable for " + ((JGoBasicNode)object).getText());
						getDocument().removeObjectAtPos(position);
						return;
					}
					if (((JGoBasicNode)object).getBrush() != null) {
						if (((JGoBasicNode)object).getBrush().getColor() != null
							&& ((JGoBasicNode)object).getBrush().getColor().equals(Color.WHITE))
						((JGoBasicNode)object).setBrush(null);
					}
				}
			} catch (NullPointerException npe) {
				npe.printStackTrace();
				System.out.print("");
			}
			position = getDocument().getNextObjectPos(position);
		} while (position != null);
	}

	void editLink(Link link) {
		LinkDialog d = new LinkDialog(getFrame(), link);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
	}

	void editArc(Arc link) {
		ArcDialog d = new ArcDialog(getFrame(), link);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
	}

	void editTextNode(TextNode node) {
		NodeDialog d = new NodeDialog(getFrame(), node);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
	}

	void editGageNode(GageNode node) {
		NodeDialog d = new NodeDialog(getFrame(), node);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
	}

	/**
	 * CB added.
	 * @param node
	 */
	void editValueNode(ValueNode node) {
		NodeDialog d = new NodeDialog(getFrame(), node);  //CB don't want for a value box?
		d.setLocationRelativeTo(null);
		d.setVisible(true);
	}

	void editNetworkNode(NetworkNode node) {
		// System.out.println("Network Node: "+node.getNodeType());
		/*
		 * switch(node.getNodeType()) { case NetworkNode.Network: break; case
		 * NetworkNode.Demand: JOptionPane.showInternalMessageDialog(this, "A
		 * Demand Unit has no editable properties", "information",
		 * JOptionPane.INFORMATION_MESSAGE); break; case NetworkNode.Reservoir:
		 * JOptionPane.showInternalMessageDialog(this, "A Reservoir node has no
		 * editable properties", "information",
		 * JOptionPane.INFORMATION_MESSAGE); break; case NetworkNode.Variable:
		 * JOptionPane.showInternalMessageDialog(this, "A Variable has no
		 * editable properties", "information",
		 * JOptionPane.INFORMATION_MESSAGE); break; case NetworkNode.Boundary:
		 * JOptionPane.showInternalMessageDialog(this, "A Boundary has no
		 * editable properties", "information",
		 * JOptionPane.INFORMATION_MESSAGE); break; case NetworkNode.DWR:
		 * JOptionPane.showInternalMessageDialog(this, "A DSA Outflow Point has
		 * no editable properties", "information",
		 * JOptionPane.INFORMATION_MESSAGE); break; case NetworkNode.Plant:
		 * JOptionPane.showInternalMessageDialog(this, "A Plant has no editable
		 * properties", "information", JOptionPane.INFORMATION_MESSAGE); break;
		 */

//		Color back = getBackground();
		
//		System.out.println(back); //shows a white background for non-modifiable document when it appears light gray!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		switch (node.getType()) {
		case NetworkNode.NETWORK:
		case NetworkNode.DEMAND:
		case NetworkNode.DEMAND_ALT:
		case NetworkNode.RESERVOIR:
		case NetworkNode.RRESERVOIR: //CB changed VRESERVOIR to RRESERVOIR
		case NetworkNode.LRESERVOIR: //CB added
		case NetworkNode.URESERVOIR: //CB added
		case NetworkNode.RESERVOIR_NOTUSED: //CB added
		case NetworkNode.RRESERVOIR_NOTUSED: //CB added
		case NetworkNode.LRESERVOIR_NOTUSED: //CB added
		case NetworkNode.URESERVOIR_NOTUSED: //CB added
		case NetworkNode.GWSTORAGE:  //CB added
		case NetworkNode.LCPSIMSTORAGE:  //CB added
		case NetworkNode.VARIABLE:
		case NetworkNode.BOUNDARY:
		case NetworkNode.DWR:
		case NetworkNode.PLANT:
		case NetworkNode.WASTE_PLANT:
			NodeDialog d = new NodeDialog(getFrame(), node);
			d.setLocationRelativeTo(null);
			d.setVisible(true);
			break;
		default:
			JOptionPane.showInternalMessageDialog(this,
					"This node has no editable properties",
					"information", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	// toggle the grid appearance
	void showGrid() {
		int style = getGridStyle();
		if (style == JGoView.GridInvisible) {
			style = JGoView.GridDot;
			setGridPen(JGoPen.black);
			setSnapMove(JGoView.SnapJump);
		} else {
			style = JGoView.GridInvisible;
			setSnapMove(JGoView.NoSnap);
		}
		setGridStyle(style);
	}

	// printing support
	public Rectangle2D.Double getPrintPageRect(Graphics2D g2, PageFormat pf) {
		// leave some space at the bottom for a footer
		return new Rectangle2D.Double(pf.getImageableX(), pf.getImageableY(),
				pf.getImageableWidth(), pf.getImageableHeight() - 20);
	}

	public void printDecoration(Graphics2D g2, PageFormat pf, int hpnum,
			int vpnum) {
		// draw corners around the getPrintPageRect area
		super.printDecoration(g2, pf, hpnum, vpnum);

		// print the n,m page number in the footer
		String msg = Integer.toString(hpnum);
		msg += ", ";
		msg += Integer.toString(vpnum);

		Paint oldpaint = g2.getPaint();
		g2.setPaint(Color.black);
		Font oldfont = g2.getFont();
		g2.setFont(new Font(JGoText.getDefaultFontFaceName(), Font.PLAIN, 10));
		g2.drawString(msg,
				(int) (pf.getImageableX() + pf.getImageableWidth() / 2),
				(int) (pf.getImageableY() + pf.getImageableHeight() - 10));
		g2.setPaint(oldpaint);
		g2.setFont(oldfont);
	}

	public double getPrintScale(Graphics2D g2, PageFormat pf) {
		return getScale();
	}

	void zoomIn() {
		double newscale = Math.rint(getScale() / 0.9f * 100f) / 100f;
		setScale(newscale);
	}

	void zoomOut() {
		double newscale = Math.rint(getScale() * 0.9f * 100f) / 100f;
		setScale(newscale);
	}

	void zoomNormal() {
		setScale(1.0d);
	}

	void zoomToFit() {
		double newscale = 1;
		if (!getDocument().isEmpty()) {
			double extentWidth = getExtentSize().width;
			double printWidth = getPrintDocumentSize().width;
			double extentHeight = getExtentSize().height;
			double printHeight = getPrintDocumentSize().height;
			newscale = Math.min((extentWidth/printWidth),
					(extentHeight/printHeight));
		}
		if (newscale > 2)
			newscale = 1;
		newscale *= getScale();
		setScale(newscale);
		setViewPosition(0, 0);
	}

	// State
	protected Point myDefaultLocation = new Point(10, 10);

	private Point myMouseUpDocPoint = new Point(0, 0);

	private Point copyPoint = new Point(0, 0); //CB added

	protected Schematic myApp = null;

	protected JInternalFrame myInternalFrame = null;
	// static protected JPopupMenu myPopupMenu = new JPopupMenu();
}
