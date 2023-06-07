package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomeSteps {

    HomePage homePage;

    @Step
    public void isDisplayHomeScreen(){
        assertThat(homePage.isDisplayHome(), is(true));
    }
}
