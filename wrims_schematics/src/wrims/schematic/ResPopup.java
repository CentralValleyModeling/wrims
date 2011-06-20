package wrims.schematic;

import java.awt.Component;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import com.nwoods.jgo.*;

public class ResPopup extends DssFrameRelatedPopup { // CB - implemented Actions instead
	NetworkNode _node = null;

	public ResPopup(NetworkNode node) {
		_node = node;
	}

	public JPopupMenu getPopup() {
		JMenu submenu;
		JMenu subsubmenu;
		JMenuItem menuItem;
		JPopupMenu menu = new JPopupMenu();

		// first submenu
		submenu = new JMenu("Physical Properties");
		submenu.setMnemonic(KeyEvent.VK_P);
//		submenu.setEnabled(false);  //CB TO DO - figure out best how to access lookup tables, then enable this

		menuItem = new JMenuItem("Ratings");
		menuItem.setMnemonic(KeyEvent.VK_R);
		menuItem.setAction(ratingsAction);
		menuItem.setEnabled(ratingsAction.canAct());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Zones");
		menuItem.setMnemonic(KeyEvent.VK_Z);
		menuItem.setAction(zonesAction); //CB in progress
		menuItem.setEnabled(zonesAction.canAct());
		submenu.add(menuItem);

		menu.add(submenu);

		// second submenu
		menu.addSeparator();
		submenu = new JMenu("Timeseries (DSS)");
		submenu.setMnemonic(KeyEvent.VK_T);
		if (!plotAction.canAct()) submenu.setEnabled(false);

		// EOP Storage submenu of Timeseries (DSS) menu
		subsubmenu = createSubmenu(DssFrameRelatedAction.STORAGE_STRING, KeyEvent.VK_S);
		submenu.add(subsubmenu);

		// Inflow submenu of Timeseries (DSS) menu
		subsubmenu = createSubmenu(DssFrameRelatedAction.INFLOWS_STRING, KeyEvent.VK_I);
		submenu.add(subsubmenu);

		// Outflow submenu of Timeseries (DSS) menu
		subsubmenu = createSubmenu(DssFrameRelatedAction.OUTFLOWS_STRING, KeyEvent.VK_O);
		submenu.add(subsubmenu);

		// Evaporation submenu of Timeseries (DSS) menu
		subsubmenu = createSubmenu(DssFrameRelatedAction.EVAP_STRING, KeyEvent.VK_E);
		submenu.add(subsubmenu);

		// Non-Recovered Spill submenu of Timeseries (DSS) menu
		subsubmenu = createSubmenu(DssFrameRelatedAction.SPILL_STRING, KeyEvent.VK_P);
		submenu.add(subsubmenu);

		// Surface Areasubmenu of Timeseries (DSS) menu
		subsubmenu = createSubmenu(DssFrameRelatedAction.AREA_STRING, KeyEvent.VK_A);
		submenu.add(subsubmenu);

		menu.add(submenu);
		return menu;
	}

	/** In progress?
	 * CB adding....................................................................................
	 */
	ContainerRelatedAction zonesAction = null; {  //extends AbstractAction {
//		Icon icon = iconImage("images/Copy24.gif");
		zonesAction = new ContainerRelatedAction("Zones", SchematicUtils.schematic) {
			public void actionPerformed(ActionEvent e) {
				if (canAct()) {
					String zonesDir = (new File(((Schematic)getApp()).getPropertiesLocation())).getParent() + "\\common\\System";
					if (zonesDir == null) return;
					File directory = new File(zonesDir);
//					System.out.println("parent directory = " + zonesDir);
//					File parent = directory.getParentFile();
					File[] files = directory.listFiles();  //works for CalSim III, NOT CalSim II
//					String[] files2 = directory.list();
					for (int i = 0; i < files.length; ++i) {
						if (files[i].isFile()) continue;
						File[] childFiles = files[i].listFiles();
//						Vector selectedObjects = ((Schematic)getApp()).getCurrentView()
//						.createSelectionVector(((((Schematic)getApp()).getCurrentView().getCurrentObject())));
						JGoObject current = ((Schematic)getApp()).getCurrentView().getCurrentObject();
						if (current instanceof NetworkNode && (((NetworkNode)current).getType()
								== NetworkNode.RESERVOIR || ((NetworkNode)current).getType()
								== NetworkNode.RRESERVOIR || ((NetworkNode)current).getType()
								== NetworkNode.LRESERVOIR || ((NetworkNode)current).getType()
								== NetworkNode.URESERVOIR || ((NetworkNode)current).getType()
								== NetworkNode.RESERVOIR_NOTUSED || ((NetworkNode)current).getType()
								== NetworkNode.RRESERVOIR_NOTUSED || ((NetworkNode)current).getType()
								== NetworkNode.LRESERVOIR_NOTUSED || ((NetworkNode)current).getType()
								== NetworkNode.URESERVOIR_NOTUSED)) {
//							String name = ((NetworkNode)current).getText();
							for (int j = 0; j < childFiles.length; ++j) {
								if (childFiles[j].getName().toLowerCase().indexOf("reserv") > -1) {
									try {
										File file = new File(childFiles[j].getAbsolutePath());
//										System.out.println( "file: " + file);
							            BufferedReader input = new BufferedReader(new FileReader(file));

							            String line = null;
							            String[] tokens = null;

							            // when found, load the data into a table/tableframe and break from loop
							            //CURRENTLY NAMES IN FILE DO NOT AGREE WITH NAMES ON SCHEMATIC
							            boolean inBlockComment = false;
							            while ((line = input.readLine()) != null) {
							            	if (line.startsWith("!"))
							            		continue;
							            	if (line.indexOf("/*") > -1) {
							            		inBlockComment = true;
							            	}

						            		if (line.indexOf("*/") > -1) {
						            			if (inBlockComment) {
						            				if (line.lastIndexOf("*/") > line.lastIndexOf("/*")) {
						            					inBlockComment = false;
						            				}
						            			}

						            		}

						            		if (!inBlockComment) {
						            			//split on one or more blank spaces
						            			tokens = line.split("\\s+");
//								            	for (int k = 0; k < temp.length; ++k)
//								            		System.out.println(temp[k]);

								            	// System.out.println(line);

								            	//TO DO: NEED A BOOLEAN VARIABLE LIKE FOUNDFIRST,
								            	//       WHICH WHEN TRUE MEANS THE DATA WAS FOUND
								            	//       AND THIS METHOD NEEDS TO BE EXITED
							            	}
							            }
							            input.close();
									} catch (FileNotFoundException ex) {
										ex.printStackTrace();
									} catch (IOException ex) {
										ex.printStackTrace();
									}
								}
							}
						}
					}

					// if not null, show the table
					if (true) {
						//SHOW TABLE OF VALUES
					} else { //CB added else block
						JOptionPane.showMessageDialog(((Schematic)getApp())._DssFrame,
							"No variables in dss files that match any of the selected items",
							"Match Not Found", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Make sure a properties location has been opened",
							"Cannot Show Zones", JOptionPane.ERROR_MESSAGE);
				}
			}
			public boolean canAct() {
				return  (((Schematic)getApp()).getPropertiesLocation() != null);
			}
		}; // doesn't depend on a view
	}

	/** In progress?
	 *
	 */
	ContainerRelatedAction ratingsAction = null;  //extends AbstractAction
	{
//		Icon icon = iconImage("images/Copy24.gif");
		ratingsAction = new ContainerRelatedAction("Ratings", SchematicUtils.schematic) {
			public void actionPerformed(ActionEvent e) {
				if (canAct()) {
					String ratingsDir = ((Schematic)getApp()).getPropertiesLocation() + "/run/Lookup/";
					//NEED RESERVOIR NAME using _currentOpenPropertyLocation;
					//LOOK FOR RES IN PERINENT TABLE
					if (true) {
						//SHOW TABLE OF VALUES
					} else { //CB added else block
						JOptionPane.showMessageDialog(((Schematic)getApp())._DssFrame,
							"No variables in dss files that match any of the selected items",
							"Match Not Found", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			public boolean canAct() {
				return  (((Schematic)getApp()).getPropertiesLocation() != null);
			}
		}; // doesn't depend on a view
	}
}
