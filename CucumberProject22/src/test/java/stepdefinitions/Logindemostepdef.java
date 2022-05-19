package stepdefinitions;

import org.openqa.selenium.WebDriver;

import browserutility.BrowserConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginDemo;

public class Logindemostepdef 
{
	WebDriver driver;
	BrowserConfig br; 
	loginDemo ld;
	@Given("browser is open")
	public void browser_is_open() 
	{
		br = new BrowserConfig();
		driver = br.launchBrowser();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() 
	{
		br.browserUrl();
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials(DataTable dt)
	{
	    ld = new loginDemo(driver);
	    ld.enterName(dt.cell(1, 0));
	     
	    ld.enterPassword(dt.cell(1, 1));
	}

	@When("clicks on login button")
	public void clicks_on_login_button()
	{
	    ld.clickLogin();
	}

	@Then("user is navigated to TestProject Example page")
	public void user_is_navigated_to_test_project_example_page()
	{
	    ld.verifyPage();
	}
	@When("user fill TestProject Example page")
	public void user_fill_test_project_example_page(DataTable data) 
	{
		ld.enterCountry(data.cell(1, 0));
		ld.enterAddress(data.cell(1, 1));
		ld.enterEmail(data.cell(1, 2));
		ld.enterPhone(data.cell(1, 3));
		
	}
	@When("click save button")
	public void click_save_button()
	{
		ld.clickBtn();
	}
	@Then("user is able to fill TestProject Example page")
	public void user_is_able_to_fill_test_project_example_page() 
	{
		driver.close();
	}
}
