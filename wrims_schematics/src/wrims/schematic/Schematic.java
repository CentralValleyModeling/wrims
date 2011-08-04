package wrims.schematic;

import hec.heclib.dss.HecDSSFileAccess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import vista.gui.VistaUtils;
import wrims.dss.DssFrame;
import wrims.dss.DssViewer;

import com.nwoods.jgo.JGoArea;
import com.nwoods.jgo.JGoBrush;
import com.nwoods.jgo.JGoDocument;
import com.nwoods.jgo.JGoImage;
import com.nwoods.jgo.JGoLayer;
import com.nwoods.jgo.JGoListPosition;
import com.nwoods.jgo.JGoNode;
import com.nwoods.jgo.JGoObject;
import com.nwoods.jgo.JGoOverview;
import com.nwoods.jgo.JGoPalette;
import com.nwoods.jgo.JGoPen;
import com.nwoods.jgo.JGoPort;
import com.nwoods.jgo.JGoRectangle;
import com.nwoods.jgo.JGoSelection;
import com.nwoods.jgo.JGoSubGraph;
import com.nwoods.jgo.JGoText;
import com.nwoods.jgo.JGoTextNode;

public class Schematic extends JApplet implements Runnable, DocumentListener { // TextListener
	private static final boolean DEBUG = true;

	// {
	// //CB
	// added
	// DocumentListener
	public Schematic() {
		this("", false);
	}

	public Schematic(String mainDir, boolean isStandalone) {
		HecDSSFileAccess.setMessageLevel(_messageLevel);

		// clearRecentFilePreferences(); // CB added for development phase only;
		// save for possible user use
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			_mainDir = mainDir;
			_isStandalone = isStandalone;

			mainMenuBar = new JMenuBar();
			createRecentFilesOpenActions(); // CB added

			// CB toolBar = new JToolBar();
			filemenu = new JMenu();
			editmenu = new JMenu();
			viewmenu = new JMenu();
			dssmenu = new JMenu();
			propertyMenu = new JMenu(); // CB added
			insertmenu = new JMenu();
			layoutmenu = new JMenu();
			helpmenu = new JMenu();

			plotter = new Plotter();

			initMenus();
			// CB initToolbar();
			toolBar1 = initToolbar1(); // CB renamed toolbar
			toolBar2 = initToolbar2(); // CB added

			myDesktop = new JDesktopPane();
			/*
			 * CB myPalette = new JGoPalette(); myPalette.setPreferredSize(new
			 * Dimension(100, 300)); myPalette.setMinimumSize(new Dimension(100,
			 * 100));
			 */
			// CB replaced code due to need for more than one palette type
			JGoPalette[] myPalette = new JGoPalette[2];
			myPaletteTabbedPane = new JTabbedPane();
			myPaletteTabbedPane.setPreferredSize(new Dimension(100, 400));
			myPaletteTabbedPane.setMinimumSize(new Dimension(100, 400));
			for (int i = 0; i < myPalette.length; ++i) {
				myPaletteTabbedPane.add(STYLE_NAME[i],
						myPalette[i] = new JGoPalette());
			}

			Container contentPane = getContentPane();
			contentPane.setLayout(new BorderLayout());

			// CB added section for single period data updating
			JPanel barPanel = new JPanel();
			// CB barPanel.setLayout(new BorderLayout());
			// CB barPanel.add(toolBar, "West");
			barPanel.setLayout(new BoxLayout(barPanel, BoxLayout.Y_AXIS)); // CB
			barPanel.add(toolBar1); // CB renamed
			barPanel.add(toolBar2); // CB added

			// CB contentPane.add(toolBar, "North");
			tabbedPane =new JTabbedPane();
			contentPane.add(tabbedPane);
			
			inputPane=new InputPanel();
			tabbedPane.add(inputPane,"Input");
			
			outputPane=new JPanel();
			tabbedPane.add(outputPane, "Output");
			outputPane.setLayout(new BorderLayout());
			outputPane.add(barPanel,"North");
			
			if (IS_DEVELOPER) { // CB added check
				JSplitPane splitPane = new JSplitPane(
						JSplitPane.HORIZONTAL_SPLIT);
				splitPane.setContinuousLayout(true);
				// CB splitPane.setLeftComponent(getPalette());
				splitPane.setLeftComponent(myPaletteTabbedPane);
				splitPane.setRightComponent(getDesktop());
				splitPane.setDividerLocation(100);
				outputPane.add(splitPane, "Center");
			} else {
				outputPane.add(getDesktop(), "Center");
			}
			outputPane.validate();

			// CB moved the below here from main(args)
			mainFrame = new JFrame();
			theApp = mainFrame;

			// close the application when the main window closes
			mainFrame.addWindowListener(new WindowAdapter() {
				public void windowActivated(WindowEvent evt) {
					if (getCurrentView() != null) {
						getCurrentView().getDoc().updateLocationModifiable();
					}
				}

				public void windowClosing(WindowEvent event) {
					Object object = event.getSource();
					if (object == mainFrame) {
						exit();
					}
				}
			});

			// _DssFrame.mainPanel.getFilterPanel().getBaseDVFileField().getDocument()
			// //CB added, but there is no Document at creation!
			// .addDocumentListener(this); //CB added

			// _DssFrame.mainPanel.getFilterPanel().getBaseDVFileField().addTextListener(this);
			// //CB added, but JTextField extends JTextComponent, not
			// textComponent

			addExitCommand();

			mainFrame.setTitle("WRIMS Schematic");
			// Dimension screensize =
			// Toolkit.getDefaultToolkit().getScreenSize();
			// mainFrame.setBounds(0, 0, screensize.width, screensize.height);
			mainFrame.setSize(new Dimension(800, 600));

			Container contentPane2 = mainFrame.getContentPane();
			contentPane2.setLayout(new BorderLayout());
			contentPane2.add("Center", this);
			contentPane2.validate();

			mainFrame.setVisible(true);

			if (!Schematic.IS_DEVELOPER) {
				SchematicRelatedAction.updateAllActions();
			}

			start();

		} catch (Throwable t) {
			System.err.println(t);
			t.printStackTrace();
		}
	}

	/**
	 * CB added.
	 */
	public void changedUpdate(DocumentEvent e) {
		// ? loadDateBox();
	}

	/**
	 * CB added.
	 */
	public void removeUpdate(DocumentEvent e) {
		// No action needed
	}

	/**
	 * CB added.
	 */
	public void insertUpdate(DocumentEvent e) {
		// ? loadDateBox();
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	private String getSelectedDate() {
		if (_dateBox.getSelectedItem() instanceof ComboItem) {
			return ((ComboItem) _dateBox.getSelectedItem()).toString();
		} else { // must be a String
			return (String) _dateBox.getSelectedItem();
		}
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	public Vector<String> getTimeWindows() {
		Vector<String> timeWindows = new Vector<String>();
		for (int i = 0; i < ((DefaultComboBoxModel) _dateBox.getModel())
				.getSize(); ++i) {
			if (((DefaultComboBoxModel) _dateBox.getModel()).getElementAt(i) instanceof ComboItem) {
				String period = ((ComboItem) ((DefaultComboBoxModel) _dateBox
						.getModel()).getElementAt(i)).toString();
				if (period.indexOf("-") > -1) {
					timeWindows.add(period);
				}
			}
		}
		return timeWindows;
	}

	/**
	 *
	 */
	private void createRecentFilesOpenActions() {
		createRecentSchematicFilesOpenActions();
		createRecentProjectFilesOpenActions();
		createRecentPropertyDirectoriesOpenActions();
	}

	private void createRecentFilesOpenActions(int type) {
		if (type == SCHEMATIC_TYPE) {
			createRecentSchematicFilesOpenActions();
		} else if (type == PROJECT_TYPE) {
			createRecentProjectFilesOpenActions();
		} else if (type == PROPERTIES_TYPE) {
			createRecentPropertyDirectoriesOpenActions();
		} else {
			JOptionPane.showMessageDialog(this,
					"Schematic or Project file types allowed",
					"Incorrect File Type", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * CB - added
	 * 
	 */
	private void createRecentSchematicFilesOpenActions() { // CB added
		for (int i = 0; i < NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			RecentSchematicFilesOpenActions[i] = createSchematicOpenAction(i + 1);
		}
	}

	private void setRecentFileOpenActions(int type) { // CB added
		if (type == SCHEMATIC_TYPE) {
			setRecentSchematicFileOpenActions();
		} else if (type == PROJECT_TYPE) {
			setRecentProjectFileOpenActions();
		} else if (type == PROPERTIES_TYPE) {
			setRecentPropertyDirectoriesOpenActions();
		}
	}

	private void setRecentSchematicFileOpenActions() { // CB added
		setRecentSchematicFileOpenActions(false);
	}

	/**
	 * 
	 * @param isFirstTime
	 */
	private void setRecentSchematicFileOpenActions(boolean isFirstTime) { // CB
		// added
		for (int i = 0; i < NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			if (recentSchematicFilesOpenMenuItems[i] == null) {
				recentSchematicFilesOpenMenuItems[i] = new JMenuItem();
			}
			// CB TO DO: need to add null checks?
			recentSchematicFilesOpenMenuItems[i]
					.setAction(RecentSchematicFilesOpenActions[i]);
			if (RecentSchematicFilesOpenActions[i] == null) {
				recentSchematicFilesOpenMenuItems[i].setVisible(false);
			} else {
				recentSchematicFilesOpenMenuItems[i].setVisible(true);
			}
			if (isFirstTime) {
				// if (RecentFilesOpenActions[i] != null) // THIS LINE WORKS,
				// BUT IF SEPARATOR IS NOT ADDED, THEN IS NOT THERE AFTER FIRST
				// FILE IS OPENED
				if (i == 0) {
					filemenu.addSeparator();
				}
				filemenu.add(recentSchematicFilesOpenMenuItems[i]);
				// if (RecentFilesOpenActions[i] == null)
				// recentFilesOpenMenuItems[i].setVisible(false);
			} else {
				Component[] comps = filemenu.getPopupMenu().getComponents();
				for (int j = 0; j < comps.length; ++j) {
					if (comps[j] == recentSchematicFilesOpenMenuItems[i]) { // CB
						// TODO
						// is
						// there
						// a
						// better
						// way
						// to
						// do
						// this
						// -
						// there
						// should
						// be!
						filemenu.remove(comps[j]);
						filemenu
								.insert(recentSchematicFilesOpenMenuItems[i], j);
						break;
					}
				}
			}
		}
		filemenu.revalidate();
		filemenu.repaint();
	}

	/**
	 * 
	 * @param filename
	 * @param type
	 */
	/*
	 * void handleBadFileRecentlyOpenedMenuItem(String filename, final int type)
	 * { removeRecentlyOpenedFilenamePreference(filename, type);
	 * reorderPreferences(type); createRecentFilesOpenActions(type); //recreate
	 * open action (easier than deleting one and recreating or reorganizing
	 * SwingUtilities.invokeLater(new Runnable() { public void run() {
	 * setRecentFileOpenActions(type); //reset open actions // TODO need to
	 * reset recentSchematicFilesOpenMenuItems[i] once
	 * loaded??????????????????????????????????????????????????????????????????
	 * } }); }
	 */

	/**
	 * CB added to remove a bad project name menu item. TODO BETTER TO JUST
	 * RECREATE BASED ON PREFS???
	 * 
	 * @param filename
	 */
	/*
	 * public void removeSchematicFileOpenAction(final String filename) {
	 * removeRecentlyOpenedFilenamePreference(filename,
	 * Schematic.SCHEMATIC_TYPE); SwingUtilities.invokeLater(new Runnable() {
	 * public void run() { Component[] components =
	 * filemenu.getMenuComponents(); // recentProjectFilesOpenMenuItems[i] for
	 * (int i = 0; i < components.length; ++i) { if (components[i] instanceof
	 * JMenuItem) { String text = ((JMenuItem)components[i]).getText(); if (text
	 * != null && text.substring(2).trim().equals(filename)) {
	 * filemenu.remove(components[i]); //TODO Need to reorganize them
	 * !!!!!!!!!!!
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * !!!!!!!!!!!!!!!!!!!!!!
	 * Schematic.this.updateRecentFilesOpenedPreferences("",
	 * Schematic.SCHEMATIC_TYPE); //TODO? filemenu.reload(); break; } } } } });
	 * }
	 */

	/**
	 * CB - added
	 * 
	 */
	private void createRecentProjectFilesOpenActions() {
		for (int i = 0; i < NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			RecentProjectFilesOpenActions[i] = createProjectOpenAction(i + 1);
		}
	}

	private void setRecentProjectFileOpenActions() { // CB added
		setRecentProjectFileOpenActions(false);
	}

	/**
	 * 
	 * @param isFirstTime
	 */
	private void setRecentProjectFileOpenActions(boolean isFirstTime) { // CB
		// added
		for (int i = 0; i < NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			if (recentProjectFilesOpenMenuItems[i] == null) {
				recentProjectFilesOpenMenuItems[i] = new JMenuItem();
			}
			recentProjectFilesOpenMenuItems[i]
					.setAction(RecentProjectFilesOpenActions[i]);
			if (RecentProjectFilesOpenActions[i] == null) {
				recentProjectFilesOpenMenuItems[i].setVisible(false);
			} else {
				recentProjectFilesOpenMenuItems[i].setVisible(true);
			}
			if (isFirstTime) {
				// if (RecentFilesOpenActions[i] != null) // THIS LINE WORKS,
				// BUT IF SEPARATOR IS NOT ADDED, THEN IS NOT THERE AFTER FIRST
				// FILE IS OPENED
				if (i == 0) {
					dssmenu.addSeparator();
				}
				dssmenu.add(recentProjectFilesOpenMenuItems[i]);
				// if (RecentFilesOpenActions[i] == null)
				// recentFilesOpenMenuItems[i].setVisible(false);
			}
		}
	}

	/**
	 * CB added to remove a bad project name menu item.
	 * 
	 * @param filename
	 */
	/*
	 * public void removeProjectFileOpenAction(final String filename) {
	 * SwingUtilities.invokeLater(new Runnable() { public void run() {
	 * Component[] components = dssmenu.getMenuComponents(); //
	 * recentProjectFilesOpenMenuItems[i] for (int i = 0; i < components.length;
	 * ++i) { if (components[i] instanceof JMenuItem) { if
	 * (((JMenuItem)components
	 * [i]).getText().substring(2).trim().equals(filename)) {
	 * dssmenu.remove(components[i]); break; } } } } }); }
	 */

	/**
	 * CB - added
	 * 
	 */
	private void createRecentPropertyDirectoriesOpenActions() {
		for (int i = 0; i < NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			RecentPropertyDirectoriesOpenActions[i] = createPropertiesOpenAction(i + 1);
		}
	}

	private void setRecentPropertyDirectoriesOpenActions() { // CB added
		setRecentPropertyDirectoriesOpenActions(false);
	}

	/**
	 * 
	 * @param isFirstTime
	 */
	private void setRecentPropertyDirectoriesOpenActions(boolean isFirstTime) { // CB
		// added
		for (int i = 0; i < NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			if (recentPropertyDirectoryOpenMenuItems[i] == null) {
				recentPropertyDirectoryOpenMenuItems[i] = new JMenuItem();
			}
			recentPropertyDirectoryOpenMenuItems[i]
					.setAction(RecentPropertyDirectoriesOpenActions[i]); // CB
			// TO
			// DO:
			// need
			// to
			// add
			// nulls??
			if (RecentPropertyDirectoriesOpenActions[i] == null) {
				recentPropertyDirectoryOpenMenuItems[i].setVisible(false);
			} else {
				recentPropertyDirectoryOpenMenuItems[i].setVisible(true);
			}
			if (isFirstTime) {
				// if (RecentFilesOpenActions[i] != null) // THIS LINE WORKS,
				// BUT IF SEPARATOR IS NOT ADDED, THEN IS NOT THERE AFTER FIRST
				// FILE IS OPENED
				if (i == 0) {
					dssmenu.addSeparator();
				}
				propertyMenu.add(recentPropertyDirectoryOpenMenuItems[i]);
				// if (RecentFilesOpenActions[i] == null)
				// recentFilesOpenMenuItems[i].setVisible(false);
			}
		}
	}

	// ==============================================================
	// Define all the command actions
	// ==============================================================
	static public Icon createIconImage(String resourceName) { // CB changed to
		// public and
		// renamed

		URL url = Schematic.class.getResource(resourceName); // CB need path
		// to have
		// D:\WRIMS1Development\Calsim1.3\wrims\Schematic\images
		if (url == null) {
			if (!imagesErrorDisplayed) {
				JOptionPane
						.showMessageDialog(
								null,
								"Image files not found.\nThe Schematic.images directory must be placed in the class path.",
								"alert", JOptionPane.ERROR_MESSAGE);
				imagesErrorDisplayed = true;
			}
		} else {
			return new ImageIcon(url);
		}
		return null;
	}

	SchematicRelatedAction FileNewAction = null;
	{

		// Icon icon = iconImage("images/new.gif");
		// Icon icon = iconImage(System.getProperty("calsim.home").substring(0,
		// System.getProperty("calsim.home").lastIndexOf("\\") + 1)
		// + "wrims\\images\\New24.gif");
		Icon icon = createIconImage("images/New24.gif");
		FileNewAction = new SchematicRelatedAction("New", icon, this) {
			public void actionPerformed(ActionEvent e) {
				newSchematic();
			}

			public boolean canAct() {
				return true;
			}
		}; // doesn't depend on a view
	}

	SchematicRelatedAction FileOpenAction = null;
	{
		// Icon icon = iconImage("images/open.gif");
		Icon icon = createIconImage("images/Open24.gif");
		FileOpenAction = new SchematicRelatedAction("Open", icon, this) {
			public void actionPerformed(ActionEvent e) {
				String filename = openSchematic();
				SchematicView view = getCurrentView();
				SchematicDocument doc = null;
				if (view != null) {
					doc = view.getDoc();
				}
				if (doc != null) {
					filename = doc.getLocation();
				}
				Schematic.this.updateFileMenu(filename, true); // TODO always
				// true?
			}

			public boolean canAct() {
				return true;
			}
		}; // doesn't depend on a view
	}

	SchematicRelatedAction[] RecentSchematicFilesOpenActions = new SchematicRelatedAction[NUMBER_OF_RECENT_FILES_OPENED];

	// CB added
	// AppAction RecentFile1OpenAction = null; //CB create in the constructor
	// using createOpenAction(RecentFile1OpenAction, "1");!!
	/*
	 * { String filename = readRecentOpenedFilename("1"); if (filename != null
	 * && filename.trim().length() > 0) { RecentFile1OpenAction = new
	 * AppAction("1: " + filename, this) { public void
	 * actionPerformed(ActionEvent e) { if (e.getSource() instanceof JMenuItem)
	 * { String filename = ((JMenuItem)e.getSource()).getText().substring
	 * (((JMenuItem)e.getSource()).getText().indexOf(":") -1 );
	 * openSchematic(filename); } }
	 * 
	 * public boolean canAct() { return true; } }; // doesn't depend on a view }
	 * }
	 */
	// CB added
	// AppAction RecentFile2OpenAction = null;
	/*
	 * { String filename = readRecentOpenedFilename("2"); RecentFile2OpenAction
	 * = new AppAction("2: " + filename, this) { public void
	 * actionPerformed(ActionEvent e) { if (e.getSource() instanceof JMenuItem)
	 * { String filename = ((JMenuItem)e.getSource()).getText().substring
	 * (((JMenuItem)e.getSource()).getText().indexOf(":") -1 );
	 * openSchematic(filename); } }
	 * 
	 * public boolean canAct() { return true; } }; // doesn't depend on a view }
	 */
	// CB added
	// AppAction RecentFile3OpenAction = null;
	/*
	 * { String filename = readRecentOpenedFilename("3"); RecentFile3OpenAction
	 * = new AppAction("3: " + filename, this) { public void
	 * actionPerformed(ActionEvent e) { if (e.getSource() instanceof JMenuItem)
	 * { String filename = ((JMenuItem)e.getSource()).getText().substring
	 * (((JMenuItem)e.getSource()).getText().indexOf(":") -1 );
	 * openSchematic(filename); } }
	 * 
	 * public boolean canAct() { return true; } }; // doesn't depend on a view }
	 */
	// CB added
	// AppAction RecentFile4OpenAction = null;
	/*
	 * { String filename = readRecentOpenedFilename("4"); RecentFile4OpenAction
	 * = new AppAction("4: " + filename, this) { public void
	 * actionPerformed(ActionEvent e) { if (e.getSource() instanceof JMenuItem)
	 * { String filename = ((JMenuItem)e.getSource()).getText().substring
	 * (((JMenuItem)e.getSource()).getText().indexOf(":") -1 );
	 * openSchematic(filename); } }
	 * 
	 * public boolean canAct() { return true; } }; // doesn't depend on a view }
	 */
	// CB added
	// AppAction RecentFile5OpenAction = null;
	/*
	 * { String filename = readRecentOpenedFilename("5"); RecentFile5OpenAction
	 * = new AppAction("5: " + filename, this) { public void
	 * actionPerformed(ActionEvent e) { if (e.getSource() instanceof JMenuItem)
	 * { String filename = ((JMenuItem)e.getSource()).getText().substring
	 * (((JMenuItem)e.getSource()).getText().indexOf(":") -1 );
	 * openSchematic(filename); } }
	 * 
	 * public boolean canAct() { return true; } }; // doesn't depend on a view }
	 */

	SchematicRelatedAction FileCloseAction = new SchematicRelatedAction(
			"Close", this) {
		public void actionPerformed(ActionEvent e) {
			closeSchematic();
		}
	};

	SchematicRelatedAction FileSaveAction = null;
	{
		// Icon icon = iconImage("images/save.gif");
		Icon icon = createIconImage("images/Save24.gif");
		FileSaveAction = new SchematicRelatedAction("Save", icon, this) {
			public void actionPerformed(ActionEvent e) {
				saveSchematic();
			}

			public boolean canAct() {
				return super.canAct()
						&& getView().getDoc().isLocationModifiable();
			}
		}; // doesn't depend on a view
	}

	SchematicRelatedAction FileSaveAsAction = null;
	{
		FileSaveAsAction = new SchematicRelatedAction("Save As", this) {
			public void actionPerformed(ActionEvent e) {
				saveAsSchematic();
			}
		};
	}

	SchematicRelatedAction FileImportAction = null;
	{
		FileImportAction = new SchematicRelatedAction("Import", this) {
			public void actionPerformed(ActionEvent e) {
				importXY();
			}

			public boolean canAct() {
				return true;
			}
		}; // doesn't depend on a view
	}

	SchematicRelatedAction CutAction = null;
	{
		// Icon icon = iconImage("images/remove.gif");
		Icon icon = createIconImage("images/Cut24.gif");
		CutAction = new SchematicRelatedAction("Cut", icon, this) {
			public void actionPerformed(ActionEvent e) {
				getView().cut();
			}

			public boolean canAct() {
				return super.canAct() && !getView().getSelection().isEmpty()
						&& getView().getDoc().isModifiable();
			}
		}; // doesn't depend on a view
	}

	SchematicRelatedAction CopyAction = null;
	{
		// Icon icon = iconImage("images/copy.gif");
		Icon icon = createIconImage("images/Copy24.gif");
		CopyAction = new SchematicRelatedAction("Copy", icon, this) {
			public void actionPerformed(ActionEvent e) {
				getView().copy(); // CB Now it throws some weird
				// NotSerializableException and I was not
				// able to fix it in 5 hours or so
				// CB the exception probably has to do with copying an arc or
				// link
				// copySelection works fine with the same objects, so it appears
				// it is a JGo bug
			}

			public boolean canAct() {
				return super.canAct() && !getView().getSelection().isEmpty();
			}
		}; // doesn't depend on a view
	}

	SchematicRelatedAction PasteAction = null;
	{
		// Icon icon = iconImage("images/paste.gif");
		Icon icon = createIconImage("images/Paste24.gif");
		PasteAction = new SchematicRelatedAction("Paste", icon, this) {
			public void actionPerformed(ActionEvent e) {
				getView().paste();
				// The paste() method selects all of the newly copied objects
				// that have been pasted into this view's document.
				// This makes it easier to define a
				// JGoViewEvent.CLIPBOARD_PASTED or
				// JGoViewEvent.EXTERNAL_OBJECTS_DROPPED event handler that
				// modifies those newly created objects.
				// loadVariablesVector(); //CB cannot tell
			}

			public boolean canAct() {
				return super.canAct() && getView().getDoc().isModifiable();
			}
		}; // doesn't depend on a view
	}

	SchematicRelatedAction DeleteAction = new SchematicRelatedAction("Delete",
			this) {
		public void actionPerformed(ActionEvent e) {
			getView().deleteSelection();
		}

		public boolean canAct() {
			return super.canAct() && !getView().getSelection().isEmpty()
					&& getView().getDoc().isModifiable();
		}
	};

	SchematicRelatedAction SelectAllAction = new SchematicRelatedAction(
			"Select All", this) {
		public void actionPerformed(ActionEvent e) {
			getView().selectAll(); // CB Throws a NullPointerSelection after
			// less than all of the objects are selected
			// DUE TO me allowing Arcs with null labels
			// probably
		}
	};

	JMenuItem UndoMenuItem = null;

	SchematicRelatedAction UndoAction = new SchematicRelatedAction("Undo",
			createIconImage("images/Undo24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().getDocument().undo();
			SchematicRelatedAction.updateAllActions();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getDocument().canUndo());
		}

		public void updateEnabled() {
			super.updateEnabled();
			if ((UndoMenuItem != null) && (getView() != null)) {
				UndoMenuItem.setText(getView().getDocument().getUndoManager()
						.getUndoPresentationName());
			}
		}
	};

	JMenuItem RedoMenuItem = null;

	SchematicRelatedAction RedoAction = new SchematicRelatedAction("Redo",
			createIconImage("images/Redo24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().getDocument().redo();
			SchematicRelatedAction.updateAllActions();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getDocument().canRedo());
		}

		public void updateEnabled() {
			super.updateEnabled();
			if ((RedoMenuItem != null) && (getView() != null)) {
				RedoMenuItem.setText(getView().getDocument().getUndoManager()
						.getRedoPresentationName());
			}
		}
	};

	// Group actions
	SchematicRelatedAction GroupAction = new SchematicRelatedAction("Group",
			this) {
		public void actionPerformed(ActionEvent e) {
			groupAction();
		}

		public boolean canAct() {
			return super.canAct()
					&& (getView().getSelection().getNumObjects() >= 2);
		}
	};

	SchematicRelatedAction UngroupAction = new SchematicRelatedAction(
			"Ungroup", this) {
		public void actionPerformed(ActionEvent e) {
			ungroupAction();
		}

		public boolean canAct() {
			return super.canAct()
					&& !getView().getSelection().isEmpty()
					&& (getView().getSelection().getPrimarySelection() instanceof JGoArea);
		}
	};

	SchematicRelatedAction ObjectPropertiesAction = new SchematicRelatedAction(
			"Object Properties", this) {
		public void actionPerformed(ActionEvent e) {
			getView().editObjectProperties();
		}

		public boolean canAct() {
			return super.canAct() && !getView().getSelection().isEmpty();
		}
	};

	// CB added LinkObjectsForDSSAction
	SchematicRelatedAction LinkObjectsForDSSAction = new SchematicRelatedAction(
			"DSS Object Linking", this) {
		public void actionPerformed(ActionEvent e) {
			getView().linkObjectsForDSS();
		}

		public boolean canAct() {
			return super.canAct() && !getView().getSelection().isEmpty();
		}
	};

	SchematicRelatedAction ZoomNormalAction = new SchematicRelatedAction(
			"Normal Zoom", this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomNormal();
		}
	};

	SchematicRelatedAction ZoomInAction = new SchematicRelatedAction("Zoom In",
			createIconImage("images/ZoomIn24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomIn();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getScale() < 8.0f);
		}
	};

	SchematicRelatedAction ZoomOutAction = new SchematicRelatedAction(
			"Zoom Out", createIconImage("images/ZoomOut24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomOut();
		}

		public boolean canAct() {
			return super.canAct() && (getView().getScale() > 0.13f); // CB TO
			// DO:
			// decrase
			// this
			// number?
		}
	};

	// CB added TODO: make an [XXXXX]Action class which extends
	// DssFrameRelatedAction and is extended by the next four classes??:
	SchematicRelatedAction SingleStepValuesAction = new DssFrameRelatedAction(
			"Single Step Values", null, this) {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			if (e.getSource() instanceof JComboBox) {
				if (((JComboBox) e.getSource()).getSelectedItem() instanceof ComboItem) {
					// CB I should have done this more thoroughly (ComboItem,
					// ComboListener, ComboRenderer but in a hurry
					if (((JComboBox) e.getSource()).getSelectedIndex() == 0) {
						int firstIndex = -1;
						for (int i = 0; i < ((JComboBox) e.getSource())
								.getItemCount(); ++i) {
							if (((ComboItem) ((JComboBox) e.getSource())
									.getItemAt(i)).toString().equalsIgnoreCase(
									"OCT 1921")) {
								firstIndex = i;
								break;
							}
						}
						((JComboBox) e.getSource())
								.setSelectedIndex(firstIndex); // does not
						// appear to
						// fire
						// ActionEvent!
						// So ...
						if (((ComboItem) ((JComboBox) e.getSource())
								.getSelectedItem()).isEnabled()) {
							// String date =
							// ((ComboItem)((JComboBox)e.getSource()).getSelectedItem()).toString();;
							// updateValues(date);
							updateValues();
						}
					} else {
						if (((ComboItem) ((JComboBox) e.getSource())
								.getSelectedItem()).isEnabled()) {
							// String date =
							// ((ComboItem)((JComboBox)e.getSource()).getSelectedItem()).toString();;
							// updateValues(date);
							updateValues();
						}
					}
				}
			}
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		public boolean canAct() {
			return super.canAct() && (_DssFrame != null)
					&& _DssFrame.getFP().isFilterValid(); // &&
			// _DssFrame.getFP().rowsSelected();
		}
	};

	SchematicRelatedAction Forward1Action = new DssFrameRelatedAction("",
			createIconImage("images/forward.gif"), this) {

		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			JComboBox dateBox = _dateBox;
			int firstIndex = -1;
			for (int i = 0; i < dateBox.getItemCount(); ++i) {
				// System.out.println(dateBox.getItemAt(i));
				if (((ComboItem) dateBox.getItemAt(i)).toString()
						.equalsIgnoreCase("OCT 1921")) {
					firstIndex = i;
					break;
				}
			}
			if (dateBox.getSelectedIndex() < firstIndex) {
				dateBox.setSelectedIndex(firstIndex);
			} else if (dateBox.getSelectedIndex() < dateBox.getItemCount() - 1) {
				dateBox.setSelectedIndex(dateBox.getSelectedIndex() + 1);
			}

			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		public boolean canAct() {
			return super.canAct() && (_DssFrame != null)
					&& _DssFrame.getFP().isFilterValid();
		}
	};

	SchematicRelatedAction Back1Action = new DssFrameRelatedAction("",
			createIconImage("images/back.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			JComboBox dateBox = _dateBox;
			int firstIndex = -1;
			for (int i = 0; i < dateBox.getItemCount(); ++i) {
				if (((ComboItem) dateBox.getItemAt(i)).toString()
						.equalsIgnoreCase("OCT 1921")) {
					firstIndex = i;
					break;
				}
			}
			if (dateBox.getSelectedIndex() > firstIndex) {
				dateBox.setSelectedIndex(dateBox.getSelectedIndex() - 1);
			}
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		public boolean canAct() {
			return super.canAct() && (_DssFrame != null)
					&& _DssFrame.getFP().isFilterValid();
		}
	};

	SchematicRelatedAction ForwardBlockAction = new DssFrameRelatedAction("",
			createIconImage("images/fastforward.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			JComboBox dateBox = _dateBox;
			int firstIndex = -1;
			for (int i = 0; i < dateBox.getItemCount(); ++i) {
				if (((ComboItem) dateBox.getItemAt(i)).toString()
						.equalsIgnoreCase("OCT 1921")) {
					firstIndex = i;
					break;
				}
			}
			if (dateBox.getSelectedIndex() < firstIndex) {
				dateBox.setSelectedIndex(firstIndex);
			} else if (dateBox.getSelectedIndex() < dateBox.getItemCount() - 13) {
				dateBox.setSelectedIndex(dateBox.getSelectedIndex() + 12);
			} else {
				dateBox.setSelectedIndex(dateBox.getItemCount() - 1);
			}
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		public boolean canAct() {
			return super.canAct() && (_DssFrame != null)
					&& _DssFrame.getFP().isFilterValid();
		}
	};
	SchematicRelatedAction BackBlockAction = new DssFrameRelatedAction("",
			createIconImage("images/fastback.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			JComboBox dateBox = _dateBox;
			int firstIndex = -1;
			for (int i = 0; i < dateBox.getItemCount(); ++i) {
				if (((ComboItem) dateBox.getItemAt(i)).toString()
						.equalsIgnoreCase("OCT 1921")) {
					firstIndex = i;
					break;
				}
			}
			if (dateBox.getSelectedIndex() > firstIndex + 11) {
				dateBox.setSelectedIndex(dateBox.getSelectedIndex() - 12);
			} else {
				dateBox.setSelectedIndex(firstIndex);
			}
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		public boolean canAct() {
			return super.canAct() && (_DssFrame != null)
					&& _DssFrame.getFP().isFilterValid();
		}
	};

	SchematicRelatedAction PlotAction = new SchematicRelatedAction("Plot", // CB
			// why
			// not
			// use
			// DSSFrameRelatedAction
			// here?
			// It
			// should
			// be.
			createIconImage("images/icon24_graph.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			showOutput("Plot");
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		// public boolean canAct() { return super.canAct() &&
		// !getView().getSelection().isEmpty(); } };
		public boolean canAct() {
			return super.canAct()
					&& (_DssFrame != null)
					&&
					// !_DSSFrame.getMP().getProjectName().equals("") &&
					// getPlotter().validSelection(getView().getSelection()) &&
					// this actually changes the list of variables in the
					// FilterPanel...only need in one Action, not TableAction
					// below
					// CB TO DO: check for stuff being null first
					// CB
					// _DSSFrame.getFP().filterByBpart(getPlotter().parseSelection
					// CB (getCurrentView().getSelection()));
					_DssFrame.getFP().isFilterValid()
					&& (_DssFrame.getFP().rowsSelected() || _DssFrame.getFP()
							.areDashboardRowsSelected()); // CB
			// TP
			// _DSSFrame.getFP().isValidBpart(getPlotter().parseSelection(getCurrentView().getSelection()));
		}
	};

	SchematicRelatedAction TableAction = new SchematicRelatedAction("Table", // CB
			// why
			// not
			// use
			// DSSFrameRelatedAction
			// here?
			createIconImage("images/table24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			showOutput("Table"); // CB TO DO: tableAction????????????????????
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		public boolean canAct() {
			return super.canAct()
					&& (// !getView().getSelection().isEmpty() &&
					_DssFrame != null)
					&&
					// !_DSSFrame.getMP().getProjectName().equals("") &&
					// getPlotter().validSelection(getView().getSelection()) &&
					// CB
					// _DSSFrame.getFP().filterByBpart(getPlotter().parseSelection(
					// CB getCurrentView().getSelection()));
					_DssFrame.getFP().isFilterValid()
					&& (_DssFrame.getFP().rowsSelected() || _DssFrame.getFP()
							.areDashboardRowsSelected()); // CB
			// TP
			// _DSSFrame.getFP().isValidBpart(getPlotter().parseSelection(getCurrentView().getSelection()));
		}
	};

	SchematicRelatedAction MonthlyAction = new SchematicRelatedAction(
			"Monthly", // CB why not use DSSFrameRelatedAction here?
			createIconImage("images/monthly24.gif"), this) {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			showOutput("Monthly");
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		public boolean canAct() {
			return super.canAct()
					&& (// !getView().getSelection().isEmpty() &&
					_DssFrame != null)
					&&
					// !_DssFrame.getMP().getProjectName().equals("") &&
					// getPlotter().validSelection(getView().getSelection()) &&
					// CB
					// _DssFrame.getFP().filterByBpart(getPlotter().parseSelection(
					// CB getCurrentView().getSelection()));
					_DssFrame.getFP().isFilterActive()
					&& (_DssFrame.getFP().rowsSelected() || _DssFrame.getFP()
							.areDashboardRowsSelected()); // CB
			// TP
			// _DSSFrame.getFP().isValidBpart(getPlotter().parseSelection(getCurrentView().getSelection()));
		}
	};

	// CB TO DO:? Need to add the other plot actions
	// here????????????????????????????????????????????????????????????????????????????????????

	SchematicRelatedAction ZoomToFitAction = new SchematicRelatedAction(
			"Zoom To Fit", this) {
		public void actionPerformed(ActionEvent e) {
			getView().zoomToFit();
		}
	};

	SchematicRelatedAction OverviewAction = new SchematicRelatedAction(
			"Overview", this) {
		public void actionPerformed(ActionEvent e) {
			overviewAction();
		}
	};

	SchematicRelatedAction AboutAction = null;
	{
		Icon icon = createIconImage("images/tb_07_u.gif");
		AboutAction = new SchematicRelatedAction("About", icon, this) {
			public void actionPerformed(ActionEvent e) {
				showAbout();
			}

			public boolean canAct() {
				return true;
			}
		}; // doesn't depend on a view
	}

	// ////////////////////////////// Dss related actions
	/*
	 * SchematicRelatedAction LoadDefaultsAction = new SchematicRelatedAction(
	 * "Load default dss & svg files", this) { public void
	 * actionPerformed(ActionEvent e) {
	 * setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	 * 
	 * if (_DssFrame == null) { _DssFrame = new DssFrame(Schematic.this, false);
	 * addDocumentListener(); _DssFrame.addWindowListener(new WindowAdapter() {
	 * public void windowClosing(WindowEvent event) { _DssFrame.dispose();
	 * SwingUtilities.invokeLater(new Runnable() { public void run() { _DssFrame
	 * = null; _dateBox.setModel(new DefaultComboBoxModel());
	 * _dateBox.validate(); //no effect on removing blue "selection" color
	 * _dateBox.repaint(); //no effect on removing blue "selection" color
	 * _dateBox.repaint(); updateAllActions(); } }); } }); }
	 * 
	 * _DssFrame.mainPanel.getActions().loadDefaultFiles();
	 * 
	 * // load schematic if exists under 'defaults/svg/' if
	 * (loadDefaultSchematic()) overviewAction();
	 * 
	 * SchematicRelatedAction.updateAllActions();
	 * setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); }
	 * 
	 * // CB added for Beta version - no defaults yet! public boolean canAct() {
	 * return false; } };
	 */

	/**
	 * CB added.
	 */
	private void addDocumentListener() {
		// if
		// (_DssFrame.mainPanel.getFilterPanel().getBaseDVFileField().getDocument().listeners.contains())
		// {
		_DssFrame.mainPanel.getFilterPanel().getBaseDVFileField().getDocument()
				.addDocumentListener(Schematic.this);
		// }
	}

	SchematicRelatedAction DssOpenProjectAction = new SchematicRelatedAction(
			"Open Project", this) {
		public void actionPerformed(ActionEvent e) {
			/*
			 * setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			 * 
			 * if (_DSSFrame == null) _DSSFrame = new DSSFrame(false); String
			 * filename = _DSSFrame.mainPanel.getActions().openViewerFile(); //
			 * CB altered AppAction.updateAllActions(); if
			 * (!_DSSFrame.isVisible()) // CB added _DSSFrame.setVisible(true);
			 * setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			 * Schematic.this.updateDSSMenu(filename);
			 */

			openProject();
		}
	};

	SchematicRelatedAction OpenPropertyDirectoryAction = new SchematicRelatedAction(
			"Open Properties Directory", this) {
		public void actionPerformed(ActionEvent e) {
			String filename = openPropertiesLocation();
			updatePropertiesMenu(filename, true); // TODO test this call with
			// boolean arg added
		}
	};

	SchematicRelatedAction[] RecentProjectFilesOpenActions = new SchematicRelatedAction[NUMBER_OF_RECENT_FILES_OPENED];

	SchematicRelatedAction DssOpenViewerAction = null;
	{
		DssOpenViewerAction = new SchematicRelatedAction("Viewer", this) {
			public void actionPerformed(ActionEvent e) {
				if (_DssFrame == null) {
					_DssFrame = new DssFrame(Schematic.this, true);

					addDocumentListener();
					// CB TODO put this WindowListener somewhere so can be
					// accessed from multiple locations!!!!!!
					_DssFrame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent event) {
							_DssFrame.dispose();
							SwingUtilities.invokeLater(new Runnable() {
								public void run() {
									_DssFrame.mainPanel.stopMonthlyDataWork();
									_DssFrame = null;
									_dateBox
											.setModel(new DefaultComboBoxModel());
									_dateBox.validate();
									_dateBox.repaint();
									updateAllActions();
								}
							});
						}
					});

				} else {
					_DssFrame.setVisible(true);
				}
				SchematicRelatedAction.updateAllActions();
			}
		};
	}

	SchematicRelatedAction[] RecentPropertyDirectoriesOpenActions = new SchematicRelatedAction[NUMBER_OF_RECENT_FILES_OPENED];

	/**
	 * CB - added MAY NEED TO PROVIDE AN APPROPRIATE ERRORS MESSAGES FOR WHEN
	 * THIS DOES NOT WORK
	 * 
	 * @param openAction
	 * @param intPosition
	 */
	private SchematicRelatedAction createSchematicOpenAction(int position) {
		if ((position < 1) || (position > 5)) {
			return null;
		}
		String filename = readRecentlyOpenedFilename(position, SCHEMATIC_TYPE);
		// openAction = new AppAction(position + ": " + filename,
		// Schematic.this) {
		if ((filename == null) || (filename.trim().length() == 0)) {
			return null;
		} else {
			return new SchematicRelatedAction(position + ": " + filename,
					Schematic.this) {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() instanceof JMenuItem) {
						String filename = ((JMenuItem) e.getSource()).getText()
								.substring(
										((JMenuItem) e.getSource()).getText()
												.indexOf(":") + 1).trim();
						if (filename != null) {
							boolean isFileOpen = isSchematicFileOpen(filename);
							if (!isFileOpen) {
								String result = openSchematic(filename);
								updateFileMenu(result, true);
							}
						}// else
						// removeProjectFileOpenAction(filename);
					}
				}

				public boolean canAct() {
					return true;
				}
			}; // doesn't depend on a view
		}
	}

	/**
	 * CB - added MAY NEED TO PROVIDE AN APPROPRIATE ERROR MESSAGES FOR WHEN
	 * THIS DOES NOT WORK
	 * 
	 * @param position
	 */
	private SchematicRelatedAction createProjectOpenAction(int position) {
		if ((position < 1) || (position > 5)) {
			return null;
		}
		String filename = readRecentlyOpenedFilename(position, PROJECT_TYPE);
		if ((filename == null) || (filename.trim().length() == 0)) {
			return null;
		} else {
			return new SchematicRelatedAction(position + ": " + filename,
					Schematic.this) {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() instanceof JMenuItem) {
						String filename = ((JMenuItem) e.getSource()).getText()
								.substring(
										((JMenuItem) e.getSource()).getText()
												.indexOf(":") + 1).trim();
						if (filename != null) {
							boolean isProjectFileOpen = isProjectFileOpen(filename);
							if (!isProjectFileOpen) {
								// setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
								String result = openProject(filename);
								updateDSSMenu(result, true);
							}
						}
					}
				}

				public boolean canAct() {
					return (getCurrentView() != null);
				}
			};
		}
	}

	/**
	 * CB - added MAY NEED TO PROVIDE AN APPROPRIATE ERROR MESSAGES FOR WHEN
	 * THIS DOES NOT WORK
	 * 
	 * @param position
	 */
	private SchematicRelatedAction createPropertiesOpenAction(int position) {
		if ((position < 1) || (position > 5)) {
			return null;
		}
		String filename = readRecentlyOpenedFilename(position, PROPERTIES_TYPE);
		if ((filename == null) || (filename.trim().length() == 0)) {
			return null;
		} else {
			return new SchematicRelatedAction(position + ": " + filename,
					Schematic.this) {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() instanceof JMenuItem) {
						String filename = ((JMenuItem) e.getSource()).getText()
								.substring(
										((JMenuItem) e.getSource()).getText()
												.indexOf(":") + 1).trim();
						if (filename != null) {
							boolean isPropertiesDirectoryOpen = isPropertiesDirectoryOpen(filename);
							if (!isPropertiesDirectoryOpen) {
								openPropertiesLocation(filename);
								updatePropertiesMenu(filename, true); // TODO
								// test
								// this
								// call
								// with
								// boolean
								// arg
								// added
							}
						}
					}
				}

				public boolean canAct() {
					return (getCurrentView() != null);
				}
			};
		}
	}

	void initMenus() {
		// ==============================================================
		// Define all the command actions and setup the menus
		// ==============================================================
		JMenuItem item = null;

		filemenu.setText("File");
		filemenu.setMnemonic('F');

		JMenuItem openitem = new JMenuItem("Open Study");
		openitem.addActionListener(new GuiTaskListener("Opening Study..."){
		      public void doWork(){
						openStudy();
		      };
		    });
		filemenu.add(openitem);
		
	    JMenuItem saveitem = new JMenuItem("Save Study");
		saveitem.addActionListener(new GuiTaskListener("Saving Study..."){
	        public void doWork(){
	  				saveStudy();
	        };
	      });
		filemenu.add(saveitem);
		
	    JMenuItem saveasitem = new JMenuItem("Save Study As");
	    saveasitem.addActionListener(new GuiTaskListener("Saving Study As..."){
	        public void doWork(){
	  				saveAsStudy();
	        };
	      });	
		filemenu.add(saveasitem);
		
		filemenu.addSeparator();
		
		if (IS_DEVELOPER) { // CB added
			item = filemenu.add(FileNewAction);
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
					Event.CTRL_MASK));
			item.setMnemonic('N');
			item.setIcon(null); // choose not to use icon in menu
		}

		item = filemenu.add(FileOpenAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				Event.CTRL_MASK));
		item.setMnemonic('O');
		item.setIcon(null); // choose not to use icon in menu

		item = filemenu.add(FileCloseAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				Event.CTRL_MASK));
		item.setMnemonic('C');

		if (IS_DEVELOPER) { // CB added
			filemenu.addSeparator();

			item = filemenu.add(FileSaveAction);
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK));
			item.setMnemonic('S');
			item.setIcon(null); // choose not to use icon in menu

			item = filemenu.add(FileSaveAsAction);
			item.setMnemonic('A');

			filemenu.addSeparator();

			filemenu.add(FileImportAction);
		}

		// loadRecentFilesSubmenu();
		// filemenu.add(recentFilesSubmenu);

		setRecentSchematicFileOpenActions(true); // CB added

		// CB added if (RecentFilesOpenActions[0] != null)
		// filemenu.addSeparator(); //CB not needed addExitCommand adds
		// separator
		mainMenuBar.add(filemenu);

		if (IS_DEVELOPER) { // CB added check
			editmenu.setText("Edit");
			editmenu.setMnemonic('E');
			item = editmenu.add(CutAction);
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK));
			item.setMnemonic('t');
			item.setIcon(null); // choose not to use icon in menu

			item = editmenu.add(CopyAction);
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK));
			item.setMnemonic('C');
			item.setIcon(null); // choose not to use icon in menu
			item = editmenu.add(PasteAction);
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK));
			item.setMnemonic('P');
			item.setIcon(null); // choose not to use icon in menu

			item = editmenu.add(DeleteAction);
			item.setMnemonic('D');

			item = editmenu.add(SelectAllAction);
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
					Event.CTRL_MASK));
			item.setMnemonic('l');

			editmenu.addSeparator();
			UndoMenuItem = editmenu.add(UndoAction);
			UndoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
					Event.CTRL_MASK));
			UndoMenuItem.setMnemonic('U');
			UndoMenuItem.setIcon(null); // choose not to use icon in menu

			RedoMenuItem = editmenu.add(RedoAction);
			RedoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
					Event.CTRL_MASK));
			RedoMenuItem.setMnemonic('R');
			RedoMenuItem.setIcon(null); // choose not to use icon in menu

			editmenu.addSeparator();
			editmenu.add(GroupAction);
			editmenu.add(UngroupAction);

			mainMenuBar.add(editmenu);
		}

		viewmenu.setText("View");
		viewmenu.setMnemonic('V');

		item = viewmenu.add(ZoomNormalAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,
				Event.CTRL_MASK | Event.SHIFT_MASK));
		item.setMnemonic('N');

		item = viewmenu.add(ZoomInAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,
				Event.CTRL_MASK));
		item.setMnemonic('I');
		item.setIcon(null); // choose not to use icon in menu

		item = viewmenu.add(ZoomOutAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,
				Event.SHIFT_MASK));
		item.setMnemonic('O');
		item.setIcon(null); // choose not to use icon in menu

		item = viewmenu.add(ZoomToFitAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		item.setMnemonic('Z');

		viewmenu.addSeparator();

		viewmenu.add(OverviewAction).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK));

		mainMenuBar.add(viewmenu);

		// DSS menu
		dssmenu.setText("DSS");
		dssmenu.setMnemonic('D');

		item = dssmenu.add(DssOpenProjectAction);
		item.setMnemonic('O');

		item = dssmenu.add(DssOpenViewerAction);
		item.setMnemonic('V');

		setRecentProjectFileOpenActions(true); // CB added

		dssmenu.addSeparator();
		// temp? item = dssmenu.add(LoadDefaultsAction);
		// temp? item.setMnemonic('L');

		mainMenuBar.add(dssmenu);

		// CB added section
		// Property (from lookup tables in WRIMS 1) menu
		propertyMenu.setText("Properties");
		propertyMenu.setMnemonic('O');
		item = propertyMenu.add(OpenPropertyDirectoryAction);
		item.setMnemonic('O');
		setRecentPropertyDirectoriesOpenActions(true); // CB added
		// propertyMenu.addSeparator();
		// item = propertyMenu.add(LoadDefaultsAction);
		// item.setMnemonic('L');
		propertyMenu.setEnabled(false);
		mainMenuBar.add(propertyMenu);

		// Help menu
		helpmenu.setText("Help");
		helpmenu.setMnemonic('H');

		/*
		 * item = helpmenu.add(AboutAction); item.setMnemonic('A');
		 * item.setIcon(null); //choose not to use icon in menu
		 */

		// mainMenuBar.add(helpmenu);
		setJMenuBar(mainMenuBar);
	}

	/*
	 * private void loadRecentFilesMenuItems() { if (recentFilesSubmenu == null)
	 * return; recentFilesSubmenu.removeAll(); if (RecentFilesOpenAction[0] !=
	 * null) { recentFilesSubmenu.addSeparator();
	 * recentFilesSubmenu.add(RecentFilesOpenAction[0]); for (int i = 1; i <
	 * NUMBER_OF_RECENT_FILES_OPENED; ++i) { if (RecentFilesOpenAction[i] !=
	 * null) recentFilesSubmenu.add(RecentFilesOpenAction[i]); }
	 * recentFilesSubmenu.addSeparator(); } }
	 */

	private JToolBar initToolbar1() { // CB renamed and changed to private
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(0);
		JButton button = null;
		if (Schematic.IS_DEVELOPER) {
			button = toolBar.add(FileNewAction);
			button.setToolTipText("New schematic window");
		}
		button = toolBar.add(FileOpenAction);
		button.setToolTipText("Open schematic window");
		if (Schematic.IS_DEVELOPER) {
			button = toolBar.add(FileSaveAction);
			button.setToolTipText("Save window");
		}
		toolBar.addSeparator();
		if (Schematic.IS_DEVELOPER) {
			button = toolBar.add(CutAction);
			button.setToolTipText("Cut to clipboard");
			button = toolBar.add(CopyAction);
			button.setToolTipText("Copy to clipboard");
			button = toolBar.add(PasteAction);
			button.setToolTipText("Paste to clipboard");
			toolBar.addSeparator();
			button = toolBar.add(UndoAction);
			button.setToolTipText("Undo");
			button = toolBar.add(RedoAction);
			button.setToolTipText("Redo");
			toolBar.addSeparator();
		}
		button = toolBar.add(ZoomInAction);
		button.setToolTipText("Zoom In");
		button = toolBar.add(ZoomOutAction);
		button.setToolTipText("Zoom Out");
		toolBar.addSeparator();
		button = toolBar.add(PlotAction);
		button.setToolTipText("Plot");
		button = toolBar.add(TableAction);
		button.setToolTipText("Table");
		button = toolBar.add(MonthlyAction); // CB added
		button.setToolTipText("Monthly Table"); // CB added

		// CB added progress bar section
		GridBagConstraints gc = new GridBagConstraints();
		JPanel progressBarPanel = new JPanel(new GridBagLayout());
		gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 0.0;
		gc.ipadx = 5;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		progressBarPanel.add(_monthlyProgressLabel, gc);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1.0;
		gc.ipadx = 50;
		progressBarPanel.add(_monthlyProgressBar, gc);
		gc.fill = GridBagConstraints.NONE;
		gc.ipadx = 0;
		gc.weightx = 0.0;
		progressBarPanel.add(new Label(" "), gc);

		gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 0.0;
		gc.ipadx = 5;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		progressBarPanel.add(_longtermProgressLabel, gc);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1.0;
		gc.ipadx = 50;
		progressBarPanel.add(_longtermProgressBar, gc);
		gc.fill = GridBagConstraints.NONE;
		gc.ipadx = 0;
		gc.weightx = 0.0;
		progressBarPanel.add(new Label("  "), gc);
		setProgressVisibility(false);

		toolBar.addSeparator();
		toolBar.add(progressBarPanel, "West");

		return toolBar;
	}

	protected JToolBar initToolbar2() { // CB renamed
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(0);
		JPanel dssPeriodControlPanel = new JPanel();
		dssPeriodControlPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 0.0;
		gc.ipadx = 5;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;

		dssPeriodControlPanel.add(new JLabel("Units:"), gc);
		ButtonGroup g = new ButtonGroup();
		g.add(_TAFButton);
		g.add(_CFSButton);
		_CFSButton.setSelected(true);
		dssPeriodControlPanel.add(_TAFButton);
		dssPeriodControlPanel.add(new JLabel("TAF"));
		dssPeriodControlPanel.add(_CFSButton);
		dssPeriodControlPanel.add(new JLabel("CFS"));

		/**
		 * CB added.
		 */
		_TAFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_DssFrame.mainPanel.getMessagePanel().updateUnitsButtons(
						Schematic.TAF);
				// update the value boxes IFF a selection exists
				if (_dateBox.getSelectedIndex() != 0) {
					// String date =
					// ((ComboItem)_dateBox.getSelectedItem()).toString();
					// updateValues(date);
					updateValues();
				}
			}
		});
		/**
		 * CB added.
		 */
		_CFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_DssFrame.mainPanel.getMessagePanel().updateUnitsButtons(
						Schematic.CFS);
				// update the value boxes IFF a selection exists
				if (_dateBox.getSelectedIndex() != 0) {
					// String date =
					// ((ComboItem)_dateBox.getSelectedItem()).toString();
					// updateValues(date);
					updateValues();
				}
			}
		});

		JLabel showValueBoxesLabel = new JLabel("Show Values"); // CB added
		_showValueBoxesCheckbox = new JCheckBox(); // CB added
		_showValueBoxesCheckbox.setSelected(true); // CB added TODO use
		// preferences to set
		// initial state
		_showValueBoxesCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() instanceof JCheckBox) {
					boolean isVisible = ((JCheckBox) event.getSource())
							.isSelected();
					Schematic.this.getCurrentView().getDoc()
							.setValueNodeVisibility(isVisible);
				}
			}
		});

		String location = "D:/WrimsSchematic/wrims/schematic/images"; // CB TO
		// DO:
		// make
		// it a
		// relative
		// constant
		// somewhere!!!!!
		_forward1PeriodButton = new JButton(new ImageIcon(location
				+ "/forward.gif"));
		_forward1PeriodButton.setAction(Forward1Action);
		_back1PeriodButton = new JButton(new ImageIcon(location + "/back.gif"));
		_back1PeriodButton.setAction(Back1Action);
		_forward1BlockButton = new JButton(new ImageIcon(location
				+ "/fastforward.gif"));
		_forward1BlockButton.setAction(ForwardBlockAction);
		_back1BlockButton = new JButton(new ImageIcon(location
				+ "/fastback.gif"));
		_back1BlockButton.setAction(BackBlockAction);

		dssPeriodControlPanel.add(new JLabel("        "), gc);
		dssPeriodControlPanel.add(showValueBoxesLabel, gc);
		dssPeriodControlPanel.add(_showValueBoxesCheckbox, gc);
		dssPeriodControlPanel.add(new JLabel("      "), gc);
		dssPeriodControlPanel.add(_forward1PeriodButton, gc);
		dssPeriodControlPanel.add(_back1PeriodButton, gc);
		dssPeriodControlPanel.add(_forward1BlockButton, gc);
		dssPeriodControlPanel.add(_back1BlockButton, gc);
		dssPeriodControlPanel.add(new Label("  "), gc);
		/*
		 * No - does not work in toolBar toolBar.add(showValueBoxesLabel, gc);
		 * toolBar.add(_showValueBoxesCheckbox, gc); toolBar.add(new
		 * JLabel(" "), gc); toolBar.add(_forward1PeriodButton, gc);
		 * toolBar.add(_back1PeriodButton, gc);
		 * toolBar.add(_forward1BlockButton, gc); toolBar.add(_back1BlockButton,
		 * gc); toolBar.add(new Label("  "), gc);
		 */

		dssPeriodControlPanel.add(new JLabel("Date: "), gc);
		// No toolBar.add(dateLabel, gc);
		_dateBox = new JComboBox();
		_dateBox.setAction(SingleStepValuesAction);
		gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 0.0;
		gc.ipadx = 50;
		dssPeriodControlPanel.add(_dateBox, gc);
		gc.ipadx = 0;
		gc.weightx = 1.0;
		dssPeriodControlPanel.add(new Label(" "), gc);
		toolBar.add(dssPeriodControlPanel, "East");
		// No toolBar.add(_dateBox, gc);
		// No toolBar.add(new Label(" "), gc);
		return toolBar;
	}

	public void addExitCommand() {
		filemenu.addSeparator();

		SchematicRelatedAction ExitAction = new SchematicRelatedAction("Exit",
				this) {
			public void actionPerformed(ActionEvent e) {
				exit();
			}

			public boolean canAct() {
				return true;
			}
		}; // doesn't depend on a view

		JMenuItem item = filemenu.add(ExitAction);
		item.setMnemonic('x');
	}

	public void init() {
		JGoImage.setDefaultBase(getCodeBase());
	}

	// CB void initPalette() {
	void initPalette(int style) { // CB
		myPaletteTabbedPane.setSelectedIndex(style); // CB added
		getPalette().setBorder(new TitledBorder("WRIMS Palette"));

		NetworkNode nnode;
		JGoText label;

		JGoDocument doc = getPalette().getDocument();

		/*
		 * // Comment node, construct w/o port JGoBasicNode cnode = new
		 * JGoBasicNode(); label = new JGoText("comment");
		 * label.setEditable(true); label.setMultiline(true);
		 * cnode.setLabel(label); cnode.setLabelSpot(JGoObject.Center);
		 * //cnode.setBrush(JGoBrush.makeStockBrush(Color.cyan));
		 * cnode.setDrawable(new JGoRectangle());
		 * cnode.setPen(JGoPen.make(JGoPen.SOLID, 1, Color.white));
		 * doc.addObjectAtTail(cnode);
		 */
		boolean isCAD; // CB added isCAD lines
		if (style == CALSIM_II_STYLE) {
			isCAD = true;
		} else {
			isCAD = false;
		}

		// Another comment node
		if (isCAD) { // CB added if statement
			JGoTextNode tn = new JGoTextNode("Annotation");
			tn.setTopPort(null);
			tn.setBottomPort(null);
			tn.setLeftPort(null);
			tn.setRightPort(null);
			JGoText text = tn.getLabel();
			text.setFontSize(10);
			// tn.setBrush(JGoBrush.makeStockBrush(Color.lightGray));
			// tn.setBrush(JGoBrush.makeStockBrush(new Color(230, 230, 250)));
			tn.setBrush(JGoBrush.makeStockBrush(new Color(240, 240, 255)));
			tn.getLabel().setEditable(true);
			// tn.getLabel().setAlignment(JGoText.ALIGN_CENTER);
			doc.addObjectAtTail(tn);

			// Text node
			TextNode tnode = new TextNode("generic label");
			label = tnode.getLabel();
			label.setEditable(true);
			label.setMultiline(true);
			tnode.setLabelSpot(JGoObject.Center);
			tnode.setDrawable(new JGoRectangle());
			tnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.white));
			tnode.setToolTipText("");
			doc.addObjectAtTail(tnode);

			// CB they added a bunch of text colors
			tnode = new TextNode("GW label");
			label = tnode.getLabel();
			label.setTextColor(Color.MAGENTA);
			label.setEditable(true);
			label.setMultiline(true);
			label.setBold(true);
			// label.setFontSize(10);
			tnode.setLabelSpot(JGoObject.Center);
			tnode.setDrawable(new JGoRectangle());
			tnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.white));
			tnode.setToolTipText("");
			doc.addObjectAtTail(tnode);

			tnode = new TextNode("Diversion label");
			label = tnode.getLabel();
			label.setTextColor(Color.RED);
			label.setEditable(true);
			label.setMultiline(true);
			label.setBold(true);
			// label.setFontSize(10);
			tnode.setLabelSpot(JGoObject.Center);
			tnode.setDrawable(new JGoRectangle());
			tnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.white));
			tnode.setToolTipText("");
			doc.addObjectAtTail(tnode);

			tnode = new TextNode("River label");
			label = tnode.getLabel();
			label.setTextColor(Color.BLUE);
			label.setEditable(true);
			label.setMultiline(true);
			label.setBold(true);
			// label.setFontSize(10);
			tnode.setLabelSpot(JGoObject.Center);
			tnode.setDrawable(new JGoRectangle());
			tnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.white));
			tnode.setToolTipText("");
			doc.addObjectAtTail(tnode);

			tnode = new TextNode("Return label");
			label = tnode.getLabel();
			label.setTextColor(Schematic.ARC_GREEN);
			label.setEditable(true);
			label.setMultiline(true);
			label.setBold(true);
			// label.setFontSize(10);
			tnode.setLabelSpot(JGoObject.Center);
			tnode.setDrawable(new JGoRectangle());
			tnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.white));
			tnode.setToolTipText("");
			doc.addObjectAtTail(tnode);

		} else { // CB added section
			// Text node CB copied from above
			// CB JGoBasicNode tnode = new JGoBasicNode("Text Node");
			TextNode tnode = new TextNode("Annotation");
			/*
			 * CB created class and moved bulk to init method label =
			 * tnode.getLabel(); label.setEditable(true);
			 * label.setMultiline(true); label.setFontSize(label.getFontSize() +
			 * 2); //CB make larger label.setBold(true);
			 * tnode.setLabelSpot(JGoObject.Center); tnode.setDrawable(new
			 * JGoRectangle()); tnode.setPen(JGoPen.make(JGoPen.SOLID, 2,
			 * Color.white));
			 */
			doc.addObjectAtTail(tnode);
			// Annotation node
			// CB JGoBasicNode node = new JGoBasicNode("Gage station");
			GageNode node = new GageNode("Gage station");
			/*
			 * CB created class and moved bulk to init method label =
			 * node.getLabel(); label.setEditable(true);
			 * label.setMultiline(true); label.setBold(true);
			 * node.setLabelSpot(JGoObject.Center); node.setDrawable(new
			 * JGoRectangle());
			 * node.setBrush(JGoBrush.makeStockBrush(Color.LIGHT_GRAY));
			 * node.setPen(JGoPen.make(JGoPen.NONE, 2, Color.LIGHT_GRAY));
			 */
			doc.addObjectAtTail(node);
			// Variable nodes
			nnode = new NetworkNode("river", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.BLUE);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLUE));
			nnode.setToolTipText("River/Stream Channel");
			doc.addObjectAtTail(nnode);

			/*
			 * CB created class and moved bulk to init method nnode = new
			 * NetworkNode("old name", NetworkNode.VARIABLE, false); label =
			 * nnode.getLabel(); label.setMultiline(false);
			 * label.setTextColor(Color.BLUE); label.setBold(true);
			 * nnode.setBrush(JGoBrush.makeStockBrush(Color.YELLOW));
			 * nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.CYAN));
			 */
			ValueNode vnode = new ValueNode(1, ALT_STRINGS[0] + " value");
			// need? vnode.
			// doc.addObjectAtTail(nnode);
			doc.addObjectAtTail(vnode);

			vnode = new ValueNode(2, ALT_STRINGS[1] + " value");
			// vnode.init
			doc.addObjectAtTail(vnode);

			nnode = new NetworkNode("channel", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.GRAY);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.GRAY));
			nnode.setToolTipText("Canal Channel");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("return", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Schematic.ARC_GREEN);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Schematic.ARC_GREEN));
			nnode.setToolTipText("Return Flow");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("spill", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.BLACK);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
			nnode.setToolTipText("Spill");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("diversion", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.RED);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.RED));
			nnode.setToolTipText("Diversion");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("bypass", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(BROWN);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			// nnode.setPen(JGoPen.make(JGoPen.SOLID, 1, Color.YELLOW));
			// nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, ALMOST_YELLOW));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, MUSTARD));
			nnode.setToolTipText("Bypass Channel");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("boundary", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.BLUE);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.CYAN));
			nnode.setToolTipText("Inflow");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("LCPSIM", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Schematic.VIOLET);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Schematic.VIOLET));
			nnode.setToolTipText("LCPSIM");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("groundwater", NetworkNode.VARIABLE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.MAGENTA);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.WHITE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.MAGENTA));
			nnode.setToolTipText("Groundwater");
			doc.addObjectAtTail(nnode);

			// Surface Runoff type - perhaps magenta or pink //CB TODO:
			// nnode.setToolTipText("Surface Runoff"); //CB TODO:
			// ??????????????????????????????????????????????????????????????????

			nnode = new NetworkNode("River(s)", NetworkNode.BOUNDARY, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.BLACK);
			label.setBold(true);
			nnode.setBrush(JGoBrush.makeStockBrush(Color.CYAN));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
			nnode.setToolTipText("Boundary");
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("WTP \nXXX", NetworkNode.PLANT,
					Color.BLACK, Color.WHITE, JGoPen.SOLID, 2);
			label = nnode.getLabel();
			label.setBold(true);
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("Waste TP", NetworkNode.WASTE_PLANT, false);
			label = nnode.getLabel();
			label.setBold(true);
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("Closure Term", NetworkNode.CLOSURE, false);
			label = nnode.getLabel();
			label.setMultiline(false);
			label.setTextColor(Color.WHITE);
			label.setBold(true);
			doc.addObjectAtTail(nnode);
		}
		if (isCAD) {
			// nnode = new NetworkNode("     \n0", NetworkNode.NETWORK, isCAD);
			// //CB taller node
			nnode = new NetworkNode("0", NetworkNode.NETWORK, isCAD); // shorter
			// node
			// (more
			// elliptical)
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
			label = nnode.getLabel();
			label.setBold(true);
			label.setFontSize(10);
			doc.addObjectAtTail(nnode);
			// CB added LCPSIM node
			nnode = new NetworkNode("", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Schematic.VIOLET));
			nnode.setBrush(JGoBrush.makeStockBrush(Schematic.VIOLET));
			label = nnode.getLabel();
			label.setBold(true);
			label.setFontSize(10);
			label.setTextColor(Schematic.VIOLET);
			nnode.setToolTipText("LCPSIM node");
			doc.addObjectAtTail(nnode);
			// CB added groundwater node
			nnode = new NetworkNode("0", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.MAGENTA));
			label = nnode.getLabel();
			label.setBold(true);
			label.setFontSize(10);
			label.setTextColor(Color.MAGENTA);
			nnode.setToolTipText("Groundwater node");
			doc.addObjectAtTail(nnode);
			// CB added groundwater node
			nnode = new NetworkNode("", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.GREEN));
			label = nnode.getLabel();
			label.setBold(true);
			label.setFontSize(10);
			label.setTextColor(Color.WHITE); // not text
			nnode.setToolTipText("Module boundary");
			doc.addObjectAtTail(nnode);
			// CB added invisible node
			nnode = new NetworkNode("0", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.WHITE));
			label = nnode.getLabel();
			label.setBold(true);
			label.setFontSize(10);
			label.setTextColor(Color.WHITE);
			nnode.setToolTipText("");
			doc.addObjectAtTail(nnode);
		} else {
			// CB revamped NetworkNodes
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLUE));
			label = nnode.getLabel();
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.DASHED, 2, Color.BLUE));
			label = nnode.getLabel();
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.DOTTED, 2, Color.BLUE));
			label = nnode.getLabel();
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			// CB they changed the color scheme
			// nnode.setBrush(JGoBrush.makeStockBrush(Color.GRAY));
			nnode.setBrush(JGoBrush.makeStockBrush(Color.BLUE));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLUE));
			label = nnode.getLabel();
			label.setTextColor(Color.WHITE);
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			// CB they changed the color scheme
			// nnode.setBrush(JGoBrush.makeStockBrush(Color.GRAY));
			nnode.setBrush(JGoBrush.makeStockBrush(Color.BLUE));
			nnode.setPen(JGoPen.make(JGoPen.DASHED, 2, Color.BLUE));
			label = nnode.getLabel();
			label.setTextColor(Color.WHITE);
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.GRAY));
			label = nnode.getLabel();
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.DASHED, 2, Color.GRAY));
			label = nnode.getLabel();
			label.setBold(true);
			doc.addObjectAtTail(nnode);

			// CB they changed the color scheme again
			nnode.setBrush(JGoBrush.makeStockBrush(Color.GRAY));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.GRAY));
			label = nnode.getLabel();
			label.setTextColor(Color.WHITE);
			label.setBold(true);
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			// CB they changed the color scheme:
			// CB nnode.setBrush(JGoBrush.makeStockBrush(NODE_GREEN));
			// CB nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, Color.BLACK));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, ARC_GREEN));
			label = nnode.getLabel();
			label.setTextColor(ARC_GREEN);
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.DASHED, 2, ARC_GREEN));
			label = nnode.getLabel();
			label.setTextColor(ARC_GREEN);
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setBrush(JGoBrush.makeStockBrush(MUSTARD));
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, MUSTARD));
			label = nnode.getLabel();
			label.setTextColor(BROWN);
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 2, MUSTARD));
			label = nnode.getLabel();
			label.setTextColor(BROWN);
			label.setBold(true);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("XXX\n000", NetworkNode.NETWORK, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.DASHED, 2, MUSTARD));
			label = nnode.getLabel();
			label.setTextColor(BROWN);
			label.setBold(true);
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode("DWR\n000", NetworkNode.DWR, isCAD);
			nnode.setPen(JGoPen.make(JGoPen.SOLID, 1, Color.BLACK));
			doc.addObjectAtTail(nnode);
		}

		// nnode = new NetworkNode("0", NetworkNode.RESERVOIR, true,
		// PlotAction);
		// CB nnode = new NetworkNode("0", NetworkNode.RESERVOIR, true);
		nnode = new NetworkNode("0", NetworkNode.RESERVOIR, isCAD);
		doc.addObjectAtTail(nnode);
		// CB nnode = new NetworkNode("0", NetworkNode.URESERVOIR, true); //CB
		// added URESERVOIR
		nnode = new NetworkNode("0", NetworkNode.URESERVOIR, isCAD); // CB added
		// URESERVOIR
		doc.addObjectAtTail(nnode);
		// nnode = new NetworkNode("0", NetworkNode.VRESERVOIR, true, this);
		// CB nnode = new NetworkNode("0", NetworkNode.RRESERVOIR, true); //CB
		// changed VRESERVOIR to RRESERVOIR
		nnode = new NetworkNode("0", NetworkNode.RRESERVOIR, isCAD); // CB
		// changed
		// VRESERVOIR
		// to
		// RRESERVOIR
		doc.addObjectAtTail(nnode);
		// CB added
		// CB nnode = new NetworkNode("0", NetworkNode.LRESERVOIR, true); //CB
		// added LRESERVOIR
		nnode = new NetworkNode("0", NetworkNode.LRESERVOIR, isCAD); // CB added
		// LRESERVOIR
		doc.addObjectAtTail(nnode);
		// CB added black (not implemented) reservoir shapes
		nnode = new NetworkNode("0", NetworkNode.RESERVOIR_NOTUSED, isCAD);
		doc.addObjectAtTail(nnode);
		// CB nnode = new NetworkNode("0", NetworkNode.URESERVOIR, true); //CB
		// added URESERVOIR
		nnode = new NetworkNode("0", NetworkNode.URESERVOIR_NOTUSED, isCAD); // CB
		// added
		// URESERVOIR
		doc.addObjectAtTail(nnode);
		// nnode = new NetworkNode("0", NetworkNode.VRESERVOIR, true, this);
		// CB nnode = new NetworkNode("0", NetworkNode.RRESERVOIR, true); //CB
		// changed VRESERVOIR to RRESERVOIR
		nnode = new NetworkNode("0", NetworkNode.RRESERVOIR_NOTUSED, isCAD); // CB
		// changed
		// VRESERVOIR
		// to
		// RRESERVOIR
		doc.addObjectAtTail(nnode);
		// CB added
		// CB nnode = new NetworkNode("0", NetworkNode.LRESERVOIR, true); //CB
		// added LRESERVOIR
		nnode = new NetworkNode("0", NetworkNode.LRESERVOIR_NOTUSED, isCAD); // CB
		// added
		// LRESERVOIR
		doc.addObjectAtTail(nnode);

		if (isCAD) { // CB added if
			// CB added groundwater storage
			nnode = new NetworkNode("0", NetworkNode.GWSTORAGE, isCAD);
			doc.addObjectAtTail(nnode);
			// CB added LCPSIM storage
			nnode = new NetworkNode("0", NetworkNode.LCPSIMSTORAGE, isCAD);
			doc.addObjectAtTail(nnode);
			// CB nnode = new NetworkNode("0", NetworkNode.DEMAND, true);
			nnode = new NetworkNode("0", NetworkNode.DEMAND, isCAD);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("0", NetworkNode.DEMAND_ALT, isCAD);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode();
			nnode.init(NetworkNode.POWER);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode();
			nnode.init(NetworkNode.VPOWER);
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode();
			nnode.init(NetworkNode.PUMPING);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode();
			nnode.init(NetworkNode.VPUMPING);
			doc.addObjectAtTail(nnode);

			nnode = new NetworkNode();
			nnode.init(NetworkNode.DSA);
			doc.addObjectAtTail(nnode);
		} else { // CB added section
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, Color.LIGHT_GRAY, JGoPen.SOLID, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, Color.LIGHT_GRAY, JGoPen.DASHED, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, Color.LIGHT_GRAY, JGoPen.DOTTED, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, NODE_GREEN, JGoPen.SOLID, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, NODE_GREEN, JGoPen.DASHED, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, NODE_GREEN, JGoPen.DOTTED, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, YUCK, JGoPen.SOLID, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, YUCK, JGoPen.DASHED, 2);
			doc.addObjectAtTail(nnode);
			nnode = new NetworkNode("WBA #\nNon-project", NetworkNode.DEMAND,
					Color.BLACK, YUCK, JGoPen.DOTTED, 2);
			doc.addObjectAtTail(nnode);
		}

		/*
		 * nnode = new NetworkNode(); nnode.init(NetworkNode.Variable);
		 * doc.addObjectAtTail(nnode);
		 * 
		 * nnode = new NetworkNode("0", NetworkNode.Reservoir);
		 * doc.addObjectAtTail(nnode);
		 * 
		 * nnode = new NetworkNode("0", NetworkNode.Network);
		 * doc.addObjectAtTail(nnode);
		 * 
		 * nnode = new NetworkNode("C", NetworkNode.Variable);
		 * doc.addObjectAtTail(nnode);
		 * 
		 * nnode = new NetworkNode("0", NetworkNode.Plant);
		 * doc.addObjectAtTail(nnode);
		 * 
		 * nnode = new NetworkNode("0", NetworkNode.Boundary, "", "cyan");
		 * doc.addObjectAtTail(nnode);
		 */

		// CB added Calsim III style stuff
		// if (style == CALSIM_III_STYLE)
		// myPaletteTabbedPane.setSelectedIndex(CALSIM_II_STYLE); //CB added

	}

	public void start() {
		if (!IS_DEVELOPER) {
			return; // CB added
		}
		// enable drag-and-drop from separate thread
		new Thread(this).start();

		initPalette(CALSIM_II_STYLE); // CB added
		initPalette(CALSIM_III_STYLE); // CB added
		getContentPane().validate(); // CB added - DOES NOTHING. TO DO: CAD tab
		// looks wide until spilt pane is
		// clicked on! FIX IT
	}

	public void run() {
		// CB getPalette().initializeDragDropHandling();
		if (IS_DEVELOPER) { // CB added
			getPalette(0).initializeDragDropHandling(); // CB added. TO DO: get
			// rid of hard coding of
			// indices
			getPalette(1).initializeDragDropHandling(); // CB added. TO DO: get
			// rid of hard coding of
			// indices
		}

		if (getDesktop().getAllFrames().length == 0) {
			newSchematic();
			// Importer importer = new Importer(getCurrentView().getDoc());
			// importer.addObjectsFromFile();
			// importer.addConnectorsFromFile();
		}

		SchematicRelatedAction.updateAllActions();
	}

	public void closeAllFrames() {
		JInternalFrame[] frames = getDesktop().getAllFrames();
		for (JInternalFrame f : frames) {
			try {
				f.setClosed(true);
			} catch (Exception x) {
			}
		}
	}

	public void destroy() {
		super.destroy();
		theApp.dispose();
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String devMode = System.getProperty("wrims.schematic.devMode");
		IS_DEVELOPER = Boolean.valueOf(devMode);
		String directory = "";
		if ((args != null) && (args.length > 0)) {
			directory = args[0];
		}
		SchematicUtils.schematic = new Schematic(directory, true);
	}

	static Frame getApp() {
		return theApp;
	}

	void exit() {
		closeAllFrames();
		destroy();
		if (_isStandalone) {
			System.exit(0);
		}
		System.gc();
	}

	void showAbout() {
		HelpDlg helpDlg = new HelpDlg(mainFrame, "About", true);
		helpDlg.setVisible(true);
	}

	void editSchematicProperties() {
		SchematicView v = getCurrentView();
		if (v != null) {
			v.getDoc().startTransaction();
			new SchematicDialog(v.getFrame(), v.getDoc()).setVisible(true);
			v.getDoc().endTransaction("Schematic Properties");
		}
	}

	// CB public void createFrame(SchematicDocument doc) {
	public WrimsSchematicInternalFrame createFrame(SchematicDocument doc) {
		// CB I would have overridden JInternalFrame class and it would have had
		// a SchematicView, not the other way around!!!!!!
		final SchematicView view = new SchematicView(doc);
		// CB final JInternalFrame frame = new JInternalFrame(doc.getName(),
		// true, true, true);
		final WrimsSchematicInternalFrame frame = new WrimsSchematicInternalFrame(
				view); // CB
		frame.setName(doc.getLocation()); // CB - use the frame name to store
		// location
		frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		view.initialize(this, frame); // This line adds 50 GB to RAM for
		// non-modifiable due to JGoImage code

		// keep track of the "current" view, even if it doesn't have focus
		// try to give focus to a view when it becomes activated
		// enable/disable all the command actions appropriately for the view
		frame.addInternalFrameListener(new InternalFrameListener() {
			public void internalFrameActivated(InternalFrameEvent e) {
				// CB myCurrentView = view;
				// CB myCurrentView.requestFocus();
				// CB if (myOverview != null)
				// CB myOverview.setObserved(myCurrentView);
				// CB myCurrentView.getDoc().updateLocationModifiable();
				// CB SchematicRelatedAction.updateAllActions();
				// CB code replacement block for internal frame that has a view,
				// not the opposite as was previously done
				SchematicView frameView = null;
				if (e.getSource() instanceof WrimsSchematicInternalFrame) {
					frameView = ((WrimsSchematicInternalFrame) e.getSource())
							.getView();
					frameView.requestFocus();
					if (myOverview != null) {
						myOverview.setObserved(frameView);
					}
					frameView.getDoc().updateLocationModifiable();
					SchematicRelatedAction.updateAllActions();
				}
			}

			public void internalFrameDeactivated(InternalFrameEvent e) {
			}

			public void internalFrameOpened(InternalFrameEvent e) {
			}

			public void internalFrameClosing(InternalFrameEvent e) {
			}

			public void internalFrameClosed(InternalFrameEvent e) {
				// CB myCurrentView = null; //CB NO, replaced
				// "view has an internal frame" with "internal frame has a view"
				SchematicView frameView = null;
				if (e.getSource() instanceof WrimsSchematicInternalFrame) {
					frameView = ((WrimsSchematicInternalFrame) e.getSource())
							.getView();
					// frameView = null;
				}
				if (frameView != null) {
					SchematicDocument sDoc = frameView.getDoc();
					JGoDocument doc = frameView.getDocument(); // same document
					// as previous
					// line
					sDoc = null; // does not solve memory issue
					doc = null; // does not solve memory issue
					frameView = null; // does not solve memory issue
				}
				SchematicRelatedAction.updateAllActions();
			}

			public void internalFrameIconified(InternalFrameEvent e) {
			}

			public void internalFrameDeiconified(InternalFrameEvent e) {
			}
		});

		frame
				.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
					public void vetoableChange(
							java.beans.PropertyChangeEvent evt)
							throws java.beans.PropertyVetoException {
						if (!Schematic.IS_DEVELOPER) {
							return;
						}
						if (evt.getPropertyName().equals(
								JInternalFrame.IS_CLOSED_PROPERTY)
								&& (evt.getOldValue() == Boolean.FALSE)
								&& (evt.getNewValue() == Boolean.TRUE)) {
							if (view.getDoc().isModified()) {
								String msg = "Save changes to ";
								if (view.getDoc().getName().equals("")) {
									msg += "modified document?";
								} else {
									msg += view.getDoc().getName();
								}
								msg += "\n  (";
								if (view.getDoc().getLocation().equals("")) {
									msg += "<no location>";
								} else {
									msg += view.getDoc().getLocation();
								}
								msg += ")";
								int answer = JOptionPane.showConfirmDialog(view
										.getFrame(), msg,
										"Closing modified document",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE);
								if ((answer == JOptionPane.NO_OPTION)
										|| (answer == JOptionPane.YES_OPTION)) {
									if (answer == JOptionPane.YES_OPTION) {
										if (view.getDoc()
												.isLocationModifiable()) {
											view.getDoc().save();
										} else {
											view.getDoc().saveAs(".svg");
										}
									}
									// then allow the internal frame to close
									getDesktop().remove(frame);
									getDesktop().repaint();
								} else {
									// CANCEL_OPTION--don't close
									throw new java.beans.PropertyVetoException(
											"", evt);
								}
							}
						}
					}
				});

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(view);

		frame.setSize(500, 400);
		getDesktop().add(frame);
		frame.show();
		view.initializeDragDropHandling();

		// view.setBackground(Color.WHITE); //CB tried to make white, but
		// already is! It appears off-white for non-modifiable views though
		// System.out.println("background color = " + view.getBackground());
		// System.out.println("transparency = " +
		// view.getDocument().getDefaultLayer().getTransparency());
		// System.out.println("first layer transparency = " +
		// view.getDocument().getFirstLayer().getTransparency()); //no color for
		// layers
		// System.out.println("number of layers = " +
		// view.getDocument().getNumLayers());
		return frame; // CB added
	}

	public boolean loadDefaultSchematic() {

		// filter for svg files
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".svg");
			}
		};
		// CB String loc = "c:/ztp/schematic_dss/defaults/svg/";
		String loc = "wrims/schematic/svg"; // CB get from a jar

		File dir = new File(loc);
		String[] children = dir.list(filter);

		if (children == null) {
			// Either dir does not exist or is not a directory
			System.out.println("No svg files");
			return false;
		} else {
			String filename = children[0];
			System.out.println("file: " + filename);

			loc = loc + filename;
			SchematicDocument doc = SchematicDocument.openDoc(this, loc,
					filename);
			if (doc != null) {
				createFrame(doc);
			}
			if (doc != null) {
				/*
				 * CB JInternalFrame frame =
				 * getCurrentView().getInternalFrame(); if (frame != null) { try
				 * { frame.setMaximum(true); } catch (Exception x) { } }
				 */
				// CB replacement block (ONLY GOOD IF
				// SchematicDocument.openDoc(this, loc, filename); CREATES THE
				// FRAME!!!
				if (myDesktop.getAllFrames().length > 0) {
					JInternalFrame frame = myDesktop.getSelectedFrame();
					try {
						frame.setMaximum(true);
					} catch (Exception x) {
					}
				}
			}
		}
		return true;
	}

	SchematicDocument newSchematic() { // CB added return type
		// CB SchematicDocument doc = new SchematicDocument();
		SchematicDocument doc = new SchematicDocument("Untitled"
				+ Integer.toString(myDocCount++)); // CB attempt to force
		// elsewhere correct naming
		// CB String t = "Untitled" + Integer.toString(myDocCount++);
		// CB doc.setName(t);
		createFrame(doc);
		doc.setModified(false);
		doc.discardAllEdits();
		return doc; // CB added
	}

	/**
	 *
	 */
	String openSchematic() { // CB added return value.
		return openSchematic("");
	}

	/**
	 * 
	 * @param filename
	 *            a file recently opened and selected in the File menu
	 */
	String openSchematic(String filename) { // CB added return value.
		if (DEBUG) {
			System.out.println("Opening : " + filename);
		}
		String defaultLoc = null;
		SchematicView view = getCurrentView();
		SchematicDocument doc = null;
		// CB added "last files opened" submenu
		if ((filename != null) && (filename.trim().length() > 0)) {
			doc = SchematicDocument.open(this, filename);
			if (doc == null) {
				JOptionPane.showMessageDialog(this, "Document, " + filename
						+ " does not exist", "File Not Found",
						JOptionPane.ERROR_MESSAGE);
				// removeSchematicFileOpenAction(filename);
				updateFileMenu(filename, false);
				// HandleBadFileRecentlyOpenedMenuItem(filename,
				// SCHEMATIC_TYPE);
			}
		}
		if (doc == null) { // if generic open (file chooser is to come up)
			if (view != null) {
				doc = view.getDoc();
				defaultLoc = doc.getLocation();
			}
			if ((defaultLoc == null) || (defaultLoc.equals(""))) {
				// CB defaultLoc = "c:/ztp/schematic_dss/svg/";
				// System.out.println(_userPrefs.get(PREFS_FILE_TYPE_STRINGS[0]
				// + "1", "")); // CB debugging
				if (DEBUG) {
					System.out.println("Default location is null or empty: "
							+ defaultLoc);
					System.out.println("User Prefs Recent Schematics"
							+ _userPrefs.get(PREFS_FILE_TYPE_STRINGS[0] + "1",
									"").trim());
				}
				if (!_userPrefs.get(PREFS_FILE_TYPE_STRINGS[0] + "1", "")
						.trim().equals("")) { // CB added if
					defaultLoc = _userPrefs.get(
							PREFS_FILE_TYPE_STRINGS[0] + "1", "").substring(
							0,
							_userPrefs
									.get(PREFS_FILE_TYPE_STRINGS[0] + "1", "")
									.lastIndexOf("\\"))
							+ "/";
				} else {
					// CB - grab it from a jar in the classpath OR a directory
					// in system path
					defaultLoc = "wrims/schematic/svg/"; // A DIRECTORY!!!!!!!!!
					// CORRECT TODO
					// allow user to set
					// using preferences
				}
			}
			if (DEBUG) {
				System.out.println("Opening document with defaultLoc: "
						+ defaultLoc);
			}
			// System.out.println("defaultLoc:"+defaultLoc);
			doc = SchematicDocument.open(this, defaultLoc);
			// if (doc == null) //CB added. It catches directory or filename
			// change or movement BUT comes up double if user cancels out of
			// file chooser previously
			// doc = SchematicDocument.open(this, "");
		}

		// TODO need (here?)? if (doc == null) //CB added. It catches directory
		// or file name chance or movement BUT comes up double if user cancels
		// out of file chooser previously
		// doc = SchematicDocument.open(this, "");

		if (doc != null) {
			// CB deleted the unneeded instance variable which stored the last
			// location and set it in open(Component, String)
			// CB doc.setLocation(defaultLoc);
			createFrame(doc); // *************************************************
			// This line adds 50 GB to memory
		}

		if (doc != null) {
			// System.out.println("view width = " +
			// getCurrentView().getWidth());
			// System.out.println("view height = " +
			// getCurrentView().getHeight());
			if (IS_DEVELOPER) {
				System.out
						.println("doc width = " + doc.getDocumentSize().width);
				System.out.println("doc height = "
						+ doc.getDocumentSize().height);
			}
			/*
			 * JInternalFrame frame = getCurrentView().getInternalFrame(); if
			 * (frame != null) { try { frame.setMaximum(true); } catch
			 * (Exception x) { } }
			 */
			// CB replacement block (ONLY GOOD IF
			// SchematicDocument.openDoc(this, loc, filename); CREATES THE
			// FRAME!!!
			if (myDesktop.getAllFrames().length > 0) {
				JInternalFrame frame = myDesktop.getSelectedFrame();
				try {
					frame.setMaximum(true);
				} catch (Exception x) {
				}
			}
		} else {
			return null;
		}
		return filename; // CB added TODO is here the best place for this line?
	}

	String openProject() {
		return openProject(null);
	}

	String openProject(String filename) { // CB added
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		if (_DssFrame == null) {
			_DssFrame = new DssFrame(this, false);
			addDocumentListener();

			_DssFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent event) {
					// CB need to remove listeners?
					_DssFrame.dispose();
					SwingUtilities.invokeLater(new Runnable() {
						public void run() { // Cb TODO move the run() method
							// contents outside the listener as
							// it is called from > 1 locations
							_DssFrame.mainPanel.stopMonthlyDataWork();
							_DssFrame = null;
							_dateBox.setModel(new DefaultComboBoxModel());
							_dateBox.validate();
							_dateBox.repaint();
							SchematicRelatedAction.updateAllActions();
						}
					});
				}
			});
		}

		if ((filename == null) || (filename.trim().length() == 0)) {
			filename = _DssFrame.mainPanel.getActions().openViewerFile(); // CB
			// altered
		} else {
			// CB added
			String result = _DssFrame.mainPanel.getActions().openViewerFile(
					filename);
			if (result == null) {
				// removeProjectFileOpenAction(filename);
				updateDSSMenu(filename, false);
				return result;
			}
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (!_DssFrame.isVisible()) {
					_DssFrame.setVisible(true);
				}
				SchematicRelatedAction.updateAllActions();
			}
		});
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		return filename;
	}

	/**
	 * CB added.
	 * 
	 * @param isEnabled
	 */
	public void updateDateBoxTWs(final boolean isEnabled,
			final boolean isLongTermType) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for (int i = 0; i < ((DefaultComboBoxModel) _dateBox.getModel())
						.getSize(); ++i) {
					if (((DefaultComboBoxModel) _dateBox.getModel())
							.getElementAt(i) instanceof ComboItem) {
						String period = ((ComboItem) ((DefaultComboBoxModel) _dateBox
								.getModel()).getElementAt(i)).toString();
						if ((isLongTermType && (period.indexOf("-") > -1))
								|| (!isLongTermType && (period.indexOf("-") == -1))) {
							((ComboItem) ((DefaultComboBoxModel) _dateBox
									.getModel()).getElementAt(i))
									.setEnabled(isEnabled);
						}
					}
				}
			}
		});
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	public JComboBox getDateBox() {
		return _dateBox;
	}

	/**
	 * CB added.
	 */
	public void disableMonthItems() {
		ComboBoxModel model = _dateBox.getModel();
		if (model instanceof DefaultComboBoxModel) {
			for (int i = 0; i < ((DefaultComboBoxModel) model).getSize(); ++i) {
				Object element = ((DefaultComboBoxModel) model).getElementAt(i);
				if (element instanceof ComboItem) {
					if (((ComboItem) element).toString().indexOf("-") == -1) {
						((ComboItem) element).setEnabled(false);
					}
				}
			}
		}
	}

	/**
	 * CB added.
	 */
	public void disableLongtermItems() {
		ComboBoxModel model = _dateBox.getModel();
		if (model instanceof DefaultComboBoxModel) {
			for (int i = 0; i < ((DefaultComboBoxModel) model).getSize(); ++i) {
				Object element = ((DefaultComboBoxModel) model).getElementAt(i);
				if (element instanceof ComboItem) {
					if (((ComboItem) element).toString().indexOf("-") > -1) {
						((ComboItem) element).setEnabled(false);
					}
				}
			}
		}
	}

	private String propertiesDirectory; // CB added

	/**
	 * CB added.
	 */
	String openPropertiesLocation() {
		_currentOpenPropertyLocation = openPropertiesLocation(null);
		return _currentOpenPropertyLocation;
	}

	String getPropertiesLocation() {
		return _currentOpenPropertyLocation;
	}

	/**
	 * CB added.
	 * 
	 * @param directory
	 */
	String openPropertiesLocation(String directory) { // CB added
		JFileChooser chooser = null; // = new JFileChooser();
		if ((directory == null) || (directory.trim().length() == 0)) {
			chooser = new JFileChooser();
			chooser.setCurrentDirectory(null);
		} else {
			chooser = new JFileChooser(); // TO DO: don't need this is File
			// exists
			// already!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			File currentFile = new File(directory);
			chooser.setCurrentDirectory(currentFile);
		}
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// chooser.setAcceptAllFileFilterUsed(false);
		Filter inputFilter = new Filter("",
				"Lowest-level directory must be a level above the \"run\" directory");
		chooser.addChoosableFileFilter(inputFilter);
		chooser.setFileFilter(inputFilter);
		int returnVal = chooser.showOpenDialog(mainFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String loc = chooser.getSelectedFile().getAbsolutePath();
			if ((loc != null) && !loc.trim().equals("")) {
				// System.out.println(chooser.getSelectedFile().getAbsolutePath());
				File[] children = chooser.getSelectedFile().listFiles(); // looking
				// for
				// one
				// level
				// above
				// "run"
				// directory
				boolean isOK = false;
				for (int i = 0; i < children.length; ++i) {
					if (children[i].getName().equalsIgnoreCase("run")) {
						isOK = true;
						break;
					}
				}
				if (isOK) {
					// if (loc.toLowerCase().lastIndexOf("run") == loc.length()
					// - 3) // looking for "run" directory
					return loc;
				} else {
					return null;
				}
			}
		}
		return null;
	}

	void importXY() {
		String defaultLoc = null;
		SchematicView view = getCurrentView();
		if (view != null) {
			SchematicDocument doc = view.getDoc();
			defaultLoc = doc.getLocation();
		}
		SchematicDocument doc = SchematicDocument.importXY(this, defaultLoc);
		SchematicRelatedAction.updateAllActions();
		if (doc != null) {
			createFrame(doc);
		}
	}

	void closeSchematic() {
		/*
		 * CB if (getCurrentView() != null) { JInternalFrame frame =
		 * getCurrentView().getInternalFrame(); if (frame != null) { try {
		 * frame.setClosed(true); } catch (Exception x) { } } }
		 */
		// CB replacement block
		if (myDesktop.getAllFrames().length > 0) {
			JInternalFrame[] frames = myDesktop.getAllFrames();
			for (int i = frames.length - 1; i >= 0; --i) {
				try {
					frames[i].setClosed(true);
				} catch (Exception x) {
				}
			}
		}
	}

	void saveSchematic() {
		if (getCurrentView() != null) {
			SchematicDocument doc = getCurrentView().getDoc();
			doc.save();
		}
	}

	void saveAsSchematic() {
		if (getCurrentView() != null) {
			SchematicDocument doc = getCurrentView().getDoc();
			doc.saveAs(".svg");

		}
	}

	// make the overview window visible
	void overviewAction() {
		if (myOverview == null) {
			myOverview = new JGoOverview();
			myOverview.setObserved(getCurrentView());
			myOverviewDialog = new JDialog(mainFrame,
					"Quick Navigation Window", false);
			myOverviewDialog.getContentPane().setLayout(new BorderLayout());

			// CB added following block
			JTabbedPane jtp = new JTabbedPane();
			// CB moved jtp.add("Summary", myOverview);

			// InputStream is =
			// getClass().getResourceAsStream("images/water_alt12.jpg");
			InputStream is = getClass().getResourceAsStream(
					"images/calsim_map.gif");
			if (is != null) {
				try {
					BufferedImage image = ImageIO.read(is);
					// cleanImage(image);
					MapOverviewPanel mapOverviewPanel = new MapOverviewPanel(
							new SchematicDocument(), this, image);
					MapOverviewRelatedAction.updateAllActions();
					jtp.add("Quick Locator", mapOverviewPanel);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

			}
			jtp.add("Summary", myOverview); // CB moved it to here
			// CB myOverviewDialog.getContentPane().add(myOverview,
			myOverviewDialog.getContentPane().add(jtp, // CB added
					BorderLayout.CENTER);
		}
		myOverviewDialog.setPreferredSize(new Dimension(750, 900));
		myOverviewDialog.pack();
		myOverviewDialog.setVisible(true);
	}

	/**
	 * CB added to clean up a image file and write it back to file. DID NOT WORK
	 * ENOUGH - NOT USED
	 */
	void cleanImage(BufferedImage image) {
		// File file = new File(filename);
		// BufferedImage image = null;
		// try {
		// image = ImageIO.read(file);
		// } catch (IOException ioe) {
		// ioe.printStackTrace();
		// }
		// Get all the pixels
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		int[] rgbs = new int[w * h];
		int[] rgbArray = image.getRGB(0, 0, w, h, rgbs, 0, w);
		for (int i = 0; i < rgbArray.length; i++) {
			Color pixelColor = new Color(rgbArray[i]);
			int r = pixelColor.getRed();
			int g = pixelColor.getGreen();
			int b = pixelColor.getBlue();
			int rgb = 0;
			if (i < w) {
				// Set a pixel
				rgb = new Color(0, 0, 0).getRGB();
			} else {
				if ((b > 1.5 * r) || (b > 1.5 * g)) { // CB 1.7 is arbitrary
					rgb = new Color(0, 0, 128).getRGB();
				} else if (r + g + b > 400) {
					rgb = new Color(255, 255, 255).getRGB();
				} else if (r + g + b < 380) {
					rgb = new Color(0, 0, 0).getRGB();
				}
			}
			int x = i % w;
			int y = i / w;
			image.setRGB(x, y, rgb);
		}
		String writeFormats[] = ImageIO.getWriterMIMETypes();
		// System.out.println();
	}

	/**
	 * CB added.
	 * 
	 * @param image
	 * @param file
	 */
	boolean saveImage(BufferedImage image, File file) {
		boolean successful = false;
		try {
			successful = ImageIO.write(image, "gif", file);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return successful;
	}

	// Plot the selected variables from schematic
	void showOutput(String type) { // CB I fixed this method
		// System.out.println("entered showoutput"); //CB debugging
		if (getCurrentView() != null) {
			JGoSelection selection = getCurrentView().getSelection();
			if (selection != null) {
				// Vector<String> variables =
				// getPlotter().parseSelection(selection);
				_DssFrame.getFP().retrieve(DssViewer.getOutputType(type));
			}
		}
	}

	/**
	 * CB added.
	 */
	public void resetValueNodeNames() {
		if ((getCurrentView() != null) && (getCurrentView().getDoc() != null)) {
			getCurrentView().getDoc().resetValueNodeNames();
		}
	}

	/**
	 * CB added to allow notification that the value box lables need to be
	 * refreshed for the current date.
	 */
	public void updateValues() {
		if ((_dateBox != null)
				&& _dateBox.isEnabled()
				&& (_dateBox.getSelectedItem() != null)
				&& !(((ComboItem) _dateBox.getSelectedItem()).toString().trim()
						.equals(""))) {
			updateValues(((ComboItem) _dateBox.getSelectedItem()).toString());
		}
	}

	/**
	 * CB added to update values in value boxes when a date is selected. Not in
	 * dispatch thread because values are read-only and this method should be
	 * accessed by more than one object (thread) simultaneously.
	 */
	public void updateValues(String date) {
		Hashtable<String, String>[] values = null; // two Hashtables, one each
		// for each alternative; one
		// value per alternative
		// node
		if (_DssFrame != null) {
			if (_DssFrame.getFP().getValueViewer() == null) {
				values = _DssFrame.getFP().retrieve(
						DssViewer.getOutputType(DssViewer.VALUES_STRING), date,
						getAllVariables());
			} else {
				values = _DssFrame.getFP().retrieve(
						DssViewer.getOutputType(DssViewer.VALUES_STRING), date,
						null);
			}

			HashMap<Integer, Object> dssFileMap = _DssFrame.mainPanel
					.getMessagePanel().getDSSFileNames("BOTH");

			if (values != null) {
				Enumeration<String> variables = getCurrentView().getDoc()
						.getAllVariables().keys();
				Hashtable<String, ValueNode>[] valueNodes = getCurrentView()
						.getDoc().getNameToValueNodeHashtables();
				int valueIndex = 0;
				int[] valueNodesToValuesMap = new int[valueNodes.length];
				for (int i = 0; i < valueNodes.length; ++i) {
					valueNodesToValuesMap[i] = -1;
					for (int j = i; j < values.length; ++j) {
						// System.out.println(dssFileMap.get(j));
						if ((values[j] instanceof Hashtable)
								&& (dssFileMap.get(j) != null)) {
							if (((Hashtable) values[j]).size() > 0) {
								valueNodesToValuesMap[i] = j;
								break;
							}
						}
					}
				}
				while (variables.hasMoreElements()) {
					String varName = variables.nextElement();
					for (int i = 0; i < valueNodes.length; ++i) { // TODO use 2
						// here?????????????????????????????????????????????????????????????????????????????????
						// for (int i = 0; i < values.length; ++i) { //Only
						// works if
						// just Base files and when DSSViewer is closed the text
						// resets to "Alt. 1 (or 2) value"
						/*
						 * if (values.length < 2) {
						 * valueNodes[i].get(varName).setText("Alt " + i +
						 * " value"); continue; }
						 */

						if (valueNodes[i].get(varName) == null) {
							// TODO - message to user??
						} else {
							if (valueNodesToValuesMap[i] == -1) {
								valueNodes[i].get(varName).setText(
										ALT_STRINGS[i] + " value");
								break;
							}
							// valueNodes[i].get(varName).setText(String.valueOf(values[i].get(varName)));
							NumberFormat formatter = new DecimalFormat("0");
							// System.out.println(values[i].get(varName));
							if (values[valueNodesToValuesMap[i]].get(varName) != null) {
								// valueNodes[i].get(varName).setText(String.valueOf(formatter.format(values[i].get(varName))));
								String[] split = values[valueNodesToValuesMap[i]]
										.get(varName).split(" +");
								try { // CB
									// debugging!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
									// TODO figure it out
									valueNodes[i]
											.get(varName)
											.setText(
													String
															.valueOf(formatter
																	.format(Double
																			.parseDouble(split[0])))
															+ " "
															+ split[1]
																	.toLowerCase());
								} catch (NullPointerException npe) {
									if (varName == null) {
										System.out.println("varName is null");
									}
									if (split[0] == null) {
										System.out.println("split[0] is null");
									}
									if (split[1] == null) {
										System.out.println("split[1] is null");
									}
									if (valueNodes[i] == null) {
										System.out
												.println("valueNodes[i] is null");
									}
									if (valueNodes[i].get(varName) == null) {
										System.out
												.println("valueNodes[i].get(varName) is null");
									}
								}
							} else if ((valueNodes[i] != null)
									&& (varName != null)
									&& (valueNodes[i].get(varName) != null)) {
								valueNodes[i].get(varName)
										.setText("Not in DSS");
							}
						}
					}
				}
			} else {
				System.out
						.println("No values yet for method updateValues(String date)");
				JOptionPane.showMessageDialog(null, "No values yet for date = "
						+ date, "Date Does Not Exist",
						JOptionPane.ERROR_MESSAGE);
			}
			// System.out.print("");
		} else {

		}
	}

	// make a JGoNode out of the current selection
	void groupAction() {
		getCurrentView().getDoc().startTransaction();
		JGoSelection selection = getCurrentView().getSelection();
		JGoObject primary = selection.getPrimarySelection();
		JGoArea area = new JGoNode();
		// now add the area to the document
		primary.getLayer().addObjectAtTail(area);
		// add the selected objects to the area
		ArrayList arr = area.addCollection(selection, false, getCurrentView()
				.getDoc().getFirstLayer());
		// update the selection too, for the user's convenience
		selection.selectObject(area);
		// make each object not Selectable
		for (int i = 0; i < arr.size(); i++) {
			JGoObject obj = (JGoObject) arr.get(i);
			obj.setSelectable(false);
		}
		getCurrentView().getDoc().endTransaction(GroupAction.toString());
	}

	// this action only works on the primary selection, which should
	// be a JGoSubGraph
	void ungroupAction() {
		JGoSelection selection = getCurrentView().getSelection();
		JGoObject primary = selection.getPrimarySelection();
		if (primary == null) {
			return;
		}
		if (!(primary instanceof JGoArea)) {
			return;
		}
		JGoLayer layer = primary.getLayer();
		if (layer == null) {
			return;
		}
		getCurrentView().getDoc().startTransaction();
		JGoArea area = (JGoArea) primary;
		ArrayList arr = null;

		// special cases for subgraphs--don't promote Handle or Label
		// or other special subgraph children as stand-alone objects
		if (area instanceof JGoSubGraph) {
			SchemGraph sg = (SchemGraph) area;
			// JGoSubGraph sg = (JGoSubGraph)area;
			// expand before ungrouping
			sg.expandAll();
			ArrayList children = new ArrayList();
			JGoListPosition pos = sg.getFirstObjectPos();
			while (pos != null) {
				JGoObject obj = sg.getObjectAtPos(pos);
				pos = sg.getNextObjectPosAtTop(pos);
				// check for special subgraph children
				if ((obj != sg.getHandle()) && (obj != sg.getLabel())
						&& !(obj instanceof JGoPort)
						&& (obj != sg.getCollapsedObject())) {
					children.add(obj);
				}
			}
			arr = layer.addCollection(children, true, getCurrentView().getDoc()
					.getFirstLayer());
		} else {
			arr = layer.addCollection(area, false, getCurrentView().getDoc()
					.getFirstLayer());
		}

		for (int i = 0; i < arr.size(); i++) {
			JGoObject obj = (JGoObject) arr.get(i);
			// update the selectability and visibility, just in case
			obj.setSelectable(true);
			obj.setVisible(true);
			// update the selection too, for the user's convenience
			selection.extendSelection(obj);
		}

		// delete the area
		layer.removeObject(area);
		getCurrentView().getDoc().endTransaction(UngroupAction.toString());
	}

	/**
	 * CB added to get all variable without giving up the view or the doc to the
	 * DSS package.
	 * 
	 * @return
	 */
	public Hashtable<String, Object> getAllVariables() {
		if ((getCurrentView() == null) || (getCurrentView().getDoc() == null)) {
			return null;
		}
		return getCurrentView().getDoc().getAllVariables();
	}

	SchematicView getCurrentView() {
		// CB return myCurrentView;
		// CB replaced view has a frame with frame has a view logic
		if (myDesktop.getAllFrames().length > 0) {
			if (myDesktop.getAllFrames()[0] instanceof WrimsSchematicInternalFrame) {
				return ((WrimsSchematicInternalFrame) myDesktop.getAllFrames()[0])
						.getView();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	Plotter getPlotter() {
		return plotter;
	}

	JDesktopPane getDesktop() {
		return myDesktop;
	}

	JGoPalette getPalette() {
		// CB return myPalette;
		if (myPaletteTabbedPane.getSelectedIndex() > -1) {
			return (JGoPalette) myPaletteTabbedPane
					.getComponentAt(myPaletteTabbedPane.getSelectedIndex());
		} else {
			return null;
		}
	}

	/**
	 * CB added.
	 * 
	 * @param index
	 * @return
	 */
	JGoPalette getPalette(int index) {
		if (index >= myPaletteTabbedPane.getTabCount()) {
			return null;
		} else {
			return (JGoPalette) myPaletteTabbedPane.getComponentAt(index);
		}
	}

	// get an image from the given filename
	private static Image getImage(String filename) {

		// to read from file
		ImageIcon icon = new ImageIcon(filename);

		// try to read from URL
		if ((icon == null)
				|| (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
			try {
				URL url = new URL(filename);
				icon = new ImageIcon(url);
			} catch (Exception e) { /* not a url */
			}
		}

		// in case file is inside a .jar
		if ((icon == null)
				|| (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
			URL url = Schematic.class.getResource(filename);
			if (url == null) {
				throw new RuntimeException("image " + filename + " not found");
			}
			icon = new ImageIcon(url);
		}

		return icon.getImage();
	}

	/**
	 * CB added.
	 * 
	 * @return
	 */
	public int getSelectedUnits() {
		if (_TAFButton.isSelected()) {
			return TAF;
		} else if (_CFSButton.isSelected()) {
			return CFS;
		} else {
			return -1;
		}
	}

	/**
	 * CB added.
	 * 
	 * @param units
	 */
	public void setUnitsButtons(int units) {
		getSelectedDate();
		if (units == TAF) {
			if (!_TAFButton.isSelected()) {
				_TAFButton.setSelected(true);
				toolBar2.repaint();
				// updateValues(getSelectedDate());
				updateValues();
			}
		} else {
			if (!_CFSButton.isSelected()) {
				_CFSButton.setSelected(true);
				toolBar2.repaint();
				// updateValues(getSelectedDate());
				updateValues();
			}
		}
	}

	/**
	 *
	 *
	 */
	private void readPreferences() { // CB added
		readWindowPreferences();
	}

	/**
	 *
	 */
	private void readWindowPreferences() { // CB added
		// Read window preferences to set window location and size
		int x = _userPrefs
				.getInt("SchematicFrameX", (Toolkit.getDefaultToolkit()
						.getScreenSize().width - DEFAULT_WIDTH) / 2);
		int y = _userPrefs
				.getInt("SchematicFrameY", (Toolkit.getDefaultToolkit()
						.getScreenSize().height - DEFAULT_HEIGHT) / 2);
		setLocation(x, y);
		int width = _userPrefs.getInt("SchematicFrameWidth", DEFAULT_WIDTH);
		int height = _userPrefs.getInt("SchematicFrameHeight", DEFAULT_HEIGHT);
		setSize(width, height);
		// Read preferences to set all SplitPane locations
		// _mainSplit.setDividerLocation(_userPrefs.getInt("MainSplitX",
		// MAINSPLIT_DEFAULT_X));
	}

	/**
	 *
	 */
	private void writeWindowPreferences() { // CB added
		// Write window location and size to preferences
		_userPrefs.put("SchematicFrameX", String.valueOf(getX()));
		_userPrefs.put("SchematicFrameY", String.valueOf(getY()));
		_userPrefs.put("SchematicFrameWidth", String.valueOf(getWidth()));
		_userPrefs.put("SchematicFrameHeight", String.valueOf(getHeight()));

		// Write all SplitPane locations to preferences
		// _userPrefs.putInt("MainSplitX", _mainSplit.getDividerLocation());
	}

	private String readRecentlyOpenedFilename(int number, int type) { // CB
		// added
		return _userPrefs.get(PREFS_FILE_TYPE_STRINGS[type] + number, "");
	}

	/**
	 * CB added. Remove a recently opened file from the preferences. This is to
	 * fix a broken preference (one for which the file does not exist in the
	 * specified location).
	 * 
	 * @param number
	 * @param type
	 * @return
	 */
	private void removeRecentlyOpenedFilenamePreference(String filename,
			int type) { // CB added
		String key = null;
		for (int i = 1; i <= 5; i++) {
			if ((_userPrefs.get(key = PREFS_FILE_TYPE_STRINGS[type] + i, ""))
					.equals(filename)) {
				_userPrefs.remove(key);
				break;
			}
		}
	}

	private boolean isFileRecent(String fileToBeOpened, int type) { // CB added
		if ((type < 0) || (type > 1)) {
			return false;
		}
		for (int i = 1; i <= NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			// System.out.println(PREFS_FILE_TYPE_STRINGS[type] + i + " ="
			// + _userPrefs.get(PREFS_FILE_TYPE_STRINGS[type] + i, "")); //
			// debugging
			if (fileToBeOpened.equalsIgnoreCase(_userPrefs.get(
					PREFS_FILE_TYPE_STRINGS[type] + i, ""))) {
				return false;
			}
		}
		return true;
	}

	public boolean isFileOpen(String fileToBeOpened, int type) { // CB added
		if (type == SCHEMATIC_TYPE) {
			return isSchematicFileOpen(fileToBeOpened);
		} else if (type == PROJECT_TYPE) {
			return isProjectFileOpen(fileToBeOpened);
		} else {
			return false; // CB probably should do a JOptionPane for better
			// messaging!
		}
	}

	/**
	 * Determines if a file of type .svg is currently open.
	 * 
	 * @param fileToBeOpened
	 * @return
	 */
	public boolean isSchematicFileOpen(String fileToBeOpened) { // CB added
		for (int i = 0; i < getDesktop().getComponentCount(); ++i) {
			if (getDesktop().getAllFrames()[i].getName().equalsIgnoreCase(
					fileToBeOpened)) {
				return true;
			}
		}
		return false;
	}

	public boolean isProjectFileOpen(String fileToBeOpened) { // CB added
		if ((_DssFrame == null)
				|| (_DssFrame.mainPanel == null)
				|| (_DssFrame.mainPanel.getMessagePanel() == null)
				|| (_DssFrame.mainPanel.getMessagePanel().getProjectName() == null)) {
			return false;
		}
		if (_DssFrame.mainPanel.getMessagePanel().getProjectName()
				.equalsIgnoreCase(fileToBeOpened)) {
			return true;
		}
		return false;
	}

	public boolean isPropertiesDirectoryOpen(String fileToBeOpened) { // CB
		// added
		return fileToBeOpened.equals(_currentOpenPropertyLocation);
	}

	/**
	 * Checks is the last file opened was already in the preferences. If it was
	 * not, the stored recent file preferences are shifted down one (i.e., the
	 * get for recent file i is put as the preference for recent file i + 1, and
	 * the new file is stored for recent file 1. If the last file opened was
	 * already in the preferences,
	 * 
	 * @param lastFileOpened
	 */
	/*
	 * private void updateRecentFilesOpenedPreferences(String lastFileOpened) {
	 * // CB // added updateRecentFilesOpenedPreferences(lastFileOpened,
	 * SCHEMATIC_TYPE); updateRecentFilesOpenedPreferences(lastFileOpened,
	 * PROJECT_TYPE); updateRecentFilesOpenedPreferences(lastFileOpened,
	 * PROPERTIES_TYPE); }
	 */

	/**
	 * Checks is the last file opened was already in the preferences. If it was
	 * not, the stored recent file preferences are shifted down one (i.e., the
	 * get for recent file i is put as the preference for recent file i + 1, and
	 * the new file is stored for recent file 1. If the last file opened was
	 * already in the preferences,
	 * 
	 * @param lastFileOpened
	 */
	private void updateRecentFilesOpenedPreferences(String lastFileOpened,
			int type) { // CB added
		int index = -1;
		// System.out.println("lastFileOpened = " + lastFileOpened); //
		// debugging
		if ((lastFileOpened != null) && !lastFileOpened.trim().equals("")) {
			for (int i = 1; i <= NUMBER_OF_RECENT_FILES_OPENED; ++i) {
				// System.out.println("RecentFile" + i + " = " +
				// _userPrefs.get("RecentFile" + i, "")); //debugging
				if (lastFileOpened.equalsIgnoreCase(_userPrefs.get(
						PREFS_FILE_TYPE_STRINGS[type] + i, ""))) {
					index = i;
					break;
				}
			}
			int intFrom;
			if (index == -1) {
				intFrom = NUMBER_OF_RECENT_FILES_OPENED;
			} else {
				intFrom = index;
			}
			for (int i = intFrom; i >= 2; --i) {
				_userPrefs.put(PREFS_FILE_TYPE_STRINGS[type] + i, _userPrefs
						.get(PREFS_FILE_TYPE_STRINGS[type] + (i - 1), ""));
			}
			_userPrefs.put(PREFS_FILE_TYPE_STRINGS[type] + 1, lastFileOpened);
			// System.out.println(PREFS_FILE_TYPE_STRINGS[type] + 1 + " +
			// _userPrefs.get(PREFS_FILE_TYPE_STRINGS[type] + 1, ""));
			// //debugging
		}
		// reorderPreferences(type);
	}

	private void reorderPreferences(int type) {
		for (int i = 1; i <= 5; ++i) { // CB TODO replace hard 5 with a Java
			// constant
			String value = _userPrefs
					.get(PREFS_FILE_TYPE_STRINGS[type] + i, "");
			// System.out.println("schematic open prefs value " + i + " = " +
			// value);
			if ((value == null) || value.trim().equals("")) {
				if (i < 5) {
					for (int j = i; j < 5; ++j) {
						_userPrefs.put(PREFS_FILE_TYPE_STRINGS[type] + j,
								_userPrefs.get(PREFS_FILE_TYPE_STRINGS[type]
										+ (j + 1), ""));
					}
				}
				_userPrefs.put(PREFS_FILE_TYPE_STRINGS[type] + 5, "");
				break;
			}
		}
		// debugging
		for (int i = 1; i <= 5; ++i) {
			String value = _userPrefs
					.get(PREFS_FILE_TYPE_STRINGS[type] + i, "");
			// System.out.println("schematic open prefs value " + i + " = " +
			// value);
		}
	}

	/**
	 * CB added. TODO combine all three methods of this kind in one using the
	 * type as an arg??????
	 * 
	 * @param filename
	 * @param wasAdded
	 *            true if the filename was added, false if the filename
	 */
	private void updateFileMenu(String filename, boolean wasAdded) { // CB added
		if (filename != null) {
			if (wasAdded) {
				updateRecentFilesOpenedPreferences(filename, SCHEMATIC_TYPE);
			} else {
				removeRecentlyOpenedFilenamePreference(filename, SCHEMATIC_TYPE);
				reorderPreferences(SCHEMATIC_TYPE);
			}
			createRecentFilesOpenActions(SCHEMATIC_TYPE);
			setRecentFileOpenActions(SCHEMATIC_TYPE);
			mainMenuBar.revalidate();
			mainMenuBar.repaint();
		}
	}

	/**
	 * CB added. TODO combine all three methods of this kind in one using the
	 * type as an arg??????
	 * 
	 * @param filename
	 * @param wasAdded
	 */
	public void updateDSSMenu(String filename, boolean wasAdded) { // CB added -
		// made
		// public
		// because
		// is a DSS
		// function
		// (accessed
		// from that
		// package)
		if (filename != null) {
			if (wasAdded) {
				updateRecentFilesOpenedPreferences(filename, PROJECT_TYPE);
			} else {
				removeRecentlyOpenedFilenamePreference(filename, PROJECT_TYPE);
				reorderPreferences(PROJECT_TYPE);
			}
			createRecentFilesOpenActions(PROJECT_TYPE);
			setRecentFileOpenActions(PROJECT_TYPE);
			mainMenuBar.revalidate();
			mainMenuBar.repaint();
		}
	}

	/**
	 * CB added. TODO combine all three methods of this kind in one using the
	 * type as an arg??????
	 * 
	 * @param filename
	 */
	private void updatePropertiesMenu(String filename, boolean wasAdded) { // TODO
		// test
		// this
		// method
		// after
		// properties
		// added
		if ((filename != null) && !filename.trim().equals("")) {
			if (wasAdded) {
				_currentOpenPropertyLocation = filename;
				updateRecentFilesOpenedPreferences(filename, PROPERTIES_TYPE);
			} else {
				removeRecentlyOpenedFilenamePreference(filename,
						PROPERTIES_TYPE);
				reorderPreferences(PROPERTIES_TYPE);
			}
			createRecentFilesOpenActions(PROPERTIES_TYPE);
			setRecentFileOpenActions(PROPERTIES_TYPE);
			mainMenuBar.revalidate();
			mainMenuBar.repaint();
		}
	}

	/**
	 * CB - added for development phase only.
	 * 
	 */
	private void clearRecentFilePreferences() {
		clearRecentFilePreferences(SCHEMATIC_TYPE);
		clearRecentFilePreferences(PROJECT_TYPE);
	}

	/**
	 * CB - added for development phase only.
	 * 
	 */
	private void clearRecentFilePreferences(int type) {
		for (int i = 1; i <= NUMBER_OF_RECENT_FILES_OPENED; ++i) {
			_userPrefs.put(PREFS_FILE_TYPE_STRINGS[type] + i, "");
		}
	}

	/**
	 *
	 *
	 */
	private void writePreferences() { // CB added
		writeWindowPreferences();
	}

	/**
	 * CB added.
	 * 
	 * @param isVisible
	 */
	public void setProgressVisibility(boolean isVisible) {
		// System.out.println("Setting progress visibility to " + isVisible);
		_monthlyProgressLabel.setVisible(isVisible);
		_monthlyProgressBar.setVisible(isVisible);
		_longtermProgressLabel.setVisible(isVisible);
		_longtermProgressBar.setVisible(isVisible);
	}

	/**
	 * CB added.
	 */
	public void resetProgressBars() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				_monthlyProgressBar.setValue(0);
				_longtermProgressBar.setValue(0);
			}
		});
	}

	/**
	 * CB added.
	 * 
	 * @param value
	 */
	public void setMonthlyProgress(final int value) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				_monthlyProgressBar.setValue(value);
			}
		});
	}

	/**
	 * CB added.
	 * 
	 * @param value
	 */
	public void setLongtermProgress(final int value) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				_longtermProgressBar.setValue(value);
			}
		});
	}
	
	  /**
	   * open study
	   */
	 void openStudy(){
	    String styFile = VistaUtils.getFilenameFromDialog(this,FileDialog.LOAD,
							      "sty","Study files (*.sty)");
	    if ( styFile == null ) return;
	    // open and load project
	    sty = new Study();
	    try {
	      sty.load(styFile);
	      //DJE********************************************************
	      if (!sty.isUpdatedStudyObject()) {
	        String msg = styFile + " was created with a previous version of CALSIM.";
	        JOptionPane.showMessageDialog(this, msg, "Warning", JOptionPane.WARNING_MESSAGE);
	      }
	      inputPane.setStudy(sty);
	      //*************************************************************
	    }catch(IOException ioe){
	      VistaUtils.displayException(this,ioe);
	    }
	  }
	  /**
	   * save study
	   */
	 void saveStudy(){
	    inputPane.updateStudy(sty);
	    String styFile = sty.getFileName();
	    if ( styFile.equals("") ){
	      styFile = VistaUtils.getFilenameFromDialog(this,FileDialog.SAVE,
							 "sty","Study files (*.sty)");
	      if ( styFile == null ) return;
	    }
	    try{
	      if ( styFile.indexOf(".") == -1 )  styFile += ".sty";
	      sty.save(styFile);
	    }catch(IOException ioe){
	      VistaUtils.displayException(this,ioe);
	    }
	  }
	  /**
	   * save study
	   */
	  void saveAsStudy(){
		inputPane.updateStudy(sty);
	    String styFile = VistaUtils.getFilenameFromDialog(this,FileDialog.SAVE,
							      "sty","Study files (*.sty)");
	    if ( styFile == null ) return;
	    try{
	      if ( styFile.indexOf((int)'.') == -1 )  //no extension
		styFile += ".sty";  //set default extension
	      sty.save(styFile);
	    }catch(IOException ioe){
	      VistaUtils.displayException(this,ioe);
	    }
	  }

	public static boolean IS_DEVELOPER = false; // CB added to switch to
	// user-only mode after
	// done programming
	public static String DEFAULT_OPEN_DIR = null;

	public static final int NUMBER_OF_RECENT_FILES_OPENED = 5; // CB added

	public static final int SCHEMATIC_TYPE = 0; // CB added

	public static final int PROJECT_TYPE = 1; // CB added

	public static final int PROPERTIES_TYPE = 2; // CB added

	public static final String[] PREFS_FILE_TYPE_STRINGS = { "RecentSchematic",
			"RecentProject", "RecentProperties" }; // CB added

	public static final int DEFAULT_WIDTH = 800; // CB added

	public static final int DEFAULT_HEIGHT = 600; // CB added

	public static final int CALSIM_II_STYLE = 0; // CB added

	public static final int CALSIM_III_STYLE = 1; // CB added

	static final int[] STYLE = { CALSIM_II_STYLE, CALSIM_III_STYLE }; // CB
	// added

	static final String[] STYLE_NAME = { "CAD", "Flow" }; // CB added

	public static final Color ARC_GREEN = Color.decode("#007000"); // CB added

	public static final Color NODE_GREEN = Color.decode("#73BB73"); // CB added

	public static final Color YUCK = Color.decode("#BBBBFF"); // CB added

	public static final Color ALMOST_YELLOW = Color.decode("#EEEE00"); // CB
	// added

	public static final Color MUSTARD = Color.decode("#DDDD00"); // CB added

	// public static final Color BURNT_ORANGE = Color.decode("#C87800"); //CB
	// added - equiv to (200, 120, 0) fairly dark yellow-brown

	// public static final Color BURNT_ORANGE = Color.decode("#D88800"); //CB
	// added - equiv to (216, 136, 0) medium yellow-brown

	public static final Color BURNT_ORANGE = Color.decode("#E89800"); // CB
	// added
	// -
	// equiv
	// to
	// (232,
	// 152,
	// 0)

	public static final Color BROWN = Color.decode("#777700"); // CB added

	public static final Color VIOLET = Color.decode("#9900EE"); // CB added
	// Color.decode("#EE00EE")
	// is
	// Color.MAGENTA

	/*
	 * public static final String NONE = "None"; //CB added
	 * 
	 * public static final String SOLID = "Solid"; //CB added
	 * 
	 * public static final String DASHED = "Dashed"; //CB added
	 * 
	 * public static final String DOTTED = "Dotted"; //CB added
	 * 
	 * public static final String DASHDOT = "DashDot"; //CB added
	 * 
	 * public static final String DASHDOTDOT = "DashDotDot"; //CB added
	 */

	public static final String[] ALT_STRINGS = { "Alt. 1", "Alt. 2" };

	public final static int TAF = 0;

	public final static int CFS = 1;

	static private boolean imagesErrorDisplayed = false;

	static private Frame theApp = null;

	// State

	static boolean _isStandalone;

	static String _mainDir;

	static JFrame mainFrame;

	protected JTabbedPane tabbedPane;
	
	protected InputPanel inputPane;
	
	protected JPanel outputPane;
	
	protected HashMap myMap = new HashMap();

	// CB protected SchematicView myCurrentView; CHANGED INTERNALFRAME TO HAVE A
	// SchematicView instance variable

	protected JDesktopPane myDesktop;

	// CB protected JGoPalette myPalette;

	// protected JGoPalette[] myPalette; //CB for multiple palette groups (e.g.,
	// CalSim II, CalSim III styles)

	protected JTabbedPane myPaletteTabbedPane;

	protected JMenuBar mainMenuBar;

	protected JToolBar toolBar1; // CB renamed

	private JToolBar toolBar2; // CB added

	JRadioButton _TAFButton = new JRadioButton(); // CB added

	JRadioButton _CFSButton = new JRadioButton(); // CB added

	protected JMenu filemenu;

	// private JMenu recentFilesSubmenu;

	private JMenuItem[] recentSchematicFilesOpenMenuItems = new JMenuItem[NUMBER_OF_RECENT_FILES_OPENED]; // CB
	// added

	private JMenuItem[] recentProjectFilesOpenMenuItems = new JMenuItem[NUMBER_OF_RECENT_FILES_OPENED]; // CB
	// added

	private JMenuItem[] recentPropertyDirectoryOpenMenuItems = new JMenuItem[NUMBER_OF_RECENT_FILES_OPENED]; // CB
	// added

	private String _currentOpenPropertyLocation; // CB added

	protected JMenu editmenu;

	protected JMenu viewmenu;

	protected JMenu dssmenu;

	protected JMenu propertyMenu; // CB added

	protected JMenu insertmenu;

	protected JMenu layoutmenu;

	protected JMenu helpmenu;

	protected JDialog myOverviewDialog;

	protected JGoOverview myOverview;

	private int myDocCount = 1;

	protected Plotter plotter;

	private int _messageLevel = 0; // CB added: 0 is "none" (CB not true), 3
	// adds ZWRITE, 4 is default, 5 adds ZREAD,
	// 10 is high bebug level, 15 is max debug
	// level

	DssFrame _DssFrame = null;

	JComboBox _dateBox; // CB added

	JButton _forward1PeriodButton, _back1PeriodButton, _forward1BlockButton,
			_back1BlockButton; // CB added

	JCheckBox _showValueBoxesCheckbox; // CB added

	private JLabel _monthlyProgressLabel = new JLabel("  Monthly Data:");

	private JLabel _longtermProgressLabel = new JLabel("   Long-term Avg:");

	private JProgressBar _monthlyProgressBar = new JProgressBar(); // CB added

	private JProgressBar _longtermProgressBar = new JProgressBar(); // CB added

	private static Preferences _userPrefs = Preferences // CB added
			.userNodeForPackage(Schematic.class);
	
	private Study sty;
}
