package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.*;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;

public class TestILP_callite {
	
	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private String logFilePath;	
	private String studyPath;	
	private String dssPath;	
	private String objMatchString = "L P   O P T I M A L   S O L U T I O N ---> OBJ:\\s+\\d+.\\d+";
	private double expected;
	
	@Test(groups = { "ilp_callite_studies" })
	public void callite_2cycle_step1() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CalLite_Beta_042611\\";
		dssPath =   "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CalLite_Beta_042611\\DSS\\";
		
		/// set control data		
		String[] controlDataString = {
		studyPath + "",   //groundwater dir
		studyPath + "run\\main_BO.wresl",
		dssPath +   "CL_FUTURE_WHL042611_SV.dss",
		dssPath +   "CalLite2020D09EINIT.dss",
		dssPath +   "v2_1921OCT_1step.dss",
		"2020D09E",
		"2020D09E",
		"CALSIM",
		"1MON",
		"1921",
		"10",
		 "31",
		 "1921",
		 "10",
		 "31", 
		 "ILP", 
		 "csv_ilp_callite"};
		
	    new Controller(controlDataString);
	
		// TODO: compare objective function value 
	    // wrims v1 XA16 OBJ: 41169932.383266 
	    // wrims v2 XA16 OBJ: 41169932.835543
	    
	    expected = 41169932.383266;
	
	    
	    logFilePath = studyPath+"run\\xa.log";
		String logText = Tools.readFileAsString(logFilePath);	
	
		int n = RegUtils.timesOfMatches(logText, objMatchString);
		Assert.assertEquals(n, 1);
		
		String line = RegUtils.getLastMatch(logText, objMatchString);
		String value = RegUtils.getLastMatch(line, "\\d+.\\d+");
		
		double obj_value =  Double.parseDouble(value);
		
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}
	

}
