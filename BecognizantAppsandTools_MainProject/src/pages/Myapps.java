package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import reportUtility.Report;

public class Myapps 

{
	static WebDriver driver;
	Report report;
	@FindBy(xpath="//button[@data-original-title='Apps and Tools']")
	public WebElement appstools;
	
	@FindBy(xpath="//*[@id='header-menu-item-AppsAndTools']/apps-and-tools/div/div/div/div/tabset/div/div/button[1]")
	public WebElement myappsclick;
	
	@FindBy(xpath="//*[@id='mCSB_2_container']/div[1]")
	public WebElement myapps;
	
	/****************** Myapps Parameterized Constructor ***********************/
	public Myapps(WebDriver driver,Report report)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.report=report;
	}
	
	/****************** Display the MyApps ***********************/
	public void MyApplication()
	{
		try {
		driver.navigate().to("https://be.cognizant.com/");
		 WebDriverWait wait = new WebDriverWait(driver,20);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchbox\"]")));
	     appstools.click();
	     myappsclick.click();
	     System.out.println("--------------------- My Apps are ---------------------");
	     report.createTest("My Apps are");
	     System.out.println(myapps.getText());
	     report.logPass(myapps.getText());
		}catch (Exception e) {
            report.logFail("Login function is failed");

		}
	}
}
