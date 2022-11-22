import PageObjects.SignInPage;
import PageObjects.UserPage;
import Utilities.BaseClass;
import Utilities.Constants;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseClass {
   public  String org_name ="QA Testing";
    @Test()
    public void createOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterOrganisationDetails(org_name);
        Assert.assertTrue(userPage.checkOrganisationCreated(), "organisation created not found in the table");
    }
    @Test()
    public void createChildOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterChildOrganisationDetails(org_name);
        Assert.assertTrue(userPage.checkOrganisationCreated(), "organisation created not found in the table");
    }
    @Test() //Enter organisation without a type field.
    public void createOrganisationWithoutTypeTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterOrganisationDetailsWithOutTpe(org_name);
        Assert.assertTrue(userPage.checkOrganisationTypeError(), "organisation created not found in the table");
    }
    @Test() //Enter organisation without a type field.
    public void createOrganisationWithoutPasswordTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterOrganisationDetailsWithOutTpe(org_name);
        Assert.assertTrue(userPage.checkOrganisationTypeError(), "organisation created not found in the table");
    }
    @Test()//edit organisation details
    public void editOrganisationDetailsTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.openOrganisationDetails(org_name);
        userPage.clickOrgEditBtn();
        userPage.enterOrganisationDetails("qa testing team");
        Assert.assertTrue(userPage.isOrgDetailsChanged("qa testing team"), "organisation not edited in the table");
    }
    @Test()//edit user details
    public void editUserDetailsTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserTab();
        userPage.expandUserDetails("qa.automation.user");
        userPage.clickOrgEditBtn();
        userPage.editUser("Yonela","tester");
        Assert.assertTrue(userPage.checkUserUpdatedDisplayed(), "user not edited in the table");
    }

    @Test()//Delete organisation
    public void deleteOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.openOrganisationDetails(org_name);
        userPage.clickDeleteBtn();
        userPage.clickConfirmDeleteBtn();
        Assert.assertTrue(userPage.isOrganisationSuccessfullyDeleted(), "organisation not deleted in the table");
    }
    @Test()//Delete organisation
    public void deleteUserTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserTab();
        userPage.expandUserDetails("qa.automation.user");
        userPage.clickDeleteBtn();
        userPage.clickConfirmDeleteBtn();
        Assert.assertTrue(userPage.isOrganisationSuccessfullyDeleted(), "user not deleted in the table");
    }
    @Test()//Delete organisation
    public void createUserTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserTab();
        userPage.clickCreateUserBtn();
        userPage.createUser("automation","user");
        Assert.assertTrue(userPage.checkUserCreatedDisplayed(), "user created not displayed");
    }
    @Test()//Delete organisation
    public void createUserWithoutNamesTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserTab();
        userPage.clickCreateUserBtn();
        userPage.createUser("","");
        Assert.assertTrue(userPage.isUserEmptyNamesErrorDisplayed(), "user with empty names warning message not displayed");
    }
    @Test()//Delete organisation
    public void createUserWithoutPasswordTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserTab();
        userPage.clickCreateUserBtn();
        userPage.createUserWithOutPassword();
        Assert.assertTrue(userPage.checkUserPasswordError(), "missing password error not displayed");
    }

    @Test()//Toggle organisation to inactive state
    public void InactiveOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.openOrganisationDetails("QA Testing");
        userPage.clickOrgEditBtn();
        userPage.toggleInactive();
        userPage.clickSaveOrganisation();
        userPage.openOrganisationDetails("QA Testing");
        Assert.assertTrue(userPage.isOrganisationActive(), "organisation is active");
    }
}
