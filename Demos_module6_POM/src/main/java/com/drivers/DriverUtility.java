package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtility 
{

	static WebDriver driver;
	
	public static WebDriver initializeDriver(String browserName, String driverPath)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",driverPath);
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",driverPath);
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Browser not supported yet");
		}
	
	return driver;
    }
}
