package gov.ca.dwr.calsimhydro.views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import wrimsv2_plugin.debugger.exception.WPPException;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;

public class CalSimHydroView extends ViewPart {

	private Composite swingContainer;
	private Container contentPane;
	private String urlString="http://mrsbmapp20565.pr.water.ca.gov/calsim-cesium.html";
	private Browser browser = BrowserFactory.create();
	private JComponent bc;
	public static String ID="gov.ca.dwr.calsimhydro.views.CalSimHydroView";

	@Override
	public void createPartControl(Composite parent) {
		System.setProperty("sun.awt.noerasebackground", "true");
		swingContainer = new Composite(parent, SWT.BACKGROUND | SWT.EMBEDDED);
		Frame frame = SWT_AWT.new_Frame(swingContainer);
		Panel panel = new Panel(new BorderLayout()) {
			public void update(java.awt.Graphics g) {
				/* Do not erase the background */
				paint(g);
			}
		};
		frame.add(panel);
		JRootPane root = new JRootPane();
		panel.add(root);
		contentPane = root.getContentPane();
		
		try {
			URL url = new URL(urlString);
			url.openConnection();
			// HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
			// Object objData = urlConnect.getContent();
		} catch (UnknownHostException e) {
			WPPException.handleException(e);
			return;

		} catch (Exception e) {
			WPPException.handleException(e);
			return;

		}

		JPanel jPanel = new JPanel();
		browser.loadURL(urlString);
		bc = browser.getView().getComponent();
		setSizes(1920, 1200);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.insets = new Insets(0, 0, 5, 5);

		jPanel.add(bc, c);
		
		contentPane.add(new JScrollPane(jPanel));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	public void setSizes(int width, int height) {
		bc.setMinimumSize(new Dimension(width, height));
		bc.setPreferredSize(new Dimension(width, height));
	}
}
