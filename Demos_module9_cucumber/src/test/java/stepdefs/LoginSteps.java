package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginSteps {
	WebDriver driver;


public LoginSteps()  {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b7c.06.13\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
}
	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		Thread.sleep(5000);
	    throw new PendingException();

	}

	@When("^Admin enters valid email$")
	public void admin_enters_valid_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("userName")).sendKeys("admin");
		Thread.sleep(5000);
		System.out.println("Done");
	}

	@When("^Admin enters valid password$")
	public void admin_enters_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys("Password456");
		Thread.sleep(5000);
		driver.findElement(By.name("Login")).click();
		Thread.sleep(5000);
	}

	@Then("^Login is Successful$")
	public void login_is_Successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement loggedInUser = driver.findElement(By.id("username"));
		Assert.assertEquals(loggedInUser.getText(),"Admin");
	}
}

