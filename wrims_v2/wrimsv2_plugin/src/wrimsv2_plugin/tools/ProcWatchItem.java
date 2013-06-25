package wrimsv2_plugin.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProcWatchItem {
	private final static String watchFile = "watch.prf"; 
	
	public static ArrayList<String> getLastWatchItems(){
		ArrayList<String> watchItems=new ArrayList<String> ();
		try {
			File file = new File(watchFile);
			if (!file.exists()){
				file.createNewFile();
			}
			FileInputStream fs = new FileInputStream(watchFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		    LineNumberReader reader = new LineNumberReader(br);
		    String line;
		    while((line = br.readLine())!=null){
		       	watchItems.add(line);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return watchItems;
	}
	
	public static void saveWatchItems(ArrayList<String> watchItems){
		try {
			FileWriter watchFW = new FileWriter(watchFile);
			PrintWriter out = new PrintWriter(watchFW);
			int size = watchItems.size();
			for (int i=0; i<size; i++){
				out.println(watchItems.get(i));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
