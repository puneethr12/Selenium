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

import com.utility.Class_ScreenShot;

public class TestClass06 {
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
		try {
		
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("Username")).sendKeys("Admin");
		Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Password856");
		Thread.sleep(5000);
		driver.findElement(By.name("Login")).click();
		Thread.sleep(5000);
		}
		catch(Exception e) {
			System.out.println("Exception happened: " + e.getMessage());
			Class_ScreenShot.captureScreen(driver);
		}
		
	}
}
