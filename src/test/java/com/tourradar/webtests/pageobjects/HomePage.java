package com.tourradar.webtests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "div.js-ao-header-navigation__profile-placeholder")
    private WebElement loginIcon;

    @FindBy(css = "a.ao-header-navigation__profile-link")
    private WebElement accountIcon;

    @FindBy(css = "button.cn-button__desktop.js-cn-button--accept")
    private WebElement acceptAllCookiesButton;


    @FindBy(css = "a[data-login-traveller-url='/login']")
    private WebElement loginButton;

    @FindBy(css = "h1.ao-profile-top__profile-details-greeting")
    private WebElement helloMessage;

    @FindBy(css = "button[data-cy='serp-tour--download-brochure']")
    private WebElement downloadBrochureButtonForFirstSearchResult;

    @FindBy(css = "a.aa-btn.aa-btn--xs")
    private WebElement viewTourButtonForFirstSearchResult;

    @FindAll({@FindBy(css = "a.aa-btn.aa-btn--xs")})
    private List<WebElement> individualSearchResultsListings;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginIcon() {
        loginIcon.click();
    }

    public void clickOnLogInButton() {
        loginButton.click();
    }

    public HomePage navigateToHomePage() {
        driver.get("https://www.tourradar.com/d/europe");
        return new HomePage(driver);
    }

    public boolean verifyGreetingIconsPresence() {
        accountIcon.click();
        return helloMessage.isDisplayed();
    }

    public String verifyNumberOfDefaultSearchListings() {
        return Integer.toString(individualSearchResultsListings.size());
    }

    public boolean verifyDownloadBrochureButtonPresence() {
        return downloadBrochureButtonForFirstSearchResult.isDisplayed();

    }

    public String getTextForDownloadBrochureButton() {
        return downloadBrochureButtonForFirstSearchResult.getText();

    }

    public boolean verifyViewTourButtonsPresence() {
        return viewTourButtonForFirstSearchResult.isDisplayed();
    }

    public String getTextForViewTourButton() {
        return viewTourButtonForFirstSearchResult.getText();

    }
}
