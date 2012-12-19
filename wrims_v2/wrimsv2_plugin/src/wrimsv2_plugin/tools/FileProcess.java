package wrimsv2_plugin.tools;

import java.io.File;
import java.util.ArrayList;

public class FileProcess {
	public static ArrayList<String> retrieveFileNames(String[] fns){
		ArrayList<String> allFiles=new ArrayList<String>();
		for (int i=0; i<fns.length; i++){
			String fn=fns[i];
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
}
