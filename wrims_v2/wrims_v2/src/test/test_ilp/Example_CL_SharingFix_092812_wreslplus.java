package test.test_ilp;

import java.io.IOException;

import lpsolve.LpSolveException;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;

public class Example_CL_SharingFix_092812_wreslplus {
	
	private double tolerance_perc = 0.0001/1000000; // 0.1 ppb
	private String studyPath;	
	private double expected;
	
	@Test(groups = { "ilp_config_example_callite" })
	public void Future_BO_36steps_wreslplus() throws RecognitionException, IOException{
		
		studyPath = "J:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CL_SharingFix_092812\\";

		/// set control data		
		String[] controlDataString = {

				
	    "-config=\"J:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CL_SharingFix_092812\\Future_BO_36steps_wreslplus.config\"" 
				
		};

	
		Error.clear();
        new ControllerBatch(controlDataString);
        
        expected = 9.322149549230603E8; 
		
		double obj_value=-99;

			//obj_value = ControlData.lpsolve_objective;
			obj_value = ControlData.xasolver.getObjective();
		
		Assert.assertEquals(Error.getTotalError(), 0);	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	}
	
}
