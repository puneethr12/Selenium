package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass09 {
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
		driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//Fetch domain name
		String domainName=(String) js.executeScript("return document.domain");
		System.out.println("Domain name:" + domainName);
		
		//Fetch Title name
		String pageTitle=(String) js.executeScript("return document.title");
		System.out.println("Page Title:" + pageTitle);
		
		//Generate alert Toolbox
        //js.executeScript("alert('Hello');");
        //Thread.sleep(5000);
        
        //Scrolling down to bottom
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);
        
        WebElement registerBtn = driver.findElement(By.name("Submit"));
        //Highlighter
        js.executeScript("arguments[0].style.border='7px dotted red'", registerBtn);
        Thread.sleep(5000);
        
	}
}
