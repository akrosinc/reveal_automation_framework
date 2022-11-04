package PageObjects;
import ActionDriver.Action;
import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LocationManagementPage extends BaseClass{
    Action action= new Action();
    WebDriver driver;
    @FindBy(how = How.ID, using ="locations-button")
    WebElement locations_management_btn;

    @FindBy(how = How.ID, using ="create-button")
    WebElement location_create_btn;

    @FindBy(how = How.XPATH, using ="//*[@id=\"location-tabs-tabpane-geographic-levels\"]/div[2]/table")
    WebElement locationTable;

    public  void clickLocationManagementBtn(){
        action.JSClick(getDriver(),locations_management_btn);
    }

    public boolean isLocationManagementAccessible(){
        return locationTable.isDisplayed();
    }
}
