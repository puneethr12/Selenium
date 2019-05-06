package com.selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass08 {
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b7c.06.13\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
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
		//Add a new cookie in current Domain
		Cookie name = new Cookie("mycookie","12aw34156fr");
		driver.manage().addCookie(name);
		
		// Display all the cookies in the current domain
		Set <Cookie> listofCookies= driver.manage().getCookies();
		
		for(Cookie c:listofCookies)
		{
			System.out.println(c);
		}
		
		// Display a specific cookie
		System.out.println(driver.manage().getCookieNamed("mycookie"));
		
		//Delete a specific cookie
		driver.manage().deleteCookieNamed("mycookie");
		
		System.out.println(driver.manage().getCookieNamed("mycookie"));
	}
}
