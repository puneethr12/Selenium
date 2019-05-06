package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass02 {
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b7c.06.13\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();		
	
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		Actions act = new Actions(driver);
		
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		Thread.sleep(5000);
		
		WebElement userNameTxtBox = driver.findElement(By.id("userName"));
		act.moveToElement(userNameTxtBox)
		.click()
		.keyDown(userNameTxtBox,Keys.SHIFT)
		.sendKeys(userNameTxtBox,"Admin")
		.keyUp(userNameTxtBox,Keys.SHIFT)
		.doubleClick()
		.contextClick()
		.build().perform();
		
		Thread.sleep(5000);
		
		
	}
}
