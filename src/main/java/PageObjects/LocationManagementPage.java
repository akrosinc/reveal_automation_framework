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
    @FindBy(how = How.ID, using ="name-input")
    WebElement location_name_input;

    @FindBy(how = How.ID, using ="title-input")
    WebElement location_title_input;
    @FindBy(how = How.XPATH, using ="//*[@id=\"location-tabs-tabpane-geographic-levels\"]/div[2]/table")
    WebElement locationTable;

    @FindBy(how = How.XPATH, using ="//form/div[3]/button[1]")
    WebElement location_submit_create;

    @FindBy(how = How.XPATH, using ="//label[starts-with(@class,'text-danger')]")
    WebElement location_warning_msg;
    @FindBy(how = How.XPATH, using ="//*[text()='Geographic Level name must not be empty.'] ")
    WebElement location_name_warning_msg;
    @FindBy(how = How.XPATH, using ="//*[text()='Geographic Level title must not be empty.'] ")
    WebElement location_title_warning_msg;
    public  void clickLocationManagementBtn(){
        action.JSClick(getDriver(),locations_management_btn);
    }
    public  void clickMainCreateBtn(){
        action.click(getDriver(),location_create_btn);
    }
    public  void clickFormCreateBtn(){
        action.explicitWait(getDriver(),location_submit_create,40);
        action.click(getDriver(),location_submit_create);
    }
    public void fileInGeographicLevelDetails(String name,String title){
        action.type(location_name_input,name);
        action.type(location_title_input,title);
    }
    public boolean isLocationManagementAccessible(){
        return locationTable.isDisplayed();
    }
    public boolean isSpecialCharacterWarningMessageDisplayed(){
        return location_warning_msg.getText().contains("Geographic Level name can't start with empty space and can't containt uppercase characters or special letters.");
    }
    public boolean isEmptyWarningMessageDisplayed(){
        return location_name_warning_msg.isDisplayed() && location_title_warning_msg.isDisplayed();
    }
}
