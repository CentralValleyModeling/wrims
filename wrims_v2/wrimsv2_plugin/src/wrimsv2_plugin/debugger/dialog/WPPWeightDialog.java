package wrimsv2_plugin.debugger.dialog;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
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

public class WPPWeightDialog extends Dialog {
	
	private boolean firstAlt=false;
	
	public WPPWeightDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	
	public void openDialog(){
		create();
		getShell().setSize(820, 520);
		getShell().setText("Weighted Variables");
		open();
	}
	
	@Override
	 protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		GridLayout layout=new GridLayout();
		layout.numColumns=1;
		layout.marginWidth=20;
		dialogArea.setLayout(layout);
				
		Table table = new Table(dialogArea, SWT.NONE);
		GridData gd1=new GridData(750, 390);
		table.setLayoutData(gd1);
	    constructTable(table);
	    
		Button ok = new Button(dialogArea, SWT.PUSH);
		ok.setText("OK");
		ok.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				close();
			}
		});
		GridData gd2= new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		ok.setLayoutData(gd2);
		
		dialogArea.getShell().setDefaultButton(ok);
		dialogArea.pack();
		return dialogArea;
	 }
	
	public void constructTable(final Table table){
		
	    final TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		tc1.setText("Variable");
		tc1.setWidth(150);
		tc1.setResizable(true);
		
		
		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    tc2.setText("Weight");
	    tc2.setWidth(150);
		tc2.setResizable(true);
		
		final TableColumn tc3 = new TableColumn(table, SWT.LEFT);
	    tc3.setText("Value");
	    tc3.setWidth(150);
		tc3.setResizable(true);
	    
		Map<Integer, Integer> variableAltColIndex = DebugCorePlugin.variableAltColIndex;
		if (variableAltColIndex.size()>0) firstAlt=true;
		
		final TableColumn tc4 = new TableColumn(table, SWT.LEFT);
		if (firstAlt){
			int i=variableAltColIndex.get(2)+1;
			tc4.setText("Alt"+i);
		}else{
			tc4.setText("Alt");
		}
		tc4.setWidth(150);
		tc4.setResizable(true);

		final TableColumn tc5 = new TableColumn(table, SWT.LEFT);
		tc5.setText("Obj Change");
		tc5.setWidth(150);
		tc5.setResizable(true);
		
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
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
	     
		 Listener valueSortListener = new Listener() {  
	            
				@Override
				public void handleEvent(Event e) {
					 TableItem[] items = table.getItems();
					 Collator collator = Collator.getInstance(Locale.getDefault());  
		             TableColumn column = (TableColumn)e.widget;  
		             int index;
		             if (column==tc2){
		            	 index=1;
		             }else if (column == tc3){
		            	 index=2;
		             }else if (column == tc4){
		            	 index=3;
		             }else{
		            	 index=4;
		             }
		             
		             for (int i = 1; i < items.length; i++) {
		            	 double value1, value2;
		            	 String value1Str = items[i].getText(index);
		            	 if (value1Str.equals("")){
		            		 value1 = 0.0;
		            	 }else{
		            		 value1 = Double.parseDouble(value1Str);
		            	 }
		                 for (int j = 0; j < i; j++){
		                	 String value2Str = items[j].getText(index);
		                	 if (value2Str.equals("")){
			            		 value2 = 0.0;
			            	 }else{
			            		 value2 = Double.parseDouble(value2Str);
			            	 }
		                     if (value1 > value2) {
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
		 tc2.addListener(SWT.Selection, valueSortListener);
		 tc3.addListener(SWT.Selection, valueSortListener);
		 tc4.addListener(SWT.Selection, valueSortListener);
		 tc5.addListener(SWT.Selection, valueSortListener);
	     
		 fillData(table);
		 table.redraw();
	}
	
	public void fillData(final Table table){
		String weightedVariables=DebugCorePlugin.weightedVariables;
		if (weightedVariables.equals("")) return;
		String[] dataStrings = weightedVariables.split("#");
		int size=dataStrings.length;

		DebugCorePlugin.allVariableProperty=DataProcess.generateVariableProperty(DebugCorePlugin.allVarProperties);
		WPPValue[] allVarStack = (WPPValue[])DebugCorePlugin.allVariableStack;
		int allVarStackSize=allVarStack.length;
		String value="";
		for (int i=0; i<size; i++){
			String[] varWeight = dataStrings[i].split(":");
			String var=varWeight[0];
			String wt=varWeight[1];
			TableItem ti=new TableItem(table, SWT.NONE);
			ti.setText(0, var);
			ti.setText(1, wt);
			boolean notFound=true;
			int j=0;
			while (j<allVarStackSize && notFound){
				value="";
				if (allVarStack[j].getVariableString().equals(var)){
					try {
						value=allVarStack[j].getValueString();
						ti.setText(2, value);
						notFound=false;
					} catch (DebugException e) {
						WPPException.handleException(e);
					}
				}
				j++;
			}
			if (firstAlt){
				String alt=ProcessAltColumn.addAltColumnData(var, 2, 2);
				ti.setText(3, alt);
				if (!alt.equals("")){
					double objChange=(Double.parseDouble(value)-Double.parseDouble(alt))*Double.parseDouble(wt);
					ti.setText(4, DebugCorePlugin.df.format(objChange));
				}
			}
		}
	}
}
