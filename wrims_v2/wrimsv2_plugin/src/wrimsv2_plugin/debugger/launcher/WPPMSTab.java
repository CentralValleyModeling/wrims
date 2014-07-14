package wrimsv2_plugin.debugger.launcher;

import java.util.Calendar;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.TimeOperation;

public class WPPMSTab extends AbstractLaunchConfigurationTab {
	
	private Text msDurationText;
	private Combo studies;
	private Text fMainFileText;
	private Button fMainFileButton;
	private Text fDvarFileText;
	private Button fDvarFileButton;
	private Text fSvarFileText;
	private Button fSvarFileButton;
	private Text fInitFileText;
	private Button fInitFileButton;
	private Text groundWaterFolderText;
	private Button groundWaterFolderButton;
	private Text aPartText;
	private Text svFPartText;
	private Text initFPartText;
	private Combo timeStepCombo;
	
	private String[] timeSteps = { "1MON", "1DAY" };
	private String sid="2";
	private String preSid="2";
	private Text dataTransferText;
	private Button dataTransferButton;
	private ILaunchConfiguration currConfiguration;
	private ModifyListener dataTransferML;
	private ModifyListener fMainFileML;
	private ModifyListener fDvarFileML;
	private ModifyListener fSvarFileML;
	private ModifyListener fInitFileML;
	private ModifyListener groundWaterFolderML;
	private ModifyListener aPartML;
	private ModifyListener svFPartML;
	private ModifyListener initFPartML;
	private ModifyListener timeStepML;
	
	@Override
	public void createControl(Composite parent) {
		Font font = parent.getFont();
		
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout topLayout = new GridLayout(7, false);
		topLayout.verticalSpacing = 10;
		comp.setLayout(topLayout);
		comp.setFont(font);
		
		createVerticalSpacer(comp, 3);
		
		Label label1=new Label(comp, SWT.NONE);
		label1.setText("Multi Study Duration (months):");
		GridData gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 4;
		label1.setLayoutData(gd);
		
		msDurationText=new Text(comp, SWT.RIGHT);
		gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 3;
		gd.widthHint=50;
		msDurationText.setLayoutData(gd);
		msDurationText.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
			
		});
		
		Label label2=new Label(comp, SWT.NONE);
		label2.setText("Study #:");
		gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 4;
		label2.setLayoutData(gd);
		
		studies = new Combo(comp, SWT.NONE);
		for (int i=2; i<10; i++){
			studies.add(String.valueOf(i));
		}
		studies.select(0);
		gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 3;
		studies.setLayoutData(gd);
		studies.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				preSid=sid;
				sid=studies.getItem(studies.getSelectionIndex());
				updateLaunchConfigurationDialog();
				setupForm(currConfiguration);
			}
			
		});
		
		Label dataTransferLabel = new Label(comp, SWT.NONE);
		dataTransferLabel.setText("&Data Transfer File:");
		gd = new GridData(GridData.BEGINNING);
		dataTransferLabel.setLayoutData(gd);
		dataTransferLabel.setFont(font);
		
		dataTransferText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 5;
		dataTransferText.setLayoutData(gd);
		dataTransferText.setFont(font);
		dataTransferML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		dataTransferText.addModifyListener(dataTransferML);
		
		dataTransferButton = createPushButton(comp, "&Browse", null); //$NON-NLS-1$
		dataTransferButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseFiles(dataTransferText);
			}
		});
		
		Label mainFileLabel = new Label(comp, SWT.NONE);
		mainFileLabel.setText("&Main WRESL File:");
		gd = new GridData(GridData.BEGINNING);
		mainFileLabel.setLayoutData(gd);
		mainFileLabel.setFont(font);
		
		fMainFileText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 5;
		fMainFileText.setLayoutData(gd);
		fMainFileText.setFont(font);
		fMainFileML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		fMainFileText.addModifyListener(fMainFileML);
		
		fMainFileButton = createPushButton(comp, "&Browse", null); //$NON-NLS-1$
		fMainFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseFiles(fMainFileText);
			}
		});
		
		Label dvarFileLabel = new Label(comp, SWT.NONE);
		dvarFileLabel.setText("&Dvar DSS File:");
		gd = new GridData(GridData.BEGINNING);
		dvarFileLabel.setLayoutData(gd);
		dvarFileLabel.setFont(font);
		
		fDvarFileText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 5;
		fDvarFileText.setLayoutData(gd);
		fDvarFileText.setFont(font);
		fDvarFileML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		fDvarFileText.addModifyListener(fDvarFileML);
		
		fDvarFileButton = createPushButton(comp, "&Browse", null); //$NON-NLS-1$
		fDvarFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseFiles(fDvarFileText);
			}
		});
		
		Label svarFileLabel = new Label(comp, SWT.NONE);
		svarFileLabel.setText("&Svar DSS File:");
		gd = new GridData(GridData.BEGINNING);
		svarFileLabel.setLayoutData(gd);
		svarFileLabel.setFont(font);
		
		fSvarFileText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 5;
		fSvarFileText.setLayoutData(gd);
		fSvarFileText.setFont(font);
		fSvarFileML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		fSvarFileText.addModifyListener(fSvarFileML);
		
		fSvarFileButton = createPushButton(comp, "&Browse", null); //$NON-NLS-1$
		fSvarFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseFiles(fSvarFileText);
			}
		});
		
		Label initFileLabel = new Label(comp, SWT.NONE);
		initFileLabel.setText("&Init DSS File:");
		gd = new GridData(GridData.BEGINNING);
		initFileLabel.setLayoutData(gd);
		initFileLabel.setFont(font);
		
		fInitFileText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 5;
		fInitFileText.setLayoutData(gd);
		fInitFileText.setFont(font);
		fInitFileML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		fInitFileText.addModifyListener(fInitFileML);
		
		fInitFileButton = createPushButton(comp, "&Browse", null); //$NON-NLS-1$
		fInitFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseFiles(fInitFileText);
			}
		});
		
		Label groundwaterFolderLabel = new Label(comp, SWT.NONE);
		groundwaterFolderLabel.setText("&Groundwater Folder:");
		gd = new GridData(GridData.BEGINNING);
		groundwaterFolderLabel.setLayoutData(gd);
		groundwaterFolderLabel.setFont(font);
		
		groundWaterFolderText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 5;
		groundWaterFolderText.setLayoutData(gd);
		groundWaterFolderText.setFont(font);
		groundWaterFolderML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		groundWaterFolderText.addModifyListener(groundWaterFolderML);
		
		groundWaterFolderButton = createPushButton(comp, "&Browse", null); //$NON-NLS-1$
		groundWaterFolderButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseFolders(groundWaterFolderText);
			}
		});
		
		Label aPart = new Label(comp, SWT.NONE);
		aPart.setText("&A-Part:");
		gd = new GridData(GridData.BEGINNING);
		aPart.setLayoutData(gd);
		aPart.setFont(font);
		
		aPartText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 6;
		aPartText.setLayoutData(gd);
		aPartText.setFont(font);
		aPartML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		aPartText.addModifyListener(aPartML);
		
		Label svFPart = new Label(comp, SWT.NONE);
		svFPart.setText("&SV F-Part:");
		gd = new GridData(GridData.BEGINNING);
		svFPart.setLayoutData(gd);
		svFPart.setFont(font);
		
		svFPartText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 6;
		svFPartText.setLayoutData(gd);
		svFPartText.setFont(font);
		svFPartML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		svFPartText.addModifyListener(svFPartML);
		
		Label initFPart = new Label(comp, SWT.NONE);
		initFPart.setText("&Init F-Part:");
		gd = new GridData(GridData.BEGINNING);
		initFPart.setLayoutData(gd);
		initFPart.setFont(font);
		
		initFPartText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 6;
		initFPartText.setLayoutData(gd);
		initFPartText.setFont(font);
		initFPartML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		initFPartText.addModifyListener(initFPartML);
		
		Label timeStep = new Label(comp, SWT.NONE);
		timeStep.setText("&Time Step:");
		gd = new GridData(GridData.BEGINNING);
		timeStep.setLayoutData(gd);
		timeStep.setFont(font);
				
		timeStepCombo=new Combo(comp, SWT.READ_ONLY);
		timeStepCombo.setItems(timeSteps);
		gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 6;
		timeStepCombo.setLayoutData(gd);
		timeStepCombo.setFont(font);
		timeStepCombo.select(0);
		timeStepML=new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		timeStepCombo.addModifyListener(timeStepML);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		currConfiguration=configuration;
		try {
			String msDuration = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_MSDURATION, "12");
			msDurationText.setText(msDuration);
			setupForm(configuration);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
	}

	public void setupForm(ILaunchConfiguration configuration){
		dataTransferText.removeModifyListener(dataTransferML);
		fMainFileText.removeModifyListener(fMainFileML);
		fDvarFileText.removeModifyListener(fDvarFileML);
		fSvarFileText.removeModifyListener(fSvarFileML);
		fInitFileText.removeModifyListener(fInitFileML);
		groundWaterFolderText.removeModifyListener(groundWaterFolderML);
		aPartText.removeModifyListener(aPartML);
		svFPartText.removeModifyListener(svFPartML);
		initFPartText.removeModifyListener(initFPartML);
		timeStepCombo.removeModifyListener(timeStepML);
		
		try{	
			String dataTransferFile = null;
			dataTransferFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_DATATRANSFER+"_MS"+sid, (String)null);
			if (dataTransferFile == null) {
				dataTransferText.setText("");
			}else{
				dataTransferText.setText(dataTransferFile);
			}
			String mainFile = null;
			mainFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM+"_MS"+sid, (String)null);
			if (mainFile == null) {
				fMainFileText.setText("");
			}else{
				fMainFileText.setText(mainFile);
			}
			String dvarFile = null;
			dvarFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_DVARFILE+"_MS"+sid, (String)null);
			if (dvarFile == null) {
				fDvarFileText.setText("");
			}else{
				fDvarFileText.setText(dvarFile);
			}
			String svarFile = null;
			svarFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_SVARFILE+"_MS"+sid, (String)null);
			if (svarFile == null) {
				fSvarFileText.setText("");
			}else{
				fSvarFileText.setText(svarFile);
			}
			String initFile = null;
			initFile = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_INITFILE+"_MS"+sid, (String)null);
			if (initFile == null) {
				fInitFileText.setText("");
			}else{
				fInitFileText.setText(initFile);
			}
			String gwDataFolder = null;
			gwDataFolder = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_GWDATAFOLDER+"_MS"+sid, (String)null);
			if (gwDataFolder == null) {
				groundWaterFolderText.setText("");
			}else{
				groundWaterFolderText.setText(gwDataFolder);
			}
			String aPart = null;
			aPart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_APART+"_MS"+sid, (String)null);
			if (aPart == null) {
				aPartText.setText("");
			}else{
				aPartText.setText(aPart);
			}
			String svFPart = null;
			svFPart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_SVFPART+"_MS"+sid, (String)null);
			if (svFPart == null) {
				svFPartText.setText("");
			}else{
				svFPartText.setText(svFPart);
			}
			String initFPart = null;
			initFPart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_INITFPART+"_MS"+sid, (String)null);
			if (initFPart == null) {
				initFPartText.setText("");
			}else{
				initFPartText.setText(initFPart);
			}
			String timeStep = null;
			timeStep = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_TIMESTEP+"_MS"+sid, (String)null);
			if (timeStep == null) {
				timeStepCombo.select(0);
			}else{
				timeStepCombo.setText(timeStep);
			}
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		dataTransferText.addModifyListener(dataTransferML);
		fMainFileText.addModifyListener(fMainFileML);
		fDvarFileText.addModifyListener(fDvarFileML);
		fSvarFileText.addModifyListener(fSvarFileML);
		fInitFileText.addModifyListener(fInitFileML);
		groundWaterFolderText.addModifyListener(groundWaterFolderML);
		aPartText.addModifyListener(aPartML);
		svFPartText.addModifyListener(svFPartML);
		initFPartText.addModifyListener(initFPartML);
		timeStepCombo.addModifyListener(timeStepML);
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String dataTransferFile = dataTransferText.getText().trim();
		if (dataTransferFile.length() == 0) {
			dataTransferFile = "";
		}		
		String mainFile = fMainFileText.getText().trim();
		if (mainFile.length() == 0) {
			mainFile = "";
		}
		String dvarFile = fDvarFileText.getText().trim();
		if (dvarFile.length() == 0) {
			dvarFile = "";
		}
		String svarFile = fSvarFileText.getText().trim();
		if (svarFile.length() == 0) {
			svarFile = "";
		}
		String initFile = fInitFileText.getText().trim();
		if (initFile.length() == 0) {
			initFile = "";
		}
		String gwDataFolder = groundWaterFolderText.getText().trim();
		if (gwDataFolder.length() == 0) {
			gwDataFolder = "";
		}
		String aPart = aPartText.getText().trim();
		if (aPart.length() == 0) {
			aPart = "";
		}
		String svFPart = svFPartText.getText().trim();
		if (svFPart.length() == 0) {
			svFPart = "";
		}
		String initFPart = initFPartText.getText().trim();
		if (initFPart.length() == 0) {
			initFPart = "";
		}
		String timeStep = timeStepCombo.getText().trim();
		if (timeStep.length() == 0) {
			timeStep = "";
		}
		
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_MSDURATION, msDurationText.getText());
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_DATATRANSFER+"_MS"+preSid, dataTransferFile);		
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM+"_MS"+preSid, mainFile);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_DVARFILE+"_MS"+preSid, dvarFile);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_SVARFILE+"_MS"+preSid, svarFile);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_INITFILE+"_MS"+preSid, initFile);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_GWDATAFOLDER+"_MS"+preSid, gwDataFolder);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_APART+"_MS"+preSid, aPart);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_SVFPART+"_MS"+preSid, svFPart);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_INITFPART+"_MS"+preSid, initFPart);
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_TIMESTEP+"_MS"+preSid, timeStep);
	}

	@Override
	public String getName() {
		return "Multi Study Runner";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		return true;
	}
	
	protected void browseFiles(Text fileLocationText) {
		FileDialog dlg =new FileDialog(getShell(),SWT.OPEN);
		fileLocationText.setText(dlg.open());
	}
	
	protected void browseFolders(Text folderLocationText) {
		DirectoryDialog dlg =new DirectoryDialog(getShell(),SWT.OPEN);
		folderLocationText.setText(dlg.open());
	}
}
