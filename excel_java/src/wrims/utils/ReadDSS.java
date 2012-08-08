package wrims.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

import vista.db.dss.DSSUtil;
import vista.set.DataReference;
import vista.set.DataSet;
import vista.set.Group;
import vista.set.RegularTimeSeries;
import vista.time.Time;
import vista.time.TimeFactory;
import vista.time.TimeWindow;

public class ReadDSS {

	
	public static void main(String[] args) throws IOException {
		
		String partA = "CALSIM";
		String partB = "S_SHSTALEVEL5";
		String partC = "STORAGE-LEVEL";
		String partE = "1MON";
		String partF = "CALSIM30_10";
		String dssFilePath="D:\\cvwrsm\\trunk\\excel_java\\CalSim30_10_SV.dss";
		String startTime = "31JAN1982 2400";
		String endTime = "31JUL1982 2400";
		
		Group g = DSSUtil.createGroup("local", dssFilePath);
		double[] d = readDSS(g, startTime, endTime, partA, partB, partC, partE, partF);
		
		String filePath = "workbook.xlsm";
		String sheetName = "Control";
		int ci = 4;
		int ri = 9;
		Workbook wb = ExcelUtil.getWorkbook(filePath);
		wb = ExcelUtil.modifyWorkBook(wb, sheetName, ci, ri, d);
		ExcelUtil.writeWorkbookToFile(wb, filePath);
		
	}	

	
	public static double[] readDSS(Group group, String startTime, String endTime, String partA, String partB, String partC, String partE, String partF) {

		partA = regularExp(partA);
		partB = regularExp(partB);
		partC = regularExp(partC);
		partE = regularExp(partE);
		partF = regularExp(partF);
		
		DataReference[] refs = group.find(new String[]{ partA, partB, partC, "", partE, partF});

		Time st = TimeFactory.getInstance().createTime(startTime);
		Time et = TimeFactory.getInstance().createTime(endTime);
		TimeWindow tw = TimeFactory.getInstance().createTimeWindow(st,et);
		
		DataReference r = DataReference.create(refs[0], tw);
		DataSet ds = r.getData();	
		RegularTimeSeries rts=(RegularTimeSeries)ds;
		
		for (double d :  rts.getYArray()){
			System.out.println(d);
		}
		
		return rts.getYArray();
	}
	
	public static String regularExp(String part){
		return "^"+part+"$";
	}
}
