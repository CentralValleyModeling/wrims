package components;

public class MainFile {
	public static String fullPath="";
	public static String mainFile="";
	public static String mainDirectory="";

	public MainFile(String fullPath){
		this.fullPath=fullPath;
		int index=fullPath.lastIndexOf("\\");
		mainDirectory=fullPath.substring(0,index+1);
		mainFile=fullPath.substring(index+1);
	}
}
