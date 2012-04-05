package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.*;

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
				"-config=\"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\simple1\\Run\\simple1.config\"" 
				};

//		FilePaths.ilpFileDirectory = "ilp_TestIlp_Simple1";
//		FilePaths.ilpFile = "test.ilp";
		
        new ControllerBatch(controlDataString);

        
        expected = 3.0;

		double obj_value =  ControlData.xasolver.getObjective();
		
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}
	

}
