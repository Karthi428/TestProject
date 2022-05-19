package testcases;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.openqa.selenium.WebDriver;
import browserconfig.browser;
import pages.PageTest;
public class MainPage {

	static WebDriver driver = null;
	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		PageTest pg;
		browser brows = new browser();
		//Invokes the methods used in  browser class
		driver = brows.launchBrowser();
		
		pg = new PageTest(driver);
		//Setting Console output in Consoleoutput file 
		System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\2078130\\eclipse-workspace\\SearchforSchoolMiniProject\\Consoleoutput"+"\\Output.txt")));
		//Invokes the methods used in PageTest class
		pg.SearchSchools();
		//To close driver
		driver.quit();	
	}
	

}
