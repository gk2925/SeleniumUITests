package com.tourradar.webtests.steps;

import com.tourradar.webtests.pageobjects.HomePage;
import com.tourradar.webtests.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    Base base;
    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps(Base base) {
        this.base = base;
        this.homePage = new HomePage(base.driver);
        this.loginPage = new LoginPage(base.driver);
    }

    @Given("User is at the home page of the application and accept the cookies")
    public void user_is_at_the_home_page_of_the_application() {
        homePage.navigateToHomePage();

    }

    @And("User clicks on the login icon and login button")
    public void user_clicks_on_the_login_icon_and_login_button() {
        homePage.clickLoginIcon();
        homePage.clickOnLogInButton();
    }

    @Then("User is able to login the application successfully")
    public void user_is_able_to_login_the_application_successfully() {
        Assert.assertTrue(homePage.verifyGreetingIconsPresence());
    }

    @And("User enters valid set of {string} and {string}")
    public void userEntersValidSetOfAnd(String arg0, String arg1) {
        loginPage.enterLoginCredentials(arg0, arg1);
    }
}
