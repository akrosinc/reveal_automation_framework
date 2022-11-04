package PageObjects;


import ActionDriver.Action;
import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseClass {
    Action action= new Action();
    WebDriver driver;
    @FindBy(how = How.ID, using ="login-button")
    WebElement homeLogInBtn;

    @FindBy(id = "username")
    WebElement signIn_username;

    @FindBy(id = "password")
    WebElement signIn_password;

    @FindBy(id = "kc-login")
    WebElement signInBtn;

    @FindBy(id="logout-nav-dropdown")
    WebElement signOutBtn;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        //PageFactory.initElements(getDriver(),this);
    }
    public void clickLogInBtn() throws Throwable{
        action.explicitWait(getDriver(),homeLogInBtn,40);
        action.click(getDriver(),homeLogInBtn);
    }
    public void signIn(String username,String password)
    {
        action.type(signIn_username,username);
        action.type(signIn_password,password);
        action.click(getDriver(),signInBtn);
        action.explicitWait(getDriver(),signOutBtn,10);
    }
     public boolean isUserSignedIn()
     {
         action.explicitWait(getDriver(),signOutBtn,10);
            return action.isDisplayed(getDriver(),signOutBtn);
     }
}
