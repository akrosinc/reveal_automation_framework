package PageObjects;
import ActionDriver.Action;
import Utilities.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.lang.System.in;

public class UserPage extends BaseClass{
    Action action= new Action();
    WebDriver driver;
    @FindBy(how = How.ID, using ="organization-create-button")
    WebElement organization_create_btn;

    @FindBy(how = How.ID, using ="organization-name-input")
    WebElement organization_name_input;

    @FindBy(how = How.ID, using ="type-select")
    WebElement organization_type;

    @FindBy(how = How.ID, using ="react-select-2-input")
    WebElement organization_part_of_select;
    @FindBy(how = How.ID, using ="save-button")
    WebElement organization_save_btn;

    @FindBy(how = How.XPATH, using ="//*[text()='QA Testing']")
    WebElement organization_created;
    @FindBy(how = How.ID, using ="management-button")
    WebElement user_management_btn;

    @FindBy(how = How.XPATH, using ="//form/div[2]/label[2]")
    WebElement org_type_error;

    @FindBy(how = How.ID, using ="edit-button")
    WebElement edit_org_details;
    @FindBy(how = How.ID, using ="active-organization-switch")
    WebElement active_organization_switch;

    @FindBy(how = How.ID, using ="expanderclick-handler")
    WebElement expand_org_name;

    @FindBy(how = How.ID, using ="delete-button")
    WebElement delete_org_btn;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Confirm')]")
    WebElement confirm_delete_org;
    @FindBy(how = How.ID, using ="management-tab-tab-user")
    WebElement user_tab;
    @FindBy(how = How.ID, using ="create-user-button")
    WebElement create_user_btn;
    @FindBy(how = How.ID, using ="username-input")
    WebElement username_input;
    @FindBy(how = How.ID, using ="first-name-input")
    WebElement first_name_input;
    @FindBy(how = How.ID, using ="last-name-input")
    WebElement last_name_input;

    @FindBy(how = How.ID, using ="password-input")
    WebElement password_input;

    @FindBy(how = How.XPATH, using ="//div[5]/div/div/div[1]/div[2]/input")
    WebElement security_group;
    @FindBy(how = How.XPATH, using ="//div[6]/div/div/div[1]/div[2]/input")
    WebElement organization_user_select;

    @FindBy(how = How.XPATH, using ="//div[3]/label[2]")
    WebElement password_missing_error;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'qa.automation.user')]")
    WebElement created_user_on_table;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'First name must not be empty.')]")
    WebElement first_name_empty_error;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Last name must not be empty.')]")
    WebElement last_name_empty_error;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),' deleted successfully')]")
    WebElement org_deleted_toast;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'qa.automation.user')]")
    WebElement existing_user;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),' updated successfully.')]")
    WebElement user_updated_toast;
    @FindBy(how = How.ID, using ="submit-button")
    WebElement user_submit_btn;
    public UserPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickCreateOrganizationBtn(){
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        action.JSClick(getDriver(),organization_create_btn);
    }
    public void clickCreateUserBtn(){
        action.click(getDriver(),create_user_btn);
    }
    public void clickUserTab(){
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        action.JSClick(getDriver(),user_tab);
    }
    public void enterOrganisationDetails(String org_name){
        action.type(organization_name_input,org_name);
        action.SelectDropDown(organization_type);
       // action.SelectDropDown(organization_part_of_select);
        action.click(getDriver(),organization_save_btn);
    }
    public void enterChildOrganisationDetails(String org_name){
        action.type(organization_name_input,org_name);
        action.SelectDropDown(organization_type);
        action.SelectDropDown(organization_part_of_select);
        action.click(getDriver(),organization_save_btn);
    }
    public void enterOrganisationDetailsWithOutTpe(String org_name){
        action.type(organization_name_input,org_name);
        action.SelectDropDown(organization_part_of_select);
        action.click(getDriver(),organization_save_btn);
    }
    public void createUserWithOutPassword(){
        action.type(username_input,"qa.automation.user");
        action.type(first_name_input,"automation");
        action.type(last_name_input,"user");
        action.click(getDriver(),user_submit_btn);
    }
    public void createUser(String fname, String lname){
        action.type(username_input,"qa.automation.user");
        action.type(first_name_input,fname);
        action.type(last_name_input,lname);
        action.type(password_input,prop.getProperty("password"));
        action.click(getDriver(),user_submit_btn);
    }
    public void editUser(String fname, String lname){
        action.type(username_input,"automation.user");
        action.type(first_name_input,fname);
        action.type(last_name_input,lname);
        action.type(password_input,prop.getProperty("password"));
        action.JSClick(getDriver(),organization_save_btn);
    }
    public void toggleInactive(){
        action.click(getDriver(),active_organization_switch);
    }
    public void clickDeleteBtn(){
        action.JSClick(getDriver(),delete_org_btn);
    }
    public void clickConfirmDeleteBtn(){
        action.JSClick(getDriver(),confirm_delete_org);
    }
    public void clickSaveOrganisation(){
        action.click(getDriver(),organization_save_btn);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public boolean checkOrganisationCreated(){
      if(!organization_created.getText().contains("Testing team")) {
          organization_created.click();
      }
      return organization_created.isDisplayed();
    }

    public void clickUserManagementBtn(){
        action.JSClick(getDriver(),user_management_btn);
    }
    public void expandUserDetails(String username){
        boolean flag_user_name = false;
        try {
            flag_user_name =existing_user.getText().contains(username);
        }catch(NotFoundException e){
            e.getStackTrace();
        }
        if (!flag_user_name) {
            clickCreateUserBtn();
            createUser("qa", "automation");
            action.JSClick(getDriver(),existing_user);

        } else {
            action.JSClick(getDriver(),existing_user);
        }
    }
    public void clickOrgEditBtn(){
        action.click(getDriver(),edit_org_details);
    }
    public void openOrganisationDetails(String org_name){
        boolean flag_org_name = false;
        try {
            flag_org_name =organization_created.getText().contains(org_name);
        }catch(NotFoundException e){
            e.getStackTrace();
        }
        if (!flag_org_name) {
            clickCreateOrganizationBtn();
            enterOrganisationDetails(org_name);
            organization_created.click();

        } else {
            organization_created.click();
        }
    }
    public boolean checkOrganisationTypeError(){
        return org_type_error.isDisplayed();
    }
    public boolean isUserEmptyNamesErrorDisplayed(){
        return first_name_empty_error.isDisplayed() && last_name_empty_error.isDisplayed();
    }
    public boolean checkUserPasswordError(){
        return password_missing_error.isDisplayed();
    }
    public boolean checkUserCreatedDisplayed(){
        return created_user_on_table.isDisplayed();
    }
    public boolean checkUserUpdatedDisplayed(){
        return user_updated_toast.isDisplayed();
    }
    public boolean isOrgDetailsChanged(String org_name){
      return   organization_created.getText().contains(org_name);
    }
    public boolean isOrganisationActive(){
        return   !active_organization_switch.isSelected();
    }
    public boolean isOrganisationSuccessfullyDeleted(){
        return   org_deleted_toast.isDisplayed();
    }
}
