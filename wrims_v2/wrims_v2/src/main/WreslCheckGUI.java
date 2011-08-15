package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import wrimsv2.components.Versions;

public class WreslCheckGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Versions vers = new Versions();
		int version_svn = vers.getSVN();
		String version_main = vers.getMainVersion();
		String version_status = vers.getStatus().toLowerCase();
		
		JFrame frame = new JFrame("Wresl Study Check Tool   ( v"+version_main+version_status+" svn"+version_svn+" )");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel wreslCheckPanel = new JPanel();
		wreslCheckPanel.setLayout(new BoxLayout(wreslCheckPanel, BoxLayout.Y_AXIS));
		final InputFilePanel inputFilePanel = new InputFilePanel(
				"Main Wresl File ");
		wreslCheckPanel.add(inputFilePanel);
		final JButton runButton = new JButton("Run Wresl Check");
		wreslCheckPanel.add(runButton);
		runButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				runButton.setEnabled(false);
				runButton.setText("Parsing...");
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							String errMessage =WreslCheck.parseWresl(inputFilePanel.getFile());

							if (errMessage.length() > 0){
								JOptionPane.showMessageDialog(runButton, errMessage, "Error",
										JOptionPane.ERROR_MESSAGE);
							}

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(runButton, ex
									.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						} finally {
							runButton.setText("Run Wresl Check");
							runButton.setEnabled(true);
						}
					}
				});
			}
		});
		frame.getContentPane().add(wreslCheckPanel);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.show();
	}

	/**
	 * Creates a panel consisting of label, a textfield populated by a browse
	 * (file browser) button
	 * 
	 * @return
	 */
	@SuppressWarnings("serial")
	private static class InputFilePanel extends JPanel {
		private JTextField textfield;
		private JButton browseButton;

		public InputFilePanel(String label) {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.add(new JLabel(label));
			this.add(textfield = new JTextField(40));
			this.add(browseButton = new JButton("Browse..."));
			browseButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int showOpenDialog = fileChooser
							.showOpenDialog(InputFilePanel.this);
					if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
						textfield.setText(fileChooser.getSelectedFile()
								.getAbsolutePath());
					}
				}
			});
		}

		public String getFile() {
			return textfield.getText();
		}
	}

}
