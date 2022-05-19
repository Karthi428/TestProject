package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import excelutils.ReadExceldata;
import reportUtility.Report;

public class Office365apps 

{
	static WebDriver driver;
	Report report;
	ReadExceldata rd = new ReadExceldata(driver);
	
	/****************** Office365apps Parameterized Constructor ***********************/
	public Office365apps(WebDriver driver,Report report)
	{
		this.driver=driver;
		this.report=report;

	}
	
	
	/****************** Display the Office 365 Apps ***********************/
	public void officeapps() throws InterruptedException
	{
			String variable = rd.getdata(0, 0, 0);
			driver.findElement(By.xpath("//button[normalize-space()='"+variable+"']")).click();
			List<WebElement> offapp = driver.findElements(By.xpath("//span[@class='apps-and-tools__card__title line-clamp--2 ng-binding']"));
			System.out.println("--------------------- Office 365 Apps are ---------------------");
			report.createTest("Office 365 Apps are");
			for(int i =0;i<offapp.size();i++)
			{
				try {
			String elementText = offapp.get(i).getText();
			System.out.println((i+1)+"."+elementText);
			report.logPass((i+1)+"."+elementText);
				} catch(Exception e){
		            report.logFail("Login function is failed");
		        }
			
			
	}
			int officeapps=offapp.size();
			System.out.println("The total office 365 apps is"+" "+officeapps);
			try {
				report.logPass("The total office 365 apps is"+" "+officeapps);
			} catch (Exception e) {
				report.logFail("Login function is failed");

			}
}
}
