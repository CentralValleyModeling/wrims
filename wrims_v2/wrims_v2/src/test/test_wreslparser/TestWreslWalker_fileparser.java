
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.FileParser;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.SimulationDataSet;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslparser.grammar.WreslTreeWalker;

public class TestWreslWalker_fileparser {
	
	public String projectPath = "src\\test\\test_wreslparser_v2\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void simple() throws RecognitionException, IOException {
		String fileFullPath="D:/CS3_Studies/CS3_BO_version120A/common/System/SystemTables_Sac/constraints-Connectivity.wresl";
		try {
			WreslTreeWalker walker = FileParser.parseOneFileForDebug(fileFullPath);
			SimulationDataSet fileDataSet = walker.thisFileDataSet;
			ArrayList<String> dvList = fileDataSet.dvList;
			ArrayList<String> svList = fileDataSet.svList;
			ArrayList<String> asList = fileDataSet.asList;
			ArrayList<String> tsList = fileDataSet.tsList;
			ArrayList<String> sortedList=fileDataSet.asList;
			asList.removeAll(dvList);
			sortedList.addAll(dvList);
			sortedList.addAll(svList);
			sortedList.addAll(tsList);
			
			ArrayList<String> gList = fileDataSet.gList;
			for (String gName:gList){
				Set<String> dependants = fileDataSet.gMap.get(gName).expressionDependants;
				Iterator<String> iterator = dependants.iterator();
				while (iterator.hasNext()){
					String varName=iterator.next();
					if (!sortedList.contains(varName)){
						sortedList.add(varName);
					}
				}
			}
			Collections.sort(sortedList);
			System.out.println(sortedList);
		}catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
