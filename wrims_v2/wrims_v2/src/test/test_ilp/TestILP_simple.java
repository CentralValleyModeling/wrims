package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.*;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;

public class TestILP_simple {
	
	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private String studyPath;	
	private String dssPath;	
	private double expected;
	
	@Test(groups = { "ilp_simple" })
	public void simple1() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\simple1\\";
		dssPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\simple1\\dss\\";
		
		/// set control data		
		String[] controlDataString = {
		studyPath + "run\\",   //groundwater dir
		studyPath + "run\\Simple1.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1921",
		"10",
		 "31",
		 "1921",
		 "10",
		 "31", 
		 "ILP", 
		 "csv_ilp_Simple1"};

		FilePaths.ilpFileDirectory = "ilp_TestIlp_Simple1";
		FilePaths.ilpFile = "test.ilp";
		
        new Controller(controlDataString);


		
		// TODO: compare objective function value 
        // wrims v1 XA16 OBJ: 41169932.383266 
        // wrims v2 XA16 OBJ: 41169932.835543
        
        expected = 3.0;

		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}
	

}
