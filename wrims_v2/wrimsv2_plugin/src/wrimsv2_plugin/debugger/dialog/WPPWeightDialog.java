package wrimsv2_plugin.debugger.dialog;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.debug.core.DebugException;
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
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
import wrimsv2_plugin.debugger.view.WPPAllGoalView;
import wrimsv2_plugin.debugger.view.WPPAllVariableView;
import wrimsv2_plugin.debugger.view.WPPGoalView;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;
import wrimsv2_plugin.debugger.view.WPPVariableView;
import wrimsv2_plugin.tools.SearchTable;

public class WPPWeightDialog extends PopupDialog {
	
	private IViewPart view;
	
	public WPPWeightDialog(Shell parent, int shellStyle,
			boolean takeFocusOnOpen, boolean persistSize,
			boolean persistLocation, boolean showDialogMenu,
			boolean showPersistActions, String titleText, String infoText) {
		super(parent, shellStyle, takeFocusOnOpen, persistSize, persistLocation,
				showDialogMenu, showPersistActions, titleText, infoText);
		// TODO Auto-generated constructor stub
	}

	public void open(IViewPart view){
		this.view=view;
		create();
		getShell().setSize(790, 520);
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
	
	public void constructTable(Table table){
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		tc1.setText("Variable");
		tc1.setWidth(150);
		tc1.setResizable(true);
	    TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    tc2.setText("Weight");
	    tc2.setWidth(150);
		tc2.setResizable(true);
	    TableColumn tc3 = new TableColumn(table, SWT.LEFT);
	    tc3.setText("Value");
	    tc3.setWidth(150);
		tc3.setResizable(true);
	    
	    TableColumn tc4 = new TableColumn(table, SWT.LEFT);
	    tc4.setText("Alt");
	    tc4.setWidth(150);
	    tc4.setResizable(true);

	    TableColumn tc5 = new TableColumn(table, SWT.LEFT);
	    tc5.setText("Obj Change");
	    tc5.setWidth(150);
		tc5.setResizable(true);

	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    fillData(table);
	    table.redraw();
	}
	
	public void fillData(final Table table){
		String weightedVariables=DebugCorePlugin.weightedVariables;
		if (weightedVariables.equals("")) return;
		String[] dataStrings = weightedVariables.split("#");
		final int size=dataStrings.length;
		final String[] varList=new String[size];
		final String[] wtList=new String[size];
		final String[] valueList=new String[size];
		final String[] altList= new String[size];
		final String[] data;
		for (int i=0; i<size; i++){
			String[] varWeight = dataStrings[i].split(":");
			varList[i]=varWeight[0];
			wtList[i]=varWeight[1];
			TableItem ti=new TableItem(table, SWT.NONE);
			ti.setText(0, varWeight[0]);
			ti.setText(1, varWeight[1]);
		}
		
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
				WPPAllVariableView allVariableView=(WPPAllVariableView) workBenchPage.findView(DebugCorePlugin.ID_WPP_ALLVARIABLE_VIEW);
				Table allVarTable = allVariableView.getTable();
				int aVSize = allVarTable.getItemCount();
				boolean hasAlt=false;
				if (allVarTable.getColumnCount()>2) hasAlt=true;
				for (int i=0; i<size; i++){
					for (int j=0; j<aVSize; j++){
						TableItem item = allVarTable.getItem(j);
						if (item.getText(0).equals(varList[i])){
							valueList[i]=item.getText(1);
							if (hasAlt){
								altList[i]=item.getText(2);
							}
						}
					}
				}
				
				for (int i=0; i<size; i++){
					TableItem ti=table.getItem(i);
					ti.setText(2, valueList[i]);
					if (hasAlt){
						ti.setText(3, altList[i]);
						double objChange=(Double.parseDouble(valueList[i])-Double.parseDouble(altList[i]))*Double.parseDouble(wtList[1]);
						ti.setText(4, String.valueOf(objChange));
					}
				}
			    table.redraw();
			}
		});
	}
}
