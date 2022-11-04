import PageObjects.PlanPage;
import PageObjects.SignInPage;
import PageObjects.UserPage;
import Utilities.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTests extends BaseClass {

    @Test()
    public void createOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterOrganisationDetails("Testing Team");
        Assert.assertTrue(userPage.checkOrganisationCreated(), "organisation created not found in the table");
    }
    @Test() //Enter organisation without a type field.
    public void createOrganisationWithoutTypeTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterOrganisationDetailsWithOutTpe("Testing qa team");
        Assert.assertTrue(userPage.checkOrganisationTypeError(), "organisation created not found in the table");
    }
    @Test() //Enter organisation without a type field.
    public void createOrganisationWithoutPasswordTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterOrganisationDetailsWithOutTpe("Testing qa team");
        Assert.assertTrue(userPage.checkOrganisationTypeError(), "organisation created not found in the table");
    }
    @Test()//edit organisation details
    public void editOrganisationDetailsTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        userPage.clickUserManagementBtn();
        userPage.openOrganisationDetails("Testing team");
        userPage.clickOrgEditBtn();
        userPage.enterOrganisationDetails("qa testing team");
        Assert.assertTrue(userPage.isOrgDetailsChanged("qa testing team"), "organisation not edited in the table");
    }

    @Test()//Delete organisation
    public void deleteOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        userPage.clickUserManagementBtn();
        userPage.openOrganisationDetails("Testing team");
        userPage.clickOrgEditBtn();
        userPage.enterOrganisationDetails("qa testing team");
        Assert.assertTrue(userPage.isOrgDetailsChanged("qa testing team"), "organisation not edited in the table");
    }
    @Test()//Delete organisation
    public void createUserTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        userPage.clickUserManagementBtn();
        userPage.clickUserTab();
        userPage.clickCreateUserBtn();
        userPage.createUser();
        Assert.assertTrue(userPage.checkUserCreatedDisplayed(), "user created not displayed");
    }
    @Test()//Delete organisation
    public void createUserWithoutPasswordTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        userPage.clickUserManagementBtn();
        userPage.clickUserTab();
        userPage.clickCreateUserBtn();
        userPage.createUserWithOutPassword();
        Assert.assertTrue(userPage.checkUserPasswordError(), "missing password error not displayed");
    }
}
