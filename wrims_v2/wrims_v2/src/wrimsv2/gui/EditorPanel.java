/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditorPanel.java
 *
 * Created on Apr 6, 2011, 3:29:54 PM
 */

package wrimsv2.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class EditorPanel extends javax.swing.JPanel {

	private TreePanel treePane=new TreePanel();
	private JPanel rightPane=new JPanel();
	private MessagePanel messagePane=new MessagePanel();
	private JPanel topPane=new JPanel();
	private TextPanel textPanel=new TextPanel();
	private DataPanel dataPanel =new DataPanel();
	
    public EditorPanel() {
  	
    	setLayout(new BorderLayout());
        Dimension minimumSize = new Dimension(100, 50);
    	
        JSplitPane jsp3=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,textPanel,dataPanel);
        jsp3.setOneTouchExpandable(true);
        textPanel.setMinimumSize(minimumSize);
        dataPanel.setMinimumSize(minimumSize);
        jsp3.setDividerLocation(550);
        
        JSplitPane jsp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jsp3, messagePane);
        jsp2.setOneTouchExpandable(true);       
        jsp3.setMinimumSize(minimumSize);
        messagePane.setMinimumSize(minimumSize);
        //jsp2.setPreferredSize(new Dimension(400, 200));
        jsp2.setDividerLocation(450);
        
    	JSplitPane jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,treePane,jsp2); 	
    	add(jsp1, BorderLayout.CENTER);
        jsp1.setOneTouchExpandable(true);
		treePane.setMinimumSize(minimumSize);
		//jsp1.setPreferredSize(new Dimension(400, 200));
        jsp1.setDividerLocation(200);
    }

}
