package wrimsv2_plugin.tools;

import java.io.File;
import java.util.ArrayList;

public class FileProcess {
	public static ArrayList<String> retrieveFileNames(String[] files){
		ArrayList<String> allFiles=new ArrayList<String>();
		for (int i=0; i<files.length; i++){
			String fn=files[i];
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
}
