package com.advanced;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startReport()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+ "/target/surefire-reports/ExtentReprotResults.html",true);
		
		extent.addSystemInfo("Host Name", "Selenium Test")
		.addSystemInfo("Environment", "Automation Test")
		.addSystemInfo("User name", "Puneeth");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+ "\\extent-config.xml"));
	}
	
	@Test
	public void passTest()
	{
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test case passed:passTest");
	}
	
	@Test
	public void failTest()
	{
		logger= extent.startTest("failTest");
		
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b7c.06.13\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://newtours.demoaut.com");
				Assert.assertTrue(false);
	}
	
	@Test
	public void skipTest()
	{
		logger=extent.startTest("skipTest");
		throw new SkipException("This is not ready for testing");
	}
	
	@AfterMethod
	public void generateResults(ITestResult result) throws Exception
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test case failed is:" + result.getName());
			logger.log(LogStatus.FAIL, "Test case failed is:" + result.getThrowable());
			
			String screenshotPath = ExtentReport.getScreenshot(driver,result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test case Skipped is:" + result.getName());
			logger.log(LogStatus.SKIP, "Test case Skipped is:" + result.getThrowable());
		}
		extent.endTest(logger);
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
		driver.close();
		
	}
	
	//Method to capture screenshot
	public static String getScreenshot(WebDriver driver,String screenshotName) throws Exception
	{
		Date d = new Date();
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(d);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "FailedTestsScreenshots/" + screenshotName + dateName+".png";
				
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
				
				return destination;
				
	}
}
