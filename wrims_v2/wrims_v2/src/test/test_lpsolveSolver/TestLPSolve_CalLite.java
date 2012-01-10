package test.test_lpsolveSolver;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.*;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;

public class TestLPSolve_CalLite {
	
//	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private double tolerance_perc = 2; // 0.1 ppm
	private String studyPath;	
	private String dssPath;	
	private double expected;
	
	@Test(groups = { "ilp_example_CalLite" })
	public void CalLiteStep1() throws RecognitionException, IOException{
		
		studyPath = "D:\\CalLite2.00\\Run\\";
		dssPath = "D:\\CalLite2.00\\Run\\DSS\\";
		
		/// set control data		
		String[] controlDataString = {
		studyPath + "common\\CVGroundwater\\Data\\",   //groundwater dir
		studyPath + "main_BO.wresl",
		dssPath +   "CL_FUTURE_BO_080911_SV.DSS",
		"D:\\CalLite2.00\\Run\\DSS\\CL_INIT.dss",
		studyPath + "Test25.dss",
		"2020D09E",       // sv dv F part
		"INITIAL",   // init file F part
		"CALLITE",        // part A
		"1MON",
		"1921",
		"10",
		 "31",
		 "1921",
		 "10",
		 "31", 
		 "XA", 
		 "csv"};

		FilePaths.ilpFileDirectory = "ilp_TestIlp_example_calsim30_bo_step1";
		//FilePaths.ilpFile = "test.ilp";
		/*		studyPath = "D:\\cvwrsm\\CalLite_Beta_071511_newsv\\run\\";
		dssPath = "D:\\cvwrsm\\CalLite_Beta_071511_newsv\\DSS\\";
		
		/// set control data		
		String[] controlDataString = {
		studyPath + "gw",
		studyPath + "main_BO.wresl",
		dssPath +   "CL_FUTURE_BO_080911_SV.dss",
		dssPath +   "CalLite2020D09EINIT.dss",
		dssPath +   "LPSolve_FutureDV.dss",

		"CALSIM",
		"2020D09E"
		*/
        new Controller(controlDataString);

        
        expected = 1.748286645871391E10; //17482866458.7
		
		double obj_value = 50;
		
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}
	

}
