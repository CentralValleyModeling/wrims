package wrimsv2.wreslplus.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;



import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.wreslparser.elements.LogUtils;

public class Procedures {
	
	
	private Procedures(){}


	public static StudyTemp processDependants(StudyTemp s){
		
		
		for (String m: s.modelList){			

			ModelTemp mObj = s.modelMap.get(m);
			
			for (String svKey: mObj.svMap.keySet()){			
				
				SvarTemp svObj = mObj.svMap.get(svKey);
				
				//svObj.dependants.removeAll(arg0);
				//svObj.caseCondition = Tools.replace_ignoreChar(svObj.caseCondition);
				//svObj.caseExpression = 
				
				//o.caseCondition = Tools.allToLowerCase(s.caseCondition);
				//o.caseExpression = Tools.allToLowerCase(s.caseExpression);
				
			}			

		}
		
		return s;

	}	
	


	

}
	
