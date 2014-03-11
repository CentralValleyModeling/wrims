package gov.ca.dwr.hecdssvue.views;

import gov.ca.dwr.hecdssvue.Activator;
import hec.dataTable.HecDataTable;
import hec.heclib.dss.HecDss;
import hec.io.DataContainer;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JScrollPane;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.DataProcess;

public class DSSFileView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "gov.ca.dwr.hecdssvue.views.DSSFileView";
	
	private Button[] checkBox=new Button[4];
	private Text[] dvFileText=new Text[4];
	private Button[] dvBrowserButton=new Button[4];
	private Text[] svFileText=new Text[4];
	private Button[] svBrowserButton=new Button[4];
	private Button okButton;
	private String unavailableFiles="";
	private String unavailableFolders="";
	private String errorFiles="";

	
	/**
	 * The constructor.
	 */
	public DSSFileView() {
	}


	public void createPartControl(Composite parent) {

		Composite dialogArea = new Composite(parent, SWT.NONE);
		FillLayout fl = new FillLayout(SWT.VERTICAL);
		dialogArea.setLayout(fl);
		fl.marginWidth=10;
		fl.marginHeight=15;
		
		Composite title = new Composite(dialogArea, SWT.NONE);
		title.setLayout(new GridLayout(37, true));
		Label labelTitle = new Label(title, SWT.NONE);
		labelTitle.setText("Please select DV and SV files for alternatives");
		okButton = new Button(title, SWT.PUSH);
		okButton.setText("OK");
		okButton.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
				selectFiles();
				if (DebugCorePlugin.selectedStudies[0] || DebugCorePlugin.selectedStudies[1] || DebugCorePlugin.selectedStudies[2] || DebugCorePlugin.selectedStudies[3]){
					if (checkFilesExist()){
						boolean success=openDssFiles();
						if (success){
////							close();
////							processViews();
						}else{
							showDssFileErrorDialog(1);
						}
						ArrayList<HecDss> dssArray = new ArrayList<HecDss> ();
//						dssArray.add(DebugCorePlugin.dvDss[0]);
//						dssArray.add(DebugCorePlugin.svDss[0]);
//						for (int i = 0; i <DebugCorePlugin.dvDss.length; i++){
//							dssArray.add(DebugCorePlugin.dvDss[i]);
//							dssArray.add(DebugCorePlugin.svDss[i]);
//						}
						for (int i = 0; i <DebugCorePlugin.selectedStudies.length/2;i++){
							if (DebugCorePlugin.selectedStudies[i]==true){
								dssArray.add(DebugCorePlugin.dvDss[i]);
								dssArray.add(DebugCorePlugin.svDss[i]);
							}
						}
						try {
							DSSCatalogView dcv = (DSSCatalogView) getSite().getWorkbenchWindow()
                                                .getActivePage().showView(DSSCatalogView.ID);
							try {
								dcv.getViewer().setInput(dssArray);
//								dcv.setInput(dssArray);
//								dcv.updateData();
							} catch (Exception ex) {
								Status status = new Status(IStatus.ERROR,
								                Activator.PLUGIN_ID,
								                "Error opening dss file: ", ex);
								StatusManager.getManager().handle(status,
										StatusManager.LOG);
							}
						} catch (PartInitException e1) {
							e1.printStackTrace();
						}
						// put in Catalog View
					}else{
						showDssFileErrorDialog(0);
					}
				}else{
//					if (checkFoldersExist()){
////						close();
//						processViews();
//					}else{
//						showDssFileErrorDialog(2);
//					}
				}
		    }
		});
		
		Composite[] fileSelection = new Composite[4];
		for (int i=0; i<4; i++){
			final int j=i;
			fileSelection[i] = new Composite(dialogArea, SWT.NONE);
			GridLayout layout = new GridLayout(37, true);
			fileSelection[i].setLayout(layout);
			
			checkBox[i]=new Button(fileSelection[i], SWT.CHECK);
			checkBox[i].setText("Alt "+(i+1));
			checkBox[i].setSelection(DebugCorePlugin.selectedStudies[i]);
			GridData gd0 = new GridData(GridData.FILL_HORIZONTAL);
			gd0.horizontalSpan = 9;//TODO
			checkBox[i].setLayoutData(gd0);
//			/*
//			checkBox[i].addSelectionListener(new SelectionAdapter() {
//				@Override
//				public void widgetSelected(SelectionEvent e) {
//					for (int j=4; j<8; j++){//TODO
////					for (int j=0; j<4; j++){
//						checkBox[j].setSelection(false);
//						DebugCorePlugin.selectedStudies[j]=false;
//					}
//				}
//			});
//			*/
			
			dvFileText[i] = new Text(fileSelection[i], SWT.SINGLE | SWT.BORDER);
			GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
			gd1.horizontalSpan = 8;
			dvFileText[i].setLayoutData(gd1);
			dvFileText[i].setText(DebugCorePlugin.studyDvFileNames[i]);
		
			dvBrowserButton[i] = new Button(fileSelection[i], SWT.PUSH);
			dvBrowserButton[i].setText("DV");
			GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
			gd2.horizontalSpan = 5;
			dvBrowserButton[i].setLayoutData(gd2);
			dvBrowserButton[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					final IWorkbench workbench=PlatformUI.getWorkbench();
					workbench.getDisplay().asyncExec(new Runnable(){
						public void run(){
							Shell shell=workbench.getActiveWorkbenchWindow().getShell();
							FileDialog dlg=new FileDialog(shell, SWT.OPEN);
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
			gd1.horizontalSpan = 8;
			svFileText[i].setLayoutData(gd1);
			svFileText[i].setText(DebugCorePlugin.studySvFileNames[i]);
		
			svBrowserButton[i] = new Button(fileSelection[i], SWT.PUSH);
			svBrowserButton[i].setText("SV");
			gd2 = new GridData(GridData.FILL_HORIZONTAL);
			gd2.horizontalSpan = 5;
			svBrowserButton[i].setLayoutData(gd2);
			svBrowserButton[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					final IWorkbench workbench=PlatformUI.getWorkbench();
					workbench.getDisplay().asyncExec(new Runnable(){
						public void run(){
							Shell shell=workbench.getActiveWorkbenchWindow().getShell();
							FileDialog dlg=new FileDialog(shell, SWT.OPEN);
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
//				case 2:
//					messageBox.setMessage("Study folders "+unavailableFolders+" do not exist.");
//					break;
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
	
	
	public boolean checkFoldersExist(){
		unavailableFolders="";
		boolean allFolderFound=true;
		for (int i=4; i<8; i++){
			int j=i-4;
			if (DebugCorePlugin.selectedStudies[i]){
				File folder = new File(DebugCorePlugin.studyFolderNames[j]);
				if (!folder.exists()){
					unavailableFolders=unavailableFolders+DebugCorePlugin.studyFolderNames[j]+",";
					allFolderFound=false;
				}
			}		
		}
		if (unavailableFolders.endsWith(",")){
			unavailableFolders=unavailableFolders.substring(0, unavailableFolders.length()-1);
		}
		return allFolderFound;
	}
	
	
	public boolean openDssFiles(){
		errorFiles="";
		boolean success=true;
		for (int i=0; i<4; i++){
			if (DebugCorePlugin.selectedStudies[i]){
				try {
//					HecDss dss =HecDss.open(DebugCorePlugin.studyDvFileNames[i]);
//					DebugCorePlugin.dvDss[i] = dss;
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
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
//		contentPane.requestFocus();
	}


}
