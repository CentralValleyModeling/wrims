package test.test_xasolver;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.*;

public class TestXASolver {

	@Test(groups = { "xa_solver_example_studies" })
	public void example1_step1() throws RecognitionException, IOException{
		
		/// set control data		
		String[] controlDataString = {
		"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\example1\\run\\mainEx1.wresl",
		"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\example1\\dss\\ExampleSV.dss",
		"D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\example1\\dss\\ExampleINIT.dss",
		"",

		"EXAMPLE",
		"INIT",
		"CALSIM",
		"1MON",
		"1921",
		"10",
		 "31",
		 "1921",
		 "10",
		 "31", 
		 "XA", 
		 "csv_Example1"};
		
        new Controller(controlDataString);

		// TODO: compare objective function value 
        // wrims v1 XA16 OBJ: 41169932.383266 
        // wrims v2 XA16 OBJ: 41169932.835543
		Assert.assertEquals(0, 1);	
	}
}
