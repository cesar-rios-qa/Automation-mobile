package stepDefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;
import steps.SignInSteps;
import utils.TestDataReader;

public class SignInDefinitions {

    @Steps
    SignInSteps signInSteps;

    @Steps
    HomeSteps homeSteps;

    @Given("that the user enters the login")
    public void goToLoginScreen(){
        signInSteps.goToLoginPage();
    }

    @When("the user enters the email {string} and password {string}")
    public void signInUser(String email, String password){
        signInSteps.signInUser(TestDataReader.getProperty(email), TestDataReader.getProperty(password));
    }

    @When("the user enters the emailFalse {string} and password {string}")
    public void signInUserWithIncorrectEmailFormat(String emailFalse, String password){
        signInSteps.incorrectMailFormat(TestDataReader.getProperty(emailFalse), TestDataReader.getProperty(password));
    }

    @Then("the home screen of the application is displayed")
    public void isDisplayHomeScreen(){
        homeSteps.isDisplayHomeScreen();
    }

    @Then("the system shows incorrect format validation")
    public void isDisplayMessageOfIncorrectFormat(){
        signInSteps.verifyMessageIncorrectFormat();
    }

}
