package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Login, tab, 2 of 2\"]/android.widget.ImageView")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    private WebElement inputEmail;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText")
    private WebElement inputPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[5]")
    private WebElement signInBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[2]")
    private WebElement txtTittleLogin;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement txtMessageInvalidFormat;


    public void tapLoginBtn() {
        isDisplayed(loginBtn);
        tap(loginBtn);
    }

    public void typeInputEmail(String email) {
        tap(inputEmail);
        type(inputEmail, email);
    }

    public void typeInputPassword(String password) {
        tap(inputPassword);
        type(inputPassword, password);
    }

    public void tapSignInBtn() {
        isDisplayed(signInBtn);
        tap(signInBtn);
    }

    public boolean isDisplayedLoginScreen() {
        return isDisplayed(txtTittleLogin);
    }

    public String getMessageIncorrectFormat(){
        return getText(txtMessageInvalidFormat);
    }

}
