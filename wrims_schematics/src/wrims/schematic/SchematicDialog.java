package wrims.schematic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import com.nwoods.jgo.*;

public class SchematicDialog extends JDialog {
  JPanel panel1 = new JPanel();
  JButton OKButton = new JButton();
  JButton CancelButton = new JButton();
  JLabel label1 = new JLabel();
  JTextField nameField = new JTextField();
  JLabel label2 = new JLabel();
  JTextField locField = new JTextField();
  JCheckBox readonly = new JCheckBox();

  public SchematicDocument myObject;

  public SchematicDialog(Frame frame, SchematicDocument obj) {
    super(frame, "Schematic Properties", true);
    try  {
      myObject = obj;
      init();
      pack();
      updateDialog();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public SchematicDialog() {
    super((Frame)null, "Schematic Properties", true);
  }

  private final void init() {
    panel1.setLayout(null);
    panel1.setMinimumSize(new Dimension(294, 241));
    panel1.setPreferredSize(new Dimension(294, 241));
    OKButton.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        OnOK();
      }
    });
    CancelButton.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        OnCancel();
      }
    });
    getContentPane().add(panel1);

    OKButton.setText("OK");
    panel1.add(OKButton);
    OKButton.setFont(new Font("Dialog", Font.PLAIN, 12));
    OKButton.setBounds(new Rectangle(60,204,79,22));
    OKButton.getRootPane().setDefaultButton(OKButton);
    CancelButton.setText("Cancel");
    panel1.add(CancelButton);
    CancelButton.setFont(new Font("Dialog", Font.PLAIN, 12));
    CancelButton.setBounds(new Rectangle(168,204,79,22));

    label1.setText("Schematic Name:");
    label1.setHorizontalAlignment(JLabel.LEFT);
    panel1.add(label1);
    label1.setBounds(new Rectangle(50,10,148,24));
    panel1.add(nameField);
    nameField.setBounds(new Rectangle(50,40,200,24));
    nameField.setEnabled(myObject.isModifiable());
    nameField.setEditable(Schematic.IS_DEVELOPER);  //CB added
    label2.setText("Path:");
    label2.setHorizontalAlignment(JLabel.LEFT);
    panel1.add(label2);
    label2.setBounds(new Rectangle(50,70,148,24));
    panel1.add(locField);
    locField.setBounds(new Rectangle(50,100,200,24));
    locField.setEnabled(myObject.isModifiable());
    locField.setEditable(Schematic.IS_DEVELOPER);  //CB added
    readonly.setText("Read Only");
    readonly.setBounds(new Rectangle(50, 150, 100, 14));
    panel1.add(readonly);
  }

  void updateDialog() {
    if (myObject == null) return;

    nameField.setText(myObject.getName());
    locField.setText(myObject.getLocation());
    readonly.setSelected(!myObject.isModifiable());
  }

  void updateData() {
    if (myObject == null) return;

    myObject.setName(nameField.getText());
    myObject.setLocation(locField.getText());
    myObject.setModifiable(!readonly.isSelected());
  }

  public void addNotify() {
    // Record the size of the window prior to calling parents addNotify.
    Dimension d = getSize();

    super.addNotify();

    if (fComponentsAdjusted)
      return;

    // Adjust components according to the insets
    Insets insets = getInsets();
    setSize(insets.left + insets.right + d.width, insets.top + insets.bottom + d.height);
    Component components[] = getComponents();
    for (int i = 0; i < components.length; i++)
    {
      Point p = components[i].getLocation();
      p.translate(insets.left, insets.top);
      components[i].setLocation(p);
    }
    fComponentsAdjusted = true;
  }

  // Used for addNotify check.
  boolean fComponentsAdjusted = false;

  void OnOK() {
    try {
      updateData();
      this.dispose();             // Free system resources
    } catch (Exception e) {
    }
  }

  void OnCancel() {
    try {
      this.dispose();             // Free system resources
    } catch (Exception e) {
    }
  }
}
