package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivers.DriverUtility;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class PHPTravelsTest {

	WebDriver driver;
	LoginPage lp;
	DashboardPage dp;
	
	@BeforeTest
	public void setUp()
	{
		String path = "C:\\Users\\training_b7c.06.13\\Downloads\\chromedriver_win32\\chromedriver.exe";
		driver=DriverUtility.initializeDriver("Chrome", path);
		
		lp=PageFactory.initElements(driver, LoginPage.class);
		dp=PageFactory.initElements(driver, DashboardPage.class);
	}
	
	@AfterTest
	public void tearDown()
	{
		lp=null;
		dp=null;
		driver.quit();
	}
	
	@Test(priority=0)
	public void validAdminTest() throws InterruptedException
	{
	lp.get();
	lp.loginAsAdmin("admin@phptravels.com", "demoadmin");
	Thread.sleep(20000);
	Assert.assertEquals(dp.getPageTitle(), "Dashboard");
	dp.logOutAsAdmin();
	Thread.sleep(20000);
	Assert.assertEquals(lp.getPageTitle(),"Administrator login");
	}
	
	@Test(priority=1)
	public void invalidAdminErrorMessageTest() throws InterruptedException
	{
	Thread.sleep(6000);
	lp.loginAsAdmin("admin@phptravels.com", "demadmin");
	Thread.sleep(6000);
	Assert.assertEquals(lp.getErrorMessage(), "Invalid Login");
	}
	
	@Test(priority=2)
	public void invalidEmailErrorMessageTest() throws InterruptedException
	{
	Thread.sleep(6000);
	lp.loginAsAdmin("adm@phptravels.com", "demoadmin");
	Thread.sleep(6000);
	Assert.assertEquals(lp.getErrorMessage(), "The Email field must contain a valid Email address");
	}
}
