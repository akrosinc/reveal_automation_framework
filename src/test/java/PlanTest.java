import PageObjects.PlanPage;
import PageObjects.SignInPage;
import Utilities.BaseClass;
import Utilities.Constants;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static PageObjects.PlanPage.activePlanTitle;


public class PlanTest extends BaseClass {
   private  String plan_name = "testing qa";
    private  String goal_description = "Drug treatment";
    @Test() //Create plan without goals
    public void createPlanTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.clickCreatePlanBtn();
        plan.enterPlanDetails(plan_name);
        plan.clickPlanUpdateBtn();
        Assert.assertTrue(plan.isPlanOnTheTable(), "plan created not found in the table");
    }
    //Create plan with goals
    @Test()
    public void createPlanWithGoalsTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.clickCreatePlanBtn();
        plan.enterPlanDetails(plan_name);
        plan.clickGoalTab();
        plan.clickAddGoals();
        plan.createGoals(goal_description);
        Assert.assertTrue(plan.isGoalCreated(), "goal not created");
        plan.submitPlan();
    }
    //Edit plan goals
    @Test()
    public void editPlanGoalsTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.clickGoalTab();
        plan.clickAddGoals();
        plan.createGoals(goal_description);
        plan.expandGoals();
        plan.clickEditGoalButton();
        plan.createGoals("edit drug treatment");
        Assert.assertTrue(plan.isGoalEdited(),"goal not edited");;
    }
    //Edit plan goals
    @Test()
    public void createGoalsActionsTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.clickGoalTab();
        plan.clickAddGoals();
        plan.createGoals(goal_description);
        plan.expandGoals();
        plan.clickCreateActionsBtn();
        plan.CreateActions();
        Assert.assertTrue(plan.isActionsOnTheTable(),"actions not successfully created");;
    }
    //Delete Goal Action
    @Test()
    public void deleteGoalsActionTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.clickGoalTab();
        plan.expandGoals();
        plan.deleteGoalBtn();
        plan.confirmBtn();
        Assert.assertTrue(plan.isGoalDeleted(),"goal not deleted");;
    }
    @Test()//update plan tile
    public void updatePlanTitleTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.editPlanTitle("edited testing title");
        plan.clickPlanUpdateBtn();
        plan.clickPlanBackBtn();
        Assert.assertTrue(plan.isGPlanTitleEdited("edited testing title"),"plan title not successfully created");;
    }
    @Test()//update plan details
    public void updatePlanTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.updatePlanDetails(plan_name);
        Assert.assertTrue(plan.isPlanUpdated("Plan updated successfully."),"plan not successfully updated");;
    }
    @Test()//Activate plan
    public void activatePlanTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.clickCreatePlanBtn();
        plan.enterPlanDetails(activePlanTitle);
        plan.submitPlan();
        plan.confirmBtn();
        plan.clickActivatePlanBtn();
        plan.submitActivatePlan();
        Assert.assertTrue(plan.isPlanActivated(),"plan not successfully activated");;
    }
    @Test()//Change intervention type
    public void ChangeInterventionTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanManagementBtn();
        plan.openPlan();
        boolean type = plan.changeInterventionType();
        Assert.assertTrue(plan.changeInterventionType(),"plan not successfully activated");;
    }
    @Test()//assign a plan to a location
    public void planLocationAssignmentTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanAssignmentBtn();
        plan.openPlan();
        plan.clickAssignLocationTab();
        plan.selectLocationAssign();
        plan.saveLocationAssignment();
        Assert.assertTrue(plan.isLocationAssignedToPlan(),"Location not assigned to plan successfully");;
    }
    @Test()//assign a plan to a location
    public void assignmentTeamToLocationTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        plan.clickPlanAssignmentBtn();
        plan.openPlan();
        plan.clickAssignTeamTab();
        plan.selectTeam();
        plan.selectLocationsAssignment();
        plan.saveLocationAssignment();
        Assert.assertTrue(plan.isTeamAssignedToLocation(),"Team not assigned to location successfully");;
    }
}
