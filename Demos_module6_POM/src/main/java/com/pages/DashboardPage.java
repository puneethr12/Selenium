package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id='logout']/a")
	private WebElement logOutLink;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void logOutAsAdmin()
	{
		logOutLink.click();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}
