package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.IOException;
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
		String mainFilePath = new File(StudyUtils.runDir, mainfile).getAbsolutePath();
		
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
		FilePaths.groundwaterDir =  new File(StudyUtils.runDir, configMap.get("groundwaterdir")).getAbsolutePath()+"\\";
		FilePaths.setSvarDssPaths(new File(StudyUtils.runDir, configMap.get("svarfile")).getAbsolutePath());
		FilePaths.setInitDssPaths(new File(StudyUtils.runDir, configMap.get("initfile")).getAbsolutePath());
		FilePaths.setDvarDssPaths(new File(StudyUtils.runDir, configMap.get("dvarfile")).getAbsolutePath());
		FilePaths.csvFolderName = "";


		ControlData.showWreslLog = !(configMap.get("showwresllog").equalsIgnoreCase("no"));
		
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

		ControlData.totalTimeStep = ControllerBatch.getTotalTimeStep();

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

		
		if (!configFile.exists()) {
			System.out.println("Config file not found: " + configFilePath);
			System.exit(1);
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
				}
				else {
					value = value.substring(0, value.indexOf(" "));
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
		StudyUtils.runDir = configFile.getParent();	
		File mf = new File(StudyUtils.runDir, configMap.get("mainfile"));
		
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
