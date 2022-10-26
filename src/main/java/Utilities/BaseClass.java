package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BaseClasss {

    public static WebDriver driver ;
    public static Properties prop;
    @BeforeTest
    public void launchApp(){
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");
      if(browserName.contains("Chrome")){
          driver = new ChromeDriver();
      }else if(browserName.contains("FireFox")){
          driver = new FirefoxDriver();
      }else if(browserName.contains("Edge")){
          driver = new EdgeDriver();
      }
        //Maximize the screen
        driver.manage().window().maximize();
        //Launching the URL
        driver.get(prop.getProperty("baseUrl"));
    }
    @BeforeTest
    public void loadConfig(){
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
}
