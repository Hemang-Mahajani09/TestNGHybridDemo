package BasePackage;

import org.openqa.selenium.By;
import org.testng.asserts.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multipleclass_DataProvider {

	@Test(dataProvider= "TestDataforlogin", dataProviderClass = dataproviderclass.class)

	public void readfromdataprovider(String email, String password) throws InterruptedException /* (String[] str) */
	{
		SoftAssert softassert = new SoftAssert();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/"); //str[0]
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys(email); //str[1]
		driver.findElement(By.id("input-password")).sendKeys(password); // str[0]
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(5000);
		//softassert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger alert-dismissible')]")).getText().contains("No match for E-Mail Address and/or Password."));
		System.out.println("https://tutorialsninja.com/demo/" + " "+ email + " "+ password);
		driver.quit();
	}
}
