
package test.wresl_walker;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;

import components.FileParser;
import components.LogUtils;

import wresl.WreslTreeWalker;

public class TestWreslWalker {
	
	
	public String inputFilePath;


	

	public void example() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\example.wresl";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();

		LogUtils.setLogFile("TestWreslWalker_example.log");
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		LogUtils._logFile.close();
		
		System.out.println("tree = " + walker.commonTree.toStringTree());
		System.out.println("result = " + walker.result);
		

	}

	@Test(groups = { "WRESL_elements" })
	public void mainFile() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestWreslWalker_mainFile.wresl";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile("TestWreslWalker_mainFile.log");
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		LogUtils._logFile.close();
		
		System.out.println("tree = " + walker.commonTree.toStringTree());
		//System.out.println("result = " + walker.result);
		

	}		
	

	public void dvar_std() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestWreslWalker_dvarStd.wresl";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		LogUtils.setLogFile("TestWreslWalker_dvar_std.log");
		
		WreslTreeWalker walker = FileParser.parseFile(absFilePath);
		
		LogUtils._logFile.close();
		
		System.out.println("tree = " + walker.commonTree.toStringTree());
		//System.out.println("result = " + walker.result);
		

	}	
	
}
