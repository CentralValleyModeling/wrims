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
		
		RowLayout rLayout = new RowLayout(SWT.HORIZONTAL);
		parent.setLayout(rLayout);
		choice = new Group(parent, SWT.NONE);
        detail = new Group(parent, SWT.NONE);
        
        GridLayout gLayout = new GridLayout();
        gLayout.numColumns=1;
        choice.setLayout(gLayout);
        tsButton = new Button(choice, SWT.RADIO);
        tsButton.setText("Timeseries");
        MouseListener tsListener= new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				DebugCorePlugin.varDetailChoice=0;	
				updateDetailTable();
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
				updateDetailTable();
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
				updateDetailTable();
			}

			@Override
			public void mouseUp(MouseEvent e) {

			}
        	
        };
        cycleButton.addMouseListener(cycleListener);
      
        FillLayout fLayout = new FillLayout(SWT.VERTICAL);
        detail.setLayout(fLayout);
        detail.setText("Detail");
        name=new Text(detail, 0);
        name.setText("X");
        table=new Table (detail, SWT.MULTI|SWT.FULL_SELECTION);
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
	}

	public void updateDetailTable(){
		if (DebugCorePlugin.varDetailChoice==0){
			displayTimeseries();
		}else if (DebugCorePlugin.varDetailChoice==1){
			displayFutureValues();
		}else{
			displayCycleValues();
		}
	}
	
	public void displayTimeseries(){
		table.removeAll();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Time Step");
	    tc2.setText("Date");
	    tc3.setText("Value");
	    table.setHeaderVisible(true);
	    ArrayList<String[]> timeseries=DebugCorePlugin.varDetailTimeseries;
	    for (String[] itemStrings: timeseries){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	item.setText(itemStrings);
	    }
	}
	
	public void displayFutureValues(){
		table.removeAll();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Time Step");
	    tc2.setText("Date");
	    tc3.setText("Value");
	    table.setHeaderVisible(true);
	    ArrayList<String[]> future=DebugCorePlugin.varDetailFuture;
	    for (String[] itemStrings: future){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	item.setText(itemStrings);
	    }
	}
	
	public void displayCycleValues(){
		table.removeAll();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Cycle");
	    tc2.setText("Value");
	    table.setHeaderVisible(true);
	    ArrayList<String[]> cycle=DebugCorePlugin.varDetailCycle;
	    for (String[] itemStrings: cycle){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	item.setText(itemStrings);
	    }
	}
}
