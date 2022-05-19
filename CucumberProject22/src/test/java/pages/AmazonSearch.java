package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import excelutils.ReadExceldata;


public class AmazonSearch 
{
	WebDriver driver;
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchtext;

	@FindBy(id = "nav-search-submit-button")
	WebElement clksearchbtn;

	@FindBy(xpath = "//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
	List<WebElement> waterbottles;
	
	@FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
	WebElement waituntil;
	ReadExceldata rd = new ReadExceldata(driver);

	public AmazonSearch(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void Searchtext()
	{
		searchtext.sendKeys(rd.getdata(0, 0, 0));
	}
	public void Clickbutton()
	{
		clksearchbtn.click();
	}
	public void Verifydisplay()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));
		wait.until(ExpectedConditions.visibilityOf(waituntil));
		System.out.println("**********The List of Water bottles**********");
		for(int i=0;i<waterbottles.size();i++)
		{
		String waterbottle = waterbottles.get(i).getText();
		System.out.println((i+1)+".)"+waterbottle);
		}
	}
}
