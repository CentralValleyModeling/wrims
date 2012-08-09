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



		
		//DV file
		String[] dvPartB = readColumn(wb, readSheetName, 3, 18);
		String[] dvPartC = readColumn(wb, readSheetName, 4, 18);

		//SV file
		int svSize =3;
		int svRow = 6;
		String[] svPartB = readColumn(wb, readSheetName, 3, svRow, svSize);
		String[] svPartC = readColumn(wb, readSheetName, 4, svRow, svSize);
		
		System.out.println("SV");
		for (int i=0; i<svPartB.length; i++){
			System.out.println(svPartB[i]+":"+svPartC[i]);
		}
		System.out.println("DV");
		for (int i=0; i<dvPartB.length; i++){
			System.out.println(dvPartB[i]+":"+dvPartC[i]);
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

	public static String[] readColumn(Workbook wb, String sheetName, int colIndex, int rowIndex) {
		
		Sheet sh = wb.getSheet(sheetName);

		ArrayList<Cell> ca = getColumnCells(sh, colIndex, rowIndex);

		String[] s = new String[ca.size()];
		
		for (int i = 0; i < ca.size(); i++) {

			s[i] = ca.get(i).getStringCellValue();

		}

		return s;

	}
	
	public static String[] readColumn(Workbook wb, String sheetName, int colIndex, int rowIndex, int size) {

		String[] s = new String[size];
		
		Sheet sh = wb.getSheet(sheetName);

		Cell[] cell = getColumnCells(sh, colIndex, rowIndex, size);

		for (int i = 0; i < size; i++) {

			s[i] = cell[i].getStringCellValue();

		}

		return s;

	}
	
	public static Workbook modifyWorkBook(Workbook wb, String sheetName, int colIndex, int rowIndex, double[] d) {

		Sheet sh = wb.getSheet(sheetName);

		Cell[] cell = getColumnCells(sh, colIndex, rowIndex, d.length);

		for (int i = 0; i < d.length; i++) {

			cell[i].setCellValue(d[i]);

		}

		return wb;

	}

	public static ArrayList<Cell> getColumnCells(Sheet sh, int colIndex, int rowIndex) {

		Cell c;
		ArrayList<Cell> ca = new ArrayList<Cell>();
		int i=0;

		boolean notEmpty = true;
		
		while ( notEmpty) {
			
			try {

				Row r = sh.getRow(i + rowIndex);
				c = r.getCell(colIndex);
				
				if(c.getCellType() != Cell.CELL_TYPE_BLANK){
					ca.add(c);
				} else {
					notEmpty = false;
				}

			}
			catch (Exception e) {

				notEmpty = false;

			}
			i++;
		}

		return ca;

	}
	
	public static Cell[] getColumnCells(Sheet sh, int colIndex, int rowIndex, int size) {

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
