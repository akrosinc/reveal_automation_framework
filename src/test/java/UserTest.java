import PageObjects.SignInPage;
import PageObjects.UserPage;
import Utilities.BaseClass;
import Utilities.Constants;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseClass {
   public  String org_name ="QA Testing";
    @Test()//Create organisation without part of.
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
    @Test()//Create child organisation
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
    @Test()//Create child of child organisation
    public void createChild_Of_ChildOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickCreateOrganizationBtn();
        userPage.enterChildOfChildOrganisationDetails(org_name);
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

    @Test()//Upload a bulk users
    public void UploadBulkUsersTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserImportTab();
        userPage.uploadUsers("User.csv");
        Assert.assertTrue(userPage.isFileUploadedNow(), "user file not uploaded in the table");
    }
    @Test()//Bulk upload a file with some users with existing username
    public void UploadBulkUsersWithExistingUsernameTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserImportTab();
        userPage.uploadUsers("User.csv");
        Assert.assertTrue(userPage.isFileUploadedNow(), "user file not uploaded in the table");
    }
    @Test()//Bulk upload a file with some users with username with special characters
    public void UploadBulkUsersWithUsernameWithSpecialCharactersTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserImportTab();
        userPage.uploadUsers("User.csv");
        Assert.assertTrue(userPage.isFileUploadedNow(), "user file not uploaded in the table");
    }
    @Test()//Bulk upload a file with some users with NONE existing organisation UUID
    public void UploadBulkUsersWithoutOrganisationTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserImportTab();
        userPage.uploadUsers("UsersWithoutOrg.csv");
        Assert.assertTrue(userPage.isFileUploadedNow(), "user file not uploaded in the table");
    }
    @Test()//check Uploaded a bulk users status
    public void CheckUploadedFileStatusTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserImportTab();
        Assert.assertTrue(userPage.isUploadedStatusCompleted(), "user file status not completed in the table");
    }
    @Test()//Download user template
    public void DownloadTemplateTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserImportTab();
        userPage.clickBulkImportBtn();
        userPage.downloadUsersTemplate();
        Assert.assertTrue(userPage.isFileDownloaded("userTemplate","csv",30), "Downloaded file not found");
    }
    @Test()//Download security groups user template
    public void DownloadSecurityGroupTemplateTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        userPage.clickUserManagementBtn();
        userPage.clickUserImportTab();
        userPage.clickBulkImportBtn();
        userPage.downloadSecurityGroupTemplate();
        Assert.assertTrue(userPage.isFileDownloaded("security_groups","csv",30), "Downloaded file not found");
    }
    @Test()//Delete user
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

}
