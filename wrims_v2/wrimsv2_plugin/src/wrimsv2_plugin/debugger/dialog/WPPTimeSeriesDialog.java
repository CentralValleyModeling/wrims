package wrimsv2_plugin.debugger.dialog;

import java.util.ArrayList;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;

public class WPPTimeSeriesDialog extends PopupDialog {

	private int col;
	private int row;
	private TableItem item;
	private Table table;
	private String varName;
	private String input;
	
	public WPPTimeSeriesDialog(Shell parent, int shellStyle,
			boolean takeFocusOnOpen, boolean persistSize,
			boolean persistLocation, boolean showDialogMenu,
			boolean showPersistActions, String titleText, String infoText) {
		super(parent, shellStyle, takeFocusOnOpen, persistSize, persistLocation,
				showDialogMenu, showPersistActions, titleText, infoText);
		// TODO Auto-generated constructor stub
	}

	public void open(int row, int col, TableItem item, Table table, String varName){
		this.row=row;
		this.col=col;
		this.item=item;
		this.table=table;
		this.varName=varName;
		create();
		getShell().setSize(300, 200);
		open();
	}
	
	public String getInput(){
		return input;
	}
	
	public void setInput(String input){
		this.input=input;
	}

	@Override
	 protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		dialogArea.setLayout(new GridLayout(2, true));
		
		GridData data=new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan=1;
		
		Label label0_0 = new Label(dialogArea, SWT.NONE);
		label0_0.setText("Variable:");
		label0_0.setLayoutData(data);
		
		Label label0_1 = new Label(dialogArea, SWT.NONE);
		label0_1.setText(varName);
		label0_1.setLayoutData(data);
		
		Label label1_0 = new Label(dialogArea, SWT.NONE);
		label1_0.setText("Time Step:");
		label1_0.setLayoutData(data);
		
		Label label1_1 = new Label(dialogArea, SWT.NONE);
		final String itemText0=item.getText(0);
		label1_1.setText(itemText0);
		label1_1.setLayoutData(data);
		
		Label label2_0 = new Label(dialogArea, SWT.NONE);
		label2_0.setText("Date:");
		label2_0.setLayoutData(data);
		
		Label label2_1 = new Label(dialogArea, SWT.NONE);
		final String itemText1=item.getText(1);
		label2_1.setText(itemText1);
		label2_1.setLayoutData(data);
		
		Label label3 = new Label(dialogArea, SWT.NONE);
		label3.setText("Value:");
		label3.setLayoutData(data);
		
		final Text text=new Text(dialogArea, SWT.BORDER);
		text.setText(item.getText(2));
		text.setLayoutData(data);
		
		Button ok = new Button(dialogArea, SWT.PUSH);
		ok.setText("OK");
		ok.setLayoutData(data);
		ok.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				input=text.getText();
				ArrayList<String[]> timeSeries=DebugCorePlugin.varDetailTimeseries;
				String[] rowItem=timeSeries.get(row);
				try {
					String data=DebugCorePlugin.target.sendRequest("modify_timeseries:"+varName+"#"+rowItem[0]+"#"+input);
					if (data.equals("modified")){
						rowItem[col]=input;
						final IWorkbench workbench=PlatformUI.getWorkbench();
						workbench.getDisplay().asyncExec(new Runnable(){
							public void run(){
								WPPVarDetailView varDetailView = (WPPVarDetailView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_VARIABLEDETAIL_VIEW);
								varDetailView.displayTimeseries();
							}
						});
					}
				} catch (DebugException e) {
					WPPException.handleException(e);
				}
				close();
			}
		});
		
		Button cancel = new Button(dialogArea, SWT.PUSH);
		cancel.setText("Cancel");
		cancel.setLayoutData(data);
		cancel.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				close();
			}
		});
		
		return dialogArea;
	 }
}
