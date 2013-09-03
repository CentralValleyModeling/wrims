package wvscript.gui;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Params {

	public static final FileNameExtensionFilter filter_txt = new FileNameExtensionFilter("txt file", "txt");
	public static final FileNameExtensionFilter filter_dss = new FileNameExtensionFilter("dss file", "dss");
	public static final FileNameExtensionFilter filter_config = new FileNameExtensionFilter("config file", "config");
	public static final FileNameExtensionFilter filter_run = new FileNameExtensionFilter("run dir", "run");
	public static final String plsSpecifyRunDir = "Please specify study's run directory.";
	public static final String isNotValidRunDir = " is not a valid run directory.";
	public static final String notExist = " does not exist.";

	public static final String[] configKeyList = {"WreslPlus", "MainFile", "Solver", "InitFile", "InitFPart", "SvarFile", "SvarAPart",
			"SvarFPart", "DvarFile", "TimeStep", "StartYear", "StartMonth", "StartDay", "NumberOfSteps", "StopYear", "StopMonth", "StopDay",
			"LookupSubDir", "GroundwaterDir", "ShowWreslLog", "PrefixInitToDvarFile", "IlpLog", "IlpLogFormat", "IlpLogVarValue"};

}
