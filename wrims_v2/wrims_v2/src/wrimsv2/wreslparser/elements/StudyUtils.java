package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.FilenameUtils;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.Versions;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.Workflow;
import wrimsv2.wreslplus.elements.procedures.ToWreslData;

public class StudyUtils {

	public static int config_errors = 0;
	public static int total_errors = 0;
	public static boolean loadParserData=false;
	public static boolean compileOnly=false;

	public static String parserDataPath = "";
	public static String configFilePath = "";
	public static String configFileCanonicalPath = "";
	public static String configDir = "";
	public static String configFileName = "default";
	public static boolean useWreslPlus = false;
	
	private StudyUtils() {

	}
	
	public static void reset() {

		StudyParser.reset();
		total_errors = 0;
		config_errors = 0;
	}

	public static StudyDataSet compileStudy(String inMainWreslPath) throws IOException {
		
		StudyUtils.compileOnly = true;
		return checkStudy(inMainWreslPath);

	}	
	
	public static StudyDataSet checkStudy(String inMainWreslPath) throws IOException {
		
		// TODO: clean up this mess. simplify these checkStudy methods.
		if (FilePaths.mainFile.length()<1) FilePaths.mainFile = FilenameUtils.getName(inMainWreslPath);
		
		String mainFileName = FilenameUtils.removeExtension(FilePaths.mainFile);
		
		String csvFolderName = "=WreslCheck_"+mainFileName+"=";
		String logFileName = "=WreslCheck_"+mainFileName+"=.log";
		
		if (!ControlData.outputWreslCSV) {
			csvFolderName = "";  // disable csv output
		}

		return checkStudy(inMainWreslPath, logFileName, csvFolderName, ControlData.sendAliasToDvar);

	}

	public static StudyDataSet checkStudy(String inMainWreslPath, String csvFolderName, boolean sendAliasToDvar) throws IOException {

		String mainFileName = FilenameUtils.removeExtension(FilePaths.mainFile);
		
		String logFileName = "=WreslCheck_"+mainFileName+"=.log";

		return checkStudy(inMainWreslPath, logFileName, csvFolderName, sendAliasToDvar);

	}
	
	public static StudyDataSet checkStudy(String inMainWreslPath, String logFileName, String csvFolderName,
			boolean sendAliasToDvar) throws IOException {

		StudyDataSet sds = null;

		File mainWreslFile = sanityCheck(inMainWreslPath);

		LogUtils.setLogFile(mainWreslFile.getParentFile().getCanonicalPath(), logFileName);
		LogUtils.titleMsg(Param.wreslChekerName + " 2.0 SVN 2589");
			
		try {
			
			if (useWreslPlus) {
				sds = parseWreslPlus(mainWreslFile);
				total_errors = StudyParser.total_errors;
			} else {
				sds = parseWresl(mainWreslFile, sendAliasToDvar);
			}
			
		}
		catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (csvFolderName != null && csvFolderName.length() > 0) {
			String csvFolderPath = mainWreslFile.getParentFile() + File.separator + csvFolderName;
			WriteCSV.study(sds, csvFolderPath);
		}

		if (StudyUtils.compileOnly) {
			
			if (StudyUtils.total_errors ==0) {
				StudyUtils.compileObject(FilePaths.fullMainPath, sds);
				//System.exit(0);
			} else {
				LogUtils.errMsg("Compilation unsuccessful.");
				//System.exit(1);
			}
	
		}
		
		LogUtils.closeLogFile();

		return sds;

	}

	public static void compileObject(String inMainWreslPath, StudyDataSet sds) {

		StringBuilder b = new StringBuilder(inMainWreslPath);
		b.replace(inMainWreslPath.lastIndexOf("."), inMainWreslPath.length(), ".par");
		String objFilePath = b.toString();

		StringBuilder b2 = new StringBuilder(FilePaths.mainFile);
		b2.replace(FilePaths.mainFile.lastIndexOf("."), FilePaths.mainFile.length(), ".par");
		String objFileName = b2.toString();
		
		LogUtils.importantMsg("Writing parser data....");
		writeObj(sds, objFilePath);
		LogUtils.importantMsg("Wresl files are compiled into a binary file: "+objFileName );

	}

	public static StudyDataSet loadObject(String objFilePath) {

		System.out.println("Loading precompiled parser data: "+objFilePath);
		
		return readObj(objFilePath);

	}

	private static File sanityCheck(String inMainWreslPath) throws IOException {

		String m = inMainWreslPath;
		File validatedAbsFile = null;

		if (m.length() < 7) {

		throw new IOException("Invalid wresl file: " + m); }

		String extension = m.substring(m.length() - 5);

		if (!extension.equalsIgnoreCase("wresl")) { throw new IOException("Invalid wresl file: " + m); }

		validatedAbsFile = new File(inMainWreslPath).getAbsoluteFile();

		if (!validatedAbsFile.exists()) { throw new IOException("File not found: " + inMainWreslPath); }

		return validatedAbsFile;

	}

	private static StudyDataSet parseWresl(File validatedMainWreslFile, boolean sendAliasToDvar)
			throws RecognitionException, IOException {

		try {

			TempData td = new TempData();
			StudyParser.reset();
			StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(validatedMainWreslFile.getCanonicalPath());

			// td.model_dataset_map=StudyParser.parseModels(sc,td);
			td.model_dataset_map = StudyParser.parseModels(sc, td, false, sendAliasToDvar);

			StudyDataSet sd = StudyParser.writeWreslData(sc, td);			
			
			StudyParser.analyzeVarNeededFromCycles(sc, sd);
			
			total_errors = StudyParser.total_errors;

			return sd;

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static StudyDataSet parseWreslPlus(File validatedMainWreslFile)
			throws RecognitionException, IOException {
	
		StudyUtils.reset();
		
		try {
	
			
			//total_errors = StudyParser.total_errors;
	
			StudyTemp st = Workflow.checkStudy(validatedMainWreslFile.getCanonicalPath());
			
			StudyDataSet sd = ToWreslData.convertStudy(st);
			
			st = null;
			System.gc();
			
			return sd;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	private static void writeObj(StudyDataSet sds, String objFilePath) {

		FileOutputStream f_out = null;
		ObjectOutputStream obj_out = null;

		try {
			f_out = new FileOutputStream(objFilePath);
			obj_out = new ObjectOutputStream(f_out);
			obj_out.writeObject(sds);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static StudyDataSet readObj(String objFilePath) {

		FileInputStream f_in = null;
		StudyDataSet obj_in = null;

		try {
			f_in = new FileInputStream(objFilePath);
			obj_in = (StudyDataSet) (new ObjectInputStream(f_in).readObject());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj_in;

	}
}