package wrimsv2.external;

import java.io.File;
import java.util.*;

import wrimsv2.components.FilePaths;

public abstract class ExternalFunction{

	public static String externalDir=FilePaths.mainDirectory+File.separator+"external"+File.separator;
	public static Map<String, Integer> cpuTimeMap = new HashMap<String, Integer>();
	public static Map<String, Integer> nCallsMap = new HashMap<String, Integer>();
	
	public abstract void execute(Stack stack);
}
