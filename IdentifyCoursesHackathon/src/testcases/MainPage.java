package testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserutility.BrowserConfig;
import pages.CourseDetails;
import pages.ExtractDetails;
import pages.FormFilling;

public class MainPage 

{
	static WebDriver driver;
	
	@BeforeTest
	public void browserlaunch()
	{
		//Invoking BrowserConfig class
		BrowserConfig br = new BrowserConfig();
		driver = br.launchBrowser();
	}
	@Test(priority=0)
	public void GetcourseDetails() throws InterruptedException
	{
		//Invoking CourseDetails class
		CourseDetails sc1 = new CourseDetails(driver);
		sc1.SearchingCourse();
		sc1.courseDetails();
	}
	@Test(priority=1)
	public void Extract()
	{
		//Invoking ExtractDetails class
		ExtractDetails sc2 = new ExtractDetails(driver);
		sc2.LanguageCount();
		sc2.LevelCount();
	}
	@Test(priority=2)
	public void formFilling() throws InterruptedException
	{
		//Invoking FormFilling class
		FormFilling sc3 = new FormFilling(driver);
		sc3.homePage();
	}
	@AfterTest
	public void closingbrowser()
	{
		
		driver.quit();
	}

	
}
