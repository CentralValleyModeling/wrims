package wrimsv2.external;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateCompileFiles {
	public static HashMap<String, String[]> dllFunctions=new HashMap<String, String[]>();
	public static HashMap<String, String> dllDlls = new HashMap<String, String>();
	public static HashMap<String, String> functionTypes=new HashMap<String, String>();
	public static HashMap<String, String[]> functionVariableNames = new HashMap<String, String[]> ();
	public static HashMap<String, String[]> functionVariableTypes = new HashMap<String, String[]> ();
	private static ArrayList<String> functionArray=new ArrayList<String>();
	public static ArrayList<String> error=new ArrayList<String>(); 
	public static String workingDir;
	public static boolean setPath=false;
	private static String currentDirectory;
	
	public static void generateBatchFile(){
		String batchFileFullPath=workingDir+"processDll.bat";

		Iterator fvni=functionVariableNames.keySet().iterator();
		Iterator dfi=dllFunctions.keySet().iterator();
		
		try{
			FileWriter batchFile = new FileWriter(batchFileFullPath);
			PrintWriter out = new PrintWriter(batchFile);

			if (setPath){
				out.println("set path="+currentDirectory+"/../jdk6/bin;"+currentDirectory+"/../mingw/bin;");
			}
			
			while (fvni.hasNext()){
				String functionName=(String)fvni.next();
				if (setPath){
					out.println("javac -cp "+currentDirectory+"/../lib/wrimsv2.jar "+"wrimsv2\\external\\Function"+functionName+".java");
				}else{
					out.println("javac -cp . wrimsv2\\external\\Function"+functionName+".java");
				}
				out.println("javah -jni wrimsv2.external.Function"+functionName);
				out.println("gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I\""+currentDirectory+"/../jdk/include\"  -I\""+currentDirectory+"/../jdk/include/win32\" wrimsv2_external_Function"+functionName+".c");
			}
			String compileString="gcc -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -shared "; 
			while (dfi.hasNext()){
				String dllName=(String)dfi.next();
				String fortranDllName=dllDlls.get(dllName);
				String[] functions=dllFunctions.get(dllName);
				for (int i=0; i<functions.length; i++){
					compileString=compileString+"wrimsv2_external_Function"+functions[i]+".o "; 
				}
				compileString=compileString+"-o "+dllName+".dll -L./ "+fortranDllName+".dll";
				out.println(compileString);
			}
			out.println("Exit");
			out.close();
		} catch (IOException e){
			error.add(e.getMessage());
		}	
	}
	
	public static void generateJavaFile(String functionName){
		String javaFileFullPath=workingDir+"wrimsv2\\external\\Function"+functionName+".java";
		String functionType=functionTypes.get(functionName);
		String[] variableNames=functionVariableNames.get(functionName);
		String[] variableTypes=functionVariableTypes.get(functionName);
		try{
			FileWriter javaFile = new FileWriter(javaFileFullPath);
			PrintWriter out = new PrintWriter(javaFile);
			out.println("package wrimsv2.external;");
			out.println();
			out.println("import java.util.*;");
			out.println();
			out.println("public class Function"+functionName+" extends ExternalFunction{");
			out.println("	private final boolean DEBUG = false;");
			out.println();
			out.println();	
			out.println("	public Function"+functionName+"(){");
			out.println();		
			out.println("	}");
			out.println();
			out.println("	public void execute(Stack stack) {");
			out.println();	
			out.println("		//values in reverse order:");
			for (int i=variableNames.length; i>0; i--){
				out.println("		Object param"+i+" = stack.pop();");
			}
			out.println();
			out.println("		//cast params to correct types:");
			for (int i=variableNames.length; i>0; i--){
					out.println("		"+variableTypes[i-1] +" "+ variableNames[i-1]+" = ((Number) param"+i+")."+variableTypes[i-1]+"Value();");
			}
			out.println();
			String resultString="";
			resultString="		"+functionType+" result = "+functionName+"("; 	
			for (int i=0; i<variableNames.length-1; i++){
				resultString=resultString+variableNames[i]+", ";
			}
			resultString=resultString+variableNames[variableNames.length-1]+");";
			out.println(resultString);
			out.println();
			out.println("		// push the result on the Stack");
			if (functionType.equals("int")){
				out.println("		stack.push(new Integer(result));");
			}else if (functionType.equals("float")){
				out.println("		stack.push(new Float(result));");
			}if (functionType.equals("double")){
				out.println("		stack.push(new Double(result));");
			}	
			out.println("	}");
			out.println();
			String nativeString="	public native "+functionType+" "+functionName+"(";
			for (int i=0; i<variableNames.length-1; i++){
				nativeString=nativeString+variableTypes[i]+" "+variableNames[i]+", ";
			}
			nativeString=nativeString+variableTypes[variableTypes.length-1]+" "+variableNames[variableNames.length-1]+");";
			out.println(nativeString);
			out.println("}");
			out.close();
		} catch (IOException e){
			error.add(e.getMessage());
		}		
	}
	
	public static void generateCFile(String functionName){
		String cFileFullPath=workingDir+"wrimsv2_external_Function"+functionName+".c";
		String functionType=functionTypes.get(functionName);
		String[] variableNames=functionVariableNames.get(functionName);
		String[] variableTypes=functionVariableTypes.get(functionName);
		try{
			FileWriter cFile = new FileWriter(cFileFullPath);
			PrintWriter out = new PrintWriter(cFile);
			out.println("#include <jni.h>");
			out.println("#include \"wrimsv2_external_Function"+functionName+".h\"");
			out.println();
			String externalString="extern "+functionType+" "+functionName.toUpperCase()+"(";
			String variableType;
			for (int i=0; i<variableNames.length-1; i++){
				if (variableTypes[i].equals("int")){
					variableType="long";
				}else{
					variableType=variableTypes[i];
				}
				externalString=externalString+variableType+"* "+variableNames[i]+", ";
			}
			if (variableTypes[variableTypes.length-1].equals("int")){
				variableType="long";
			}else{
				variableType=variableTypes[variableTypes.length-1];
			}
			externalString=externalString+variableType+"* "+variableNames[variableNames.length-1]+");";
			out.println(externalString);
			out.println();
			out.println();
			String modifiedFunctionName=functionName.replaceAll("_", "_1");
			String exportString="JNIEXPORT j"+functionType+" JNICALL Java_wrimsv2_external_Function"+modifiedFunctionName+"_"+modifiedFunctionName+"(JNIEnv *env, jobject obj, ";
			for (int i=0; i<variableNames.length-1; i++){
				exportString=exportString+"j"+variableTypes[i]+" "+variableNames[i]+", ";
			}
			exportString=exportString+"j"+variableTypes[variableTypes.length-1]+" "+variableNames[variableNames.length-1]+") {";
			out.println(exportString);
			out.println();
			String returnString="	return "+functionName.toUpperCase()+"(";
			for (int i=0; i<variableNames.length-1; i++){
				returnString=returnString+"&"+variableNames[i]+", ";
			}
			returnString=returnString+"&"+variableNames[variableNames.length-1]+");";
			out.println(returnString);
			out.println("}");
			out.close();
		} catch (IOException e){
			error.add(e.getMessage());
		}		
	}
	
	public static boolean setDllFunction(String fileName) {	
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(fileName);
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String nDllFileString;
		    int line=0;
		    
		    int nDllFiles;
		    nDllFileString=br.readLine();
		    line=line+1;
		    if (nDllFileString ==null){
		    	error.add("Line "+line+": Number of interface dll files is not defined." );
		    	return false;
		    }
		    nDllFiles=Integer.parseInt(nDllFileString);
		    
		    for (int i=0; i<nDllFiles; i++){
		    	String interfaceDllString=br.readLine();
		    	line=line+1;
		    	if (interfaceDllString==null){
		    		error.add("Line " +line+": The number of defined interface dlls is less than the number in Line 1. Please define interface dll name.");
		    		return false;
		    	}
		    	interfaceDllString=removeLeadingTailingSpace(interfaceDllString);
		    	if (interfaceDllString.contains("\\s")) {
		    		error.add("Line "+line+": Only one interface dll name could be used in one line.");
		    		return false;
		    	}
		    	if (!isNameFormatRight(interfaceDllString)) {
		    		error.add("Line "+line+": Interface dll name contains non-characters or non-numeric.");
		    		return false;
		    	}
		    	
		    	String fortranDllString=br.readLine();
		    	line=line+1;
		    	if (fortranDllString==null){
		    		error.add("Line " +line+": The number of defined interface dlls is less than the number in Line 1. Please define Fortran dll name.");
		    		return false;
		    	}
		    	fortranDllString=removeLeadingTailingSpace(fortranDllString);
		    	if (fortranDllString.contains("\\s")) {
		    		error.add("Line "+line+": Only one Fortran dll name could be used in one line.");
		    		return false;
		    	}
		    	if (!isNameFormatRight(fortranDllString)) {
		    		error.add("Line "+line+": Fortran dll name contains non-characters or non-numeric.");
		    		return false;
		    	}
		    	
		    	String functionString=br.readLine();
		    	line=line+1;
		    	if (functionString==null){
		    		error.add("Line "+line+": The number of defined interface dlls is less than the number in Line 1. Please define function names");
		    		return false;
		    	}
		    	functionString=removeLeadingTailingSpace(functionString);
		    	String[] function=functionString.split("\\s+");
		    	for (int j=0; j<function.length; j++){
		    		if (!isNameFormatRight(function[j])) {
		    			error.add("Line "+line+": Function name contains non-characters or non-numeric.");
		    			return false;
		    		}
		    		functionArray.add(function[j]);
		    	}
		    	dllFunctions.put(interfaceDllString, function);
		    	dllDlls.put(interfaceDllString, fortranDllString);
		    }
		    
		    br.readLine();
		    line=line+1;
		    int nFunctions=functionArray.size();
		    
		    for (int i=0; i<nFunctions; i++){
		    	String functionName=br.readLine();
		    	line=line+1;
		    	if (functionName==null){
		    		error.add("Line " +line+": The number of defined functions is less than the total number of functions. Please provide the function name.");
		    		return false;
		    	}
		    	functionName=removeLeadingTailingSpace(functionName);
		    	if (functionName.contains("\\s")) {
		    		error.add("Line "+line+": Only one function name could be used in this line.");
		    		return false;
		    	}
		    	if (functionArray.contains(functionName)){
		    		functionArray.remove(functionName);
		    	}else{
		    		error.add("Line "+line+": The defined function name is not found in the dll definition above.");
		    		return false;
		    	}
		    	
		    	String functionType=br.readLine().toLowerCase();
		    	line=line+1;
		    	if (functionType==null){
		    		error.add("Line " +line+": The number of defined functions is less than the total number of functions. Please provide the function type.");
		    		return false;
		    	}
		    	functionType=removeLeadingTailingSpace(functionType);
		    	if (functionType.contains("\\s")) {
		    		error.add("Line "+line+": Only one function type could be used in this line.");
		    		return false;
		    	}
		    	
		    	String variableTypeString=br.readLine();
		    	line=line+1;
		    	if (variableTypeString==null){
		    		error.add("Line "+line+": The number of defined functions is less than the total number of functions. Please define variable type");
		    		return false;
		    	}
		    	variableTypeString=removeLeadingTailingSpace(variableTypeString);
		    	String[] variableTypes=variableTypeString.toLowerCase().split("\\s+");
		    	for (int j=0; j<variableTypes.length; j++){
		    		if (!isNameFormatRight(variableTypes[j])) {
		    			error.add("Line "+line+": Variable type contains non-characters or non-numeric.");
		    			return false;
		    		}
		    	}
		    	
		    	String variableNameString=br.readLine();
		    	line=line+1;
		    	if (variableNameString==null){
		    		error.add("Line "+line+": The number of defined functions is less than the total number of functions. Please define variable name");
		    		return false;
		    	}
		    	variableNameString=removeLeadingTailingSpace(variableNameString);
		    	String[] variableNames=variableNameString.split("\\s+");
		    	if (variableNames.length!=variableTypes.length){
		    		error.add("Line "+line+": The number of variable names is different from the number of variable types in the same function.");
		    		return false;
		    	}
		    	for (int j=0; j<variableNames.length; j++){
		    		if (!isNameFormatRight(variableNames[j])) {
		    			error.add("Line "+line+": Variable names contains non-characters or non-numeric.");
		    			return false;
		    		}
		    	}
		    	
		    	functionTypes.put(functionName, functionType);
		    	functionVariableTypes.put(functionName, variableTypes);
		    	functionVariableNames.put(functionName, variableNames);
		    }
		    
		} catch (Exception e) {
			error.add(e.getMessage());
			return false;
		}
		return true;
	}
	
	public static String removeLeadingTailingSpace(String text){
	    text=text.replaceAll("^\\s+", "");
	    text=text.replaceAll("\\s+$", "");
	    return text;
	}
	
	public static boolean isNameFormatRight(String name){
		if (Character.isDigit(name.charAt(0))){
			return false;
		}
		Pattern alphaNumberic = Pattern.compile("[A-Za-z0-9_]+");
		Matcher m = alphaNumberic.matcher(name);
		return m.matches();	
	}
	
	public static void generateFiles(){
		String strDirectory =workingDir+"wrimsv2\\external\\";
		boolean isDone=(new File(strDirectory)).mkdirs();
		
		Iterator fvni=functionVariableNames.keySet().iterator();
		while (fvni.hasNext()){
			String functionName=(String)fvni.next();
			generateJavaFile(functionName);
			generateCFile(functionName);
		}
		
		generateBatchFile();
	}
	
	public static void reportErrors(){
		String errorFileFullPath=workingDir+"error.log";
		try{
			FileWriter errorFile = new FileWriter(errorFileFullPath);
			PrintWriter out = new PrintWriter(errorFile);

			for (int i=0; i<error.size(); i++){
				out.println(error.get(i));
			}
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void setWorkingDirectory(String fileFullPath){
		int index=fileFullPath.lastIndexOf("\\");
		workingDir= fileFullPath.substring(0,index+1);
	}
	
	public static void main(String args[]){
		setWorkingDirectory(args[0]);
		if (args.length>1) {
			setPath=true;
			currentDirectory=args[1];
		}
		if (setDllFunction(args[0])) generateFiles();
		reportErrors();
	}
}
