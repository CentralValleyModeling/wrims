package wrimsv2_plugin.debugger.launcher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.ProfileManager;
import org.eclipse.datatools.connectivity.drivers.jdbc.IJDBCConnectionProfileConstants;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.CBCSetting;
import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.dialog.WPPDssToSqlDialog;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.DataProcess;
import wrimsv2_plugin.tools.Encryption;
import wrimsv2_plugin.tools.FileProcess;
import wrimsv2_plugin.tools.TimeOperation;

public class WPPInfeasibilityTab extends AbstractLaunchConfigurationTab {

	private ILaunchConfiguration launchConfig;
	private String launchPath;
	private Button noSelButt;
	private Button selButt;
	private List list;
	private Button fileButt;
	private Button folderButt;
	private Button importButt;
	private Button deleteButt;
	private Button deleteAllButt;
	private Button insertFileButt;
	private Button insertFolderButt;
	private String prevFilterPath="";
	
	public WPPInfeasibilityTab(){
		
	}
	
	@Override
	public void createControl(Composite parent) {
		Font font = parent.getFont();
		
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout topLayout = new GridLayout();
		topLayout.verticalSpacing = 0;
		topLayout.numColumns = 8;
		comp.setLayout(topLayout);
		comp.setFont(font);
		
		createVerticalSpacer(comp, 3);
		
		Group group1 = new Group(comp, SWT.SHADOW_IN);
	    group1.setText("&Select WRESL files for Infeasibility Analysis:");
	    group1.setLayout(topLayout);
	    GridData gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 8;
		group1.setLayoutData(gd);
		
		noSelButt = new Button(group1, SWT.RADIO);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		noSelButt.setText("No");
		noSelButt.setLayoutData(gd);
		noSelButt.setFont(font);
		noSelButt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		selButt = new Button(group1, SWT.RADIO);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		selButt.setText("Yes");
		selButt.setLayoutData(gd);
		selButt.setFont(font);
		selButt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		list = new List(comp, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 8;
		gd.heightHint=200;
		list.setLayoutData(gd);
		//list.setSize(600, 400);

		importButt = new Button(comp, SWT.NONE);;
	    importButt.setText("Import");
		importButt.setFont(font);
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		importButt.setLayoutData(gd);
		
	    fileButt = new Button(comp, SWT.NONE);
	    fileButt.setText("Add Files");
		fileButt.setFont(font);
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		fileButt.setLayoutData(gd);
		fileButt.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN|SWT.MULTI);
				dialog.setFilterExtensions(new String [] {"*.wresl"});
				dialog.setFilterPath(prevFilterPath);
				dialog.open();
				String filterPath=dialog.getFilterPath();
				prevFilterPath=filterPath;
				String[] absPaths = dialog.getFileNames();
				for (int i=0; i<absPaths.length; i++){
					String absPath=filterPath+"\\"+absPaths[i];
					String relativePath="";
					if (!absPath.equals("")){
						relativePath=makeRelativePath(launchPath, absPath);
					}
					list.add(relativePath);
				}
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		folderButt = new Button(comp, SWT.NONE);;
	    folderButt.setText("Add Folder");
		folderButt.setFont(font);
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		folderButt.setLayoutData(gd);
		folderButt.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN|SWT.MULTI);
				dialog.setFilterPath(prevFilterPath);
				String absPath = dialog.open();
				prevFilterPath=dialog.getFilterPath();
				String relativePath="";
				if (absPath!=null && !absPath.equals("")){
					relativePath=makeRelativePath(launchPath, absPath);
				}
				list.add(relativePath);	
				updateLaunchConfigurationDialog();	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		insertFileButt = new Button(comp, SWT.NONE);
		insertFileButt.setText("Insert Files");
		insertFileButt.setFont(font);
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		insertFileButt.setLayoutData(gd);
		insertFileButt.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN|SWT.MULTI);
				dialog.setFilterExtensions(new String [] {"*.wresl"});
				dialog.setFilterPath(prevFilterPath);
				dialog.open();
				String filterPath=dialog.getFilterPath();
				prevFilterPath=filterPath;
				String[] absPaths = dialog.getFileNames();
				for (int i=0; i<absPaths.length; i++){
					String absPath=filterPath+"\\"+absPaths[i];
					String relativePath="";
					if (!absPath.equals("")){
						relativePath=makeRelativePath(launchPath, absPath);
					}
					int index=list.getSelectionIndex();
					if (index<0){
						index=0;
					}
					list.add(relativePath, index);
				}
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		insertFolderButt = new Button(comp, SWT.NONE);;
		insertFolderButt.setText("Insert Folder");
		insertFolderButt.setFont(font);
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		insertFolderButt.setLayoutData(gd);
		insertFolderButt.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN|SWT.MULTI);
				dialog.setFilterPath(prevFilterPath);
				String absPath = dialog.open();
				prevFilterPath = dialog.getFilterPath();
				String relativePath="";
				if (absPath!=null && !absPath.equals("")){
					relativePath=makeRelativePath(launchPath, absPath);
				}
				int index=list.getSelectionIndex();
				if (index<0){
					index=0;
				}
				list.add(relativePath, index);	
				updateLaunchConfigurationDialog();	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		deleteButt = new Button(comp, SWT.NONE);;
	    deleteButt.setText("Delete");
		deleteButt.setFont(font);
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		deleteButt.setLayoutData(gd); 
		deleteButt.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] sels=list.getSelectionIndices();
				list.remove(sels);
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		deleteAllButt = new Button(comp, SWT.NONE);;
	    deleteAllButt.setText("Delete All");
		deleteAllButt.setFont(font);
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		deleteAllButt.setLayoutData(gd);
		deleteAllButt.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				list.removeAll();
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		launchConfig=configuration;
		launchPath=launchConfig.getFile().getLocation().toFile().getAbsolutePath();
		
		try {
			String isSelFiles = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_IFSISSELFILE, "no");
			if (isSelFiles.equalsIgnoreCase("no")){
				noSelButt.setSelection(true);
			}else{
				selButt.setSelection(true);
			}
			
			list.removeAll();
			int numberSelFiles=configuration.getAttribute(DebugCorePlugin.ATTR_WPP_IFSNUMBERSELFILES, 0);
			for (int i=0; i<numberSelFiles; i++){
				String relativePath=configuration.getAttribute(DebugCorePlugin.ATTR_WPP_IFSSELFILENAME+i, "");
				list.add(relativePath);
			}
		} catch (CoreException e) {
			WPPException.handleException(e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if (noSelButt.getSelection()){
			configuration.setAttribute(DebugCorePlugin.ATTR_WPP_IFSISSELFILE, "no");
		}else{
			configuration.setAttribute(DebugCorePlugin.ATTR_WPP_IFSISSELFILE, "yes");
		}
		
		int numberSelFiles=list.getItemCount();
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_IFSNUMBERSELFILES, numberSelFiles);
		
		for (int i=0; i<numberSelFiles; i++){
			String relativePath=list.getItem(i);
			configuration.setAttribute(DebugCorePlugin.ATTR_WPP_IFSSELFILENAME+i, relativePath);			
		}
	}

	@Override
	public String getName() {
		return "Infeasibility";
	}
	
	public String procRelativePath(String path){
		String absPath=launchConfig.getFile().getLocation().toFile().getParentFile().getAbsolutePath();
		absPath=absPath+"\\"+path;
		return absPath;
	}
	
	public String makeRelativePath(String absolutePath, String relativeTo){

        String[] absoluteDirectories = absolutePath.split("\\\\");
        String[] relativeDirectories = relativeTo.split("\\\\");

        //Get the shortest of the two paths
        int length = absoluteDirectories.length < relativeDirectories.length ? absoluteDirectories.length : relativeDirectories.length;

        //Use to determine where in the loop we exited
        int lastCommonRoot = -1;
        int index;

        //Find common root
        for (index = 0; index < length; index++){
        	if (absoluteDirectories[index].equalsIgnoreCase(relativeDirectories[index])){
                lastCommonRoot = index;
        	}else{
                break;
        	}
		}

        //If we didn't find a common prefix then throw
        if (lastCommonRoot == -1){
        	return relativeTo;
        }

        //Build up the relative path
        StringBuilder relativePath = new StringBuilder();

        //Add on the ..
       for (index = lastCommonRoot + 1; index < absoluteDirectories.length-1; index++){
            if (absoluteDirectories[index].length() > 0){
            	relativePath.append("..\\");
            }
       }
       
       //Add on the folders
       for (index = lastCommonRoot + 1; index < relativeDirectories.length - 1; index++){
    	   	relativePath.append(relativeDirectories[index] + "\\");
       }
       relativePath.append(relativeDirectories[relativeDirectories.length - 1]);

       return relativePath.toString();
	}
}
