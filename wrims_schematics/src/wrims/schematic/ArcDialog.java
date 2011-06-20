package wrims.schematic;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import com.nwoods.jgo.JGoObject;
//import com.nwoods.jgo.JGoArea;

public class ArcDialog extends JDialog {
  JTextField nameField = new JTextField();

  JPanel panel1 = new JPanel();
  javax.swing.JButton OKButton = new javax.swing.JButton();
  javax.swing.JButton CancelButton = new javax.swing.JButton();
  javax.swing.JLabel label2 = new javax.swing.JLabel();


  JPanel typePanel = new JPanel();
  ButtonGroup typeGroup = new ButtonGroup();
  JRadioButton riverButton = new JRadioButton();  //CB added
  JRadioButton diversionButton = new JRadioButton();
  JRadioButton gwPumpingButton = new JRadioButton();
  JRadioButton gsInteractionButton = new JRadioButton();
  JRadioButton ggInteractionButton = new JRadioButton();
  JRadioButton gwRechargeButton = new JRadioButton();
  JRadioButton inflowButton = new JRadioButton();
  JRadioButton returnFlowButton = new JRadioButton();
  JRadioButton channelButton = new JRadioButton();
  JRadioButton futureArcButton = new JRadioButton();
  JRadioButton oldToNewLineButton = new JRadioButton();
  JRadioButton bypassArcButton = new JRadioButton();
  JLabel label13 = new JLabel();

  JLabel classNameLabel = new JLabel();

  //public JGoObject myObject;
  public Arc myObject;

  public ArcDialog(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try  {
      jbInit2();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public ArcDialog(Frame frame, Arc obj) {
    super(frame, "Arc Properties", true);
    try  {
      myObject = obj;
      jbInit2();
      pack();
      updateDialog();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public ArcDialog() {
    this(null, "", false);
  }

  void jbInit2() throws Exception {
    panel1.setLayout(null);
    panel1.setMinimumSize(new Dimension(254, 315));
    panel1.setPreferredSize(new Dimension(254, 315));
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
    OKButton.setBounds(new Rectangle(30,278,79,22));

    CancelButton.setText("Cancel");
    panel1.add(CancelButton);
    CancelButton.setFont(new Font("Dialog", Font.PLAIN, 12));
    CancelButton.setBounds(new Rectangle(138,278,79,22));

    classNameLabel.setText("Network Link");
    panel1.add(classNameLabel);
    classNameLabel.setBounds(new Rectangle(23,5,264,24));

    label2.setText("Name:");
    label2.setHorizontalAlignment(JLabel.RIGHT);
    panel1.add(label2);
    label2.setBounds(new Rectangle(24,36,48,24));
    panel1.add(nameField);
    nameField.setBounds(new Rectangle(84,36,80,24));
    if (!Schematic.IS_DEVELOPER)
    	nameField.setEditable(false);

    // type panel
    typePanel.setBorder(BorderFactory.createRaisedBevelBorder());
    typePanel.setLayout(null);
    typePanel.setBackground(java.awt.Color.lightGray);
    typePanel.setBounds(new Rectangle(10,82,234,180));
    typePanel.add(label13);

    label13.setText("Link Type");
    label13.setFont(new Font("Dialog", Font.ITALIC, 12));
    label13.setBounds(new Rectangle(12, 2, 130, 23));

    typePanel.add(riverButton);
    riverButton.setBounds(new Rectangle(12,36,180,14));
    riverButton.setText("River");
    riverButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(riverButton);

    typePanel.add(diversionButton);
    diversionButton.setBounds(new Rectangle(12,52,220,14));
    diversionButton.setText("Diversion");
    diversionButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(diversionButton);

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

    typePanel.add(inflowButton);
    inflowButton.setBounds(new Rectangle(12,132,220,14));
    inflowButton.setText("Inflow");
    inflowButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(inflowButton);

    typePanel.add(returnFlowButton);
    returnFlowButton.setBounds(new Rectangle(12,148,220,14));
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
    futureArcButton.setText("Future Arc");
    futureArcButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(futureArcButton);
    // CB added section
    typePanel.add(oldToNewLineButton);
	oldToNewLineButton.setBounds(new Rectangle(12,36,180,14));
	oldToNewLineButton.setText("Old name to new name line");
	oldToNewLineButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(oldToNewLineButton);
    // CB added section
    typePanel.add(bypassArcButton);
	bypassArcButton.setBounds(new Rectangle(12,36,180,14));  //CB check all these section including the bounds
	bypassArcButton.setText("Bypass Arc");
	bypassArcButton.setBackground(java.awt.Color.lightGray);
    typeGroup.add(bypassArcButton);

    panel1.add(typePanel);
  }


  void updateDialog() {  //CB WHY USE Link.TYPE here instead of Acr.TYPE??????????????????????????????????????????????????????????????????????????
    if (myObject == null) return;

        switch(myObject.getType()) { //CB changed all types from Link. ... to Arc. ...
            case Arc.RIVER:
                riverButton.setSelected(true);
                break;
            case Arc.INFLOW:
                inflowButton.setSelected(true);
                break;
            case Arc.DIVERSION:
                diversionButton.setSelected(true);
                break;
            case Arc.GWRECHARGE:
                gwRechargeButton.setSelected(true);
                break;
            case Arc.GWPUMPING:
                gwPumpingButton.setSelected(true);
                break;
            case Arc.GWGW:
                ggInteractionButton.setSelected(true);
                break;
            case Arc.GWSW:
                gsInteractionButton.setSelected(true);
                break;
            case Arc.RETURN:
                returnFlowButton.setSelected(true);
                break;
            case Arc.CHANNEL:
                channelButton.setSelected(true);
                break;
            case Arc.FUTURE:  //CB added section
            	futureArcButton.setSelected(true);
            	break;
        }
        nameField.setText(myObject.getVariable());
  }

  void UpdateControl() { //CB changed all types from Link. ... to Arc. ...
    if (myObject == null) return;
    int type;
    if (riverButton.isSelected()) //CB added RIVER section
      type = Arc.RIVER;
    else if (diversionButton.isSelected())
      type = Arc.DIVERSION;
    else if (gwPumpingButton.isSelected())
      type = Arc.GWPUMPING;
    else if (gsInteractionButton.isSelected())
      type = Arc.GWSW;
    else if (ggInteractionButton.isSelected())
      type = Arc.GWGW;
    else if (gwRechargeButton.isSelected())
      type = Arc.GWRECHARGE;
    else if (inflowButton.isSelected())
      type = Arc.INFLOW;
    else if (returnFlowButton.isSelected())
      type = Arc.RETURN;
    else if (channelButton.isSelected())
        type = Arc.CHANNEL;
    else if (futureArcButton.isSelected())  //CB added section
    	type = Arc.FUTURE;
    else if (oldToNewLineButton.isSelected())  //CB added section
    	type = Arc.OLD_TO_NEW;
    else if (bypassArcButton.isSelected())  //CB added section
    	type = Arc.BYPASS;
    else
      type = 0;

    System.out.println( "UpdateControl.ARCTYPE: "+type);
    myObject.setType(type);
    myObject.setVariable(nameField.getText());
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

