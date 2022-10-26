import PageObjects.SignInPage;
import Utilities.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ExtentReport.ExtentManager.*;

public class LogInPageTest extends BaseClass {

    @Test()
    public void loginTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertFalse(login.isUserSignedIn(), "user not successfully signed in");
    }
}
