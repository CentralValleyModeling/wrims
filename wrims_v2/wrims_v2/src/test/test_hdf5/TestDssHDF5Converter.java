package test.test_hdf5;

import java.io.IOException;

import lpsolve.LpSolveException;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.hdf5.DSSHDF5Converter;

public class TestDssHDF5Converter {
	
	private double tolerance_perc = 0.0001/1000000; // 0.1 ppb
	private String studyPath;	
	private double expected;
	
	@Test
	public void DssHDF5Converter() throws RecognitionException, IOException{
		
		/// set control data		
		String[] controlDataString = {

				
	    "-config=\"D:\\CL_Existing_BO_noCC_FullDem\\Existing.config" 
				
		};

	
		Error.clear();
        new DSSHDF5Converter(controlDataString);
        	
	}
	
}
