package Utilities;

import ExtentReport.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * @author Yonela Ntlokwana: BaseClass is used to load the config file and Initialize
 * WebDriver
 *
 */
public class BaseClass  {

    //public static WebDriver driver ;
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static Properties prop;

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver.get();
    }
    //Launching a browser  and sending an url

    public static  WebDriver launchApp(){
        //loadConfig();
        String browserName= Constants.browser;
        //String browserName= prop.getProperty("browser")
        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors",
                    "--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
            driver.set(new ChromeDriver());
        }else if(browserName.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }else if(browserName.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }
        //Maximize the screen
        getDriver().manage().window().maximize();
        //Launching the URL
        getDriver().get(Constants.baseUrl);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();
    }

    //Loading a config file
    //@BeforeMethod
    public static void loadConfig(){
            try{
                prop = new Properties();
                System.out.println("Super constructor invoked");
                FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\config.properties");
                prop.load(ip);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException io){
                io.printStackTrace();
            }
    }
    //Setting
    @BeforeMethod()
    public void setup() {
        launchApp();
        ExtentManager.setExtent();
    }
   //closing a browser driver
    @AfterMethod()
    public void tearDown() {
        ExtentManager.endReport();
        getDriver().quit();
    }
    public static String getCurrentTime(){
            String currentDate  = new SimpleDateFormat("yyyy-mm-dd-hhmmss").format(new Date());
            return  currentDate;
    }
    public static String getCurrentTime1(){
        String currentDate  = new SimpleDateFormat("Mth d, yyyy HH:MM tt").format(new Date());
        return  currentDate;
    }
}
