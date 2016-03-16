package gov.ca.dwr.jdiagram.dialog;

import gov.ca.dwr.jdiagram.SchematicPluginCore;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class AddTimeWindowDialog extends PopupDialog {
	//private DateCombo dateCombo;
	private Combo dateList;
	private static String[] _monthSelections = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
		"JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	
	private Text year1, year2;
	private Combo month1, month2;
	private String newTW="OCT1921 - SEP2009";
	
	public AddTimeWindowDialog(Shell parent, int shellStyle,
			boolean takeFocusOnOpen, boolean persistSize,
			boolean persistLocation, boolean showDialogMenu,
			boolean showPersistActions, String titleText, String infoText) {
		
		super(parent, shellStyle, takeFocusOnOpen, persistSize, persistLocation,
				showDialogMenu, showPersistActions, titleText, infoText);
		// TODO Auto-generated constructor stub
	}

	public void open(Combo dateList){
		this.dateList=dateList;
		create();
		getShell().setSize(400, 150);
		open();
	}

	@Override
	 protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		GridLayout layout=new GridLayout();
		layout.numColumns = 5;
		layout.makeColumnsEqualWidth = true;
		layout.marginWidth=20;
		layout.marginHeight=20;
		dialogArea.setLayout(layout);
		
		month1=new Combo(dialogArea, SWT.NONE);
		for (int i=0; i<_monthSelections.length; i++){
			month1.add(_monthSelections[i]);
		}
		month1.select(9);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		month1.setLayoutData(gd);
		
		year1= new Text(dialogArea, SWT.BORDER);
		year1.setToolTipText("Year");
		year1.setText("1921");
		year1.setLayoutData(gd);
		
		Label label1=new Label(dialogArea, SWT.NONE);
		label1.setText("To");
		label1.setLayoutData(gd);
		
		month2=new Combo(dialogArea, SWT.NONE);
		for (int i=0; i<_monthSelections.length; i++){
			month2.add(_monthSelections[i]);
		}
		month2.select(8);
		month2.setLayoutData(gd);
		
		year2= new Text(dialogArea, SWT.BORDER);
		year2.setToolTipText("Year");
		year2.setText("2009");
		year2.setLayoutData(gd);
		
		Button ok = new Button(dialogArea, SWT.PUSH);
		ok.setLayoutData(gd);
		ok.setText("OK");
		ok.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				int index=validateTW();
				if (index==SchematicPluginCore._twSelections.size()){
					dateList.add(newTW, index);
					dateList.select(index);
					SchematicPluginCore._twSelections.add(index, newTW);
					close();
				}else if (index>=0){
					dateList.select(index);
					close();
				}
			}
		});
		
		Button cancel = new Button(dialogArea, SWT.PUSH);
		cancel.setLayoutData(gd);
		cancel.setText("Cancel");
		cancel.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				close();
			}
		});
		
		dialogArea.getShell().setDefaultButton(ok);
		return dialogArea;
	}
	
	public int validateTW(){
		int startyear=Integer.parseInt(year1.getText());
		int endyear=Integer.parseInt(year2.getText());
		if (startyear>endyear){
			showWarning();
	        return -1;
		}else if (startyear==endyear && month1.getSelectionIndex()>month2.getSelectionIndex()){
			showWarning();
	        return -1;
		}else{
			newTW=month1.getText()+startyear+" - "+month2.getText()+endyear;
			int size=SchematicPluginCore._twSelections.size();
			int index=size;
			for (int i=0; i<index; i++){
				if (dateList.getItem(i).equals(newTW)){
					return i;
				}
			}
			return index;
		}
		
	}
	
	public void showWarning(){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				Shell shell=workbench.getActiveWorkbenchWindow().getShell();
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
				messageBox.setText("Warning");
				messageBox.setMessage("Start date should be earlier than ending date");
				messageBox.open();
			}
		});
	}
}
