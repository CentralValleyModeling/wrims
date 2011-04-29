
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_svar {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_elements" })
	public void svar_case() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_svar_case";
		inputFilePath = projectPath+csvFolderPath+".wresl";
		logFilePath = csvFolderPath+".log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 

		LogUtils.studySummary_details(sd);

		LogUtils.closeLogFile();
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\svar.csv");	
		
		String s;
		int n;
	
		s ="svar_global,case1,1,month>=jan .and. month<=feb .and. sri_ytp==5 .and. c_nimbus_fmp_mif(-1)<800.,select feb from sacramento_runoff where wateryear=wateryear";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "svar_global,case2,2,always,300.0";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		s = "svar_local,mar_sep,1,month>=mar .and. month<=sep,sum(i=-(month-may);sep-month) i_folsm(i)*cfs_taf(i)+i300(i)*cfs_taf(i)";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "svar_local,other,2,always,min(max(i_folsm(i);200);i300(i))";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_global.get(0),"svar_global" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).svList_local.get(0),"svar_local" );
	}
}
