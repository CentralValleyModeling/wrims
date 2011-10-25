package wrims.schematic.jdiagram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

@SuppressWarnings("serial")
public class SchematicEditorFrame extends JFrame{

	private SchematicEditor editor;
	private String currentFilenameOpen;

	public SchematicEditorFrame(){
	editor = new SchematicEditor();
	
	loadSchematic("resources/wrims/schematic/CS3_NetworkSchematic.xml");


	Icon saveAsIcon = ImageUtil.createImageIcon("images/save_as.png");
	Icon saveIcon = ImageUtil.createImageIcon("images/save.png");
	Icon openIcon = ImageUtil.createImageIcon("images/open.png");
	
	Action fileSaveAsAction = new AbstractAction("Save As", saveAsIcon) {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String filename = chooseFileToSave();
			try {
				editor.save(filename);
				currentFilenameOpen=filename;
				SchematicEditorFrame.this.setTitle(currentFilenameOpen);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	Action fileOpenAction = new AbstractAction("Open", openIcon) {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String filename = chooseFileToOpen();
			loadSchematic(filename);
		}
	};
	
	Action fileSaveAction = new AbstractAction("Save", saveIcon) {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				editor.save(currentFilenameOpen);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	};
	
	JToolBar bar = new JToolBar();
	bar.add(fileOpenAction);
	bar.add(fileSaveAction);
	bar.add(fileSaveAsAction);
	bar.addSeparator();
	bar.add(editor.getUndoAction());
	bar.add(editor.getRedoAction());
	bar.addSeparator();
	bar.add(editor.getZoomInAction());
	bar.add(editor.getZoomOutAction());
	bar.add(editor.getZoomNormalAction());
	bar.add(editor.getZoomToFitAction());
	bar.addSeparator();
	bar.add(new JToggleButton(editor.getToggleAutoAlignAction()));
	bar.add(editor.getVerticalAlignAction());
	bar.add(editor.getHorizontalAlignAction());
	bar.add(new JCheckBox(editor.getToggleEvenlySpaceNodes()));
	//bar.add(new JToggleButton(editor.getToggleGridLinesAction()));
	bar.addSeparator();
	bar.add(editor.createFindPanel());

	JFrame fr = this;
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	mainPanel.add(BorderLayout.PAGE_START, bar);
	mainPanel.add(editor);
	
	
	JMenuBar mbar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	fileMenu.add(fileOpenAction);
	fileMenu.add(fileSaveAction);
	fileMenu.add(fileSaveAsAction);
	mbar.add(fileMenu);
	
	JMenu editMenu = new JMenu("Edit");
	editMenu.add(editor.getUndoAction());
	editMenu.add(editor.getRedoAction());
	mbar.add(editMenu);
	
	
	JMenu toolMenu = new JMenu("Tools");
	toolMenu.add(editor.getHorizontalAlignAction());
	toolMenu.add(editor.getVerticalAlignAction());
	toolMenu.add(new JCheckBoxMenuItem(editor.getToggleEvenlySpaceNodes()));
	mbar.add(toolMenu);
	
	fr.setJMenuBar(mbar);
	
	fr.getContentPane().add(mainPanel);
	fr.pack();
	fr.setSize(800, 600);
	fr.setVisible(true);
	}

	private void loadSchematic(String filename) {
		try {
			editor.load(filename);
			currentFilenameOpen = filename;
			setTitle(currentFilenameOpen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String chooseFileToSave() {
		Preferences p = Preferences.userNodeForPackage(SchematicEditorFrame.class);
		String currentDirectory = p.get("SCHEMATICS_DIRECTORY", System
				.getProperty("user.dir"));
		JFileChooser chooser = new JFileChooser(currentDirectory);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "schematics";
			}

			@Override
			public boolean accept(File f) {
				return f != null && f.isFile();

			}
		});
		int rval = chooser.showSaveDialog(this);
		if (rval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File selectedFile = chooser.getSelectedFile();
		p.put("SCHEMATICS_DIRECTORY", selectedFile.getParent());
		return selectedFile.getAbsolutePath();
	}

	private String chooseFileToOpen() {
		Preferences p = Preferences.userNodeForPackage(SchematicEditorFrame.class);
		String currentDirectory = p.get("SCHEMATICS_DIRECTORY", System
				.getProperty("user.dir"));
		JFileChooser chooser = new JFileChooser(currentDirectory);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "schematics";
			}

			@Override
			public boolean accept(File f) {
				return f != null
						&& f.isFile()
						&& (f.getName().toLowerCase().endsWith(".xml") || f
								.getName().toLowerCase().endsWith(".sch"));
			}
		});
		int rval = chooser.showOpenDialog(this);
		if (rval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File selectedFile = chooser.getSelectedFile();
		p.put("SCHEMATICS_DIRECTORY", selectedFile.getParent());
		return selectedFile.getAbsolutePath();
	}

	public static void main(String[] args) throws Exception{
		new SchematicEditorFrame();
	}
}
