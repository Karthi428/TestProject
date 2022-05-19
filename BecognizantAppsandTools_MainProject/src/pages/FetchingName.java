package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import reportUtility.Report;

public class FetchingName 
{
	static WebDriver driver;
	Report report;
	
	@FindBy(xpath="//*[@id='user-name']")
	public WebElement userName;
	
	
	/****************** FetchingName Parameterized Constructor ***********************/
	public FetchingName(WebDriver driver,Report report)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.report=report;
	}
	
	/****************** Fetching User name from Becognizant  ***********************/
	public void UserName()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-name']")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String LoginUsername = (userName.getText().replace("(Cognizant)", "")).replace(",", "").trim();
		System.out.println(LoginUsername);
		report.logPass(LoginUsername);
		
	}
}
