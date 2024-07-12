package HybridFrameworkTestNG.Testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BrowserSetup;

public class Search_Test extends BrowserSetup{

	WebDriver driver;

	
	@BeforeMethod
	public void launchbrowser() throws FileNotFoundException
	{
	driver = initialisebrowser("chrome");
	}

	@Test
	public void SearchHP()
	{
	driver.findElement(By.name("search")).sendKeys("HP");
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test
	public void SearchHONDA()
	{
	driver.findElement(By.name("search")).sendKeys("HONDA");
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	String actualmessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
	Assert.assertEquals(actualmessage,"There is no product that matches the search criteria.", "Matching criteria failed");
	}
	
	@Test
	public void SearchBlank()
	{
	driver.findElement(By.name("search")).sendKeys("");
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	String actualmessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
	Assert.assertEquals(actualmessage,"There is no product that matches the search criteria.", "Matching criteria failed");
	}
	
	@AfterMethod
	public void cleanup() {driver.quit();}
}