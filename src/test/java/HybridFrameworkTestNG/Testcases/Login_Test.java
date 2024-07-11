package HybridFrameworkTestNG.Testcases;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.testng.asserts.*;

import BasePackage.BrowserSetup;


import org.testng.annotations.Test;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login_Test extends BrowserSetup {
	
	WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	Properties prop;
	public Login_Test() throws FileNotFoundException {
		super();
	}
	
	
	@BeforeMethod
	public void LaunchBrowser_Login() 
	{
	
		driver = initialisebrowser("chrome");
			
	}	
	
	@AfterMethod
	public void browsercleanup() {
		driver.quit();
	}

	@DataProvider(name= "SupplyTestData")
	public Object [][] SupplyTestData() throws IOException{
		Object[][] data = {{"hemangmahajani10@gmail.com","12345"},{"Hemang2642IS@gmail.com","12345"}};
		
		return data;
				
	}
	
	@Test(dataProvider = "SupplyTestData")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']"));
		
		softassert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		System.out.println("Login passed");	
	}


	@Test
	public void verifyLoginWithInvalidCredentialsEmail()
	{
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("hemangmahajani09@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		softassert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissibl')]")).getText().contains("No match for E-Mail Address and/or Password"));
		System.out.println("Login Failed_email incorrect");
	}
	

	@Test
	public void verifyLoginWithInvalidCredentialsPassword()
	{
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("Hemangmahajani10@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		softassert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissibl')]")).getText().contains("No match for E-Mail Address and/or Password"));
		System.out.println("Login Failed_Password incorrect");
	}
}
