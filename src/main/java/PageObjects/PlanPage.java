package PageObjects;
import ActionDriver.Action;
import Utilities.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class PlanPage extends BaseClass {
    Action action= new Action();
    WebDriver driver;
    @FindBy(how = How.ID, using ="plans-button")
    WebElement plan_management_btn;

    @FindBy(how = How.ID, using ="create-button")
    WebElement create_plan_btn;

    @FindBy(how = How.ID, using ="plan-title-input")
    WebElement plan_title_input;

    @FindBy(how = How.ID, using ="start-date-picker")
    WebElement start_date_picker;

    @FindBy(how = How.ID, using ="end-date-picker")
    WebElement end_date_picker;

    @FindBy(how = How.ID, using ="hierarchy-select")
    WebElement select_hierarchy;

    @FindBy(how = How.ID, using ="intervention-type-select")
    WebElement select_intervention_type;

    @FindBy(how = How.ID, using ="create-plan-button")
    WebElement submit_plan;

    @FindBy(how = How.ID, using ="dialog-confirm")
    WebElement confirm_submitted_plan;

    @FindBy(how = How.XPATH, using ="//*[text()='testing qa']")
    WebElement confirm_plan_on_table;

    @FindBy(how = How.ID, using ="plans-tab-create-goals")
    WebElement plans_tab_create_goals;

    @FindBy(how = How.ID, using ="add-goal-button")
    WebElement add_goal_button;

    @FindBy(how = How.ID, using ="goal-description-input")
    WebElement goal_description_input;

    @FindBy(how = How.ID, using ="goal-priority-select")
    WebElement goal_priority_select;

    @FindBy(how = How.ID, using ="submit-goal-button")
    WebElement submit_goal_button;
    @FindBy(how = How.XPATH, using ="//div/div[2]/div/div[2]/h2/button")
    WebElement goal_created;
    @FindBy(how = How.XPATH, using ="//*[@id=\"edit-goal-button\"]")
    WebElement edit_goal_button;

    @FindBy(how = How.CSS, using ="input[value='Drug_treatment']")
    WebElement edited_goal;

    @FindBy(how = How.ID, using ="name-sort")
    WebElement plan_table;

    @FindBy(how = How.ID, using ="create-action-button")
    WebElement create_actions_btn;

    @FindBy(how = How.ID, using ="action-title-input")
    WebElement action_title_input;

    @FindBy(how = How.ID, using ="action-description-input")
    WebElement action_description_input;

    @FindBy(how = How.ID, using ="action-start-date-picker")
    WebElement action_start_date_picker;

    @FindBy(how = How.ID, using ="action-end-date-picker")
    WebElement action_end_date_picker;

    @FindBy(how = How.ID, using ="action-form-select")
    WebElement action_form_select;

    @FindBy(how = How.ID, using ="action-save-button")
    WebElement action_save_button;

    @FindBy(how = How.ID, using ="action_RACD Register Family")
    WebElement action_description_on_table;

    @FindBy(how = How.ID, using ="edit-action-button")
    WebElement action_edit_btn;

    @FindBy(how = How.ID, using ="condition-entity-select")
    WebElement condition_entity_select;

    @FindBy(how = How.ID, using ="entity-properties-select")
    WebElement condition_entity_properties_select;

    @FindBy(how = How.ID, using ="operator-select")
    WebElement condition_operator_select;

    @FindBy(how = How.ID, using ="filter-value-input")
    WebElement condition_filter_value;

    @FindBy(how = How.ID, using ="target-description-input")
    WebElement condition_target_description;
    @FindBy(how = How.ID, using ="target-priority-input")
    WebElement condition_target_priority_input;

    @FindBy(how = How.ID, using ="flexRadioDefault1")
    WebElement condition_flexRadioDefault1;

    @FindBy(how = How.ID, using ="target-metric-value-input")
    WebElement condition_target_metric_value;
    @FindBy(how = How.ID, using ="condition-save-button")
    WebElement condition_condition_save_btn;

    @FindBy(how = How.XPATH, using ="//div/div[2]/div/div[2]/div/div/div[1]/div[2]/button[2]")
    WebElement delete_goal_btn;

    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Confirm')]")
    WebElement confirm_delete_goal;
    @FindBy(how = How.ID, using ="action_RACD Register Family")
    WebElement action_exist;
    @FindBy(how = How.ID, using ="update-details-button")
    WebElement update_details_btn;
    @FindBy(how = How.ID, using ="back-button")
    WebElement plan_back_btn;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'edited testing title')]")
    WebElement edited_plan_tile;
    public PlanPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickCreatePlanBtn() throws Throwable{action.click(getDriver(),create_plan_btn);}
    public void clickPlanManagementBtn() throws Throwable{
        action.moveToElement(getDriver(),plan_management_btn);
        action.click(getDriver(),plan_management_btn);
        //action.explicitWait(getDriver(),plan_table,40);
    }
    public void enterPlanDetails(String plan_name) {
        Actions keyDown = new Actions(driver);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.type(plan_title_input,plan_name);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.type(start_date_picker,getCurrentDate());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.type(end_date_picker,getCurrentDate());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.SelectDropDown(select_hierarchy);
        action.SelectDropDown(select_intervention_type);
    }

    private String getCurrentDate(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }

    public void submitPlan(){
        action.click(getDriver(),submit_plan);
    }
    public void clickPlanBackBtn(){
        action.click(getDriver(),plan_back_btn);
    }
    public void createGoals(String goalDescription){
        action.type(goal_description_input,goalDescription);
        action.click(getDriver(),goal_priority_select);
        goal_priority_select.sendKeys(Keys.ARROW_DOWN);
        goal_priority_select.sendKeys(Keys.ENTER);
        action.click(getDriver(),submit_goal_button);
    }
    public void expandGoals(){
        action.click(getDriver(),goal_created);
    }
    public void clickEditGoalButton(){
        action.JSClick(getDriver(),edit_goal_button);
    }
    public  boolean isGoalCreated(){
       return action.isDisplayed(getDriver(),goal_created);
    }
    public void confirmSubmittedPlan(){
        action.JSClick(getDriver(),confirm_submitted_plan);
    }
    public void clickGoalTab(){
        action.moveToElement(getDriver(),plans_tab_create_goals);
        plans_tab_create_goals.click();
        //action.click(getDriver(),plans_tab_create_goals);
    }
    public void openPlan(){
        action.click(getDriver(),confirm_plan_on_table);
    }
    public void clickAddGoals(){
        action.click(getDriver(),add_goal_button);
    }
    public void clickCreateActionsBtn(){
        action.click(getDriver(),create_actions_btn);
    }

    public void deleteGoalBtn(){
        action.click(getDriver(),delete_goal_btn);
    }
    public void confirmDeleteGoalBtn(){
        action.click(getDriver(),confirm_delete_goal);
    }
    public void CreateActions(){
        action.click(getDriver(),action_title_input);
        action_title_input.sendKeys(Keys.ARROW_DOWN);
        action_title_input.sendKeys(Keys.ENTER);
        action.type(action_description_input,"Testing actions");
        action.type(action_start_date_picker,getCurrentDate());
        action_start_date_picker.sendKeys(Keys.TAB);
        action.type(action_end_date_picker,getCurrentDate());
        action_end_date_picker.sendKeys(Keys.TAB);
        action.click(getDriver(),action_form_select);
        action_title_input.sendKeys(Keys.ARROW_DOWN);
        action_title_input.sendKeys(Keys.TAB);
        action.click(getDriver(),action_save_button);
    }
    public void editPlanTitle(String title) throws Throwable{
        action.type(plan_title_input,title);
    }
    public void clickPlanUpdateBtn() throws Throwable{
        action.click(getDriver(),update_details_btn);
    }
    public boolean isActionsOnTheTable(){return action.isDisplayed(getDriver(),action_exist);}
    public boolean isPlanOnTheTable(){return action.isDisplayed(getDriver(),confirm_plan_on_table);}

    public boolean isGoalEdited(){
        return edited_goal.getText().contains("edit");}
    public boolean isGPlanTitleEdited(String title){
        return edited_plan_tile.getText().contains(title);
    }

    public boolean isGoalDeleted(){
        return !goal_created.isDisplayed();}
}
