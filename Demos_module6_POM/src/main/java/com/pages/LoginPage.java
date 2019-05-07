package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage> {
	
	WebDriver driver;

	@FindBy(name="email")
	private WebElement emailTxtBox;
	
	@FindBy(name="password")
	private WebElement passwordTxtBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger loading wow fadeIn animated animated']")
	private WebElement errorElement;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void loginAsAdmin(String email, String password)
	{
		emailTxtBox.clear();
		passwordTxtBox.clear();
		emailTxtBox.sendKeys(email);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
	}
	
	public String getErrorMessage()
	{
		return errorElement.getText();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
		
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		System.out.println("In isLoaded method");
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.startsWith("https://www.phptravels.net"),"not on the correct page"+url);
				
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		System.out.println("In load method");
		driver.get("https://www.phptravels.net/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
	}
	

}
