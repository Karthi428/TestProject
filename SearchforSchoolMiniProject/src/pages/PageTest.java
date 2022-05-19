package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageTest {
	
	//Declaring WebDriver driver as a global variable
	static WebDriver driver;
	//constructor class
	public PageTest(WebDriver driver)
	{
		this.driver= driver;
		
	}
	//Test for Search school
	public void SearchSchools() throws InterruptedException
	{
		//Click on "Schools" link in the Menu bar
				WebElement schools = driver.findElement(By.xpath("//a[text()='Schools']"));
				schools.click();
				
				//Thread sleep for 4sec.
				Thread.sleep(4000);
				
				
				//Click on "Course-Type" dropdown and select “CBSE” from the list
				Select course = new Select(driver.findElement(By.id("ddl_Category")));
				course.selectByVisibleText("CBSE");
				
			
				//Click on "City" dropdown and select “Pune” from the list
				Select city = new Select(driver.findElement(By.id("ddl_City")));  
				city.selectByVisibleText("Pune");
				
				//Click on "Search" button
				WebElement search = driver.findElement(By.xpath("//input[@id=\"btnSearch\"]"));
				search.click();
				
				//Verify Search results is displayed or not
				String pageTitle = driver.getTitle();
				String ExpectResult = "Best Schools in India 2013, List, Ranking";
				
				if(pageTitle.equals(ExpectResult))
				{
					//Displayed verify page is valid
					System.out.println("The Search result is - "+ExpectResult);
				}
				else
				{
					//Displayed verify page is not valid
					System.out.println("The Search display not displyed");
				}
		
	}

}
