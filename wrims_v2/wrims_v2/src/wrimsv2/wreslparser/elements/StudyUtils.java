package wrimsv2.wreslparser.elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.antlr.runtime.RecognitionException;

import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.components.Versions;

public class StudyUtils {

	private StudyUtils() {

	}

	public static StudyDataSet checkStudy(String inMainWreslPath, String logFileName, String csvFolderName)
			throws IOException {

		StudyDataSet sds = null;

		File mainWreslFile = sanityCheck(inMainWreslPath);

		LogUtils.setLogFile(mainWreslFile.getParentFile().getCanonicalPath(), logFileName);

		LogUtils.titleMsg(Param.wreslChekerName + new Versions().getComplete());

		try {
			sds = parseWresl(mainWreslFile);
		}
		catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (csvFolderName != null && csvFolderName.length() > 0) {
			String csvFolderPath = mainWreslFile.getParentFile() + "\\" + csvFolderName;
			WriteCSV.study(sds, csvFolderPath);
		}

		LogUtils.closeLogFile();

		return sds;

	}

	public static void compileObject(String inMainWreslPath, StudyDataSet sds) {

		StringBuilder b = new StringBuilder(inMainWreslPath);
		b.replace(inMainWreslPath.lastIndexOf("."), inMainWreslPath.length(), ".object");
		String objFilePath = b.toString();

		writeObj(sds, objFilePath);

	}

	public static StudyDataSet loadObject(String objFilePath) {

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

	private static StudyDataSet parseWresl(File validatedMainWreslFile) throws RecognitionException, IOException {

		try {

			TempData td = new TempData();
			StudyParser.reset();
			StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(validatedMainWreslFile.getCanonicalPath());

			// td.model_dataset_map=StudyParser.parseModels(sc,td);
			td.model_dataset_map = StudyParser.parseModels(sc, td, false, false);

			StudyDataSet sd = StudyParser.writeWreslData(sc, td);

			StudyParser.analyzeVarNeededFromCycles(sc, sd);

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