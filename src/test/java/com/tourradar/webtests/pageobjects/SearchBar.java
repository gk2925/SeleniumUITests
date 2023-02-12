package com.tourradar.webtests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SearchBar {

    private WebDriver driver;

    @FindBy(css = "div.search>input")
    private WebElement searchTextBox;

    @FindBy(css = "ul.autocomplete-items>li")
    private WebElement autoSuggestion;


    public SearchBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static By autosuggestionByLocator() {
        return By.cssSelector("ul.autocomplete-items>li");
    }

    public void enterSearchKeyword(String text) throws InterruptedException {

        /* here sleep is necessary in order to get the autosuggestions appear in UI */
        searchTextBox.sendKeys(text.substring(0, 1).toUpperCase());
        sleep(1000);
        searchTextBox.sendKeys(text.substring(1, 2).toUpperCase());
        sleep(1000);
        searchTextBox.sendKeys(text.substring(2, 3).toUpperCase());
        sleep(1000);
        searchTextBox.sendKeys(text.substring(3, 4).toUpperCase());
        sleep(1000);
    }

    public void userClickFirstRelevantAutosuggestion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(autosuggestionByLocator()));
        autoSuggestion.click();
    }
}
