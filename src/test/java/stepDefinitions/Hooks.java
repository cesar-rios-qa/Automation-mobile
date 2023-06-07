package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import utils.AutomationException;

public class Hooks extends PageObject {

    @Before
    public void updateNameSessionInBrowserStack(Scenario scenario) {
        String scenarioUri=scenario.getUri().toString();
        String featureName= StringUtils.substringBetween(scenarioUri,"features/", ".feature").trim();
        String scenarioName = scenario.getName();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"" + featureName + " - " + scenarioName + "\" }}");
    }
}
