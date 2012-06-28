package wrimsv2_plugin.debugger.view;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
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
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;

public class WPPVarDetailView extends ViewPart implements ISelectionListener{

	private Group choice;
	private Group detail;
	
	private Button tsButton;
	private Button futButton;
	private Button cycleButton;
	
	private Text name;
	private Table table;
	
	
	@Override
	public void createPartControl(Composite parent) {
		
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
	
	public void updateDetail(String variableName){
		if (DebugCorePlugin.varDetailChoice==0){
			displayTimeseries();
		}else if (DebugCorePlugin.varDetailChoice==1){
			displayFutureValues();
		}else{
			displayCycleValues();
		}
		detail.setText("Detail: "+variableName);
		detail.redraw();
	}
	
	public void displayTimeseries(){
		table.removeAll();
		removeAllTableColumns();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Time Step");
	    tc2.setText("Date");
	    tc3.setText("Value");
	    int width=(int) Math.rint(table.getClientArea().width/3.0);
	    tc1.setWidth(width);
	    tc2.setWidth(width);
	    tc3.setWidth(width);
	    table.setHeaderVisible(true);
	    ArrayList<String[]> timeseries=DebugCorePlugin.varDetailTimeseries;
	    for (String[] itemStrings: timeseries){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	item.setText(itemStrings);
	    	table.redraw();
	    }
	}
	
	public void displayFutureValues(){
		table.removeAll();
		removeAllTableColumns();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Time Step");
	    tc2.setText("Date");
	    tc3.setText("Value");
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
	    tc1.setText("Cycle");
	    tc2.setText("Value");
	    int width=(int) Math.rint(table.getClientArea().width/2.0);
	    tc1.setWidth(width);
	    tc2.setWidth(width);
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
}
