package wrimsv2_plugin.batchrun;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;
import wrimsv2_plugin.debugger.msr.MSRDataTransferBR;
import wrimsv2_plugin.debugger.msr.MSRProcRunBR;
import wrimsv2_plugin.debugger.msr.MSRUtil;
import wrimsv2_plugin.debugger.pa.PAProcDVBR;
import wrimsv2_plugin.debugger.pa.PAProcInitBR;
import wrimsv2_plugin.debugger.pa.PAProcRunBR;
import wrimsv2_plugin.tools.FileProcess;
import wrimsv2_plugin.tools.TimeOperation;

import java.lang.Runtime;

import javax.jws.WebParam.Mode;


public class BatchRunProcess {
	private String externalPath;
	private String gwDataFolder;
	private String mainFile;
	private String svarFile;
	private String initFile;
	private String dvarFile;
	public String svFPart;
	private String initFPart;
	private String aPart;
	private String timeStep;
	public int startYear;
	public int startMonth;
	public int startDay;
	public int endYear;
	public int endMonth;
	public int endDay;
	private int runStartYear;
	private int runStartMonth;
	private int runStartDay;
	private int runEndYear;
	private int runEndMonth;
	private int runEndDay;
	private String wreslPlus;
	private String freeXA;
	private String allowSvTsInit;
	private String jarXA="XAOptimizer.jar";
	private int sid=1;
	private boolean afterFirstRound=false;
	private int ms=1;
	private boolean useMainFile=true;
	private int launchType;
	public int msDuration;
	public int msStartYear;
	public int msStartMonth;
	public int msStartDay;
	public int msEndYear;
	public int msEndMonth;
	public int msEndDay;
	public int paStartInterval;
	public int paDuration;
	public boolean deletePAInit;
	public int paDVStartYear;
	public int paDVStartMonth;
	public int paDVStartDay;
	public boolean resetOutputStart;
	public String paInitFile;
	public int paStartYear;
	public int paStartMonth;
	public int paStartDay;
	public int paEndYear;
	public int paEndMonth;
	public int paEndDay;
	
	private int terminateCode=0;
	private Process process;
	
	public boolean isRunning=false;
		
	public void launch(LaunchConfigInfo configuration, String launchFilePath) throws CoreException {		
		
		isRunning = true;
		terminateCode=0;
		
		ms=Integer.parseInt(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_MULTISTUDY, "1"));
		String lt=configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_LAUNCHTYPE, "0");
		launchType=Integer.parseInt(lt);
		
		getStartEndDate(configuration);
		afterFirstRound=false;
		sid=1;
		
		if (ms==1){	
			switch (launchType){
				case 0:
					useMainFile=true;
					regularLaunch(configuration, launchFilePath);
					break;
				case 1:
					paLaunch(configuration, launchFilePath);
					break;
			}
		}else{
			multiStudyRun(configuration, launchFilePath);
		}
		
		isRunning=false;
	}
	
	public void regularLaunch(LaunchConfigInfo configuration, String launchFilePath) throws CoreException{
			
		createBatch(configuration, launchFilePath);
		
		try {
			String engineFileFullPath = launchFilePath+".bat";
			process = Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c", "start", "/min", "/w", engineFileFullPath}, 
					null, null); 
			process.waitFor();
			terminateCode=process.exitValue();
		} catch (Exception e) {
			WPPException.handleException(e);
		}
		
	}
	
	public void paLaunch(LaunchConfigInfo configuration, String launchFilePath) throws CoreException{
		paProcConfig(configuration);
		PAProcInitBR procInit = new PAProcInitBR(configuration, sid);
		PAProcRunBR procRun = new PAProcRunBR();
		PAProcDVBR procDV = new PAProcDVBR(configuration);
		
		procInit.createPAInit(launchFilePath, this);
		procRun.initialPATime(this);
		procDV.deleteDVFile(launchFilePath);
		
		useMainFile=true;
		
		while (procRun.continueRun(this) && terminateCode==0){				
		
			createBatch(configuration, launchFilePath);
		
			try {
				String engineFileFullPath = launchFilePath+".bat";
				process = Runtime.getRuntime().exec(new String[] {"cmd", "/C", "start", "/min", "/w", engineFileFullPath}, 
						null, null); 		
				process.waitFor();
				terminateCode=process.exitValue();
				process.destroy();
			} catch (Exception e) {
				WPPException.handleException(e);
			}
			
			procDV.resetDVStartDate(this);
			procRun.updatePATime(this);
			procInit.createInitData(procRun, this);
			useMainFile=false;
		}
		procInit.deletePAInit(this);
		
	}
	
	public void multiStudyRun(LaunchConfigInfo configuration, String launchFilePath) throws CoreException{
		
		String isFixDuration=configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_ISFIXDURATION, "yes");
		if (isFixDuration.equals("yes")){
			DebugCorePlugin.msDuration=new int[1];
			DebugCorePlugin.msDuration[0]=Integer.parseInt(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_FIXEDDURATION, "12"));
		}else{
			String variableDuration=configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_VARIABLEDURATION, "");
			DebugCorePlugin.msDuration=MSRUtil.loadMSDuration(variableDuration, launchFilePath);
		}
		
		MSRDataTransferBR dataTxfr=new MSRDataTransferBR();
		dataTxfr.procDataTxfrFile(configuration, launchFilePath, ms);
		
		MSRProcRunBR msr=new MSRProcRunBR();
		msr.initialMSTime(this);
		runStartYear=msStartYear;
		runStartMonth=msStartMonth;
		runStartDay=msStartDay;
		runEndYear=msEndYear;
		runEndMonth=msEndMonth;
		runEndDay=msEndDay;
		
		useMainFile=true;
		while (msr.continueRun(this) && terminateCode==0){
			sid=1;
			while (sid<=ms && terminateCode==0){
				switch (launchType){
				case 0:
					regularLaunch(configuration, launchFilePath);
					break;
				case 1:
					paLaunch(configuration, launchFilePath);
					break;
				}
				if (sid<ms) dataTxfr.dataTxfr(sid, this);
				sid++;
			}
			msr.updateMSTime(this);
			runStartYear=msStartYear;
			runStartMonth=msStartMonth;
			runStartDay=msStartDay;
			runEndYear=msEndYear;
			runEndMonth=msEndMonth;
			runEndDay=msEndDay;
			afterFirstRound=true;
			useMainFile=false;
		}
	}
	
	public void paProcConfig(LaunchConfigInfo configuration){
		String paStartIntervalStr = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PASTARTINTERVAL, "12");
		paStartInterval=Integer.parseInt(paStartIntervalStr);
		
		String paDurationStr = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PADURATION, "12");
		paDuration=Integer.parseInt(paDurationStr);
		
		String initDelStr = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PADELINIT, "yes");
		if (initDelStr.equals("yes")){
			deletePAInit=true;
		}else{
			deletePAInit=false;
		}
		
		String defaultPADVStartYearStr;
		if (Calendar.getInstance().get(Calendar.MONTH)<=9){
			defaultPADVStartYearStr=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-1);
		}else{
			defaultPADVStartYearStr=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		String paDVStartYearStr = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTYEAR, defaultPADVStartYearStr);
		paDVStartYear=Integer.parseInt(paDVStartYearStr);
		
		String paDVStartMonthStr = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTMONTH, "10");
		paDVStartMonth=Integer.parseInt(paDVStartMonthStr);
		
		String paDVStartDayStr = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PADVSTARTDAY, "1");
		paDVStartDay=Integer.parseInt(paDVStartDayStr);
		
		String resetDVStartStr = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PARESETDVSTART, "no");
		if (resetDVStartStr.equals("yes")){
			resetOutputStart=true;
		}else{
			resetOutputStart=false;
		}
	}
	
	public void getStartEndDate(LaunchConfigInfo configuration){
		startYear = Integer.parseInt(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_STARTYEAR, (String)null));
		startMonth = TimeOperation.monthValue(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_STARTMONTH, (String)null));

		endYear = Integer.parseInt(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_ENDYEAR, (String)null));
		endMonth = TimeOperation.monthValue(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_ENDMONTH, (String)null));

		startDay= Integer.parseInt(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_STARTDAY, (String)null));
		endDay=Integer.parseInt(configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_ENDDAY, (String)null));
	}
	
	public void createBatch(LaunchConfigInfo configuration, String launchFilePath){
		
		String suffix="";
		if (sid>1) suffix="_MS"+sid;
		
		String lastSuffix="_MS"+ms;
		
		String studyName=null;
		studyName = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_STUDY, (String)null);
				
		String author=null;
		author = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_AUTHOR, (String)null);
			
		String date=null;
		date = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_DATE, (String)null);
		
		String description=null;
		description = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_DESCRIPTION, (String)null);
			
		mainFile = null;
		mainFile = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_PROGRAM+suffix, (String)null);
		
		dvarFile = null;
		dvarFile = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_DVARFILE+suffix, (String)null);
		
		svarFile = null;
		svarFile = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_SVARFILE+suffix, (String)null);
		
		initFile = null;
		initFile = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_INITFILE+suffix, (String)null);
		if (launchType==1){
			initFile=paInitFile;
		}else{
			if (afterFirstRound) {
				String lastDvarFile = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_DVARFILE+lastSuffix, (String)null);
				initFile=lastDvarFile;
			}
		}
		
		gwDataFolder = null;
		gwDataFolder = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_GWDATAFOLDER+suffix, (String)null)+File.separator;
		
		aPart = null;
		aPart = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_APART+suffix, (String)null);
		
		svFPart = null;
		svFPart = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_SVFPART+suffix, (String)null);
		
		initFPart = null;
		initFPart = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_INITFPART+suffix, (String)null);
		if (afterFirstRound){
			String lastSvFPart=configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_SVFPART+lastSuffix, (String)null);
			initFPart=lastSvFPart;
		}
		
		timeStep = null;
		timeStep = configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_TIMESTEP+suffix, (String)null);
		
		if (launchType==1){
			runStartYear=paStartYear;
			runStartMonth=paStartMonth;
			runStartDay = paStartDay;
			runEndYear=paEndYear;
			runEndMonth=paEndMonth;
			runEndDay = paEndDay;
		}else if (ms==1){
			runStartYear=startYear;
			runStartMonth=startMonth;
			runStartDay = startDay;
			runEndYear=endYear;
			runEndMonth=endMonth;
			runEndDay = endDay;
		}
		
		wreslPlus=configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_WRESLPLUS, "no");
		freeXA=configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_FREEXA, "no");
		if (freeXA.equalsIgnoreCase("yes")){
			jarXA="CalLiteV16.jar";
		}else{
			jarXA="XAOptimizer.jar";
		}
		allowSvTsInit=configuration.getStringAttribute(DebugCorePlugin.ATTR_WPP_ALLOWSVTSINIT, "no");
		
		String mainFileAbsPath;
		if (new File(mainFile).isAbsolute()){
			mainFileAbsPath = mainFile;
		}else{
			mainFileAbsPath = FileProcess.procRelativePath(mainFile, launchFilePath);
		}
		int index = mainFileAbsPath.lastIndexOf(File.separator);
		String mainDirectory = mainFileAbsPath.substring(0, index + 1);
		externalPath = mainDirectory + "External";
		
		String engineFileFullPath = launchFilePath+".bat";
		try {
			String configFilePath = generateConfigFile(configuration, mainFileAbsPath, launchFilePath);
			FileWriter debugFile = new FileWriter(engineFileFullPath);
			PrintWriter out = new PrintWriter(debugFile);
			generateBatch(out, configFilePath);
		}catch (IOException e) {
			WPPException.handleException(e);
		}
	}
	
	public void generateBatch(PrintWriter out, String configFilePath){
		out.println("@echo off");
		out.println("set path=" + externalPath + ";"+"lib;%path%");
		out.println("set temp_wrims2=jre\\bin");
		String xmx="1280m";
		if (System.getProperty("os.arch").equalsIgnoreCase("amd64")){
			xmx="4096m";
		}
		out.println("jre\\bin\\java -Xmx"+xmx+" -Xss1024K -Duser.timezone=UTC -Djava.library.path=\"" + externalPath + ";lib\" -cp \""+externalPath+";"+"lib\\external;lib\\WRIMSv2.jar;lib\\commons-io-2.1.jar;lib\\"+jarXA+";lib\\lpsolve55j.jar;lib\\coinor.jar;lib\\gurobi.jar;lib\\heclib.jar;lib\\jnios.jar;lib\\jpy.jar;lib\\misc.jar;lib\\pd.jar;lib\\vista.jar;lib\\guava-11.0.2.jar;lib\\javatuples-1.2.jar;lib\\kryo-2.24.0.jar;lib\\minlog-1.2.jar;lib\\objenesis-1.2.jar;\" wrimsv2.components.ControllerBatch "+"-config="+configFilePath);
		out.println("exit");
		out.close();
	}
	
	public String generateConfigFile(LaunchConfigInfo configuration, String mainFileAbsPath, String launchFilePath){
		
		Map<String, String> configMap = new HashMap<String, String>();
		String configFilePath = null;
		
		try {				
			
			configMap.put("MainFile".toLowerCase(), mainFile);
			configMap.put("DvarFile".toLowerCase(),   dvarFile);
			configMap.put("SvarFile".toLowerCase(),   svarFile);
			configMap.put("SvarAPart".toLowerCase(),  aPart);
			configMap.put("SvarFPart".toLowerCase(),  svFPart);
			configMap.put("InitFile".toLowerCase(),   initFile);
			configMap.put("InitFPart".toLowerCase(),  initFPart);
			configMap.put("TimeStep".toLowerCase(),   timeStep);
			configMap.put("StartYear".toLowerCase(),  String.valueOf(runStartYear));
			configMap.put("StopYear".toLowerCase(),   String.valueOf(runEndYear));
			configMap.put("StartMonth".toLowerCase(), String.valueOf(runStartMonth));
			configMap.put("StopMonth".toLowerCase(),  String.valueOf(runEndMonth));
			configMap.put("StartDay".toLowerCase(), String.valueOf(runStartDay));
			configMap.put("StopDay".toLowerCase(), String.valueOf(runEndDay));
			
			if (gwDataFolder.length()>0) {
				configMap.put("groundwaterdir".toLowerCase(), gwDataFolder);
			} else {
				configMap.put("groundwaterdir".toLowerCase(), ".");
			}
			
			configMap.put("ShowWreslLog".toLowerCase(), "No");			
			if (DebugCorePlugin.solver.equals("XA") && DebugCorePlugin.log.equals("Log")){
				configMap.put("Solver".toLowerCase(), DebugCorePlugin.solver+"LOG");
			}else{
				configMap.put("Solver".toLowerCase(), DebugCorePlugin.solver);
			}
				
			if (DebugCorePlugin.log.equals("Log")){
				configMap.put("IlpLog".toLowerCase(), "Yes");
				if (DebugCorePlugin.solver.equals("XA")){
					configMap.put("IlpLogFormat".toLowerCase(), "CplexLp");
				}else if (DebugCorePlugin.solver.equals("LPSolve")){
					configMap.put("IlpLogFormat".toLowerCase(), "LpSolve");
				}else if (DebugCorePlugin.solver.equals("CBC")){
					configMap.put("IlpLogFormat".toLowerCase(), "CplexLp");
				}
				configMap.put("IlpLogVarValue".toLowerCase(), "Yes");
				configMap.put("IlpLogAllCycles".toLowerCase(), "Yes");
			} else {
				configMap.put("IlpLog".toLowerCase(), "No");
				configMap.put("IlpLogFormat".toLowerCase(), "None");
				configMap.put("IlpLogVarValue".toLowerCase(), "No");
				configMap.put("IlpLogAllCycles".toLowerCase(), "No");
			}
			
			configMap.put("WreslPlus".toLowerCase(), wreslPlus);
			configMap.put("AllowSvTsInit".toLowerCase(), allowSvTsInit);
			
			if (launchType==1 || (ms>1 && afterFirstRound)){
				configMap.put("prefixinittodvarfile", "no");
			}
			
			String configName = launchFilePath +".config";
			File f = new File(configName);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			 
			out.println("##################################################################################");
			out.println("# Command line Example:");
			out.println("# C:\\wrimsv2_SG\\bin\\runConfig_limitedXA.bat D:\\example\\EXISTING_BO.config");
			out.println("# ");	
			out.println("# Note:");			
			out.println("# 1. This config file and the RUN directory must be placed in the same directory.");
			out.println("# 2. Use relative path to increase the portability.");
			out.println("#    For example, use RUN\\main.wresl for MainFile and DSS\\INIT.dss for InitFile");
			out.println("##################################################################################");	
			out.println("");
			out.println("");
			
			if (useMainFile){
				out.println("MainFile           "+mainFileAbsPath);
			}else{
				out.println("MainFile           "+mainFileAbsPath+".par");
			}
			out.println("Solver             "+configMap.get("solver".toLowerCase()));
			if (new File(dvarFile).isAbsolute()){
				out.println("DvarFile           "+dvarFile);
			}else{
				String procDvarFile=FileProcess.procRelativePath(dvarFile, launchFilePath);
				out.println("DvarFile           " + procDvarFile);
			}
			if (new File(svarFile).isAbsolute()){
				out.println("SvarFile           "+svarFile);
			}else{
				String procSvarFile=FileProcess.procRelativePath(svarFile, launchFilePath);
				out.println("SvarFile           "+procSvarFile);
			}
			if (new File(gwDataFolder).isAbsolute()){
				out.println("GroundwaterDir     "+gwDataFolder);
			}else{
				out.println("GroundwaterDir     "+FileProcess.procRelativePath(gwDataFolder, launchFilePath));
			}
			out.println("SvarAPart          "+configMap.get("SvarAPart".toLowerCase()));
			out.println("SvarFPart          "+configMap.get("SvarFPart".toLowerCase()));
			if (new File(initFile).isAbsolute()){
				out.println("InitFile           "+initFile);
			}else{
				String procInitFile=FileProcess.procRelativePath(initFile, launchFilePath);
				out.println("InitFile           "+procInitFile);
			}
			out.println("InitFPart          "+configMap.get("InitFPart".toLowerCase()));
			out.println("TimeStep           "+configMap.get("TimeStep".toLowerCase()));
			out.println("StartYear          "+configMap.get("StartYear".toLowerCase()));
			out.println("StartMonth         "+configMap.get("StartMonth".toLowerCase()));
			out.println("StartDay           "+configMap.get("StartDay".toLowerCase()));
			out.println("StopYear           "+configMap.get("StopYear".toLowerCase()));
			out.println("StopMonth          "+configMap.get("StopMonth".toLowerCase()));
			out.println("StopDay            "+configMap.get("StopDay".toLowerCase()));
			out.println("IlpLog             "+configMap.get("IlpLog".toLowerCase()));
			out.println("IlpLogFormat       "+configMap.get("IlpLogFormat".toLowerCase()));
			out.println("IlpLogVarValue     "+configMap.get("IlpLogVarValue".toLowerCase()));
			out.println("IlpLogAllCycles    "+configMap.get("IlpLogAllCycles".toLowerCase()));
			out.println("WreslPlus          "+configMap.get("WreslPlus".toLowerCase()));
			out.println("AllowSvTsInit      "+configMap.get("AllowSvTsInit".toLowerCase()));
			
			if (DebugCorePlugin.solver.equalsIgnoreCase("LpSolve")) {
				
				out.println("LpSolveConfigFile         callite.lpsolve");
				out.println("LpSolveNumberOfRetries    2");				
				
			}
			if (launchType==1 || (ms>1 && afterFirstRound)){
				out.println("prefixinittodvarfile  "+configMap.get("prefixinittodvarfile"));
			}
			
			out.close();
		
			configFilePath= new File(configName).getAbsolutePath();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return configFilePath;
			
	}
	
	/**
	 * Throws an exception with a new status containing the given
	 * message and optional exception.
	 * 
	 * @param message error message
	 * @param e underlying exception
	 * @throws CoreException
	 */
	private void abort(String message, Throwable e) throws CoreException {
		throw new CoreException(new Status(IStatus.ERROR, DebugCorePlugin.getDefault().getDescriptor().getUniqueIdentifier(), 0, message, e));
	}
	
	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free port.
	 * 
	 * @return a free port number on localhost, or -1 if unable to find a free port
	 */
	
	public void terminate(String engineFilePath){
		if (process !=null){
			try {
				process.destroy();
				Runtime.getRuntime().exec("taskkill /t /f /fi \"WINDOWTITLE eq C:\\Windows\\System32\\cmd.exe - "+engineFilePath.toLowerCase()+"\"");
			} catch (IOException e) {
				WPPException.handleException(e);
			}
		}
		terminateCode=1;
		isRunning=false;
	}
}
