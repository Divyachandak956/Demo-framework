package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {

	@SuppressWarnings("resource")
	public String[][] excelRead(String filepath, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		String arrayExcelData[][] = null;
		FileInputStream fs = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
//		int sheets = workbook.getNumberOfSheets();
//		 System.out.println(sheets);
		XSSFSheet sh = workbook.getSheet(sheetName);
		int row = sh.getPhysicalNumberOfRows();
		int col = sh.getRow(0).getLastCellNum();
		System.out.println("No of Rows " + row);
		System.out.println("No Of Columns" + col);
		arrayExcelData = new String[row - 1][col];
		
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arrayExcelData[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue();
			
			}
			
		}
		
		System.out.println(Arrays.deepToString(arrayExcelData));
		System.out.println(arrayExcelData);
		return arrayExcelData;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DataDriven ext = new DataDriven();
		ext.excelRead("C:\\Users\\OM\\workspace\\anyonehomeDemo\\src\\main\\java\\TestData\\file.xlsx", "Sheet1");
	}
}
