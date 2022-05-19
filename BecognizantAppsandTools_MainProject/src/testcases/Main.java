package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserutility.BrowserConfig;
import pages.CompanyApps;
import pages.FetchingName;
import pages.Myapps;
import pages.Office365apps;
import pages.Sigin;
import pages.StockMarketprice;
import reportUtility.Report;

public class Main
{
	
	static WebDriver driver;
	Report report;
	@BeforeTest
	public void browserlaunch()
	{
		
		//Invoking BrowserConfig class
		BrowserConfig br = new BrowserConfig();
		driver = br.launchBrowser();
//      Initializing the Report object
      report=new Report();
//      Calling the initReport Method
      report.initReport();
		
	}
	
	@Test(priority=0)
	public void LogIn() throws InterruptedException
	{
		report.createTest("Getting the user name");
		Sigin sg = new Sigin(driver);
		sg.login();
		
	}
	
	@Test(priority=1)
	public void fetchUserName()
	{
		//Creating a Test case
      report.createTest("Fetching the UserName");
		FetchingName fn = new FetchingName(driver,report);
		fn.UserName();
		
	}
	@Test(priority=2)
	public void price() 
	{
		//Creating a Test case
	      report.createTest("Get Strock market price value");
		StockMarketprice st = new StockMarketprice(driver,report);
		st.becognizantFetch();
		st.google();
		st.googleFetch();
		
	}
	@Test(priority=3)
	public void Myapp()
	{
		//Creating a Test case
	      report.createTest("Get My Apps");
		Myapps mapp = new Myapps(driver,report);
		mapp.MyApplication();
		
	}
	@Test(priority=4)
	public void office() throws InterruptedException
	{
		//Creating a Test case
	      report.createTest("Get Office Apss");
		Office365apps off = new Office365apps(driver,report);
		off.officeapps();
		
	}
	
	@Test(priority=5)
	public void company() throws InterruptedException
	{
		//Creating a Test case
	      report.createTest("Get CompanyApps");
		CompanyApps cpp = new CompanyApps(driver,report);
		cpp.clkOnCompanyApps();
		cpp.getCompanyApps();
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		report.saveReport();
	}
	

}
