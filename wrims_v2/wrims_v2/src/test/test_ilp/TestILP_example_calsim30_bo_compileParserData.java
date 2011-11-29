package test.test_ilp;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.ControlData;
import wrimsv2.components.ControllerBatch;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;

public class TestILP_example_calsim30_bo_compileParserData {
	
	
	@Test(groups = { "ilp_config_example_calsim3" })
	public void calsim3() throws RecognitionException, IOException{
		
		String mainWreslFilePath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\calsim30_bo_svn51\\conv\\Run\\mainCONV_30.wresl";
		String parFilePath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\calsim30_bo_svn51\\conv\\Run\\mainCONV_30.par";
				
		// -mainwresl="D:\cvwrsm\trunk\wrims_v2\wrims_v2\examples\calsim30_bo_svn51\conv\Run\mainCONV_30.wresl"
		String[] controlDataString = {

		"-mainwresl=\""+ mainWreslFilePath + "\"", 
	  	};
	
		File parFile = new File(parFilePath);
		if (parFile.exists()) parFile.delete();
		
		Assert.assertEquals(parFile.exists(), false);	
		
		Error.clear();
        new ControllerBatch(controlDataString);
        	
		Assert.assertEquals(parFile.exists(), true);	
	
	}
}
