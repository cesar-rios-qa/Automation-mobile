package pages;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import utils.AutomationException;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.jna.Platform.isAndroid;
import static java.time.Duration.ofSeconds;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.util.Arrays.asList;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class BasePage extends PageObject {

    public final AppiumDriver APPIUM_DRIVER = getProxiedDriver();
    public static Logger logger;



    public boolean isDisplayed(WebElement element) {
        waitFor(element);
        return element.isDisplayed();
    }

    public void type(WebElement element, String text) {
        if (isDisplayed(element)) {
            element.sendKeys(text);
        }
    }

    public void tap(WebElement element) {
        if (isDisplayed(element)) {
            element.click();
        } else {
            throw new AutomationException("Element isn't displayed");
        }
    }

    public String getText(WebElement element) {
        if (isAndroid()) {
            isDisplayed(element);
        }
        return element.getText();
    }

    public boolean isElementPresent(WebElementFacade element) {
        boolean isPresent = false;
        try {
            setImplicitTimeout(500, MILLIS);
            if (element.isPresent()) {
                isPresent = true;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        } finally {
            resetImplicitTimeout();
        }
        return isPresent;
    }

    public void swipeToCoordinates(int startX, int startY, int endX, int endY) {

        PointerInput finger = new PointerInput(TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(ofSeconds(0), viewport(), startX, startY))
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(finger.createPointerMove(ofSeconds(1), viewport(), endX, endY))
                .addAction(finger.createPointerUp(LEFT.asArg()));

        APPIUM_DRIVER.perform(asList(swipe));
    }

    public void swipeToElement(WebElementFacade element) {

        int i = 0;
        while (!isElementPresent(element) && i < 5) {
            Dimension dimension = APPIUM_DRIVER.manage().window().getSize();
            swipeToCoordinates((int) (dimension.width * 0.5), (int) (dimension.height * 0.9),
                    (int) (dimension.width * 0.02), (int) (dimension.height * 0.1));
            i++;
        }
    }


}
