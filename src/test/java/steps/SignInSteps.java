package steps;

import net.thucydides.core.annotations.Step;
import pages.SignInPage;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static utils.CapturedMesaages.*;


public class SignInSteps {

    SignInPage signInPage;

    @Step
    public void goToLoginPage(){
        signInPage.tapLoginBtn();
        assertThat(signInPage.isDisplayedLoginScreen(), is(true));
    }

    @Step
    public void signInUser(String email, String password){
        signInPage.typeInputEmail(email);
        signInPage.typeInputPassword(password);
        signInPage.tapSignInBtn();
    }

    @Step
    public void incorrectMailFormat(String emailFalse, String password){
        signInPage.typeInputEmail(emailFalse);
        signInPage.typeInputPassword(password);
        signInPage.tapSignInBtn();
    }

    @Step
    public void verifyMessageIncorrectFormat(){
        assertThat(signInPage.getMessageIncorrectFormat(), is(INCORRECT_FORMAT_EMAIL.getMessage()));
    }
}
