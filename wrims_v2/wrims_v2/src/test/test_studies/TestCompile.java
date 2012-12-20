package test.test_studies;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;

import wrimsv2.components.Controller;
import wrimsv2.components.FilePaths;
import wrimsv2.debug.Compile;
import wrimsv2.wreslparser.elements.StudyUtils;

public class TestCompile {
	@Test
	public void testMain() throws RecognitionException, IOException{
		Compile.checkStudy("D:\\D1485_v14\\Run\\main_BO.wresl", true);
	}
}
