package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.User;
import com.utility.Users;

import java.util.List;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LoginTestClass 
{
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
	public void readXMLAndPerformloginOperation() throws JAXBException,InterruptedException
	{
		readXML("src\\test\\resources\\loginCredentials.xml");
	}
	
	public void readXML(String filePath) throws JAXBException,InterruptedException
	{
		File file = new File(filePath);
		
		JAXBContext jaxbcontext = JAXBContext.newInstance(Users.class);
		
		Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
		
		Users u1 = (Users) unmarshaller.unmarshal(file);
		List<User> userList = u1.getUserList();
		
		for(User u: userList) {
			System.out.println(u.getEmail()+" "+u.getPassword());
			login(u.getEmail(),u.getPassword());
		}
	}
	public void login(String email,String pwd) throws InterruptedException
		{
			WebElement emailBox =driver.findElement(By.name("email"));
			WebElement pwdBox = driver.findElement(By.name("password"));
			WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
				
				emailBox.sendKeys(email);
				pwdBox.sendKeys(pwd);
				loginBtn.click();
				
				Thread.sleep(20000);
				
				String pageTitle = driver.getTitle();
				
				if(pageTitle.equals("Dashboard"))
				{
					
					driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/logout']")).click();
					Thread.sleep(6000);
				}
				else
				{
					emailBox.clear();
					pwdBox.clear();
					driver.navigate().refresh();
					
				}
				
			

		}
		
		
	}
	
	
	
