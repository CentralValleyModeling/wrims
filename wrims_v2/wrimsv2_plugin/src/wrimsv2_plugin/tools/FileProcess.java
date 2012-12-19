package wrimsv2_plugin.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;

public class FileProcess {
	public static ArrayList<String> retrieveFileNames(ArrayList<String> fns){
		ArrayList<String> allFiles=new ArrayList<String>();
		for (int i=0; i<fns.size(); i++){
			String fn=fns.get(i);
			File file=new File(fn);
			String fnlc=fn.toLowerCase();
			if (!allFiles.contains(fnlc)) allFiles.add(fnlc);
			file = file.getParentFile();
			while (file != null){
				fnlc=file.getAbsolutePath().toLowerCase();
				if (!allFiles.contains(fnlc)) allFiles.add(fnlc);
				file=file.getParentFile();
			}
		}
		return allFiles;
	}
	
	public static boolean isWreslFile(String path){
		if (path.toLowerCase().endsWith(".wresl")){
			return true;
		}else{
			return false;
		}
	}
	
	public static ArrayList<String> getStudyWreslFiles(String mainFilePath, StudyDataSet sds){
		ArrayList<String> fns=new ArrayList<String>();
		fns.add(mainFilePath.toLowerCase());
		Map<String, ModelDataSet> mdsm = sds.getModelDataSetMap();
		Set<String> mns=mdsm.keySet();
		for (String mn: mns){
			ModelDataSet mds=mdsm.get(mn);
			ArrayList<String> ifl = mds.incFileList;
			for (int i=0; i<ifl.size(); i++){
				String fnl = ifl.get(i).toLowerCase();
				if (!fns.contains(fnl)){
					fns.add(fnl);
				}
			}
		}
		return fns;
	}
}
