package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
public class ExtractDetails 
{
//Invoking WebDriverWait
WebDriverWait wait;
//Invoking static WebDriver
static WebDriver driver;
//Finding the element using "By" method
By Langclick = By.className("Select-placeholder");
By shwclick = By.xpath("//*[@id=\"react-select-2--option-9\"]/div/button[2]");
By Exactlang = By.xpath("//div[@class=\"filters-modal-content horizontal-box\"]");
By close = By.xpath("//a[contains(text(),'✕')]");
By lvlclick = By.xpath("//div[contains(text(),'Level')]");
By difflevel = By.className("Select-menu");
By wait1 = By.xpath("//h2[contains(text(),'Web Design for Everybody: Basics of Web Developmen')]");
//invoking constructor
public ExtractDetails(WebDriver driver)
{
	this.driver=driver;
}
//Method for getting Language count
public void LanguageCount()
{
driver.navigate().to("https://www.coursera.org/search?query=web%20development&index=prod_all_launched_products_term_optimization");
//click placeholder for getting Language
driver.findElement(Langclick).click();
//Exact Languages
driver.findElement(shwclick).click();
//creating list
List<WebElement> languages = driver.findElements(Exactlang);
for(int i =0;i<languages.size();i++) {
	//getting text of multiple languages
 String elementText = languages.get(i).getText();
//print multiple languages in console
 System.out.println("The total languages are "+elementText); 
		}
	//for closing extract language page
	driver.findElement(close).click();
	
}
//Method for getting Level count
public void LevelCount()
{
	wait = new WebDriverWait(driver,5);
	//wait until the given visibilityOfElementLocated page is located
wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));
//click placeholder for getting Levels
driver.findElement(lvlclick).click();
//creating list
List<WebElement> levels = driver.findElements(difflevel);
		
for(int i =0;i<levels.size();i++)
{
	//getting text of different levels
String elementText1 = levels.get(i).getText();
//printing different levels of course
System.out.println("The total different levels are "+elementText1); 
Reporter.log("The total different levels are "+elementText1);
		}	
	}

}
