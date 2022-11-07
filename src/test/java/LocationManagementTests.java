import PageObjects.LocationManagementPage;
import PageObjects.SignInPage;
import PageObjects.UserPage;
import Utilities.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocationManagementTests extends BaseClass {

    @Test()
    public void accessLocationManagementAreaTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        page.clickLocationManagementBtn();
        Assert.assertTrue(page.isLocationManagementAccessible(), "location management area not accessible");
    }
    @Test()
    public void CreateGeographicLevelNameWith_SpecialCharactersTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        page.clickLocationManagementBtn();
        page.clickMainCreateBtn();
        page.fileInGeographicLevelDetails("test@%j","Country");
        page.clickFormCreateBtn();
        Assert.assertTrue(page.isSpecialCharacterWarningMessageDisplayed(), "warning for entering special characters not displayed");
    }
    @Test()
    public void CreateGeographicLevelWithEmpty_nameAndTitleTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        LocationManagementPage page = PageFactory.initElements(getDriver(), LocationManagementPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        page.clickLocationManagementBtn();
        page.clickMainCreateBtn();
        page.fileInGeographicLevelDetails("","");
        page.clickFormCreateBtn();
        Assert.assertTrue(page.isEmptyWarningMessageDisplayed(), "warning for empty form fields not displayed");
    }
}
