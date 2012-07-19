package wrimsv2_plugin.debugger.view;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.WPPValue;
import wrimsv2_plugin.tools.DataProcess;

public class WPPVarDetailView extends ViewPart implements ISelectionListener{

	private Group choice;
	private Group detail;
	
	private Button tsButton;
	private Button futButton;
	private Button cycleButton;
	
	private Text name;
	private Table table;
	
	private ISelectionListener listener=new ISelectionListener(){
		@Override
		public void selectionChanged(IWorkbenchPart part,
				ISelection selection) {
			if (part instanceof WPPVariableView || part instanceof WPPAllVariableView){
				ArrayList<String> selectedVariableNames = new ArrayList<String>();
				Iterator iterator = ((StructuredSelection)selection).iterator();
				while (iterator.hasNext()){
					Object item=iterator.next();
					String variableName=((WPPValue)item).getVariableString();
					selectedVariableNames.add(variableName);
				}
				if (selectedVariableNames.size()>0){
					DebugCorePlugin.selectedVariableNames=selectedVariableNames;
					if (DebugCorePlugin.target !=null && DebugCorePlugin.target.isSuspended()){
						updateDetailVariableView(selectedVariableNames);
					}
				}
			}
		}
    };
	
	
	@Override
	public void createPartControl(Composite parent) {
		getSite().getPage().addSelectionListener(listener);
		
		GridLayout gLayoutMain = new GridLayout();
		gLayoutMain.numColumns=2;
		parent.setLayout(gLayoutMain);
		choice = new Group(parent, SWT.NONE);
		choice.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        detail = new Group(parent, SWT.NONE);
        detail.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        GridLayout gLayoutChoice = new GridLayout();
        gLayoutChoice.numColumns=1;
        choice.setLayout(gLayoutChoice);
        tsButton = new Button(choice, SWT.RADIO);
        tsButton.setText("Timeseries");
        tsButton.setSelection(true);
        MouseListener tsListener= new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				DebugCorePlugin.varDetailChoice=0;	
				updateDetail();
			}

			@Override
			public void mouseUp(MouseEvent e) {

			}
        	
        };
        tsButton.addMouseListener(tsListener);
        
        futButton = new Button(choice, SWT.RADIO);
        futButton.setText("Future");
        MouseListener futListener= new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				DebugCorePlugin.varDetailChoice=1;	
				updateDetail();
			}

			@Override
			public void mouseUp(MouseEvent e) {

			}
        	
        };
        futButton.addMouseListener(futListener);
        
        cycleButton = new Button(choice, SWT.RADIO);
        cycleButton.setText("Cycle");
        MouseListener cycleListener= new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				DebugCorePlugin.varDetailChoice=2;	
				updateDetail();
			}

			@Override
			public void mouseUp(MouseEvent e) {

			}
        	
        };
        cycleButton.addMouseListener(cycleListener);
      
        GridLayout gLayoutDetail = new GridLayout();
        gLayoutDetail.numColumns=1;
        detail.setLayout(gLayoutDetail);
        detail.setText("Detail:");
        table=new Table (detail, SWT.MULTI|SWT.FULL_SELECTION);
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
        tc1.setText("Time Step");
	    tc2.setText("Date");
	    tc3.setText("Value");
	    tc1.setWidth(150);
	    tc2.setWidth(150);
	    tc3.setWidth(150);
	    table.setHeaderVisible(true);
	    table.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
	}

	public void updateDetail(){
		if (DebugCorePlugin.varDetailChoice==0){
			displayTimeseries();
		}else if (DebugCorePlugin.varDetailChoice==1){
			displayFutureValues();
		}else{
			displayCycleValues();
		}
	}
	
	public void updateDetail(ArrayList<String> variableNames){
		if (DebugCorePlugin.varDetailChoice==0){
			displayTimeseries();
		}else if (DebugCorePlugin.varDetailChoice==1){
			displayFutureValues();
		}else{
			displayCycleValues();
		}
		detail.setText("Detail:");
		detail.redraw();
	}
	
	public void displayTimeseries(){
		table.removeAll();
		removeAllTableColumns();
		ArrayList<String> variableNames=DebugCorePlugin.selectedVariableNames;
		int sizeTc=variableNames.size()+2;
		int width=(int) Math.rint(table.getClientArea().width/(sizeTc*1.0));
		TableColumn[] tc = new TableColumn[sizeTc];
		tc[0] = new TableColumn(table, SWT.CENTER);
	    tc[0].setText("Time Step");
	    tc[1] = new TableColumn(table, SWT.CENTER);
	    tc[1].setText("Date");
	    if (width>10){
	    	tc[0].setWidth(width);
	    	tc[1].setWidth(width);
	    }else{
		    tc[0].setWidth(150);
		    tc[1].setWidth(150);
	    }
	    for (int i=2; i<sizeTc; i++){
	    	tc[i] = new TableColumn(table, SWT.CENTER);
	    	tc[i].setText(variableNames.get(i-2));
	    	if (width>10){
		    	tc[i].setWidth(width);
		    }else{
			    tc[i].setWidth(150);
		    }
	    }

	    table.setHeaderVisible(true);
	    ArrayList<String[]> timeseries=DebugCorePlugin.varDetailTimeseries;
	    for (String[] itemStrings: timeseries){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	item.setText(itemStrings);
	    }
	    table.redraw();
	    final TableCursor cursor = new TableCursor(table, SWT.NONE);
	    cursor.addSelectionListener(new SelectionAdapter(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (DebugCorePlugin.isDebugging && DebugCorePlugin.target.isSuspended()){
					int col=cursor.getColumn();
					if (col>=2){
						final String varName=table.getColumn(col).getText();
						final TableItem ti=cursor.getRow();
						final IWorkbench workbench=PlatformUI.getWorkbench();
						workbench.getDisplay().asyncExec(new Runnable(){
							public void run(){
								Shell shell=workbench.getActiveWorkbenchWindow().getShell();
								WPPTimeSeriesDialog dialog= new WPPTimeSeriesDialog(shell, SWT.BORDER|SWT.APPLICATION_MODAL, true, false, false, false, false, "Modify Value", varName);
								dialog.open(ti, table, varName);
							}
						});
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	}
	
	public void displayFutureValues(){
		table.removeAll();
		removeAllTableColumns();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Time Step");
	    tc2.setText("Date");
	    tc3.setText(DebugCorePlugin.selectedVariableNames.get(0));
	    int width=(int) Math.rint(table.getClientArea().width/3.0);
	    tc1.setWidth(width);
	    tc2.setWidth(width);
	    tc3.setWidth(width);
	    table.setHeaderVisible(true);
	    ArrayList<String[]> future=DebugCorePlugin.varDetailFuture;
	    for (String[] itemStrings: future){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	item.setText(itemStrings);
	    }
	    table.redraw();
	}
	
	public void displayCycleValues(){
		table.removeAll();
		removeAllTableColumns();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Index");
	    tc2.setText("Cycle");
	    tc3.setText(DebugCorePlugin.selectedVariableNames.get(0));
	    int width=(int) Math.rint(table.getClientArea().width/3.0);
	    tc1.setWidth(width);
	    tc2.setWidth(width);
	    tc3.setWidth(width);
	    table.setHeaderVisible(true);
	    ArrayList<String[]> cycle=DebugCorePlugin.varDetailCycle;
	    for (String[] itemStrings: cycle){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	item.setText(itemStrings);
	    }
	    table.redraw();
	}
	
	public void removeAllTableColumns(){
		table.setRedraw(false);
		while ( table.getColumnCount() > 0 ) {
		    table.getColumns()[ 0 ].dispose();
		}
		table.setRedraw(true);
	}
	
	public void updateDetailVariableView(final ArrayList<String> variableNames){
		try{
			String data="";
			String linkVarNames="";
			for (String varName:variableNames){
				linkVarNames=linkVarNames+varName+"#";
			}
			if (linkVarNames.endsWith("#")) linkVarNames=linkVarNames.substring(0, linkVarNames.length()-1);
			data= DebugCorePlugin.target.sendRequest("tsdetail:"+variableNames.get(0));
			DebugCorePlugin.varDetailTimeseries=DataProcess.generateVarDetailData(data);
			final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						WPPVarMonitorView varMonitorView = (WPPVarMonitorView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_VARIABLEMONITOR_VIEW);
						varMonitorView.initialPlot();
					}
			});
			data= DebugCorePlugin.target.sendRequest("futdetail:"+variableNames.get(0));
			DebugCorePlugin.varDetailFuture=DataProcess.generateVarDetailData(data);
			data= DebugCorePlugin.target.sendRequest("cycledetail:"+variableNames.get(0));
			DebugCorePlugin.varDetailCycle=DataProcess.generateVarDetailData(data);
			updateDetail(variableNames);
			getSite().getPage().showView(DebugCorePlugin.ID_WPP_VARIABLEDETAIL_VIEW, null, IWorkbenchPage.VIEW_VISIBLE);
		} catch (Exception e) {
			WPPException.handleException(e);
		} 
	}
}
