package com.tourradar.webtests.steps;

import com.tourradar.webtests.pageobjects.HomePage;
import com.tourradar.webtests.pageobjects.SearchBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;


public class SearchSteps {
    private Base base;
    private HomePage homePage;
    private SearchBar searchBar;

    public SearchSteps(Base base) {
        this.base = base;
        this.homePage = new HomePage(base.driver);
        this.searchBar = new SearchBar(base.driver);
    }

    @And("User clicks {string} as city name in the search bar")
    public void userClicksAsCityNameInTheSearchBar(String cityName) throws InterruptedException {
        searchBar.enterSearchKeyword(cityName);
    }

    @Given("User clicks on the valid autosuggestion")
    public void user_clicks_on_the_valid_autosuggestion() {
        searchBar.userClickFirstRelevantAutosuggestion();

    }

    @Then("For the first search result user have an option to download brochure")
    public void for_the_first_search_result_user_have_an_option_to_download_brochure() {
        Assert.assertTrue(homePage.verifyDownloadBrochureButtonPresence());
    }

    @Then("User able to see the list of results which are by default {string} in number")
    public void userAbleToSeeTheListOfResultsWhichAreByDefaultInNumber(String num) {
        Assert.assertEquals((homePage.verifyNumberOfDefaultSearchListings()), num);
    }

    @And("In the first search result {string} button is displayed")
    public void inTheFirstSearchResultButtonIsDisplayed(String text) {
        Assert.assertTrue(homePage.verifyDownloadBrochureButtonPresence());
        Assert.assertEquals(homePage.getTextForDownloadBrochureButton(), text);

    }

    @And("In the first search result {string} button is present")
    public void inTheFirstSearchResultButtonIsPresent(String text) {
        Assert.assertTrue(homePage.verifyViewTourButtonsPresence());
        Assert.assertEquals(homePage.getTextForViewTourButton(), text);
    }


}
