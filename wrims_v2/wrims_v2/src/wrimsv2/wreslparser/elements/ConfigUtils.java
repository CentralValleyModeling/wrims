package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.FilePaths;
import wrimsv2.components.Versions;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.solver.LPSolveSolver;

public class ConfigUtils {

	private static Map<String, String> argsMap;

	public static void loadArgs(String[] args) {


		// print version number then exit
		if (args.length==1 && args[0].equalsIgnoreCase("-version") ) {
		
			System.out.println("WRIMS "+new Versions().getComplete());
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

		StudyUtils.config_errors = 0; // reset

		Map<String, String> configMap = new HashMap<String, String>();

		configMap = checkConfigFile(configFile);


		String mainfile = configMap.get("mainfile").toLowerCase();
		String mainFilePath = new File(StudyUtils.configDir, mainfile).getAbsolutePath();
		
		if (mainfile.endsWith(".par")) {
			StudyUtils.loadParserData = true;
			StudyUtils.parserDataPath = mainFilePath;		
			FilePaths.setMainFilePaths(mainFilePath);
		}
		else if (mainfile.endsWith(".wresl")) {
			FilePaths.setMainFilePaths(mainFilePath);
		}
		else {
			System.out.println("Invalid main file extension: " + configMap.get("mainfile"));
			System.out.println("Specify either *.wresl or *.par");
			System.exit(1);
		}

		// FilePaths.mainDirectory = configMap.get("maindir");
		try {
			FilePaths.groundwaterDir =  new File(StudyUtils.configDir, configMap.get("groundwaterdir")).getCanonicalPath()+"\\";
			System.out.println("GroundWaterDir: "+FilePaths.groundwaterDir);
			FilePaths.setSvarDssPaths(new File(StudyUtils.configDir, configMap.get("svarfile")).getCanonicalPath());
			System.out.println("SvarFile:       "+FilePaths.fullSvarDssPath);
			FilePaths.setInitDssPaths(new File(StudyUtils.configDir, configMap.get("initfile")).getCanonicalPath());
			System.out.println("InitFile:       "+FilePaths.fullInitDssPath);
			FilePaths.setDvarDssPaths(new File(StudyUtils.configDir, configMap.get("dvarfile")).getCanonicalPath());
			System.out.println("DvarFile:       "+FilePaths.fullDvarDssPath);
		} catch (IOException e){
			System.out.println("Invalid file path");
			e.printStackTrace();
		}
		
		StudyUtils.configFileName = new File(configFile).getName();
		
		FilePaths.csvFolderName = "";

		if (configMap.get("showwresllog").equalsIgnoreCase("no") || configMap.get("showwresllog").equalsIgnoreCase("false")){
			ControlData.showWreslLog = false;
		}
		//ControlData.showWreslLog = !(configMap.get("showwresllog").equalsIgnoreCase("no"));
		
		ControlData.svDvPartF = configMap.get("svarfpart");
		ControlData.initPartF = configMap.get("initfpart");
		ControlData.partA = configMap.get("svarapart");
		ControlData.partE = configMap.get("timestep");
		ControlData.timeStep = configMap.get("timestep");

		ControlData.startYear = Integer.parseInt(configMap.get("startyear"));
		ControlData.startMonth = Integer.parseInt(configMap.get("startmonth"));
		ControlData.startDay = TimeOperation.numberOfDays(ControlData.startMonth, ControlData.startYear);

		ControlData.endYear = Integer.parseInt(configMap.get("stopyear"));
		ControlData.endMonth = Integer.parseInt(configMap.get("stopmonth"));
		ControlData.endDay = TimeOperation.numberOfDays(ControlData.endMonth, ControlData.endYear);

		ControlData.solverName = configMap.get("solver");
		ControlData.currYear = ControlData.startYear;
		ControlData.currMonth = ControlData.startMonth;
		ControlData.currDay = ControlData.startDay;
		ControlData.writeDssStartYear = ControlData.startYear;
		ControlData.writeDssStartMonth = ControlData.startMonth;
		ControlData.writeDssStartDay = ControlData.startDay;

		System.out.println("TimeStep:       "+ControlData.timeStep);
		System.out.println("SvarAPart:      "+ControlData.partA);
		System.out.println("SvarFPart:      "+ControlData.svDvPartF);
		System.out.println("InitFPart:      "+ControlData.initPartF);
		System.out.println("StartYear:      "+ControlData.startYear);
		System.out.println("StartMonth:     "+ControlData.startMonth);
		System.out.println("StopYear:       "+ControlData.endYear);
		System.out.println("StopMonth:      "+ControlData.endMonth);
		System.out.println("Solver:         "+ControlData.solverName);
		
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

		
		
		if (ControlData.solverName.toLowerCase().contains("lpsolve")) {
			
			// LpSolveSettingFile
			if (configMap.keySet().contains("lpsolvesettingfile")) {

				String f = configMap.get("lpsolvesettingfile");

				try {

					File sf = new File(StudyUtils.configDir, f);
					if (sf.exists()) {					
						LPSolveSolver.settingFile = sf.getCanonicalPath();
					} else {
						System.out.println("#Error: LpSolveSettingFile not found: " + f);					
					}

				} catch (Exception e) {

					System.out.println("#Error: LpSolveSettingFile not found: " + f);
					e.printStackTrace();
				}
			} else {
				System.out.println("#Error: LpSolveSettingFile not defined. ");
			}
		
			System.out.println("LpSolveSettingFile:   "+LPSolveSolver.settingFile);
			
			
			// LpSolveNumberOfRetries default is 0 retry
			if (configMap.keySet().contains("lpsolvenumberofretries")){
				
				String s = configMap.get("lpsolvenumberofretries");
				
				try {
					LPSolveSolver.numberOfRetries = Integer.parseInt(s);
					
				} catch (Exception e) {
					System.out.println("#Error: LpSolveNumberOfRetries not recognized: " + s);
					
				}				
			}
			System.out.println("LpSolveNumberOfRetries: "+LPSolveSolver.numberOfRetries);
			
			
		}
		
		

		

//		if (configMap.keySet().contains("lpsolveoverwritedefaultsetting")){
//			
//			String s = configMap.get("lpsolveoverwritedefaultsetting");
//			
//			if (s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true")){
//				LPSolveSolver.overwriteDefaultSetting = true;	
//			} else if (s.equalsIgnoreCase("no") || s.equalsIgnoreCase("false")){
//				LPSolveSolver.overwriteDefaultSetting = false;	
//			} else {
//				LPSolveSolver.overwriteDefaultSetting = false;	
//			}
//			
//		}
//		System.out.println("LpSolveOverwriteDefaultSetting: "+LPSolveSolver.overwriteDefaultSetting);
		
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
			System.out.println("Config file not found: " + configFilePath);
			System.exit(1);
		} finally {
			if (!configFile.exists()){
				System.out.println("Config file not found: " + configFilePath);
				System.exit(1);					
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
			
				//System.out.println(key+ " & "+value);
				configMap.put(key.toLowerCase(), value);
			}

//			for (String k : configMap.keySet()) {
//				System.out.println(k + ": " + configMap.get(k));
//			}

		}
		catch (Exception e) {
			System.out.println("Invalid Config File: " + configFilePath);
			System.exit(1);
			// e.printStackTrace();
		}

		
		// check missing fields
		String[] requiredFields = { "MainFile", "Solver", "DvarFile", "SvarFile", "SvarAPart",
				"SvarFPart", "InitFile", "InitFPart", "TimeStep", "StartYear", "StartMonth",
				"GroundwaterDir" };

		for (String k : requiredFields) {
			if (!configMap.keySet().contains(k.toLowerCase())) {
				System.out.println("Config file missing field: " + k);
				StudyUtils.config_errors++;
				System.exit(1);
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
					System.out.println("Config file missing field: " + k);
					StudyUtils.config_errors++;
					System.exit(1);
				}
			}			
		}
		
		// fill-in start day and end day
		
		int bday=TimeOperation.numberOfDays(bMon, bYr);
		configMap.put("startday", Integer.toString(bday));
		
		int endYr= Integer.parseInt(configMap.get("stopyear"));
		int endMon= Integer.parseInt(configMap.get("stopmonth"));
		int endday= TimeOperation.numberOfDays(endMon, endYr);
		configMap.put("stopday", Integer.toString(endday));


		
		
		
		// support only monthly time step
		if (!configMap.get("timestep").equalsIgnoreCase("1mon")){
			
			System.out.println("Only monthly timestep supported, i.e., \"TimeStep  1MON\" ");
			StudyUtils.config_errors++;
			System.exit(1);
		}
		
		

		
		// exit for above checks
		if (StudyUtils.config_errors>0) System.exit(1);
			
	
		// check run dir and mainfile
		// don't limit config file to run folder
		//StudyUtils.runDir = configFile.getParent();	
		File mf = new File(StudyUtils.configDir, configMap.get("mainfile"));
		
		try {
			mf.getCanonicalPath();
		}
		catch (IOException e) {
			System.out.println("Main file not found: "+mf.getAbsolutePath());
			System.exit(1);
		}
		
		return configMap;

	}

	private static Map<String, String> setDefaultConfig() {

		Map<String, String> configMap = new HashMap<String, String>();

		configMap.put("saveparserdata".toLowerCase(), "No");
		configMap.put("solver".toLowerCase(), "XA");
		configMap.put("timestep".toLowerCase(), "1MON");
		configMap.put("groundwaterdir".toLowerCase(), "\\");
		configMap.put("showwresllog".toLowerCase(), "yes");


		return configMap;

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
