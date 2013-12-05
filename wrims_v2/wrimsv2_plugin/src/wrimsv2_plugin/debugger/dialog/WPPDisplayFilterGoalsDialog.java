package wrimsv2_plugin.debugger.dialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.goal.FilterGoal;
import wrimsv2_plugin.debugger.listener.TableCopyListener;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.model.WPPValue;
import wrimsv2_plugin.debugger.view.ProcessAltColumn;
import wrimsv2_plugin.debugger.view.WPPAllGoalView;
import wrimsv2_plugin.debugger.view.WPPAllVariableView;
import wrimsv2_plugin.debugger.view.WPPGoalView;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;
import wrimsv2_plugin.debugger.view.WPPVariableView;
import wrimsv2_plugin.tools.DataProcess;
import wrimsv2_plugin.tools.SearchTable;

public class WPPDisplayFilterGoalsDialog extends Dialog {
	
	private boolean firstAlt=false;
	private ArrayList<String> filterGoalNames=new ArrayList<String>();
	private Map<String, FilterGoal> filterGoals = new HashMap<String, FilterGoal>();
	private ArrayList<String> goalKeys=new ArrayList<String>();
	
	public WPPDisplayFilterGoalsDialog(Shell parent, ArrayList<String> filterGoalNames, Map<String, FilterGoal> filterGoals) {
		super(parent);
		this.filterGoalNames=filterGoalNames;
		this.filterGoals=filterGoals;
		setShellStyle(SWT.MIN);
	}
	
	public void openDialog(){
		create();
		getShell().setSize(820, 520);
		getShell().setText("Filtered Goals");
		open();
	}
	
	@Override
	 protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		GridLayout layout=new GridLayout();
		layout.numColumns=1;
		layout.marginWidth=20;
		dialogArea.setLayout(layout);
				
		Table table = new Table(dialogArea, SWT.MULTI|SWT.FULL_SELECTION);
		GridData gd1=new GridData(750, 390);
		table.setLayoutData(gd1);
	    constructTable(table);
	    	    
		dialogArea.pack();
		return dialogArea;
	 }
	
	public void constructTable(final Table table){
		
	    final TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		tc1.setText("Alias");
		tc1.setWidth(70);
		tc1.setResizable(true);
		
		
		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    tc2.setText("Control");
	    tc2.setWidth(70);
		tc2.setResizable(true);
		
		final TableColumn tc3 = new TableColumn(table, SWT.LEFT);
	    tc3.setText("Goal");
	    tc3.setWidth(100);
		tc3.setResizable(true);
	    
	    final TableColumn tc4 = new TableColumn(table, SWT.LEFT);
		tc4.setText("Content");
		tc4.setWidth(430);
		tc4.setResizable(true);
		
		
		final TableColumn tc5 = new TableColumn(table, SWT.LEFT);
	    tc5.setText("Tolerance");
	    tc5.setWidth(80);
		tc5.setResizable(true);
		
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    TableCopyListener tcl=new TableCopyListener(table);
	    table.addKeyListener(tcl);
	    
	    Listener nameSortListener = new Listener() {  
            
			@Override
			public void handleEvent(Event e) {
				 TableItem[] items = table.getItems();
				 Collator collator = Collator.getInstance(Locale.getDefault());  
	             TableColumn column = (TableColumn)e.widget;  
	             int index=0;
	             
	             for (int i = 1; i < items.length; i++) {  
	                 String value1 = items[i].getText(index);  
	                 for (int j = 0; j < i; j++){  
	                     String value2 = items[j].getText(index);  
	                     if (collator.compare(value1, value2) < 0) {  
	                         String[] values = {items[i].getText(0), items[i].getText(1), items[i].getText(2), items[i].getText(3), items[i].getText(4)};  
	                         items[i].dispose();  
	                         TableItem item = new TableItem(table, SWT.NONE, j);  
	                         item.setText(values);  
	                         items = table.getItems();  
	                         break;  
	                     }
	                 }  
	             }  
	             table.setSortColumn(column);  
	        } 
	     };  
	     
		 tc1.addListener(SWT.Selection, nameSortListener);
		 tc2.addListener(SWT.Selection, nameSortListener);
		 tc3.addListener(SWT.Selection, nameSortListener);
	     
		 procFilterGoal();
		 
		 fillData(table);
		 table.redraw();
	}
	
	public void procFilterGoal(){
		String line="";
		
		goalKeys=new ArrayList<String>();
		String filterGoalFileName="filtergoals.dat";
		File filterGoalFile=new File(DebugCorePlugin.dataDir, filterGoalFileName);
		if (filterGoalFile.exists()){
			try {
				FileReader fr = new FileReader(filterGoalFile);
				BufferedReader br = new BufferedReader(fr);
				while ((line = br.readLine()) != null) {
					String[] parts=line.split(";");
					String gn=parts[0];
					if (filterGoals.containsKey(gn) && parts.length==3){
						FilterGoal fg = filterGoals.get(gn);
						fg.setContent(parts[1]);
						fg.setControl(parts[2]);
						goalKeys.add(gn);
					}
				}
				fr.close();
			} catch (Exception e) {
				WPPException.handleException(e);
			}
		}
	}
	
	public void fillData(final Table table){
		for (int i=0; i<goalKeys.size(); i++){
			String name=goalKeys.get(i);
			FilterGoal fg=filterGoals.get(name);
			TableItem ti=new TableItem(table, SWT.NONE);
			ti.setText(0, fg.getAlias());
			ti.setText(1, fg.getControl());
			ti.setText(2, name);
			ti.setText(3, fg.getContent());
			ti.setText(4, fg.getTolerance());
		}
	}
}
