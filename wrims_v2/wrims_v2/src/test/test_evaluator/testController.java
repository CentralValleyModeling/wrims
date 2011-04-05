package test.test_evaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.components.ControlData;
import wrimsv2.components.Controller;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;

public class testController {
	@Test
	public void testSvControl(){
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
		ModelDataSet mds1=new ModelDataSet();
		mdsm.put("base", mds1);
		Map<String, Svar> svarMap1=new HashMap<String, Svar>();
		mds1.svMap=svarMap1;
		ArrayList<String> svarList1=new ArrayList<String> ();
		mds1.svList=svarList1;
		
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
		
		new Controller(sds);
		Error.writeEvaluationErrorFile("runtime_error.txt");
	}
}
