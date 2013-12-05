package wrimsv2_plugin.debugger.dialog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.goal.FilterGoal;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;
import wrimsv2_plugin.debugger.view.WPPAllGoalView;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;

public class WPPFilterGoalsDialog extends Dialog {
	private Text fileText;
	private Text filterText;
	private String filterName="";
	private boolean doFilter=false;
	
	public WPPFilterGoalsDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	public void openDialog(){
		create();
		getShell().setSize(600, 240);
		getShell().setText("Filter Goals");
		open();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		FillLayout fl = new FillLayout(SWT.VERTICAL);
		dialogArea.setLayout(fl);
		fl.marginWidth=10;
		fl.marginHeight=15;
		
		GridLayout layout = new GridLayout(15, true);
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 12;
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 3;
		
		Label label3=new Label(dialogArea, SWT.NONE);
		label3.setText("Optional goals filter:");
		filterName=DebugCorePlugin.filterFileName;
		
		Composite filterSelection = new Composite(dialogArea, SWT.NONE);
		filterSelection.setLayout(layout);
		filterText = new Text(filterSelection, SWT.SINGLE | SWT.BORDER);
		filterText.setLayoutData(gd1);
		filterText.setText(filterName);
		
		Button filterButton = new Button(filterSelection, SWT.PUSH);
		filterButton.setText("Browser");
		filterButton.setLayoutData(gd2);
		filterButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						FileDialog dlg=new FileDialog(shell, SWT.OPEN);
						dlg.setFilterNames(new String[]{"Filter Files (*.flt)", "All Files (*.*)"});
						dlg.setFilterExtensions(new String[]{"*.flt", "*.*"});
						dlg.setFileName(filterText.getText());
						String file=dlg.open();
						if (file !=null){
							filterText.setText(file);
						}else{
							filterText.setText("");
						}
					}
				});
			}
		});
		
		return dialogArea;
	}
	
	@Override
	public void okPressed(){
		procFilterFile();
		if (doFilter){
			close();
		}else{
			showWarningMessage(1);
		}
	}
	
	public void procFilterFile(){
		final Map<String, FilterGoal> filterGoals=new HashMap<String, FilterGoal>();
		final ArrayList<String> filterGoalNames=new ArrayList<String>();
		filterName=filterText.getText();
		DebugCorePlugin.filterFileName=filterName;
		File filterFile=new File(filterName);
		if (filterFile.exists()){
			doFilter=true;
			try {
				FileReader fr = new FileReader(filterFile);
				BufferedReader br = new BufferedReader(fr);
				String line = br.readLine();
				if (line != null){
					while ((line = br.readLine()) != null) {
						line=line.trim().toLowerCase();
						String[] filterParts=line.split(",");
						int length=filterParts.length;
						FilterGoal fg=new FilterGoal();
						if (length==3){
							fg.setAlias(filterParts[1]);
							fg.setTolerance(filterParts[2]);
						}else if (length==2){
							fg.setAlias(filterParts[1]);
						}
						filterGoals.put(filterParts[0], fg);
						filterGoalNames.add(filterParts[0]);
					}
				}
				fr.close();
				
				WPPDebugTarget target = DebugCorePlugin.target;
				if (target !=null && target.isSuspended()){
					target.sendRequest("filtergoal:"+filterName);
					displayFilterGoals(filterGoalNames, filterGoals);
				}else{
					showWarningMessage(0);
				}
			} catch (Exception e) {
				WPPException.handleException(e);
			}
		}else{
			doFilter=false;
		}
	}
	
	public void displayFilterGoals(final ArrayList<String> filterGoalNames, final Map<String, FilterGoal> filterGoals){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				Shell shell=workbench.getActiveWorkbenchWindow().getShell();
				WPPDisplayFilterGoalsDialog dialog= new WPPDisplayFilterGoalsDialog(shell, filterGoalNames, filterGoals);
				dialog.openDialog();
			}
		});
	}
	
	public void showWarningMessage(final int flag){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				Shell shell=workbench.getActiveWorkbenchWindow().getShell();
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
				messageBox.setText("Warning:");
				switch (flag){
					case 0:
						messageBox.setMessage("Please pause the model to filter the goals");
						break;
					case 1:
						messageBox.setMessage("Please select correct filter file.");
						break;
				}
				messageBox.open();
			}
		});
	}
}
