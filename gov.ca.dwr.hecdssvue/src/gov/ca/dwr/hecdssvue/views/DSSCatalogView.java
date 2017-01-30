package gov.ca.dwr.hecdssvue.views;

import gov.ca.dwr.hecdssvue.Activator;
import gov.ca.dwr.hecdssvue.DssPluginCore;
import gov.ca.dwr.hecdssvue.components.DataOps;
import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecDss;
import hec.heclib.util.HecTime;
import hec.hecmath.HecMath;
import hec.hecmath.HecMathException;
import hec.hecmath.TimeSeriesMath;
import hec.io.DataContainer;
import hec.io.TimeSeriesContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

//public class DSSCatalogView extends ViewPart {
public class DSSCatalogView extends AbstractDSSView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "gov.ca.dwr.hecdssvue.views.DSSCatalogView";

	private TableViewer viewer;
	private Action plotAction;
	private Action tabulateAction;
	private Action doubleClickAction;
	private HecDss dss;
//	private ArrayList<HecDss> dssArray = new ArrayList<HecDss> ();
//	private ArrayList<HecDss> dssArray;
	
	private TableViewSorter comparator;

	class TableViewSorter extends ViewerComparator {
		private int propertyIndex;
		private static final int ASCENDING = 0;
		private static final int DESCENDING = 1;
		private int direction = ASCENDING;

		public TableViewSorter() {
			this.propertyIndex = 1;
			direction = ASCENDING;
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
				direction = ASCENDING;
			}
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			String[] parts1 = (String[]) e1;
			String[] parts2 = (String[]) e2;
			int rc = 0;
			rc = parts1[propertyIndex+1].compareTo(parts2[propertyIndex+1]);
			// If descending order, flip the direction
			if (direction == DESCENDING) {
				rc = -rc;
			}
			return rc;
		}

	}

	class ViewContentProvider implements IStructuredContentProvider {
		Job catalogJob = null;
//		Vector<CondensedReference> condensedCatalog_elem;
//		ArrayList<HecDss> dssInputs = new ArrayList<HecDss>();
		ArrayList<HecDss> dssInputs;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
//			final HecDss dssInput = (HecDss) newInput;   //1 dss
//			final ArrayList<HecDss> dssInputs = (ArrayList<HecDss>) newInput;
			dssInputs = (ArrayList<HecDss>) newInput;

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
					//1 dss
//					if (dssInput != null) {
//						monitor.beginTask("Cataloging...", 2);
//						monitor.worked(1);
//						condensedCatalog = dssInput.getCondensedCatalog();
//						monitor.done();
//					} else {
//						condensedCatalog = null;
//					}
					if (dssInputs != null) {
						DssPluginCore.condensedCatalog = new Vector<CondensedReference>();//TODO
						int i=0;
					    for (Iterator<HecDss> it = dssInputs.iterator(); it.hasNext();i++){
						    HecDss dssInput = it.next();
							monitor.beginTask("Cataloging...", 2);
							monitor.worked(1);
							Vector<CondensedReference> condensedCatalog_elem = dssInput.getCondensedCatalog();
//							if (dssInput!=null) {
//								Vector<CondensedReference> condensedCatalog_elem = dssInput.getCondensedCatalog();
//							}
							if (i<2){
								DssPluginCore.condensedCatalog.addAll(condensedCatalog_elem);
							}
							monitor.done();
					    }
					    
					} else {
						DssPluginCore.condensedCatalog = null;
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
			if (DssPluginCore.condensedCatalog == null) {
				return new Object[] {};
			}

			ArrayList<String[]> pathParts = new ArrayList<String[]>();
			DssPluginCore.allStorageNames= new ArrayList<String>();
			DssPluginCore.allPathName = new HashMap<String, String>();
			int i=0;
			for (Iterator<CondensedReference> it = DssPluginCore.condensedCatalog.iterator();
					it.hasNext();) {
				CondensedReference next = it.next();
				String pathName = next.getNominalPathname();
				String[] parts = pathName.split("/");
				if (parts[3].toLowerCase().startsWith("storage")) DssPluginCore.allStorageNames.add(parts[2]);
				DssPluginCore.allPathName.put(parts[2], getPath(parts));
				i++;
				if (showFilteredRows(parts, DssPluginCore.filter, false)) pathParts.add(parts);
			}
			return pathParts.toArray();
		}
		
		public String getPath(String[] parts) { // CB changed return type to String
			StringBuffer path = new StringBuffer();// CB to speed up
			path.append("/");
			path.append(parts[1]);
			path.append("/");
			path.append(parts[2]);
			path.append("/");
			path.append(parts[3]);
			path.append("//");
			path.append(parts[5]);
			path.append("/");
			path.append(parts[6]);
			path.append("/");
			return path.toString();
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
								dss = HecDss.open(file.getLocation().toString());
								DssPluginCore.dssArray = new ArrayList<HecDss> ();// for multiple dss readin
								DssPluginCore.dssArray.add(dss);
								viewer.setInput(DssPluginCore.dssArray);
								resetDssFileView();
								DataOps.clearGeoSchematicVariableData();
								DataOps.loadAllSchematicVariableData();

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
	
	/* 
	 * return path data from 1 file
	 */
//	public DataContainer getData(String pathname) {
//		try {
//			return dss.get(pathname, true);
//		} catch (Exception ex) {
//			return null;
//		}
//	}
	
	/* 
	 * return path data from multiple files
	 */
	public Vector<DataContainer> getData(String pathname, String[] parts) {
		Vector<DataContainer> dataVector_path = new Vector<DataContainer>();
//		DataContainer dataVector_file = new DataContainer();
		TimeSeriesContainer dataVector_file = new TimeSeriesContainer();
        int dv_flag;
        ArrayList<HecDss> dssArray = (ArrayList<HecDss>)getViewer().getInput();

		for (int i = 0; i <dssArray.size(); i++){
			dv_flag = i%2;
			switch(dv_flag){
			  case 0:
				try{
//				  dataVector_file = dssArray.get(i).get(pathname, true);
				  if (DssPluginCore.tw.equals("All")){	
					  HecDss hecDss = dssArray.get(i);
					  TimeSeriesContainer tsc = (TimeSeriesContainer)hecDss.get(pathname, true);
					  if (tsc == null || tsc.numberValues==0){
						  String pathname_new=getPathNameIgnorePartAF(i/2, parts, pathname);
						  if (!pathname.equals(pathname_new)) tsc = (TimeSeriesContainer)hecDss.get(pathname_new, true);
					  }
					  dataVector_file = DataOps.getMonthlyData(tsc, DssPluginCore.months);
				  }else{
					  String startTime=DssPluginCore.tw.substring(0, 13);
					  String endTime=DssPluginCore.tw.substring(15, 28);
					  HecDss hecDss = dssArray.get(i);
					  TimeSeriesContainer tsc = (TimeSeriesContainer)hecDss.get(pathname, startTime, endTime);
					  if (tsc == null || tsc.numberValues==0){
						  String pathname_new=getPathNameIgnorePartAF(i/2, parts, pathname);
						  if (!pathname.equals(pathname_new)) tsc = (TimeSeriesContainer)hecDss.get(pathname_new, startTime, endTime);
					  }
					  dataVector_file = DataOps.getMonthlyData(tsc, DssPluginCore.months);
				  }
				} catch (Exception ex) {
				  dataVector_file = null;
			    }
				if (DssPluginCore.mode.equals(DssPluginCore.diff) && i>1 && dataVector_file !=null){
					dataVector_file=DataOps.diff(dataVector_file, (TimeSeriesContainer)dataVector_path.get(0));
				}
				if (dataVector_file !=null) dataVector_path.add(dataVector_file);
//				dataVector_file.units//TODO
                break;
			  case 1:
//				if (dataVector_file.numberValues == 0){
//				if (dataVector_path.get((i-1)/2).numberValues == 0){
//				if (dataVector_file.fullName==""){//TODO:prev null
				if ((dataVector_file==null)||(dataVector_file.fullName=="")){//TODO
//				if (dataVector_file==null){//TODO
//				if (dataVector_path.get((i-1)/2).equals(null)){
				  try{
//					dataVector_file = dssArray.get(i).get(pathname, true);
					if (DssPluginCore.tw.equals("All")){  
						HecDss hecDss = dssArray.get(i);
						  TimeSeriesContainer tsc = (TimeSeriesContainer)hecDss.get(pathname, true);
						  if (tsc == null || tsc.numberValues==0){
							  String pathname_new=getPathNameIgnorePartAF(i/2, parts, pathname);
							  if (!pathname.equals(pathname_new)) tsc = (TimeSeriesContainer)hecDss.get(pathname_new, true);
						  }
						  dataVector_file = DataOps.getMonthlyData(tsc, DssPluginCore.months);
					}else{ 
						String startTime=DssPluginCore.tw.substring(0, 13);
						String endTime=DssPluginCore.tw.substring(15, 28);
						HecDss hecDss = dssArray.get(i);
						TimeSeriesContainer tsc = (TimeSeriesContainer)hecDss.get(pathname, startTime, endTime);
						if (tsc == null || tsc.numberValues==0){
							String pathname_new=getPathNameIgnorePartAF(i/2, parts, pathname);
							if (!pathname.equals(pathname_new)) tsc = (TimeSeriesContainer)hecDss.get(pathname_new, startTime, endTime);
						}
						dataVector_file = DataOps.getMonthlyData(tsc, DssPluginCore.months);
					}
				  } catch (Exception ex) {
				    dataVector_file = null;
			      }
				  if (DssPluginCore.mode.equals(DssPluginCore.diff) && i>1 && dataVector_file !=null){
						dataVector_file=DataOps.diff(dataVector_file, (TimeSeriesContainer)dataVector_path.get(0));
				  }
				  dataVector_path.add(dataVector_file);
				}
		        break;
			}
		}
		
		if (DssPluginCore.mode.equals(DssPluginCore.diff) && dataVector_path.size()>0){
			dataVector_path.remove(0);
		}
		
		return dataVector_path;
     }
	
	public TableViewer getViewer() {
		return viewer;
	}

	protected void showSelected(Vector<DataContainer> dataVector) {
		try {
			DSSPlotView dpv = (DSSPlotView) getSite().getWorkbenchWindow()
                              .getActivePage().showView(DSSPlotView.ID);
			dpv.showSelected(dataVector);

			DSSTableView dtv = (DSSTableView) getSite().getWorkbenchWindow()
                               .getActivePage().showView(DSSTableView.ID);
			dtv.showSelected(dataVector);
			
			DSSMonthlyView mv = (DSSMonthlyView) getSite().getWorkbenchWindow()
                    .getActivePage().showView(DSSMonthlyView.ID);
			mv.showSelected(dataVector);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
	}
	
	public Vector<String[]> getSelectedParts(){
		Vector<String[]> selectedParts=new Vector<String[]>();
		ISelection selection = viewer.getSelection();
		Iterator iterator = ((IStructuredSelection) selection)
				.iterator();
		while(iterator.hasNext()){
			String[] parts = (String[]) iterator.next();
			selectedParts.add(parts);
		}
		return selectedParts;
	}
	
	public Vector<String> getSelectedPathNames(){
		Vector<String> selectedPathnames=new Vector<String>();
		ISelection selection = viewer.getSelection();
		Iterator iterator = ((IStructuredSelection) selection)
				.iterator();
		while(iterator.hasNext()){
			String[] parts = (String[]) iterator.next();
			selectedPathnames.add(getPathname(parts));
		}
		return selectedPathnames;
	}
	
	public void resetDssFileView(){
		DebugCorePlugin.selectedStudies[0]=true;
		for (int i=1; i<8; i++){
			DebugCorePlugin.selectedStudies[i]=false;
		}
		String fn = dss.getFilename();
		if (fn.toLowerCase().endsWith("sv.dss")){
			DebugCorePlugin.svDss[0]=dss;
			DebugCorePlugin.studySvFileNames[0]=fn;
			DebugCorePlugin.studyDvFileNames[0]="";
		}else{
			DebugCorePlugin.dvDss[0]=dss;
			DebugCorePlugin.studySvFileNames[0]="";
			DebugCorePlugin.studyDvFileNames[0]=fn;
		}
		for (int i=1; i<4; i++){
			DebugCorePlugin.studySvFileNames[i]="";
			DebugCorePlugin.studyDvFileNames[i]="";
		}
	}
	
	public boolean showFilteredRows(String[] pathParts, String filter, boolean useRegex) {
		String search = filter.trim().toUpperCase();
		// if (filter.equals("///////") && !useRegex)
		// filter = "/*/*/*/*/*/*/";
		// filter = "/.*/.*/.*/.*/.*/.*/";

		String[] parts = search.split("/");
		int i;
		Pattern[] pattern = new Pattern[7];

		// Compile the match pattern for each 'part'
		for (i = 1; i < 7; i++) {
			// map interface non-regex wildcards to a regex
			if (!useRegex) {
				parts[i] = parts[i].replaceAll("\\?", ".");
				parts[i] = parts[i].replaceAll("\\*", ".*");
			}
			pattern[i] = Pattern.compile(parts[i]);

		}

		boolean match = true;
		for (i = 1; i < 7; i++) {
			match = pattern[i].matcher((String) pathParts[i]).matches();
			if (!match)
				break;
		}
		return match;
	}
	
	public String getPathNameIgnorePartAF(int j, String[] parts, String pathname){
		boolean found=false;
		int k=0;
		ArrayList<String> pathnameList = DssPluginCore.pathnameLists[j];
		while (k<pathnameList.size() && !found) {
			String pathName_new = pathnameList.get(k);
			String[] parts_new = pathName_new.split("/");
			if (parts[2].equals(parts_new[2]) && parts[3].equals(parts_new[3])){
				found = true;
				pathname=pathName_new;
			}
			k++;
		}
		return pathname;
	}
}