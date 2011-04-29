package wrimsv2.wreslparser.elements;

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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import wrimsv2.commondata.wresldata.Param;

public class Tools {
	public static String strip(String s) {
		if (s==null)  return null; 
		return s.substring(1, s.length() - 1);
	}
	public static String replace_regex(String s) {
		if (s==null)  return null; 
		s=s.replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)");
		s=s.replaceAll("\\.", "\\\\.");
		s=s.replaceAll("\\*", "\\\\*");
		s=s.replaceAll("\\|", "\\\\|");
		s=s.replaceAll("\\+", "\\\\+");
		s=s.replaceAll("\\[", "\\\\[").replaceAll("\\]", "\\\\]");
		s=s.replaceAll("#", ".+");
		return s;
	}
	public static String replace_ignoreChar(String s) {
		if (s==null)  return null; 
		s=s.replaceAll("\n+", "").replaceAll("\r+", "");
		s=s.replaceAll("\t+", "");
		s=s.replaceAll("\\s+", "");
		return s;
	}
	public static String add_space_between_logical(String s) {
		if (s==null)  return null; 
		
		s = replace_ignoreChar(s);
		s = replace_seperator(s);
		
		s=s.replaceAll("\\.AND\\.", " \\.and\\. ");
		s=s.replaceAll("\\.OR\\.",  " \\.or\\. ");
		s=s.replaceAll("\\.and\\.", " \\.and\\. ");
		s=s.replaceAll("\\.or\\.",  " \\.or\\. ");
		
		return s;
	}
	public static String replace_seperator(String s) {
		if (s==null)  return null; 
		s=s.replaceAll(Param.arg_seperator,Param.new_seperator);
		return s;
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

	public static String readFileAsString(String filePath)  {
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		} catch ( IOException e){
			
	         LogUtils.errMsg("File not found: "+ filePath);

	         System.exit(1);
			
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

	public static Map<String, SimulationDataSet> convertSimulationDataSetMapToLocal(Map<String, SimulationDataSet> s) {
		
		Map<String, SimulationDataSet> out = new HashMap<String, SimulationDataSet>();
		
		for (String key : s.keySet()){
			
			out.put(key, convertSimulationDataSetToLocal(s.get(key)));
			
		}
		
		return out;
			
	}
	
	public static SimulationDataSet convertSimulationDataSetToLocal(SimulationDataSet s) {
		
		SimulationDataSet out = new SimulationDataSet();

		if (!s.wtList.isEmpty()) {
			out.wtList.addAll(s.wtList);
			out.wtList_local.addAll(s.wtList);
			out.wtMap.putAll(s.wtMap);
		}
		
		if (!s.incFileList.isEmpty()) {
			out.incFileList.addAll(s.incFileList);
			out.incFileList_local.addAll(s.incFileList);
			out.incFileMap.putAll(s.incFileMap);
		}

		if (!s.exList.isEmpty()) {
			out.exList.addAll(s.exList);
			out.exList_local.addAll(s.exList);
			out.exMap.putAll(s.exMap);
		}
		
		if (!s.svList.isEmpty()) {
			out.svList.addAll(s.svList);
			out.svList_local.addAll(s.svList);
			out.svMap.putAll(s.svMap);
		}

		if (!s.dvList.isEmpty()) {
			out.dvList.addAll(s.dvList);
			out.dvList_local.addAll(s.dvList);
			out.dvMap.putAll(s.dvMap);
		}
		if (!s.asList.isEmpty()) {
			out.asList.addAll(s.asList);
			out.asList_local.addAll(s.asList);
			out.asMap.putAll(s.asMap);
		}

		if (!s.gList.isEmpty()) {
			out.gList.addAll(s.gList);
			out.gList_local.addAll(s.gList);
			out.gMap.putAll(s.gMap);
		}

		if (!s.model_list.isEmpty()) {
			out.model_list.addAll(s.model_list);
		}

		return out;
	}	
	




	public static ArrayList<String> getScopeList(ArrayList<String> fileList, ArrayList<String> localList) {

		ArrayList<String> scopeList = new ArrayList<String>();

		for (String f : fileList) {
			if (localList.contains(f)) {
				scopeList.add("local");
			}
			else {
				scopeList.add("global");
			}
		}
		return scopeList;

	}

	public static Map<String, String> getScopeMap(Set<String> fileSet, Set<String> localSet) {

		Map<String, String> scopeMap = new HashMap<String, String>();

		for (String f : fileSet) {
			if (localSet.contains(f)) {
				scopeMap.put(f,Param.local);
			}
			else {
				scopeMap.put(f,Param.global);
			}
		}
		return scopeMap;

	}
	
	/// type 1 map is the shallow included files, e.g., map( f1, [f7,f9])
	public static Map<String, Set<String>> getType1Map(Map<String, SimulationDataSet> dataMap) {

		Map<String, Set<String>> out = new HashMap<String, Set<String>>();
		
		for (String f : dataMap.keySet()){

			SimulationDataSet data = dataMap.get(f);
			
			Set<String> fileSet = new HashSet<String>();
			fileSet.addAll(data.incFileSet);
			
			out.put(f, fileSet);
		}
		return out;
	}

	/// type 1 map is the shallow included files, e.g., map( f1, [f7,f9])
	public static Map<String, Set<String>> getReverseMap(Map<String, Set<String>> t1Map) {

		Map<String, Set<String>> out = new HashMap<String, Set<String>>();
		
		for (String f : t1Map.keySet()) {

			for (String c : t1Map.get(f)) {

				if (out.get(c) == null) {
					Set<String> s = new HashSet<String>();
					s.add(f);
					out.put(c, s);
				}
				else {
					out.get(c).add(f);
				}

			}

		}
		return out;
	}	
	
	/// type 1 map is the shallow included files, e.g., map( f1, [f7,f9])
	public static Map<String, ArrayList<String>> getReverseMap_arrayList(Map<String, ArrayList<String>> t1Map) {

		Map<String, ArrayList<String>> out = new HashMap<String, ArrayList<String>>();
		
		for (String f : t1Map.keySet()){
			
			for (String c : t1Map.get(f)){
				
			ArrayList<String> s; 
			if (out.get(c)==null) { s = new ArrayList<String>(); s.add(f);}
			else { s= out.get(c); s.add(f);}
			
			out.put(c, s);
				
			}

		}
		return out;
	}

	public static Map<String, String> getFileScopeMap(Map<String, SimulationDataSet> dataMap) {

		Map<String, String> out = new HashMap<String, String>();
		//getScopeMap(adhoc.incFileList, adhoc.incFileList_local);
		
		
		for (String f : dataMap.keySet()){

			SimulationDataSet data = dataMap.get(f);
			out.putAll(getScopeMap(data.incFileSet, data.incFileSet_local));

		}
		return out;
	}

	/// type 1 map is the scope list for the shallow included files, e.g., map( f1, [f7 scope ,f9 scope])
	public static Map<String, ArrayList<String>> getType1MapScope(Map<String, SimulationDataSet> dataMap) {

		Map<String, ArrayList<String>> out = new HashMap<String, ArrayList<String>>();
		
		for (String f : dataMap.keySet()){

			SimulationDataSet data = dataMap.get(f);
			
			ArrayList<String> scopeList = new ArrayList<String>();
			
			for (String i : data.incFileList){
				if (data.incFileList_local.contains(i)){scopeList.add("local");}
				else                                   {scopeList.add("global");}
				
			}
			
			out.put(f, scopeList);
		}
		return out;
	}
	
	public static SimulationDataSet correctDataScope(String f, SimulationDataSet ds, Map<String,String> fileScopeMap,
			Map<String,Set<String>> t1ReverseMap	) {

		
		if (fileScopeMap.get(f) == Param.local) {

			ds.convertToLocal_set();

		}
		else {

			for (String upperFile : t1ReverseMap.get(f)) {

				if (fileScopeMap.get(upperFile) == Param.local) {

					LogUtils.normalMsg("...Convert this file data to local: " + f );
					LogUtils.normalMsg("   due to  [local] specification for its parent file: " + upperFile + "\n");
					
					ds.convertToLocal_set();

					break;
				}
			}
		}
		return ds;
	}
	

	public static Map<String,SimulationDataSet> getAllOffSprings(String nodeFile, Map<String,ArrayList<String>> t1Map, Map<String, SimulationDataSet> fileDataMap ) {
		Map<String, SimulationDataSet> out = new HashMap<String, SimulationDataSet>();
		
		for (String child : t1Map.get(nodeFile)){
			
			if (t1Map.get(child)!=null) out.putAll(getAllOffSprings(child,t1Map,fileDataMap));

			out.put(child, fileDataMap.get(child));	
		}
		
		return out;
		
	}
	
	public static Map<String,SimulationDataSet> putDataFileMapFromWholeStudy(String file, Map<String,SimulationDataSet> fileDataMap) {
		
		
		Map<String,SimulationDataSet> out = new HashMap<String, SimulationDataSet>();
		
		out.put(file, fileDataMap.get(file));
		
			if (! fileDataMap.get(file).incFileList.isEmpty()){
				
				for (String child : fileDataMap.get(file).incFileList){
					out.putAll(putDataFileMapFromWholeStudy(child,fileDataMap));
				}
			}
		
		return out;
		
	}
	public static void mapRemoveAll (Map<String, ?> map, Set<String> set){
		for (String key: set){
			map.remove(key);	
		}
	}	
	public static void mapRemoveAll (Map<String, ?> map, ArrayList<String> list){
		mapRemoveAll (map, new HashSet<String>(list));
	}

	public static SimulationDataSet overwrite_set(SimulationDataSet main, SimulationDataSet s) {
		
		SimulationDataSet a = new SimulationDataSet(); a.add(main);
		SimulationDataSet b = new SimulationDataSet(); b.add(s);
		b.overwrittenWith_set(a);
		
		return b;
	}
	
	public static Set<String> convertStrToSet(String inStr){
		
		Set<String> out = new HashSet<String>();
		StringTokenizer st = new StringTokenizer(inStr);

		while (st.hasMoreTokens()) {
			out.add(st.nextToken());
		}
		out.remove("null");
		
		return out;
	}

}
