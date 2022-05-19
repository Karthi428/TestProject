package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenShot
{
	static WebDriver driver;
	
	/****************** ScreenShot Parameterized Constructor ***********************/
	public ScreenShot(WebDriver driver)
	{
		this.driver=driver;
	
	}
	public static void takeScreenShot() {
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File src=screenshot.getScreenshotAs(OutputType.FILE);		
		File path = new File("Screenshot//img_"+timestamp()+".png");
		try {
		//Copy file at destination
		FileHandler.copy(src, path);
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		public static String timestamp()
		{
		// return the current date and time
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}

		}
