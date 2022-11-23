import PageObjects.SignInPage;
import Utilities.BaseClass;
import Utilities.Constants;
import Utilities.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static ExtentReport.ExtentManager.*;

public class LogInPageTest extends BaseClass {

    @Test()
    public void loginTest() throws Throwable {
           Log.startTestCase("Login test");
           SignInPage login = PageFactory.initElements(getDriver(), SignInPage.class);
           login.clickLogInBtn();
           login.signIn(Constants.username, Constants.password);
           Assert.assertTrue(login.isUserSignedIn(), "user not successfully signed in");
           Log.endTestCase("Login test");
    }
}
