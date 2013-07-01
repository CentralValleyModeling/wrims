package wrimsv2_plugin.debugger.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

public class WPPConfigTab extends AbstractLaunchConfigurationTab {
	
	private Button wpButton;
	private Button xaButton;
	
	@Override
	public void createControl(Composite parent) {
		Font font = parent.getFont();
		
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout topLayout = new GridLayout();
		topLayout.verticalSpacing = 0;
		topLayout.numColumns = 7;
		comp.setLayout(topLayout);
		comp.setFont(font);
		
		createVerticalSpacer(comp, 3);
		
		Label wpLabel = new Label(comp, SWT.NONE);
		wpLabel.setText("&WRESL Plus:");
		GridData gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan=2;
		wpLabel.setLayoutData(gd);
		wpLabel.setFont(font);
		
		wpButton = new Button(comp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		wpButton.setLayoutData(gd);
		wpButton.setFont(font);
		wpButton.addSelectionListener(new SelectionListener(){
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();			
			}
		});
		
		Label xaLabel = new Label(comp, SWT.NONE);
		xaLabel.setText("&XA Free Limited License:");
		gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan=2;
		xaLabel.setLayoutData(gd);
		xaLabel.setFont(font);
		
		xaButton = new Button(comp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		xaButton.setLayoutData(gd);
		xaButton.setFont(font);
		xaButton.addSelectionListener(new SelectionListener(){
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();			
			}
		});
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_WRESLPLUS, "no");
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		String wreslPlus = null;
		try {
			wreslPlus = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_WRESLPLUS, "no");
			if (wreslPlus.equalsIgnoreCase("yes")){
				wpButton.setSelection(true);
			}else{
				wpButton.setSelection(false);
			}
		} catch (CoreException e) {
			WPPException.handleException(e);
		}
		
		String freeXA = null;
		try {
			freeXA = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_FREEXA, "no");
			if (freeXA.equalsIgnoreCase("yes")){
				xaButton.setSelection(true);
			}else{
				xaButton.setSelection(false);
			}
		} catch (CoreException e) {
			WPPException.handleException(e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String wreslPlus="yes";
		if (wpButton.getSelection()){
			wreslPlus="yes";
		}else{
			wreslPlus="no";
		}
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_WRESLPLUS, wreslPlus);
		
		String freeXA="yes";
		if (xaButton.getSelection()){
			freeXA="yes";
		}else{
			freeXA="no";
		}
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_FREEXA, freeXA);
	}

	@Override
	public String getName() {
		return "Configuration";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		setMessage(null);
		return true;
	}
}
