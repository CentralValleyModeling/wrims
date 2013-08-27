package wvscript.gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

public class MainGUI {

	private File configDirToLock = new File("Z:\\temp");
	private File driveToLock = new File("Z:\\");
	private JFrame frmWvscript;
	private JPanel panel_Simple_run;
	private JTabbedPane panel_Simple_config_wrapper;
	private JTabbedPane tabbedPane_PA;
	private static final FileNameExtensionFilter filter_txt = new FileNameExtensionFilter("txt file", "txt");
	private static final FileNameExtensionFilter filter_dss = new FileNameExtensionFilter("dss file", "dss");
	private JPanel panel_Simple;
	private JTextField textField_1;
	private static final DateFormat df_yyyymmdd = new SimpleDateFormat("yyyy-mm-dd");
	private static final DateFormat df_yyyymm = new SimpleDateFormat("yyyy-mm");
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmWvscript.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {

		UIManager.put("FileChooser.readOnly", Boolean.TRUE);

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWvscript = new JFrame();
		frmWvscript.setTitle("WVscript 1.20");
		frmWvscript.setBounds(100, 100, 645, 637);
		frmWvscript.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane_Main = new JTabbedPane(JTabbedPane.TOP);
		frmWvscript.getContentPane().add(tabbedPane_Main, BorderLayout.CENTER);

		panel_Simple = new JPanel();
		tabbedPane_Main.addTab("Simple", null, panel_Simple, null);
		panel_Simple.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("center:default:grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		panel_Simple_run = new JPanel();
		panel_Simple.add(panel_Simple_run, "1, 1, fill, top");
		simpleRunPanel();

		panel_Simple_config_wrapper = new JTabbedPane();
		panel_Simple.add(panel_Simple_config_wrapper, "1, 2, fill, bottom");
		simpleConfigPanel();

		tabbedPane_PA = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Main.addTab("Position Analysis", tabbedPane_PA);
		positionAnalysisPanel();

	}

	public void simpleConfigPanel() {

		// panel_config_wrapper.addTab(lbl_basicConfig, null, panel_Simple,
		// null);

		JPanel panel_Simple_config_basic = new JPanel();
		//panel_Simple_config_basic.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Simple_config_wrapper.addTab("Basic Config", null, panel_Simple_config_basic, null);
		panel_Simple_config_basic.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(15dlu;min)"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
				JRadioButton rdbtn_wreslPlus = new JRadioButton(" Use WRESL+");
				rdbtn_wreslPlus.setHorizontalTextPosition(SwingConstants.RIGHT);
				panel_Simple_config_basic.add(rdbtn_wreslPlus, "2, 5, 5, 1");

		textField_1 = new JTextField();
		panel_Simple_config_basic.add(textField_1, "4, 9, 7, 1, fill, default");
		textField_1.setColumns(10);

		try {
			MaskFormatter dateMask = new MaskFormatter("####-##-##");

			String[] cbStrings = {"1MON", "1DAY"};

			ArrayList<String> tsList = new ArrayList<String>();
			tsList.add("1MON");
			tsList.add("1DAY");

			// spinner_1.setModel(new javax.swing.SpinnerListModel(tsList));

			SpinnerModel spm_month = new SpinnerNumberModel(10, 1, 12, 1);
			SpinnerModel spm_year = new SpinnerNumberModel(1921, 1901, 2099, 1);
			
					JButton btnNewButton = new JButton("SV File");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {

							FileSystemView fsv = new DirectoryRestrictedFileSystemView(driveToLock);
							// JFileChooser chooser = new JFileChooser();
							JFileChooser chooser = new JFileChooser(fsv);
							chooser.setCurrentDirectory(configDirToLock);
							chooser.setControlButtonsAreShown(false);
							chooser.setAcceptAllFileFilterUsed(false);

							chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
							chooser.setFileFilter(filter_dss);
							int option = chooser.showOpenDialog(frmWvscript);

							if (option == JFileChooser.APPROVE_OPTION) {

								File sf = chooser.getSelectedFile();
								System.out.println(sf.getName());
							}
						}
					});
					panel_Simple_config_basic.add(btnNewButton, "2, 9");

			textField_4 = new JTextField();
			panel_Simple_config_basic.add(textField_4, "4, 11, 7, 1, fill, default");
			textField_4.setColumns(10);
			
						JButton btnNewButton_1 = new JButton("Init File");
						panel_Simple_config_basic.add(btnNewButton_1, "2, 11");

			textField_5 = new JTextField();
			panel_Simple_config_basic.add(textField_5, "4, 13, 7, 1, fill, default");
			textField_5.setColumns(10);
																					
																								JButton btnNewButton_2 = new JButton("DV File");
																								panel_Simple_config_basic.add(btnNewButton_2, "2, 13");
																		
																					JLabel lblSvarDssA = new JLabel("SV File A Part:");
																					panel_Simple_config_basic.add(lblSvarDssA, "2, 15, right, default");
															
																		JLabel lblNewLabel_4 = new JLabel("SV File F Part:");
																		panel_Simple_config_basic.add(lblNewLabel_4, "2, 17, right, default");
												
															JLabel lblNewLabel_5 = new JLabel("Init File F Part:");
															panel_Simple_config_basic.add(lblNewLabel_5, "2, 19, right, default");
									
												JLabel lblNewLabel = new JLabel("Time step:");
												panel_Simple_config_basic.add(lblNewLabel, "2, 21, left, default");
									JComboBox comboBox = new JComboBox(cbStrings);
									panel_Simple_config_basic.add(comboBox, "4, 21, left, default");
						
									JLabel lblNewLabel_1 = new JLabel("Start date:");
									panel_Simple_config_basic.add(lblNewLabel_1, "2, 23, left, default");
			
						JLabel lblNewLabel_2 = new JLabel("Stop date:");
						panel_Simple_config_basic.add(lblNewLabel_2, "2, 25, left, default");

			JLabel lblNewLabel_6 = new JLabel("(YYYY-MM-DD)");
			panel_Simple_config_basic.add(lblNewLabel_6, "10, 25, left, default");
			
						JSpinner spinner_year = new JSpinner(spm_year);
						JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner_year, "#");
						spinner_year.setEditor(editor);
						
									panel_Simple_config_basic.add(spinner_year, "4, 25, left, default");
			JSpinner spinner_mont = new JSpinner(spm_month);
			panel_Simple_config_basic.add(spinner_mont, "6, 25");
			
						JSpinner spinner_2 = new JSpinner();
						panel_Simple_config_basic.add(spinner_2, "8, 25");

			JLabel lblNewLabel_3 = new JLabel("Number of Time Steps:");
			panel_Simple_config_basic.add(lblNewLabel_3, "2, 27, 3, 1, left, default");
			
						JSpinner spinner_3 = new JSpinner();
						panel_Simple_config_basic.add(spinner_3, "6, 27");
		} catch (ParseException ex) {
			Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void simpleRunPanel() {

		panel_Simple_run.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(100dlu;min):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(10dlu;min)"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("15dlu"),}));
												
														JButton btn_openConfig = new JButton("Open Config");
														
																btn_openConfig.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent ae) {
														
																		FileSystemView fsv = new DirectoryRestrictedFileSystemView(configDirToLock);
																		// JFileChooser chooser = new JFileChooser();
																		JFileChooser chooser = new JFileChooser(fsv);
																		chooser.setCurrentDirectory(configDirToLock);
																		chooser.setControlButtonsAreShown(false);
																		chooser.setAcceptAllFileFilterUsed(false);
																		chooser.setFileView(new FileView() {
														
																			@Override
																			public Boolean isTraversable(File f) {
																				// File dirToLock = new File("Z:\\");
																				// return dirToLock.equals(f);
																				return false;
																			}
																		});
																		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
																		// disableUpFolderButton(chooser);
																		// disableDesktopButton(chooser);
																		// chooser.setMultiSelectionEnabled(true);
																		chooser.setFileFilter(filter_txt);
																		int option = chooser.showOpenDialog(frmWvscript);
																		System.out.println("option:" + option + " JFileChooser.APPROVE_OPTION:" + JFileChooser.APPROVE_OPTION);
																		System.out.println(" file:" + chooser.getSelectedFile().getName());
														
																		if (option == JFileChooser.APPROVE_OPTION) {
														
																			File sf = chooser.getSelectedFile();
																			System.out.println(sf.getName());
																		}
																	}
																});
																
																JButton btnNewButton_5 = new JButton("Study Run Dir");
																panel_Simple_run.add(btnNewButton_5, "4, 2");
																
																textField = new JTextField();
																panel_Simple_run.add(textField, "6, 2, 7, 1, fill, default");
																textField.setColumns(10);
																btn_openConfig.setToolTipText("");
																panel_Simple_run.add(btn_openConfig, "4, 4, fill, default");
												
												textField_2 = new JTextField();
												panel_Simple_run.add(textField_2, "6, 4, fill, default");
												textField_2.setColumns(10);
																		
																		JButton btnNewButton_3 = new JButton("Save");
																		panel_Simple_run.add(btnNewButton_3, "8, 4");
																		
																		JButton btnNewButton_4 = new JButton("Save As");
																		panel_Simple_run.add(btnNewButton_4, "10, 4");
																		
																				JButton btn_run = new JButton("Run");
																				btn_run.setFont(new Font("Dialog", Font.BOLD, 16));
																				panel_Simple_run.add(btn_run, "4, 8, fill, fill");

	}

	public void positionAnalysisPanel() {
		JPanel panel_PA_1 = new JPanel();
		tabbedPane_PA.addTab("PA Step 1", null, panel_PA_1, null);
		JPanel panel_PA_2 = new JPanel();
		tabbedPane_PA.addTab("PA Step 2", null, panel_PA_2, null);
		JPanel panel_PA_3 = new JPanel();
		tabbedPane_PA.addTab("Run", null, panel_PA_3, null);
		GridBagLayout gbl_panel_PA_3 = new GridBagLayout();
		gbl_panel_PA_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_PA_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_PA_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_PA_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_PA_3.setLayout(gbl_panel_PA_3);

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel_PA_3.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 2;
		panel_PA_3.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

	}

	public static void disableUpFolderButton(Container c) {
		int len = c.getComponentCount();
		for (int i = 0; i < len; i++) {
			Component comp = c.getComponent(i);
			if (comp instanceof JButton) {
				JButton b = (JButton) comp;
				Icon icon = b.getIcon();
				if (icon != null && icon == UIManager.getIcon("FileChooser.upFolderIcon")) {
					b.setEnabled(false);
				}
			} else if (comp instanceof Container) {
				disableUpFolderButton((Container) comp);
			}
		}

	}

	public static void disableDesktopButton(Container c) {
		int len = c.getComponentCount();
		for (int i = 0; i < len; i++) {
			Component comp = c.getComponent(i);
			if (comp instanceof JButton) {
				JButton b = (JButton) comp;

				// if (b != null && b.getText() != null &&
				// b.getText().equals("Desktop")) {
				if (b != null && b.getToolTipText() != null && b.getToolTipText().equals("Desktop")) {
					b.setEnabled(false);
				}
			} else if (comp instanceof Container) {
				disableDesktopButton((Container) comp);
			}
		}

	}
	public JPanel getPanel_Simple() {
		return panel_Simple;
	}
}
