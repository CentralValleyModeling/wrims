package wrims.schematic;

import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import javax.swing.KeyStroke;

import java.awt.event.*;

public class ChanPopup extends DssFrameRelatedPopup { //CB implements ActionListener, ItemListener {
	//CB bad programming to have mutiple IVs when only one is non-null!
	Link link; //CB not accessed!

	Arc arc; //CB not accessed!
	 //CB added: TO DO: This should NOT be done, but I am in a huge hurry.  Only arc should exist for both CalSim II and Calsim III types
	 //          Link class should be deleted and Arcs with bordered label should be used for CalSim III arc type, NOT NetworkNode.
	NetworkNode _node; //CB not accessed!

	public ChanPopup(Link l) {
		link = l;
	}

	public ChanPopup(Arc a) {
		arc = a;
	}

	/**
	 * CB added.  TO DO: See IV comments above and fix.
	 * @param node
	 */
	public ChanPopup(NetworkNode node) {
		_node = node;
	}

	public JMenu getVariableMenu() {
		JMenu submenu;
		JMenu subsubmenu;
		JMenuItem menuItem;

		submenu = new JMenu("Variables");
		submenu.setMnemonic(KeyEvent.VK_V);
		submenu.setEnabled(false);  //CB TO DO - figure out best how to access lookup tables, then enable this

		menuItem = new JMenuItem("Bounding Flows");
		submenu.setMnemonic(KeyEvent.VK_F);
//		menuItem.setAction(new BoundingFlowsAction());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Bounding Nodes");
		submenu.setMnemonic(KeyEvent.VK_N);
//		menuItem.setAction(new BoundingNodesAction());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Weights");
		submenu.setMnemonic(KeyEvent.VK_W);
//		menuItem.setAction(new WeightsAction());
		submenu.add(menuItem);

		return submenu;
	}

	public JMenu getDSSMenu() {
		JMenu submenu;
		JMenu subsubmenu;

		submenu = new JMenu("Timeseries (DSS)");
		submenu.setMnemonic(KeyEvent.VK_T);
		if (_node.getText().startsWith("S_") || _node.getText().startsWith("s_"))
			subsubmenu = createSubmenu(DssFrameRelatedAction.STORAGE_STRING, KeyEvent.VK_F);
		else
			subsubmenu = createSubmenu(DssFrameRelatedAction.FLOW_STRING, KeyEvent.VK_S);
		submenu.add(subsubmenu);
		if (!plotAction.canAct()) submenu.setEnabled(false);
		return submenu;
	}

	public JPopupMenu getPopup() {
		JMenu submenu;
		JPopupMenu menu = new JPopupMenu();

//CB		submenu = getVariableMenu();  //"Variables" not added yet
//CB		menu.add(submenu);            //"Variables" not added yet
//CB		menu.addSeparator();          //"Variables" not added yet
		submenu = getDSSMenu();
		menu.add(submenu);

		return menu;
	}
}
