package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseClass {

    @FindBy(id = "login-button")
    WebElement homeLogInBtn;

    @FindBy(id = "username")
    WebElement signIn_username;

    @FindBy(id = "password")
    WebElement LogIn_password;

    @FindBy(id = "kc-login")
    WebElement signInBtn;

    @FindBy(id = "logout-nav-dropdown")
    WebElement signOutBtn;

    public SignInPage(){
        PageFactory.initElements(driver,this);
    }

}
