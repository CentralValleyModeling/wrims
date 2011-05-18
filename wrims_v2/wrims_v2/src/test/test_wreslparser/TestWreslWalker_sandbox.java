
package test.test_wreslparser;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class TestWreslWalker_sandbox {
	
	ArrayList<String> test;
	
	@Test(groups = { "sandbox" })
	public void testfunc ( ) {
	
	TestWreslWalker_readonly r = new TestWreslWalker_readonly();
	
	test = r.getX();

	System.out.println(" test = "+test);
	
	test.clear();
	test.add("modified");
	
	System.out.println(" test = "+test);
	
	System.out.println(" r.getX() = "+r.getX());
	}

}
