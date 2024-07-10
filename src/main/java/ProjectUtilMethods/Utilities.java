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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utilities {
	
	
	WebDriver driver;

public static String GenerateRandomEmail() {
		
		Date date= new Date();
		String timestamp = date.toString().replace(" ","").replace(":","").substring(10, 16);
		return "Hemang" + timestamp+ "@gmail.com";
	}

public void BrowserSetup() {
	String browsername = "chrome";
	
	if (browsername.equals("chrome")) 
	{driver = new ChromeDriver();}
	else if (browsername.equals("firefox")) 
	{driver = new FirefoxDriver();}
	else if (browsername.equals("edge"))
	{driver = new EdgeDriver();}
	
}

public static Object[][] gettestdata(String sheetname) throws FileNotFoundException {
	
	File file = new File(System.getProperty("(user.dir)"+ "ProjectFiles/document.xlsx"));
	FileInputStream excelfile = new FileInputStream(file);
	
	
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.getSheet(sheetname);
	
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
	return data;
	
}
}


