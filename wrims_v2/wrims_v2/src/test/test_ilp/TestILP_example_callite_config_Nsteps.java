package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;

public class TestILP_example_callite_config_Nsteps {
	
	private double tolerance_perc = 0.0001/1000000; // 0.1 ppb
	private String studyPath;	
	private double expected;
	
	@Test(groups = { "ilp_config_example_callite" })
	public void callite_Nsteps() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\callite_svn47\\";
		/// set control data		
		String[] controlDataString = {

		"-config=\"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\callite_svn47\\test_Nsteps.config\"" 

		};

		FilePaths.ilpFileDirectory = studyPath + "ilp_TestILP_example_callite_config_Nsteps";
		//FilePaths.ilpFile = "test.ilp";		
		Error.clear();
        new ControllerBatch(controlDataString);
        
        expected = 9.651283097922951E8; 
		
		double obj_value =  ControlData.xasolver.getObjective();		
		Assert.assertEquals(Error.getTotalError(), 0);	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	}
	
	@Test(groups = { "ilp_config_example_callite" })
	public void callite_Nsteps_lpsolve() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\callite_svn47\\";
		/// set control data		
		String[] controlDataString = {

		"-config=\"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\callite_svn47\\test_lpsolve.config\"" 

		};

		//FilePaths.ilpFileDirectory = studyPath + "ilp_TestILP_example_callite_config_Nsteps";
		//FilePaths.ilpFile = "test.ilp";		
		Error.clear();
        new ControllerBatch(controlDataString);
        
        expected = 9.651283097922951E8; 
		
		double obj_value =  ControlData.lpsolve_objective;		
		Assert.assertEquals(Error.getTotalError(), 0);	
		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	
	}
}
