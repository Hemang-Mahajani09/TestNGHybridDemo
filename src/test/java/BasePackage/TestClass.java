package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestClass {
	static WebDriver driver;


			

	public static Properties loadproperties() throws FileNotFoundException {
Properties prop = new Properties();
		
		FileInputStream	fis = new FileInputStream("./ProjectFiles//config.properties");
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("url"));
		
		String browsername = "chrome";
		if (browsername .equals("chrome")) 
		{ driver = new ChromeDriver();}
		else if (browsername.equals("firefox")) 
		{driver = new FirefoxDriver();}
		else if (browsername.equals("edge"))
		{driver = new EdgeDriver();}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("webdriver element invoked");
		driver.get(prop.getProperty("url"));
		return prop;
	}
	
	
	
		// TODO Auto-generated method stub
		
	}

