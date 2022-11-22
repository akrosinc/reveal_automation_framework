import PageObjects.LocationManagementPage;
import PageObjects.SignInPage;
import Utilities.BaseClass;
import Utilities.Constants;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocationManagementTest extends BaseClass {

    @Test()
    public void accessLocationManagementAreaTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        Assert.assertTrue(page.isLocationManagementAccessible(), "location management area not accessible");
    }
    @Test()
    public void CreateGeographicLevelTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        page.clickMainCreateBtn();
        page.enterGeographicLevelDetails("testing","Country");
        page.clickFormCreateBtn();
        Assert.assertTrue(page.isGeoLocationCreated(), "Geographic Location not created successfully");
    }
    @Test()//Create Geo location with name with special characters
    public void CreateGeographicLevelNameWith_SpecialCharactersTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        page.clickMainCreateBtn();
        page.enterGeographicLevelDetails("test@%j","Country");
        page.clickFormCreateBtn();
        Assert.assertTrue(page.isSpecialCharacterWarningMessageDisplayed(), "warning for entering special characters not displayed");
    }
    @Test()//Create Geo location with name with uppercase characters
    public void CreateGeographicLevelNameWith_UppercaseCharactersTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        page.clickMainCreateBtn();
        page.enterGeographicLevelDetails("Testing","Country");
        page.clickFormCreateBtn();
        Assert.assertTrue(page.isSpecialCharacterWarningMessageDisplayed(), "warning for entering special characters not displayed");
    }
    @Test()//create geo location with empty name and title.
    public void CreateGeographicLevelWithEmpty_nameAndTitleTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        page.clickMainCreateBtn();
        page.enterGeographicLevelDetails("","");
        page.clickFormCreateBtn();
        Assert.assertTrue(page.isEmptyWarningMessageDisplayed(), "warning for empty form fields not displayed");
    }

    @Test()   //Edit geographic level details
    public void editGeographicLevelDetailsTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        page.expandGeoLevel();
        page.clickEditGeoLevel();
        page.enterGeographicLevelDetails("edited","province");
        page.clickSaveGeoLevel();
        Assert.assertTrue(page.isGeoLocationUpdated(), "Geographic location level details not successfully updated");
    }
    @Test()   //Delete geographic level details
    public void deleteGeographicLevelDetailsTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        page.expandGeoLevel();
        page.clickDeleteBtn();
        page.confirmDelete();
        Assert.assertTrue(page.isGeoLocationDeleted(), "Geographic location level details not successfully Deleted");
    }
    @Test()   //create geographic hierarchy if not existing and delete after creation.
    public void createLocationHierarchyTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username,Constants.password);
        page.clickLocationManagementBtn();
        page.clickLocationHierarchyTab();
        page.createGeographicHierarchy();
        Assert.assertTrue(page.isLocationHierarchyNameDisplayed(), "Geographic location hierarchy not successfully created");
        page.clickDeleteBtn();
        page.confirmDelete();
    }
}
