package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass10 {
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
		driver.findElement(By.id("uploadfile_0")).click();
		
		uploadFiles("C:\\SeleniumWebDriver\\Screenshots\\2019-46-06 12-46-25TestMeApp.jpg");
		Thread.sleep(5000);
	}
	
	//Function to upload files by Robot class
	public void uploadFiles(String filePath) {
		
		StringSelection stringselection = new StringSelection(filePath);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		Clipboard.setContents(StringSelection,null);
		
		Robot robot = null;
		
		try {
			robot = new Robot();
		
		}
	      catch (AWTException e) {
	    	  e.printStackTrace();
	    	  
	      }
		
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(150);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
}
