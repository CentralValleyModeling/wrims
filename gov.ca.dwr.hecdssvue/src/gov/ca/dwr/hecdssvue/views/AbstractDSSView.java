package gov.ca.dwr.hecdssvue.views;

import hec.io.DataContainer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JRootPane;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

public abstract class AbstractDSSView extends ViewPart {

	protected Container contentPane;

	public AbstractDSSView() {
		super();
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		System.setProperty("sun.awt.noerasebackground", "true");
		Composite swingContainer = new Composite(parent, SWT.BACKGROUND
				| SWT.EMBEDDED);
		final Frame frame = SWT_AWT.new_Frame(swingContainer);
		@SuppressWarnings("serial")
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
		ISelectionListener listener = new ISelectionListener() {
	
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void selectionChanged(IWorkbenchPart part,
					ISelection selection) {
				if (part instanceof DSSCatalogView) {
					DSSCatalogView catalogView = (DSSCatalogView) part;
					Iterator iterator = ((IStructuredSelection) selection)
							.iterator();
					Vector<DataContainer> dataVector = new Vector();
					Vector<DataContainer> dataVector_path = new Vector();
					while(iterator.hasNext()){
						String[] parts = (String[]) iterator.next();
						// read 1 file
//						DataContainer data = catalogView.getData(catalogView.getPathname(parts));
//						if (data == null) {
//							continue;
//						}
//						dataVector.add(data);
                        // read multiple files
						dataVector_path = catalogView.getData(catalogView.getPathname(parts));
						if (dataVector_path == null) {
							continue;
						}
						dataVector.addAll(dataVector_path);
					}
					showSelected(dataVector);
				}
			}
		};
		getSite().getWorkbenchWindow().getSelectionService()
				.addSelectionListener(listener);
		ISelection selection = getSite().getWorkbenchWindow()
				.getSelectionService().getSelection();
		listener.selectionChanged(getSite().getPart(), selection);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		contentPane.requestFocus();
	}
	
	protected abstract void showSelected(Vector<DataContainer> dataVector);

}