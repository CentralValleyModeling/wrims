package wrimsv2_plugin.debugger.dialog;

import hec.heclib.dss.HecDss;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.view.WPPAllGoalView;
import wrimsv2_plugin.debugger.view.WPPAllVariableView;
import wrimsv2_plugin.debugger.view.WPPGoalView;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;
import wrimsv2_plugin.debugger.view.WPPVariableView;
import wrimsv2_plugin.debugger.view.WPPWatchView;

public class WPPLoadStudyDssDialog extends Dialog {
	private Button[] checkBox;
	private Text[] dvFileText=new Text[4];
	private Button[] dvBrowserButton=new Button[4];
	private Text[] svFileText=new Text[4];
	private Button[] svBrowserButton=new Button[4];
	private String unavailableFiles="";
	private String errorFiles="";
	
	public WPPLoadStudyDssDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	public void openDialog(){
		create();
		getShell().setSize(900, 330);
		getShell().setText("Load Alt DV/SV");
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
		label1.setText("Please select DV and SV file for alternative studies");
		
		Composite[] fileSelection = new Composite[4];
		checkBox = new Button[4];
		
		for (int i=0; i<4; i++){
			final int j=i;
			fileSelection[i] = new Composite(dialogArea, SWT.NONE);
			GridLayout layout = new GridLayout(37, true);
			fileSelection[i].setLayout(layout);
			
			checkBox[i]=new Button(fileSelection[i], SWT.CHECK);
			checkBox[i].setText("Alt "+(i+1)+":");
			checkBox[i].setSelection(DebugCorePlugin.selectedStudies[i]);
			GridData gd0 = new GridData(GridData.FILL_HORIZONTAL);
			gd0.horizontalSpan = 3;
			checkBox[i].setLayoutData(gd0);
			
			dvFileText[i] = new Text(fileSelection[i], SWT.SINGLE | SWT.BORDER);
			GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
			gd1.horizontalSpan = 13;
			dvFileText[i].setLayoutData(gd1);
			dvFileText[i].setText(DebugCorePlugin.studyDvFileNames[i]);
		
			dvBrowserButton[i] = new Button(fileSelection[i], SWT.PUSH);
			dvBrowserButton[i].setText("Browser DV");
			GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
			gd2.horizontalSpan = 4;
			dvBrowserButton[i].setLayoutData(gd2);
			dvBrowserButton[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					final IWorkbench workbench=PlatformUI.getWorkbench();
					workbench.getDisplay().asyncExec(new Runnable(){
						public void run(){
							Shell shell=workbench.getActiveWorkbenchWindow().getShell();
							FileDialog dlg=new FileDialog(shell, SWT.SAVE);
							dlg.setFilterNames(new String[]{"DSS Files (*.dss)", "All Files (*.*)"});
							dlg.setFilterExtensions(new String[]{"*.dss", "*.*"});
							dlg.setFileName(dvFileText[j].getText());
							String file=dlg.open();
							if (file !=null){
								dvFileText[j].setText(file);
							}
						}
					});
				}
			});
			
			svFileText[i] = new Text(fileSelection[i], SWT.SINGLE | SWT.BORDER);
			gd1 = new GridData(GridData.FILL_HORIZONTAL);
			gd1.horizontalSpan = 13;
			svFileText[i].setLayoutData(gd1);
			svFileText[i].setText(DebugCorePlugin.studySvFileNames[i]);
		
			svBrowserButton[i] = new Button(fileSelection[i], SWT.PUSH);
			svBrowserButton[i].setText("Browser SV");
			gd2 = new GridData(GridData.FILL_HORIZONTAL);
			gd2.horizontalSpan = 4;
			svBrowserButton[i].setLayoutData(gd2);
			svBrowserButton[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					final IWorkbench workbench=PlatformUI.getWorkbench();
					workbench.getDisplay().asyncExec(new Runnable(){
						public void run(){
							Shell shell=workbench.getActiveWorkbenchWindow().getShell();
							FileDialog dlg=new FileDialog(shell, SWT.SAVE);
							dlg.setFilterNames(new String[]{"DSS Files (*.dss)", "All Files (*.*)"});
							dlg.setFilterExtensions(new String[]{"*.dss", "*.*"});
							dlg.setFileName(svFileText[j].getText());
							String file=dlg.open();
							if (file !=null){
								svFileText[j].setText(file);
							}
						}
					});
				}
			});
		}
		
		return dialogArea;
	}
	
	@Override
	public void okPressed(){
		selectFiles();
		if (checkFilesExist()){
			if (openDssFiles()){
				close();
				processViews();
			}else{
				showDssFileErrorDialog(1);
			}
		}else{
			showDssFileErrorDialog(0);
		}
	}
	
	public void selectFiles(){
		for (int i=0; i<4; i++){
			if (checkBox[i].getSelection()){
				DebugCorePlugin.selectedStudies[i]=true;
			}else{
				DebugCorePlugin.selectedStudies[i]=false;
			}
			DebugCorePlugin.studyDvFileNames[i]=dvFileText[i].getText();
			DebugCorePlugin.studySvFileNames[i]=svFileText[i].getText();
		}
	}
	
	public void showDssFileErrorDialog(final int flag){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				Shell shell=workbench.getActiveWorkbenchWindow().getShell();
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
				messageBox.setText("Error:");
				switch (flag){
				case 0:
					messageBox.setMessage("Files "+unavailableFiles+" do not exist.");
					break;
				case 1:
					messageBox.setMessage("Dss files "+errorFiles+" could not be opened.");
					break;
				}
				messageBox.open();
			}
		});
	}
	
	public boolean checkFilesExist(){
		unavailableFiles="";
		boolean allFileFound=true;
		for (int i=0; i<4; i++){
			if (DebugCorePlugin.selectedStudies[i]){
				File dvFile = new File(DebugCorePlugin.studyDvFileNames[i]);
				if (!dvFile.exists()){
					unavailableFiles=unavailableFiles+DebugCorePlugin.studyDvFileNames[i]+",";
					allFileFound=false;
				}
				File svFile = new File(DebugCorePlugin.studySvFileNames[i]);
				if (!svFile.exists()){
					unavailableFiles=unavailableFiles+DebugCorePlugin.studySvFileNames[i]+",";
					allFileFound=false;
				}
			}		
		}
		if (unavailableFiles.endsWith(",")){
			unavailableFiles=unavailableFiles.substring(0, unavailableFiles.length()-1);
		}
		return allFileFound;
	}
	
	public boolean openDssFiles(){
		errorFiles="";
		boolean success=true;
		for (int i=0; i<4; i++){
			if (DebugCorePlugin.selectedStudies[i]){
				try {
					DebugCorePlugin.dvDss[i]=HecDss.open(DebugCorePlugin.studyDvFileNames[i]);
					DebugCorePlugin.dvVector[i]=DebugCorePlugin.dvDss[i].getCatalogedPathnames();
				} catch (Exception e) {
					WPPException.handleException(e);
					errorFiles=errorFiles+DebugCorePlugin.studyDvFileNames[i]+",";
					success=false;
				}
				try {
					DebugCorePlugin.svDss[i]=HecDss.open(DebugCorePlugin.studySvFileNames[i]);
					DebugCorePlugin.svVector[i]=DebugCorePlugin.svDss[i].getCatalogedPathnames();
				} catch (Exception e) {
					WPPException.handleException(e);
					errorFiles=errorFiles+DebugCorePlugin.studySvFileNames[i]+",";
					success=false;
				}
			}
		}
		if (errorFiles.endsWith(",")){
			errorFiles=errorFiles.substring(0, errorFiles.length()-1);
		}
		return success;
	}
	
	public void processViews(){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){

			@Override
			public void run() {
				IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
				
				WPPVariableView variableView = (WPPVariableView) workBenchPage.findView(DebugCorePlugin.ID_WPP_VARIABLE_VIEW);
				WPPWatchView watchView = (WPPWatchView) workBenchPage.findView(DebugCorePlugin.ID_WPP_WATCH_VIEW);
				
				if (DebugCorePlugin.target!=null && DebugCorePlugin.target.isSuspended()){
					variableView.updateView();
					if (DebugCorePlugin.target.allVGLoadedViewNames.contains(DebugCorePlugin.TITLE_WATCH_VIEW)) watchView.updateView();
				}else{
					variableView.adjustAltColumnNames();
					watchView.adjustAltColumnNames();
				}
			}
		});
	}
}
