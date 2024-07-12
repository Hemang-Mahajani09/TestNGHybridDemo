package BasePackage;
import java.io.*;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ReadDataFromExcel {
	
	@Test
	public void  Exceldata() throws IOException {
		System.out.println("line16");
		String excelfilepath = "./ProjectFiles/TestData.xlsx";
		
		System.out.println(Objects.isNull(excelfilepath));
		File excelfile = new File(excelfilepath);
		System.out.println("line21");
		FileInputStream fis = new FileInputStream(excelfile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//workbook.getSheetAt(0);
	
		
		int sheetinarrayterms = sheet.getLastRowNum();
		System.out.println(sheetinarrayterms);
		
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		
		
	    int cols = sheet.getRow(0).getLastCellNum();
		
		
		for (int i=0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j=0; j<cols; j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
					
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				}
			}
		}
		workbook.close();
	}

}
