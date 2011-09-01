package wrims.schematic;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ConsolePanel extends JScrollPane{
	JTextArea textArea=new JTextArea(500,500);
	
	public ConsolePanel (JTextArea textArea){
		super (textArea);
		this.textArea=textArea;
		redirectSystemStreams();
	}

	private void updateTextArea(final String text) {    
		  SwingUtilities.invokeLater(new Runnable() {      
			  public void run() {        
				  textArea.append(text);      
			  }    
		  });  
	} 
	  
	private void redirectSystemStreams() {    
		  OutputStream out = new OutputStream() {      
			  
			  @Override      
			  public void write(final int b) throws IOException {        
				  updateTextArea(String.valueOf((char) b));      
			  }      
			  
			  @Override      
			  public void write(byte[] b, int off, int len) throws IOException {        
				  updateTextArea(new String(b, off, len));      
			  }      
			  
			  @Override  public void write(byte[] b) throws IOException {        
				  write(b, 0, b.length);      
			  }    
			  
		  };    
		  System.setOut(new PrintStream(out, true));    
		  System.setErr(new PrintStream(out, true));  }
}
