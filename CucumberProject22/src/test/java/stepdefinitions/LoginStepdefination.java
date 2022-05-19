//package stepdefinitions;
//
//import org.openqa.selenium.WebDriver;
//
//import browserutility.BrowserConfig;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pages.loginDemo;
//
//public class LoginStepdefination 
//{
//	WebDriver driver;
//	BrowserConfig br; 
//	loginDemo ld;
//	@Given("browser is open")
//	public void browser_is_open() 
//	{
//		br = new BrowserConfig();
//		driver = br.launchBrowser();
//	}
//
//	@Given("user is on login page")
//	public void user_is_on_login_page() 
//	{
//		br.browserUrl();
//	}
//
//	@When("user enters {string} and {string}")
//	public void user_enters_username_and_password(String username, String password)
//	{
//	    ld = new loginDemo(driver);
//	    ld.enterName(username);
//	     
//	    ld.enterPassword(password);
//	}
//
//	@When("clicks on login button")
//	public void clicks_on_login_button()
//	{
//	    ld.clickLogin();
//	}
//
//	@Then("user is navigated to the home page")
//	public void user_is_navigated_to_the_home_page() {
//	    driver.quit();
//	}
//
//}
