package PageObjects;
import ActionDriver.Action;
import Utilities.BaseClass;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class LocationManagementPage extends BaseClass{
    Action action= new Action();
    WebDriver driver;
    @FindBy(how = How.ID, using ="locations-button")
    WebElement locations_management_btn;

    @FindBy(how = How.ID, using ="create-button")
    WebElement location_create_btn;
    @FindBy(how = How.XPATH, using ="//div[4]/button[1]")
    WebElement location_hierarchy_form_create_btn;
    @FindBy(how = How.ID, using ="name-input")
    WebElement location_name_input;

    @FindBy(how = How.ID, using ="title-input")
    WebElement location_title_input;
    @FindBy(how = How.XPATH, using ="//*[@name=\"nodeOrder\"]")
    WebElement location_node_list;
    @FindBy(how = How.XPATH, using ="//*[@id=\"hierarchy-select\"]/div/div[1]/div[2]")
    WebElement geography_levels_select;
    @FindBy(how = How.XPATH, using ="//*[@id=\"location-tabs-tabpane-geographic-levels\"]/div[2]/table")
    WebElement locationTable;
    @FindBy(how = How.XPATH, using ="//form/div[3]/button[1]")
    WebElement location_submit_create;
    @FindBy(how = How.XPATH, using ="//*[text()='default']")
    WebElement default_location_hierarchy_name;
    @FindBy(how = How.XPATH, using ="//label[starts-with(@class,'text-danger')]")
    WebElement location_warning_msg;
    @FindBy(how = How.XPATH, using ="//*[text()='Geographic Level name must not be empty.']")
    WebElement location_name_warning_msg;
    @FindBy(how = How.XPATH, using ="//*[text()='Geographic Level title must not be empty.']")
    WebElement location_title_warning_msg;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Geographic Location created successfully with id:')]")
    WebElement location_created_toast;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Geographic location updated successfully with id:')]")
    WebElement location_updated_toast;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Geographic location deleted successfully ')]")
    WebElement location_deleted_toast;
    @FindBy(how = How.XPATH, using ="//*[text()='testing']")
    WebElement location_name_created;
    @FindBy(how = How.XPATH, using ="//*[text()='edited']")
    WebElement location_name_edited;
    @FindBy(how = How.ID, using ="edit-button")
    WebElement location_edit_btn;
    @FindBy(how = How.ID, using ="delete-button")
    WebElement location_delete_btn;
    @FindBy(how = How.XPATH, using ="//div[3]/button[2]")
    WebElement location_confirm_delete;
    @FindBy(how = How.ID, using ="save-button")
    WebElement location_save_btn;
    @FindBy(how = How.ID, using ="location-tabs-tab-location-hierarchy")
    WebElement location_tab_location_hierarchy;
    public  void clickLocationManagementBtn(){
        action.JSClick(getDriver(),locations_management_btn);
    }
    public  void clickMainCreateBtn(){
        action.click(getDriver(),location_create_btn);
    }
    public  void clickLocationHierarchyTab(){
        action.click(getDriver(),location_tab_location_hierarchy);
    }
    public  void clickDeleteBtn(){
        action.click(getDriver(),location_delete_btn);
    }
    public  void confirmDelete(){
        action.click(getDriver(),location_confirm_delete);
    }
    public  void clickFormCreateBtn(){
        action.explicitWait(getDriver(),location_submit_create,40);
        action.click(getDriver(),location_submit_create);
    }
    public void enterGeographicLevelDetails(String name, String title){
        action.type(location_name_input,name);
        action.type(location_title_input,title);
    }
    public  void expandGeoLevel(){
        action.click(getDriver(),location_name_created);
    }
    public  void clickEditGeoLevel(){
        action.explicitWait(getDriver(),location_edit_btn,10);
        action.click(getDriver(),location_edit_btn);
    }
    public  void clickSaveGeoLevel(){
        action.click(getDriver(),location_save_btn);
    }
    public void createGeographicHierarchy(){
       try {
           var name = action.findElement(getDriver(), default_location_hierarchy_name);
           if (!name) {
               action.click(getDriver(), location_create_btn);
               action.type(location_name_input, "testing");
               action.SelectDropDown(geography_levels_select);
               clickFormCreateBtn();
           }
       }catch (NotFoundException e){}
    }
    public boolean isLocationManagementAccessible(){
        return locationTable.isDisplayed();
    }
    public boolean isLocationHierarchyNameDisplayed(){
        return default_location_hierarchy_name.isDisplayed();
    }
    public boolean isSpecialCharacterWarningMessageDisplayed(){
        return location_warning_msg.getText().contains("Geographic Level name can't start with empty space and can't containt uppercase characters or special letters.");
    }
    public boolean isGeoLocationCreated(){
        return location_created_toast.getText().contains("Geographic Location created successfully with id: ");
    }
    public boolean isGeoLocationDeleted(){
        return location_created_toast.getText().contains("Geographic Location deleted successfully with id: ");
    }
    public boolean isGeoLocationUpdated(){
        return location_updated_toast.getText().contains("Geographic location updated successfully with id: ");
    }
    public boolean isEmptyWarningMessageDisplayed(){
        return location_name_created.isDisplayed();
    }
}
