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

public class TestILP_example_callite_uniqueSolution_config_newAlias_lpsolve {
	
	private double tolerance_perc = 0.0001/1000000; // 0.1 ppb
	private String studyPath;	
	private double expected;
	
	@Test(groups = { "ilp_config_example_callite" })
	public void callite_newAlias_unique_36steps() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\callite_uniqueSolution\\";
		/// set control data		
		String[] controlDataString = {

		"-config=\"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\callite_uniqueSolution\\callite_newAlias_lpsolve.config\"" 

		};

		//FilePaths.ilpFileDirectory = studyPath + "ilp_TestILP_example_callite_config_Nsteps";
		//FilePaths.ilpFile = "test.ilp";		
		Error.clear();
        new ControllerBatch(controlDataString);
        
        expected = 9.290264401055747E8; 
		
		double obj_value=-99;

			obj_value = ControlData.lpsolve_objective;
		
		Assert.assertEquals(Error.getTotalError(), 0);	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	}
	
//	@Test(groups = { "ilp_config_example_callite" })
//	public void callite_newAlias_unique_36steps() throws RecognitionException, IOException{
//		
//		studyPath = "D:\\cvwrsm\\trunk\\callite\\CalLite\\";
//		/// set control data		
//		String[] controlDataString = {
//
//		"-config=\"D:\\cvwrsm\\trunk\\callite\\CalLite\\Run\\demo.config\"" 
//
//		};
//
//		//FilePaths.ilpFileDirectory = studyPath + "ilp_TestILP_example_callite_config_Nsteps";
//		//FilePaths.ilpFile = "test.ilp";		
//		Error.clear();
//        new ControllerBatch(controlDataString);
//        
//        expected = 9.290264177187278E8; 
//		
//		double obj_value=-99;
//
//			obj_value = ControlData.lpsolve_objective;
//		
//		Assert.assertEquals(Error.getTotalError(), 0);	
//		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
//	}
}
