package wrims.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;

import vista.db.dss.DSSUtil;
import vista.set.Group;
import vista.set.RegularTimeSeries;
import wrimsv2.evaluator.TimeOperation;

public class testDSSread2 {

	public static void main(String[] args) throws IOException {

		int beginYear = 1921;
		int beginMonth = 10;
		int endYear = 1923;
		int endMonth = 8;
		String partA = "CALSIM";
		String partE = "1MON";
		String partF = "CALSIM30_10";
		String dssFilePath = "D:\\cvwrsm\\trunk\\excel_java\\CalSim30_10_SV.dss";
		String excelFilePath = "OperationsControl_CS3_version134.xlsm";
		String readSheetName = "DSS Group";
		String writeSheetName = "Data";
		
		// write date
		int svTimeColIndex = 1;
		int dvTimeColIndex = 5;
		int timeRowIndex = 12;		
	
		
		// SV input
		int numberOfSvVars = 3;
		int svRowIndex = 6;
		int svColIndex_partB = 3;
		int svColIndex_partC = 3;
		
		// SV data
		int svDataColIndex = svTimeColIndex + 1;	
		int svDataRowIndex = timeRowIndex;
		
		
		// DV input
		
		// SV data
		
		
		
		
		

		int beginDay = TimeOperation.numberOfDays(beginMonth,beginYear);
		int endDay = TimeOperation.numberOfDays(endMonth,endYear);
		
		String[] ss = getDateList(beginYear, beginMonth, endYear, endMonth);
		
		System.out.println(Arrays.toString(ss));
		
		//String startTime = "15MAR1982 2400";
		//String endTime = "15JUL1982 2400";
		
		String startTime = beginDay+toMonth(beginMonth)+ beginYear + " 2400";
		String endTime =   endDay  +toMonth(endMonth)  + endYear   + " 2400";	
		
		System.out.println(startTime);
		System.out.println(endTime);
		

		
		Workbook wb = ExcelUtil.getWorkbook(excelFilePath);


		

		
		String[] svPartB = ExcelUtil.readColumn(wb, readSheetName, svColIndex_partB, svRowIndex, numberOfSvVars);
		String[] svPartC = ExcelUtil.readColumn(wb, readSheetName, svColIndex_partC, svRowIndex, numberOfSvVars);

		System.out.println("SV");

		for (int i = 0; i < svPartB.length; i++) {
			System.out.println(svPartB[i] + ":" + svPartC[i]);
		}

		Group g = ReadDSS.getGroup(DSSUtil.createGroup("local", dssFilePath), startTime, endTime, partA, partE, partF);


        
		RegularTimeSeries rts;

		
		for ( int i=0;i<3;i++){
			
			rts = ReadDSS.readDSS(g, svPartB[i], svPartC[i]);
			double[] d = rts.getYArray();

			wb = ExcelUtil.modifyWorkBook(wb, writeSheetName, svDataColIndex + i, svDataRowIndex, d);
		}
		
		

		
		wb = ExcelUtil.modifyWorkBook(wb, writeSheetName, svTimeColIndex, timeRowIndex, ss);
		wb = ExcelUtil.modifyWorkBook(wb, writeSheetName, dvTimeColIndex, timeRowIndex, ss);
		
		ExcelUtil.writeWorkbookToFile(wb, excelFilePath);


		
		System.out.println("finish");
	}
	
	
	public static String[] getDateList(int beginYear, int beginMonth, int endYear, int endMonth){
		
		int totalItems = ( endYear - beginYear )*12 + endMonth - beginMonth + 1;
		
		String[] out = new String[totalItems];
		
		
		int y;
		int m;
		int d;
		
		for ( int i=0; i< totalItems; i++){
			
			y = (i + beginMonth)/12 + beginYear;
			m = (i + beginMonth)%12;
			d = TimeOperation.numberOfDays(m,y);
			
			out[i] = m+"/"+d+"/"+y;
			
		}
		
		
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, year);
//        c.set(Calendar.MONTH, month);
//        c.set(Calendar.DAY_OF_MONTH, 15);
//        
//		System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return out;
	}
	
	public static String toMonth(int iMonth){
		
		
		String[] monthList ={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		
		
		return monthList[iMonth-1];
	}

}
