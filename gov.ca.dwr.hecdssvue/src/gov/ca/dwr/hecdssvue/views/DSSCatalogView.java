package gov.ca.dwr.hecdssvue.views;

import gov.ca.dwr.hecdssvue.Activator;
import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecDss;
import hec.io.DataContainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;

public class DSSCatalogView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "gov.ca.dwr.hecdssvue.views.DSSCatalogView";

	private TableViewer viewer;
	private Action plotAction;
	private Action tabulateAction;
	private Action doubleClickAction;
	private HecDss dss;

	private TableViewSorter comparator;

	class TableViewSorter extends ViewerComparator {
		private int propertyIndex;
		private static final int DESCENDING = 1;
		private int direction = DESCENDING;

		public TableViewSorter() {
			this.propertyIndex = 0;
			direction = DESCENDING;
		}

		public int getDirection() {
			return direction == 1 ? SWT.DOWN : SWT.UP;
		}

		public void setColumn(int column) {
			if (column == this.propertyIndex) {
				// Same column as last sort; toggle the direction
				direction = 1 - direction;
			} else {
				// New column; do an ascending sort
				this.propertyIndex = column;
				direction = DESCENDING;
			}
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			String[] parts1 = (String[]) e1;
			String[] parts2 = (String[]) e2;
			int rc = 0;
			rc = parts1[propertyIndex].compareTo(parts2[propertyIndex]);
			// If descending order, flip the direction
			if (direction == DESCENDING) {
				rc = -rc;
			}
			return rc;
		}

	}

	class ViewContentProvider implements IStructuredContentProvider {
		Job catalogJob = null;
		Vector<CondensedReference> condensedCatalog;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			final HecDss dssInput = (HecDss) newInput;
			while (catalogJob != null && catalogJob.getState() == Job.RUNNING) {
				catalogJob.cancel();
				try {
					catalogJob.join();
				} catch (InterruptedException e) {
				}
			}
			catalogJob = new Job("DSS Catalog") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					if (dssInput != null) {
						monitor.beginTask("Cataloging...", 2);
						monitor.worked(1);
						condensedCatalog = dssInput.getCondensedCatalog();
						monitor.done();
					} else {
						condensedCatalog = null;
					}
					
					return Status.OK_STATUS;
				}
			};
			catalogJob.schedule();
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (catalogJob == null) {
				return new Object[] {};
			}
			if (catalogJob.getState() == Job.RUNNING) {
				try {
					catalogJob.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (condensedCatalog == null) {
				return new Object[] {};
			}

			ArrayList<String[]> pathParts = new ArrayList<String[]>();
			for (Iterator<CondensedReference> it = condensedCatalog.iterator(); it
					.hasNext();) {
				CondensedReference next = it.next();
				String[] parts = next.getNominalPathname().split("/");
				pathParts.add(parts);
			}
			return pathParts.toArray();
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			String[] pathParts = (String[]) obj;
			return pathParts[index + 1];
		}

		public Image getColumnImage(Object obj, int index) {
			return null;
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public DSSCatalogView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setSorter(new NameSorter());
		viewer.setComparator(comparator = new TableViewSorter());
		viewer.setInput(null);
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		createColumns(parent, viewer);
		viewer.setLabelProvider(new ViewLabelProvider());
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(viewer.getControl(), "gov.ca.dwr.hecdssvue.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		//
		ISelectionListener mylistener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart sourcepart,
					ISelection selection) {
				if (selection == null) {
					return;
				}
				if (selection instanceof IStructuredSelection) {
					Object element = ((IStructuredSelection) selection)
							.getFirstElement();
					if (element instanceof IFile) {
						IFile file = (IFile) element;
						if (file.getFullPath().getFileExtension()
								.equalsIgnoreCase("dss")) {
							try {
								if (dss != null) {
									dss.close();
								}
								dss = HecDss
										.open(file.getLocation().toString());
								viewer.setInput(dss);
							} catch (Exception ex) {
								Status status = new Status(IStatus.ERROR,
										Activator.PLUGIN_ID,
										"Error opening dss file: "
												+ file.getLocation(), ex);
								StatusManager.getManager().handle(status,
										StatusManager.LOG);
							}
						}
					}
				}
			}
		};
		getSite().getWorkbenchWindow().getSelectionService()
				.addSelectionListener(mylistener);
		ISelection selection = getSite().getWorkbenchWindow()
				.getSelectionService().getSelection();
		mylistener.selectionChanged(getSite().getPart(), selection);
		getSite().setSelectionProvider(viewer);
	}

	// This will create the columns for the table
	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "A part", "B part", "C part", "D part", "E part",
				"F part" };
		int[] bounds = { 100, 150, 150, 250, 100, 200 };
		for (int i = 0; i < titles.length; i++) {
			createTableViewerColumn(titles[i], bounds[i], i);
		}
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound,
			final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comparator.setColumn(colNumber);
				int dir = comparator.getDirection();
				viewer.getTable().setSortDirection(dir);
				viewer.refresh();
			}
		});
		return viewerColumn;
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DSSCatalogView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(plotAction);
		manager.add(new Separator());
		manager.add(tabulateAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(plotAction);
		manager.add(tabulateAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(plotAction);
		manager.add(tabulateAction);
	}

	private void makeActions() {
		plotAction = new Action() {
			public void run() {
				try {
					getSite().getWorkbenchWindow().getActivePage()
							.showView(DSSPlotView.ID);
				} catch (PartInitException ex) {
					Status status = new Status(IStatus.ERROR,
							Activator.PLUGIN_ID,
							"Error opening DSS Plot View ", ex);
					StatusManager.getManager()
							.handle(status, StatusManager.LOG);
				}
			}
		};
		plotAction.setText("Plot");
		plotAction.setToolTipText("Plot");
		plotAction.setImageDescriptor(Activator
				.getImageDescriptor("graph24.gif"));

		tabulateAction = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		tabulateAction.setText("Action 2");
		tabulateAction.setToolTipText("Action 2 tooltip");
		tabulateAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"DSS Catalog View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public String getPathname(String[] parts) {
		StringBuilder sb = new StringBuilder();
		sb.append("/");
		for (int i = 1; i < parts.length; i++) {
			if (i == 4) {
				sb.append(parts[i].split("-")[0].trim()).append("/");
			} else {
				sb.append(parts[i]).append("/");
			}
		}
		return sb.toString();
	}

	public DataContainer getData(String pathname) {
		try {
			return dss.get(pathname, true);
		} catch (Exception ex) {
			return null;
		}
	}
}