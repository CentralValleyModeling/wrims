package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.components.ControlData;
import wrimsv2.components.Controller;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;

public class TestILP_alias {
	
	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private String studyPath;	
	private String dssPath;	
	private double expected;
	
	@Test(groups = { "ilp_simple" })
	public void alias_case1() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\alias\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "alias_case1.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv_case1.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1921",
		"7",
		 "31",
		 "1921",
		 "7",
		 "31", 
		 "ILP", 
		 "csv"};

		FilePaths.ilpFileDirectory = studyPath + "ilp_case1";
		
		Error.clear();
        new Controller(controlDataString);

        
        expected = 650.;

		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(StudyUtils.total_errors, 0);
		
		Assert.assertEquals(Error.getTotalError(), 0);

		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}

	@Test(groups = { "ilp_simple" })
	public void alias_case2() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\alias\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "alias_case2.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv_case2.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1921",
		"7",
		 "31",
		 "1921",
		 "7",
		 "31", 
		 "ILP", 
		 "csv"};
	
		FilePaths.ilpFileDirectory = studyPath + "ilp_case2";
		
		Error.clear();
	    new Controller(controlDataString);
	
	    
	    expected = 500.;
	
		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(StudyUtils.total_errors, 0);
		
		Assert.assertEquals(Error.getTotalError(), 0);
	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}
	

}
