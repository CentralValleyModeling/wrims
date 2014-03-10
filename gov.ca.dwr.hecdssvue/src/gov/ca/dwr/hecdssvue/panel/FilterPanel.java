package gov.ca.dwr.hecdssvue.panel;

import gov.ca.dwr.hecdssvue.PluginCore;
import hec.dssgui.Group;
import hec.hecmath.DSS;
import hec.hecmath.DSSFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.ProgressMonitor;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class FilterPanel extends JPanel {

	public static boolean DEBUG = false;
	public final String DEFAULT_TIME_WINDOW = "31Oct1921 2400 30Sep2009 2400"; // CB
	// added
	String _timeWindow = DEFAULT_TIME_WINDOW;
	private JTextField[] _pathText;

	private JButton _filterBtn = null;
	private JRadioButton _plotBtn = null;
	private JRadioButton _exceedBtn = null;
	private JRadioButton _annualTotBtn = null;
	private JRadioButton _annualTotExceedBtn = null;
	private JRadioButton _monthlyAvgBtn = null; 
	JTable _table = null;

	private JList _monthlist;

	HashMap<Integer, Object> _fparts = new HashMap<Integer, Object>();

	// public FilterPanel(MainPanel mp) {
	public FilterPanel() {
		setLayout(new BorderLayout());
		add(createUpperPanel());
	}

	/**
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JCheckBox) {
			String name = ((JCheckBox) e.getSource()).getText();
			// TODO: figure out what I was planning or trying to do here
		}
	}

	String[] retrieveDateRangeFromTimeWindow() {
		// time window format: "31Oct1921 2400 30Sep2003 2400"
		String[] rangePair = new String[2];
		String[] split = _timeWindow.split(" +");
		rangePair[0] = split[0].substring(2);
		rangePair[1] = split[2].substring(2);
		return rangePair;
	}

	public void refreshFilter(int dssType) {
		for (int i = 0; i < 6; i++)
			_pathText[i].setText("");
	}

	public static int binarySearch(String[][] array, String key, int column) {
		return binarySearch(array, 0, array.length, key, column);
	}

	public static int binarySearch(String[][] array, int lowerbound,
			int upperbound, String key, int column) {
		int position;
		int compare_count = 1;

		// calculate initial search position.
		position = (lowerbound + upperbound) / 2;

		while (!(array[position][column].equalsIgnoreCase(key))
				&& (lowerbound < upperbound)) {
			compare_count++;
			// if the value in the search position is greater than the key
			// change upperbound to search position minus one.
			if (array[position][column].compareTo(key) > 0) { // CB
				// compareToIgnoreCase
				// does NOT work
				// here
				upperbound = position - 1; //
			} else { // change lowerbound to search position plus one.
				lowerbound = position + 1;
			}
			position = (lowerbound + upperbound) / 2;
		}
		if (lowerbound <= upperbound) {
			// System.out.println(key + " was found in array subscript " +
			// position);
		} else {
			// System.out.println(key + "  not found by binary search");
		}
		return position;
	}

	public ArrayList<Integer> getMonthList() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int indices[] = _monthlist.getSelectedIndices();
		int i2m[] = { 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int i = 0; i < indices.length; i++) {
			l.add(i2m[indices[i]]);
		}
		return l;
	}

	public void setTimeWindow(String tw) {
			_timeWindow = "31Oct1921 2400 30Sep2009 2400"; // defualt full time
	}

	private String getPathSpec(boolean useRegex) {
		String pathSpec = "";

		String glob = "*";
		if (useRegex)
			glob = ".*";

		for (int i = 0; i < 6; i++) {
			String txt = _pathText[i].getText().trim().toUpperCase();
			if (txt.length() > 0)
				pathSpec = pathSpec + "/" + txt;
			else
				pathSpec = pathSpec + "/" + glob;
		}
		pathSpec = pathSpec + "/";
		return pathSpec;
	}

	public JList createMonthList() {
		String months[] = { "Oct", "Nov", "Dec", "Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "Jul", "Aug", "Sep" };

		final JList list = new JList(months);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(1);
		list.setSelectionInterval(0, months.length - 1);
		list.setToolTipText("Select months to extract for plots/tables");
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				PluginCore.months=new ArrayList<Integer>();
				int[] sels=list.getSelectedIndices();
				for (int i=0; i<sels.length; i++){
					switch (sels[i]) {
		            	case 0:  
		            		PluginCore.months.add(10);
		            		break;
		            	case 1:  
		            		PluginCore.months.add(11);
		            		break;
		            	case 2:  
		            		PluginCore.months.add(12);
		            		break;
		            	case 3:  
		            		PluginCore.months.add(1);
		            		break;
		            	case 4:  
		            		PluginCore.months.add(2);
		            		break;
		            	case 5:  
		            		PluginCore.months.add(3);
		            		break;
		            	case 6:  
		            		PluginCore.months.add(4);
		            		break;
		            	case 7:  
		            		PluginCore.months.add(5);
		            		break;
		            	case 8:  
		            		PluginCore.months.add(6);
		            		break;
		            	case 9:  
		            		PluginCore.months.add(7);
		            		break;
		            	case 10:  
		            		PluginCore.months.add(8);
		            		break;
		            	case 11:  
		            		PluginCore.months.add(9);
		            		break;
		            	default:
		            		break;
					}
				}
			}
			
		});

		return list;

	}

	private void setTextFieldAction(JTextField textArea) {
		InputMap inputMap = textArea.getInputMap();
		ActionMap actionMap = textArea.getActionMap();

		Object transferTextActionKey = "TRANSFER_TEXT";
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				transferTextActionKey);
		// Also add shift+enter binding here if you want
		actionMap.put(transferTextActionKey, new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				filter();
			}
			
			public void filter(){
				
			}
		});
	}

	// //////////////////// GeneralRetrievePanel.java code
	// /////////////////////////////////////////
	public JPanel createUpperPanel() {
		int textwidth = 15;
		// create filter panel
		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new GridLayout(1, 7));

		_pathText = new JTextField[6];
		_pathText[0] = new JTextField(textwidth);
		setTextFieldAction(_pathText[0]);
		_pathText[0].setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.lightGray), "A"));
		_pathText[1] = new JTextField(textwidth);
		setTextFieldAction(_pathText[1]);
		_pathText[1].setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.lightGray), "B"));
		_pathText[2] = new JTextField(textwidth);
		setTextFieldAction(_pathText[2]);
		_pathText[2].setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.lightGray), "C"));
		_pathText[3] = new JTextField(textwidth);
		setTextFieldAction(_pathText[3]);
		_pathText[3].setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.lightGray), "D"));
		_pathText[4] = new JTextField(textwidth);
		setTextFieldAction(_pathText[4]);
		_pathText[4].setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.lightGray), "E"));
		_pathText[5] = new JTextField(textwidth);
		setTextFieldAction(_pathText[5]);
		_pathText[5].setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.lightGray), "F"));

		// filterPanel.add(_varTypeBox);
		for (int i = 0; i < 6; i++) {
			filterPanel.add(_pathText[i]);
		}
		filterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.blue), "Filter"));

		_filterBtn = new JButton("Filter");
		_plotBtn = new JRadioButton("Model Data");
		_plotBtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				PluginCore.chartType=0;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		_exceedBtn = new JRadioButton("Exceedance");
		_exceedBtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				PluginCore.chartType=1;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		_annualTotBtn = new JRadioButton("Annual Total");
		_annualTotBtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				PluginCore.chartType=2;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		_annualTotExceedBtn = new JRadioButton("Annual Exceedence");
		_annualTotExceedBtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				PluginCore.chartType=3;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		_monthlyAvgBtn = new JRadioButton("Monthly Average");
		_monthlyAvgBtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				PluginCore.chartType=4;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ButtonGroup group = new ButtonGroup();
	    group.add(_plotBtn);
	    group.add(_exceedBtn);
	    group.add(_annualTotBtn);
	    group.add(_annualTotExceedBtn);
	    group.add(_monthlyAvgBtn);
		_plotBtn.setSelected(true);
		PluginCore.chartType=0;

		// List of Months for plots/table
		_monthlist = createMonthList();

		Box btnPanel = new Box(BoxLayout.X_AXIS);
		btnPanel.add(Box.createHorizontalGlue());
		btnPanel.add(_filterBtn);
		btnPanel.add(_monthlist);
		// btnPanel.add(_retrieveBtn);
		btnPanel.add(new JLabel("  "));
		btnPanel.add(_plotBtn);
		btnPanel.add(_exceedBtn);
		btnPanel.add(_annualTotBtn);
		btnPanel.add(_annualTotExceedBtn);
		btnPanel.add(_monthlyAvgBtn); // CB added

		btnPanel.add(Box.createHorizontalGlue());
		//
		Box filterBox = new Box(BoxLayout.Y_AXIS);
		filterBox.add(Box.createVerticalGlue());
		filterBox.add(filterPanel);
		filterBox.add(Box.createVerticalGlue());
		//
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(Box.createVerticalGlue());
		box.add(filterBox);
		box.add(btnPanel);
		box.add(Box.createVerticalGlue());
		Box box1 = new Box(BoxLayout.X_AXIS);
		box1.add(Box.createHorizontalGlue());
		box1.add(box);
		box1.add(Box.createHorizontalGlue());
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BorderLayout());
		upperPanel.add(box1, BorderLayout.CENTER);
		return upperPanel;
	}
}
