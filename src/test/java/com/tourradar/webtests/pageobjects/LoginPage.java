package com.tourradar.webtests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "g_email")
    private WebElement emailTextBox;

    @FindBy(id = "g_password")
    private WebElement passwordTextBox;

    @FindBy(id = "g_send")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage enterLoginCredentials(String uName, String pass) {
        emailTextBox.clear();
        emailTextBox.sendKeys(uName);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(pass);
        logInButton.click();
        return new HomePage(driver);
    }
}
