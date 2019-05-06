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

public class TestClass04 {
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
		
	
		
		WebElement userNameTxtBox = driver.findElement(By.id("SignIn"));
		 act.moveToElement(userNameTxtBox)
		.keyDown(userNameTxtBox,Keys.SHIFT)
		.click()
		.keyUp(userNameTxtBox,Keys.SHIFT)
		.build().perform();
		
		Thread.sleep(5000);
		
		
	}

	private WebElement keyDown(WebElement userNameTxtBox, Keys shift) {
		// TODO Auto-generated method stub
		return null;
	}
}
