package wrimsv2.gui;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class TreePanel extends JTabbedPane{
	private JScrollPane studyTreePane=new JScrollPane();
	
	public TreePanel(){
		add("Studies", studyTreePane);
	}
}
