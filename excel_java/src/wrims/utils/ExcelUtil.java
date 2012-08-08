package wrims.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static void main(String[] args) {

		String filePath = "OperationsControl_CS3_version134.xlsm";
		String readSheetName = "DSS Group";
		String writeSheetName = "test";
		int ci = 4;
		int ri = 9;

		double[] d = new double[4];

		d[0] = 11.13;
		d[1] = 22.9999;
		d[2] = 33.8;
		d[3] = 7733.8;


		Workbook wb = getWorkbook(filePath);


		String[] s = readColumn(wb, readSheetName, 4, 20, 5);
		
		for (String e: s){
			System.out.println(e);
		}

		try {
			wb.createSheet("test");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		wb = modifyWorkBook(wb, writeSheetName, ci, ri, d);

		writeWorkbookToFile(wb, filePath);

	}

	public static Workbook getWorkbook(String filePath) {

		InputStream inp;
		Workbook wb = null;
		//File inp = null;

		try {
			//inp = new File(filePath);
			inp = new FileInputStream(filePath);
			wb = WorkbookFactory.create(inp);
			inp.close();

		}
		catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wb;

	}

	public static void writeWorkbookToFile(Workbook wb, String filePath) {

		FileOutputStream fileOut = null;

		try {
			fileOut = new FileOutputStream(filePath);
			wb.write(fileOut);
			fileOut.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String[] readColumn(Workbook wb, String sheetName, int colIndex, int rowIndex, int size) {

		String[] s = new String[size];
		
		Sheet sh = wb.getSheet(sheetName);

		Cell[] cell = getColumnCells(sh, size, colIndex, rowIndex);

		for (int i = 0; i < size; i++) {

			s[i] = cell[i].getStringCellValue();

		}

		return s;

	}
	
	public static Workbook modifyWorkBook(Workbook wb, String sheetName, int colIndex, int rowIndex, double[] d) {

		Sheet sh = wb.getSheet(sheetName);

		Cell[] cell = getColumnCells(sh, d.length, colIndex, rowIndex);

		for (int i = 0; i < d.length; i++) {

			cell[i].setCellValue(d[i]);

		}

		return wb;

	}


	public static Cell[] getColumnCells(Sheet sh, int size, int colIndex, int rowIndex) {

		Cell[] c = new Cell[size];

		for (int i = 0; i < size; i++) {

			try {

				Row r = sh.getRow(i + rowIndex);
				c[i] = r.getCell(colIndex);

			}
			catch (Exception e) {

				Row r = sh.createRow(i + rowIndex);
				c[i] = r.createCell(colIndex);

			}
		}

		return c;

	}

}
