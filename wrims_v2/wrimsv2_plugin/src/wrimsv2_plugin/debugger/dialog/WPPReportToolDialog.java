package wrimsv2_plugin.debugger.dialog;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.reporttool.Report;



public class WPPReportToolDialog extends Dialog {
	
	private Text templateFileText;
	private Text baseFileText;
	private Text baseAliasText;
	private Text altFileText;
	private Text altAliasText;
	private Text noteText;
	private Text assumptionText;
	private Text modelerText;
	private Text fontSizeText;
	private Text reportFileText;

	public WPPReportToolDialog(Shell parentShell) {
		super(parentShell, SWT.MIN);
		setText("Report Tool");
	}

	public void openDialog(){
		Shell shell=new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.setLocation(500, 300);
		shell.pack();
		shell.open();
	}

	protected void createContents(final Shell shell) {
		
		GridLayout gl = new GridLayout();
		gl.numColumns = 9;
		gl.makeColumnsEqualWidth = true;
		gl.marginWidth=10;
		gl.marginHeight=15;
		shell.setLayout(gl);
		
		Label l1=new Label(shell, SWT.None);
		l1.setText("Report template file");
		GridData gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l1.setLayoutData(gd0);
		
		templateFileText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 6;
		templateFileText.setLayoutData(gd1);
		templateFileText.setText("");
		
		Button templateBrowserButton = new Button(shell, SWT.PUSH);
		templateBrowserButton.setText("Browser");
		GridData gd2 = new GridData();
		gd2.horizontalSpan = 1;
		templateBrowserButton.setLayoutData(gd2);
		templateBrowserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						FileDialog dlg=new FileDialog(shell, SWT.OPEN);
						dlg.setFilterNames(new String[]{"Template File (*.inp)", "All Files (*.*)"});
						dlg.setFilterExtensions(new String[]{"*.inp", "*.*"});
						dlg.setFileName(templateFileText.getText());
						String file=dlg.open();
						if (file !=null){
							templateFileText.setText(file);
						}
					}
				});
			}
		});
		
		Label l2=new Label(shell, SWT.None);
		l2.setText("DSS result file #1");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l2.setLayoutData(gd0);
		
		baseFileText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 6;
		baseFileText.setLayoutData(gd1);
		baseFileText.setText("");
		
		Button baseBrowserButton = new Button(shell, SWT.PUSH);
		baseBrowserButton.setText("Browser");
		gd2 = new GridData();
		gd2.horizontalSpan = 1;
		baseBrowserButton.setLayoutData(gd2);
		baseBrowserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						FileDialog dlg=new FileDialog(shell, SWT.OPEN);
						dlg.setFilterNames(new String[]{"Hec Dss File (*.dss)", "All Files (*.*)"});
						dlg.setFilterExtensions(new String[]{"*.dss", "*.*"});
						dlg.setFileName(baseFileText.getText());
						String file=dlg.open();
						if (file !=null){
							baseFileText.setText(file);
						}
					}
				});
			}
		});

		Label l3=new Label(shell, SWT.None);
		l3.setText("DSS result alias #1");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l3.setLayoutData(gd0);
		
		baseAliasText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 6;
		baseAliasText.setLayoutData(gd1);
		baseAliasText.setText("Base");
		
		Label l3a=new Label(shell, SWT.None);
		l3a.setText("");
		gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 1;
		l3a.setLayoutData(gd2);
		
		Label l4=new Label(shell, SWT.None);
		l4.setText("DSS result file #2");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l4.setLayoutData(gd0);
		
		altFileText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 6;
		altFileText.setLayoutData(gd1);
		altFileText.setText("");
		
		Button altBrowserButton = new Button(shell, SWT.PUSH);
		altBrowserButton.setText("Browser");
		gd2 = new GridData();
		gd2.horizontalSpan = 1;
		altBrowserButton.setLayoutData(gd2);
		altBrowserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						FileDialog dlg=new FileDialog(shell, SWT.OPEN);
						dlg.setFilterNames(new String[]{"Hec Dss File (*.dss)", "All Files (*.*)"});
						dlg.setFilterExtensions(new String[]{"*.dss", "*.*"});
						dlg.setFileName(altFileText.getText());
						String file=dlg.open();
						if (file !=null){
							altFileText.setText(file);
						}
					}
				});
			}
		});
		
		Label l5=new Label(shell, SWT.None);
		l5.setText("DSS result alias #2");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l5.setLayoutData(gd0);
		
		altAliasText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 6;
		altAliasText.setLayoutData(gd1);
		altAliasText.setText("Alt");
		
		Label l5a=new Label(shell, SWT.None);
		l5a.setText("");
		gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 1;
		l5a.setLayoutData(gd2);
		
		Label l6=new Label(shell, SWT.None);
		l6.setText("Report output file");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l6.setLayoutData(gd0);
		
		reportFileText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 6;
		reportFileText.setLayoutData(gd1);
		reportFileText.setText("");
		
		Button reportBrowserButton = new Button(shell, SWT.PUSH);
		reportBrowserButton.setText("Browser");
		gd2 = new GridData();
		gd2.horizontalSpan = 1;
		reportBrowserButton.setLayoutData(gd2);
		reportBrowserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						FileDialog dlg=new FileDialog(shell, SWT.SAVE);
						dlg.setFilterNames(new String[]{"Report Output File (*.pdf)", "All Files (*.*)"});
						dlg.setFilterExtensions(new String[]{"*.pdf", "*.*"});
						dlg.setFileName(reportFileText.getText());
						String file=dlg.open();
						if (file !=null){
							reportFileText.setText(file);
						}
					}
				});
			}
		});
		
		Label l7=new Label(shell, SWT.None);
		l7.setText("Notes");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 9;
		l7.setLayoutData(gd0);
		
		noteText=new Text(shell, SWT.MULTI|SWT.BORDER|SWT.V_SCROLL|SWT.H_SCROLL);
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 8;
		gd0.heightHint=100;
		noteText.setLayoutData(gd0);
		
		Label l8=new Label(shell, SWT.None);
		l8.setText("");
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 1;
		gd1.heightHint=100;
		l8.setLayoutData(gd1);
		
		Label l9=new Label(shell, SWT.None);
		l9.setText("Assumptions");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 9;
		l9.setLayoutData(gd0);
		
		assumptionText=new Text(shell, SWT.MULTI|SWT.BORDER|SWT.V_SCROLL|SWT.H_SCROLL);
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 8;
		gd0.heightHint=100;
		assumptionText.setLayoutData(gd0);
		
		Label l10=new Label(shell, SWT.None);
		l10.setText("");
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 1;
		gd1.heightHint=100;
		l10.setLayoutData(gd1);
		
		Label l11=new Label(shell, SWT.None);
		l11.setText("Modeler");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l11.setLayoutData(gd0);
		
		modelerText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 6;
		modelerText.setLayoutData(gd1);
		modelerText.setText("");
		
		Label l11a=new Label(shell, SWT.None);
		l11a.setText("");
		gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 1;
		l11a.setLayoutData(gd2);
		
		Label l12=new Label(shell, SWT.None);
		l12.setText("Table font size (point)");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		l12.setLayoutData(gd0);
		
		fontSizeText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 1;
		fontSizeText.setLayoutData(gd1);
		fontSizeText.setText("9");
		
		Label l12a=new Label(shell, SWT.None);
		l12a.setText("");
		gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 6;
		l12a.setLayoutData(gd2);
		
		Button reportButton = new Button(shell, SWT.PUSH);
		reportButton.setText("Generate Report");
		gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 2;
		reportButton.setLayoutData(gd0);
		reportButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				generateReport(shell);
			}
		});
		
		Label l13=new Label(shell, SWT.None);
		l13.setText("");
		gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 1;
		l13.setLayoutData(gd1);
		
		Button cancelButton = new Button(shell, SWT.PUSH);
		cancelButton.setText("Cancel");
		gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 2;
		cancelButton.setLayoutData(gd2);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		
		Label l13a=new Label(shell, SWT.None);
		l13a.setText("");
		GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
		gd3.horizontalSpan = 4;
		l13a.setLayoutData(gd3);
	}

	public void generateReport(Shell shell){
		String templateFileStr=templateFileText.getText();
		String baseFileStr=baseFileText.getText();
		String altFileStr=altFileText.getText();
		String reportFileStr=reportFileText.getText();
		String baseAliasStr=baseAliasText.getText();
		String altAliasStr=altAliasText.getText();
		String noteStr=noteText.getText();
		String assumptionStr=assumptionText.getText();
		String modelerStr=modelerText.getText();
		String fontSizeStr=fontSizeText.getText();
				
		if (templateFileStr.equals("") || baseFileStr.equals("") || altFileStr.equals("") || reportFileStr.equals("")){
			MessageDialog.openInformation(shell,
					"Error", "You must specify the template file, the source DSS files, and the output PDF file");
		}else if(!new File(templateFileStr).exists()){
			MessageDialog.openInformation(shell,
					"Error", "The template files doesn't exist");
		}else if (!new File(baseFileStr).exists() && !new File(altFileStr).exists()){
			MessageDialog.openInformation(shell,
					"Error", "The source DSS files for the base and alternative studies don't exist");
		}else if(!new File(baseFileStr).exists()){
				MessageDialog.openInformation(shell,
						"Error", "The source DSS file for the base study doesn't exist");
		}else if(!new File(altFileStr).exists()){
			MessageDialog.openInformation(shell,
					"Error", "The source DSS file for the alternative study doesn't exist");
		}else{
			try {
				// Create an inputstream from template file;
				FileInputStream fin = new FileInputStream(templateFileStr);
				BufferedReader br = new BufferedReader(new InputStreamReader(fin));
				// Open the template file
				String theText = br.readLine() + "\n";
				theText = theText + br.readLine() + "\n";
				theText = theText + br.readLine() + "\n";
				br.readLine();
				theText = theText + "FILE_BASE\t" + baseFileStr + "\n";
				br.readLine();
				theText = theText + "NAME_BASE\t\"" + baseAliasStr + "\"\n";
				br.readLine();
				theText = theText + "FILE_ALT\t" + altFileStr + "\n";
				br.readLine();
				theText = theText + "NAME_ALT\t\"" + altAliasStr + "\"\n";
				br.readLine();
				theText = theText + "OUTFILE\t" + reportFileStr + "\n";
				br.readLine();
				theText = theText + "NOTE\t\"" + noteStr + "\"\n";
				br.readLine();
				theText = theText + "ASSUMPTIONS\t\"" + assumptionStr + "\"\n";
				br.readLine();
				theText = theText + "MODELER\t\"" + modelerStr + "\"\n";

				theText = theText + "TABLE_FONT_SIZE\t" + fontSizeStr + "\n";

				String aLine = br.readLine();
				while (aLine != null) {
					theText = theText + aLine + "\n";
					aLine = br.readLine();
				}
				br.close();
				theText = theText + "\n";
				ByteArrayInputStream bs = new ByteArrayInputStream(theText.getBytes());
				try {
					Report report = new Report(bs, reportFileStr);
				} catch (IOException e1) {
					MessageDialog.openInformation(shell,
							"Exception", e1.getMessage());
				}
			} catch (IOException e1) {
				MessageDialog.openInformation(shell,
						"Exception", e1.getMessage());
			}
		}
	}
}
