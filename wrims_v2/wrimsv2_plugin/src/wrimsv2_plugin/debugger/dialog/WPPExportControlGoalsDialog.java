package wrimsv2_plugin.debugger.dialog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.view.WPPAllGoalView;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;

public class WPPExportControlGoalsDialog extends Dialog {
	private Text fileText;
	private	String fileName="";
	
	public WPPExportControlGoalsDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	public void openDialog(){
		create();
		getShell().setSize(600, 200);
		getShell().setText("Export Control Goals");
		open();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		FillLayout fl = new FillLayout(SWT.VERTICAL);
		dialogArea.setLayout(fl);
		fl.marginWidth=10;
		fl.marginHeight=15;
		
		Label label1=new Label(dialogArea, SWT.NONE);
		label1.setText("Please select a file to export the controlling goals:");
		fileName=DebugCorePlugin.controlGoalsFileName;
		
		Composite fileSelection = new Composite(dialogArea, SWT.NONE);
		GridLayout layout = new GridLayout(15, true);
		fileSelection.setLayout(layout);
		fileText = new Text(fileSelection, SWT.SINGLE | SWT.BORDER);
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 12;
		fileText.setLayoutData(gd1);
		fileText.setText(fileName);
		
		Button browserButton = new Button(fileSelection, SWT.PUSH);
		browserButton.setText("Browser");
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 3;
		browserButton.setLayoutData(gd2);
		browserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						FileDialog dlg=new FileDialog(shell, SWT.SAVE);
						dlg.setFilterNames(new String[]{"Data Files (*.dat)", "All Files (*.*)"});
						dlg.setFilterExtensions(new String[]{"*.dat", "*.*"});
						dlg.setFileName(fileText.getText());
						String file=dlg.open();
						if (file !=null){
							fileText.setText(file);
						}
					}
				});
			}
		});
		
		return dialogArea;
	}
	
	@Override
	public void okPressed(){
		fileName=fileText.getText();
		DebugCorePlugin.controlGoalsFileName=fileName;
		boolean exists = (new File(fileName)).exists();
		if (exists) {
			final IWorkbench workbench=PlatformUI.getWorkbench();
			workbench.getDisplay().asyncExec(new Runnable(){
				public void run(){
					Shell shell=workbench.getActiveWorkbenchWindow().getShell();
					boolean overwrite = MessageDialog.openConfirm(shell, "Overwrite Confirm", "Do you want to overwrite the file of "+fileName);
					if (overwrite){
						exportControlGoals();
					}
				}
			}); 
		} else {
			exportControlGoals();
		}
		close();
	}
	
	public void exportControlGoals(){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				WPPAllGoalView allGoalView = (WPPAllGoalView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_ALLGOAL_VIEW);
				Table table = ((TableViewer)allGoalView.getViewer()).getTable();
				int size = table.getItemCount();	
				
				File controlGoalsFile = new File(fileName);
				FileOutputStream controlGoalsStream;
				try {
					controlGoalsStream = new FileOutputStream(controlGoalsFile);
					OutputStreamWriter controlGoalsWriter = new OutputStreamWriter(controlGoalsStream);    
					BufferedWriter controlGoalsBuffer = new BufferedWriter(controlGoalsWriter);
					
					for (int i=0; i<size; i++){
						TableItem ti = table.getItem(i);
						String goalName=ti.getText(0);
						if (DebugCorePlugin.allControlGoals.contains(goalName)){
							String controlGoal=goalName+" : "+ti.getText(1)+System.getProperty("line.separator");
							controlGoalsBuffer.write(controlGoal);
						}
					}
					
					controlGoalsBuffer.close();
					
				} catch (FileNotFoundException e) {
					WPPException.handleException(e);
				} catch (IOException e) {
					WPPException.handleException(e);
				}
				
			}
		});
	}
}
