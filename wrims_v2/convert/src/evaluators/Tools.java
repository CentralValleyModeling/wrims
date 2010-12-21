package evaluators;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Tools {
	public static String strip(String s) {
		return s.substring(1, s.length() - 1);
	}

	public static Map<String, String> readFilesFromDirAsMap(String dir)
			throws IOException {
		File folder = new File(dir);
		File[] listOfFiles = folder.listFiles();
		Map<String, String> map = new HashMap<String, String>();

		for (File file : listOfFiles) {

			if (!file.getName().contains(".svn")) {

				String filePath = file.getPath();
				String fileName = file.getName();
				map.put(fileName, readFileAsString(filePath));
			}
		}

		return map;

	}

	public static String readFileAsString(String filePath) throws IOException {
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ignored) {
				}
		}
		return new String(buffer);
	}

	public static String readFileLine(String filePath) throws IOException {

		File input = new File(filePath);
		BufferedReader in = new BufferedReader(new FileReader(input));
		return in.readLine();
	}

	public static PrintWriter openFile(String filePath) throws IOException {

		File f = new File(filePath);
		File dir = new File(f.getParent());
		dir.mkdirs();
		f.createNewFile();

		return new PrintWriter(new BufferedWriter(new FileWriter(f)));
	}

	public static Map<String, Dataset> convertStructMapToDataMap(
			Map<String, Struct> s) {

		Map<String, Dataset> resultMap = new HashMap<String, Dataset>();
		Dataset dataset;

		if (!s.isEmpty()) {
			for (String key : s.keySet()) {
				dataset = new Dataset();
				dataset.addStruct(s.get(key));
				resultMap.put(key, dataset);
			}
		}

		return resultMap;

	}

	public static boolean deleteDir(String dirString) {
		File dir = new File(dirString);
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i])
						.getPath());
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}

}
