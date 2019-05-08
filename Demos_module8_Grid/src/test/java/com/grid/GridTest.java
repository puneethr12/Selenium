package com.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class GridTest {

	WebDriver driver;
	
	@Parameters({"node","browser"})
	@BeforeTest
	public void setUp(String node,String browser) throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(Platform.ANY);
		
		driver = new RemoteWebDriver(new URL(node),dc);
	}
	
	@Test
	public void openApplication() throws InterruptedException
	{
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		Thread.sleep(10000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
