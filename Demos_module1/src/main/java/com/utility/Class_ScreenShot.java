package com.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Class_ScreenShot {

	public static void captureScreen(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("C:\\SeleniumWebDriver\\Screenshots\\" + getTimestamp() + "TestMeApp.jpg"));
				
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static String getTimestamp()
	{
		return new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date());
	}
}
