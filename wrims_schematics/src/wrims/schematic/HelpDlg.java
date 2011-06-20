package wrims.schematic;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.awt.event.*;

public class HelpDlg extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel LogoLabel = new JLabel();
  JLabel TextLabel = new JLabel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JButton OKButton = new JButton();

  public HelpDlg(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try  {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public HelpDlg() {
    this(null, "", false);
  }

  void jbInit() throws Exception {
    panel1.setLayout(gridBagLayout1);
    ImageIcon logo = null;
    URL url = HelpDlg.class.getResource("images/nwlogo-94.gif");
    if (url != null)
      logo = new ImageIcon(url);
    LogoLabel.setMaximumSize(new Dimension(1200, 17));
    LogoLabel.setIcon(logo);
    LogoLabel.setText("<html><font face=\"Arial\" size=\"5\">JGo Flower<br>A Workflow Editor Sample Application</font></html>");
    TextLabel.setText("<html>" +
      "This sample application provides a simple example of using JGo to create<br>"+
      "a multiple-document interface workflow application.<br>"+
      "It also demonstrates support for various kinds of serialization and export<br>"+
      "formats, including XML and SVG (a specific XML document type for Scalable<br>"+
      "Vector Graphics).<br>"+
      "<br>"+
      "<font color=\"#FF0000\"><i>Drag and drop</i></font> workflow activities from the palette onto a diagram.<br>"+
      "<font color=\"#FF0000\"><i>Double-click</i></font> the activities on the diagram to examine or modifiy their<br>"+
      "properties (activity name and duration).<br>"+
      "<font color=\"#FF0000\"><i>Link</i></font> the activities together by dragging links from the output port of<br>"+
      "any activity to the input port of another activity.<br>"+
      "<font color=\"#FF0000\"><i>Layout</i></font> the diagram automatically using the default layered digraph algorithm.<br>"+
      "<br>"+
      "The labels on the links will always indicate the total length of the critical<br>"+
      "path at that point."+
      "</html>");
    panel1.setMaximumSize(new Dimension(5000, 5000));
    panel1.setMinimumSize(new Dimension(100, 100));
    panel1.setPreferredSize(new Dimension(550, 450));
    OKButton.setText("OK");
    OKButton.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        OKButton_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(LogoLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panel1.add(TextLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(10, 62, 0, 0), 0, 0));
    panel1.add(OKButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    OKButton.getRootPane().setDefaultButton(OKButton);
  }

  void OKButton_actionPerformed(ActionEvent e) {
      try {
        this.dispose();             // Free system resources
      } catch (Exception ex) {
      }
  }
}

