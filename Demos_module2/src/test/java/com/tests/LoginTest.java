package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.ExcelUtility;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b7c.06.13\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/admin");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void loginOperation() throws InterruptedException
	{
		WebElement emailBox = null;
		WebElement pwdBox = null;
		WebElement loginBtn = null;
		
		String excelPath = "src\\test\\resources\\Credentials.xlsx";
		
		ExcelUtility exu = new ExcelUtility(excelPath);
		String sheetName = "Admin";
		
		int rowCount = exu.getNumberofRows(sheetName);
		int colCount = exu.getNumberOfCols(sheetName);
		
		String email = null;
		String pwd = null;
		
		for(int i=1; i<rowCount; i++)
		{
			email = exu.getCellData(sheetName, i, 0);
			pwd = exu.getCellData(sheetName,i, 1);
			
			emailBox =driver.findElement(By.name("email"));
			pwdBox = driver.findElement(By.name("password"));
			loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
			
			emailBox.sendKeys(email);
			pwdBox.sendKeys(pwd);
			loginBtn.click();
			
			Thread.sleep(20000);
			
			String pageTitle = driver.getTitle();
			
			if(pageTitle.equals("Dashboard"))
			{
				exu.setCellData(sheetName,i,2,"Login Successfull");
				driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/logout']")).click();
				Thread.sleep(6000);
			}
			else
			{
				exu.setCellData(sheetName, i, 2, "login Failed");
				emailBox.clear();
				pwdBox.clear();
				driver.navigate().refresh();
				
			}
			
		}
		
		String destinationPath="src\\test\\resources\\TestResults.xlsx";
		ExcelUtility.writeAndSaveExcel(destinationPath);
	}
	

}

