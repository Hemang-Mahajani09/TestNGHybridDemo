package ProjectUtilMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String filepath = "./ProjectFiles//document 1.xlsx";
		File file = new File(filepath);
		FileInputStream excelfile = new FileInputStream(file);
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
	
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for (int i=0; i<rows; i++)
		{
			XSSFRow row= sheet.getRow(i+1); 
			for (int j=0; j<cols; j++)
			{
				XSSFCell cell= row.getCell(j);
				CellType celltype= cell.getCellType();
				
				
				switch(celltype) {
				case STRING:
					data[i][j]= cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]= Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]= cell.getBooleanCellValue();
					break;
				
			}
			}
		}
	}
}




