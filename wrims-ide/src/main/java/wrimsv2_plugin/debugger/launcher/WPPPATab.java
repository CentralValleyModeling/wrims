package wrimsv2_plugin.debugger.launcher;

import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;
import hec.hecmath.TimeSeriesMath;
import hec.io.TimeSeriesContainer;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.pa.PAProcRun;
import wrimsv2_plugin.tools.DssOperations;
import wrimsv2_plugin.tools.FileProcess;
import wrimsv2_plugin.tools.TimeOperation;

public class WPPPATab extends AbstractLaunchConfigurationTab {
	
	private Text paDurationText;
	private Text paStartIntervalText;
	private Button initDelBut;
	private Button nResetDVStartBut;
	private Button resetDVStartBut;
	private Combo dvYearCombo;
	private Combo dvMonthCombo;
	private Combo dvDayCombo;
	private Button unchangeGWRestartBut;
	private Button unchangeInitialDssBut;
	private Button createSeriesPAInitsBut;
	private WPPMainTab mainTab;
	private ILaunchConfiguration configuration;
	private String startTime="";
	private String endTime="";
	private ProgressBar seriesPAInitPB;
	private boolean isCreateSeriesPAInit=true;
	private Button cancelSeriesPAInitsBut;
	
	public WPPPATab(WPPMainTab mainTab){
		this.mainTab=mainTab;
	}
	
	@Override
	public void createControl(Composite parent) {
		Font font = parent.getFont();
		
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout topLayout = new GridLayout(2, false);
		topLayout.verticalSpacing = 10;
		comp.setLayout(topLayout);
		comp.setFont(font);
		
		createVerticalSpacer(comp, 3);
		
		Label label1=new Label(comp, SWT.NONE);
		label1.setText("PA Start Interval (months):");
		GridData gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan = 1;
		label1.setLayoutData(gd1);
		
		paStartIntervalText=new Text(comp, SWT.RIGHT|SWT.BORDER);
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan = 1;
		gd1.widthHint=50;
		paStartIntervalText.setLayoutData(gd1);
		paStartIntervalText.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();			
			}
			
		});
				
		Label label2=new Label(comp, SWT.NONE);
		label2.setText("PA Duration (months):");
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan = 1;
		label2.setLayoutData(gd1);
		
		paDurationText=new Text(comp, SWT.RIGHT|SWT.BORDER);
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan = 1;
		gd1.widthHint=50;
		paDurationText.setLayoutData(gd1);
		paDurationText.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();			
			}
			
		});
				
		initDelBut=new Button(comp, SWT.CHECK);
		initDelBut.setText("Delete PA initial file after run completed");
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan = 2;
		initDelBut.setLayoutData(gd1);
		initDelBut.addSelectionListener(new SelectionAdapter(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
			
		});
		
		Group group1 = new Group(comp, SWT.SHADOW_IN);
	    group1.setText("Reset the start date of DV DSS output?");
	    gd1 = new GridData(GridData.BEGINNING);
	    gd1.horizontalSpan = 2;
	    group1.setLayoutData(gd1);
	    
	    GridLayout layout2=new GridLayout(7, false);
	    layout2.marginWidth=20;
	    layout2.marginHeight=15;
		group1.setLayout(layout2);

		nResetDVStartBut=new Button(group1, SWT.RADIO);
		nResetDVStartBut.setText("No");
		GridData gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 7;
		nResetDVStartBut.setLayoutData(gd2);
		nResetDVStartBut.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (nResetDVStartBut.getSelection()){			
					enableDVStartDate(false);
				}
				updateLaunchConfigurationDialog();
			}
			
		});
		
		resetDVStartBut=new Button(group1, SWT.RADIO);
		resetDVStartBut.setText("Yes");
		gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 1;
		resetDVStartBut.setLayoutData(gd2);
		resetDVStartBut.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (resetDVStartBut.getSelection()){			
					enableDVStartDate(true);
				}
				updateLaunchConfigurationDialog();
			}
			
		});
		
		Label label4=new Label(group1, SWT.NONE);
		label4.setText("Year:");
		gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 1;
		label4.setLayoutData(gd2);
		
		dvYearCombo=new Combo(group1, SWT.NONE);
		gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 1;
		dvYearCombo.setLayoutData(gd2);
		createYearCombo();
		dvYearCombo.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();			
			}
			
		});
		
		Label label5=new Label(group1, SWT.NONE);
		label5.setText("Month:");
		gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 1;
		label5.setLayoutData(gd2);
		
		dvMonthCombo=new Combo(group1, SWT.NONE);
		gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 1;
		dvMonthCombo.setLayoutData(gd2);
		createMonthCombo();
		dvMonthCombo.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();			
			}
			
		});
		
		Label label6=new Label(group1, SWT.NONE);
		label6.setText("Day:");
		gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 1;
		label6.setLayoutData(gd2);
		
		dvDayCombo=new Combo(group1, SWT.NONE);
		gd2 = new GridData(GridData.BEGINNING);
		gd2.horizontalSpan = 1;
		dvDayCombo.setLayoutData(gd2);
		createDayCombo();	
		dvDayCombo.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();			
			}
			
		});
		
		unchangeGWRestartBut=new Button(comp, SWT.CHECK);
		unchangeGWRestartBut.setText("Use the Same GW Restart File");
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan =2;
		unchangeGWRestartBut.setLayoutData(gd1);
		unchangeGWRestartBut.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		unchangeInitialDssBut=new Button(comp, SWT.CHECK);
		unchangeInitialDssBut.setText("Get Initial Data from Initial Dss File at the Start Date of Each Indvidual PA Run");
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan =2;
		unchangeInitialDssBut.setLayoutData(gd1);
		unchangeInitialDssBut.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		createSeriesPAInitsBut=new Button(comp, SWT.NONE);
		createSeriesPAInitsBut.setText("Create a Series of PA Intial Files");
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan =2;
		createSeriesPAInitsBut.setLayoutData(gd1);
		createSeriesPAInitsBut.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				createSeriesPAInits();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		seriesPAInitPB=new ProgressBar(comp, SWT.NONE);
		seriesPAInitPB.setMinimum(1922);
		seriesPAInitPB.setMaximum(2015);
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan =2;
		seriesPAInitPB.setLayoutData(gd1);
		seriesPAInitPB.setVisible(true);
		
		cancelSeriesPAInitsBut=new Button(comp, SWT.NONE);
		cancelSeriesPAInitsBut.setText("Cancel");
		gd1 = new GridData(GridData.BEGINNING);
		gd1.horizontalSpan =2;
		cancelSeriesPAInitsBut.setLayoutData(gd1);
		cancelSeriesPAInitsBut.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				isCreateSeriesPAInit=false;
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
		this.configuration=configuration;
		try {
			String paStartInterval = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PASTARTINTERVAL, "12");
			paStartIntervalText.setText(paStartInterval);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String paDuration = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PADURATION, "12");
			paDurationText.setText(paDuration);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String initDel = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PADELINIT, "yes");
			if (initDel.equals("yes")){
				initDelBut.setSelection(true);
			}else{
				initDelBut.setSelection(false);
			}
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String defaultPADVStartYear;
			if (Calendar.getInstance().get(Calendar.MONTH)<=9){
				defaultPADVStartYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-1);
			}else{
				defaultPADVStartYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			}
			String paDVStartYear = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTYEAR, defaultPADVStartYear);
			dvYearCombo.setText(paDVStartYear);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String paDVStartMonth = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTMONTH, "10");
			dvMonthCombo.setText(paDVStartMonth);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String paDVStartDay = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTDAY, "1");
			dvDayCombo.setText(paDVStartDay);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String resetDVStart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_PARESETDVSTART, "no");
			if (resetDVStart.equals("yes")){
				resetDVStartBut.setSelection(true);
				enableDVStartDate(true);
			}else{
				nResetDVStartBut.setSelection(true);
				enableDVStartDate(false);
			}
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String unchangeGWRestart = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_UNCHANGEGWRESTART, "yes");
			if (unchangeGWRestart.equals("yes")){
				unchangeGWRestartBut.setSelection(true);
			}else{
				unchangeGWRestartBut.setSelection(false);
			}
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
		
		try {
			String unchangeInitialDss = configuration.getAttribute(DebugCorePlugin.ATTR_WPP_UNCHANGEINITIALDSS, "yes");
			if (unchangeInitialDss.equals("yes")){
				unchangeInitialDssBut.setSelection(true);
			}else{
				unchangeInitialDssBut.setSelection(false);
			}
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PASTARTINTERVAL, paStartIntervalText.getText());
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PADURATION, paDurationText.getText());
		
		String paInitDel="yes";
		if (initDelBut.getSelection()){
			paInitDel="yes";
		}else{
			paInitDel="no";
		}
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PADELINIT, paInitDel);
		
		String paResetDVStart="no";
		if (resetDVStartBut.getSelection()){
			paResetDVStart="yes";
		}else{
			paResetDVStart="no";
		}
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PARESETDVSTART, paResetDVStart);
		
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTYEAR, dvYearCombo.getText());
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTMONTH, dvMonthCombo.getText());
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTDAY, dvDayCombo.getText());
		
		String unchangeGWRestart="yes";
		if (unchangeGWRestartBut.getSelection()){
			unchangeGWRestart="yes";
		}else{
			unchangeGWRestart="no";
		}
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_UNCHANGEGWRESTART, unchangeGWRestart);
		
		String unchangeInitialDss="yes";
		if (unchangeInitialDssBut.getSelection()){
			unchangeInitialDss="yes";
		}else{
			unchangeInitialDss="no";
		}
		configuration.setAttribute(DebugCorePlugin.ATTR_WPP_UNCHANGEINITIALDSS, unchangeInitialDss);
	}

	@Override
	public String getName() {
		return "Position Analysis";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		int dvStartYear=Integer.parseInt(dvYearCombo.getText());
		int dvStartMonth=Integer.parseInt(dvMonthCombo.getText());
		int dvStartDay=Integer.parseInt(dvDayCombo.getText());
		if (dvStartDay>TimeOperation.numberOfDays(dvStartMonth, dvStartYear)){
			setErrorMessage("The DV DSS start date is larger than the number of the days in the month!");
			setMessage(null);
			return false;
		}else{
			setErrorMessage(null);
			setMessage(null);
			return true;
		}
	}
	
	public void enableDVStartDate(boolean resetOutputStart){
		dvYearCombo.setEnabled(resetOutputStart);
		dvMonthCombo.setEnabled(resetOutputStart);
		dvDayCombo.setEnabled(resetOutputStart);
	}
	
	public void createYearCombo(){
		for (int i=1900; i<=4000; i++){
			dvYearCombo.add(String.valueOf(i));
		}
	}
	
	public void createMonthCombo(){
		for (int i=1; i<=12; i++){
			dvMonthCombo.add(String.valueOf(i));
		}
	}
	
	public void createDayCombo(){
		for (int i=1; i<=31; i++){
			dvDayCombo.add(String.valueOf(i));
		}
	}
	
	public void createSeriesPAInits(){
		final int interval = Integer.parseInt(paStartIntervalText.getText());
		final int startYear=Integer.parseInt(mainTab.startYearCombo.getText());
		final int startMonth=TimeOperation.monthValue(mainTab.startMonthCombo.getText());
		final int startDay=Integer.parseInt(mainTab.startDayCombo.getText());
		final int endYear=Integer.parseInt(mainTab.endYearCombo.getText());
		final int endMonth=TimeOperation.monthValue(mainTab.endMonthCombo.getText());
		final int endDay=Integer.parseInt(mainTab.endDayCombo.getText());
		final String initFile = mainTab.fInitFileText.getText();

		Thread thread=new Thread(){
			private int paStartYear;
			private int paStartMonth;
			private int paStartDay;

			public void run(){
				paStartYear=startYear;
				paStartMonth=startMonth;
				paStartDay=startDay;
				
				Calendar cal1 = new GregorianCalendar();
		        Calendar cal2 = new GregorianCalendar();
				cal1.set(paStartYear, paStartMonth, paStartDay);
				cal2.set(endYear, endMonth, endDay);
				int i = 0;
				boolean isFirstOne=true;
				isCreateSeriesPAInit=true;
				
				Display.getDefault().asyncExec(new Runnable(){
					
					public void run(){
						seriesPAInitPB.setMinimum(startYear);
						seriesPAInitPB.setMaximum(endYear);
						seriesPAInitPB.setVisible(true);
					}
				});

				while ((cal1.before(cal2) || cal1.equals(cal2)) && isCreateSeriesPAInit) {
					Display.getDefault().asyncExec(new Runnable(){
						
						public void run(){
							seriesPAInitPB.setSelection(paStartYear);
							seriesPAInitPB.setVisible(true);
						}
					});
					createPAInit(paStartYear, paStartMonth, paStartDay, startYear, startMonth, startDay, i*interval, isFirstOne, initFile);
					cal1.add(Calendar.MONTH, interval);
					paStartYear = cal1.get(Calendar.YEAR);
					paStartMonth = cal1.get(Calendar.MONTH);
					paStartDay = cal1.get(Calendar.DAY_OF_MONTH);
					i++;
					isFirstOne=false;
				}
				
				if (isCreateSeriesPAInit){
					Display.getDefault().asyncExec(new Runnable(){
					
						public void run(){
							seriesPAInitPB.setSelection(endYear);
							seriesPAInitPB.setVisible(true);
						}
					});
				}
			}
		};
		thread.start();
	}
	
	public void createPAInit(int paStartYear, int paStartMonth, int paStartDay, int startYear, int startMonth, int startDay, int intervalMonths, boolean isFirstOne, String initFile){
		File initDSSFile=new File(initFile);
		if (initFile !=null){
			if (!initDSSFile.isAbsolute()){
				initFile=FileProcess.procRelativePath(initFile, configuration);
				initDSSFile=new File(initFile);
			}
			String paInitFileName = createPAInitFileName(initFile, paStartYear, paStartMonth, paStartDay);
			if (initDSSFile !=null){
				File newInitDSSFile = new File(paInitFileName);
				try {
					FileUtils.copyFile(initDSSFile, newInitDSSFile);
					createInitData(paInitFileName, paStartYear, paStartMonth, paStartDay, startYear, startMonth, startDay, intervalMonths, isFirstOne);
				} catch (IOException e) {
					WPPException.handleException(e);
				}
			}
		}
	}
	
	public String createPAInitFileName(String initFile, int paStartYear, int paStartMonth, int paStartDay){
		File file = new File(initFile);
		String fn = file.getName();
		String fp = file.getParent();
		String prefix="\\pa_"+paStartYear+TimeOperation.getModMonthText(paStartMonth)+TimeOperation.getModDayhText(paStartDay)+"_";
		return fp+prefix+fn;
	}
	
	public void createInitData(String paInitFileName, int paStartYear, int paStartMonth, int paStartDay, int startYear, int startMonth, int startDay, int intervalMonths, boolean isFirstOne){
		HecDss paInitDss;
		try {
			paInitDss=HecDss.open(paInitFileName);
		} catch (Exception e) {
			WPPException.handleException(e);
			return;
		}
		Vector<String> paPathList = paInitDss.getPathnameList();
		Collections.sort(paPathList, Collections.reverseOrder());
		int size = paPathList.size();
		if (isFirstOne){
			/*
			int sYear=startYear;
			for (int i=0; i<size; i++){
				String path = paPathList.get(i);
				try {
					TimeSeriesContainer firstDc = (TimeSeriesContainer)paInitDss.get(path);
					long st=firstDc.startTime;
					long stms=st*60000;
					long l1970=1440l * 25568l * 60000l;
					long ststd=stms-l1970;
					int sYear1=new Date(ststd).getYear()+1900;
					if (sYear1<sYear){
						sYear=sYear1;
					}
				} catch (Exception e1) {
					WPPException.handleException(e1);
				}
			}
			startTime=TimeOperation.createStartTime(sYear, 1, 1, "1DAY");
			endTime=TimeOperation.createEndTime1(startYear, startMonth, startDay, "1DAY");
			*/
		}else{
			//paInitDss.setTimeWindow(startTime, endTime);
			for (int i=0; i<size; i++){
				String path = paPathList.get(i);
				try {
					TimeSeriesContainer dc = (TimeSeriesContainer)paInitDss.get(path);
					TimeSeriesMath tm = new TimeSeriesMath(dc);
					//TimeSeriesMath tm1 = (TimeSeriesMath) tm.extractTimeSeriesDataForTimeSpecification("YEAR", dsy+"-"+paStartYear, true, 0, false);
					HecMath newTm = tm.shiftInTime(intervalMonths+"MON");
					paInitDss.write(newTm);
				} catch (Exception e) {
					WPPException.handleException(e);
				}
			}
		}
		paInitDss.close();
	}

}
