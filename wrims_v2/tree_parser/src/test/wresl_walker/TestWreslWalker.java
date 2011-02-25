
package test.wresl_walker;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;

import components.FileParser;

import wresl.WreslTreeWalker;

public class TestWreslWalker {
	
	
	public String inputFilePath;


	
	@Test(groups = { "WRESL_elements" })
	public void example() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\example.wresl";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		System.out.println("tree = " + walker.commonTree.toStringTree());
		System.out.println("result = " + walker.result);
		

	}
	
	@Test(groups = { "WRESL_elements" })
	public void dvar_std() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestConvertWresl_dvarStd.wresl";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		System.out.println("tree = " + walker.commonTree.toStringTree());
		//System.out.println("result = " + walker.result);
		

	}	
	
}
