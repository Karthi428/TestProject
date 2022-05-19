package stepdefinitions;

import org.openqa.selenium.WebDriver;

import browserutility.BrowserConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonSearch;

public class AmazonStepdefination
{
	WebDriver driver=null;
	BrowserConfig br; 
	AmazonSearch am;
	@Given("Browser is opened")
	public void browser_is_opened() {
		br = new BrowserConfig();
		driver = br.launchBrowser();

	}

	@And("navigate amazon webpage")
	public void navigate_amazon_webpage() {

		br.browserUrl();

	}

	@When("entering waterbottle")
	public void entering_waterbottle() {
		am = new AmazonSearch(driver);
		am.Searchtext();

	}

	@And("click search button")
	public void click_search_button() throws InterruptedException {
		am = new AmazonSearch(driver);
		am.Clickbutton();
		am.Verifydisplay();
		Thread.sleep(4000);

	}

	@Then("List of waterbottle is displayed")
	public void list_of_waterbottle_is_displayed() {
		driver.quit();
	}
}
