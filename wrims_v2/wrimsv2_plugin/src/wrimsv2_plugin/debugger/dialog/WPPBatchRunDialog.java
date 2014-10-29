package wrimsv2_plugin.debugger.dialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
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
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.batchrun.BatchRunProcess;
import wrimsv2_plugin.batchrun.LaunchConfigInfo;
import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;

public class WPPBatchRunDialog extends Dialog {
	private Text fileText;
	private	String fileName="";
	private Button addButton;
	private Button deleteButton;
	private Button startAllButton;
	private Button stopAllButton;
	private Button stopButton;
	private Button seqButton;
	private List brl;
	
	private boolean isSequential=false;
	
	private ArrayList<String> launchPathList=new ArrayList<String>();
	private ArrayList<String> launchNameList=new ArrayList<String>();
	private Map<String, LaunchConfigInfo> configMap = new HashMap<String, LaunchConfigInfo>();
	private Map<String, BatchRunProcess> brpMap = new HashMap<String, BatchRunProcess>();
	private Map<String, Boolean> brpIsToRunMap = new HashMap<String, Boolean>();
	
	public WPPBatchRunDialog(Shell parentShell) {
		super(parentShell, SWT.MIN);
		setText("Batch Run");
	}

	public void openDialog(){
		Shell shell=new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.setLocation(450, 300);
		shell.pack();
		shell.open();
	}

	protected void createContents(final Shell shell) {
		
		GridLayout gl = new GridLayout();
		gl.numColumns = 8;
		gl.makeColumnsEqualWidth = true;
		gl.marginWidth=10;
		gl.marginHeight=15;
		shell.setLayout(gl);
		
		brl=new List(shell, SWT.BORDER|SWT.MULTI|SWT.V_SCROLL|SWT.H_SCROLL);
		GridData gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 8;
		gd0.heightHint=brl.getItemHeight()*14;
		brl.setLayoutData(gd0);
		
		fileText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 5;
		fileText.setLayoutData(gd1);
		fileText.setText(fileName);
		
		Button browserButton = new Button(shell, SWT.PUSH);
		browserButton.setText("Browser");
		GridData gd2 = new GridData();
		gd2.horizontalSpan = 1;
		browserButton.setLayoutData(gd2);
		browserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						FileDialog dlg=new FileDialog(shell, SWT.OPEN);
						dlg.setFilterNames(new String[]{"Launch File (*.launch)", "All Files (*.*)"});
						dlg.setFilterExtensions(new String[]{"*.launch", "*.*"});
						dlg.setFileName(fileText.getText());
						String file=dlg.open();
						if (file !=null){
							fileText.setText(file);
						}
					}
				});
			}
		});
		
		addButton = new Button(shell, SWT.PUSH);
		addButton.setText("Add");
		GridData gd3 = new GridData();
		gd3.horizontalSpan = 1;
		addButton.setLayoutData(gd3);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						String lfp = fileText.getText().toLowerCase();
						if (!lfp.equals("") && !launchPathList.contains(lfp)){
							LaunchConfigInfo config = new LaunchConfigInfo(lfp);
							BatchRunProcess brp=new BatchRunProcess();
							int index1=lfp.lastIndexOf("\\");
							int index2=lfp.lastIndexOf(".");
							String lfn=lfp.substring(index1+1, index2);
							launchPathList.add(lfp);
							launchNameList.add(lfn);
							configMap.put(lfp, config);
							brpMap.put(lfp, brp);
							brl.add(lfn);
						}
					}
				});
			}
		});
		
		deleteButton = new Button(shell, SWT.PUSH);
		deleteButton.setText("Delete");
		GridData gd4 = new GridData();
		gd4.horizontalSpan = 1;
		deleteButton.setLayoutData(gd4);
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						int[] indices = brl.getSelectionIndices();
						for (int i=indices.length-1; i>=0; i--){
							String lfp=launchPathList.get(indices[i]);
							configMap.remove(lfp);
							brpMap.remove(lfp);
							launchNameList.remove(indices[i]);
							launchPathList.remove(indices[i]);
						}
						brl.remove(indices);	
					}
				});
			}
		});
		
		startAllButton = new Button(shell, SWT.PUSH);
		startAllButton.setText("Start All");
		GridData gd5 = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gd5.horizontalSpan = 2;
		startAllButton.setLayoutData(gd5);
		startAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						stopAllButton.setEnabled(true);
						stopButton.setEnabled(true);
						startAllButton.setEnabled(false);
						addButton.setEnabled(false);
						deleteButton.setEnabled(false);
						seqButton.setEnabled(false);
						startAllBatchRun();
					}
				});
			}
		});
		
		stopAllButton = new Button(shell, SWT.PUSH);
		stopAllButton.setText("Stop All");
		GridData gd6 = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gd6.horizontalSpan = 1;
		stopAllButton.setLayoutData(gd6);
		stopAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						stopAllButton.setEnabled(false);
						stopButton.setEnabled(false);
						startAllButton.setEnabled(true);
						addButton.setEnabled(true);
						deleteButton.setEnabled(true);
						seqButton.setEnabled(true);
						stopAllBatchRun();
					}
				});
			}
		});
		stopAllButton.setEnabled(false);
		
		stopButton = new Button(shell, SWT.PUSH);
		stopButton.setText("Stop");
		GridData gd7 = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gd7.horizontalSpan = 1;
		stopButton.setLayoutData(gd7);
		stopButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						stopBatchRuns();
					}
				});
			}
		});
		stopButton.setEnabled(false);
		
		seqButton = new Button(shell, SWT.CHECK);
		seqButton.setText("Sequential");
		GridData gd8 = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gd8.horizontalSpan = 4;
		seqButton.setLayoutData(gd8);
		seqButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						isSequential=!isSequential;
					}
				});
			}
		});

	}
	
	
	protected void startAllBatchRun(){
		
		emptyProgressFiles();
		clearBatchRunList();
		
		for (int i=0; i<launchPathList.size(); i++){
			String lfp=launchPathList.get(i);
			brpIsToRunMap.put(lfp,  true);							
		}
		
		checkProgress();
		
		if (isSequential){
			sequentialRun();
		}else{
			parallelRun();
		}
	}
	
	protected void sequentialRun(){
		
		Runnable runnable = new Runnable(){
			
			public void run(){
				try {
					for (int i=0; i<launchPathList.size(); i++){
						String lfp=launchPathList.get(i);
						if (configMap.containsKey(lfp) && brpMap.containsKey(lfp) && brpIsToRunMap.containsKey(lfp)){
							LaunchConfigInfo config = configMap.get(lfp);
							BatchRunProcess brp = brpMap.get(lfp);
							if (brpIsToRunMap.get(lfp)) {
								brpIsToRunMap.put(lfp, false);
								brp.launch(config, lfp);									
							}
						}
					}
				} catch (CoreException e) {
					WPPException.handleException(e);
				}
			}
		};
		
		new Thread(runnable).start();
	}
	
	protected void parallelRun(){
		for (int i=0; i<launchPathList.size(); i++){
			final String lfp=launchPathList.get(i);
			if (configMap.containsKey(lfp) && brpMap.containsKey(lfp) && brpIsToRunMap.containsKey(lfp)){
				final LaunchConfigInfo config = configMap.get(lfp);
				final BatchRunProcess brp = brpMap.get(lfp);
				
				Runnable runnable = new Runnable(){
					
					public void run(){
						try {
							if (brpIsToRunMap.get(lfp)) {
								brpIsToRunMap.put(lfp, false);
								brp.launch(config, lfp);
							}
						} catch (CoreException e) {
							WPPException.handleException(e);
						}
					}
				};
				
				new Thread(runnable).start();
			}
		}
	}
	
	protected void stopAllBatchRun(){
		for (int i=0; i<launchPathList.size(); i++){
			String lfp=launchPathList.get(i);
			if (brpMap.containsKey(lfp)){
				BatchRunProcess brp = brpMap.get(lfp);
				brp.terminate(lfp+".bat");									
			}
			brpIsToRunMap.put(lfp, false);
		}
	}
	
	protected void stopBatchRuns(){
		int[] indices = brl.getSelectionIndices();
		for (int i=0; i<indices.length; i++){
			String lfp=launchPathList.get(indices[i]);
			if (brpMap.containsKey(lfp)){
				BatchRunProcess brp = brpMap.get(lfp);
				brp.terminate(lfp+".bat");									
			}
			brpIsToRunMap.put(lfp, false);
		}
	}
	
	public void checkProgress(){
		
		Runnable runnable = new Runnable(){
			
			public void run(){
				
				boolean allComplete;
				
				do{
					allComplete=true;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						WPPException.handleException(e);
					}
					for (int i=0; i<launchPathList.size(); i++){
						String lfp=launchPathList.get(i);
						if (brpIsToRunMap.get(lfp)){
							allComplete=false;
						}else{
							BatchRunProcess brp = brpMap.get(lfp);
							if (brp.isRunning){
								allComplete=false;
							}
							File pf = new File(lfp+".config.prgss");
							try {
								BufferedReader br = new BufferedReader(new FileReader(pf));
								String line = br.readLine();
								if (line==null){
								}else if (line.startsWith("Run to ")){
									int index=line.indexOf("/");
									String sYear = line.substring(7, index);
									int percent = Math.round(100.0f*(Integer.parseInt(sYear)-brp.startYear)/(brp.endYear-brp.startYear));
									final String item=launchNameList.get(i)+" "+line+" "+percent + "% Done.";
									final int pi=i;
									IWorkbench workbench=PlatformUI.getWorkbench();
									workbench.getDisplay().asyncExec(new Runnable(){
										public void run(){
											brl.setItem(pi, item);
										}
									});
								}else{
									final String item=launchNameList.get(i)+" "+line;
									final int pi=i;
									IWorkbench workbench=PlatformUI.getWorkbench();
									workbench.getDisplay().asyncExec(new Runnable(){
										public void run(){
											brl.setItem(pi, item);
										}
									});
								}
							} catch (FileNotFoundException e) {
								WPPException.handleException(e);
							} catch (IOException e) {
								WPPException.handleException(e);
							}
						}
					}
				}while (!allComplete);
				
				IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						stopAllButton.setEnabled(false);
						stopButton.setEnabled(false);
						startAllButton.setEnabled(true);
						addButton.setEnabled(true);
						deleteButton.setEnabled(true);
						seqButton.setEnabled(true);
					}
				});
			}
		};
		
		new Thread(runnable).start();
		
	}
	
	public void emptyProgressFiles(){
		for (int i=0; i<launchPathList.size(); i++){
			FileWriter progressFile;
			try {
				progressFile = new FileWriter((launchPathList.get(i)+".config.prgss"));
				PrintWriter pw = new PrintWriter(progressFile);
				pw.println();
				pw.close();
			} catch (IOException e) {
				WPPException.handleException(e);
			}
		}
	}
	
	public void clearBatchRunList(){
		IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				for (int i=0; i<launchNameList.size(); i++){
					String lfn=launchNameList.get(i);
					brl.setItem(i, lfn);
				}
			}
		});
	}
}
