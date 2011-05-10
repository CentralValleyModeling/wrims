package test.test_evaluator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.components.ControlData;
import wrimsv2.components.Controller;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;

public class testController {

	public void testSvControl() throws RecognitionException, IOException{
        FilePaths.fullSvarDssPath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09ESV.dss";
        FilePaths.fullInitDssPath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09EINIT.DSS";
        FilePaths.setMainFilePaths("D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\main.wresl");
		ControlData cd=new ControlData();
		cd.endYear=1921;
		cd.endMonth=11;
		cd.endDay=30;
		
		StudyDataSet sds=new StudyDataSet();
		Map<String, ModelDataSet> mdsm=new HashMap<String, ModelDataSet>();
		sds.setModelDataSetMap(mdsm);
		ArrayList<String> modelList=new ArrayList<String> ();
		sds.setModelList(modelList);
		modelList.add("base");
		modelList.add("wheeling");
		ModelDataSet mds1=new ModelDataSet();
		ModelDataSet mds2=new ModelDataSet();
		mdsm.put("base", mds1);
		mdsm.put("wheeling", mds2);
		
		Map<String, Svar> svarMap1=new HashMap<String, Svar>();
		mds1.svMap=svarMap1;
		ArrayList<String> svarList1=new ArrayList<String> ();
		mds1.svList=svarList1;
		Map<String, Svar> svarMap2=new HashMap<String, Svar>();
		mds2.svMap=svarMap2;
		ArrayList<String> svarList2=new ArrayList<String> ();
		mds2.svList=svarList2;		
		
		Svar svar1=new Svar();
		String svar1Name="bf601";
		svarList1.add(svar1Name);
		svarMap1.put(svar1Name, svar1);
		svar1.kind="bf-flow";
		svar1.units="cfs";
		svar1.caseCondition.add("always");
		svar1.caseExpression.add("timeseries");
		
		Svar svar2=new Svar();
		String svar2Name="bf601Pre";
		svarList1.add(svar2Name);
		svarMap1.put(svar2Name, svar2);
		svar2.kind="bf-flow";
		svar2.units="cfs";
		svar2.caseCondition.add("always");
		svar2.caseExpression.add("bf601(-1)");		
		
		Svar svar3=new Svar();
		String svar3Name="testLookup";
		svarList1.add(svar3Name);
		svarMap1.put(svar3Name, svar3);
		svar3.kind="undefined";
		svar3.units="cfs";
		svar3.caseCondition.add("(6+8)*4>(3-2) .and. 100-4<3");
		svar3.caseCondition.add("always");
		svar3.caseExpression.add("1.0");
		svar3.caseExpression.add("select demand from swp_3pattern_demands given percent=75 use linear where contractor=1; month=7");
		//svar3.caseExpression.add("1+annlinegen(6472.58740234; 8065.77587891; 9674.55859375; 7614.22070313; 1844.08239746; 829.421325684; 0.0; 2808.64648438;  1565.21533203; 799.454162598; 645.070129395; 816.196533203; 1269.01464844; 0.0; 26.0; 31.0; 31.0; 30.0; 1061.79003906; 3956.91992188; 3897.29638672; 2362.15014648; 1330.7467041; 200.450531006; 241.239242554; 0.0; 54.8862113953; -141; 330.817657471; 365.760253906; 384.316558838; 375.362304688; 346.135650635; 603.290405273; 648.479736328; 647.118896484; 647.933044434; 637.05291748; 31; 30; 31; 31; 30; 964.91; 10000; 12000; 2; 2; 1; 12; 1990; 3)");
		
		Svar svar4=new Svar();
		String svar4Name="testSumFunction";
		svarList1.add(svar4Name);
		svarMap1.put(svar4Name, svar4);
		svar4.kind="undefined";
		svar4.units="cfs";
		svar4.caseCondition.add("{bf601}-0.3<0");
		svar4.caseCondition.add("always");
		svar4.caseExpression.add("1.0");
		svar4.caseExpression.add("sum(i=month-prevjul;oct;-2) 3.0*bf601(i)");
		
		Svar svar5=new Svar();
		String svar5Name="testCycle";
		svarList2.add(svar5Name);
		svarMap2.put(svar5Name, svar5);
		svar5.kind="undefined";
		svar5.units="cfs";
		svar5.caseCondition.add("always");
		svar5.caseExpression.add("2*testSumFunction[base]");

		Map<String, Goal> gMap1=new HashMap<String, Goal>();
		mds1.gMap=gMap1;
		ArrayList<String> gList1=new ArrayList<String> ();
		mds1.gList=gList1;
		Map<String, Goal> gMap2=new HashMap<String, Goal>();
		mds2.gMap=gMap2;
		ArrayList<String> gList2=new ArrayList<String> ();
		mds2.gList=gList2;
		
		Goal goal1=new Goal();
		String goal1Name="testGoal1";
		gList1.add(goal1Name);
		gMap1.put(goal1Name, goal1);
		goal1.caseCondition.add("always");
		goal1.caseExpression.add("(2+a)*3.4-(5+6*7.0)*b+4*f<(2+{bf601})*6+3*f");
		
		Goal goal2=new Goal();
		String goal2Name="testGoal2";
		gList2.add(goal2Name);
		gMap2.put(goal2Name, goal2);
		goal2.caseCondition.add("always");
		goal2.caseExpression.add("max(4;-3)*a+min(3.1;100.2)*b+pow(3;abs(-2))*c+int(5.43)*d+log(2)*e<log10(10.0)");		
		
		new Controller();
		Error.writeEvaluationErrorFile("runtime_error.txt");
	}
	
	public void testParsedCalsim3()throws RecognitionException, IOException{
        FilePaths.fullSvarDssPath="D:\\CALSIM30_041311_BO\\common\\DSS\\CalSim30_06_SV.dss";
        FilePaths.fullInitDssPath="D:\\CALSIM30_041311_BO\\common\\DSS\\CalSim30_06Init.dss";
        FilePaths.setMainFilePaths("D:\\CALSIM30_041311_BO\\CONV\\Run\\mainCONV_30.wresl");
		ControlData cd=new ControlData();
		cd.startYear=1921;
		cd.startMonth=10;
		cd.startDay=31;
		cd.endYear=2006;
		cd.endMonth=11;
		cd.endDay=30;
		cd.currYear=cd.startYear;
		cd.currMonth=cd.startMonth;
		cd.currDay=cd.startDay;
		cd.svDvPartF="CALSIM30_06";
		cd.initPartF="CALSIM30_06";
		
		StudyDataSet sds=parseCalsim3();
		
		new Controller();
		Error.writeEvaluationErrorFile("evaluation_error.txt");
	}
	
	public StudyDataSet parseCalsim3() throws RecognitionException, IOException{
		
		String csvFolderPath = "TestWreslWalker_calsim3_full_study";
		String inputFilePath = "D:\\CALSIM30_041311_BO\\CONV\\Run\\mainCONV_30.wresl";
		String logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
				
		/// write full study data to csv files
		WriteCSV.study(sd, csvFolderPath ) ;
	
		return sd;	
	}
	
	@Test
	public void testParsedCalLite()throws RecognitionException, IOException{
        FilePaths.fullSvarDssPath="D:\\CalLite_Beta_042611\\DSS\\CL_FUTURE_WHL042611_SV.dss";
        FilePaths.fullInitDssPath="D:\\CalLite_Beta_042611\\DSS\\CalLite2020D09EINIT.dss";
        FilePaths.setMainFilePaths("D:\\CalLite_Beta_042611\\Run\\main_BO.wresl");
		ControlData cd=new ControlData();
		cd.startYear=1921;
		cd.startMonth=10;
		cd.startDay=31;
		cd.endYear=2003;
		cd.endMonth=9;
		cd.endDay=30;
		cd.currYear=cd.startYear;
		cd.currMonth=cd.startMonth;
		cd.currDay=cd.startDay;
		cd.svDvPartF="2020D09E";
		cd.initPartF="2020D09E";
		
		StudyDataSet sds=parseCalLite();
		
		new Controller();
		Error.writeEvaluationErrorFile("evaluation_error.txt");
	}
	
	public StudyDataSet parseCalLite() throws RecognitionException, IOException{
		
		String csvFolderPath = "TestWreslWalker_callite_full_study";
		String inputFilePath = "D:\\CalLite_Beta_042611\\Run\\main_BO.wresl";
		String logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
				
		/// write full study data to csv files
		WriteCSV.study(sd, csvFolderPath ) ;
	
		return sd;	
	}
}
