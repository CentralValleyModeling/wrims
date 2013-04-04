package wrimsv2.config;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.FilenameUtils;

import wrimsv2.components.BuildProps;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.Error;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.ilp.ILP;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslplus.elements.ParamTemp;
import wrimsv2.wreslplus.elements.ParserUtils;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class ConfigUtils {

	private static Map<String, String> argsMap;

	public static LinkedHashMap<String, ParamTemp> paramMap = new LinkedHashMap<String, ParamTemp>();
	
	public static void loadArgs(String[] args) {

		// for Error.log header
		ControlData.currEvalTypeIndex=8;
		
		// print version number then exit
		if (args.length==1 && args[0].equalsIgnoreCase("-version") ) {
		
			System.out.println("WRIMS "+new BuildProps().getSVN());
			System.exit(0);
		}
		
		
		
		argsMap = new HashMap<String, String>();

		for (int i = 0; i < args.length; i++) {

			try {
				String key = args[i].substring(0, args[i].indexOf("="));
				String val = args[i].substring(args[i].indexOf("=") + 1, args[i].length());
				val=val.replaceAll("\"", "");

				argsMap.put(key.toLowerCase(), val); 

			}
			catch (Exception e) {
				System.out.println("Example: ");
				System.out.println("-config=\"D:\\test\\example.config\"");
//				System.out.println("Example: ");
//				System.out.println("-mainwresl=\"C:\\study\\main.wresl\"");
				System.exit(1);
			}

			//System.out.println(argsMap);

		}


		
		// load config file
		if (argsMap.keySet().contains("-config")) {
			
			String configFilePath = FilenameUtils.removeExtension(argsMap.get("-config"))+".config";
			argsMap.put("-config", configFilePath);
			
			System.out.println("\nWARNING!! Config file and RUN directory must be placed in the same folder! \n");
			System.out.println("Loading config file: "+argsMap.get("-config"));
			StudyUtils.configFilePath = argsMap.get("-config");
			loadConfig(StudyUtils.configFilePath);
			if (Error.getTotalError()>0) {
				Error.writeErrorLog();
			}
			
		// compile to serial object named *.par
		} else if (argsMap.keySet().contains("-mainwresl")) {

			System.out.println("Compiling main wresl file: "+argsMap.get("-mainwresl"));
			StudyUtils.compileOnly = true;
			FilePaths.setMainFilePaths(argsMap.get("-mainwresl"));

		} else {
			System.out.println("Example: ");
			System.out.println("-config=\"D:\\test\\example.config\"");
//			System.out.println("Example: ");
//			System.out.println("-mainwresl=\"C:\\study\\main.wresl\"");
			System.exit(1);
		}

	}

	private static void loadConfig(String configFile) {

		//StudyUtils.config_errors = 0; // reset

		Map<String, String> configMap = new HashMap<String, String>();

		configMap = checkConfigFile(configFile);
		
		String mainfile = configMap.get("mainfile").toLowerCase();
		
		String mainFilePath = "";
		
		if (mainfile.contains(":")){
			mainFilePath =  new File(mainfile).getAbsolutePath();
		} else { 
			mainFilePath =  new File(StudyUtils.configDir, mainfile).getAbsolutePath();
		}
		
		File validatedAbsFile = new File(mainFilePath).getAbsoluteFile();
		if (!validatedAbsFile.exists()) { 
			Error.addConfigError("File not found: " + mainFilePath); 
			Error.writeErrorLog();
		}
		
		if (mainfile.endsWith(".par")) {
			StudyUtils.loadParserData = true;
			StudyUtils.parserDataPath = mainFilePath;		
			FilePaths.setMainFilePaths(mainFilePath);
		}
		else if (mainfile.endsWith(".wresl")) {
			FilePaths.setMainFilePaths(mainFilePath);
		}
		else {
			Error.addConfigError("Invalid main file extension: " + configMap.get("mainfile"));
			Error.writeErrorLog();
			//System.out.println("Invalid main file extension: " + configMap.get("mainfile"));
			//System.out.println("Specify either *.wresl or *.par");
			//System.exit(1);
		}

		// FilePaths.mainDirectory = configMap.get("maindir");
		System.out.println("MainFile:       "+FilePaths.fullMainPath);
		
		try {
			
			if (configMap.get("groundwaterdir").length()>0) {
				if (configMap.get("groundwaterdir").contains(":")){
					FilePaths.groundwaterDir =  new File(configMap.get("groundwaterdir")).getCanonicalPath()+File.separator;
				} else { 
					FilePaths.groundwaterDir =  new File(StudyUtils.configDir, configMap.get("groundwaterdir")).getCanonicalPath()+File.separator;
				}
				System.out.println("GroundWaterDir: "+FilePaths.groundwaterDir);
			} else {
				FilePaths.groundwaterDir = "None";
			}
			
			if (configMap.get("svarfile").contains(":")){
				FilePaths.setSvarDssPaths(new File(configMap.get("svarfile")).getCanonicalPath());
			} else {
				FilePaths.setSvarDssPaths(new File(StudyUtils.configDir, configMap.get("svarfile")).getCanonicalPath());
			}
			System.out.println("SvarFile:       "+FilePaths.fullSvarDssPath);
			
			if (configMap.get("initfile").contains(":")){
				FilePaths.setInitDssPaths(new File(configMap.get("initfile")).getCanonicalPath());
			} else {
				FilePaths.setInitDssPaths(new File(StudyUtils.configDir, configMap.get("initfile")).getCanonicalPath());
			}
			System.out.println("InitFile:       "+FilePaths.fullInitDssPath);
			
			if (configMap.get("dvarfile").contains(":")) {
				FilePaths.setDvarDssPaths(new File(configMap.get("dvarfile")).getCanonicalPath());
			} else {
				FilePaths.setDvarDssPaths(new File(StudyUtils.configDir, configMap.get("dvarfile")).getCanonicalPath());
			}
			System.out.println("DvarFile:       "+FilePaths.fullDvarDssPath);
		
		} catch (IOException e){
			Error.addConfigError("Invalid file path in config file");
			Error.writeErrorLog();
			//System.out.println("Invalid file path");
			e.printStackTrace();
		}
		
		StudyUtils.configFileName = new File(configFile).getName();
		
		FilePaths.csvFolderName = "";

		if (configMap.get("showwresllog").equalsIgnoreCase("no") || configMap.get("showwresllog").equalsIgnoreCase("false")){
			ControlData.showWreslLog = false;
		}
		if (configMap.get("lookupsubdir").length()>0 ){
			FilePaths.lookupSubDirectory = configMap.get("lookupsubdir");
			System.out.println("LookupSubDir:   "+FilePaths.lookupSubDirectory);
		}
		//ControlData.showWreslLog = !(configMap.get("showwresllog").equalsIgnoreCase("no"));
		
		ControlData.svDvPartF = configMap.get("svarfpart");
		ControlData.initPartF = configMap.get("initfpart");
		ControlData.partA = configMap.get("svarapart");
		ControlData.partE = configMap.get("timestep");
		ControlData.timeStep = configMap.get("timestep");

		ControlData.startYear = Integer.parseInt(configMap.get("startyear"));
		ControlData.startMonth = Integer.parseInt(configMap.get("startmonth"));
		ControlData.startDay = Integer.parseInt(configMap.get("startday"));

		ControlData.endYear = Integer.parseInt(configMap.get("stopyear"));
		ControlData.endMonth = Integer.parseInt(configMap.get("stopmonth"));
		ControlData.endDay = Integer.parseInt(configMap.get("stopday"));

		ControlData.solverName = configMap.get("solver");
		
		ControlData.currYear = ControlData.startYear;
		ControlData.currMonth = ControlData.startMonth;
		ControlData.currDay = ControlData.startDay;
		
		System.out.println("TimeStep:       "+ControlData.timeStep);
		System.out.println("SvarAPart:      "+ControlData.partA);
		System.out.println("SvarFPart:      "+ControlData.svDvPartF);
		System.out.println("InitFPart:      "+ControlData.initPartF);
		System.out.println("StartYear:      "+ControlData.startYear);
		System.out.println("StartMonth:     "+ControlData.startMonth);
		System.out.println("StopYear:       "+ControlData.endYear);
		System.out.println("StopMonth:      "+ControlData.endMonth);
		System.out.println("Solver:         "+ControlData.solverName);
		
		final String[] solvers = {"xa","xalog","lpsolve","gurobi","cbc"};

		if (!Arrays.asList(solvers).contains(ControlData.solverName.toLowerCase())){
			Error.addConfigError("Solver name not recognized: "+ControlData.solverName);
			Error.writeErrorLog();
		 }
		
		// SendAliasToDvar default is false
		if (configMap.keySet().contains("sendaliastodvar")){
			
			String s = configMap.get("sendaliastodvar");
			
			if (s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true")){
				ControlData.sendAliasToDvar = true;	
			} else if (s.equalsIgnoreCase("no") || s.equalsIgnoreCase("false")){
				ControlData.sendAliasToDvar = false;	
			} else {
				ControlData.sendAliasToDvar  = false;	
			}
			
		}
		System.out.println("SendAliasToDvar: "+ControlData.sendAliasToDvar);
		
		// PrefixInitToDvarFile
		// default is false in controllerBatch but true in other controller
		if (configMap.keySet().contains("prefixinittodvarfile")){
			
			String s = configMap.get("prefixinittodvarfile");
			
			if (s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true")){
				ControlData.writeInitToDVOutput = true;	
			} else if (s.equalsIgnoreCase("no") || s.equalsIgnoreCase("false")){
				ControlData.writeInitToDVOutput = false;	
			} else {
				ControlData.writeInitToDVOutput = false;	
			}
		}
		System.out.println("PrefixInitToDvarFile: "+ControlData.writeInitToDVOutput);

		
		
		if (ControlData.solverName.equalsIgnoreCase("lpsolve")) {
			
			// LpSolveConfigFile
			if (configMap.keySet().contains("lpsolveconfigfile")) {

				String f = configMap.get("lpsolveconfigfile");

				try {

					File sf = new File(StudyUtils.configDir, f);
					if (sf.exists()) {					
						LPSolveSolver.configFile = sf.getCanonicalPath();
					} else {
						//System.out.println("#Error: LpSolveConfigFile not found: " + f);
						Error.addConfigError("LpSolveConfigFile not found: " + f);
						Error.writeErrorLog();
					}

				} catch (Exception e) {
					Error.addConfigError("LpSolveConfigFile not found: " + f);
					Error.writeErrorLog();
					//System.out.println("#Error: LpSolveConfigFile not found: " + f);
					e.printStackTrace();
				}
			} else {
				Error.addConfigError("LpSolveConfigFile not defined. ");
				Error.writeErrorLog();
				//System.out.println("#Error: LpSolveConfigFile not defined. ");
			}
		
			System.out.println("LpSolveConfigFile:   "+LPSolveSolver.configFile);
			
			
			// LpSolveNumberOfRetries default is 0 retry
			if (configMap.keySet().contains("lpsolvenumberofretries")){
				
				String s = configMap.get("lpsolvenumberofretries");
				
				try {
					LPSolveSolver.numberOfRetries = Integer.parseInt(s);
					
				} catch (Exception e) {
					//System.out.println("#Error: LpSolveNumberOfRetries not recognized: " + s);
					Error.addConfigError("LpSolveNumberOfRetries not recognized: " + s);
					Error.writeErrorLog();
					
				}				
			}
			System.out.println("LpSolveNumberOfRetries: "+LPSolveSolver.numberOfRetries);
			
			
		}
		
		// processed only for ILP
		
		// TODO: lpsolve and ilp log is binded. need to enable direct linking instead of reading file
		if(ControlData.solverName.equalsIgnoreCase("XALOG")){
			configMap.put("ilplog","yes");
			ILP.loggingCplexLp = true;
		}else if (ControlData.solverName.equalsIgnoreCase("lpsolve")) {
			configMap.put("ilplog","yes");
			ILP.loggingLpSolve = true;
		}else if (ControlData.solverName.equalsIgnoreCase("Gurobi")) {
			configMap.put("ilplog","yes");
			ILP.loggingCplexLp = true;
		}		
		
		String strIlpLog = configMap.get("ilplog");
		if (strIlpLog.equalsIgnoreCase("yes") || strIlpLog.equalsIgnoreCase("true")) {

			ILP.logging = true;
			// IlpLogVarValue
			// default is true
			if (configMap.keySet().contains("ilplogvarvalue")) {

				String s = configMap.get("ilplogvarvalue");

				if (s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true")) {
					ILP.loggingVariableValue = true;
				}
				else if (s.equalsIgnoreCase("no") || s.equalsIgnoreCase("false")) {
					ILP.loggingVariableValue = false;
				}
				else {
					ILP.loggingVariableValue = false;
				}
			}

			// IlpLogMaximumFractionDigits
			// default is 8
			if (configMap.keySet().contains("ilplogmaximumfractiondigits")) {

				String s = configMap.get("ilplogmaximumfractiondigits");
				int d;

				try {
					d = Integer.parseInt(s);
					ILP.maximumFractionDigits = d;

				}
				catch (Exception e) {

					Error.addConfigError("IlpLogMaximumFractionDigits not recognized: " + s);
					Error.writeErrorLog();
				}
			}
			
			if (configMap.keySet().contains("ilplogformat")) {

				String s = configMap.get("ilplogformat");

				if (s.toLowerCase().contains("cplexlp")) {
					ILP.loggingCplexLp = true;
					System.out.println("IlpLogFormat:           " + "CplexLp");
				} 
				if (s.toLowerCase().contains("mpmodel")) {
					ILP.loggingMPModel = true;
					System.out.println("IlpLogFormat:           " + "MPModel");
				} 
				if (s.toLowerCase().contains("ampl")) {
					ILP.loggingAmpl = true;
					System.out.println("IlpLogFormat:           " + "Ampl");
				} 
				if (s.toLowerCase().contains("lpsolve")) {
					ILP.loggingLpSolve = true;
					System.out.println("IlpLogFormat:           " + "LpSolve");
				} 
			}

			System.out.println("IlpLog:                 " + ILP.logging);
			System.out.println("IlpLogVarValue:         " + ILP.loggingVariableValue);
			System.out.println("IlpLogMaximumFractionDigits: " + ILP.maximumFractionDigits);

		}
		
		String s = configMap.get("wreslplus");
		
		if (s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true")){
			StudyUtils.useWreslPlus = true;	
		} else if (s.equalsIgnoreCase("no") || s.equalsIgnoreCase("false")){
			StudyUtils.useWreslPlus = false;	
		} else {
			StudyUtils.useWreslPlus  = false;	
		}
		System.out.println("WreslPlus:         " + StudyUtils.useWreslPlus);
		
		
		
		
		//if (Error.getTotalError()<1) readParameter(configFile);
		
//		if (Error.getTotalError()<1 && paramMap.size()>0) { 
//			System.out.println("--------------------------------------------");
//			for (String k: paramMap.keySet()){	
//				ParamTemp pt = paramMap.get(k);
//				System.out.println("Parameter::   "+k+": "+pt.expression );
//			}
//		}
		
		
		
		
//		if (configMap.keySet().contains("lpsolveparamheader")){
//			
//			String s = configMap.get("lpsolveparamheader");
//			
//			String delimiter = "[\\+]";  
//			String [] pheaders =  s.split(delimiter);
//			
//			//LPSolveSolver.paramHeader = new ArrayList<String>();
//			
//			System.out.println( "s:"+s);
//			
//			for (int i=1;i<=pheaders.length;i++){
//				System.out.println( pheaders[i-1]);
//			}
//			
//			for (int i=1;i<=pheaders.length;i++){
//				
//				String h = pheaders[i-1];		
//				
//				LPSolveSolver.paramHeader.add(h);
//				
//				//System.out.println("LpSolveParamFile: "+pf);
//				switch (i){
//					case 1 : System.out.println("default LpSolveParamHeader: "+h); break;
//					case 2 : System.out.println("2nd try LpSolveParamHeader: "+h); break;
//					case 3 : System.out.println("3rd try LpSolveParamHeader: "+h); break;
//					default : System.out.println( i+"th try LpSolveParamHeader: "+h); break;
//				}
//				
//			}
//			
//
//		}
		//System.out.println("Ignored... SetAmplOption:   option presolve_eps 1e-13;");
		
		
		
		// System.out.println("gw: "+FilePaths.groundwaterDir);
		// System.out.println("svd: "+FilePaths.svarDssDirectory);
		// System.out.println("sv: "+FilePaths.svarDssFile);
		// System.out.println("initD: "+FilePaths.initDssDirectory);
		// System.out.println("init: "+FilePaths.initDssFile);
		//
		//
		// System.out.println(FilePaths.mainDirectory);
		// System.out.println(FilePaths.groundwaterDir);
		// System.out.println(FilePaths.csvFolderName);
		//
		// System.out.println(ControlData.svDvPartF);
		// System.out.println(ControlData.initPartF);
		// System.out.println(ControlData.partA);
		// System.out.println(ControlData.partE);
		// System.out.println(ControlData.timeStep);
		//
		// System.out.println(ControlData.startYear);
		// System.out.println(ControlData.startMonth);
		// System.out.println(ControlData.startDay);
		//
		// System.out.println(ControlData.endYear);
		// System.out.println(ControlData.endMonth);
		// System.out.println(ControlData.endDay);
		//
		// System.out.println(ControlData.solverName);
		// System.out.println(ControlData.currYear);
		// System.out.println(ControlData.currMonth);
		// System.out.println(ControlData.currDay);
		// System.out.println(ControlData.writeDssStartYear);
		// System.out.println(ControlData.writeDssStartMonth);
		// System.out.println(ControlData.writeDssStartDay);
		//
		// System.out.println(ControlData.totalTimeStep);
		// System.exit(0);

	}

	private static Map<String, String> checkConfigFile(String configFilePath) {

		final File configFile = new File(configFilePath);

		
		try {
			StudyUtils.configFileCanonicalPath = configFile.getCanonicalPath();
			StudyUtils.configDir = configFile.getParentFile().getCanonicalPath();
		} catch (Exception e) {

			Error.addConfigError("Config file not found: " + configFilePath);

		} finally {
			if (!configFile.exists()){

				Error.addConfigError("Config file not found: " + configFilePath);
				
			}			
		}		

		Map<String, String> configMap = setDefaultConfig();

		try {

			Scanner scanner = new Scanner(configFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				line = line.trim();
				line = line.replace('\t', ' ');
				//System.out.println(line);
				if (line.indexOf("#") > -1) {
					line = line.substring(0, line.indexOf("#"));
					line = line.trim();
				}
				if (line.indexOf(" ") < 0) continue;
				if (line.lastIndexOf(" ") + 1 >= line.length()) continue;
				if (line.length() < 5) continue;
				
				//System.out.println(line);

				String key = line.substring(0, line.indexOf(" "));

				String value = line.substring(key.length(), line.length());

				value = value.trim();
				value = value + " ";
				if (value.startsWith("\"")) {
					value = value.substring(1, value.lastIndexOf("\""));
					value = value.replace("\"", "");
				}
				else {
					value = value.substring(0, value.indexOf(" "));
					value = value.replace("\"", "");
				}
				
				// break at the line "End Config"
				if (key.equalsIgnoreCase("end") & value.equalsIgnoreCase("config") ) break;
			
				configMap.put(key.toLowerCase(), value);
			}

		}
		catch (Exception e) {

			Error.addConfigError("Invalid Config File: " + configFilePath);

		}

		
		// check missing fields
		String[] requiredFields = { "MainFile", "Solver", "DvarFile", "SvarFile", "SvarAPart",
				"SvarFPart", "InitFile", "InitFPart", "TimeStep", "StartYear", "StartMonth" };

		for (String k : requiredFields) {
			if (!configMap.keySet().contains(k.toLowerCase())) {

				Error.addConfigError("Config file missing field: " + k);
				Error.writeErrorLog();

			}
		}	
		
		// convert number of steps to end date
		int bYr= Integer.parseInt(configMap.get("startyear"));
		int bMon= Integer.parseInt(configMap.get("startmonth"));
		
		if (configMap.keySet().contains("numberofsteps")){
			
			int nsteps = Integer.parseInt(configMap.get("numberofsteps"));
			
			int iBegin = bYr*12 + bMon;
			int iEnd = iBegin + nsteps -1 ; 
					
			int eYr = iEnd/12;
			int eMon = iEnd%12;
			
			configMap.put("stopyear", Integer.toString(eYr));
			configMap.put("stopmonth", Integer.toString(eMon));
			
		} else {
			// check missing fields
			String[] endDateFields = {"StopYear", "StopMonth"};

			for (String k : endDateFields) {
				if (!configMap.keySet().contains(k.toLowerCase())) {

					Error.addConfigError("Config file missing field: " + k);
					Error.writeErrorLog();

				}
			}			
		}
		
		// fill-in start day and end day
		
		int bday=TimeOperation.numberOfDays(bMon, bYr);
		//configMap.put("startday", Integer.toString(bday));
		
		int endYr= Integer.parseInt(configMap.get("stopyear"));
		int endMon= Integer.parseInt(configMap.get("stopmonth"));
		int endday= TimeOperation.numberOfDays(endMon, endYr);
		//configMap.put("stopday", Integer.toString(endday));		
		
		
		// support only monthly time step
		if (!configMap.get("timestep").equalsIgnoreCase("1mon")){

			Error.addConfigError("Only monthly timestep supported, i.e., \"TimeStep  1MON\" ");
			Error.writeErrorLog();

		}
		
		

		// TODO: duplcate codes. clean it up!
		
		File mf = null;
		String mainfile = configMap.get("mainfile");
		
		if (mainfile.contains(":")){
			mf = new File(mainfile);
		} else { 
			mf = new File(StudyUtils.configDir, mainfile);
		}
		
		
		try {
			mf.getCanonicalPath();
		}
		catch (IOException e) {

			Error.addConfigError("Main file not found: "+mf.getAbsolutePath());
			Error.writeErrorLog();
	
		}
		
		return configMap;

	}

	private static Map<String, String> setDefaultConfig() {

		Map<String, String> configMap = new HashMap<String, String>();

		configMap.put("saveparserdata".toLowerCase(), "No");
		configMap.put("solver".toLowerCase(), "XA");
		configMap.put("timestep".toLowerCase(), "1MON");
		configMap.put("showwresllog".toLowerCase(), "yes");
		configMap.put("groundwaterdir".toLowerCase(), "");
		configMap.put("lookupsubdir".toLowerCase(), "");
		configMap.put("IlpLog".toLowerCase(), "no");
		configMap.put("IlpLogVarValue".toLowerCase(), "no");
		configMap.put("WreslPlus".toLowerCase(), "no");


		return configMap;

	}

	private static void readParameter(String configFilePath) {
	
		final File configFile = new File(configFilePath);	
	
		boolean isParameter = false;
		
		paramMap = new LinkedHashMap<String, ParamTemp>();
	
		try {
	
			Scanner scanner = new Scanner(configFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
	
				line = line.trim();
				line = line.replace('\t', ' ');
				//System.out.println(line);
				if (line.indexOf("#") > -1) {
					line = line.substring(0, line.indexOf("#"));
					line = line.trim();
				}
				if (line.indexOf(" ") < 0) continue;
				if (line.lastIndexOf(" ") + 1 >= line.length()) continue;
				if (line.length() < 5) continue;
				
				//System.out.println(line);
	
				String key = line.substring(0, line.indexOf(" "));
	
				String value = line.substring(key.length(), line.length());
	
				value = value.trim();
				value = value + " ";
				if (value.startsWith("\"")) {
					value = value.substring(1, value.lastIndexOf("\""));
					value = value.replace("\"", "");
				}
				else {
					value = value.substring(0, value.indexOf(" "));
					value = value.replace("\"", "");
				}
				
				// break at the line "End Parameter"
				if (key.equalsIgnoreCase("end") & value.equalsIgnoreCase("initial") ) break;
			
				if (key.equalsIgnoreCase("begin") & value.equalsIgnoreCase("initial") ) {
					isParameter = true;
					System.out.println("--------------------------------------------");
					continue;
				}
				
				if (isParameter) {
					
					if (paramMap.keySet().contains(key.toLowerCase())) {
						
						Error.addConfigError("Initial variable ["+key+"] is redefined");
						
					}
					
					ParamTemp pt = new ParamTemp();
					pt.id = key;
					pt.expression = value.toLowerCase();
					
					System.out.println("Initial variable::  "+pt.id.toLowerCase()+": "+pt.expression );
					
					try {
						//pt.dependants = checkExpression(pt.expression);
						Float.parseFloat(pt.expression);
					} catch (Exception e) {
						Error.addConfigError("Initial variable ["+key+"] in Config file must be assigned with a number, but it's ["+pt.expression+"]");
					}
					
					paramMap.put(key.toLowerCase(), pt);
				}
			}
	
		}
		catch (Exception e) {
	
			Error.addConfigError("Exception in parsing [Initial] section: " + configFilePath);
	
		}
	
		//return paramMap;
	
	}

	private static Set<String> checkExpression(String text) throws RecognitionException {
			
			WreslPlusParser parser = ParserUtils.initParserSimple(text);
			
			parser.expression_simple();
			
			return parser.dependants;
		
	}

	// private static void loadConfig2(String loadFile) throws IOException {
	//
	// try {
	// XmlDocument doc = XmlDocument.createXmlDocument(
	// new FileInputStream(loadFile), false);
	// fromXml(doc.getDocumentElement());
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new IOException("Invalid config file: " + loadFile);
	// }
	//
	// }

	// private static void fromXml(Element se) {
	//
	// _parserdataversion = se.getAttribute("parserdataversion");
	// _groundwaterfolder = se.getAttribute("groundwaterfolder");
	// _wreslfile = se.getAttribute("wreslfile");
	// _svfile = se.getAttribute("svfile");
	// _dvfile = se.getAttribute("dvfile");
	// _initfile = se.getAttribute("initfile");
	//
	// _svfileapart = se.getAttribute("svfileapart");
	// _svfilefpart = se.getAttribute("svfilefpart");
	// _initfilefpart = se.getAttribute("initfilefpart");
	//
	// String startMonth = se.getAttribute("startmo");
	// String startYear = se.getAttribute("startyr");
	// String stopMonth = se.getAttribute("stopmo");
	// String stopYear = se.getAttribute("stopyr");
	//
	// try {
	//
	// _startmo = TimeOperation.monthValue(startMonth.toLowerCase());
	// _startyr = Integer.parseInt(startYear);
	// _stopmo = TimeOperation.monthValue(stopMonth.toLowerCase());
	// _stopyr = Integer.parseInt(stopYear);
	//
	//
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	//
	//
	// FilePaths.setMainFilePaths(_wreslfile);
	// FilePaths.groundwaterDir= _groundwaterfolder;
	// FilePaths.setSvarDssPaths(_svfile);
	// FilePaths.setInitDssPaths(_initfile);
	// FilePaths.setDvarDssPaths(_dvfile);
	// FilePaths.csvFolderName = "";
	//
	// ControlData.svDvPartF = _svfilefpart;
	// ControlData.initPartF = _initfilefpart;
	// ControlData.partA = _svfileapart;
	// ControlData.partE = _ts;
	// ControlData.timeStep = _ts;
	//
	// ControlData.startYear = _startyr;
	// ControlData.startMonth = _startmo;
	// ControlData.startDay = TimeOperation.numberOfDays(_startmo, _startyr);
	//
	// ControlData.endYear = _stopyr;
	// ControlData.endMonth = _stopmo;
	// ControlData.endDay = TimeOperation.numberOfDays(_stopmo, _stopyr);
	//
	// ControlData.solverName= _solver;
	// ControlData.currYear=ControlData.startYear;
	// ControlData.currMonth=ControlData.startMonth;
	// ControlData.currDay=ControlData.startDay;
	// ControlData.writeDssStartYear=ControlData.startYear;
	// ControlData.writeDssStartMonth=ControlData.startMonth;
	// ControlData.writeDssStartDay=ControlData.startDay;
	//
	// ControlData.totalTimeStep = ControllerBatch.getTotalTimeStep();
	// }

}
