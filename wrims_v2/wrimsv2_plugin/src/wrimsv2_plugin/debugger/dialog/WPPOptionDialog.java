package wrimsv2_plugin.debugger.dialog;


import org.eclipse.debug.core.DebugException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.internal.Workbench;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.core.SettingPref;
import wrimsv2_plugin.debugger.exception.WPPException;

public class WPPOptionDialog extends Dialog {
	
	protected Text textMemory;
	protected Combo solverCombo;
	protected Combo logCombo;
	protected Button buttonCycleDss;
	private Button buttonAllCycles;
	private Button buttonSelectedCycles;
	private Text textSelectedCycles;

	public WPPOptionDialog(Shell parent) {
		super(parent, SWT.MIN);
		setText("Option");
	}

	public void openDialog(){
		Shell shell=new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.setSize(450, 350);
		shell.setLocation(450, 300);
		//shell.pack();
		shell.open();
	}

	protected void createContents(final Shell shell) {
		GridLayout layout=new GridLayout(2, false);
		layout.marginWidth=20;
		layout.marginHeight=15;
		shell.setLayout(layout);
		
		GridData gridData=new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan=2;
		
		final TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);

	    TabItem generalTab = new TabItem(tabFolder, SWT.NULL);
	    generalTab.setText("General");
	    createGeneralTab(tabFolder, generalTab);
	    
	    TabItem cycleTab = new TabItem(tabFolder, SWT.NULL);
	    cycleTab.setText("Cycles");
	    createCycleTab(tabFolder, cycleTab);
	    
	    tabFolder.setSize(400, 300);
	    tabFolder.setLayoutData(gridData);
		
		gridData=new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan=1;
	    
		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");
		ok.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				DebugCorePlugin.xmx=textMemory.getText();
				DebugCorePlugin.solver=solverCombo.getText();
				DebugCorePlugin.log=logCombo.getText();
				DebugCorePlugin.outputCycleToDss=buttonCycleDss.getSelection();
				DebugCorePlugin.outputAllCycles=buttonAllCycles.getSelection();
				DebugCorePlugin.outputCycles="\'"+textSelectedCycles.getText()+"\'";
				SettingPref.save();
				if (DebugCorePlugin.isDebugging){
					try {
						DebugCorePlugin.target.sendRequest("solveroption:"+DebugCorePlugin.solver+":"+DebugCorePlugin.log);
						if (DebugCorePlugin.outputCycleToDss) {
							DebugCorePlugin.target.sendRequest("OutputCycleDataToDssOn");
						}else{
							DebugCorePlugin.target.sendRequest("OutputCycleDataToDssOff");
						}
					} catch (DebugException e) {
						WPPException.handleException(e);
					}
				}
				showSolverStatus();
				shell.close();
			}
		});
		ok.setLayoutData(gridData);
		
		Button cancel = new Button(shell, SWT.PUSH);
		cancel.setText("Cancel");
		cancel.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				shell.close();
			}
		});
		cancel.setLayoutData(gridData);
		
		shell.setDefaultButton(ok);
		shell.pack();
	}
	
	public void createGeneralTab(TabFolder tabFolder, TabItem generalTab){		
		
		Group group = new Group(tabFolder, SWT.NONE);
		
		GridLayout layout=new GridLayout(2, false);
		layout.marginWidth=20;
		layout.marginHeight=15;
		group.setLayout(layout);
		
		GridData gridData=new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan=1;
		
		Label label1 = new Label(group, SWT.NONE);
		label1.setText("Solver:");
		
		solverCombo = new Combo(group, SWT.BORDER);
		solverCombo.add("CBC");
		solverCombo.add("XA");
		//solverCombo.add("LPSolve");
		
		Label label2 =  new Label(group, SWT.NONE);
		label2.setText("Log:");
		
		logCombo = new Combo(group, SWT.SINGLE|SWT.BORDER);
		logCombo.add("None");
		logCombo.add("Log");
		
		if (DebugCorePlugin.solver.equals("CBC")){
			solverCombo.select(0);
		}else if (DebugCorePlugin.solver.equals("XA")){
			solverCombo.select(1);
		}else if (DebugCorePlugin.solver.equals("LPSolve")){
			solverCombo.select(2);
		}
		solverCombo.setLayoutData(gridData);
		
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
		logCombo.setLayoutData(gridData);
		
		Label label3 =  new Label(group, SWT.NONE);
		label3.setText("Allocated Memory (mb):");
		
		textMemory =  new Text(group, SWT.BORDER);
		textMemory.setText(DebugCorePlugin.xmx);
		textMemory.setLayoutData(gridData);
		
		Label label4 =  new Label(group, SWT.NONE);
		label4.setText("Output Cycle Data to DSS");
		
		buttonCycleDss =  new Button(group, SWT.CHECK);
		buttonCycleDss.setSelection(DebugCorePlugin.outputCycleToDss);
		buttonCycleDss.setLayoutData(gridData);
		
		generalTab.setControl(group);
	}
	
	public void createCycleTab(TabFolder tabFolder, TabItem cycleTab){		
		
		Group group = new Group(tabFolder, SWT.NONE);
		
		GridLayout layout=new GridLayout(2, false);
		layout.marginWidth=20;
		layout.marginHeight=25;
		group.setLayout(layout);
		
		GridData gridData=new GridData(GridData.BEGINNING);
		gridData.horizontalSpan=2;
		
		buttonAllCycles =  new Button(group, SWT.RADIO);
		buttonAllCycles.setText("All cycles");
		buttonAllCycles.setSelection(DebugCorePlugin.outputAllCycles);
		buttonAllCycles.setLayoutData(gridData);
		
		buttonSelectedCycles =  new Button(group, SWT.RADIO);
		buttonSelectedCycles.setText("Selected cycles");
		buttonSelectedCycles.setSelection(!DebugCorePlugin.outputAllCycles);
		buttonSelectedCycles.setLayoutData(gridData);
		
		GridData gridData1 = new GridData(GridData.FILL_HORIZONTAL);
		gridData1.horizontalSpan=2;
		
		textSelectedCycles = new Text (group, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL);
		textSelectedCycles.setText(DebugCorePlugin.outputCycles.replace("\'", ""));
		textSelectedCycles.setLayoutData(gridData1);
		
		Label labelSelectedCycles = new Label(group, SWT.NONE);
		labelSelectedCycles.setText("*Selected cycles to output, e.g. 1, 2, 4, 6, 10");
		labelSelectedCycles.setLayoutData(gridData);
		
		cycleTab.setControl(group);
	}
	
	public void showSolverStatus(){
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				String log="";
				if (!DebugCorePlugin.log.equalsIgnoreCase("NONE")){
					log=DebugCorePlugin.log;
				}
				String status=DebugCorePlugin.solver+"  "+log;
				
				IWorkbenchPage page = Workbench.getInstance().getActiveWorkbenchWindow().getActivePage();
				try {
					IViewPart console = page.showView( IConsoleConstants.ID_CONSOLE_VIEW );
					if (console != null){
						console.getViewSite().getActionBars().getStatusLineManager().setMessage(status);
					}
				} catch (PartInitException e) {
					WPPException.handleException(e);
				} 
			}
		});
	}
}
