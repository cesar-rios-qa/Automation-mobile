package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement txtHomeLogin;


    public boolean isDisplayHome() {
       return isDisplayed(txtHomeLogin);
    }

}
