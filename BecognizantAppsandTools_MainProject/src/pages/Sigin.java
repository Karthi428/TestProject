package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Sigin
{
static WebDriver driver;
/****************** Sigin Parameterized Constructor ***********************/
public Sigin(WebDriver driver)
{
this.driver=driver;
if(!driver.getTitle().equals("Verify your identity"))
{
	System.out.println("Login page indicated");
}
else
{
	System.out.println("Login page not indicated");
}
}
public void login() throws InterruptedException
{
	//For clicking submit button after entering password
/*Thread.sleep(10000);

WebElement confirmationButton = driver.findElement(By.id("idSIButton9"));

if (confirmationButton.isEnabled())
{
confirmationButton.click();
}*/
	//For clicking number to validate OTP
driver.findElement(By.xpath("//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[1]/div/div/div[2]")).click();

Thread.sleep(10000);

WebElement confirmationButton1 = driver.findElement(By.id("idTxtBx_SAOTCC_OTC"));

if (confirmationButton1.isEnabled())
{
confirmationButton1.click();
}
//For clicking No button
//driver.findElement(By.id("idBtn_Back")).click();
}
}