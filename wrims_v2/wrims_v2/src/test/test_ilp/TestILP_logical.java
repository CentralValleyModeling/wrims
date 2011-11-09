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

public class TestILP_logical {
	
	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private String studyPath;	
	private String dssPath;	
	private double expected;
	
	@Test(groups = { "ilp_simple" })
	public void july() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\logical\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "logical.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv.dss",
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
		 "csv_ilp_logical"};

		FilePaths.ilpFileDirectory = "ilp_TestIlp_logical";
		
		Error.clear();
        new Controller(controlDataString);

        
        expected = 999.;

		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(StudyUtils.total_errors, 0);
		
		Assert.assertEquals(Error.getTotalError(), 0);

		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}

	@Test(groups = { "ilp_simple" })
	public void august() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\logical\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "logical.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1921",
		"8",
		 "31",
		 "1921",
		 "8",
		 "31", 
		 "ILP", 
		 "csv_ilp_logical"};
	
		FilePaths.ilpFileDirectory = "ilp_TestIlp_logical";
		
		Error.clear();
	    new Controller(controlDataString);
	
	    
	    expected = 30.;
	
		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(StudyUtils.total_errors, 0);
		
		Assert.assertEquals(Error.getTotalError(), 0);
	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}

	@Test(groups = { "ilp_simple" })
	public void september() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\logical\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "logical.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1921",
		"9",
		 "30",
		 "1921",
		 "9",
		 "30", 
		 "ILP", 
		 "csv_ilp_logical"};
	
		FilePaths.ilpFileDirectory = "ilp_TestIlp_logical";
		
		Error.clear();
	    new Controller(controlDataString);
	
	    
	    expected = 30.;
	
		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(StudyUtils.total_errors, 0);
		
		Assert.assertEquals(Error.getTotalError(), 0);
	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}

	@Test(groups = { "ilp_simple" })
	public void october() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\logical\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "logical.wresl",
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
		 "csv_ilp_logical"};
	
		FilePaths.ilpFileDirectory = "ilp_TestIlp_logical";
		
		Error.clear();
	    new Controller(controlDataString);
	
	    
	    expected = 30.;
	
		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(StudyUtils.total_errors, 0);
		
		Assert.assertEquals(Error.getTotalError(), 0);
	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}

	@Test(groups = { "ilp_simple" })
	public void november() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\logical\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "logical.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1921",
		"11",
		 "30",
		 "1921",
		 "11",
		 "30", 
		 "ILP", 
		 "csv_ilp_logical"};
	
		FilePaths.ilpFileDirectory = "ilp_TestIlp_logical";
		
		Error.clear();
	    new Controller(controlDataString);
	
	    
	    expected = 999.;
	
		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(StudyUtils.total_errors, 0);
		
		Assert.assertEquals(Error.getTotalError(), 0);
	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}
	

}
