package pages;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reportUtility.Report;

public class CompanyApps
{
	static WebDriver driver;
	Report report;
	@FindBy(xpath = "//button[normalize-space()='Company Apps']")
	public WebElement companyTab;
	
	@FindBy(xpath = "//div[@id='companyApps']/focusable-group/div/div")
	public WebElement clickdiv;
	
	@FindBy(xpath = "//div[@id='companyApps']/focusable-group/div/div/div/div/div/apps-and-tools-tab-item/div/a")
	List<WebElement> companyapps;
	
	
	/****************** CompanyApps Parameterized Constructor ***********************/
	public CompanyApps(WebDriver driver,Report report)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.report=report;
	}
	/****************** Click On Company Apps Tab***********************/
	public void clkOnCompanyApps()
	{
		companyTab.click();
	}
	
	/****************** Display the Company Apps ***********************/
	public void getCompanyApps()
	{
		clickdiv.click();
		for (int i=0;i<13;i++)
		{
			//scroll page down
			clickdiv.sendKeys(Keys.PAGE_DOWN);
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		//display apps
		System.out.println("--------------------- Company Apps are ---------------------");
		report.createTest("Company Apps are");
		 for (int j = 0; j < companyapps.size(); j++) {
			  try {
			System.out.println((j+1)+"."+companyapps.get(j).getAttribute("title"));
			report.logPass((j+1)+"."+companyapps.get(j).getAttribute("title"));
			  }catch(Exception e){
		            report.logFail("Login function is failed");
		        }
		}
		 int compapp = companyapps.size();
		 System.out.println("The total size of Companyapps is"+" "+compapp);
		 try {
			 report.logPass("The total size of Companyapps is"+" "+compapp);
		 }
		 catch(Exception e){
	            report.logFail("Login function is failed");
	        }
}
}

