package wrimsv2_plugin.debugger.view;

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

public class WPPCycleDialog extends PopupDialog {

	private TableItem item;
	private Table table;
	private String varName;
	private String input;
	
	public WPPCycleDialog(Shell parent, int shellStyle,
			boolean takeFocusOnOpen, boolean persistSize,
			boolean persistLocation, boolean showDialogMenu,
			boolean showPersistActions, String titleText, String infoText) {
		super(parent, shellStyle, takeFocusOnOpen, persistSize, persistLocation,
				showDialogMenu, showPersistActions, titleText, infoText);
		// TODO Auto-generated constructor stub
	}

	public void open(TableItem item, Table table, String varName){
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
		label1_0.setText("Cycle Index:");
		label1_0.setLayoutData(data);
		
		Label label1_1 = new Label(dialogArea, SWT.NONE);
		final String itemText0=item.getText(0);
		label1_1.setText(itemText0);
		label1_1.setLayoutData(data);
		
		Label label2_0 = new Label(dialogArea, SWT.NONE);
		label2_0.setText("Cycle Name:");
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
				String[] itemStrings=new String[3];
				itemStrings[0]=itemText0;
				itemStrings[1]=itemText1;
				itemStrings[2]=input;
				item.setText(itemStrings);
				table.update();
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
