package PageObjects;
import ActionDriver.Action;
import Utilities.BaseClass;
import org.junit.platform.commons.function.Try;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PlanPage extends BaseClass {
    Action action= new Action();
    WebDriver driver;
    static Random rand = new Random(); //instance of random class
    static int upperbound = 100;
    //generate random values from 0-100
    static int int_random = rand.nextInt(upperbound);
    public static final String activePlanTitle = "active_b";
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
    @FindBy(how = How.XPATH, using ="//form/div/div[1]/div[5]/div/div/div[1]/div[2]/input")
    WebElement select_intervention_type;
    @FindBy(how = How.XPATH, using ="//*[@id=\"intervetion-type-select\"]/div/div[1]/div[1]")
    WebElement intervention_type;
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
    @FindBy(how = How.XPATH, using ="//div[1]/h2/button")
    WebElement goal_created;
    @FindBy(how = How.XPATH, using ="//div[1]/h2/button")
    WebElement goal_first_created;
    @FindBy(how = How.XPATH, using ="//form/div/div[2]/div/div[1]//div[1]/div[2]/button[1]")
    WebElement edit_goal_button;
    @FindBy(how = How.CSS, using ="input[value='Drug_treatment']")
    WebElement edited_goal;
    @FindBy(how = How.XPATH, using ="//*[text()='Goal updated successfully']")
    WebElement edited_goal_toast;
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
    @FindBy(how = How.XPATH, using ="//form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]")
    WebElement delete_goal_btn;
    @FindBy(how = How.XPATH, using ="//button[contains(text(),'Confirm')]")
    WebElement confirm_button;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Action deleted successfully.')]")
    WebElement action_delete_toast;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Action created successfully.')]")
    WebElement action_created_toast;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Action edited successfully.')]")
    WebElement action_edited_toast;
    @FindBy(how = How.ID, using ="action_RACD Register Family")
    WebElement action_exist;
    @FindBy(how = How.ID, using ="update-details-button")
    WebElement update_details_btn;
    @FindBy(how = How.ID, using ="back-button")
    WebElement plan_back_btn;
    @FindBy(how = How.XPATH, using ="//*[contains(text(),'edited testing title')]")
    WebElement edited_plan_tile;
    @FindBy(how = How.XPATH, using ="//*[text()='Plan updated successfully.']")
    WebElement update_plan_toast;
    @FindBy(how = How.XPATH, using ="//*[text()='Plan activated successfully']")
    WebElement activated_plan_toast;
    @FindBy(how = How.XPATH, using ="//*[text()='Teams successfully assigned.']")
    WebElement team_assigned_toast;
    @FindBy(how = How.ID, using ="assign-button")
    WebElement plan_assignment_main_btn;
    @FindBy(how = How.ID, using ="assignments-tab-location-assignment")
    WebElement assign_location_tab;
    @FindBy(how = How.ID, using ="assignments-tab-team-assignment")
    WebElement assign_team_tab;
    @FindBy(how = How.XPATH, using ="//table[1]/tbody[1]/tr[1]/td[4]/div[1]/input[1]")
    WebElement plan_location_selectBox;
    @FindBy(how = How.ID, using ="save-assignments-button")
    WebElement save_assign_location;
    @FindBy(how = How.XPATH, using ="//div[contains(text(),'Locations assigned to plan successfully.')]")
    WebElement plan_location_assignment_toast;
    @FindBy(how = How.XPATH, using ="//div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement select_team_assignment;
    @FindBy(how = How.XPATH, using ="//div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement select_location_assignment;
    @FindBy(how = How.XPATH, using ="//div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    WebElement select_location_assignmentDiv;
    @FindBy(how = How.XPATH, using ="//td[text()='"+activePlanTitle+"']/../td[7]/button[1]")
    WebElement activate_plan;
    @FindBy(how = How.ID, using ="activate-button")
    WebElement confirm_activate_plan;
    @FindBy(how = How.XPATH, using ="//td[@class='text-center']")
    WebElement expand_action;
    @FindBy(how = How.XPATH, using ="//div[contains(text(),'Please select and save your changes, at least one location needs to be able selected to assign teams.')]")
    WebElement getTeam_assigned_warning_toast;
    public PlanPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickCreatePlanBtn() {action.JSClick(getDriver(),create_plan_btn);}
    public void clickPlanManagementBtn() throws Throwable{
        action.moveToElement(getDriver(),plan_management_btn);
        action.click(getDriver(),plan_management_btn);
    }
    public void enterPlanDetails(String plan_name) {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.type(plan_title_input,plan_name);
        action.type(start_date_picker,getCurrentDate());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.type(end_date_picker,getCurrentDate());
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.SelectDropDown(select_hierarchy);
        action.SelectDropDown(select_intervention_type);
    }
    public void updatePlanDetails(String plan_name) {
        action.type(plan_title_input,plan_name);
        start_date_picker.clear();
        action.type(start_date_picker,getCurrentDate());
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        end_date_picker.clear();
        action.type(end_date_picker,getCurrentDate());
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.SelectDropDown(select_hierarchy);
        clickPlanUpdateBtn();
    }

    public String getCurrentDate(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }

    public void submitPlan(){
        action.click(getDriver(),submit_plan);
    }
    public void clickAssignTeamTab(){
        action.explicitWait(getDriver(),assign_team_tab,30);
        getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        boolean accessAsignTeamTab = false;
        try {
            action.JSClick(getDriver(),assign_team_tab);
            accessAsignTeamTab= action.findElement(getDriver(),getTeam_assigned_warning_toast);
        }catch (NotFoundException ex){}
        if (accessAsignTeamTab){
            selectLocationAssign();
            saveLocationAssignment();
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            action.JSClick(getDriver(),assign_team_tab);
        }else {
            action.JSClick(getDriver(),assign_team_tab);
        }

    }
    public void selectTeam(){
        action.SelectDropDown(select_team_assignment);
    }
    public void selectLocationsAssignment(){
        action.type(select_location_assignment,"a");
        action.explicitWait(getDriver(),select_location_assignmentDiv,30);
        action.JSClick(getDriver(),select_location_assignmentDiv);
    }

    public void clickPlanAssignmentBtn(){
        action.JSClick(getDriver(),plan_assignment_main_btn);
    }
    public void clickAssignLocationTab(){
        action.click(getDriver(),assign_location_tab);
    }
    public void clickEditActionBtn(){
        action.click(getDriver(),expand_action);
    }
    public void selectLocationAssign(){
        action.JSClick(getDriver(),plan_location_selectBox);
    }
    public void saveLocationAssignment(){
        action.JSClick(getDriver(),save_assign_location);
    }
    public void clickPlanBackBtn(){
        action.click(getDriver(),plan_back_btn);
    }
    public void createGoals(String goalDescription){
        action.type(goal_description_input,goalDescription);
        action.click(getDriver(),goal_priority_select);
        goal_priority_select.sendKeys(Keys.ARROW_DOWN);
        goal_priority_select.sendKeys(Keys.ENTER);
        clickSubmitGoalsBtn();
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void expandGoals(){
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       try{
           if (action.findElement(getDriver(),goal_created)){
               action.click(getDriver(),goal_created);
           }else {
               action.click(getDriver(),goal_first_created);
           }
       }catch (NotFoundException e){e.getStackTrace();}

    }
    public void clickEditGoalButton(){
        action.click(getDriver(),edit_goal_button);
    }
    public void clickSubmitGoalsBtn(){
        action.click(getDriver(),submit_goal_button);
    }
    public  boolean isGoalCreated(){
       return action.isDisplayed(getDriver(),goal_created);
    }
    public void confirmSubmittedPlan(){
        action.JSClick(getDriver(),confirm_submitted_plan);
    }
    public void clickActivatePlanBtn(){
        action.JSClick(getDriver(),activate_plan);
    }
    public void submitActivatePlan(){
        action.JSClick(getDriver(),confirm_activate_plan);
    }
    public void clickGoalTab(){
        action.moveToElement(getDriver(),plans_tab_create_goals);
        plans_tab_create_goals.click();
        //action.click(getDriver(),plans_tab_create_goals);
    }
    public void openPlan() {
        boolean plan = false;
        try {
             plan = action.findElement(getDriver(),confirm_plan_on_table);
            if (!plan) {
                clickCreatePlanBtn();
                enterPlanDetails("testing qa");
                submitPlan();
                confirmBtn();
                action.explicitWait(getDriver(), confirm_plan_on_table, 10);
                action.click(getDriver(), confirm_plan_on_table);
            } else {
                action.click(getDriver(), confirm_plan_on_table);
            }

        }catch(NotFoundException ex){}

    }
    public void clickAddGoals(){
        action.click(getDriver(),add_goal_button);
    }
    public void clickCreateActionsBtn(){
        action.click(getDriver(),create_actions_btn);
    }

    public boolean changeInterventionType(){
      String type= intervention_type.getText();
      action.doubleSelectDropDown(select_intervention_type);
      clickPlanUpdateBtn();
      String new_type= intervention_type.getText();
      if(type != new_type){
          return true;
      }else {
          return false;
      }
    }

    public void deleteGoalBtn(){
        action.JSClick(getDriver(),delete_goal_btn);
    }
    public void confirmBtn(){
        action.JSClick(getDriver(), confirm_button);
    }
    public void CreateActions(){
        action.SelectDropDown(action_title_input);
        action.type(action_description_input,"Testing actions");
        start_date_picker.sendKeys(Keys.chord(Keys.CLEAR));
        action.datePicker(start_date_picker);
        end_date_picker.sendKeys(Keys.chord(Keys.CLEAR));
        action.datePicker(end_date_picker);
        action.JSClick(getDriver(),action_save_button);
    }
    public void editPlanTitle(String title) throws Throwable{
        action.type(plan_title_input,title);
    }
    public void clickPlanUpdateBtn(){
        action.JSClick(getDriver(),update_details_btn);
    }
    public boolean isActionsOnTheTable(){return action.isDisplayed(getDriver(),action_exist);}
    public boolean isPlanOnTheTable(){return action.isDisplayed(getDriver(),confirm_plan_on_table);}

    public boolean isGoalEdited(){
        return edited_goal_toast.isDisplayed();
    }
    public boolean isTeamAssignedToLocation(){
        action.explicitWait(getDriver(),team_assigned_toast,40);
        return team_assigned_toast.isDisplayed();
    }
    public boolean isGPlanTitleEdited(String title){
        return edited_plan_tile.getText().contains(title);
    }
    public boolean isPlanUpdated(String msg){
        return update_plan_toast.getText().contains(msg);
    }
    public boolean isPlanActivated(){
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return activated_plan_toast.isDisplayed();
    }
    public boolean isLocationAssignedToPlan(){
        return plan_location_assignment_toast.isDisplayed();
    }
    public boolean isGoalDeleted(){
        return goal_created.isDisplayed();}
}
