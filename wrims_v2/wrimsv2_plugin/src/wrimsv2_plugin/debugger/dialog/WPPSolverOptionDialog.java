package wrimsv2_plugin.debugger.dialog;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;

public class WPPSolverOptionDialog extends PopupDialog {
	
	public WPPSolverOptionDialog(Shell parent, int shellStyle,
			boolean takeFocusOnOpen, boolean persistSize,
			boolean persistLocation, boolean showDialogMenu,
			boolean showPersistActions, String titleText, String infoText) {
		super(parent, shellStyle, takeFocusOnOpen, persistSize, persistLocation,
				showDialogMenu, showPersistActions, titleText, infoText);
		// TODO Auto-generated constructor stub
	}

	public void open(int i){
		create();
		getShell().setSize(300, 170);
		open();
	}

	@Override
	 protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		GridLayout layout=new GridLayout(2, false);
		dialogArea.setLayout(layout);
		
		GridData gridData=new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan=1;
		
		Label label1 = new Label(dialogArea, SWT.NONE);
		label1.setText("Solver:");
		
		final Combo solverCombo = new Combo(dialogArea, SWT.BORDER);
		solverCombo.add("XA");
		solverCombo.add("LPSolve");
		
		Label label2 =  new Label(dialogArea, SWT.NONE);
		label2.setText("Log:");
		
		final Combo logCombo = new Combo(dialogArea, SWT.BORDER);
		logCombo.add("None");
		logCombo.add("Log");
		
		if (DebugCorePlugin.solver.equals("XA")){
			solverCombo.select(0);
		}else if (DebugCorePlugin.solver.equals("LPSolve")){
			solverCombo.select(1);
		}
		if (DebugCorePlugin.target==null){
			solverCombo.setEnabled(true);
			logCombo.setEnabled(true);
		}else if (DebugCorePlugin.target.isTerminated()){
			solverCombo.setEnabled(true);
			logCombo.setEnabled(true);
		}else if (DebugCorePlugin.target.isSuspended()){
			solverCombo.setEnabled(true);
			logCombo.setEnabled(true);
		}else{
			solverCombo.setEnabled(false);
			logCombo.setEnabled(false);
		}
		
		if (DebugCorePlugin.log.equals("None")){
			logCombo.select(0);
		}else if (DebugCorePlugin.log.equals("Log")){
			logCombo.select(1);
		}
		
		Button ok = new Button(dialogArea, SWT.PUSH);
		ok.setText("OK");
		ok.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				DebugCorePlugin.solver=solverCombo.getText();
				DebugCorePlugin.log=logCombo.getText();
				if (DebugCorePlugin.isDebugging){
					try {
						DebugCorePlugin.target.sendRequest("solveroption:"+DebugCorePlugin.solver+":"+DebugCorePlugin.log);
					} catch (DebugException e) {
						WPPException.handleException(e);
					}
				}
				close();
			}
		});
		
		Button cancel = new Button(dialogArea, SWT.PUSH);
		cancel.setText("Cancel");
		cancel.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				close();
			}
		});
		
		dialogArea.getShell().setDefaultButton(ok);
		return dialogArea;
	 }
}
