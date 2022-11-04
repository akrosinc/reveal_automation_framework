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
}
