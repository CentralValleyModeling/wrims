package wrimsv2_plugin.debugger.dialog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2.components.IncFileCollector;
import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;

public class WPPExportStudyDialog extends Dialog {
	private String selFilePath;
	private Text targetText;
	private String targetFolder;
	private IFile selFile;
	
	public WPPExportStudyDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	public void open(String selFilePath, IFile ifile){
		this.selFilePath=selFilePath;
		this.selFile=ifile;
		create();
		getShell().setSize(600, 200);
		getShell().setText("Export Study");
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
		label1.setText("Please select a folder to export the study to:");
				
		Composite fileSelection = new Composite(dialogArea, SWT.NONE);
		GridLayout layout = new GridLayout(15, true);
		fileSelection.setLayout(layout);
		targetText = new Text(fileSelection, SWT.SINGLE | SWT.BORDER);
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 12;
		targetText.setLayoutData(gd1);
		targetText.setText("");
		
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
						DirectoryDialog dlg =new DirectoryDialog(getShell(),SWT.OPEN);
						targetText.setText(dlg.open());
					}
				});
			}
		});
		
		return dialogArea;
	}
	
	@Override
	public void okPressed(){
		targetFolder=targetText.getText();
		if (selFilePath.toLowerCase().endsWith(".wresl")){
			procMainFile();
		}else if (selFilePath.toLowerCase().endsWith(".launch")){
			procLaunchFile();
		}
		close();
	}
	
	protected void procMainFile(){
		new IncFileCollector(selFilePath, targetFolder);
		collectExternalFiles(selFilePath, targetFolder);
	}
	
	protected void procLaunchFile(){

        // check for an existing launch config for the WPP file
        String path = selFile.getFullPath().toString(); 
        ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
        ILaunchConfigurationType type = launchManager.getLaunchConfigurationType(DebugCorePlugin.ID_WPP_LAUNCH_CONFIGURATION_TYPE);
        ILaunchConfiguration[] configurations;
		try {
			configurations = launchManager.getLaunchConfigurations(type);
			
			for (int j = 0; j < configurations.length; j++) {
				ILaunchConfiguration configuration = configurations[j];
				String configPath=configuration.getFile().getFullPath().toString();
								
				if (path.equals(configPath)) {
					String msr = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_MULTISTUDY, "1");
					int msv = Integer.parseInt(msr);
			
					String sid="";
					for (int i=1; i<=msv; i++){
						if (i>1){
							sid="_MS"+String.valueOf(i);
						}
						
						collectModelFiles(configuration, sid);
						collectDSSFiles(configuration, sid, 0);
						collectDSSFiles(configuration, sid, 1);
						collectDSSFiles(configuration, sid, 2);
						
						
					}
				}
            }
		} catch (Exception e) {
			WPPException.handleException(e);
		}
		
		collectLaunchFile(selFilePath, targetFolder);
	}
	
	protected void collectDSSFiles(ILaunchConfiguration configuration, String sid, int flag) {
		String dssFile=null;
		try{
			if (flag==0){
				dssFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_SVARFILE+sid, (String)null);
			}else if (flag==1){
				dssFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_INITFILE+sid, (String)null);
			}else{
				dssFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_DVARFILE+sid, (String)null);
			}
		}catch (CoreException e){
		}
		
		if (dssFile !=null){
			if (!new File(dssFile).isAbsolute()){
				dssFile = procRelativePath(dssFile, selFile);
			}
			int index = dssFile.indexOf(":");
			String dssFilePathWithoutDrive = dssFile.substring(index+1);
			
			File targetPath = new File(targetFolder,dssFilePathWithoutDrive);
			try {
				FileUtils.copyFile(new File(dssFile), targetPath);
			} catch (IOException e) {
			}
		}
	}	
	
	protected void collectModelFiles(ILaunchConfiguration configuration, String sid){
		String mainFile=null;
		try {
			mainFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM+sid, (String)null);
		} catch (CoreException e) {
		}
		if (mainFile !=null){
			if (!new File(mainFile).isAbsolute()){
				mainFile = procRelativePath(mainFile, selFile);
			}
			new IncFileCollector(mainFile, targetFolder);
			collectExternalFiles(mainFile, targetFolder);
		}
	}
	
	public void collectExternalFiles(String mainFile, String targetFolder) {
		int index1 = mainFile.lastIndexOf("\\");
		String mainDirectory = mainFile.substring(0, index1 + 1);
		String externalDirectory=mainDirectory+"external";
		int index2 = externalDirectory.indexOf(":");
		String externalDirectoryWithoutDrive = externalDirectory.substring(index2+1);
		try {
			FileUtils.copyDirectory(new File(externalDirectory), new File(targetFolder, externalDirectoryWithoutDrive));
		} catch (IOException e) {
		}
	}
	
	public void collectLaunchFile(String launchFile, String targetFolder){
		int index = launchFile.indexOf(":");
		String launchFilePathWithoutDrive = launchFile.substring(index+1);
		File targetPath = new File(targetFolder,launchFilePathWithoutDrive);
		try {
			FileUtils.copyFile(new File(launchFile), targetPath);
		} catch (IOException e) {
		}
	}
	
	public String procRelativePath(String path, IFile file){
		String absPath=file.getLocation().toFile().getParentFile().getAbsolutePath();
		absPath=absPath+"\\"+path;
		return absPath;
	}
}
