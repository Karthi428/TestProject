package reportUtility;
 
import java.util.Date;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 

 
public class Report {

    // Declaring variables for the report
    public static ExtentHtmlReporter extHtmlRep;
    public static ExtentReports extRep;
    public static ExtentTest testLog;
 
    // Method to initialize report and configure it
    public void initReport() {
    extHtmlRep = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\" + reportName() + ".html");
    extRep = new ExtentReports();
    extRep.attachReporter(extHtmlRep);
 
    extRep.setSystemInfo("Machine", "CTS");
    extRep.setSystemInfo("Env", "Testing");
    extRep.setSystemInfo("OS", "Microsoft Windows 10 Enterprise");
 
    extHtmlRep.config().setDocumentTitle("ExtentReports");
    extHtmlRep.config().setReportName("ExtentReports1");
 
    }
 
    // Method to create name of the report based on date and time
    public static String reportName() {
    Date date = new Date();
    return date.toString().replace(":", "_").toString().replace(" ", "_");
    }
 
    // Method to create a test
    public void createTest(String name) {
    testLog = extRep.createTest(name);
    }
 
    // Method to log the info in the report
    public void logInfo(String msg) {
    testLog.log(Status.INFO, msg);
    }
 
 
    // Method to log the pass message in the report
    public void logPass(String msg) {
    testLog.log(Status.PASS, msg);
    }
 
    // Method to log the fail message in the report
    public void logFail(String msg) {
    testLog.log(Status.FAIL, msg);
    System.out.println(msg);
    Assert.fail(msg);
    }
    //Method to save the report
    public void saveReport() {
    extRep.flush();
    }
}