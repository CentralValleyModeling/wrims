
package test.test_distribute;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.components.Versions;

public class TestDistribute {
	
	
	@Test(groups = { "distribute" })
	public void version_svn() {
		
		new Versions().getSVN();
		

	
		Assert.assertEquals(1, 0);	
		
	}	
}
