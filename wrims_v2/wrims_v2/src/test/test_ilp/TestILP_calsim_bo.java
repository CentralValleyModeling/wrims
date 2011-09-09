package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.*;

public class TestILP_calsim_bo {
	
	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private String studyPath;	
	private String dssPath;	
	private double expected;
	
	@Test(groups = { "ilp_calsim3_bo" })
	public void step1() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\";
		dssPath   = "D:\\cvwrsm\\trunk\\calsim30\\calsim30_bo\\common\\DSS\\";
		
		/// set control data		
		String[] controlDataString = {
		studyPath + "common\\CVGroundwater\\Data\\",   //groundwater dir
		studyPath + "CONV\\run\\mainCONV_30.wresl",
		dssPath +   "CalSim30_06_SV.dss",
		dssPath +   "CalSim30_06Init.dss",
		studyPath + "CONV\\DSS\\dv.dss",
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
		 "ILP", 
		 "csv_TestIlp_Calsim_BO"};

		FilePaths.ilpFileDirectory = "ilp_TestIlp_Calsim3";
		//FilePaths.ilpFile = "test.ilp";
		
        new Controller(controlDataString);


		
		// TODO: compare objective function value 
        // wrims v1 XA16 OBJ: 41169932.383266 
        // wrims v2 XA16 OBJ: 41169932.835543
        
        expected = 1.7482867180632626E10;
		
		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}
	

}
