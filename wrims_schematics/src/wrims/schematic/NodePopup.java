package wrims.schematic;

import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import javax.swing.KeyStroke;

import java.awt.event.*;

/**
 * @author Clay Booher (format is the same as Tom Pruett's similar classes)
 */
public class NodePopup extends DssFrameRelatedPopup { //CB implements ActionListener, ItemListener {

	NetworkNode node;

	public NodePopup(NetworkNode nn) {
		node = nn;
	}

	public JPopupMenu getPopup() {
//		JMenu submenu;
//		JMenuItem menuItem;
		return new JPopupMenu();
	}
}
