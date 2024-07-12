package HybridFrameworkTestNG.Testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePackage.BrowserSetup;
import ProjectUtilMethods.Utilities;

public class RegisterTest extends BrowserSetup {
	

	
	WebDriver driver;
	
	SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void LaunchBrowser() 
	{
	
		
		driver = initialisebrowser("chrome");
			
	}	
	
	@AfterMethod
	public void browsercleanup() {
		driver.quit();
	}
	

	@Test
	public void LaunchBrowser_Register() 
	{
	
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Hemang");
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajani");
		String registeredemail = Utilities.GenerateRandomEmail();
		System.out.println(registeredemail);
		driver.findElement(By.id("input-email")).sendKeys(registeredemail);
		
		driver.findElement(By.id("input-telephone")).sendKeys("9998887776");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String AccountCreatedVerification =driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText();
		Assert.assertEquals(AccountCreatedVerification, "Your Account Has Been Created!", "Account not Created");	
		}



		@Test	
		public void Register_AllFields() {
		
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Hemang");
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajani");
		String registeredemail = Utilities.GenerateRandomEmail();
		System.out.println(registeredemail);
		driver.findElement(By.id("input-email")).sendKeys(registeredemail);
		driver.findElement(By.id("input-telephone")).sendKeys("9998887776");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String AccountCreatedVerification =driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText();
		Assert.assertEquals(AccountCreatedVerification, "Your Account Has Been Created!", "Account not Created");				
		}
	

		@Test	
		public void InvalidRegister() {
		
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Hemang");
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajani");
		driver.findElement(By.id("input-email")).sendKeys("hemangmahajani10@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9998887776");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualwarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualwarning.contains("Warning: E-Mail Address is already registered!"),"Warning message is not displayed");
	
		}

	
		@Test	
		public void InvalidRegisterNil() {
		
		driver.findElement(By.className("caret")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String warning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(warning.contains("Warning: You must agree to the Privacy Policy!"),"Warning message is not displayed");
		}
}
