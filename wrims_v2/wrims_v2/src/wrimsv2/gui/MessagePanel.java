package wrimsv2.gui;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import javax.swing.JLabel;

public class MessagePanel extends JTabbedPane{

	private JScrollPane errorPane=new JScrollPane();
	
	public MessagePanel(){
		add("Error", errorPane);
	}
}
