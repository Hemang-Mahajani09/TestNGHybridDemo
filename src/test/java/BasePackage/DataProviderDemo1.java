package BasePackage;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.*;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo1 {
	

	public class Login_TestNG {
		SoftAssert softassert = new SoftAssert();
		@Parameters({"url", "validemail", "validpassword"})
		@Test
		public void readvalidparameter( @Optional String URL ,String validemail, String validpassword )
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			
			
			driver.get(URL);
			driver.findElement(By.className("caret")).click();
			driver.findElement(By.linkText("Login")).click();
			
			driver.findElement(By.id("input-email")).sendKeys(validemail);
			driver.findElement(By.id("input-password")).sendKeys(validpassword);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']"));
			
			AssertJUnit.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			driver.quit();
			
		}
		@Parameters({"url", "invalidemail", "validpassword"})
		@Test
		public void readinvalidparameter(@Optional String URL, String invalidemail, String validpassword)
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get(URL);
			driver.findElement(By.className("caret")).click();
			driver.findElement(By.linkText("Login")).click();
			
			driver.findElement(By.id("input-email")).sendKeys(invalidemail);
			driver.findElement(By.id("input-password")).sendKeys(validpassword);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissibl')]")).getText().contains("No match for E-Mail Address and/or Password"));
			
			driver.quit();
		}
		
		
		@Test(dataProvider= "TestDataforlogin")

		public void readfromdataprovider( String URL, String email, String password) /* (String[] str) */
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get(URL); //str[0]
			driver.findElement(By.className("caret")).click();
			driver.findElement(By.linkText("Login")).click();
			
			driver.findElement(By.id("input-email")).sendKeys(email); //str[1]
			driver.findElement(By.id("input-password")).sendKeys(password); // str[0]
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissibl')]")).getText().contains("No match for E-Mail Address and/or Password"));
			System.out.println(URL + " "+ email + " "+ password);
			driver.quit();
		}
		
		
		@DataProvider(name = "TestDataforlogin")
	public String[][] datasupplier() {
			String [][] data= {{"https://tutorialsninja.com/demo/", "hemangmahajani10@gmail.com", "123457"},
					{"https://tutorialsninja.com/demo/", "hemangmahajani10@gmail.com", "123456"}	,
					{"https://tutorialsninja.com/demo/", "hemangmahajani09@gmail.com", "12345",}};
		
			return data;
		}
		
	}


}
