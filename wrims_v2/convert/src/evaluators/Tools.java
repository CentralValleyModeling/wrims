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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.RecognitionException;

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

	public static PrintWriter openFile(String dirPath, String fileName) throws IOException {

		File f = new File(dirPath, fileName);
		File dir = new File(f.getParent());
		dir.mkdirs();
		f.createNewFile();

		return new PrintWriter(new BufferedWriter(new FileWriter(f)));
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

	public static Map<String, Dataset> convertDatasetMapToLocal(Map<String, Dataset> s) {
		
		Map<String, Dataset> out = new HashMap<String, Dataset>();
		
		for (String key : s.keySet()){
			
			out.put(key, convertDatasetToLocal(s.get(key)));
			
		}
		
		return out;
			
	}
	
	public static Dataset convertDatasetToLocal(Dataset s) {
		
		Dataset out = new Dataset();


		if (!s.incFileList.isEmpty()) {
			out.incFileList.addAll(s.incFileList);
			out.incFileList_local.addAll(s.incFileList_local);
			out.incFileMap.putAll(s.incFileMap);
		}

		if (!s.svList.isEmpty()) {
			out.svList.addAll(s.svList);
			out.svList_local.addAll(s.svList_local);
			out.svMap.putAll(s.svMap);
		}

		if (!s.dvList.isEmpty()) {
			out.dvList.addAll(s.dvList);
			out.dvList_local.addAll(s.dvList_local);
			out.dvMap.putAll(s.dvMap);
		}
		if (!s.asList.isEmpty()) {
			out.asList.addAll(s.asList);
			out.asList_local.addAll(s.asList_local);
			out.asMap.putAll(s.asMap);
		}

		if (!s.gList.isEmpty()) {
			out.gList.addAll(s.gList);
			out.gList_local.addAll(s.gList_local);
			out.gMap.putAll(s.gMap);
		}

		if (!s.model_list.isEmpty()) {
			out.model_list.addAll(s.model_list);
		}

		return out;
	}	
	
	public static Dataset convertStructToDataset(Object obj) {
		
		Dataset out = new Dataset();
		Struct s = (Struct)obj;

		if (!s.incFileList.isEmpty()) {
			out.incFileList.addAll(s.incFileList);
			if (!s.incFileList_global.isEmpty()) {out.incFileList_global.addAll(s.incFileList_global);}
			if (!s.incFileList_local.isEmpty()) {out.incFileList_local.addAll(s.incFileList_local);}
			out.incFileMap.putAll(s.incFileMap);
		}

		if (!s.svList.isEmpty()) {
			out.svList.addAll(s.svList);
			if (!s.svList_global.isEmpty()) {out.svList_global.addAll(s.svList_global);}
			if (!s.svList_local.isEmpty()) {out.svList_local.addAll(s.svList_local);}
			out.svMap.putAll(s.svMap);
		}

		if (!s.dvList.isEmpty()) {
			out.dvList.addAll(s.dvList);
			if (!s.dvList_global.isEmpty()) {out.dvList_global.addAll(s.dvList_global);}
			if (!s.dvList_local.isEmpty()) {out.dvList_local.addAll(s.dvList_local);}
			out.dvMap.putAll(s.dvMap);
		}
		if (!s.asList.isEmpty()) {
			out.asList.addAll(s.asList);
			if (!s.asList_global.isEmpty()) {out.asList_global.addAll(s.asList_global);}
			if (!s.asList_local.isEmpty()) {out.asList_local.addAll(s.asList_local);}
			out.asMap.putAll(s.asMap);
		}

		if (!s.gList.isEmpty()) {
			out.gList.addAll(s.gList);
			if (!s.gList_global.isEmpty()) {out.gList_global.addAll(s.gList_global);}
			if (!s.gList_local.isEmpty()) {out.gList_local.addAll(s.gList_local);}
			out.gMap.putAll(s.gMap);
		}

		if (!s.model_list.isEmpty()) {
			out.model_list.addAll(s.model_list);
		}

		if (!s.sequence_list.isEmpty()) {
			out.sequence_list.addAll(s.sequence_list);
			out.sequence_map.putAll(s.sequence_map);
		}
		
		return out;
	}

	public static Map<String,Dataset> convertStructMapToDatasetMap(Map<String,Struct> s) {
		
		Map<String,Dataset> out = new HashMap<String, Dataset> ();
		
		for (String key : s.keySet()) {
			
			Dataset d = new Dataset();
			d = convertStructToDataset(s.get(key));
			out.put(key, d);
			
		}
 
		return out;
	}

//	public static Map<String,Dataset> getModelDataFromAdhoc(Dataset InputModelAdhoc) throws RecognitionException, IOException{
//		
//		Map<String,Dataset> out = new HashMap<String, Dataset>();
//						
//		                    out = FileParser.processFileListIntoDatasetMap(InputModelAdhoc);
//			
//			return out;
//
//	}
	
	public static PairMap getModelPairFromAdhoc(Dataset InputModelAdhoc) throws RecognitionException, IOException{
		
		PairMap out = new PairMap();
						
			Map<String, PairMap> pm = FileParser.processFileListIntoMapOfPair(InputModelAdhoc);
			
			for (String fileKey : pm.keySet()){
				
				out.add(pm.get(fileKey)); 
				
			}
			return out;

	}
	
	public static Dataset overrideScope(
					Map<String,Dataset> inputFileDataMap, ArrayList<String> allFiles, ArrayList<String> localFiles){
		
		Dataset out = new Dataset();
								
		
		// / copy data from pair into the complete data container
		for (String includedFile : allFiles) {

			Dataset ds = inputFileDataMap.get(includedFile);

			if ( out.hasDuplicateIn(ds, includedFile)) {
				// / replace with some exit message
				// System.exit(1);
				out.remove(ds);
			}

			// / add to local
			if (localFiles.contains(includedFile)) {

				out.addToLocal(ds);
			}
			// / add all
			else {
				out.add(ds);
			}

		}
		return out;
					


	}	
	
	
	
}
