package browserutility;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import objectutility.PropertyReaders;

public class BrowserConfig

{
	
static WebDriver driver;
	
	//Invoking PropertiesReader class
	static PropertyReaders ppr1 = new PropertyReaders();
	static String cpath = ppr1.getchromepath();
	static String ckey = ppr1.getchormekey();
	static String baseurl = ppr1.geturl();
	static String fkey = ppr1.getfirefoxkey();
	static String fpath = ppr1.getfirefoxpath();
	static String ekey = ppr1.getedgekey();
	static String epath = ppr1.getedgepath();
	
	//returns the driver object based on the brow
	public WebDriver launchBrowser()
	{
		
		Scanner input = new Scanner(System.in);

	    System.out.print("Enter browser name : ");

	    // takes input from the keyboard
	    String name = input.nextLine();

	    // prints the name
	    System.out.println("The Entered Browser name is " + name);
		
		//invokes the chrome browser
		if(name.equalsIgnoreCase("Chrome"))
		{
		
		System.setProperty(ckey,cpath);
		driver = new ChromeDriver();
		}
		
		//invokes the firefox browser
		else if(name.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(fkey,fpath);
			driver=new FirefoxDriver();
		}
		//invokes the edge browser
		else if(name.equalsIgnoreCase("Edge"))
		{
			System.setProperty(ekey,epath);
			driver = new EdgeDriver();
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



