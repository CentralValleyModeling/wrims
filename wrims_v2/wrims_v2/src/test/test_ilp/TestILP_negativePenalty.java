package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.*;
import wrimsv2.components.Error;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;

public class TestILP_negativePenalty {
	
	private double tolerance_perc = 0.01/1000000; // 0.01 ppm
	private String studyPath;	
	private String dssPath;	
	private double expected;
	
	@Test(groups = { "ilp" })
	public void case1() throws RecognitionException, IOException{
		
		studyPath = "examples\\negativePenalty\\case1\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "Case1.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv1.dss",
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
		 "csv"};

		FilePaths.ilpFileDirectory = studyPath+"..\\ilp";
		FilePaths.ilpFile = "case1.ilp";
		
        new Controller(controlDataString);
        
        expected = 10010.;

		double obj_value =  ControlData.xasolver.getObjective();
	    Assert.assertEquals(Error.getTotalError(), 0);
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}

	@Test(groups = { "ilp" })
	public void case2() throws RecognitionException, IOException{
		
		studyPath = "examples\\negativePenalty\\case2\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "Case2.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv2.dss",
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
		 "csv"};
	
		FilePaths.ilpFileDirectory = studyPath+"..\\ilp";
		FilePaths.ilpFile = "case2.ilp";
		
	    new Controller(controlDataString);
	    
	    expected = 30.;
	
		double obj_value =  ControlData.xasolver.getObjective();
	    Assert.assertEquals(Error.getTotalError(), 0);
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}

	@Test(groups = { "ilp" })
	public void case3() throws RecognitionException, IOException{
		
		studyPath = "examples\\negativePenalty\\case3\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "Case3.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv3.dss",
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
		 "csv"};
	
		FilePaths.ilpFileDirectory = studyPath+"..\\ilp";
		FilePaths.ilpFile = "case3.ilp";
		
	    new Controller(controlDataString);
	    
	    expected = 20.;
	
		double obj_value =  ControlData.xasolver.getObjective();
	    Assert.assertEquals(Error.getTotalError(), 0);
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	
	}

	@Test(groups = { "ilp" })
	public void case4() throws RecognitionException, IOException{
		
		studyPath = "examples\\negativePenalty\\case4\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "Case4.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv4.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1927",
		"4",
		 "30",
		 "1927",
		 "4",
		 "30", 
		 "ILP", 
		 "csv"};
	
		FilePaths.clear();
		FilePaths.ilpFileDirectory = studyPath+"\\ilp";
		FilePaths.ilpFile = "case4.ilp";
		
	    new Controller(controlDataString);
		
	    expected = -1743.0;
	
		double obj_value =  ControlData.xasolver.getObjective();
	    Assert.assertEquals(Error.getTotalError(), 0);
		Assert.assertEquals(obj_value, expected, Math.abs(expected*tolerance_perc));	
	
	}

	@Test(groups = { "ilp" })
	public void case4_2month() throws RecognitionException, IOException{
		
		studyPath = "examples\\negativePenalty\\case4\\";
		dssPath = studyPath;
		
		/// set control data		
		String[] controlDataString = {
		studyPath,   //groundwater dir
		studyPath + "Case4.wresl",
		dssPath +   "SV.dss",
		dssPath +   "INIT.dss",
		dssPath +   "dv4_2.dss",
		"F_part",       // sv dv F part
		"F_part",       // init file F part
		"A_part",       // part A
		"1MON",
		"1927",
		"3",
		 "31",
		 "1927",
		 "4",
		 "30", 
		 "ILP", 
		 "csv"};
	
		FilePaths.clear();
		FilePaths.ilpFileDirectory = studyPath+"\\ilp";
		
	    new Controller(controlDataString);
		
	    expected = -1743.0;
	
		double obj_value =  ControlData.xasolver.getObjective();
	    Assert.assertEquals(Error.getTotalError(), 0);
		Assert.assertEquals(obj_value, expected, Math.abs(expected*tolerance_perc));	
	
	}
	

}
