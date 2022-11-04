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

    @FindBy(how = How.XPATH, using ="//*[@id=\"management-tab-tabpane-organization\"]//tr[1]/td[2] ")
    WebElement organization_created;
    @FindBy(how = How.ID, using ="management-button")
    WebElement user_management_btn;

    @FindBy(how = How.XPATH, using ="//form/div[2]/label[2]")
    WebElement org_type_error;

    @FindBy(how = How.ID, using ="edit-button")
    WebElement edit_org_details;
    @FindBy(how = How.ID, using ="expanderclick-handler")
    WebElement expand_org_name;

    @FindBy(how = How.ID, using ="nameclick-handler")
    WebElement org_name;

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
    @FindBy(how = How.ID, using ="submit-button")
    WebElement user_submit_btn;
    public UserPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickCreateOrganizationBtn(){
        action.click(getDriver(),organization_create_btn);
    }
    public void clickCreateUserBtn(){
        action.click(getDriver(),create_user_btn);
    }
    public void clickUserTab(){
        action.click(getDriver(),user_tab);
    }
    public void enterOrganisationDetails(String org_name){
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
    public void createUser(){
        action.type(username_input,"qa.automation.user");
        action.type(first_name_input,"automation");
        action.type(last_name_input,"user");
        action.type(password_input,prop.getProperty("password"));
        action.click(getDriver(),user_submit_btn);
    }
    public boolean checkOrganisationCreated(){
      if(!organization_created.getText().contains("Testing team")) {
          organization_created.click();
      }
      return organization_created.isDisplayed();
    }
    public boolean checkOrganisationTypeError(){
        return org_type_error.isDisplayed();
    }
    public boolean checkUserPasswordError(){
        return password_missing_error.isDisplayed();
    }
    public boolean checkUserCreatedDisplayed(){
        return created_user_on_table.isDisplayed();
    }
    public void clickUserManagementBtn(){
        action.JSClick(getDriver(),user_management_btn);
    }
    public void clickOrgEditBtn(){
        action.click(getDriver(),edit_org_details);
    }
    public void openOrganisationDetails(String org_name){
        if(!organization_created.getText().contains(org_name)) {
            expand_org_name.click();
            organization_created.click();
        }else {
            organization_created.click();
        }
    }
    public boolean isOrgDetailsChanged(String org_name){
      return   organization_created.getText().contains(org_name);
    }
}
