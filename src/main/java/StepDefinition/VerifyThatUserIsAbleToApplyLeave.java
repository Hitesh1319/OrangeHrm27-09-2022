package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class VerifyThatUserIsAbleToApplyLeave extends BaseClass {
    @Given("Navigate to Url")
    public void clicks_on_login_button() throws IOException {
        Setup();
    }

    @When("User is login")
    public void user_is_login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Then("Click on Leave in left menu")
    public void click_on_leave_in_left_menu() {
        pageFactory.getLeftMenu().leave();
    }

    @And("Click on the apply in top menu")
    public void click_on_the_apply_in_top_menu() {
        pageFactory.getLeavePage().apply();
    }

    @Then("Applying Leave")
    public void applying_leave() throws IOException {
        pageFactory.getLeavePage().applyingLeave();
    }

    @And("Verify Leave")
    public void verify_leave() {
        pageFactory.getLeavePage().myLeaveVerification();
    }
}
