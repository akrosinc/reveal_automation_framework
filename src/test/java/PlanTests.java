import PageObjects.PlanPage;
import PageObjects.SignInPage;
import Utilities.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlanTests extends BaseClass {
    //Create plan without goals
    @Test()
    public void createPlanTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        plan.clickPlanManagementBtn();
        plan.clickCreatePlanBtn();
        plan.enterPlanDetails("testing qa edited");
        plan.clickPlanUpdateBtn();
        Assert.assertTrue(plan.isPlanOnTheTable(), "plan created not found in the table");
    }
    //Create plan with goals
    @Test()
    public void createPlanWithGoalsTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        plan.clickPlanManagementBtn();
        plan.clickCreatePlanBtn();
        plan.enterPlanDetails("testing qa");
        plan.clickGoalTab();
        plan.clickAddGoals();
        plan.createGoals("Drug treatment");
        Assert.assertTrue(plan.isGoalCreated(), "goal not created");
        plan.submitPlan();
    }
    //Edit plan goals
    @Test()
    public void editPlanGoalsTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.clickGoalTab();
        plan.clickAddGoals();
        plan.createGoals("Drug_treatment");
        plan.expandGoals();
        plan.clickEditGoalButton();
        plan.createGoals(" edit");
        Assert.assertTrue(plan.isGoalEdited(),"goal not edited");;
    }
    //Edit plan goals
    @Test()
    public void createGoalsActionsTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.clickGoalTab();
        plan.clickAddGoals();
        plan.createGoals("Drug_treatment");
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
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.clickGoalTab();
        plan.clickAddGoals();
        plan.createGoals("Drug_treatment");
        plan.expandGoals();
        plan.deleteGoalBtn();
        plan.confirmDeleteGoalBtn();
        Assert.assertTrue(plan.isGoalDeleted(),"goal not deleted");;
    }
    @Test()//update plan tile
    public void updatePlanTitleTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
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
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        plan.clickPlanManagementBtn();
        plan.openPlan();
        plan.editPlanTitle("edited testing title");
        plan.clickPlanUpdateBtn();
        plan.clickPlanBackBtn();
        Assert.assertTrue(plan.isGPlanTitleEdited("edited testing title"),"plan title not successfully created");;
    }
}
