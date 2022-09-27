package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class VerifyThatUserIsAbleToApplyLeave extends BaseClass {
    @Given("Navigate to Url")
    public void clicks_on_login_button() throws IOException {
        Setup();
    }
}
