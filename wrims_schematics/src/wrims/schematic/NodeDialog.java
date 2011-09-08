package wrims.schematic;

import com.nwoods.jgo.JGoBasicNode;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//import javax.swing.event.*;
//import javax.swing.colorchooser.AbstractColorChooserPanel;
//import javax.swing.text.*;

public class NodeDialog extends JDialog {
	// CB public NetworkNode myObject;
	private JGoBasicNode myObject; // CB
	JPanel panel1 = new JPanel();
	JLabel jLabel1 = new JLabel();
	// CB JTextField taskNameField = new JTextField();
	JTextField nameField = new JTextField(25); // CB changed it to text area
												// until demo comments indicated
												// shortening names/labels or
												// objects
	JLabel jLabel2 = new JLabel();
	// CB JTextField taskDurationField = new JTextField();
	JTextArea descriptionArea = new JTextArea(); // CB
	JButton OKButton = new JButton();
	JButton CancelButton = new JButton();

	// CB GridBagLayout gridBagLayout1 = new GridBagLayout();

	public NodeDialog(Frame frame, String title, boolean modal) {
		super(frame, title, modal);
		try {
			jbInit2();
			pack();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public NodeDialog() {
		this(null, "", false);
	}

	// CB public NodeDialog(Frame frame, NetworkNode obj) {
	public NodeDialog(Frame frame, JGoBasicNode obj) {
		super(frame, "Properties", true);
		try {
			myObject = obj;
			jbInit2();
			pack();
			updateDialog();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void jbInit1() throws Exception { // CB this method is screwed up - don't
										// use unless rewritten first
	// CB panel1.setLayout(gridBagLayout1);
		panel1.setLayout(new GridBagLayout()); // CB
		// panel1.setMinimumSize(new Dimension(150, 125)); NO EFFECT
		jLabel1.setText("Node Name:");
		nameField.grabFocus();

		if (!MainFrame.IS_DEVELOPER) nameField.setEditable(false);  //CB added the check

		jLabel2.setText("Description:"); // CB
		/*
		 * jLabel2.setText("Task Duration:"); taskDurationField is numeric, add
		 * KeyListener to enforce this taskDurationField.addKeyListener(new
		 * KeyAdapter() { public void keyTyped(KeyEvent e) { char c =
		 * e.getKeyChar(); if (!(Character.isDigit(c) || (c ==
		 * KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		 * getToolkit().beep(); e.consume(); } } });
		 */

		/*
		 * CB began allowing user to specify specific colors for objects, then
		 * put it on hold JDialog colorSelectionDialog = new JDialog(); //Set up
		 * color chooser for setting text color final JColorChooser chooser =
		 * new JColorChooser(); chooser.getSelectionModel().addChangeListener(
		 * new ChangeListener() { public void stateChanged(ChangeEvent e) {
		 * Color newColor = chooser.getColor(); } } );
		 * chooser.setBorder(BorderFactory.createTitledBorder("Choose Text
		 * Color")); //Remove the preview panel chooser.setPreviewPanel(new
		 * JPanel()); //Override the chooser panels with our own
		 * AbstractColorChooserPanel panels[] = { new CrayonPanel() };
		 * chooser.setChooserPanels(panels); chooser.setColor(Color.BLACK);
		 * colorSelectionDialog.add(chooser); JButton colorButton = new
		 * JButton(""); colorButton.setBackground(Color.BLACK);
		 */

		OKButton.setText("OK");
		OKButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OKButton_actionPerformed(e);
			}
		});
		CancelButton.setText("Cancel");
		CancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelButton_actionPerformed(e);
			}
		});
		getContentPane().add(panel1);
		panel1.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						30, 32, 0, 13), 0, 0));
		panel1.add(jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.5, 0.5,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						31, 32, 0, 0), 0, 0));
		// in progress panel1.add(colorSelectionDialog, new
		// GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
		// GridBagConstraints.NONE, new Insets(31, 32, 0, 0), 0, 0));

		panel1.add(nameField, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(30, 8, 0, 22), 118, 0));
		// panel1.add(taskDurationField, new GridBagConstraints(1, 1, 1, 1, 1.0,
		// 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new
		// Insets(29, 8, 0, 111), 29, 0));
		panel1.add(descriptionArea, new GridBagConstraints(1, 1, 1, 1,
				1.0,
				0.0, // CB
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(29, 8, 0, 111), 29, 0));
		panel1.add(OKButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						18, 50, 32, 11), 0, 0)); // CB changed ipadx to 100
													// (from 0)
		panel1.add(CancelButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						18, 7, 32, 72), 0, 0)); // CB changed ipadx to 100 (from
												// 0)
		OKButton.getRootPane().setDefaultButton(OKButton);
		nameField.grabFocus();
		setResizable(false); // CB added - does not work for
								// GridBagConstraints layout!!!
	}

	/**
	 * CB brought this from ArcDialog and altered as jbInit1() is screwed up.
	 *
	 * @throws Exception
	 */
	void jbInit2() throws Exception {
		panel1.setLayout(null);
		panel1.setMinimumSize(new Dimension(320, 215));
		panel1.setPreferredSize(new Dimension(320, 215));
		OKButton.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				OKButton_actionPerformed(e);
			}
		});
		CancelButton.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CancelButton_actionPerformed(e);
			}
		});
		this.setResizable(false);
		getContentPane().add(panel1);

		jLabel1.setText("Name");
		jLabel1.setHorizontalAlignment(JLabel.RIGHT);
		jLabel1.setBounds(12, 5, 70, 24);
		panel1.add(jLabel1);

		nameField.setBounds(95, 5, 200, 24);
		nameField.setFont(new Font(nameField.getFont().getFontName(), nameField
				.getFont().getStyle()
				+ Font.BOLD, nameField.getFont().getSize()));
		nameField.setMargin(new Insets(0, 3, 2, 0));
		if (!MainFrame.IS_DEVELOPER) nameField.setEditable(false);  //CB added the check
		panel1.add(nameField);

		jLabel2.setText("Description");
		jLabel2.setHorizontalAlignment(JLabel.RIGHT);
		jLabel2.setBounds(new Rectangle(11, 40, 70, 48));
		panel1.add(jLabel2);

		descriptionArea.setFont(nameField.getFont());
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setMargin(new Insets(0, 3, 2, 3));
		if (!MainFrame.IS_DEVELOPER) descriptionArea.setEditable(false);  //CB added the check
		JScrollPane pane = new JScrollPane(descriptionArea);
		pane.setBounds(95, 55, 200, 100);
		pane.setBorder(LineBorder.createGrayLineBorder());
		panel1.add(pane);

		OKButton.setText("OK");
		OKButton.setFont(new Font("Dialog", Font.PLAIN, 12));

		if (MainFrame.IS_DEVELOPER) {  //CB added the check
			OKButton.setBounds(new Rectangle(65, 178, 79, 22));
			panel1.add(OKButton);
			CancelButton.setText("Cancel");
			CancelButton.setFont(new Font("Dialog", Font.PLAIN, 12));
			CancelButton.setBounds(new Rectangle(190, 178, 79, 22));
			panel1.add(CancelButton);
		} else {  //CB added to center the lonesome OK button
			OKButton.setBounds(new Rectangle(120, 178, 79, 22));
			panel1.add(OKButton);
		}
	}

	void updateDialog() {
		if (myObject == null)
			return;
		nameField.setText(myObject.getLabel().getText());
		// taskDurationField.setText(Integer.toString(myObject.getTaskDuration()));
		if (myObject instanceof Describable) descriptionArea.setText(((Describable)myObject).getDescription());
	}

	void updateData() {
		if (myObject == null)
			return;

		myObject.getLabel().setText(nameField.getText());
		// myObject.setTaskDuration(Integer.parseInt(taskDurationField.getText()));
		if (myObject instanceof Describable)
			((Describable)myObject).setDescription(descriptionArea.getText()); // CB added

		//CB trying to force a circular ellipse: none of it works and it messes up variable boxes
		//CB actually it does change the bounding rectangle, but does NOT change the ellipse height!!!
/*		Rectangle R = myObject.getBoundingRect();  //CB debugging
		System.out.println("R width = " + R.width);
		System.out.println("R height = " + R.height);
		R.setBounds(R.x, R.y, R.width, R.width);
		System.out.println("R height = " + R.height);
		myObject.setAutoResize(false);
		myObject.setAutoRescale(false);
		myObject.setBoundingRect(R);
		myObject.setSize(R.width, R.width); */
	}

	void OKButton_actionPerformed(ActionEvent e) {
		try {
			updateData();
			dispose(); // Free system resources
		} catch (Exception ex) {
		}
	}

	void CancelButton_actionPerformed(ActionEvent e) {
		try {
			dispose(); // Free system resources
		} catch (Exception ex) {
		}
	}
}
