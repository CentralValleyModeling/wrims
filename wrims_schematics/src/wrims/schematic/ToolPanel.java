package wrims.schematic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ToolPanel extends javax.swing.JPanel {

    public ToolPanel() {

    	this.setLayout(new BorderLayout());
        JTabbedPane jtp = new ToolSubTabs();
        add(jtp);
    }
}

class ToolSubTabs extends JTabbedPane {

	public ToolSubTabs() {

		JPanel jp1 = new ToolTrendReport();
		JPanel jp2 = new JPanel();

		this.addTab("Trend Report for CalSim3", jp1);
		this.addTab("   ", jp2);

		JButton test = new JButton("Press");
		//jp2.add(test);

//		ButtonHandler phandler = new ButtonHandler();
//		test.addActionListener(phandler);
//		setVisible(true);
	}
}
