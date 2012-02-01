package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;

public class TestILP_example_calsim30_bo_config_step2 {
	
	private double tolerance_perc = 0.0001/1000000; // 0.1 ppb
	private String studyPath;	
	private double expected;
	
	@Test(groups = { "ilp_config_example_calsim3" })
	public void calsim3_step2() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\calsim30_bo_svn51\\";
		/// set control data		
		String[] controlDataString = {

		"-config=\"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\calsim30_bo_svn51\\conv\\Run\\step2.config\"" 

		};

		FilePaths.ilpFileDirectory = studyPath + "ilp_TestIlp_example_calsim30_bo_config_step2";
		//FilePaths.ilpFile = "test.ilp";		
		Error.clear();
        new ControllerBatch(controlDataString);
        
        expected = 1.766497094428481E10;
		
		double obj_value =  ControlData.xasolver.getObjective();		
		Assert.assertEquals(Error.getTotalError(), 0);	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	}
}
