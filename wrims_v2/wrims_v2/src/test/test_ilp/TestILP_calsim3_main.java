package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import wrimsv2.components.*;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;

public class TestILP_calsim3_main {
	
	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private static String logFilePath;	
	private static String studyPath;	
	private static String dssPath;	
	private static String objMatchString = "L P   O P T I M A L   S O L U T I O N ---> OBJ:\\s+\\d+.\\d+";
	private static double expected;
	
	public static void main(String[] args) throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CALSIM30_051711_BO\\CONV\\";
		dssPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CALSIM30_051711_BO\\common\\DSS\\";
		
		/// set control data		
		String[] controlDataString = {
		studyPath + "run\\mainCONV_30.wresl",
		dssPath +   "CalSim30_06_SV.dss",
		dssPath +   "CalSim30_06Init.dss",
		dssPath +   "dv.dss",
		"CalSim30_06",       // sv dv F part
		"CalSim30_06",   // init file F part
		"CALSIM",        // part A
		"1MON",
		"1921",
		"10",
		 "31",
		 "1921",
		 "10",
		 "31", 
		 "XA", 
		 "csv_TestIlp_Calsim3"};

		FilePaths.ilpFileDirectory = "ilp_TestIlp_Calsim3";
		FilePaths.ilpFile = "test.ilp";
		
        new Controller(controlDataString);


		
		// TODO: compare objective function value 
        // wrims v1 XA16 OBJ: 41169932.383266 
        // wrims v2 XA16 OBJ: 41169932.835543
        
        expected = 41169932.383266;

        
        logFilePath = studyPath+"run\\xa.log";
		String logText = Tools.readFileAsString(logFilePath);	

		int n = RegUtils.timesOfMatches(logText, objMatchString);
		//Assert.assertEquals(n, 1);
		
		String line = RegUtils.getLastMatch(logText, objMatchString);
		String value = RegUtils.getLastMatch(line, "\\d+.\\d+");
		
		double obj_value =  Double.parseDouble(value);
		
		//Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}
	

}
