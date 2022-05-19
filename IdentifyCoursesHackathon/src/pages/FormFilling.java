package pages;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import excelutils.ReadExceldata;

public class FormFilling
{
//Invoking WebDriverWait
WebDriverWait wait;
//Invoking static WebDriver
static WebDriver driver;
//Finding the element using "By" method
By hpage = By.xpath("//a[@aria-label='Coursera']//div");
By forEnterprice = By.xpath("//a[@id='enterprise-link']");
By product = By.xpath("//a[@href='https://www.coursera.org/business/products']");
By campus = By.xpath("//a[@target='_blank'][normalize-space()='For Campus']");
By fname = By.id("FirstName");
By lname = By.id("LastName");
By jobfuc = By.xpath("//select[@id='C4C_Job_Title__c']");
By jobtitle = By.xpath("//input[@id='Title']");
By email = By.id("Email");
By phone = By.id("Phone");
By institution = By.id("Company");
By instype = By.xpath("//select[@id='Institution_Type__c']");
By discipline = By.xpath("//select[@id='Primary_Discipline__c']");
By country = By.id("Country");
By state = By.id("State");
By submit = By.className("mktoButton");
By warnmsg = By.xpath("//div[@id='ValidMsgEmail']");
By wait1 = By.xpath("//h1[contains(text(),'Prepare students with')]");
//Invoking ReadExceldata class
ReadExceldata rd = new ReadExceldata(driver);	
//Invoking constructor
public FormFilling(WebDriver driver)
{
	this.driver=driver;
}
//Method for form filling details
public void homePage() throws InterruptedException
{
	//click homepage
driver.findElement(hpage).click();
//click For Enterprice 
driver.findElement(forEnterprice).click();
//navigate to Products
 WebElement element = driver.findElement(product);
 //object of Actions class
 Actions a = new Actions(driver);
 //move to element
 a.moveToElement(element);
 a.perform();
 //click For Campus from Product
driver.findElement(campus).click();
Thread.sleep(3000);
String parentpage = driver.getWindowHandle();
Set<String> handle = driver.getWindowHandles();
for(String child : handle)
{
if(!(child.equals(parentpage)))
{
driver.switchTo().window(child);
WebDriverWait wait = new WebDriverWait(driver,5);
//wait until visibilityOfElementLocated page is located
wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));
//Sending First Name values throw sendKeys
driver.findElement(fname).sendKeys(rd.getdata(0, 1, 0));
//Sending Last Name values throw sendKeys
driver.findElement(lname).sendKeys(rd.getdata(0, 1, 1));
//Selecting Job Function from dropdown
Select sc = new Select(driver.findElement(jobfuc));
sc.selectByVisibleText(rd.getdata(0, 1, 2));
//Sending Job Title values throw sendKeys
driver.findElement(jobtitle).sendKeys(rd.getdata(0, 1, 3));
//Sending Work Email Address values throw sendKeys
driver.findElement(email).sendKeys(rd.getdata(0, 1, 4));
//Sending Phone Number values throw sendKeys
driver.findElement(phone).sendKeys(rd.getdata(0, 1, 5));
Thread.sleep(3000);
//Sending Institution Name values throw sendKeys
driver.findElement(institution).sendKeys(rd.getdata(0, 1, 6));
Thread.sleep(3000);
//Selecting Institution Type from dorpdown
Select sc2 = new Select(driver.findElement(instype));
sc2.selectByVisibleText(rd.getdata(0, 1, 7));
Thread.sleep(3000);
//Selecting Primary Discipline from dropdown
Select sc3 = new Select(driver.findElement(discipline));
sc3.selectByVisibleText(rd.getdata(0, 1, 8));
Thread.sleep(3000);
//Selecting country from dropdown
Select sc4 = new Select(driver.findElement(country));
sc4.selectByVisibleText(rd.getdata(0, 1, 9));
Thread.sleep(3000);
//selecting state from dropdown
Select sc5 = new Select(driver.findElement(state));
sc5.selectByVisibleText(rd.getdata(0, 1, 10));
Thread.sleep(3000);
//clicking submit button
driver.findElement(submit).click();
Thread.sleep(3000);
//getting error warning message
WebElement warn = driver.findElement(warnmsg);
//printing warning error message in console
System.out.println("The Warning message is "+warn.getText());
Reporter.log("The Warning message is "+warn.getText());
//calling screenshot class
ScreenShot scr = new ScreenShot(driver);
//calling screenshot class method
ScreenShot.takeScreenShot();
//closing child page
driver.close();
//Switch to parentpage
driver.switchTo().window(parentpage);
}
}
}
	
}
