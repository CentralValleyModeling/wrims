
package test.test_distribute;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.BuildProps;

public class TestDistribute {
	
	
	@Test(groups = { "distribute" })
	public void version_vn() {
		
		new BuildProps().getVN();
		

	
		Assert.assertEquals(1, 0);	
		
	}	
}
