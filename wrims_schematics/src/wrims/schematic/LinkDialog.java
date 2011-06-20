package wrims.schematic;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import com.nwoods.jgo.JGoObject;
//import com.nwoods.jgo.JGoArea;

public class LinkDialog extends JDialog {
  JTextField nameField = new JTextField();

  JPanel panel1 = new JPanel();
  javax.swing.JButton OKButton = new javax.swing.JButton();
  javax.swing.JButton CancelButton = new javax.swing.JButton();
  javax.swing.JTextField heightField = new javax.swing.JTextField();
  javax.swing.JLabel label2 = new javax.swing.JLabel();


  JPanel typePanel = new JPanel();
  ButtonGroup typeGroup = new ButtonGroup();
  JRadioButton riverButton = new JRadioButton(); //CB added
  JRadioButton diversionButton = new JRadioButton();
  JRadioButton gwPumpingButton = new JRadioButton();
  JRadioButton gsInteractionButton = new JRadioButton();
  JRadioButton ggInteractionButton = new JRadioButton();
  JRadioButton gwRechargeButton = new JRadioButton();
  JRadioButton inflowButton = new JRadioButton();
  JRadioButton returnFlowButton = new JRadioButton();
  JRadioButton channelButton = new JRadioButton();
  JRadioButton futureArcButton = new JRadioButton(); //Cb added
  JLabel label13 = new JLabel();

  JLabel classNameLabel = new JLabel();

  //public JGoObject myObject;
  public Link myObject;

  public LinkDialog(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try  {
      jbInit2();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public LinkDialog(Frame frame, Link obj)
  {
    super(frame, "Link Properties", true);
    try  {
      myObject = obj;
      jbInit2();
      pack();
      updateDialog();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public LinkDialog() {
    this(null, "", false);
  }

  void jbInit2() throws Exception {
    panel1.setLayout(null);
    panel1.setMinimumSize(new Dimension(254, 215));
    panel1.setPreferredSize(new Dimension(254, 215));
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

    OKButton.setText("OK");
    panel1.add(OKButton);
    OKButton.setFont(new Font("Dialog", Font.PLAIN, 12));
    OKButton.setBounds(new Rectangle(30,178,79,22));

    CancelButton.setText("Cancel");
    panel1.add(CancelButton);
    CancelButton.setFont(new Font("Dialog", Font.PLAIN, 12));
    CancelButton.setBounds(new Rectangle(138,178,79,22));

    classNameLabel.setText("Network Link");
    panel1.add(classNameLabel);
    classNameLabel.setBounds(new Rectangle(23,5,264,24));

    /*
    label2.setText("Name:");
    label2.setHorizontalAlignment(JLabel.RIGHT);
    panel1.add(label2);
    label2.setBounds(new Rectangle(24,36,48,24));
    panel1.add(nameField);
    nameField.setBounds(new Rectangle(84,36,80,24));
    */

    // type panel
    typePanel.setBorder(BorderFactory.createRaisedBevelBorder());
    typePanel.setLayout(null);
    typePanel.setBackground(java.awt.Color.lightGray);
    typePanel.setBounds(new Rectangle(10,36,234,110));
    typePanel.add(label13);

    label13.setText("Link Type");
    label13.setFont(new Font("Dialog", Font.ITALIC, 12));
    label13.setBounds(new Rectangle(12, 2, 130, 23));

    typePanel.add(riverButton); //CB added section
    riverButton.setBounds(new Rectangle(12,36,180,14));
    riverButton.setText("River");
    riverButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(riverButton);

    typePanel.add(diversionButton);
    diversionButton.setBounds(new Rectangle(12,52,220,14));
    diversionButton.setText("Diversion");
    diversionButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(diversionButton);

    /*
    typePanel.add(gwPumpingButton);
    gwPumpingButton.setBounds(new Rectangle(12,68,220,14));
    gwPumpingButton.setText("Groundwater Pumping");
    gwPumpingButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(gwPumpingButton);

    typePanel.add(gsInteractionButton);
    gsInteractionButton.setBounds(new Rectangle(12,84,220,14));
    gsInteractionButton.setText("Groundwater-Stream Interaction ");
    gsInteractionButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(gsInteractionButton);

    typePanel.add(ggInteractionButton);
    ggInteractionButton.setBounds(new Rectangle(12,100,220,14));
    ggInteractionButton.setText("Groundwater-Groundwater Interaction");
    ggInteractionButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(ggInteractionButton);

    typePanel.add(gwRechargeButton);
    gwRechargeButton.setBounds(new Rectangle(12,116,220,14));
    gwRechargeButton.setText("Groundwater Basin Recharge");
    gwRechargeButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(gwRechargeButton);
    */

    typePanel.add(inflowButton);
    inflowButton.setBounds(new Rectangle(12,68,220,14));
    inflowButton.setText("Inflow");
    inflowButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(inflowButton);

    typePanel.add(returnFlowButton);
    returnFlowButton.setBounds(new Rectangle(12,84,220,14));
    returnFlowButton.setText("Return Flow");
    returnFlowButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(returnFlowButton);

    typePanel.add(channelButton);
    channelButton.setBounds(new Rectangle(12,36,180,14));
    channelButton.setText("Channel");
    channelButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(channelButton);
    //CB added section
    typePanel.add(futureArcButton);
    futureArcButton.setBounds(new Rectangle(12,36,180,14));
    futureArcButton.setText("Channel");
    futureArcButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(futureArcButton);

    panel1.add(typePanel);
  }


  void updateDialog() {
    if (myObject == null) return;

        switch(myObject.getType()) {
            case Link.RIVER:
                riverButton.setSelected(true);
                break;
            case Link.INFLOW:
                inflowButton.setSelected(true);
                break;
            case Link.DIVERSION:
                diversionButton.setSelected(true);
                break;
            case Link.GWRECHARGE:
                gwRechargeButton.setSelected(true);
                break;
            case Link.GWPUMPING:
                gwPumpingButton.setSelected(true);
                break;
            case Link.GWGW:
                ggInteractionButton.setSelected(true);
                break;
            case Link.GWSW:
                gsInteractionButton.setSelected(true);
                break;
            case Link.RETURN:
                returnFlowButton.setSelected(true);
                break;
            case Link.CHANNEL:
                channelButton.setSelected(true);
                break;
            case Link.FUTURE:
                futureArcButton.setSelected(true);
                break;
        }

  }

  void UpdateControl() {
    if (myObject == null) return;

    int type;
    if (riverButton.isSelected())
      type = Link.RIVER;
    else if (diversionButton.isSelected())
      type = Link.DIVERSION;
    else if (gwPumpingButton.isSelected())
      type = Link.GWPUMPING;
    else if (gsInteractionButton.isSelected())
      type = Link.GWSW;
    else if (ggInteractionButton.isSelected())
      type = Link.GWGW;
    else if (gwRechargeButton.isSelected())
      type = Link.GWRECHARGE;
    else if (inflowButton.isSelected())
      type = Link.INFLOW;
    else if (returnFlowButton.isSelected())
      type = Link.RETURN;
    else if (channelButton.isSelected())
        type = Link.CHANNEL;
    else if (futureArcButton.isSelected())
        type = Link.FUTURE;
    else
      type = 0;

    //System.out.println( "UpdateControl.ARCTYPE: "+type);
    myObject.setType(type);

  }


  void OKButton_actionPerformed(ActionEvent e) {
      try {
        UpdateControl();
        this.dispose();             // Free system resources
      } catch (Exception ex) {
    }
  }

  void CancelButton_actionPerformed(ActionEvent e)
  {
    try {
      this.dispose();             // Free system resources
    } catch (Exception ex) {
    }
  }

}

