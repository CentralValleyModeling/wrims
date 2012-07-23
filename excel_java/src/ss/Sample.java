package ss;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;


public class Sample {
	
	
	public static void main(String[] args){

		

	    try {
			test();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}
	
	public static void test() throws Exception{
		
	    Workbook wb = new HSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();

	    Workbook wb2 = new XSSFWorkbook();
	    FileOutputStream fileOut2 = new FileOutputStream("workbook2.xlsm");
	    wb2.write(fileOut2);
	    fileOut.close();
	}
	

}
