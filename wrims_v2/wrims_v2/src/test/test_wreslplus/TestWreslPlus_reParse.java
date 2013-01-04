package test.test_wreslplus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.Workflow;
import wrimsv2.wreslplus.elements.procedures.ToWreslData;


public class TestWreslPlus_reParse {
	
	public String projectPath = TestParam.projectPath;	
	public String inputFilePath;
	public String inputFilePath_include;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void reParse() throws RecognitionException, IOException {
		
	
		testName = TestParam.testNamePrepend + "_reParse";
		csvFolderPath = TestParam.csvFolderPrepend +"testResult_wreslplus\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		inputFilePath_include = projectPath + testName + "_include"+TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		// before modification
		String wreslText_original = Tools.readFileAsString(inputFilePath_include);
		System.out.println(wreslText_original);
		
		// parse and print result
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		System.out.println("StudyTemp:");
		System.out.println(styTemp.seqMap.get("cycle1").glMap.get("g").caseExpression.get(0));
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		System.out.println("StudyDataSet:");
		System.out.println(sd.getModelDataSetMap().get("first").gMap.get("g").caseExpression.get(0));	
		
		// modify wresl file, replace 7 with 888
		FileWriter fstream = new FileWriter(inputFilePath_include);
		BufferedWriter out = new BufferedWriter(fstream);
		String wreslText_mod = wreslText_original.replace("7", "888");
		out.write(wreslText_mod);
		out.close();
		
		// print modified wresl
		System.out.println(wreslText_mod);
		  
		// parse modified wresl and print result
		styTemp=Workflow.checkStudy(absFilePath);		
		System.out.println("StudyTemp:");
		System.out.println(styTemp.seqMap.get("cycle1").glMap.get("g").caseExpression.get(0));
		
		sd = ToWreslData.convertStudy(styTemp);
		System.out.println("StudyDataSet:");  
		System.out.println(sd.getModelDataSetMap().get("first").gMap.get("g").caseExpression.get(0));			  
		
		// revert wresl file
		fstream = new FileWriter(inputFilePath_include);
		out = new BufferedWriter(fstream);
		out.write(wreslText_original);
		out.close();
		
		LogUtils.closeLogFile();
		
		int ub = Integer.parseInt(sd.getModelDataSetMap().get("first").dvMap.get("x").upperBound);
		Assert.assertEquals(ub, 888);	
		
	
	}
}
