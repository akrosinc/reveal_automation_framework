import PageObjects.SignInPage;
import Utilities.BaseClass;
import Utilities.Constants;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static ExtentReport.ExtentManager.*;

public class LogInPageTest extends BaseClass {

    @Test(testName = "Login test")
    public void loginTest() throws Throwable {
        SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
        login.clickLogInBtn();
        login.signIn(Constants.username, Constants.password);
        Assert.assertTrue(login.isUserSignedIn(), "user not successfully signed in");
    }
}
