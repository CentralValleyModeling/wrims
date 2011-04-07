package wrimsv2.gui;

import javax.swing.JTabbedPane;

public class DataPanel extends JTabbedPane {
	private OutlinePanel outlinePanel=new OutlinePanel();
	private VariablePanel variablePanel=new VariablePanel();
	
	public DataPanel(){
		add(outlinePanel, "Outline");
		add(variablePanel,"Variable");
	}
}
