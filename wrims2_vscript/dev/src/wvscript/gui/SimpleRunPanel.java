package wvscript.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;


public class SimpleRunPanel {

	private JPanel panel_Simple = new JPanel();
	private JTextField textField_studyName;
	private JTable table_configFile;

	public SimpleRunPanel() {

	}

	public void init() {

		panel_Simple.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("left:default"), ColumnSpec.decode("max(20dlu;min)"),
				FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;default):grow"), ColumnSpec.decode("max(15dlu;min)"),}, new RowSpec[]{
				RowSpec.decode("max(10dlu;min)"), FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblNewLabel = new JLabel("Study name:");
		panel_Simple.add(lblNewLabel, "4, 2, left, center");

		JLabel lblNewLabel_1 = new JLabel("Config file content:");
		panel_Simple.add(lblNewLabel_1, "6, 2");

		textField_studyName = new JTextField();
		panel_Simple.add(textField_studyName, "4, 4, fill, default");
		textField_studyName.setColumns(10);

		table_configFile = new JTable();
		table_configFile.setRowHeight(20);
		table_configFile.setIntercellSpacing(new Dimension(3, 3));
		table_configFile.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_Simple.add(table_configFile, "6, 4, 5, 17");
		table_configFile.setFont(new Font("Dialog", Font.PLAIN, 14));
		table_configFile.setColumnSelectionAllowed(true);
		table_configFile.setModel(new DefaultTableModel(new Object[][]{{"keyword1", "value1"}, {null, null}, {null, null}, {null, null},
				{null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
				{null, null},}, new String[]{"Keyword", "Value"}) {
			Class[] columnTypes = new Class[]{String.class, String.class};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_configFile.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_configFile.getColumnModel().getColumn(0).setMinWidth(50);
		table_configFile.getColumnModel().getColumn(0).setMaxWidth(150);
		table_configFile.getColumnModel().getColumn(1).setPreferredWidth(190);
		table_configFile.getColumnModel().getColumn(1).setMinWidth(50);
		table_configFile.getColumnModel().getColumn(1).setMaxWidth(900);

		JButton btn_importConfig = new JButton("Import config...");
		btn_importConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {

				FChooser chooser = new FChooser();
				chooser.setMultiSelectionEnabled(true);
				int option = chooser.showOpenDialog(null);
				if (option == FChooser.APPROVE_OPTION) {
					File[] sf = chooser.getSelectedFiles();
					String filelist = "nothing";
					// if (sf.length > 0) filelist = sf[0].getName();
					// for (int i = 1; i < sf.length; i++) {
					// filelist += ", " + sf[i].getName();
					// }
					// statusbar.setText("You chose " + filelist);
					// }
					// else {
					// statusbar.setText("You canceled.");
					// }

				}
			}
		});
		btn_importConfig.setToolTipText("Optional.");
		panel_Simple.add(btn_importConfig, "4, 8, fill, default");

		JButton btn_runDir = new JButton("Run dir...");
		panel_Simple.add(btn_runDir, "4, 12, fill, default");

		JButton btn_initDss = new JButton("Init dss...");
		panel_Simple.add(btn_initDss, "4, 14, fill, default");

		JButton btn_svarDss = new JButton("Svar dss...");
		panel_Simple.add(btn_svarDss, "4, 16, fill, default");

		JButton btn_dvarDss = new JButton("Dvar dss...");
		panel_Simple.add(btn_dvarDss, "4, 18, fill, default");

		JComboBox comboBox_timeStep = new JComboBox();
		comboBox_timeStep.setModel(new DefaultComboBoxModel(new String[]{"Time step:  1MON", "Time step:  1DAY"}));
		panel_Simple.add(comboBox_timeStep, "4, 20, left, default");

		JButton btn_run = new JButton("Run");
		btn_run.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_Simple.add(btn_run, "4, 26, 3, 1, fill, fill");

	}

}
