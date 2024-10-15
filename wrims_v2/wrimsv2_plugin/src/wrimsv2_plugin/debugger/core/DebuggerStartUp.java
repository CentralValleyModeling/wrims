package wrimsv2_plugin.debugger.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.internal.PluginActionContributionItem;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.ViewPart;

import wrimsv2_plugin.calsimhydro.DefaultCalSimHydro;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.toolbaritem.EnableButtons;
import wrimsv2_plugin.debugger.toolbaritem.HandlePauseResumeButton;
import wrimsv2_plugin.debugger.view.UpdateView;
import wrimsv2_plugin.debugger.view.WPPWatchView;
import wrimsv2_plugin.tools.DataProcess;
import wrimsv2_plugin.tools.ProcWatchItem;
import wrimsv2_plugin.tools.ShowDuplicatedWatch;

public class DebuggerStartUp implements IStartup {

	private static String solverSetup="solvers.dat";
	
	@Override
	public void earlyStartup() {
		SettingPref.load();
		SettingPref.loadCBCDefault();
		SettingPref.loadCBCSetting();
		loadSolverSetup();
		enableRunMenu();
		initialStudyData();
		DataProcess.initialVariableValueAlt();
		addPerspectiveChangeListener();
	}

	public void enableRunMenu(){
		HashMap<String, Boolean> enableMenuMap=new HashMap<String, Boolean>();
		enableMenuMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_CONDITIONALBREAKPOINT, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_CLEARCONDITIONALBREAKPOINT, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMenuMap);
		/*
		HandlePauseResumeButton.procPauseResumeToolbarItem(0);
		HashMap<String, Boolean> enableButtonMap=new HashMap<String, Boolean>();
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLEBUTTON, false);
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEPBUTTON, false);
		new EnableButtons(enableButtonMap);
		*/
		showSolverStatus();
	}
	
	public void initialStudyData(){
		Map<String, String>[] studiesData = DebugCorePlugin.studiesData;
		for (int i=0; i<4; i++){
			studiesData[i]=new HashMap<String, String>();
		}
	}
		
	public void showSolverStatus(){
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				String log="";
				if (!DebugCorePlugin.log.equalsIgnoreCase("NONE")){
					log=DebugCorePlugin.log;
				}
				
				String status=DebugCorePlugin.solver+"  "+log;
				/*
				if (DebugCorePlugin.solver.equalsIgnoreCase("CBC")){
					status=DebugCorePlugin.solver+" "+DebugCorePlugin.cbcSelVer+"  "+log;
				}else if (DebugCorePlugin.solver.equalsIgnoreCase("GUROBI")){
					status=DebugCorePlugin.solver+" "+DebugCorePlugin.gurobiSelVer+"  "+log;
				}
				*/
				
				IWorkbenchPage page = Workbench.getInstance().getActiveWorkbenchWindow().getActivePage();
				IViewPart console = page.findView( IConsoleConstants.ID_CONSOLE_VIEW ); 
				if (console != null){
					try {
						console=page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
						console.getViewSite().getActionBars().getStatusLineManager().setMessage(status);
					} catch (PartInitException e) {
						WPPException.handleException(e);
					}
				}
			}
		});
	}
	
	public void addPerspectiveChangeListener(){
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				Workbench.getInstance().getActiveWorkbenchWindow().addPerspectiveListener(new IPerspectiveListener() {

					@Override
					public void perspectiveActivated(IWorkbenchPage page,
							IPerspectiveDescriptor perspective) {
						String label=perspective.getLabel();
						if (label.equalsIgnoreCase("IDE")){
							showSolverStatus();
						}
					}

					@Override
					public void perspectiveChanged(IWorkbenchPage page,
							IPerspectiveDescriptor perspective, String changeId) {
						String label=perspective.getLabel();
						if (label.equalsIgnoreCase("CalSimHydro")){
							DefaultCalSimHydro dch = new DefaultCalSimHydro();
							dch.load();
						}
					}
				});
			}
			
		});
		
	}	
	
	public void loadSolverSetup(){
		try {
			File file = new File(DebugCorePlugin.dataDir, solverSetup);
			if (file.exists()){
				FileInputStream fs = new FileInputStream(file.getAbsolutePath());
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				LineNumberReader reader = new LineNumberReader(br);
				br.readLine();
				String line=br.readLine().toUpperCase();
				while (line !=null){
					String[] parts = line.split(",");
					if (parts.length==4){
						if (!DebugCorePlugin.solverNames.contains(parts[0])){
							DebugCorePlugin.solverNames.add(parts[0]);
						}
						if (parts[0].equalsIgnoreCase("CBC")){
							DebugCorePlugin.cbcVers.add(parts[1]);
							DebugCorePlugin.cbcJars.put(parts[1], parts[2]);
							DebugCorePlugin.cbcDlls.put(parts[1], parts[3]);
						}else if (parts[0].equalsIgnoreCase("GUROBI")){
							DebugCorePlugin.gurobiVers.add(parts[1]);
							DebugCorePlugin.gurobiJars.put(parts[1], parts[2]);
							DebugCorePlugin.gurobiDlls.put(parts[1], parts[3]);
						}else if (parts[0].equalsIgnoreCase("XA")){
							DebugCorePlugin.xaVers.add(parts[1]);
							DebugCorePlugin.xaJars.put(parts[1], parts[2]);
							DebugCorePlugin.xaDlls.put(parts[1], parts[3]);
						}
					}
					line=br.readLine().toUpperCase();
				}
			}
		}catch (Exception e){
			WPPException.handleException(e);
		}
		return;
	}
}
