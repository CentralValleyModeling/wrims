package test.test_ilp;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;

import wrimsv2.components.ControllerBatch;

public class TestILP_version {
	
	
	@Test(groups = { "version" })
	public void version() throws RecognitionException, IOException{
		
		String[] controlDataString = {

		"-version"
	  	};
	
        new ControllerBatch(controlDataString);
	}
}
