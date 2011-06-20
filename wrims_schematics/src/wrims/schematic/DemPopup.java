package wrims.schematic;

import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import javax.swing.KeyStroke;

import java.awt.event.*;

public class DemPopup extends DssFrameRelatedPopup { //CB implements ActionListener, ItemListener {

	NetworkNode node;

	public DemPopup(NetworkNode nn) {
		node = nn;
	}

	public JPopupMenu getPopup() {
		JMenu submenu;
		JMenuItem menuItem;
		JPopupMenu menu = new JPopupMenu();

		// first submenu
//		menu.addSeparator();
		
/*		submenu = new JMenu("Variables");   //CB "Variables" not yet implemented
		submenu.setMnemonic(KeyEvent.VK_V);
		submenu.setEnabled(false);  //CB TO DO - figure out best how to access lookup tables, then enable this

		menuItem = new JMenuItem("Surface Water Depletion");
		menuItem.setMnemonic(KeyEvent.VK_S);
		// menuItem.setAccelerator(KeyStroke.getKeyStroke(
		// KeyEvent.VK_1, ActionEvent.ALT_MASK));
//		menuItem.setAction(new SWDepletionAction());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Applied Water");
		menuItem.setMnemonic(KeyEvent.VK_A);
		// menuItem.setAccelerator(KeyStroke.getKeyStroke(
		// KeyEvent.VK_2, ActionEvent.ALT_MASK));
//		menuItem.setAction(new AppliedWaterAction());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Net Surface Water Delivery");
		menuItem.setMnemonic(KeyEvent.VK_N);
		// menuItem.setAccelerator(KeyStroke.getKeyStroke(
		// KeyEvent.VK_3, ActionEvent.ALT_MASK));
//		menuItem.setAction(new SWDeliveryAction());;
		submenu.add(menuItem);

		menuItem = new JMenuItem("GroundWater Pumping");
		menuItem.setMnemonic(KeyEvent.VK_G);
		// menuItem.setAccelerator(KeyStroke.getKeyStroke(
		// KeyEvent.VK_4, ActionEvent.ALT_MASK));
//		menuItem.setAction(new GWPumpingAction());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Return Flow");
		menuItem.setMnemonic(KeyEvent.VK_R);
		// menuItem.setAccelerator(KeyStroke.getKeyStroke(
		// KeyEvent.VK_5, ActionEvent.ALT_MASK));
//		menuItem.setAction(new ReturnAction());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Deep Percolation");
		menuItem.setMnemonic(KeyEvent.VK_D);
		// menuItem.setAccelerator(KeyStroke.getKeyStroke(
		// KeyEvent.VK_6, ActionEvent.ALT_MASK));
//		menuItem.setAction(new DeepPercolationAction());
		submenu.add(menuItem);
		menu.add(submenu); */
		return menu; 
	}
}
