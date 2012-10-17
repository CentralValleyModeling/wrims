package test.test_wreslplus;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.SequenceTemp;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.Workflow;
import wrimsv2.wreslplus.elements.procedures.ToWreslData;


public class TestWreslPlus_weightGroup {
	
	public String projectPath = TestParam.projectPath_wp;	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup1() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup1";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		for (String sss: styTemp.seqList){
			
			SequenceTemp se = styTemp.seqMap.get(sss);
			
			int ndv = se.dvList.size();
			
			System.out.println("se.dvList:"+se.dvList);
			Assert.assertEquals(ndv, 13);	
			
			int nwv = se.wvList.size();
			
			System.out.println("se.wvList:"+se.wvList);
			Assert.assertEquals(nwv, 11);	
			
		}
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		for (String sss: sd.getModelList()){
			
			ModelDataSet se = sd.getModelDataSetMap().get(sss);
			
			int w = se.wtMap.keySet().size();
			
			Assert.assertEquals(w, 11);	
			
		}
		
		
		WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup2() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup2";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		for (String sss: styTemp.seqList){
			
			SequenceTemp se = styTemp.seqMap.get(sss);
			
			int ndv = se.dvList.size();
			
			System.out.println("se.dvList:"+se.dvList);
			Assert.assertEquals(ndv, 13);	
			
			int nwv = se.wvList.size();
			
			System.out.println("se.wvList:"+se.wvList);
			Assert.assertEquals(nwv, 11);	
			
		}
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		for (String sss: sd.getModelList()){
			
			ModelDataSet se = sd.getModelDataSetMap().get(sss);
			
			int w = se.wtMap.keySet().size();
			
			Assert.assertEquals(w, 11);	
			
		}
		
		WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup3() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup3";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		for (String sss: styTemp.seqList){
			
			SequenceTemp se = styTemp.seqMap.get(sss);
			
			int ndv = se.dvList.size();
			
			System.out.println("se.dvList:"+se.dvList);
			Assert.assertEquals(ndv, 13);	
			
			int nwv = se.wvList.size();
			
			System.out.println("se.wvList:"+se.wvList);
			Assert.assertEquals(nwv, 11);	
			
		}
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		for (String sss: sd.getModelList()){
			
			ModelDataSet se = sd.getModelDataSetMap().get(sss);
			
			int w = se.wtMap.keySet().size();
			
			Assert.assertEquals(w, 11);	
			
		}
		
		WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup4() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup4";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		for (String sss: styTemp.seqList){
			
			SequenceTemp se = styTemp.seqMap.get(sss);
			
			int ndv = se.dvList.size();
			
			System.out.println("se.dvList:"+se.dvList);
			Assert.assertEquals(ndv, 13);	
			
			int nwv = se.wvList.size();
			
			System.out.println("se.wvList:"+se.wvList);
			Assert.assertEquals(nwv, 11);	
			
		}
		
		StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		for (String sss: sd.getModelList()){
			
			ModelDataSet se = sd.getModelDataSetMap().get(sss);
			
			int w = se.wtMap.keySet().size();
			
			Assert.assertEquals(w, 11);	
			
		}
		
		WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup5() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup5";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup6() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup6";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup7() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup7";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup8() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup8";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup9() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup9";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup10() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup10";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup11() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup11";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 4);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup12() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup12";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 2);		
	
	}
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void weightGroup13() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_weightGroup13";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 3);		
	
	}
}
