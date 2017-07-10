package wrimsv2.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import wrimsv2.components.ControlData;

public class DataBaseProfile {
	
	public DataBaseProfile(String[] args){
		int i=0;
		boolean isConfigExist=false;
		
		while (i<args.length && !isConfigExist){
			if (args[i].toLowerCase().startsWith("-config")){
				String configFilePath = args[i].substring(args[i].indexOf("=") + 1, args[i].length());
				String profileFilePath=configFilePath+".dpf";
				File profileFile=new File(profileFilePath);
				if (profileFile.exists()){
					try {
						FileInputStream fs = new FileInputStream(profileFile.getAbsolutePath());
						BufferedReader br = new BufferedReader(new InputStreamReader(fs));
					    LineNumberReader reader = new LineNumberReader(br);
					    ControlData.USER = br.readLine();
					    ControlData.PASS = br.readLine();
					    br.close();
					    fs.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					profileFile.delete();
				}
				isConfigExist=true;
			}
			i++;
		}
	}

}
