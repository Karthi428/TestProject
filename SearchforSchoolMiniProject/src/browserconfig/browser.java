package browserconfig;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import configreader.PropertiesReader;

public class browser 
{
	//Declaring WebDriver driver as a global variable
	static WebDriver driver;
	
	//Invoking PropertiesReader class
	static PropertiesReader ppr = new PropertiesReader();
	static String cpath = ppr.getchromepath();
	static String ckey = ppr.getchormekey();
	static String baseurl = ppr.geturl();
	static String fkey = ppr.getfirefoxkey();
	static String fpath = ppr.getfirefoxpath();
	
	//returns the driver object based on the brow
	public WebDriver launchBrowser()
	{
		
		String brow = ppr.getBrowser();
		
		//invokes the chrome browser
		if(brow.equalsIgnoreCase("Chrome"))
		{
		
		System.setProperty(ckey,cpath);
		driver = new ChromeDriver();
		}
		
		//invokes the firefox browser
		else if(brow.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(fkey,fpath);
			driver=new FirefoxDriver();
		}
		//Maximize the window
		driver.manage().window().maximize();
		//To navigate the url
		driver.get(baseurl);
		//wait 10 seconds before throwing NoSuchElement found exception
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	

}
