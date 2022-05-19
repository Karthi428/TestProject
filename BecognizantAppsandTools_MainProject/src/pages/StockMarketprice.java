package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reportUtility.Report;

public class StockMarketprice
{
static WebDriver driver;
Report report;
@FindBy(xpath="//div[@class='stock-ticker-header__name']/span")
public WebElement becognizantSName;

@FindBy(xpath="//div[@class='stock-ticker-header__price']/span")
public WebElement becognizantSPrice;

@FindBy(xpath="//div[@class='stock-ticker-header__change']/span")
public WebElement becognizantSPercentage;

@FindBy(xpath="//div[@class='stock-ticker-header__stockExchange']/span")
public WebElement becognizantSExchange;

@FindBy(xpath="//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div/div[2]/div/div/span[2]/a")
public WebElement googleSName;

@FindBy(xpath="//span[@class='r3IKmc']")
public WebElement googleSExchange;

@FindBy(xpath="//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div/div[2]/div/div/span[2]/span[3]")
public WebElement googleSPrice;

@FindBy(xpath="//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div/div[2]/div/div/span[2]/span[5]")
public WebElement googleSPercentage;

/****************** StockMarketprice Parameterized Constructor ***********************/
public StockMarketprice(WebDriver driver,Report report)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	this.report=report;
}
/****************** Fetching Cognizant stock price from Becognizant  ***********************/
public void becognizantFetch()
{
	try {
	ScreenShot sc = new ScreenShot(driver);
	sc.takeScreenShot();
	String stockname = becognizantSName.getText();
	String stockprice =becognizantSPrice.getText();
	String stockPer = becognizantSPercentage.getText();
	String stockExchange = becognizantSExchange.getText();
	String beCognizantStockPrice = stockname + "(" + stockExchange + ")$" + stockprice + "(" + stockPer + ")";
	
	System.out.println("The Stock Price in Becognizant - "+beCognizantStockPrice);
	report.logPass("The Stock Price in Becognizant - "+beCognizantStockPrice);
	}catch (Exception e) {
        report.logFail("Login function is failed");

	}
	
}

/****************** Enter cognizant in google ***********************/
public void google()
{
	driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
    driver.get("https://www.google.com/");
      // identify element
      WebElement p=driver.findElement(By.name("q"));
      //enter text with sendKeys() then apply submit()
      p.sendKeys("Cognizant");
      // Explicit wait condition for search results
      WebDriverWait w = new WebDriverWait(driver, 5);
      w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
      p.submit();
}

/****************** Fetching Cognizant stock price from Google  ***********************/
public void googleFetch()
{
	try {
	String stockname = googleSName.getText();
	String stockExchange = googleSExchange.getText();
	String stockprice = googleSPrice.getText();
	String stockPer = googleSPercentage.getText();
	
	int startIndex = stockPer.indexOf("(");
	int endIndex = stockPer.indexOf(")");
	String toBeReplaced = stockPer.substring(startIndex, endIndex);
	String googleStockPrice = stockname + stockExchange + stockprice + toBeReplaced + ")";
	System.out.println("The Stock Price in Google - "+googleStockPrice);
	report.logPass("The Stock Price in Google - "+googleStockPrice);
	}catch(Exception e){
        report.logFail("Login function is failed");
    }
}
}

