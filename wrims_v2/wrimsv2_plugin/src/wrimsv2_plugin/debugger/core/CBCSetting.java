package wrimsv2_plugin.debugger.core;

public class CBCSetting {
	public static String cbcTolerancePrimalDefault      = "1e-8";
	public static String cbcTolerancePrimalRelaxDefault = "1e-6";
	public static String cbcToleranceWarmPrimalDefault  = "1e-9";
	public static String cbcToleranceIntegerDefault     = "1e-9";
	public static String cbcToleranceIntegerCheckDefault= "1e-8";
	public static String cbcToleranceZeroDefault        = "1e-11";
	
	public static String cbcTolerancePrimal      = cbcTolerancePrimalDefault;
	public static String cbcTolerancePrimalRelax = cbcTolerancePrimalRelaxDefault;
	public static String cbcToleranceWarmPrimal  = cbcToleranceWarmPrimalDefault;
	public static String cbcToleranceInteger     = cbcToleranceIntegerDefault;
	public static String cbcToleranceIntegerCheck= cbcToleranceIntegerCheckDefault;
	public static String cbcToleranceZero        = cbcToleranceZeroDefault;
	
	public static double dvcbcTolerancePrimal      = Double.parseDouble(cbcTolerancePrimalDefault);
	public static double dvcbcTolerancePrimalRelax = Double.parseDouble(cbcTolerancePrimalRelaxDefault);
	public static double dvcbcToleranceWarmPrimal  = Double.parseDouble(cbcToleranceWarmPrimalDefault);
	public static double dvcbcToleranceInteger     = Double.parseDouble(cbcToleranceIntegerDefault);
	public static double dvcbcToleranceIntegerCheck= Double.parseDouble(cbcToleranceIntegerCheckDefault);
	public static double dvcbcToleranceZero        = Double.parseDouble(cbcToleranceZeroDefault);
	
	public static boolean changeSetting=false;

}
