package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class ScreenShot
{
	static WebDriver driver;
	//invoking constructor
public ScreenShot(WebDriver driver)
{
	this.driver=driver;

}
public static void takeScreenShot() {
	//
WebElement dr = driver.findElement(By.xpath("//section[@class='form bg-highlight-primary']"));
 //Call getScreenshotAs method to create image file
File ss = dr.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
File path = new File("Screenshot//img_"+timestamp()+".png");
try {
//Copy file at destination
FileHandler.copy(ss, path);
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
