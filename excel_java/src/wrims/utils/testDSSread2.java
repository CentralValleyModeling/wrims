package wrims.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

import vista.db.dss.DSSUtil;
import vista.set.Group;

public class testDSSread2 {

	
	public static void main(String[] args) throws IOException {
		
		String partA = "CALSIM";
		String partB = "S_SHSTALEVEL5";
		String partC = "STORAGE-LEVEL";
		String partE = "1MON";
		String partF = "CALSIM30_10";
		String dssFilePath="D:\\cvwrsm\\trunk\\excel_java\\CalSim30_10_SV.dss";
		String startTime = "31JAN1982 2400";
		String endTime = "31JUL1982 2400";
		
		String filePath = "workbook.xlsm";
		String sheetName = "Control";
		
		
		Group g = DSSUtil.createGroup("local", dssFilePath);
		double[] d = ReadDSS.readDSS(g, startTime, endTime, partA, partB, partC, partE, partF);
		
		int ci = 4;
		int ri = 9;
		Workbook wb = ExcelUtil.getWorkbook(filePath);
		
		
		
		wb = ExcelUtil.modifyWorkBook(wb, sheetName, ci, ri, d);
		ExcelUtil.writeWorkbookToFile(wb, filePath);
		
	}	

}
