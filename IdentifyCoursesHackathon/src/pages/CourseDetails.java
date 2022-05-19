package pages;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import objectutility.PropertyReaders;
public class CourseDetails
{
//Invoking WebDriverWait
WebDriverWait wait;
//Invoking static WebDriver
static WebDriver driver;
//Invoking PropertyReaders class
static PropertyReaders ppr1 = new PropertyReaders();
static String skey = ppr1.getcoursename();
//Finding the element using "By" method
By course = By.xpath("//input[@class=\"react-autosuggest__input\"]");
By search = By.xpath("//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
By clk = By.className("Select-placeholder");
By english = By.className("_htmk7zm");
By clk2 = By.xpath("//div[text()=\"Level\"]");
By beginner = By.xpath("//input[@value=\"Beginner\"]");
By wait1 = By.xpath("//h2[normalize-space()='Introduction to Web Development']");
By course1 = By.xpath("//span[text()='Course']");
By wait2 = By.cssSelector("h1.banner-title.banner-title-without--subtitle.m-b-0");
By coursetitle = By.cssSelector("h1.banner-title.banner-title-without--subtitle.m-b-0");
By courserate = By.cssSelector("span._16ni8zai.m-b-0.rating-text.number-rating.number-rating-expertise");
By coursedur = By.cssSelector("div.rc-MetatagsWrapper div.XdpApp div._1jug6qr.CDPPage div.rc-XdpSection.cdp-about:nth-child(2) div._1d3lkver.p-b-2 div.AboutCourse div._jyhj5r.text-xs-left div._xliqh9g div._cs3pjta._1pfe6xlx.p-l-2.p-r-0 div.ProductGlance div._y1d9czk.m-b-2.p-t-1s:nth-child(5) div._1tu07i3a div._16ni8zai.m-b-0.m-t-1s > span:nth-child(1)");
//Invoking constructor
public CourseDetails(WebDriver driver)
{
this.driver=driver;
}
public void SearchingCourse() throws InterruptedException
{
//search web development course
driver.findElement(course).sendKeys(skey);
//Click search button
driver.findElement(search).click();
//click placeholder for getting Language
driver.findElement(clk).click();
//click "English" language from check box
driver.findElement(english).click();
//click placeholder for getting level
driver.findElement(clk2).click();
//click "Beginner" level from check box
driver.findElement(beginner).click();

}
//Method for getting CourseDetails
public void courseDetails() throws InterruptedException
{

wait = new WebDriverWait(driver,10);
//wait until the given visibilityOfElementLocated page is located
wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));
//creating list
List<WebElement> course = driver.findElements(course1);
String parentpage = driver.getWindowHandle();
System.out.println("\n********course details*********");
for(int i=0; i<2; i++)
{
course.get(i).click();
//creating list
Set<String> handle = driver.getWindowHandles();
for(String child : handle)
{
if(!(child.equals(parentpage)))
{
//switch to child page
driver.switchTo().window(child);
WebDriverWait wait = new WebDriverWait(driver,10);
//wait until the given visibilityOfElementLocated page is located
wait.until(ExpectedConditions.visibilityOfElementLocated(wait2));
//get text of course title
String Course = driver.findElement(coursetitle).getText();
//get text rate of courses
String rate = driver.findElement(courserate).getText();
//get text duration of courses
String duration = driver.findElement(coursedur).getText();
//getting course details and rate and duration in console
System.out.println((i+1)+" " + Course +" - " + rate + " - " +duration);
Reporter.log((i+1)+" " + Course +" - " + rate + " - " +duration);
//close child page
driver.close();
//Switch to parentpage
driver.switchTo().window(parentpage);
}
}
}
}
}