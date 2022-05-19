package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class loginDemo
{
	WebDriver driver;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="password")
	WebElement pswrd;
	
	@FindBy(id="login")
	WebElement logbtn;
	
	@FindBy(xpath="//div[@id='pageProfile']//h1[contains(text(),'TestProject Example page')]")
	WebElement actual;
	
	@FindBy(id = "country")
	WebElement cnty;
	
	@FindBy(id = "address")
	WebElement adrs;
	
	@FindBy(id = "email")
	WebElement gmail;
	
	@FindBy(id = "phone")
	WebElement mob;
	
	@FindBy(xpath="//button[@id='save']")
	WebElement btn;

	
	public loginDemo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterName(String username)
	{
		name.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		pswrd.sendKeys(password);
	}
	public void clickLogin()
	{
		logbtn.click();
	}
	public void verifyPage()
	{
		String Actualtitle = actual.getText();
		String Expected = "TestProject Example page";
		assertEquals(Actualtitle, Expected);
		System.out.println(Actualtitle);
		
	}
	public void enterCountry(String Country)
	{
		Select dropcontry = new Select(cnty);
		dropcontry.selectByVisibleText(Country);
		
	}
	public void enterAddress(String Address)
	{
		adrs.sendKeys(Address);
	}
	public void enterEmail(String email)
	{
		gmail.sendKeys(email);
	}
	public void enterPhone(String phone)
	{
		mob.sendKeys(phone);
	}
	public void clickBtn()
	{
		btn.click();
	}
	

}
