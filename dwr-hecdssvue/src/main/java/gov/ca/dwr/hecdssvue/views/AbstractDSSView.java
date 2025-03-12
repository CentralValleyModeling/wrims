package gov.ca.dwr.hecdssvue.views;


import gov.ca.dwr.hecdssvue.components.ClearAllCheckBox;
import hec.io.DataContainer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JRootPane;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public abstract class AbstractDSSView extends ViewPart {

	protected Container contentPane;
	protected Frame frame;
	private Composite swingContainer;
	private Job dataReadJob;

	protected AbstractDSSView() {
		super();
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		System.setProperty("sun.awt.noerasebackground", "true");
		swingContainer = new Composite(parent, SWT.BACKGROUND
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
		ISelectionService selectionService = getSite().getWorkbenchWindow().getSelectionService();
		selectionService.addSelectionListener(this::executeReadSelectedDssValuesJob);
		ISelection selection = selectionService.getSelection();
		executeReadSelectedDssValuesJob(getSite().getPart(), selection);
		this.frame =frame;
	}

	private void executeReadSelectedDssValuesJob(IWorkbenchPart part, ISelection selection) {
		if (part instanceof DSSCatalogView) {
			while (dataReadJob != null && dataReadJob.getState() == Job.RUNNING) {
				dataReadJob.cancel();
			}
			dataReadJob = Job.create("Reading DSS Data", monitor -> readDssValues( part, selection, monitor));
			dataReadJob.setUser(true);
			dataReadJob.schedule();
		}
	}

	private IStatus readDssValues(IWorkbenchPart workbenchPart, ISelection selection, IProgressMonitor monitor) {
		Vector<DataContainer> dataVector = new Vector<>();
		DSSCatalogView catalogView = (DSSCatalogView) workbenchPart;
		Iterator<?> iterator = ((IStructuredSelection) selection).iterator();
		while (iterator.hasNext()) {
			String[] next = (String[]) iterator.next();
			monitor.subTask("Reading DSS Data for " + Arrays.toString(next) + "Hello");
			dataVector.addAll(catalogView.getData(next));
		}
		if (!monitor.isCanceled()) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
				new ClearAllCheckBox();
				showSelected(dataVector);
			});
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		swingContainer.setFocus();
	}
	
	protected abstract void showSelected(Vector<DataContainer> dataVector);

}