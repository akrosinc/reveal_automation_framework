package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static Utilities.BaseClass.*;

/**
 * @author Yonela Ntlokwana: ExtentManager class is used for Extent Report
 *
 */
public class ExtentManager {
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeMethod
    public static void setExtent(){

        spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+getCurrentTime1()+".html");
        //spark.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
        spark.config().setDocumentTitle("Web Automation Test Report");
        spark.config().setReportName("Reveal Test Automation Report");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "Reveal Web Automation");
        extent.setSystemInfo("Tester", prop.getProperty("username"));
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", prop.getProperty("browser"));
    }
     @AfterTest
    public static void endReport() {
        extent.flush();
    }
}
