package wrimsv2.components;

import java.io.File;

public class FilePaths {
	public static String groundwaterDir="";  //for groundwater use.
	public static String fullMainPath="";
	public static String mainFile="";
	public static String mainDirectory="";
	public static String fullSvarDssPath="";
	public static String svarDssFile="";
	public static String svarDssDirectory="";
	public static String fullDvarDssPath="";
	public static String dvarDssFile="";
	public static String dvarDssDirectory="";
	public static String fullInitDssPath="";
	public static String initDssFile="";
	public static String initDssDirectory="";
	public static String fullIlpPath="";
	public static String ilpFile="";
	public static String ilpFileDirectory="";
	public static String csvFolderName="";
	public static String lookupSubDirectory="";


	public static void setMainFilePaths(String fullPath){
		fullMainPath=fullPath;
		int index=fullPath.lastIndexOf(File.separator);
		mainDirectory=fullPath.substring(0,index+1);
		mainFile=fullPath.substring(index+1);
	}
	
	public static void setSvarDssPaths(String fullPath){
		fullSvarDssPath=fullPath;
		int index=fullPath.lastIndexOf(File.separator);
		svarDssDirectory=fullPath.substring(0,index+1);
		svarDssFile=fullPath.substring(index+1);
	}
	
	public static void setDvarDssPaths(String fullPath){
		fullDvarDssPath=fullPath;
		int index=fullPath.lastIndexOf(File.separator);
		dvarDssDirectory=fullPath.substring(0,index+1);
		dvarDssFile=fullPath.substring(index+1);
	}
	
	public static void setInitDssPaths(String fullPath){
		fullInitDssPath=fullPath;
		int index=fullPath.lastIndexOf(File.separator);
		initDssDirectory=fullPath.substring(0,index+1);
		initDssFile=fullPath.substring(index+1);
	}
	
	public static void clear(){
		
		groundwaterDir=""; 
		fullMainPath="";
		mainFile="";
		mainDirectory="";
		fullSvarDssPath="";
		svarDssFile="";
		svarDssDirectory="";
		fullDvarDssPath="";
		dvarDssFile="";
		dvarDssDirectory="";
		fullInitDssPath="";
		initDssFile="";
		initDssDirectory="";
		fullIlpPath="";
		ilpFile="";
		ilpFileDirectory="";
		csvFolderName="";		
	}

}
